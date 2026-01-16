package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;

/* renamed from: ir.nasim.nf8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class BinderC17850nf8 extends AbstractBinderC11856df8 implements c.a, c.b {
    private static final a.AbstractC0169a n = AbstractC20230rf8.c;
    private final Context a;
    private final Handler h;
    private final a.AbstractC0169a i;
    private final Set j;
    private final C23773xV0 k;
    private InterfaceC22690vf8 l;
    private InterfaceC17259mf8 m;

    public BinderC17850nf8(Context context, Handler handler, C23773xV0 c23773xV0) {
        a.AbstractC0169a abstractC0169a = n;
        this.a = context;
        this.h = handler;
        this.k = (C23773xV0) AbstractC3795Cj5.k(c23773xV0, "ClientSettings must not be null");
        this.j = c23773xV0.g();
        this.i = abstractC0169a;
    }

    static /* bridge */ /* synthetic */ void D2(BinderC17850nf8 binderC17850nf8, zak zakVar) {
        ConnectionResult connectionResultP = zakVar.P();
        if (connectionResultP.x0()) {
            zav zavVar = (zav) AbstractC3795Cj5.j(zakVar.S());
            ConnectionResult connectionResultP2 = zavVar.P();
            if (!connectionResultP2.x0()) {
                String strValueOf = String.valueOf(connectionResultP2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                binderC17850nf8.m.c(connectionResultP2);
                binderC17850nf8.l.c();
                return;
            }
            binderC17850nf8.m.b(zavVar.S(), binderC17850nf8.j);
        } else {
            binderC17850nf8.m.c(connectionResultP);
        }
        binderC17850nf8.l.c();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.common.api.a$f, ir.nasim.vf8] */
    public final void E2(InterfaceC17259mf8 interfaceC17259mf8) {
        InterfaceC22690vf8 interfaceC22690vf8 = this.l;
        if (interfaceC22690vf8 != null) {
            interfaceC22690vf8.c();
        }
        this.k.k(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0169a abstractC0169a = this.i;
        Context context = this.a;
        Looper looper = this.h.getLooper();
        C23773xV0 c23773xV0 = this.k;
        this.l = abstractC0169a.a(context, looper, c23773xV0, c23773xV0.h(), this, this);
        this.m = interfaceC17259mf8;
        Set set = this.j;
        if (set == null || set.isEmpty()) {
            this.h.post(new RunnableC16077kf8(this));
        } else {
            this.l.j();
        }
    }

    public final void F2() {
        InterfaceC22690vf8 interfaceC22690vf8 = this.l;
        if (interfaceC22690vf8 != null) {
            interfaceC22690vf8.c();
        }
    }

    @Override // ir.nasim.InterfaceC23286wf8
    public final void T(zak zakVar) {
        this.h.post(new RunnableC16668lf8(this, zakVar));
    }

    @Override // ir.nasim.InterfaceC17823nd1
    public final void onConnected(Bundle bundle) {
        this.l.g(this);
    }

    @Override // ir.nasim.ZI4
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.m.c(connectionResult);
    }

    @Override // ir.nasim.InterfaceC17823nd1
    public final void onConnectionSuspended(int i) {
        this.l.c();
    }
}
