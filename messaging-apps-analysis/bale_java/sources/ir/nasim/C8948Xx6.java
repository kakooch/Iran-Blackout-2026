package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.View;
import ir.nasim.animation.view.transition.sharedelement.Corners;

/* renamed from: ir.nasim.Xx6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8948Xx6 {
    private final View a;
    private final Corners b;

    public C8948Xx6(View view, Corners corners) {
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(corners, "corners");
        this.a = view;
        this.b = corners;
    }

    public final View a() {
        return this.a;
    }

    public final Corners b() {
        return this.b;
    }

    public final View c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8948Xx6)) {
            return false;
        }
        C8948Xx6 c8948Xx6 = (C8948Xx6) obj;
        return AbstractC13042fc3.d(this.a, c8948Xx6.a) && AbstractC13042fc3.d(this.b, c8948Xx6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SharedElement(view=" + this.a + ", corners=" + this.b + Separators.RPAREN;
    }
}
