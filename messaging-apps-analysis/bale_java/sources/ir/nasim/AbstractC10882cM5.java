package ir.nasim;

/* renamed from: ir.nasim.cM5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10882cM5 {
    private static final C12898fM5 a;
    private static final InterfaceC11299cm3[] b;

    static {
        C12898fM5 c12898fM5 = null;
        try {
            c12898fM5 = (C12898fM5) C13516gM5.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c12898fM5 == null) {
            c12898fM5 = new C12898fM5();
        }
        a = c12898fM5;
        b = new InterfaceC11299cm3[0];
    }

    public static InterfaceC16733lm3 a(DB2 db2) {
        return a.a(db2);
    }

    public static InterfaceC11299cm3 b(Class cls) {
        return a.b(cls);
    }

    public static InterfaceC15551jm3 c(Class cls) {
        return a.c(cls, "");
    }

    public static InterfaceC15551jm3 d(Class cls, String str) {
        return a.c(cls, str);
    }

    public static InterfaceC20888sm3 e(AbstractC5240Im4 abstractC5240Im4) {
        return a.d(abstractC5240Im4);
    }

    public static InterfaceC22165um3 f(AbstractC5708Km4 abstractC5708Km4) {
        return a.e(abstractC5708Km4);
    }

    public static InterfaceC23351wm3 g(AbstractC6175Mm4 abstractC6175Mm4) {
        return a.f(abstractC6175Mm4);
    }

    public static InterfaceC3820Cm3 h(AbstractC23452ww5 abstractC23452ww5) {
        return a.g(abstractC23452ww5);
    }

    public static InterfaceC4288Em3 i(AbstractC24632yw5 abstractC24632yw5) {
        return a.h(abstractC24632yw5);
    }

    public static InterfaceC4771Gm3 j(AbstractC3439Aw5 abstractC3439Aw5) {
        return a.i(abstractC3439Aw5);
    }

    public static String k(InterfaceC23005wB2 interfaceC23005wB2) {
        return a.j(interfaceC23005wB2);
    }

    public static String l(AbstractC8614Ws3 abstractC8614Ws3) {
        return a.k(abstractC8614Ws3);
    }
}
