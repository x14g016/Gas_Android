package com.sync3.networktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    TextView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpURLConnection con = null;
         
// URLの作成
        URL url = new URL("http://techbooster.jpn.org/");
                     
// 接続用HttpURLConnectionオブジェクト作成
        con = (HttpURLConnection)url.openConnection();
// リクエストメソッドの設定
        con.setRequestMethod("GET");
// リダイレクトを自動で許可しない設定
        con.setInstanceFollowRedirects(false);
// ヘッダーの設定(複数設定可能)
        con.setRequestProperty("Accept-Language", "jp");
         
// 接続
        con.connect();
    ｝
    ｝