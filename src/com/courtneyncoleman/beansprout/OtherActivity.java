package com.courtneyncoleman.beansprout;
import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class OtherActivity extends Activity implements OnClickListener {
	Button myStatusButton;
	TextView myStatusText;
	private ListView myListView; 
	private ArrayAdapter<String> listAdapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other_activity);
		myStatusButton=(Button) findViewById(R.id.btn_status);
		myStatusText=(TextView) findViewById(R.id.statusText);
		myListView=(ListView) findViewById(R.id.listView1);
		myStatusButton.setOnClickListener(this);

	//Create and populate the list as an array 
		
		String [] thestatuses=new String[] {"sleeping", "snoring"};
		
		ArrayList<String> statusList=new ArrayList<String>(); 
		statusList.addAll(Arrays.asList(thestatuses));
		
		listAdapter=new ArrayAdapter<String>(this, R.layout.simplerow, statusList);
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Log.v("OtherActivity", "Button was clicked"); 
		listAdapter.add( "eating" );  
	    listAdapter.add( "sittingup");  
	
		myListView.setAdapter(listAdapter);  
		
	}
	
	
}
