package com.kevin.thinking.in.spring.ioc.overview.domian;

/**
 * @Author kevin
 * @Description 实体类对象
 * @Date Created on 2020/3/4 11:01
 */
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static User createUser(){
        User kevin = new User();
        kevin.setId(100L);
        kevin.setName("kevin-100");
        return  kevin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
