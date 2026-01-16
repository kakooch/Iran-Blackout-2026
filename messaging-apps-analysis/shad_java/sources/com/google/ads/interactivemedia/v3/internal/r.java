package com.google.ads.interactivemedia.v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.util.Iterator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class r {
    private static final r a = new r();
    private Context b;
    private BroadcastReceiver c;
    private boolean d;
    private boolean e;
    private w f;

    private r() {
    }

    public static r a() {
        return a;
    }

    static /* synthetic */ void f(r rVar, boolean z) {
        if (rVar.e != z) {
            rVar.e = z;
            if (rVar.d) {
                rVar.h();
                if (rVar.f != null) {
                    if (rVar.e()) {
                        aq.b().c();
                    } else {
                        aq.b().e();
                    }
                }
            }
        }
    }

    private final void h() {
        boolean z = this.e;
        Iterator<i> it = p.a().e().iterator();
        while (it.hasNext()) {
            ac acVarH = it.next().h();
            if (acVarH.e()) {
                v.a().g(acVarH.d(), "setState", true != z ? "foregrounded" : "backgrounded");
            }
        }
    }

    public final void b(Context context) {
        this.b = context.getApplicationContext();
    }

    public final void c() {
        this.c = new q(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.b.registerReceiver(this.c, intentFilter);
        this.d = true;
        h();
    }

    public final void d() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.b;
        if (context != null && (broadcastReceiver = this.c) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.c = null;
        }
        this.d = false;
        this.e = false;
        this.f = null;
    }

    public final boolean e() {
        return !this.e;
    }

    public final void g(w wVar) {
        this.f = wVar;
    }
}
