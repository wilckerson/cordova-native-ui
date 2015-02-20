cordova.define("com.wilckerson.native_ui.NativeUI", function(require, exports, module) { var exec = require("cordova/exec");

var NativeUI = {
    init: function () {

    },
    //    elements: {},
    //    nativeEvent: function(elementId,eventName){
    //     
    //        var elm = this.elements[elementId];
    //        if(elm)
    //        {
    //            var callback = elm[eventName];
    //            if(callback) { callback(); }
    //        }
    //        
    //    }

    //    nativeAlert: function(msg){
    //         
    //        exec(function(){ 
    //            console.log("OK");
    //        }, function (err) {
    //                  console.log("Erro");
    //            console.log(err);
    //        }, "NativeUI", "nativeAlert", [msg]);
    //                
    //    },

    //               addButton: function(title,onClickCallback){
    //                   
    //                  
    //                   
    //               exec(function(elementId){
    //                    console.log("OK");
    //                   
    //                    //var id = UUID();
    //                   this.elements[elementId] = {
    //                        type: "button",
    //                        title: title,
    //                       onClick:onClickCallback
    //                   };
    //                   
    //                    }, function (err) {
    //                    console.log("Erro");
    //                    console.log(err);
    //                    }, "NativeUI", "addButton", [title]);
    //               
    //               
    //               },


    loadPage: function (path) {
        exec(function (result) {
            console.log("NativeUIPluginSucess");



        }, function (err) {
            console.log("NativeUIPluginError: " + err);
        }, "NativeUI", "loadPage", [path]);
    },

    hide: function () {
        exec(function (result) {
            console.log("NativeUIPluginSucess");



        }, function (err) {
            console.log("NativeUIPluginError: " + err);
        }, "NativeUI", "hide", []);
    },

    setValueAsync: function (controlID, propertyName, propertyValue, onSucess, onError) {
        exec(function (result) {
            console.log("NativeUIPluginSucess: " + result);

            if (onSucess) {
                onSucess(result);
            }

        }, function (err) {
            console.log("NativeUIPluginError: " + err);
            if (onError) {
                onError(err);
            }
        }, "NativeUI", "setValueAsync", [controlID, propertyName, propertyValue]);
    },

    getValueAsync: function (controlID, propertyName, onSucess, onError) {
        exec(function (result) {
            console.log("NativeUIPluginSucess: " + result);

            if (onSucess) {
                onSucess(result);
            }

        }, function (err) {
            console.log("NativeUIPluginError: " + err);
            if (onError) {
                onError(err);
            }
        }, "NativeUI", "getValueAsync", [controlID, propertyName]);
    },

    addListener: function (controlID, eventName, handlerCallback) {},

    removeListener: function (controlID, eventName, handlerCallback) {},

};

//document.addEventListener("NativeEvent" ,NativeUI.nativeEvent, false );

module.exports = NativeUI;
});
