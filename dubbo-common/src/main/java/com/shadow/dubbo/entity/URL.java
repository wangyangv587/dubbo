package com.shadow.dubbo.entity;

import java.io.Serializable;

/**
 * @author Shadow
 * @date 2021/01/29 00:06:35
 */
public class URL implements Serializable {

    private String hostName;

    private Integer port;

    public URL() {
    }

    public URL(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
