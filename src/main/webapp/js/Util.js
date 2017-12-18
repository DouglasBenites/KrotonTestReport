var Util = {
	getContext: function(){
		var url;
		if(window.location != undefined){
			var origem 		= window.location.origin;
			var pathname	= window.location.pathname;
			pathname 		= pathname.substring(0, pathname.indexOf("/", 2) + 1);
			var url			= origem + pathname;
		}
		else{
			url = document.URL ;
			url = url.substring(0, url.indexOf("/", 4) + 1); ;
		}
		
		return url;
	},
	
	get: function($http, restResource, params, _successCallBack, _errorCallBack){
		if(!_successCallBack || _successCallBack == undefined)
			_successCallBack = function(){};
			
		if(!_errorCallBack || _errorCallBack == undefined)
			_errorCallBack = function(){};
			
		$http({
		    method : "GET",
		    url : this.getContext() + restResource,
		    data : angular.toJson(params)
		})
		.then(
			_successCallBack, _errorCallBack
		);
	},
	
	post: function($http, restResource, params, _successCallBack, _errorCallBack){
		if(!_successCallBack || _successCallBack == undefined)
			_successCallBack = function(){};
			
		if(!_errorCallBack || _errorCallBack == undefined)
			_errorCallBack = function(){};
				
		$http({
		    method : "POST",
		    url : this.getContext() + restResource,
		    data : angular.toJson(params)
		    
		})
		.then(
			_successCallBack, _errorCallBack
		);
	},
	
	put: function($http, restResource, params, _successCallBack, _errorCallBack){
		if(!_successCallBack || _successCallBack == undefined)
			_successCallBack = function(){};
			
		if(!_errorCallBack || _errorCallBack == undefined)
			_errorCallBack = function(){};
				
		$http({
		    method : "PUT",
		    url : this.getContext() + restResource,
		    data : angular.toJson(params)
		    
		})
		.then(
			_successCallBack, _errorCallBack
		);
	},
	
	del: function($http, restResource, params, _successCallBack, _errorCallBack){
		if(!_successCallBack || _successCallBack == undefined)
			_successCallBack = function(){};
		
		if(!_errorCallBack || _errorCallBack == undefined)
			_errorCallBack = function(){};
			
		$http({
		    method : "DELETE",
		    url : this.getContext() + restResource,
		    data : angular.toJson(params),
		    headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    }
		   
		})
		.then(
			_successCallBack, _errorCallBack
		);
	}
}