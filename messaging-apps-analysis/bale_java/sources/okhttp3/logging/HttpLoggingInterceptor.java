package okhttp3.logging;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC4597Fu6;
import ir.nasim.DY6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14067hI1;
import ir.nasim.YV0;
import ir.nasim.database.dailogLists.DialogEntity;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002'(B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R*\u0010\u0015\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00148\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b\u001a\u0010\u0019\"\u0004\b\u0015\u0010&¨\u0006)"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "Lokhttp3/Headers;", "headers", "", "i", "Lir/nasim/rB7;", "logHeader", "(Lokhttp3/Headers;I)V", "", "bodyHasUnknownEncoding", "(Lokhttp3/Headers;)Z", "", "name", "redactHeader", "(Ljava/lang/String;)V", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "setLevel", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;", "-deprecated_level", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "getLevel", "Lokhttp3/Interceptor$Chain;", ReferencesHeader.CHAIN, "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "headersToRedact", "Ljava/util/Set;", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes8.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "", DialogEntity.COLUMN_MESSAGE, "Lir/nasim/rB7;", "log", "(Ljava/lang/String;)V", "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0})
    public interface Logger {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DefaultLogger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<init>", "()V", "", DialogEntity.COLUMN_MESSAGE, "Lir/nasim/rB7;", "log", "(Ljava/lang/String;)V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0})
            private static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    AbstractC13042fc3.i(message, DialogEntity.COLUMN_MESSAGE);
                    Platform.log$default(Platform.INSTANCE.get(), message, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }

        void log(String message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get(SIPHeaderNames.CONTENT_ENCODING);
        return (str == null || AbstractC20153rZ6.D(str, "identity", true) || AbstractC20153rZ6.D(str, "gzip", true)) ? false : true;
    }

    private final void logHeader(Headers headers, int i) {
        String strValue = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        this.logger.log(headers.name(i) + ": " + strValue);
    }

    @InterfaceC14067hI1
    /* renamed from: -deprecated_level, reason: not valid java name and from getter */
    public final Level getLevel() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        String string;
        String str;
        char c;
        String string2;
        Charset charset;
        Charset charset2;
        AbstractC13042fc3.i(chain, ReferencesHeader.CHAIN);
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        RequestBody requestBodyBody = request.body();
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        if (connection != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(' ');
            sb2.append(connection.protocol());
            string = sb2.toString();
        } else {
            string = "";
        }
        sb.append(string);
        String string3 = sb.toString();
        if (!z2 && requestBodyBody != null) {
            string3 = string3 + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.logger.log(string3);
        if (z2) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType mediaType = requestBodyBody.get$contentType();
                if (mediaType != null && headers.get(SIPHeaderNames.CONTENT_TYPE) == null) {
                    this.logger.log("Content-Type: " + mediaType);
                }
                if (requestBodyBody.contentLength() != -1 && headers.get(SIPHeaderNames.CONTENT_LENGTH) == null) {
                    this.logger.log("Content-Length: " + requestBodyBody.contentLength());
                }
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                logHeader(headers, i);
            }
            if (!z || requestBodyBody == null) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (requestBodyBody.isDuplex()) {
                this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (requestBodyBody.isOneShot()) {
                this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBodyBody.writeTo(buffer);
                MediaType mediaType2 = requestBodyBody.get$contentType();
                if (mediaType2 == null || (charset2 = mediaType2.charset(StandardCharsets.UTF_8)) == null) {
                    charset2 = StandardCharsets.UTF_8;
                    AbstractC13042fc3.h(charset2, "UTF_8");
                }
                this.logger.log("");
                if (Utf8Kt.isProbablyUtf8(buffer)) {
                    this.logger.log(buffer.readString(charset2));
                    this.logger.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                }
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            AbstractC13042fc3.f(responseBodyBody);
            long contentLength = responseBodyBody.getContentLength();
            String str2 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<-- ");
            sb3.append(responseProceed.code());
            if (responseProceed.message().length() == 0) {
                str = "-byte body omitted)";
                string2 = "";
                c = ' ';
            } else {
                String strMessage = responseProceed.message();
                StringBuilder sb4 = new StringBuilder();
                str = "-byte body omitted)";
                c = ' ';
                sb4.append(' ');
                sb4.append(strMessage);
                string2 = sb4.toString();
            }
            sb3.append(string2);
            sb3.append(c);
            sb3.append(responseProceed.request().url());
            sb3.append(" (");
            sb3.append(millis);
            sb3.append("ms");
            sb3.append(z2 ? "" : ", " + str2 + " body");
            sb3.append(')');
            logger.log(sb3.toString());
            if (z2) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    logHeader(headers2, i2);
                }
                if (!z || !HttpHeaders.promisesBody(responseProceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(responseProceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = responseBodyBody.getSource();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.getBuffer();
                    Long l = null;
                    if (AbstractC20153rZ6.D("gzip", headers2.get(SIPHeaderNames.CONTENT_ENCODING), true)) {
                        Long lValueOf = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            YV0.a(gzipSource, null);
                            l = lValueOf;
                        } finally {
                        }
                    }
                    MediaType mediaType3 = responseBodyBody.get$contentType();
                    if (mediaType3 == null || (charset = mediaType3.charset(StandardCharsets.UTF_8)) == null) {
                        charset = StandardCharsets.UTF_8;
                        AbstractC13042fc3.h(charset, "UTF_8");
                    }
                    if (!Utf8Kt.isProbablyUtf8(buffer2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer2.size() + str);
                        return responseProceed;
                    }
                    if (contentLength != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(charset));
                    }
                    if (l != null) {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                }
            }
            return responseProceed;
        } catch (Exception e) {
            this.logger.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public final void level(Level level) {
        AbstractC13042fc3.i(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(String name) {
        AbstractC13042fc3.i(name, "name");
        TreeSet treeSet = new TreeSet(AbstractC20153rZ6.F(DY6.a));
        AbstractC13610gX0.D(treeSet, this.headersToRedact);
        treeSet.add(name);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        AbstractC13042fc3.i(level, "level");
        this.level = level;
        return this;
    }

    public HttpLoggingInterceptor(Logger logger) {
        AbstractC13042fc3.i(logger, "logger");
        this.logger = logger;
        this.headersToRedact = AbstractC4597Fu6.d();
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i, ED1 ed1) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
