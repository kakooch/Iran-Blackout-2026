package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.b;
import ir.nasim.C9205Yy;
import ir.nasim.InterfaceC17259mf8;
import java.util.Set;

/* loaded from: classes3.dex */
final class v implements b.c, InterfaceC17259mf8 {
    private final a.f a;
    private final C9205Yy b;
    private com.google.android.gms.common.internal.e c = null;
    private Set d = null;
    private boolean e = false;
    final /* synthetic */ C2059c f;

    public v(C2059c c2059c, a.f fVar, C9205Yy c9205Yy) {
        this.f = c2059c;
        this.a = fVar;
        this.b = c9205Yy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        com.google.android.gms.common.internal.e eVar;
        if (!this.e || (eVar = this.c) == null) {
            return;
        }
        this.a.l(eVar, this.d);
    }

    @Override // com.google.android.gms.common.internal.b.c
    public final void a(ConnectionResult connectionResult) {
        this.f.p.post(new u(this, connectionResult));
    }

    @Override // ir.nasim.InterfaceC17259mf8
    public final void b(com.google.android.gms.common.internal.e eVar, Set set) {
        if (eVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            c(new ConnectionResult(4));
        } else {
            this.c = eVar;
            this.d = set;
            h();
        }
    }

    @Override // ir.nasim.InterfaceC17259mf8
    public final void c(ConnectionResult connectionResult) {
        s sVar = (s) this.f.l.get(this.b);
        if (sVar != null) {
            sVar.E(connectionResult);
        }
    }
}
