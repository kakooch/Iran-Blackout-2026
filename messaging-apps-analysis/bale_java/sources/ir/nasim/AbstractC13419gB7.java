package ir.nasim;

import ir.nasim.C9475a16;
import kotlinx.coroutines.TimeoutCancellationException;

/* renamed from: ir.nasim.gB7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13419gB7 {
    public static final void a(InterfaceC14603iB2 interfaceC14603iB2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        InterfaceC20295rm1 interfaceC20295rm1A = WA1.a(interfaceC20295rm1);
        try {
            InterfaceC11938do1 context = interfaceC20295rm1.getContext();
            Object objC = AbstractC7173Qo7.c(context, null);
            try {
                Object objInvoke = ((InterfaceC14603iB2) AbstractC19810qy7.g(interfaceC14603iB2, 2)).invoke(obj, interfaceC20295rm1A);
                if (objInvoke != AbstractC14862ic3.e()) {
                    interfaceC20295rm1A.resumeWith(C9475a16.b(objInvoke));
                }
            } finally {
                AbstractC7173Qo7.a(context, objC);
            }
        } catch (Throwable th) {
            C9475a16.a aVar = C9475a16.b;
            interfaceC20295rm1A.resumeWith(C9475a16.b(AbstractC10685c16.a(th)));
        }
    }

    public static final Object b(C18419od6 c18419od6, Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        Object b01;
        Object objG0;
        try {
            b01 = ((InterfaceC14603iB2) AbstractC19810qy7.g(interfaceC14603iB2, 2)).invoke(obj, c18419od6);
        } catch (Throwable th) {
            b01 = new B01(th, false, 2, null);
        }
        if (b01 != AbstractC14862ic3.e() && (objG0 = c18419od6.G0(b01)) != AbstractC23321wj3.b) {
            if (objG0 instanceof B01) {
                throw ((B01) objG0).a;
            }
            return AbstractC23321wj3.h(objG0);
        }
        return AbstractC14862ic3.e();
    }

    public static final Object c(C18419od6 c18419od6, Object obj, InterfaceC14603iB2 interfaceC14603iB2) throws Throwable {
        Object b01;
        Object objG0;
        try {
            b01 = ((InterfaceC14603iB2) AbstractC19810qy7.g(interfaceC14603iB2, 2)).invoke(obj, c18419od6);
        } catch (Throwable th) {
            b01 = new B01(th, false, 2, null);
        }
        if (b01 != AbstractC14862ic3.e() && (objG0 = c18419od6.G0(b01)) != AbstractC23321wj3.b) {
            if (objG0 instanceof B01) {
                Throwable th2 = ((B01) objG0).a;
                if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).coroutine != c18419od6) {
                    throw th2;
                }
                if (b01 instanceof B01) {
                    throw ((B01) b01).a;
                }
            } else {
                b01 = AbstractC23321wj3.h(objG0);
            }
            return b01;
        }
        return AbstractC14862ic3.e();
    }
}
