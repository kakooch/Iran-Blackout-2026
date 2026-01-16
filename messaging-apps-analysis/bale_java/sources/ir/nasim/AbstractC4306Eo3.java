package ir.nasim;

import android.view.KeyEvent;

/* renamed from: ir.nasim.Eo3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4306Eo3 {
    private static final InterfaceC3838Co3 a = new a();

    /* renamed from: ir.nasim.Eo3$a */
    public static final class a implements InterfaceC3838Co3 {
        a() {
        }

        @Override // ir.nasim.InterfaceC3838Co3
        public EnumC18526oo3 a(KeyEvent keyEvent) {
            EnumC18526oo3 enumC18526oo3 = null;
            if (AbstractC23371wo3.f(keyEvent) && AbstractC23371wo3.d(keyEvent)) {
                long jA = AbstractC23371wo3.a(keyEvent);
                C13532gO3 c13532gO3 = C13532gO3.a;
                if (AbstractC13780go3.o(jA, c13532gO3.i())) {
                    enumC18526oo3 = EnumC18526oo3.G0;
                } else if (AbstractC13780go3.o(jA, c13532gO3.j())) {
                    enumC18526oo3 = EnumC18526oo3.H0;
                } else if (AbstractC13780go3.o(jA, c13532gO3.k())) {
                    enumC18526oo3 = EnumC18526oo3.Z;
                } else if (AbstractC13780go3.o(jA, c13532gO3.h())) {
                    enumC18526oo3 = EnumC18526oo3.z0;
                }
            } else if (AbstractC23371wo3.d(keyEvent)) {
                long jA2 = AbstractC23371wo3.a(keyEvent);
                C13532gO3 c13532gO32 = C13532gO3.a;
                if (AbstractC13780go3.o(jA2, c13532gO32.i())) {
                    enumC18526oo3 = EnumC18526oo3.j;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.j())) {
                    enumC18526oo3 = EnumC18526oo3.k;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.k())) {
                    enumC18526oo3 = EnumC18526oo3.p;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.h())) {
                    enumC18526oo3 = EnumC18526oo3.q;
                }
            }
            return enumC18526oo3 == null ? AbstractC4072Do3.b().a(keyEvent) : enumC18526oo3;
        }
    }

    public static final InterfaceC3838Co3 a() {
        return a;
    }
}
