package ir.nasim;

import android.view.KeyEvent;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.gm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC13764gm7 {

    /* renamed from: ir.nasim.gm7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ C6542Ny3 e;
        final /* synthetic */ C19101pm7 f;
        final /* synthetic */ C23945xm7 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ InterfaceC11600dH4 j;
        final /* synthetic */ C14612iB7 k;
        final /* synthetic */ UA2 l;
        final /* synthetic */ int m;

        /* renamed from: ir.nasim.gm7$a$a, reason: collision with other inner class name */
        /* synthetic */ class C1260a extends EB2 implements UA2 {
            C1260a(Object obj) {
                super(1, obj, C13173fm7.class, "process", "process-ZmokQxo(Landroid/view/KeyEvent;)Z", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return y(((C20908so3) obj).f());
            }

            public final Boolean y(KeyEvent keyEvent) {
                return Boolean.valueOf(((C13173fm7) this.receiver).l(keyEvent));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C6542Ny3 c6542Ny3, C19101pm7 c19101pm7, C23945xm7 c23945xm7, boolean z, boolean z2, InterfaceC11600dH4 interfaceC11600dH4, C14612iB7 c14612iB7, UA2 ua2, int i) {
            super(3);
            this.e = c6542Ny3;
            this.f = c19101pm7;
            this.g = c23945xm7;
            this.h = z;
            this.i = z2;
            this.j = interfaceC11600dH4;
            this.k = c14612iB7;
            this.l = ua2;
            this.m = i;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(851809892);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(851809892, i, -1, "androidx.compose.foundation.text.textFieldKeyInput.<anonymous> (TextFieldKeyInput.kt:252)");
            }
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C4067Dn7();
                interfaceC22053ub1.s(objB);
            }
            C4067Dn7 c4067Dn7 = (C4067Dn7) objB;
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new LA1();
                interfaceC22053ub1.s(objB2);
            }
            C13173fm7 c13173fm7 = new C13173fm7(this.e, this.f, this.g, this.h, this.i, c4067Dn7, this.j, this.k, (LA1) objB2, null, this.l, this.m, 512, null);
            e.a aVar2 = androidx.compose.ui.e.a;
            boolean zD = interfaceC22053ub1.D(c13173fm7);
            Object objB3 = interfaceC22053ub1.B();
            if (zD || objB3 == aVar.a()) {
                objB3 = new C1260a(c13173fm7);
                interfaceC22053ub1.s(objB3);
            }
            androidx.compose.ui.e eVarA = androidx.compose.ui.input.key.a.a(aVar2, (UA2) ((InterfaceC16733lm3) objB3));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarA;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, C6542Ny3 c6542Ny3, C19101pm7 c19101pm7, C23945xm7 c23945xm7, UA2 ua2, boolean z, boolean z2, InterfaceC11600dH4 interfaceC11600dH4, C14612iB7 c14612iB7, int i) {
        return androidx.compose.ui.c.c(eVar, null, new a(c6542Ny3, c19101pm7, c23945xm7, z, z2, interfaceC11600dH4, c14612iB7, ua2, i), 1, null);
    }
}
