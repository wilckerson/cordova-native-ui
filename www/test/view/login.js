/**
 * Created by wilckersonganda on 04/11/14.
 */
View.login = {
    type: NativeUI.type.view,
    showHeader: false,
    backgroundImage: "img/bgLogin.png",
    elements: [
        {
            type: NativeUI.type.linearContainer,
            vAlign: NativeUI.vAlign.bottom,
            margin: [0, 0, "5%", 0],
            elements: [
                {type: NativeUI.type.image, path: "img/pmpLogo.png"},
                {type: NativeUI.type.label, content: "Seu pet sempre seguro"},
                {
                    type: NativeUI.type.button,
                    onClick: Controller.login.onClickFacebook,
                    margin: [0, 20, 0, 0],
                    backgroundGradient: {
                        type: NativeUI.gradient.linear,
                        values: [
                            {step: 0, color: "#a43452"},
                            {step: 1, color: "#46aa53"}
                        ]
                    },
                    content: {
                        type: NativeUI.type.linearContainer,
                        orientation: NativeUI.orientation.horizontal,
                        elements: [
                            {
                                type: NativeUI.type.image,
                                path: "img/facebookIcon.png"
                            },
                            {
                                type: NativeUI.type.label,
                                content: "Entrar com facebook",
                                margin: [0, 0, 0, 10]
                            }
                        ]
                    }
                }
            ]
        },
        View.shared.loading
    ]
};

/*

 <view backgroundImage=""img/bgLogin.png>
 <linearConainer vAlign="bottom" margin="0,0,5%,0">
 <image path="img/logo.png"></image>
 <label content="Seu pet sempre seguro"></label>
 <button margin="0,20,0,0">
 <button.backgroundGradient type="linear">
 <step value="0" color="#230543"></step>
 <step value="1" color="#12df52"></step>
 </button.backgroundGradient>
 <button.content>
 <linearContainer orientation="horizontal">
 <image path="img/facebookIcon.png" margin="0,10,0,0"></image>
 <label content="Entrar com facebook"></label>
 </linearContainer>
 </button.content>
 </button>
 </linearContainer>
 </view>

 */