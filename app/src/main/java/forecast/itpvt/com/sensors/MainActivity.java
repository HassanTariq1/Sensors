package forecast.itpvt.com.sensors;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements SensorEventListener{


    TextView text, txt1;

    SensorManager sensor;

    boolean run= false;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

text= (TextView) findViewById(R.id.info);
txt1=(TextView) findViewById(R.id.steps);

sensor=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        
    }

    @Override
    protected void onResume() {
        super.onResume();

        run=true;

        Sensor count= sensor.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if(count!=null){

            sensor.registerListener(this, count, SensorManager.SENSOR_DELAY_UI);



        }
        else {

            Toast.makeText(getApplicationContext(),"no Sensor", Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    protected void onPause() {
        super.onPause();

        run=false;

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

if(run){

    txt1.setText(String.valueOf(sensorEvent.values[0]));

    // for light sensors
//    if(sensorEvent.sensor.getType()== Sensor.TYPE_LIGHT);
//    txt1.setText(""+sensorEvent.values[0]);


}

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
