var NativeUIRenderFries = (function () {

    function appendRequiredFiles() {
        NativeUIRender.helpers.appendStyle("../nativeUI/fries/themes/holo-dark/holo-dark.min.css");
        NativeUIRender.helpers.appendScript("../nativeUI/fries/fries.js");
    }

    function getIconElement(iconPath) {

        var nativeIconIdx = Object.keys(NativeUI.icons).indexOf(iconPath);

        if (nativeIconIdx != -1) {
            return '<i class="icon-' + iconPath + '"></i>';
        } else {
            return '<img src=' + iconPath + '"/>';
        }

    }


    function renderView(view) {

        var html = "";
        var props = ['title', 'actions', 'content'];


        var propsResult = NativeUIRender.helpers.checkProps(Object.keys(view), props);
        if (propsResult.length) {
            throw "O controle do tipo " + NativeUI.type.view + " não suporta a(s) propriedade(s): " + propsResult.toString();
        }

        html += '<header class="action-bar fixed-top">';

        if (view.title) {
            html += '<h1 style="margin-left:10px;" class="title">' + view.title + '</h1>';
        }

        if (view.actions) {

            html += renderViewActions(view.actions);
        }

        html += '</header>';

        if (view.content) {

            html += renderViewContent(view.content);

        }

        return html;
    }

    function renderViewActions(actions) {
        var html = "";

        if (!NativeUIRender.helpers.isArray(actions)) {
            throw "A propriedade view.actions deve ser um Array.";
        }

        html += '<ul class="actions pull-right">';
        for (var i in actions) {
            var elm = actions[i];

            if (elm.type != NativeUI.type.action) {
                throw "A propriedade view.actions só pode ter elementos do tipo " + NativeUI.type.action + ". O elemento com indice " + i + " está com o tipo " + elm.type;

            }

            html += '<li><a href="javascript: void(0);" class="action">' +
                getIconElement(elm.icon) +
            //'<span>' + elm.text +'</span>' +
            '</a></li>';

        }
        html += '</ul>';

        return html;
    }

    function renderViewContent(content) {
        var html = "";

        if (!NativeUIRender.helpers.isObject(content)) {
            throw "A propriedade view.content deve ser um Objeto.";
        }

        if (content.type == NativeUI.type.tabView) {
            html += renderTabView(content);
        }
        return html;
    }


    function renderTabView(view) {

        var html = "";


        html += '<nav class="tab-fixed"><ul class="tab-inner">';

        if (view.items) {
            if (!NativeUIRender.helpers.isArray(view.items)) {
                throw "A propriedade tabView.items deve ser um Array.";
            }

            for (var itemIdx in view.items) {
                var elm = view.items[itemIdx];

                if (elm.type != NativeUI.type.tabViewItem) {
                    throw "A propriedade tabView.items só pode ter elementos do tipo " + NativeUI.type.tabViewItem + ". O elemento com indice " + itemIdx + " está com o tipo " + elm.type;

                }

                html += '<li><a href="#groups" data-ignore="true">' +
                    getIconElement(elm.icon) +
                //'<span>' + elm.text +'</span>' +
                '</a></li>';
            }
        }

        html += '</ul></nav>';

        return html;
    }

    return {
        renderView: renderView,
        appendRequiredFiles: appendRequiredFiles
    };

}());