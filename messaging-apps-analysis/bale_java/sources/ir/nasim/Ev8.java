package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Ev8 extends Pu8 {
    private static Ev8 j;
    private final Handler g;
    private final InterfaceC14986io8 h;
    private final Set i;

    public Ev8(Context context, InterfaceC14986io8 interfaceC14986io8) {
        super(new C16237kv8("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.g = new Handler(Looper.getMainLooper());
        this.i = new LinkedHashSet();
        this.h = interfaceC14986io8;
    }

    public static synchronized Ev8 f(Context context) {
        try {
            if (j == null) {
                j = new Ev8(context, Ws8.INSTANCE);
            }
        } catch (Throwable th) {
            throw th;
        }
        return j;
    }

    @Override // ir.nasim.Pu8
    protected final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra == null) {
            return;
        }
        PI6 pi6J = PI6.j(bundleExtra);
        this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", pi6J);
        Qo8 qo8Zza = this.h.zza();
        if (pi6J.e() != 3 || qo8Zza == null) {
            h(pi6J);
        } else {
            qo8Zza.a(pi6J.i(), new C20392rv8(this, pi6J, intent, context));
        }
    }

    public final synchronized void h(PI6 pi6) {
        Iterator it = new LinkedHashSet(this.i).iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
        super.c(pi6);
    }
}
