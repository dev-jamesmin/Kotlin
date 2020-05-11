package com.example.mysample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.mysample.model.Model
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity() : AppCompatActivity(), Observer, View.OnClickListener {

    private var mModel: Model? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mModel = Model()
        mModel!!.addData()
        mModel!!.addObserver(this)
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        Log.d("DEBUG", "v->:$v")
        Log.d("DEBUG", "v" + v?.id)
        Log.d("DEBUG", "text1" + text1.id)
        if (v != null) {
            when (v.id) {
                text1.id -> {
                    mModel?.setDataAtIndex(0)
                }

                text2.id  ->
                    mModel?.setDataAtIndex(1)

            }
        }


    }

    override fun update(o: Observable?, arg: Any?) {
        text1.text = "Count : " + (mModel?.getDataAtIndex(0) ?: "NULL");
        text2.text = "Count : " + (mModel?.getDataAtIndex(1) ?: "NULL");

    }
}


// import java.util.Observable;
// import java.util.Observer;
//
// import android.view.View;
// import android.view.View.OnClickListener;
// import android.widget.Button;
//
//public class Android_MVC_PatternActivity extends Activity implements Observer, OnClickListener{
//    13     private Model mModel;
//    14     private Button mButton1, mButton2;
//    15
//    16     /** Called when the activity is first created. */
//    17     @Override
//    18     public void onCreate(Bundle savedInstanceState) {
//        19         super.onCreate(savedInstanceState);
//        20         setContentView(R.layout.main);
//        21         mModel = new Model();
//        22         mModel.addObserver(this);
//        23         mButton1 = (Button)findViewById(R.id.button1);
//        24         mButton2 = (Button)findViewById(R.id.button2);
//        25         mButton1.setOnClickListener(this);
//        26         mButton2.setOnClickListener(this);
//        27     }
//    28
//    29     public void onClick(View arg0) {
//        30         // TODO Auto-generated method stub
//        31         switch(arg0.getId()){
//            32         case R.id.button1:
//            33             mModel.setDataAtIndex(0);
//            34             break;
//            35         case R.id.button2:
//            36             mModel.setDataAtIndex(1);
//            37             break;
//            38         }
//        39     }
//    40     public void update(Observable observable, Object data) {
//        41         // TODO Auto-generated method stub
//        42         mButton1.setText("Count : " + mModel.getDataAtIndex(0));
//        43         mButton2.setText("Count : " + mModel.getDataAtIndex(1));
//        44     }
//    45 }
//
//출처: https://scotty83.tistory.com/entry/MVC-Pattern사용한-예제 [나만의 보물창고]