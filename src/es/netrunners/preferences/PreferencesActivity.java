package es.netrunners.preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PreferencesActivity extends Activity {

	private String PREFS_NAME = "Preferences";
	EditText key;
	EditText value;
	EditText key2;
	TextView value2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		key = (EditText) findViewById(R.id.key);
		value = (EditText) findViewById(R.id.value);
		key2 = (EditText) findViewById(R.id.keyRetrieve);
		value2 = (TextView) findViewById(R.id.txtValue);
	}

	public void retrieveData(View v) {
		SharedPreferences settings = getSharedPreferences(PREFS_NAME,
				MODE_PRIVATE);
		settings.getString("KEY", "Default Value");
		value2.setText(settings.getString(key2.getText().toString(), ""));
	}

	public void storeData(View v) {
		SharedPreferences settings = getSharedPreferences(PREFS_NAME,
				MODE_PRIVATE);
		Editor editor = settings.edit();
		editor.putString(key.getText().toString(), value.getText().toString());
		editor.commit(); // IMPORTANT
	}
}