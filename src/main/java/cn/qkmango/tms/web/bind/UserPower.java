package cn.qkmango.tms.web.bind;

public enum UserPower {
    student,
    teacher,
    admin
}


class Main{
    public static void main(String[] args) {
        System.out.println(UserPower.student.ordinal());
    }
}