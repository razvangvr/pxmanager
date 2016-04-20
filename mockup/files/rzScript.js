function showPersonaPercentInput(control, alias){
    //
    var checked = control.checked;
    if(checked){
        $('#'+alias).show();
    }else{
        $('#'+alias).hide();
    }
}

function onLoadShowPersonaPercentInput(){
    // var checked = $("."+'persona'+" > input").is(":checked").;
    var checked = $("."+'persona'+" > input:checkbox").each(function(){
        var checked = this.checked;
        var parent = $( this).parent();
        var elem = $(parent).find('.PersonaPercentInput');
        if(checked){
            //$('.persona > .PersonaPercentInput').show();
            elem.show();
        }else{
            //$('.persona > .PersonaPercentInput').hide();
            elem.hide();
        }
    });

}

function showNowSlot(){
    $('#'+'newSlot').show();
}