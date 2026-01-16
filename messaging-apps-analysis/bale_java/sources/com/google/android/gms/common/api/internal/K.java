package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
final class K implements Runnable {
    private final I a;
    final /* synthetic */ L b;

    K(L l, I i) {
        this.b = l;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.b) {
            ConnectionResult connectionResultB = this.a.b();
            if (connectionResultB.s0()) {
                L l = this.b;
                l.a.startActivityForResult(GoogleApiActivity.a(l.b(), (PendingIntent) AbstractC3795Cj5.j(connectionResultB.d0()), this.a.a(), false), 1);
                return;
            }
            L l2 = this.b;
            if (l2.e.b(l2.b(), connectionResultB.P(), null) != null) {
                L l3 = this.b;
                l3.e.v(l3.b(), this.b.a, connectionResultB.P(), 2, this.b);
            } else {
                if (connectionResultB.P() != 18) {
                    this.b.l(connectionResultB, this.a.a());
                    return;
                }
                L l4 = this.b;
                Dialog dialogQ = l4.e.q(l4.b(), this.b);
                L l5 = this.b;
                l5.e.r(l5.b().getApplicationContext(), new J(this, dialogQ));
            }
        }
    }
}
