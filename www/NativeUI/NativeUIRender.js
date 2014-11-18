/**
 * Created by wilckersonganda on 17/11/14.
 */
var NativeUIRender = (function () {


    function appendRequiredFiles() {
        appendStyle("../nativeUI/fries/themes/holo-dark/holo-dark.min.css");
        appendScript("../nativeUI/fries/fries.js");
    }

    function appendStyle(path) {
        var l = document.createElement('link');
        l.rel = 'stylesheet';
        l.type = 'text/css';
        l.href = path;
        document.head.appendChild(l);
    }

    function appendScript(path) {
        var l = document.createElement('script');
        l.type = 'text/javascript';
        l.src = path;
        document.head.appendChild(l);
    }


    function appendResult(html) {
        var root = document.getElementById("root");

        if (!root) {
            root = document.createElement("div");
            root.id = "root";
            document.body.appendChild(root);
        }

        root.innerHTML = html;

    }

    function getIconElement(iconPath) {

        var nativeIconIdx = Object.keys(NativeUI.icons).indexOf(iconPath);

        if (nativeIconIdx != -1) {
            return '<i class="icon-' + iconPath + '"></i>';
        }
        else {
            return '<img src=' + iconPath + '"/>';
        }

    }

    function render(view) {

        var parseResult = parse(view);

        if (!parseResult.errors.length) {
            console.log("NativeUIRender: view gerada.");
            console.log(parseResult.html);

            appendRequiredFiles();

            appendResult(parseResult.html);

        }
        else {
            console.log("NativeUIRender: Foi encontrado os seguintes erros:")
            for (var i in parseResult.errors) {
                console.log(parseResult.errors[i]);
            }
        }
    }

    function isArray(prop) {
        return Object.prototype.toString.call(prop) === '[object Array]';
    }

    function parse(view) {

        var errors = [];
        var html = "";
        var r = {errors: errors, html: ""};

        if (view.type == NativeUI.type.view) {

            html += '<header class="action-bar fixed-top">';

            if (view.title) {
                html += '<h1 class="title">' + view.title + '</h1>';
            }

            if (view.actions) {

                if(!isArray(view.actions))
                {
                    errors.push("A propriedade view.actions deve ser um Array.");
                    return r;
                }

                html += '<ul class="actions pull-right">';
                for (var i in view.actions) {
                    var elm = view.actions[i];

                    if (elm.type != NativeUI.type.action) {
                        errors.push("A propriedade view.actions só pode ter elementos do tipo " + NativeUI.type.action + ". O elemento com indice " + i + " está com o tipo " + elm.type);
                        return r;
                    }

                    html += '<li><a href="javascript: void(0);" class="action">' +
                    getIconElement(elm.icon) +
                        //'<span>' + elm.text +'</span>' +
                    '</a></li>';

                }
                html += '<ul>';
            }

            html += '</header>';

            if(view.content)
            {
                if(isArray(view.content))
                {
                    errors.push("A propriedade view.content deve ser um Objeto.");
                    return r;
                }

                if(view.content.type == NativeUI.type.tabView)
                {
                    html += '<nav class="tab-fixed"><ul class="tab-inner">';

                    if(view.content.items) {
                        if (!isArray(view.content.items)) {
                            errors.push("A propriedade tabView.items deve ser um Array.");
                            return r;
                        }

                        for(var itemIdx in view.content.items)
                        {
                            var itemElm = view.content.items[itemIdx];

                            if(itemElm.type!=NativeUI.type.tabViewItem)
                            {
                                errors.push("A propriedade tabView.items só pode ter elementos do tipo " + NativeUI.type.tabViewItem + ". O elemento com indice " + itemIdx + " está com o tipo " + itemElm.type);
                                return r;
                            }

                            html += '<li><a href="#groups" data-ignore="true">'+
                                        getIconElement(itemElm.icon) +
                                        //'<span>' + elm.text +'</span>' +
                                    '</a></li>';
                        }
                    }



                    html += '</ul></nav>';
                }

            }
        }
        else {
            errors.push("A tela raiz deve ser do tipo View ao invés de " + view.type);
            return r;
        }

        r.html = html;
        return r;
    }

    return {
        render: render
    };

})();