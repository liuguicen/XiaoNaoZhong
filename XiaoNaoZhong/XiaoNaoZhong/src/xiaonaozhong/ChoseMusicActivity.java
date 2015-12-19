package xiaonaozhong;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import systemservice.naozhong.GetAllMusic;
import lgc.xiaonaozhong.R;
import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

class ChoiseView extends FrameLayout implements Checkable {
	private TextView mTextView;
	private RadioButton mRadioButton;

	public ChoiseView(Context context) {
		super(context);
		View.inflate(context, R.layout.music_item, this);
		mTextView = (TextView) findViewById(R.id.music_name);
		mRadioButton = (RadioButton) findViewById(R.id.music_checked);
	}

	public void setText(String text) {
		mTextView.setText(text);
	}

	@Override
	public void setChecked(boolean checked) {
		mRadioButton.setChecked(checked);

	}

	@Override
	public boolean isChecked() {

		return mRadioButton.isChecked();
	}

	@Override
	public void toggle() {

		mRadioButton.toggle();
	}

}

public class ChoseMusicActivity extends Activity {
	ImageButton verifyBtn;
	ImageButton cancelBtn;
	String musicPath;
	List<String> musicList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chose_music);
		verifyBtn = (ImageButton) findViewById(R.id.music_verify);
		cancelBtn = (ImageButton) findViewById(R.id.music_cancel);
		// 获取所有的music的路径
		musicList = new ArrayList<String>();
		List<String> nameList = new ArrayList<String>();

		new GetAllMusic(this).getAllMusicPath(musicList);
		for (String s : musicList) {
			nameList.add("   "
					+ s.substring(s.lastIndexOf("/") + 1, s.length()));
		}

		ListView listView = (ListView) findViewById(R.id.listview_chose_music);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		ListAdapter adapter = new ArrayAdapter<String>(this,
				R.layout.music_item, nameList) {
			public View getView(int position, View convertView,
					android.view.ViewGroup parent) {
				final ChoiseView view;
				if (convertView == null) {
					view = new ChoiseView(ChoseMusicActivity.this);
				} else {
					view = (ChoiseView) convertView;
				}
				view.setText(getItem(position));
				return view;
			}
		};
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				musicPath = musicList.get(position);
			}
		});
		listView.setAdapter(adapter);
		verifyBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent resultIntent = getIntent();
				resultIntent.putExtra("musicPath", musicPath);
				ChoseMusicActivity.this.setResult(0, resultIntent);
				ChoseMusicActivity.this.finish();
			}
		});
		cancelBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
