function dowork(x, y) {
    return x + y;
}
var result = dowork(10, 20);
console.log(result);
var sum = function (x, y) {
    return x + y;
};
var value = sum(30, 20);
console.log(value);
function greeting(msg, name) {
    return name + " :" + msg;
}
var greetMsg = greeting("Good Afternoon", "Mano");
console.log(greetMsg);
function greet(msg) {
    var uname = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        uname[_i - 1] = arguments[_i];
    }
    console.log(msg + " " + uname.join(","));
}
greet("mano", "pandu", "maha", "krish", "raji", "kiruthu");
