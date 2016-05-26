package com.sync3.networktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    TextView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = (TextView) findViewById(R.id.view);
        mView.setText(new String(httpGet("http://www.yahoo.co.jp")));
    }
    public static String httpGet(String strURL) {
        // (1)try-catchによるエラー処理
        try {
            // (2)URLクラスを使用して通信を行う
            URL url = new URL(strURL);
            URLConnection connection = url.openConnection();
            // 動作を入力に設定
            connection.setDoInput(true);
            InputStream stream = connection.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    stream));
            // (3)データの取得
            String data = "";
            String tmp = "";
            while ((tmp = input.readLine()) != null) {
                data += tmp;
            }
            // (4)終了処理
            stream.close();
            input.close();
            return data;
        } catch (Exception e) {
            // (5)エラー処理
            return e.toString();
        }
    }
}


