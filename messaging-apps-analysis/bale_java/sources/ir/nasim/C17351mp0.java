package ir.nasim;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Response;
import okio.BufferedSink;
import okio.BufferedSource;

/* renamed from: ir.nasim.mp0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17351mp0 {
    private final InterfaceC9173Yu3 a;
    private final InterfaceC9173Yu3 b;
    private final long c;
    private final long d;
    private final boolean e;
    private final Headers f;

    /* renamed from: ir.nasim.mp0$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CacheControl invoke() {
            return CacheControl.INSTANCE.parse(C17351mp0.this.d());
        }
    }

    /* renamed from: ir.nasim.mp0$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MediaType invoke() {
            String str = C17351mp0.this.d().get(SIPHeaderNames.CONTENT_TYPE);
            if (str != null) {
                return MediaType.INSTANCE.parse(str);
            }
            return null;
        }
    }

    public C17351mp0(BufferedSource bufferedSource) throws NumberFormatException {
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.a = AbstractC13269fw3.b(enumC4870Gx3, new a());
        this.b = AbstractC13269fw3.b(enumC4870Gx3, new b());
        this.c = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.d = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.e = Integer.parseInt(bufferedSource.readUtf8LineStrict()) > 0;
        int i = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        Headers.Builder builder = new Headers.Builder();
        for (int i2 = 0; i2 < i; i2++) {
            AbstractC18638p.b(builder, bufferedSource.readUtf8LineStrict());
        }
        this.f = builder.build();
    }

    public final CacheControl a() {
        return (CacheControl) this.a.getValue();
    }

    public final MediaType b() {
        return (MediaType) this.b.getValue();
    }

    public final long c() {
        return this.d;
    }

    public final Headers d() {
        return this.f;
    }

    public final long e() {
        return this.c;
    }

    public final boolean f() {
        return this.e;
    }

    public final void g(BufferedSink bufferedSink) {
        bufferedSink.writeDecimalLong(this.c).writeByte(10);
        bufferedSink.writeDecimalLong(this.d).writeByte(10);
        bufferedSink.writeDecimalLong(this.e ? 1L : 0L).writeByte(10);
        bufferedSink.writeDecimalLong(this.f.size()).writeByte(10);
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            bufferedSink.writeUtf8(this.f.name(i)).writeUtf8(": ").writeUtf8(this.f.value(i)).writeByte(10);
        }
    }

    public C17351mp0(Response response) {
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.a = AbstractC13269fw3.b(enumC4870Gx3, new a());
        this.b = AbstractC13269fw3.b(enumC4870Gx3, new b());
        this.c = response.sentRequestAtMillis();
        this.d = response.receivedResponseAtMillis();
        this.e = response.handshake() != null;
        this.f = response.headers();
    }
}
