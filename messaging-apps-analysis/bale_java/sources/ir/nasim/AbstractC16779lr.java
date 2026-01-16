package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import ir.nasim.C16914m47;

/* renamed from: ir.nasim.lr, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16779lr extends AbstractC10816cF2 implements C16914m47.a {
    private final String a = "AndroidClockSync";
    private SharedPreferences b;
    private C16914m47 c;
    private long d;

    /* renamed from: ir.nasim.lr$a */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C19406qI3.a("AndroidClockSync", "Time changed: invalidating sync", new Object[0]);
            AbstractC16779lr.this.o();
        }
    }

    public AbstractC16779lr() {
        SZ.e(new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.kr
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m();
            }
        })).h(EnumC11723dV1.COMPUTATION));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        SharedPreferences sharedPreferences = C5721Ko.b.getSharedPreferences("time_sync.ini", 0);
        this.b = sharedPreferences;
        this.d = sharedPreferences.getLong("delta", this.d);
        o();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        C5721Ko.b.registerReceiver(new a(), intentFilter);
    }

    private void n() {
        C16914m47 c16914m47 = this.c;
        if (c16914m47 == null) {
            return;
        }
        try {
            c16914m47.interrupt();
            this.c = null;
        } catch (Exception e) {
            C19406qI3.d("AndroidClockSync", e);
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        C19406qI3.a("AndroidClockSync", "Starting sync...", new Object[0]);
        n();
        try {
            C16914m47 c16914m47 = new C16914m47(this);
            this.c = c16914m47;
            c16914m47.setName("T_SyncTime");
            this.c.start();
        } catch (Exception e) {
            C19406qI3.d("AndroidClockSync", e);
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    @Override // ir.nasim.InterfaceC16767lp7
    public U33 b(String str, EnumC9950ap7 enumC9950ap7, int i) {
        return new C15384jV1();
    }

    @Override // ir.nasim.InterfaceC16767lp7
    public long c() {
        return System.currentTimeMillis() + this.d;
    }

    @Override // ir.nasim.C16914m47.a
    public void d(long j) {
        this.d = j;
        this.b.edit().putLong("delta", j).apply();
        n();
    }

    @Override // ir.nasim.InterfaceC16767lp7
    public YU1 i(String str) {
        return new C7165Qo(str);
    }
}
