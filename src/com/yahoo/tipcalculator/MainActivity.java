package com.yahoo.tipcalculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
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
	
	double lastTipPercent = 0.0;
	
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
        
        etBillAmount = (EditText) findViewById(R.id.etBillAmount);
        
        etBillAmount.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub		
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void afterTextChanged(Editable s) {
		    	etBillAmount = (EditText) findViewById(R.id.etBillAmount);
		    	tvTipAmount  = (TextView) findViewById(R.id.tvTipText);
		    	double tip;
		    	
				if (etBillAmount.getText().toString().isEmpty())
					tip = 0;		    	
				else
					tip = Double.parseDouble(etBillAmount.getText().toString()) * lastTipPercent / 100;
					
		    	tvTipAmount.setText("Tip is: " + String.format("%.2f", tip));
			}
		});        
    }
    
    public void calculateTipFunction(View v) {
    	etBillAmount = (EditText) findViewById(R.id.etBillAmount);
    	tvTipAmount  = (TextView) findViewById(R.id.tvTipText);
    	final InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    	
    	lastTipPercent = Double.parseDouble(v.getTag().toString());
    	double tip = Double.parseDouble(etBillAmount.getText().toString()) * lastTipPercent / 100;
    	
    	tvTipAmount.setText("Tip is: " + String.format("%.2f", tip));
    	inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
    }
}
