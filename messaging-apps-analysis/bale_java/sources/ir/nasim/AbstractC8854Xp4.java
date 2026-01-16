package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Arrays;

/* renamed from: ir.nasim.Xp4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC8854Xp4 {

    /* renamed from: ir.nasim.Xp4$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bundle invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C8588Wp4 c8588Wp4) {
            return c8588Wp4.i0();
        }
    }

    /* renamed from: ir.nasim.Xp4$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Context e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(1);
            this.e = context;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C8588Wp4 invoke(Bundle bundle) {
            C8588Wp4 c8588Wp4C = AbstractC8854Xp4.c(this.e);
            c8588Wp4C.g0(bundle);
            return c8588Wp4C;
        }
    }

    /* renamed from: ir.nasim.Xp4$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Context e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context) {
            super(0);
            this.e = context;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C8588Wp4 invoke() {
            return AbstractC8854Xp4.c(this.e);
        }
    }

    private static final InterfaceC8230Vb6 a(Context context) {
        return AbstractC8464Wb6.a(a.e, new b(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8588Wp4 c(Context context) {
        C8588Wp4 c8588Wp4 = new C8588Wp4(context);
        c8588Wp4.H().b(new C9804ab1(c8588Wp4.H()));
        c8588Wp4.H().b(new C10424bb1());
        c8588Wp4.H().b(new YO1());
        return c8588Wp4;
    }

    public static final InterfaceC9664aL6 d(androidx.navigation.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.A(-120375203);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-120375203, i, -1, "androidx.navigation.compose.currentBackStackEntryAsState (NavHostController.kt:41)");
        }
        InterfaceC9664aL6 interfaceC9664aL6A = AbstractC10222bH6.a(eVar.C(), null, null, interfaceC22053ub1, 56, 2);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return interfaceC9664aL6A;
    }

    public static final C8588Wp4 e(androidx.navigation.p[] pVarArr, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.A(-312215566);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-312215566, i, -1, "androidx.navigation.compose.rememberNavController (NavHostController.kt:57)");
        }
        Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
        C8588Wp4 c8588Wp4 = (C8588Wp4) AbstractC9681aN5.e(Arrays.copyOf(pVarArr, pVarArr.length), a(context), null, new c(context), interfaceC22053ub1, 72, 4);
        for (androidx.navigation.p pVar : pVarArr) {
            c8588Wp4.H().b(pVar);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return c8588Wp4;
    }
}
