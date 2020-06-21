package team.paradise.qqnicknametail;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Button btn=(Button)findViewById(R.id.btn);
		
		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				EditText nn=(EditText)findViewById(R.id.name);
				EditText tl=(EditText)findViewById(R.id.tail);
				String name=nn.getText().toString();
				String tail=tl.getText().toString();
				if (name.length()==0 || tail.length()==0){
					Toast.makeText(getApplicationContext(),"Please input your nick name and tail!",Toast.LENGTH_LONG).show();
					return;
				}
				String s=name+(char)8238+reverse(tail)+(char)8237;
				ClipboardManager cm=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
				ClipData cd=ClipData.newPlainText(null,s);
				cm.setPrimaryClip(cd);
				Toast.makeText(getApplicationContext(),"Copied",Toast.LENGTH_LONG).show();
			}
			
			public String reverse(String str){
				return new StringBuffer(str).reverse().toString();
			}
		});
    }
}
