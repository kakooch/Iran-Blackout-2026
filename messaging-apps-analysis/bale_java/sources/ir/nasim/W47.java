package ir.nasim;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.background.systemjob.SystemJobService;
import ir.nasim.C21563tl1;
import java.util.Iterator;

/* loaded from: classes2.dex */
class W47 {
    private static final String b = HI3.f("SystemJobInfoConverter");
    private final ComponentName a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC22806vr4.values().length];
            a = iArr;
            try {
                iArr[EnumC22806vr4.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC22806vr4.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC22806vr4.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC22806vr4.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC22806vr4.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    W47(Context context) {
        this.a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri b(C21563tl1.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    static int c(EnumC22806vr4 enumC22806vr4) {
        int i = a.a[enumC22806vr4.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5 && Build.VERSION.SDK_INT >= 26) {
            return 4;
        }
        HI3.c().a(b, String.format("API version too low. Cannot convert network type value %s", enumC22806vr4), new Throwable[0]);
        return 1;
    }

    static void d(JobInfo.Builder builder, EnumC22806vr4 enumC22806vr4) {
        if (Build.VERSION.SDK_INT < 30 || enumC22806vr4 != EnumC22806vr4.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(enumC22806vr4));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    JobInfo a(C17810nb8 c17810nb8, int i) {
        C18424oe1 c18424oe1 = c17810nb8.j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", c17810nb8.a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", c17810nb8.d());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.a).setRequiresCharging(c18424oe1.g()).setRequiresDeviceIdle(c18424oe1.h()).setExtras(persistableBundle);
        d(extras, c18424oe1.b());
        if (!c18424oe1.h()) {
            extras.setBackoffCriteria(c17810nb8.m, c17810nb8.l == EnumC9756aW.LINEAR ? 0 : 1);
        }
        long jMax = Math.max(c17810nb8.a() - System.currentTimeMillis(), 0L);
        if (Build.VERSION.SDK_INT <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!c17810nb8.q) {
            extras.setImportantWhileForeground(true);
        }
        if (c18424oe1.e()) {
            Iterator it = c18424oe1.a().b().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(b((C21563tl1.a) it.next()));
            }
            extras.setTriggerContentUpdateDelay(c18424oe1.c());
            extras.setTriggerContentMaxDelay(c18424oe1.d());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(c18424oe1.f());
            extras.setRequiresStorageNotLow(c18424oe1.i());
        }
        boolean z = c17810nb8.k > 0;
        boolean z2 = jMax > 0;
        if (C7139Ql0.c() && c17810nb8.q && !z && !z2) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}
