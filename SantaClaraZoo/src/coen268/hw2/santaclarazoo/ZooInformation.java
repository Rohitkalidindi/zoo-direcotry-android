package coen268.hw2.santaclarazoo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ZooInformation extends Activity {
	
	Button call;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_info);
        call=(Button) findViewById(R.id.button1);
        call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				call.setTextColor(0xFFF06D2F);
				Uri number= Uri.parse("tel:" +"5555555");
				Intent intent = new Intent(Intent.ACTION_CALL,number);
				startActivity(intent);
				
			}
		});
        
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
         return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
        case R.id.info:
            return true;
        case R.id.uninstall:
        	Uri packageUri = Uri.parse("package:coen268.hw2.santaclarazoo");
            Intent uninstallIntent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageUri);
            startActivity(uninstallIntent);
            return true;
        default:
		return super.onOptionsItemSelected(item);
		}

	}
}
