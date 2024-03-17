class user
{
    userid:number;
    username:string;
    constructor(userid:number,username:string)
    {
        this.userid=userid;
        this.username=username;
    }
}
let users=new user(11,"mano");
console.log(users.userid+" "+users.username);