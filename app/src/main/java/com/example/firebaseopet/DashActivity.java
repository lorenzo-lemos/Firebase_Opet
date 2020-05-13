package com.example.firebaseopet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DashActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView textWelcome;
    private FirebaseFirestore db;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        mAuth = FirebaseAuth.getInstance();
        textWelcome = findViewById(R.id.textWelcome);
        textResultado = findViewById(R.id.textResultado);
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        textWelcome.setText("Bem-vindo, "+user.getEmail());
        db = FirebaseFirestore.getInstance();
    }

    public void sair(View view){
        mAuth.signOut();
        Intent inicio = new Intent(DashActivity.this,MainActivity.class);
        startActivity(inicio);
        finish();
    }

    public void registrardadosusuario(View view) {
        Intent cadoneactivity = new Intent(DashActivity.this,CadOneActivity.class);
        startActivity(cadoneactivity);
    }

    public void registrardadosvenda(View view) {
        Intent cad2activity = new Intent(DashActivity.this,Cad2Activity.class);
        startActivity(cad2activity);
    }

    public void registrardadostarefa(View view) {
        Intent cadtarefaactivity = new Intent(DashActivity.this,CadTarefaActivity.class);
        startActivity(cadtarefaactivity);
    }

    public void gerardadosnofirebase(View view) {
        List<Pessoa> pessoas = PopulateUtil.loadPessoas();

        for(Pessoa p : pessoas){
            db.collection("pessoas").add(p);
        }
    }

    public void pergunta1(View view) {
        CollectionReference pessoas = db.collection("pessoas");
        pessoas.whereEqualTo("nome","Lorenzo")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String resultado = "";
                            List<Pessoa> listPessoas = new ArrayList<>();
                            for(QueryDocumentSnapshot document : task.getResult()){
                                resultado += "ID: " + document.getId() + '\n' +
                                        document.getData().toString() + '\n';

                                listPessoas.add(document.toObject(Pessoa.class));
                            }
                            resultado = "";
                            for(Pessoa p : listPessoas){
                                resultado += p.toString() + "\n";
                            }
                            textResultado.setText(resultado);
                        }
                    }
                });
    }

    public void pergunta2(View view) {
        CollectionReference pessoas = db.collection("pessoas");
        pessoas.whereGreaterThan("salario",40000)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String resultado = "";
                            List<Pessoa> listPessoas = new ArrayList<>();
                            for(QueryDocumentSnapshot document : task.getResult()){
                                resultado += "ID: " + document.getId() + '\n' +
                                        document.getData().toString() + '\n';

                                listPessoas.add(document.toObject(Pessoa.class));
                            }
                            resultado = "";
                            for(Pessoa p : listPessoas){
                                resultado += p.toString() + "\n";
                            }
                            textResultado.setText(resultado);
                        }
                    }
                });
    }

    public void pergunta3(View view) {
        CollectionReference pessoas = db.collection("pessoas");

        pessoas.whereArrayContains("pets","Josney")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String resultado = "";
                            List<Pessoa> listPessoas = new ArrayList<>();
                            for(QueryDocumentSnapshot document : task.getResult()){
                                resultado += "ID: " + document.getId() + '\n' +
                                        document.getData().toString() + '\n';

                                listPessoas.add(document.toObject(Pessoa.class));
                            }
                            resultado = "";
                            for(Pessoa p : listPessoas){
                                resultado += p.toString() + "\n";
                            }
                            textResultado.setText(resultado);
                        }
                    }
                });
    }

    public void pergunta4(View view) {
        CollectionReference pessoas = db.collection("pessoas");

        pessoas.whereGreaterThan("qtde_filhos",0)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String resultado = "";
                            List<Pessoa> listPessoas = new ArrayList<>();
                            for(QueryDocumentSnapshot document : task.getResult()) {
                                Pessoa pessoa = document.toObject(Pessoa.class);
                                if(pessoa.salario > 3000) {
                                    resultado += "ID: " + document.getId() + '\n' +
                                            document.getData().toString() + '\n';

                                    listPessoas.add(pessoa);
                                }
                            }
                            resultado = "";
                            for(Pessoa p : listPessoas){
                                resultado += p.toString() + "\n";
                            }
                            textResultado.setText(resultado);
                        }
                    }
                });
    }
}
