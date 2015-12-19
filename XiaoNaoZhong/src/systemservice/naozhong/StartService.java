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
		Log.e("sevice������", "ssssssssssssssssss");
		sendBroadcast(new Intent()
				.setAction("com.android.broadcast.RECEIVER_ACTION"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		creatDialog(this);
		return super.onStartCommand(intent, flags, startId);
	}

	public void creatDialog(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("����");
		builder.setMessage("��ʾ����");
		builder.setPositiveButton("�Ի���ť",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});

		builder.setCancelable(false);// �����򲻿��Ի����ؼ�ȡ��
		AlertDialog dialog = builder.create();
		dialog.getWindow()
				.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);// ������������Ϊȫ��
		dialog.setCanceledOnTouchOutside(false);// ʧȥ���㲻����ʧ
		dialog.show();
	}

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

}

