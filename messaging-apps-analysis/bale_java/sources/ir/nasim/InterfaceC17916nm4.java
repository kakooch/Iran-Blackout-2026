package ir.nasim;

/* renamed from: ir.nasim.nm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC17916nm4 extends InterfaceC5365Ja3, InterfaceC9102Ym4 {
    @Override // ir.nasim.InterfaceC5365Ja3
    int d();

    void h(int i);

    default void m(int i) {
        h(i);
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        m(((Number) obj).intValue());
    }

    @Override // ir.nasim.InterfaceC9664aL6
    default Integer getValue() {
        return Integer.valueOf(d());
    }
}
