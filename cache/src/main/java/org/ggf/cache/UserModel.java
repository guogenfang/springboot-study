package org.ggf.cache;

import java.io.Serializable;

public class UserModel implements Serializable {

    private Integer id;

    private String name;

    public UserModel() {
    }

    public UserModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "org.ggf.cache.UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
