package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class H3 extends D3 {
    private W3 c;

    H3(InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
    }

    @Override // j$.util.stream.InterfaceC0180k3, j$.util.stream.InterfaceC0192m3
    public void accept(int i) {
        this.c.accept(i);
    }

    @Override // j$.util.stream.AbstractC0156g3, j$.util.stream.InterfaceC0192m3
    public void n() {
        int[] iArr = (int[]) this.c.g();
        Arrays.sort(iArr);
        this.a.o(iArr.length);
        int i = 0;
        if (this.b) {
            int length = iArr.length;
            while (i < length) {
                int i2 = iArr[i];
                if (this.a.p()) {
                    break;
                }
                this.a.accept(i2);
                i++;
            }
        } else {
            int length2 = iArr.length;
            while (i < length2) {
                this.a.accept(iArr[i]);
                i++;
            }
        }
        this.a.n();
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = j > 0 ? new W3((int) j) : new W3();
    }
}
