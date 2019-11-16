package edu.cnm.deepdive.tabfinalclass.controller;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import edu.cnm.deepdive.tabfinalclass.R;
import java.util.HashMap;

public class WebViewActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.web_view_activity);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    //initialize link
    HashMap<String, String> linkInitializeOptions = new HashMap<String, String>();
    linkInitializeOptions.put("key", "0c5bb5681c5687a8b071df6238742f");
    linkInitializeOptions.put("product", "auth");
    linkInitializeOptions.put("apiVersion", "v2");
    linkInitializeOptions.put("env", "sandbox");
    linkInitializeOptions.put("clientName","Test App");
    linkInitializeOptions.put("selectAccount","true");
    linkInitializeOptions.put("webhook","http://requestb.in");
    linkInitializeOptions.put("baseUrl","https://cdn.plaid.com/link/v2/stable/link.html");

    linkInitializeOptions.put("userEmailAddress", "USER_EMAIL_ADDRESS");
    linkInitializeOptions.put("userLegalName","USER_LEGAL_NAME");




  }
}
