/**
 * Created by wilckersonganda on 04/11/14.
 */
var NativeUI = {
    type: {
        window: 1,
        linearContainer: 1,
        container: 1,
        label:1,
        image: 1,
        button: 1,
        linkButton: 1
    },
    orientation: {horizontal: 0, vertical: 1},
    gradient: {linear: 0, radial:1},
    vAlign: {top: -1, middle: 0, bottom: 1},
    hAlign: {left:-1, center: 0, right: 1},
    color: {
        fromRgba: function (r, g, b, a) {
        }
    }
}

var NativeUIManager = {
    navigateToController: function(controller){},
    updateElementById: function(view,id,propertiesValues){},
    getElementValueById:function(view,id,propertyName){}
};