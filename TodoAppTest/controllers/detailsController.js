NativeUI.addController("detailsController",function($view){
    
    $view.onLoad = function(args){
        
        //Is new item?
        if(!args.itemId)
        {
            $view.showDeleteBtn = false;
        }
        
    };
    
    $view.saveItem = function(){
        
        var item = {
            description : $view.description ,
            done: false
        };
        
        NativeUI.sendMessage("newItem",item);
        NativeUI.loadView("views/main.xml");
    };
    
});