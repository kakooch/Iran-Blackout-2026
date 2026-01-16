package androidx.compose.ui.draw;

import ir.nasim.AbstractC24975zX0;
import ir.nasim.EV4;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13157fl1;

/* loaded from: classes2.dex */
public abstract class d {
    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, EV4 ev4, boolean z, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0) {
        return eVar.i(new PainterElement(ev4, z, interfaceC12529em, interfaceC13157fl1, f, abstractC24975zX0));
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, EV4 ev4, boolean z, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            interfaceC12529em = InterfaceC12529em.a.e();
        }
        InterfaceC12529em interfaceC12529em2 = interfaceC12529em;
        if ((i & 8) != 0) {
            interfaceC13157fl1 = InterfaceC13157fl1.a.f();
        }
        InterfaceC13157fl1 interfaceC13157fl12 = interfaceC13157fl1;
        if ((i & 16) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i & 32) != 0) {
            abstractC24975zX0 = null;
        }
        return a(eVar, ev4, z2, interfaceC12529em2, interfaceC13157fl12, f2, abstractC24975zX0);
    }
}
