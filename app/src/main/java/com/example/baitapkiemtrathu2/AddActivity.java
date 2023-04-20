package com.example.baitapkiemtrathu2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitapkiemtrathu2.model.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

public class AddActivity extends AppCompatActivity {
    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;

    Spinner s1;
    Spinner s2;

    Switch sw1;

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);

        s1 = findViewById(R.id.spinner);
        s2 = findViewById(R.id.spinner2);

        sw1 = findViewById(R.id.switch1);

        btn1 = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button3);

        String[] ss1 = new String[]{
                "test1", "test2", "test3"
        };
        ArrayAdapter adapter1 = new ArrayAdapter(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ss1);
        s1.setAdapter(adapter1);

        String[] ss2 = new String[]{
                "T1", "T2", "T3"
        };
        ArrayAdapter adapter2 = new ArrayAdapter(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ss2);
        s2.setAdapter(adapter2);

        Intent intent1 = getIntent();
        Integer id = intent1.getIntExtra("id", -1);

        Model model = new Model();
        if (id == -1)
            btn2.setVisibility(View.INVISIBLE);
        else {
            model = MainActivity.db.findOne(id);
            btn1.setText("Sửa");
            edt1.setText(model.getName());
            edt2.setText(model.getContent());
            edt3.setText(model.getDescription());
            edt4.setText(model.getDate());

            sw1.setChecked(model.getIsOK() != null && model.getIsOK() == 1);

            for (int i = 0; i < ss1.length; i++)
                if (ss1[i].equals(model.getSpn1()))
                    s1.setSelection(i);

            for (int i = 0; i < ss2.length; i++)
                if (ss2[i].equals(model.getSpn2()))
                    s2.setSelection(i);
        }


//        edt4.setKeyListener(null);
//        edt4.setOnClickListener(v -> {
//            Calendar c = Calendar.getInstance();
//            int y = c.get(Calendar.YEAR);
//            int m = c.get(Calendar.MONTH);
//            int d = c.get(Calendar.DATE);
//            new DatePickerDialog(this, (datePicker, i0, i1, i2) -> {
//                String year = datePicker.getYear() + "";
//                String month = datePicker.getMonth() < 10 ? "0" + datePicker.getMonth() : datePicker.getMonth() + "";
//                String day = datePicker.getDayOfMonth() < 10 ? "0" + datePicker.getDayOfMonth() : datePicker.getDayOfMonth() + "";
//                edt4.setText(year + "-" + month + "-" + day);
//            }, y, m, d).show();
//        });

//        edt4.setKeyListener(null);
//        edt4.setOnClickListener(view -> {
//            Calendar c = Calendar.getInstance();
//            int h = c.get(Calendar.HOUR);
//            int m = c.get(Calendar.MINUTE);
//            TimePickerDialog tpd = new TimePickerDialog(this, (timePicker, ii, i1) -> {
//                String hh = timePicker.getHour() < 10 ? "0" + timePicker.getHour() : timePicker.getHour() + "";
//                String mm = timePicker.getMinute() < 10 ? "0" + timePicker.getMinute() : timePicker.getMinute() + "";
//                edt4.setText(hh + ":" + mm);
//            }, h, m, true);
//            tpd.show();
//        });

        Model finalModel = model;
        btn1.setOnClickListener(v1 -> {
            Model model1 = new Model();
            model1.setId(finalModel.getId());
            model1.setName(edt1.getText().toString());
            model1.setContent(edt2.getText().toString());
            model1.setDescription(edt3.getText().toString());
            model1.setSpn1(s1.getSelectedItem().toString());
            model1.setSpn2(s2.getSelectedItem().toString());
            model1.setDate(edt4.getText().toString());
            model1.setIsOK(sw1.isChecked() ? 1 : 0);

            MainActivity.db.save(model1);
            Intent intent = new Intent(AddActivity.this, MainActivity.class);
            startActivity(intent);
        });

        btn2.setOnClickListener(v2 -> {
            MainActivity.db.delete(id);
            Intent intent = new Intent(AddActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}
