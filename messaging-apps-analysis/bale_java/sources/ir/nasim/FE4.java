package ir.nasim;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

/* loaded from: classes2.dex */
public abstract class FE4 {
    public static void a(Context context, String str, int i, int i2, int i3) {
        if (AbstractC9683aN7.a >= 26) {
            NotificationManager notificationManager = (NotificationManager) AbstractC20011rK.e((NotificationManager) context.getSystemService("notification"));
            EE4.a();
            NotificationChannel notificationChannelA = ZC4.a(str, context.getString(i), i3);
            if (i2 != 0) {
                notificationChannelA.setDescription(context.getString(i2));
            }
            notificationManager.createNotificationChannel(notificationChannelA);
        }
    }
}
