package ir.nasim;

/* renamed from: ir.nasim.lm6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16736lm6 {
    private static final InterfaceC15796kB2 a = a.e;
    private static final C14539i47 b = new C14539i47("STATE_REG");
    private static final C14539i47 c = new C14539i47("STATE_COMPLETED");
    private static final C14539i47 d = new C14539i47("STATE_CANCELLED");
    private static final C14539i47 e = new C14539i47("NO_RESULT");
    private static final C14539i47 f = new C14539i47("PARAM_CLAUSE_0");

    /* renamed from: ir.nasim.lm6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final a e = new a();

        a() {
            super(3);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void q(Object obj, Object obj2, Object obj3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnumC19201pw7 a(int i) {
        if (i == 0) {
            return EnumC19201pw7.SUCCESSFUL;
        }
        if (i == 1) {
            return EnumC19201pw7.REREGISTER;
        }
        if (i == 2) {
            return EnumC19201pw7.CANCELLED;
        }
        if (i == 3) {
            return EnumC19201pw7.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i).toString());
    }

    public static final C14539i47 i() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(HE0 he0, UA2 ua2) {
        Object objC = he0.C(C19938rB7.a, null, ua2);
        if (objC == null) {
            return false;
        }
        he0.W(objC);
        return true;
    }
}
