package com.yahoo.tipcalculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
        
        bTip10       = (Button)   findViewById(R.id.bTip10);
        bTip15       = (Button)   findViewById(R.id.bTip15);
        bTip20       = (Button)   findViewById(R.id.bTip20);
        
        bTip10.setTag(10);
        bTip15.setTag(15);
        bTip20.setTag(20);
        
//        bTip10.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				tvTipAmount.setText("Tip is: " + calculateTip(etBillAmount.getText().toString(), Double.parseDouble(bTip10.getTag().toString())));
//				lastTipPercent = 10;
//				inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//			}
//		});
//        
//        bTip15.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				tvTipAmount.setText("Tip is: " + calculateTip(etBillAmount.getText().toString(), 15));
//				lastTipPercent = 15; 
//				inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//			}
//		});
//        
//        bTip20.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				tvTipAmount.setText("Tip is: " + calculateTip(etBillAmount.getText().toString(), 20));
//				lastTipPercent = 20;
//				
//			}
//		});
    }
    
    public void calculateTipFunction(View v) {
    	etBillAmount = (EditText) findViewById(R.id.etBillAmount);
    	tvTipAmount  = (TextView) findViewById(R.id.tvTipText);
    	
    	final InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    	
    	double tip = Double.parseDouble(etBillAmount.getText().toString()) * Double.parseDouble(v.getTag().toString()) / 100;
    	
    	tvTipAmount.setText("Tip is: " + String.format("%.2f", tip));
    	inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
    
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    
    
}
