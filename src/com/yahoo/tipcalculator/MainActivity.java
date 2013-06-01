package com.yahoo.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText etBillAmount;
	TextView tvTipAmount;
	
	Button bTip10;
	Button bTip15;
	Button bTip20;
	
	int lastTipPercent = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etBillAmount = (EditText) findViewById(R.id.etBillAmount);
        tvTipAmount  = (TextView) findViewById(R.id.tvTipText);
        
        bTip10       = (Button)   findViewById(R.id.bTip10);
        bTip15       = (Button)   findViewById(R.id.bTip15);
        bTip20       = (Button)   findViewById(R.id.bTip20);      
        
        bTip10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tvTipAmount.setText("Tip is: " + calculateTip(etBillAmount.getText().toString(), 10));
				lastTipPercent = 10;
			}
		});
        
        bTip15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tvTipAmount.setText("Tip is: " + calculateTip(etBillAmount.getText().toString(), 15));
				lastTipPercent = 15;
			}
		});
        
        bTip20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tvTipAmount.setText("Tip is: " + calculateTip(etBillAmount.getText().toString(), 20));
				lastTipPercent = 20;
			}
		});
    }
    
    public double calculateTip(String billAmount, double tipPercent) {
    	return (double) Double.parseDouble(billAmount.toString()) * tipPercent / 100;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
