package coen268.hw2.santaclarazoo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AnimalListActivity extends Activity {

    private ListView list;
    private String[] animals={ "Elephant", "Giraffe", "Wolf", "Zebra","Bear"};
    private int[] icons = {R.drawable.elephanticon,
    		R.drawable.giraffeicon,
    		R.drawable.wolficon,R.drawable.zebraicon,R.drawable.bearicon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


		//Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
        
        list = (ListView) findViewById(R.id.listView1);
        CustomAdapter adapter = new CustomAdapter(this, animals, icons);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	switch( position )
			    {
            	
			       case 0:  Intent newActivity0 = new Intent(AnimalListActivity.this, AnimalDetail.class);
			       			newActivity0.putExtra("id", position);
			                startActivity(newActivity0);
			                break;
			                
			       case 1:  Intent newActivity1 = new Intent(AnimalListActivity.this, AnimalDetail.class); 
			       			newActivity1.putExtra("id", position);
			                startActivity(newActivity1);
			                break;
			    
			       case 2:  Intent newActivity2 = new Intent(AnimalListActivity.this, AnimalDetail.class); 
			       			newActivity2.putExtra("id", position);
			                startActivity(newActivity2);
			                break;
			       
			       case 3:  Intent newActivity3 = new Intent(AnimalListActivity.this, AnimalDetail.class);     
			       			newActivity3.putExtra("id", position);         
			       			startActivity(newActivity3);
			                break;
			       
			       case 4: 	final AlertDialog.Builder b = new AlertDialog.Builder(AnimalListActivity.this);
			       				
			       				b.setTitle("Caution!!")
			       				
			       				.setIcon(R.drawable.caution)
			       				
			       				.setMessage("The animal you are about to see is scary!! Do you want to continue?")
			       				
			       				.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			       					@Override
			       					public void onClick(DialogInterface dialog, int which) {
			       						dialog.dismiss();
			       						Intent newActivity4 = new Intent(AnimalListActivity.this, AnimalDetail.class);              
			       						newActivity4.putExtra("id", 4);
			       						startActivity(newActivity4);   
			       					}
			       				})

			       				.setNegativeButton("NO", new DialogInterface.OnClickListener() {
			       					@Override
			       					public void onClick(DialogInterface dialog, int which) {
			       						dialog.dismiss();
			       					}
			       				})
			       				.create()
			       				.show();
			       			break;
			    }

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
        	Intent newActivity = new Intent(AnimalListActivity.this, ZooInformation.class);
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


class CustomAdapter extends ArrayAdapter<String> {
    int size = 1;
    Context context;
    int[] icons;
    String[] name;

    CustomAdapter(Context c, String[] name, int imgs[]) {
        super(c, R.layout.list_row, R.id.textView1, name);
        this.context = c;
        this.icons = imgs;
        this.name = name;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
       
    	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_row, parent, false);
        
        ImageView icon = (ImageView) row.findViewById(R.id.imageView1);
        icon.setImageResource(icons[position]);
        
        TextView animal_name = (TextView) row.findViewById(R.id.textView1);
        animal_name.setText(name[position]);
        
        return row;
    }

}

