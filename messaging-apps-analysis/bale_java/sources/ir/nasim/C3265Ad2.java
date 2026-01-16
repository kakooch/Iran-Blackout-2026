package ir.nasim;

import android.net.Uri;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.cache.a;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14371ho1;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.Ad2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3265Ad2 implements ZY1, InterfaceC10995cZ1 {
    private static final a l = new a(null);
    public static final int m = 8;
    private final FileReference a;
    private final C9528a7 b;
    private final IT7 c;
    private final a.c d;
    private final InterfaceC15796kB2 e;
    private InterfaceC13730gj3 f;
    private InterfaceC13730gj3 g;
    private C17416mv5 h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC20315ro1 k;

    /* renamed from: ir.nasim.Ad2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ad2$b */
    public static final class b extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ C3265Ad2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC14371ho1.a aVar, C3265Ad2 c3265Ad2) {
            super(aVar);
            this.b = c3265Ad2;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            Object value;
            C19406qI3.b("ExoDownloadTask", "download failed with: \n " + th);
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.b.i;
            do {
                value = interfaceC9336Zm4.getValue();
                C9475a16.a aVar = C9475a16.b;
            } while (!interfaceC9336Zm4.f(value, C9475a16.a(C9475a16.b(AbstractC10685c16.a(th)))));
        }
    }

    /* renamed from: ir.nasim.Ad2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3265Ad2.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            String str;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long fileId = C3265Ad2.this.a.getFileId();
                long accessHash = C3265Ad2.this.a.getAccessHash();
                String strA = C3265Ad2.this.c.a(fileId, accessHash);
                com.google.android.exoplayer2.upstream.b bVarA = new b.C0164b().j("").f(strA).b(4).a();
                AbstractC13042fc3.h(bVarA, "build(...)");
                long jC = DD6.c().c(strA, bVarA.g, bVarA.h);
                C19406qI3.a("ExoDownloadTask", "downloadedBytes: " + jC, new Object[0]);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C3265Ad2.this.i;
                C3265Ad2 c3265Ad2 = C3265Ad2.this;
                do {
                    value = interfaceC9336Zm4.getValue();
                    C9475a16.a aVar = C9475a16.b;
                } while (!interfaceC9336Zm4.f(value, C9475a16.a(C9475a16.b(AbstractC6392Nk0.c(jC / c3265Ad2.a.getFileSize())))));
                C3265Ad2 c3265Ad22 = C3265Ad2.this;
                c3265Ad22.g = c3265Ad22.n();
                InterfaceC15796kB2 interfaceC15796kB2 = C3265Ad2.this.e;
                Long lE = AbstractC6392Nk0.e(fileId);
                Long lE2 = AbstractC6392Nk0.e(accessHash);
                this.b = strA;
                this.c = 1;
                Object objQ = interfaceC15796kB2.q(lE, lE2, this);
                if (objQ == objE) {
                    return objE;
                }
                str = strA;
                obj = objQ;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.b;
                AbstractC10685c16.b(obj);
            }
            String str2 = (String) obj;
            if (str2 == null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = C3265Ad2.this.i;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                    C9475a16.a aVar2 = C9475a16.b;
                } while (!interfaceC9336Zm42.f(value2, C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("Failed to download url."))))));
                return C19938rB7.a;
            }
            C2018a0 c2018a0A = new C2018a0.c().j(Uri.parse(str2)).b(str).a();
            AbstractC13042fc3.h(c2018a0A, "build(...)");
            C17416mv5 c17416mv5 = new C17416mv5(c2018a0A, C3265Ad2.this.d);
            C3265Ad2.this.h = c17416mv5;
            c17416mv5.d(C3265Ad2.this);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ad2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Ad2$d$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C3265Ad2 a;

            a(C3265Ad2 c3265Ad2) {
                this.a = c3265Ad2;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C9475a16 c9475a16 = (C9475a16) obj;
                C19406qI3.a("ExoDownloadTask", "result: " + C9475a16.k(c9475a16.l()), new Object[0]);
                Object objL = c9475a16.l();
                C3265Ad2 c3265Ad2 = this.a;
                if (C9475a16.j(objL)) {
                    float fFloatValue = ((Number) objL).floatValue();
                    if (fFloatValue >= 1.0f) {
                        c3265Ad2.b.d(new C13488gJ4(c3265Ad2.a.getFileId(), new C9115Yo("")));
                    } else {
                        c3265Ad2.b.d(new C12870fJ4(c3265Ad2.a.getFileId(), fFloatValue));
                    }
                }
                C3265Ad2 c3265Ad22 = this.a;
                Throwable thE = C9475a16.e(objL);
                if (thE != null) {
                    c3265Ad22.b.d(new C14079hJ4(c3265Ad22.a.getFileId(), new Exception(thE)));
                }
                Object objB = HG1.b(60L, interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3265Ad2.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2Q = AbstractC6459Nq2.q(AbstractC6459Nq2.F(C3265Ad2.this.i));
                a aVar = new a(C3265Ad2.this);
                this.b = 1;
                if (interfaceC4557Fq2Q.b(aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C3265Ad2(FileReference fileReference, C9528a7 c9528a7, IT7 it7, a.c cVar, InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        AbstractC13042fc3.i(c9528a7, "manager");
        AbstractC13042fc3.i(it7, "cacheIdGenerator");
        AbstractC13042fc3.i(cVar, "cacheDataSourceFactory");
        AbstractC13042fc3.i(interfaceC15796kB2, "urlDownloader");
        this.a = fileReference;
        this.b = c9528a7;
        this.c = it7;
        this.d = cVar;
        this.e = interfaceC15796kB2;
        this.i = AbstractC12281eL6.a(null);
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.zd2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3265Ad2.l(this.a);
            }
        });
        this.k = AbstractC20906so1.a(P17.b(null, 1, null).X(m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC14371ho1 l(C3265Ad2 c3265Ad2) {
        AbstractC13042fc3.i(c3265Ad2, "this$0");
        return new b(InterfaceC14371ho1.h0, c3265Ad2);
    }

    private final InterfaceC14371ho1 m() {
        return (InterfaceC14371ho1) this.j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 n() {
        return AbstractC10533bm0.d(this.k, C12366eV1.b(), null, new d(null), 2, null);
    }

    @Override // ir.nasim.InterfaceC10995cZ1
    public void a(long j, long j2, float f) {
        Object value;
        Object value2;
        C19406qI3.a("ExoDownloadTask", j + ", " + j2 + ", " + f, new Object[0]);
        if (j == -1) {
            return;
        }
        float f2 = j == j2 ? 1.0f : j == -1 ? 0.0f : f / 100.0f;
        try {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
            do {
                value2 = interfaceC9336Zm4.getValue();
                C9475a16.a aVar = C9475a16.b;
            } while (!interfaceC9336Zm4.f(value2, C9475a16.a(C9475a16.b(Float.valueOf(f2)))));
        } catch (Exception e) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.i;
            do {
                value = interfaceC9336Zm42.getValue();
                C9475a16.a aVar2 = C9475a16.b;
            } while (!interfaceC9336Zm42.f(value, C9475a16.a(C9475a16.b(AbstractC10685c16.a(e)))));
        }
    }

    @Override // ir.nasim.ZY1
    public void cancel() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
        InterfaceC13730gj3 interfaceC13730gj3 = this.g;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.g = null;
        C17416mv5 c17416mv5 = this.h;
        if (c17416mv5 != null) {
            c17416mv5.c();
        }
        this.h = null;
        InterfaceC13730gj3 interfaceC13730gj32 = this.f;
        if (interfaceC13730gj32 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj32, null, 1, null);
        }
        this.f = null;
    }

    @Override // ir.nasim.ZY1
    public void start() {
        if (this.f != null) {
            return;
        }
        this.f = AbstractC10533bm0.d(this.k, null, null, new c(null), 3, null);
    }
}
