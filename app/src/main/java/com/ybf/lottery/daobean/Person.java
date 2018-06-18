package com.ybf.lottery.daobean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/6/18.
 */

@Entity
public class Person {

    @Id(autoincrement = true)
    private Long pId;
    private String source;
    @NotNull
    private String url;
    @Generated(hash = 1239199159)
    public Person(Long pId, String source, @NotNull String url) {
        this.pId = pId;
        this.source = source;
        this.url = url;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public Long getPId() {
        return this.pId;
    }
    public void setPId(Long pId) {
        this.pId = pId;
    }
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer("Person{ ");
        sb.append("pId= " + pId);
        sb.append(",source= " + source);
        sb.append(",url= " + url);
        sb.append(" }");
        return sb.toString();
    }
}
