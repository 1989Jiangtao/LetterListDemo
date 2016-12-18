package com.cjt.letterlistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.cjt.letterlistdemo.QuickAdapter.BaseAdapterHelper;
import com.cjt.letterlistdemo.QuickAdapter.QuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] mTestDatas = new String[]{"Android", "Table", "Caption", "Row",
            "Column", "Rowspan", "Colspan", "Align", "Valign","It's it is的缩写形式 ",
            "How adv (指程度)多少,怎样 ",
            "Old adj ...岁的,老的 ",
            "Eleven num 十一 ",
            "Twelve num 十二 ",
            "Minus prep 减,减去 ",
            "Thirteen num 十三 ",
            "Fourteen num 十四 ",
            "Fifteen num 十五 ",
            "Hello interj 喂(问候或唤起",
            "Please interj 请 ",
            "Can v.aux 能,可以,会 ",
            "Spell v 拼写 ",
            "That pron 那,那个 ",
            "Secret n 秘密 ",
            "This pron 这,这个 ",
            "In prep 用...(表达) ",
            "English n & adj 英语,英国人" };
    private ListView mListView ; // 界面上的列表控件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 准备测试的数据
        List<String> listDatas = new ArrayList<>();
        for (int i = 0; i < mTestDatas.length; i++) {
            listDatas.add(i,mTestDatas[i]);
        }
        mListView = (ListView) findViewById(R.id.myList);
        mListView.setAdapter(new QuickAdapter<String>(getBaseContext(),R.layout.list_item ,listDatas) {
            @Override
            protected void convert(BaseAdapterHelper helper, String item) {
                helper.setText(R.id.tvContent , item );
                helper.setImageResource(R.id.imgIcon  , getIconResId(item.charAt(0))); // 取首字母转换为资源ID
            }
        });

    }

    /***
     * 根据传入的字母获取相应的Icon的资源引用
     * @param letter   传入的字母，小写，因为资源文件只支持小写
     * @return  对应的资源引用
     */
    private int getIconResId(char letter){
        // 将传入的大写转换为小写，并得到对应的资源文件ID返回
        if(Character.isLetter(letter)){
            return this.getResources().getIdentifier("icon_"+Character.toLowerCase(letter),"mipmap",getPackageName());
        }
        return R.mipmap.ic_launcher;
    }

    /***
     * 检查数组中是否存在某个元素的方法
     * @param stringArray   目标数组
     * @param targetValue   目标元素
     * @return  false： 不存在  true：存在
     */
    private static boolean checkExist(String[] stringArray , String targetValue){
        for (String s: stringArray) {
            if (targetValue.equals(s)) return true ;
        }
        return false;
    }
}
