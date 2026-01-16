package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C11057cf4;
import ir.nasim.InterfaceC12464ef4;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ff4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13100ff4 extends AbstractC18524oo1 {
    private static final a k = new a(null);
    public static final int l = 8;
    private final InterfaceC9336Zm4 d;
    private final UA2 e;
    private final C11057cf4 f;
    private final C9847af4 g;
    private final AbstractC13778go1 h;
    private final boolean i;
    private final c j;

    /* renamed from: ir.nasim.ff4$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ff4$b */
    public interface b {

        /* renamed from: ir.nasim.ff4$b$a */
        public static final class a implements b {
            private final long a;

            public a(long j) {
                this.a = j;
            }

            public final long a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && this.a == ((a) obj).a;
            }

            public int hashCode() {
                return Long.hashCode(this.a);
            }

            public String toString() {
                return "Delete(fileId=" + this.a + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.ff4$b$b, reason: collision with other inner class name */
        public static final class C1236b implements b {
            private final C10405bZ1 a;

            public C1236b(C10405bZ1 c10405bZ1) {
                AbstractC13042fc3.i(c10405bZ1, "downloaded");
                this.a = c10405bZ1;
            }

            public final C10405bZ1 a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1236b) && AbstractC13042fc3.d(this.a, ((C1236b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "Insert(downloaded=" + this.a + Separators.RPAREN;
            }
        }
    }

    /* renamed from: ir.nasim.ff4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13100ff4.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11057cf4 c11057cf4 = C13100ff4.this.f;
                List list = this.d;
                this.b = 1;
                if (c11057cf4.j(list, this) == objE) {
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

    /* renamed from: ir.nasim.ff4$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C13100ff4.this.m(null, this);
        }
    }

    /* renamed from: ir.nasim.ff4$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C13100ff4.this.p(null, this);
        }
    }

    /* renamed from: ir.nasim.ff4$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C13100ff4.this.r(null, this);
        }
    }

    /* renamed from: ir.nasim.ff4$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ List d;
        final /* synthetic */ C13100ff4 e;

        /* renamed from: ir.nasim.ff4$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13100ff4 c;
            final /* synthetic */ List d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13100ff4 c13100ff4, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13100ff4;
                this.d = list;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C13100ff4 c13100ff4 = this.c;
                    List list = this.d;
                    this.b = 1;
                    if (c13100ff4.r(list, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(List list, C13100ff4 c13100ff4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = c13100ff4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(this.d, this.e, interfaceC20295rm1);
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
                List listH0 = AbstractC15401jX0.h0(this.d, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                C13100ff4 c13100ff4 = this.e;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listH0, 10));
                Iterator it = listH0.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC10533bm0.b(interfaceC20315ro1, c13100ff4.h, null, new a(c13100ff4, (List) it.next(), null), 2, null));
                }
                this.b = 1;
                obj = DV.a(arrayList, this);
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

    /* renamed from: ir.nasim.ff4$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C10405bZ1 c;
        final /* synthetic */ C13100ff4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C10405bZ1 c10405bZ1, C13100ff4 c13100ff4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c10405bZ1;
            this.d = c13100ff4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (new File(this.c.q()).exists()) {
                return new C11057cf4.b(this.d.f.i(this.c.getFileSize(), this.c.q(), this.c.getFileId()), this.c.q());
            }
            C19406qI3.j("MigrationMsgProcessor", "File not found during transform, path=" + this.c.q(), new Object[0]);
            return null;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ C13100ff4(InterfaceC9336Zm4 interfaceC9336Zm4, UA2 ua2, C11057cf4 c11057cf4, C9847af4 c9847af4, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, InterfaceC20315ro1 interfaceC20315ro1, boolean z, int i2, ED1 ed1) {
        this(interfaceC9336Zm4, ua2, c11057cf4, c9847af4, abstractC13778go1, abstractC13778go12, interfaceC20315ro1, (i2 & 128) != 0 ? true : z);
    }

    private final Object l(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new d(list, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0126 A[Catch: Exception -> 0x0135, CancellationException -> 0x013a, TRY_LEAVE, TryCatch #5 {CancellationException -> 0x013a, Exception -> 0x0135, blocks: (B:57:0x011c, B:59:0x0126), top: B:82:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0160 A[Catch: Exception -> 0x0039, CancellationException -> 0x003c, TRY_LEAVE, TryCatch #6 {CancellationException -> 0x003c, Exception -> 0x0039, blocks: (B:13:0x0034, B:67:0x0140, B:69:0x0160), top: B:80:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(ir.nasim.InterfaceC12464ef4.a r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13100ff4.m(ir.nasim.ef4$a, ir.nasim.rm1):java.lang.Object");
    }

    private final void n(InterfaceC12464ef4.b bVar) {
        if (this.j.a().j()) {
            C19406qI3.a("MigrationMsgProcessor", "Ignored EnqueueAdd. Migration already DONE or FAILED.", new Object[0]);
        } else {
            this.j.b().put(Long.valueOf(bVar.a().getFileId()), new b.C1236b(bVar.a()));
        }
    }

    private final void o(InterfaceC12464ef4.c cVar) {
        if (this.j.a().j()) {
            C19406qI3.a("MigrationMsgProcessor", "Ignored EnqueueDelete. Migration already DONE or FAILED.", new Object[0]);
        } else {
            this.j.b().put(Long.valueOf(cVar.a()), new b.a(cVar.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(ir.nasim.InterfaceC12464ef4.d r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13100ff4.p(ir.nasim.ef4$d, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006c -> B:22:0x006f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C13100ff4.g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.ff4$g r0 = (ir.nasim.C13100ff4.g) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.ff4$g r0 = new ir.nasim.ff4$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r8)
            goto L8b
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.c
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.b
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r5 = r0.a
            ir.nasim.ff4 r5 = (ir.nasim.C13100ff4) r5
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6f
        L44:
            ir.nasim.AbstractC10685c16.b(r8)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r7 = r7.iterator()
            r5 = r6
            r2 = r8
        L54:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L77
            java.lang.Object r8 = r7.next()
            ir.nasim.bZ1 r8 = (ir.nasim.C10405bZ1) r8
            r0.a = r5
            r0.b = r2
            r0.c = r7
            r0.f = r4
            java.lang.Object r8 = r5.t(r8, r0)
            if (r8 != r1) goto L6f
            return r1
        L6f:
            ir.nasim.cf4$b r8 = (ir.nasim.C11057cf4.b) r8
            if (r8 == 0) goto L54
            r2.add(r8)
            goto L54
        L77:
            java.util.List r2 = (java.util.List) r2
            ir.nasim.cf4 r7 = r5.f
            r8 = 0
            r0.a = r8
            r0.b = r8
            r0.c = r8
            r0.f = r3
            java.lang.Object r7 = r7.k(r2, r0)
            if (r7 != r1) goto L8b
            return r1
        L8b:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13100ff4.r(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    private final Object s(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new h(list, this, null), interfaceC20295rm1);
    }

    private final Object t(C10405bZ1 c10405bZ1, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.h, new i(c10405bZ1, this, null), interfaceC20295rm1);
    }

    private final void u(EnumC13691gf4 enumC13691gf4) {
        this.j.c(enumC13691gf4);
        this.d.setValue(this.j.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC18524oo1
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Object c(InterfaceC12464ef4 interfaceC12464ef4, InterfaceC20295rm1 interfaceC20295rm1) {
        if (interfaceC12464ef4 instanceof InterfaceC12464ef4.b) {
            n((InterfaceC12464ef4.b) interfaceC12464ef4);
        } else {
            if (!(interfaceC12464ef4 instanceof InterfaceC12464ef4.c)) {
                if (interfaceC12464ef4 instanceof InterfaceC12464ef4.d) {
                    Object objP = p((InterfaceC12464ef4.d) interfaceC12464ef4, interfaceC20295rm1);
                    return objP == AbstractC14862ic3.e() ? objP : C19938rB7.a;
                }
                if (!(interfaceC12464ef4 instanceof InterfaceC12464ef4.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                Object objM = m((InterfaceC12464ef4.a) interfaceC12464ef4, interfaceC20295rm1);
                return objM == AbstractC14862ic3.e() ? objM : C19938rB7.a;
            }
            o((InterfaceC12464ef4.c) interfaceC12464ef4);
        }
        return C19938rB7.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C13100ff4(InterfaceC9336Zm4 interfaceC9336Zm4, UA2 ua2, C11057cf4 c11057cf4, C9847af4 c9847af4, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, InterfaceC20315ro1 interfaceC20315ro1, boolean z) {
        super(abstractC13778go12, interfaceC20315ro1, "MigrationMsgProcessor");
        AbstractC13042fc3.i(interfaceC9336Zm4, "migrationStateFlow");
        AbstractC13042fc3.i(ua2, "oldDataSnapshot");
        AbstractC13042fc3.i(c11057cf4, "migrationDownloadRepository");
        AbstractC13042fc3.i(c9847af4, "migrationChecker");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "defaultDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        this.d = interfaceC9336Zm4;
        this.e = ua2;
        this.f = c11057cf4;
        this.g = c9847af4;
        this.h = abstractC13778go1;
        this.i = z;
        this.j = new c((EnumC13691gf4) interfaceC9336Zm4.getValue(), null, 2, 0 == true ? 1 : 0);
    }

    /* renamed from: ir.nasim.ff4$c */
    private static final class c {
        private EnumC13691gf4 a;
        private final ConcurrentHashMap b;

        public c(EnumC13691gf4 enumC13691gf4, ConcurrentHashMap concurrentHashMap) {
            AbstractC13042fc3.i(enumC13691gf4, "currentMigrationState");
            AbstractC13042fc3.i(concurrentHashMap, "pendingMap");
            this.a = enumC13691gf4;
            this.b = concurrentHashMap;
        }

        public final EnumC13691gf4 a() {
            return this.a;
        }

        public final ConcurrentHashMap b() {
            return this.b;
        }

        public final void c(EnumC13691gf4 enumC13691gf4) {
            AbstractC13042fc3.i(enumC13691gf4, "<set-?>");
            this.a = enumC13691gf4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && AbstractC13042fc3.d(this.b, cVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "ProcessorInternalState(currentMigrationState=" + this.a + ", pendingMap=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ c(EnumC13691gf4 enumC13691gf4, ConcurrentHashMap concurrentHashMap, int i, ED1 ed1) {
            this(enumC13691gf4, (i & 2) != 0 ? new ConcurrentHashMap() : concurrentHashMap);
        }
    }
}
