package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C7737Sz4;
import ir.nasim.InterfaceC16756lo6;
import ir.nasim.InterfaceC23654xH7;
import ir.nasim.JH7;
import ir.nasim.ZG7;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.video.MediaCodecVideoConvertor;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* renamed from: ir.nasim.oc1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18404oc1 extends C7737Sz4 {
    private static final a P = new a(null);
    public static final int Q = 8;
    private final AbstractC13778go1 K;
    private final UA2 L;
    private final String M;
    private ir.nasim.tgwidgets.editor.messenger.H N;
    private String O;

    /* renamed from: ir.nasim.oc1$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.oc1$b */
    private static final class b {
        private final long a;
        private final float b;

        public b(long j, float f) {
            this.a = j;
            this.b = f;
        }

        public final long a() {
            return this.a;
        }

        public final float b() {
            return this.b;
        }

        public final long c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && Float.compare(this.b, bVar.b) == 0;
        }

        public int hashCode() {
            return (Long.hashCode(this.a) * 31) + Float.hashCode(this.b);
        }

        public String toString() {
            return "CompressDetail(availableSize=" + this.a + ", progress=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.oc1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ ir.nasim.tgwidgets.editor.messenger.H d;
        final /* synthetic */ File e;
        final /* synthetic */ C18404oc1 f;

        /* renamed from: ir.nasim.oc1$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ ir.nasim.tgwidgets.editor.messenger.H d;
            final /* synthetic */ File e;
            final /* synthetic */ C18404oc1 f;
            final /* synthetic */ InterfaceC16204ks5 g;

            /* renamed from: ir.nasim.oc1$c$a$a, reason: collision with other inner class name */
            public static final class C1427a implements MediaController.r {
                final /* synthetic */ InterfaceC20315ro1 a;
                final /* synthetic */ C9663aL5 b;
                final /* synthetic */ ir.nasim.tgwidgets.editor.messenger.H c;
                final /* synthetic */ C9663aL5 d;
                final /* synthetic */ InterfaceC16204ks5 e;

                C1427a(InterfaceC20315ro1 interfaceC20315ro1, C9663aL5 c9663aL5, ir.nasim.tgwidgets.editor.messenger.H h, C9663aL5 c9663aL52, InterfaceC16204ks5 interfaceC16204ks5) {
                    this.a = interfaceC20315ro1;
                    this.b = c9663aL5;
                    this.c = h;
                    this.d = c9663aL52;
                    this.e = interfaceC16204ks5;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
                @Override // ir.nasim.tgwidgets.editor.messenger.MediaController.r
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void b(long r7, float r9) {
                    /*
                        r6 = this;
                        double r0 = (double) r9
                        r2 = 4604930618986332160(0x3fe8000000000000, double:0.75)
                        int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                        r3 = 1
                        if (r2 <= 0) goto L18
                        ir.nasim.aL5 r2 = r6.b
                        boolean r4 = r2.a
                        if (r4 != 0) goto L18
                        r2.a = r3
                        ir.nasim.tgwidgets.editor.messenger.H r0 = r6.c
                        float r1 = (float) r7
                        float r1 = r1 / r9
                        long r1 = (long) r1
                        r0.p = r1
                        goto L30
                    L18:
                        r4 = 4606732058837280358(0x3fee666666666666, double:0.95)
                        int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                        if (r0 <= 0) goto L30
                        ir.nasim.aL5 r0 = r6.d
                        boolean r1 = r0.a
                        if (r1 != 0) goto L30
                        r0.a = r3
                        ir.nasim.tgwidgets.editor.messenger.H r0 = r6.c
                        float r1 = (float) r7
                        float r1 = r1 / r9
                        long r1 = (long) r1
                        r0.p = r1
                    L30:
                        ir.nasim.tgwidgets.editor.messenger.H r0 = r6.c
                        long r1 = r0.q
                        float r1 = (float) r1
                        long r2 = r0.t
                        float r0 = (float) r2
                        float r1 = r1 / r0
                        ir.nasim.ks5 r0 = r6.e
                        ir.nasim.oc1$b r2 = new ir.nasim.oc1$b
                        float r9 = r9 / r1
                        r2.<init>(r7, r9)
                        r0.h(r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18404oc1.c.a.C1427a.b(long, float):void");
                }

                @Override // ir.nasim.tgwidgets.editor.messenger.MediaController.r
                public boolean c() {
                    return !AbstractC20906so1.g(this.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ir.nasim.tgwidgets.editor.messenger.H h, File file, C18404oc1 c18404oc1, InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = h;
                this.e = file;
                this.f = c18404oc1;
                this.g = interfaceC16204ks5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                C9663aL5 c9663aL5 = new C9663aL5();
                C9663aL5 c9663aL52 = new C9663aL5();
                MediaCodecVideoConvertor mediaCodecVideoConvertor = new MediaCodecVideoConvertor();
                ir.nasim.tgwidgets.editor.messenger.H h = this.d;
                String str = h.o;
                File file = this.e;
                int i = h.g;
                int i2 = h.h;
                int i3 = h.i;
                int i4 = h.k;
                int i5 = h.l;
                int i6 = h.n;
                int i7 = h.m;
                int i8 = h.j;
                long j = h.a;
                long j2 = h.b;
                long j3 = h.c;
                long j4 = h.t;
                MediaController.n nVar = h.x;
                String str2 = h.y;
                ArrayList arrayList = h.z;
                boolean z = h.B;
                MediaController.i iVar = h.A;
                boolean z2 = h.r;
                C1427a c1427a = new C1427a(interfaceC20315ro1, c9663aL5, h, c9663aL52, this.g);
                ir.nasim.tgwidgets.editor.messenger.H h2 = this.d;
                boolean zB = mediaCodecVideoConvertor.b(str, file, i, false, i2, i3, i4, i5, i6, i7, i8, j, j2, j3, true, j4, nVar, str2, arrayList, z, iVar, z2, c1427a, h2.F, h2.G, h2.s, false, h2.D, h2.E);
                C19406qI3.a(this.f.e0(), "Compression completed with failure result: " + zB, new Object[0]);
                if (zB) {
                    String str3 = this.f.O;
                    if (str3 != null) {
                        AbstractC6392Nk0.a(new File(str3).delete());
                    }
                    InterfaceC9336Zm4 interfaceC9336Zm4A = this.f.a();
                    do {
                        value = interfaceC9336Zm4A.getValue();
                    } while (!interfaceC9336Zm4A.f(value, new InterfaceC23654xH7.a(new ZG7.e(new IOException("Failed to compress the given file.")))));
                } else {
                    this.d.p = this.e.length();
                    GJ0.b(this.g.h(new b(this.e.length(), 1.0f)));
                }
                InterfaceC16756lo6.a.a(this.g, null, 1, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ir.nasim.tgwidgets.editor.messenger.H h, File file, C18404oc1 c18404oc1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = h;
            this.e = file;
            this.f = c18404oc1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, this.f, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                AbstractC10533bm0.d(interfaceC16204ks5, null, null, new a(this.d, this.e, this.f, interfaceC16204ks5, null), 3, null);
                this.b = 1;
                if (AbstractC13822gs5.b(interfaceC16204ks5, null, this, 1, null) == objE) {
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
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.oc1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ WG7 d;
        final /* synthetic */ JH7.b e;
        final /* synthetic */ InterfaceC16756lo6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(WG7 wg7, JH7.b bVar, InterfaceC16756lo6 interfaceC16756lo6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = wg7;
            this.e = bVar;
            this.f = interfaceC16756lo6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18404oc1.this.new e(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ir.nasim.tgwidgets.editor.messenger.H h = C18404oc1.this.N;
                if (h != null) {
                    C18404oc1 c18404oc1 = C18404oc1.this;
                    WG7 wg7 = this.d;
                    InterfaceC16756lo6 interfaceC16756lo6 = this.f;
                    this.b = 1;
                    if (c18404oc1.R0(wg7, h, interfaceC16756lo6, this) == objE) {
                        return objE;
                    }
                } else {
                    InterfaceC24823zG1 interfaceC24823zG1T = C18404oc1.super.T(this.d, this.e, this.f);
                    this.b = 2;
                    if (interfaceC24823zG1T.y(this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.oc1$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        private /* synthetic */ Object g;
        final /* synthetic */ ir.nasim.tgwidgets.editor.messenger.H i;
        final /* synthetic */ InterfaceC16756lo6 j;
        final /* synthetic */ WG7 k;

        /* renamed from: ir.nasim.oc1$f$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C11637dL5 a;
            final /* synthetic */ InterfaceC20315ro1 b;
            final /* synthetic */ WG7 c;
            final /* synthetic */ C18404oc1 d;
            final /* synthetic */ C11637dL5 e;
            final /* synthetic */ InterfaceC17551n93 f;
            final /* synthetic */ InterfaceC16756lo6 g;

            /* renamed from: ir.nasim.oc1$f$a$a, reason: collision with other inner class name */
            static final class C1428a extends AbstractC22163um1 {
                Object a;
                long b;
                float c;
                int d;
                /* synthetic */ Object e;
                int g;

                C1428a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.e = obj;
                    this.g |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C11637dL5 c11637dL5, InterfaceC20315ro1 interfaceC20315ro1, WG7 wg7, C18404oc1 c18404oc1, C11637dL5 c11637dL52, InterfaceC17551n93 interfaceC17551n93, InterfaceC16756lo6 interfaceC16756lo6) {
                this.a = c11637dL5;
                this.b = interfaceC20315ro1;
                this.c = wg7;
                this.d = c18404oc1;
                this.e = c11637dL52;
                this.f = interfaceC17551n93;
                this.g = interfaceC16756lo6;
            }

            private static final boolean e(float f, long j, C11637dL5 c11637dL5, WG7 wg7) {
                if (f < 1.0f) {
                    if (j - c11637dL5.a < wg7.c()) {
                        return false;
                    }
                } else if (j <= c11637dL5.a) {
                    return false;
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:27:0x00a3 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00a4  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00b1 A[Catch: ClosedSendChannelException -> 0x00bb, TryCatch #1 {ClosedSendChannelException -> 0x00bb, blocks: (B:29:0x00a9, B:31:0x00b1, B:21:0x005d, B:23:0x0065, B:25:0x006f, B:33:0x00bd, B:34:0x00c4), top: B:41:0x00a9 }] */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00bd A[Catch: ClosedSendChannelException -> 0x00bb, TryCatch #1 {ClosedSendChannelException -> 0x00bb, blocks: (B:29:0x00a9, B:31:0x00b1, B:21:0x005d, B:23:0x0065, B:25:0x006f, B:33:0x00bd, B:34:0x00c4), top: B:41:0x00a9 }] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a4 -> B:41:0x00a9). Please report as a decompilation issue!!! */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.C18404oc1.b r19, ir.nasim.InterfaceC20295rm1 r20) {
                /*
                    Method dump skipped, instructions count: 211
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18404oc1.f.a.a(ir.nasim.oc1$b, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(ir.nasim.tgwidgets.editor.messenger.H h, InterfaceC16756lo6 interfaceC16756lo6, WG7 wg7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = h;
            this.j = interfaceC16756lo6;
            this.k = wg7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C18404oc1.this.new f(this.i, this.j, this.k, interfaceC20295rm1);
            fVar.g = obj;
            return fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v21, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            Throwable th;
            ?? r1;
            InterfaceC16756lo6 interfaceC16756lo6;
            InterfaceC17551n93 interfaceC17551n93;
            WG7 wg7;
            C18404oc1 c18404oc1;
            InterfaceC17551n93 interfaceC17551n932;
            Object objS0;
            Object objE = AbstractC14862ic3.e();
            int i = this.f;
            try {
                try {
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.g;
                        C19406qI3.a(C18404oc1.this.e0(), "Generating chunks with info: \n" + this.i, new Object[0]);
                        String strM = C4053Dm2.m("mp4");
                        C18404oc1.this.O = strM;
                        File file = new File(strM);
                        file.createNewFile();
                        AbstractC13042fc3.f(strM);
                        InterfaceC17551n93 interfaceC17551n93C = new C9115Yo(strM).c();
                        WG7 wg72 = this.k;
                        C18404oc1 c18404oc12 = C18404oc1.this;
                        ir.nasim.tgwidgets.editor.messenger.H h = this.i;
                        interfaceC16756lo6 = this.j;
                        C11637dL5 c11637dL5 = new C11637dL5();
                        c11637dL5.a = 1;
                        C11637dL5 c11637dL52 = new C11637dL5();
                        c11637dL52.a = wg72.c();
                        InterfaceC4557Fq2 interfaceC4557Fq2Q0 = c18404oc12.Q0(file, h);
                        a aVar = new a(c11637dL52, interfaceC20315ro1, wg72, c18404oc12, c11637dL5, interfaceC17551n93C, interfaceC16756lo6);
                        this.g = interfaceC17551n93C;
                        this.b = wg72;
                        this.c = c18404oc12;
                        this.d = interfaceC16756lo6;
                        this.e = interfaceC17551n93C;
                        this.f = 1;
                        if (interfaceC4557Fq2Q0.b(aVar, this) == objE) {
                            return objE;
                        }
                        interfaceC17551n93 = interfaceC17551n93C;
                        wg7 = wg72;
                        c18404oc1 = c18404oc12;
                        interfaceC17551n932 = interfaceC17551n93;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ?? r12 = (Closeable) this.g;
                            AbstractC10685c16.b(obj);
                            interfaceC17551n93 = r12;
                            objS0 = obj;
                            ((Boolean) objS0).booleanValue();
                            YV0.a(interfaceC17551n93, null);
                            InterfaceC16756lo6.a.a(this.j, null, 1, null);
                            C19406qI3.a(C18404oc1.this.e0(), "SendChannel is closed manually", new Object[0]);
                            return C19938rB7.a;
                        }
                        InterfaceC17551n93 interfaceC17551n933 = (InterfaceC17551n93) this.e;
                        InterfaceC16756lo6 interfaceC16756lo62 = (InterfaceC16756lo6) this.d;
                        C18404oc1 c18404oc13 = (C18404oc1) this.c;
                        WG7 wg73 = (WG7) this.b;
                        ?? r6 = (Closeable) this.g;
                        try {
                            AbstractC10685c16.b(obj);
                            interfaceC16756lo6 = interfaceC16756lo62;
                            interfaceC17551n93 = r6;
                            wg7 = wg73;
                            interfaceC17551n932 = interfaceC17551n933;
                            c18404oc1 = c18404oc13;
                        } catch (Throwable th2) {
                            th = th2;
                            r1 = r6;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                YV0.a(r1, th);
                                throw th3;
                            }
                        }
                    }
                    int iC = wg7.c();
                    this.g = interfaceC17551n93;
                    this.b = null;
                    this.c = null;
                    this.d = null;
                    this.e = null;
                    this.f = 2;
                    objS0 = c18404oc1.S0(0, iC, 0, interfaceC17551n932, wg7, interfaceC16756lo6, this);
                    if (objS0 == objE) {
                        return objE;
                    }
                    ((Boolean) objS0).booleanValue();
                    YV0.a(interfaceC17551n93, null);
                    InterfaceC16756lo6.a.a(this.j, null, 1, null);
                    C19406qI3.a(C18404oc1.this.e0(), "SendChannel is closed manually", new Object[0]);
                    return C19938rB7.a;
                } catch (Throwable th4) {
                    th = th4;
                    r1 = interfaceC17551n93;
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                r1 = i;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.oc1$g */
    public static final class g implements InterfaceC3346Am2 {
        private final /* synthetic */ InterfaceC3346Am2 a;
        private final int b;

        g(InterfaceC3346Am2 interfaceC3346Am2, C18404oc1 c18404oc1) {
            this.a = interfaceC3346Am2;
            ir.nasim.tgwidgets.editor.messenger.H h = c18404oc1.N;
            this.b = h != null ? (int) h.p : interfaceC3346Am2.f();
        }

        @Override // ir.nasim.InterfaceC3346Am2
        public boolean a() {
            return this.a.a();
        }

        @Override // ir.nasim.InterfaceC3346Am2
        public DN4 b(int i) {
            return this.a.b(i);
        }

        @Override // ir.nasim.InterfaceC3346Am2
        public InterfaceC17551n93 c() {
            return this.a.c();
        }

        @Override // ir.nasim.InterfaceC3346Am2
        public int f() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC3346Am2
        public String getDescriptor() {
            return this.a.getDescriptor();
        }
    }

    /* renamed from: ir.nasim.oc1$h */
    static final class h extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C18404oc1.this.S0(0, 0, 0, null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18404oc1(long j, long j2, long j3, String str, String str2, String str3, ExPeer exPeer, C9528a7 c9528a7, AbstractC13778go1 abstractC13778go1, SettingsModule settingsModule, InterfaceC3570Bk5 interfaceC3570Bk5, OkHttpClient okHttpClient, InterfaceC12532em2 interfaceC12532em2, AbstractC13778go1 abstractC13778go12, EnumC4543Fo6 enumC4543Fo6, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC4557Fq2 interfaceC4557Fq2, UA2 ua2) {
        super(j, j2, j3, str, str2, str3, exPeer, c9528a7, abstractC13778go1, settingsModule, interfaceC3570Bk5, okHttpClient, interfaceC12532em2, enumC4543Fo6, interfaceC14603iB2, interfaceC4557Fq2, null, 65536, null);
        AbstractC13042fc3.i(str, "descriptor");
        AbstractC13042fc3.i(str2, "fileName");
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(c9528a7, "manager");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcherIo");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(okHttpClient, "okHttpClient");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(abstractC13778go12, "dispatcherDefault");
        AbstractC13042fc3.i(enumC4543Fo6, "sendType");
        AbstractC13042fc3.i(interfaceC14603iB2, "onSendEvent");
        AbstractC13042fc3.i(interfaceC4557Fq2, "configurationFLow");
        AbstractC13042fc3.i(ua2, "videoEditedInfoProducer");
        this.K = abstractC13778go12;
        this.L = ua2;
        this.M = "CompressAndUploadTask(" + AbstractC24249yI3.a(Long.valueOf(j)) + ")_(" + AbstractC24249yI3.a(Long.valueOf(j2)) + Separators.RPAREN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 Q0(File file, ir.nasim.tgwidgets.editor.messenger.H h2) {
        return AbstractC6459Nq2.q(AbstractC6459Nq2.V(AbstractC6459Nq2.x(AbstractC6459Nq2.f(new c(h2, file, this, null)), new C25226zw5() { // from class: ir.nasim.oc1.d
            @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
            public Object get(Object obj) {
                return Long.valueOf(((b) obj).c());
            }
        }), this.K));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object R0(WG7 wg7, ir.nasim.tgwidgets.editor.messenger.H h2, InterfaceC16756lo6 interfaceC16756lo6, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new f(h2, interfaceC16756lo6, wg7, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S0(int r5, int r6, int r7, ir.nasim.InterfaceC17551n93 r8, ir.nasim.WG7 r9, ir.nasim.InterfaceC16756lo6 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r4 = this;
            boolean r0 = r11 instanceof ir.nasim.C18404oc1.h
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.oc1$h r0 = (ir.nasim.C18404oc1.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.oc1$h r0 = new ir.nasim.oc1$h
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r11)
            goto L5c
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.Zk2 r8 = r8.O0(r5, r6)
            if (r8 == 0) goto L61
            int r11 = r8.b()
            if (r11 == r6) goto L41
            goto L61
        L41:
            ir.nasim.IT0 r11 = new ir.nasim.IT0
            byte[] r8 = r8.a()
            int r9 = r9.g()
            int r6 = r6 + r5
            ir.nasim.ya3 r5 = ir.nasim.AbstractC21867uG5.y(r5, r6)
            r11.<init>(r7, r8, r9, r5)
            r0.c = r3
            java.lang.Object r5 = r10.o(r11, r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r3)
            return r5
        L61:
            ir.nasim.Zm4 r5 = r4.a()
        L65:
            java.lang.Object r6 = r5.getValue()
            r7 = r6
            ir.nasim.xH7 r7 = (ir.nasim.InterfaceC23654xH7) r7
            ir.nasim.xH7$a r7 = new ir.nasim.xH7$a
            ir.nasim.ZG7$e r9 = new ir.nasim.ZG7$e
            java.io.IOException r10 = new java.io.IOException
            if (r8 != 0) goto L77
            java.lang.String r11 = "Failed to read from input stream, the returned chunk was null."
            goto L79
        L77:
            java.lang.String r11 = "Failed to read from input stream."
        L79:
            r10.<init>(r11)
            r9.<init>(r10)
            r7.<init>(r9)
            boolean r6 = r5.f(r6, r7)
            if (r6 == 0) goto L65
            r5 = 0
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18404oc1.S0(int, int, int, ir.nasim.n93, ir.nasim.WG7, ir.nasim.lo6, ir.nasim.rm1):java.lang.Object");
    }

    private final Object T0(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file = null;
            }
            if (file != null) {
                return Boolean.valueOf(file.delete());
            }
            return null;
        } catch (Exception unused) {
            return C19938rB7.a;
        }
    }

    @Override // ir.nasim.C7737Sz4
    protected Request M(JH7 jh7, WG7 wg7) {
        AbstractC13042fc3.i(jh7, "uploadType");
        AbstractC13042fc3.i(wg7, "uploadConfig");
        if (!(jh7 instanceof JH7.b) || this.N == null) {
            return super.M(jh7, wg7);
        }
        int iD = AbstractC20723sV3.d((float) Math.ceil(a0() / wg7.c()));
        Request.Builder builderNewBuilder = super.M(jh7, wg7).newBuilder();
        C7737Sz4.C7738a c7738a = C7737Sz4.H;
        return builderNewBuilder.removeHeader(c7738a.a()).addHeader(c7738a.a(), String.valueOf(iD)).addHeader("override-size", String.valueOf(a0())).build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C7737Sz4
    public InterfaceC24823zG1 T(WG7 wg7, JH7.b bVar, InterfaceC16756lo6 interfaceC16756lo6) {
        AbstractC13042fc3.i(wg7, "uploadConfig");
        AbstractC13042fc3.i(bVar, "uploadType");
        AbstractC13042fc3.i(interfaceC16756lo6, "producerChannel");
        return AbstractC10533bm0.b(U(), null, null, new e(wg7, bVar, interfaceC16756lo6, null), 3, null);
    }

    @Override // ir.nasim.C7737Sz4
    protected InterfaceC3346Am2 Y(WG7 wg7) {
        InterfaceC3346Am2 interfaceC3346Am2Y = super.Y(wg7);
        if (interfaceC3346Am2Y == null) {
            return null;
        }
        this.N = (ir.nasim.tgwidgets.editor.messenger.H) this.L.invoke(interfaceC3346Am2Y.getDescriptor());
        C19406qI3.a(e0(), "videoEditInfo: " + this.N, new Object[0]);
        return new g(interfaceC3346Am2Y, this);
    }

    @Override // ir.nasim.C7737Sz4
    protected int a0() {
        ir.nasim.tgwidgets.editor.messenger.H h2 = this.N;
        return h2 != null ? (int) h2.p : super.a0();
    }

    @Override // ir.nasim.C7737Sz4
    protected String e0() {
        return this.M;
    }

    @Override // ir.nasim.C7737Sz4, ir.nasim.VH7
    public InterfaceC13730gj3 i(boolean z) {
        InterfaceC13730gj3 interfaceC13730gj3I = super.i(z);
        String str = this.O;
        if (str != null) {
            T0(str);
        }
        this.N = null;
        return interfaceC13730gj3I;
    }

    @Override // ir.nasim.C7737Sz4
    protected void l0(InterfaceC23654xH7.c cVar) {
        AbstractC13042fc3.i(cVar, "state");
        String str = this.O;
        if (str != null) {
            if (!new File(str).exists()) {
                str = null;
            }
            if (str != null) {
                T0(cVar.d().getDescriptor());
                super.l0(InterfaceC23654xH7.c.b(cVar, 0L, new C9115Yo(str), 1, null));
                return;
            }
        }
        super.l0(cVar);
    }

    @Override // ir.nasim.C7737Sz4
    protected void s0() {
        super.s0();
        String str = this.O;
        if (str != null) {
            T0(str);
        }
    }

    @Override // ir.nasim.C7737Sz4
    protected Object t0(JH7 jh7, InterfaceC20295rm1 interfaceC20295rm1) {
        if (this.N == null) {
            return super.t0(jh7, interfaceC20295rm1);
        }
        InterfaceC12532em2 interfaceC12532em2Z = Z();
        ExPeer exPeerW = W();
        return interfaceC12532em2Z.h(1, jh7.a(), f0(), X(), C6906Pm2.o(V()), exPeerW, c0(), interfaceC20295rm1);
    }

    @Override // ir.nasim.C7737Sz4
    protected Object v0(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return C19938rB7.a;
    }

    @Override // ir.nasim.C7737Sz4
    protected Object x0(WG7 wg7, InterfaceC20295rm1 interfaceC20295rm1) {
        int iG = wg7.g();
        ArrayList arrayList = new ArrayList(iG);
        for (int i = 0; i < iG; i++) {
            arrayList.add(AbstractC6392Nk0.d(i));
        }
        Object objX0 = super.x0(wg7.a((38 & 1) != 0 ? wg7.a : 0L, (38 & 2) != 0 ? wg7.b : 0, (38 & 4) != 0 ? wg7.c : 0, (38 & 8) != 0 ? wg7.d : null, (38 & 16) != 0 ? wg7.e : null, (38 & 32) != 0 ? wg7.f : arrayList), interfaceC20295rm1);
        return objX0 == AbstractC14862ic3.e() ? objX0 : C19938rB7.a;
    }
}
