package com.sinam7.booksage.tool;

import java.io.UnsupportedEncodingException;

public class Encoder {

    public static String encode(String raw, String from, String to) {
        try {
            return new String(raw.getBytes(from), to);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
