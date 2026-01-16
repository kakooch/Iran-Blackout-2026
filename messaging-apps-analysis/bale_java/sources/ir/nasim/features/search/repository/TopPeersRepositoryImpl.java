package ir.nasim.features.search.repository;

import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.reflect.TypeToken;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22163um1;
import ir.nasim.C11994dt7;
import ir.nasim.C19938rB7;
import ir.nasim.C3804Ck5;
import ir.nasim.C8618Ws7;
import ir.nasim.C9475a16;
import ir.nasim.ED1;
import ir.nasim.InterfaceC12607et7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21626tr4;
import ir.nasim.InterfaceC3570Bk5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class TopPeersRepositoryImpl implements InterfaceC12607et7 {
    public static final a j = new a(null);
    public static final int k = 8;
    private final InterfaceC21626tr4 a;
    private final C8618Ws7 b;
    private final InterfaceC3570Bk5 c;
    private final C11994dt7 d;
    private final AbstractC13778go1 e;
    private final InterfaceC20315ro1 f;
    private final List g;
    private final C3804Ck5 h;
    private final List i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            Object objE = TopPeersRepositoryImpl.this.e(null, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            Object objB = TopPeersRepositoryImpl.this.b(this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TopPeersRepositoryImpl.this.new d(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0080 A[PHI: r1 r5 r6
          0x0080: PHI (r1v11 java.util.Iterator) = (r1v9 java.util.Iterator), (r1v12 java.util.Iterator) binds: [B:22:0x007b, B:29:0x00af] A[DONT_GENERATE, DONT_INLINE]
          0x0080: PHI (r5v1 ir.nasim.features.search.repository.TopPeersRepositoryImpl) = 
          (r5v0 ir.nasim.features.search.repository.TopPeersRepositoryImpl)
          (r5v2 ir.nasim.features.search.repository.TopPeersRepositoryImpl)
         binds: [B:22:0x007b, B:29:0x00af] A[DONT_GENERATE, DONT_INLINE]
          0x0080: PHI (r6v6 java.lang.Object) = (r6v1 java.lang.Object), (r6v7 java.lang.Object) binds: [B:22:0x007b, B:29:0x00af] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a8 -> B:28:0x00ab). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r11.e
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L42
                if (r1 == r4) goto L38
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                ir.nasim.AbstractC10685c16.b(r12)
                ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
                r12.l()
                goto Lc7
            L1b:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L23:
                java.lang.Object r1 = r11.d
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r5 = r11.c
                ir.nasim.features.search.repository.TopPeersRepositoryImpl r5 = (ir.nasim.features.search.repository.TopPeersRepositoryImpl) r5
                java.lang.Object r6 = r11.b
                ir.nasim.AbstractC10685c16.b(r12)
                ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
                java.lang.Object r12 = r12.l()
                goto Lab
            L38:
                ir.nasim.AbstractC10685c16.b(r12)
                ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
                java.lang.Object r12 = r12.l()
                goto L54
            L42:
                ir.nasim.AbstractC10685c16.b(r12)
                ir.nasim.features.search.repository.TopPeersRepositoryImpl r12 = ir.nasim.features.search.repository.TopPeersRepositoryImpl.this
                ir.nasim.dt7 r12 = ir.nasim.features.search.repository.TopPeersRepositoryImpl.d(r12)
                r11.e = r4
                java.lang.Object r12 = r12.a(r11)
                if (r12 != r0) goto L54
                return r0
            L54:
                ir.nasim.features.search.repository.TopPeersRepositoryImpl r1 = ir.nasim.features.search.repository.TopPeersRepositoryImpl.this
                java.util.List r1 = ir.nasim.features.search.repository.TopPeersRepositoryImpl.c(r1)
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                r1 = r1 ^ r4
                if (r1 == 0) goto Lb3
                ir.nasim.features.search.repository.TopPeersRepositoryImpl r1 = ir.nasim.features.search.repository.TopPeersRepositoryImpl.this
                java.util.List r1 = ir.nasim.features.search.repository.TopPeersRepositoryImpl.c(r1)
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                ir.nasim.features.search.repository.TopPeersRepositoryImpl r5 = ir.nasim.features.search.repository.TopPeersRepositoryImpl.this
                boolean r6 = r1 instanceof java.util.Collection
                if (r6 == 0) goto L7b
                r6 = r1
                java.util.Collection r6 = (java.util.Collection) r6
                boolean r6 = r6.isEmpty()
                if (r6 == 0) goto L7b
                goto Lb3
            L7b:
                java.util.Iterator r1 = r1.iterator()
                r6 = r12
            L80:
                boolean r12 = r1.hasNext()
                if (r12 == 0) goto Lb2
                java.lang.Object r12 = r1.next()
                java.lang.Number r12 = (java.lang.Number) r12
                long r7 = r12.longValue()
                ir.nasim.dt7 r12 = ir.nasim.features.search.repository.TopPeersRepositoryImpl.d(r5)
                ir.nasim.d25 r9 = new ir.nasim.d25
                ir.nasim.W25 r10 = ir.nasim.W25.a
                int r7 = (int) r7
                r9.<init>(r10, r7)
                r11.b = r6
                r11.c = r5
                r11.d = r1
                r11.e = r3
                java.lang.Object r12 = r12.b(r9, r11)
                if (r12 != r0) goto Lab
                return r0
            Lab:
                boolean r12 = ir.nasim.C9475a16.j(r12)
                if (r12 != 0) goto L80
                r4 = 0
            Lb2:
                r12 = r6
            Lb3:
                if (r4 == 0) goto Lc7
                ir.nasim.features.search.repository.TopPeersRepositoryImpl r1 = ir.nasim.features.search.repository.TopPeersRepositoryImpl.this
                r3 = 0
                r11.b = r3
                r11.c = r3
                r11.d = r3
                r11.e = r2
                java.lang.Object r12 = r1.e(r12, r11)
                if (r12 != r0) goto Lc7
                return r0
            Lc7:
                ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.search.repository.TopPeersRepositoryImpl.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objA = TopPeersRepositoryImpl.this.a(null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TopPeersRepositoryImpl(InterfaceC21626tr4 interfaceC21626tr4, C8618Ws7 c8618Ws7, InterfaceC3570Bk5 interfaceC3570Bk5, C11994dt7 c11994dt7, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1) {
        List listM;
        AbstractC13042fc3.i(interfaceC21626tr4, "networkStatusProvider");
        AbstractC13042fc3.i(c8618Ws7, "topPeersLocalDataSource");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(c11994dt7, "topPeersRemoteDataSource");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = interfaceC21626tr4;
        this.b = c8618Ws7;
        this.c = interfaceC3570Bk5;
        this.d = c11994dt7;
        this.e = abstractC13778go1;
        this.f = interfaceC20315ro1;
        this.g = new ArrayList();
        C3804Ck5 c3804Ck5 = new C3804Ck5(interfaceC3570Bk5, null, 2, 0 == true ? 1 : 0);
        this.h = c3804Ck5;
        String strE = c3804Ck5.c().e("removedPeersList");
        if (strE == null) {
            listM = AbstractC10360bX0.m();
        } else {
            Object objL = c3804Ck5.b().l(strE, new TypeToken<List<? extends Long>>() { // from class: ir.nasim.features.search.repository.TopPeersRepositoryImpl$special$$inlined$getList$1
            }.d());
            AbstractC13042fc3.h(objL, "fromJson(...)");
            listM = (List) objL;
        }
        this.i = listM;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC12607et7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.C11458d25 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.search.repository.TopPeersRepositoryImpl.a(ir.nasim.d25, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011e A[PHI: r4 r8 r11
      0x011e: PHI (r4v7 java.util.Iterator) = (r4v4 java.util.Iterator), (r4v8 java.util.Iterator) binds: [B:51:0x0117, B:58:0x014b] A[DONT_GENERATE, DONT_INLINE]
      0x011e: PHI (r8v10 java.lang.Object) = (r8v8 java.lang.Object), (r8v11 java.lang.Object) binds: [B:51:0x0117, B:58:0x014b] A[DONT_GENERATE, DONT_INLINE]
      0x011e: PHI (r11v7 ir.nasim.features.search.repository.TopPeersRepositoryImpl) = 
      (r11v2 ir.nasim.features.search.repository.TopPeersRepositoryImpl)
      (r11v8 ir.nasim.features.search.repository.TopPeersRepositoryImpl)
     binds: [B:51:0x0117, B:58:0x014b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0144 -> B:57:0x0147). Please report as a decompilation issue!!! */
    @Override // ir.nasim.InterfaceC12607et7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.InterfaceC20295rm1 r19) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.search.repository.TopPeersRepositoryImpl.b(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d9 A[LOOP:1: B:64:0x01d3->B:66:0x01d9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.Object r25, ir.nasim.InterfaceC20295rm1 r26) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.search.repository.TopPeersRepositoryImpl.e(java.lang.Object, ir.nasim.rm1):java.lang.Object");
    }
}
