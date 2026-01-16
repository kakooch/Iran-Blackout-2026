package ir.nasim;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.bu6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10619bu6 {

    /* renamed from: ir.nasim.bu6$a */
    private static final class a {
        private final InterfaceC13730gj3 a;
        private final Object b;

        public a(InterfaceC13730gj3 interfaceC13730gj3, Object obj) {
            this.a = interfaceC13730gj3;
            this.b = obj;
        }

        public final InterfaceC13730gj3 a() {
            return this.a;
        }

        public final Object b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.bu6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ AtomicReference e;
        final /* synthetic */ InterfaceC14603iB2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, AtomicReference atomicReference, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
            this.e = atomicReference;
            this.f = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar;
            InterfaceC13730gj3 interfaceC13730gj3A;
            a aVar2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    aVar = new a(AbstractC19067pj3.p(interfaceC20315ro1.getCoroutineContext()), this.d.invoke(interfaceC20315ro1));
                    a aVar3 = (a) this.e.getAndSet(aVar);
                    if (aVar3 != null && (interfaceC13730gj3A = aVar3.a()) != null) {
                        this.c = aVar;
                        this.b = 1;
                        if (AbstractC19067pj3.g(interfaceC13730gj3A, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        aVar2 = (a) this.c;
                        try {
                            AbstractC10685c16.b(obj);
                            AbstractC16775lq5.a(this.e, aVar2, null);
                            return obj;
                        } catch (Throwable th) {
                            th = th;
                            AbstractC16775lq5.a(this.e, aVar2, null);
                            throw th;
                        }
                    }
                    aVar = (a) this.c;
                    AbstractC10685c16.b(obj);
                }
                InterfaceC14603iB2 interfaceC14603iB2 = this.f;
                Object objB = aVar.b();
                this.c = aVar;
                this.b = 2;
                obj = interfaceC14603iB2.invoke(objB, this);
                if (obj == objE) {
                    return objE;
                }
                aVar2 = aVar;
                AbstractC16775lq5.a(this.e, aVar2, null);
                return obj;
            } catch (Throwable th2) {
                th = th2;
                aVar2 = aVar;
                AbstractC16775lq5.a(this.e, aVar2, null);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static AtomicReference a() {
        return b(new AtomicReference(null));
    }

    public static final Object c(AtomicReference atomicReference) {
        a aVar = (a) atomicReference.get();
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public static final Object d(AtomicReference atomicReference, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new b(ua2, atomicReference, interfaceC14603iB2, null), interfaceC20295rm1);
    }

    private static AtomicReference b(AtomicReference atomicReference) {
        return atomicReference;
    }
}
