package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.fb6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC13035fb6 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(a.e);

    /* renamed from: ir.nasim.fb6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC11814db6 invoke() {
            return null;
        }
    }

    public static final InterfaceC11814db6 a(Map map, UA2 ua2) {
        return new C12426eb6(map, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!AbstractC10868cL0.d(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final AbstractC6535Nx5 e() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C7386Rm4 f(Map map) {
        C7386Rm4 c7386Rm4 = new C7386Rm4(map.size());
        c7386Rm4.t(map);
        return c7386Rm4;
    }
}
