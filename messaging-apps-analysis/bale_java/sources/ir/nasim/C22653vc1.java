package ir.nasim;

import android.os.SystemClock;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.core.network.dns.model.DnsResolution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ir.nasim.vc1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22653vc1 implements InterfaceC23154wR7 {
    private final InterfaceC11732dW1 b;
    private final InterfaceC12984fW1 c;
    private final Set d;
    private final SA2 e;
    private final AbstractC13778go1 f;
    private boolean g;
    private final ReentrantLock h;
    private final HashMap i;

    /* renamed from: ir.nasim.vc1$a */
    /* synthetic */ class a extends EB2 implements SA2 {
        public static final a a = new a();

        a() {
            super(0, SystemClock.class, "uptimeMillis", "uptimeMillis()J", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(SystemClock.uptimeMillis());
        }
    }

    /* renamed from: ir.nasim.vc1$b */
    static final class b implements UA2 {
        final /* synthetic */ HE0 a;
        final /* synthetic */ AtomicBoolean b;
        final /* synthetic */ C12889fL5 c;
        final /* synthetic */ AtomicInteger d;
        final /* synthetic */ InterfaceC24823zG1 e;

        b(HE0 he0, AtomicBoolean atomicBoolean, C12889fL5 c12889fL5, AtomicInteger atomicInteger, InterfaceC24823zG1 interfaceC24823zG1) {
            this.a = he0;
            this.b = atomicBoolean;
            this.c = c12889fL5;
            this.d = atomicInteger;
            this.e = interfaceC24823zG1;
        }

        public final void a(Throwable th) {
            if (th != null) {
                if (this.a.b() && this.b.compareAndSet(false, true)) {
                    HE0 he0 = this.a;
                    C9475a16.a aVar = C9475a16.b;
                    he0.resumeWith(C9475a16.b(AbstractC10685c16.a(th)));
                }
                List list = (List) this.c.a;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((NV1) it.next()).dispose();
                    }
                    return;
                }
                return;
            }
            if (this.d.decrementAndGet() == 0) {
                if (this.a.b() && this.b.compareAndSet(false, true)) {
                    HE0 he02 = this.a;
                    C9475a16.a aVar2 = C9475a16.b;
                    he02.resumeWith(C9475a16.b(this.e.k()));
                    return;
                }
                return;
            }
            DnsResolution dnsResolution = (DnsResolution) this.e.k();
            if (dnsResolution == null) {
                return;
            }
            if (this.a.b() && this.b.compareAndSet(false, true)) {
                this.a.resumeWith(C9475a16.b(dnsResolution));
            }
            List list2 = (List) this.c.a;
            if (list2 != null) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    ((NV1) it2.next()).dispose();
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vc1$c */
    static final class c implements UA2 {
        final /* synthetic */ C12889fL5 a;

        c(C12889fL5 c12889fL5) {
            this.a = c12889fL5;
        }

        public final void a(Throwable th) {
            Iterator it = ((Iterable) this.a.a).iterator();
            while (it.hasNext()) {
                ((NV1) it.next()).dispose();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vc1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String e;

        /* renamed from: ir.nasim.vc1$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC12984fW1 c;
            final /* synthetic */ String d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC12984fW1 interfaceC12984fW1, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC12984fW1;
                this.d = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return this.c.b(this.d);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C22653vc1.this.new d(this.e, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            List list;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                Set set = C22653vc1.this.d;
                C22653vc1 c22653vc1 = C22653vc1.this;
                String str = this.e;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(set, 10));
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    arrayList.add(C22653vc1.l(c22653vc1, interfaceC20315ro1, null, new a((InterfaceC12984fW1) it.next(), str, null), 1, null));
                }
                C22653vc1 c22653vc12 = C22653vc1.this;
                this.c = arrayList;
                this.b = 1;
                obj = c22653vc12.j(arrayList, this);
                if (obj == objE) {
                    return objE;
                }
                list = arrayList;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.c;
                AbstractC10685c16.b(obj);
            }
            DnsResolution dnsResolution = (DnsResolution) obj;
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                InterfaceC13730gj3.a.a((InterfaceC13730gj3) it2.next(), null, 1, null);
            }
            return dnsResolution;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vc1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        long b;
        int c;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22653vc1.this.new e(this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            long j;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                DnsResolution dnsResolution = C22653vc1.this.b.get(this.e);
                if (dnsResolution != null) {
                    C19406qI3.a("DnsResolver", "Cache hits for host: " + this.e + " to resolution: " + dnsResolution, new Object[0]);
                    return dnsResolution;
                }
                long jLongValue = ((Number) C22653vc1.this.e.invoke()).longValue();
                C22653vc1 c22653vc1 = C22653vc1.this;
                String str = this.e;
                this.b = jLongValue;
                this.c = 1;
                obj = c22653vc1.m(str, this);
                if (obj == objE) {
                    return objE;
                }
                j = jLongValue;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.b;
                AbstractC10685c16.b(obj);
            }
            DnsResolution dnsResolution2 = (DnsResolution) obj;
            if (dnsResolution2 == null) {
                C19406qI3.b("DnsResolver", "Cache failed for host: " + this.e + ", took " + (((Number) C22653vc1.this.e.invoke()).longValue() - j) + " ms");
                return null;
            }
            String str2 = this.e;
            C22653vc1 c22653vc12 = C22653vc1.this;
            C19406qI3.a("DnsResolver", "Cache misses for host: " + str2 + ", took " + (((Number) c22653vc12.e.invoke()).longValue() - j) + " ms, resolution: " + dnsResolution2, new Object[0]);
            if (dnsResolution2.isVerified()) {
                c22653vc12.b.a(dnsResolution2);
            } else {
                c22653vc12.i(dnsResolution2);
            }
            return dnsResolution2;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C22653vc1(InterfaceC11732dW1 interfaceC11732dW1, InterfaceC12984fW1 interfaceC12984fW1, Set set, SA2 sa2, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC11732dW1, "cache");
        AbstractC13042fc3.i(interfaceC12984fW1, "baleDnsResolver");
        AbstractC13042fc3.i(set, "dnsResolvers");
        AbstractC13042fc3.i(sa2, "timeInMillisProvider");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = interfaceC11732dW1;
        this.c = interfaceC12984fW1;
        this.d = set;
        this.e = sa2;
        this.f = abstractC13778go1;
        this.h = new ReentrantLock(true);
        this.i = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(DnsResolution dnsResolution) {
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            DnsResolution dnsResolution2 = (DnsResolution) this.i.get(dnsResolution.getHost());
            if (dnsResolution2 == null) {
                this.i.put(dnsResolution.getHost(), dnsResolution);
            } else {
                this.i.put(dnsResolution.getHost(), DnsResolution.copy$default(dnsResolution2, null, 0L, AbstractC15401jX0.m1(AbstractC15401jX0.s1(dnsResolution2.getAddresses(), dnsResolution.getAddresses())), false, 11, null));
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        AtomicInteger atomicInteger = new AtomicInteger(this.d.size());
        C12889fL5 c12889fL5 = new C12889fL5();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        List<InterfaceC24823zG1> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (InterfaceC24823zG1 interfaceC24823zG1 : list2) {
            arrayList.add(interfaceC24823zG1.s(new b(ie0, atomicBoolean, c12889fL5, atomicInteger, interfaceC24823zG1)));
        }
        c12889fL5.a = arrayList;
        if (ie0.p()) {
            Iterator it = ((Iterable) c12889fL5.a).iterator();
            while (it.hasNext()) {
                ((NV1) it.next()).dispose();
            }
        } else {
            ie0.J(new c(c12889fL5));
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    private final InterfaceC24823zG1 k(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2) {
        return AbstractC10533bm0.b(interfaceC20315ro1, interfaceC11938do1.X(AbstractC20267rj3.b(null, 1, null)), null, interfaceC14603iB2, 2, null);
    }

    static /* synthetic */ InterfaceC24823zG1 l(C22653vc1 c22653vc1, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        return c22653vc1.k(interfaceC20315ro1, interfaceC11938do1, interfaceC14603iB2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new d(str, null), interfaceC20295rm1);
    }

    private final DnsResolution n(String str) {
        return (DnsResolution) AbstractC9323Zl0.e(this.f, new e(str, null));
    }

    @Override // ir.nasim.InterfaceC23154wR7
    public boolean a(String str, List list) {
        AbstractC13042fc3.i(str, "host");
        AbstractC13042fc3.i(list, "addresses");
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            DnsResolution dnsResolution = (DnsResolution) this.i.remove(str);
            boolean z = false;
            if (dnsResolution != null) {
                if (this.b.get(str) == null) {
                    DnsResolution dnsResolutionCopy$default = DnsResolution.copy$default(dnsResolution, null, dnsResolution.getTtlInMillis() + 3600000, AbstractC15401jX0.m1(AbstractC15401jX0.w0(dnsResolution.getAddresses(), AbstractC15401jX0.r1(list))), true, 1, null);
                    this.b.a(dnsResolutionCopy$default);
                    C19406qI3.a("DnsResolver", dnsResolutionCopy$default + " verified and cached.", new Object[0]);
                }
                z = true;
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // ir.nasim.InterfaceC12984fW1
    public DnsResolution b(String str) {
        Object objB;
        AbstractC13042fc3.i(str, "host");
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(AbstractC12375eW1.a(this.c.b(str), n(str)));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.c("DnsResolver", "Failed to resolve host(" + str + ") with cause:", thE);
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (DnsResolution) objB;
    }

    @Override // ir.nasim.InterfaceC12984fW1
    public void initialize() {
        synchronized (this) {
            try {
                if (this.g) {
                    return;
                }
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((InterfaceC12984fW1) it.next()).initialize();
                }
                this.b.initialize();
                this.g = true;
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C22653vc1(InterfaceC11732dW1 interfaceC11732dW1, AbstractC13778go1 abstractC13778go1, InterfaceC12984fW1 interfaceC12984fW1, Set set) {
        this(interfaceC11732dW1, interfaceC12984fW1, set, a.a, abstractC13778go1);
        AbstractC13042fc3.i(interfaceC11732dW1, "cache");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC12984fW1, "baleDnsResolver");
        AbstractC13042fc3.i(set, "dnsResolvers");
    }
}
