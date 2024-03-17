function dowork(x:number,y:number):number{
    return x+y;

}
let result=dowork(10,20);
console.log(result);
let sum=function(x:number,y:number):number{
    return x+y;
}
let value=sum(30,20);
console.log(value);
function greeting(msg:string,name:string):string{
    return name+" :"+msg;
}
let greetMsg=greeting("Good Afternoon","Mano");
console.log(greetMsg);
function greet(msg:string,...uname:string[]){
 console.log(msg+" "+uname.join(","));
}
greet("mano","pandu","maha","krish","raji","kiruthu");