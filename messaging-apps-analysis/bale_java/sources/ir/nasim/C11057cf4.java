package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC10467bf4;
import ir.nasim.InterfaceC19365qD7;
import ir.nasim.InterfaceC9905al2;
import ir.nasim.MX1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.cf4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11057cf4 extends AbstractC18524oo1 {
    public static final a h = new a(null);
    private final PG3 d;
    private final InterfaceC20315ro1 e;
    private final AbstractC13778go1 f;
    private final C22878vy3 g;

    /* renamed from: ir.nasim.cf4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.cf4$b */
    public static final class b {
        private final MX1.a a;
        private final String b;

        public b(MX1.a aVar, String str) {
            AbstractC13042fc3.i(aVar, "input");
            AbstractC13042fc3.i(str, "path");
            this.a = aVar;
            this.b = str;
        }

        public final MX1.a a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "MigrateDownloadedData(input=" + this.a + ", path=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.cf4$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C11057cf4.this.g(this);
        }
    }

    /* renamed from: ir.nasim.cf4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC10467bf4 c;
        final /* synthetic */ C11057cf4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC10467bf4 interfaceC10467bf4, C11057cf4 c11057cf4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC10467bf4;
            this.d = c11057cf4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List listA = ((InterfaceC10467bf4.a) this.c).a();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : listA) {
                    if (new File(((b) obj2).b()).exists()) {
                        arrayList.add(obj2);
                    }
                }
                C11057cf4 c11057cf4 = this.d;
                this.b = 1;
                if (c11057cf4.k(arrayList, this) == objE) {
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

    /* renamed from: ir.nasim.cf4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC10467bf4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC10467bf4 interfaceC10467bf4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10467bf4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11057cf4.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11057cf4 c11057cf4 = C11057cf4.this;
                List listA = ((InterfaceC10467bf4.b) this.d).a();
                this.b = 1;
                if (c11057cf4.j(listA, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11057cf4(PG3 pg3, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C22878vy3 c22878vy3) {
        super(abstractC13778go1, interfaceC20315ro1, "MigrationDownloadRepository");
        AbstractC13042fc3.i(pg3, "localDownloadDataSource");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(abstractC13778go1, "defaultDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "ioDispatcher");
        AbstractC13042fc3.i(c22878vy3, "legacyFilePathToFileDescriptorMapper");
        this.d = pg3;
        this.e = interfaceC20315ro1;
        this.f = abstractC13778go12;
        this.g = c22878vy3;
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C11057cf4.c
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.cf4$c r0 = (ir.nasim.C11057cf4.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.cf4$c r0 = new ir.nasim.cf4$c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            ir.nasim.AbstractC10685c16.b(r5)     // Catch: java.lang.Exception -> L29 java.util.concurrent.CancellationException -> L2b
            goto L4b
        L29:
            r5 = move-exception
            goto L43
        L2b:
            r5 = move-exception
            goto L50
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.PG3 r5 = r4.d     // Catch: java.lang.Exception -> L29 java.util.concurrent.CancellationException -> L2b
            r0.c = r3     // Catch: java.lang.Exception -> L29 java.util.concurrent.CancellationException -> L2b
            java.lang.Object r5 = r5.c(r0)     // Catch: java.lang.Exception -> L29 java.util.concurrent.CancellationException -> L2b
            if (r5 != r1) goto L4b
            return r1
        L43:
            java.lang.String r0 = "MigrationDownloadRepository"
            java.lang.String r1 = "Error clearing database"
            android.util.Log.e(r0, r1, r5)
            r3 = 0
        L4b:
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r3)
            return r5
        L50:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11057cf4.g(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC18524oo1
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Object c(InterfaceC10467bf4 interfaceC10467bf4, InterfaceC20295rm1 interfaceC20295rm1) {
        if (interfaceC10467bf4 instanceof InterfaceC10467bf4.a) {
            Object objG = AbstractC9323Zl0.g(this.f, new d(interfaceC10467bf4, this, null), interfaceC20295rm1);
            return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
        }
        if (!(interfaceC10467bf4 instanceof InterfaceC10467bf4.b)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objG2 = AbstractC9323Zl0.g(this.f, new e(interfaceC10467bf4, null), interfaceC20295rm1);
        return objG2 == AbstractC14862ic3.e() ? objG2 : C19938rB7.a;
    }

    public final MX1.a i(long j, String str, long j2) {
        AbstractC13042fc3.i(str, "descriptor");
        return new MX1.a(j, AbstractC20762sZ6.d1(str, Separators.SLASH, null, 2, null), this.g.a(str), new C4995Hl2(j2, -1L));
    }

    public final Object j(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        PG3 pg3 = this.d;
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new C4995Hl2(((Number) it.next()).longValue(), -1L));
        }
        Object objE = pg3.e(arrayList, interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public final Object k(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        PG3 pg3 = this.d;
        List<b> list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list2, 10)), 16));
        for (b bVar : list2) {
            XV4 xv4A = AbstractC4616Fw7.a(bVar.a(), new InterfaceC19365qD7.a(new InterfaceC9905al2.a(bVar.b(), bVar.a().b())));
            linkedHashMap.put(xv4A.e(), xv4A.f());
        }
        Object objD = pg3.d(linkedHashMap, interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }
}
