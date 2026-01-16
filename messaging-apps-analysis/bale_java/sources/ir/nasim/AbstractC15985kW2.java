package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13077j;

/* renamed from: ir.nasim.kW2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC15985kW2<B extends InterfaceC9764aW7> extends AbstractC5830La0<B> implements ME2 {
    private ContextWrapper Y0;
    private boolean Z0;
    private volatile C5805Kx2 a1;
    private final Object b1 = new Object();
    private boolean c1 = false;

    private void v8() {
        if (this.Y0 == null) {
            this.Y0 = C5805Kx2.b(super.G5(), this);
            this.Z0 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.Z0) {
            return null;
        }
        v8();
        return this.Y0;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.Y0;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        v8();
        w8();
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        v8();
        w8();
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
    /* renamed from: t8, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.a1 == null) {
            synchronized (this.b1) {
                try {
                    if (this.a1 == null) {
                        this.a1 = u8();
                    }
                } finally {
                }
            }
        }
        return this.a1;
    }

    protected C5805Kx2 u8() {
        return new C5805Kx2(this);
    }

    protected void w8() {
        if (this.c1) {
            return;
        }
        this.c1 = true;
        ((InterfaceC5507Jq1) N2()).r0((ViewOnClickListenerC13077j) SB7.a(this));
    }
}
