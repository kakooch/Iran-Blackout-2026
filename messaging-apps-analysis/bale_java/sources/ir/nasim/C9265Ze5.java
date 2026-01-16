package ir.nasim;

import android.graphics.Typeface;
import ir.nasim.InterfaceC19228pz7;

/* renamed from: ir.nasim.Ze5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9265Ze5 {
    private final InterfaceC24463yf5 a = AbstractC3759Cf5.a();

    public InterfaceC19228pz7 a(C18046nz7 c18046nz7, InterfaceC9848af5 interfaceC9848af5, UA2 ua2, UA2 ua22) {
        Typeface typefaceA;
        AbstractC9998au2 abstractC9998au2C = c18046nz7.c();
        if (abstractC9998au2C == null ? true : abstractC9998au2C instanceof XD1) {
            typefaceA = this.a.a(c18046nz7.f(), c18046nz7.d());
        } else if (abstractC9998au2C instanceof TE2) {
            typefaceA = this.a.b((TE2) c18046nz7.c(), c18046nz7.f(), c18046nz7.d());
        } else {
            if (!(abstractC9998au2C instanceof C21865uG3)) {
                return null;
            }
            InterfaceC9447Zy7 interfaceC9447Zy7O = ((C21865uG3) c18046nz7.c()).o();
            AbstractC13042fc3.g(interfaceC9447Zy7O, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
            typefaceA = ((InterfaceC17961nr) interfaceC9447Zy7O).a(c18046nz7.f(), c18046nz7.d(), c18046nz7.e());
        }
        return new InterfaceC19228pz7.b(typefaceA, false, 2, null);
    }
}
