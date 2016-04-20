function SimpleTabs(linksDivId, divSelector) {
	this.linksDivId= linksDivId;
	this.divSelector= divSelector;
	this.tabLinks;
	this.tabs;
	
	this.activate = function(targetDivId, currentLink) {
		this.activateTabLink(currentLink);
		this.activateTab(targetDivId);
	};
	
	this.activateTab = function(targetDivId) {
		var tabs = this.getTabs();
		for(var i=0; i< tabs.length; i++) {
			if (tabs[i].id == targetDivId) {
				tabs[i].style.display= "block";
			}
			else {
				tabs[i].style.display= "none";
			}
		}
	};
	
	this.activateTabLink =  function(currentLink) {
		this.clearTabs();
		currentLink.className = "tab activeTab";	
	};
	
	this.clearTabs = function() {
		var tabLinks= this.getTabLinks();
		
		for(var i= 0; i < tabLinks.length; i++) {
			tabLinks[i].className = "tab";
		}
	};
	
	this.getTabLinks = function() {
		if (!this.tabLinks) {
			var linksDiv= document.getElementById(this.linksDivId);
			if(linksDiv) {
				this.tabLinks= linksDiv.getElementsByTagName("a");
			}
		}
		
		return this.tabLinks;
	};
	
	this.getTabs = function() {
		if (!this.tabs) {
			var possibleTabs= document.getElementsByTagName("div");
			this.tabs= new Array();
			
			for(var i= 0; i < possibleTabs.length; i++) {
				if(possibleTabs[i].className == this.divSelector) {
					this.tabs.push(possibleTabs[i]);
				}
			}
		}
		
		return this.tabs;
	}
}
