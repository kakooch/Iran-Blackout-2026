package ir.nasim;

import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.rx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C20409rx6 implements InterfaceC9904al1 {
    private final String a;
    private final List b;
    private final boolean c;

    public C20409rx6(String str, List list, boolean z) {
        this.a = str;
        this.b = list;
        this.c = z;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new C4502Fk1(qVar, abstractC3236Aa0, this, c23677xK3);
    }

    public List b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
