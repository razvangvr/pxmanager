var ResourceElement = {
	createResource : function() {
		var addBtn = document.getElementById('resourceAddButton');
		var modelEl = document.getElementById('resourceTemplate');
		var parentElem = modelEl.parentNode;
		var newFieldSet = document.createElement("fieldset");
		for(var i = 0; i < modelEl.childNodes.length; i++) {
			newFieldSet.appendChild(modelEl.childNodes[i].cloneNode(true));
		}
		parentElem.insertBefore(newFieldSet, addBtn);
	},
	
	deleteResource : function(btnElem, parentElementType) {
		var table = ResourceElement.findParentElement(btnElem, parentElementType);
		if (table == "undefined") {
			alert("Cannot find parent table to delete!");
			return;
		}
		
		var parentElem = table.parentNode;
		var enclosingElem = parentElem.parentNode;
		enclosingElem.removeChild(parentElem);
	},
	
	updateResourceRef : function(element) {
		var table = ResourceElement.findParentElement(element, 'TABLE');
		if (table == "undefined") {
			return;
		}
		
		table.rows[1].cells[0].appendChild(document.createTextNode("Resource: " + element.value));
	},
	
	updateResource : function(element, target) {
		var targetElement = document.getElementById(target);
		
		if (targetElement) {
			targetElement.innerHTML = "Path: " + element.value;
		}
	},
	
	updateResourceValue : function(value, target) {
		var targetElement = document.getElementsByName(target);
		if (targetElement) {
			for(i=0; i< targetElement.length; i++){
				targetElement[i].value = value;
			}
		}
	},
	
	findParentElement : function(element, parentElementType) {
		var parentElem = element.parentNode;
		
		while (parentElem && parentElem.nodeName != parentElementType) {
			parentElem = parentElem.parentNode;
		}
		
		return parentElem;
	},
	
	showBlock : function(elementOrId) {
		var elem= ResourceElement.getElement(elementOrId);
		if (elem && elem.style) {
			elem.style.display = "block";
		}
	},
	
	showInline : function(elementOrId) {
		var elem= ResourceElement.getElement(elementOrId);
		if (elem && elem.style) {
			elem.style.display = "inline";
		}
	},
	
	hide : function(elementOrId) {
		var elem= ResourceElement.getElement(elementOrId);
		if (elem && elem.style) {
			elem.style.display = "none";
		}
	},
	
	toggleInline : function(elementOrId) {
		var elem= ResourceElement.getElement(elementOrId);
		if (elem && elem.style) {
			if (elem.style.display == "none") {
				elem.style.display = "inline";
			}
			else {
				elem.style.display = "none";
			}
		}
	},
	
	toggleBlock : function(elementOrId) {
		var elem= ResourceElement.getElement(elementOrId);
		if (elem && elem.style) {
			if (elem.style.display == "none") {
				elem.style.display = "block";
			}
			else {
				elem.style.display = "none";
			}
		}
	},
	
	deleteElement : function(elementOrId) {
		var elem= this.getElement(elementOrId);
		if (elem && elem.parentNode) {
			var parent = elem.parentNode;
			parent.removeChild(elem);
		}
	},
	
	getElement : function(elementOrId) {
		// alert("getElement: " + elementOrId);
		var elem;
		if (typeof elementOrId == "undefined") {
			return;
		}
		else if (typeof elementOrId == "string") {
			elem = document.getElementById(elementOrId);
		}
		else {
			elem = elementOrId;
		}
		
		return elem;
	},
	
	suggestUrl : function(elementOrId, targetElementOrId) {
		var srcelem= ResourceElement.getElement(elementOrId);
		var targetelem= ResourceElement.getElement(targetElementOrId);
		if(!srcelem || !targetelem) {
			return;
		}
		if(srcelem.value && srcelem.value != "") {
			if(!(targetelem.readOnly || targetelem.disabled)) {
				targetelem.value= srcelem.value.replace(/[ :'\"\?#]/g, "-");
			}
		}
	},
	
	/** 
	 * returns an array of all elements that are named: name[index] 
	 * Note: DOESN'T WORK WELL IN IE WITH DYNAMIC CREATED ELEMENTS
	 */
	getElementsByIndexedName : function(name) {
		var fieldsArray = new Array();
		for (var i =0 ;  i <= itemIndex; i++) {
			var fields = document.getElementsByName(name + "[" + i + "]");
			if (fields != null) {
				for(var idx = 0; idx < fields.length; idx++) {
					fieldsArray.push(fields[idx]);
				}
			}
		}
		
		return fieldsArray;
	},
	
	/** 
	 * returns an array of all elements that are named: name[index] 
	 */
	getTypedElementsByIndexedName : function(tagName, name) {
		var fieldsArray = new Array();
		var typedElements= document.getElementsByTagName(tagName);
		for(var i= 0; i < typedElements.length; i++) {
			if(typedElements[i].name && typedElements[i].name.match(name)) {
				if(typedElements[i].name.charAt(name.length) == '[') {
					fieldsArray.push(typedElements[i]);
				}
			}
		}
		
		return fieldsArray;
	},
	
	createIndexedResource : function(aboveElemId, templateElementId) {
		itemIndex++;
		var addBtn = document.getElementById(aboveElemId);
		var modelEl = document.getElementById(templateElementId);
		var parentElem = modelEl.parentNode;
		var newFieldSet = document.createElement("fieldset");
		  			  
		for(var i = 0; i < modelEl.childNodes.length; i++) {
			newFieldSet.appendChild(modelEl.childNodes[i].cloneNode(true));				
		}
		    
		this.addIndex(newFieldSet, itemIndex);		   
		parentElem.insertBefore(newFieldSet, addBtn);
	},

	addIndex : function(enclosingElem, elemIndex) {
	  	var inputFields = enclosingElem.getElementsByTagName('input');
	  	for (var i = 0 ; i < inputFields.length; i++) {
	  		this.appendIndex(inputFields[i], elemIndex);
	  		if (inputFields[i].name.length > 0) {
  	  			inputFields[i].id = inputFields[i].name.replace(/[\[\]]/g,'_');
			}
		}
		inputFields = enclosingElem.getElementsByTagName('textarea');
	  	for (var i = 0 ; i < inputFields.length; i++) {
	  		this.appendIndex(inputFields[i], elemIndex);
	  		if (inputFields[i].name.length > 0) {
  	  			inputFields[i].id = inputFields[i].name.replace(/[\[\]]/g,'_');
			}
		}
		inputFields = enclosingElem.getElementsByTagName('select');
	  	for (var i = 0 ; i < inputFields.length; i++) {
	  		this.appendIndex(inputFields[i], elemIndex);
	  		if (inputFields[i].name.length > 0) {
  	  			inputFields[i].id = inputFields[i].name.replace(/[\[\]]/g,'_');
			}
		}
	},
    	       	   
   	appendIndex : function(elem, elemIndex) {
		if (elem.type=="button") {
			return;
		}
    	var name = elem.name;
    	var pos = name.indexOf("[");
    	if (pos > 0) {
			name = name.substring(0, pos);
    	}
		name = name + "[" + elemIndex + "]";
		elem.name = name;
	},
        checkFileSelect: function (evt, imagePathLabel) {
            var files = evt.target.files;
            if (!files[0].type.match('image.jpeg')) {
                alert(jpgOnlyMsg);
                var oldInput = evt.target;
                oldInput.parentNode.replaceChild(oldInput.cloneNode(), oldInput);
                var pathLabel = document.getElementById(imagePathLabel);
                if(pathLabel) pathLabel.innerHTML = "";
            }
        }
};