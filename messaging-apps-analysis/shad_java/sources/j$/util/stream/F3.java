package j$.util.stream;

import java.util.Comparator;

/* loaded from: classes2.dex */
abstract class F3 extends AbstractC0168i3 {
    protected final Comparator b;
    protected boolean c;

    F3(InterfaceC0192m3 interfaceC0192m3, Comparator comparator) {
        super(interfaceC0192m3);
        this.b = comparator;
    }

    @Override // j$.util.stream.AbstractC0168i3, j$.util.stream.InterfaceC0192m3
    public final boolean p() {
        this.c = true;
        return false;
    }
}
