/**
 * Created by wilckersonganda on 05/11/14.
 */
Controller.login = {
    view: View.login,


    onClickFacebook: function () {

        //Mostra mascara
        NativeUIManager.updateElementById(this.view, "loadingMask", {visible: true});

        //Autentica no facebook

        //Esconde mascara
        NativeUIManager.updateElementById(this.view, "loadingMask", {visible: false});

        //Redireciona para welcome
        NativeUIManager.navigateToController(Controller.welcome,
            {
                name: "Fulano da Silva",
                picUrl: "http://.../img.jpg"
            });
    }
};