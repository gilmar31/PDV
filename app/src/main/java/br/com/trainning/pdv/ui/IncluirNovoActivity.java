package br.com.trainning.pdv.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

import br.com.trainning.pdv.R;
import br.com.trainning.pdv.domain.model.Produto;
import butterknife.Bind;
import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.Query;

public class IncluirNovoActivity extends BaseActivity {

    @Bind(R.id.editText_descricao)
    EditText descricao;

    @Bind(R.id.editText_unidade)
    EditText unidade;


    @Bind(R.id.editText_codigo_barras)
    EditText codigoBarras;

    @Bind(R.id.editText_preco)
    EditText preco;


    @Bind(R.id.imageButton_camera)
    ImageButton botaoCamera;

    @Bind(R.id.imageButton_galeria)
    ImageButton botaoGaleria;


    @Bind(R.id.imageView_foto)
    ImageView foto;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir_novo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Produto produto = new Produto();
                produto.setId(0L);
                produto.setDescricao(descricao.getText().toString());
                produto.setUnidade(unidade.getText().toString());
                produto.setCodigoBarras(codigoBarras.getText().toString());
                produto.setPreco(Double.parseDouble(preco.getText().toString()));
                produto.setFoto("Teste");
                produto.setAtivo(1);

                produto.save();

                Log.d("INCLUIRNOVO", produto.toString());

                CursorList cursor = Query.all(Produto.class).get();
                List<Produto> lista = cursor.asList();

                for(Produto p3: lista){
                    Log.d("INCLUIRNOVO",""+p3.toString());
                }
                finish();
            }
        });
    }
}