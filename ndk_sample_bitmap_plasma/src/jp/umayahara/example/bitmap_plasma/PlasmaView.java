package jp.umayahara.example.bitmap_plasma;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class PlasmaView extends View {
    private Bitmap mBitmap;
    private long mStartTime;
    /* load our native library */

    /* implementend by libplasma.so */
    public  native void renderPlasma(long time_ms,Bitmap  bitmap);

    public PlasmaView(Context context) {
        super(context);

        final int W = 400;
        final int H = 400;

        mBitmap = Bitmap.createBitmap(W, H, Bitmap.Config.RGB_565);
        mStartTime = System.currentTimeMillis();
    }

    @Override protected void onDraw(Canvas canvas) {
        //canvas.drawColor(0xFFCCCCCC);
        renderPlasma( System.currentTimeMillis() - mStartTime,mBitmap);
        canvas.drawBitmap(mBitmap, 0, 0, null);
        // force a redraw, with a different time-based pattern.
        invalidate();
    }
}
