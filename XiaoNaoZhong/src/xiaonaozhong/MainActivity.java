package xiaonaozhong;

import java.util.ArrayList;
import java.util.List;

import utils.DBUtil;
import lgc.xiaonaozhong.R;
import myCodeTools.P;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String title = "午觉";
	String musicPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tixing_manager);
		startActivityForResult(new Intent(MainActivity.this,
				ChoseMusicActivity.class), 0);
		testDBUtil();
		Resources res = getResources();
		Bitmap bitmap = BitmapFactory.decodeResource(res,
				R.drawable.naozhong_icon);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0 && resultCode == 0) {
			musicPath = data.getStringExtra("musicPath");
			Toast.makeText(this, musicPath, 1).show();
		}
	}

	public void testDBUtil() {
		DBUtil dbUtil = new DBUtil(this);
		for (int i = 0; i < 11; i++)
			dbUtil.inseartTixing(i, "tixing" + String.valueOf(i));
		dbUtil.inseartTixing(11, "tixing11");
		dbUtil.deleteTixing(1);
		dbUtil.updateTixing(0, "我是修改后的tixing");
	}
}

/*
 * ImageView imageView=(ImageView)findViewById(R.id.imageView1);
 * imageView.setImageBitmap(bitmap);
 * 
 * Button addBtn = (Button) findViewById(R.id. add_btn); final ShortcutUtil
 * shortcutUtil = new ShortcutUtil(MainActivity.this);
 * addBtn.setOnClickListener(new View.OnClickListener() {
 * 
 * @Override public void onClick(View v) {
 * 
 * Intent mainIntent = new Intent(MainActivity.this, MainActivity.class);
 * mainIntent.setAction(Intent.ACTION_ANSWER); shortcutUtil.creatShortCut(title,
 * null,mainIntent); if(shortcutUtil.isShortCutExist(MainActivity.this, title))
 * P.mt(MainActivity.this,"aaaaaaa"); }
 * 
 * });
 * 
 * Button delBtn = (Button) findViewById(R.id.del_btn);
 * delBtn.setOnClickListener(new View.OnClickListener() {
 * 
 * @Override public void onClick(View v) { Intent mainIntent = new
 * Intent(MainActivity.this, MainActivity.class);
 * mainIntent.setAction(Intent.ACTION_ANSWER); shortcutUtil.delShortcut(title,
 * mainIntent); } }); }
 * 
 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
 * menu; this adds items to the action bar if it is present.
 * getMenuInflater().inflate(R.menu.main, menu); return true; }
 * 
 * @Override public boolean onOptionsItemSelected(MenuItem item) { // Handle
 * action bar item clicks here. The action bar will // automatically handle
 * clicks on the Home/Up button, so long // as you specify a parent activity in
 * AndroidManifest.xml. int id = item.getItemId(); if (id ==
 * R.id.action_settings) { return true; } return
 * super.onOptionsItemSelected(item); }
 * 
 * }
 */
