package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public final class D extends H {
    protected final AbstractC2058b b;

    public D(int i, AbstractC2058b abstractC2058b) {
        super(i);
        this.b = (AbstractC2058b) AbstractC3795Cj5.k(abstractC2058b, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void a(Status status) {
        try {
            this.b.h(status);
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void b(Exception exc) {
        try {
            this.b.h(new Status(10, exc.getClass().getSimpleName() + ": " + exc.getLocalizedMessage()));
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void c(s sVar) throws DeadObjectException {
        try {
            this.b.f(sVar.r());
        } catch (RuntimeException e) {
            b(e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final void d(C2068l c2068l, boolean z) {
        c2068l.c(this.b, z);
    }
}
