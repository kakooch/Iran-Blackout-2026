package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.gov.nist.javax.sip.address.ParameterNames;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.e;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C19813qz1;
import ir.nasim.InterfaceC25209zu7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c implements com.google.android.exoplayer2.upstream.a {
    private final Context a;
    private final List b = new ArrayList();
    private final com.google.android.exoplayer2.upstream.a c;
    private com.google.android.exoplayer2.upstream.a d;
    private com.google.android.exoplayer2.upstream.a e;
    private com.google.android.exoplayer2.upstream.a f;
    private com.google.android.exoplayer2.upstream.a g;
    private com.google.android.exoplayer2.upstream.a h;
    private com.google.android.exoplayer2.upstream.a i;
    private com.google.android.exoplayer2.upstream.a j;
    private com.google.android.exoplayer2.upstream.a k;

    public static final class a implements a.InterfaceC0163a {
        private final Context a;
        private final a.InterfaceC0163a b;
        private InterfaceC25209zu7 c;

        public a(Context context) {
            this(context, new e.b());
        }

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a() {
            c cVar = new c(this.a, this.b.a());
            InterfaceC25209zu7 interfaceC25209zu7 = this.c;
            if (interfaceC25209zu7 != null) {
                cVar.i(interfaceC25209zu7);
            }
            return cVar;
        }

        public a(Context context, a.InterfaceC0163a interfaceC0163a) {
            this.a = context.getApplicationContext();
            this.b = interfaceC0163a;
        }
    }

    public c(Context context, com.google.android.exoplayer2.upstream.a aVar) {
        this.a = context.getApplicationContext();
        this.c = (com.google.android.exoplayer2.upstream.a) AbstractC20011rK.e(aVar);
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
        if (this.i == null) {
            C19813qz1 c19813qz1 = new C19813qz1();
            this.i = c19813qz1;
            n(c19813qz1);
        }
        return this.i;
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
        if (this.j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.a);
            this.j = rawResourceDataSource;
            n(rawResourceDataSource);
        }
        return this.j;
    }

    private com.google.android.exoplayer2.upstream.a t() {
        if (this.g == null) {
            try {
                com.google.android.exoplayer2.upstream.a aVar = (com.google.android.exoplayer2.upstream.a) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                this.g = aVar;
                n(aVar);
            } catch (ClassNotFoundException unused) {
                AbstractC18815pI3.k("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
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
        if (this.h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.h = udpDataSource;
            n(udpDataSource);
        }
        return this.h;
    }

    private void v(com.google.android.exoplayer2.upstream.a aVar, InterfaceC25209zu7 interfaceC25209zu7) {
        if (aVar != null) {
            aVar.i(interfaceC25209zu7);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(b bVar) {
        AbstractC20011rK.g(this.k == null);
        String scheme = bVar.a.getScheme();
        if (AbstractC9683aN7.w0(bVar.a)) {
            String path = bVar.a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.k = r();
            } else {
                this.k = o();
            }
        } else if ("asset".equals(scheme)) {
            this.k = o();
        } else if ("content".equals(scheme)) {
            this.k = p();
        } else if ("rtmp".equals(scheme)) {
            this.k = t();
        } else if (ParameterNames.UDP.equals(scheme)) {
            this.k = u();
        } else if ("data".equals(scheme)) {
            this.k = q();
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            this.k = s();
        } else {
            this.k = this.c;
        }
        return this.k.b(bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        com.google.android.exoplayer2.upstream.a aVar = this.k;
        if (aVar != null) {
            try {
                aVar.close();
            } finally {
                this.k = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map d() {
        com.google.android.exoplayer2.upstream.a aVar = this.k;
        return aVar == null ? Collections.emptyMap() : aVar.d();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        com.google.android.exoplayer2.upstream.a aVar = this.k;
        if (aVar == null) {
            return null;
        }
        return aVar.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void i(InterfaceC25209zu7 interfaceC25209zu7) {
        AbstractC20011rK.e(interfaceC25209zu7);
        this.c.i(interfaceC25209zu7);
        this.b.add(interfaceC25209zu7);
        v(this.d, interfaceC25209zu7);
        v(this.e, interfaceC25209zu7);
        v(this.f, interfaceC25209zu7);
        v(this.g, interfaceC25209zu7);
        v(this.h, interfaceC25209zu7);
        v(this.i, interfaceC25209zu7);
        v(this.j, interfaceC25209zu7);
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) {
        return ((com.google.android.exoplayer2.upstream.a) AbstractC20011rK.e(this.k)).read(bArr, i, i2);
    }
}
