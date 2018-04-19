package com.james.test;

import android.graphics.Bitmap;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String postUrl = "https://mobicardsystems.com/received";
    private WebView webView;

    private LinearLayout formLayout;
    private TextInputEditText firstName,lastName,mobile,orderAmount,itemDescription,postalCode,email;
    private Button btnSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
//        formLayout = (LinearLayout) findViewById(R.id.formLayout);
//        firstName = (TextInputEditText)findViewById(R.id.firstName);
//        lastName = (TextInputEditText)findViewById(R.id.lastName);
//        mobile = (TextInputEditText)findViewById(R.id.mobile);
//        orderAmount = (TextInputEditText)findViewById(R.id.orderAmount);
//        itemDescription = (TextInputEditText)findViewById(R.id.itemDescription);
//        postalCode = (TextInputEditText)findViewById(R.id.postalCode);
//        email = (TextInputEditText)findViewById(R.id.email);
//
//        btnSubmit = (Button ) findViewById(R.id.btnSubmit);
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//            }
//        });

        Map<String, String> params = new HashMap<String, String>();
        params.put("_token", "_token");
        params.put("Mobicard_Version", "1.0");
        params.put("Mobicard_Mode", "SILENT-HOSTED");
        params.put("Mobicard_Order_Amount", "100");
        params.put("Mobicard_Order_Currency", "USD");
        params.put("Mobicard_Item_Description", "TEST ITEM");
        params.put("Mobicard_Transaction_Reference", "1234567890");
        params.put("Mobicard_MerchantID", "1021");
        params.put("Mobicard_API_Key", "MWRmZjYyZDdmMDMzMTAwNjcyOWM5MTYwMGUzMGM3M2UxOWJjNmU5YjBkNzMifQ==");
        params.put("Mobicard_First_Name", "Test");//firstName.getText().toString());
        params.put("Mobicard_Last_Name","Client");// lastName.getText().toString());
        params.put("Mobicard_Address", "Physical address (You Many Use GPS coordinates or a Static Value if not collected by your app)");
        params.put("Mobicard_Postal_Code", "1234");//postalCode.getText().toString());//
        params.put("Mobicard_Country_Code", "KE");
        params.put("Mobicard_Mobile_Number", "254700123456");//mobile.getText().toString());//
        params.put("Mobicard_Email","markmathenge@gmail.com"); //email.getText().toString());
        params.put("Mobicard_Payment_Type", "CARD");
        params.put("Mobicard_Payment_Set", "1");
        params.put("Mobicard_Cnumber", "5300721110259295");
        params.put("Mobicard_Cvv", "766");
        params.put("Mobicard_Cexp_Month", "04");
        params.put("Mobicard_Cexp_Year", "18");

        //webView.setVisibility(View.VISIBLE);
        // formLayout.setVisibility(View.GONE);

        JSONObject jsonObject = new JSONObject(params);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d("reroute",url);
            }
        });
        webView.postUrl(postUrl,jsonObject.toString().getBytes());





    }
}
