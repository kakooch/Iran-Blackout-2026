package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.impl.background.systemalarm.e;
import ir.nasim.AbstractC24092y18;
import ir.nasim.HI3;

/* loaded from: classes2.dex */
public class SystemAlarmService extends LifecycleService implements e.c {
    private static final String d = HI3.f("SystemAlarmService");
    private e b;
    private boolean c;

    private void e() {
        e eVar = new e(this);
        this.b = eVar;
        eVar.m(this);
    }

    @Override // androidx.work.impl.background.systemalarm.e.c
    public void b() {
        this.c = true;
        HI3.c().a(d, "All commands completed in dispatcher", new Throwable[0]);
        AbstractC24092y18.a();
        stopSelf();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
        this.c = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.c = true;
        this.b.j();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.c) {
            HI3.c().d(d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.b.j();
            e();
            this.c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.b.a(intent, i2);
        return 3;
    }
}
