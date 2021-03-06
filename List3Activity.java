package com.example.huilv;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class List3Activity extends ListActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        private String TAG = "List3Activity";
        Handler handler;
        private ArrayList<HashMap<String, String>> listItems;
        private SimpleAdapter listItemAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            initListView();
            this.setListAdapter(listItemAdapter);

            handler = new Handler() {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    if (msg.what == 9) {
                        List<HashMap<String, String>> list2 = (List<HashMap<String, String>>) msg.obj;
                        listItemAdapter = new SimpleAdapter(List3Activity.this, list2, R.layout.list_item,
                                new String[]{"ItemTitle", "ItemDetail"}, new int[]{R.id.itemTitle, R.id.itemDetail});
                        setListAdapter(listItemAdapter);
                    }
                    super.handleMessage(msg);

                }
            };

            getListView().setOnItemClickListener(this);
            MyRate rate = new MyRate();
            rate.setHandler(handler);
            Thread thread = new Thread(rate);
            thread.start();//task.run()
        }

        private void initListView() {
            listItems = new ArrayList<HashMap<String, String>>();
            for (int i = 0;i<50;i++){
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("ItemTitle","Rate:"+i);
                map.put("ItemDetail","detail:"+i);
                listItems.add(map);
            }
            listItemAdapter = new SimpleAdapter(this, listItems,
                    R.layout.list_item,
                    new String[]{"ItemTitle","ItemDetail"},
                    new int[]{R.id.itemTitle,R.id.itemDetail}
            );
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Log.i(TAG, "onItemClick: position=" + position);

            HashMap<String, String> map = (HashMap<String, String>) getListView().getItemAtPosition(position);
            String titleStr = map.get("ItemTitle");
            String detailStr = map.get("ItemDetail");
            Log.i(TAG, "onItemClick: titleStr=" + titleStr);
            Log.i(TAG, "onItemClick: detailStr=" + detailStr);

            TextView title = (TextView) view.findViewById(R.id.itemTitle);
            TextView detail = (TextView) view.findViewById(R.id.itemDetail);
            String title2 = String.valueOf(title.getText());
            String detail2 = String.valueOf(detail.getText());
            Log.i(TAG, "onItemClick: title2=" + title2);
            Log.i(TAG, "onItemClick: detail2=" + detail2);

            Intent rateCal = new Intent(this, RateCalActivity.class);
            rateCal.putExtra("title", titleStr);
            rateCal.putExtra("rate", Float.parseFloat(detailStr));
            startActivity(rateCal);
        }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "onItemLongClick: ??????????????????");
        //???????????????
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("??????")
                .setMessage("?????????????????????????????????")
                .setPositiveButton("???", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: ?????????????????????");
                        //???????????????
                        //adapter1.remove(getListView().getItemAtPosition(position));
                    }
                }).setNegativeButton("???",null);
        builder.create().show();

        return true;
    }
}