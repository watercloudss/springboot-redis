package com.lly.annotation;

/**
 * @Author: lly
 * @Date: 2020/10/3
 * @Description:
 */
public class People {
    @FieldAnno(columnName = "name",type = "varchar",length = 10)
    private String name;
    @FieldAnno(columnName = "age",type = "int",length = 10)
    private int age;
    @FieldAnno(columnName = "sex",type = "varchar",length = 10)
    private String sex;

    public People() {
    }

    public People(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
