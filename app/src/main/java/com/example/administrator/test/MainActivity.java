package com.example.administrator.test;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.content;
import static android.R.attr.data;
import static android.R.interpolator.linear;
import static com.example.administrator.test.R.layout.linearlayout_demo;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private Button button_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.main);
        button_go = (Button) findViewById(R.id.jumps);
        editText = (EditText) findViewById(R.id.tel);

        //为button按钮注册监听器，并通过匿名内部类实现
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("ddddd", "onClick: "+editText.getText());
                SmsManager smss = SmsManager.getDefault();
                smss.sendTextMessage(editText.getText().toString(),null,"测试",null,null);


            }
        });

        button_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){


//                try {
//                    HttpURLConnection conn = null; //连接对象
//                    URL url = null; //URL对象
//                    String encoding="UTF-8";
//                    url = new URL("http://192.168.0.22:8280/nbsljoa/web/mobile/AddressBook_listdept.action");
//                    String params="[{\"addTime\":\"2011-09-19 14:23:02\"}]";
//                    byte[] data = params.getBytes(encoding);
//                    conn = (HttpURLConnection) url.openConnection(); //使用URL打开一个链接
//                    conn.setConnectTimeout(5*1000);
//                    conn.setRequestMethod("GET"); //使用get请求
//                    conn.setDoOutput(true);
//                    //application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据
//                    conn.setRequestProperty("Content-Type", "application/x-javascript; charset="+ encoding);
//                    conn.setRequestProperty("Content-Length", String.valueOf(data.length));
//                    conn.setConnectTimeout(5*1000);
//                    OutputStream outStream = conn.getOutputStream();
//                    outStream.write(data);
//                    outStream.flush();
//                    outStream.close();
//                    Log.i("123321", "onClick: "+conn.getResponseCode());//响应代码 200表示成功
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                Log.i("", "onClick: 跳转开始---------------------------------------------------------------");
               TelephonyManager tm = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
                StringBuilder sb = new StringBuilder();
                sb.append("\nDeviceId(IMEI) = " + tm.getDeviceId());
                sb.append("\nDeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion());
                sb.append("\nLine1Number = " + tm.getLine1Number());
                sb.append("\nNetworkCountryIso = " + tm.getNetworkCountryIso());
                sb.append("\nNetworkOperator = " + tm.getNetworkOperator());
                sb.append("\nNetworkOperatorName = " + tm.getNetworkOperatorName());
                sb.append("\nNetworkType = " + tm.getNetworkType());
                sb.append("\nPhoneType = " + tm.getPhoneType());
                sb.append("\nSimCountryIso = " + tm.getSimCountryIso());
                sb.append("\nSimOperator = " + tm.getSimOperator());
                sb.append("\nSimOperatorName = " + tm.getSimOperatorName());
                sb.append("\nSimSerialNumber = " + tm.getSimSerialNumber());
                sb.append("\nSimState = " + tm.getSimState());
                sb.append("\nSubscriberId(IMSI) = " + tm.getSubscriberId());
                sb.append("\nVoiceMailNumber = " + tm.getVoiceMailNumber());
                Log.e("info", sb.toString());

                Log.i("", "onClick: 跳转开始");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, linearlayout.class);
                intent.putExtra("com.example.administrator.test.name","葫芦娃");
                startActivity(intent);
                Log.i("", "onClick: 跳转end-----------------------------------------------------------------------");
            }

        });



    }
}
