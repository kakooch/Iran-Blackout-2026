package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: ir.nasim.tG3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21191tG3 {
    private static final a m = new a(null);
    private final long a;
    private final boolean b;
    private final InterfaceC20315ro1 c;
    private final InterfaceC22621vY7 d;
    private final InterfaceC19305q74 e;
    private final SettingsModule f;
    private final AbstractC13778go1 g;
    private final InterfaceC20315ro1 h;
    private final ReentrantReadWriteLock i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9173Yu3 l;

    /* renamed from: ir.nasim.tG3$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tG3$b */
    public interface b {
        C21191tG3 a(InterfaceC20315ro1 interfaceC20315ro1);
    }

    /* renamed from: ir.nasim.tG3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C21191tG3.this.new c(interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                long j = C21191tG3.this.a;
                this.c = interfaceC20315ro1;
                this.b = 1;
                if (HG1.b(j, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
            }
            while (AbstractC20906so1.g(interfaceC20315ro1)) {
                C21191tG3.this.w();
                long jU2 = C21191tG3.this.f.U2();
                this.c = interfaceC20315ro1;
                this.b = 2;
                if (HG1.b(jU2, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tG3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.tG3$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21191tG3 c;
            final /* synthetic */ C11458d25 d;
            final /* synthetic */ HashSet e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21191tG3 c21191tG3, C11458d25 c11458d25, HashSet hashSet, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21191tG3;
                this.d = c11458d25;
                this.e = hashSet;
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
                    C21191tG3 c21191tG3 = this.c;
                    C11458d25 c11458d25 = this.d;
                    HashSet hashSet = this.e;
                    this.b = 1;
                    if (c21191tG3.x(c11458d25, hashSet, this) == objE) {
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

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C21191tG3.this.new d(interfaceC20295rm1);
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
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            Map mapO = C21191tG3.this.o();
            C21191tG3 c21191tG3 = C21191tG3.this;
            for (Map.Entry entry : mapO.entrySet()) {
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c21191tG3, (C11458d25) entry.getKey(), (HashSet) entry.getValue(), null), 3, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tG3$e */
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
            return C21191tG3.this.x(null, null, this);
        }
    }

    /* renamed from: ir.nasim.tG3$f */
    static final class f implements InterfaceC4806Gq2 {
        final /* synthetic */ C11458d25 b;

        f(C11458d25 c11458d25) {
            this.b = c11458d25;
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objL = ((C9475a16) obj).l();
            C21191tG3 c21191tG3 = C21191tG3.this;
            C11458d25 c11458d25 = this.b;
            if (C9475a16.j(objL)) {
                c21191tG3.q(c11458d25, (List) objL);
            }
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                C19406qI3.b("LoadViewsUseCase", "loadViews: " + thE.getMessage());
            }
            return C19938rB7.a;
        }
    }

    public C21191tG3(long j, boolean z, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC22621vY7 interfaceC22621vY7, InterfaceC19305q74 interfaceC19305q74, SettingsModule settingsModule, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro12) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(interfaceC22621vY7, "viewsRepository");
        AbstractC13042fc3.i(interfaceC19305q74, "messageRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro12, "applicationCoroutineScope");
        this.a = j;
        this.b = z;
        this.c = interfaceC20315ro1;
        this.d = interfaceC22621vY7;
        this.e = interfaceC19305q74;
        this.f = settingsModule;
        this.g = abstractC13778go1;
        this.h = interfaceC20315ro12;
        this.i = new ReentrantReadWriteLock(true);
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pG3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21191tG3.l();
            }
        });
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qG3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21191tG3.y();
            }
        });
        this.l = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rG3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21191tG3.v();
            }
        });
        if (z) {
            t();
        }
    }

    private final void k(C11458d25 c11458d25, J44 j44, boolean z) {
        C8445Vz5 c8445Vz5Q;
        C11458d25 c11458d25U;
        AbstractC17457n0 abstractC17457n0F = j44.F();
        C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
        if (c11907dl != null) {
            for (J44 j442 : c11907dl.r()) {
                m().put(new T74(c11458d25, j442.i(), j442.h()), Long.valueOf(j44.i()));
                k(c11458d25, j442, z);
            }
            return;
        }
        C8445Vz5 c8445Vz5Q2 = j44.Q();
        if (c8445Vz5Q2 == null || !c8445Vz5Q2.E()) {
            C7167Qo1 c7167Qo1 = new C7167Qo1(j44.h(), j44.i(), z);
            HashMap mapN = n();
            Object hashSet = mapN.get(c11458d25);
            if (hashSet == null) {
                hashSet = new HashSet();
                mapN.put(c11458d25, hashSet);
            }
            ((HashSet) hashSet).add(c7167Qo1);
            return;
        }
        C8445Vz5 c8445Vz5Q3 = j44.Q();
        if (c8445Vz5Q3 == null || (c8445Vz5Q = j44.Q()) == null || (c11458d25U = c8445Vz5Q.u()) == null) {
            return;
        }
        p().put(new T74(c11458d25U, c8445Vz5Q3.s(), c8445Vz5Q3.h()), new T74(c11458d25, j44.i(), j44.h()));
        C7167Qo1 c7167Qo12 = new C7167Qo1(c8445Vz5Q3.h(), c8445Vz5Q3.s(), z);
        HashMap mapN2 = n();
        Object hashSet2 = mapN2.get(c11458d25U);
        if (hashSet2 == null) {
            hashSet2 = new HashSet();
            mapN2.put(c11458d25U, hashSet2);
        }
        ((HashSet) hashSet2).add(c7167Qo12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap l() {
        return new HashMap();
    }

    private final HashMap m() {
        return (HashMap) this.j.getValue();
    }

    private final HashMap n() {
        return (HashMap) this.l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map o() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.i;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            Map mapY = AbstractC20051rO3.y(n());
            n().clear();
            return mapY;
        } finally {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    private final HashMap p() {
        return (HashMap) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(C11458d25 c11458d25, List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C23807xY7 c23807xY7 = (C23807xY7) it.next();
            long jA = c23807xY7.a();
            long jB = c23807xY7.b();
            long jC = c23807xY7.c();
            T74 t74 = new T74(c11458d25, jA, jB);
            T74 t742 = (T74) p().remove(t74);
            if (t742 != null) {
                C11458d25 c11458d25A = t742.a();
                long jB2 = t742.b();
                long jC2 = t742.c();
                Long l = (Long) m().remove(t742);
                if (l != null) {
                    XV4 xv4A = AbstractC4616Fw7.a(c11458d25A, Long.valueOf(l.longValue()));
                    Object arrayList = map.get(xv4A);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map.put(xv4A, arrayList);
                    }
                    ((List) arrayList).add(C23807xY7.e(c23807xY7, jB2, jC2, 0L, 4, null));
                } else {
                    this.e.e(c11458d25A, jB2, jC2, jC);
                }
            }
            Long l2 = (Long) m().remove(t74);
            if (l2 != null) {
                XV4 xv4A2 = AbstractC4616Fw7.a(c11458d25, Long.valueOf(l2.longValue()));
                Object arrayList2 = map.get(xv4A2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(xv4A2, arrayList2);
                }
                ((List) arrayList2).add(c23807xY7);
            } else {
                this.e.e(c11458d25, jA, jB, jC);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            XV4 xv4 = (XV4) entry.getKey();
            this.e.a((C11458d25) xv4.e(), ((Number) xv4.f()).longValue(), (List) entry.getValue());
        }
    }

    private final NV1 t() {
        return AbstractC10533bm0.d(this.c, this.g, null, new c(null), 2, null).s(new UA2() { // from class: ir.nasim.sG3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21191tG3.u(this.a, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(C21191tG3 c21191tG3, Throwable th) {
        AbstractC13042fc3.i(c21191tG3, "this$0");
        if (th == null || (th instanceof CancellationException)) {
            c21191tG3.w();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap v() {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 w() {
        return AbstractC10533bm0.d(this.h, this.g, null, new d(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(ir.nasim.C11458d25 r6, java.util.Set r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C21191tG3.e
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.tG3$e r0 = (ir.nasim.C21191tG3.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.tG3$e r0 = new ir.nasim.tG3$e
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r8)
            goto L68
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.b
            ir.nasim.d25 r6 = (ir.nasim.C11458d25) r6
            java.lang.Object r7 = r0.a
            ir.nasim.tG3 r7 = (ir.nasim.C21191tG3) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L53
        L40:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.vY7 r8 = r5.d
            r0.a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r8 = r8.a(r6, r7, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            r7 = r5
        L53:
            ir.nasim.Fq2 r8 = (ir.nasim.InterfaceC4557Fq2) r8
            ir.nasim.tG3$f r2 = new ir.nasim.tG3$f
            r2.<init>(r6)
            r6 = 0
            r0.a = r6
            r0.b = r6
            r0.e = r3
            java.lang.Object r6 = r8.b(r2, r0)
            if (r6 != r1) goto L68
            return r1
        L68:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21191tG3.x(ir.nasim.d25, java.util.Set, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap y() {
        return new HashMap();
    }

    public final void r(C11458d25 c11458d25, long j, long j2, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        if (this.b) {
            ReentrantReadWriteLock.ReadLock lock = this.i.readLock();
            lock.lock();
            try {
                C7167Qo1 c7167Qo1 = new C7167Qo1(j2, j, z);
                HashMap mapN = n();
                Object hashSet = mapN.get(c11458d25);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    mapN.put(c11458d25, hashSet);
                }
                ((HashSet) hashSet).add(c7167Qo1);
                lock.unlock();
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }
    }

    public final void s(C11458d25 c11458d25, J44 j44, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        if (this.b) {
            ReentrantReadWriteLock.ReadLock lock = this.i.readLock();
            lock.lock();
            try {
                k(c11458d25, j44, z);
                C19938rB7 c19938rB7 = C19938rB7.a;
            } finally {
                lock.unlock();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C21191tG3(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC22621vY7 interfaceC22621vY7, InterfaceC19305q74 interfaceC19305q74, SettingsModule settingsModule, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro12) {
        this(1000L, !C18252oL4.e(), interfaceC20315ro1, interfaceC22621vY7, interfaceC19305q74, settingsModule, abstractC13778go1, interfaceC20315ro12);
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(interfaceC22621vY7, "viewsRepository");
        AbstractC13042fc3.i(interfaceC19305q74, "messageRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro12, "applicationCoroutineScope");
    }
}
