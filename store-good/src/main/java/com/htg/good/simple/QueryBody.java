package com.htg.good.simple;

public class QueryBody {
    private String name;
    private String value;


    public QueryBody() {
    }

    public QueryBody(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "QueryBody{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
