cordova.define("com.wilckerson.native-ui.NativeUI", function (require, exports, module) {

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
        //                        type: "Button",
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
                console.log("OK");



            }, function (err) {
                console.log("Erro");
                console.log(err);
            }, "NativeUI", "initView", []);

        }

    };

    //document.addEventListener("NativeEvent" ,NativeUI.nativeEvent, false );

    module.exports = NativeUI;


});