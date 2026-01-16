package ir.nasim;

import android.content.Context;
import java.io.File;

/* renamed from: ir.nasim.Cz1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3935Cz1 {
    public static final C3935Cz1 a = new C3935Cz1();

    private C3935Cz1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File e(Context context) {
        AbstractC13042fc3.i(context, "$appContext");
        return AbstractC17897nk5.a(context, EnumC12211eE.d.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File g(Context context) {
        AbstractC13042fc3.i(context, "$appContext");
        return AbstractC17897nk5.a(context, EnumC12211eE.e.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File i(Context context) {
        AbstractC13042fc3.i(context, "$appContext");
        return AbstractC17897nk5.a(context, EnumC12211eE.f.getKey());
    }

    public final InterfaceC23475wz1 d(final Context context) {
        AbstractC13042fc3.i(context, "appContext");
        return C17306mk5.b(C17306mk5.a, null, null, null, new SA2() { // from class: ir.nasim.Az1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3935Cz1.e(context);
            }
        }, 7, null);
    }

    public final InterfaceC23475wz1 f(final Context context) {
        AbstractC13042fc3.i(context, "appContext");
        return C17306mk5.b(C17306mk5.a, null, null, null, new SA2() { // from class: ir.nasim.zz1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3935Cz1.g(context);
            }
        }, 7, null);
    }

    public final InterfaceC23475wz1 h(final Context context) {
        AbstractC13042fc3.i(context, "appContext");
        return C17306mk5.b(C17306mk5.a, null, null, null, new SA2() { // from class: ir.nasim.Bz1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3935Cz1.i(context);
            }
        }, 7, null);
    }
}
