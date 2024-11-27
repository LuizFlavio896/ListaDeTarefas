package meuProjeto;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

//ListAdapter liga uma lista de objetos a componentes de exibição
public class AdapterTask  extends ArrayAdapter<Task> {
    private final  List<Task> taskList;

    public AdapterTask(Context context, List<Task> taskList){
        super(context,0,taskList);
        this.taskList = taskList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tarefa,parent,false);
        }
        Task task = getItem(position);

        CheckBox checkBox = convertView.findViewById(R.id.checkBoxT);
        TextView textViewNome = convertView.findViewById(R.id.txtTituloT);
        TextView textViewData = convertView.findViewById(R.id.txtDataT);
        ImageButton delete = convertView.findViewById(R.id.imageButtonDeleteT);
        ImageButton edit = convertView.findViewById(R.id.imageButtonEditT);

        textViewNome.setText(task.getNome());
        textViewData.setText(task.getData());
        checkBox.setChecked(task.getConcluido());

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskList.remove(position);
                notifyDataSetChanged();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = taskList.get(position);
                EditarTarefa(task,position);
            }
        });

        return convertView;
    }

    public void EditarTarefa(Task task, int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Editar tarefa");

        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(linearLayout.VERTICAL);

        EditText nome = new EditText(getContext());
        nome.setHint("nome");
        nome.setText(task.getNome());
        linearLayout.addView(nome);

        EditText data = new EditText(getContext());
        data.setHint("Data");
        data.setText(task.getData());
        linearLayout.addView(data);

        builder.setView(linearLayout);

        builder.setPositiveButton("Salvar",(dialog,which)->{
            String novoNome = nome.getText().toString();
            String novaData = data.getText().toString();

            task.setNome(novoNome);
            task.setData(novaData);

            notifyDataSetChanged();
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }

}
