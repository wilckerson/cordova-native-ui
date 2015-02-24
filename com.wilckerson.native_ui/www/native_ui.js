var exec = require("cordova/exec");
var chanel = require('cordova/channel');



                                
var NativeUI = {
    
    controlEvents: {},
    
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

    setValueAsync: function (controlName, propertyName, propertyValue, onSucess, onError) {
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
        }, "NativeUI", "setValueAsync", [controlName, propertyName, propertyValue]);
    },

    getValueAsync: function (controlName, propertyName, onSucess, onError) {
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
        }, "NativeUI", "getValueAsync", [controlName, propertyName]);
    },

    addListener: function (controlName, eventName, handlerCallback) {
    
        //If the control was not registered
        if(!NativeUI.controlEvents[controlName]){
               NativeUI.controlEvents[controlName] = {};
        }
        
        //If the control event was not registred
         if(!NativeUI.controlEvents[controlName][eventName]){
               NativeUI.controlEvents[controlName][eventName] = [];
        }
        
        //Register the callback on control event
        NativeUI.controlEvents[controlName][eventName].push(handlerCallback);
        
        
    },

    removeListener: function (controlName, eventName, handlerCallback) {
    
         //If has any handlerCallback registred for this control and event
        if(NativeUI.controlEvents[controlName] && NativeUI.controlEvents[controlName][eventName])
        {
            //Call all of them
            var callbacks = NativeUI.controlEvents[controlName][eventName];
            for(var i = 0; i < callbacks.length; i++){
                var func = callbacks[i];
                if(func == handlerCallback){
                     callbacks.splice(i, 1); 
                    i--;
                    
                }
            } 
        }
    },
    
    broadcastEvent: function(controlName,eventName){
         console.log("NativeUI broadcastEvent "+eventName+" on control " + controlName);
        
        //If has any handlerCallback registred for this control and event
        if(NativeUI.controlEvents[controlName] && NativeUI.controlEvents[controlName][eventName])
        {
            //Call all of them
            var callbacks = NativeUI.controlEvents[controlName][eventName];
            for(var i = 0; i < callbacks.length; i++){
                var func = callbacks[i];
                if(func){
                    func();  
                    
                }
            }
            console.log("NativeUI broadcasted event");
        }
        else
        {
            console.log("NativeUI there is no handlerCallbacks for event "+eventName+" on control " + controlName);
         
        }
        
    },
    
    registerBroadcastEvent: function(){
        
         exec(function (result) {
            console.log("NativeUIPluginSucess: " + result)

            if(result){
                NativeUI.broadcastEvent(result.controlName,result.eventName);
            }
            
        }, function (err) {
            console.log("NativeUIPluginError: " + err);
           
        }, "NativeUI", "broadcastEvent", []);
    }

};

//document.addEventListener("NativeEvent" ,NativeUI.nativeEvent, false );

chanel.onCordovaReady.subscribe(function() {
    NativeUI.registerBroadcastEvent();
});

module.exports = NativeUI;