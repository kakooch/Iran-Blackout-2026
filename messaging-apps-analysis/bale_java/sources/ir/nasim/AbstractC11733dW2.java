package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C;
import ir.nasim.AbstractC17902nl0;
import ir.nasim.HB3;
import ir.nasim.chat.ChatFragment;

/* renamed from: ir.nasim.dW2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC11733dW2<T extends AbstractC17902nl0 & HB3, V extends RecyclerView.C> extends AV1<T, V> implements ME2 {
    private ContextWrapper l1;
    private boolean m1;
    private volatile C5805Kx2 n1;
    private final Object o1 = new Object();
    private boolean p1 = false;

    private void qa() {
        if (this.l1 == null) {
            this.l1 = C5805Kx2.b(super.G5(), this);
            this.m1 = AbstractC15077iy2.a(super.G5());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context G5() {
        if (super.G5() == null && !this.m1) {
            return null;
        }
        qa();
        return this.l1;
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        ContextWrapper contextWrapper = this.l1;
        AbstractC4497Fj5.d(contextWrapper == null || C5805Kx2.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        qa();
        ra();
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        qa();
        ra();
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
    /* renamed from: oa, reason: merged with bridge method [inline-methods] */
    public final C5805Kx2 E4() {
        if (this.n1 == null) {
            synchronized (this.o1) {
                try {
                    if (this.n1 == null) {
                        this.n1 = pa();
                    }
                } finally {
                }
            }
        }
        return this.n1;
    }

    protected C5805Kx2 pa() {
        return new C5805Kx2(this);
    }

    protected void ra() {
        if (this.p1) {
            return;
        }
        this.p1 = true;
        ((QP0) N2()).y1((ChatFragment) SB7.a(this));
    }
}
