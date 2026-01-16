package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class D0 extends E0 {
    private final byte[] d;
    private final int e;
    private int f;

    D0(byte[] bArr, int i, int i2) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.d = bArr;
        this.f = 0;
        this.e = i2;
    }

    public final void D(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, 0, this.d, this.f, i2);
            this.f += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)), e);
        }
    }

    public final void E(String str) throws zzjk {
        int i = this.f;
        try {
            int iA = E0.a(str.length() * 3);
            int iA2 = E0.a(str.length());
            if (iA2 != iA) {
                u(E1.c(str));
                byte[] bArr = this.d;
                int i2 = this.f;
                this.f = E1.b(str, bArr, i2, this.e - i2);
                return;
            }
            int i3 = i + iA2;
            this.f = i3;
            int iB = E1.b(str, this.d, i3, this.e - i3);
            this.f = i;
            u((iB - i) - iA2);
            this.f = iB;
        } catch (D1 e) {
            this.f = i;
            e(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzjk(e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final int g() {
        return this.e - this.f;
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void h(byte b) throws zzjk {
        try {
            byte[] bArr = this.d;
            int i = this.f;
            this.f = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void i(int i, boolean z) throws zzjk {
        u(i << 3);
        h(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void j(int i, A0 a0) throws zzjk {
        u((i << 3) | 2);
        u(a0.r());
        a0.E(this);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void k(int i, int i2) throws zzjk {
        u((i << 3) | 5);
        l(i2);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void l(int i) throws zzjk {
        try {
            byte[] bArr = this.d;
            int i2 = this.f;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.f = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void m(int i, long j) throws zzjk {
        u((i << 3) | 1);
        n(j);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void n(long j) throws zzjk {
        try {
            byte[] bArr = this.d;
            int i = this.f;
            bArr[i] = (byte) (((int) j) & 255);
            bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
            bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
            bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.f = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void o(int i, int i2) throws zzjk {
        u(i << 3);
        p(i2);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void p(int i) throws zzjk {
        if (i >= 0) {
            u(i);
        } else {
            w(i);
        }
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void q(byte[] bArr, int i, int i2) {
        D(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void r(int i, String str) throws zzjk {
        u((i << 3) | 2);
        E(str);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void s(int i, int i2) throws zzjk {
        u((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void t(int i, int i2) throws zzjk {
        u(i << 3);
        u(i2);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void u(int i) throws zzjk {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
            }
        }
        byte[] bArr2 = this.d;
        int i3 = this.f;
        this.f = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void v(int i, long j) throws zzjk {
        u(i << 3);
        w(j);
    }

    @Override // com.google.android.gms.internal.measurement.E0
    public final void w(long j) throws zzjk {
        if (E0.c && this.e - this.f >= 10) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                z1.s(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i2 = this.f;
            this.f = i2 + 1;
            z1.s(bArr2, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                byte[] bArr3 = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
            }
        }
        byte[] bArr4 = this.d;
        int i4 = this.f;
        this.f = i4 + 1;
        bArr4[i4] = (byte) j;
    }
}
