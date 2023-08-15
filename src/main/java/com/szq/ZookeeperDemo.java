package com.szq;

import java.util.List;

public class ZookeeperDemo {
    public static void main(String[] args) throws Exception {
        //创建连接
        BaseZookeeper baseZookeeper = new BaseZookeeper();
        //创建客户端   windows电脑上先配置了  hosts
        baseZookeeper.connectZookeeper("node101:2181,node102:2181,node103:2181");
        //创建节点
        baseZookeeper.createNode("/yjx", "444");
        baseZookeeper.createNode("/yjx/node" + Math.random(), "666");
        //查看节点
        String data = baseZookeeper.getData("/yjx");
        System.out.println(data);
        //查看子节点
        List<String> list = baseZookeeper.getChildren("/yjx");
        System.out.println(list);
        //查看创建时间
        String time = baseZookeeper.getCTime("/yjx");
        System.out.println(time);
        //删除节点
        // baseZookeeper.deleteNode("/yjx/bd");
        //关闭连接
        baseZookeeper.closeConnection();
    }
}
