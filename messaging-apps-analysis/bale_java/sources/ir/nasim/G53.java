package ir.nasim;

import android.os.SystemClock;
import com.google.protobuf.AbstractC2383g;
import io.livekit.android.room.datastream.StreamException;
import io.livekit.android.room.participant.Participant;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.InterfaceC16756lo6;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import livekit.LivekitModels$DataStream;

/* loaded from: classes3.dex */
public final class G53 implements F53 {
    public static final a Companion = new a(null);
    private final Map a = Collections.synchronizedMap(new LinkedHashMap());
    private final Map b = Collections.synchronizedMap(new LinkedHashMap());
    private final Map c = Collections.synchronizedMap(new LinkedHashMap());

    public static final class a {
        private a() {
        }

        public final InterfaceC17639nJ0 a() {
            return DJ0.b(Integer.MAX_VALUE, EnumC6162Ml0.SUSPEND, null, 4, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LivekitModels$DataStream.Header.c.values().length];
            try {
                iArr[LivekitModels$DataStream.Header.c.TEXT_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LivekitModels$DataStream.Header.c.BYTE_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LivekitModels$DataStream.Header.c.CONTENTHEADER_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ VX6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC14603iB2 interfaceC14603iB2, VX6 vx6) {
            super(2);
            this.e = interfaceC14603iB2;
            this.f = vx6;
        }

        public final void a(InterfaceC17639nJ0 interfaceC17639nJ0, String str) {
            AbstractC13042fc3.i(interfaceC17639nJ0, "channel");
            AbstractC13042fc3.i(str, "identity");
            InterfaceC14603iB2 interfaceC14603iB2 = this.e;
            if (interfaceC14603iB2 != null) {
                interfaceC14603iB2.invoke(new C7400Ro0((C7166Qo0) this.f, interfaceC17639nJ0), Participant.Identity.a(str));
                return;
            }
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            VX6 vx6 = this.f;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "Received byte stream for topic \"" + vx6.b() + "\", but no handler was found. Ignoring.", new Object[0]);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC17639nJ0) obj, ((Participant.Identity) obj2).getValue());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ VX6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC14603iB2 interfaceC14603iB2, VX6 vx6) {
            super(2);
            this.e = interfaceC14603iB2;
            this.f = vx6;
        }

        public final void a(InterfaceC17639nJ0 interfaceC17639nJ0, String str) {
            AbstractC13042fc3.i(interfaceC17639nJ0, "channel");
            AbstractC13042fc3.i(str, "identity");
            InterfaceC14603iB2 interfaceC14603iB2 = this.e;
            if (interfaceC14603iB2 != null) {
                interfaceC14603iB2.invoke(new C8573Wn7((C8339Vn7) this.f, interfaceC17639nJ0), Participant.Identity.a(str));
                return;
            }
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            VX6 vx6 = this.f;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "Received text stream for topic \"" + vx6.b() + "\", but no handler was found. Ignoring.", new Object[0]);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC17639nJ0) obj, ((Participant.Identity) obj2).getValue());
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ VX6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(VX6 vx6) {
            super(1);
            this.f = vx6;
        }

        public final void a(Throwable th) {
            G53.this.d(this.f.a());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String str) {
        Map map = this.a;
        AbstractC13042fc3.h(map, "openStreams");
        synchronized (map) {
            b bVar = (b) this.a.get(str);
            if (bVar == null) {
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.d(null, "Attempted to close stream " + str + ", but no descriptor was found.", new Object[0]);
                }
                return;
            }
            InterfaceC16756lo6.a.a(bVar.a(), null, 1, null);
            long jElapsedRealtime = SystemClock.elapsedRealtime() - bVar.b();
            AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.d(null, "Closed stream " + str + ", (open for " + jElapsedRealtime + "ms", new Object[0]);
            }
        }
    }

    private final InterfaceC14603iB2 e(VX6 vx6) {
        if (vx6 instanceof C7166Qo0) {
            return new d((InterfaceC14603iB2) this.c.get(vx6.b()), vx6);
        }
        if (vx6 instanceof C8339Vn7) {
            return new e((InterfaceC14603iB2) this.b.get(vx6.b()), vx6);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void f(VX6 vx6, String str) {
        if (this.a.containsKey(vx6.a())) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "Stream already open for id " + vx6.a(), new Object[0]);
            return;
        }
        InterfaceC14603iB2 interfaceC14603iB2E = e(vx6);
        InterfaceC17639nJ0 interfaceC17639nJ0A = Companion.a();
        b bVar = new b(vx6, SystemClock.elapsedRealtime(), interfaceC17639nJ0A, 0L, 8, null);
        Map map = this.a;
        AbstractC13042fc3.h(map, "openStreams");
        map.put(vx6.a(), bVar);
        interfaceC17639nJ0A.f(new f(vx6));
        AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
        if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.d(null, "Opened stream " + vx6.a(), new Object[0]);
        }
        try {
            interfaceC14603iB2E.invoke(interfaceC17639nJ0A, Participant.Identity.a(str));
        } catch (Exception e2) {
            AbstractC6718Or3.a aVar3 = AbstractC6718Or3.Companion;
            if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.e(e2, "Unhandled exception when invoking stream handler!", new Object[0]);
        }
    }

    private final VX6 g(LivekitModels$DataStream.Header header) {
        VX6 c8339Vn7;
        try {
            LivekitModels$DataStream.Header.c contentHeaderCase = header.getContentHeaderCase();
            int i = contentHeaderCase == null ? -1 : c.a[contentHeaderCase.ordinal()];
            if (i != -1) {
                if (i == 1) {
                    LivekitModels$DataStream.TextHeader textHeader = header.getTextHeader();
                    AbstractC13042fc3.h(textHeader, "getTextHeader(...)");
                    c8339Vn7 = new C8339Vn7(header, textHeader);
                } else if (i == 2) {
                    LivekitModels$DataStream.ByteHeader byteHeader = header.getByteHeader();
                    AbstractC13042fc3.h(byteHeader, "getByteHeader(...)");
                    c8339Vn7 = new C7166Qo0(header, byteHeader);
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                return c8339Vn7;
            }
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return null;
            }
            AbstractC5270Ip7.g(null, "received header with non-set content header. streamId: " + header.getStreamId() + ", topic: " + header.getTopic(), new Object[0]);
            return null;
        } catch (Exception e2) {
            AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
            if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.e(e2, "Exception when processing new stream header.", new Object[0]);
            }
            return null;
        }
    }

    @Override // ir.nasim.F53
    public void E() {
        Map map = this.a;
        AbstractC13042fc3.h(map, "openStreams");
        synchronized (map) {
            try {
                Iterator it = AbstractC15401jX0.m1(this.a.values()).iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a().w(new StreamException.TerminatedException(null, 1, null));
                }
                this.a.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.F53
    public void a(LivekitModels$DataStream.Chunk chunk) {
        b bVar;
        AbstractC13042fc3.i(chunk, "chunk");
        AbstractC2383g content = chunk.getContent();
        if (content == null || (bVar = (b) this.a.get(chunk.getStreamId())) == null) {
            return;
        }
        long jC = bVar.c() + content.size();
        Long lC = bVar.d().c();
        if (lC != null && jC > lC.longValue()) {
            bVar.a().w(new StreamException.LengthExceededException());
            return;
        }
        bVar.e(jC);
        InterfaceC17639nJ0 interfaceC17639nJ0A = bVar.a();
        byte[] bArrA0 = content.a0();
        AbstractC13042fc3.h(bArrA0, "toByteArray(...)");
        interfaceC17639nJ0A.h(bArrA0);
    }

    @Override // ir.nasim.F53
    public void c(LivekitModels$DataStream.Header header, String str) {
        AbstractC13042fc3.i(header, "header");
        AbstractC13042fc3.i(str, "fromIdentity");
        VX6 vx6G = g(header);
        if (vx6G == null) {
            return;
        }
        f(vx6G, str);
    }

    @Override // ir.nasim.F53
    public void r(LivekitModels$DataStream.Trailer trailer) {
        AbstractC13042fc3.i(trailer, "trailer");
        b bVar = (b) this.a.get(trailer.getStreamId());
        if (bVar == null) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "Received trailer for unknown stream: " + trailer.getStreamId(), new Object[0]);
            return;
        }
        Long lC = bVar.d().c();
        if (lC != null && bVar.c() != lC.longValue()) {
            bVar.a().w(new StreamException.IncompleteException());
            return;
        }
        String reason = trailer.getReason();
        if (reason == null || reason.length() == 0) {
            InterfaceC16756lo6.a.a(bVar.a(), null, 1, null);
        } else {
            bVar.a().w(new StreamException.AbnormalEndException(reason));
        }
    }

    private static final class b {
        private final VX6 a;
        private final long b;
        private final InterfaceC17639nJ0 c;
        private long d;

        public b(VX6 vx6, long j, InterfaceC17639nJ0 interfaceC17639nJ0, long j2) {
            AbstractC13042fc3.i(vx6, "streamInfo");
            AbstractC13042fc3.i(interfaceC17639nJ0, "channel");
            this.a = vx6;
            this.b = j;
            this.c = interfaceC17639nJ0;
            this.d = j2;
        }

        public final InterfaceC17639nJ0 a() {
            return this.c;
        }

        public final long b() {
            return this.b;
        }

        public final long c() {
            return this.d;
        }

        public final VX6 d() {
            return this.a;
        }

        public final void e(long j) {
            this.d = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c) && this.d == bVar.d;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d);
        }

        public String toString() {
            return "Descriptor(streamInfo=" + this.a + ", openTime=" + this.b + ", channel=" + this.c + ", readLength=" + this.d + ')';
        }

        public /* synthetic */ b(VX6 vx6, long j, InterfaceC17639nJ0 interfaceC17639nJ0, long j2, int i, ED1 ed1) {
            this(vx6, j, interfaceC17639nJ0, (i & 8) != 0 ? 0L : j2);
        }
    }
}
