package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import ir.nasim.HI3;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public class Za8 extends Ya8 {
    private static final String j = HI3.f("WorkManagerImpl");
    private static Za8 k = null;
    private static Za8 l = null;
    private static final Object m = new Object();
    private Context a;
    private androidx.work.a b;
    private WorkDatabase c;
    private InterfaceC5684Kj7 d;
    private List e;
    private C13231fs5 f;
    private C19079pk5 g;
    private boolean h;
    private BroadcastReceiver.PendingResult i;

    public Za8(Context context, androidx.work.a aVar, InterfaceC5684Kj7 interfaceC5684Kj7) {
        this(context, aVar, interfaceC5684Kj7, context.getResources().getBoolean(AbstractC22403vA5.workmanager_test_configuration));
    }

    public static void e(Context context, androidx.work.a aVar) {
        synchronized (m) {
            try {
                Za8 za8 = k;
                if (za8 != null && l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (za8 == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (l == null) {
                        l = new Za8(applicationContext, aVar, new C9811ab8(aVar.l()));
                    }
                    k = l;
                }
            } finally {
            }
        }
    }

    public static Za8 j() {
        synchronized (m) {
            try {
                Za8 za8 = k;
                if (za8 != null) {
                    return za8;
                }
                return l;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Za8 k(Context context) {
        Za8 za8J;
        synchronized (m) {
            try {
                za8J = j();
                if (za8J == null) {
                    context.getApplicationContext();
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return za8J;
    }

    private void q(Context context, androidx.work.a aVar, InterfaceC5684Kj7 interfaceC5684Kj7, WorkDatabase workDatabase, List list, C13231fs5 c13231fs5) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = aVar;
        this.d = interfaceC5684Kj7;
        this.c = workDatabase;
        this.e = list;
        this.f = c13231fs5;
        this.g = new C19079pk5(workDatabase);
        this.h = false;
        if (applicationContext.isDeviceProtectedStorage()) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.d.b(new ForceStopRunnable(applicationContext, this));
    }

    @Override // ir.nasim.Ya8
    public InterfaceC15297jL4 a(String str) {
        CE0 ce0D = CE0.d(str, this);
        this.d.b(ce0D);
        return ce0D.e();
    }

    @Override // ir.nasim.Ya8
    public InterfaceC15297jL4 c(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new Pa8(this, list).a();
    }

    public InterfaceC15297jL4 f(UUID uuid) {
        CE0 ce0B = CE0.b(uuid, this);
        this.d.b(ce0B);
        return ce0B.e();
    }

    public List g(Context context, androidx.work.a aVar, InterfaceC5684Kj7 interfaceC5684Kj7) {
        return Arrays.asList(AbstractC10449bd6.a(context, this), new C9660aL2(context, aVar, interfaceC5684Kj7, this));
    }

    public Context h() {
        return this.a;
    }

    public androidx.work.a i() {
        return this.b;
    }

    public C19079pk5 l() {
        return this.g;
    }

    public C13231fs5 m() {
        return this.f;
    }

    public List n() {
        return this.e;
    }

    public WorkDatabase o() {
        return this.c;
    }

    public InterfaceC5684Kj7 p() {
        return this.d;
    }

    public void r() {
        synchronized (m) {
            try {
                this.h = true;
                BroadcastReceiver.PendingResult pendingResult = this.i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void s() {
        X47.b(h());
        o().Q().k();
        AbstractC10449bd6.b(i(), o(), n());
    }

    public void t(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (m) {
            try {
                this.i = pendingResult;
                if (this.h) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void u(String str) {
        v(str, null);
    }

    public void v(String str, WorkerParameters.a aVar) {
        this.d.b(new MK6(this, str, aVar));
    }

    public void w(String str) {
        this.d.b(new JN6(this, str, true));
    }

    public void x(String str) {
        this.d.b(new JN6(this, str, false));
    }

    public Za8(Context context, androidx.work.a aVar, InterfaceC5684Kj7 interfaceC5684Kj7, boolean z) {
        this(context, aVar, interfaceC5684Kj7, WorkDatabase.H(context.getApplicationContext(), interfaceC5684Kj7.c(), z));
    }

    public Za8(Context context, androidx.work.a aVar, InterfaceC5684Kj7 interfaceC5684Kj7, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        HI3.e(new HI3.a(aVar.j()));
        List listG = g(applicationContext, aVar, interfaceC5684Kj7);
        q(context, aVar, interfaceC5684Kj7, workDatabase, listG, new C13231fs5(context, aVar, interfaceC5684Kj7, workDatabase, listG));
    }
}
