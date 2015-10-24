function initDialog() {
  $("#idOfDialogPlaceHolder").dialog({
     modal: true,
     buttons: {
            SaveNew: function () {
                $("#justAButton").click();
            },
            Close: function () {
                $(this).dialog("close");
            }
     },
 });
}

function initNewServiceDialog() {
	  $("#InitNewServiceDialog").dialog({
	     modal: true,
	     buttons: {
	            Save: function () {
	                $("#saveButton").click();
	            },
	            Close: function () {
	                $(this).dialog("close");
	            }
	     },
	 });
}