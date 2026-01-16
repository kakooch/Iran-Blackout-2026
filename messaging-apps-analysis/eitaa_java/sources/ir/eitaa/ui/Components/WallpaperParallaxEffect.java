package ir.eitaa.ui.Components;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class WallpaperParallaxEffect implements SensorEventListener {
    private Sensor accelerometer;
    private int bufferOffset;
    private Callback callback;
    private boolean enabled;
    private SensorManager sensorManager;
    private WindowManager wm;
    private float[] rollBuffer = new float[3];
    private float[] pitchBuffer = new float[3];

    public interface Callback {
        void onOffsetsChanged(int offsetX, int offsetY, float angle);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public WallpaperParallaxEffect(Context context) {
        this.wm = (WindowManager) context.getSystemService("window");
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.sensorManager = sensorManager;
        this.accelerometer = sensorManager.getDefaultSensor(1);
    }

    public void setEnabled(boolean enabled) {
        if (this.enabled != enabled) {
            this.enabled = enabled;
            Sensor sensor = this.accelerometer;
            if (sensor == null) {
                return;
            }
            if (enabled) {
                this.sensorManager.registerListener(this, sensor, 1);
            } else {
                this.sensorManager.unregisterListener(this);
            }
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public float getScale(int boundsWidth, int boundsHeight) {
        float f = boundsWidth;
        float fDp = AndroidUtilities.dp(16.0f) * 2;
        float f2 = (f + fDp) / f;
        float f3 = boundsHeight;
        return Math.max(f2, (fDp + f3) / f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSensorChanged(android.hardware.SensorEvent r17) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.WallpaperParallaxEffect.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
