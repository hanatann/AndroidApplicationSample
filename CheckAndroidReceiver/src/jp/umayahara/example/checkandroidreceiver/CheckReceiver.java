/**
The MIT License

Copyright (c) 2013 Umayahara Kazumi(hanatann@gmail.com)
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

以下に定める条件に従い、本ソフトウェアおよび関連文書のファイル（以下「ソフトウェア」）の複製を取得するすべての人に対し、ソフトウェアを無制限に扱うことを無償で許可します。これには、ソフトウェアの複製を使用、複写、変更、結合、掲載、頒布、サブライセンス、および/または販売する権利、およびソフトウェアを提供する相手に同じことを許可する権利も無制限に含まれます。
上記の著作権表示および本許諾表示を、ソフトウェアのすべての複製または重要な部分に記載するものとします。
ソフトウェアは「現状のまま」で、明示であるか暗黙であるかを問わず、何らの保証もなく提供されます。ここでいう保証とは、商品性、特定の目的への適合性、および権利非侵害についての保証も含みますが、それに限定されるものではありません。 作者または著作権者は、契約行為、不法行為、またはそれ以外であろうと、ソフトウェアに起因または関連し、あるいはソフトウェアの使用またはその他の扱いによって生じる一切の請求、損害、その他の義務について何らの責任も負わないものとします。
 */

package jp.umayahara.example.checkandroidreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.widget.Toast;

/**
 * @author umayahara_k01
 *
 */
public class CheckReceiver extends BroadcastReceiver {
//	public class TestActivity extends Activity
//	{
//	    /** Called when the activity is first created. */
//	    @Override
//	    public void onCreate(Bundle savedInstanceState)
//	    {
//	        super.onCreate(savedInstanceState);
//	        setContentView(R.layout.main);
//	        TextView view = (TextView)findViewById(R.id.test_view);
//	        view.setOnClickListener(new View.OnClickListener(){
//	          public void onClick(View view){
//	            Uri packageUri = Uri.parse("package:org.klnusbaum.test");
//	            Intent uninstallIntent =
//	              new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageUri);
//	            startActivity(uninstallIntent);
//	          }
//	        });
//	    }
//	}
	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context arg0, Intent arg1) {
        String action = arg1.getAction();
        String name = "";
        String detail = "";
//        // AndroidManifestの初期のヴァージョンコードを入れる:１００とする
//        int mInitVersionCode = 100;
//        try {
//        	mInitVersionCode=arg0.getPackageManager().getPackageInfo(arg0.getPackageName(), 1).versionCode;
//		} catch (NameNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        if(mInitVersionCode>100){
//        	// 新し場合
//        }else{
//        	// 100の場合
//        	// 静的レシーバが取得できないACTION_PACKAGE_REPLACEDを取得後の処理実行
//        	goReceiverACTION_PACKAGE_REPLACED(arg0,arg1);
//        }
        Log.d("test", "onReceive::xxx::"+action);
        if (action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            name = "ACTION_AIRPLANE_MODE_CHANGED";
            detail = "端末を飛行モードに変更した／通常モードに戻した";
        } else if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
            name = "ACTION_BATTERY_CHANGED";
            detail = "バッテリ残量が変わった";
        } else if (action.equals(Intent.ACTION_BATTERY_LOW)) {
            name = "ACTION_BATTERY_LOW";
            detail = "バッテリ残量が少ない";
        } else if (action.equals(Intent.ACTION_BATTERY_OKAY)) {
            name = "ACTION_BATTERY_OKAY";
            detail = "バッテリー残量が回復した";
        } else if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            name = "ACTION_BOOT_COMPLETED";
            detail = "システムの起動が完了した";
        } else if (action.equals(Intent.ACTION_CAMERA_BUTTON)) {
            name = "ACTION_CAMERA_BUTTON";
            detail = "カメラボタンが押下された";
        } else if (action.equals(Intent.ACTION_CONFIGURATION_CHANGED)) {
            name = "ACTION_CONFIGURATION_CHANGED";
            detail = "オリエンテーションやロケールなどの端末設定値が変更された";
        } else if (action.equals(Intent.ACTION_DATE_CHANGED)) {
            name = "ACTION_DATE_CHANGED";
            detail = "日付が変更された";
        } else if (action.equals(Intent.ACTION_DEVICE_STORAGE_LOW)) {
            name = "ACTION_DEVICE_STORAGE_LOW";
            detail = "内蔵メモリ容量が少なくなった";
        } else if (action.equals(Intent.ACTION_DEVICE_STORAGE_OK)) {
            name = "ACTION_DEVICE_STORAGE_OK";
            detail = "内蔵メモリ容量不足が解消された";
        } else if (action.equals(Intent.ACTION_HEADSET_PLUG)) {
            name = "ACTION_HEADSET_PLUG";
            detail = "ヘッドセットが接続された/取り外された";
        } else if (action.equals(Intent.ACTION_INPUT_METHOD_CHANGED)) {
            name = "ACTION_INPUT_METHOD_CHANGED";
            detail = "インプットメソッドを変更した";
        } else if (action.equals(Intent.ACTION_MEDIA_EJECT)) {
            name = "ACTION_MEDIA_EJECT";
            detail = "外部メモリ排出処理が実行された";
        } else if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
            name = "ACTION_MEDIA_MOUNTED";
            detail = "外部メモリのマウントに成功した";
        } else if (action.equals(Intent.ACTION_MEDIA_REMOVED)) {
            name = "ACTION_MEDIA_REMOVED";
            detail = "外部メモリが取り除かれた";
        } else if (action.equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
            name = "ACTION_NEW_OUTGOING_CALL";
            detail = "電話を掛ける";
        } else if (action.equals(Intent.ACTION_PACKAGE_ADDED)) {
            name = "ACTION_PACKAGE_ADDED";
            detail = "新しいパッケージがインストールされた";
        } else if (action.equals(Intent.ACTION_PACKAGE_CHANGED)) {
            name = "ACTION_PACKAGE_CHANGED";
            detail = "既存のパッケージが変更された";
        } else if (action.equals(Intent.ACTION_PACKAGE_INSTALL)) {
            name = "ACTION_PACKAGE_INSTALL";
            detail = "パッケージのダウンロードとインストールを開始した";
        } else if (action.equals(Intent.ACTION_PACKAGE_REMOVED)) {
            name = "ACTION_PACKAGE_REMOVED";
            detail = "パッケージが削除された";
        }else if (action.equals(Intent.ACTION_PACKAGE_REPLACED)) {
            name = "PACKAGE_REPLACED";
            detail = "パッケージが削除された2222";
        }
        
        else if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
            name = "ACTION_POWER_CONNECTED";
            detail = "外部電源が接続された";
        } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            name = "ACTION_POWER_DISCONNECTED";
            detail = "外部電源から切断された";
        } else if (action.equals(Intent.ACTION_PROVIDER_CHANGED)) {
            name = "ACTION_PROVIDER_CHANGED";
            detail = "コンテンツプロバイダからの通知を受信した";
        } else if (action.equals(Intent.ACTION_REBOOT)) {
            name = "ACTION_REBOOT";
            detail = "端末を再起動する";
        } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            name = "ACTION_SCREEN_OFF";
            detail = "スクリーンが切られた";
        } else if (action.equals(Intent.ACTION_SCREEN_ON)) {
            name = "ACTION_SCREEN_ON";
            detail = "スクリーンが入れられた";
        } else if (action.equals(Intent.ACTION_TIME_CHANGED)) {
            name = "ACTION_TIME_CHANGED";
            detail = "端末の時刻が設定された";
        } else if (action.equals(Intent.ACTION_TIME_TICK)) {
            name = "ACTION_TIME_TICK";
            detail = "現在時刻が変更された";
        } else if (action.equals(Intent.ACTION_UMS_CONNECTED)) {
            name = "ACTION_UMS_CONNECTED";
            detail = "端末が USB 機器として接続された";
        } else if (action.equals(Intent.ACTION_UMS_DISCONNECTED)) {
            name = "ACTION_UMS_DISCONECTED";
            detail = "端末の USB 接続が解除された";
        } else if (action.equals(Intent.ACTION_WALLPAPER_CHANGED)) {
            name = "ACTION_WALLPAPER_CHANGED";
            detail = "端末の壁紙が変更された";
        }

        if (name.length() > 0 && detail.length() > 0)
            showToast(arg0, name, detail);
    }
//	private void goReceiverACTION_PACKAGE_REPLACED(Context context, Intent intent){
//		if(intent ==null){
//		// 放置
//		
//		}else if (intent.getAction().equals(Intent.ACTION_PACKAGE_REPLACED)) {
//		/*************************************************************************************/
//		// 下記は前回メールで送付した内容になります。
//		// 変わっている点：：
//		// アラーム関連のメソッドはstaticメソッドであるため、アクセス方法の記載が変わっています。
//		/*************************************************************************************/
//						Log.d("TEST", "ACTION_PACKAGE_REPLACED");
//		//				一度、アラーム関係をキャンセルします。
//		//				おそらく、⑦が上手くいっていないのはこの処理が抜けているためでは？と思います。
//		//				・7s処理タイマーをキャンセル = 描画が止まるはずです。
//						VideoRushWidget.cancelAlarm(context);
//		//				・２４Hアラームをキャンセル  = 通信タイマーが止まります
//						VideoRushWidget.cancelAlarm24H(context);
//		//				・初期画面のくるくるトランジション用アラーム キャンセル = 「利用規約時だった場合」描画が止まるはずです。
//						VideoRushWidget.cancelAlarmKurukuru(context);
//		//				・サービスをストップさせます。③④
//						Intent serviceIntent = new Intent(context, VideoRushWidgetService.class);
//						context.stopService(serviceIntent);
//						// OS起動時のBoot_Completedアクション呼び出し。端末再起動時の処理開始。
//						Intent startBootCompletedIntent = new Intent(context, VideoRushWidget.class);
//						startBootCompletedIntent.setAction(Intent.ACTION_BOOT_COMPLETED);
//						context.sendBroadcast(startBootCompletedIntent);
//						// 上記処理によって、端末を再起動された以降の処理「ACTION_BOOT_COMPLETED取得以降の処理」が開始されます。
//						// この処理以降、２４Hアラームが1Hアラームに切り替わっているため、通信が実行されると思います。⑤⑥⑦が実行される。
//		} 
//	}	
	
    private void showToast(Context context, String action, String detail) {
        String text = action + "\n" + detail;
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}
