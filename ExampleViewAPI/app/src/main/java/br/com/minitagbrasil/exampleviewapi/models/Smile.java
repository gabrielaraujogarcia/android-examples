package br.com.minitagbrasil.exampleviewapi.models;

import br.com.minitagbrasil.exampleviewapi.R;

/**
 * Created by ggarcia on 19/05/15.
 */
public class Smile {

    private final int type;

    public static final int HAPPY = 0;
    public static final int SAD = 1;
    public static final int CRAZY = 2;

    public String name;

    public Smile(String name, int type){
        this.name = name;
        this.type = type;
    }

    public int getImage() {

        switch (type){
            case HAPPY:
                return R.drawable.smile_happy_32x32;
            case CRAZY:
                return R.drawable.smile_crazy_32x32;
            case SAD:
                return R.drawable.smile_sad_32x32;
        }

        return R.drawable.allien_32x32;
    }
}
