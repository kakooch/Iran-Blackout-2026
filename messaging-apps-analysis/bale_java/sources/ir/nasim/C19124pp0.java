package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: ir.nasim.pp0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19124pp0 {
    public static final a c = new a(null);
    private final Request a;
    private final C17351mp0 b;

    /* renamed from: ir.nasim.pp0$a */
    public static final class a {
        private a() {
        }

        private final boolean d(String str) {
            return AbstractC20153rZ6.D(SIPHeaderNames.CONTENT_LENGTH, str, true) || AbstractC20153rZ6.D(SIPHeaderNames.CONTENT_ENCODING, str, true) || AbstractC20153rZ6.D(SIPHeaderNames.CONTENT_TYPE, str, true);
        }

        private final boolean e(String str) {
            return (AbstractC20153rZ6.D("Connection", str, true) || AbstractC20153rZ6.D("Keep-Alive", str, true) || AbstractC20153rZ6.D(SIPHeaderNames.PROXY_AUTHENTICATE, str, true) || AbstractC20153rZ6.D(SIPHeaderNames.PROXY_AUTHORIZATION, str, true) || AbstractC20153rZ6.D("TE", str, true) || AbstractC20153rZ6.D("Trailers", str, true) || AbstractC20153rZ6.D("Transfer-Encoding", str, true) || AbstractC20153rZ6.D("Upgrade", str, true)) ? false : true;
        }

        public final Headers a(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String strName = headers.name(i);
                String strValue = headers.value(i);
                if ((!AbstractC20153rZ6.D(SIPHeaderNames.WARNING, strName, true) || !AbstractC20153rZ6.S(strValue, "1", false, 2, null)) && (d(strName) || !e(strName) || headers2.get(strName) == null)) {
                    builder.addUnsafeNonAscii(strName, strValue);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strName2 = headers2.name(i2);
                if (!d(strName2) && e(strName2)) {
                    builder.addUnsafeNonAscii(strName2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        public final boolean b(Request request, C17351mp0 c17351mp0) {
            return (request.cacheControl().noStore() || c17351mp0.a().noStore() || AbstractC13042fc3.d(c17351mp0.d().get("Vary"), Separators.STAR)) ? false : true;
        }

        public final boolean c(Request request, Response response) {
            return (request.cacheControl().noStore() || response.cacheControl().noStore() || AbstractC13042fc3.d(response.headers().get("Vary"), Separators.STAR)) ? false : true;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.pp0$b */
    public static final class b {
        private final Request a;
        private final C17351mp0 b;
        private Date c;
        private String d;
        private Date e;
        private String f;
        private Date g;
        private long h;
        private long i;
        private String j;
        private int k;

        public b(Request request, C17351mp0 c17351mp0) {
            this.a = request;
            this.b = c17351mp0;
            this.k = -1;
            if (c17351mp0 != null) {
                this.h = c17351mp0.e();
                this.i = c17351mp0.c();
                Headers headersD = c17351mp0.d();
                int size = headersD.size();
                for (int i = 0; i < size; i++) {
                    String strName = headersD.name(i);
                    if (AbstractC20153rZ6.D(strName, SIPHeaderNames.DATE, true)) {
                        this.c = headersD.getDate(SIPHeaderNames.DATE);
                        this.d = headersD.value(i);
                    } else if (AbstractC20153rZ6.D(strName, SIPHeaderNames.EXPIRES, true)) {
                        this.g = headersD.getDate(SIPHeaderNames.EXPIRES);
                    } else if (AbstractC20153rZ6.D(strName, "Last-Modified", true)) {
                        this.e = headersD.getDate("Last-Modified");
                        this.f = headersD.value(i);
                    } else if (AbstractC20153rZ6.D(strName, "ETag", true)) {
                        this.j = headersD.value(i);
                    } else if (AbstractC20153rZ6.D(strName, "Age", true)) {
                        this.k = AbstractC18638p.z(headersD.value(i), -1);
                    }
                }
            }
        }

        private final long a() {
            Date date = this.c;
            long jMax = date != null ? Math.max(0L, this.i - date.getTime()) : 0L;
            int i = this.k;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            return jMax + (this.i - this.h) + (C9963aq7.a.a() - this.i);
        }

        private final long c() {
            C17351mp0 c17351mp0 = this.b;
            AbstractC13042fc3.f(c17351mp0);
            if (c17351mp0.a().maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            Date date = this.g;
            if (date != null) {
                Date date2 = this.c;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.i);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.e == null || this.a.url().query() != null) {
                return 0L;
            }
            Date date3 = this.c;
            long time2 = date3 != null ? date3.getTime() : this.h;
            Date date4 = this.e;
            AbstractC13042fc3.f(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / 10;
            }
            return 0L;
        }

        private final boolean d(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final C19124pp0 b() {
            String str;
            C17351mp0 c17351mp0 = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.b == null) {
                return new C19124pp0(this.a, c17351mp0, objArr12 == true ? 1 : 0);
            }
            if (this.a.isHttps() && !this.b.f()) {
                return new C19124pp0(this.a, objArr11 == true ? 1 : 0, objArr10 == true ? 1 : 0);
            }
            CacheControl cacheControlA = this.b.a();
            if (!C19124pp0.c.b(this.a, this.b)) {
                return new C19124pp0(this.a, objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0);
            }
            CacheControl cacheControl = this.a.cacheControl();
            if (cacheControl.noCache() || d(this.a)) {
                return new C19124pp0(this.a, objArr2 == true ? 1 : 0, objArr == true ? 1 : 0);
            }
            long jA = a();
            long jC = c();
            if (cacheControl.maxAgeSeconds() != -1) {
                jC = Math.min(jC, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
            if (!cacheControlA.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControlA.noCache() && jA + millis2 < jC + millis) {
                return new C19124pp0(objArr7 == true ? 1 : 0, this.b, objArr6 == true ? 1 : 0);
            }
            String str2 = this.j;
            if (str2 != null) {
                AbstractC13042fc3.f(str2);
                str = "If-None-Match";
            } else {
                str = "If-Modified-Since";
                if (this.e != null) {
                    str2 = this.f;
                    AbstractC13042fc3.f(str2);
                } else {
                    if (this.c == null) {
                        return new C19124pp0(this.a, objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0);
                    }
                    str2 = this.d;
                    AbstractC13042fc3.f(str2);
                }
            }
            return new C19124pp0(this.a.newBuilder().addHeader(str, str2).build(), this.b, objArr5 == true ? 1 : 0);
        }
    }

    public /* synthetic */ C19124pp0(Request request, C17351mp0 c17351mp0, ED1 ed1) {
        this(request, c17351mp0);
    }

    public final C17351mp0 a() {
        return this.b;
    }

    public final Request b() {
        return this.a;
    }

    private C19124pp0(Request request, C17351mp0 c17351mp0) {
        this.a = request;
        this.b = c17351mp0;
    }
}
