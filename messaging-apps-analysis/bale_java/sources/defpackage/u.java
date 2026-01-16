package defpackage;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10721c52;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC7778Td6;
import ir.nasim.C19206px3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17639nJ0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.SA2;

/* loaded from: classes.dex */
public abstract class u {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ t c;
        final /* synthetic */ C19206px3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(t tVar, C19206px3 c19206px3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = tVar;
            this.d = c19206px3;
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
                InterfaceC17639nJ0 interfaceC17639nJ0C = this.c.c();
                this.b = 1;
                obj = interfaceC17639nJ0C.i(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            float fFloatValue = ((Number) obj).floatValue();
            C19206px3 c19206px3 = this.d;
            this.b = 2;
            if (AbstractC7778Td6.c(c19206px3, fFloatValue, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final t a(C19206px3 c19206px3, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c19206px3, "lazyListState");
        AbstractC13042fc3.i(interfaceC14603iB2, "onMove");
        AbstractC13042fc3.i(sa2, "onDragEnd");
        interfaceC22053ub1.W(-822759121);
        interfaceC22053ub1.W(-484144082);
        int i3 = (i2 & 14) ^ 6;
        boolean z = true;
        boolean z2 = ((i3 > 4 && interfaceC22053ub1.V(c19206px3)) || (i2 & 6) == 4) | ((((i2 & 7168) ^ SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) > 2048 && interfaceC22053ub1.e(i)) || (i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 2048);
        Object objB = interfaceC22053ub1.B();
        if (z2 || objB == InterfaceC22053ub1.a.a()) {
            objB = new t(i, c19206px3, interfaceC14603iB2, sa2);
            interfaceC22053ub1.s(objB);
        }
        t tVar = (t) objB;
        interfaceC22053ub1.Q();
        interfaceC22053ub1.W(-484135778);
        boolean zD = interfaceC22053ub1.D(tVar);
        if ((i3 <= 4 || !interfaceC22053ub1.V(c19206px3)) && (i2 & 6) != 4) {
            z = false;
        }
        boolean z3 = zD | z;
        Object objB2 = interfaceC22053ub1.B();
        if (z3 || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = new a(tVar, c19206px3, null);
            interfaceC22053ub1.s(objB2);
        }
        interfaceC22053ub1.Q();
        AbstractC10721c52.e(tVar, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
        interfaceC22053ub1.Q();
        return tVar;
    }
}
