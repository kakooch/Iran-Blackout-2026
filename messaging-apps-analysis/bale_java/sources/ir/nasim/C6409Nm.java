package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.Nm, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6409Nm {
    private final C4284Em a;
    private final InterfaceC20315ro1 b;

    /* renamed from: ir.nasim.Nm$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6409Nm.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4284Em c4284Em = C6409Nm.this.a;
                String str = this.d;
                this.b = 1;
                if (c4284Em.h(str, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nm$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ Object f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = str2;
            this.f = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6409Nm.this.new b(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4284Em c4284Em = C6409Nm.this.a;
                String str = this.d;
                String str2 = this.e;
                Object obj2 = this.f;
                this.b = 1;
                if (c4284Em.g(str, str2, obj2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nm$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ Map e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Map map, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = map;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6409Nm.this.new c(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4284Em c4284Em = C6409Nm.this.a;
                String str = this.d;
                Map map = this.e;
                this.b = 1;
                if (c4284Em.f(str, map, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C6409Nm(C4284Em c4284Em, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c4284Em, "analyticsDataSource");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        this.a = c4284Em;
        this.b = interfaceC20315ro1;
    }

    public final InterfaceC13730gj3 b(String str) {
        AbstractC13042fc3.i(str, "eventName");
        return AbstractC10533bm0.d(this.b, null, null, new a(str, null), 3, null);
    }

    public final InterfaceC13730gj3 c(String str, String str2, Object obj) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(str2, "key");
        AbstractC13042fc3.i(obj, "value");
        return AbstractC10533bm0.d(this.b, null, null, new b(str, str2, obj, null), 3, null);
    }

    public final InterfaceC13730gj3 d(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        return AbstractC10533bm0.d(this.b, null, null, new c(str, map, null), 3, null);
    }
}
