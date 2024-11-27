package meuProjeto;

import static com.example.myapplication.R.layout.activity_main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonAdicionar,buttonEdit,buttonDelete;
    private LinearLayout linearLayout;
    private TextView txtNome, txtData;
    private ListView listView;
    private ArrayList<Task> listTask;
    private AdapterTask adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        buttonAdicionar = findViewById(R.id.btAdicionar);
        txtNome = findViewById(R.id.txTitulo);
        txtData = findViewById(R.id.textData);


        listTask = new ArrayList<>();
        listView = findViewById(R.id.listView);
        adapter = new AdapterTask(this, listTask);
        listView.setAdapter(adapter);


        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarTarefa();
            }
        });
    }

    public void adicionarTarefa() {

        String nome = txtNome.getText().toString();
        String data = txtData.getText().toString();

        if (!nome.isEmpty()) {

            Task task = new Task(nome, data);
            listTask.add(task);
            adapter.notifyDataSetChanged();
            txtNome.setText("nome da tarefa");
            txtData.setText("data da tarefa");


        }
    }
}


