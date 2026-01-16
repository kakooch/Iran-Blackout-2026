package ir.nasim;

/* renamed from: ir.nasim.Iv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5320Iv3 {
    public static final int a(InterfaceC21665tv3 interfaceC21665tv3) {
        return (int) (interfaceC21665tv3.a() == EnumC24286yM4.a ? interfaceC21665tv3.b() & 4294967295L : interfaceC21665tv3.b() >> 32);
    }

    public static final int b(InterfaceC16823lv3 interfaceC16823lv3, EnumC24286yM4 enumC24286yM4) {
        return enumC24286yM4 == EnumC24286yM4.a ? C22045ua3.l(interfaceC16823lv3.o()) : C22045ua3.k(interfaceC16823lv3.o());
    }

    public static final int c(InterfaceC16823lv3 interfaceC16823lv3, EnumC24286yM4 enumC24286yM4) {
        return (int) (enumC24286yM4 == EnumC24286yM4.a ? interfaceC16823lv3.a() & 4294967295L : interfaceC16823lv3.a() >> 32);
    }
}
