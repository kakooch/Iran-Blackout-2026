package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import org.rbmain.messenger.MessagesController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class jv implements abu {
    private final abu b;
    private final long c;
    private long d;
    private int f;
    private int g;
    private byte[] e = new byte[MessagesController.UPDATE_MASK_CHECK];
    private final byte[] a = new byte[4096];

    public jv(abu abuVar, long j, long j2) {
        this.b = abuVar;
        this.d = j;
        this.c = j2;
    }

    private final void o(int i) {
        int i2 = this.f + i;
        int length = this.e.length;
        if (i2 > length) {
            this.e = Arrays.copyOf(this.e, aeu.H(length + length, MessagesController.UPDATE_MASK_CHECK + i2, i2 + MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM));
        }
    }

    private final int p(int i) {
        int iMin = Math.min(this.g, i);
        r(iMin);
        return iMin;
    }

    private final int q(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.e, 0, bArr, i, iMin);
        r(iMin);
        return iMin;
    }

    private final void r(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length + (-524288) ? new byte[MessagesController.UPDATE_MASK_CHECK + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.e = bArr2;
    }

    private final int s(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int iA = this.b.a(bArr, i + i3, i2 - i3);
        if (iA != -1) {
            return i3 + iA;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private final void t(int i) {
        if (i != -1) {
            this.d += i;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        int iQ = q(bArr, i, i2);
        if (iQ == 0) {
            iQ = s(bArr, i, i2, 0, true);
        }
        t(iQ);
        return iQ;
    }

    public final boolean b(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int iQ = q(bArr, i, i2);
        while (iQ < i2 && iQ != -1) {
            iQ = s(bArr, i, i2, iQ, z);
        }
        t(iQ);
        return iQ != -1;
    }

    public final void c(byte[] bArr, int i, int i2) throws IOException {
        b(bArr, i, i2, false);
    }

    public final void d(int i) throws IOException {
        int iP = p(i);
        while (iP < i && iP != -1) {
            iP = s(this.a, -iP, Math.min(i, iP + 4096), iP, false);
        }
        t(iP);
    }

    public final int e(byte[] bArr, int i, int i2) throws IOException {
        int iMin;
        o(i2);
        int i3 = this.g;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            iMin = s(this.e, i4, i2, 0, true);
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

    public final boolean f(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!h(i2, z)) {
            return false;
        }
        System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        return true;
    }

    public final void g(byte[] bArr, int i, int i2) throws IOException {
        f(bArr, i, i2, false);
    }

    public final boolean h(int i, boolean z) throws IOException {
        o(i);
        int iS = this.g - this.f;
        while (iS < i) {
            iS = s(this.e, this.f, i, iS, z);
            if (iS == -1) {
                return false;
            }
            this.g = this.f + iS;
        }
        this.f += i;
        return true;
    }

    public final void i(int i) throws IOException {
        h(i, false);
    }

    public final void j() {
        this.f = 0;
    }

    public final long k() {
        return this.d + this.f;
    }

    public final long l() {
        return this.d;
    }

    public final long m() {
        return this.c;
    }

    public final int n() throws IOException {
        int iP = p(1);
        if (iP == 0) {
            iP = s(this.a, 0, Math.min(1, 4096), 0, true);
        }
        t(iP);
        return iP;
    }
}
