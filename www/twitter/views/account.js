/**
 * Created by wilckersonganda on 17/11/14.
 */
Views.account = {
    type: NativeUI.type.view,
    content: {
        type: NativeUI.type.linearContainer,
        items:[
            {
                type: NativeUI.type.linearContainer,
                height: 300,
                items:[
                    {
                        type: NativeUI.type.image,
                        path: "img/defaultAccountPicture.png",
                        border: {radius: "5", color: "#fff", size: 3}
                    },
                    {
                        type: NativeUI.type.label,
                        text: "User Name",
                        style: [Styles.title1, Styles.whiteText]
                    },
                    {
                        type: NativeUI.type.label,
                        text: "@account",
                        style: Styles.whiteText
                    }
                ]
            },
            {
                type: NativeUI.type.linearContainer,
                orientation: NativeUI.orientation.horizontal,
                items:[
                    {
                        type: NativeUI.type.linearContainer,
                        width: "20%",
                        items:[
                            {
                                type: NativeUI.type.label,
                                text: "0",
                                style: Styles.boldText,
                                hAlign: NativeUI.hAlign.left
                            },
                            {
                                type: NativeUI.type.label,
                                text: "tweets",
                                style: Styles.smallInfo,
                                hAlign: NativeUI.hAlign.left
                            }
                        ]
                    },
                    {
                        type: NativeUI.type.linearContainer,
                        width: "20%",
                        items:[
                            {
                                type: NativeUI.type.label,
                                text: "0",
                                style: Styles.boldText,
                                hAlign: NativeUI.hAlign.left
                            },
                            {
                                type: NativeUI.type.label,
                                text: "Seguindo",
                                style: Styles.smallInfo,
                                hAlign: NativeUI.hAlign.left
                            }
                        ]
                    },
                    {
                        type: NativeUI.type.linearContainer,
                        width: "60%",
                        items:[
                            {
                                type: NativeUI.type.linearContainer,
                                width: "60%",
                                items:[
                                    {
                                        type: NativeUI.type.label,
                                        text: "0",
                                        style: Styles.boldText,
                                        hAlign: NativeUI.hAlign.left
                                    },
                                    {
                                        type: NativeUI.type.label,
                                        text: "Seguidores",
                                        style: Styles.smallInfo,
                                        hAlign: NativeUI.hAlign.left
                                    }
                                ]
                            },
                            {
                                type: NativeUI.type.linearContainer,
                                hAlign: NativeUI.hAlign.right,
                                items:[
                                    {
                                        type: NativeUI.type.button,
                                        icon: "img/settings.png"
                                    },
                                    {
                                        type: NativeUI.type.button,
                                        icon: "img/switchAccount.png"
                                    },
                                    {
                                        type: NativeUI.type.button,
                                        icon: "img/message.png",
                                        content: {
                                            type: NativeUI.type.label,
                                            text: "0",
                                            border: { radius: "50%"},
                                            background: ThemeColors.blue
                                        }
                                    }
                                ]
                            }
                        ]
                    }

                ]
            }
        ]
    }

};