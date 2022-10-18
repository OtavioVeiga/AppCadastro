package com.example.appdecadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appdecadastro.database.DBHelper;

public class MainActivity extends AppCompatActivity {

    Button botaoProdutos;
    Button botaoClientes;
    Button botaoFornecedores;
    Button botaoSair;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper db = new DBHelper(MainActivity.this);

        botaoClientes = findViewById(R.id.botaoClientes);
        botaoSair = findViewById(R.id.botaoSair);
        botaoFornecedores = findViewById(R.id.botaoFornecedores);
        botaoProdutos = findViewById(R.id.botaoProdutos);

        acoesComponentes();
    }

    private void acoesComponentes() {
        botaoProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("operacao", 0);

                startActivity(intent);
            }
        });

        botaoFornecedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("operacao", 1);

                startActivity(intent);
            }
        });

        botaoClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("operacao", 2);

                startActivity(intent);
            }
        });

        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}