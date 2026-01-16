package org.linphone.core.tools.compatibility;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.Ringtone;
import android.os.PowerManager;
import android.os.Vibrator;
import java.util.Map;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class DeviceUtils23 {
    public static boolean isAppBatteryOptimizationEnabled(Context context) {
        boolean zIsIgnoringBatteryOptimizations = ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
        Log.i("[Platform Helper] Is app in device battery optimization whitelist: " + zIsIgnoringBatteryOptimizations);
        return !zIsIgnoringBatteryOptimizations;
    }

    public static void vibrate(Vibrator vibrator) {
        vibrator.vibrate(new long[]{0, 1000, 1000}, 1);
    }

    public static void playRingtone(Ringtone ringtone, AudioAttributes audioAttributes) throws IllegalArgumentException {
        ringtone.setAudioAttributes(audioAttributes);
        ringtone.play();
        Log.i("[Audio Helper] Ringtone ringing started");
    }

    public static String getStringOrDefaultFromMap(Map<String, String> map, String str, String str2) {
        String str3;
        return (!map.containsKey(str) || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public static void startForegroundService(Service service, int i, Notification notification) {
        service.startForeground(i, notification);
    }

    public static void startForegroundService(Context context, Intent intent) {
        context.startService(intent);
    }
}
