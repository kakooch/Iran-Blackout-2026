package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.SystemClock;
import ir.nasim.InterfaceC18557or4;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.RequestBody;
import okhttp3.Response;

/* renamed from: ir.nasim.g30, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13333g30 extends EventListener {
    private static final b f = new b(null);
    private static final EventListener g = new a();
    private final d a;
    private final SA2 b;
    private final InterfaceC11463d30 c;
    private final String d;
    private Long e;

    /* renamed from: ir.nasim.g30$a */
    public static final class a extends EventListener {
        a() {
        }
    }

    /* renamed from: ir.nasim.g30$b */
    private static final class b {
        private b() {
        }

        public final EventListener a() {
            return C13333g30.g;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.g30$d */
    private static final class d {
        public static final d a = new d("UP", 0);
        public static final d b = new d("DOWN", 1);
        private static final /* synthetic */ d[] c;
        private static final /* synthetic */ F92 d;

        static {
            d[] dVarArrA = a();
            c = dVarArrA;
            d = G92.a(dVarArrA);
        }

        private d(String str, int i) {
        }

        private static final /* synthetic */ d[] a() {
            return new d[]{a, b};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) c.clone();
        }
    }

    public /* synthetic */ C13333g30(long j, d dVar, SA2 sa2, InterfaceC11463d30 interfaceC11463d30, ED1 ed1) {
        this(j, dVar, sa2, interfaceC11463d30);
    }

    private final C12106e30 c(Call call) {
        return (C12106e30) call.request().tag(C12106e30.class);
    }

    private final boolean d(IOException iOException) {
        String message;
        if (iOException instanceof SocketTimeoutException) {
            return true;
        }
        return (iOException instanceof ConnectException) && (message = iOException.getMessage()) != null && AbstractC20762sZ6.V(message, "timed out", true);
    }

    private final Long e(Call call) {
        RequestBody requestBodyBody = call.request().body();
        if (requestBodyBody != null) {
            return Long.valueOf(requestBodyBody.contentLength());
        }
        return null;
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(iOException, "ioe");
        if (d(iOException)) {
            long jLongValue = ((Number) this.b.invoke()).longValue();
            Long l = this.e;
            if (l != null) {
                long jLongValue2 = jLongValue - l.longValue();
                C12106e30 c12106e30C = c(call);
                if (c12106e30C == null) {
                    return;
                }
                this.c.a(new InterfaceC18557or4.a(jLongValue2, iOException, 0L, c12106e30C));
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        this.e = (Long) this.b.invoke();
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        AbstractC13042fc3.i(call, "call");
        if (this.a != d.b) {
            return;
        }
        long jLongValue = ((Number) this.b.invoke()).longValue();
        Long l = this.e;
        if (l != null) {
            long jLongValue2 = jLongValue - l.longValue();
            C12106e30 c12106e30C = c(call);
            if (c12106e30C == null) {
                return;
            }
            this.c.a(new InterfaceC18557or4.b(jLongValue2, j, c12106e30C));
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Long lE;
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(response, "response");
        if (this.a != d.a) {
            return;
        }
        long jLongValue = ((Number) this.b.invoke()).longValue();
        Long l = this.e;
        if (l != null) {
            long jLongValue2 = jLongValue - l.longValue();
            C12106e30 c12106e30C = c(call);
            if (c12106e30C == null || (lE = e(call)) == null) {
                return;
            }
            this.c.a(new InterfaceC18557or4.b(jLongValue2, lE.longValue(), c12106e30C));
        }
    }

    private C13333g30(long j, d dVar, SA2 sa2, InterfaceC11463d30 interfaceC11463d30) {
        this.a = dVar;
        this.b = sa2;
        this.c = interfaceC11463d30;
        this.d = "BandwidthWatcher(" + j + "_" + dVar + Separators.RPAREN;
    }

    /* renamed from: ir.nasim.g30$c */
    public static final class c implements EventListener.Factory {
        private final SA2 a;
        private final InterfaceC11463d30 b;
        private final InterfaceC11463d30 c;
        private final AtomicLong d;

        /* renamed from: ir.nasim.g30$c$a */
        /* synthetic */ class a extends EB2 implements SA2 {
            public static final a a = new a();

            a() {
                super(0, SystemClock.class, "elapsedRealtimeNanos", "elapsedRealtimeNanos()J", 0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final Long invoke() {
                return Long.valueOf(SystemClock.elapsedRealtimeNanos());
            }
        }

        public c(SA2 sa2, InterfaceC11463d30 interfaceC11463d30, InterfaceC11463d30 interfaceC11463d302) {
            AbstractC13042fc3.i(sa2, "timeProviderInNanos");
            AbstractC13042fc3.i(interfaceC11463d30, "uploadBandwidthOptimizer");
            AbstractC13042fc3.i(interfaceC11463d302, "downloadBandwidthOptimizer");
            this.a = sa2;
            this.b = interfaceC11463d30;
            this.c = interfaceC11463d302;
            this.d = new AtomicLong();
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
        
            return new ir.nasim.C13333g30(r7.d.incrementAndGet(), ir.nasim.C13333g30.d.a, r7.a, r7.b, null);
         */
        @Override // okhttp3.EventListener.Factory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public okhttp3.EventListener create(okhttp3.Call r8) {
            /*
                r7 = this;
                java.lang.String r0 = "call"
                ir.nasim.AbstractC13042fc3.i(r8, r0)
                okhttp3.Request r8 = r8.request()
                java.lang.String r8 = r8.method()
                int r0 = r8.hashCode()
                r1 = 70454(0x11336, float:9.8727E-41)
                if (r0 == r1) goto L46
                r1 = 79599(0x136ef, float:1.11542E-40)
                if (r0 == r1) goto L2a
                r1 = 2461856(0x2590a0, float:3.449795E-39)
                if (r0 == r1) goto L21
                goto L4e
            L21:
                java.lang.String r0 = "POST"
                boolean r8 = r8.equals(r0)
                if (r8 != 0) goto L32
                goto L4e
            L2a:
                java.lang.String r0 = "PUT"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L4e
            L32:
                ir.nasim.g30$d r3 = ir.nasim.C13333g30.d.a
                java.util.concurrent.atomic.AtomicLong r8 = r7.d
                long r1 = r8.incrementAndGet()
                ir.nasim.SA2 r4 = r7.a
                ir.nasim.d30 r5 = r7.b
                ir.nasim.g30 r8 = new ir.nasim.g30
                r6 = 0
                r0 = r8
                r0.<init>(r1, r3, r4, r5, r6)
                goto L6a
            L46:
                java.lang.String r0 = "GET"
                boolean r8 = r8.equals(r0)
                if (r8 != 0) goto L57
            L4e:
                ir.nasim.g30$b r8 = ir.nasim.C13333g30.a()
                okhttp3.EventListener r8 = r8.a()
                goto L6a
            L57:
                ir.nasim.g30$d r3 = ir.nasim.C13333g30.d.b
                java.util.concurrent.atomic.AtomicLong r8 = r7.d
                long r1 = r8.incrementAndGet()
                ir.nasim.SA2 r4 = r7.a
                ir.nasim.d30 r5 = r7.c
                ir.nasim.g30 r8 = new ir.nasim.g30
                r6 = 0
                r0 = r8
                r0.<init>(r1, r3, r4, r5, r6)
            L6a:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13333g30.c.create(okhttp3.Call):okhttp3.EventListener");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC11463d30 interfaceC11463d30, InterfaceC11463d30 interfaceC11463d302) {
            this(a.a, interfaceC11463d30, interfaceC11463d302);
            AbstractC13042fc3.i(interfaceC11463d30, "uploadBandwidthOptimizer");
            AbstractC13042fc3.i(interfaceC11463d302, "downloadBandwidthOptimizer");
        }
    }
}
