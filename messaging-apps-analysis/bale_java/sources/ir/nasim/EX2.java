package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.C13090h;

/* loaded from: classes6.dex */
public abstract class EX2 extends AbstractC13089g implements ME2 {
    private ContextWrapper f1;
    private boolean g1;
    private volatile C5805Kx2 h1;
    private final Object i1 = new Object();
    private boolean j1 = false;

    private void xa() {
        if (this.f1 == null) {
            this.f1 = C5805Kx2.b(super.G5(), this);
            this.g1 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.g1) {
            return null;
        }
        xa();
        return this.f1;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.f1;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        xa();
        ya();
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        xa();
        ya();
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

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.h
    public G.c n3() {
        return AbstractC18204oG1.b(this, super.n3());
    }

    @Override // ir.nasim.ME2
    /* renamed from: va, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.h1 == null) {
            synchronized (this.i1) {
                try {
                    if (this.h1 == null) {
                        this.h1 = wa();
                    }
                } finally {
                }
            }
        }
        return this.h1;
    }

    protected C5805Kx2 wa() {
        return new C5805Kx2(this);
    }

    protected void ya() {
        if (this.j1) {
            return;
        }
        this.j1 = true;
        ((Z36) N2()).U0((C13090h) SB7.a(this));
    }
}
