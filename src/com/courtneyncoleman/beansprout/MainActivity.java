package com.courtneyncoleman.beansprout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{

	Button myButton; 
	ImageView myImage; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//When the application starts, set it to the main activity layout. 
		setContentView(R.layout.activity_main);
		
		//Find and Cast all objects on the layout to what they are as resources

		myImage=(ImageView) findViewById(R.id.imageView1);
		
	      

		//give the button a listener so it can do something when its clicked 
		myButton.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Log.v("MainActivity", "Button was clicked"); 
		
		Intent i=new Intent(this, OtherActivity.class);
		startActivity(i); 
		
	}

}
