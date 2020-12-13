package com.wiceflow.note.learn.service.handler;

import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BF
 * @date 2020/12/10 16:41
 */
public class BufToMessageDecoder extends ChannelInboundHandlerAdapter {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("stringTest");

        Object o = list;

        String str = (String) o;
        System.out.println(str);
    }

}


