package com.courtneyncoleman.beansprout;
import com.courtneyncoleman.beansprout.R;

import android.app.Activity;
import android.os.Bundle;



public class MediaActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//When the application starts, set it to the main activity layout. 
		setContentView(R.layout.media_menu);
		
}
}
