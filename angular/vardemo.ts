var petname:string="dog";

function setpetname(){
    var petname:string ="cat";
    console.log("inside funtion "+petname);
}

setpetname();
console.log("outsode function "+petname);

var index=0;
for(var index=0;index<=5;index++)
{
    console.log("index value inside loop"+index);
}
console.log("index value outside loop"+index);
var index=0;
for(let index=0;index<=5;index++)
{
    console.log("index value inside loop"+index);
}
console.log("index value outside loop"+index);