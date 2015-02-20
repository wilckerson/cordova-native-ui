
var exec = require("cordova/exec");

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
        initView: function () {

            exec(function (elementId) {
                console.log("NativeUIPluginSucess");



            }, function (err) {
                console.log("NativeUIPluginError: " + err);
            }, "NativeUI", "initView", []);

        },
        
        loadPage: function(path){
             exec(function (elementId) {
                console.log("NativeUIPluginSucess");



            }, function (err) {
                console.log("NativeUIPluginError: " + err);
            }, "NativeUI", "loadPage", [path]);
        },
        
        hide: function(){
             exec(function (elementId) {
                console.log("NativeUIPluginSucess");



            }, function (err) {
                console.log("NativeUIPluginError: " + err);
            }, "NativeUI", "hide", []);
        }

    };

    //document.addEventListener("NativeEvent" ,NativeUI.nativeEvent, false );

    module.exports = NativeUI;


