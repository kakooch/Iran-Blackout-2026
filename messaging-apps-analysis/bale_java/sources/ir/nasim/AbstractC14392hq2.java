package ir.nasim;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.nasim.X2;

/* renamed from: ir.nasim.hq2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC14392hq2 extends AbstractC21558tk6 {
    private final boolean d;

    public AbstractC14392hq2() {
        this(false);
    }

    @Override // ir.nasim.AbstractC21558tk6
    protected boolean c(View view) {
        return n() > m();
    }

    @Override // ir.nasim.AbstractC21558tk6
    protected boolean d(View view) {
        return n() < l();
    }

    @Override // ir.nasim.AbstractC21558tk6
    protected void e(View view, boolean z) {
        float fK = k();
        if (z) {
            fK *= -1.0f;
        }
        o(Math.min(l(), Math.max(m(), n() + fK)));
    }

    @Override // ir.nasim.AbstractC21558tk6
    public void h(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.h(view, accessibilityNodeInfo);
        if (this.d) {
            X2 x2G1 = X2.g1(accessibilityNodeInfo);
            x2G1.b(X2.a.L);
            x2G1.O0(X2.g.a(1, m(), l(), n()));
        }
    }

    @Override // ir.nasim.AbstractC21558tk6
    public boolean i(View view, int i, Bundle bundle) {
        if (super.i(view, i, bundle)) {
            return true;
        }
        if (i != X2.a.L.b()) {
            return false;
        }
        o(bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"));
        return true;
    }

    protected float k() {
        return 0.05f;
    }

    protected float l() {
        return 1.0f;
    }

    protected float m() {
        return 0.0f;
    }

    protected abstract float n();

    protected abstract void o(float f);

    public AbstractC14392hq2(boolean z) {
        this.d = z;
    }
}
