package jp.umayahara.example.hello_opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends Activity {

	private GLSurfaceView mView;
	private MyRenderer mRenderer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		mView = new GLSurfaceView(this);
		mRenderer = new MyRenderer();
		mView.setRenderer(mRenderer);
		setContentView(mView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onPause() {

		super.onPause();
		mView.onPause();
	}

	@Override
	protected void onResume() {

		super.onResume();
		mView.onResume();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			mView.queueEvent(new Runnable() {
				
				@Override
				public void run() {
					mRenderer.toggleColor();
					
				}
			});
			
		}
		return super.onTouchEvent(event);
	}

	private class MyRenderer implements GLSurfaceView.Renderer{

		private FloatBuffer mQuad;
		public MyRenderer(){
			float[] vertices = {
				-0.5f,-0.5f,0.0f,
				0.5f,-0.5f,0.0f,
				-0.5f,0.5f,0.0f,
				0.5f,0.5f,0.0f
			};
			ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length *4);
			byteBuffer.order(ByteOrder.nativeOrder());
			mQuad= byteBuffer.asFloatBuffer();
			mQuad.put(vertices);
			mQuad.position(0);
		}
		private boolean mColorRed = true;
		private boolean mLastColorRed = false;
		public void toggleColor() {
			mColorRed = !mColorRed;
			
		}
		@Override
		public void onDrawFrame(GL10 gl) {
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
			gl.glMatrixMode(GL10.GL_MODELVIEW);
			gl.glLoadIdentity();
			
			//3.6秒で１回転
			gl.glRotatef((SystemClock.uptimeMillis()%3600)*0.1f, 0, 0, 1.0f);
			if(mColorRed != mLastColorRed){
				if(mColorRed){
					//赤
					gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
				}else{
					//緑
					gl.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
				}
				mLastColorRed = mColorRed;
			}
			//赤
			//gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
			
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mQuad);
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
		}

		@Override
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			if(width>height){
				//横
				gl.glViewport((width-height)/2, 0, height, height);
			}else{
				//縦
				gl.glViewport(0,(height-width)/2,  width,width );
			}
			
		}

		@Override
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glMatrixMode(GL10.GL_PROJECTION);
			gl.glLoadIdentity();
			GLU.gluOrtho2D(gl, -1.0f, 1.0f, -1.0f, 1.0f);
			
		}
		
	}

}
