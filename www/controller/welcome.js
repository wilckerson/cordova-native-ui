/**
 * Created by wilckersonganda on 05/11/14.
 */
Controller.welcome = {
    view: View.welcome,

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