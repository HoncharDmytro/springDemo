package com.honchar.springDemo.chapter03.decoupled;

import com.honchar.springDemo.chapter02.decoupled.MessageProvider;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
