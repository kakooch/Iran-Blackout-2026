package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import ir.nasim.C9475a16;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* renamed from: ir.nasim.nZ2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17785nZ2 implements Interceptor {
    private final b a;
    private volatile Set b;
    private volatile a c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.nZ2$a */
    public static final class a {
        public static final a a = new a("NONE", 0);
        public static final a b = new a("HEADERS", 1);
        private static final /* synthetic */ a[] c;
        private static final /* synthetic */ F92 d;

        static {
            a[] aVarArrA = a();
            c = aVarArrA;
            d = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) c.clone();
        }
    }

    /* renamed from: ir.nasim.nZ2$b */
    public interface b {
        void log(String str);
    }

    public C17785nZ2(b bVar) {
        AbstractC13042fc3.i(bVar, "logger");
        this.a = bVar;
        this.b = AbstractC4597Fu6.d();
        this.c = a.a;
    }

    private final void b(Headers headers, int i) {
        String strValue = this.b.contains(headers.name(i)) ? "██" : headers.value(i);
        this.a.log(headers.name(i) + ": " + strValue);
    }

    private final HttpUrl c(HttpUrl httpUrl) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(httpUrl.newBuilder().query(null).build());
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        return (HttpUrl) (C9475a16.g(objB) ? null : objB);
    }

    public final void a(a aVar) {
        AbstractC13042fc3.i(aVar, "<set-?>");
        this.c = aVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        AbstractC13042fc3.i(chain, ReferencesHeader.CHAIN);
        a aVar = this.c;
        Request request = chain.request();
        if (aVar == a.a) {
            return chain.proceed(request);
        }
        boolean z = aVar == a.b;
        RequestBody requestBodyBody = request.body();
        Connection connection = chain.connection();
        String str = "--> " + request.method() + Separators.SP + c(request.url()) + (connection != null ? Separators.SP + connection.protocol() : "");
        if (!z && requestBodyBody != null) {
            str = str + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.a.log(str);
        if (z) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType mediaTypeContentType = requestBodyBody.getContentType();
                if (mediaTypeContentType != null && headers.get(SIPHeaderNames.CONTENT_TYPE) == null) {
                    this.a.log("Content-Type: " + mediaTypeContentType);
                }
                if (requestBodyBody.contentLength() != -1 && headers.get(SIPHeaderNames.CONTENT_LENGTH) == null) {
                    this.a.log("Content-Length: " + requestBodyBody.contentLength());
                }
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                b(headers, i);
            }
            this.a.log("--> END " + request.method());
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            AbstractC13042fc3.f(responseBodyBody);
            long jContentLength = responseBodyBody.getContentLength();
            String str2 = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            this.a.log("<-- " + responseProceed.code() + (responseProceed.message().length() == 0 ? "" : ' ' + responseProceed.message()) + Separators.SP + c(responseProceed.request().url()) + " (" + millis + "ms" + (z ? "" : ", " + str2 + " body") + Separators.RPAREN);
            if (z) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b(headers2, i2);
                }
                this.a.log("<-- END HTTP");
            }
            return responseProceed;
        } catch (Exception e) {
            this.a.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }
}
