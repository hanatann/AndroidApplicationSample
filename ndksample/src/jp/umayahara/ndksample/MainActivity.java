package jp.umayahara.ndksample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  implements OnClickListener{

    TextView text1, text2;
    Button btn1, btn2;
    final String[] msgList = 
        { "日本", "アメリカ", "イギリス", "フランス", "ロシア", "中国" };
    int count = 0;

    static {
        System.loadLibrary("ndksample");
    }

    public native String msgFromNDK(int count);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.textView1);
        text1.setText(msgList[0]);

        text2 = (TextView) findViewById(R.id.textView2);
        text2.setText("");

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setText("Java");
        btn1.setOnClickListener(this);

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setText("Navite");
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            text1.setText(msgFromJava());
        } else {
            text2.setText(msgFromNDK(count));
        }
    }

    String msgFromJava() {
        String msg = new String();
        if (++count >= msgList.length) {
            count = 0;
        }
        msg = msgList[count];
        return msg;
    }

}
