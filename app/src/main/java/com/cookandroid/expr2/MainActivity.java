package com.cookandroid.expr2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    final  String[] STANT_NM= {
            "시청", "을지로입구", "을지로3가", "을지로4가", "동대문역사문화공원", "신당", "상왕십리", "왕십리", "한양대", "뚝섬", "성수",
            "건대입구", "구의", "강변", "잠실나루", "잠실", "신천", "종합운동장", "삼성","선릉", "역삼", "강남", "교대", "서초", "방배",
            "사당", "낙성대", "서울대입구", "봉천", "신림", "신대방", "구로디지털단지", "대림", "신도림", "문래", "영등포구청", "당산", "합정", "홍대입구",
            "신촌(지하)", "이대", "아현", "충정로", "용답", "신답", "신설동", "도림천", "양천구청", "신정네거리", "용두", "까치산"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,STANT_NM);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SubwayCongestion.class);
                String title = STANT_NM[position];
                intent.putExtra("title", title);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }
}