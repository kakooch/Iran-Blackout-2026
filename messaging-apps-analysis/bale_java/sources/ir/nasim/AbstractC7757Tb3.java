package ir.nasim;

import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.Tb3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7757Tb3 {

    /* renamed from: ir.nasim.Tb3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC7757Tb3.d(((InterfaceC20315ro1) this.c).getCoroutineContext(), this.d);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object b(InterfaceC11938do1 interfaceC11938do1, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(interfaceC11938do1, new a(sa2, null), interfaceC20295rm1);
    }

    public static /* synthetic */ Object c(InterfaceC11938do1 interfaceC11938do1, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        return b(interfaceC11938do1, sa2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(InterfaceC11938do1 interfaceC11938do1, SA2 sa2) throws Throwable {
        try {
            C14387hp7 c14387hp7 = new C14387hp7(AbstractC19067pj3.p(interfaceC11938do1));
            c14387hp7.d();
            try {
                return sa2.invoke();
            } finally {
                c14387hp7.a();
            }
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }
}
