package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class SJ6 {

    public static final class a extends AbstractC15082iy7 {
        final /* synthetic */ List d;

        a(List list) {
            this.d = list;
        }

        @Override // ir.nasim.AbstractC15082iy7
        public InterfaceC3932Cy7 j(InterfaceC13882gy7 interfaceC13882gy7) {
            AbstractC13042fc3.i(interfaceC13882gy7, "key");
            if (!this.d.contains(interfaceC13882gy7)) {
                return null;
            }
            MU0 mu0D = interfaceC13882gy7.d();
            if (mu0D != null) {
                return AbstractC7497Ry7.s((InterfaceC22882vy7) mu0D);
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    public static final AbstractC4099Dr3 a(InterfaceC22882vy7 interfaceC22882vy7) {
        AbstractC13042fc3.i(interfaceC22882vy7, "<this>");
        List parameters = ((NU0) interfaceC22882vy7.b()).j().getParameters();
        AbstractC13042fc3.h(parameters, "classDescriptor.typeConstructor.parameters");
        List list = parameters;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC22882vy7) it.next()).j());
        }
        C5585Jy7 c5585Jy7G = C5585Jy7.g(new a(arrayList));
        List upperBounds = interfaceC22882vy7.getUpperBounds();
        AbstractC13042fc3.h(upperBounds, "this.upperBounds");
        AbstractC4099Dr3 abstractC4099Dr3P = c5585Jy7G.p((AbstractC4099Dr3) AbstractC15401jX0.q0(upperBounds), KQ7.OUT_VARIANCE);
        if (abstractC4099Dr3P != null) {
            return abstractC4099Dr3P;
        }
        XC6 xc6Y = PI1.g(interfaceC22882vy7).y();
        AbstractC13042fc3.h(xc6Y, "builtIns.defaultBound");
        return xc6Y;
    }
}
