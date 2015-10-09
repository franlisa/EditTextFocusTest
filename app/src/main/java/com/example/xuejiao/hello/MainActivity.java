package com.example.xuejiao.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private ImageView image2;
    private EditText mText;
    private  EditText mTestFocusedMovedUp;
    private EditText mTopestView;

    public final static String INT_KEY = "int_key";
    public final static String String_KEY = "string_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mTestFocusedMovedUp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Log.e("fxj", "the focus moved up to the focusable view from the top");
                } else {
                    Log.e("fxj", "the first view not focused");
                }

            }
        });
        mTopestView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Log.e("fxj","topest view focused");
                }else {
                    Log.e("fxj","topest View not focused");
                }
            }
        });

        mText.setOnFocusChangeListener(new android.view.View.
                OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Log.e("fxj", "focused");
                } else {
                    // 此处为失去焦点时的处理内容
                    Log.e("fxj", "not focused ");
                }
            }
        });
        mText.setCursorVisible(true);
        mText.setFocusable(true);
        mText.setFocusableInTouchMode(true);
        mText.requestFocus();

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setCursorVisible(false);
                mText.clearFocus();
                Log.e("fxj","before");
//                mText.setFocusableInTouchMode(false);
                mText.setFocusable(false);
                Log.e("fxj","after");
//

//               image.requestFocus();
            }

        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setCursorVisible(true);
                mText.setFocusable(true);
                mText.setFocusableInTouchMode(true);
                mText.requestFocus();
            }
        });
//        image.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
      //  image.setImageDrawable(getDrawableById("ic_launcher"));

    }
    private  void initView(){
        mText =(EditText)findViewById(R.id.searchEdit);
        mTestFocusedMovedUp =(EditText)findViewById(R.id.testFocusedMovedUp);
        image =(ImageView)findViewById(R.id.image);
        image2=(ImageView)findViewById(R.id.image2);
        mTopestView =(EditText)findViewById(R.id.topestView);
    }
//    public Drawable getDrawableById(String id){
//        String packName  = getBaseContext().getPackageName();
//        Resources resources = getBaseContext().getResources();
//        int drawableId = resources.getIdentifier(id,"mipmap",packName);
//      return   resources.getDrawable(drawableId);
//
//
//    }
//    public View getViewById(String id){
//        String packName = getBaseContext().getPackageName();
//        Resources resources = getBaseContext().getResources();
//        int viewId = resources.getIdentifier(id,"id",packName);
//        if(viewId == 0)
//            return  null;
//        return  findViewById(viewId);
//    }
//    public  String getStringValue(String key){
//        String packageName = getBaseContext().getPackageName();
//        Resources resources= getBaseContext().getResources();
//        int stringId = resources.getIdentifier(key,"string",packageName);
//        Log.e("fxj", packageName + "," + resources);
//        return  resources.getString(stringId);
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//
//        outState.putInt(INT_KEY,1);
//        outState.putString(String_KEY, "test");
//        super.onSaveInstanceState(outState);
//        Log.e("fxj","method onSaveInstanceState");
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        int savedInt = (int)savedInstanceState.get(INT_KEY);
//       String  saveString = (String)savedInstanceState.get(String_KEY);
//        Log.e("fxj","method onRestoreInstanceState,"+saveString+savedInt);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.e("fxj","method onDestory");
//    }
//
//
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.e("fxj", "method onStop");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.e("fxj", "method onRestart");
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.e("fxj","method onStart");
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.e("fxj", "method onPause");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.e("fxj","method onResuem");
//    }
}
