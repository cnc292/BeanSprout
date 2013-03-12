package com.courtneyncoleman.beansprout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{

	Button myButton; 
	Button mySignupbutton;
	ImageView myImage; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//When the application starts, set it to the main activity layout. 
		setContentView(R.layout.activity_main);
		//Find and Cast all objects on the layout to what they are as resources
		myImage=(ImageView) findViewById(R.id.img_profilePic);
		myButton=(Button) findViewById(R.id.btn_login);
		mySignupbutton=(Button) findViewById(R.id.btn_signup);
		//give the button a listener so it can do something when its clicked 
		
		myButton.setOnClickListener(new View.OnClickListener() {		
		public void onClick(View v) {
			  Intent myintent2 = new Intent(MainActivity.this, OtherActivity.class);
              startActivity(myintent2);
	}
		});
		
		mySignupbutton.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				  Intent mysignupintent = new Intent(MainActivity.this, SignupActivity.class);
	              startActivity(mysignupintent);
		}
			});
	}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
