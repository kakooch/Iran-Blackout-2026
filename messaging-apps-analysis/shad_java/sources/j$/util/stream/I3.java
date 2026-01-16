package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class I3 extends E3 {
    private Y3 c;

    I3(InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
    }

    @Override // j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public void accept(long j) {
        this.c.accept(j);
    }

    @Override // j$.util.stream.AbstractC0162h3, j$.util.stream.InterfaceC0192m3
    public void n() {
        long[] jArr = (long[]) this.c.g();
        Arrays.sort(jArr);
        this.a.o(jArr.length);
        int i = 0;
        if (this.b) {
            int length = jArr.length;
            while (i < length) {
                long j = jArr[i];
                if (this.a.p()) {
                    break;
                }
                this.a.accept(j);
                i++;
            }
        } else {
            int length2 = jArr.length;
            while (i < length2) {
                this.a.accept(jArr[i]);
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
        this.c = j > 0 ? new Y3((int) j) : new Y3();
    }
}
