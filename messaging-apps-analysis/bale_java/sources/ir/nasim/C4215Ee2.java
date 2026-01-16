package ir.nasim;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Ee2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4215Ee2 implements com.google.android.exoplayer2.upstream.a {
    private final Context a;
    private final List b;
    private final com.google.android.exoplayer2.upstream.a c;
    private com.google.android.exoplayer2.upstream.a d;
    private com.google.android.exoplayer2.upstream.a e;
    private com.google.android.exoplayer2.upstream.a f;
    private com.google.android.exoplayer2.upstream.a g;
    private com.google.android.exoplayer2.upstream.a h;
    private com.google.android.exoplayer2.upstream.a i;
    private com.google.android.exoplayer2.upstream.a j;

    public C4215Ee2(Context context, com.google.android.exoplayer2.upstream.a aVar) {
        this.a = context.getApplicationContext();
        this.c = (com.google.android.exoplayer2.upstream.a) AbstractC20011rK.e(aVar);
        this.b = new ArrayList();
    }

    private void n(com.google.android.exoplayer2.upstream.a aVar) {
        for (int i = 0; i < this.b.size(); i++) {
            aVar.i((InterfaceC25209zu7) this.b.get(i));
        }
    }

    private com.google.android.exoplayer2.upstream.a o() {
        if (this.e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.a);
            this.e = assetDataSource;
            n(assetDataSource);
        }
        return this.e;
    }

    private com.google.android.exoplayer2.upstream.a p() {
        if (this.f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.a);
            this.f = contentDataSource;
            n(contentDataSource);
        }
        return this.f;
    }

    private com.google.android.exoplayer2.upstream.a q() {
        if (this.h == null) {
            C19813qz1 c19813qz1 = new C19813qz1();
            this.h = c19813qz1;
            n(c19813qz1);
        }
        return this.h;
    }

    private com.google.android.exoplayer2.upstream.a r() {
        if (this.d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.d = fileDataSource;
            n(fileDataSource);
        }
        return this.d;
    }

    private com.google.android.exoplayer2.upstream.a s() {
        if (this.i == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.a);
            this.i = rawResourceDataSource;
            n(rawResourceDataSource);
        }
        return this.i;
    }

    private com.google.android.exoplayer2.upstream.a t() {
        if (this.g == null) {
            try {
                com.google.android.exoplayer2.upstream.a aVar = (com.google.android.exoplayer2.upstream.a) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                this.g = aVar;
                n(aVar);
            } catch (ClassNotFoundException unused) {
                AbstractC18815pI3.k("ExtendedDefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating RTMP extension", e);
            }
            if (this.g == null) {
                this.g = this.c;
            }
        }
        return this.g;
    }

    private com.google.android.exoplayer2.upstream.a u() {
        C20296rm2 c20296rm2 = new C20296rm2();
        n(c20296rm2);
        return c20296rm2;
    }

    private void v(com.google.android.exoplayer2.upstream.a aVar, InterfaceC25209zu7 interfaceC25209zu7) {
        if (aVar != null) {
            aVar.i(interfaceC25209zu7);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) {
        AbstractC20011rK.g(this.j == null);
        String scheme = bVar.a.getScheme();
        if (AbstractC9683aN7.w0(bVar.a)) {
            String path = bVar.a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.j = r();
            } else {
                this.j = o();
            }
        } else if ("tg".equals(scheme)) {
            this.j = u();
        } else if ("asset".equals(scheme)) {
            this.j = o();
        } else if ("content".equals(scheme)) {
            this.j = p();
        } else if ("rtmp".equals(scheme)) {
            this.j = t();
        } else if ("data".equals(scheme)) {
            this.j = q();
        } else if ("rawresource".equals(scheme)) {
            this.j = s();
        } else {
            this.j = this.c;
        }
        return this.j.b(bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        com.google.android.exoplayer2.upstream.a aVar = this.j;
        if (aVar != null) {
            try {
                aVar.close();
            } finally {
                this.j = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map d() {
        com.google.android.exoplayer2.upstream.a aVar = this.j;
        return aVar == null ? Collections.emptyMap() : aVar.d();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        com.google.android.exoplayer2.upstream.a aVar = this.j;
        if (aVar == null) {
            return null;
        }
        return aVar.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void i(InterfaceC25209zu7 interfaceC25209zu7) {
        this.c.i(interfaceC25209zu7);
        this.b.add(interfaceC25209zu7);
        v(this.d, interfaceC25209zu7);
        v(this.e, interfaceC25209zu7);
        v(this.f, interfaceC25209zu7);
        v(this.g, interfaceC25209zu7);
        v(this.h, interfaceC25209zu7);
        v(this.i, interfaceC25209zu7);
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) {
        return ((com.google.android.exoplayer2.upstream.a) AbstractC20011rK.e(this.j)).read(bArr, i, i2);
    }

    public C4215Ee2(Context context, InterfaceC25209zu7 interfaceC25209zu7, com.google.android.exoplayer2.upstream.a aVar) {
        this(context, aVar);
        if (interfaceC25209zu7 != null) {
            this.b.add(interfaceC25209zu7);
            aVar.i(interfaceC25209zu7);
        }
    }
}
