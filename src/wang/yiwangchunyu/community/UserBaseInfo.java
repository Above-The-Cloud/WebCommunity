package wang.yiwangchunyu.community;

import java.io.Serializable;

/**
 * @author
 *
 * 瑙ｆ瀽鑾峰彇鐢ㄦ埛鍩烘湰淇℃伅
 */
public class UserBaseInfo implements Serializable{

//	 {"ret":"0","errcode":"0","msg":"鎺ュ彛璋冪敤鎴愬姛","nickname":"erom","userhead":"/img/users/head/avatar.png",
//	"userid":"11653","email":"123456789@qq.com","role":"0"}
	private String userid;//鐢ㄦ埛id
	private String nickname;//鏄电О
	private String userhead;//鐢ㄦ埛澶村儚璺緞 
	private String email;//鐢ㄦ埛閭欢
	private String ret;//璇锋眰鐘舵�佺爜  0锛氭甯革紝 1锛氱敤鎴蜂笉瀛樺湪
	private String errcode;//閿欒鐮�
	private String msg;
	
	private String role;// 0:管理员， 1：非管理员
	
	
	
	
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserhead() {
		return userhead;
	}
	public void setUserhead(String userhead) {
		this.userhead = userhead;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
 

}
