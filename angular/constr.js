var user = /** @class */ (function () {
    function user(userid, username) {
        this.userid = userid;
        this.username = username;
    }
    return user;
}());
var users = new user(11, "mano");
console.log(users.userid + " " + users.username);
