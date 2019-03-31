package com.example.administrator.uicomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simple_Adapter extends AppCompatActivity {
    private String[] names = new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imageIds = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);
        // 创建一个List集合，List集合的元素是Map
        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0;i < names.length;i++) {
            Map<String,Object> listItem = new HashMap<String, Object>();
            listItem.put("animalName",names[i]);
            listItem.put("tail",imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter
                (this,listItems,R.layout.simpleadapter_item,new String[] {"animalName","tail"},new int[] {R.id.tv,R.id.iv});
        ListView list = findViewById(R.id.lv);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*parent是指当前的listview；
                 *view是当前listview中的item的view的布局,就是可用这个view获取里面控件id后操作控件
                 * position是当前item在listview中适配器的位置
                 * id是当前item在listview里第几行的位置
                 */
                //获得选中项中的HashMap对象
                HashMap<String,String> map = (HashMap<String, String>) parent.getItemAtPosition(position);
                String AnimalName = map.get("animalName");
                Toast.makeText(Simple_Adapter.this,AnimalName,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
