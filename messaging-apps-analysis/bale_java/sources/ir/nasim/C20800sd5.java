package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.sd5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20800sd5 {
    public static final int c = C10299bQ2.j;
    private final C10299bQ2 a;
    private final int b;

    /* renamed from: ir.nasim.sd5$a */
    public interface a {
        C20800sd5 a(int i);
    }

    /* renamed from: ir.nasim.sd5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20800sd5.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA2;
            List list;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C10299bQ2 c10299bQ2 = C20800sd5.this.a;
                int i2 = C20800sd5.this.b;
                int i3 = this.d;
                int i4 = this.e;
                this.b = 1;
                objA2 = c10299bQ2.a2(i2, i3, i4, this);
                if (objA2 == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA2 = ((C9475a16) obj).l();
            }
            if (C9475a16.g(objA2)) {
                objA2 = null;
            }
            XV4 xv4 = (XV4) objA2;
            return (xv4 == null || (list = (List) xv4.f()) == null) ? AbstractC10360bX0.m() : list;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C20800sd5(C10299bQ2 c10299bQ2, int i) {
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        this.a = c10299bQ2;
        this.b = i;
    }

    public final Object c(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(i, i2, null), interfaceC20295rm1);
    }
}
