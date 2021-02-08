package cat.itb.niceuserfrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout username, password, password2, email, name, surnames, birthDate, gp;
    CheckBox checkContrac;
    Button register, login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username_register);
        password = findViewById(R.id.password_register);
        password2 = findViewById(R.id.password_register2);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        surnames = findViewById(R.id.surname);
        birthDate = findViewById(R.id.birth_date);
        gp = findViewById(R.id.gender_pronoum);
        checkContrac = findViewById(R.id.contract);
        register = findViewById(R.id.register2_singin);
        login = findViewById(R.id.login2_singin);

        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        final  MaterialDatePicker<Long> picker = builder.build();

        picker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                birthDate.getEditText().setText(picker.getHeaderText());
            }
        });

        birthDate.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.show(getSupportFragmentManager(), picker.toString());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setError(null);
                password.setError(null);
                password2.setError(null);
                email.setError(null);
                name.setError(null);
                surnames.setError(null);
                birthDate.setError(null);
                gp.setError(null);
                checkContrac.setError(null);
                boolean allRight = true;

                if(username.getEditText().getText().toString().equals("")){
                    username.setError("requiered field");
                    allRight = false;
                }

                if(!password.getEditText().getText().toString().equals("")){
                    if(password.getEditText().getText().length() < 7) {
                        password.setError("password to short");
                        allRight = false;
                    }
                } else {
                    allRight = false;
                    password.setError("requiered field");
                }

                if(!password2.getEditText().getText().toString().equals("")){
                    if(!password2.getEditText().getText().toString().equals(password.getEditText().getText().toString())){
                        System.out.println("pasa per aqui\n"+password2.getEditText().getText()+"\n"+password.getEditText().getText());
                        password2.setError("the password isn't the same");
                        allRight = false;
                    }
                } else {
                    allRight = false;
                    password2.setError("requiered field");
                }

                if(email.getEditText().getText().toString().equals("")){
                    email.setError("requiered field");
                    allRight = false;
                }

                if(name.getEditText().getText().toString().equals("")){
                    name.setError("requiered field");
                    allRight = false;
                }

                if(surnames.getEditText().getText().toString().equals("")){
                    surnames.setError("requiered field");
                    allRight = false;
                }

                if(birthDate.getEditText().getText().toString().equals("")){
                    birthDate.setError("requiered field");
                    allRight = false;
                }

                if(gp.getEditText().getText().toString().equals("")){
                    gp.setError("requiered field");
                    allRight = false;
                }

                if(!checkContrac.isChecked()) checkContrac.setError("requiered field");

                if(allRight && checkContrac.isChecked()){
                    Intent i = new Intent(RegisterActivity.this, WelcomeActivity.class);
                    startActivity(i);
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}