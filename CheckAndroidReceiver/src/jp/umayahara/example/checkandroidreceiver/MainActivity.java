package jp.umayahara.example.checkandroidreceiver;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // アンインストールボタンが押されたら、自身をアンインストール
        ((Button) findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String packageName = getClass().getPackage().getName();
                Uri uri = Uri.fromParts("package", packageName, null);
                Intent intent = new Intent(Intent.ACTION_DELETE, uri);
                startActivity(intent);
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
