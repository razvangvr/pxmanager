var MenuBar = {
	displayCancelOptions : function(targetId) {
		var messageSpan= document.getElementById(targetId);
		if (messageSpan) {
			if (messageSpan.style.display == "none") {
				messageSpan.style.display= "inline";
			}
			else {
				messageSpan.style.display= "none";
			}
		}
	
		return false;
	}
};