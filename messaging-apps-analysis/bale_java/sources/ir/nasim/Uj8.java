package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Uj8 extends Ni8 {
    protected Uj8() {
        this.a.add(EnumC9901ak8.FOR_IN);
        this.a.add(EnumC9901ak8.FOR_IN_CONST);
        this.a.add(EnumC9901ak8.FOR_IN_LET);
        this.a.add(EnumC9901ak8.FOR_LET);
        this.a.add(EnumC9901ak8.FOR_OF);
        this.a.add(EnumC9901ak8.FOR_OF_CONST);
        this.a.add(EnumC9901ak8.FOR_OF_LET);
        this.a.add(EnumC9901ak8.WHILE);
    }

    private static InterfaceC22720vi8 c(Rj8 rj8, Iterator it, InterfaceC22720vi8 interfaceC22720vi8) {
        if (it != null) {
            while (it.hasNext()) {
                InterfaceC22720vi8 interfaceC22720vi8C = rj8.a((InterfaceC22720vi8) it.next()).c((Ch8) interfaceC22720vi8);
                if (interfaceC22720vi8C instanceof Lh8) {
                    Lh8 lh8 = (Lh8) interfaceC22720vi8C;
                    if ("break".equals(lh8.b())) {
                        return InterfaceC22720vi8.r0;
                    }
                    if ("return".equals(lh8.b())) {
                        return lh8;
                    }
                }
            }
        }
        return InterfaceC22720vi8.r0;
    }

    private static InterfaceC22720vi8 d(Rj8 rj8, InterfaceC22720vi8 interfaceC22720vi8, InterfaceC22720vi8 interfaceC22720vi82) {
        return c(rj8, interfaceC22720vi8.r(), interfaceC22720vi82);
    }

    private static InterfaceC22720vi8 e(Rj8 rj8, InterfaceC22720vi8 interfaceC22720vi8, InterfaceC22720vi8 interfaceC22720vi82) {
        if (interfaceC22720vi8 instanceof Iterable) {
            return c(rj8, ((Iterable) interfaceC22720vi8).iterator(), interfaceC22720vi82);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    @Override // ir.nasim.Ni8
    public final InterfaceC22720vi8 a(String str, C20322ro8 c20322ro8, List list) {
        EnumC9901ak8 enumC9901ak8 = EnumC9901ak8.ADD;
        int iOrdinal = AbstractC9951ap8.e(str).ordinal();
        if (iOrdinal == 65) {
            AbstractC9951ap8.h(EnumC9901ak8.WHILE.name(), 4, list);
            InterfaceC22720vi8 interfaceC22720vi8 = (InterfaceC22720vi8) list.get(0);
            InterfaceC22720vi8 interfaceC22720vi82 = (InterfaceC22720vi8) list.get(1);
            InterfaceC22720vi8 interfaceC22720vi83 = (InterfaceC22720vi8) list.get(2);
            InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(3));
            if (c20322ro8.b(interfaceC22720vi83).o().booleanValue()) {
                InterfaceC22720vi8 interfaceC22720vi8C = c20322ro8.c((Ch8) interfaceC22720vi8B);
                if (interfaceC22720vi8C instanceof Lh8) {
                    Lh8 lh8 = (Lh8) interfaceC22720vi8C;
                    if ("break".equals(lh8.b())) {
                        return InterfaceC22720vi8.r0;
                    }
                    if ("return".equals(lh8.b())) {
                        return lh8;
                    }
                }
            }
            while (c20322ro8.b(interfaceC22720vi8).o().booleanValue()) {
                InterfaceC22720vi8 interfaceC22720vi8C2 = c20322ro8.c((Ch8) interfaceC22720vi8B);
                if (interfaceC22720vi8C2 instanceof Lh8) {
                    Lh8 lh82 = (Lh8) interfaceC22720vi8C2;
                    if ("break".equals(lh82.b())) {
                        return InterfaceC22720vi8.r0;
                    }
                    if ("return".equals(lh82.b())) {
                        return lh82;
                    }
                }
                c20322ro8.b(interfaceC22720vi82);
            }
            return InterfaceC22720vi8.r0;
        }
        switch (iOrdinal) {
            case 26:
                AbstractC9951ap8.h(EnumC9901ak8.FOR_IN.name(), 3, list);
                if (!(list.get(0) instanceof Ei8)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                }
                return d(new Tj8(c20322ro8, ((InterfaceC22720vi8) list.get(0)).j()), c20322ro8.b((InterfaceC22720vi8) list.get(1)), c20322ro8.b((InterfaceC22720vi8) list.get(2)));
            case 27:
                AbstractC9951ap8.h(EnumC9901ak8.FOR_IN_CONST.name(), 3, list);
                if (!(list.get(0) instanceof Ei8)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                }
                return d(new Kj8(c20322ro8, ((InterfaceC22720vi8) list.get(0)).j()), c20322ro8.b((InterfaceC22720vi8) list.get(1)), c20322ro8.b((InterfaceC22720vi8) list.get(2)));
            case 28:
                AbstractC9951ap8.h(EnumC9901ak8.FOR_IN_LET.name(), 3, list);
                if (!(list.get(0) instanceof Ei8)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                }
                return d(new Mj8(c20322ro8, ((InterfaceC22720vi8) list.get(0)).j()), c20322ro8.b((InterfaceC22720vi8) list.get(1)), c20322ro8.b((InterfaceC22720vi8) list.get(2)));
            case 29:
                AbstractC9951ap8.h(EnumC9901ak8.FOR_LET.name(), 4, list);
                InterfaceC22720vi8 interfaceC22720vi8B2 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                if (!(interfaceC22720vi8B2 instanceof Ch8)) {
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                }
                Ch8 ch8 = (Ch8) interfaceC22720vi8B2;
                InterfaceC22720vi8 interfaceC22720vi84 = (InterfaceC22720vi8) list.get(1);
                InterfaceC22720vi8 interfaceC22720vi85 = (InterfaceC22720vi8) list.get(2);
                InterfaceC22720vi8 interfaceC22720vi8B3 = c20322ro8.b((InterfaceC22720vi8) list.get(3));
                C20322ro8 c20322ro8A = c20322ro8.a();
                for (int i = 0; i < ch8.w(); i++) {
                    String strJ = ch8.x(i).j();
                    c20322ro8A.g(strJ, c20322ro8.d(strJ));
                }
                while (c20322ro8.b(interfaceC22720vi84).o().booleanValue()) {
                    InterfaceC22720vi8 interfaceC22720vi8C3 = c20322ro8.c((Ch8) interfaceC22720vi8B3);
                    if (interfaceC22720vi8C3 instanceof Lh8) {
                        Lh8 lh83 = (Lh8) interfaceC22720vi8C3;
                        if ("break".equals(lh83.b())) {
                            return InterfaceC22720vi8.r0;
                        }
                        if ("return".equals(lh83.b())) {
                            return lh83;
                        }
                    }
                    C20322ro8 c20322ro8A2 = c20322ro8.a();
                    for (int i2 = 0; i2 < ch8.w(); i2++) {
                        String strJ2 = ch8.x(i2).j();
                        c20322ro8A2.g(strJ2, c20322ro8A.d(strJ2));
                    }
                    c20322ro8A2.b(interfaceC22720vi85);
                    c20322ro8A = c20322ro8A2;
                }
                return InterfaceC22720vi8.r0;
            case 30:
                AbstractC9951ap8.h(EnumC9901ak8.FOR_OF.name(), 3, list);
                if (!(list.get(0) instanceof Ei8)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                }
                return e(new Tj8(c20322ro8, ((InterfaceC22720vi8) list.get(0)).j()), c20322ro8.b((InterfaceC22720vi8) list.get(1)), c20322ro8.b((InterfaceC22720vi8) list.get(2)));
            case 31:
                AbstractC9951ap8.h(EnumC9901ak8.FOR_OF_CONST.name(), 3, list);
                if (!(list.get(0) instanceof Ei8)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                }
                return e(new Kj8(c20322ro8, ((InterfaceC22720vi8) list.get(0)).j()), c20322ro8.b((InterfaceC22720vi8) list.get(1)), c20322ro8.b((InterfaceC22720vi8) list.get(2)));
            case 32:
                AbstractC9951ap8.h(EnumC9901ak8.FOR_OF_LET.name(), 3, list);
                if (!(list.get(0) instanceof Ei8)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                }
                return e(new Mj8(c20322ro8, ((InterfaceC22720vi8) list.get(0)).j()), c20322ro8.b((InterfaceC22720vi8) list.get(1)), c20322ro8.b((InterfaceC22720vi8) list.get(2)));
            default:
                return super.b(str);
        }
    }
}
