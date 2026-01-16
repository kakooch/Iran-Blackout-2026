package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: ir.nasim.aG3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C9616aG3 {
    private final InterfaceC20315ro1 a;
    private final C3777Ch5 b;
    private final AbstractC13778go1 c;
    private final DB3 d;
    private final long e;
    private final ReentrantReadWriteLock f;
    private final HashMap g;

    /* renamed from: ir.nasim.aG3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C9616aG3.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0088 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0086 -> B:15:0x003f). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L22
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                java.lang.Object r1 = r7.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L6f
            L22:
                java.lang.Object r1 = r7.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L3f
            L2a:
                ir.nasim.AbstractC10685c16.b(r8)
                java.lang.Object r8 = r7.c
                r1 = r8
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                r7.c = r1
                r7.b = r4
                r5 = 1500(0x5dc, double:7.41E-321)
                java.lang.Object r8 = ir.nasim.HG1.b(r5, r7)
                if (r8 != r0) goto L3f
                return r0
            L3f:
                boolean r8 = ir.nasim.AbstractC20906so1.g(r1)
                if (r8 == 0) goto L8e
                ir.nasim.aG3 r8 = ir.nasim.C9616aG3.this
                java.util.concurrent.locks.ReentrantReadWriteLock r8 = ir.nasim.C9616aG3.c(r8)
                ir.nasim.aG3 r5 = ir.nasim.C9616aG3.this
                java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r8 = r8.readLock()
                r8.lock()
                java.util.HashMap r5 = ir.nasim.C9616aG3.b(r5)     // Catch: java.lang.Throwable -> L89
                r8.unlock()
                boolean r8 = r5.isEmpty()
                r8 = r8 ^ r4
                if (r8 == 0) goto L78
                ir.nasim.aG3 r8 = ir.nasim.C9616aG3.this
                r7.c = r1
                r7.b = r3
                java.lang.Object r8 = ir.nasim.C9616aG3.d(r8, r5, r7)
                if (r8 != r0) goto L6f
                return r0
            L6f:
                ir.nasim.aG3 r8 = ir.nasim.C9616aG3.this
                java.util.HashMap r8 = ir.nasim.C9616aG3.b(r8)
                r8.clear()
            L78:
                ir.nasim.aG3 r8 = ir.nasim.C9616aG3.this
                long r5 = ir.nasim.C9616aG3.a(r8)
                r7.c = r1
                r7.b = r2
                java.lang.Object r8 = ir.nasim.HG1.b(r5, r7)
                if (r8 != r0) goto L3f
                return r0
            L89:
                r0 = move-exception
                r8.unlock()
                throw r0
            L8e:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9616aG3.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aG3$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C9616aG3.this.f(null, this);
        }
    }

    public C9616aG3(InterfaceC20315ro1 interfaceC20315ro1, C3777Ch5 c3777Ch5, AbstractC13778go1 abstractC13778go1, DB3 db3, long j) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(c3777Ch5, "pollRepository");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(db3, "messageEngine");
        this.a = interfaceC20315ro1;
        this.b = c3777Ch5;
        this.c = abstractC13778go1;
        this.d = db3;
        this.e = j;
        this.f = new ReentrantReadWriteLock(true);
        this.g = new HashMap();
        AbstractC10533bm0.d(interfaceC20315ro1, abstractC13778go1, null, new a(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.util.Map r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof ir.nasim.C9616aG3.b
            if (r0 == 0) goto L13
            r0 = r15
            ir.nasim.aG3$b r0 = (ir.nasim.C9616aG3.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.aG3$b r0 = new ir.nasim.aG3$b
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r14 = r0.a
            ir.nasim.aG3 r14 = (ir.nasim.C9616aG3) r14
            ir.nasim.AbstractC10685c16.b(r15)
            goto L50
        L2d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L35:
            ir.nasim.AbstractC10685c16.b(r15)
            ir.nasim.Ch5 r15 = r13.b
            java.util.Set r14 = r14.keySet()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.List r14 = ir.nasim.ZW0.m1(r14)
            r0.a = r13
            r0.d = r3
            java.lang.Object r15 = r15.f(r14, r0)
            if (r15 != r1) goto L4f
            return r1
        L4f:
            r14 = r13
        L50:
            java.util.List r15 = (java.util.List) r15
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.List r15 = ir.nasim.ZW0.n0(r15)
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L63:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto Ld6
            java.lang.Object r1 = r15.next()
            ir.nasim.m18 r1 = (ir.nasim.C16885m18) r1
            java.util.HashMap r2 = r14.g
            long r4 = r1.s()
            java.lang.Long r4 = ir.nasim.AbstractC6392Nk0.e(r4)
            java.lang.Object r2 = r2.get(r4)
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L86
            long r4 = r2.longValue()
            goto L88
        L86:
            r4 = -1
        L88:
            ir.nasim.DB3 r2 = r14.d
            ir.nasim.nl0 r2 = r2.a(r4)
            ir.nasim.J44 r2 = (ir.nasim.J44) r2
            if (r2 != 0) goto L93
            goto L63
        L93:
            ir.nasim.n0 r4 = r2.F()
            java.lang.String r5 = "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PollContent"
            ir.nasim.AbstractC13042fc3.g(r4, r5)
            r12 = r4
            ir.nasim.ph5 r12 = (ir.nasim.C19049ph5) r12
            ir.nasim.ph5$a r4 = ir.nasim.C19049ph5.i
            boolean r5 = r12.y()
            long r6 = r12.u()
            java.lang.String r8 = r12.v()
            java.util.List r9 = r12.t()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.List r9 = ir.nasim.ZW0.p1(r9)
            ir.nasim.aB r10 = r12.w()
            if (r10 != 0) goto Lbf
            ir.nasim.aB r10 = ir.nasim.EnumC9567aB.UNSUPPORTED_VALUE
        Lbf:
            r11 = r1
            ir.nasim.ph5 r4 = r4.a(r5, r6, r8, r9, r10, r11)
            ir.nasim.m18 r5 = r12.x()
            boolean r1 = ir.nasim.AbstractC13042fc3.d(r5, r1)
            if (r1 != 0) goto L63
            ir.nasim.J44 r1 = r2.u(r4, r3)
            r0.add(r1)
            goto L63
        Ld6:
            ir.nasim.DB3 r14 = r14.d
            r14.c(r0)
            ir.nasim.rB7 r14 = ir.nasim.C19938rB7.a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9616aG3.f(java.util.Map, ir.nasim.rm1):java.lang.Object");
    }

    public final void e(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "messages");
        ReentrantReadWriteLock reentrantReadWriteLock = this.f;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            ArrayList<J44> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                J44 j44 = (J44) obj;
                if (j44.F() instanceof C19049ph5) {
                    AbstractC17457n0 abstractC17457n0F = j44.F();
                    AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PollContent");
                    C16885m18 c16885m18X = ((C19049ph5) abstractC17457n0F).x();
                    if (c16885m18X == null || !c16885m18X.y()) {
                        if (j44.L() != EnumC23558x74.ERROR && j44.L() != EnumC23558x74.PENDING) {
                            arrayList2.add(obj);
                        }
                    }
                }
            }
            for (J44 j442 : arrayList2) {
                HashMap map = this.g;
                AbstractC17457n0 abstractC17457n0F2 = j442.F();
                AbstractC13042fc3.g(abstractC17457n0F2, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PollContent");
                map.put(Long.valueOf(((C19049ph5) abstractC17457n0F2).u()), Long.valueOf(j442.i()));
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
            throw th;
        }
    }
}
