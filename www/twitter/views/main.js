/**
 * Created by wilckersonganda on 17/11/14.
 */
Views.main = {
    type: NativeUI.type.view,
    title: "Twitter",
    actions: [
        {
            type: NativeUI.type.action,
            text: "search",
            icon: NativeUI.icons.search
        },
        {
            type: NativeUI.type.action,
            text: "compose",
            icon: NativeUI.icons.edit
        },
        {
            type: NativeUI.type.action,
            text: "star",
            icon: NativeUI.icons.person
        }
    ],
    content: {
        type: NativeUI.type.tabView,
        items: [
            {
                type: NativeUI.type.tabViewItem,
                text: "Início",
                icon: NativeUI.icons.person,
                content: Views.home
            },
            {
                type: NativeUI.type.tabViewItem,
                text: "Notificações",
                icon: NativeUI.icons.group,
                content: Views.notification
            }
            //{
            //    type: NativeUI.type.tabViewItem,
            //    text: "Descobrir",
            //    icon: "img/discovery.png",
            //    content: Views.discovery
            //}
            //{
            //    type: NativeUI.type.tabViewItem,
            //    text: "Conta",
            //    icon: "img/account.png"
            //    //content: Views.home
            //}
        ]
    }
}