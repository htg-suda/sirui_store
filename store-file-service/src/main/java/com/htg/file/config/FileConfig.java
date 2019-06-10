package com.htg.file.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@ConfigurationProperties(prefix="file-context")
public class FileConfig {
    private String global_path;
    private String public_res;
    private String private_res;
    private Map<String,String> pub_res_map;

    public String getGlobal_path() {
        return global_path;
    }

    public void setGlobal_path(String global_path) {
        this.global_path = global_path;
    }

    public String getPublic_res() {
        return public_res;
    }

    public void setPublic_res(String public_res) {
        this.public_res = public_res;
    }

    public String getPrivate_res() {
        return private_res;
    }

    public void setPrivate_res(String private_res) {
        this.private_res = private_res;
    }

    public Map<String, String> getPub_res_map() {
        return pub_res_map;
    }

    public void setPub_res_map(Map<String, String> pub_res_map) {
        this.pub_res_map = pub_res_map;
    }

    @Override
    public String toString() {
        return "FileConfig{" +
                "global_path='" + global_path + '\'' +
                ", public_res='" + public_res + '\'' +
                ", private_res='" + private_res + '\'' +
                ", pub_res_map=" + pub_res_map +
                '}';
    }
}
