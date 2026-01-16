package ir.nasim;

import ir.nasim.Z06;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class V66 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ AbstractC13778go1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, String str, int i, AbstractC13778go1 abstractC13778go1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
            this.d = str;
            this.e = i;
            this.f = abstractC13778go1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UA2 ua2 = this.c;
                this.b = 1;
                obj = ua2.invoke(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        AbstractC10685c16.b(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                String str = this.d;
                if (str != null) {
                    C19406qI3.a(str, "request succeeded", new Object[0]);
                }
                return new Z06.b(((Z06.b) z06).a());
            }
            if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            int i2 = this.e;
            if (i2 <= 0) {
                String str2 = this.d;
                if (str2 != null) {
                    C19406qI3.a(str2, "request failed terminally", new Object[0]);
                }
                return new Z06.a(((Z06.a) z06).a());
            }
            String str3 = this.d;
            if (str3 != null) {
                C19406qI3.a(str3, "request failed, attempting retry " + i2, new Object[0]);
            }
            UA2 ua22 = this.c;
            int i3 = this.e - 1;
            AbstractC13778go1 abstractC13778go1 = this.f;
            String str4 = this.d;
            this.b = 2;
            obj = V66.a(ua22, i3, abstractC13778go1, str4, this);
            return obj == objE ? objE : obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(UA2 ua2, int i, AbstractC13778go1 abstractC13778go1, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(abstractC13778go1, new a(ua2, str, i, abstractC13778go1, null), interfaceC20295rm1);
    }

    public static /* synthetic */ Object b(UA2 ua2, int i, AbstractC13778go1 abstractC13778go1, String str, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        if ((i2 & 4) != 0) {
            abstractC13778go1 = C12366eV1.b();
        }
        if ((i2 & 8) != 0) {
            str = null;
        }
        return a(ua2, i, abstractC13778go1, str, interfaceC20295rm1);
    }
}
