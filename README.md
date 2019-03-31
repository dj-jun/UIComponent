# UIComponent
There are four Android UI components.
## 这里有四个Android UI组件，分别是SimpleAdapter、AlertDialog、XML定义菜单和ActionMode。
## 主界面截图：
![](https://github.com/dj-jun/UIComponent/blob/master/images/13.png)

## 一、利用SimpleAdapter实现界面效果:
### 1.simpleadapter.xml部分代码：
    <ListView
        android:id="@+id/lv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:dividerHeight="3dp"
        android:divider="#000000"
        android:listSelector="#B22222">   <!--设置不同点击状态展现出的相应样式-->

    </ListView>
### 2.simpleadapter_item.xml部分代码：
    <TextView
        android:id="@+id/tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:layout_gravity="center"
        android:layout_weight="1" />
    <ImageView
        android:id="@+id/iv"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:padding="10dp"
        android:scaleType="fitEnd"
        android:layout_gravity="center"
        android:layout_weight="1" />
### 3.为ListView设置Adapter：
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
### 4.使用Toast显示选中的列表项信息：
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

### 结果截图如下：
![](https://github.com/dj-jun/UIComponent/blob/master/images/1.png)

## 二、创建自定义布局的AlertDialog：
### 1.alertdialog.xml部分代码：
    <Button
        android:layout_width="100dp"
        android:layout_height="60dp"
        android:text="AlertDialog"
        android:textAllCaps="false"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        android:onClick="click"/>
### 2.alertdialog_view部分代码：
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@drawable/header_logo"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="Username"
        android:maxLines="1"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="Password"
        android:maxLines="1"/>
### 3.创建和使用AlertDialog：
    public void click(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setView(R.layout.alertdialog_view)
                .setNegativeButton("Cancel",null).setPositiveButton("Sign in",null).create();
        alertDialog.show();
    }

### 结果截图如下：
![](https://github.com/dj-jun/UIComponent/blob/master/images/2.png)
![](https://github.com/dj-jun/UIComponent/blob/master/images/3.png)

## 三、使用XML定义菜单：
### 1.菜单的layout部分代码：
    <TextView
        android:id="@+id/tv1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="用于测试的内容"
        android:textColor="#000000"
        android:textSize="20dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>
    <View
        android:layout_width="match_parent"
        android:layout_height="5px"
        android:background="#00CED1"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/tv1">

    </View>

### 2.菜单的menu代码：
    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android">
        <item
            android:id="@+id/item1"
            android:title="字体大小">
            <menu>
                <item
                   android:id="@+id/inner1"
                   android:title="小"></item>
                <item
                    android:id="@+id/inner2"
                    android:title="中"></item>
                <item
                    android:id="@+id/inner3"
                    android:title="大"></item>
            </menu>
        </item>
        <item
            android:id="@+id/item2"
            android:title="普通菜单项">
        </item>
        <item
            android:id="@+id/item3"
            android:title="字体颜色">
            <menu>
                <item
                    android:id="@+id/inner4"
                    android:title="红色"></item>
                <item
                    android:id="@+id/inner5"
                    android:title="黑色"></item>
            </menu>
        </item>
    </menu>

### 3.菜单点击相关事件：
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  //开发选项菜单重写的方法
        MenuInflater inflater = new MenuInflater(this);  //菜单动态加载类
        inflater.inflate(R.menu.xml_menu,menu);  //调用inflate方法解析菜单文件
        super.onCreateOptionsMenu(menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        switch (mi.getItemId()) {
            case R.id.inner1:
                textView.setTextSize(10);
                break;
            case R.id.inner2:
                textView.setTextSize(16);
                break;
            case R.id.inner3:
                textView.setTextSize(20);
                break;
            case R.id.item2:
                Toast.makeText(this,"点击了普通菜单项",Toast.LENGTH_SHORT).show();
                break;
            case R.id.inner4:
                textView.setTextColor(Color.parseColor("#FF0000"));
                break;
            case R.id.inner5:
                textView.setTextColor(Color.parseColor("#000000"));
                break;
        }
        return true;
    }

### 结果截图如下：
![](https://github.com/dj-jun/UIComponent/blob/master/images/4.png)
![](https://github.com/dj-jun/UIComponent/blob/master/images/5.png)
![](https://github.com/dj-jun/UIComponent/blob/master/images/6.png)
![](https://github.com/dj-jun/UIComponent/blob/master/images/9.png)
![](https://github.com/dj-jun/UIComponent/blob/master/images/10.png)

## 四、创建上下文操作模式（ActionMode）的上下文菜单：
### 1.ActionMode的layout（actionmode.xml）部分代码：
    <ListView
        android:id="@+id/lv1"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    </ListView>
### 2.ActionMode的详细布局（actionmode_item.xml）部分代码：
    <ImageView
        android:id="@+id/iv2"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:scaleType="fitStart"
        android:layout_gravity="center"
        android:layout_margin="10dp" />
    <TextView
        android:id="@+id/tv2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginLeft="10dp"
        android:textColor="#000000"
        android:textSize="15dp" />
### 3.菜单栏的改变：
    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android">
        <item
            android:id="@+id/i1"
            android:title="删除"
            android:icon="@drawable/remove">
    
        </item>
    </menu>
### 4.选中后颜色的变化：
    <?xml version="1.0" encoding="utf-8"?>
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
        <item
            android:state_activated="true"
            android:drawable="@color/blue">
    
        </item>
    </selector>
### 5.创建actionmode形式的上下文菜单：
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB
                mode.setTitle(list.getCheckedItemCount()+" selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.actionmode, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.i1:
                        //deleteSelectedItems();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }
        });
    }

### 结果截图如下：
![](https://github.com/dj-jun/UIComponent/blob/master/images/11.png)
![](https://github.com/dj-jun/UIComponent/blob/master/images/12.png)
