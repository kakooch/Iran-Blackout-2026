package ir.nasim;

import ir.nasim.AbstractC9998au2;
import ir.nasim.InterfaceC8154Ut2;
import java.util.List;

/* renamed from: ir.nasim.fn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13183fn7 {
    private final C13245fu a;
    private final C9348Zn7 b;
    private final List c;
    private final int d;
    private final boolean e;
    private final int f;
    private final WH1 g;
    private final EnumC12613eu3 h;
    private final AbstractC9998au2.b i;
    private final long j;
    private InterfaceC8154Ut2.a k;

    public /* synthetic */ C13183fn7(C13245fu c13245fu, C9348Zn7 c9348Zn7, List list, int i, boolean z, int i2, WH1 wh1, EnumC12613eu3 enumC12613eu3, AbstractC9998au2.b bVar, long j, ED1 ed1) {
        this(c13245fu, c9348Zn7, list, i, z, i2, wh1, enumC12613eu3, bVar, j);
    }

    public final long a() {
        return this.j;
    }

    public final WH1 b() {
        return this.g;
    }

    public final AbstractC9998au2.b c() {
        return this.i;
    }

    public final EnumC12613eu3 d() {
        return this.h;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13183fn7)) {
            return false;
        }
        C13183fn7 c13183fn7 = (C13183fn7) obj;
        return AbstractC13042fc3.d(this.a, c13183fn7.a) && AbstractC13042fc3.d(this.b, c13183fn7.b) && AbstractC13042fc3.d(this.c, c13183fn7.c) && this.d == c13183fn7.d && this.e == c13183fn7.e && AbstractC23365wn7.g(this.f, c13183fn7.f) && AbstractC13042fc3.d(this.g, c13183fn7.g) && this.h == c13183fn7.h && AbstractC13042fc3.d(this.i, c13183fn7.i) && C17833ne1.f(this.j, c13183fn7.j);
    }

    public final int f() {
        return this.f;
    }

    public final List g() {
        return this.c;
    }

    public final boolean h() {
        return this.e;
    }

    public int hashCode() {
        return (((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + Boolean.hashCode(this.e)) * 31) + AbstractC23365wn7.h(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + C17833ne1.o(this.j);
    }

    public final C9348Zn7 i() {
        return this.b;
    }

    public final C13245fu j() {
        return this.a;
    }

    public String toString() {
        return "TextLayoutInput(text=" + ((Object) this.a) + ", style=" + this.b + ", placeholders=" + this.c + ", maxLines=" + this.d + ", softWrap=" + this.e + ", overflow=" + ((Object) AbstractC23365wn7.i(this.f)) + ", density=" + this.g + ", layoutDirection=" + this.h + ", fontFamilyResolver=" + this.i + ", constraints=" + ((Object) C17833ne1.q(this.j)) + ')';
    }

    private C13183fn7(C13245fu c13245fu, C9348Zn7 c9348Zn7, List list, int i, boolean z, int i2, WH1 wh1, EnumC12613eu3 enumC12613eu3, InterfaceC8154Ut2.a aVar, AbstractC9998au2.b bVar, long j) {
        this.a = c13245fu;
        this.b = c9348Zn7;
        this.c = list;
        this.d = i;
        this.e = z;
        this.f = i2;
        this.g = wh1;
        this.h = enumC12613eu3;
        this.i = bVar;
        this.j = j;
        this.k = aVar;
    }

    private C13183fn7(C13245fu c13245fu, C9348Zn7 c9348Zn7, List list, int i, boolean z, int i2, WH1 wh1, EnumC12613eu3 enumC12613eu3, AbstractC9998au2.b bVar, long j) {
        this(c13245fu, c9348Zn7, list, i, z, i2, wh1, enumC12613eu3, (InterfaceC8154Ut2.a) null, bVar, j);
    }
}
