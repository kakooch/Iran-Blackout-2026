package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import ir.nasim.OZ2;

/* loaded from: classes3.dex */
public final class r implements ServiceConnection {
    private final int a;
    final /* synthetic */ b b;

    public r(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b bVar = this.b;
        if (iBinder == null) {
            b.d0(bVar, 16);
            return;
        }
        synchronized (bVar.n) {
            try {
                b bVar2 = this.b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                bVar2.o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof OZ2)) ? new n(iBinder) : (OZ2) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.b.e0(0, null, this.a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.b.n) {
            this.b.o = null;
        }
        b bVar = this.b;
        int i = this.a;
        Handler handler = bVar.l;
        handler.sendMessage(handler.obtainMessage(6, i, 1));
    }
}
