package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import ir.nasim.H03;
import ir.nasim.HI3;
import ir.nasim.O47;
import ir.nasim.P47;
import ir.nasim.Za8;

/* loaded from: classes2.dex */
abstract class a {
    private static final String a = HI3.f("Alarms");

    public static void a(Context context, Za8 za8, String str) {
        P47 p47N = za8.o().N();
        O47 o47B = p47N.b(str);
        if (o47B != null) {
            b(context, str, o47B.b);
            HI3.c().a(a, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            p47N.d(str);
        }
    }

    private static void b(Context context, String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, b.b(context, str), 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        HI3.c().a(a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i)), new Throwable[0]);
        alarmManager.cancel(service);
    }

    public static void c(Context context, Za8 za8, String str, long j) {
        WorkDatabase workDatabaseO = za8.o();
        P47 p47N = workDatabaseO.N();
        O47 o47B = p47N.b(str);
        if (o47B != null) {
            b(context, str, o47B.b);
            d(context, str, o47B.b, j);
        } else {
            int iB = new H03(workDatabaseO).b();
            p47N.a(new O47(str, iB));
            d(context, str, iB, j);
        }
    }

    private static void d(Context context, String str, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, b.b(context, str), 201326592);
        if (alarmManager != null) {
            alarmManager.setExact(0, j, service);
        }
    }
}
