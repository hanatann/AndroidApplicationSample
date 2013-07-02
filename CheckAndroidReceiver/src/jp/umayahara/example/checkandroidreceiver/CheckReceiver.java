/**
The MIT License

Copyright (c) 2013 Umayahara Kazumi(hanatann@gmail.com)
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

�ȉ��ɒ�߂�����ɏ]���A�{�\�t�g�E�F�A����ъ֘A�����̃t�@�C���i�ȉ��u�\�t�g�E�F�A�v�j�̕������擾���邷�ׂĂ̐l�ɑ΂��A�\�t�g�E�F�A�𖳐����Ɉ������Ƃ𖳏��ŋ����܂��B����ɂ́A�\�t�g�E�F�A�̕������g�p�A���ʁA�ύX�A�����A�f�ځA�Еz�A�T�u���C�Z���X�A�����/�܂��͔̔����錠���A����у\�t�g�E�F�A��񋟂��鑊��ɓ������Ƃ������錠�����������Ɋ܂܂�܂��B
��L�̒��쌠�\������і{�����\�����A�\�t�g�E�F�A�̂��ׂĂ̕����܂��͏d�v�ȕ����ɋL�ڂ�����̂Ƃ��܂��B
�\�t�g�E�F�A�́u����̂܂܁v�ŁA�����ł��邩�Öقł��邩���킸�A����̕ۏ؂��Ȃ��񋟂���܂��B�����ł����ۏ؂Ƃ́A���i���A����̖ړI�ւ̓K�����A����ь�����N�Q�ɂ��Ă̕ۏ؂��܂݂܂����A����Ɍ��肳�����̂ł͂���܂���B ��҂܂��͒��쌠�҂́A�_��s�ׁA�s�@�s�ׁA�܂��͂���ȊO�ł��낤�ƁA�\�t�g�E�F�A�ɋN���܂��͊֘A���A���邢�̓\�t�g�E�F�A�̎g�p�܂��͂��̑��̈����ɂ���Đ������؂̐����A���Q�A���̑��̋`���ɂ��ĉ���̐ӔC������Ȃ����̂Ƃ��܂��B
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
//        // AndroidManifest�̏����̃��@�[�W�����R�[�h������:�P�O�O�Ƃ���
//        int mInitVersionCode = 100;
//        try {
//        	mInitVersionCode=arg0.getPackageManager().getPackageInfo(arg0.getPackageName(), 1).versionCode;
//		} catch (NameNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        if(mInitVersionCode>100){
//        	// �V���ꍇ
//        }else{
//        	// 100�̏ꍇ
//        	// �ÓI���V�[�o���擾�ł��Ȃ�ACTION_PACKAGE_REPLACED���擾��̏������s
//        	goReceiverACTION_PACKAGE_REPLACED(arg0,arg1);
//        }
        Log.d("test", "onReceive::xxx::"+action);
        if (action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            name = "ACTION_AIRPLANE_MODE_CHANGED";
            detail = "�[�����s���[�h�ɕύX�����^�ʏ탂�[�h�ɖ߂���";
        } else if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
            name = "ACTION_BATTERY_CHANGED";
            detail = "�o�b�e���c�ʂ��ς����";
        } else if (action.equals(Intent.ACTION_BATTERY_LOW)) {
            name = "ACTION_BATTERY_LOW";
            detail = "�o�b�e���c�ʂ����Ȃ�";
        } else if (action.equals(Intent.ACTION_BATTERY_OKAY)) {
            name = "ACTION_BATTERY_OKAY";
            detail = "�o�b�e���[�c�ʂ��񕜂���";
        } else if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            name = "ACTION_BOOT_COMPLETED";
            detail = "�V�X�e���̋N������������";
        } else if (action.equals(Intent.ACTION_CAMERA_BUTTON)) {
            name = "ACTION_CAMERA_BUTTON";
            detail = "�J�����{�^�����������ꂽ";
        } else if (action.equals(Intent.ACTION_CONFIGURATION_CHANGED)) {
            name = "ACTION_CONFIGURATION_CHANGED";
            detail = "�I���G���e�[�V�����⃍�P�[���Ȃǂ̒[���ݒ�l���ύX���ꂽ";
        } else if (action.equals(Intent.ACTION_DATE_CHANGED)) {
            name = "ACTION_DATE_CHANGED";
            detail = "���t���ύX���ꂽ";
        } else if (action.equals(Intent.ACTION_DEVICE_STORAGE_LOW)) {
            name = "ACTION_DEVICE_STORAGE_LOW";
            detail = "�����������e�ʂ����Ȃ��Ȃ���";
        } else if (action.equals(Intent.ACTION_DEVICE_STORAGE_OK)) {
            name = "ACTION_DEVICE_STORAGE_OK";
            detail = "�����������e�ʕs�����������ꂽ";
        } else if (action.equals(Intent.ACTION_HEADSET_PLUG)) {
            name = "ACTION_HEADSET_PLUG";
            detail = "�w�b�h�Z�b�g���ڑ����ꂽ/���O���ꂽ";
        } else if (action.equals(Intent.ACTION_INPUT_METHOD_CHANGED)) {
            name = "ACTION_INPUT_METHOD_CHANGED";
            detail = "�C���v�b�g���\�b�h��ύX����";
        } else if (action.equals(Intent.ACTION_MEDIA_EJECT)) {
            name = "ACTION_MEDIA_EJECT";
            detail = "�O���������r�o���������s���ꂽ";
        } else if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
            name = "ACTION_MEDIA_MOUNTED";
            detail = "�O���������̃}�E���g�ɐ�������";
        } else if (action.equals(Intent.ACTION_MEDIA_REMOVED)) {
            name = "ACTION_MEDIA_REMOVED";
            detail = "�O������������菜���ꂽ";
        } else if (action.equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
            name = "ACTION_NEW_OUTGOING_CALL";
            detail = "�d�b���|����";
        } else if (action.equals(Intent.ACTION_PACKAGE_ADDED)) {
            name = "ACTION_PACKAGE_ADDED";
            detail = "�V�����p�b�P�[�W���C���X�g�[�����ꂽ";
        } else if (action.equals(Intent.ACTION_PACKAGE_CHANGED)) {
            name = "ACTION_PACKAGE_CHANGED";
            detail = "�����̃p�b�P�[�W���ύX���ꂽ";
        } else if (action.equals(Intent.ACTION_PACKAGE_INSTALL)) {
            name = "ACTION_PACKAGE_INSTALL";
            detail = "�p�b�P�[�W�̃_�E�����[�h�ƃC���X�g�[�����J�n����";
        } else if (action.equals(Intent.ACTION_PACKAGE_REMOVED)) {
            name = "ACTION_PACKAGE_REMOVED";
            detail = "�p�b�P�[�W���폜���ꂽ";
        }else if (action.equals(Intent.ACTION_PACKAGE_REPLACED)) {
            name = "PACKAGE_REPLACED";
            detail = "�p�b�P�[�W���폜���ꂽ2222";
        }
        
        else if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
            name = "ACTION_POWER_CONNECTED";
            detail = "�O���d�����ڑ����ꂽ";
        } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            name = "ACTION_POWER_DISCONNECTED";
            detail = "�O���d������ؒf���ꂽ";
        } else if (action.equals(Intent.ACTION_PROVIDER_CHANGED)) {
            name = "ACTION_PROVIDER_CHANGED";
            detail = "�R���e���c�v���o�C�_����̒ʒm����M����";
        } else if (action.equals(Intent.ACTION_REBOOT)) {
            name = "ACTION_REBOOT";
            detail = "�[�����ċN������";
        } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            name = "ACTION_SCREEN_OFF";
            detail = "�X�N���[�����؂�ꂽ";
        } else if (action.equals(Intent.ACTION_SCREEN_ON)) {
            name = "ACTION_SCREEN_ON";
            detail = "�X�N���[���������ꂽ";
        } else if (action.equals(Intent.ACTION_TIME_CHANGED)) {
            name = "ACTION_TIME_CHANGED";
            detail = "�[���̎������ݒ肳�ꂽ";
        } else if (action.equals(Intent.ACTION_TIME_TICK)) {
            name = "ACTION_TIME_TICK";
            detail = "���ݎ������ύX���ꂽ";
        } else if (action.equals(Intent.ACTION_UMS_CONNECTED)) {
            name = "ACTION_UMS_CONNECTED";
            detail = "�[���� USB �@��Ƃ��Đڑ����ꂽ";
        } else if (action.equals(Intent.ACTION_UMS_DISCONNECTED)) {
            name = "ACTION_UMS_DISCONECTED";
            detail = "�[���� USB �ڑ����������ꂽ";
        } else if (action.equals(Intent.ACTION_WALLPAPER_CHANGED)) {
            name = "ACTION_WALLPAPER_CHANGED";
            detail = "�[���̕ǎ����ύX���ꂽ";
        }

        if (name.length() > 0 && detail.length() > 0)
            showToast(arg0, name, detail);
    }
//	private void goReceiverACTION_PACKAGE_REPLACED(Context context, Intent intent){
//		if(intent ==null){
//		// ���u
//		
//		}else if (intent.getAction().equals(Intent.ACTION_PACKAGE_REPLACED)) {
//		/*************************************************************************************/
//		// ���L�͑O�񃁁[���ő��t�������e�ɂȂ�܂��B
//		// �ς���Ă���_�F�F
//		// �A���[���֘A�̃��\�b�h��static���\�b�h�ł��邽�߁A�A�N�Z�X���@�̋L�ڂ��ς���Ă��܂��B
//		/*************************************************************************************/
//						Log.d("TEST", "ACTION_PACKAGE_REPLACED");
//		//				��x�A�A���[���֌W���L�����Z�����܂��B
//		//				�����炭�A�F����肭�����Ă��Ȃ��̂͂��̏����������Ă��邽�߂ł́H�Ǝv���܂��B
//		//				�E7s�����^�C�}�[���L�����Z�� = �`�悪�~�܂�͂��ł��B
//						VideoRushWidget.cancelAlarm(context);
//		//				�E�Q�SH�A���[�����L�����Z��  = �ʐM�^�C�}�[���~�܂�܂�
//						VideoRushWidget.cancelAlarm24H(context);
//		//				�E������ʂ̂��邭��g�����W�V�����p�A���[�� �L�����Z�� = �u���p�K�񎞂������ꍇ�v�`�悪�~�܂�͂��ł��B
//						VideoRushWidget.cancelAlarmKurukuru(context);
//		//				�E�T�[�r�X���X�g�b�v�����܂��B�B�C
//						Intent serviceIntent = new Intent(context, VideoRushWidgetService.class);
//						context.stopService(serviceIntent);
//						// OS�N������Boot_Completed�A�N�V�����Ăяo���B�[���ċN�����̏����J�n�B
//						Intent startBootCompletedIntent = new Intent(context, VideoRushWidget.class);
//						startBootCompletedIntent.setAction(Intent.ACTION_BOOT_COMPLETED);
//						context.sendBroadcast(startBootCompletedIntent);
//						// ��L�����ɂ���āA�[�����ċN�����ꂽ�ȍ~�̏����uACTION_BOOT_COMPLETED�擾�ȍ~�̏����v���J�n����܂��B
//						// ���̏����ȍ~�A�Q�SH�A���[����1H�A���[���ɐ؂�ւ���Ă��邽�߁A�ʐM�����s�����Ǝv���܂��B�D�E�F�����s�����B
//		} 
//	}	
	
    private void showToast(Context context, String action, String detail) {
        String text = action + "\n" + detail;
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}
