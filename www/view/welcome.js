/**
 * Created by wilckersonganda on 05/11/14.
 */
View.welcome = {
    type: NativeUI.type.window,
    showHeader: false,
    elements: [
        {
            type: NativeUI.type.label,
            content: "Bem vindo {0}"
        },
        {
            type: NativeUI.type.image,
            path: "img/default_user_picture.png",
            border: {radius: "50%", color: "#fff", size: 3},
            shadow: {x: 1, y: 1, size: 5, blur: 100}
        },
        {
            type: NativeUI.type.linearContainer,
            orientation: NativeUI.orientation.horizontal,
            elements: [
                {
                    type: NativeUI.type.label,
                    content: "Para continuar, aceite os"
                },
                {
                    type: NativeUI.type.linkButton,
                    content: "termos de uso.",
                    onClick: Controller.welcome.onClickUserTerms
                }
            ]
        },
        {
            type: NativeUI.type.checkBox,
            id: "cbxAcceptTerms",
            checked: false,
            content: "Aceito os termos",
            onClick: Controller.welcome.onClickAcceptTerms
        },
        {
            type: NativeUI.type.button,
            id: "btnContinue",
            visible: false,
            content: "Continuar",
            onClick: Controller.welcome.onClickContinue
        }
    ]
};