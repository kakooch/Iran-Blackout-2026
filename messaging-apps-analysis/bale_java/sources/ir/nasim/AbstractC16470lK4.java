package ir.nasim;

import kotlinx.coroutines.internal.UndeliveredElementException;

/* renamed from: ir.nasim.lK4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16470lK4 {

    /* renamed from: ir.nasim.lK4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ Object f;
        final /* synthetic */ InterfaceC11938do1 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, Object obj, InterfaceC11938do1 interfaceC11938do1) {
            super(1);
            this.e = ua2;
            this.f = obj;
            this.g = interfaceC11938do1;
        }

        public final void a(Throwable th) {
            AbstractC16470lK4.b(this.e, this.f, this.g);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    public static final UA2 a(UA2 ua2, Object obj, InterfaceC11938do1 interfaceC11938do1) {
        return new a(ua2, obj, interfaceC11938do1);
    }

    public static final void b(UA2 ua2, Object obj, InterfaceC11938do1 interfaceC11938do1) {
        UndeliveredElementException undeliveredElementExceptionC = c(ua2, obj, null);
        if (undeliveredElementExceptionC != null) {
            AbstractC16160ko1.a(interfaceC11938do1, undeliveredElementExceptionC);
        }
    }

    public static final UndeliveredElementException c(UA2 ua2, Object obj, UndeliveredElementException undeliveredElementException) {
        try {
            ua2.invoke(obj);
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException("Exception in undelivered element handler for " + obj, th);
            }
            AbstractC16632lc2.a(undeliveredElementException, th);
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(UA2 ua2, Object obj, UndeliveredElementException undeliveredElementException, int i, Object obj2) {
        if ((i & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(ua2, obj, undeliveredElementException);
    }
}
