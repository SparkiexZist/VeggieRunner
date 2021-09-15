function incrementValue(vegetable)
{
    var value = parseInt(document.getElementById(vegetable).value, 10);
    if(value >= 0)
        value = value+1;
    document.getElementById(vegetable).value = value;
}
function decrementValue(vegetable)
{
    var value = parseInt(document.getElementById(vegetable).value, 10);
    if(value >= 1)
        value = value-1;
    document.getElementById(vegetable).value = value;
}

function createId(){
    var d = new Date();
    var n = d.toString();
    document.getElementById(history_idInput).value = n;
}