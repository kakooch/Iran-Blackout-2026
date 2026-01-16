package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import ir.nasim.InterfaceC22259uv7;

/* loaded from: classes2.dex */
public final class NE1 {
    private final AbstractC13778go1 a;
    private final AbstractC13778go1 b;
    private final AbstractC13778go1 c;
    private final AbstractC13778go1 d;
    private final InterfaceC22259uv7.a e;
    private final EnumC18478oj5 f;
    private final Bitmap.Config g;
    private final boolean h;
    private final boolean i;
    private final Drawable j;
    private final Drawable k;
    private final Drawable l;
    private final EnumC16760lp0 m;
    private final EnumC16760lp0 n;
    private final EnumC16760lp0 o;

    public NE1(AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, AbstractC13778go1 abstractC13778go13, AbstractC13778go1 abstractC13778go14, InterfaceC22259uv7.a aVar, EnumC18478oj5 enumC18478oj5, Bitmap.Config config, boolean z, boolean z2, Drawable drawable, Drawable drawable2, Drawable drawable3, EnumC16760lp0 enumC16760lp0, EnumC16760lp0 enumC16760lp02, EnumC16760lp0 enumC16760lp03) {
        this.a = abstractC13778go1;
        this.b = abstractC13778go12;
        this.c = abstractC13778go13;
        this.d = abstractC13778go14;
        this.e = aVar;
        this.f = enumC18478oj5;
        this.g = config;
        this.h = z;
        this.i = z2;
        this.j = drawable;
        this.k = drawable2;
        this.l = drawable3;
        this.m = enumC16760lp0;
        this.n = enumC16760lp02;
        this.o = enumC16760lp03;
    }

    public final NE1 a(AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, AbstractC13778go1 abstractC13778go13, AbstractC13778go1 abstractC13778go14, InterfaceC22259uv7.a aVar, EnumC18478oj5 enumC18478oj5, Bitmap.Config config, boolean z, boolean z2, Drawable drawable, Drawable drawable2, Drawable drawable3, EnumC16760lp0 enumC16760lp0, EnumC16760lp0 enumC16760lp02, EnumC16760lp0 enumC16760lp03) {
        return new NE1(abstractC13778go1, abstractC13778go12, abstractC13778go13, abstractC13778go14, aVar, enumC18478oj5, config, z, z2, drawable, drawable2, drawable3, enumC16760lp0, enumC16760lp02, enumC16760lp03);
    }

    public final boolean c() {
        return this.h;
    }

    public final boolean d() {
        return this.i;
    }

    public final Bitmap.Config e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NE1) {
            NE1 ne1 = (NE1) obj;
            if (AbstractC13042fc3.d(this.a, ne1.a) && AbstractC13042fc3.d(this.b, ne1.b) && AbstractC13042fc3.d(this.c, ne1.c) && AbstractC13042fc3.d(this.d, ne1.d) && AbstractC13042fc3.d(this.e, ne1.e) && this.f == ne1.f && this.g == ne1.g && this.h == ne1.h && this.i == ne1.i && AbstractC13042fc3.d(this.j, ne1.j) && AbstractC13042fc3.d(this.k, ne1.k) && AbstractC13042fc3.d(this.l, ne1.l) && this.m == ne1.m && this.n == ne1.n && this.o == ne1.o) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC13778go1 f() {
        return this.c;
    }

    public final EnumC16760lp0 g() {
        return this.n;
    }

    public final Drawable h() {
        return this.k;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31;
        Drawable drawable = this.j;
        int iHashCode2 = (iHashCode + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.k;
        int iHashCode3 = (iHashCode2 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.l;
        return ((((((iHashCode3 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode();
    }

    public final Drawable i() {
        return this.l;
    }

    public final AbstractC13778go1 j() {
        return this.b;
    }

    public final AbstractC13778go1 k() {
        return this.a;
    }

    public final EnumC16760lp0 l() {
        return this.m;
    }

    public final EnumC16760lp0 m() {
        return this.o;
    }

    public final Drawable n() {
        return this.j;
    }

    public final EnumC18478oj5 o() {
        return this.f;
    }

    public final AbstractC13778go1 p() {
        return this.d;
    }

    public final InterfaceC22259uv7.a q() {
        return this.e;
    }

    public /* synthetic */ NE1(AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, AbstractC13778go1 abstractC13778go13, AbstractC13778go1 abstractC13778go14, InterfaceC22259uv7.a aVar, EnumC18478oj5 enumC18478oj5, Bitmap.Config config, boolean z, boolean z2, Drawable drawable, Drawable drawable2, Drawable drawable3, EnumC16760lp0 enumC16760lp0, EnumC16760lp0 enumC16760lp02, EnumC16760lp0 enumC16760lp03, int i, ED1 ed1) {
        this((i & 1) != 0 ? C12366eV1.c().F0() : abstractC13778go1, (i & 2) != 0 ? C12366eV1.b() : abstractC13778go12, (i & 4) != 0 ? C12366eV1.b() : abstractC13778go13, (i & 8) != 0 ? C12366eV1.b() : abstractC13778go14, (i & 16) != 0 ? InterfaceC22259uv7.a.b : aVar, (i & 32) != 0 ? EnumC18478oj5.c : enumC18478oj5, (i & 64) != 0 ? AbstractC18638p.f() : config, (i & 128) != 0 ? true : z, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? null : drawable, (i & 1024) != 0 ? null : drawable2, (i & 2048) == 0 ? drawable3 : null, (i & 4096) != 0 ? EnumC16760lp0.c : enumC16760lp0, (i & 8192) != 0 ? EnumC16760lp0.c : enumC16760lp02, (i & 16384) != 0 ? EnumC16760lp0.c : enumC16760lp03);
    }
}
