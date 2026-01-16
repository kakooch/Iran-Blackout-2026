package ir.nasim;

/* renamed from: ir.nasim.r63, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19885r63 {

    /* renamed from: ir.nasim.r63$a */
    static final class a extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ UA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.c = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UA2 ua2 = this.c;
                this.b = 1;
                obj = AbstractC16704lj4.c(ua2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        InterfaceC18703p63 interfaceC18703p63 = (InterfaceC18703p63) interfaceC20295rm1.getContext().a(InterfaceC18703p63.m0);
        return interfaceC18703p63 == null ? AbstractC16704lj4.c(ua2, interfaceC20295rm1) : interfaceC18703p63.n(new a(ua2, null), interfaceC20295rm1);
    }
}
