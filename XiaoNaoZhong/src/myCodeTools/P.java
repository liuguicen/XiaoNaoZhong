package myCodeTools;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
/**
 * �򻯴�����࣬
 * ���ǹ��������ӡ����
 * @author acm_lgc
 *
 */
public class P {
	public static void mt(Context context,String s){
		Toast.makeText(context, s, Toast.LENGTH_LONG).show();
	}
	public void le(Object s)
	{
		Log.e(s.toString(),"------");
	}
	public void le(Object s1,Object s2)
	{
		Log.e(s1.toString(),s2.toString());
	}
	public void lgd(String s)
	{
		Log.d(s,"------");
	}
	public void lgd(String s1,String s2)
	{
		Log.d(s1,s2);
	}
	public void taost(Context context,Object s){
		Toast.makeText(context, s.toString(), Toast.LENGTH_LONG).show();
	}
}
