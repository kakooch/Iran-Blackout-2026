package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: ir.nasim.cl0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11286cl0 extends AbstractC15469je1 {
    private static final String h = HI3.f("BrdcstRcvrCnstrntTrckr");
    private final BroadcastReceiver g;

    /* renamed from: ir.nasim.cl0$a */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                AbstractC11286cl0.this.h(context, intent);
            }
        }
    }

    public AbstractC11286cl0(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        super(context, interfaceC5684Kj7);
        this.g = new a();
    }

    @Override // ir.nasim.AbstractC15469je1
    public void e() {
        HI3.c().a(h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.registerReceiver(this.g, g());
    }

    @Override // ir.nasim.AbstractC15469je1
    public void f() {
        HI3.c().a(h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.unregisterReceiver(this.g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, Intent intent);
}
