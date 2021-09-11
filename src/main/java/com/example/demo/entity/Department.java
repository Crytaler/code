package com.example.demo.entity;

import com.alibaba.fastjson.JSON;
import com.example.demo.dto.ResultDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName Department
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/8/20 下午10:13
 * @Version 1.0
 **/
public class Department {


    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                '}';
    }

    private Integer id;

    public Boolean getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    private String name;

    private Integer parentId;

    private Boolean hasPermission;

    private Long count;

    private List<Department> children = new ArrayList<>();

    public Department(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }


    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.add(9);
        list.add(11);

        List<ResultDto> dtos = Lists.newArrayList();

        Result result = new Result();
        result.setId(1);
        result.setCount(99L);;

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department(1, "白胡子", 0));
        departmentList.add(new Department(2, "不死鸟", 1));
        departmentList.add(new Department(3, "艾斯", 1));
        departmentList.add(new Department(4, "龙", 0));
        departmentList.add(new Department(5, "路飞", 4));
        departmentList.add(new Department(6, "索隆", 5));
        departmentList.add(new Department(7, "娜美", 5));
        departmentList.add(new Department(8, "罗宾", 5));
        departmentList.add(new Department(9, "乌索普", 5));
        departmentList.add(new Department(10, "小丑", 100));//小丑的长官Id不存在，所以tree中没有它的信息
        departmentList.add(new Department(11, "不死鸟", 9));
        departmentList.add(new Department(12, "艾斯", 9));

        List<Department> tree = makeTree(departmentList, 0, list);
        Department department = tree.get(1);
        List<Department> departments = initToShowMenus(department, list);
//        dfs(department,list);
//        dfs1(department);
        System.out.println("-------------------------->" + JSON.toJSONString(departments.get(0)));
    }

    private static List<Department> makeTree(List<Department> departmentList, Integer pId, List<Integer> list) {

        //子类
        List<Department> children = departmentList.stream().filter(x -> x.getParentId() == pId).collect(Collectors.toList());
        //后辈中的非子类
        List<Department> successor = departmentList.stream().filter(x -> x.getParentId() != pId).collect(Collectors.toList());
        children.forEach(x ->
                {
                    makeTree(successor, x.getId(), list).forEach(
                            y -> x.getChildren().add(y));
                }
        );
        return children;
    }
    public static Department dfs(Department department, List<Integer> list) {
        boolean contains = list.contains(department.getId());
        department.setHasPermission(contains);
        if (CollectionUtils.isNotEmpty(department.getChildren())) {
            for (Department child : department.getChildren()) {
                dfs(child,list);
            }
        }
        return department;
    }
    public static Department dfs1(Department department) {
        if (department == null || !Objects.equals(true,department.getHasPermission())) {
            return null;
        }
        if (CollectionUtils.isNotEmpty(department.getChildren())) {
            department.getChildren().removeIf(depart ->!Objects.equals(true,depart.getHasPermission()));
            for (Department child : department.getChildren()) {
                dfs1(child);
            }
        }
        return department;
    }




    /**
     * 树数据拷贝，去掉不满足条件的叶子节点信息
     * @param treeNodes
     * @param permissions
     * @return
     */
    public static List<Department> initToShowMenus(Department treeNodes, List<Integer> permissions) {
        List<Department> newTreeNodes =new ArrayList<>();
//        for (Department treeNode : treeNodes) {
            Department nNode = copy(treeNodes,permissions);
            newTreeNodes.add(nNode);
//        }
        return newTreeNodes;
    }

    public static Department copy(Department node,List<Integer> permissions) {
        Department nNode = new Department();
        if (node.getChildren().size() == 0 && !permissions.contains(node.getId())) {
            System.out.println("没有查看权限的菜单：" + node.getName());
            return null;
        } else {
            nNode.setId(node.getId());
            nNode.setName(node.getName());
            nNode.setParentId(node.getParentId());
            nNode.setName(node.getName());
            List<Department> list = new ArrayList<>();
            if (node.getChildren().size() > 0) {
                for (int i = 0; i < node.getChildren().size(); i++) {
                    Department theNode = copy(node.getChildren().get(i), permissions);
                    if (theNode == null) {
                        continue;
                    } else {
                        list.add(theNode);
                    }
                }
            }
            nNode.setChildren(list);
            return nNode;
        }

    }
}
//private static List<Department> getThree(List<Department> list,int parentId,List<Long> list1){
//    //获取所有子节点
//    List<Department> childTreeList = getChildTree(list,parentId,list1);
//    for (Department dept:childTreeList) {
//        dept.setChildren(getThree(list,dept.getId(),list1));
//    }
//    return childTreeList;
//}
//
//    private static List<Department> getChildTree(List<Department> list,int id,List<Long> list1){
//        List<Department> childTree = new ArrayList<>();
//        for (Department dept:list) {
//            if(dept.getParentId() == id){
//                if (list1.contains(Long.valueOf(dept.getId()))) {
//                    childTree.add(dept);
//                }
//            }
//        }
//        return childTree;
//    }
//}
