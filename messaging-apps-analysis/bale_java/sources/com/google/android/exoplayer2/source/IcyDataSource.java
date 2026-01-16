package com.google.android.exoplayer2.source;

import android.net.Uri;
import ir.nasim.AbstractC20011rK;
import ir.nasim.EW4;
import ir.nasim.InterfaceC25209zu7;
import java.util.Map;

/* loaded from: classes2.dex */
final class IcyDataSource implements com.google.android.exoplayer2.upstream.a {
    private final com.google.android.exoplayer2.upstream.a a;
    private final int b;
    private final Listener c;
    private final byte[] d;
    private int e;

    public interface Listener {
        void b(EW4 ew4);
    }

    public IcyDataSource(com.google.android.exoplayer2.upstream.a aVar, int i, Listener listener) {
        AbstractC20011rK.a(i > 0);
        this.a = aVar;
        this.b = i;
        this.c = listener;
        this.d = new byte[1];
        this.e = i;
    }

    private boolean n() {
        if (this.a.read(this.d, 0, 1) == -1) {
            return false;
        }
        int i = (this.d[0] & 255) << 4;
        if (i == 0) {
            return true;
        }
        byte[] bArr = new byte[i];
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            int i4 = this.a.read(bArr, i3, i2);
            if (i4 == -1) {
                return false;
            }
            i3 += i4;
            i2 -= i4;
        }
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        if (i > 0) {
            this.c.b(new EW4(bArr, i));
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map d() {
        return this.a.d();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        return this.a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void i(InterfaceC25209zu7 interfaceC25209zu7) {
        AbstractC20011rK.e(interfaceC25209zu7);
        this.a.i(interfaceC25209zu7);
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) {
        if (this.e == 0) {
            if (!n()) {
                return -1;
            }
            this.e = this.b;
        }
        int i3 = this.a.read(bArr, i, Math.min(this.e, i2));
        if (i3 != -1) {
            this.e -= i3;
        }
        return i3;
    }
}
