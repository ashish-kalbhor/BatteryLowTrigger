
package ashish.triggers.batterylowtrigger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/**
 * BatteryLowTrigger is fired when the device battery level
 * is below the given threshold.
 * 
 * @author "Ashish Kalbhor"
 */
public class BatteryLowTrigger extends BroadcastReceiver 
{
	/**
	 * Android's Application Context
	 */
	private Context context = null;


	public void onCreate(Context context)
	{
		this.context = context;
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_BATTERY_CHANGED);
		context.registerReceiver(this.getBroadCastReceiver(), filter);
	}


	public BroadcastReceiver getBroadCastReceiver()
	{
		return this;
	}


	public void onDestroy()
	{
		this.context.unregisterReceiver(this.getBroadCastReceiver());

	}


	@Override
	public void onReceive(Context context, Intent intent)
	{

		Log.d("BroadCastReceiver", intent.toString());
		String action = intent.getAction();
		int rawlevel = intent.getIntExtra("level", -1);
		int scale = intent.getIntExtra("scale", -1);
		int level = -1;
		if ( rawlevel >= 0 && scale > 0 )
		{
			level = rawlevel * 100 / scale;
		}

		if ( level > 20 )
		{
			Intent bcIntent = new Intent("BatteryLowTrigger");
			bcIntent.putExtra("trigger", "BATTERY_OKAY");
			context.sendBroadcast(bcIntent);
		}
		else
		{
			Intent bcIntent = new Intent("BatteryLowTrigger");
			bcIntent.putExtra("trigger", "BATTERY_LOW");
			context.sendBroadcast(bcIntent);
		}

	}

}