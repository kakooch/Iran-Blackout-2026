package ir.nasim;

/* renamed from: ir.nasim.hm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC14354hm4 extends InterfaceC17363mq2, InterfaceC9102Ym4 {
    @Override // ir.nasim.InterfaceC17363mq2
    float a();

    default void n(float f) {
        s(f);
    }

    void s(float f);

    @Override // ir.nasim.InterfaceC9102Ym4
    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        n(((Number) obj).floatValue());
    }

    @Override // ir.nasim.InterfaceC9664aL6
    default Float getValue() {
        return Float.valueOf(a());
    }
}
