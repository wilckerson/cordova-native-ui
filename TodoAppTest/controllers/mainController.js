NativeUI.addController("mainController",function($view){
    
    $view.items = [];
    
    $view.onMessage("newItem",function(item){
        $view.items.push(item);
    });
    
    $view.newItem = function(){
        NativeUI.loadView("views/details.xml",{itemId: undefined});   
    }
});