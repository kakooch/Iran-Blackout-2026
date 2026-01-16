package com.google.firebase.messaging;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import ir.nasim.AbstractC3993Df5;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.C4982Hj7;
import ir.nasim.ExecutorC4596Fu5;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
abstract class r {
    private static boolean b(Context context) {
        return Binder.getCallingUid() == context.getApplicationInfo().uid;
    }

    static void c(Context context) {
        if (s.b(context)) {
            return;
        }
        e(new ExecutorC4596Fu5(), context, f(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Context context, boolean z, C4982Hj7 c4982Hj7) {
        try {
            if (!b(context)) {
                Log.e("FirebaseMessaging", "error configuring notification delegate for package " + context.getPackageName());
                return;
            }
            s.c(context, true);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (z) {
                notificationManager.setNotificationDelegate("com.google.android.gms");
            } else if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                notificationManager.setNotificationDelegate(null);
            }
        } finally {
            c4982Hj7.e(null);
        }
    }

    static Task e(Executor executor, final Context context, final boolean z) {
        if (!AbstractC3993Df5.j()) {
            return AbstractC9078Yj7.e(null);
        }
        final C4982Hj7 c4982Hj7 = new C4982Hj7();
        executor.execute(new Runnable() { // from class: com.google.firebase.messaging.q
            @Override // java.lang.Runnable
            public final void run() {
                r.d(context, z, c4982Hj7);
            }
        });
        return c4982Hj7.a();
    }

    private static boolean f(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            Context applicationContext = context.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_notification_delegation_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_messaging_notification_delegation_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
