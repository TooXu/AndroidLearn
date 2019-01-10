package com.example.xzr.networkpractice;

/**
 * Created by xzr on 2019/1/10.
 */

public class ShareInfo {
//    {
//        "show_style": "icon",
//            "text": "更多",
//            "icon": "xxxxxxx.jpg",
//            "action": "more",
//            "need_login": "2",
//            "target": "",
//            "target_val": ""
//    }

    private String show_style;
    private String icon;
    private String text;
    private String action;
    private String need_login;

    public String getShow_style() {
        return show_style;
    }

    public void setShow_style(String show_style) {
        this.show_style = show_style;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNeed_login() {
        return need_login;
    }

    public void setNeed_login(String need_login) {
        this.need_login = need_login;
    }
}
