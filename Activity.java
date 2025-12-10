package com.example.project;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName, editMarks;
    Button btnSubmit, btnView;
    TextView tvResult;

    String studentName = "";
    int marks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editMarks = findViewById(R.id.editMarks);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnView = findViewById(R.id.btnView);
        tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentName = editName.getText().toString().trim();
                String marksStr = editMarks.getText().toString().trim();

                if (studentName.isEmpty() || marksStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    marks = Integer.parseInt(marksStr);
                    Toast.makeText(MainActivity.this, "Data Submitted!", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Enter valid marks", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentName.isEmpty()) {
                    tvResult.setText("Please submit data first!");
                } else {
                    String performance;
                    if (marks >= 90) performance = "Excellent";
                    else if (marks >= 75) performance = "Good";
                    else if (marks >= 50) performance = "Average";
                    else performance = "Needs Improvement";

                    tvResult.setText("Name: " + studentName + "\nMarks: " + marks + "\nPerformance: " + performance);
                }
            }
        });
    }
}
