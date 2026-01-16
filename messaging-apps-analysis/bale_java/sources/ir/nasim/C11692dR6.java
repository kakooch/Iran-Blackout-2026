package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.dR6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C11692dR6 {
    private int a;
    private EnumC23779xV6 b;
    private final Float c;

    public C11692dR6(int i, EnumC23779xV6 enumC23779xV6, Float f) {
        AbstractC13042fc3.i(enumC23779xV6, "storyType");
        this.a = i;
        this.b = enumC23779xV6;
        this.c = f;
    }

    public final int a() {
        return this.a;
    }

    public final Float b() {
        return this.c;
    }

    public final EnumC23779xV6 c() {
        return this.b;
    }

    public final boolean d() {
        return this.b == EnumC23779xV6.f;
    }

    public final boolean e() {
        return this.b == EnumC23779xV6.e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C11692dR6)) {
            return false;
        }
        C11692dR6 c11692dR6 = (C11692dR6) obj;
        return this.a == c11692dR6.a && this.b == c11692dR6.b;
    }

    public final boolean f() {
        return this.b == EnumC23779xV6.b;
    }

    public int hashCode() {
        return Integer.hashCode(this.a) + this.b.hashCode();
    }

    public String toString() {
        return "StoryKey(id=" + this.a + ", storyType=" + this.b + ", popularity=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C11692dR6(int i, EnumC23779xV6 enumC23779xV6, Float f, int i2, ED1 ed1) {
        this(i, enumC23779xV6, (i2 & 4) != 0 ? null : f);
    }
}
