package defpackage;

import android.view.MotionEvent;
import androidx.compose.foundation.layout.f;
import androidx.compose.foundation.layout.h;
import androidx.compose.ui.c;
import androidx.compose.ui.e;
import defpackage.m;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC4139Dv7;
import ir.nasim.AbstractC6797Pa1;
import ir.nasim.C11932dn4;
import ir.nasim.C14063hH6;
import ir.nasim.C19938rB7;
import ir.nasim.C21669tv7;
import ir.nasim.C9361Zp2;
import ir.nasim.DG7;
import ir.nasim.FV0;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11819dc1;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15247jG;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC16978mB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC4788Go2;
import ir.nasim.InterfaceC5342Ix7;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.PQ7;
import ir.nasim.QJ5;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.ZG4;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C21669tv7 a;
        final /* synthetic */ InterfaceC4788Go2 b;
        final /* synthetic */ int c;
        final /* synthetic */ List d;
        final /* synthetic */ Object e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ InterfaceC16978mB2 g;
        final /* synthetic */ int h;

        /* renamed from: m$a$a, reason: collision with other inner class name */
        static final class C1834a implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC4788Go2 a;

            C1834a(InterfaceC4788Go2 interfaceC4788Go2) {
                this.a = interfaceC4788Go2;
            }

            public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(bVar, "$this$animateFloat");
                interfaceC22053ub1.W(-1703569616);
                InterfaceC4788Go2 interfaceC4788Go2 = this.a;
                interfaceC22053ub1.Q();
                return interfaceC4788Go2;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            }
        }

        a(C21669tv7 c21669tv7, InterfaceC4788Go2 interfaceC4788Go2, int i, List list, Object obj, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC16978mB2 interfaceC16978mB2, int i2) {
            this.a = c21669tv7;
            this.b = interfaceC4788Go2;
            this.c = i;
            this.d = list;
            this.e = obj;
            this.f = interfaceC9102Ym4;
            this.g = interfaceC16978mB2;
            this.h = i2;
        }

        private static final float b(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Number) interfaceC9664aL6.getValue()).floatValue();
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C21669tv7 c21669tv7 = this.a;
            C1834a c1834a = new C1834a(this.b);
            int i2 = this.c;
            List list = this.d;
            Object obj = this.e;
            InterfaceC5342Ix7 interfaceC5342Ix7D = PQ7.d(C9361Zp2.a);
            Object objH = c21669tv7.h();
            interfaceC22053ub1.W(-1329360673);
            float f = (i2 != list.size() + (-1) || AbstractC13042fc3.d(objH, obj)) ? 1.0f : 0.0f;
            interfaceC22053ub1.Q();
            Float fValueOf = Float.valueOf(f);
            Object objO = c21669tv7.o();
            interfaceC22053ub1.W(-1329360673);
            float f2 = (i2 != list.size() + (-1) || AbstractC13042fc3.d(objO, obj)) ? 1.0f : 0.0f;
            interfaceC22053ub1.Q();
            e eVarO = m.o(e.a, b(AbstractC4139Dv7.e(c21669tv7, fValueOf, Float.valueOf(f2), (InterfaceC4788Go2) c1834a.q(c21669tv7.m(), interfaceC22053ub1, 0), interfaceC5342Ix7D, "", interfaceC22053ub1, 196608)), m.h(this.f));
            InterfaceC16978mB2 interfaceC16978mB2 = this.g;
            Object obj2 = this.e;
            int i3 = this.h;
            InterfaceC10970cW3 interfaceC10970cW3G = f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            e eVarE = c.e(interfaceC22053ub1, eVarO);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            h hVar = h.a;
            interfaceC22053ub1.W(1304229663);
            interfaceC16978mB2.e(p.a, obj2, interfaceC22053ub1, Integer.valueOf((i3 & 8) << 3));
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11932dn4 c;
        final /* synthetic */ C14063hH6 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C11932dn4 c11932dn4, C14063hH6 c14063hH6, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c11932dn4;
            this.d = c14063hH6;
            this.e = sa2;
            this.f = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean y(C11932dn4 c11932dn4, o oVar) {
            return !AbstractC13042fc3.d(oVar.b(), c11932dn4.b());
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (!m.j(this.f) && AbstractC13042fc3.d(this.c.a(), this.c.b())) {
                C14063hH6 c14063hH6 = this.d;
                final C11932dn4 c11932dn4 = this.c;
                AbstractC13610gX0.K(c14063hH6, new UA2() { // from class: n
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(m.b.y(c11932dn4, (o) obj2));
                    }
                });
                this.e.invoke();
            }
            m.k(this.f, false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ac A[LOOP:1: B:98:0x01a6->B:100:0x01ac, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0324 A[LOOP:0: B:136:0x031e->B:138:0x0324, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(final java.lang.Object r24, androidx.compose.ui.e r25, ir.nasim.InterfaceC4788Go2 r26, ir.nasim.SA2 r27, final ir.nasim.InterfaceC16978mB2 r28, ir.nasim.InterfaceC22053ub1 r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m.d(java.lang.Object, androidx.compose.ui.e, ir.nasim.Go2, ir.nasim.SA2, ir.nasim.mB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(InterfaceC9102Ym4 interfaceC9102Ym4, MotionEvent motionEvent) {
        ZG4 zg4D;
        AbstractC13042fc3.i(interfaceC9102Ym4, "$offset$delegate");
        AbstractC13042fc3.i(motionEvent, "it");
        if (motionEvent.getAction() == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            zg4D = ZG4.d(ZG4.e((Float.floatToRawIntBits(x) << 32) | (Float.floatToRawIntBits(y) & 4294967295L)));
        } else {
            zg4D = null;
        }
        i(interfaceC9102Ym4, zg4D);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(Object obj, e eVar, InterfaceC4788Go2 interfaceC4788Go2, SA2 sa2, InterfaceC16978mB2 interfaceC16978mB2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC16978mB2, "$content");
        d(obj, eVar, interfaceC4788Go2, sa2, interfaceC16978mB2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZG4 h(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (ZG4) interfaceC9102Ym4.getValue();
    }

    private static final void i(InterfaceC9102Ym4 interfaceC9102Ym4, ZG4 zg4) {
        interfaceC9102Ym4.setValue(zg4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    public static final e o(e eVar, float f, ZG4 zg4) {
        AbstractC13042fc3.i(eVar, "$this$circularReveal");
        return eVar.i(FV0.a(eVar, new q(f, zg4, null)));
    }
}
