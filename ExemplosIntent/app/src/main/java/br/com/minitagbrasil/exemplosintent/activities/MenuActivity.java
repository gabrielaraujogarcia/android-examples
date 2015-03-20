package br.com.minitagbrasil.exemplosintent.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by ggarcia on 17/03/15.
 */
public class MenuActivity extends ListActivity {

    //constante para identificar a activity sim nao
    private static final int ACTIVITY_YES_NO = 1;

    private final String[] options = new String[] {
        "Abrir URL",
        "Ligar para um telefone",
        "Exibir contato da agenda",
        "Selecionar contato da agenda",
        "Retornar valores da activity criada",
        "Sair"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //cria o ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, options);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent it = null;
        boolean skip = false;

        switch (position){

            case 0:

                it = new Intent(this, ExampleOpenBrowser.class);
                break;

            case 1:

                it = new Intent(this, ExampleCallTelephone.class);
                break;

            case 2:

                it = new Intent(this, ExampleShowPhoneBookContact.class);
                break;

            case 3:

                it = new Intent(this, ExamplePickPhoneBookContact.class);
                break;

            case 4:

                //para nao abrir a activity duas vezes
                skip = true;

                it = new Intent(this, ExampleReturnResultFromCustomActivity.class);

                //inicia uma nova activity e aguarda o retorno da mesma
                startActivityForResult(it, ACTIVITY_YES_NO);
                break;

            default:
                Log.i("BLABLABLABLABLA ---- > ", "Encerrando a aplicacao a pedido do usuario");
        }

        if(!skip){

            if(it != null){
                startActivity(it);
            } else {
                finish();
            }

        }

    }

    /**
     * Metodo para trarar o retorno de uma chamada startActivityFromResult
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //checa se o codigo da requisicao e o mesmo codigo que enviamos no startActivityForResult
        //quando requisitamos a tela ExampleReturnFromCustomActivity
        if(requestCode == ACTIVITY_YES_NO){

            Bundle bundle = data != null ? data.getExtras() : null;

            if(bundle != null) {

                String msg = bundle.getString("msg");

                //codigo adicionado no setResult da classe ExampleReturnFromCustomActivity
                if(resultCode == 1) {
                    //sim
                    Toast.makeText(this, "Escolheu sim! "+msg, Toast.LENGTH_LONG).show();
                } else if (resultCode == 2){
                    //nao
                    Toast.makeText(this, "Escolheu não! "+msg, Toast.LENGTH_LONG).show();
                } else {
                    //cancelado talvez..
                    Toast.makeText(this, "Não definido: "+msg, Toast.LENGTH_LONG).show();
                }

            }

        }
    }
}
