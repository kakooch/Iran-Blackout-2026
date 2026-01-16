package ir.nasim;

import ir.nasim.C9475a16;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC15522jj4;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Zk0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9314Zk0 implements InterfaceC15522jj4 {
    private final SA2 a;
    private Throwable c;
    private final Object b = new Object();
    private List d = new ArrayList();
    private List e = new ArrayList();
    private final QL f = new QL(0);

    /* renamed from: ir.nasim.Zk0$a */
    private static final class a {
        private final UA2 a;
        private final InterfaceC20295rm1 b;

        public a(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = ua2;
            this.b = interfaceC20295rm1;
        }

        public final InterfaceC20295rm1 a() {
            return this.b;
        }

        public final void b(long j) {
            Object objB;
            InterfaceC20295rm1 interfaceC20295rm1 = this.b;
            try {
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(this.a.invoke(Long.valueOf(j)));
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            interfaceC20295rm1.resumeWith(objB);
        }
    }

    /* renamed from: ir.nasim.Zk0$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ a f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(1);
            this.f = aVar;
        }

        public final void a(Throwable th) {
            Object obj = C9314Zk0.this.b;
            C9314Zk0 c9314Zk0 = C9314Zk0.this;
            a aVar = this.f;
            synchronized (obj) {
                try {
                    c9314Zk0.d.remove(aVar);
                    if (c9314Zk0.d.isEmpty()) {
                        c9314Zk0.f.set(0);
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    public C9314Zk0(SA2 sa2) {
        this.a = sa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(Throwable th) {
        synchronized (this.b) {
            try {
                if (this.c != null) {
                    return;
                }
                this.c = th;
                List list = this.d;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    InterfaceC20295rm1 interfaceC20295rm1A = ((a) list.get(i)).a();
                    C9475a16.a aVar = C9475a16.b;
                    interfaceC20295rm1A.resumeWith(C9475a16.b(AbstractC10685c16.a(th)));
                }
                this.d.clear();
                this.f.set(0);
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ir.nasim.InterfaceC15522jj4
    public Object G(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        a aVar = new a(ua2, ie0);
        synchronized (this.b) {
            Throwable th = this.c;
            if (th != null) {
                C9475a16.a aVar2 = C9475a16.b;
                ie0.resumeWith(C9475a16.b(AbstractC10685c16.a(th)));
            } else {
                boolean z = !this.d.isEmpty();
                this.d.add(aVar);
                if (!z) {
                    this.f.set(1);
                }
                boolean z2 = true ^ z;
                ie0.J(new b(aVar));
                if (z2 && this.a != null) {
                    try {
                        this.a.invoke();
                    } catch (Throwable th2) {
                        t(th2);
                    }
                }
            }
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1) {
        return InterfaceC15522jj4.a.d(this, interfaceC11938do1);
    }

    @Override // ir.nasim.InterfaceC11938do1.b, ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
        return InterfaceC15522jj4.a.b(this, cVar);
    }

    @Override // ir.nasim.InterfaceC11938do1
    public Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        return InterfaceC15522jj4.a.a(this, obj, interfaceC14603iB2);
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
        return InterfaceC15522jj4.a.c(this, cVar);
    }

    public final boolean v() {
        return this.f.get() != 0;
    }

    public final void w(long j) {
        synchronized (this.b) {
            try {
                List list = this.d;
                this.d = this.e;
                this.e = list;
                this.f.set(0);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ((a) list.get(i)).b(j);
                }
                list.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
