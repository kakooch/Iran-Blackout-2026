package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import ir.nasim.InterfaceC10839cH7;
import ir.nasim.core.modules.file.FileSizeExceededException;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.network.RpcException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.No6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6434No6 extends S1 {
    private final HashMap u;
    private final HashMap v;
    private final HashMap w;
    private C4275El x;
    private final C22333v35 y;
    private C9057Yh4 z;

    /* renamed from: ir.nasim.No6$A */
    public static class A {
        private final C11458d25 a;
        private final Long b;
        private final String c;
        private final List d;
        private final Boolean e;
        private final EnumC9567aB f;
        private final Long g;
        private final Long h;

        public A(C11458d25 c11458d25, Long l, String str, List list, Boolean bool, EnumC9567aB enumC9567aB, Long l2, Long l3) {
            this.a = c11458d25;
            this.b = l;
            this.d = list;
            this.e = bool;
            this.c = str;
            this.f = enumC9567aB;
            this.h = l3;
            this.g = l2;
        }

        public C11458d25 h() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.No6$B */
    public static class B extends z {
        private final AbstractC4970Hi4 l;
        private final AbstractC13130fi4 m;
        private final String n;

        public B(C11458d25 c11458d25, AbstractC4970Hi4 abstractC4970Hi4, C22694vg2 c22694vg2, String str, String str2, String str3, int i, int i2, int i3, AbstractC13130fi4 abstractC13130fi4, String str4) {
            super(c11458d25, c22694vg2, str, str2, str3, i, i2, i3, null, null, null);
            this.l = abstractC4970Hi4;
            this.m = abstractC13130fi4;
            this.n = str4;
        }

        public AbstractC13130fi4 m() {
            return this.m;
        }

        public AbstractC4970Hi4 n() {
            return this.l;
        }
    }

    /* renamed from: ir.nasim.No6$C */
    public static class C implements InterfaceC15283jK {
        private final C11458d25 a;
        private final C22694vg2 b;
        private final String c;
        private final int d;
        private final int e;
        private final int f;
        private final Long g;
        private final Long h;
        private final C7880To7 i;

        public C(C11458d25 c11458d25, String str, int i, Long l, Long l2, int i2, int i3, C22694vg2 c22694vg2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.e = i3;
            this.f = i2;
            this.b = c22694vg2;
            this.c = str;
            this.d = i;
            this.g = l;
            this.h = l2;
            this.i = c7880To7;
        }

        public Long a() {
            return this.h;
        }

        public String b() {
            return this.c;
        }

        public C22694vg2 c() {
            return this.b;
        }

        public Long d() {
            return this.g;
        }

        public int e() {
            return this.d;
        }

        public int f() {
            return this.f;
        }

        public C11458d25 g() {
            return this.a;
        }

        public C7880To7 h() {
            return this.i;
        }

        public int i() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.No6$D */
    public static class D {
        private final C11458d25 a;
        private final C23698xM6 b;
        private final Long c;
        private final Long d;
        private final C7880To7 e;

        public D(C11458d25 c11458d25, C23698xM6 c23698xM6, Long l, Long l2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = c23698xM6;
            this.c = l;
            this.d = l2;
            this.e = c7880To7;
        }

        public C11458d25 a() {
            return this.a;
        }

        public Long b() {
            return this.d;
        }

        public Long c() {
            return this.c;
        }

        public C23698xM6 d() {
            return this.b;
        }

        public C7880To7 e() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.No6$E */
    public static class E {
        private final C11458d25 a;
        private final String b;
        private final C16526lQ6 c;

        public E(C11458d25 c11458d25, String str, C16526lQ6 c16526lQ6) {
            this.a = c11458d25;
            this.b = str;
            this.c = c16526lQ6;
        }
    }

    /* renamed from: ir.nasim.No6$F */
    public static class F {
        private final C11458d25 a;
        private final String b;
        private final long c;

        public F(C11458d25 c11458d25, String str, Long l) {
            this.a = c11458d25;
            this.b = str;
            this.c = l.longValue();
        }

        public C11458d25 b() {
            return this.a;
        }

        public long c() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.No6$G */
    public static class G {
        private final C11458d25 a;
        private final String b;
        private final ArrayList c;
        private final boolean d;
        private final Long e;
        private final Long f;
        private final C7880To7 g;

        public G(C11458d25 c11458d25, String str, ArrayList arrayList, boolean z, Long l, Long l2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = str;
            this.c = arrayList;
            this.d = z;
            this.e = l;
            this.f = l2;
            this.g = c7880To7;
        }

        public ArrayList b() {
            return this.c;
        }

        public C11458d25 c() {
            return this.a;
        }

        public Long d() {
            return this.f;
        }

        public Long e() {
            return this.e;
        }

        public String f() {
            return this.b;
        }

        public boolean g() {
            return this.d;
        }
    }

    /* renamed from: ir.nasim.No6$H */
    public static class H {
        private final C11458d25 a;
        private final String b;
        private final ArrayList c;
        private final boolean d;
        private final Long e;
        private final Long f;
        private final C7880To7 g;

        public H(C11458d25 c11458d25, String str, ArrayList arrayList, boolean z, Long l, Long l2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = str;
            this.c = arrayList;
            this.d = z;
            this.e = l;
            this.f = l2;
            this.g = c7880To7;
        }

        public ArrayList a() {
            return this.c;
        }

        public C11458d25 b() {
            return this.a;
        }

        public Long c() {
            return this.f;
        }

        public Long d() {
            return this.e;
        }

        public String e() {
            return this.b;
        }

        public C7880To7 f() {
            return this.g;
        }

        public boolean g() {
            return this.d;
        }
    }

    /* renamed from: ir.nasim.No6$I */
    public static class I {
        private final C11458d25 a;
        private final String b;
        private final int c;
        private final int d;
        private final int e;
        private final C22694vg2 f;
        private final String g;
        private final String h;
        private final int i;
        private final Long j;
        private final Long k;
        private final boolean l;
        private final C7880To7 m;

        public I(C11458d25 c11458d25, String str, int i, int i2, int i3, C22694vg2 c22694vg2, String str2, String str3, int i4, Long l, Long l2, boolean z, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = str;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = c22694vg2;
            this.g = str2;
            this.h = str3;
            this.i = i4;
            this.j = l;
            this.k = l2;
            this.l = z;
            this.m = c7880To7;
        }

        public String a() {
            return this.h;
        }

        public String b() {
            return this.g;
        }

        public int c() {
            return this.e;
        }

        public C22694vg2 d() {
            return this.f;
        }

        public String e() {
            return this.b;
        }

        public int f() {
            return this.i;
        }

        public int g() {
            return this.d;
        }

        public C11458d25 h() {
            return this.a;
        }

        public Long i() {
            return this.k;
        }

        public Long j() {
            return this.j;
        }

        public C7880To7 k() {
            return this.m;
        }

        public int l() {
            return this.c;
        }

        public boolean m() {
            return this.l;
        }
    }

    /* renamed from: ir.nasim.No6$J */
    public static class J {
        private final C11458d25 a;
        private final String b;
        private final String c;
        private final int d;
        private final Long e;
        private final Long f;
        private final String g;
        private final C7880To7 h;

        public J(C11458d25 c11458d25, String str, String str2, int i, Long l, Long l2, String str3, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = l;
            this.f = l2;
            this.g = str3;
            this.h = c7880To7;
        }

        public String a() {
            return this.g;
        }

        public String b() {
            return this.b;
        }

        public int c() {
            return this.d;
        }

        public String d() {
            return this.c;
        }

        public C11458d25 e() {
            return this.a;
        }

        public Long f() {
            return this.f;
        }

        public Long g() {
            return this.e;
        }

        public C7880To7 h() {
            return this.h;
        }
    }

    /* renamed from: ir.nasim.No6$K */
    public static class K {
    }

    /* renamed from: ir.nasim.No6$a, reason: case insensitive filesystem */
    class C6435a implements InterfaceC18995pc1 {
        final /* synthetic */ J44 a;
        final /* synthetic */ C11458d25 b;

        C6435a(J44 j44, C11458d25 c11458d25) {
            this.a = j44;
            this.b = c11458d25;
        }

        @Override // ir.nasim.InterfaceC18995pc1
        public void a() {
            C6434No6.this.w.remove(Long.valueOf(this.a.i()));
            C19857r35 c19857r35X0 = C6434No6.this.x0(this.a.i());
            if (c19857r35X0 != null) {
                C6434No6.this.o.r().remove(c19857r35X0);
                C6434No6.this.W0();
            }
        }

        @Override // ir.nasim.InterfaceC18995pc1
        public void b(long j) {
            C6434No6.this.w.remove(Long.valueOf(this.a.i()));
            C19857r35 c19857r35X0 = C6434No6.this.x0(this.a.i());
            if (c19857r35X0 != null) {
                C6434No6.this.o.r().remove(c19857r35X0);
                J44 j44W = this.a.w(GS7.B((GS7) this.a.F(), (int) j, false));
                C6434No6.this.z.G().H0(this.b).d(j44W);
                C6434No6.this.o.r().add(new C19857r35(this.b, j44W.i(), j44W.F(), c19857r35X0.w()));
                C6434No6.this.W0();
            }
        }
    }

    /* renamed from: ir.nasim.No6$c, reason: case insensitive filesystem */
    class C6437c implements O66 {
        final /* synthetic */ long a;
        final /* synthetic */ C11458d25 b;
        final /* synthetic */ C22993wA c;
        final /* synthetic */ InterfaceC22912w18 d;
        final /* synthetic */ C7234Qv5 e;

        C6437c(long j, C11458d25 c11458d25, C22993wA c22993wA, InterfaceC22912w18 interfaceC22912w18, C7234Qv5 c7234Qv5) {
            this.a = j;
            this.b = c11458d25;
            this.c = c22993wA;
            this.d = interfaceC22912w18;
            this.e = c7234Qv5;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            C6434No6.this.u.remove(Long.valueOf(this.a));
            C6434No6.this.r().d(new C6445k(this.b, this.a));
            this.d.a();
            this.e.a(rpcException);
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(C23490x06 c23490x06) {
            C6434No6.this.u.remove(Long.valueOf(this.a));
            C6434No6.this.r().d(new l(this.b, this.a, c23490x06.h()));
            C6434No6.this.z.V().S(c23490x06.w(), c23490x06.y(), new WE7(C18732p92.o(this.c), this.a, c23490x06.h(), c23490x06.u() != null ? C6434No6.this.c2(c23490x06.u()) : null), 0);
            this.d.a();
            C6434No6.this.S0(c23490x06.h());
            this.e.b(c23490x06);
        }
    }

    /* renamed from: ir.nasim.No6$d, reason: case insensitive filesystem */
    class C6438d implements O66 {
        final /* synthetic */ C7234Qv5 a;
        final /* synthetic */ long b;
        final /* synthetic */ C11458d25 c;
        final /* synthetic */ InterfaceC22912w18 d;
        final /* synthetic */ C7880To7 e;
        final /* synthetic */ C3933Cz f;
        final /* synthetic */ AbstractC24063xz g;

        C6438d(C7234Qv5 c7234Qv5, long j, C11458d25 c11458d25, InterfaceC22912w18 interfaceC22912w18, C7880To7 c7880To7, C3933Cz c3933Cz, AbstractC24063xz abstractC24063xz) {
            this.a = c7234Qv5;
            this.b = j;
            this.c = c11458d25;
            this.d = interfaceC22912w18;
            this.e = c7880To7;
            this.f = c3933Cz;
            this.g = abstractC24063xz;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            this.a.a(rpcException);
            C6434No6.this.y.d(this.c.getPeerId());
            C6434No6.this.u.remove(Long.valueOf(this.b));
            C6434No6.this.r().d(new C6445k(this.c, this.b));
            this.d.a();
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(C23490x06 c23490x06) {
            this.a.b(C14505i18.a);
            C6434No6.this.u.remove(Long.valueOf(this.b));
            C6434No6.this.y.d(this.c.getPeerId());
            C6434No6.this.r().d(new l(this.c, this.b, c23490x06.h()));
            WE7 we7 = new WE7(this.c, this.b, c23490x06.h(), c23490x06.u() != null ? C6434No6.this.c2(c23490x06.u()) : null);
            C6434No6.this.z.G().T0().E(we7);
            boolean z = false;
            C6434No6.this.z.V().S(c23490x06.w(), c23490x06.y(), we7, 0);
            this.d.a();
            if (this.e != null) {
                Integer numO0 = ((C14697iL2) C6434No6.this.z.E().X1().d(this.c.getPeerId())).o0();
                if (numO0 == null) {
                    return;
                }
                C3933Cz c3933Cz = this.f;
                if (c3933Cz != null && c3933Cz.i() != this.e.i()) {
                    z = true;
                }
                C20320ro6.b(we7.d(), numO0.intValue(), this.e.i(), z, C6434No6.this.g2(this.g), this.e.q());
            }
            C6434No6.this.S0(c23490x06.h());
        }
    }

    /* renamed from: ir.nasim.No6$e, reason: case insensitive filesystem */
    static /* synthetic */ class C6439e {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4543Fo6.values().length];
            a = iArr;
            try {
                iArr[EnumC4543Fo6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC4543Fo6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC4543Fo6.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC4543Fo6.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC4543Fo6.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumC4543Fo6.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: ir.nasim.No6$f, reason: case insensitive filesystem */
    public static class C6440f {
        private final long a;

        public C6440f(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.No6$g, reason: case insensitive filesystem */
    public static class C6441g {
        private final C11458d25 a;
        private final J44 b;
        private final C7880To7 c;

        public C6441g(C11458d25 c11458d25, J44 j44, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = j44;
            this.c = c7880To7;
        }

        public C7880To7 c() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.No6$h, reason: case insensitive filesystem */
    public static class C6442h {
        private final C11458d25 a;

        public C6442h(C11458d25 c11458d25) {
            this.a = c11458d25;
        }

        public C11458d25 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.No6$i, reason: case insensitive filesystem */
    public static class C6443i {
        private final List a;

        public C6443i(List list) {
            this.a = list;
        }

        public List a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.No6$j, reason: case insensitive filesystem */
    public static class C6444j {
        private final C11458d25 a;
        private final C11458d25 b;
        private final List c;
        private final String d;

        public C6444j(C11458d25 c11458d25, C11458d25 c11458d252, List list, String str) {
            this.a = c11458d25;
            this.b = c11458d252;
            this.c = list;
            this.d = str;
        }

        public String a() {
            return this.d;
        }

        public C11458d25 b() {
            return this.b;
        }

        public List c() {
            return this.c;
        }

        public C11458d25 d() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.No6$k, reason: case insensitive filesystem */
    public static class C6445k {
        private final C11458d25 a;
        private final long b;

        public C6445k(C11458d25 c11458d25, long j) {
            this.a = c11458d25;
            this.b = j;
        }

        public C11458d25 a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.No6$l */
    public static class l {
        private final C11458d25 a;
        private final long b;
        private final long c;

        public l(C11458d25 c11458d25, long j, long j2) {
            this.a = c11458d25;
            this.b = j;
            this.c = j2;
        }

        public C11458d25 a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.No6$m */
    public static class m {
        private final Long a;
        private final C11458d25 b;
        private final Long c;
        private final Long d;
        private final List e;

        public m(Long l, C11458d25 c11458d25, Long l2, Long l3, List list) {
            this.a = l;
            this.b = c11458d25;
            this.c = l2;
            this.d = l3;
            this.e = list;
        }
    }

    /* renamed from: ir.nasim.No6$n */
    public static final class n extends UJ5 {
        private final C11458d25 a;
        private final J44 b;

        public n(C11458d25 c11458d25, J44 j44) {
            this.a = c11458d25;
            this.b = j44;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (obj != null && n.class == obj.getClass()) {
                return Arrays.equals(b(), ((n) obj).b());
            }
            return false;
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.a, this.b};
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return AbstractC6694Oo6.a(n.class, b());
        }

        public final String toString() {
            return AbstractC6928Po6.a(b(), n.class, "a;b");
        }
    }

    /* renamed from: ir.nasim.No6$o */
    public static class o {
        private final C11458d25 a;
        private final C14419ht b;
        private final Long c;
        private final Long d;

        public o(C11458d25 c11458d25, C14419ht c14419ht, Long l, Long l2) {
            this.a = c11458d25;
            this.b = c14419ht;
            this.c = l;
            this.d = l2;
        }

        public C11458d25 a() {
            return this.a;
        }

        public Long b() {
            return this.d;
        }

        public Long c() {
            return this.c;
        }

        public C14419ht d() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.No6$p */
    public static class p {
        private final C11458d25 a;
        private final String b;
        private final String c;
        private final int d;
        private final Long e;
        private final Long f;
        private final String g;
        private final C7880To7 h;

        public p(C11458d25 c11458d25, String str, String str2, int i, String str3, Long l, Long l2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.g = str3;
            this.e = l;
            this.f = l2;
            this.h = c7880To7;
        }

        public String a() {
            return this.g;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public C11458d25 e() {
            return this.a;
        }

        public Long f() {
            return this.f;
        }

        public Long g() {
            return this.e;
        }

        public C7880To7 h() {
            return this.h;
        }
    }

    /* renamed from: ir.nasim.No6$q */
    public static class q {
        private final C11458d25 a;
        private final long b;
        private final int c;
        private final String d;
        private final String e;
        private final String f;
        private final Long g;
        private final C7880To7 h;

        public q(C11458d25 c11458d25, long j, String str, String str2, String str3, Long l, int i, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = l;
            this.b = j;
            this.c = i;
            this.h = c7880To7;
        }

        public String b() {
            return this.f;
        }

        public String c() {
            return this.e;
        }

        public String d() {
            return this.d;
        }

        public C11458d25 e() {
            return this.a;
        }

        public Long f() {
            return this.g;
        }

        public long g() {
            return this.b;
        }

        public int h() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.No6$r */
    public static class r {
        private final C11458d25 a;
        private final ArrayList b;
        private final ArrayList c;
        private final String d;
        private final String e;
        private final Long f;
        private final Long g;
        private final C7880To7 h;

        public r(C11458d25 c11458d25, ArrayList arrayList, ArrayList arrayList2, String str, String str2, Long l, Long l2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = arrayList;
            this.c = arrayList2;
            this.d = str;
            this.e = str2;
            this.f = l;
            this.g = l2;
            this.h = c7880To7;
        }

        public String a() {
            return this.e;
        }

        public ArrayList b() {
            return this.c;
        }

        public String c() {
            return this.d;
        }

        public C11458d25 d() {
            return this.a;
        }

        public ArrayList e() {
            return this.b;
        }

        public Long f() {
            return this.g;
        }

        public Long g() {
            return this.f;
        }

        public C7880To7 h() {
            return this.h;
        }
    }

    /* renamed from: ir.nasim.No6$s */
    public static class s extends z {
        private final String l;
        private final String m;
        private final long n;
        private final long o;
        private final long p;
        private final String q;

        public s(C11458d25 c11458d25, C9625aH3 c9625aH3, String str, String str2, long j, long j2, long j3, String str3) {
            super(c11458d25, new C22694vg2(c9625aH3.s()), c9625aH3.u(), c9625aH3.getFileName(), str, c9625aH3.getFileSize(), c9625aH3.z(), c9625aH3.y(), null, null, null);
            this.l = str;
            this.m = str2;
            this.n = j;
            this.o = j2;
            this.p = j3;
            this.q = str3;
        }
    }

    /* renamed from: ir.nasim.No6$t */
    public static class t implements InterfaceC15283jK {
        private final C11458d25 a;
        private final C22694vg2 b;
        private final String c;
        private final String d;
        private final String e;
        private final int f;
        private final String g;
        private final Long h;
        private final Long i;
        private final C7880To7 j;

        public t(C11458d25 c11458d25, String str, String str2, int i, String str3, C22694vg2 c22694vg2, String str4, Long l, Long l2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = c22694vg2;
            this.c = str3;
            this.d = str;
            this.e = str2;
            this.f = i;
            this.g = str4;
            this.h = l;
            this.i = l2;
            this.j = c7880To7;
        }

        public String a() {
            return this.g;
        }

        public String b() {
            return this.c;
        }

        public C22694vg2 c() {
            return this.b;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.f;
        }

        public String f() {
            return this.e;
        }

        public C11458d25 g() {
            return this.a;
        }

        public Long h() {
            return this.i;
        }

        public Long i() {
            return this.h;
        }

        public C7880To7 j() {
            return this.j;
        }
    }

    /* renamed from: ir.nasim.No6$u */
    public static class u {
        private final C11458d25 a;
        private final long b;
        private final long c;
        private final C24967zW1 d;
        private final C7880To7 e;

        public u(C11458d25 c11458d25, long j, long j2, C24967zW1 c24967zW1, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = j;
            this.c = j2;
            this.d = c24967zW1;
            this.e = c7880To7;
        }

        public C24967zW1 a() {
            return this.d;
        }

        public C11458d25 b() {
            return this.a;
        }

        public long c() {
            return this.c;
        }

        public long d() {
            return this.b;
        }

        public C7880To7 e() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.No6$v */
    public static class v {
        private final C11458d25 a;
        private final String b;
        private final int c;
        private final int d;
        private final int e;
        private final C22694vg2 f;
        private final String g;
        private final String h;
        private final int i;
        private final Long j;
        private final Long k;
        private final String l;
        private final C7880To7 m;

        public v(C11458d25 c11458d25, String str, int i, int i2, int i3, C22694vg2 c22694vg2, String str2, String str3, int i4, Long l, Long l2, String str4, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = str;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = c22694vg2;
            this.g = str2;
            this.h = str3;
            this.i = i4;
            this.j = l;
            this.k = l2;
            this.l = str4;
            this.m = c7880To7;
        }

        public String a() {
            return this.h;
        }

        public String b() {
            return this.g;
        }

        public int c() {
            return this.e;
        }

        public C22694vg2 d() {
            return this.f;
        }

        public String e() {
            return this.b;
        }

        public int f() {
            return this.i;
        }

        public int g() {
            return this.d;
        }

        public String h() {
            return this.l;
        }

        public C11458d25 i() {
            return this.a;
        }

        public Long j() {
            return this.k;
        }

        public Long k() {
            return this.j;
        }

        public C7880To7 l() {
            return this.m;
        }

        public int m() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.No6$w */
    public static class w {
        private final C11458d25 a;
        private final QG2 b;
        private final ArrayList c;
        private final Long d;
        private final Long e;
        private final C7880To7 f;

        public w(C11458d25 c11458d25, QG2 qg2, ArrayList arrayList, Long l, Long l2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = qg2;
            this.c = arrayList;
            this.d = l;
            this.e = l2;
            this.f = c7880To7;
        }

        public C7880To7 f() {
            return this.f;
        }
    }

    /* renamed from: ir.nasim.No6$x */
    public static class x implements InterfaceC15283jK {
        private final C11458d25 a;
        private final int b;
        private final long c;
        private final EnumC19802qy d;
        private final String e;
        private final String f;

        public x(C11458d25 c11458d25, int i, long j, EnumC19802qy enumC19802qy, String str, String str2) {
            this.a = c11458d25;
            this.d = enumC19802qy;
            this.b = i;
            this.c = j;
            this.e = str2;
            this.f = str;
        }

        public int a() {
            return this.b;
        }

        public EnumC19802qy b() {
            return this.d;
        }

        public C11458d25 c() {
            return this.a;
        }

        public String d() {
            return this.f;
        }

        public String e() {
            return this.e;
        }

        public long f() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.No6$y */
    public static class y {
        private final C11458d25 a;
        private final Double b;
        private final Double c;
        private final String d;
        private final String e;
        private final Long f;
        private final Long g;
        private final C7880To7 h;

        public y(C11458d25 c11458d25, Double d, Double d2, String str, String str2, Long l, Long l2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = d;
            this.c = d2;
            this.e = str2;
            this.d = str;
            this.f = l;
            this.g = l2;
            this.h = c7880To7;
        }

        public Double a() {
            return this.c;
        }

        public Double b() {
            return this.b;
        }

        public C11458d25 c() {
            return this.a;
        }

        public String d() {
            return this.e;
        }

        public Long e() {
            return this.g;
        }

        public Long f() {
            return this.f;
        }

        public String g() {
            return this.d;
        }

        public C7880To7 h() {
            return this.h;
        }
    }

    /* renamed from: ir.nasim.No6$z */
    public static class z implements InterfaceC15283jK {
        private final C11458d25 a;
        private final C22694vg2 b;
        private final String c;
        private final String d;
        private final String e;
        private final int f;
        private final int g;
        private final int h;
        private final Long i;
        private final Long j;
        private final C7880To7 k;

        public z(C11458d25 c11458d25, C22694vg2 c22694vg2, String str, String str2, String str3, int i, int i2, int i3, Long l, Long l2, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = c22694vg2;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = l;
            this.j = l2;
            this.k = c7880To7;
        }

        public String a() {
            return this.e;
        }

        public String b() {
            return this.c;
        }

        public C22694vg2 c() {
            return this.b;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.f;
        }

        public int f() {
            return this.h;
        }

        public C11458d25 g() {
            return this.a;
        }

        public Long h() {
            return this.j;
        }

        public Long i() {
            return this.i;
        }

        public C7880To7 j() {
            return this.k;
        }

        public int k() {
            return this.g;
        }
    }

    public C6434No6(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.u = new HashMap();
        this.v = new HashMap();
        this.w = new HashMap();
        this.y = new C22333v35(new UA2() { // from class: ir.nasim.Go6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return this.a.o2((SP5) obj);
            }
        });
        this.z = c9057Yh4;
        b0("sequences_synced");
    }

    private void A1(final C11458d25 c11458d25, final C11458d25 c11458d252, final List list, String str) {
        if (str == null || str.trim().isEmpty()) {
            C0(c11458d25, c11458d252, list);
        } else {
            L1(c11458d25, str).G(new InterfaceC17569nB2() { // from class: ir.nasim.Jo6
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return C6434No6.l2((Exception) obj);
                }
            }).H(new InterfaceC17569nB2() { // from class: ir.nasim.Ko6
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.m2(c11458d25, c11458d252, list, (C14505i18) obj);
                }
            });
        }
    }

    private void A2(C11458d25 c11458d25, long j, AbstractC24063xz abstractC24063xz, InterfaceC22912w18 interfaceC22912w18, C3933Cz c3933Cz, C7880To7 c7880To7, C7234Qv5 c7234Qv5) {
        C17557nA c17557nAN = this.z.n(c11458d25);
        C22993wA c22993wAK = C9057Yh4.k(c11458d25);
        C16966mA c16966mAM = this.z.m(c11458d25);
        if (c17557nAN == null || c22993wAK == null) {
            c7234Qv5.a(new Exception("outPeer or apiPeer is null!"));
        } else {
            this.u.put(Long.valueOf(j), Long.valueOf(Z(new C16570lV5(c17557nAN, j, abstractC24063xz, null, c3933Cz, c16966mAM, c7880To7 == null ? null : new C3460Az(c7880To7.h(), c7880To7.i(), 0L)), new C6438d(c7234Qv5, j, c11458d25, interfaceC22912w18, c7880To7, c3933Cz, abstractC24063xz))));
        }
    }

    private void B1(C19857r35 c19857r35) {
        J44 j44Z = c19857r35.z();
        if (j44Z != null) {
            this.z.G().T0().A(c19857r35.C(), j44Z.s(t0()));
        }
    }

    private C6517Nv5 B2(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0, C3933Cz c3933Cz, C7880To7 c7880To7) {
        AbstractC24063xz abstractC24063xzU1 = u1(abstractC17457n0);
        if (abstractC24063xzU1 == null) {
            return C6517Nv5.F(new Exception("Message is null!"));
        }
        return z2(c11458d25, j, abstractC24063xzU1, (c7880To7 == null || c3933Cz != null) ? c3933Cz : new C3933Cz(this.z.n(c11458d25), c7880To7.i(), Long.valueOf(c7880To7.h()), null, null), c7880To7);
    }

    private void C2(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0, C7880To7 c7880To7) {
        B2(c11458d25, j, abstractC17457n0, null, c7880To7);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void D1(ir.nasim.J44 r34, ir.nasim.C11458d25 r35) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6434No6.D1(ir.nasim.J44, ir.nasim.d25):void");
    }

    private void D2(long j, long j2, ExPeer exPeer, String str, String str2, String str3, C7880To7 c7880To7, EnumC4543Fo6 enumC4543Fo6) {
        this.v.put(Long.valueOf(j), AbstractC20507s76.x());
        this.z.D().X(j, j2, exPeer, str, str2, str3, r(), c7880To7, enumC4543Fo6, k2(j));
    }

    private void E2(long j, long j2, ExPeer exPeer, String str, String str2, String str3, Long l2, EnumC5360Iz7 enumC5360Iz7, C7880To7 c7880To7, EnumC4543Fo6 enumC4543Fo6) {
        F2(j, j2, exPeer, str, str2, str3, l2, Boolean.FALSE, enumC5360Iz7, c7880To7, enumC4543Fo6);
    }

    private void F2(long j, long j2, ExPeer exPeer, String str, String str2, String str3, Long l2, Boolean bool, EnumC5360Iz7 enumC5360Iz7, C7880To7 c7880To7, EnumC4543Fo6 enumC4543Fo6) {
        this.v.put(Long.valueOf(j), AbstractC20507s76.x());
        this.z.D().Y(j, j2, exPeer, str, str2, str3, r(), l2, enumC5360Iz7, bool.booleanValue(), c7880To7, enumC4543Fo6, k2(j));
    }

    private J44 K2(GS7 gs7, C11458d25 c11458d25, Long l2, C7880To7 c7880To7) {
        return f2(c11458d25, l2, 0L, AbstractC19981rG5.a(), t0(), this.z.n(c11458d25), gs7, null, c7880To7);
    }

    private boolean L2(C11458d25 c11458d25) {
        ExPeerType exPeerType;
        ExPeer exPeerW1 = w1(c11458d25);
        return exPeerW1 == null || (exPeerType = exPeerW1.getExPeerType()) == ExPeerType.PRIVATE || exPeerType == ExPeerType.GROUP;
    }

    private C6517Nv5 O1(C11458d25 c11458d25, int i, long j, EnumC19802qy enumC19802qy, String str, String str2) {
        return O(new C15388jV5(this.z.n(c11458d25), AbstractC19981rG5.a(), new C21001sy(i, j, enumC19802qy, null, str, this.z.i0(), null, Boolean.FALSE), str2), 16500L);
    }

    private ArrayList b2(C11458d25 c11458d25, String str) {
        C14697iL2 c14697iL2;
        C17637nI7 c17637nI7;
        ArrayList arrayList = new ArrayList();
        if (str.length() < 2 || c11458d25.s() != W25.b || (c14697iL2 = (C14697iL2) this.z.E().X1().d(c11458d25.getPeerId())) == null) {
            return arrayList;
        }
        String lowerCase = str.toLowerCase();
        Iterator it = c14697iL2.s0().iterator();
        while (it.hasNext()) {
            if (((C23104wM2) it.next()) != null && (c17637nI7 = (C17637nI7) this.z.W().p0().d(r2.f())) != null) {
                if (c17637nI7.d0() != null) {
                    String str2 = Separators.AT + c17637nI7.d0().toLowerCase();
                    if (!lowerCase.contains(str2 + ":")) {
                        if (!lowerCase.contains(str2 + Separators.SP)) {
                            if (lowerCase.contains(Separators.SP + str2) || lowerCase.endsWith(str2)) {
                            }
                        }
                    }
                    arrayList.add(Integer.valueOf(c17637nI7.n0()));
                } else if (C8386Vt0.S7()) {
                    if (Pattern.compile("\\[[^]]+]\\(uid:" + c17637nI7.n0() + "\\)").matcher(lowerCase).find()) {
                        arrayList.add(Integer.valueOf(c17637nI7.n0()));
                    }
                }
            }
        }
        if (c14697iL2.q0() == ZN2.GROUP && (lowerCase.contains("@all:") || lowerCase.contains("@all\n") || lowerCase.contains("@all ") || lowerCase.endsWith("@all"))) {
            arrayList.add(-1);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C3460Az c2(C19811qz c19811qz) {
        long jU = -1;
        long jU2 = -1;
        for (C20420rz c20420rz : c19811qz.u()) {
            if ("previous_message_rid".equals(c20420rz.getKey()) && (c20420rz.q() instanceof C5811Ky)) {
                jU2 = ((C5811Ky) c20420rz.q()).u();
            } else if ("previous_message_date".equals(c20420rz.getKey()) && (c20420rz.q() instanceof C5811Ky)) {
                jU = ((C5811Ky) c20420rz.q()).u();
            }
        }
        if (jU2 == -1 || jU == -1) {
            return null;
        }
        return new C3460Az(jU, jU2, 0L);
    }

    private DS7 d2(long j) {
        return (DS7) this.w.get(Long.valueOf(j));
    }

    private C6517Nv5 e2(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l2, Long l3, C16526lQ6 c16526lQ6, C7880To7 c7880To7) {
        long jA1 = a1(abstractC17457n0, c11458d25, l2, l3, c16526lQ6, c7880To7);
        B2(c11458d25, jA1, abstractC17457n0, (l2 == null || l2.longValue() == 0) ? c16526lQ6 != null ? new C3933Cz(this.z.n(c11458d25), 0L, null, null, new LC(c16526lQ6.a(), new C16966mA(EnumC9196Yx.PRIVATE, c16526lQ6.b(), 0L))) : null : new C3933Cz(this.z.n(c11458d25), l2.longValue(), l3, null, null), c7880To7);
        return C6517Nv5.l0(Long.valueOf(jA1));
    }

    private J44 f2(C11458d25 c11458d25, Long l2, Long l3, long j, long j2, C17557nA c17557nA, AbstractC17457n0 abstractC17457n0, C16526lQ6 c16526lQ6, C7880To7 c7880To7) {
        boolean z2;
        C17532n74 c17532n74;
        C17532n74 c17532n742;
        boolean z3;
        J44 j44;
        C3933Cz c3933Cz;
        C11458d25 c11458d252;
        C3933Cz c3933Cz2;
        J44 j442;
        int iU;
        AbstractC17457n0 abstractC17457n02;
        C19406qI3.a("FiSeCoFl", "getMessageAndAddPending(" + abstractC17457n0 + ") -> " + AbstractC24249yI3.a(Long.valueOf(j)), new Object[0]);
        C14733iO2 c14733iO2 = c11458d25.z() ? (C14733iO2) this.z.E().Y1().n(c11458d25.getPeerId()) : null;
        if (c14733iO2 == null || c14733iO2.n() == null || !((Boolean) c14733iO2.n().b()).booleanValue() || c14733iO2.o() == null || ((Integer) c14733iO2.o().b()).intValue() == 0) {
            z2 = false;
            c17532n74 = null;
        } else {
            c17532n74 = new C17532n74(c14733iO2.r(), ((Integer) c14733iO2.o().b()).intValue());
            z2 = true;
        }
        if (l2 == null || l2.longValue() == 0) {
            c17532n742 = c17532n74;
            boolean z4 = z2;
            if (c16526lQ6 != null) {
                z3 = z4;
                j44 = new J44(j, j2, j2, this.z.i0(), EnumC23558x74.PENDING, abstractC17457n0, new ArrayList(), 0, new C8445Vz5(0L, 0, c16526lQ6.b(), 0L, null, c11458d25, false, c16526lQ6.a()));
                c3933Cz = new C3933Cz(c17557nA, 0L, null, null, new LC(c16526lQ6.a(), new C16966mA(EnumC9196Yx.PRIVATE, c16526lQ6.b(), 0L)));
            } else {
                z3 = z4;
                j44 = new J44(j, j2, j2, this.z.i0(), EnumC23558x74.PENDING, abstractC17457n0);
                c3933Cz = null;
            }
        } else {
            J44 j443 = c7880To7 == null ? (J44) this.z.G().H0(c11458d25).a(l2.longValue()) : this.z.G().F0() != null ? (J44) this.z.G().F0().a(l2.longValue()) : null;
            if (j443 == null) {
                Long lC = this.x.c(c11458d25.u(), new XV4(l2, l3));
                if (lC != null) {
                    j443 = (J44) this.z.G().H0(c11458d25).a(lC.longValue());
                }
                if (j443 == null) {
                    return null;
                }
            }
            c17532n742 = c17532n74;
            J44 j444 = new J44(j, j2, j2, this.z.i0(), EnumC23558x74.PENDING, abstractC17457n0, new ArrayList(), 0, new C8445Vz5(j443.i(), 0, j443.U(), j443.h(), j443.F(), c11458d25, false, null));
            c3933Cz = new C3933Cz(c17557nA, l2.longValue(), l3, null, null);
            j44 = j444;
            z3 = z2;
        }
        j44.h0(z3);
        j44.m0(c17532n742);
        if (c7880To7 != null) {
            j44.n0(new C7880To7(c7880To7.i(), c7880To7.h(), c7880To7.q()));
        }
        if (c3933Cz != null || c7880To7 == null) {
            c11458d252 = c11458d25;
            c3933Cz2 = c3933Cz;
        } else {
            C3933Cz c3933Cz3 = new C3933Cz(this.z.n(c11458d25), c7880To7.i(), Long.valueOf(c7880To7.h()), null, null);
            if (this.z.G().F0() == null || (j442 = (J44) this.z.G().F0().a(c7880To7.i())) == null) {
                j442 = (J44) this.z.G().H0(c11458d25).a(c7880To7.i());
            }
            int iF = AbstractC5969Lp4.f();
            if (j442 != null) {
                AbstractC17457n0 abstractC17457n0F = j442.F();
                iU = j442.U();
                abstractC17457n02 = abstractC17457n0F;
            } else {
                iU = iF;
                abstractC17457n02 = null;
            }
            c11458d252 = c11458d25;
            j44 = j44.E(new C8445Vz5(c7880To7.i(), 0, iU, c7880To7.h(), abstractC17457n02, c11458d25, false, null));
            c3933Cz2 = c3933Cz3;
        }
        this.z.G().T0().A(c11458d252, j44).E(new InterfaceC24449ye1() { // from class: ir.nasim.Lo6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C19406qI3.d("SenderActor", (Exception) obj);
            }
        });
        this.o.r().add(new C19857r35(c11458d25, j, abstractC17457n0, c3933Cz2, c7880To7));
        W0();
        return j44;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g2(AbstractC24063xz abstractC24063xz) {
        if (abstractC24063xz == null) {
            return "other";
        }
        if (!(abstractC24063xz instanceof C6035Lx)) {
            return abstractC24063xz instanceof ZC ? ParameterNames.TEXT : "other";
        }
        AbstractC4383Ex abstractC4383ExW = ((C6035Lx) abstractC24063xz).w();
        return abstractC4383ExW instanceof C4617Fx ? MediaStreamTrack.AUDIO_TRACK_KIND : abstractC4383ExW instanceof C5100Hx ? "photo" : abstractC4383ExW instanceof C5802Kx ? "voice" : abstractC4383ExW instanceof C4866Gx ? "gif" : abstractC4383ExW instanceof C5568Jx ? MediaStreamTrack.VIDEO_TRACK_KIND : "other";
    }

    private EnumC4543Fo6 h2(AbstractC17457n0 abstractC17457n0) {
        return abstractC17457n0 instanceof GS7 ? EnumC4543Fo6.c : ((abstractC17457n0 instanceof C13388g85) || (abstractC17457n0 instanceof XG2)) ? EnumC4543Fo6.b : abstractC17457n0 instanceof TM ? EnumC4543Fo6.e : abstractC17457n0 instanceof J08 ? EnumC4543Fo6.d : abstractC17457n0 instanceof C24967zW1 ? EnumC4543Fo6.f : EnumC4543Fo6.a;
    }

    private String i2(String str) {
        return str != null ? str.trim() : str;
    }

    private long j2(C11458d25 c11458d25) {
        long jU = C11458d25.E(this.z.i0()).u();
        return (c11458d25.s() == W25.b && ((C14697iL2) this.z.E().X1().d((long) c11458d25.getPeerId())).q0() == ZN2.CHANNEL) ? c11458d25.u() : jU;
    }

    private InterfaceC10839cH7 k2(long j) {
        AbstractC17457n0 abstractC17457n0L0 = L0(j);
        if (abstractC17457n0L0 == null) {
            return InterfaceC10839cH7.a.a;
        }
        if (!(abstractC17457n0L0 instanceof C24967zW1)) {
            abstractC17457n0L0 = abstractC17457n0L0.f();
        }
        switch (C6439e.a[h2(abstractC17457n0L0).ordinal()]) {
            case 1:
            case 2:
            case 3:
                return InterfaceC10839cH7.b.a;
            case 4:
            case 5:
            case 6:
                return InterfaceC10839cH7.a.a;
            default:
                throw new IncompatibleClassChangeError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 l2(Exception exc) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 m2(C11458d25 c11458d25, C11458d25 c11458d252, List list, C14505i18 c14505i18) {
        C0(c11458d25, c11458d252, list);
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 o2(SP5 sp5) {
        A2(sp5.c(), sp5.e(), sp5.b(), AbstractC20507s76.x(), sp5.a(), sp5.f(), sp5.d());
        return C19938rB7.a;
    }

    private boolean p1(C11907dl c11907dl) {
        Iterator it = c11907dl.r().iterator();
        while (it.hasNext()) {
            if (!(((J44) it.next()).F().i() instanceof C11909dl1)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(C19857r35 c19857r35, J44 j44, C14505i18 c14505i18, Exception exc) {
        if (c19857r35.w() != null) {
            I2(j44.F(), c19857r35.C(), Long.valueOf(c19857r35.w().i()), c19857r35.w().q(), c19857r35.D());
        } else {
            X0(j44.F(), c19857r35.C(), c19857r35.D());
        }
    }

    private AbstractC17457n0 q1(AbstractC17457n0 abstractC17457n0, FileReference fileReference, ArrayList arrayList) {
        if (abstractC17457n0 instanceof C18626oy5) {
            C18626oy5 c18626oy5 = (C18626oy5) abstractC17457n0;
            C13388g85 c13388g85 = (C13388g85) c18626oy5.t();
            return C18626oy5.r(c18626oy5.v(), C13388g85.C(fileReference, arrayList, c13388g85.E(), c13388g85.D(), c13388g85.v()), c18626oy5.u(), c18626oy5.x());
        }
        if (abstractC17457n0 instanceof C13388g85) {
            C13388g85 c13388g852 = (C13388g85) abstractC17457n0;
            return C13388g85.C(fileReference, arrayList, c13388g852.E(), c13388g852.D(), c13388g852.v());
        }
        if (abstractC17457n0 instanceof GS7) {
            GS7 gs7 = (GS7) abstractC17457n0;
            return GS7.F(fileReference, arrayList, gs7.I(), gs7.H(), gs7.G(), gs7.v());
        }
        if (abstractC17457n0 instanceof XG2) {
            XG2 xg2 = (XG2) abstractC17457n0;
            return XG2.C(fileReference, arrayList, xg2.G(), xg2.F(), xg2.E(), xg2.v());
        }
        if (abstractC17457n0 instanceof J08) {
            J08 j08 = (J08) abstractC17457n0;
            return J08.F(fileReference, arrayList, j08.G(), j08.J().getVoiceTranscript(), j08.x());
        }
        if (abstractC17457n0 instanceof TM) {
            TM tm = (TM) abstractC17457n0;
            return TM.C(fileReference, arrayList, tm.E(), tm.D(), tm.K(), tm.I(), tm.v(), tm.F(), tm.G());
        }
        if (abstractC17457n0 instanceof C24967zW1) {
            C24967zW1 c24967zW1 = (C24967zW1) abstractC17457n0;
            return C24967zW1.s(fileReference, arrayList, c24967zW1.v(), c24967zW1.x());
        }
        if (!(abstractC17457n0 instanceof ir.nasim.core.modules.messaging.entity.content.a)) {
            return null;
        }
        ir.nasim.core.modules.messaging.entity.content.a aVar = (ir.nasim.core.modules.messaging.entity.content.a) abstractC17457n0;
        C13388g85 c13388g853 = (C13388g85) aVar.s();
        C13388g85 c13388g85C = C13388g85.C(fileReference, arrayList, c13388g853.E(), c13388g853.D(), c13388g853.v());
        return ir.nasim.core.modules.messaging.entity.content.a.g.b(aVar, fileReference, c13388g85C.v(), c13388g85C.E(), c13388g85C.D());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(C16966mA c16966mA, ArrayList arrayList, C3933Cz c3933Cz, long j, C11458d25 c11458d25, C22993wA c22993wA, InterfaceC22912w18 interfaceC22912w18, C7234Qv5 c7234Qv5) {
        this.u.put(Long.valueOf(j), Long.valueOf(Z(new C17161mV5(c16966mA, arrayList, c3933Cz, j), new C6437c(j, c11458d25, c22993wA, interfaceC22912w18, c7234Qv5))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(C11458d25 c11458d25, long j, AbstractC24063xz abstractC24063xz, C3933Cz c3933Cz, C7880To7 c7880To7, C7234Qv5 c7234Qv5) {
        this.y.c(c11458d25.getPeerId(), new SP5(c11458d25, j, abstractC24063xz, c3933Cz, c7880To7, c7234Qv5));
    }

    private void s1(C19857r35 c19857r35) {
        C11907dl c11907dl = (C11907dl) c19857r35.y();
        for (J44 j44 : c11907dl.r()) {
            AbstractC17457n0 abstractC17457n0F = j44.F();
            if (abstractC17457n0F instanceof C24967zW1) {
                C24967zW1 c24967zW1 = (C24967zW1) abstractC17457n0F;
                if (c24967zW1.z() instanceof C4512Fl2) {
                    C11458d25 c11458d25C = c19857r35.C();
                    long jJ2 = j2(c11458d25C);
                    ExPeer exPeerW1 = w1(c11458d25C);
                    this.p.put(Long.valueOf(j44.i()), Long.valueOf(c19857r35.i()));
                    D2(j44.i(), jJ2, exPeerW1, ((C4512Fl2) c24967zW1.z()).c, c24967zW1.z().a(), ((C4512Fl2) c24967zW1.z()).d, c19857r35.D(), h2(c19857r35.y()));
                }
            }
        }
        if (p1(c11907dl)) {
            t2(c19857r35.i(), c19857r35, c11907dl);
        }
    }

    private void s2(long j, long j2, FileReference fileReference, Long l2) {
        if (this.v.containsKey(Long.valueOf(j2))) {
            ((InterfaceC22912w18) this.v.remove(Long.valueOf(j2))).a();
        }
        C19857r35 c19857r35X0 = x0(j);
        if (c19857r35X0 == null) {
            return;
        }
        this.o.r().remove(c19857r35X0);
        ArrayList arrayList = new ArrayList();
        if (fileReference.getCaption() != null) {
            arrayList = b2(c19857r35X0.C(), fileReference.getCaption());
        }
        C11907dl c11907dl = (C11907dl) c19857r35X0.y();
        List listR = c11907dl.r();
        int i = 0;
        while (true) {
            if (i >= listR.size()) {
                break;
            }
            J44 j44 = (J44) listR.get(i);
            if (j44.i() == j2) {
                c11907dl.r().set(i, j44.u(q1(j44.F(), fileReference, arrayList), true));
                break;
            }
            i++;
        }
        this.o.r().add(c19857r35X0.q(c11907dl));
        this.z.G().T0().v(c19857r35X0.C(), j, c11907dl);
        W0();
        if (p1(c11907dl)) {
            t2(j, c19857r35X0, c11907dl);
        }
    }

    private void t1(Uri uri, String str, String str2, J44 j44, C11458d25 c11458d25, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "compressVideoAndSend() " + AbstractC24249yI3.a(Long.valueOf(j44.i())), new Object[0]);
        long jS = j44.Q() != null ? j44.Q().s() : 0L;
        if (C8386Vt0.F5()) {
            this.z.D().Y(j44.i(), c11458d25.u(), w1(c11458d25), uri.getPath(), ((GS7) j44.F()).y(), str, r(), Long.valueOf(jS), EnumC5360Iz7.i, true, c7880To7, h2(j44.F()), InterfaceC10839cH7.a.a);
            return;
        }
        DS7 ds7 = new DS7(c11458d25, jS, str, str2, j44.i(), j44.h(), c7880To7, new C6436b(j44, c11458d25), new C6435a(j44, c11458d25));
        this.w.put(Long.valueOf(j44.i()), ds7);
        ds7.h(uri.getPath());
    }

    private void t2(long j, final C19857r35 c19857r35, C11907dl c11907dl) {
        Iterator it = c11907dl.r().iterator();
        while (it.hasNext()) {
            this.p.remove(Long.valueOf(((J44) it.next()).i()));
        }
        C11458d25 c11458d25C = c19857r35.C();
        if (c11458d25C != null && L2(c11458d25C)) {
            this.z.U().F(c11458d25C, EnumC5360Iz7.h);
        }
        if (c11907dl.r().size() > 1) {
            V0(c19857r35.C(), c11907dl, c19857r35.w(), j);
        } else {
            this.o.r().remove(c19857r35);
            final J44 j44 = (J44) c11907dl.r().get(0);
            this.z.G().T0().k(c19857r35.C(), j44.i(), j44.h()).z(new InterfaceC3273Ae1() { // from class: ir.nasim.Ho6
                @Override // ir.nasim.InterfaceC3273Ae1
                public final void apply(Object obj, Object obj2) {
                    this.a.p2(c19857r35, j44, (C14505i18) obj, (Exception) obj2);
                }
            });
            W0();
        }
    }

    public static AbstractC24063xz u1(AbstractC17457n0 abstractC17457n0) {
        return v1(abstractC17457n0, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void u2(java.util.List r8) {
        /*
            r7 = this;
            java.util.Iterator r8 = r8.iterator()
        L4:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L10c
            java.lang.Object r0 = r8.next()
            java.lang.Long r0 = (java.lang.Long) r0
            java.util.HashMap r1 = r7.p
            java.lang.Object r1 = r1.remove(r0)
            java.lang.Long r1 = (java.lang.Long) r1
            if (r1 == 0) goto L5c
            long r2 = r1.longValue()
            ir.nasim.r35 r2 = r7.x0(r2)
            if (r2 == 0) goto L5c
            ir.nasim.s35 r3 = r7.o
            java.util.ArrayList r3 = r3.r()
            r3.remove(r2)
            ir.nasim.ol r3 = ir.nasim.C18492ol.a
            ir.nasim.n0 r4 = r2.y()
            ir.nasim.dl r4 = (ir.nasim.C11907dl) r4
            long r5 = r0.longValue()
            ir.nasim.dl r3 = r3.i(r4, r5)
            if (r3 == 0) goto L59
            ir.nasim.r35 r2 = r2.q(r3)
            ir.nasim.s35 r4 = r7.o
            java.util.ArrayList r4 = r4.r()
            r4.add(r2)
            boolean r4 = r7.p1(r3)
            if (r4 == 0) goto L59
            long r4 = r1.longValue()
            r7.t2(r4, r2, r3)
        L59:
            r7.W0()
        L5c:
            long r1 = r0.longValue()
            ir.nasim.r35 r1 = r7.x0(r1)
            if (r1 == 0) goto L83
            ir.nasim.v35 r2 = r7.y
            ir.nasim.d25 r3 = r1.C()
            int r3 = r3.getPeerId()
            long r4 = r0.longValue()
            r2.e(r3, r4)
            ir.nasim.s35 r2 = r7.o
            java.util.ArrayList r2 = r2.r()
            r2.remove(r1)
            r7.W0()
        L83:
            if (r1 == 0) goto Ld4
            ir.nasim.n0 r1 = r1.y()
            boolean r2 = r1 instanceof ir.nasim.C11907dl
            if (r2 == 0) goto Ld4
            ir.nasim.dl r1 = (ir.nasim.C11907dl) r1
            java.util.List r1 = r1.r()
            java.util.Iterator r1 = r1.iterator()
        L97:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lf4
            java.lang.Object r2 = r1.next()
            ir.nasim.J44 r2 = (ir.nasim.J44) r2
            java.util.HashMap r3 = r7.v
            long r4 = r2.i()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto Lc6
            java.util.HashMap r3 = r7.v
            long r4 = r2.i()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Object r3 = r3.get(r4)
            ir.nasim.w18 r3 = (ir.nasim.InterfaceC22912w18) r3
            r3.a()
        Lc6:
            ir.nasim.Yh4 r3 = r7.z
            ir.nasim.in2 r3 = r3.D()
            long r4 = r2.i()
            r3.S(r4)
            goto L97
        Ld4:
            java.util.HashMap r1 = r7.v
            boolean r1 = r1.containsKey(r0)
            if (r1 == 0) goto Le7
            java.util.HashMap r1 = r7.v
            java.lang.Object r1 = r1.get(r0)
            ir.nasim.w18 r1 = (ir.nasim.InterfaceC22912w18) r1
            r1.a()
        Le7:
            ir.nasim.Yh4 r1 = r7.z
            ir.nasim.in2 r1 = r1.D()
            long r2 = r0.longValue()
            r1.S(r2)
        Lf4:
            java.util.HashMap r1 = r7.u
            java.lang.Object r1 = r1.get(r0)
            java.lang.Long r1 = (java.lang.Long) r1
            if (r1 == 0) goto L4
            long r1 = r1.longValue()
            r7.Q(r1)
            java.util.HashMap r1 = r7.u
            r1.remove(r0)
            goto L4
        L10c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6434No6.u2(java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x030a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.AbstractC24063xz v1(ir.nasim.AbstractC17457n0 r29, java.lang.Long r30) {
        /*
            Method dump skipped, instructions count: 964
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6434No6.v1(ir.nasim.n0, java.lang.Long):ir.nasim.xz");
    }

    private void v2(C11458d25 c11458d25, long j) {
        Iterator it = this.o.r().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C19857r35 c19857r35 = (C19857r35) it.next();
            if (c19857r35.i() == j && c19857r35.C().equals(c11458d25)) {
                this.o.r().remove(c19857r35);
                break;
            }
        }
        W0();
        this.z.G().T0().z(c11458d25, j);
    }

    private ExPeer w1(C11458d25 c11458d25) {
        ExPeerType exPeerTypeA = X25.a(c11458d25);
        if (exPeerTypeA == null) {
            return null;
        }
        return new ExPeer(exPeerTypeA, c11458d25.getPeerId());
    }

    private void w2(long j) {
        Long l2 = (Long) this.p.get(Long.valueOf(j));
        C19857r35 c19857r35X0 = x0(l2 != null ? l2.longValue() : j);
        if (c19857r35X0 == null) {
            return;
        }
        if (c19857r35X0.y() instanceof C11907dl) {
            this.z.U().F(c19857r35X0.C(), EnumC5360Iz7.h);
            List listR = ((C11907dl) c19857r35X0.y()).r();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < listR.size(); i++) {
                J44 j44 = (J44) listR.get(i);
                if (this.v.containsKey(Long.valueOf(j44.i()))) {
                    ((InterfaceC22912w18) this.v.remove(Long.valueOf(j44.i()))).a();
                }
                this.z.D().S(j44.i());
                this.p.remove(Long.valueOf(j44.i()));
                arrayList.add(j44.y(EnumC23558x74.ERROR));
                r0(j44.i());
            }
            this.z.G().T0().v(c19857r35X0.C(), c19857r35X0.i(), new C11907dl(arrayList));
        } else if (this.v.containsKey(Long.valueOf(j))) {
            ((InterfaceC22912w18) this.v.remove(Long.valueOf(j))).a();
        }
        this.z.G().T0().z(c19857r35X0.C(), c19857r35X0.i());
        this.o.r().remove(c19857r35X0);
        W0();
    }

    private C11907dl x1(Long l2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C24967zW1 c24967zW1 = (C24967zW1) it.next();
            long jA = AbstractC19981rG5.a();
            long jT0 = t0();
            arrayList.add(new J44(jA, jT0, jT0, this.z.i0(), EnumC23558x74.PENDING, c24967zW1, new ArrayList(), 0, null, null, 0L, null, null, false, l2));
        }
        return new C11907dl(arrayList);
    }

    private void x2(long j, FileReference fileReference, Long l2, C7880To7 c7880To7) {
        if (this.v.containsKey(Long.valueOf(j))) {
            ((InterfaceC22912w18) this.v.remove(Long.valueOf(j))).a();
        }
        C19857r35 c19857r35X0 = x0(j);
        if (c19857r35X0 == null) {
            return;
        }
        this.o.r().remove(c19857r35X0);
        ArrayList arrayList = new ArrayList();
        if (fileReference.getCaption() != null) {
            arrayList = b2(c19857r35X0.C(), fileReference.getCaption());
        }
        AbstractC17457n0 abstractC17457n0Q1 = q1(c19857r35X0.y(), fileReference, arrayList);
        if (abstractC17457n0Q1 == null) {
            return;
        }
        this.o.r().add(c19857r35X0.q(abstractC17457n0Q1));
        this.z.G().T0().v(c19857r35X0.C(), c19857r35X0.i(), abstractC17457n0Q1);
        W0();
        if (l2 == null || l2.longValue() == 0) {
            C2(c19857r35X0.C(), j, abstractC17457n0Q1, c7880To7);
        } else {
            B2(c19857r35X0.C(), j, abstractC17457n0Q1, new C3933Cz(this.z.n(c19857r35X0.C()), l2.longValue(), null, null, null), c7880To7);
        }
    }

    private void y1() {
        ArrayList arrayList = new ArrayList(this.o.r().size());
        Iterator it = this.o.r().iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((C19857r35) it.next()).i()));
        }
        u2(arrayList);
    }

    private void y2(C11458d25 c11458d25, long j) {
        Iterator it = this.o.r().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C19857r35 c19857r35 = (C19857r35) it.next();
            if (c19857r35.i() == j && c19857r35.C().equals(c11458d25)) {
                this.o.r().remove(c19857r35);
                break;
            }
        }
        W0();
    }

    private void z1(C11458d25 c11458d25) {
        u2(K0(c11458d25));
    }

    private C6517Nv5 z2(final C11458d25 c11458d25, final long j, final AbstractC24063xz abstractC24063xz, final C3933Cz c3933Cz, final C7880To7 c7880To7) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Io6
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.r2(c11458d25, j, abstractC24063xz, c3933Cz, c7880To7, c7234Qv5);
            }
        });
    }

    public void C1(Long l2, C11458d25 c11458d25, List list, Long l3, Long l4) {
        C19406qI3.a("FiSeCoFl", "doSendAlbum()", new Object[0]);
        if (L2(c11458d25)) {
            this.z.U().D(c11458d25, EnumC5360Iz7.h);
        }
        C11907dl c11907dlX1 = x1(l2, list);
        Z0(c11907dlX1, c11458d25, l3, l4, null, l2.longValue(), null);
        long jJ2 = j2(c11458d25);
        int i = 0;
        for (List listR = c11907dlX1.r(); i < listR.size(); listR = listR) {
            J44 j44 = (J44) listR.get(i);
            this.p.put(Long.valueOf(j44.i()), l2);
            OG3 og3 = (OG3) ((C8540Wk1) j44.F().i()).c();
            E2(j44.i(), jJ2, w1(c11458d25), og3.u(), og3.getFileName(), og3.getCaption(), l3, EnumC5360Iz7.b, null, h2(j44.F()));
            i++;
        }
    }

    public void E1(C11458d25 c11458d25, C14419ht c14419ht, Long l2, Long l3) {
        H2(C16799lt.r(c14419ht), c11458d25, l2, l3);
    }

    public void F1(C11458d25 c11458d25, String str, String str2, String str3, int i, Long l2, Long l3, C7880To7 c7880To7) throws IllegalArgumentException {
        C19406qI3.a("FiSeCoFl", "doSendAudio()", new Object[0]);
        String strI2 = i2(str3);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int i2 = (int) Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(2);
        if (strExtractMetadata == null) {
            strExtractMetadata = "";
        }
        if (strExtractMetadata.length() > 256) {
            strExtractMetadata = strExtractMetadata.substring(0, 256);
        }
        String str4 = strExtractMetadata;
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(1);
        if (strExtractMetadata2 == null) {
            strExtractMetadata2 = "";
        }
        if (strExtractMetadata2.length() > 256) {
            strExtractMetadata2 = strExtractMetadata2.substring(0, 256);
        }
        String str5 = strExtractMetadata2;
        String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(6);
        if (strExtractMetadata3 == null) {
            strExtractMetadata3 = "";
        }
        if (strExtractMetadata3.length() > 256) {
            strExtractMetadata3 = strExtractMetadata3.substring(0, 256);
        }
        String str6 = strExtractMetadata3;
        String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(7);
        String str7 = strExtractMetadata4 != null ? strExtractMetadata4 : "";
        M2(TM.B(str, str2, strI2, i, str4, str5, str7.length() > 256 ? str7.substring(0, 256) : str7, str6, null, null, i2), c11458d25, l2, l3, str2, str, strI2, EnumC5360Iz7.j, c7880To7);
    }

    @Override // ir.nasim.S1, ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (obj instanceof z) {
            z zVar = (z) obj;
            return Q1(zVar.g(), zVar.c(), zVar.b(), zVar.d(), zVar.a(), zVar.e(), zVar.k(), zVar.f(), zVar.i(), zVar.h(), zVar.j());
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return K1(tVar.g(), tVar.d(), tVar.f(), tVar.e(), tVar.c(), tVar.b(), tVar.a(), tVar.i(), tVar.h(), tVar.j());
        }
        if (!(obj instanceof x)) {
            return super.G(obj);
        }
        x xVar = (x) obj;
        return O1(xVar.c(), xVar.a(), xVar.f(), xVar.b(), xVar.d(), xVar.e());
    }

    public void G1(C11458d25 c11458d25, long j, String str, String str2, String str3, Long l2, int i, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "doSendCompressedVideo()", new Object[0]);
        O2(c11458d25, j, l2, str, str2, i2(str3), i, c7880To7);
    }

    public C6517Nv5 G2(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l2, C16526lQ6 c16526lQ6, C7880To7 c7880To7) {
        return e2(abstractC17457n0, c11458d25, l2, 0L, c16526lQ6, c7880To7);
    }

    public void H1(C11458d25 c11458d25, ArrayList arrayList, ArrayList arrayList2, String str, String str2, Long l2, Long l3, C7880To7 c7880To7) {
        I2(C6833Pe1.r(str, arrayList2, arrayList, str2), c11458d25, l2, l3, c7880To7);
    }

    public C6517Nv5 H2(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l2, Long l3) {
        return e2(abstractC17457n0, c11458d25, l2, l3, null, null);
    }

    public void I1(s sVar) {
        C13388g85 c13388g85B = C13388g85.B(sVar.b(), sVar.d(), i2(sVar.a()), sVar.e(), sVar.k(), sVar.f(), sVar.c());
        try {
            N2(ir.nasim.core.modules.messaging.entity.content.a.g.a(CrowdfundingContentInfo.INSTANCE.a(sVar.l, sVar.m, sVar.n, sVar.o, sVar.p, sVar.q, AbstractC17457n0.o(c13388g85B)), c13388g85B), sVar.g(), null, sVar.d(), sVar.b(), sVar.l, null);
        } catch (IOException e) {
            C19406qI3.c("Sender", "doSendCrowdfunding", e);
        }
    }

    public C6517Nv5 I2(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l2, Long l3, C7880To7 c7880To7) {
        return e2(abstractC17457n0, c11458d25, l2, l3, null, c7880To7);
    }

    public C6517Nv5 J1(C11458d25 c11458d25, Long l2, Long l3, C24967zW1 c24967zW1, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "doSendDocument()", new Object[0]);
        if (c24967zW1 instanceof GS7) {
            GS7 gs7 = (GS7) c24967zW1;
            if (gs7.J()) {
                J44 j44K2 = K2(gs7, c11458d25, l2, c7880To7);
                C19406qI3.a("FiSeCoFl", "doSendDocument() -> compress", new Object[0]);
                r().d(new C6441g(c11458d25, j44K2, c7880To7));
                return C6517Nv5.l0(Long.valueOf(j44K2.i()));
            }
        }
        OG3 og3 = (OG3) ((C8540Wk1) c24967zW1.i()).c();
        return M2(c24967zW1, c11458d25, l2, l3, og3.getFileName(), og3.u(), og3.getCaption(), EnumC5360Iz7.j(c24967zW1), c7880To7);
    }

    public C6517Nv5 J2(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l2) {
        return B2(c11458d25, a1(abstractC17457n0, c11458d25, l2, 0L, null, null), abstractC17457n0, (l2 == null || l2.longValue() == 0) ? null : new C3933Cz(this.z.n(c11458d25), l2.longValue(), null, null, null), null);
    }

    public C6517Nv5 K1(C11458d25 c11458d25, String str, String str2, int i, C22694vg2 c22694vg2, String str3, String str4, Long l2, Long l3, C7880To7 c7880To7) {
        return J1(c11458d25, l2, l3, C24967zW1.r(str, i, str3, i2(str4), str2, c22694vg2), c7880To7);
    }

    public C6517Nv5 L1(C11458d25 c11458d25, String str) {
        return J2(C23345wl7.r(str.trim()), c11458d25, 0L);
    }

    public void M1(C11458d25 c11458d25, String str, int i, int i2, int i3, C22694vg2 c22694vg2, String str2, String str3, int i4, Long l2, Long l3, String str4, C7880To7 c7880To7) {
        String strI2 = i2(str3);
        M2(XG2.B(str2, str, strI2, i4, i, i2, i3, c22694vg2, str4), c11458d25, l2, l3, str, str2, strI2, EnumC5360Iz7.b, c7880To7);
    }

    public C6517Nv5 M2(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l2, Long l3, String str, String str2, String str3, EnumC5360Iz7 enumC5360Iz7, C7880To7 c7880To7) {
        long jA1 = a1(abstractC17457n0, c11458d25, l2, l3, null, c7880To7);
        long jJ2 = j2(c11458d25);
        ExPeer exPeerW1 = w1(c11458d25);
        C19406qI3.a("FiSeCoFl", "uploadAndSend(" + AbstractC24249yI3.a(Long.valueOf(jA1)) + ") called with: content = [" + abstractC17457n0 + "], fileName = [" + str + "], descriptor = [" + str2 + "]", new Object[0]);
        E2(jA1, jJ2, exPeerW1, str2, str, str3, l2, enumC5360Iz7, c7880To7, h2(abstractC17457n0));
        return C6517Nv5.l0(Long.valueOf(jA1));
    }

    public void N1(C11458d25 c11458d25, QG2 qg2, ArrayList arrayList, Long l2, Long l3, C7880To7 c7880To7) {
        I2(XG2.D(qg2.c(), arrayList, qg2.g(), qg2.d(), qg2.b(), qg2.f() != null ? new C22694vg2(90, 90, qg2.f()) : null, qg2.e()), c11458d25, l2, l3, c7880To7);
    }

    public C6517Nv5 N2(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l2, String str, String str2, String str3, C7880To7 c7880To7) {
        long jA1 = a1(abstractC17457n0, c11458d25, l2, 0L, null, c7880To7);
        E2(jA1, j2(c11458d25), w1(c11458d25), str2, str, str3, l2, EnumC5360Iz7.b, c7880To7, h2(abstractC17457n0));
        return C6517Nv5.l0(Long.valueOf(jA1));
    }

    public C6517Nv5 O2(C11458d25 c11458d25, long j, Long l2, String str, String str2, String str3, int i, C7880To7 c7880To7) {
        long jJ2 = j2(c11458d25);
        J44 j44 = (J44) this.z.G().H0(c11458d25).a(j);
        GS7 gs7C = GS7.C((GS7) j44.F(), str2, i);
        this.z.G().H0(c11458d25).d(j44.w(gs7C));
        E2(j, jJ2, w1(c11458d25), str2, str, str3, l2, EnumC5360Iz7.i, c7880To7, h2(gs7C));
        return C6517Nv5.l0(Long.valueOf(j));
    }

    public void P1(C11458d25 c11458d25, Double d, Double d2, String str, String str2, Long l2, Long l3, C7880To7 c7880To7) {
        I2(C10844cI3.r(d.doubleValue(), d2.doubleValue(), str, str2), c11458d25, l2, l3, c7880To7);
    }

    public C6517Nv5 Q1(C11458d25 c11458d25, C22694vg2 c22694vg2, String str, String str2, String str3, int i, int i2, int i3, Long l2, Long l3, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "doSendPhoto()", new Object[0]);
        String strI2 = i2(str3);
        return M2(C13388g85.B(str, str2, strI2, i, i2, i3, c22694vg2), c11458d25, l2, l3, str2, str, strI2, EnumC5360Iz7.g, c7880To7);
    }

    public void R1(C11458d25 c11458d25, Long l2, String str, List list, Boolean bool, EnumC9567aB enumC9567aB, Long l3, Long l4) {
        H2(C19049ph5.s(bool.booleanValue(), l2.longValue(), str, list, enumC9567aB, null), c11458d25, l3, l4);
    }

    public void S1(C11458d25 c11458d25, AbstractC4970Hi4 abstractC4970Hi4, C22694vg2 c22694vg2, String str, String str2, String str3, int i, int i2, int i3, AbstractC13130fi4 abstractC13130fi4, String str4) {
        String strI2 = i2(str3);
        N2(C18626oy5.r(abstractC4970Hi4, C13388g85.B(str, str2, strI2, i, i2, i3, c22694vg2), abstractC13130fi4, str4), c11458d25, null, str2, str, strI2, null);
    }

    public C6517Nv5 T1(C11458d25 c11458d25, String str, int i, long j, long j2, C22694vg2 c22694vg2, int i2, int i3, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "doSendRemotePhoto()", new Object[0]);
        String strI2 = i2(str);
        return X0(C13388g85.C(new FileReference(new C12056dy(j, j2, 1), j + "", strI2, i), new ArrayList(), i2, i3, c22694vg2), c11458d25, c7880To7);
    }

    public void U1(C11458d25 c11458d25, C23698xM6 c23698xM6, Long l2, Long l3, C7880To7 c7880To7) {
        I2(JM6.r(c23698xM6), c11458d25, l2, l3, c7880To7);
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        ArrayList arrayListR = this.o.r();
        boolean z2 = false;
        for (C19857r35 c19857r35 : (C19857r35[]) arrayListR.toArray(new C19857r35[arrayListR.size()])) {
            if ((c19857r35.y() instanceof C23345wl7) || (c19857r35.y() instanceof C22739vk7) || (c19857r35.y() instanceof C18121o72)) {
                B1(c19857r35);
                B2(c19857r35.C(), c19857r35.i(), c19857r35.y(), c19857r35.w(), c19857r35.D());
            } else if (c19857r35.y() instanceof GS7) {
                J44 j44 = (J44) this.z.G().H0(c19857r35.C()).a(c19857r35.i());
                if (j44 != null) {
                    if (j44.L() == EnumC23558x74.LIMIT_EXCEEDED) {
                        C19857r35 c19857r35X0 = x0(j44.i());
                        if (c19857r35X0 != null) {
                            this.o.r().remove(c19857r35X0);
                            z2 = true;
                        }
                    } else if (((GS7) c19857r35.y()).J()) {
                        r().d(new C6441g(c19857r35.C(), j44, c19857r35.D()));
                    } else {
                        C21874uH3 c21874uH3 = (C21874uH3) ((C8540Wk1) j44.F().i()).c();
                        r().d(new q(c19857r35.C(), j44.i(), c21874uH3.getFileName(), c21874uH3.u(), c21874uH3.getCaption(), Long.valueOf(c19857r35.w() == null ? 0L : c19857r35.w().i()), c21874uH3.getFileSize(), c19857r35.D()));
                    }
                }
            } else if (c19857r35.y() instanceof C24967zW1) {
                C24967zW1 c24967zW1 = (C24967zW1) c19857r35.y();
                if (c24967zW1.z() instanceof C4512Fl2) {
                    C11458d25 c11458d25C = c19857r35.C();
                    D2(c19857r35.i(), j2(c11458d25C), w1(c11458d25C), ((C4512Fl2) c24967zW1.z()).c, c24967zW1.z().a(), ((C4512Fl2) c24967zW1.z()).d, c19857r35.D(), h2(c19857r35.y()));
                } else {
                    B1(c19857r35);
                    B2(c19857r35.C(), c19857r35.i(), c19857r35.y(), c19857r35.w(), c19857r35.D());
                }
            } else if (c19857r35.y() instanceof C11907dl) {
                s1(c19857r35);
            }
        }
        if (z2) {
            W0();
        }
        r().d(new K());
    }

    @Override // ir.nasim.S1
    public C6517Nv5 V0(final C11458d25 c11458d25, AbstractC17457n0 abstractC17457n0, final C3933Cz c3933Cz, final long j) {
        final InterfaceC22912w18 interfaceC22912w18X = AbstractC20507s76.x();
        final ArrayList arrayList = new ArrayList();
        for (J44 j44 : ((C11907dl) abstractC17457n0).r()) {
            arrayList.add(new CC(j44.i(), (C6035Lx) v1((C24967zW1) j44.F(), Long.valueOf(j))));
        }
        final C16966mA c16966mAM = this.z.m(c11458d25);
        final C22993wA c22993wAK = C9057Yh4.k(c11458d25);
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Mo6
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.q2(c16966mAM, arrayList, c3933Cz, j, c11458d25, c22993wAK, interfaceC22912w18X, c7234Qv5);
            }
        });
    }

    public void V1(C11458d25 c11458d25, String str, C16526lQ6 c16526lQ6) {
        G2(C23345wl7.r(i2(str)), c11458d25, null, c16526lQ6, null);
    }

    @Override // ir.nasim.S1
    protected void W0() {
        W().j("sender_pending_v2", this.o.toByteArray());
    }

    public void W1(C11458d25 c11458d25, String str, Long l2) {
        X0(C22739vk7.r(str.trim(), l2), c11458d25, null);
    }

    @Override // ir.nasim.S1
    public C6517Nv5 X0(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, C7880To7 c7880To7) {
        return e2(abstractC17457n0, c11458d25, null, null, null, c7880To7);
    }

    public void X1(C11458d25 c11458d25, String str, ArrayList arrayList, boolean z2, Long l2, Long l3, C7880To7 c7880To7) {
        String strTrim = str.trim();
        if (z2) {
            arrayList = b2(c11458d25, strTrim);
        }
        I2(C23345wl7.s(strTrim, arrayList), c11458d25, l2, l3, c7880To7);
    }

    public void Y1(C11458d25 c11458d25, String str, ArrayList arrayList, boolean z2, Long l2, Long l3, C7880To7 c7880To7) {
        List listU = XY6.u(str, this.z.S().j3());
        for (int i = 0; i < listU.size(); i++) {
            q(new G(c11458d25, (String) listU.get(i), arrayList, z2, l2, l3, c7880To7), i * SIPTransactionStack.BASE_TIMER_INTERVAL);
        }
    }

    @Override // ir.nasim.S1
    protected long Z0(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l2, Long l3, C16526lQ6 c16526lQ6, long j, C7880To7 c7880To7) {
        f2(c11458d25, l2, l3, j, t0(), this.z.n(c11458d25), abstractC17457n0, c16526lQ6, c7880To7);
        return j;
    }

    public void Z1(C11458d25 c11458d25, String str, int i, int i2, int i3, C22694vg2 c22694vg2, String str2, String str3, int i4, Long l2, Long l3, boolean z2, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "doSendVideo()", new Object[0]);
        String strI2 = i2(str3);
        if (!z2) {
            M2(GS7.D(str2, str, strI2, i4, i, i2, i3, c22694vg2), c11458d25, l2, l3, str, str2, strI2, EnumC5360Iz7.i, c7880To7);
        } else {
            r().d(new C6441g(c11458d25, K2(GS7.E(str2, str, strI2, i4, i, i2, i3, c22694vg2, true), c11458d25, l2, c7880To7), c7880To7));
        }
    }

    public void a2(C11458d25 c11458d25, String str, String str2, int i, Long l2, Long l3, String str3, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "doSendVoice()", new Object[0]);
        M2(J08.E(str, str2, str3, KN6.r(str).f(), i), c11458d25, l2, l3, str2, str, str3, EnumC5360Iz7.e, c7880To7);
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof G) {
            G g = (G) obj;
            X1(g.c(), g.f(), g.b(), g.g(), g.e(), g.d(), g.g);
            return;
        }
        if (obj instanceof H) {
            H h = (H) obj;
            Y1(h.b(), h.e(), h.a(), h.g(), h.d(), h.c(), h.f());
            return;
        }
        if (obj instanceof F) {
            F f = (F) obj;
            W1(f.b(), f.b, Long.valueOf(f.c()));
            return;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            y2(lVar.a(), lVar.b());
            return;
        }
        if (obj instanceof C6445k) {
            C6445k c6445k = (C6445k) obj;
            v2(c6445k.a(), c6445k.b());
            return;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            K1(tVar.g(), tVar.d(), tVar.f(), tVar.e(), tVar.c(), tVar.b(), tVar.a(), tVar.i(), tVar.h(), tVar.j());
            return;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            J1(uVar.b(), Long.valueOf(uVar.d()), Long.valueOf(uVar.c()), uVar.a(), uVar.e());
            return;
        }
        if (obj instanceof VG7) {
            VG7 vg7 = (VG7) obj;
            Long l2 = (Long) this.p.get(Long.valueOf(vg7.c()));
            if (l2 != null) {
                s2(l2.longValue(), vg7.c(), vg7.a(), vg7.b());
                return;
            } else {
                x2(vg7.c(), vg7.a(), vg7.b(), vg7.d());
                return;
            }
        }
        if (obj instanceof C9629aH7) {
            w2(((C9629aH7) obj).a());
            return;
        }
        if (obj instanceof B) {
            B b = (B) obj;
            S1(b.g(), b.n(), b.c(), b.b(), b.d(), b.a(), b.e(), b.k(), b.f(), b.m(), b.n);
            return;
        }
        if (obj instanceof s) {
            I1((s) obj);
            return;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            Q1(zVar.g(), zVar.c(), zVar.b(), zVar.d(), zVar.a(), zVar.e(), zVar.k(), zVar.f(), zVar.i(), zVar.h(), zVar.j());
            return;
        }
        if (obj instanceof C) {
            C c = (C) obj;
            T1(c.g(), c.b(), c.e(), c.d().longValue(), c.a().longValue(), c.c(), c.f(), c.i(), c.h());
            return;
        }
        if (obj instanceof I) {
            I i = (I) obj;
            Z1(i.h(), i.e(), i.l(), i.g(), i.c(), i.d(), i.b(), i.a(), i.f(), i.j(), i.i(), i.m(), i.k());
            return;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            G1(qVar.e(), qVar.g(), qVar.d(), qVar.c(), qVar.b(), qVar.f(), qVar.h(), qVar.h);
            return;
        }
        if (obj instanceof C6440f) {
            r1(((C6440f) obj).a());
            return;
        }
        if (obj instanceof C6441g) {
            C6441g c6441g = (C6441g) obj;
            if (c6441g.b != null) {
                GS7 gs7 = (GS7) c6441g.b.F();
                t1(Uri.parse(((C21874uH3) ((C8540Wk1) gs7.i()).c()).u()), gs7.t().v(), gs7.x(), c6441g.b, c6441g.a, c6441g.c());
                return;
            }
            return;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            M1(vVar.i(), vVar.e(), vVar.m(), vVar.g(), vVar.c(), vVar.d(), vVar.b(), vVar.a(), vVar.f(), vVar.k(), vVar.j(), vVar.h(), vVar.l());
            return;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            N1(wVar.a, wVar.b, wVar.c, wVar.d, wVar.e, wVar.f());
            return;
        }
        if (obj instanceof J) {
            J j = (J) obj;
            a2(j.e(), j.b(), j.d(), j.c(), j.g(), j.f(), j.a() == null ? "" : j.a(), j.h());
            return;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            F1(pVar.e(), pVar.b(), pVar.c(), pVar.a(), pVar.d(), pVar.g(), pVar.f(), pVar.h());
            return;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            H1(rVar.d(), rVar.b(), rVar.e(), rVar.c(), rVar.a(), rVar.g(), rVar.f(), rVar.h());
            return;
        }
        if (obj instanceof A) {
            A a = (A) obj;
            R1(a.h(), a.b, a.c, a.d, a.e, a.f, a.g, a.h);
            return;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            P1(yVar.c(), yVar.b(), yVar.a(), yVar.g(), yVar.d(), yVar.f(), yVar.e(), yVar.h());
            return;
        }
        if (obj instanceof D) {
            D d = (D) obj;
            U1(d.a(), d.d(), d.c(), d.b(), d.e());
            return;
        }
        if (obj instanceof C6444j) {
            C6444j c6444j = (C6444j) obj;
            A1(c6444j.d(), c6444j.b(), c6444j.c(), c6444j.a());
            return;
        }
        if (obj instanceof C6443i) {
            u2(((C6443i) obj).a());
            return;
        }
        if (obj instanceof C6442h) {
            C11458d25 c11458d25A = ((C6442h) obj).a();
            if (c11458d25A == null) {
                y1();
                return;
            } else {
                z1(c11458d25A);
                return;
            }
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            E1(oVar.a(), oVar.d(), oVar.c(), oVar.b());
            return;
        }
        if (obj instanceof E) {
            E e = (E) obj;
            V1(e.a, e.b, e.c);
            return;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            C1(mVar.a, mVar.b, mVar.e, mVar.c, mVar.d);
        } else if (obj instanceof K) {
            T0();
        } else if (!(obj instanceof n)) {
            super.m(obj);
        } else {
            n nVar = (n) obj;
            D1(nVar.b, nVar.a);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        this.o = new C20466s35();
        this.p = new HashMap();
        if (W().getInt("migration_version", 56) >= 55) {
            byte[] bArrB = W().b("sender_pending_v2");
            if (bArrB != null) {
                try {
                    this.o = C20466s35.q(bArrB);
                } catch (IOException e) {
                    C19406qI3.c("Sender", "readingPendingMessages", e);
                }
            }
        } else {
            C19406qI3.j("Sender", "ignoring the pending messages", new Object[0]);
        }
        this.x = ((InterfaceC6280My1) C92.a(C5721Ko.b, InterfaceC6280My1.class)).s0();
    }

    public void r1(long j) {
        if (C8386Vt0.F5()) {
            this.z.D().S(j);
            C19857r35 c19857r35X0 = x0(j);
            if (c19857r35X0 != null) {
                this.o.r().remove(c19857r35X0);
                W0();
                this.z.G().H0(c19857r35X0.C()).b(j);
                return;
            }
            return;
        }
        DS7 ds7D2 = d2(j);
        if (ds7D2 != null) {
            ds7D2.e();
            this.w.remove(Long.valueOf(j));
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            u2(arrayList);
        }
    }

    /* renamed from: ir.nasim.No6$b, reason: case insensitive filesystem */
    class C6436b implements InterfaceC15419jZ0 {
        final /* synthetic */ J44 a;
        final /* synthetic */ C11458d25 b;

        C6436b(J44 j44, C11458d25 c11458d25) {
            this.a = j44;
            this.b = c11458d25;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            if (exc instanceof FileSizeExceededException) {
                GS7 gs7 = (GS7) this.a.F();
                J44 j44W = this.a.w(GS7.B(gs7, gs7.z().f(), false));
                j44W.i0(EnumC23558x74.LIMIT_EXCEEDED);
                C6434No6.this.z.G().H0(this.b).d(j44W);
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
        }
    }
}
