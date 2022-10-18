package com.example.appdecadastro.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appdecadastro.entities.Produtos;

import java.util.List;

public class ProdutoDB {

    private DBHelper db;
    private SQLiteDatabase conexao;

    public ProdutoDB(DBHelper db) {
        this.db = db;
    }

    public void inserir(Produtos produto) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("marca", produto.getMarca());
        values.put("quantidade", produto.getQuantidade());
        values.put("dataValidade", produto.getDataValidade());
        values.put("preco", produto.getPreco());

        conexao.insertOrThrow("produtos", null, values);

        conexao.close();
    }

    public void listar(List<Produtos> listaProdutos) {
        listaProdutos.clear();
        conexao = db.getReadableDatabase();

        String colunas[] = {"id", "nome", "marca", "quantidade", "dataValidade", "preco"};
        Cursor query = conexao.query("produtos", colunas, null, null, null, null, "nome");

        while (query.moveToNext()) {
            Produtos produtos = new Produtos();

            produtos.setId(query.getInt(0));
            produtos.setNome(query.getString(1));
            produtos.setMarca(query.getString(2));
            produtos.setQuantidade(query.getInt(3));
            produtos.setDataValidade(query.getString(4));
            produtos.setPreco(query.getFloat(5));

            listaProdutos.add(produtos);
        }

        conexao.close();
    }
}
