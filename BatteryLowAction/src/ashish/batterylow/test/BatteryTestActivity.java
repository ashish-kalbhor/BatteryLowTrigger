package ashish.batterylow.test;

import android.app.Activity;
import android.os.Bundle;
import ashish.triggers.batterylowtrigger.BatteryLowTrigger;

/**
 * Test Activity which will show some action,
 * whenever a Low Battery Trigger is raised.
 * @author Ashish
 *
 */
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
