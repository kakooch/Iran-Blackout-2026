package ir.nasim;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.net.URLDecoder;

/* renamed from: ir.nasim.qz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19813qz1 extends G90 {
    private com.google.android.exoplayer2.upstream.b e;
    private byte[] f;
    private int g;
    private int h;

    public C19813qz1() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) throws DataSourceException, ParserException {
        p(bVar);
        this.e = bVar;
        Uri uri = bVar.a;
        String scheme = uri.getScheme();
        AbstractC20011rK.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrR0 = AbstractC9683aN7.R0(uri.getSchemeSpecificPart(), ",");
        if (strArrR0.length != 2) {
            throw ParserException.b("Unexpected URI format: " + uri, null);
        }
        String str = strArrR0[1];
        if (strArrR0[0].contains(";base64")) {
            try {
                this.f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw ParserException.b("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.f = AbstractC9683aN7.m0(URLDecoder.decode(str, AbstractC12884fL0.a.name()));
        }
        long j = bVar.g;
        byte[] bArr = this.f;
        if (j > bArr.length) {
            this.f = null;
            throw new DataSourceException(2008);
        }
        int i = (int) j;
        this.g = i;
        int length = bArr.length - i;
        this.h = length;
        long j2 = bVar.h;
        if (j2 != -1) {
            this.h = (int) Math.min(length, j2);
        }
        q(bVar);
        long j3 = bVar.h;
        return j3 != -1 ? j3 : this.h;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        if (this.f != null) {
            this.f = null;
            o();
        }
        this.e = null;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        com.google.android.exoplayer2.upstream.b bVar = this.e;
        if (bVar != null) {
            return bVar.a;
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        System.arraycopy(AbstractC9683aN7.j(this.f), this.g, bArr, i, iMin);
        this.g += iMin;
        this.h -= iMin;
        n(iMin);
        return iMin;
    }
}
