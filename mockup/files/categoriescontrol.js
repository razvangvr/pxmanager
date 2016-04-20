var CategoriesControl = {
	addSelection : function(selectElemId, targetElemId) {
		var selectEl= document.getElementById(selectElemId);
		var targetEl= document.getElementById(targetElemId);
		
		if(selectEl.selectedIndex > -1) {
			for(var i = 0; i < selectEl.options.length; i++) {
				if(selectEl.options[i].selected) {
					var found = false;
					for (var j = 0; j < targetEl.options.length; j++) {
						if (targetEl.options[j].value == selectEl.options[i].value) {
							found= true;
							break;
						}
					}
					
					if (!found) {
						var newOption= document.createElement("option");
						newOption.text= selectEl.options[i].text;
						newOption.value= selectEl.options[i].value;
						newOption.selected= true;
						targetEl.options.add(newOption);
					}
				}
			}
		}
	},
	
	removeSelection : function(targetElemId) {
		var targetEl= document.getElementById(targetElemId);
	
		if(targetEl.selectedIndex > -1) {
			var i=0;
			while (i < targetEl.options.length) {
				if(targetEl.options[i].selected) {
					targetEl.remove(i);
				}
				else {
					i++;
				}
			}
		}
	},
	
	selectAll : function(selectElemId) {
		var selectElem= document.getElementById(selectElemId);
		if(!selectElem) {
			return;
		}
		try {
			for(var i= 0; i < selectElem.options.length; i++) {
				selectElem.options[i].selected= true;
			}
		} catch (err) {}
	},
	
	addNewCategory : function(id) {
		level = document.getElementById(id+"_level").value;
		alias = document.getElementById(id+"_alias").value;
		category = document.getElementById(id+"_category").value;		
		language = document.getElementById(id+"_language").value;
		if (!alias.match("^[+a-zA-Z0-9_-]+$")) {
			alert("Alias is required and must contain letters, digits and _, -, +.");
		} 
		else if (level && alias && category && language) {
			DynamicTagCreator.createCategory(level, alias, language, category,{callback: function(catId) { finishAdd(id, category, catId); }});
		}
		else {
			alert("Please enter an alias, a name and chose a language.");
		}
	}
};
function finishAdd(id, category, catId) {
	var selectEl= document.getElementById(id+'_availableTags');
	var targetEl= document.getElementById(id);
	var newOption= document.createElement("option");
	newOption.text= category;
	newOption.value= catId;
	newOption.selected= true;
	targetEl.options.add(newOption);
	newOption= document.createElement("option");
	newOption.text= category;
	newOption.value= catId;
	newOption.selected= false;
	selectEl.options.add(newOption);
}

var TokenTopicAutosuggest = {
	availableTags : [],
	split : function(val) {
		return val.split( /,\s*/ );
	},
	extractLast : function(term) {
		var x = this.split(term).pop();
		return x;
	},

	init : function(elementId) {
		var containerId = jQuery("#" + elementId).parent()[0].id; 
		jQuery( "#" + elementId )
		// don't navigate away from the field on tab when selecting an item
		.bind( "keydown", function( event ) {
			if ( event.keyCode === jQuery.ui.keyCode.TAB &&
					jQuery( this ).data( "autocomplete" ).menu.active ) {
				event.preventDefault();
			}
		})
		.autocomplete({
			source: function( request, response ) {
				// delegate back to autocomplete, but extract the last term
				response( jQuery.ui.autocomplete.filter(
					TokenTopicAutosuggest.filterOutUsed(), TokenTopicAutosuggest.extractLast( request.term ) ) );
			},
			focus: function() {
				// prevent value inserted on focus
				return false;
			},
			select: function( e, ui ) {
				var topicName = ui.item.label,
					span = jQuery("<span>").text(topicName),
					a = jQuery("<a>").addClass("remove").attr({
						href: "javascript:",
						title: "Remove " + topicName
					}).text("x").appendTo(span),
					hidden = jQuery("<input type='hidden' class='autocompleteData' name='topicId'>").val(ui.item.value).appendTo(span);
				
				span.insertBefore("#" + elementId);
				TokenTopicAutosuggest.updateCompleteTags();
				TokenTopicAutosuggest.findTopicById(ui.item.value)["alreadyAdded"] = "true";
				// a topic has been selected 
				this.topicSelected = true;
			},
			change: function() {
				//prevent 'topics' field being updated and correct position
				jQuery("#" + elementId).val("").css("top", 2);
			},
			close: function() {
				// if there was a topic selected, clear the input field (to remove the id that's inserted by the autocomplete) 
				if(this.topicSelected) {
					jQuery("#" + elementId).val("").css("top", 2);
					this.topicSelected = false;
				}
			}
		});
		jQuery("#" + containerId).click(function(){
			//focus 'topics' field
			jQuery("#" + elementId).focus();
		});
		//add live handler for clicks on remove links
		jQuery(".remove", document.getElementById(containerId)).live("click", function(){
			//remove topic
			jQuery(this).parent().remove();
			//correct 'topics' field position
			if(jQuery("#" + containerId + " span").length === 0) {
				jQuery("#" + elementId).css("top", 0);
			}
			var elemId = jQuery(this).parent().children().last().val();
			TokenTopicAutosuggest.findTopicById(elemId)["alreadyAdded"] = "";
			TokenTopicAutosuggest.updateCompleteTags();
		});
	},
	filterOutUsed : function() {
		var availableTagsFiltered = [];
		for(var i=0;i<this.availableTags.length;i++) {
			if(this.availableTags[i]["alreadyAdded"] != "true") {
				availableTagsFiltered.push(this.availableTags[i]);
			}
		}
		return availableTagsFiltered;
	},
	findTopicById : function(id) {
		for(var i=0;i<this.availableTags.length;i++) {
			if(this.availableTags[i].value == id) {
				return this.availableTags[i];
			}
		}
	},
	updateCompleteTags : function() {
		if(jQuery(".autocompleteData").length == 0) {
			jQuery("#contentTagList").html("");
			return;
		}
		
		var allTopics = "";
		var idList = [];
		var ids = "";
		jQuery(".autocompleteData").each(function(index) {
			if(index > 0) {
				ids += ",";
			}
			ids += jQuery(this).val();
			idList[index] = jQuery(this).val();
			if(index > 0) {
				allTopics += ",";
			}
			allTopics += " " + TokenTopicAutosuggest.findTopicById(idList[index]).label; 
		});
		jQuery("#contentTagList").html(allTopics);

		jQuery.ajax({
			url: "/mag4media/api/topicManager!getTagListForIds.action",
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			type: 'POST',
			data: {"idList" : ids},
			success: function(data) {
				var allTopics = jQuery("#contentTagList").html();
				for(var i=0;i<data.length;i++) {
					if((jQuery.inArray(data[i].id + "", idList) < 0) && (TokenTopicAutosuggest.findTopicById(data[i].id))) {
						allTopics += "," + TokenTopicAutosuggest.findTopicById(data[i].id).label; 
						jQuery("#contentTagList").html(allTopics);
					}
				}
			}
		});
	},
	
	addNewCategory : function(id) {
		level = document.getElementById(id+"_level").value;
		alias = document.getElementById(id+"_alias").value;
		category = document.getElementById(id+"_category").value;
		language = document.getElementById(id+"_language").value;
		if (!alias.match("^[+a-zA-Z0-9_-]+$")) {
			alert("Alias is required and must contain letters, digits and _, -, +.");
		} 
		else if (level && alias && category && language) {
			DynamicTagCreator.createCategory(level, alias, language, category,{callback: function(catId) {
				TokenTopicAutosuggest.availableTags.push( {value:catId,label:category} ) 
				document.getElementById(id+"_alias").value = "";
				document.getElementById(id+"_category").value = "";
				jQuery('#newTopic_div').toggle('fast');
			}});
		}
		else {
			alert("Please enter an alias, a name and chose a language.");
		}
	}
	
		
}

