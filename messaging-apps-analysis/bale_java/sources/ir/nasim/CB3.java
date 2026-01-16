package ir.nasim;

import ir.nasim.AbstractC12710f43;

/* loaded from: classes2.dex */
final class CB3 implements InterfaceC23772xV {
    public final AbstractC12710f43 a;
    private final int b;

    private CB3(int i, AbstractC12710f43 abstractC12710f43) {
        this.b = i;
        this.a = abstractC12710f43;
    }

    private static InterfaceC23772xV a(int i, int i2, EW4 ew4) {
        switch (i) {
            case 1718776947:
                return TX6.d(i2, ew4);
            case 1751742049:
                return C24956zV.b(ew4);
            case 1752331379:
                return AV.c(ew4);
            case 1852994675:
                return XX6.a(ew4);
            default:
                return null;
        }
    }

    public static CB3 c(int i, EW4 ew4) {
        AbstractC12710f43.a aVar = new AbstractC12710f43.a();
        int iG = ew4.g();
        int iB = -2;
        while (ew4.a() > 8) {
            int iS = ew4.s();
            int iF = ew4.f() + ew4.s();
            ew4.R(iF);
            InterfaceC23772xV interfaceC23772xVC = iS == 1414744396 ? c(ew4.s(), ew4) : a(iS, iB, ew4);
            if (interfaceC23772xVC != null) {
                if (interfaceC23772xVC.getType() == 1752331379) {
                    iB = ((AV) interfaceC23772xVC).b();
                }
                aVar.a(interfaceC23772xVC);
            }
            ew4.S(iF);
            ew4.R(iG);
        }
        return new CB3(i, aVar.h());
    }

    public InterfaceC23772xV b(Class cls) {
        DB7 it = this.a.iterator();
        while (it.hasNext()) {
            InterfaceC23772xV interfaceC23772xV = (InterfaceC23772xV) it.next();
            if (interfaceC23772xV.getClass() == cls) {
                return interfaceC23772xV;
            }
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC23772xV
    public int getType() {
        return this.b;
    }
}
