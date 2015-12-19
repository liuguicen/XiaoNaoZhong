package systemservice.naozhong;

import lgc.xiaonaozhong.R;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowManager;

public class StartService extends Service {
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.e("sevice启动了", "ssssssssssssssssss");
		sendBroadcast(new Intent()
				.setAction("com.android.broadcast.RECEIVER_ACTION"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		creatDialog(this);
		return super.onStartCommand(intent, flags, startId);
	}

	public void creatDialog(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("标题");
		builder.setMessage("提示文字");
		builder.setPositiveButton("对话框按钮",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});

		builder.setCancelable(false);// 弹出框不可以换返回键取消
		AlertDialog dialog = builder.create();
		dialog.getWindow()
				.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);// 将弹出框设置为全局
		dialog.setCanceledOnTouchOutside(false);// 失去焦点不会消失
		dialog.show();
	}

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

}

