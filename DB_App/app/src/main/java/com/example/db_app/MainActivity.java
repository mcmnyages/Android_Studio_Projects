package com.example.db_app;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etRegNumber, etName, etSchool, etDepartment, etCourse, etYear, etSemester;
    private Button btnAdd, btnView, btnUpdate, btnDelete;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRegNumber = findViewById(R.id.etRegNumber);
        etName = findViewById(R.id.etName);
        etSchool = findViewById(R.id.etSchool);
        etDepartment = findViewById(R.id.etDepartment);
        etCourse = findViewById(R.id.etCourse);
        etYear = findViewById(R.id.etYear);
        etSemester = findViewById(R.id.etSemester);

        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        dbHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewStudents();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStudent();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteStudent();
            }
        });
    }

    private void addStudent() {
        String regNumber = etRegNumber.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String school = etSchool.getText().toString().trim();
        String department = etDepartment.getText().toString().trim();
        String course = etCourse.getText().toString().trim();
        String year = etYear.getText().toString().trim();
        String semester = etSemester.getText().toString().trim();


        long result = dbHelper.addStudent(regNumber, name, school, department, course, year, semester);

        if (result == -1) {
            Toast.makeText(this, "Failed to add student", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show();
            clearFields();
        }
    }

    private void viewStudents() {
        Cursor cursor = dbHelper.viewStudents();
        if (cursor.getCount() == 0) {
            showMessage("Error", "No students found");
            return;
        }

        StringBuilder buffer = new StringBuilder();
        while (cursor.moveToNext()) {
            buffer.append("Registration Number: ").append(cursor.getString(0)).append("\n");
            buffer.append("Name: ").append(cursor.getString(1)).append("\n");
            buffer.append("School: ").append(cursor.getString(2)).append("\n");
            buffer.append("Department: ").append(cursor.getString(3)).append("\n");
            buffer.append("Course: ").append(cursor.getString(4)).append("\n");
            buffer.append("Year: ").append(cursor.getString(5)).append("\n");
            buffer.append("Semester: ").append(cursor.getString(6)).append("\n\n");
        }

        showMessage("Students", buffer.toString());
    }

    private void updateStudent() {
        String regNumber = etRegNumber.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String school = etSchool.getText().toString().trim();
        String department = etDepartment.getText().toString().trim();
        String course = etCourse.getText().toString().trim();
        String year = etYear.getText().toString().trim();
        String semester = etSemester.getText().toString().trim();

        boolean result = dbHelper.updateStudent(regNumber, name, school, department, course, year, semester);

        if (result) {
            Toast.makeText(this, "Student updated successfully", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Failed to update student", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteStudent() {
        String regNumber = etRegNumber.getText().toString().trim();

        boolean result = dbHelper.deleteStudent(regNumber);

        if (result) {
            Toast.makeText(this, "Student deleted successfully", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Failed to delete student", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        etRegNumber.setText("");
        etName.setText("");
        etSchool.setText("");
        etDepartment.setText("");
        etCourse.setText("");
        etYear.setText("");
        etSemester.setText("");
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}