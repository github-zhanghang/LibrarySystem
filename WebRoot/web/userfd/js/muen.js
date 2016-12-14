strin = function(){
		//alert("aa");
		if(document.all && document.getElementById){
			aa=document.getElementById("nuw");
			//alert(aa.innerHTML);
			for(var i=0;i<aa.childNodes.length;i++){
				var bb = aa.childNodes[i];
				//alert(bb.name);
				if(bb.nodeName=="LI"){
					//alert("bb.nodeName");
					bb.onmouseover=function(){
						this.className="over";
					}
					bb.onmouseout= function(){
						this.className="";
					}
				}
				else{
					//alert("bb.nodeName");
				}
		
			}
			//navRoot.childNodes.length
		}
	}
	window.onload=strin;