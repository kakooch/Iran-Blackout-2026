package ir.nasim;

import ir.nasim.C9475a16;
import ir.nasim.GJ0;

/* loaded from: classes8.dex */
abstract /* synthetic */ class RJ0 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC16756lo6 d;
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC16756lo6 interfaceC16756lo6, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC16756lo6;
            this.e = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC16756lo6 interfaceC16756lo6 = this.d;
                    Object obj2 = this.e;
                    C9475a16.a aVar = C9475a16.b;
                    this.b = 1;
                    if (interfaceC16756lo6.o(obj2, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                objB = C9475a16.b(C19938rB7.a);
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            return GJ0.b(C9475a16.j(objB) ? GJ0.b.c(C19938rB7.a) : GJ0.b.a(C9475a16.e(objB)));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(InterfaceC16756lo6 interfaceC16756lo6, Object obj) {
        Object objH = interfaceC16756lo6.h(obj);
        if (objH instanceof GJ0.c) {
            return ((GJ0) AbstractC9913am0.b(null, new a(interfaceC16756lo6, obj, null), 1, null)).k();
        }
        return GJ0.b.c(C19938rB7.a);
    }
}
