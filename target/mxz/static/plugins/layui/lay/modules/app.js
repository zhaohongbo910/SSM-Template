 /**
 * Name:app.js
 * Author:zhang
 * E-mail:1411004666@qq.com
 */
var tab;
layui.define(['element', 'form', 'table', 'tab', 'navbar', 'onelevel'], function(exports) {
    var $ = layui.jquery,
        element = layui.element,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        navbar = layui.navbar,
        _win = $(window),
        _doc = $(document),
        _body = $('.kit-body');
    tab = layui.tab;
    var app = {
        hello: function(str) {
            layer.alert('Hello ' + (str || 'test'));
        },
        config: {
            type: 'iframe'
        },
        set: function(options) {
            var that = this;
            $.extend(true, that.config, options);
            return that;
        },
        init: function() {
            var that = this,
                _config = that.config;
            if (_config.type === 'iframe') {
                tab.set({
                    elem: '#container',
                    onSwitch: function(data) { //选项卡切换时触发
                        //console.log(data.layId); //lay-id值
                        //console.log(data.index); //得到当前Tab的所在下标
                        //console.log(data.elem); //得到当前的Tab大容器
                    },
                    closeBefore: function(data) { //关闭选项卡之前触发
                        // console.log(data);
                        // console.log(data.icon); //显示的图标
                        // console.log(data.id); //lay-id
                        // console.log(data.title); //显示的标题
                        // console.log(data.url); //跳转的地址
                        return true; //返回true则关闭
                    }
                }).render();
                //navbar加载方式一，直接绑定已有的dom元素事件                
                navbar.bind(function(data) {
                    tab.tabAdd(data);
                });
                //navbar加载方式二，设置远程地址加载
                navbar.set({
                    remote: {
                        url: '../plugins/datas/navbar1.json'
                    }
                }).render(function(data) {
                    tab.tabAdd(data);
                });

                //处理顶部一级菜单
                var onelevel = layui.onelevel;
                if (onelevel.hasElem()) {
                    onelevel.set({
                        remote: {
                            url: '../plugins/datas/onelevel1.json' //远程地址
                        },
                        onClicked: function(id) {
                            switch (id) {
                                case 1:
                                    navbar.set({
                                        remote: {
                                            url: '../plugins/datas/navbar1.json'
                                        }
                                    }).render(function(data) {
                                        tab.tabAdd(data);
                                    });
                                    break;
                                case 2:
                                    navbar.set({
                                        remote: {
                                            url: '../plugins/datas/navbar2.json'
                                        }
                                    }).render(function(data) {
                                        tab.tabAdd(data);
                                    });
                                    break;
                                default:
                                    navbar.set({
                                    	 remote: {
                                             url: '../plugins/datas/defaultNavbar.json'
                                         }
                                    }).render(function(data) {
                                        tab.tabAdd(data);
                                    });
                                    break;
                            }
                        }
                    }).render();
                }
            }
            return that;
        }
    };
    //输出test接口
    exports('app', app);
});