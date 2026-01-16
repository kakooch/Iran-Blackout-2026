package ir.nasim;

import ir.nasim.C19360qD2;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ir.nasim.qD2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19360qD2 implements InterfaceC17587nD2 {
    private final ConcurrentHashMap a = new ConcurrentHashMap();

    /* renamed from: ir.nasim.qD2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(C19360qD2 c19360qD2, String str, UA2 ua2) {
            c19360qD2.a.remove(str, ua2);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(InterfaceC16204ks5 interfaceC16204ks5, C19951rD2 c19951rD2) {
            QJ0.b(interfaceC16204ks5, c19951rD2);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C19360qD2.this.new a(this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final UA2 ua2 = new UA2() { // from class: ir.nasim.oD2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C19360qD2.a.z(interfaceC16204ks5, (C19951rD2) obj2);
                    }
                };
                C19360qD2.this.a.put(this.e, ua2);
                final C19360qD2 c19360qD2 = C19360qD2.this;
                final String str = this.e;
                SA2 sa2 = new SA2() { // from class: ir.nasim.pD2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C19360qD2.a.D(c19360qD2, str, ua2);
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
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    @Override // ir.nasim.InterfaceC17587nD2
    public InterfaceC4557Fq2 a(String str) {
        AbstractC13042fc3.i(str, "key");
        return AbstractC6459Nq2.f(new a(str, null));
    }

    @Override // ir.nasim.InterfaceC17587nD2
    public void b(String str, C19951rD2 c19951rD2) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(c19951rD2, "result");
        UA2 ua2 = (UA2) this.a.get(str);
        if (ua2 != null) {
            ua2.invoke(c19951rD2);
        }
    }
}
