package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.C12855fH7;
import ir.nasim.C18810pH7;
import ir.nasim.C24649yy4;
import ir.nasim.InterfaceC10839cH7;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.file.upload.MessageIdToRidRepository;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.yy4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24649yy4 extends AbstractC6360Ng4 {
    public static final c w = new c(null);
    public static final int x = 8;
    private final C9057Yh4 m;
    private final InterfaceC20315ro1 n;
    private final InterfaceC9336Zm4 o;
    private final C9213Yy7 p;
    private boolean q;
    private final InterfaceC9173Yu3 r;
    private final InterfaceC9173Yu3 s;
    private final InterfaceC9336Zm4 t;
    private final InterfaceC9173Yu3 u;
    private final InterfaceC9173Yu3 v;

    /* renamed from: ir.nasim.yy4$b */
    private static final class b {
    }

    /* renamed from: ir.nasim.yy4$c */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.yy4$d */
    private static final class d {
        private final long a;

        public d(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.yy4$e */
    /* synthetic */ class e extends EB2 implements InterfaceC14603iB2 {
        e(Object obj) {
            super(2, obj, C24649yy4.class, "onSendEvent", "onSendEvent(Ljava/lang/String;Ljava/util/Map;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y((String) obj, (Map) obj2);
            return C19938rB7.a;
        }

        public final void y(String str, Map map) {
            AbstractC13042fc3.i(str, "p0");
            AbstractC13042fc3.i(map, "p1");
            ((C24649yy4) this.receiver).M0(str, map);
        }
    }

    /* renamed from: ir.nasim.yy4$f */
    /* synthetic */ class f extends EB2 implements InterfaceC14603iB2 {
        f(Object obj) {
            super(2, obj, C24649yy4.class, "onSendEvent", "onSendEvent(Ljava/lang/String;Ljava/util/Map;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y((String) obj, (Map) obj2);
            return C19938rB7.a;
        }

        public final void y(String str, Map map) {
            AbstractC13042fc3.i(str, "p0");
            AbstractC13042fc3.i(map, "p1");
            ((C24649yy4) this.receiver).M0(str, map);
        }
    }

    /* renamed from: ir.nasim.yy4$g */
    public static final class g extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C24649yy4 e;
        final /* synthetic */ InterfaceC10839cH7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC20295rm1 interfaceC20295rm1, C24649yy4 c24649yy4, InterfaceC10839cH7 interfaceC10839cH7) {
            super(3, interfaceC20295rm1);
            this.e = c24649yy4;
            this.f = interfaceC10839cH7;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.X(this.e.E0().T().b(), new h((Map) this.d, this.f, null));
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2X, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(interfaceC20295rm1, this.e, this.f);
            gVar.c = interfaceC4806Gq2;
            gVar.d = obj;
            return gVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.yy4$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ Map d;
        final /* synthetic */ InterfaceC10839cH7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Map map, InterfaceC10839cH7 interfaceC10839cH7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = map;
            this.e = interfaceC10839cH7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(this.d, this.e, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C9489a30 c9489a30 = (C9489a30) this.c;
            if (c9489a30 == null) {
                return new XG7(0L, 1);
            }
            return new XG7(c9489a30.c(), AbstractC23053wG5.e(AbstractC20723sV3.c((c9489a30.b() * ((Number) this.d.getOrDefault(this.e, AbstractC6392Nk0.b(0.5d))).doubleValue()) / c9489a30.a()), 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C9489a30 c9489a30, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(c9489a30, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.yy4$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = new i(interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                XG7 xg7 = new XG7(-1L, 1);
                this.b = 1;
                if (interfaceC4806Gq2.a(xg7, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C24649yy4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = AbstractC20906so1.a(C12366eV1.b().X(new C19115po1("UploadManagerScope")));
        this.o = AbstractC12281eL6.a(AbstractC20051rO3.n(AbstractC4616Fw7.a(InterfaceC10839cH7.b.a, Double.valueOf(0.4d)), AbstractC4616Fw7.a(InterfaceC10839cH7.a.a, Double.valueOf(0.6d))));
        this.p = new C9213Yy7(new C18810pH7("UploadSmallQueue", c9057Yh4.S().C4(), null, 4, null), new C18810pH7("UploadBigQueue", c9057Yh4.S().C4(), null, 4, null));
        this.r = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.vy4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24649yy4.U0();
            }
        });
        this.s = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jy4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24649yy4.J0(this.a);
            }
        });
        this.t = AbstractC12281eL6.a(null);
        this.u = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ky4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24649yy4.B0();
            }
        });
        this.v = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ly4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24649yy4.C0(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.tgwidgets.editor.messenger.H A0(C4890Gz5 c4890Gz5, String str) {
        AbstractC13042fc3.i(c4890Gz5, "$pendingItem");
        AbstractC13042fc3.i(str, "descriptor");
        ir.nasim.tgwidgets.editor.messenger.H hU = c4890Gz5.u();
        if (hU != null) {
            return hU;
        }
        ir.nasim.tgwidgets.editor.messenger.H hA = AbstractC25148zo6.a(str);
        if (hA == null || !hA.b()) {
            return null;
        }
        return hA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC19086pl2 B0() {
        return (InterfaceC19086pl2) C92.a(C5721Ko.a.d(), InterfaceC19086pl2.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC12532em2 C0(C24649yy4 c24649yy4) {
        AbstractC13042fc3.i(c24649yy4, "this$0");
        return c24649yy4.E0().Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC19086pl2 E0() {
        return (InterfaceC19086pl2) this.u.getValue();
    }

    private final InterfaceC12532em2 F0() {
        return (InterfaceC12532em2) this.v.getValue();
    }

    private final MessageIdToRidRepository G0() {
        return (MessageIdToRidRepository) this.s.getValue();
    }

    private final InterfaceC3570Bk5 H0() {
        return (InterfaceC3570Bk5) this.r.getValue();
    }

    private final InterfaceC4557Fq2 I0(InterfaceC10839cH7 interfaceC10839cH7) {
        return AbstractC6459Nq2.c0(AbstractC6459Nq2.s0(this.o, new g(null, this, interfaceC10839cH7)), new i(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageIdToRidRepository J0(C24649yy4 c24649yy4) {
        AbstractC13042fc3.i(c24649yy4, "this$0");
        KS2 ks2U0 = c24649yy4.E0().u0();
        InterfaceC3570Bk5 interfaceC3570Bk5H0 = c24649yy4.H0();
        AbstractC13042fc3.h(interfaceC3570Bk5H0, "<get-preferencesStorage>(...)");
        MessageIdToRidRepository messageIdToRidRepository = new MessageIdToRidRepository(ks2U0, interfaceC3570Bk5H0, null, 4, null);
        messageIdToRidRepository.c();
        return messageIdToRidRepository;
    }

    private final void K0(long j) {
        C4890Gz5 c4890Gz5C = this.p.c(j);
        if (c4890Gz5C == null) {
            return;
        }
        C19406qI3.a("UploadManager", "Failed to put last chunk #" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5C.l())), new Object[0]);
        c4890Gz5C.A(false);
        C12855fH7 c12855fH7K = c4890Gz5C.k();
        if (c12855fH7K != null) {
            c12855fH7K.d();
        }
        VH7 vh7T = c4890Gz5C.t();
        if (vh7T != null) {
            vh7T.i(false);
        }
        c4890Gz5C.D(null);
        c4890Gz5C.C(false);
        r().d(new b());
    }

    private final void L0(long j) {
        C4890Gz5 c4890Gz5C = this.p.c(j);
        if (c4890Gz5C == null) {
            return;
        }
        C19406qI3.a("UploadManager", "PuttingLastChunk #" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5C.l())), new Object[0]);
        c4890Gz5C.A(true);
        r().d(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(String str, Map map) {
        E0().x0().a(str, map);
    }

    private final void N0(long j) {
        C4890Gz5 c4890Gz5C = this.p.c(j);
        if (c4890Gz5C == null) {
            return;
        }
        c4890Gz5C.A(false);
        c4890Gz5C.B(AbstractC20507s76.p());
        C12855fH7 c12855fH7K = c4890Gz5C.k();
        if (c12855fH7K != null) {
            c12855fH7K.d();
        }
        c4890Gz5C.y(null);
        VH7 vh7T = c4890Gz5C.t();
        if (vh7T != null) {
            VH7.c(vh7T, false, 1, null);
        }
        c4890Gz5C.D(null);
        c4890Gz5C.C(false);
        this.p.i(c4890Gz5C);
        C4890Gz5 c4890Gz5A = c4890Gz5C.a((524286 & 1) != 0 ? c4890Gz5C.a : AbstractC17026mG5.a.k(), (524286 & 2) != 0 ? c4890Gz5C.b : 0L, (524286 & 4) != 0 ? c4890Gz5C.c : 0L, (524286 & 8) != 0 ? c4890Gz5C.d : null, (524286 & 16) != 0 ? c4890Gz5C.e : null, (524286 & 32) != 0 ? c4890Gz5C.f : null, (524286 & 64) != 0 ? c4890Gz5C.g : null, (524286 & 128) != 0 ? c4890Gz5C.h : null, (524286 & 256) != 0 ? c4890Gz5C.i : null, (524286 & 512) != 0 ? c4890Gz5C.j : 0L, (524286 & 1024) != 0 ? c4890Gz5C.k : false, (524286 & 2048) != 0 ? c4890Gz5C.l : null, (524286 & 4096) != 0 ? c4890Gz5C.m : null, (524286 & 8192) != 0 ? c4890Gz5C.n : null, (524286 & 16384) != 0 ? c4890Gz5C.o : 0, (524286 & 32768) != 0 ? c4890Gz5C.p : 0.0f, (524286 & 65536) != 0 ? c4890Gz5C.q : false, (524286 & 131072) != 0 ? c4890Gz5C.r : false, (524286 & 262144) != 0 ? c4890Gz5C.s : null);
        G0().e(c4890Gz5A.l(), c4890Gz5A.o());
        this.p.a(c4890Gz5A);
        r().d(new b());
        C19406qI3.a("UploadManager", "onUploadSeemsToBeCorrupted(#" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5C.l())) + ")(rid: " + AbstractC24249yI3.a(Long.valueOf(j)) + ") -> replaced with rid(" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5A.o())) + Separators.RPAREN, new Object[0]);
    }

    private final void O0(long j, FileReference fileReference, InterfaceC3346Am2 interfaceC3346Am2) {
        C4890Gz5 c4890Gz5C = this.p.c(j);
        if (c4890Gz5C == null) {
            return;
        }
        if (this.q) {
            C19406qI3.a("UploadManager", "Upload #" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5C.l())) + " complete", new Object[0]);
        }
        if (c4890Gz5C.w()) {
            this.p.i(c4890Gz5C);
            VH7 vh7T = c4890Gz5C.t();
            if (vh7T != null) {
                VH7.c(vh7T, false, 1, null);
            }
            this.m.D().O().e(new C10405bZ1(fileReference.getFileId(), fileReference.getFileSize(), interfaceC3346Am2.getDescriptor()));
            Iterator it = c4890Gz5C.c().iterator();
            AbstractC13042fc3.h(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                AbstractC13042fc3.h(next, "next(...)");
                final InterfaceC10223bH7 interfaceC10223bH7 = (InterfaceC10223bH7) next;
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.ny4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C24649yy4.P0(interfaceC10223bH7);
                    }
                });
            }
            c4890Gz5C.c().clear();
            InterfaceC19401qH7 interfaceC19401qH7S = c4890Gz5C.s();
            if (interfaceC19401qH7S != null) {
                interfaceC19401qH7S.a(c4890Gz5C.l(), fileReference, c4890Gz5C.n());
            }
            r().d(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(InterfaceC10223bH7 interfaceC10223bH7) {
        AbstractC13042fc3.i(interfaceC10223bH7, "$fileCallback");
        interfaceC10223bH7.b();
    }

    private final void Q0(long j, Throwable th) {
        C4890Gz5 c4890Gz5C = this.p.c(j);
        if (c4890Gz5C == null) {
            if (this.q) {
                C19406qI3.a("UploadManager", "OnUploadError- Nothing found with rid(" + j + Separators.RPAREN, new Object[0]);
                return;
            }
            return;
        }
        if (this.q) {
            C19406qI3.a("UploadManager", "Upload #" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5C.l())) + " error, with error=" + th, new Object[0]);
        }
        if (c4890Gz5C.w()) {
            this.p.i(c4890Gz5C);
            C12855fH7 c12855fH7K = c4890Gz5C.k();
            if (c12855fH7K != null) {
                c12855fH7K.d();
            }
            c4890Gz5C.y(null);
            VH7 vh7T = c4890Gz5C.t();
            if (vh7T != null) {
                VH7.c(vh7T, false, 1, null);
            }
            c4890Gz5C.D(null);
            c4890Gz5C.C(false);
            Iterator it = c4890Gz5C.c().iterator();
            AbstractC13042fc3.h(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                AbstractC13042fc3.h(next, "next(...)");
                final InterfaceC10223bH7 interfaceC10223bH7 = (InterfaceC10223bH7) next;
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.iy4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C24649yy4.R0(interfaceC10223bH7);
                    }
                });
            }
            c4890Gz5C.c().clear();
            InterfaceC19401qH7 interfaceC19401qH7S = c4890Gz5C.s();
            if (interfaceC19401qH7S != null) {
                interfaceC19401qH7S.c(c4890Gz5C.l());
            }
            r().d(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(InterfaceC10223bH7 interfaceC10223bH7) {
        AbstractC13042fc3.i(interfaceC10223bH7, "$callback");
        InterfaceC10223bH7.h(interfaceC10223bH7, false, 1, null);
    }

    private final void S0(long j, final float f2, final int i2) {
        C4890Gz5 c4890Gz5C = this.p.c(j);
        if (c4890Gz5C == null) {
            return;
        }
        if (this.q) {
            C19406qI3.a("UploadManager", "Upload #" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5C.l())) + " progress " + f2, new Object[0]);
        }
        if (c4890Gz5C.w()) {
            c4890Gz5C.z(f2);
            c4890Gz5C.x(i2);
            e1(c4890Gz5C);
            Iterator it = c4890Gz5C.c().iterator();
            AbstractC13042fc3.h(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                AbstractC13042fc3.h(next, "next(...)");
                final InterfaceC10223bH7 interfaceC10223bH7 = (InterfaceC10223bH7) next;
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.uy4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C24649yy4.T0(interfaceC10223bH7, f2, i2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(InterfaceC10223bH7 interfaceC10223bH7, float f2, int i2) {
        AbstractC13042fc3.i(interfaceC10223bH7, "$fileCallback");
        interfaceC10223bH7.f(f2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3570Bk5 U0() {
        return C7183Qq.q(EnumC18608ow5.i);
    }

    private final boolean V0(String str, C18810pH7.a aVar) {
        if (aVar instanceof C18810pH7.a.c) {
            return true;
        }
        if (!(aVar instanceof C18810pH7.a.b)) {
            if (!AbstractC13042fc3.d(aVar, C18810pH7.a.C1440a.a)) {
                throw new NoWhenBranchMatchedException();
            }
            e1(null);
            return false;
        }
        C4890Gz5 c4890Gz5A = ((C18810pH7.a.b) aVar).a();
        C19406qI3.a("UploadManager", "Queue(" + str + ")- Starting upload file #" + AbstractC24249yI3.a(Long.valueOf(c4890Gz5A.l())) + c4890Gz5A.g(), new Object[0]);
        t0(c4890Gz5A).h(u0(c4890Gz5A));
        c4890Gz5A.C(true);
        e1(c4890Gz5A);
        return true;
    }

    private final void W0(long j) {
        if (this.q) {
            C19406qI3.a("UploadManager", "Removing upload #" + AbstractC24249yI3.a(Long.valueOf(j)), new Object[0]);
        }
        C4890Gz5 c4890Gz5B = this.p.b(j);
        if (c4890Gz5B == null) {
            C19406qI3.a("UploadManager", "- Not present in queue", new Object[0]);
            return;
        }
        this.p.i(c4890Gz5B);
        if (this.q) {
            C19406qI3.a("UploadManager", "- Stopping actor", new Object[0]);
        }
        C12855fH7 c12855fH7K = c4890Gz5B.k();
        if (c12855fH7K != null) {
            c12855fH7K.d();
        }
        c4890Gz5B.y(null);
        VH7 vh7T = c4890Gz5B.t();
        if (vh7T != null) {
            VH7.c(vh7T, false, 1, null);
        }
        c4890Gz5B.D(null);
        c4890Gz5B.C(false);
        InterfaceC19401qH7 interfaceC19401qH7S = c4890Gz5B.s();
        if (interfaceC19401qH7S != null) {
            interfaceC19401qH7S.b(c4890Gz5B.l());
        }
        Iterator it = c4890Gz5B.c().iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            final InterfaceC10223bH7 interfaceC10223bH7 = (InterfaceC10223bH7) next;
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.qy4
                @Override // java.lang.Runnable
                public final void run() {
                    C24649yy4.X0(interfaceC10223bH7);
                }
            });
        }
        c4890Gz5B.c().clear();
        r().d(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(InterfaceC10223bH7 interfaceC10223bH7) {
        AbstractC13042fc3.i(interfaceC10223bH7, "$callback");
        InterfaceC10223bH7.h(interfaceC10223bH7, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(InterfaceC10223bH7 interfaceC10223bH7) {
        AbstractC13042fc3.i(interfaceC10223bH7, "$callback");
        InterfaceC10223bH7.h(interfaceC10223bH7, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(InterfaceC10223bH7 interfaceC10223bH7, float f2, C4890Gz5 c4890Gz5) {
        AbstractC13042fc3.i(interfaceC10223bH7, "$callback");
        interfaceC10223bH7.f(f2, c4890Gz5.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(InterfaceC10223bH7 interfaceC10223bH7) {
        AbstractC13042fc3.i(interfaceC10223bH7, "$callback");
        interfaceC10223bH7.g(false);
    }

    private final void c1(long j, long j2, ExPeer exPeer, String str, String str2, String str3, InterfaceC19401qH7 interfaceC19401qH7, Long l, boolean z, EnumC4543Fo6 enumC4543Fo6, ir.nasim.tgwidgets.editor.messenger.H h2, InterfaceC10839cH7 interfaceC10839cH7) {
        long jK;
        C4890Gz5 c4890Gz5B = this.p.b(j);
        if (c4890Gz5B != null) {
            if (this.q) {
                C19406qI3.j("UploadManager", "Upload #" + AbstractC24249yI3.a(Long.valueOf(j)) + " already started with rid=" + c4890Gz5B.o() + "!", new Object[0]);
                return;
            }
            return;
        }
        if (this.q) {
            C19406qI3.a("UploadManager", "Starting upload #" + AbstractC24249yI3.a(Long.valueOf(j)) + " with descriptor " + str, new Object[0]);
        }
        Long lA = G0().a(j);
        if (lA != null) {
            jK = lA.longValue();
        } else {
            jK = AbstractC17026mG5.a.k();
            G0().e(j, jK);
        }
        this.p.a(new C4890Gz5(jK, j, j2, exPeer, str, str2, str3, interfaceC19401qH7, l, AbstractC20507s76.p(), z, enumC4543Fo6, h2, interfaceC10839cH7, 0, 0.0f, false, false, null, 507904, null));
        r().d(new b());
    }

    private final void d1(long j, InterfaceC10223bH7 interfaceC10223bH7) {
        C4890Gz5 c4890Gz5B = this.p.b(j);
        if (c4890Gz5B == null) {
            return;
        }
        c4890Gz5B.c().remove(interfaceC10223bH7);
    }

    private final void e1(C4890Gz5 c4890Gz5) {
        Object value;
        YG7 yg7;
        InterfaceC9336Zm4 interfaceC9336Zm4D0 = D0();
        do {
            value = interfaceC9336Zm4D0.getValue();
            yg7 = (YG7) value;
            if (c4890Gz5 == null) {
                yg7 = null;
            } else if (!c4890Gz5.v() || (yg7 != null && c4890Gz5.l() == yg7.b())) {
                yg7 = new YG7(new C11458d25(c4890Gz5.f()), c4890Gz5.l(), c4890Gz5.m(), c4890Gz5.h());
            }
        } while (!interfaceC9336Zm4D0.f(value, yg7));
    }

    private final C12855fH7 t0(C4890Gz5 c4890Gz5) {
        C12855fH7 c12855fH7K = c4890Gz5.k();
        if (c12855fH7K != null) {
            return c12855fH7K;
        }
        int i2 = 0;
        C12855fH7 c12855fH7 = new C12855fH7(new a(this, c4890Gz5.o(), c4890Gz5.l(), null, 4, null), this.n, i2, 4, null);
        c4890Gz5.y(c12855fH7);
        return c12855fH7;
    }

    private final C7737Sz4 u0(C4890Gz5 c4890Gz5) {
        C7737Sz4 c7737Sz4Z0 = z0(c4890Gz5);
        c7737Sz4Z0.start();
        c4890Gz5.D(c7737Sz4Z0);
        return c7737Sz4Z0;
    }

    private final void v0(long j, final InterfaceC10223bH7 interfaceC10223bH7) {
        final C4890Gz5 c4890Gz5B = this.p.b(j);
        if (c4890Gz5B != null) {
            if (c4890Gz5B.w()) {
                final float fM = c4890Gz5B.m();
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.py4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C24649yy4.x0(interfaceC10223bH7, fM, c4890Gz5B);
                    }
                });
            } else {
                AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.oy4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C24649yy4.w0(interfaceC10223bH7);
                    }
                });
            }
            c4890Gz5B.c().add(interfaceC10223bH7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(InterfaceC10223bH7 interfaceC10223bH7) {
        AbstractC13042fc3.i(interfaceC10223bH7, "$callback");
        InterfaceC10223bH7.h(interfaceC10223bH7, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(InterfaceC10223bH7 interfaceC10223bH7, float f2, C4890Gz5 c4890Gz5) {
        AbstractC13042fc3.i(interfaceC10223bH7, "$callback");
        interfaceC10223bH7.f(f2, c4890Gz5.i());
    }

    private final void y0() {
        C19406qI3.a("UploadManager", "- Checking small queue", new Object[0]);
        boolean zV0 = V0("small", this.p.h());
        C19406qI3.a("UploadManager", "- Checking big queue", new Object[0]);
        this.o.setValue((zV0 && V0("big", this.p.g())) ? AbstractC20051rO3.n(AbstractC4616Fw7.a(InterfaceC10839cH7.b.a, Double.valueOf(0.4d)), AbstractC4616Fw7.a(InterfaceC10839cH7.a.a, Double.valueOf(0.6d))) : AbstractC20051rO3.n(AbstractC4616Fw7.a(InterfaceC10839cH7.b.a, Double.valueOf(1.0d)), AbstractC4616Fw7.a(InterfaceC10839cH7.a.a, Double.valueOf(1.0d))));
    }

    private final C7737Sz4 z0(final C4890Gz5 c4890Gz5) {
        if (c4890Gz5.e() && C8386Vt0.F5()) {
            long jL = c4890Gz5.l();
            long jO = c4890Gz5.o();
            long jR = c4890Gz5.r();
            String strG = c4890Gz5.g();
            String strH = c4890Gz5.h();
            String strD = c4890Gz5.d();
            ExPeer exPeerF = c4890Gz5.f();
            C9528a7 c9528a7R = r();
            AbstractC13042fc3.h(c9528a7R, "self(...)");
            AbstractC13778go1 abstractC13778go1B = C12366eV1.b();
            SettingsModule settingsModuleS = this.m.S();
            AbstractC13042fc3.h(settingsModuleS, "getSettingsModule(...)");
            InterfaceC3570Bk5 interfaceC3570Bk5H0 = H0();
            AbstractC13042fc3.h(interfaceC3570Bk5H0, "<get-preferencesStorage>(...)");
            return new C18404oc1(jL, jO, jR, strG, strH, strD, exPeerF, c9528a7R, abstractC13778go1B, settingsModuleS, interfaceC3570Bk5H0, E0().f(), F0(), C12366eV1.a(), c4890Gz5.p(), new e(this), I0(c4890Gz5.j()), new UA2() { // from class: ir.nasim.my4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C24649yy4.A0(c4890Gz5, (String) obj);
                }
            });
        }
        long jL2 = c4890Gz5.l();
        long jO2 = c4890Gz5.o();
        long jR2 = c4890Gz5.r();
        String strG2 = c4890Gz5.g();
        String strH2 = c4890Gz5.h();
        String strD2 = c4890Gz5.d();
        ExPeer exPeerF2 = c4890Gz5.f();
        C9528a7 c9528a7R2 = r();
        AbstractC13042fc3.h(c9528a7R2, "self(...)");
        AbstractC13778go1 abstractC13778go1B2 = C12366eV1.b();
        SettingsModule settingsModuleS2 = this.m.S();
        AbstractC13042fc3.h(settingsModuleS2, "getSettingsModule(...)");
        InterfaceC3570Bk5 interfaceC3570Bk5H02 = H0();
        AbstractC13042fc3.h(interfaceC3570Bk5H02, "<get-preferencesStorage>(...)");
        return new C7737Sz4(jL2, jO2, jR2, strG2, strH2, strD2, exPeerF2, c9528a7R2, abstractC13778go1B2, settingsModuleS2, interfaceC3570Bk5H02, E0().f(), F0(), c4890Gz5.p(), new f(this), I0(c4890Gz5.j()), null, 65536, null);
    }

    public InterfaceC9336Zm4 D0() {
        return this.t;
    }

    public final void Y0(long j, final InterfaceC10223bH7 interfaceC10223bH7) {
        AbstractC13042fc3.i(interfaceC10223bH7, "callback");
        final C4890Gz5 c4890Gz5B = this.p.b(j);
        if (c4890Gz5B == null) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.ry4
                @Override // java.lang.Runnable
                public final void run() {
                    C24649yy4.b1(interfaceC10223bH7);
                }
            });
        } else if (!c4890Gz5B.w()) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.sy4
                @Override // java.lang.Runnable
                public final void run() {
                    C24649yy4.Z0(interfaceC10223bH7);
                }
            });
        } else {
            final float fM = c4890Gz5B.m();
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.ty4
                @Override // java.lang.Runnable
                public final void run() {
                    C24649yy4.a1(interfaceC10223bH7, fM, c4890Gz5B);
                }
            });
        }
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof LK6) {
            LK6 lk6 = (LK6) obj;
            c1(lk6.g(), lk6.j(), lk6.c(), lk6.d(), lk6.e(), lk6.a(), lk6.k(), lk6.h(), lk6.b(), lk6.i(), lk6.l(), C8386Vt0.a.Y3() ? lk6.f() : InterfaceC10839cH7.b.a);
            return;
        }
        if (obj instanceof KN5) {
            W0(((KN5) obj).a());
            return;
        }
        if (obj instanceof FH7) {
            FH7 fh7 = (FH7) obj;
            Q0(fh7.a(), fh7.b());
            return;
        }
        if (obj instanceof HH7) {
            HH7 hh7 = (HH7) obj;
            S0(hh7.c(), hh7.b(), hh7.a());
            return;
        }
        if (obj instanceof EH7) {
            EH7 eh7 = (EH7) obj;
            O0(eh7.c(), eh7.a(), eh7.b());
            return;
        }
        if (obj instanceof IH7) {
            L0(((IH7) obj).a());
            return;
        }
        if (obj instanceof GH7) {
            K0(((GH7) obj).a());
            return;
        }
        if (obj instanceof C8017Ue0) {
            C8017Ue0 c8017Ue0 = (C8017Ue0) obj;
            v0(c8017Ue0.b(), c8017Ue0.a());
            return;
        }
        if (obj instanceof XA7) {
            XA7 xa7 = (XA7) obj;
            d1(xa7.b(), xa7.a());
            return;
        }
        if (obj instanceof C12379eW5) {
            C12379eW5 c12379eW5 = (C12379eW5) obj;
            Y0(c12379eW5.b(), c12379eW5.a());
        } else if (obj instanceof b) {
            y0();
        } else if (obj instanceof d) {
            N0(((d) obj).a());
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.AbstractC6360Ng4, ir.nasim.K6
    public void n() {
        super.n();
        AbstractC20906so1.d(this.n, null, 1, null);
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        this.q = true;
        if (AbstractC7607Sl0.b.booleanValue()) {
            E0().P().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.yy4$a */
    final class a implements C12855fH7.b {
        private final long a;
        private final long b;
        private final String c;
        private boolean d;
        final /* synthetic */ C24649yy4 e;

        public a(C24649yy4 c24649yy4, long j, long j2, String str) {
            AbstractC13042fc3.i(str, ParameterNames.TAG);
            this.e = c24649yy4;
            this.a = j;
            this.b = j2;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 e(a aVar, ZG7 zg7, InterfaceC13140fj4 interfaceC13140fj4) {
            AbstractC13042fc3.i(aVar, "this$0");
            AbstractC13042fc3.i(zg7, "$lastError");
            AbstractC13042fc3.i(interfaceC13140fj4, "$this$invoke");
            interfaceC13140fj4.b("Upload", "Upload(" + aVar.b + ") has been failed repeatedly by " + zg7 + Separators.DOT, zg7.b());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(a aVar, InterfaceC13140fj4 interfaceC13140fj4) {
            AbstractC13042fc3.i(aVar, "this$0");
            AbstractC13042fc3.i(interfaceC13140fj4, "$this$invoke");
            InterfaceC13140fj4.a(interfaceC13140fj4, "Upload", "Inactivity detected on upload(" + aVar.b + ").", null, 4, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.C12855fH7.b
        public void a(Class cls, final ZG7 zg7) {
            AbstractC13042fc3.i(cls, "clazz");
            AbstractC13042fc3.i(zg7, "lastError");
            if (this.d) {
                return;
            }
            C19406qI3.b(this.c, "Repeated occurrence of an error reported for file(" + AbstractC24249yI3.a(Long.valueOf(this.b)) + ") --> \n" + zg7);
            this.e.E0().E().b("UploadFailure_" + this.b, new UA2() { // from class: ir.nasim.wy4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C24649yy4.a.e(this.a, zg7, (InterfaceC13140fj4) obj);
                }
            });
            this.e.r().d(new d(this.a));
            this.d = true;
        }

        @Override // ir.nasim.C12855fH7.b
        public void b() {
            if (this.d) {
                return;
            }
            C19406qI3.b(this.c, "Inactivity reported for file(" + AbstractC24249yI3.a(Long.valueOf(this.b)) + Separators.RPAREN);
            this.e.E0().E().b("UploadFailure_" + this.b, new UA2() { // from class: ir.nasim.xy4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C24649yy4.a.f(this.a, (InterfaceC13140fj4) obj);
                }
            });
            this.e.r().d(new d(this.a));
            this.d = true;
        }

        public /* synthetic */ a(C24649yy4 c24649yy4, long j, long j2, String str, int i, ED1 ed1) {
            this(c24649yy4, j, j2, (i & 4) != 0 ? "UploadManager_HealthListener" : str);
        }
    }
}
