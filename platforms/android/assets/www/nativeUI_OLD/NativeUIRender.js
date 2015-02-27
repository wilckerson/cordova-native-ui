/**
 * Created by wilckersonganda on 17/11/14.
 */
var NativeUIRender = (function () {



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




    function isArray(prop) {
        return Object.prototype.toString.call(prop) === '[object Array]';
    }

    function isObject(prop) {
        return Object.prototype.toString.call(prop) === '[object Object]';
    }

    function checkProps(props, supportedProps) {
        var unsupported = [];

        for (var p = 0; p < props.length; p++) {
            var pp = props[p];
            if (pp != 'type' && supportedProps.indexOf(pp) == -1) {
                unsupported.push(pp);
            }
        }

        return unsupported;
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

    function render(view, provider) {

        try {

            if (view.type != NativeUI.type.view) {
                throw "A tela raiz deve ser do tipo View ao invés de " + view.type;
            }

            var renderResult = provider.renderView(view);

            console.log("NativeUIRender: view gerada.");
            console.log(renderResult);

            provider.appendRequiredFiles();

            appendResult(renderResult);

        } catch (err) {
            console.log("NativeUIRender: Foi encontrado um erro durante a renderização")
            //console.log(err);
            throw err;
        }

    }


    return {
        helpers: {
            checkProps: checkProps,
            isObject: isObject,
            isArray: isArray,
            appendScript: appendScript,
            appendStyle: appendStyle

        },
        render: render
    };

})();