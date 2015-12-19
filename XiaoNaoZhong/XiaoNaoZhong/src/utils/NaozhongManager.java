package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;

public class NaozhongManager {
	Context context;
	DBUtil dbUtil;

	public NaozhongManager(Context context) {
		this.context = context;
		dbUtil = new DBUtil(context);

		for (int i = 0; i < ids.length; i++)
			ids[i] = -1;

	}

	private Map<Integer, String> naozhongMapNameMap = new HashMap<Integer, String>();
	private int[] ids = new int[1000];// 注意最多1000个提醒；

	public void addNaozhong(String name) {
		int i = 0;
		for (; ids[i] != -1 && i < ids.length; i++)
			naozhongMapNameMap.put(i, name);
		dbUtil.inseartNaozhong(i, name);
	}

	public void deleteNaozhong(int id) {
		naozhongMapNameMap.remove(id);
		ids[id] = -1;
		dbUtil.deleteNaozhong(id);
	}

	public void updateNaozhong(int id, String name) {
		naozhongMapNameMap.remove(id);
		naozhongMapNameMap.put(id, name);

		dbUtil.updateNaozhong(id, name);
	}

	public void getAllNaozhong() {
		List<String> NaozhongList = new ArrayList<String>();
		dbUtil.getAllNaozhongName(NaozhongList);
		for (String s : NaozhongList) {
			int id = Integer.valueOf(s.substring(0, s.indexOf("+")));
			String name = s.substring(s.indexOf("+") + 1, s.length());
			naozhongMapNameMap.put(id, name);
			ids[id] = 1;
		}
	}

}
