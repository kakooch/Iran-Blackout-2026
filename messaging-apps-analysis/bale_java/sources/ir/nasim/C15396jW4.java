package ir.nasim;

import ir.nasim.C13245fu;

/* renamed from: ir.nasim.jW4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15396jW4 implements C13245fu.a {
    private final int a;
    private final int b;
    private final long c;
    private final C5477Jm7 d;
    private final C17847nf5 e;
    private final C4888Gz3 f;
    private final int g;
    private final int h;
    private final C22179un7 i;

    public /* synthetic */ C15396jW4(int i, int i2, long j, C5477Jm7 c5477Jm7, C17847nf5 c17847nf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7, ED1 ed1) {
        this(i, i2, j, c5477Jm7, c17847nf5, c4888Gz3, i3, i4, c22179un7);
    }

    public final C15396jW4 a(int i, int i2, long j, C5477Jm7 c5477Jm7, C17847nf5 c17847nf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7) {
        return new C15396jW4(i, i2, j, c5477Jm7, c17847nf5, c4888Gz3, i3, i4, c22179un7, null);
    }

    public final int c() {
        return this.h;
    }

    public final int d() {
        return this.g;
    }

    public final long e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15396jW4)) {
            return false;
        }
        C15396jW4 c15396jW4 = (C15396jW4) obj;
        return C6399Nk7.k(this.a, c15396jW4.a) && C4049Dl7.j(this.b, c15396jW4.b) && C13193fo7.e(this.c, c15396jW4.c) && AbstractC13042fc3.d(this.d, c15396jW4.d) && AbstractC13042fc3.d(this.e, c15396jW4.e) && AbstractC13042fc3.d(this.f, c15396jW4.f) && C4171Dz3.f(this.g, c15396jW4.g) && C23811xZ2.g(this.h, c15396jW4.h) && AbstractC13042fc3.d(this.i, c15396jW4.i);
    }

    public final C4888Gz3 f() {
        return this.f;
    }

    public final C17847nf5 g() {
        return this.e;
    }

    public final int h() {
        return this.a;
    }

    public int hashCode() {
        int iL = ((((C6399Nk7.l(this.a) * 31) + C4049Dl7.k(this.b)) * 31) + C13193fo7.i(this.c)) * 31;
        C5477Jm7 c5477Jm7 = this.d;
        int iHashCode = (iL + (c5477Jm7 != null ? c5477Jm7.hashCode() : 0)) * 31;
        C17847nf5 c17847nf5 = this.e;
        int iHashCode2 = (iHashCode + (c17847nf5 != null ? c17847nf5.hashCode() : 0)) * 31;
        C4888Gz3 c4888Gz3 = this.f;
        int iHashCode3 = (((((iHashCode2 + (c4888Gz3 != null ? c4888Gz3.hashCode() : 0)) * 31) + C4171Dz3.j(this.g)) * 31) + C23811xZ2.h(this.h)) * 31;
        C22179un7 c22179un7 = this.i;
        return iHashCode3 + (c22179un7 != null ? c22179un7.hashCode() : 0);
    }

    public final int i() {
        return this.b;
    }

    public final C5477Jm7 j() {
        return this.d;
    }

    public final C22179un7 k() {
        return this.i;
    }

    public final C15396jW4 l(C15396jW4 c15396jW4) {
        return c15396jW4 == null ? this : AbstractC15987kW4.a(this, c15396jW4.a, c15396jW4.b, c15396jW4.c, c15396jW4.d, c15396jW4.e, c15396jW4.f, c15396jW4.g, c15396jW4.h, c15396jW4.i);
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) C6399Nk7.m(this.a)) + ", textDirection=" + ((Object) C4049Dl7.l(this.b)) + ", lineHeight=" + ((Object) C13193fo7.j(this.c)) + ", textIndent=" + this.d + ", platformStyle=" + this.e + ", lineHeightStyle=" + this.f + ", lineBreak=" + ((Object) C4171Dz3.k(this.g)) + ", hyphens=" + ((Object) C23811xZ2.i(this.h)) + ", textMotion=" + this.i + ')';
    }

    private C15396jW4(int i, int i2, long j, C5477Jm7 c5477Jm7, C17847nf5 c17847nf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = c5477Jm7;
        this.e = c17847nf5;
        this.f = c4888Gz3;
        this.g = i3;
        this.h = i4;
        this.i = c22179un7;
        if (C13193fo7.e(j, C13193fo7.b.a())) {
            return;
        }
        if (C13193fo7.h(j) >= 0.0f) {
            return;
        }
        N73.c("lineHeight can't be negative (" + C13193fo7.h(j) + ')');
    }
}
