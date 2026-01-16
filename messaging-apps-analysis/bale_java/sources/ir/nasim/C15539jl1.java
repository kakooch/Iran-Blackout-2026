package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;

/* renamed from: ir.nasim.jl1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15539jl1 implements Serializable {
    private final int a;
    private final int b;

    public C15539jl1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15539jl1)) {
            return false;
        }
        C15539jl1 c15539jl1 = (C15539jl1) obj;
        return this.a == c15539jl1.a && this.b == c15539jl1.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "ContentSize(width=" + this.a + ", height=" + this.b + Separators.RPAREN;
    }
}
