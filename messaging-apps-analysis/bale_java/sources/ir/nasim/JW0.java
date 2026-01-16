package ir.nasim;

import android.content.Context;

/* loaded from: classes2.dex */
public final class JW0 {
    public static final JW0 a = new JW0();
    private static InterfaceC18663p23 b;
    private static InterfaceC21731u23 c;

    private JW0() {
    }

    public static final InterfaceC18663p23 a(Context context) {
        InterfaceC18663p23 interfaceC18663p23 = b;
        return interfaceC18663p23 == null ? a.b(context) : interfaceC18663p23;
    }

    private final synchronized InterfaceC18663p23 b(Context context) {
        InterfaceC18663p23 interfaceC18663p23A;
        try {
            InterfaceC18663p23 interfaceC18663p23 = b;
            if (interfaceC18663p23 != null) {
                return interfaceC18663p23;
            }
            InterfaceC21731u23 interfaceC21731u23 = c;
            if (interfaceC21731u23 == null || (interfaceC18663p23A = interfaceC21731u23.a()) == null) {
                Object applicationContext = context.getApplicationContext();
                InterfaceC21731u23 interfaceC21731u232 = applicationContext instanceof InterfaceC21731u23 ? (InterfaceC21731u23) applicationContext : null;
                interfaceC18663p23A = interfaceC21731u232 != null ? interfaceC21731u232.a() : AbstractC23507x23.a(context);
            }
            c = null;
            b = interfaceC18663p23A;
            return interfaceC18663p23A;
        } catch (Throwable th) {
            throw th;
        }
    }
}
