package ir.nasim;

/* renamed from: ir.nasim.Vn1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8333Vn1 implements InterfaceC10031ax6 {
    private final InterfaceC9934ao1 a;
    private final InterfaceC9934ao1 b;
    private final InterfaceC9934ao1 c;
    private final InterfaceC9934ao1 d;

    public AbstractC8333Vn1(InterfaceC9934ao1 interfaceC9934ao1, InterfaceC9934ao1 interfaceC9934ao12, InterfaceC9934ao1 interfaceC9934ao13, InterfaceC9934ao1 interfaceC9934ao14) {
        this.a = interfaceC9934ao1;
        this.b = interfaceC9934ao12;
        this.c = interfaceC9934ao13;
        this.d = interfaceC9934ao14;
    }

    public static /* synthetic */ AbstractC8333Vn1 d(AbstractC8333Vn1 abstractC8333Vn1, InterfaceC9934ao1 interfaceC9934ao1, InterfaceC9934ao1 interfaceC9934ao12, InterfaceC9934ao1 interfaceC9934ao13, InterfaceC9934ao1 interfaceC9934ao14, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            interfaceC9934ao1 = abstractC8333Vn1.a;
        }
        if ((i & 2) != 0) {
            interfaceC9934ao12 = abstractC8333Vn1.b;
        }
        if ((i & 4) != 0) {
            interfaceC9934ao13 = abstractC8333Vn1.c;
        }
        if ((i & 8) != 0) {
            interfaceC9934ao14 = abstractC8333Vn1.d;
        }
        return abstractC8333Vn1.c(interfaceC9934ao1, interfaceC9934ao12, interfaceC9934ao13, interfaceC9934ao14);
    }

    @Override // ir.nasim.InterfaceC10031ax6
    public final AbstractC10274bN4 a(long j, EnumC12613eu3 enumC12613eu3, WH1 wh1) {
        float fA = this.a.a(j, wh1);
        float fA2 = this.b.a(j, wh1);
        float fA3 = this.c.a(j, wh1);
        float fA4 = this.d.a(j, wh1);
        float fH = OD6.h(j);
        float f = fA + fA4;
        if (f > fH) {
            float f2 = fH / f;
            fA *= f2;
            fA4 *= f2;
        }
        float f3 = fA4;
        float f4 = fA2 + fA3;
        if (f4 > fH) {
            float f5 = fH / f4;
            fA2 *= f5;
            fA3 *= f5;
        }
        if (!(fA >= 0.0f && fA2 >= 0.0f && fA3 >= 0.0f && f3 >= 0.0f)) {
            P73.a("Corner size in Px can't be negative(topStart = " + fA + ", topEnd = " + fA2 + ", bottomEnd = " + fA3 + ", bottomStart = " + f3 + ")!");
        }
        return e(j, fA, fA2, fA3, f3, enumC12613eu3);
    }

    public final AbstractC8333Vn1 b(InterfaceC9934ao1 interfaceC9934ao1) {
        return c(interfaceC9934ao1, interfaceC9934ao1, interfaceC9934ao1, interfaceC9934ao1);
    }

    public abstract AbstractC8333Vn1 c(InterfaceC9934ao1 interfaceC9934ao1, InterfaceC9934ao1 interfaceC9934ao12, InterfaceC9934ao1 interfaceC9934ao13, InterfaceC9934ao1 interfaceC9934ao14);

    public abstract AbstractC10274bN4 e(long j, float f, float f2, float f3, float f4, EnumC12613eu3 enumC12613eu3);

    public final InterfaceC9934ao1 f() {
        return this.c;
    }

    public final InterfaceC9934ao1 g() {
        return this.d;
    }

    public final InterfaceC9934ao1 h() {
        return this.b;
    }

    public final InterfaceC9934ao1 i() {
        return this.a;
    }
}
