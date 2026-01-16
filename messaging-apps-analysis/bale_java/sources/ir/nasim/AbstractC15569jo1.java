package ir.nasim;

import java.util.Iterator;
import kotlinx.coroutines.internal.DiagnosticCoroutineContextException;
import kotlinx.coroutines.internal.ExceptionSuccessfullyProcessed;

/* renamed from: ir.nasim.jo1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15569jo1 {
    public static final void a(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
        Iterator it = AbstractC14979io1.a().iterator();
        while (it.hasNext()) {
            try {
                ((InterfaceC14371ho1) it.next()).m(interfaceC11938do1, th);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th2) {
                AbstractC14979io1.b(AbstractC16160ko1.b(th, th2));
            }
        }
        try {
            AbstractC16632lc2.a(th, new DiagnosticCoroutineContextException(interfaceC11938do1));
        } catch (Throwable unused2) {
        }
        AbstractC14979io1.b(th);
    }
}
