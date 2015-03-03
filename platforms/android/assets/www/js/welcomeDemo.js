var WelcomeDemo = {
	
	init: function(){

		NativeUI.loadPage("whoareyou.xml");

		NativeUI.addListener("#btnSubmit","click",WelcomeDemo.onSubmit);
	},

	onSubmit: function(){

		var personName = NativeUI.getValueAsync("#tbxName","content",function(value){

			if(!value){
				alert("Say your name.");
				return;
			}

			NativeUI.loadPage("welcome.xml");

			NativeUI.setValueAsync("#txUserName","content",function(){
				//Setted
			});

		});
		
	}

};