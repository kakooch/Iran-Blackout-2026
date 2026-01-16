package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import ir.nasim.AbstractC10449bd6;
import ir.nasim.AbstractC7905Tr5;
import ir.nasim.AbstractC9406Zu2;
import ir.nasim.C17810nb8;
import ir.nasim.C7139Ql0;
import ir.nasim.HI3;
import ir.nasim.InterfaceC13655gb8;
import ir.nasim.InterfaceC18401ob8;
import ir.nasim.Qa8;
import ir.nasim.Ta8;
import ir.nasim.X47;
import ir.nasim.Za8;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ForceStopRunnable implements Runnable {
    private static final String d = HI3.f("ForceStopRunnable");
    private static final long e = TimeUnit.DAYS.toMillis(3650);
    private final Context a;
    private final Za8 b;
    private int c = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String a = HI3.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            HI3.c().g(a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.g(context);
        }
    }

    public ForceStopRunnable(Context context, Za8 za8) {
        this.a = context.getApplicationContext();
        this.b = za8;
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, c(context), i);
    }

    static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent pendingIntentD = d(context, C7139Ql0.c() ? 167772160 : 134217728);
        long jCurrentTimeMillis = System.currentTimeMillis() + e;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, pendingIntentD);
        }
    }

    public boolean a() {
        boolean zI = X47.i(this.a, this.b);
        WorkDatabase workDatabaseO = this.b.o();
        InterfaceC18401ob8 interfaceC18401ob8Q = workDatabaseO.Q();
        InterfaceC13655gb8 interfaceC13655gb8P = workDatabaseO.P();
        workDatabaseO.e();
        try {
            List<C17810nb8> listQ = interfaceC18401ob8Q.q();
            boolean z = (listQ == null || listQ.isEmpty()) ? false : true;
            if (z) {
                for (C17810nb8 c17810nb8 : listQ) {
                    interfaceC18401ob8Q.b(Ta8.ENQUEUED, c17810nb8.a);
                    interfaceC18401ob8Q.l(c17810nb8.a, -1L);
                }
            }
            interfaceC13655gb8P.b();
            workDatabaseO.F();
            workDatabaseO.j();
            return z || zI;
        } catch (Throwable th) {
            workDatabaseO.j();
            throw th;
        }
    }

    public void b() {
        boolean zA = a();
        if (h()) {
            HI3.c().a(d, "Rescheduling Workers.", new Throwable[0]);
            this.b.s();
            this.b.l().c(false);
        } else if (e()) {
            HI3.c().a(d, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.b.s();
        } else if (zA) {
            HI3.c().a(d, "Found unfinished work, scheduling it.", new Throwable[0]);
            AbstractC10449bd6.b(this.b.i(), this.b.o(), this.b.n());
        }
    }

    public boolean e() {
        try {
            PendingIntent pendingIntentD = d(this.a, C7139Ql0.c() ? 570425344 : 536870912);
            if (Build.VERSION.SDK_INT >= 30) {
                if (pendingIntentD != null) {
                    pendingIntentD.cancel();
                }
                List historicalProcessExitReasons = ((ActivityManager) this.a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i = 0; i < historicalProcessExitReasons.size(); i++) {
                        if (AbstractC9406Zu2.a(historicalProcessExitReasons.get(i)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (pendingIntentD == null) {
                g(this.a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e2) {
            e = e2;
            HI3.c().h(d, "Ignoring exception", e);
            return true;
        } catch (SecurityException e3) {
            e = e3;
            HI3.c().h(d, "Ignoring exception", e);
            return true;
        }
    }

    public boolean f() {
        a aVarI = this.b.i();
        if (TextUtils.isEmpty(aVarI.c())) {
            HI3.c().a(d, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean zB = AbstractC7905Tr5.b(this.a, aVarI);
        HI3.c().a(d, String.format("Is default app process = %s", Boolean.valueOf(zB)), new Throwable[0]);
        return zB;
    }

    boolean h() {
        return this.b.l().a();
    }

    public void i(long j) throws InterruptedException {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        try {
            if (!f()) {
                return;
            }
            while (true) {
                Qa8.e(this.a);
                HI3.c().a(d, "Performing cleanup operations.", new Throwable[0]);
                try {
                    b();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                    i = this.c + 1;
                    this.c = i;
                    if (i >= 3) {
                        HI3.c().b(d, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        this.b.i().d();
                        throw illegalStateException;
                    }
                    HI3.c().a(d, String.format("Retrying after %s", Long.valueOf(i * 300)), e2);
                    i(this.c * 300);
                }
                HI3.c().a(d, String.format("Retrying after %s", Long.valueOf(i * 300)), e2);
                i(this.c * 300);
            }
        } finally {
            this.b.r();
        }
    }
}
