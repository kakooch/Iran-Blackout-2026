package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;

/* loaded from: classes6.dex */
public abstract class MW2 extends com.google.android.material.bottomsheet.b implements ME2 {
    private ContextWrapper n1;
    private boolean o1;
    private volatile C5805Kx2 p1;
    private final Object q1 = new Object();
    private boolean r1 = false;

    private void S8() {
        if (this.n1 == null) {
            this.n1 = C5805Kx2.b(super.G5(), this);
            this.o1 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.o1) {
            return null;
        }
        S8();
        return this.n1;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.n1;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        S8();
        T8();
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        S8();
        T8();
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // ir.nasim.ME2
    /* renamed from: Q8, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.p1 == null) {
            synchronized (this.q1) {
                try {
                    if (this.p1 == null) {
                        this.p1 = R8();
                    }
                } finally {
                }
            }
        }
        return this.p1;
    }

    protected C5805Kx2 R8() {
        return new C5805Kx2(this);
    }

    protected void T8() {
        if (this.r1) {
            return;
        }
        this.r1 = true;
        ((PC2) N2()).d((C24784zC2) SB7.a(this));
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public LayoutInflater V6(Bundle bundle) {
        LayoutInflater layoutInflaterV6 = super.V6(bundle);
        return layoutInflaterV6.cloneInContext(C5805Kx2.c(layoutInflaterV6, this));
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.h
    public G.c n3() {
        return AbstractC18204oG1.b(this, super.n3());
    }
}
