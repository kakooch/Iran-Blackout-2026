package ir.nasim;

import android.net.Uri;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.source.BundledExtractorsAdapter;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.cache.a;
import ir.nasim.C11840de2;
import ir.nasim.core.modules.settings.SettingsModule;
import java.io.IOException;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.de2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11840de2 {
    private static final b g = new b(null);
    public static final int h = 8;
    private static final InterfaceC10465bf2 i = new a();
    private final PF2 a;
    private final InterfaceC20315ro1 b;
    private final a.c c;
    private final AbstractC13778go1 d;
    private final SettingsModule e;
    private final IT7 f;

    /* renamed from: ir.nasim.de2$b */
    private static final class b {
        private b() {
        }

        public final InterfaceC10465bf2 a() {
            return C11840de2.i;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.de2$c */
    public interface c {
        C11840de2 a(InterfaceC20315ro1 interfaceC20315ro1);
    }

    /* renamed from: ir.nasim.de2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;

        /* renamed from: ir.nasim.de2$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C11840de2 d;
            final /* synthetic */ long e;
            final /* synthetic */ long f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C11840de2 c11840de2, long j, long j2, long j3, long j4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c11840de2;
                this.e = j;
                this.f = j2;
                this.g = j3;
                this.h = j4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final com.google.android.exoplayer2.upstream.a y(C11840de2 c11840de2) {
                com.google.android.exoplayer2.upstream.cache.a aVarA = c11840de2.c.a();
                AbstractC13042fc3.h(aVarA, "createDataSource(...)");
                return aVarA;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Uri uri = Uri.parse((String) this.c);
                    C11840de2 c11840de2 = this.d;
                    AbstractC13042fc3.f(uri);
                    final C11840de2 c11840de22 = this.d;
                    SA2 sa2 = new SA2() { // from class: ir.nasim.ee2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C11840de2.d.a.y(c11840de22);
                        }
                    };
                    String strA = this.d.f.a(this.e, this.f);
                    long j = this.g;
                    long j2 = this.h;
                    this.b = 1;
                    if (c11840de2.l(uri, sa2, strA, j, j2, this) == objE) {
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
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.de2$d$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.de2$d$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.de2$d$b$a$a, reason: collision with other inner class name */
                public static final class C1018a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1018a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.C11840de2.d.b.a.C1018a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.de2$d$b$a$a r0 = (ir.nasim.C11840de2.d.b.a.C1018a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.de2$d$b$a$a r0 = new ir.nasim.de2$d$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L51
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        java.lang.String r2 = (java.lang.String) r2
                        if (r2 == 0) goto L44
                        boolean r2 = ir.nasim.AbstractC14836iZ6.n0(r2)
                        if (r2 == 0) goto L42
                        goto L44
                    L42:
                        r2 = 0
                        goto L45
                    L44:
                        r2 = r3
                    L45:
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L51
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L51
                        return r1
                    L51:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11840de2.d.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, long j2, long j3, long j4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11840de2.this.new d(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    b bVar = new b(C11840de2.this.a.i(this.d, this.e));
                    a aVar = new a(C11840de2.this, this.d, this.e, this.f, this.g, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
            } catch (CancellationException e) {
                Log.d("ExoPreloadUseCase", "Preloading coroutine was cancelled.");
                throw e;
            } catch (Exception e2) {
                Log.e("ExoPreloadUseCase", "Error during preloading: " + e2);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.de2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Uri d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ InterfaceC10465bf2 g;
        final /* synthetic */ com.google.android.exoplayer2.upstream.a h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Uri uri, long j, long j2, InterfaceC10465bf2 interfaceC10465bf2, com.google.android.exoplayer2.upstream.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = uri;
            this.e = j;
            this.f = j2;
            this.g = interfaceC10465bf2;
            this.h = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int y(com.google.android.exoplayer2.upstream.a aVar, byte[] bArr, int i, int i2) {
            return aVar.read(bArr, i, i2);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws UnrecognizedInputFormatException {
            Object objD;
            int iB;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            BundledExtractorsAdapter bundledExtractorsAdapter = new BundledExtractorsAdapter(new UD1());
            final com.google.android.exoplayer2.upstream.a aVar = this.h;
            bundledExtractorsAdapter.c(new InterfaceC18631oz1() { // from class: ir.nasim.fe2
                @Override // ir.nasim.InterfaceC18631oz1
                public final int read(byte[] bArr, int i, int i2) {
                    return C11840de2.e.y(aVar, bArr, i, i2);
                }
            }, this.d, AbstractC20051rO3.k(), this.e, this.f, this.g);
            C8292Vi5 c8292Vi5 = new C8292Vi5();
            c8292Vi5.a = this.e;
            try {
                try {
                    try {
                        bundledExtractorsAdapter.a(0L, 100L);
                        do {
                            AbstractC20906so1.f(interfaceC20315ro1);
                            iB = bundledExtractorsAdapter.b(c8292Vi5);
                            if (iB == -1) {
                                break;
                            }
                        } while (iB != 1);
                        objD = C19938rB7.a;
                    } catch (Exception e) {
                        objD = AbstractC6392Nk0.d(Log.e("ExoPreloadUseCase", "Error during preload reading: " + e));
                    }
                    return objD;
                } catch (CancellationException e2) {
                    Log.d("ExoPreloadUseCase", "Preload operation was cancelled during reading.");
                    throw e2;
                }
            } finally {
                bundledExtractorsAdapter.release();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.de2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Uri c;
        final /* synthetic */ String d;
        final /* synthetic */ C11840de2 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ long g;

        /* renamed from: ir.nasim.de2$f$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C11840de2 d;
            final /* synthetic */ Uri e;
            final /* synthetic */ long f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C11840de2 c11840de2, Uri uri, long j, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c11840de2;
                this.e = uri;
                this.f = j;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    com.google.android.exoplayer2.upstream.a aVar = (com.google.android.exoplayer2.upstream.a) this.c;
                    C11840de2 c11840de2 = this.d;
                    InterfaceC10465bf2 interfaceC10465bf2A = C11840de2.g.a();
                    Uri uri = this.e;
                    long j = this.f;
                    this.b = 1;
                    if (c11840de2.m(aVar, interfaceC10465bf2A, uri, j, this) == objE) {
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
            public final Object invoke(com.google.android.exoplayer2.upstream.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Uri uri, String str, C11840de2 c11840de2, SA2 sa2, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = uri;
            this.d = str;
            this.e = c11840de2;
            this.f = sa2;
            this.g = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                com.google.android.exoplayer2.upstream.b bVarA = new b.C0164b().i(this.c).f(this.d).g(this.e.e.V1()).b(4).a();
                AbstractC13042fc3.h(bVarA, "build(...)");
                C11840de2 c11840de2 = this.e;
                SA2 sa2 = this.f;
                a aVar = new a(c11840de2, this.c, this.g, null);
                this.b = 1;
                obj = c11840de2.n(sa2, bVarA, aVar, this);
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.de2$g */
    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C11840de2.this.m(null, null, null, 0L, this);
        }
    }

    /* renamed from: ir.nasim.de2$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ com.google.android.exoplayer2.upstream.b e;
        final /* synthetic */ InterfaceC14603iB2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(SA2 sa2, com.google.android.exoplayer2.upstream.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sa2;
            this.e = bVar;
            this.f = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.d, this.e, this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.exoplayer2.upstream.a] */
        /* JADX WARN: Type inference failed for: r0v5 */
        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.google.android.exoplayer2.upstream.a aVar;
            Exception e;
            CancellationException e2;
            IOException e3;
            UnrecognizedInputFormatException e4;
            Object objD;
            StringBuilder sb;
            ?? E = AbstractC14862ic3.e();
            int i = this.c;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    com.google.android.exoplayer2.upstream.a aVar2 = (com.google.android.exoplayer2.upstream.a) this.d.invoke();
                    try {
                        aVar2.b(this.e);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.f;
                        this.b = aVar2;
                        this.c = 1;
                        if (interfaceC14603iB2.invoke(aVar2, this) == E) {
                            return E;
                        }
                        aVar = aVar2;
                    } catch (UnrecognizedInputFormatException e5) {
                        aVar = aVar2;
                        e4 = e5;
                        objD = AbstractC6392Nk0.d(Log.e("ExoPreloadUseCase", "Unrecognized input format during preloading: " + e4));
                        aVar.close();
                        return objD;
                    } catch (IOException e6) {
                        aVar = aVar2;
                        e3 = e6;
                        objD = AbstractC6392Nk0.d(Log.e("ExoPreloadUseCase", "I/O error during preloading: " + e3));
                        aVar.close();
                        return objD;
                    } catch (CancellationException e7) {
                        e2 = e7;
                        Log.d("ExoPreloadUseCase", "Preloading cancelled.");
                        throw e2;
                    } catch (Exception e8) {
                        aVar = aVar2;
                        e = e8;
                        objD = AbstractC6392Nk0.d(Log.e("ExoPreloadUseCase", "Exception while preloading: " + e));
                        aVar.close();
                        return objD;
                    } catch (Throwable th) {
                        E = aVar2;
                        th = th;
                        try {
                            E.close();
                        } catch (IOException e9) {
                            Log.e("ExoPreloadUseCase", "Error closing DataSource: " + e9);
                        }
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (com.google.android.exoplayer2.upstream.a) this.b;
                    try {
                        AbstractC10685c16.b(obj);
                    } catch (UnrecognizedInputFormatException e10) {
                        e4 = e10;
                        objD = AbstractC6392Nk0.d(Log.e("ExoPreloadUseCase", "Unrecognized input format during preloading: " + e4));
                        try {
                            aVar.close();
                        } catch (IOException e11) {
                            e = e11;
                            sb = new StringBuilder();
                            sb.append("Error closing DataSource: ");
                            sb.append(e);
                            Log.e("ExoPreloadUseCase", sb.toString());
                            return objD;
                        }
                        return objD;
                    } catch (IOException e12) {
                        e3 = e12;
                        objD = AbstractC6392Nk0.d(Log.e("ExoPreloadUseCase", "I/O error during preloading: " + e3));
                        try {
                            aVar.close();
                        } catch (IOException e13) {
                            e = e13;
                            sb = new StringBuilder();
                            sb.append("Error closing DataSource: ");
                            sb.append(e);
                            Log.e("ExoPreloadUseCase", sb.toString());
                            return objD;
                        }
                        return objD;
                    } catch (CancellationException e14) {
                        e2 = e14;
                        Log.d("ExoPreloadUseCase", "Preloading cancelled.");
                        throw e2;
                    } catch (Exception e15) {
                        e = e15;
                        objD = AbstractC6392Nk0.d(Log.e("ExoPreloadUseCase", "Exception while preloading: " + e));
                        try {
                            aVar.close();
                        } catch (IOException e16) {
                            e = e16;
                            sb = new StringBuilder();
                            sb.append("Error closing DataSource: ");
                            sb.append(e);
                            Log.e("ExoPreloadUseCase", sb.toString());
                            return objD;
                        }
                        return objD;
                    }
                }
                objD = C19938rB7.a;
                try {
                    aVar.close();
                } catch (IOException e17) {
                    e = e17;
                    sb = new StringBuilder();
                    sb.append("Error closing DataSource: ");
                    sb.append(e);
                    Log.e("ExoPreloadUseCase", sb.toString());
                    return objD;
                }
                return objD;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C11840de2(PF2 pf2, InterfaceC20315ro1 interfaceC20315ro1, a.c cVar, AbstractC13778go1 abstractC13778go1, SettingsModule settingsModule, IT7 it7) {
        AbstractC13042fc3.i(pf2, "getDownloadUrlUseCase");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(cVar, "cacheDataSourceFactory");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(it7, "cacheIdGenerator");
        this.a = pf2;
        this.b = interfaceC20315ro1;
        this.c = cVar;
        this.d = abstractC13778go1;
        this.e = settingsModule;
        this.f = it7;
    }

    private final Object k(com.google.android.exoplayer2.upstream.a aVar, InterfaceC10465bf2 interfaceC10465bf2, Uri uri, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.d, new e(uri, j, j2, interfaceC10465bf2, aVar, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(Uri uri, SA2 sa2, String str, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC3860Cq7.c(j2, new f(uri, str, this, sa2, j, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(com.google.android.exoplayer2.upstream.a r13, ir.nasim.InterfaceC10465bf2 r14, android.net.Uri r15, long r16, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            r12 = this;
            r0 = r18
            boolean r1 = r0 instanceof ir.nasim.C11840de2.g
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.de2$g r1 = (ir.nasim.C11840de2.g) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
            r11 = r12
        L15:
            r10 = r1
            goto L1e
        L17:
            ir.nasim.de2$g r1 = new ir.nasim.de2$g
            r11 = r12
            r1.<init>(r0)
            goto L15
        L1e:
            java.lang.Object r0 = r10.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r10.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r0)
            goto L4b
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            ir.nasim.AbstractC10685c16.b(r0)
            r10.c = r3
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r8 = r16
            java.lang.Object r0 = r2.k(r3, r4, r5, r6, r8, r10)
            if (r0 != r1) goto L4b
            return r1
        L4b:
            java.lang.String r0 = "ExoPreloadUseCase"
            java.lang.String r1 = "Preload start success"
            android.util.Log.d(r0, r1)
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11840de2.m(com.google.android.exoplayer2.upstream.a, ir.nasim.bf2, android.net.Uri, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(SA2 sa2, com.google.android.exoplayer2.upstream.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.d, new h(sa2, bVar, interfaceC14603iB2, null), interfaceC20295rm1);
    }

    public final InterfaceC13730gj3 j(long j, long j2, long j3, long j4) {
        return AbstractC10533bm0.d(this.b, this.d, null, new d(j, j2, j3, j4, null), 2, null);
    }

    /* renamed from: ir.nasim.de2$a */
    public static final class a implements InterfaceC10465bf2 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10465bf2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public P12 b(int i, int i2) {
            return new P12();
        }

        @Override // ir.nasim.InterfaceC10465bf2
        public void o(InterfaceC22148uk6 interfaceC22148uk6) {
            AbstractC13042fc3.i(interfaceC22148uk6, "seekMap");
        }

        @Override // ir.nasim.InterfaceC10465bf2
        public void s() {
        }
    }
}
