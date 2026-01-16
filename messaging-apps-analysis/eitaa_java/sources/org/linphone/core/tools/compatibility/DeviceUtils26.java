package org.linphone.core.tools.compatibility;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;

/* loaded from: classes3.dex */
public class DeviceUtils26 {
    public static boolean isSurfaceTextureReleased(SurfaceTexture surfaceTexture) {
        return surfaceTexture.isReleased();
    }

    public static void vibrate(Vibrator vibrator) {
        vibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, 1000, 1000}, new int[]{0, -1, 0}, 1), new AudioAttributes.Builder().setUsage(6).build());
    }

    public static void startForegroundService(Context context, Intent intent) {
        context.startForegroundService(intent);
    }
}
