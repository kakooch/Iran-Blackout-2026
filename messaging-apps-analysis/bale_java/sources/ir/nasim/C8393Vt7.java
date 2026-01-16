package ir.nasim;

import android.gov.nist.core.Separators;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.cache.a;
import java.util.Map;

/* renamed from: ir.nasim.Vt7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8393Vt7 implements com.google.android.exoplayer2.upstream.a {
    public static final a f = new a(null);
    public static final int g = 8;
    private final com.google.android.exoplayer2.upstream.cache.a a;
    private final InterfaceC19567qa2 b;
    private final EnumC8893Xt7 c;
    private final Map d;
    private final c e;

    /* renamed from: ir.nasim.Vt7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Vt7$b */
    public static final class b implements a.InterfaceC0163a {
        private final a.c a;
        private final InterfaceC19567qa2 b;
        private final EnumC8893Xt7 c;
        private final Map d;

        public b(a.c cVar, InterfaceC19567qa2 interfaceC19567qa2, EnumC8893Xt7 enumC8893Xt7, Map map) {
            AbstractC13042fc3.i(cVar, "cacheDataSourceFactory");
            AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
            AbstractC13042fc3.i(map, "map");
            this.a = cVar;
            this.b = interfaceC19567qa2;
            this.c = enumC8893Xt7;
            this.d = map;
        }

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
        public com.google.android.exoplayer2.upstream.a a() {
            com.google.android.exoplayer2.upstream.cache.a aVarA = this.a.a();
            AbstractC13042fc3.h(aVarA, "createDataSource(...)");
            return new C8393Vt7(aVarA, this.b, this.c, this.d);
        }
    }

    /* renamed from: ir.nasim.Vt7$c */
    public static final class c implements InterfaceC25209zu7 {
        private long a;
        private final String b = "transferInterceptor";

        c() {
        }

        public final long a() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC25209zu7
        public void b(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) {
            AbstractC13042fc3.i(aVar, "source");
            AbstractC13042fc3.i(bVar, "dataSpec");
            long j = bVar.h;
            if (((int) j) != -1) {
                this.a = (z ? 1L : 0L) * j;
            }
            Log.i(this.b, "onTransferEnd: " + j + ",  Boolean: " + z + Separators.SP);
        }

        @Override // ir.nasim.InterfaceC25209zu7
        public void g(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z, int i) {
            AbstractC13042fc3.i(aVar, "source");
            AbstractC13042fc3.i(bVar, "dataSpec");
            this.a += i != -1 ? i * (z ? 1L : 0L) : 0L;
        }

        @Override // ir.nasim.InterfaceC25209zu7
        public void h(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) {
            AbstractC13042fc3.i(aVar, "source");
            AbstractC13042fc3.i(bVar, "dataSpec");
        }

        @Override // ir.nasim.InterfaceC25209zu7
        public void i(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) {
            AbstractC13042fc3.i(aVar, "source");
            AbstractC13042fc3.i(bVar, "dataSpec");
        }
    }

    public C8393Vt7(com.google.android.exoplayer2.upstream.cache.a aVar, InterfaceC19567qa2 interfaceC19567qa2, EnumC8893Xt7 enumC8893Xt7, Map map) {
        AbstractC13042fc3.i(aVar, "cacheDataSource");
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        AbstractC13042fc3.i(map, "bundle");
        this.a = aVar;
        this.b = interfaceC19567qa2;
        this.c = enumC8893Xt7;
        this.d = map;
        c cVar = new c();
        this.e = cVar;
        aVar.i(cVar);
    }

    private final void n() {
        String str = (String) this.d.get("file_hash");
        if (str == null) {
            return;
        }
        String str2 = (String) this.d.get("file_mime_type");
        if (this.c == null || this.e.a() <= 1500 || str.length() == 0) {
            return;
        }
        InterfaceC19567qa2 interfaceC19567qa2 = this.b;
        XV4 xv4A = AbstractC4616Fw7.a("origin", Integer.valueOf(this.c.p()));
        XV4 xv4A2 = AbstractC4616Fw7.a("file_hash", str);
        XV4 xv4A3 = AbstractC4616Fw7.a("file_size", Long.valueOf(this.e.a()));
        if (str2 == null) {
            str2 = "";
        }
        interfaceC19567qa2.a("download_traffic", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a("file_mime_type", str2)));
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) {
        AbstractC13042fc3.i(bVar, "p0");
        return this.a.b(bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        n();
        this.a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        return this.a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void i(InterfaceC25209zu7 interfaceC25209zu7) {
        AbstractC13042fc3.i(interfaceC25209zu7, "p0");
        this.a.i(interfaceC25209zu7);
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) {
        AbstractC13042fc3.i(bArr, "p0");
        return this.a.read(bArr, i, i2);
    }
}
