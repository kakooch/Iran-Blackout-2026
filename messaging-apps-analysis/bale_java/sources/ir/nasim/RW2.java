package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;

/* loaded from: classes6.dex */
public abstract class RW2 extends AbstractC22105ug3 implements ME2 {
    private ContextWrapper d1;
    private boolean e1;
    private volatile C5805Kx2 f1;
    private final Object g1 = new Object();
    private boolean h1 = false;

    private void T9() {
        if (this.d1 == null) {
            this.d1 = C5805Kx2.b(super.G5(), this);
            this.e1 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.e1) {
            return null;
        }
        T9();
        return this.d1;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.d1;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        T9();
        U9();
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        T9();
        U9();
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // ir.nasim.ME2
    /* renamed from: R9, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.f1 == null) {
            synchronized (this.g1) {
                try {
                    if (this.f1 == null) {
                        this.f1 = S9();
                    }
                } finally {
                }
            }
        }
        return this.f1;
    }

    protected C5805Kx2 S9() {
        return new C5805Kx2(this);
    }

    protected void U9() {
        if (this.h1) {
            return;
        }
        this.h1 = true;
        ((InterfaceC6853Pg3) N2()).y0((C6614Og3) SB7.a(this));
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
