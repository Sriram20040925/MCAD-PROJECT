

package com.example.projz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText numSubjectsEditText;
    private Button submitButton;
    private LinearLayout gradesInputLayout;
    private ArrayList<EditText> gradeEditTexts = new ArrayList<>();
    private TextView cgpaTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numSubjectsEditText = findViewById(R.id.numSubjectsEditText);
        submitButton = findViewById(R.id.submitButton);
        gradesInputLayout = findViewById(R.id.gradesInputLayout);
        cgpaTextView = findViewById(R.id.cgpaTextView);

        submitButton.setOnClickListener(v -> {
            String numSubjectsText = numSubjectsEditText.getText().toString();

            if (numSubjectsText.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter number of subjects", Toast.LENGTH_SHORT).show();
                return;
            }

            int numSubjects = Integer.parseInt(numSubjectsText);

            if (numSubjects <= 0) {
                Toast.makeText(MainActivity.this, "Please enter a valid number of subjects", Toast.LENGTH_SHORT).show();
                return;
            }

            gradesInputLayout.removeAllViews();
            gradeEditTexts.clear();

            for (int i = 0; i < numSubjects; i++) {
                EditText gradeEditText = new EditText(MainActivity.this);
                gradeEditText.setHint("Grade for subject " + (i + 1) + " (O, A+, A, B+, B, C+, C, D, F)");
                gradeEditText.setTextSize(16);
                gradeEditText.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                gradesInputLayout.addView(gradeEditText);
                gradeEditTexts.add(gradeEditText);
            }

            gradesInputLayout.setVisibility(View.VISIBLE);
            submitButton.setText("Calculate CGPA");
            submitButton.setOnClickListener(v1 -> calculateCGPA(numSubjects));
        });
    }

    private void calculateCGPA(int numSubjects) {
        float totalPoints = 0;

        for (EditText gradeEditText : gradeEditTexts) {
            String grade = gradeEditText.getText().toString().toUpperCase();

            if (grade.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter grade for all subjects", Toast.LENGTH_SHORT).show();
                return;
            }

            // Mapping grade to points
            float gradePoints = getGradePoints(grade);
            if (gradePoints == -1) {
                Toast.makeText(MainActivity.this, "Invalid grade entered. Valid grades are O, A+, A, B+, B, C+, C, D, F.", Toast.LENGTH_SHORT).show();
                return;
            }

            totalPoints += gradePoints;
        }

        // Calculate CGPA
        float cgpa = totalPoints / numSubjects;
        cgpaTextView.setText("CGPA: " + cgpa);
    }

    private float getGradePoints(String grade) {
        switch (grade) {
            case "O":
                return 10.0f;
            case "A+":
                return 9.0f;
            case "A":
                return 8.0f;
            case "B+":
                return 7.0f;
            case "B":
                return 6.0f;
            case "C+":
                return 5.0f;
            case "C":
                return 4.0f;
            case "D":
                return 3.0f;
            case "F":
                return 0.0f;
            default:
                return -1;  // Invalid grade
        }
    }
}
