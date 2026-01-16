package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;

/* renamed from: ir.nasim.wW2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC23194wW2 extends J90 implements ME2 {
    private final Object A1 = new Object();
    private boolean B1 = false;
    private ContextWrapper x1;
    private boolean y1;
    private volatile C5805Kx2 z1;

    private void Ia() {
        if (this.x1 == null) {
            this.x1 = C5805Kx2.b(super.G5(), this);
            this.y1 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.y1) {
            return null;
        }
        Ia();
        return this.x1;
    }

    @Override // ir.nasim.ME2
    /* renamed from: Ga, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.z1 == null) {
            synchronized (this.A1) {
                try {
                    if (this.z1 == null) {
                        this.z1 = Ha();
                    }
                } finally {
                }
            }
        }
        return this.z1;
    }

    protected C5805Kx2 Ha() {
        return new C5805Kx2(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.x1;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        Ia();
        Ja();
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        Ia();
        Ja();
    }

    protected void Ja() {
        if (this.B1) {
            return;
        }
        this.B1 = true;
        ((FS1) N2()).C((AS1) SB7.a(this));
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
}
