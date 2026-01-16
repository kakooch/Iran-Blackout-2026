package ir.nasim;

import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* renamed from: ir.nasim.Df0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3988Df0 implements Cloneable {
    private int[] a;
    private int b;

    public C3988Df0() {
        this.b = 0;
        this.a = new int[1];
    }

    private void h(int i) {
        if (i > (this.a.length << 5)) {
            int[] iArrQ = q(i);
            int[] iArr = this.a;
            System.arraycopy(iArr, 0, iArrQ, 0, iArr.length);
            this.a = iArrQ;
        }
    }

    private static int[] q(int i) {
        return new int[(i + 31) / 32];
    }

    public void b(boolean z) {
        h(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i = this.b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.b++;
    }

    public void c(C3988Df0 c3988Df0) {
        int i = c3988Df0.b;
        h(this.b + i);
        for (int i2 = 0; i2 < i; i2++) {
            b(c3988Df0.i(i2));
        }
    }

    public void d(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        h(this.b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            b(z);
            i2--;
        }
    }

    public void e() {
        int length = this.a.length;
        for (int i = 0; i < length; i++) {
            this.a[i] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3988Df0)) {
            return false;
        }
        C3988Df0 c3988Df0 = (C3988Df0) obj;
        return this.b == c3988Df0.b && Arrays.equals(this.a, c3988Df0.a);
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C3988Df0 clone() {
        return new C3988Df0((int[]) this.a.clone(), this.b);
    }

    public int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.a);
    }

    public boolean i(int i) {
        return ((1 << (i & 31)) & this.a[i / 32]) != 0;
    }

    public int[] k() {
        return this.a;
    }

    public int l(int i) {
        int i2 = this.b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (~((1 << (i & 31)) - 1)) & this.a[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.a;
            if (i3 == iArr.length) {
                return this.b;
            }
            i4 = iArr[i3];
        }
        int iNumberOfTrailingZeros = (i3 << 5) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.b;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public int m(int i) {
        int i2 = this.b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (~((1 << (i & 31)) - 1)) & (~this.a[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.a;
            if (i3 == iArr.length) {
                return this.b;
            }
            i4 = ~iArr[i3];
        }
        int iNumberOfTrailingZeros = (i3 << 5) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.b;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public int n() {
        return this.b;
    }

    public int o() {
        return (this.b + 7) / 8;
    }

    public boolean p(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.b) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return true;
        }
        int i3 = i2 - 1;
        int i4 = i / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = (2 << (i6 >= i5 ? 31 & i3 : 31)) - (1 << (i6 > i4 ? 0 : i & 31));
            int i8 = this.a[i6] & i7;
            if (!z) {
                i7 = 0;
            }
            if (i8 != i7) {
                return false;
            }
            i6++;
        }
        return true;
    }

    public void r() {
        int[] iArr = new int[this.a.length];
        int i = (this.b - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = this.a[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j5 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        int i4 = this.b;
        int i5 = i2 << 5;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i] = i7;
        }
        this.a = iArr;
    }

    public void s(int i) {
        int[] iArr = this.a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void t(int i, int i2) {
        this.a[i / 32] = i2;
    }

    public String toString() {
        int i = this.b;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(i(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void u(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (i(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }

    public void v(C3988Df0 c3988Df0) {
        if (this.b != c3988Df0.b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ c3988Df0.a[i];
            i++;
        }
    }

    public C3988Df0(int i) {
        this.b = i;
        this.a = q(i);
    }

    C3988Df0(int[] iArr, int i) {
        this.a = iArr;
        this.b = i;
    }
}
