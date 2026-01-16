package ir.nasim;

/* renamed from: ir.nasim.jG, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC15247jG {
    void a(int i, int i2);

    Object b();

    void c(int i, int i2, int i3);

    void clear();

    void d(int i, Object obj);

    void f(int i, Object obj);

    void g(Object obj);

    default void h(InterfaceC14603iB2 interfaceC14603iB2, Object obj) {
        interfaceC14603iB2.invoke(b(), obj);
    }

    default void i() {
        Object objB = b();
        InterfaceC11014cb1 interfaceC11014cb1 = objB instanceof InterfaceC11014cb1 ? (InterfaceC11014cb1) objB : null;
        if (interfaceC11014cb1 != null) {
            interfaceC11014cb1.m();
        }
    }

    void k();

    default void e() {
    }

    default void j() {
    }
}
