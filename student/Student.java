package com.PPlabs.lr2.student;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private Date dateBirth;
    private String address;
    private String phoneNum;
    private String faculty;
    private byte course;
    private String group;

    public Student() {
    }

    public Student(int id, String name, String dateBirth, String address, String phoneNum, String faculty, byte course, String group) {
        this.id = id;
        this.name = name;
        this.dateBirth =  new Date(dateBirth);
        this.address = address;
        this.phoneNum = phoneNum;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getYearBirth() {
        return dateBirth.year;
    }

    public void setDateBirth(String date) {
        this.dateBirth = new Date(date);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public byte getCourse() {
        return course;
    }

    public void setCourse(byte course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String toString() {
        return id+"\t"+name+"\t"+ dateBirth.day+"/"+ dateBirth.month+"/"+ dateBirth.year+"\t"+address+"\t"+phoneNum+"\t"+faculty+"\t"+course+"\t"+group+"\n";
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }

    private class Date{
        private byte day;
        private byte month;
        private short year;

        public Date(byte day, byte month, short year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public Date(String s){
            try{
                String[] dateApart = s.split("/", -2);
                this.day = Byte.parseByte(dateApart[0]);
                this.month = Byte.parseByte(dateApart[1]);
                this.year = Short.parseShort(dateApart[2]);
            }
            catch (Exception error){
                System.out.println("Incorrectly entered data! Error - "+error.toString());
            }

        }

        public short getYear() {
            return year;
        }
    }
}
