package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.a;
import ir.nasim.InterfaceC25209zu7;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class l implements a {
    public static final l a = new l();
    public static final a.InterfaceC0163a b = new a.InterfaceC0163a() { // from class: ir.nasim.ye5
        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
        public final com.google.android.exoplayer2.upstream.a a() {
            return com.google.android.exoplayer2.upstream.l.n();
        }
    };

    private l() {
    }

    public static /* synthetic */ l n() {
        return new l();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(b bVar) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        return null;
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void i(InterfaceC25209zu7 interfaceC25209zu7) {
    }
}
