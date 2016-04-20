function validateCommunitiesAndTopics() {
	var hasErrors = false;
	
	//FIXME Adi once content translate screens will get modern personas and topics input, the code below should be removed. Test first. 
	//TOREMOVE
	var communitiesSelected = document.getElementById('communityTags');
	var topicsSelected = document.getElementById('topicTags');
    var primaryTopic = document.getElementById('primaryTopic');
    if (primaryTopic) {
        var id=primaryTopic.selectedIndex; //get currently selected idx
        if(primaryTopic.options[id].value === ""){
            var ptErrorDiv = document.getElementById('wwerr_primaryTopic');
            ptErrorDiv.innerHTML = "Primary topic must be set";
            ptErrorDiv.style.display = "block";
            hasErrors = true;
        }
    }

	if(communitiesSelected && communitiesSelected.options.length==0){
		var comunityErrorDiv = document.getElementById('communityTags_errors');
		comunityErrorDiv.innerHTML = "Content must have at least one community associated";
		comunityErrorDiv.style.display = "block";
		hasErrors = true;
	}
	else{
		ResourceElement.hide('communityTags_errors');
	}
	
	if(topicsSelected && topicsSelected.options.length==0){
		var topicsErrorDiv = document.getElementById('topicTags_errors');
		topicsErrorDiv.innerHTML = "Content must have at least one topic associated";
		topicsErrorDiv.style.display = "block";
		hasErrors = true;
	}
	else{
		ResourceElement.hide('topicTags_errors');
	}
	//TOREMOVE
	
	//PERSONAS existence validation
	// 0 is falsy in JS; having a jQuery collection of 0 elements is equivalent with this expression evaluating to false
	if(jQuery('#personas').length) {
		var personaSelected = false;
		jQuery("[name='communityTags']").each(function() {
			if(this.checked) {
				personaSelected = true;
				//break forEach
				return false;
			}
		});
		if(!personaSelected) {
			jQuery("#err_persona").show();
			hasErrors = true;
		}
		else {
			jQuery("#err_persona").hide();
		}
	}
	
	//TOPICS existence validation
	// 0 is falsy in JS; having a jQuery collection of 0 elements is equivalent with this expression evaluating to false
	if(jQuery('#topicContainer').length) {
		var topicSpecified = false;
		if (jQuery('#topicContainer>span').length){
			topicSpecified = true;
		}
		
		if(!topicSpecified) {
			jQuery("#err_topic_token").show();
			hasErrors = true;
		}
		else {
			jQuery("#err_topic_token").hide();
		}
	}
	
	return hasErrors;
}

//performs topics validation for sponsorships
function validateCommunityOrTopicOrTag(isNewItem) {
	if(!isNewItem) return false;
	var hasErrors = false;
	jQuery("#categoriesError").hide();
	
	var personaSelected = false;
	jQuery("[name='communityTags']").each(function() {
		if(this.checked) {
			personaSelected = true;
			//break forEach			
		}
	});
	
	var topicSpecified = false;
	if (jQuery('#topicContainer>span').length){
		topicSpecified = true;
	}
	
	if(!personaSelected && !topicSpecified){
		jQuery("#categoriesError").html('Must have at least one persona or topic associated');
		jQuery("#categoriesError").show();
		hasErrors = true;
	}
	
	return hasErrors;
}

function validateTopics(){
	var hasErrors = false;
	jQuery("#categoriesError").hide();
	
	var topicSpecified = false;
	if (jQuery('#topicContainer>span').length){
		topicSpecified = true;
	}
	
	if(!topicSpecified){
		jQuery("#categoriesError").html('Must have at least one topic associated');
		jQuery("#categoriesError").show();
		hasErrors = true;
	}
	
	return hasErrors;
}