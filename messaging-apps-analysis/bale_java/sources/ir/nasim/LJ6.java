package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9785aZ1;
import ir.nasim.EX1;
import ir.nasim.InterfaceC19096pm2;
import ir.nasim.InterfaceC23350wm2;
import ir.nasim.LJ6;
import ir.nasim.MX1;
import ir.nasim.NT0;
import ir.nasim.OY1;
import ir.nasim.SY1;
import ir.nasim.file.download.model.exception.DownloadErrorException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class LJ6 implements InterfaceC11759dZ1 {
    private static final a k = new a(null);
    private final AbstractC13778go1 a;
    private final InterfaceC20315ro1 b;
    private final InterfaceC20887sm2 c;
    private final InterfaceC17089mN5 d;
    private final KT0 e;
    private final NT0.b f;
    private final C9785aZ1.d g;
    private final InterfaceC14123hO3 h;
    private final PG3 i;
    private final InterfaceC23282wf4 j;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        LJ6 a(KT0 kt0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c {
        private static final a m = new a(null);
        private final String a;
        private final String b;
        private final InterfaceC20315ro1 c;
        private OY1 d;
        private final InterfaceC23940xm2 e;
        private final InterfaceC16756lo6 f;
        private final NT0 g;
        private final InterfaceC17089mN5 h;
        private BX1 i;
        private final UA2 j;
        private final C23270we2 k;
        private InterfaceC13730gj3 l;

        private static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        static final class b extends AbstractC22163um1 {
            Object a;
            Object b;
            /* synthetic */ Object c;
            int e;

            b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.c = obj;
                this.e |= RecyclerView.UNDEFINED_DURATION;
                return c.this.h(null, this);
            }
        }

        /* renamed from: ir.nasim.LJ6$c$c, reason: collision with other inner class name */
        static final class C0477c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            private /* synthetic */ Object d;

            C0477c(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0477c c0477c = c.this.new C0477c(interfaceC20295rm1);
                c0477c.d = obj;
                return c0477c;
            }

            /* JADX WARN: Code restructure failed: missing block: B:34:0x014e, code lost:
            
                if (ir.nasim.AbstractC20906so1.g(r10) != false) goto L15;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0114 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0148 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0149  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0149 -> B:33:0x014a). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    Method dump skipped, instructions count: 339
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LJ6.c.C0477c.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0477c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class d extends AbstractC22163um1 {
            Object a;
            Object b;
            Object c;
            int d;
            /* synthetic */ Object e;
            int g;

            d(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.e = obj;
                this.g |= RecyclerView.UNDEFINED_DURATION;
                return c.this.n(null, null, 0, this);
            }
        }

        public c(String str, String str2, InterfaceC20315ro1 interfaceC20315ro1, OY1 oy1, InterfaceC23940xm2 interfaceC23940xm2, InterfaceC16756lo6 interfaceC16756lo6, NT0 nt0, InterfaceC17089mN5 interfaceC17089mN5, BX1 bx1, UA2 ua2) {
            AbstractC13042fc3.i(str, ParameterNames.TAG);
            AbstractC13042fc3.i(str2, "fileUrl");
            AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
            AbstractC13042fc3.i(oy1, "retryPolicy");
            AbstractC13042fc3.i(interfaceC23940xm2, "fileSystemOutput");
            AbstractC13042fc3.i(interfaceC16756lo6, "progressChannel");
            AbstractC13042fc3.i(nt0, "chunkRangeGenerator");
            AbstractC13042fc3.i(interfaceC17089mN5, "remoteDownloadDataSource");
            AbstractC13042fc3.i(bx1, "currentChunkSize");
            AbstractC13042fc3.i(ua2, "onWorkerClosed");
            this.a = str;
            this.b = str2;
            this.c = interfaceC20315ro1;
            this.d = oy1;
            this.e = interfaceC23940xm2;
            this.f = interfaceC16756lo6;
            this.g = nt0;
            this.h = interfaceC17089mN5;
            this.i = bx1;
            this.j = ua2;
            this.k = new C23270we2(0L, 0L, 0.0d, 0.0f, 15, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00e3 -> B:22:0x0072). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0118 -> B:45:0x011b). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object h(ir.nasim.AX1 r18, ir.nasim.InterfaceC20295rm1 r19) throws ir.nasim.file.download.model.exception.DownloadErrorException {
            /*
                Method dump skipped, instructions count: 340
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LJ6.c.h(ir.nasim.AX1, ir.nasim.rm1):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 m(c cVar, Throwable th) {
            AbstractC13042fc3.i(cVar, "this$0");
            cVar.j.invoke(cVar);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0060 -> B:19:0x0064). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object n(byte[] r12, ir.nasim.AX1 r13, int r14, ir.nasim.InterfaceC20295rm1 r15) throws ir.nasim.file.download.model.exception.DownloadErrorException {
            /*
                Method dump skipped, instructions count: 229
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LJ6.c.n(byte[], ir.nasim.AX1, int, ir.nasim.rm1):java.lang.Object");
        }

        static /* synthetic */ Object o(c cVar, byte[] bArr, AX1 ax1, int i, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 3;
            }
            return cVar.n(bArr, ax1, i, interfaceC20295rm1);
        }

        public final void g() {
            this.d = OY1.b.a;
        }

        public final BX1 i() {
            return this.i;
        }

        public final InterfaceC13730gj3 j() {
            return this.l;
        }

        public final void k(BX1 bx1) {
            AbstractC13042fc3.i(bx1, "<set-?>");
            this.i = bx1;
        }

        public final void l() {
            InterfaceC13730gj3 interfaceC13730gj3 = this.l;
            if (interfaceC13730gj3 == null || !interfaceC13730gj3.b()) {
                InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(this.c, null, null, new C0477c(null), 3, null);
                interfaceC13730gj3D.s(new UA2() { // from class: ir.nasim.MJ6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return LJ6.c.m(this.a, (Throwable) obj);
                    }
                });
                this.l = interfaceC13730gj3D;
            }
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ MX1.a g;
        final /* synthetic */ C9785aZ1 h;
        final /* synthetic */ FY1 i;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ InterfaceC23940xm2 d;
            final /* synthetic */ NT0 e;
            final /* synthetic */ LJ6 f;
            final /* synthetic */ MX1.a g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC23940xm2 interfaceC23940xm2, NT0 nt0, LJ6 lj6, MX1.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC23940xm2;
                this.e = nt0;
                this.f = lj6;
                this.g = aVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r5.c
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L29
                    if (r1 == r4) goto L25
                    if (r1 == r3) goto L21
                    if (r1 != r2) goto L19
                    java.lang.Object r0 = r5.b
                    ir.nasim.qD7 r0 = (ir.nasim.InterfaceC19365qD7) r0
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L58
                L19:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L21:
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L42
                L25:
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L37
                L29:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.xm2 r6 = r5.d
                    r5.c = r4
                    java.lang.Object r6 = r6.a(r5)
                    if (r6 != r0) goto L37
                    return r0
                L37:
                    ir.nasim.NT0 r6 = r5.e
                    r5.c = r3
                    java.lang.Object r6 = r6.b(r5)
                    if (r6 != r0) goto L42
                    return r0
                L42:
                    ir.nasim.qD7 r6 = (ir.nasim.InterfaceC19365qD7) r6
                    ir.nasim.LJ6 r1 = r5.f
                    ir.nasim.PG3 r1 = ir.nasim.LJ6.g(r1)
                    ir.nasim.MX1$a r3 = r5.g
                    r5.b = r6
                    r5.c = r2
                    java.lang.Object r1 = r1.f(r3, r6, r5)
                    if (r1 != r0) goto L57
                    return r0
                L57:
                    r0 = r6
                L58:
                    ir.nasim.LJ6 r6 = r5.f
                    ir.nasim.wf4 r6 = ir.nasim.LJ6.h(r6)
                    ir.nasim.MX1$a r1 = r5.g
                    r6.a(r1, r0)
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LJ6.d.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ LJ6 c;
            final /* synthetic */ MX1.a d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(LJ6 lj6, MX1.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = lj6;
                this.d = aVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    PG3 pg3 = this.c.i;
                    C4995Hl2 c4995Hl2C = this.d.c();
                    this.b = 1;
                    obj = pg3.b(c4995Hl2C, this);
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(MX1.a aVar, C9785aZ1 c9785aZ1, FY1 fy1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = aVar;
            this.h = c9785aZ1;
            this.i = fy1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(LJ6 lj6, InterfaceC23940xm2 interfaceC23940xm2, NT0 nt0, MX1.a aVar) {
            AbstractC10533bm0.d(lj6.b, null, null, new a(interfaceC23940xm2, nt0, lj6, aVar, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = LJ6.this.new d(this.g, this.h, this.i, interfaceC20295rm1);
            dVar.e = obj;
            return dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0092 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00d3  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws ir.nasim.file.download.model.exception.DownloadErrorException {
            /*
                Method dump skipped, instructions count: 362
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LJ6.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ FY1 f;
        final /* synthetic */ C23270we2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(FY1 fy1, C23270we2 c23270we2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
            this.f = fy1;
            this.g = c23270we2;
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            return n((InterfaceC4806Gq2) obj, (Throwable) obj2, ((Number) obj3).longValue(), (InterfaceC20295rm1) obj4);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    return AbstractC6392Nk0.a(true);
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(false);
            }
            AbstractC10685c16.b(obj);
            InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
            Throwable th = (Throwable) this.d;
            EX1 eVar = (EX1) LJ6.this.h.a(th);
            if (eVar == null) {
                eVar = new EX1.e(th);
            }
            C19406qI3.c("StandardDownloader", "Download failed with exception(" + th.getClass().getSimpleName() + ") that is detected as error(" + eVar + Separators.RPAREN, th);
            if (eVar.a() && ((Boolean) this.f.a().a().invoke(eVar)).booleanValue()) {
                long jA = this.g.a();
                this.c = null;
                this.b = 1;
                if (HG1.b(jA, this) == objE) {
                    return objE;
                }
                return AbstractC6392Nk0.a(true);
            }
            SY1.c cVar = new SY1.c(eVar);
            this.c = null;
            this.b = 2;
            if (interfaceC4806Gq2.a(cVar, this) == objE) {
                return objE;
            }
            return AbstractC6392Nk0.a(false);
        }

        public final Object n(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = LJ6.this.new e(this.f, this.g, interfaceC20295rm1);
            eVar.c = interfaceC4806Gq2;
            eVar.d = th;
            return eVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                Throwable th = (Throwable) this.d;
                EX1 eVar = (EX1) LJ6.this.h.a(th);
                if (eVar == null) {
                    eVar = new EX1.e(th);
                }
                SY1.c cVar = new SY1.c(eVar);
                this.c = null;
                this.b = 1;
                if (interfaceC4806Gq2.a(cVar, this) == objE) {
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
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = LJ6.this.new f(interfaceC20295rm1);
            fVar.c = interfaceC4806Gq2;
            fVar.d = th;
            return fVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        int i;
        final /* synthetic */ VI5 j;
        final /* synthetic */ NT0 k;
        final /* synthetic */ LJ6 l;
        final /* synthetic */ MX1.a m;
        final /* synthetic */ InterfaceC16204ks5 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(VI5 vi5, NT0 nt0, LJ6 lj6, MX1.a aVar, InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.j = vi5;
            this.k = nt0;
            this.l = lj6;
            this.m = aVar;
            this.n = interfaceC16204ks5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.j, this.k, this.l, this.m, this.n, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00d4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00e7 A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:9:0x002f, B:28:0x00c0, B:32:0x00df, B:34:0x00e7, B:37:0x0102, B:54:0x0199, B:21:0x008a, B:24:0x00a9, B:27:0x00bc), top: B:65:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x011e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0131 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:41:0x0126, B:43:0x0131, B:47:0x016e, B:44:0x013f, B:46:0x0143, B:52:0x0193, B:53:0x0198, B:16:0x0066), top: B:63:0x0066 }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x013f A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:41:0x0126, B:43:0x0131, B:47:0x016e, B:44:0x013f, B:46:0x0143, B:52:0x0193, B:53:0x0198, B:16:0x0066), top: B:63:0x0066 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0184 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0199 A[Catch: all -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003e, blocks: (B:9:0x002f, B:28:0x00c0, B:32:0x00df, B:34:0x00e7, B:37:0x0102, B:54:0x0199, B:21:0x008a, B:24:0x00a9, B:27:0x00bc), top: B:65:0x000d }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0185 -> B:51:0x018e). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 424
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LJ6.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ MX1.a e;
        final /* synthetic */ FY1 f;
        final /* synthetic */ String g;
        final /* synthetic */ InterfaceC23940xm2 h;
        final /* synthetic */ InterfaceC16756lo6 i;
        final /* synthetic */ NT0 j;

        static final class a implements UA2 {
            final /* synthetic */ CopyOnWriteArrayList a;

            a(CopyOnWriteArrayList copyOnWriteArrayList) {
                this.a = copyOnWriteArrayList;
            }

            public final void a(c cVar) {
                AbstractC13042fc3.i(cVar, "it");
                cVar.g();
                this.a.remove(cVar);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((c) obj);
                return C19938rB7.a;
            }
        }

        public static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ CopyOnWriteArrayList d;
            final /* synthetic */ C11637dL5 e;
            final /* synthetic */ MX1.a f;
            final /* synthetic */ FY1 g;
            final /* synthetic */ LJ6 h;
            final /* synthetic */ String i;
            final /* synthetic */ InterfaceC20315ro1 j;
            final /* synthetic */ InterfaceC23940xm2 k;
            final /* synthetic */ InterfaceC16756lo6 l;
            final /* synthetic */ NT0 m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC20295rm1 interfaceC20295rm1, CopyOnWriteArrayList copyOnWriteArrayList, C11637dL5 c11637dL5, MX1.a aVar, FY1 fy1, LJ6 lj6, String str, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC23940xm2 interfaceC23940xm2, InterfaceC16756lo6 interfaceC16756lo6, NT0 nt0) {
                super(2, interfaceC20295rm1);
                this.d = copyOnWriteArrayList;
                this.e = c11637dL5;
                this.f = aVar;
                this.g = fy1;
                this.h = lj6;
                this.i = str;
                this.j = interfaceC20315ro1;
                this.k = interfaceC23940xm2;
                this.l = interfaceC16756lo6;
                this.m = nt0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(interfaceC20295rm1, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                JT0 jt0;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    JT0 jt02 = (JT0) this.c;
                    int iA = jt02.a();
                    if (iA < this.d.size()) {
                        int size = this.d.size() - iA;
                        for (int i2 = 0; i2 < size; i2++) {
                            c cVar = (c) AbstractC13610gX0.O(this.d);
                            if (cVar != null) {
                                cVar.g();
                            }
                        }
                    } else if (iA > this.d.size()) {
                        int size2 = iA - this.d.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            C11637dL5 c11637dL5 = this.e;
                            int i4 = c11637dL5.a + 1;
                            c11637dL5.a = i4;
                            c cVar2 = new c("Worker(" + i4 + ")(s:" + this.f.b() + Separators.RPAREN, this.i, this.j, this.g.a(), this.k, this.l, this.m, this.h.d, jt02.b(), new a(this.d));
                            cVar2.l();
                            this.d.add(cVar2);
                        }
                    }
                    Iterator it = this.d.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).k(jt02.b());
                    }
                    CopyOnWriteArrayList copyOnWriteArrayList = this.d;
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = copyOnWriteArrayList.iterator();
                    while (it2.hasNext()) {
                        InterfaceC13730gj3 interfaceC13730gj3J = ((c) it2.next()).j();
                        if (interfaceC13730gj3J != null) {
                            arrayList.add(interfaceC13730gj3J);
                        }
                    }
                    this.c = jt02;
                    this.b = 1;
                    if (AbstractC24549yo1.a(arrayList, this) == objE) {
                        return objE;
                    }
                    jt0 = jt02;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    jt0 = (JT0) this.c;
                    AbstractC10685c16.b(obj);
                }
                C19406qI3.g("StandardDownloader", "launchWorkers() called with: configuration = " + jt0 + " END", new Object[0]);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(obj, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(MX1.a aVar, FY1 fy1, String str, InterfaceC23940xm2 interfaceC23940xm2, InterfaceC16756lo6 interfaceC16756lo6, NT0 nt0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = aVar;
            this.f = fy1;
            this.g = str;
            this.h = interfaceC23940xm2;
            this.i = interfaceC16756lo6;
            this.j = nt0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = LJ6.this.new h(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                C11637dL5 c11637dL5 = new C11637dL5();
                c11637dL5.a = -1;
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.X(LJ6.this.e.f(this.e), new b(null, new CopyOnWriteArrayList(), c11637dL5, this.e, this.f, LJ6.this, this.g, interfaceC20315ro1, this.h, this.i, this.j));
                this.b = 1;
                if (AbstractC6459Nq2.G(interfaceC4557Fq2X, this) == objE) {
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
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ MX1.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(MX1.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = new i(this.d, interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            SY1 sy1 = (SY1) this.c;
            OX1.a(201, "DownloadState of " + this.d.c() + ": " + sy1, this.d);
            C19406qI3.a("StandardDownloader", "DownloadState of " + this.d.c() + ": " + sy1, new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(sy1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public LJ6(AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20887sm2 interfaceC20887sm2, InterfaceC17089mN5 interfaceC17089mN5, KT0 kt0, NT0.b bVar, C9785aZ1.d dVar, InterfaceC14123hO3 interfaceC14123hO3, PG3 pg3, InterfaceC23282wf4 interfaceC23282wf4) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(interfaceC20887sm2, "fileSystemDataSource");
        AbstractC13042fc3.i(interfaceC17089mN5, "remoteDownloadDataSource");
        AbstractC13042fc3.i(kt0, "chunkConfigurationManager");
        AbstractC13042fc3.i(bVar, "chunkRangeGeneratorFactory");
        AbstractC13042fc3.i(dVar, "downloadUrlProviderFactory");
        AbstractC13042fc3.i(interfaceC14123hO3, "throwableToDownloadErrorMapper");
        AbstractC13042fc3.i(pg3, "localDownloadDataSource");
        AbstractC13042fc3.i(interfaceC23282wf4, "migratorDataSource");
        this.a = abstractC13778go1;
        this.b = interfaceC20315ro1;
        this.c = interfaceC20887sm2;
        this.d = interfaceC17089mN5;
        this.e = kt0;
        this.f = bVar;
        this.g = dVar;
        this.h = interfaceC14123hO3;
        this.i = pg3;
        this.j = interfaceC23282wf4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float n(InterfaceC19096pm2.a aVar, long j, long j2) {
        if (j == 0) {
            return 0.0f;
        }
        return 1.0f - ((aVar.c().size() * j2) / j);
    }

    private final InterfaceC4557Fq2 o(MX1.a aVar, FY1 fy1) {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.h(AbstractC6459Nq2.i0(AbstractC6459Nq2.j(new d(aVar, this.g.a(aVar.c(), fy1.a()), fy1, null)), new e(fy1, new C23270we2(0L, 0L, 0.0d, 0.0f, 15, null), null)), new f(null)), this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 p(InterfaceC16204ks5 interfaceC16204ks5, MX1.a aVar, VI5 vi5, NT0 nt0) {
        return AbstractC10533bm0.d(interfaceC16204ks5, null, null, new g(vi5, nt0, this, aVar, interfaceC16204ks5, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 q(InterfaceC16204ks5 interfaceC16204ks5, String str, MX1.a aVar, FY1 fy1, InterfaceC23940xm2 interfaceC23940xm2, InterfaceC16756lo6 interfaceC16756lo6, NT0 nt0) {
        return AbstractC10533bm0.d(interfaceC16204ks5, null, null, new h(aVar, fy1, str, interfaceC23940xm2, interfaceC16756lo6, nt0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC23940xm2 r(MX1.a aVar, InterfaceC19096pm2.a aVar2) throws DownloadErrorException {
        InterfaceC23940xm2 interfaceC23940xm2A = InterfaceC20887sm2.a(this.c, aVar.b(), aVar2.b(), false, 4, null);
        InterfaceC23350wm2 interfaceC23350wm2Init = interfaceC23940xm2A.init();
        if (interfaceC23350wm2Init == null) {
            return interfaceC23940xm2A;
        }
        if (interfaceC23350wm2Init instanceof InterfaceC23350wm2.a) {
            throw new DownloadErrorException(new EX1.b.C0341b(((InterfaceC23350wm2.a) interfaceC23350wm2Init).a()));
        }
        if (interfaceC23350wm2Init instanceof InterfaceC23350wm2.b) {
            throw new DownloadErrorException(new EX1.d(((InterfaceC23350wm2.b) interfaceC23350wm2Init).a()));
        }
        if (interfaceC23350wm2Init instanceof InterfaceC23350wm2.c) {
            throw new DownloadErrorException(new EX1.e(((InterfaceC23350wm2.c) interfaceC23350wm2Init).a()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ir.nasim.InterfaceC11759dZ1
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public InterfaceC4557Fq2 a(MX1.a aVar, FY1 fy1) {
        AbstractC13042fc3.i(aVar, "input");
        AbstractC13042fc3.i(fy1, "downloadPolicy");
        return AbstractC6459Nq2.q(AbstractC6459Nq2.b0(o(aVar, fy1), new i(aVar, null)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LJ6(InterfaceC20887sm2 interfaceC20887sm2, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC17089mN5 interfaceC17089mN5, NT0.b bVar, C9785aZ1.d dVar, PG3 pg3, InterfaceC23282wf4 interfaceC23282wf4, KT0 kt0) {
        this(abstractC13778go1, interfaceC20315ro1, interfaceC20887sm2, interfaceC17089mN5, kt0, bVar, dVar, C19131pp7.a, pg3, interfaceC23282wf4);
        AbstractC13042fc3.i(interfaceC20887sm2, "fileSystemDataSource");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(interfaceC17089mN5, "remoteDownloadDataSource");
        AbstractC13042fc3.i(bVar, "chunkRangeGeneratorFactory");
        AbstractC13042fc3.i(dVar, "downloadUrlProviderFactory");
        AbstractC13042fc3.i(pg3, "localDownloadDataSource");
        AbstractC13042fc3.i(interfaceC23282wf4, "migratorDataSource");
        AbstractC13042fc3.i(kt0, "chunkConfigurationManager");
    }
}
