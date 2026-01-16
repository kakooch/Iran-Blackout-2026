package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC12468ef8;
import ir.nasim.C4982Hj7;
import ir.nasim.InterfaceC21248tM6;

/* loaded from: classes3.dex */
public final class F extends AbstractC12468ef8 {
    private final AbstractC2064h b;
    private final C4982Hj7 c;
    private final InterfaceC21248tM6 d;

    public F(int i, AbstractC2064h abstractC2064h, C4982Hj7 c4982Hj7, InterfaceC21248tM6 interfaceC21248tM6) {
        super(i);
        this.c = c4982Hj7;
        this.b = abstractC2064h;
        this.d = interfaceC21248tM6;
        if (i == 2 && abstractC2064h.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void a(Status status) {
        this.c.d(this.d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void b(Exception exc) {
        this.c.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void c(s sVar) throws DeadObjectException {
        try {
            this.b.b(sVar.r(), this.c);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            a(H.e(e2));
        } catch (RuntimeException e3) {
            this.c.d(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void d(C2068l c2068l, boolean z) {
        c2068l.d(this.c, z);
    }

    @Override // ir.nasim.AbstractC12468ef8
    public final boolean f(s sVar) {
        return this.b.c();
    }

    @Override // ir.nasim.AbstractC12468ef8
    public final Feature[] g(s sVar) {
        return this.b.e();
    }
}
