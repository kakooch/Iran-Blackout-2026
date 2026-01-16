package org.linphone.core.tools.compatibility;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.SurfaceTexture;
import android.media.AudioAttributes;
import android.media.Ringtone;
import android.os.Vibrator;
import android.provider.ContactsContract;
import java.util.Map;
import org.linphone.core.Address;
import org.linphone.core.tools.Log;
import org.linphone.mediastream.Version;

/* loaded from: classes3.dex */
public class DeviceUtils {
    public static boolean isAppUserRestricted(Context context) {
        if (Version.sdkAboveOrEqual(28)) {
            return DeviceUtils28.isAppUserRestricted(context);
        }
        return false;
    }

    public static int getAppStandbyBucket(Context context) {
        if (Version.sdkAboveOrEqual(28)) {
            return DeviceUtils28.getAppStandbyBucket(context);
        }
        return 0;
    }

    public static String getAppStandbyBucketNameFromValue(int i) {
        if (Version.sdkAboveOrEqual(28)) {
            return DeviceUtils28.getAppStandbyBucketNameFromValue(i);
        }
        return null;
    }

    public static boolean isAppBatteryOptimizationEnabled(Context context) {
        if (Version.sdkAboveOrEqual(23)) {
            return DeviceUtils23.isAppBatteryOptimizationEnabled(context);
        }
        return false;
    }

    public static boolean isSurfaceTextureReleased(SurfaceTexture surfaceTexture) {
        if (Version.sdkAboveOrEqual(26)) {
            return DeviceUtils26.isSurfaceTextureReleased(surfaceTexture);
        }
        return false;
    }

    public static void logPreviousCrashesIfAny(Context context) {
        if (Version.sdkAboveOrEqual(31)) {
            DeviceUtils31.logPreviousCrashesIfAny(context);
        } else if (Version.sdkAboveOrEqual(30)) {
            DeviceUtils30.logPreviousCrashesIfAny(context);
        }
    }

    public static void vibrate(Vibrator vibrator) {
        if (Version.sdkAboveOrEqual(26)) {
            DeviceUtils26.vibrate(vibrator);
        } else {
            DeviceUtils23.vibrate(vibrator);
        }
    }

    public static int getPerformanceClass() {
        if (Version.sdkAboveOrEqual(31)) {
            return DeviceUtils31.getPerformanceClass();
        }
        return -1;
    }

    public static boolean isBluetoothConnectPermissionGranted(Context context) {
        if (Version.sdkAboveOrEqual(31)) {
            return DeviceUtils31.isBluetoothConnectPermissionGranted(context);
        }
        return true;
    }

    public static void playRingtone(Ringtone ringtone, AudioAttributes audioAttributes) throws IllegalArgumentException {
        if (Version.sdkAboveOrEqual(28)) {
            DeviceUtils28.playRingtone(ringtone, audioAttributes);
        } else {
            DeviceUtils23.playRingtone(ringtone, audioAttributes);
        }
    }

    public static boolean checkIfDoNotDisturbAllowsExceptionForFavoriteContacts(Context context) {
        try {
            return ((NotificationManager) context.getSystemService("notification")).getNotificationPolicy().priorityCallSenders == 2;
        } catch (SecurityException e) {
            Log.e("[Device Utils] Can't check notification policy: " + e);
            return false;
        }
    }

    public static boolean checkIfIsFavoriteContact(Context context, Address address) {
        if (address == null) {
            return false;
        }
        if (context.checkSelfPermission("android.permission.READ_CONTACTS") != 0) {
            Log.e("[Device Utils] Can't check for favorite contact, permission hasn't been granted yet");
            return false;
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"starred"}, "data4 LIKE ? OR data1 LIKE ?", new String[]{address.getUsername(), address.asStringUriOnly()}, null);
            while (cursorQuery != null && cursorQuery.moveToNext()) {
                if (cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("starred")) == 1) {
                    Log.i("[Device Utils] Found phone number or SIP address in favorite contact");
                    cursorQuery.close();
                    return true;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (IllegalArgumentException e) {
            Log.e("[Device Utils] Failed to check if username / SIP address is part of a favorite contact: ", e);
        }
        return false;
    }

    public static String getStringOrDefaultFromMap(Map<String, String> map, String str, String str2) {
        if (Version.sdkAboveOrEqual(24)) {
            return DeviceUtils24.getStringOrDefaultFromMap(map, str, str2);
        }
        return DeviceUtils23.getStringOrDefaultFromMap(map, str, str2);
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (Version.sdkAboveOrEqual(26)) {
            DeviceUtils26.startForegroundService(context, intent);
        } else {
            DeviceUtils23.startForegroundService(context, intent);
        }
    }

    public static void startCallForegroundService(Service service, int i, Notification notification) {
        if (Version.sdkAboveOrEqual(34)) {
            DeviceUtils34.startCallForegroundService(service, i, notification);
        } else if (Version.sdkAboveOrEqual(31)) {
            DeviceUtils31.startForegroundService(service, i, notification);
        } else {
            DeviceUtils23.startForegroundService(service, i, notification);
        }
    }

    public static void startDataSyncForegroundService(Service service, int i, Notification notification) {
        if (Version.sdkAboveOrEqual(34)) {
            DeviceUtils34.startDataSyncForegroundService(service, i, notification);
        } else if (Version.sdkAboveOrEqual(31)) {
            DeviceUtils31.startForegroundService(service, i, notification);
        } else {
            DeviceUtils23.startForegroundService(service, i, notification);
        }
    }
}
