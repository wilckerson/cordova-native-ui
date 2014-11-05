/**
 * Created by wilckersonganda on 04/11/14.
 */
View.shared.loading = {
    type: NativeUI.type.container,
    id: "loadingMask",
    visible: false,
    backgroundColor: NativeUI.color.fromRgba(0, 0, 0, 0.35), //#30000000
    width: "100%",
    height: "100%",
    elements: [
        {
            type: NativeUI.type.linearContainer,
            elements: [
                {
                    type: NativeUI.type.image,
                    path: "img/animated_steps.gif"
                },
                {
                    type: NativeUI.type.label,
                    content: "Loading..."
                }
            ]
        }
    ]
};