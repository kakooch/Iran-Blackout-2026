package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;

/* loaded from: classes7.dex */
public abstract class WW2 extends Fragment implements ME2 {
    private ContextWrapper W0;
    private boolean X0;
    private volatile C5805Kx2 Y0;
    private final Object Z0 = new Object();
    private boolean a1 = false;

    WW2() {
    }

    private void t8() {
        if (this.W0 == null) {
            this.W0 = C5805Kx2.b(super.G5(), this);
            this.X0 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.X0) {
            return null;
        }
        t8();
        return this.W0;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.W0;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        t8();
        u8();
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        t8();
        u8();
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
    /* renamed from: r8, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.Y0 == null) {
            synchronized (this.Z0) {
                try {
                    if (this.Y0 == null) {
                        this.Y0 = s8();
                    }
                } finally {
                }
            }
        }
        return this.Y0;
    }

    protected C5805Kx2 s8() {
        return new C5805Kx2(this);
    }

    protected void u8() {
        if (this.a1) {
            return;
        }
        this.a1 = true;
        ((InterfaceC21811uA3) N2()).N((C21137tA3) SB7.a(this));
    }
}
