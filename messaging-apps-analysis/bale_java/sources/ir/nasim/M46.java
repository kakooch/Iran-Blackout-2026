package ir.nasim;

import ir.nasim.AbstractC10274bN4;

/* loaded from: classes.dex */
public final class M46 extends AbstractC8333Vn1 {
    public M46(InterfaceC9934ao1 interfaceC9934ao1, InterfaceC9934ao1 interfaceC9934ao12, InterfaceC9934ao1 interfaceC9934ao13, InterfaceC9934ao1 interfaceC9934ao14) {
        super(interfaceC9934ao1, interfaceC9934ao12, interfaceC9934ao13, interfaceC9934ao14);
    }

    @Override // ir.nasim.AbstractC8333Vn1
    public AbstractC10274bN4 e(long j, float f, float f2, float f3, float f4, EnumC12613eu3 enumC12613eu3) {
        if (f + f2 + f3 + f4 == 0.0f) {
            return new AbstractC10274bN4.b(UD6.c(j));
        }
        CK5 ck5C = UD6.c(j);
        EnumC12613eu3 enumC12613eu32 = EnumC12613eu3.a;
        float f5 = enumC12613eu3 == enumC12613eu32 ? f : f2;
        long jB = AbstractC8567Wn1.b((Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f5) & 4294967295L));
        float f6 = enumC12613eu3 == enumC12613eu32 ? f2 : f;
        long jB2 = AbstractC8567Wn1.b((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f6) << 32));
        float f7 = enumC12613eu3 == enumC12613eu32 ? f3 : f4;
        long jB3 = AbstractC8567Wn1.b((Float.floatToRawIntBits(f7) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L));
        float f8 = enumC12613eu3 == enumC12613eu32 ? f4 : f3;
        return new AbstractC10274bN4.c(J46.b(ck5C, jB, jB2, jB3, AbstractC8567Wn1.b((Float.floatToRawIntBits(f8) & 4294967295L) | (Float.floatToRawIntBits(f8) << 32))));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M46)) {
            return false;
        }
        M46 m46 = (M46) obj;
        return AbstractC13042fc3.d(i(), m46.i()) && AbstractC13042fc3.d(h(), m46.h()) && AbstractC13042fc3.d(f(), m46.f()) && AbstractC13042fc3.d(g(), m46.g());
    }

    public int hashCode() {
        return (((((i().hashCode() * 31) + h().hashCode()) * 31) + f().hashCode()) * 31) + g().hashCode();
    }

    @Override // ir.nasim.AbstractC8333Vn1
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public M46 c(InterfaceC9934ao1 interfaceC9934ao1, InterfaceC9934ao1 interfaceC9934ao12, InterfaceC9934ao1 interfaceC9934ao13, InterfaceC9934ao1 interfaceC9934ao14) {
        return new M46(interfaceC9934ao1, interfaceC9934ao12, interfaceC9934ao13, interfaceC9934ao14);
    }

    public String toString() {
        return "RoundedCornerShape(topStart = " + i() + ", topEnd = " + h() + ", bottomEnd = " + f() + ", bottomStart = " + g() + ')';
    }
}
