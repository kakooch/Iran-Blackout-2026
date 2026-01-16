package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import ir.nasim.AbstractC16775lq5;
import ir.nasim.InterfaceC16269kz3;
import ir.nasim.Vf8;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public abstract class L extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean b;
    protected final AtomicReference c;
    private final Handler d;
    protected final com.google.android.gms.common.a e;

    L(InterfaceC16269kz3 interfaceC16269kz3, com.google.android.gms.common.a aVar) {
        super(interfaceC16269kz3);
        this.c = new AtomicReference(null);
        this.d = new Vf8(Looper.getMainLooper());
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(ConnectionResult connectionResult, int i) {
        this.c.set(null);
        m(connectionResult, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.c.set(null);
        n();
    }

    private static final int p(I i) {
        if (i == null) {
            return -1;
        }
        return i.a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e(int i, int i2, Intent intent) {
        I i3 = (I) this.c.get();
        if (i != 1) {
            if (i == 2) {
                int iG = this.e.g(b());
                if (iG == 0) {
                    o();
                    return;
                } else {
                    if (i3 == null) {
                        return;
                    }
                    if (i3.b().P() == 18 && iG == 18) {
                        return;
                    }
                }
            }
        } else if (i2 == -1) {
            o();
            return;
        } else if (i2 == 0) {
            if (i3 == null) {
                return;
            }
            l(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, i3.b().toString()), p(i3));
            return;
        }
        if (i3 != null) {
            l(i3.b(), i3.a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.c.set(bundle.getBoolean("resolving_error", false) ? new I(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i(Bundle bundle) {
        super.i(bundle);
        I i = (I) this.c.get();
        if (i == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", i.a());
        bundle.putInt("failed_status", i.b().P());
        bundle.putParcelable("failed_resolution", i.b().d0());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.b = false;
    }

    protected abstract void m(ConnectionResult connectionResult, int i);

    protected abstract void n();

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        l(new ConnectionResult(13, null), p((I) this.c.get()));
    }

    public final void s(ConnectionResult connectionResult, int i) {
        I i2 = new I(connectionResult, i);
        AtomicReference atomicReference = this.c;
        while (!AbstractC16775lq5.a(atomicReference, null, i2)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.d.post(new K(this, i2));
    }
}
