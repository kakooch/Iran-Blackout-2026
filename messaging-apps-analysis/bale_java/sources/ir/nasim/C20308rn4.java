package ir.nasim;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.rn4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C20308rn4 extends C14376ho6 implements InterfaceC19699qn4 {
    private static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(C20308rn4.class, Object.class, "owner");
    private final InterfaceC15796kB2 h;
    private volatile Object owner;

    /* renamed from: ir.nasim.rn4$a */
    private final class a implements HE0, InterfaceC21726u18 {
        public final IE0 a;
        public final Object b;

        /* renamed from: ir.nasim.rn4$a$a, reason: collision with other inner class name */
        static final class C1522a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C20308rn4 e;
            final /* synthetic */ a f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1522a(C20308rn4 c20308rn4, a aVar) {
                super(1);
                this.e = c20308rn4;
                this.f = aVar;
            }

            public final void a(Throwable th) {
                this.e.e(this.f.b);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.rn4$a$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C20308rn4 e;
            final /* synthetic */ a f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C20308rn4 c20308rn4, a aVar) {
                super(1);
                this.e = c20308rn4;
                this.f = aVar;
            }

            public final void a(Throwable th) {
                C20308rn4.i.set(this.e, this.f.b);
                this.e.e(this.f.b);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        public a(IE0 ie0, Object obj) {
            this.a = ie0;
            this.b = obj;
        }

        @Override // ir.nasim.HE0
        public Object E(Throwable th) {
            return this.a.E(th);
        }

        @Override // ir.nasim.HE0
        public boolean F(Throwable th) {
            return this.a.F(th);
        }

        @Override // ir.nasim.HE0
        public void J(UA2 ua2) {
            this.a.J(ua2);
        }

        @Override // ir.nasim.HE0
        public void W(Object obj) {
            this.a.W(obj);
        }

        @Override // ir.nasim.HE0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void N(C19938rB7 c19938rB7, UA2 ua2) {
            C20308rn4.i.set(C20308rn4.this, this.b);
            this.a.N(c19938rB7, new C1522a(C20308rn4.this, this));
        }

        @Override // ir.nasim.HE0
        public boolean b() {
            return this.a.b();
        }

        @Override // ir.nasim.HE0
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void O(AbstractC13778go1 abstractC13778go1, C19938rB7 c19938rB7) {
            this.a.O(abstractC13778go1, c19938rB7);
        }

        @Override // ir.nasim.InterfaceC21726u18
        public void d(AbstractC23344wl6 abstractC23344wl6, int i) {
            this.a.d(abstractC23344wl6, i);
        }

        @Override // ir.nasim.HE0
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object C(C19938rB7 c19938rB7, Object obj, UA2 ua2) {
            Object objC = this.a.C(c19938rB7, obj, new b(C20308rn4.this, this));
            if (objC != null) {
                C20308rn4.i.set(C20308rn4.this, this.b);
            }
            return objC;
        }

        @Override // ir.nasim.InterfaceC20295rm1
        public InterfaceC11938do1 getContext() {
            return this.a.getContext();
        }

        @Override // ir.nasim.HE0
        public boolean p() {
            return this.a.p();
        }

        @Override // ir.nasim.InterfaceC20295rm1
        public void resumeWith(Object obj) {
            this.a.resumeWith(obj);
        }
    }

    /* renamed from: ir.nasim.rn4$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.rn4$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C20308rn4 e;
            final /* synthetic */ Object f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20308rn4 c20308rn4, Object obj) {
                super(1);
                this.e = c20308rn4;
                this.f = obj;
            }

            public final void a(Throwable th) {
                this.e.e(this.f);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        b() {
            super(3);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UA2 q(InterfaceC16145km6 interfaceC16145km6, Object obj, Object obj2) {
            return new a(C20308rn4.this, obj);
        }
    }

    public C20308rn4(boolean z) {
        super(1, z ? 1 : 0);
        this.owner = z ? null : AbstractC20899sn4.a;
        this.h = new b();
    }

    private final int r(Object obj) {
        while (d()) {
            Object obj2 = i.get(this);
            if (obj2 != AbstractC20899sn4.a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object s(C20308rn4 c20308rn4, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        if (c20308rn4.c(obj)) {
            return C19938rB7.a;
        }
        Object objT = c20308rn4.t(obj, interfaceC20295rm1);
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    private final Object t(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0B = KE0.b(AbstractC14251hc3.c(interfaceC20295rm1));
        try {
            g(new a(ie0B, obj));
            Object objT = ie0B.t();
            if (objT == AbstractC14862ic3.e()) {
                WA1.c(interfaceC20295rm1);
            }
            return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
        } catch (Throwable th) {
            ie0B.H();
            throw th;
        }
    }

    private final int u(Object obj) {
        while (!n()) {
            if (obj == null) {
                return 1;
            }
            int iR = r(obj);
            if (iR == 1) {
                return 2;
            }
            if (iR == 2) {
                return 1;
            }
        }
        i.set(this, obj);
        return 0;
    }

    @Override // ir.nasim.InterfaceC19699qn4
    public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        return s(this, obj, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC19699qn4
    public boolean c(Object obj) {
        int iU = u(obj);
        if (iU == 0) {
            return true;
        }
        if (iU == 1) {
            return false;
        }
        if (iU != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // ir.nasim.InterfaceC19699qn4
    public boolean d() {
        return m() == 0;
    }

    @Override // ir.nasim.InterfaceC19699qn4
    public void e(Object obj) {
        while (d()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != AbstractC20899sn4.a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (F1.a(atomicReferenceFieldUpdater, this, obj2, AbstractC20899sn4.a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public String toString() {
        return "Mutex@" + YA1.b(this) + "[isLocked=" + d() + ",owner=" + i.get(this) + ']';
    }
}
