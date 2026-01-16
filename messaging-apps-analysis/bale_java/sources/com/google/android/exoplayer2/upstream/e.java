package com.google.android.exoplayer2.upstream;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.e;
import ir.nasim.AbstractC13937h43;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC21378tZ2;
import ir.nasim.AbstractC3895Cu6;
import ir.nasim.AbstractC8649Ww2;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.G90;
import ir.nasim.InterfaceC11281ck5;
import ir.nasim.InterfaceC25209zu7;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public class e extends G90 implements HttpDataSource {
    private final boolean e;
    private final int f;
    private final int g;
    private final String h;
    private final HttpDataSource.b i;
    private final HttpDataSource.b j;
    private final boolean k;
    private InterfaceC11281ck5 l;
    private com.google.android.exoplayer2.upstream.b m;
    private HttpURLConnection n;
    private InputStream o;
    private boolean p;
    private int q;
    private long r;
    private long s;

    public static final class b implements a.InterfaceC0163a {
        private InterfaceC25209zu7 b;
        private InterfaceC11281ck5 c;
        private String d;
        private boolean g;
        private boolean h;
        private final HttpDataSource.b a = new HttpDataSource.b();
        private int e = 8000;
        private int f = 8000;

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a() {
            e eVar = new e(this.d, this.e, this.f, this.g, this.a, this.c, this.h);
            InterfaceC25209zu7 interfaceC25209zu7 = this.b;
            if (interfaceC25209zu7 != null) {
                eVar.i(interfaceC25209zu7);
            }
            return eVar;
        }

        public b c(String str) {
            this.d = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c extends AbstractC8649Ww2 {
        private final Map a;

        public c(Map map) {
            this.a = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean j(Map.Entry entry) {
            return entry.getKey() != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean k(String str) {
            return str != null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC8935Xw2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map b() {
            return this.a;
        }

        @Override // ir.nasim.AbstractC8649Ww2, java.util.Map
        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return super.d(obj);
        }

        @Override // ir.nasim.AbstractC8649Ww2, java.util.Map
        public Set entrySet() {
            return AbstractC3895Cu6.b(super.entrySet(), new InterfaceC11281ck5() { // from class: com.google.android.exoplayer2.upstream.g
                @Override // ir.nasim.InterfaceC11281ck5
                public final boolean apply(Object obj) {
                    return e.c.j((Map.Entry) obj);
                }
            });
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return obj != null && super.e(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return super.f();
        }

        @Override // ir.nasim.AbstractC8649Ww2, java.util.Map
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public List get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        @Override // ir.nasim.AbstractC8649Ww2, java.util.Map
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override // ir.nasim.AbstractC8649Ww2, java.util.Map
        public Set keySet() {
            return AbstractC3895Cu6.b(super.keySet(), new InterfaceC11281ck5() { // from class: com.google.android.exoplayer2.upstream.f
                @Override // ir.nasim.InterfaceC11281ck5
                public final boolean apply(Object obj) {
                    return e.c.k((String) obj);
                }
            });
        }

        @Override // ir.nasim.AbstractC8649Ww2, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }
    }

    private void r() {
        HttpURLConnection httpURLConnection = this.n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                AbstractC18815pI3.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.n = null;
        }
    }

    private URL s(URL url, String str, com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource.HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", bVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new HttpDataSource.HttpDataSourceException("Unsupported protocol redirect: " + protocol, bVar, 2001, 1);
            }
            if (this.e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + Separators.RPAREN, bVar, 2001, 1);
        } catch (MalformedURLException e) {
            throw new HttpDataSource.HttpDataSourceException(e, bVar, 2001, 1);
        }
    }

    private static boolean t(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(SIPHeaderNames.CONTENT_ENCODING));
    }

    private HttpURLConnection u(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        HttpURLConnection httpURLConnectionV;
        URL url = new URL(bVar.a.toString());
        int i = bVar.c;
        byte[] bArr = bVar.d;
        long j = bVar.g;
        long j2 = bVar.h;
        boolean zD = bVar.d(1);
        if (!this.e && !this.k) {
            return v(url, i, bArr, j, j2, zD, true, bVar.e);
        }
        int i2 = 0;
        URL urlS = url;
        int i3 = i;
        byte[] bArr2 = bArr;
        while (true) {
            int i4 = i2 + 1;
            if (i2 > 20) {
                throw new HttpDataSource.HttpDataSourceException(new NoRouteToHostException("Too many redirects: " + i4), bVar, 2001, 1);
            }
            long j3 = j;
            long j4 = j;
            int i5 = i3;
            URL url2 = urlS;
            long j5 = j2;
            httpURLConnectionV = v(urlS, i3, bArr2, j3, j2, zD, false, bVar.e);
            int responseCode = httpURLConnectionV.getResponseCode();
            String headerField = httpURLConnectionV.getHeaderField("Location");
            if ((i5 == 1 || i5 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionV.disconnect();
                urlS = s(url2, headerField, bVar);
                i3 = i5;
            } else {
                if (i5 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                httpURLConnectionV.disconnect();
                if (this.k && responseCode == 302) {
                    i3 = i5;
                } else {
                    bArr2 = null;
                    i3 = 1;
                }
                urlS = s(url2, headerField, bVar);
            }
            i2 = i4;
            j = j4;
            j2 = j5;
        }
        return httpURLConnectionV;
    }

    private HttpURLConnection v(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) throws IOException {
        HttpURLConnection httpURLConnectionX = x(url);
        httpURLConnectionX.setConnectTimeout(this.f);
        httpURLConnectionX.setReadTimeout(this.g);
        HashMap map2 = new HashMap();
        HttpDataSource.b bVar = this.i;
        if (bVar != null) {
            map2.putAll(bVar.a());
        }
        map2.putAll(this.j.a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionX.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = AbstractC21378tZ2.a(j, j2);
        if (strA != null) {
            httpURLConnectionX.setRequestProperty("Range", strA);
        }
        String str = this.h;
        if (str != null) {
            httpURLConnectionX.setRequestProperty(SIPHeaderNames.USER_AGENT, str);
        }
        httpURLConnectionX.setRequestProperty(SIPHeaderNames.ACCEPT_ENCODING, z ? "gzip" : "identity");
        httpURLConnectionX.setInstanceFollowRedirects(z2);
        httpURLConnectionX.setDoOutput(bArr != null);
        httpURLConnectionX.setRequestMethod(com.google.android.exoplayer2.upstream.b.c(i));
        if (bArr != null) {
            httpURLConnectionX.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionX.connect();
            OutputStream outputStream = httpURLConnectionX.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionX.connect();
        }
        return httpURLConnectionX;
    }

    private static void w(HttpURLConnection httpURLConnection, long j) throws IllegalAccessException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i;
        if (httpURLConnection == null || (i = AbstractC9683aN7.a) < 19 || i > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) AbstractC20011rK.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, null);
            }
        } catch (Exception unused) {
        }
    }

    private int y(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.r;
        if (j != -1) {
            long j2 = j - this.s;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) AbstractC9683aN7.j(this.o)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.s += i3;
        n(i3);
        return i3;
    }

    private void z(long j, com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int i = ((InputStream) AbstractC9683aN7.j(this.o)).read(bArr, 0, (int) Math.min(j, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), bVar, 2000, 1);
            }
            if (i == -1) {
                throw new HttpDataSource.HttpDataSourceException(bVar, 2008, 1);
            }
            j -= i;
            n(i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) throws IOException, NumberFormatException {
        byte[] bArrX0;
        this.m = bVar;
        long j = 0;
        this.s = 0L;
        this.r = 0L;
        p(bVar);
        try {
            HttpURLConnection httpURLConnectionU = u(bVar);
            this.n = httpURLConnectionU;
            this.q = httpURLConnectionU.getResponseCode();
            String responseMessage = httpURLConnectionU.getResponseMessage();
            int i = this.q;
            if (i < 200 || i > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionU.getHeaderFields();
                if (this.q == 416) {
                    if (bVar.g == AbstractC21378tZ2.c(httpURLConnectionU.getHeaderField("Content-Range"))) {
                        this.p = true;
                        q(bVar);
                        long j2 = bVar.h;
                        if (j2 != -1) {
                            return j2;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionU.getErrorStream();
                try {
                    bArrX0 = errorStream != null ? AbstractC9683aN7.X0(errorStream) : AbstractC9683aN7.f;
                } catch (IOException unused) {
                    bArrX0 = AbstractC9683aN7.f;
                }
                byte[] bArr = bArrX0;
                r();
                throw new HttpDataSource.InvalidResponseCodeException(this.q, responseMessage, this.q == 416 ? new DataSourceException(2008) : null, headerFields, bVar, bArr);
            }
            String contentType = httpURLConnectionU.getContentType();
            InterfaceC11281ck5 interfaceC11281ck5 = this.l;
            if (interfaceC11281ck5 != null && !interfaceC11281ck5.apply(contentType)) {
                r();
                throw new HttpDataSource.InvalidContentTypeException(contentType, bVar);
            }
            if (this.q == 200) {
                long j3 = bVar.g;
                if (j3 != 0) {
                    j = j3;
                }
            }
            boolean zT = t(httpURLConnectionU);
            if (zT) {
                this.r = bVar.h;
            } else {
                long j4 = bVar.h;
                if (j4 != -1) {
                    this.r = j4;
                } else {
                    long jB = AbstractC21378tZ2.b(httpURLConnectionU.getHeaderField(SIPHeaderNames.CONTENT_LENGTH), httpURLConnectionU.getHeaderField("Content-Range"));
                    this.r = jB != -1 ? jB - j : -1L;
                }
            }
            try {
                this.o = httpURLConnectionU.getInputStream();
                if (zT) {
                    this.o = new GZIPInputStream(this.o);
                }
                this.p = true;
                q(bVar);
                try {
                    z(j, bVar);
                    return this.r;
                } catch (IOException e) {
                    r();
                    if (e instanceof HttpDataSource.HttpDataSourceException) {
                        throw ((HttpDataSource.HttpDataSourceException) e);
                    }
                    throw new HttpDataSource.HttpDataSourceException(e, bVar, 2000, 1);
                }
            } catch (IOException e2) {
                r();
                throw new HttpDataSource.HttpDataSourceException(e2, bVar, 2000, 1);
            }
        } catch (IOException e3) {
            r();
            throw HttpDataSource.HttpDataSourceException.c(e3, bVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        try {
            InputStream inputStream = this.o;
            if (inputStream != null) {
                long j = this.r;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.s;
                }
                w(this.n, j2);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new HttpDataSource.HttpDataSourceException(e, (com.google.android.exoplayer2.upstream.b) AbstractC9683aN7.j(this.m), 2000, 3);
                }
            }
        } finally {
            this.o = null;
            r();
            if (this.p) {
                this.p = false;
                o();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map d() {
        HttpURLConnection httpURLConnection = this.n;
        return httpURLConnection == null ? AbstractC13937h43.p() : new c(httpURLConnection.getHeaderFields());
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            return y(bArr, i, i2);
        } catch (IOException e) {
            throw HttpDataSource.HttpDataSourceException.c(e, (com.google.android.exoplayer2.upstream.b) AbstractC9683aN7.j(this.m), 2);
        }
    }

    HttpURLConnection x(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public e(String str, int i, int i2, boolean z, HttpDataSource.b bVar) {
        this(str, i, i2, z, bVar, null, false);
    }

    private e(String str, int i, int i2, boolean z, HttpDataSource.b bVar, InterfaceC11281ck5 interfaceC11281ck5, boolean z2) {
        super(true);
        this.h = str;
        this.f = i;
        this.g = i2;
        this.e = z;
        this.i = bVar;
        this.l = interfaceC11281ck5;
        this.j = new HttpDataSource.b();
        this.k = z2;
    }
}
