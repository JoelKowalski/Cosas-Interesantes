package com.example.vale.tag;

/**
 * Created by Usuario on 28/06/2016.
 */
public class Estado {
    private boolean[] caps = new boolean[s_dummyItems.length];
    public void setCaps(int position,boolean b) {
        if (position < caps.length) {
            caps[position] = b;
        }
    }

    public boolean isCaps(int position) {
        return caps[position];
    }
     static final String[] s_dummyItems = new String[30];


}

