package ir.nasim;

import ai.bale.proto.FilesOuterClass$RequestFileUploadCancel;
import ai.bale.proto.FilesOuterClass$RequestGetNasimFileUploadResume;
import ai.bale.proto.FilesOuterClass$RequestGetNasimFileUploadUrl;
import ai.bale.proto.FilesOuterClass$RequestGetNasimFileUrl;
import ai.bale.proto.FilesOuterClass$ResponseFileUploadCancel;
import ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadResume;
import ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadUrl;
import ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUrl;
import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.FilesStruct$SendTypeValue;
import ai.bale.proto.PeersStruct$ExPeer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C13759gm2;
import ir.nasim.RY1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.gm2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13759gm2 implements InterfaceC12532em2 {
    public static final a h = new a(null);
    private final C6287Mz b;
    private final C14970in2 c;
    private final int d;
    private final AbstractC13778go1 e;
    private final AbstractC13778go1 f;
    private final InterfaceC14123hO3 g;

    /* renamed from: ir.nasim.gm2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.gm2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ FileReference e;
        final /* synthetic */ boolean f;

        /* renamed from: ir.nasim.gm2$b$a */
        public static final class a implements InterfaceC8091Um2 {
            final /* synthetic */ InterfaceC16204ks5 a;

            a(InterfaceC16204ks5 interfaceC16204ks5) {
                this.a = interfaceC16204ks5;
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void c(float f) {
                this.a.h(new RY1.b(f));
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                this.a.h(new RY1.a(interfaceC3346Am2));
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void e() {
                this.a.h(new RY1.c(null, 1, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(FileReference fileReference, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = fileReference;
            this.f = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(InterfaceC7857Tm2 interfaceC7857Tm2) {
            interfaceC7857Tm2.b();
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C13759gm2.this.new b(this.e, this.f, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final InterfaceC7857Tm2 interfaceC7857Tm2D = C13759gm2.this.c.D(this.e, false, new a(interfaceC16204ks5), (56 & 8) != 0 ? false : this.f, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
                SA2 sa2 = new SA2() { // from class: ir.nasim.hm2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13759gm2.b.y(interfaceC7857Tm2D);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gm2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13759gm2.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C13759gm2.this.c.H(this.d.getFileId());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gm2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ C13759gm2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, long j2, C13759gm2 c13759gm2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = j2;
            this.e = c13759gm2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = FilesOuterClass$RequestFileUploadCancel.newBuilder().A(FilesStruct$FileLocation.newBuilder().B(this.c).A(this.d)).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                FilesOuterClass$ResponseFileUploadCancel defaultInstance = FilesOuterClass$ResponseFileUploadCancel.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/ai.bale.server.Files/FileUploadCancel", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.e.b;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gm2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        long c;
        long d;
        boolean e;
        int f;
        final /* synthetic */ long h;
        final /* synthetic */ long i;
        final /* synthetic */ boolean j;

        /* renamed from: ir.nasim.gm2$e$a */
        public static final class a implements InterfaceC8807Xk2 {
            final /* synthetic */ HE0 a;

            a(HE0 he0) {
                this.a = he0;
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void c(float f) {
                AbstractC24549yo1.c(this.a, new RY1.b(f));
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                AbstractC24549yo1.c(this.a, new RY1.a(interfaceC3346Am2));
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void e() {
                AbstractC24549yo1.c(this.a, new RY1.c(null, 1, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, long j2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = j;
            this.i = j2;
            this.j = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13759gm2.this.new e(this.h, this.i, this.j, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.f;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13759gm2 c13759gm2 = C13759gm2.this;
                long j = this.h;
                long j2 = this.i;
                boolean z = this.j;
                this.b = c13759gm2;
                this.c = j;
                this.d = j2;
                this.e = z;
                this.f = 1;
                IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                ie0.w();
                c13759gm2.c.V(j, j2, new a(ie0), z);
                obj = ie0.t();
                if (obj == AbstractC14862ic3.e()) {
                    WA1.c(this);
                }
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gm2$f */
    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C13759gm2.this.c(0L, 0L, this);
        }
    }

    /* renamed from: ir.nasim.gm2$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ C13759gm2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(long j, long j2, C13759gm2 c13759gm2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = j2;
            this.e = c13759gm2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = FilesOuterClass$RequestGetNasimFileUrl.newBuilder().A((FilesStruct$FileLocation) FilesStruct$FileLocation.newBuilder().B(this.c).A(this.d).a()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                FilesOuterClass$ResponseGetNasimFileUrl defaultInstance = FilesOuterClass$ResponseGetNasimFileUrl.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/ai.bale.server.Files/GetNasimFileUrl", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.e.b;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 16500L, null, this, 4, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gm2$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ C13759gm2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j, long j2, C13759gm2 c13759gm2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = j2;
            this.e = c13759gm2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = FilesOuterClass$RequestGetNasimFileUploadResume.newBuilder().A(FilesStruct$FileLocation.newBuilder().B(this.c).A(this.d)).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                FilesOuterClass$ResponseGetNasimFileUploadResume defaultInstance = FilesOuterClass$ResponseGetNasimFileUploadResume.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/ai.bale.server.Files/GetNasimFileUploadResume", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.e.b;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gm2$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ C13759gm2 h;
        final /* synthetic */ ExPeer i;
        final /* synthetic */ EnumC4543Fo6 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(int i, long j, long j2, String str, String str2, C13759gm2 c13759gm2, ExPeer exPeer, EnumC4543Fo6 enumC4543Fo6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = j;
            this.e = j2;
            this.f = str;
            this.g = str2;
            this.h = c13759gm2;
            this.i = exPeer;
            this.j = enumC4543Fo6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                FilesOuterClass$RequestGetNasimFileUploadUrl.a aVarE = FilesOuterClass$RequestGetNasimFileUploadUrl.newBuilder().C(this.c).A(this.d).G(this.e).E(this.f);
                String str = this.g;
                if (str == null) {
                    str = "";
                }
                FilesOuterClass$RequestGetNasimFileUploadUrl.a aVarD = aVarE.D(str);
                PeersStruct$ExPeer.a aVarNewBuilder = PeersStruct$ExPeer.newBuilder();
                InterfaceC14123hO3 interfaceC14123hO3 = this.h.g;
                ExPeerType exPeerType = this.i.getExPeerType();
                AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
                GeneratedMessageLite generatedMessageLiteA = aVarD.B(aVarNewBuilder.C((EnumC10088b35) interfaceC14123hO3.a(exPeerType)).A(this.h.d).B(this.i.getPeerId())).F(FilesStruct$SendTypeValue.newBuilder().A(AbstractC14960im2.b(this.j))).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                FilesOuterClass$ResponseGetNasimFileUploadUrl defaultInstance = FilesOuterClass$ResponseGetNasimFileUploadUrl.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/ai.bale.server.Files/GetNasimFileUploadUrl", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.h.b;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gm2$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(FileReference fileReference, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
            this.e = z;
            this.f = z2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13759gm2.this.new j(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C13759gm2.this.c.I(this.d, null, this.e, this.f);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C13759gm2(C6287Mz c6287Mz, C14970in2 c14970in2, int i2, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(interfaceC14123hO3, "exPeerTypeToStructExPeerTypeMapper");
        this.b = c6287Mz;
        this.c = c14970in2;
        this.d = i2;
        this.e = abstractC13778go1;
        this.f = abstractC13778go12;
        this.g = interfaceC14123hO3;
    }

    private final Object q(long j2, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new g(j2, j3, this, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC12532em2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(long r8, long r10, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof ir.nasim.C13759gm2.f
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.gm2$f r0 = (ir.nasim.C13759gm2.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.gm2$f r0 = new ir.nasim.gm2$f
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r12)
            goto L42
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            ir.nasim.AbstractC10685c16.b(r12)
            r6.c = r2
            r1 = r7
            r2 = r8
            r4 = r10
            java.lang.Object r12 = r1.q(r2, r4, r6)
            if (r12 != r0) goto L42
            return r0
        L42:
            ir.nasim.Z06 r12 = (ir.nasim.Z06) r12
            boolean r8 = r12 instanceof ir.nasim.Z06.b
            if (r8 == 0) goto L59
            ir.nasim.Z06$b r12 = (ir.nasim.Z06.b) r12
            com.google.protobuf.P r8 = r12.a()
            ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUrl r8 = (ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUrl) r8
            ai.bale.proto.FilesStruct$FileUrlDescription r8 = r8.getFileUrl()
            java.lang.String r8 = r8.getUrl()
            goto L69
        L59:
            boolean r8 = r12 instanceof ir.nasim.Z06.a
            if (r8 == 0) goto L6a
            ir.nasim.Z06$a r12 = (ir.nasim.Z06.a) r12
            ir.nasim.core.network.RpcException r8 = r12.a()
            java.lang.String r9 = "FileRepositoryImpl"
            ir.nasim.C19406qI3.d(r9, r8)
            r8 = 0
        L69:
            return r8
        L6a:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13759gm2.c(long, long, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC12532em2
    public InterfaceC10258bL6 d() {
        return this.c.M();
    }

    @Override // ir.nasim.InterfaceC12532em2
    public Object e(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.f, new c(fileReference, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC12532em2
    public Object f(long j2, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new d(j2, j3, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC12532em2
    public InterfaceC4557Fq2 g(FileReference fileReference, boolean z) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        return AbstractC6459Nq2.V(AbstractC6459Nq2.f(new b(fileReference, z, null)), this.e);
    }

    @Override // ir.nasim.InterfaceC12532em2
    public Object h(int i2, long j2, long j3, String str, String str2, ExPeer exPeer, EnumC4543Fo6 enumC4543Fo6, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new i(i2, j2, j3, str, str2, this, exPeer, enumC4543Fo6, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC12532em2
    public Object j(FileReference fileReference, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.f, new j(fileReference, z, z2, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC12532em2
    public Object k(long j2, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new h(j2, j3, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC12532em2
    public Object l(long j2, long j3, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new e(j2, j3, z, null), interfaceC20295rm1);
    }
}
