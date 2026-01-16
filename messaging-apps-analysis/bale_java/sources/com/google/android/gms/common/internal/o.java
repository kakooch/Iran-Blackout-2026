package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import ir.nasim.Vp8;

/* loaded from: classes3.dex */
final class o extends Vp8 {
    final /* synthetic */ b b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(b bVar, Looper looper) {
        super(looper);
        this.b = bVar;
    }

    private static final void a(Message message) {
        p pVar = (p) message.obj;
        pVar.b();
        pVar.e();
    }

    private static final boolean b(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.b.D.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i = message.what;
        if ((i == 1 || i == 7 || ((i == 4 && !this.b.t()) || message.what == 5)) && !this.b.d()) {
            a(message);
            return;
        }
        int i2 = message.what;
        if (i2 == 4) {
            this.b.z = new ConnectionResult(message.arg2);
            if (b.h0(this.b)) {
                b bVar = this.b;
                if (!bVar.A) {
                    bVar.i0(3, null);
                    return;
                }
            }
            b bVar2 = this.b;
            ConnectionResult connectionResult = bVar2.z != null ? bVar2.z : new ConnectionResult(8);
            this.b.p.a(connectionResult);
            this.b.L(connectionResult);
            return;
        }
        if (i2 == 5) {
            b bVar3 = this.b;
            ConnectionResult connectionResult2 = bVar3.z != null ? bVar3.z : new ConnectionResult(8);
            this.b.p.a(connectionResult2);
            this.b.L(connectionResult2);
            return;
        }
        if (i2 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.b.p.a(connectionResult3);
            this.b.L(connectionResult3);
            return;
        }
        if (i2 == 6) {
            this.b.i0(5, null);
            b bVar4 = this.b;
            if (bVar4.u != null) {
                bVar4.u.onConnectionSuspended(message.arg2);
            }
            this.b.M(message.arg2);
            b.g0(this.b, 5, 1, null);
            return;
        }
        if (i2 == 2 && !this.b.a()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((p) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
