package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.InterfaceC10069b16;

/* renamed from: com.google.android.gms.common.api.internal.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2058b extends BasePendingResult {
    private final a.c a;
    private final com.google.android.gms.common.api.a b;

    protected AbstractC2058b(com.google.android.gms.common.api.a aVar, com.google.android.gms.common.api.c cVar) {
        super((com.google.android.gms.common.api.c) AbstractC3795Cj5.k(cVar, "GoogleApiClient must not be null"));
        AbstractC3795Cj5.k(aVar, "Api must not be null");
        this.a = aVar.b();
        this.b = aVar;
    }

    private void g(RemoteException remoteException) {
        h(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
    }

    protected abstract void d(a.b bVar);

    public final void f(a.b bVar) throws DeadObjectException {
        try {
            d(bVar);
        } catch (DeadObjectException e) {
            g(e);
            throw e;
        } catch (RemoteException e2) {
            g(e2);
        }
    }

    public final void h(Status status) {
        AbstractC3795Cj5.b(!status.x0(), "Failed result must not be success");
        InterfaceC10069b16 interfaceC10069b16A = a(status);
        setResult(interfaceC10069b16A);
        e(interfaceC10069b16A);
    }

    protected void e(InterfaceC10069b16 interfaceC10069b16) {
    }
}
