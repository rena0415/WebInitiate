package com.rena.wi.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * description
 *
 * @author rena
 * @date 2018/11/11 23:18
 **/
public class IOCloseUtil {

    private IOCloseUtil(){}

    public static void close(Closeable closeable){
        if (closeable != null){
            try {
                closeable.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

