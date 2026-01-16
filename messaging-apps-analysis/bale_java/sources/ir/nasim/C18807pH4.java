package ir.nasim;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* renamed from: ir.nasim.pH4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18807pH4 extends G90 implements HttpDataSource {
    private final Call.Factory e;
    private final HttpDataSource.b f;
    private final String g;
    private final CacheControl h;
    private final HttpDataSource.b i;
    private InterfaceC11281ck5 j;
    private com.google.android.exoplayer2.upstream.b k;
    private Response l;
    private InputStream m;
    private boolean n;
    private long o;
    private long p;

    /* renamed from: ir.nasim.pH4$a */
    class a implements Callback {
        final /* synthetic */ C5080Hu6 a;

        a(C18807pH4 c18807pH4, C5080Hu6 c5080Hu6) {
            this.a = c5080Hu6;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.a.y(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            this.a.x(response);
        }
    }

    /* renamed from: ir.nasim.pH4$b */
    public static final class b implements a.InterfaceC0163a {
        private final HttpDataSource.b a = new HttpDataSource.b();
        private final Call.Factory b;
        private String c;
        private InterfaceC25209zu7 d;
        private CacheControl e;
        private InterfaceC11281ck5 f;

        public b(Call.Factory factory) {
            this.b = factory;
        }

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C18807pH4 a() {
            C18807pH4 c18807pH4 = new C18807pH4(this.b, this.c, this.e, this.a, this.f, null);
            InterfaceC25209zu7 interfaceC25209zu7 = this.d;
            if (interfaceC25209zu7 != null) {
                c18807pH4.i(interfaceC25209zu7);
            }
            return c18807pH4;
        }
    }

    static {
        AbstractC9253Zd2.a("goog.exo.okhttp");
    }

    /* synthetic */ C18807pH4(Call.Factory factory, String str, CacheControl cacheControl, HttpDataSource.b bVar, InterfaceC11281ck5 interfaceC11281ck5, a aVar) {
        this(factory, str, cacheControl, bVar, interfaceC11281ck5);
    }

    private void r() {
        Response response = this.l;
        if (response != null) {
            ((ResponseBody) AbstractC20011rK.e(response.body())).close();
            this.l = null;
        }
        this.m = null;
    }

    private Response s(Call call) throws IOException {
        C5080Hu6 c5080Hu6Z = C5080Hu6.z();
        call.enqueue(new a(this, c5080Hu6Z));
        try {
            return (Response) c5080Hu6Z.get();
        } catch (InterruptedException unused) {
            call.cancel();
            throw new InterruptedIOException();
        } catch (ExecutionException e) {
            throw new IOException(e);
        }
    }

    private Request t(com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource.HttpDataSourceException {
        long j = bVar.g;
        long j2 = bVar.h;
        HttpUrl httpUrl = HttpUrl.parse(bVar.a.toString());
        if (httpUrl == null) {
            throw new HttpDataSource.HttpDataSourceException("Malformed URL", bVar, 1004, 1);
        }
        Request.Builder builderUrl = new Request.Builder().url(httpUrl);
        CacheControl cacheControl = this.h;
        if (cacheControl != null) {
            builderUrl.cacheControl(cacheControl);
        }
        HashMap map = new HashMap();
        HttpDataSource.b bVar2 = this.i;
        if (bVar2 != null) {
            map.putAll(bVar2.a());
        }
        map.putAll(this.f.a());
        map.putAll(bVar.e);
        for (Map.Entry entry : map.entrySet()) {
            builderUrl.header((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = AbstractC21378tZ2.a(j, j2);
        if (strA != null) {
            builderUrl.addHeader("Range", strA);
        }
        String str = this.g;
        if (str != null) {
            builderUrl.addHeader(SIPHeaderNames.USER_AGENT, str);
        }
        if (!bVar.d(1)) {
            builderUrl.addHeader(SIPHeaderNames.ACCEPT_ENCODING, "identity");
        }
        byte[] bArr = bVar.d;
        RequestBody requestBodyCreate = null;
        if (bArr != null) {
            requestBodyCreate = RequestBody.create((MediaType) null, bArr);
        } else if (bVar.c == 2) {
            requestBodyCreate = RequestBody.create((MediaType) null, AbstractC9683aN7.f);
        }
        builderUrl.method(bVar.b(), requestBodyCreate);
        return builderUrl.build();
    }

    private int u(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.o;
        if (j != -1) {
            long j2 = j - this.p;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) AbstractC9683aN7.j(this.m)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.p += i3;
        n(i3);
        return i3;
    }

    private void v(long j, com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            try {
                int i = ((InputStream) AbstractC9683aN7.j(this.m)).read(bArr, 0, (int) Math.min(j, 4096));
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (i == -1) {
                    throw new HttpDataSource.HttpDataSourceException(bVar, 2008, 1);
                }
                j -= i;
                n(i);
            } catch (IOException e) {
                if (!(e instanceof HttpDataSource.HttpDataSourceException)) {
                    throw new HttpDataSource.HttpDataSourceException(bVar, 2000, 1);
                }
                throw ((HttpDataSource.HttpDataSourceException) e);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        byte[] bArrX0;
        this.k = bVar;
        long j = 0;
        this.p = 0L;
        this.o = 0L;
        p(bVar);
        try {
            Response responseS = s(this.e.newCall(t(bVar)));
            this.l = responseS;
            ResponseBody responseBody = (ResponseBody) AbstractC20011rK.e(responseS.body());
            this.m = responseBody.byteStream();
            int iCode = responseS.code();
            if (!responseS.isSuccessful()) {
                if (iCode == 416) {
                    if (bVar.g == AbstractC21378tZ2.c(responseS.headers().get("Content-Range"))) {
                        this.n = true;
                        q(bVar);
                        long j2 = bVar.h;
                        if (j2 != -1) {
                            return j2;
                        }
                        return 0L;
                    }
                }
                try {
                    bArrX0 = AbstractC9683aN7.X0((InputStream) AbstractC20011rK.e(this.m));
                } catch (IOException unused) {
                    bArrX0 = AbstractC9683aN7.f;
                }
                byte[] bArr = bArrX0;
                Map<String, List<String>> multimap = responseS.headers().toMultimap();
                r();
                throw new HttpDataSource.InvalidResponseCodeException(iCode, responseS.message(), iCode == 416 ? new DataSourceException(2008) : null, multimap, bVar, bArr);
            }
            MediaType mediaTypeContentType = responseBody.get$contentType();
            String mediaType = mediaTypeContentType != null ? mediaTypeContentType.getMediaType() : "";
            InterfaceC11281ck5 interfaceC11281ck5 = this.j;
            if (interfaceC11281ck5 != null && !interfaceC11281ck5.apply(mediaType)) {
                r();
                throw new HttpDataSource.InvalidContentTypeException(mediaType, bVar);
            }
            if (iCode == 200) {
                long j3 = bVar.g;
                if (j3 != 0) {
                    j = j3;
                }
            }
            long j4 = bVar.h;
            if (j4 != -1) {
                this.o = j4;
            } else {
                long jContentLength = responseBody.getContentLength();
                this.o = jContentLength != -1 ? jContentLength - j : -1L;
            }
            this.n = true;
            q(bVar);
            try {
                v(j, bVar);
                return this.o;
            } catch (HttpDataSource.HttpDataSourceException e) {
                r();
                throw e;
            }
        } catch (IOException e2) {
            throw HttpDataSource.HttpDataSourceException.c(e2, bVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        if (this.n) {
            this.n = false;
            o();
            r();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map d() {
        Response response = this.l;
        return response == null ? Collections.emptyMap() : response.headers().toMultimap();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        Response response = this.l;
        if (response == null) {
            return null;
        }
        return Uri.parse(response.request().url().getUrl());
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            return u(bArr, i, i2);
        } catch (IOException e) {
            throw HttpDataSource.HttpDataSourceException.c(e, (com.google.android.exoplayer2.upstream.b) AbstractC9683aN7.j(this.k), 2);
        }
    }

    private C18807pH4(Call.Factory factory, String str, CacheControl cacheControl, HttpDataSource.b bVar, InterfaceC11281ck5 interfaceC11281ck5) {
        super(true);
        this.e = (Call.Factory) AbstractC20011rK.e(factory);
        this.g = str;
        this.h = cacheControl;
        this.i = bVar;
        this.j = interfaceC11281ck5;
        this.f = new HttpDataSource.b();
    }
}
