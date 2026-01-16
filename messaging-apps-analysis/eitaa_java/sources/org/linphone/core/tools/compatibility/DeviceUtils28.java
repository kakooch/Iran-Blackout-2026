package org.linphone.core.tools.compatibility;

import android.app.ActivityManager;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.Ringtone;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class DeviceUtils28 {
    public static String getAppStandbyBucketNameFromValue(int i) {
        if (i == 10) {
            return "STANDBY_BUCKET_ACTIVE";
        }
        if (i == 20) {
            return "STANDBY_BUCKET_WORKING_SET";
        }
        if (i == 30) {
            return "STANDBY_BUCKET_FREQUENT";
        }
        if (i != 40) {
            return null;
        }
        return "STANDBY_BUCKET_RARE";
    }

    public static boolean isAppUserRestricted(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).isBackgroundRestricted();
    }

    public static int getAppStandbyBucket(Context context) {
        return ((UsageStatsManager) context.getSystemService("usagestats")).getAppStandbyBucket();
    }

    public static void playRingtone(Ringtone ringtone, AudioAttributes audioAttributes) throws IllegalArgumentException {
        ringtone.setAudioAttributes(audioAttributes);
        ringtone.setLooping(true);
        ringtone.play();
        Log.i("[Audio Helper] Ringtone ringing started (looping)");
    }
}
