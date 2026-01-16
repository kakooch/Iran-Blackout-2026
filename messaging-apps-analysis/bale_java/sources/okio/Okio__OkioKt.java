package okio;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16632lc2;
import ir.nasim.UA2;
import ir.nasim.Y73;
import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aC\u0010\u0010\u001a\u00028\u0001\"\u0010\b\u0000\u0010\f*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\r*\u00028\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lokio/Source;", "Lokio/BufferedSource;", "buffer", "(Lokio/Source;)Lokio/BufferedSource;", "Lokio/Sink;", "Lokio/BufferedSink;", "(Lokio/Sink;)Lokio/BufferedSink;", "blackhole", "()Lokio/Sink;", "blackholeSink", "Ljava/io/Closeable;", "Lokio/Closeable;", TokenNames.T, TokenNames.R, "Lkotlin/Function1;", "block", "use", "(Ljava/io/Closeable;Lir/nasim/UA2;)Ljava/lang/Object;", "okio"}, k = 5, mv = {1, 9, 0}, xs = "okio/Okio")
/* loaded from: classes8.dex */
final /* synthetic */ class Okio__OkioKt {
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSource buffer(Source source) {
        AbstractC13042fc3.i(source, "<this>");
        return new buffer(source);
    }

    public static final <T extends Closeable, R> R use(T t, UA2 ua2) throws Throwable {
        R r;
        AbstractC13042fc3.i(ua2, "block");
        Throwable th = null;
        try {
            r = (R) ua2.invoke(t);
            Y73.b(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Y73.a(1);
        } catch (Throwable th3) {
            Y73.b(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable th4) {
                    AbstractC16632lc2.a(th3, th4);
                }
            }
            Y73.a(1);
            th = th3;
            r = null;
        }
        if (th != null) {
            throw th;
        }
        AbstractC13042fc3.f(r);
        return r;
    }

    public static final BufferedSink buffer(Sink sink) {
        AbstractC13042fc3.i(sink, "<this>");
        return new buffer(sink);
    }
}
