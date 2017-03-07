package com.ptteng.entity;

/**
 * Created by maweijiang on 2017/3/6.
 */
public class Student {
    private int id;
    private String stu_name;
    private long create_at;
    private long update_at;
    private String sign;
    private String stu_school;
    private String stu_introducer;
    private String url_head;
    private int course_type;
    private String company;
    private String person_introduce;
    private int good_status;
    private String password;
    private long phone;

    public int getId() {
        return id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public long getCreate_at() {
        return create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public String getSign() {
        return sign;
    }

    public String getStu_school() {
        return stu_school;
    }

    public String getStu_introducer() {
        return stu_introducer;
    }

    public String getUrl_head() {
        return url_head;
    }

    public int getCourse_type() {
        return course_type;
    }

    public String getCompany() {
        return company;
    }

    public String getPerson_introduce() {
        return person_introduce;
    }

    public int getGood_status() {
        return good_status;
    }

    public String getPassword() {
        return password;
    }

    public long getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setStu_school(String stu_school) {
        this.stu_school = stu_school;
    }

    public void setStu_introducer(String stu_introducer) {
        this.stu_introducer = stu_introducer;
    }

    public void setUrl_head(String url_head) {
        this.url_head = url_head;
    }

    public void setCourse_type(int course_type) {
        this.course_type = course_type;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPerson_introduce(String person_introduce) {
        this.person_introduce = person_introduce;
    }

    public void setGood_status(int good_status) {
        this.good_status = good_status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
