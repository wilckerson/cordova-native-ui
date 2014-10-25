cordova.define("com.wilckerson.native-ui.NativeUI", function(require, exports, module) { 
var NativeUI = {
    
    nativeAlert: function(msg){
         
        exec(function(){ 
            console.log("OK");
        }, function (err) {
                  console.log("Erro");
            console.log(err);
        }, "NativeUI", "nativeAlert", [msg]);
                
    }
};

module.exports = NativeUI;


});
