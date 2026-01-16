package ir.nasim;

import android.gov.nist.core.Separators;
import android.media.AudioRecord;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import ir.nasim.R08;
import java.io.File;
import java.io.IOException;

/* loaded from: classes6.dex */
public final class T08 extends R08 {
    public static final f m = new f(null);
    public static final int n = 8;
    private final InterfaceC20315ro1 b;
    private final AbstractC13778go1 c;
    private final AbstractC13778go1 d;
    private final SA2 e;
    private final R08.b f;
    private final U08 g;
    private final SA2 h;
    private final SA2 i;
    private final InterfaceC14603iB2 j;
    private final InterfaceC14603iB2 k;
    private e l;

    /* synthetic */ class a extends C23553x7 implements SA2 {
        a(Object obj) {
            super(0, obj, f.class, "createAudioRecord", "createAudioRecord(I)Landroid/media/AudioRecord;", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AudioRecord invoke() {
            return f.b((f) this.a, 0, 1, null);
        }
    }

    /* synthetic */ class b extends EB2 implements SA2 {
        b(Object obj) {
            super(0, obj, f.class, "createTempOpusFile", "createTempOpusFile()Ljava/io/File;", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            return ((f) this.receiver).c();
        }
    }

    /* synthetic */ class c extends C23553x7 implements InterfaceC14603iB2 {
        c(Object obj) {
            super(2, obj, f.class, "retrieveDurationFromMetadata", "retrieveDurationFromMetadata(Ljava/lang/String;)Ljava/lang/Long;", 4);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return T08.h((f) this.a, str, interfaceC20295rm1);
        }
    }

    /* synthetic */ class d extends EB2 implements SA2 {
        public static final d a = new d();

        d() {
            super(0, SystemClock.class, "uptimeMillis", "uptimeMillis()J", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(SystemClock.uptimeMillis());
        }
    }

    public static final class f {
        private f() {
        }

        public static /* synthetic */ AudioRecord b(f fVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 16000;
            }
            return fVar.a(i);
        }

        public final AudioRecord a(int i) {
            return new AudioRecord(1, i, 16, 2, AudioRecord.getMinBufferSize(i, 16, 2) * 16);
        }

        public final File c() {
            String str = "voice_msg_" + AbstractC17026mG5.a.k() + ".opus";
            String strP = C4053Dm2.p();
            if (strP == null) {
                return null;
            }
            return new File(strP, str);
        }

        public final Long d(String str) throws IOException {
            AbstractC13042fc3.i(str, "filePath");
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            Long lQ = null;
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    if (strExtractMetadata != null) {
                        lQ = AbstractC19562qZ6.q(strExtractMetadata);
                    }
                } catch (Exception e) {
                    C19406qI3.c("VoiceRecorderImpl", "retrieveDurationFromMetadata", e);
                }
                return lQ;
            } finally {
                mediaMetadataRetriever.release();
            }
        }

        public /* synthetic */ f(ED1 ed1) {
            this();
        }
    }

    public interface g {
        T08 a(R08.b bVar, InterfaceC14603iB2 interfaceC14603iB2);
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ e e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ T08 c;
            final /* synthetic */ File d;
            final /* synthetic */ e e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(T08 t08, File file, e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = t08;
                this.d = file;
                this.e = eVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    U08 u08 = this.c.g;
                    String path = this.d.getPath();
                    AbstractC13042fc3.h(path, "getPath(...)");
                    int sampleRate = this.e.b().getSampleRate();
                    this.b = 1;
                    if (u08.c(path, sampleRate, this) == objE) {
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
                return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ T08 d;
            final /* synthetic */ e e;
            final /* synthetic */ File f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(T08 t08, e eVar, File file, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.d = t08;
                this.e = eVar;
                this.f = file;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00d3  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    Method dump skipped, instructions count: 324
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.T08.h.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
                bVar.c = th;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ T08 d;
            final /* synthetic */ e e;

            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ T08 c;
                final /* synthetic */ e d;
                final /* synthetic */ e.a e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(T08 t08, e eVar, e.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = t08;
                    this.d = eVar;
                    this.e = aVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    if (this.c.s(this.d)) {
                        this.c.r().g(this.d.c(), (((Number) this.c.h.invoke()).longValue() - this.e.c()) + this.e.d());
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(T08 t08, e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = t08;
                this.e = eVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.d, this.e, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                e.a aVar;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    aVar = (e.a) this.c;
                    T08 t08 = this.d;
                    long jD = aVar.d();
                    long jC = aVar.c();
                    e eVar = this.e;
                    this.c = aVar;
                    this.b = 1;
                    if (t08.t(jD, jC, eVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    aVar = (e.a) this.c;
                    AbstractC10685c16.b(obj);
                }
                AbstractC13778go1 abstractC13778go1 = this.d.d;
                a aVar2 = new a(this.d, this.e, aVar, null);
                this.c = null;
                this.b = 2;
                if (AbstractC9323Zl0.g(abstractC13778go1, aVar2, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(e.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            d(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                d dVar = new d(interfaceC20295rm1);
                dVar.c = obj;
                return dVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(!((e.a) this.c).e());
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(e.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = eVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = T08.this.new h(this.e, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IllegalStateException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                File file = (File) T08.this.i.invoke();
                if (file == null) {
                    T08 t08 = T08.this;
                    e eVar = this.e;
                    Exception exc = new Exception("Failed to create file to record on it.");
                    if (t08.s(eVar)) {
                        t08.r().b(eVar.c(), null, exc);
                    }
                    C19406qI3.d("VoiceRecorderImpl", exc);
                    return C19938rB7.a;
                }
                AbstractC20906so1.f(interfaceC20315ro1);
                this.e.i();
                if (T08.this.s(this.e)) {
                    T08.this.r().k(this.e.c());
                }
                C19406qI3.a("VoiceRecorderImpl", "Start recording with id: " + this.e.c(), new Object[0]);
                InterfaceC4557Fq2 interfaceC4557Fq2Q0 = AbstractC6459Nq2.q0(AbstractC6459Nq2.b0(AbstractC6459Nq2.a0(AbstractC6459Nq2.c0(this.e.d(), new a(T08.this, file, this.e, null)), new b(T08.this, this.e, file, null)), new c(T08.this, this.e, null)), new d(null));
                this.b = 1;
                if (AbstractC6459Nq2.k(interfaceC4557Fq2Q0, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ e e;
        final /* synthetic */ T08 f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ T08 c;
            final /* synthetic */ e d;
            final /* synthetic */ long e;
            final /* synthetic */ long f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(T08 t08, e eVar, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = t08;
                this.d = eVar;
                this.e = j;
                this.f = j2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c.s(this.d)) {
                    this.c.r().g(this.d.c(), (((Number) this.c.h.invoke()).longValue() - this.e) + this.f);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(e eVar, T08 t08, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = eVar;
            this.f = t08;
            this.g = j;
            this.h = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = new i(this.e, this.f, this.g, this.h, interfaceC20295rm1);
            iVar.d = obj;
            return iVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:18:0x0045
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v5, types: [byte[], java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0090 -> B:8:0x0019). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r14.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L32
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r1 = r14.b
                byte[] r1 = (byte[]) r1
                java.lang.Object r4 = r14.d
                ir.nasim.ro1 r4 = (ir.nasim.InterfaceC20315ro1) r4
                ir.nasim.AbstractC10685c16.b(r15)     // Catch: java.lang.Throwable -> L1b
            L19:
                r15 = r4
                goto L41
            L1b:
                r15 = move-exception
                goto La9
            L1e:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L26:
                java.lang.Object r1 = r14.b
                byte[] r1 = (byte[]) r1
                java.lang.Object r4 = r14.d
                ir.nasim.ro1 r4 = (ir.nasim.InterfaceC20315ro1) r4
                ir.nasim.AbstractC10685c16.b(r15)     // Catch: java.lang.Throwable -> L1b
                goto L71
            L32:
                ir.nasim.AbstractC10685c16.b(r15)
                java.lang.Object r15 = r14.d
                ir.nasim.ro1 r15 = (ir.nasim.InterfaceC20315ro1) r15
                ir.nasim.RZ7 r1 = ir.nasim.RZ7.a
                r4 = 16384(0x4000, float:2.2959E-41)
                byte[] r1 = r1.a(r4)
            L41:
                boolean r4 = ir.nasim.AbstractC20906so1.g(r15)     // Catch: java.lang.Throwable -> L1b
                if (r4 == 0) goto La1
                ir.nasim.T08$e r4 = r14.e     // Catch: java.lang.Throwable -> L1b
                android.media.AudioRecord r4 = ir.nasim.T08.e.a(r4)     // Catch: java.lang.Throwable -> L1b
                int r4 = r4.getState()     // Catch: java.lang.Throwable -> L1b
                if (r4 != r3) goto La1
                ir.nasim.T08$e r4 = r14.e     // Catch: java.lang.Throwable -> L1b
                int r5 = r1.length     // Catch: java.lang.Throwable -> L1b
                r6 = 0
                int r4 = r4.f(r1, r6, r5)     // Catch: java.lang.Throwable -> L1b
                if (r4 <= 0) goto L93
                ir.nasim.T08 r5 = r14.f     // Catch: java.lang.Throwable -> L1b
                ir.nasim.U08 r5 = ir.nasim.T08.o(r5)     // Catch: java.lang.Throwable -> L1b
                r14.d = r15     // Catch: java.lang.Throwable -> L1b
                r14.b = r1     // Catch: java.lang.Throwable -> L1b
                r14.c = r3     // Catch: java.lang.Throwable -> L1b
                java.lang.Object r4 = r5.a(r1, r4, r14)     // Catch: java.lang.Throwable -> L1b
                if (r4 != r0) goto L70
                return r0
            L70:
                r4 = r15
            L71:
                ir.nasim.T08 r15 = r14.f     // Catch: java.lang.Throwable -> L1b
                ir.nasim.go1 r15 = ir.nasim.T08.k(r15)     // Catch: java.lang.Throwable -> L1b
                ir.nasim.T08$i$a r13 = new ir.nasim.T08$i$a     // Catch: java.lang.Throwable -> L1b
                ir.nasim.T08 r6 = r14.f     // Catch: java.lang.Throwable -> L1b
                ir.nasim.T08$e r7 = r14.e     // Catch: java.lang.Throwable -> L1b
                long r8 = r14.g     // Catch: java.lang.Throwable -> L1b
                long r10 = r14.h     // Catch: java.lang.Throwable -> L1b
                r12 = 0
                r5 = r13
                r5.<init>(r6, r7, r8, r10, r12)     // Catch: java.lang.Throwable -> L1b
                r14.d = r4     // Catch: java.lang.Throwable -> L1b
                r14.b = r1     // Catch: java.lang.Throwable -> L1b
                r14.c = r2     // Catch: java.lang.Throwable -> L1b
                java.lang.Object r15 = ir.nasim.AbstractC9323Zl0.g(r15, r13, r14)     // Catch: java.lang.Throwable -> L1b
                if (r15 != r0) goto L19
                return r0
            L93:
                ir.nasim.T08$e r4 = r14.e     // Catch: java.lang.Throwable -> L1b
                android.media.AudioRecord r4 = ir.nasim.T08.e.a(r4)     // Catch: java.lang.Throwable -> L1b
                int r4 = r4.getRecordingState()     // Catch: java.lang.Throwable -> L1b
                r5 = 3
                if (r4 != r5) goto La1
                goto L41
            La1:
                ir.nasim.RZ7 r15 = ir.nasim.RZ7.a
                r15.b(r1)
                ir.nasim.rB7 r15 = ir.nasim.C19938rB7.a
                return r15
            La9:
                ir.nasim.RZ7 r0 = ir.nasim.RZ7.a
                r0.b(r1)
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.T08.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public T08(InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, SA2 sa2, R08.b bVar, U08 u08, SA2 sa22, SA2 sa23, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(sa2, "audioRecordFactory");
        AbstractC13042fc3.i(bVar, "listener");
        AbstractC13042fc3.i(u08, "writer");
        AbstractC13042fc3.i(sa22, "getCurrentTime");
        AbstractC13042fc3.i(sa23, "tempOpusFileGenerator");
        AbstractC13042fc3.i(interfaceC14603iB2, "onSendAudio");
        AbstractC13042fc3.i(interfaceC14603iB22, "retrieveDurationFromMetadata");
        this.b = interfaceC20315ro1;
        this.c = abstractC13778go1;
        this.d = abstractC13778go12;
        this.e = sa2;
        this.f = bVar;
        this.g = u08;
        this.h = sa22;
        this.i = sa23;
        this.j = interfaceC14603iB2;
        this.k = interfaceC14603iB22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object h(f fVar, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return fVar.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(e eVar) {
        return this.l == eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t(long j, long j2, e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.c, new i(eVar, this, j2, j, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.R08
    public void a() {
        e eVar = this.l;
        C19406qI3.a("VoiceRecorderImpl", "cancelRecording(currentId: " + (eVar != null ? Long.valueOf(eVar.c()) : null) + Separators.RPAREN, new Object[0]);
        e eVar2 = this.l;
        if (eVar2 == null) {
            return;
        }
        eVar2.g();
        this.l = null;
        if (s(eVar2)) {
            R08.b.c(r(), eVar2.c(), null, null, 4, null);
        }
    }

    @Override // ir.nasim.R08
    public void b() throws IllegalStateException {
        e eVar = this.l;
        C19406qI3.a("VoiceRecorderImpl", "pauseRecording(currentId: " + (eVar != null ? Long.valueOf(eVar.c()) : null) + Separators.RPAREN, new Object[0]);
        e eVar2 = this.l;
        if (eVar2 != null && eVar2.b().getRecordingState() == 3) {
            eVar2.e();
            if (s(eVar2)) {
                r().e(eVar2.c());
            }
        }
    }

    @Override // ir.nasim.R08
    public void c() {
        e eVar = this.l;
        C19406qI3.a("VoiceRecorderImpl", "release(currentId: " + (eVar != null ? Long.valueOf(eVar.c()) : null) + Separators.RPAREN, new Object[0]);
        a();
    }

    @Override // ir.nasim.R08
    public void d() throws IllegalStateException {
        e eVar = this.l;
        C19406qI3.a("VoiceRecorderImpl", "resumeRecording(currentId: " + (eVar != null ? Long.valueOf(eVar.c()) : null) + Separators.RPAREN, new Object[0]);
        e eVar2 = this.l;
        if (eVar2 == null || eVar2.b().getRecordingState() == 3) {
            return;
        }
        eVar2.h();
        if (s(eVar2)) {
            r().i(eVar2.c(), ((e.a) eVar2.d().getValue()).d());
        }
    }

    @Override // ir.nasim.R08
    public long f() {
        C19406qI3.a("VoiceRecorderImpl", "startRecording(currentRecorderIsNull: " + (this.l == null) + Separators.RPAREN, new Object[0]);
        e eVar = this.l;
        if (eVar != null) {
            C19406qI3.j("VoiceRecorderImpl", "Releasing the previous recorder(" + eVar.c() + Separators.RPAREN, new Object[0]);
            eVar.g();
            this.l = null;
        }
        e eVar2 = new e(AbstractC17026mG5.a.k(), this.e, this.h);
        this.l = eVar2;
        AbstractC10533bm0.d(this.b, this.c, null, new h(eVar2, null), 2, null);
        return eVar2.c();
    }

    @Override // ir.nasim.R08
    public void g() throws IllegalStateException {
        e eVar = this.l;
        C19406qI3.a("VoiceRecorderImpl", "stopRecording(currentId: " + (eVar != null ? Long.valueOf(eVar.c()) : null) + Separators.RPAREN, new Object[0]);
        e eVar2 = this.l;
        if (eVar2 == null) {
            return;
        }
        eVar2.j();
        this.l = null;
        if (s(eVar2)) {
            r().m(eVar2.c(), -1L);
        }
    }

    public R08.b r() {
        return this.f;
    }

    private static final class e {
        private final long a;
        private final SA2 b;
        private final InterfaceC9173Yu3 c;
        private final InterfaceC9336Zm4 d;

        public e(long j, SA2 sa2, SA2 sa22) {
            AbstractC13042fc3.i(sa2, "audioRecordFactory");
            AbstractC13042fc3.i(sa22, "getCurrentTime");
            this.a = j;
            this.b = sa22;
            this.c = AbstractC13269fw3.a(sa2);
            this.d = AbstractC12281eL6.a(new a(0L, 0L, false, false, 15, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AudioRecord b() {
            return (AudioRecord) this.c.getValue();
        }

        public final long c() {
            return this.a;
        }

        public final InterfaceC9336Zm4 d() {
            return this.d;
        }

        public final void e() throws IllegalStateException {
            Object value;
            a aVar;
            b().stop();
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
                aVar = (a) value;
            } while (!interfaceC9336Zm4.f(value, a.b(aVar, (((Number) this.b.invoke()).longValue() - aVar.c()) + aVar.d(), 0L, false, false, 6, null)));
        }

        public final int f(byte[] bArr, int i, int i2) {
            AbstractC13042fc3.i(bArr, "buffer");
            return b().read(bArr, i, i2);
        }

        public final void g() {
            if (b().getState() == 1) {
                b().release();
            }
        }

        public final void h() throws IllegalStateException {
            Object value;
            b().startRecording();
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, a.b((a) value, 0L, ((Number) this.b.invoke()).longValue(), false, true, 5, null)));
        }

        public final void i() throws IllegalStateException {
            Object value;
            b().startRecording();
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, a.b((a) value, 0L, ((Number) this.b.invoke()).longValue(), false, true, 1, null)));
        }

        public final void j() throws IllegalStateException {
            Object value;
            a aVar;
            b().stop();
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
                aVar = (a) value;
            } while (!interfaceC9336Zm4.f(value, a.b(aVar, aVar.f() ? (((Number) this.b.invoke()).longValue() - aVar.c()) + aVar.d() : aVar.d(), 0L, true, false, 2, null)));
        }

        public static final class a {
            private final long a;
            private final long b;
            private final boolean c;
            private final boolean d;

            public a(long j, long j2, boolean z, boolean z2) {
                this.a = j;
                this.b = j2;
                this.c = z;
                this.d = z2;
            }

            public static /* synthetic */ a b(a aVar, long j, long j2, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = aVar.a;
                }
                long j3 = j;
                if ((i & 2) != 0) {
                    j2 = aVar.b;
                }
                long j4 = j2;
                if ((i & 4) != 0) {
                    z = aVar.c;
                }
                boolean z3 = z;
                if ((i & 8) != 0) {
                    z2 = aVar.d;
                }
                return aVar.a(j3, j4, z3, z2);
            }

            public final a a(long j, long j2, boolean z, boolean z2) {
                return new a(j, j2, z, z2);
            }

            public final long c() {
                return this.b;
            }

            public final long d() {
                return this.a;
            }

            public final boolean e() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
            }

            public final boolean f() {
                return this.d;
            }

            public int hashCode() {
                return (((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
            }

            public String toString() {
                return "State(totalDuration=" + this.a + ", previousCountedTime=" + this.b + ", isEnded=" + this.c + ", isRecording=" + this.d + Separators.RPAREN;
            }

            public /* synthetic */ a(long j, long j2, boolean z, boolean z2, int i, ED1 ed1) {
                this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? -1L : j2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public T08(W08 w08, R08.b bVar, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(w08, "writer");
        AbstractC13042fc3.i(bVar, "listener");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(interfaceC14603iB2, "onSendAudio");
        f fVar = m;
        this(interfaceC20315ro1, abstractC13778go1, abstractC13778go12, new a(fVar), bVar, w08, d.a, new b(fVar), interfaceC14603iB2, new c(fVar));
    }
}
