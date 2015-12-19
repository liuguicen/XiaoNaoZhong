package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;

public class TixingManager {
	Context context;
	DBUtil dbUtil;

	public TixingManager(Context context) {
		this.context = context;
		dbUtil = new DBUtil(context);

		for (int i = 0; i < ids.length; i++)
			ids[i] = -1;

	}

	private Map<Integer, String> tixingNameMap = new HashMap<Integer, String>();
	private int[] ids = new int[1000];// 注意最多1000个提醒；

	public void addTixing(String name) {
		int i = 0;
		for (; ids[i] != -1 && i < ids.length; i++)
			tixingNameMap.put(i, name);
		dbUtil.inseartTixing(i, name);
	}

	public void deleteTixing(int id) {
		tixingNameMap.remove(id);
		ids[id] = -1;
		dbUtil.deleteTixing(id);
	}

	public void updateTixing(int id, String name) {
		tixingNameMap.remove(id);
		tixingNameMap.put(id, name);

		dbUtil.updateTixing(id, name);
	}

	public void getAllTixing() {
		List<String> tixingList = new ArrayList<String>();
		dbUtil.getAllTixingName(tixingList);
		for (String s : tixingList) {
			int id = Integer.valueOf(s.substring(0, s.indexOf("+")));
			String name = s.substring(s.indexOf("+") + 1, s.length());
			tixingNameMap.put(id, name);
			ids[id] = 1;
		}
	}

}
