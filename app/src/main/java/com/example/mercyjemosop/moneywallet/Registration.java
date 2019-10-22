package com.example.mercyjemosop.moneywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit2.Call;

public class Registration extends AppCompatActivity {
    Button bn, bnreg;
    EditText cname, cnationalid, cusername, cgender, caddress, cemail, cphonenumber, cbnpin, cpin, cmpin;
    private Integer cradioSexGroup;
    public String phone_numberc, customername, nationaid, userName, emailc, genderc, addressc, pinc, cmpinc, gender;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        // set the current state of a radio button

        cname = findViewById(R.id.customer_name);
        cnationalid = findViewById(R.id.national_id);
        cusername = findViewById(R.id.username);
        caddress = findViewById(R.id.address);
        cemail = findViewById(R.id.email);
        cphonenumber = findViewById(R.id.phone_number);
        cpin = findViewById(R.id.pin);
        cmpin = findViewById(R.id.confirm_pin);
        radioSexGroup = findViewById(R.id.radioSex);
        bn=findViewById(R.id.btnLogin);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Registration.this,Login.class);
                startActivity(intent);
            }
        });
        radioSexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                radioSexButton = findViewById(selectedId);
                Toast.makeText(Registration.this, radioSexButton.getText(), Toast.LENGTH_SHORT).show();

            }
        });
        bnreg = findViewById(R.id.btnRegistration);
        bnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // formValidation();
                JsonObject jsonObject = new JsonObject();
                customername = cname.getText().toString();
                nationaid = cnationalid.getText().toString();
                userName = cusername.getText().toString();
                emailc = cemail.getText().toString();
                gender = radioSexButton.getText().toString();
                phone_numberc = cphonenumber.getText().toString();
                addressc = caddress.getText().toString();
                pinc = cpin.getText().toString();
                cmpinc = cmpin.getText().toString();
                //add values/data to json object
                jsonObject.addProperty("customer_name", customername);
                jsonObject.addProperty("national_id", nationaid);
                jsonObject.addProperty("username", userName);
                jsonObject.addProperty("gender", gender);
                jsonObject.addProperty("email", emailc);
                jsonObject.addProperty("address", addressc);
                jsonObject.addProperty("phone_number", phone_numberc);
                jsonObject.addProperty("pin", pinc);
                jsonObject.addProperty("confirm_pin", cmpinc);
                registerUser(jsonObject);
            }
        });

    }

    public void registerUser(JsonObject jsonObject) {
        //call our interface class which contains our endpoint
        ApiInterface Interface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> callRegistration = Interface.callRegister(jsonObject);
        //enqueue() asynchronously sends the request and notifies your app with a callback when a response comes back
        callRegistration.enqueue(new retrofit2.Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                if (response.body() != null) {
                    Toast.makeText(Registration.this, "res" + response.body(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(Registration.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registration.this, Login.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(Registration.this, "res" + t.getMessage(), Toast.LENGTH_LONG).show();
                // Toast.makeText(Registration.this, "failed", Toast.LENGTH_SHORT).show();
                Log.e("onFailure", "" + t.toString());
            }
        });
    }

    //form validation
    public void formValidation() {

        if (userName.isEmpty()) {
            Toast.makeText(this, "please enter your username", Toast.LENGTH_SHORT).show();
        }


    }
}

