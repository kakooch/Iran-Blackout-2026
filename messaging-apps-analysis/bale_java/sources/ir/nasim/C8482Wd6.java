package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Wd6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8482Wd6 implements InterfaceC24304yO4 {
    private final int a;
    private final List b;
    private Float c;
    private Float d;
    private C5629Kd6 e;
    private C5629Kd6 f;

    public C8482Wd6(int i, List list, Float f, Float f2, C5629Kd6 c5629Kd6, C5629Kd6 c5629Kd62) {
        this.a = i;
        this.b = list;
        this.c = f;
        this.d = f2;
        this.e = c5629Kd6;
        this.f = c5629Kd62;
    }

    @Override // ir.nasim.InterfaceC24304yO4
    public boolean Z0() {
        return this.b.contains(this);
    }

    public final C5629Kd6 a() {
        return this.e;
    }

    public final Float b() {
        return this.c;
    }

    public final Float c() {
        return this.d;
    }

    public final int d() {
        return this.a;
    }

    public final C5629Kd6 e() {
        return this.f;
    }

    public final void f(C5629Kd6 c5629Kd6) {
        this.e = c5629Kd6;
    }

    public final void g(Float f) {
        this.c = f;
    }

    public final void h(Float f) {
        this.d = f;
    }

    public final void i(C5629Kd6 c5629Kd6) {
        this.f = c5629Kd6;
    }
}
