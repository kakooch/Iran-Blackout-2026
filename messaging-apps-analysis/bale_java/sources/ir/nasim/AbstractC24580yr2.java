package ir.nasim;

import ir.nasim.InterfaceC22053ub1;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.yr2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC24580yr2 {

    /* renamed from: ir.nasim.yr2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC23241wb3 c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* renamed from: ir.nasim.yr2$a$a, reason: collision with other inner class name */
        static final class C1800a implements InterfaceC4806Gq2 {
            final /* synthetic */ List a;
            final /* synthetic */ InterfaceC9102Ym4 b;

            C1800a(List list, InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = list;
                this.b = interfaceC9102Ym4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
                if (interfaceC22645vb3 instanceof C23400wr2) {
                    this.a.add(interfaceC22645vb3);
                } else if (interfaceC22645vb3 instanceof C23990xr2) {
                    this.a.remove(((C23990xr2) interfaceC22645vb3).a());
                }
                this.b.setValue(AbstractC6392Nk0.a(!this.a.isEmpty()));
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC23241wb3 interfaceC23241wb3, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC23241wb3;
            this.d = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ArrayList arrayList = new ArrayList();
                InterfaceC4557Fq2 interfaceC4557Fq2B = this.c.b();
                C1800a c1800a = new C1800a(arrayList, this.d);
                this.b = 1;
                if (interfaceC4557Fq2B.b(c1800a, this) == objE) {
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC9664aL6 a(InterfaceC23241wb3 interfaceC23241wb3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1805515472, i, -1, "androidx.compose.foundation.interaction.collectIsFocusedAsState (FocusInteraction.kt:63)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
        int i2 = i & 14;
        boolean z = ((i2 ^ 6) > 4 && interfaceC22053ub1.V(interfaceC23241wb3)) || (i & 6) == 4;
        Object objB2 = interfaceC22053ub1.B();
        if (z || objB2 == aVar.a()) {
            objB2 = new a(interfaceC23241wb3, interfaceC9102Ym4, null);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.e(interfaceC23241wb3, (InterfaceC14603iB2) objB2, interfaceC22053ub1, i2);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9102Ym4;
    }
}
