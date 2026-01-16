package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C;

/* renamed from: ir.nasim.jW2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC15394jW2<T, V extends RecyclerView.C> extends AbstractC7745Ta0<T, V> implements ME2 {
    private ContextWrapper g1;
    private boolean h1;
    private volatile C5805Kx2 i1;
    private final Object j1 = new Object();
    private boolean k1 = false;

    private void X9() {
        if (this.g1 == null) {
            this.g1 = C5805Kx2.b(super.G5(), this);
            this.h1 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.h1) {
            return null;
        }
        X9();
        return this.g1;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.g1;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        X9();
        Y9();
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        X9();
        Y9();
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater V6(Bundle bundle) {
        LayoutInflater layoutInflaterV6 = super.V6(bundle);
        return layoutInflaterV6.cloneInContext(C5805Kx2.c(layoutInflaterV6, this));
    }

    @Override // ir.nasim.ME2
    /* renamed from: V9, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.i1 == null) {
            synchronized (this.j1) {
                try {
                    if (this.i1 == null) {
                        this.i1 = W9();
                    }
                } finally {
                }
            }
        }
        return this.i1;
    }

    protected C5805Kx2 W9() {
        return new C5805Kx2(this);
    }

    protected void Y9() {
        if (this.k1) {
            return;
        }
        this.k1 = true;
        ((InterfaceC4268Ek1) N2()).J0((C4034Dk1) SB7.a(this));
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.h
    public G.c n3() {
        return AbstractC18204oG1.b(this, super.n3());
    }
}
