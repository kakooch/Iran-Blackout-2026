package ir.nasim;

import ir.nasim.AbstractC9998au2;

/* renamed from: ir.nasim.sm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C20892sm7 {
    private EnumC12613eu3 a;
    private WH1 b;
    private AbstractC9998au2.b c;
    private C9348Zn7 d;
    private Object e;
    private long f = a();

    public C20892sm7(EnumC12613eu3 enumC12613eu3, WH1 wh1, AbstractC9998au2.b bVar, C9348Zn7 c9348Zn7, Object obj) {
        this.a = enumC12613eu3;
        this.b = wh1;
        this.c = bVar;
        this.d = c9348Zn7;
        this.e = obj;
    }

    private final long a() {
        return AbstractC9330Zl7.b(this.d, this.b, this.c, null, 0, 24, null);
    }

    public final long b() {
        return this.f;
    }

    public final void c(EnumC12613eu3 enumC12613eu3, WH1 wh1, AbstractC9998au2.b bVar, C9348Zn7 c9348Zn7, Object obj) {
        if (enumC12613eu3 == this.a && AbstractC13042fc3.d(wh1, this.b) && AbstractC13042fc3.d(bVar, this.c) && AbstractC13042fc3.d(c9348Zn7, this.d) && AbstractC13042fc3.d(obj, this.e)) {
            return;
        }
        this.a = enumC12613eu3;
        this.b = wh1;
        this.c = bVar;
        this.d = c9348Zn7;
        this.e = obj;
        this.f = a();
    }
}
