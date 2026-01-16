package ir.nasim;

import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC16756lo6;
import ir.nasim.KX1;
import ir.nasim.SY1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public final class KX1 {
    private final InterfaceC9336Zm4 a = AbstractC12281eL6.a(AbstractC20051rO3.k());
    private final Map b = new LinkedHashMap();
    private final Map c = new LinkedHashMap();
    private final ReentrantLock d = new ReentrantLock();

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ MX1 e;

        /* renamed from: ir.nasim.KX1$a$a, reason: collision with other inner class name */
        static final class C0466a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ MX1 d;
            final /* synthetic */ InterfaceC16204ks5 e;
            final /* synthetic */ KX1 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0466a(MX1 mx1, InterfaceC16204ks5 interfaceC16204ks5, KX1 kx1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = mx1;
                this.e = interfaceC16204ks5;
                this.f = kx1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0466a c0466a = new C0466a(this.d, this.e, this.f, interfaceC20295rm1);
                c0466a.c = obj;
                return c0466a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Map map = (Map) this.c;
                OX1.a(101, "downloadsStateFlow onEach=" + map, this.d);
                SY1 sy1 = (SY1) map.get(this.d);
                if (sy1 == null) {
                    return C19938rB7.a;
                }
                OX1.a(102, "downloadsStateFlow onEach founded=" + sy1, this.d);
                this.e.h(sy1);
                if ((sy1 instanceof SY1.a) && this.f.j(this.d) == 0) {
                    this.f.k(this.d);
                    InterfaceC16756lo6.a.a(this.e, null, 1, null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0466a) create(map, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(MX1 mx1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = mx1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(MX1 mx1, InterfaceC13730gj3 interfaceC13730gj3, KX1 kx1) {
            OX1.a(100, "callbackFlow closed!", mx1);
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            if (kx1.j(mx1) == 0) {
                kx1.k(mx1);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = KX1.this.new a(this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                KX1.this.d(this.e);
                final InterfaceC13730gj3 interfaceC13730gj3W = AbstractC6459Nq2.W(AbstractC6459Nq2.b0(KX1.this.i(), new C0466a(this.e, interfaceC16204ks5, KX1.this, null)), interfaceC16204ks5);
                final MX1 mx1 = this.e;
                final KX1 kx1 = KX1.this;
                SA2 sa2 = new SA2() { // from class: ir.nasim.JX1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return KX1.a.y(mx1, interfaceC13730gj3W, kx1);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(MX1 mx1) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            Map map = this.c;
            map.put(mx1, Integer.valueOf(((Number) map.getOrDefault(mx1, 0)).intValue() + 1));
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j(MX1 mx1) {
        int i;
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            Integer num = (Integer) this.c.get(mx1);
            if (num == null) {
                reentrantLock.unlock();
                return -1;
            }
            int iIntValue = num.intValue();
            if (iIntValue <= 1) {
                this.c.remove(mx1);
                SY1 sy1 = (SY1) ((Map) this.a.getValue()).get(mx1);
                if (sy1 != null) {
                    this.b.put(mx1, sy1);
                }
                i = 0;
            } else {
                int i2 = iIntValue - 1;
                this.c.put(mx1, Integer.valueOf(i2));
                i = i2;
            }
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(MX1 mx1) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC20051rO3.o((Map) value, mx1)));
    }

    public final void e() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            this.b.clear();
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final SY1 f(MX1 mx1) {
        AbstractC13042fc3.i(mx1, "downloadInput");
        return (SY1) this.b.get(mx1);
    }

    public final SY1 g(C4995Hl2 c4995Hl2) {
        Object next;
        AbstractC13042fc3.i(c4995Hl2, "location");
        Iterator it = this.b.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((MX1) ((Map.Entry) next).getKey()).c(), c4995Hl2)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (SY1) entry.getValue();
        }
        return null;
    }

    public final InterfaceC4557Fq2 h(MX1 mx1) {
        AbstractC13042fc3.i(mx1, "downloadInput");
        return AbstractC6459Nq2.f(new a(mx1, null));
    }

    public final InterfaceC9336Zm4 i() {
        return this.a;
    }

    public final void l(C4995Hl2 c4995Hl2, SY1 sy1) {
        Object next;
        Object value;
        AbstractC13042fc3.i(c4995Hl2, "fileLocation");
        AbstractC13042fc3.i(sy1, "newState");
        OX1.b(301, "updateDownloadState(fileLocation=" + c4995Hl2 + ")= " + sy1, null, 4, null);
        Iterator it = ((Map) this.a.getValue()).keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (AbstractC13042fc3.d(((MX1) next).c(), c4995Hl2)) {
                    break;
                }
            }
        }
        MX1 mx1 = (MX1) next;
        if (mx1 == null) {
            return;
        }
        this.b.put(mx1, sy1);
        OX1.b(302, "cached(fileLocation=" + c4995Hl2 + ")= " + sy1, null, 4, null);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC20051rO3.r((Map) value, AbstractC4616Fw7.a(mx1, sy1))));
    }

    public final void m(MX1 mx1, SY1 sy1) {
        Object value;
        AbstractC13042fc3.i(mx1, "downloadInput");
        AbstractC13042fc3.i(sy1, "newState");
        OX1.a(301, "updateDownloadState= " + sy1, mx1);
        if (!((Map) this.a.getValue()).containsKey(mx1)) {
            this.b.put(mx1, sy1);
            OX1.a(302, "cached= " + sy1, mx1);
        }
        OX1.a(303, "current downloadsStateFlow= " + ((Map) this.a.getValue()).get(mx1), mx1);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC20051rO3.r((Map) value, AbstractC4616Fw7.a(mx1, sy1))));
    }
}
