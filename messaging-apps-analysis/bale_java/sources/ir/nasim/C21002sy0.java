package ir.nasim;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.PowerManager;
import java.util.concurrent.TimeUnit;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.sy0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21002sy0 implements SensorEventListener {
    private boolean a;
    private AudioManager b;
    private SensorManager c;
    private final PowerManager d;
    private Sensor e;
    private PowerManager.WakeLock f;

    public C21002sy0() {
        C5721Ko c5721Ko = C5721Ko.a;
        Object systemService = c5721Ko.d().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.b = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        Object systemService2 = c5721Ko.d().getSystemService("sensor");
        this.c = systemService2 instanceof SensorManager ? (SensorManager) systemService2 : null;
        Object systemService3 = c5721Ko.d().getSystemService("power");
        PowerManager powerManager = systemService3 instanceof PowerManager ? (PowerManager) systemService3 : null;
        this.d = powerManager;
        SensorManager sensorManager = this.c;
        this.e = sensorManager != null ? sensorManager.getDefaultSensor(8) : null;
        this.f = powerManager != null ? powerManager.newWakeLock(32, "bale:voice_call_proximity_manager") : null;
    }

    private final boolean a(float f) {
        if (f < 5.0f) {
            Sensor sensor = this.e;
            if (!AbstractC13042fc3.a(f, sensor != null ? Float.valueOf(sensor.getMaximumRange()) : null)) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        PowerManager.WakeLock wakeLock = this.f;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        wakeLock.release();
    }

    public final void c() {
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        SensorManager sensorManager2 = this.c;
        if (sensorManager2 != null) {
            sensorManager2.registerListener(this, this.e, 3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        AudioManager audioManager;
        AbstractC13042fc3.i(sensorEvent, "event");
        if (sensorEvent.sensor.getType() != 8) {
            return;
        }
        boolean z = false;
        float f = sensorEvent.values[0];
        C19406qI3.a("bale:voice_call_proximity_manager", "the distance is: " + f, new Object[0]);
        if (a(f) && (audioManager = this.b) != null && !audioManager.isWiredHeadsetOn()) {
            z = true;
        }
        if (this.a == z) {
            return;
        }
        this.a = z;
        if (z) {
            PowerManager.WakeLock wakeLock = this.f;
            if (wakeLock == null || wakeLock.isHeld()) {
                return;
            }
            wakeLock.acquire(TimeUnit.MINUTES.toMillis(30L));
            return;
        }
        PowerManager.WakeLock wakeLock2 = this.f;
        if (wakeLock2 == null || !wakeLock2.isHeld()) {
            return;
        }
        wakeLock2.release(1);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
