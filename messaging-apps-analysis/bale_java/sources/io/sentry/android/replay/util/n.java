package io.sentry.android.replay.util;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;

/* loaded from: classes3.dex */
public final class n {
    private final C24381yX0 a;
    private final boolean b;

    public /* synthetic */ n(C24381yX0 c24381yX0, boolean z, ED1 ed1) {
        this(c24381yX0, z);
    }

    public final C24381yX0 a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return AbstractC13042fc3.d(this.a, nVar.a) && this.b == nVar.b;
    }

    public int hashCode() {
        C24381yX0 c24381yX0 = this.a;
        return ((c24381yX0 == null ? 0 : C24381yX0.w(c24381yX0.y())) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "TextAttributes(color=" + this.a + ", hasFillModifier=" + this.b + ')';
    }

    private n(C24381yX0 c24381yX0, boolean z) {
        this.a = c24381yX0;
        this.b = z;
    }
}
