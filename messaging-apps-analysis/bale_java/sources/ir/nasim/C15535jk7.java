package ir.nasim;

import android.net.Uri;
import java.util.Map;

/* renamed from: ir.nasim.jk7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15535jk7 implements com.google.android.exoplayer2.upstream.a {
    private final com.google.android.exoplayer2.upstream.a a;
    private final InterfaceC20422rz1 b;
    private boolean c;
    private long d;

    public C15535jk7(com.google.android.exoplayer2.upstream.a aVar, InterfaceC20422rz1 interfaceC20422rz1) {
        this.a = (com.google.android.exoplayer2.upstream.a) AbstractC20011rK.e(aVar);
        this.b = (InterfaceC20422rz1) AbstractC20011rK.e(interfaceC20422rz1);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) {
        long jB = this.a.b(bVar);
        this.d = jB;
        if (jB == 0) {
            return 0L;
        }
        if (bVar.h == -1 && jB != -1) {
            bVar = bVar.f(0L, jB);
        }
        this.c = true;
        this.b.b(bVar);
        return this.d;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        try {
            this.a.close();
        } finally {
            if (this.c) {
                this.c = false;
                this.b.close();
            }
        }
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
        if (this.d == 0) {
            return -1;
        }
        int i3 = this.a.read(bArr, i, i2);
        if (i3 > 0) {
            this.b.write(bArr, i, i3);
            long j = this.d;
            if (j != -1) {
                this.d = j - i3;
            }
        }
        return i3;
    }
}
