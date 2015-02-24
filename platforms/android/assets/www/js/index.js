var app = {
    // Application Constructor
    initialize: function () {
        document.addEventListener('deviceready', app.onDeviceReady, false);

    },
    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicitly call 'app.receivedEvent(...);'
    onDeviceReady: function () {

        app.log('deviceready');

        //On click btnPLugin
        var btnPlugin = document.getElementById("btnPlugin");
        btnPlugin.addEventListener("click", app.onClickBtnPlugin, false);


    },

    loaded: false,
    onClickBtnPlugin: function () {

        app.log("click");
        if (!app.loaded) {
            NativeUI.loadPage("hue.xml");
            
            NativeUI.addListener("btn","click",function(){
                app.log("btn clicked");
            });
            
            app.loaded = true;
        } else {
            //NativeUI.hide();
            //NativeUI.getValueAsync("txt", "content", function (value) {
                //app.log("got value");
                //"Hello " + value
                //NativeUI.setValueAsync("btn", "content", (new Date()).getTime() , function () {
                   // app.log("value updated");
                //});

            //});


            app.loaded = false;
        }

    },
    // Update DOM on a Received Event
    log: function (msg) {
        var element = document.getElementById("screenLog");
        element.innerHTML = "<div>" + msg + "</div>" + element.innerHTML;

        console.log('ScreenLog: ' + msg);
    }
};

app.initialize();