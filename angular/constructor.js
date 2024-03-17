var Student = /** @class */ (function () {
    function Student() {
    }
    Student.prototype.getstudentgrade = function () {
        if (this.studentmarks >= 75) {
            return "A";
        }
        else if (this.studentmarks >= 65 && this.studentmarks < 60) {
            return "B";
        }
        else {
            return "C";
        }
    };
    return Student;
}());
var s1 = new Student();
s1.studentmarks = 80;
s1.studentname = "mano";
s1.sudentrank = 1;
console.log(s1.getstudentgrade());
