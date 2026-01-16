package ir.nasim;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: ir.nasim.b27, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10080b27 {
    public static final C10080b27 a = new C10080b27();

    private C10080b27() {
    }

    public static final Uri a(Cursor cursor) {
        AbstractC13042fc3.i(cursor, "cursor");
        Uri notificationUri = cursor.getNotificationUri();
        AbstractC13042fc3.h(notificationUri, "cursor.notificationUri");
        return notificationUri;
    }

    public static final boolean b(ActivityManager activityManager) {
        AbstractC13042fc3.i(activityManager, "activityManager");
        return activityManager.isLowRamDevice();
    }
}
