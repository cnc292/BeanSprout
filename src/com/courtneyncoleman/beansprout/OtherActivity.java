package com.courtneyncoleman.beansprout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiConfiguration.Status;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OtherActivity extends Activity {
	Button myStatusButton;
	TextView myStatusText;
	ImageButton myPicButton;

	public static final int CAMERA_RESULT = 0;
	String imageFilePath;
	private ListView myListView;
	private ArrayAdapter<String> listAdapter;

	// long msTime;
	// Date anotherCurDate = new Date(msTime);
	// SimpleDateFormat formatter = new
	// SimpleDateFormat("EEEE, MMMM d 'at' hh:mm a 'in the year' yyyy G");
	// String formattedDateString = formatter.format(anotherCurDate);

	@SuppressLint("SdCardPath")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other_activity);
		myStatusButton = (Button) findViewById(R.id.btn_status);
		myStatusText = (TextView) findViewById(R.id.txtStatus);
		myListView = (ListView) findViewById(R.id.listView1);
		myPicButton = (ImageButton) findViewById(R.id.img_profilePic);

		try {
			JsonReader reader = new JsonReader(new FileReader(
					"/sdcard/beansproutdata.txt"));
			reader.beginObject();
			while (reader.hasNext()) {
				String status = reader.nextName();
				if (status.equals("name")) {
					System.out.println(reader.nextString());

				} else if (status.equals("date")) {
					System.out.println(reader.nextInt());
					// read array
					reader.beginArray();
					while (reader.hasNext()) {
						System.out.println(reader.nextString());
					}
					reader.endArray();
					listAdapter.add(status);
					myListView.setAdapter(listAdapter);
				} else {
					reader.skipValue(); // avoid some unhandle events
				}
			}
			reader.endObject();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// FileInputStream fin = new FileInputStream(myFile);
		// InputStreamReader myInReader = new InputStreamReader(fin);
		// BufferedReader bufferedReader = new BufferedReader(myInReader);
		// StringBuilder total = new StringBuilder();
		// String line;
		// while ((line = bufferedReader.readLine()) != null) {
		// total.append(line);
		// }
		// String jsonin = total.toString();
		// Status status = gson.fromJson(jsonin, status.class);
		//
		// class Status {
		// private String statusText;
		// private String date;
		// }
		// Read data from the text file
		myPicButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myintent2 = new Intent(OtherActivity.this,
						MediaActivity.class);
				startActivity(myintent2);
				// Intent mediamenuintent = new
				// Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				// File imageFile = new
				// File(Environment.getExternalStorageDirectory().getAbsolutePath());
				// imageFilePath=imageFile.getAbsolutePath();
				// Uri imageFileUri=Uri.fromFile(imageFile);
				// mediamenuintent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
				// imageFileUri);
				// startActivityForResult(mediamenuintent, CAMERA_RESULT);
				// Toast.makeText(OtherActivity.this,"ImageButton is clicked!",
				// Toast.LENGTH_SHORT).show();
			}
		});

		// Create and populate the list as an array
		String[] thestatuses = new String[] {};
		ArrayList<String> statusList = new ArrayList<String>();
		statusList.addAll(Arrays.asList(thestatuses));
		listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow,
				statusList);
		myStatusButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v("OtherActivity", "Button was clicked");
				listAdapter.add(myStatusText.getText().toString());
				myListView.setAdapter(listAdapter);
//				// save data to a text file
//				try {
//					File myFile = new File("/sdcard/beansproutdata.txt");
//					myFile.createNewFile();
//					FileOutputStream fOut = new FileOutputStream(myFile);
//					OutputStreamWriter myOutWriter = new OutputStreamWriter(
//							fOut);
//					// myOutWriter.append(myStatusText.getText());
//					Date blah = new Date();
//					// blah.getTime();
//					String jsonout = "{" + "status:" + myStatusText.getText()
//							+ "date:" + blah.getTime() + "}";
//					myOutWriter.append(jsonout);
//					myOutWriter.close();
//					fOut.close();
//					Toast.makeText(null, "Done writing SD 'mysdfile.txt'",
//							Toast.LENGTH_SHORT).show();
//					myStatusText.setText("");
//				} catch (Exception e) {
//					Toast.makeText(null, e.getMessage(), Toast.LENGTH_SHORT)
//							.show();
//				}
}

		});

	}
}

// protected void onActivityResult(int requestCode, int resultCode, Intent
// intent){
// if (requestCode==CAMERA_RESULT){
// /*
// Bundle extras=intent.getExtras();
// Bitmap bmp=(Bitmap) extras.get("data");
// */
// BitmapFactory.Options bmpFactoryOptions=new BitmapFactory.Options();
// bmpFactoryOptions.inSampleSize=8;
// Bitmap bmp=BitmapFactory.decodeFile(imageFilePath, bmpFactoryOptions);
// ImageButton newPic=(ImageButton) findViewById(R.id.img_profilePic);
// newPic.setImageBitmap(bmp);
// }
// }
//
// }
//
//
// }
