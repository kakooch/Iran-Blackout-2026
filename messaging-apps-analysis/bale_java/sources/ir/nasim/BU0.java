package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public final class BU0 {
    private final C24948zU0 a;
    private final int b;

    public BU0(C24948zU0 c24948zU0, int i) {
        AbstractC13042fc3.i(c24948zU0, "classId");
        this.a = c24948zU0;
        this.b = i;
    }

    public final C24948zU0 a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    public final C24948zU0 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BU0)) {
            return false;
        }
        BU0 bu0 = (BU0) obj;
        return AbstractC13042fc3.d(this.a, bu0.a) && this.b == bu0.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iC = c();
        for (int i = 0; i < iC; i++) {
            sb.append("kotlin/Array<");
        }
        sb.append(d());
        int iC2 = c();
        for (int i2 = 0; i2 < iC2; i2++) {
            sb.append(Separators.GREATER_THAN);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
