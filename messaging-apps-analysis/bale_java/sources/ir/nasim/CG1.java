package ir.nasim;

import android.graphics.Bitmap;
import ir.nasim.InterfaceC22259uv7;

/* loaded from: classes2.dex */
public final class CG1 {
    private final androidx.lifecycle.j a;
    private final ZD6 b;
    private final EnumC14254hc6 c;
    private final AbstractC13778go1 d;
    private final AbstractC13778go1 e;
    private final AbstractC13778go1 f;
    private final AbstractC13778go1 g;
    private final InterfaceC22259uv7.a h;
    private final EnumC18478oj5 i;
    private final Bitmap.Config j;
    private final Boolean k;
    private final Boolean l;
    private final EnumC16760lp0 m;
    private final EnumC16760lp0 n;
    private final EnumC16760lp0 o;

    public CG1(androidx.lifecycle.j jVar, ZD6 zd6, EnumC14254hc6 enumC14254hc6, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, AbstractC13778go1 abstractC13778go13, AbstractC13778go1 abstractC13778go14, InterfaceC22259uv7.a aVar, EnumC18478oj5 enumC18478oj5, Bitmap.Config config, Boolean bool, Boolean bool2, EnumC16760lp0 enumC16760lp0, EnumC16760lp0 enumC16760lp02, EnumC16760lp0 enumC16760lp03) {
        this.a = jVar;
        this.b = zd6;
        this.c = enumC14254hc6;
        this.d = abstractC13778go1;
        this.e = abstractC13778go12;
        this.f = abstractC13778go13;
        this.g = abstractC13778go14;
        this.h = aVar;
        this.i = enumC18478oj5;
        this.j = config;
        this.k = bool;
        this.l = bool2;
        this.m = enumC16760lp0;
        this.n = enumC16760lp02;
        this.o = enumC16760lp03;
    }

    public final Boolean a() {
        return this.k;
    }

    public final Boolean b() {
        return this.l;
    }

    public final Bitmap.Config c() {
        return this.j;
    }

    public final AbstractC13778go1 d() {
        return this.f;
    }

    public final EnumC16760lp0 e() {
        return this.n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CG1) {
            CG1 cg1 = (CG1) obj;
            if (AbstractC13042fc3.d(this.a, cg1.a) && AbstractC13042fc3.d(this.b, cg1.b) && this.c == cg1.c && AbstractC13042fc3.d(this.d, cg1.d) && AbstractC13042fc3.d(this.e, cg1.e) && AbstractC13042fc3.d(this.f, cg1.f) && AbstractC13042fc3.d(this.g, cg1.g) && AbstractC13042fc3.d(this.h, cg1.h) && this.i == cg1.i && this.j == cg1.j && AbstractC13042fc3.d(this.k, cg1.k) && AbstractC13042fc3.d(this.l, cg1.l) && this.m == cg1.m && this.n == cg1.n && this.o == cg1.o) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC13778go1 f() {
        return this.e;
    }

    public final AbstractC13778go1 g() {
        return this.d;
    }

    public final androidx.lifecycle.j h() {
        return this.a;
    }

    public int hashCode() {
        androidx.lifecycle.j jVar = this.a;
        int iHashCode = (jVar != null ? jVar.hashCode() : 0) * 31;
        ZD6 zd6 = this.b;
        int iHashCode2 = (iHashCode + (zd6 != null ? zd6.hashCode() : 0)) * 31;
        EnumC14254hc6 enumC14254hc6 = this.c;
        int iHashCode3 = (iHashCode2 + (enumC14254hc6 != null ? enumC14254hc6.hashCode() : 0)) * 31;
        AbstractC13778go1 abstractC13778go1 = this.d;
        int iHashCode4 = (iHashCode3 + (abstractC13778go1 != null ? abstractC13778go1.hashCode() : 0)) * 31;
        AbstractC13778go1 abstractC13778go12 = this.e;
        int iHashCode5 = (iHashCode4 + (abstractC13778go12 != null ? abstractC13778go12.hashCode() : 0)) * 31;
        AbstractC13778go1 abstractC13778go13 = this.f;
        int iHashCode6 = (iHashCode5 + (abstractC13778go13 != null ? abstractC13778go13.hashCode() : 0)) * 31;
        AbstractC13778go1 abstractC13778go14 = this.g;
        int iHashCode7 = (iHashCode6 + (abstractC13778go14 != null ? abstractC13778go14.hashCode() : 0)) * 31;
        InterfaceC22259uv7.a aVar = this.h;
        int iHashCode8 = (iHashCode7 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        EnumC18478oj5 enumC18478oj5 = this.i;
        int iHashCode9 = (iHashCode8 + (enumC18478oj5 != null ? enumC18478oj5.hashCode() : 0)) * 31;
        Bitmap.Config config = this.j;
        int iHashCode10 = (iHashCode9 + (config != null ? config.hashCode() : 0)) * 31;
        Boolean bool = this.k;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.l;
        int iHashCode12 = (iHashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        EnumC16760lp0 enumC16760lp0 = this.m;
        int iHashCode13 = (iHashCode12 + (enumC16760lp0 != null ? enumC16760lp0.hashCode() : 0)) * 31;
        EnumC16760lp0 enumC16760lp02 = this.n;
        int iHashCode14 = (iHashCode13 + (enumC16760lp02 != null ? enumC16760lp02.hashCode() : 0)) * 31;
        EnumC16760lp0 enumC16760lp03 = this.o;
        return iHashCode14 + (enumC16760lp03 != null ? enumC16760lp03.hashCode() : 0);
    }

    public final EnumC16760lp0 i() {
        return this.m;
    }

    public final EnumC16760lp0 j() {
        return this.o;
    }

    public final EnumC18478oj5 k() {
        return this.i;
    }

    public final EnumC14254hc6 l() {
        return this.c;
    }

    public final ZD6 m() {
        return this.b;
    }

    public final AbstractC13778go1 n() {
        return this.g;
    }

    public final InterfaceC22259uv7.a o() {
        return this.h;
    }
}
