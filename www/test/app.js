/**
 * Created by wilckersonganda on 04/11/14.
 */
var View = {
    shared: {}
};

var Controller = {};

var App = {
    onReady: function(){
        NativeUIManager.initWithController(Controller.login);
    }
};

NativeUIManager.addEventListener("onReady",App.onReady,false);

