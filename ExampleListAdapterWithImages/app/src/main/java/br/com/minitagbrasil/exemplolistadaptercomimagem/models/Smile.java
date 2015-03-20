package br.com.minitagbrasil.exemplolistadaptercomimagem.models;

import br.com.minitagbrasil.exemplolistadaptercomimagem.R;

/**
 * Created by ggarcia on 16/03/15.
 */
public class Smile {

    private final int tipo;

    public static final int FELIZ = 0;
    public static final int TRISTE = 1;
    public static final int LOUCO = 2;

    public String nome;

    public Smile(String nome, int tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getImage() {

        switch (tipo) {
            case FELIZ:
                return R.drawable.smile_happy_32x32;
            case LOUCO:
                return R.drawable.smile_crazy_32x32;
            case TRISTE:
                return R.drawable.smile_sad_32x32;
        }

        return R.drawable.allien_32x32;
    }

}
