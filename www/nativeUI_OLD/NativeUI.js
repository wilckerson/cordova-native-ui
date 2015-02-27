/**
 * Created by wilckersonganda on 04/11/14.
 */
var NativeUI = {
    type: {
        view: 'view',
        linearContainer: 'linearContainer',
        container: 'container',
        label:'label',
        image: 'image',
        button: 'button',
        linkButton: 'linkButton',
        action: 'action',
        tabView:'tabView',
        tabViewItem: 'tabViewItem',
        listView: 'listView'
    },
    textTransform: {upperCase: 1, lowerCase: 2},
    orientation: {horizontal: 0, vertical: 1},
    gradient: {linear: 0, radial:1},
    vAlign: {top: -1, middle: 0, bottom: 1},
    hAlign: {left:-1, center: 0, right: 1},
    color: {
        fromRgba: function (r, g, b, a) {
        }
    },
    icons: {
        edit: "edit",
        search: "search",
        person: "person",
        group:"group",
        starFull:"star-full"
    }
}

var NativeUIManager = {
    navigateToController: function(controller,data){
        if(controller.onLoad){ controller.onload(data); }
    },
    updateElementById: function(view,id,propertiesValues){},
    getElementValueById:function(view,id,propertyName){}
};