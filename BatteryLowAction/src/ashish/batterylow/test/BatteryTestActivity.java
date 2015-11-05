package ashish.batterylow.test;

import android.app.Activity;
import android.os.Bundle;
import ashish.triggers.batterylowtrigger.BatteryLowTrigger;

public class BatteryTestActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battery_test);
		
		BatteryLowTrigger b = new BatteryLowTrigger();
		
	}
}
