/**
 * Created by wilckersonganda on 17/11/14.
 */
Views.discovery = {
    type: NativeUI.type.view,
    content: {
        type: NativeUI.type.linearContainer,
        items:[
            {
                //Assuntos do Momento
                type: NativeUI.type.listView,
                listViewItemTemplate: {}
            },
            {
                //Sugestão amigos
                type: NativeUI.type.listView,
                listViewItemTemplate: {}
            }
        ]
    }
};