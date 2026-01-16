package j$.util.stream;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class R3 extends F3 {
    private Object[] d;
    private int e;

    R3(InterfaceC0192m3 interfaceC0192m3, Comparator comparator) {
        super(interfaceC0192m3, comparator);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        Object[] objArr = this.d;
        int i = this.e;
        this.e = i + 1;
        objArr[i] = obj;
    }

    @Override // j$.util.stream.AbstractC0168i3, j$.util.stream.InterfaceC0192m3
    public void n() {
        int i = 0;
        Arrays.sort(this.d, 0, this.e, this.b);
        this.a.o(this.e);
        if (this.c) {
            while (i < this.e && !this.a.p()) {
                this.a.accept((InterfaceC0192m3) this.d[i]);
                i++;
            }
        } else {
            while (i < this.e) {
                this.a.accept((InterfaceC0192m3) this.d[i]);
                i++;
            }
        }
        this.a.n();
        this.d = null;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.d = new Object[(int) j];
    }
}
