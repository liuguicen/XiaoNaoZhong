package utils;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class MySQLhelper extends SQLiteOpenHelper {

	public MySQLhelper(Context context, String name, int version) {
		super(context, name, null, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table tixing(id text, name text)");
		Log.e("���ݿ�","���������ݿ�");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.e("sssssssssssssss", "һ���¸���");
	}

}

/**
 * �����˹��ߵĶ��󼴿�ʹ�����ݿ���
 * 
 * @param context
 */
public class DBUtil {
	SQLiteDatabase db;
	MySQLhelper mySQLhelper;
	Context context;

	public DBUtil(Context context) {
		int version = AllData.DATEBASE_VERSION;
		this.context = context;
		mySQLhelper = new MySQLhelper(context, "tixing.db3", version);
	}

	public void getAllTixingName(List<String> nameList) {

		db = mySQLhelper.getWritableDatabase();

		Cursor cursor = db.query("tixing", null, null, null, null, null, null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			nameList.add(id + "+" + name);
		}
		cursor.close();
		db.close();
	}

	public void inseartTixing(int id, String name) {
		db = mySQLhelper.getWritableDatabase();
		db.execSQL("insert into tixing (id,name) values(?,?)",
				new String[] { String.valueOf(id), name });
		db.close();
	}

	public void updateTixing(int id, String name) {
		db = mySQLhelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("id", String.valueOf(id));
		contentValues.put("name", name);
		db.update("tixing", contentValues, "id=?",
				new String[] { String.valueOf(id) });
		db.close();
	}

	public void deleteTixing(int id) {
		db = mySQLhelper.getWritableDatabase();
		db.delete("tixing", "id=?", new String[] { String.valueOf(id) });
		db.close();
	}

	public void inseartNaozhong(int i, String name) {
		// TODO �Զ����ɵķ������
		
	}

	public void deleteNaozhong(int id) {
		// TODO �Զ����ɵķ������
		
	}

	public void updateNaozhong(int id, String name) {
		// TODO �Զ����ɵķ������
		
	}

	public void getAllNaozhongName(List<String> naozhongList) {
		// TODO �Զ����ɵķ������
		
	}
}
