package ir.nasim;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* renamed from: ir.nasim.qM6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19445qM6 implements com.google.android.exoplayer2.upstream.a {
    private final com.google.android.exoplayer2.upstream.a a;
    private long b;
    private Uri c = Uri.EMPTY;
    private Map d = Collections.emptyMap();

    public C19445qM6(com.google.android.exoplayer2.upstream.a aVar) {
        this.a = (com.google.android.exoplayer2.upstream.a) AbstractC20011rK.e(aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) {
        this.c = bVar.a;
        this.d = Collections.emptyMap();
        long jB = this.a.b(bVar);
        this.c = (Uri) AbstractC20011rK.e(getUri());
        this.d = d();
        return jB;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        this.a.close();
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

    public long n() {
        return this.b;
    }

    public Uri o() {
        return this.c;
    }

    public Map p() {
        return this.d;
    }

    public void q() {
        this.b = 0L;
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) {
        int i3 = this.a.read(bArr, i, i2);
        if (i3 != -1) {
            this.b += i3;
        }
        return i3;
    }
}
