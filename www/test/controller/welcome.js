/**
 * Created by wilckersonganda on 05/11/14.
 */
Controller.welcome = {
    view: View.welcome,

    onLoad: function(data){

        var msg = "Bem vindo " + data.name;
        NativeUIManager.updateElementById(this.view,"lblUserMsg",{content: msg});

        var pictureUrl = data.picUrl;
        NativeUIManager.updateElementById(this.view,"imgUserPicture",{path: pictureUrl});
    },

    onClickUserTerms: function(){

        //Redireciona para a tela de termos de uso
        //NativeUIManager.navigateToController(Controller.userTerms);
    },

    onClickAcceptTerms: function(){

        var isChecked = NativeUIManager.getElementValueById(this.view,"cbxAcceptTerms","checked");
        NativeUIManager.updateElementById(this.view,"btnContinue",{visible: isChecked});
    },

    onClickContinue: function(){

        //Redireciona para a petTimeline
        //NativeUIManager.navigateToController(Controller.petTimeline);
    }
};