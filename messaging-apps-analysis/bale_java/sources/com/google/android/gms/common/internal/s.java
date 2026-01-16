package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public final class s extends m {
    public final IBinder g;
    final /* synthetic */ b h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(b bVar, int i, IBinder iBinder, Bundle bundle) {
        super(bVar, i, bundle);
        this.h = bVar;
        this.g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.m
    protected final void f(ConnectionResult connectionResult) {
        if (this.h.v != null) {
            this.h.v.onConnectionFailed(connectionResult);
        }
        this.h.L(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.m
    protected final boolean g() throws RemoteException {
        try {
            IBinder iBinder = this.g;
            AbstractC3795Cj5.j(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.h.E().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.h.E() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceS = this.h.s(this.g);
            if (iInterfaceS == null || !(b.g0(this.h, 2, 4, iInterfaceS) || b.g0(this.h, 3, 4, iInterfaceS))) {
                return false;
            }
            this.h.z = null;
            b bVar = this.h;
            Bundle bundleX = bVar.x();
            if (bVar.u == null) {
                return true;
            }
            this.h.u.onConnected(bundleX);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
