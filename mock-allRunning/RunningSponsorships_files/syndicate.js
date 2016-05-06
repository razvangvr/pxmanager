var Syndicator = {
	syndicate : function(actionType, path, lang, index) {
		this.setFormValues(actionType, path, lang);
		var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
		DWRActionUtil.execute({namespace: '/', action: 'syndicate', executeResult: 'false'}, 
							  document.forms[1], 
							  function(data) {Syndicator.onSyndicateDone(index, actionType, data);}, 
							  message);
	},
	
	setFormValues : function(actionType, path, lang, subpath) {
		document.getElementById('action').value = actionType;
		document.getElementById('nodePath').value= path;
		document.getElementById('lang').value= lang;
		if(subpath) { document.getElementById('subPath').value= subpath; }
	},
	
	clearFormValues : function() {
		document.getElementById('action').value = "";
		document.getElementById('nodePath').value= "";
		document.getElementById('lang').value= "";
		document.getElementById('subPath').value= "";
	},
	
	vcrSyndicate : function(actionType, nodeId, index, sponsorshipPath, lang) {
		this.setVTFormValues(actionType, nodeId);
		var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
		DWRActionUtil.execute({namespace: '/', action: 'syndicateVCR', executeResult: 'false'}, 
							  document.forms[0], 
							  function(data) {Syndicator.onSyndicateDone(index, actionType, data);}, 
							  message);
		this.clearFormValues();
		if(sponsorshipPath) {
			this.setFormValues(actionType, sponsorshipPath, lang);
			var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
			DWRActionUtil.execute({namespace: '/', action: 'syndicate', executeResult: 'false'}, 
								  document.forms[0], 
								  function(data) {}, 
								  message);
			this.clearFormValues();
		}
	},
	
	techbriefSyndicate : function(actionType, nodeId, index) {
		this.setVTFormValues(actionType, nodeId);
		var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
		DWRActionUtil.execute({namespace: '/', action: 'syndicateTechbrief', executeResult: 'false'}, 
							  document.forms[0], 
							  function(data) {Syndicator.onSyndicateDone(index, actionType, data);}, 
							  message);
	},
	
	featuredcategorySyndicate : function(actionType, nodeId, index) {
		this.setVTFormValues(actionType, nodeId);
		var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
		DWRActionUtil.execute({namespace: '/', action: 'syndicateFeaturedCategory', executeResult: 'false'}, 
							  document.forms[0], 
							  function(data) {Syndicator.onSyndicateDone(index, actionType, data);}, 
							  message);
	},
	
	featuredcontentSyndicate : function(actionType, nodeId, index) {
		this.setVTFormValues(actionType, nodeId);
		var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
		DWRActionUtil.execute({namespace: '/', action: 'syndicateFeaturedContent', executeResult: 'false'}, 
							  document.forms[0], 
							  function(data) {Syndicator.onSyndicateDone(index, actionType, data);}, 
							  message);
	},
	
	sponsorcategSyndicate : function(actionType, nodeId, index) {
		this.setVTFormValues(actionType, nodeId);
		var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
		DWRActionUtil.execute({namespace: '/', action: 'syndicateSponsorCateg', executeResult: 'false'}, 
							  document.forms[0], 
							  function(data) {Syndicator.onSyndicateDone(index, actionType, data);}, 
							  message);
	},
	
	syndicateBookSponsorship : function(actionType, path, lang, index) {
		this.setFormValues(actionType, path, lang, 'sponsorship');
		var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
		DWRActionUtil.execute({namespace: '/', action: 'syndicateBookSponsorship', executeResult: 'false'}, 
							  document.forms[0], 
							  function(data) {Syndicator.onSyndicateDone(index, actionType, data);}, 
							  message);
	},
	
	skyscraperSyndicate : function(actionType, nodeId, index) {
		this.setVTFormValues(actionType, nodeId);
		var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
		DWRActionUtil.execute({namespace: '/', action: 'syndicateSkyscraper', executeResult: 'false'}, 
							  document.forms[0], 
							  function(data) {Syndicator.onSkyscraperSyndicateDone(index, actionType, data);}, 
							  message);
	},
	
	conferenceIndexPageSyndicate : function(actionType, nodeId, index) {
		this.setVTFormValues(actionType, nodeId);
		var message = actionType == 1 ? "Publishing..." : "Unpublishing...";
		DWRActionUtil.execute({namespace: '/', action: 'syndicateConferenceIndexPage', executeResult: 'false'}, 
							  document.forms[0], 
							  function(data) {Syndicator.onSyndicateDone(index, actionType, data);}, 
							  message);
	},
	
	setVTFormValues : function(actionType, nodeId) {
		document.getElementById('action').value = actionType;
		document.getElementById('nodeId').value= nodeId;
	},
	
	onSkyscraperSyndicateDone : function(index, actionType, data) {
		if (data.successful) {
			this.onSuccessSyndication(index, actionType, data);
			window.location.href=window.location.href;
		}
		else {
			this.onFailedSyndication(index, actionType, data);
		}
	},
	
	onSyndicateDone : function(index, actionType, data) {
		if (data.successful) {
			this.onSuccessSyndication(index, actionType, data);
		}
		else {
			this.onFailedSyndication(index, actionType, data);
		}
	},
	
	onSuccessSyndication : function(index, actionType, data) {
		var spanElem= document.getElementById("status_" + index);
		if(!spanElem) {alert("no status_" + index);}
		var pubLink= document.getElementById("pub_" + index);
		if(!pubLink) {alert("no pub_" + index);}
		var unpubLink= document.getElementById("unpub_" + index);
		if(!unpubLink) {alert("no unpub_" + index);}
		var dirtySpanElem= document.getElementById("dirtystatus_" + index);
		var liveUrlDivElem= document.getElementById("liveUrl_" + index);
		
		if (actionType == 1) {
			spanElem.innerHTML = "Y";
			pubLink.style.display = "none";
			unpubLink.style.display= "inline";
			if (typeof(liveUrlDivElem) != 'undefined' && liveUrlDivElem != null){
				liveUrlDivElem.style.display="block";
			}			
		}
		else {
			spanElem.innerHTML = "N";
			pubLink.style.display = "inline";
			unpubLink.style.display= "none";
			if (typeof(liveUrlDivElem) != 'undefined' && liveUrlDivElem != null){
				liveUrlDivElem.style.display="none";
			}
		}
		if(dirtySpanElem){
			dirtySpanElem.innerHTML = data.isDirty;
		}
	},

	onFailedSyndication : function(index, actionType, data) {
		var msg = "Syndication failed. Please contact webmaster";
		if(data.failureToken) {
			msg = msg + "\nToken:" + data.failureToken;
		}
		if(data.failureMessage) {
			msg = msg + "\nDetails:" + data.failureMessage;
		}
		alert(msg);
	}
};
