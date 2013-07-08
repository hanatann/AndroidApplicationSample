package jp.umayahara.example.xfermode;

import android.app.Activity;
import android.graphics.Bitmap;

import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class PorterDuffXfermodeSampleActivity extends Activity {
	private final PorterDuff.Mode[] modes = PorterDuff.Mode.values();

	private Bitmap mBitmap = null;
	private Canvas mCanvas = null;
	private Paint mPaint = new Paint();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		init();
	}

	private void init() {
		// アダプタ準備
		ArrayAdapter<PorterDuff.Mode> adapter = new ArrayAdapter<PorterDuff.Mode>(this, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		for (PorterDuff.Mode mode : modes) {
			adapter.add(mode);
		}
		// スピナ準備
		Spinner spinner = null;
		spinner = (Spinner) findViewById(R.id.xfermode_1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(mSelectedListener);
		spinner = (Spinner) findViewById(R.id.xfermode_2);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(mSelectedListener);

		// ビットマップ準備
		mBitmap = Bitmap.createBitmap(300, 300, Config.ARGB_8888);
		mPaint.setStyle(Style.FILL_AND_STROKE);
		mPaint.setAntiAlias(true);
		mPaint.setStrokeWidth(25f);

		mCanvas = new Canvas(mBitmap);

		ImageView imageView = (ImageView) findViewById(R.id.image);
		imageView.setImageBitmap(mBitmap);
	}

	// 選択されたときのイベント
	private OnItemSelectedListener mSelectedListener = new OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			drawLins();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// 何もしない
		}
	};

	// 線を描く
	private void drawLins() {
		// 透明で塗りつぶし
		mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
		mPaint.setARGB(0, 0, 0, 0);
		mCanvas.drawRect(0, 0, mBitmap.getWidth(), mBitmap.getHeight(), mPaint);

		PorterDuff.Mode mode;
		Spinner spinner;

		// 指定されたモードで線を描く
		spinner = (Spinner) findViewById(R.id.xfermode_1);
		mode = (Mode) spinner.getSelectedItem();
		mPaint.setXfermode(new PorterDuffXfermode(mode));
		mPaint.setARGB(128, 0, 0, 0);
		mCanvas.drawLine(0, 0, mBitmap.getWidth(), mBitmap.getHeight(), mPaint);

		spinner = (Spinner) findViewById(R.id.xfermode_2);
		mode = (Mode) spinner.getSelectedItem();
		mPaint.setXfermode(new PorterDuffXfermode(mode));
		mPaint.setARGB(128, 0, 0, 0);
		mCanvas.drawLine(mBitmap.getWidth(), 0, 0, mBitmap.getHeight(), mPaint);

		// 画像更新
		ImageView imageView = (ImageView) findViewById(R.id.image);
		imageView.invalidate();
	}

	// 画象を保存
	// private void saveBitmap() {
	// FileOutputStream stream = null;
	// try {
	// stream = new FileOutputStream(new
	// File(Environment.getExternalStorageDirectory(), "alpha.png"));
	// mBitmap.compress(CompressFormat.PNG, 100, stream);
	// }
	// catch (FileNotFoundException e) {
	// e.printStackTrace();
	// }
	// finally {
	// if (stream != null) {
	// try {
	// stream.close();
	// stream = null;
	// }
	// catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }
}