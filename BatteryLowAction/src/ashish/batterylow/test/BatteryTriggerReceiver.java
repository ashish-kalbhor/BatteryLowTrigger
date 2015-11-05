package ashish.batterylow.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BatteryTriggerReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent) 
	{
		String trigger = intent.getStringExtra("trigger");
		
		// Battery low broadcast is received from the BatteryLow Trigger
		if ( "BATTERY_LOW".equals(trigger) )
		{
			Toast.makeText(context, "Battery Low", Toast.LENGTH_LONG).show();
		}
	}

}
