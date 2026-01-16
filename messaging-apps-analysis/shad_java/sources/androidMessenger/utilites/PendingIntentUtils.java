package androidMessenger.utilites;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes.dex */
public class PendingIntentUtils {
    public static PendingIntent getPendingIntentActivity(Context context, int i, Intent intent, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getActivity(context, i, intent, i2 | ConnectionsManager.FileTypeFile);
        }
        return PendingIntent.getActivity(context, i, intent, i2);
    }

    public static PendingIntent getPendingIntentBroadcast(Context context, int i, Intent intent, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getBroadcast(context, i, intent, i2 | ConnectionsManager.FileTypeFile);
        }
        return PendingIntent.getBroadcast(context, i, intent, i2);
    }

    public static PendingIntent getPendingIntentService(Context context, int i, Intent intent, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getService(context, i, intent, i2 | ConnectionsManager.FileTypeFile);
        }
        return PendingIntent.getService(context, i, intent, i2);
    }
}
