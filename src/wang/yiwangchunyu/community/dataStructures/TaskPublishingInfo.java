package wang.yiwangchunyu.community.dataStructures;

import java.util.Date;
import java.util.List;

/**
 * Created by yiwangchunyu on 2018/3/9.
 */

public class TaskPublishingInfo {
    private String publishId;
    private String userId;
    private String restriction;
    private String category;
    private String title;
    private String content;
    private int commission;
    private int viewed;
    private int liked;
    private Date publish_time;
    private String code;//状态码 0：正常
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String  getRestriction(){ return restriction ;}

    public void setRestriction(String restriction){ this.restriction = restriction; }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
