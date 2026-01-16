package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC12468ef8;
import ir.nasim.C4982Hj7;

/* loaded from: classes3.dex */
abstract class C extends AbstractC12468ef8 {
    protected final C4982Hj7 b;

    public C(int i, C4982Hj7 c4982Hj7) {
        super(i);
        this.b = c4982Hj7;
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void a(Status status) {
        this.b.d(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void b(Exception exc) {
        this.b.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void c(s sVar) throws DeadObjectException {
        try {
            h(sVar);
        } catch (DeadObjectException e) {
            a(H.e(e));
            throw e;
        } catch (RemoteException e2) {
            a(H.e(e2));
        } catch (RuntimeException e3) {
            this.b.d(e3);
        }
    }

    protected abstract void h(s sVar);
}
