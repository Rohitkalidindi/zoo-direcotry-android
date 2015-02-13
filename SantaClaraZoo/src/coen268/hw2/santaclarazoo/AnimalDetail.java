package coen268.hw2.santaclarazoo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetail extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);
	
        TextView animal_name= (TextView)findViewById(R.id.textView1);
		TextView animal_description= (TextView)findViewById(R.id.textView2);
		ImageView animal_image= (ImageView)findViewById(R.id.imageView1);
		String[] animals = new String[] { "Elephant", 
                "Giraffe",
                "Wolf",
                "Zebra", 
                "Bear", 
                };
		int[] animal_pics= {R.drawable.elephant,R.drawable.giraffe,R.drawable.wolf,
				R.drawable.zebra,R.drawable.bear};
		int[] description={R.string.animal_elephant,R.string.animal_giraffe,R.string.animal_wolf,
				R.string.animal_zebra,R.string.animal_bear};
		
		//Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		int position= getIntent().getExtras().getInt("id");
		animal_name.setText(animals[position]);
		animal_image.setBackgroundResource(animal_pics[position]);
		animal_description.setText(description[position]);
				
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
        	Intent newActivity = new Intent(AnimalDetail.this, ZooInformation.class);
        	startActivity(newActivity);
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

