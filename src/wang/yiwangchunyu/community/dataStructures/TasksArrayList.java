package wang.yiwangchunyu.community.dataStructures;

import java.util.List;

/**
 * Created by yiwangchunyu on 2018/3/22.
 */

public class TasksArrayList {
    String ret;
    String code;
    String msg;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private List<TasksShowOnIndex> tasks;

    public List<TasksShowOnIndex> getTasks() {
        return tasks;
    }

    public void setTasks(List<TasksShowOnIndex> tasks) {
        this.tasks = tasks;
    }

    public TasksArrayList(List<TasksShowOnIndex> tasks) {
        this.tasks = tasks;
    }
}
