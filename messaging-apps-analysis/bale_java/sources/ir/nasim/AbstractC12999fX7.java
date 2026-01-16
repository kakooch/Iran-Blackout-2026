package ir.nasim;

import androidx.lifecycle.G;

/* renamed from: ir.nasim.fX7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12999fX7 {
    public static final VW7 a(G.c cVar, InterfaceC11299cm3 interfaceC11299cm3, AbstractC20375ru1 abstractC20375ru1) {
        AbstractC13042fc3.i(cVar, "factory");
        AbstractC13042fc3.i(interfaceC11299cm3, "modelClass");
        AbstractC13042fc3.i(abstractC20375ru1, "extras");
        try {
            try {
                return cVar.a(interfaceC11299cm3, abstractC20375ru1);
            } catch (AbstractMethodError unused) {
                return cVar.b(AbstractC4762Gl3.b(interfaceC11299cm3));
            }
        } catch (AbstractMethodError unused2) {
            return cVar.c(AbstractC4762Gl3.b(interfaceC11299cm3), abstractC20375ru1);
        }
    }
}
