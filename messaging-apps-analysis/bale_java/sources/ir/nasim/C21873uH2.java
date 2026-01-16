package ir.nasim;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: ir.nasim.uH2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C21873uH2 {
    private ByteBuffer b;
    private C21199tH2 c;
    private final byte[] a = new byte[256];
    private int d = 0;

    private boolean b() {
        return this.c.b != 0;
    }

    private int d() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    private void e() {
        this.c.d.a = n();
        this.c.d.b = n();
        this.c.d.c = n();
        this.c.d.d = n();
        int iD = d();
        boolean z = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        C19396qH2 c19396qH2 = this.c.d;
        c19396qH2.e = (iD & 64) != 0;
        if (z) {
            c19396qH2.k = g(iPow);
        } else {
            c19396qH2.k = null;
        }
        this.c.d.j = this.b.position();
        r();
        if (b()) {
            return;
        }
        C21199tH2 c21199tH2 = this.c;
        c21199tH2.c++;
        c21199tH2.e.add(c21199tH2.d);
    }

    private void f() {
        int iD = d();
        this.d = iD;
        if (iD <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                i2 = this.d;
                if (i >= i2) {
                    return;
                }
                i2 -= i;
                this.b.get(this.a, i, i2);
                i += i2;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.d, e);
                }
                this.c.b = 1;
                return;
            }
        }
    }

    private int[] g(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | (-16777216) | (bArr[i5] & 255);
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i) {
        boolean z = false;
        while (!z && !b() && this.c.c <= i) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    q();
                } else if (iD2 == 249) {
                    this.c.d = new C19396qH2();
                    j();
                } else if (iD2 == 254) {
                    q();
                } else if (iD2 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (iD == 44) {
                C21199tH2 c21199tH2 = this.c;
                if (c21199tH2.d == null) {
                    c21199tH2.d = new C19396qH2();
                }
                e();
            } else if (iD != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    private void j() {
        d();
        int iD = d();
        C19396qH2 c19396qH2 = this.c.d;
        int i = (iD & 28) >> 2;
        c19396qH2.g = i;
        if (i == 0) {
            c19396qH2.g = 1;
        }
        c19396qH2.f = (iD & 1) != 0;
        int iN = n();
        if (iN < 2) {
            iN = 10;
        }
        C19396qH2 c19396qH22 = this.c.d;
        c19396qH22.i = iN * 10;
        c19396qH22.h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        l();
        if (!this.c.h || b()) {
            return;
        }
        C21199tH2 c21199tH2 = this.c;
        c21199tH2.a = g(c21199tH2.i);
        C21199tH2 c21199tH22 = this.c;
        c21199tH22.l = c21199tH22.a[c21199tH22.j];
    }

    private void l() {
        this.c.f = n();
        this.c.g = n();
        int iD = d();
        C21199tH2 c21199tH2 = this.c;
        c21199tH2.h = (iD & 128) != 0;
        c21199tH2.i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.c.j = d();
        this.c.k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.b.getShort();
    }

    private void o() {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.c = new C21199tH2();
        this.d = 0;
    }

    private void q() {
        int iD;
        do {
            iD = d();
            this.b.position(Math.min(this.b.position() + iD, this.b.limit()));
        } while (iD > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public C21199tH2 c() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.c;
        }
        k();
        if (!b()) {
            h();
            C21199tH2 c21199tH2 = this.c;
            if (c21199tH2.c < 0) {
                c21199tH2.b = 1;
            }
        }
        return this.c;
    }

    public C21873uH2 p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
