package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.InterfaceC14087hK3;

/* renamed from: ir.nasim.Gs, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4821Gs {

    /* renamed from: ir.nasim.Gs$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;
        final /* synthetic */ InterfaceC14087hK3 e;
        final /* synthetic */ C23677xK3 f;
        final /* synthetic */ int g;
        final /* synthetic */ boolean h;
        final /* synthetic */ float i;
        final /* synthetic */ EnumC22491vK3 j;
        final /* synthetic */ boolean k;
        final /* synthetic */ InterfaceC9102Ym4 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, boolean z2, InterfaceC14087hK3 interfaceC14087hK3, C23677xK3 c23677xK3, int i, boolean z3, float f, AbstractC23087wK3 abstractC23087wK3, EnumC22491vK3 enumC22491vK3, boolean z4, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = z2;
            this.e = interfaceC14087hK3;
            this.f = c23677xK3;
            this.g = i;
            this.h = z3;
            this.i = f;
            this.j = enumC22491vK3;
            this.k = z4;
            this.l = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, this.g, this.h, this.i, null, this.j, this.k, this.l, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c && !AbstractC4821Gs.d(this.l) && this.d) {
                    InterfaceC14087hK3 interfaceC14087hK3 = this.e;
                    this.b = 1;
                    if (AbstractC15287jK3.e(interfaceC14087hK3, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC4821Gs.e(this.l, this.c);
            if (!this.c) {
                return C19938rB7.a;
            }
            InterfaceC14087hK3 interfaceC14087hK32 = this.e;
            C23677xK3 c23677xK3 = this.f;
            int i2 = this.g;
            boolean z = this.h;
            float f = this.i;
            float fB = interfaceC14087hK32.b();
            EnumC22491vK3 enumC22491vK3 = this.j;
            boolean z2 = this.k;
            this.b = 2;
            if (InterfaceC14087hK3.a.a(interfaceC14087hK32, c23677xK3, 0, i2, z, f, null, fB, false, enumC22491vK3, false, z2, this, 514, null) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC17651nK3 c(C23677xK3 c23677xK3, boolean z, boolean z2, boolean z3, AbstractC23087wK3 abstractC23087wK3, float f, int i, EnumC22491vK3 enumC22491vK3, boolean z4, boolean z5, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        interfaceC22053ub1.A(683659508);
        boolean z6 = (i3 & 2) != 0 ? true : z;
        boolean z7 = (i3 & 4) != 0 ? true : z2;
        boolean z8 = (i3 & 8) != 0 ? false : z3;
        AbstractC23087wK3 abstractC23087wK32 = (i3 & 16) != 0 ? null : abstractC23087wK3;
        float f2 = (i3 & 32) != 0 ? 1.0f : f;
        int i4 = (i3 & 64) != 0 ? 1 : i;
        EnumC22491vK3 enumC22491vK32 = (i3 & 128) != 0 ? EnumC22491vK3.a : enumC22491vK3;
        boolean z9 = (i3 & 256) != 0 ? false : z4;
        boolean z10 = (i3 & 512) != 0 ? false : z5;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(683659508, i2, -1, "com.airbnb.lottie.compose.animateLottieCompositionAsState (animateLottieCompositionAsState.kt:54)");
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException(("Iterations must be a positive number (" + i4 + ").").toString());
        }
        if (Float.isInfinite(f2) || Float.isNaN(f2)) {
            throw new IllegalArgumentException(("Speed must be a finite number. It is " + f2 + Separators.DOT).toString());
        }
        InterfaceC14087hK3 interfaceC14087hK3D = AbstractC15287jK3.d(interfaceC22053ub1, 0);
        interfaceC22053ub1.A(-180606964);
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            objB = AbstractC13472gH6.d(Boolean.valueOf(z6), null, 2, null);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
        interfaceC22053ub1.U();
        interfaceC22053ub1.A(-180606834);
        if (!z9) {
            f2 /= AbstractC16500lN7.f((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g()));
        }
        float f3 = f2;
        interfaceC22053ub1.U();
        AbstractC10721c52.h(new Object[]{c23677xK3, Boolean.valueOf(z6), abstractC23087wK32, Float.valueOf(f3), Integer.valueOf(i4)}, new a(z6, z7, interfaceC14087hK3D, c23677xK3, i4, z8, f3, abstractC23087wK32, enumC22491vK32, z10, interfaceC9102Ym4, null), interfaceC22053ub1, 72);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return interfaceC14087hK3D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }
}
