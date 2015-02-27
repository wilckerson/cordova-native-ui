var NativeUIRenderRatchet = (function () {

    function appendRequiredFiles() {
        NativeUIRender.helpers.appendStyle("../nativeui/ratchet/css/ratchet.min.css");
        NativeUIRender.helpers.appendStyle("../nativeui/ratchet/css/ratchet-theme-ios.min.css");
        NativeUIRender.helpers.appendScript("../nativeui/ratchet/js/ratchet.min.js");
    }




    function renderView(view) {


        var html = "";
        var props = ['title', 'actions', 'content'];


        var propsResult = NativeUIRender.helpers.checkProps(Object.keys(view), props);
        if (propsResult.length) {
            throw "O controle do tipo " + NativeUI.type.view + " não suporta a(s) propriedade(s): " + propsResult.toString();
        }

        html += '<header class="bar bar-nav">';

        if (view.title) {
            html += ' <h1 class="title">' + view.title + '</h1>';
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


        for (var i in actions) {
            var elm = actions[i];

            if (elm.type != NativeUI.type.action) {
                throw "A propriedade view.actions só pode ter elementos do tipo " + NativeUI.type.action + ". O elemento com indice " + i + " está com o tipo " + elm.type;

            }

            var nativeIconIdx = Object.keys(NativeUI.icons).indexOf(elm.icon);

            if (nativeIconIdx != -1) {
                var iconCss = 'icon-' + elm.icon;
                html += '<a href="javascript: void(0);" class="icon ' + iconCss + ' pull-right" style="margin-left:20px;"></a>';
            }
//            else {
//                html += '<span class="pull-right">' + elm.text + '</span>';
//            }


        }

        return html;
    }

    function renderViewContent(content) {
        var html = "";

        if (!NativeUIRender.helpers.isObject(content)) {
            throw "A propriedade view.content deve ser um Objeto.";
        }

        html += '<div class="content">';

        if (content.type == NativeUI.type.tabView) {
            html += renderTabView(content);
        }

        html += '</div>';

        return html;
    }


    function renderTabView(view) {

        var html = "";


        html += ' <nav class="bar bar-tab">';

        if (view.items) {
            if (!NativeUIRender.helpers.isArray(view.items)) {
                throw "A propriedade tabView.items deve ser um Array.";
            }

            for (var itemIdx in view.items) {
                var elm = view.items[itemIdx];

                if (elm.type != NativeUI.type.tabViewItem) {
                    throw "A propriedade tabView.items só pode ter elementos do tipo " + NativeUI.type.tabViewItem + ". O elemento com indice " + itemIdx + " está com o tipo " + elm.type;

                }

                html += '<a class="tab-item" href="#">' +
                '<span class="icon icon-'+elm.icon+'"></span>' +
                '<span class="tab-label">' + elm.text + '</span>' +
                    '</a>';
            }
        }

        html += '</nav>';

        return html;
    }

    return {
        renderView: renderView,
        appendRequiredFiles: appendRequiredFiles
    };

}());

