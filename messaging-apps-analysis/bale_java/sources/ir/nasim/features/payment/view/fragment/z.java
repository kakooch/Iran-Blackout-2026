package ir.nasim.features.payment.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;
import ir.nasim.AbstractC15077iy2;
import ir.nasim.AbstractC18204oG1;
import ir.nasim.AbstractC4497Fj5;
import ir.nasim.C5805Kx2;
import ir.nasim.InterfaceC16959m92;
import ir.nasim.ME2;
import ir.nasim.SB7;

/* loaded from: classes6.dex */
public abstract class z extends androidx.fragment.app.l implements ME2 {
    private ContextWrapper m1;
    private boolean n1;
    private volatile C5805Kx2 o1;
    private final Object p1 = new Object();
    private boolean q1 = false;

    z() {
    }

    private void O8() {
        if (this.m1 == null) {
            this.m1 = C5805Kx2.b(super.G5(), this);
            this.n1 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.n1) {
            return null;
        }
        O8();
        return this.m1;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.m1;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        O8();
        P8();
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        O8();
        P8();
    }

    @Override // ir.nasim.ME2
    /* renamed from: M8, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.o1 == null) {
            synchronized (this.p1) {
                try {
                    if (this.o1 == null) {
                        this.o1 = N8();
                    }
                } finally {
                }
            }
        }
        return this.o1;
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    protected C5805Kx2 N8() {
        return new C5805Kx2(this);
    }

    protected void P8() {
        if (this.q1) {
            return;
        }
        this.q1 = true;
        ((InterfaceC16959m92) N2()).k1((y) SB7.a(this));
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
