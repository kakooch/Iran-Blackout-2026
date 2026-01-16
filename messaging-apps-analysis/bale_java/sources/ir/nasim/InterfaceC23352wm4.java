package ir.nasim;

/* renamed from: ir.nasim.wm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC23352wm4 extends InterfaceC23668xJ3, InterfaceC9102Ym4 {
    @Override // ir.nasim.InterfaceC23668xJ3
    long getLongValue();

    default void l(long j) {
        w(j);
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        l(((Number) obj).longValue());
    }

    void w(long j);

    @Override // ir.nasim.InterfaceC9664aL6
    default Long getValue() {
        return Long.valueOf(getLongValue());
    }
}
