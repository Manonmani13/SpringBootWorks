var petname = "dog";
function setpetname() {
    var petname = "cat";
    console.log("inside funtion " + petname);
}
setpetname();
console.log("outsode function " + petname);
var index = 0;
for (var index = 0; index <= 5; index++) {
    console.log("index value inside loop" + index);
}
console.log("index value outside loop" + index);
var index = 0;
for (var index_1 = 0; index_1 <= 5; index_1++) {
    console.log("index value inside loop" + index_1);
}
console.log("index value outside loop" + index);
