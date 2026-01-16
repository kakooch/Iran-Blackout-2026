package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;
import ir.nasim.AbstractC5350Iy6;
import ir.nasim.InterfaceC17445my6;

/* renamed from: ir.nasim.cY2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC10987cY2<T extends InterfaceC17445my6, V extends AbstractC5350Iy6> extends AbstractC4894Ha0<T, V> implements ME2 {
    private ContextWrapper j1;
    private boolean k1;
    private volatile C5805Kx2 l1;
    private final Object m1 = new Object();
    private boolean n1 = false;

    private void ka() {
        if (this.j1 == null) {
            this.j1 = C5805Kx2.b(super.G5(), this);
            this.k1 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.k1) {
            return null;
        }
        ka();
        return this.j1;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.j1;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        ka();
        la();
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        ka();
        la();
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
    /* renamed from: ia, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.l1 == null) {
            synchronized (this.m1) {
                try {
                    if (this.l1 == null) {
                        this.l1 = ja();
                    }
                } finally {
                }
            }
        }
        return this.l1;
    }

    protected C5805Kx2 ja() {
        return new C5805Kx2(this);
    }

    protected void la() {
        if (this.n1) {
            return;
        }
        this.n1 = true;
        ((Q08) N2()).r((P08) SB7.a(this));
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.h
    public G.c n3() {
        return AbstractC18204oG1.b(this, super.n3());
    }
}
