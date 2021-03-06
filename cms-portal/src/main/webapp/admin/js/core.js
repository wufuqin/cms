let core={
    //限流工具类
    throttle:function(method,args,context){
        clearTimeout(method.tId);
        method.tId=setTimeout(function(){
            method.call(context,args);
        },200);
    },
    //http请求方法
    http:function(option,callback){
        this.cancel && this.cancel.abort();
        //load: 加载loading autoComplete：自动完成  goBack自动回退
        let opt={load:true,autoComplete:true,goBack:true},loadHandler,loadTime,
            options ={
                url:"",
                method:"post",
                contentType:"application/x-www-form-urlencoded",
                dataType:"json",
                beforeSend:function(){
                    this.load &&  ((loadTime = new Date().getTime()) && (loadHandler = LayUtil.layer.init(function(inner,layer){
                        inner.loading(0,{shade:0.1})
                    })))
                },
                success:function(res){
                    //处理loading 加载
                    if(this.load && loadHandler){
                        let time = 0;
                        if(new Date().getTime()-loadTime<500){
                            time = 500;
                        }
                        setTimeout(function(){
                            loadHandler.closeLoading();
                        },time)
                    }
                    let that = this,handler;
                    //延时
                    setTimeout(function(){
                        //判断请求接口
                        switch(res.restCode){
                            case CONSTANT.HTTP.ERROR:
                                core.prompt.alert(res.restInfo);
                                break;
                            case CONSTANT.HTTP.SUCCESS:
                                if(that.autoComplete){
                                    handler=function(){
                                        //后退刷新
                                        window.location.href = document.referrer;
                                    };
                                    core.prompt.msg(res.restInfo,{shade:0.3,time:1200},handler);
                                }
                                break;
                        }
                        //处理自定义回调
                        (callback instanceof Function) && callback(res)
                    },600)
                }
            };
        Object.assign(opt,options,option);
        this.cancel=$.ajax(opt);
    },
    //提示相关
    prompt:{
        //警告弹窗
        alert:function(content,opt){
            core.prompt.msg(content,$.extend({},
                {
                    icon: 5,
                    shift:6,
                    shade:0.3,
                    time:1500,
                    area:'auto',
                    shadeClose:true
                },opt));
        },
        //信息框提示
        msg:function(content,option,callback){
            LayUtil.layer.init(function(inner){
                inner.msg(content,option,callback);
            })
        }

    }
};

const  CONSTANT = {
    //http相关
    HTTP:{
        SUCCESS:200,
        ERROR:500
    }



};

// layui工具类
function LayUtil(){}

//树形表格属性
LayUtil.treeTableOption={
    treeColIndex: 1,
    treeSpid: 0,
    treeIdName: 'authorityId',
    treePidName: 'parentId',
    elem: '#treeTable',
    page: false
}

//下拉树选项
LayUtil.selectTreeOption = {
    elem: "#selectTree",
    url: "",
    dataType: "json",
    async: false,
    method: 'post',
    ficon: ["1", "-1"],
    dataStyle: "layuiStyle",
    initLevel: 1,
    width: "100%",
    dot: false,
    checkbar: false,
    formatter: {
        title: function (data) {
            let s = data.name;
            if (data.children) {
                s += ' <span style=\'color:blue\'>(' + data.children.length + ')</span>';
            }
            return s;
        }
    },
    response: {
        statusCode: 200,
        statusName: "restCode",
        treeId: "id",
        message: "restCode",
        rootName: "data",
        title: 'name'
    },
};

LayUtil.prototype = {
    construct:LayUtil,
    //弹窗
    layer:(function(LayUtil){
        function Inner(){

        }

        Inner.prototype={
            construct:Inner,
            init:function(callback){
                let that = this;
                layui.use('layer',function(){
                    that.layer = layui.layer;
                    if(callback instanceof Function){
                        callback(that,that.layer);
                    }
                })
                return this;
            },
            //显示loading加载
            loading:function(config={}){
                this.layer.load(config);
            },
            //关闭loading
            closeLoading:function(){
                this.layer.closeAll('loading');
            },
            //信息框
            msg:function(content,option,callback){
                return layer.msg(content,option,callback);
            }
        }
        LayUtil.layer = new Inner();
    })(LayUtil),
    //form表单
    form:(function(LayUtil){
        function Inner(){
        }
        Inner.prototype={
            construct:Inner,
            init:function(callback){
                let that =this;
                layui.use('form',function(){
                    that.form = layui.form;
                    that.form.render();
                    if(callback instanceof Function){
                        callback(that,that.form)
                    }
                });
                return this;
            },
            //提交表单
            submit:function(callback,name,type="submit"){
                this.form.on(type+"("+(name===undefined?'go':name)+")",function(obj){
                    if(callback instanceof Function){
                        callback(obj);
                        return false;
                    }
                    return true;
                })
            },
            //验证
            verify:function(validator){
                this.form.verify(validator);
            }
        }
        LayUtil.form = new Inner();
    })(LayUtil),
    //树形表格
    treeTable:(function(LayUtil){
        function Inner(){}
        Inner.prototype={
            construct:Inner,
            init:function(config,callback){
                let that = this, option = $.extend({},LayUtil.treeTableOption,config);
                layui.extend({
                    treetable:'{/}'+ BASE_PATH +'/admin/layui/lay/modules/treetable'
                }).use(['treetable','table'],function(){
                    that.treetable = layui.treetable;
                    that.treetable.render(option);
                    that.table = layui.table;
                    (callback instanceof Function) && callback(that,that.treetable,that.table);
                });
                return this;
            },
            //右侧工具栏
            rightTool:function(filter,callback){
                this.table.on('tool('+filter+')',function(obj){
                    (callback instanceof Function) && callback(obj)
                });
            }
        };
        LayUtil.treeTable = new Inner();
    })(LayUtil),
    //下拉树形
    selectTree:(function(LayUtil){
        function Inner(){}
        Inner.prototype={
            construct: Inner,
            init:function(config,callback){
                let that = this,option=$.extend({},LayUtil.selectTreeOption,config);
                // {/}的意思即代表采用自有路径，即不跟随 base 路径 你还得把第三方js改成layui.denfine()那种格式
                layui.extend({
                    dtree:'{/}' + BASE_PATH + "/admin/layui/lay/modules/selectTree"
                }).use('dtree',function(){
                    that.dtree = layui.dtree;
                    that.dtree.renderSelect(option);
                    (callback instanceof Function) && callback(that,that.dtree);
                });
                return this;
            }
        };
        LayUtil.selectTree = new Inner();
    })(LayUtil)
}
