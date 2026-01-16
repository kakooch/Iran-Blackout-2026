package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;

/* loaded from: classes6.dex */
public abstract class NX2 extends C22042ua0 implements ME2 {
    private ContextWrapper c1;
    private boolean d1;
    private volatile C5805Kx2 e1;
    private final Object f1 = new Object();
    private boolean g1 = false;

    private void Q9() {
        if (this.c1 == null) {
            this.c1 = C5805Kx2.b(super.G5(), this);
            this.d1 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.d1) {
            return null;
        }
        Q9();
        return this.c1;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.c1;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        Q9();
        R9();
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        Q9();
        R9();
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // ir.nasim.ME2
    /* renamed from: O9, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.e1 == null) {
            synchronized (this.f1) {
                try {
                    if (this.e1 == null) {
                        this.e1 = P9();
                    }
                } finally {
                }
            }
        }
        return this.e1;
    }

    protected C5805Kx2 P9() {
        return new C5805Kx2(this);
    }

    protected void R9() {
        if (this.g1) {
            return;
        }
        this.g1 = true;
        ((InterfaceC4657Fz6) N2()).H((C4174Dz6) SB7.a(this));
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
}
