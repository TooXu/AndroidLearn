package com.example.xzr.networkpractice;

/**
 * Created by xzr on 2019/1/10.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}


