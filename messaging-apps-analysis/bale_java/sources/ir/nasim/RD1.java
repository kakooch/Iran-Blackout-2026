package ir.nasim;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class RD1 implements InterfaceC9845af2 {
    private final InterfaceC18631oz1 b;
    private final long c;
    private long d;
    private int f;
    private int g;
    private byte[] e = new byte[65536];
    private final byte[] a = new byte[4096];

    static {
        AbstractC9253Zd2.a("goog.exo.extractor");
    }

    public RD1(InterfaceC18631oz1 interfaceC18631oz1, long j, long j2) {
        this.b = interfaceC18631oz1;
        this.d = j;
        this.c = j2;
    }

    private void n(int i) {
        if (i != -1) {
            this.d += i;
        }
    }

    private void o(int i) {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = Arrays.copyOf(this.e, AbstractC9683aN7.p(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int p(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.e, 0, bArr, i, iMin);
        t(iMin);
        return iMin;
    }

    private int q(byte[] bArr, int i, int i2, int i3, boolean z) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i4 = this.b.read(bArr, i + i3, i2 - i3);
        if (i4 != -1) {
            return i3 + i4;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private int r(int i) {
        int iMin = Math.min(this.g, i);
        t(iMin);
        return iMin;
    }

    private void t(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.e = bArr2;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public int a(int i) throws EOFException, InterruptedIOException {
        int iR = r(i);
        if (iR == 0) {
            byte[] bArr = this.a;
            iR = q(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        n(iR);
        return iR;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public boolean c(byte[] bArr, int i, int i2, boolean z) {
        if (!l(i2, z)) {
            return false;
        }
        System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        return true;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void e() {
        this.f = 0;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public boolean f(byte[] bArr, int i, int i2, boolean z) throws EOFException, InterruptedIOException {
        int iP = p(bArr, i, i2);
        while (iP < i2 && iP != -1) {
            iP = q(bArr, i, i2, iP, z);
        }
        n(iP);
        return iP != -1;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public long g() {
        return this.d + this.f;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public long getLength() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public long getPosition() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void h(int i) throws EOFException, InterruptedIOException {
        l(i, false);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public int j(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        int iMin;
        o(i2);
        int i3 = this.g;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            iMin = q(this.e, i4, i2, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.g += iMin;
        } else {
            iMin = Math.min(i2, i5);
        }
        System.arraycopy(this.e, this.f, bArr, i, iMin);
        this.f += iMin;
        return iMin;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void k(int i) throws EOFException, InterruptedIOException {
        s(i, false);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public boolean l(int i, boolean z) throws EOFException, InterruptedIOException {
        o(i);
        int iQ = this.g - this.f;
        while (iQ < i) {
            iQ = q(this.e, this.f, i, iQ, z);
            if (iQ == -1) {
                return false;
            }
            this.g = this.f + iQ;
        }
        this.f += i;
        return true;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void m(byte[] bArr, int i, int i2) {
        c(bArr, i, i2, false);
    }

    @Override // ir.nasim.InterfaceC9845af2, ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        int iP = p(bArr, i, i2);
        if (iP == 0) {
            iP = q(bArr, i, i2, 0, true);
        }
        n(iP);
        return iP;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void readFully(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        f(bArr, i, i2, false);
    }

    public boolean s(int i, boolean z) throws EOFException, InterruptedIOException {
        int iR = r(i);
        while (iR < i && iR != -1) {
            iR = q(this.a, -iR, Math.min(i, this.a.length + iR), iR, z);
        }
        n(iR);
        return iR != -1;
    }
}
