package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AV7;
import ir.nasim.C17448mz0;
import ir.nasim.C21753u45;
import ir.nasim.C24254yJ;
import ir.nasim.C24381yX0;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.J55;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.List;
import java.util.SortedSet;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public abstract class J55 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ InterfaceC9664aL6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
            this.d = interfaceC9664aL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (J55.p(this.d).e() == C17448mz0.a.d) {
                this.c.invoke(J55.p(this.d).i());
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ Integer a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ C12767fA0 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ InterfaceC9664aL6 g;
        final /* synthetic */ InterfaceC9664aL6 h;

        /* synthetic */ class a extends EB2 implements SA2 {
            a(Object obj) {
                super(0, obj, Activity.class, "onBackPressed", "onBackPressed()V", 0);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                y();
                return C19938rB7.a;
            }

            public final void y() {
                ((Activity) this.receiver).onBackPressed();
            }
        }

        b(Integer num, SA2 sa2, C12767fA0 c12767fA0, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9664aL6 interfaceC9664aL64, InterfaceC9664aL6 interfaceC9664aL65) {
            this.a = num;
            this.b = sa2;
            this.c = c12767fA0;
            this.d = interfaceC9664aL6;
            this.e = interfaceC9664aL62;
            this.f = interfaceC9664aL63;
            this.g = interfaceC9664aL64;
            this.h = interfaceC9664aL65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$openInviteBottomSheet");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.x2();
            return C19938rB7.a;
        }

        public final void c(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            Object objH = interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            AbstractC13042fc3.g(objH, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) objH;
            interfaceC22053ub1.W(543849533);
            boolean zD = interfaceC22053ub1.D(activity);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(activity);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            String strJ = J55.j(this.d);
            C18519on6 c18519on6R = J55.r(this.e);
            C9215Yz0 c9215Yz0C = J55.c(this.f);
            boolean zQ = J55.p(this.g).q();
            boolean zM = J55.w(this.h).m();
            Integer num = this.a;
            SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
            interfaceC22053ub1.W(543853493);
            boolean zV = interfaceC22053ub1.V(this.b);
            final SA2 sa22 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.K55
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return J55.b.d(sa22);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa23 = (SA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(543863322);
            boolean zD2 = interfaceC22053ub1.D(this.c);
            final C12767fA0 c12767fA0 = this.c;
            Object objB3 = interfaceC22053ub1.B();
            if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.L55
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return J55.b.f(c12767fA0);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC6787Oz0.s(num, sa2, strJ, sa23, c18519on6R, c9215Yz0C, zM, zQ, (SA2) objB3, interfaceC22053ub1, (C9215Yz0.y << 15) | (C18519on6.c << 12), 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ ZY0 a;
        final /* synthetic */ C12767fA0 b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ Context d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ InterfaceC9664aL6 g;
        final /* synthetic */ InterfaceC9664aL6 h;
        final /* synthetic */ float i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC9664aL6 k;
        final /* synthetic */ InterfaceC9664aL6 l;
        final /* synthetic */ InterfaceC9664aL6 m;
        final /* synthetic */ InterfaceC9664aL6 n;
        final /* synthetic */ InterfaceC9664aL6 o;
        final /* synthetic */ LK3 p;
        final /* synthetic */ InterfaceC9664aL6 q;
        final /* synthetic */ InterfaceC9664aL6 r;
        final /* synthetic */ InterfaceC9102Ym4 s;
        final /* synthetic */ InterfaceC9102Ym4 t;
        final /* synthetic */ InterfaceC9664aL6 u;

        static final class a implements PointerInputEventHandler {
            final /* synthetic */ boolean a;
            final /* synthetic */ InterfaceC9102Ym4 b;
            final /* synthetic */ InterfaceC9102Ym4 c;

            a(boolean z, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
                this.a = z;
                this.b = interfaceC9102Ym4;
                this.c = interfaceC9102Ym42;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 b(boolean z, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, C6616Og5 c6616Og5, ZG4 zg4) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$localSurfaceOffsetX$delegate");
                AbstractC13042fc3.i(interfaceC9102Ym42, "$localSurfaceOffsetY$delegate");
                AbstractC13042fc3.i(c6616Og5, "change");
                if (z) {
                    J55.e(interfaceC9102Ym4, J55.x(interfaceC9102Ym4) + Float.intBitsToFloat((int) (zg4.t() >> 32)));
                    J55.g(interfaceC9102Ym42, J55.f(interfaceC9102Ym42) + Float.intBitsToFloat((int) (zg4.t() & 4294967295L)));
                }
                c6616Og5.a();
                return C19938rB7.a;
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
                final boolean z = this.a;
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.c;
                Object objF = EZ1.f(interfaceC9049Yg5, null, null, null, new InterfaceC14603iB2() { // from class: ir.nasim.Z55
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return J55.c.a.b(z, interfaceC9102Ym4, interfaceC9102Ym42, (C6616Og5) obj, (ZG4) obj2);
                    }
                }, interfaceC20295rm1, 7, null);
                return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
            }
        }

        static final class b implements PointerInputEventHandler {
            final /* synthetic */ InterfaceC9102Ym4 a;
            final /* synthetic */ InterfaceC9102Ym4 b;
            final /* synthetic */ InterfaceC9102Ym4 c;
            final /* synthetic */ InterfaceC9102Ym4 d;

            b(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC9102Ym4 interfaceC9102Ym44) {
                this.a = interfaceC9102Ym4;
                this.b = interfaceC9102Ym42;
                this.c = interfaceC9102Ym43;
                this.d = interfaceC9102Ym44;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 b(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC9102Ym4 interfaceC9102Ym44, ZG4 zg4, ZG4 zg42, float f, float f2) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$scale$delegate");
                AbstractC13042fc3.i(interfaceC9102Ym42, "$boxSize$delegate");
                AbstractC13042fc3.i(interfaceC9102Ym43, "$parentSize$delegate");
                AbstractC13042fc3.i(interfaceC9102Ym44, "$offset$delegate");
                c.G(interfaceC9102Ym4, AbstractC23053wG5.l(c.F(interfaceC9102Ym4) * f, 1.0f, 5.0f));
                float fMax = Math.max(0.0f, ((((int) (c.L(interfaceC9102Ym42) >> 32)) * c.F(interfaceC9102Ym4)) - ((int) (c.J(interfaceC9102Ym43) >> 32))) / 2.0f);
                float fMax2 = Math.max(0.0f, ((((int) (c.L(interfaceC9102Ym42) & 4294967295L)) * c.F(interfaceC9102Ym4)) - ((int) (c.J(interfaceC9102Ym43) & 4294967295L))) / 2.0f);
                float fL = AbstractC23053wG5.l(Float.intBitsToFloat((int) (c.H(interfaceC9102Ym44) >> 32)) + Float.intBitsToFloat((int) (zg42.t() >> 32)), -fMax, fMax);
                float fL2 = AbstractC23053wG5.l(Float.intBitsToFloat((int) (c.H(interfaceC9102Ym44) & 4294967295L)) + Float.intBitsToFloat((int) (zg42.t() & 4294967295L)), -fMax2, fMax2);
                c.I(interfaceC9102Ym44, ZG4.e((Float.floatToRawIntBits(fL) << 32) | (Float.floatToRawIntBits(fL2) & 4294967295L)));
                return C19938rB7.a;
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.b;
                final InterfaceC9102Ym4 interfaceC9102Ym43 = this.c;
                final InterfaceC9102Ym4 interfaceC9102Ym44 = this.d;
                Object objH = AbstractC12627ev7.h(interfaceC9049Yg5, false, new InterfaceC16978mB2() { // from class: ir.nasim.a65
                    @Override // ir.nasim.InterfaceC16978mB2
                    public final Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                        return J55.c.b.b(interfaceC9102Ym4, interfaceC9102Ym42, interfaceC9102Ym43, interfaceC9102Ym44, (ZG4) obj, (ZG4) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue());
                    }
                }, interfaceC20295rm1, 1, null);
                return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
            }
        }

        c(ZY0 zy0, C12767fA0 c12767fA0, InterfaceC9664aL6 interfaceC9664aL6, Context context, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9664aL6 interfaceC9664aL64, InterfaceC9664aL6 interfaceC9664aL65, float f, boolean z, InterfaceC9664aL6 interfaceC9664aL66, InterfaceC9664aL6 interfaceC9664aL67, InterfaceC9664aL6 interfaceC9664aL68, InterfaceC9664aL6 interfaceC9664aL69, InterfaceC9664aL6 interfaceC9664aL610, LK3 lk3, InterfaceC9664aL6 interfaceC9664aL611, InterfaceC9664aL6 interfaceC9664aL612, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9664aL6 interfaceC9664aL613) {
            this.a = zy0;
            this.b = c12767fA0;
            this.c = interfaceC9664aL6;
            this.d = context;
            this.e = interfaceC9664aL62;
            this.f = interfaceC9664aL63;
            this.g = interfaceC9664aL64;
            this.h = interfaceC9664aL65;
            this.i = f;
            this.j = z;
            this.k = interfaceC9664aL66;
            this.l = interfaceC9664aL67;
            this.m = interfaceC9664aL68;
            this.n = interfaceC9664aL69;
            this.o = interfaceC9664aL610;
            this.p = lk3;
            this.q = interfaceC9664aL611;
            this.r = interfaceC9664aL612;
            this.s = interfaceC9102Ym4;
            this.t = interfaceC9102Ym42;
            this.u = interfaceC9664aL613;
        }

        private static final String D(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (String) interfaceC9102Ym4.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 E(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.N2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float F(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Number) interfaceC9102Ym4.getValue()).floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G(InterfaceC9102Ym4 interfaceC9102Ym4, float f) {
            interfaceC9102Ym4.setValue(Float.valueOf(f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long H(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((ZG4) interfaceC9102Ym4.getValue()).t();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void I(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
            interfaceC9102Ym4.setValue(ZG4.d(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long J(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((C4414Fa3) interfaceC9102Ym4.getValue()).j();
        }

        private static final void K(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
            interfaceC9102Ym4.setValue(C4414Fa3.b(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long L(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((C4414Fa3) interfaceC9102Ym4.getValue()).j();
        }

        private static final void M(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
            interfaceC9102Ym4.setValue(C4414Fa3.b(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 N(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11379cu3 interfaceC11379cu3) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$parentSize$delegate");
            AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
            K(interfaceC9102Ym4, interfaceC11379cu3.a());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 O(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11379cu3 interfaceC11379cu3) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$boxSize$delegate");
            AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
            M(interfaceC9102Ym4, interfaceC11379cu3.a());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 P(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.t(interfaceC11943do6);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean Q(InterfaceC9664aL6 interfaceC9664aL6, Integer num) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$callScreenUiState$delegate");
            if (J55.c(interfaceC9664aL6).w()) {
                int iF = AbstractC5969Lp4.f();
                if (num != null && num.intValue() == iF) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 R(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.O2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 S(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.t(interfaceC11943do6);
            return C19938rB7.a;
        }

        private static final String T(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (String) interfaceC9102Ym4.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C22045ua3 U(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, WH1 wh1) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$localSurfaceOffsetX$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym42, "$localSurfaceOffsetY$delegate");
            AbstractC13042fc3.i(wh1, "$this$offset");
            return C22045ua3.c(C22045ua3.f((AbstractC20723sV3.d(J55.f(interfaceC9102Ym42)) & 4294967295L) | (AbstractC20723sV3.d(J55.x(interfaceC9102Ym4)) << 32)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 V(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.R2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 W(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$localSurfaceBoxContentDescription$delegate");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.F0(interfaceC11943do6, 8.0f);
            AbstractC9939ao6.e0(interfaceC11943do6, T(interfaceC9102Ym4));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean X(InterfaceC9664aL6 interfaceC9664aL6, Integer num) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$callScreenUiState$delegate");
            if (!J55.c(interfaceC9664aL6).w()) {
                int iF = AbstractC5969Lp4.f();
                if (num != null && num.intValue() == iF) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 Y(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.x(interfaceC11943do6);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 Z(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$middleBoxContentDescription$delegate");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.F0(interfaceC11943do6, 7.0f);
            AbstractC9939ao6.e0(interfaceC11943do6, D(interfaceC9102Ym4));
            return C19938rB7.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v19 */
        /* JADX WARN: Type inference failed for: r10v20, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r10v37 */
        public final void C(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
            String strC;
            C12767fA0 c12767fA0;
            InterfaceC9664aL6 interfaceC9664aL6;
            float f;
            InterfaceC9664aL6 interfaceC9664aL62;
            G10 g10;
            InterfaceC9664aL6 interfaceC9664aL63;
            boolean z;
            int i2;
            InterfaceC9664aL6 interfaceC9664aL64;
            G10 g102;
            e.a aVar;
            int i3;
            Context context;
            InterfaceC9102Ym4 interfaceC9102Ym4;
            InterfaceC9102Ym4 interfaceC9102Ym42;
            InterfaceC9664aL6 interfaceC9664aL65;
            InterfaceC9664aL6 interfaceC9664aL66;
            InterfaceC9664aL6 interfaceC9664aL67;
            InterfaceC9664aL6 interfaceC9664aL68;
            InterfaceC9664aL6 interfaceC9664aL69;
            InterfaceC9664aL6 interfaceC9664aL610;
            LK3 lk3;
            InterfaceC22053ub1 interfaceC22053ub12;
            e.a aVar2;
            G10 g103;
            int i4;
            ?? r10;
            float f2;
            ZG6 zg6;
            int i5;
            int i6;
            int i7;
            EV4 ev4H;
            G10 g104;
            int i8;
            e.a aVar3;
            C12767fA0 c12767fA02;
            e.a aVar4;
            G10 g105;
            int i9;
            ZG6 zg62;
            String string;
            e.a aVar5;
            final InterfaceC9102Ym4 interfaceC9102Ym43;
            final InterfaceC9102Ym4 interfaceC9102Ym44;
            int i10;
            EV4 ev4H2;
            androidx.compose.foundation.layout.h hVar;
            G10 g106;
            boolean z2;
            String str;
            String strC2;
            int i11;
            G10 g107;
            e.a aVar6;
            e.a aVar7;
            int i12;
            float fQ;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            boolean zW = J55.c(this.c).w();
            interfaceC22053ub1.W(543891176);
            boolean zA = interfaceC22053ub1.a(zW);
            Context context2 = this.d;
            InterfaceC9664aL6 interfaceC9664aL611 = this.c;
            InterfaceC9664aL6 interfaceC9664aL612 = this.e;
            Object objB = interfaceC22053ub1.B();
            if (zA || objB == InterfaceC22053ub1.a.a()) {
                if (J55.c(interfaceC9664aL611).w()) {
                    strC = context2.getResources().getString(BD5.content_description_you);
                } else {
                    C8942Xx0 c8942Xx0D = J55.p(interfaceC9664aL612).d();
                    if (c8942Xx0D == null || (strC = c8942Xx0D.c()) == null) {
                        strC = "";
                    }
                }
                objB = AbstractC13472gH6.d(strC, null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym45 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            ZY0 zy0 = this.a;
            e.a aVar8 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarL = androidx.compose.foundation.layout.q.l(androidx.compose.foundation.layout.t.h(ZY0.b(zy0, aVar8, 1.0f, false, 2, null), 0.0f, 1, null), C17784nZ1.q(J55.t(this.f).i()), C17784nZ1.q(J55.t(this.f).l()), C17784nZ1.q(J55.t(this.f).j()), C17784nZ1.q(J55.t(this.f).e()));
            G10 g108 = G10.a;
            int i13 = G10.b;
            androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.b.c(eVarL, g108.b(interfaceC22053ub1, i13).f(), N46.b(J55.s(this.g))), N46.b(J55.s(this.g)));
            interfaceC22053ub1.W(543932813);
            Object objB2 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar9 = InterfaceC22053ub1.a;
            if (objB2 == aVar9.a()) {
                objB2 = AbstractC23831xb3.a();
                interfaceC22053ub1.s(objB2);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(543935149);
            boolean zD = interfaceC22053ub1.D(this.b);
            final C12767fA0 c12767fA03 = this.b;
            Object objB3 = interfaceC22053ub1.B();
            if (zD || objB3 == aVar9.a()) {
                objB3 = new SA2() { // from class: ir.nasim.M55
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return J55.c.E(c12767fA03);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.e.d(eVarA, interfaceC18507om4, null, false, null, null, (SA2) objB3, 28, null);
            interfaceC22053ub1.W(543940586);
            boolean zV = interfaceC22053ub1.V(interfaceC9102Ym45);
            Object objB4 = interfaceC22053ub1.B();
            if (zV || objB4 == aVar9.a()) {
                objB4 = new UA2() { // from class: ir.nasim.T55
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return J55.c.Z(interfaceC9102Ym45, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarC = AbstractC6919Pn6.c(eVarD, true, (UA2) objB4);
            InterfaceC9664aL6 interfaceC9664aL613 = this.c;
            InterfaceC9664aL6 interfaceC9664aL614 = this.h;
            float f3 = this.i;
            C12767fA0 c12767fA04 = this.b;
            boolean z3 = this.j;
            InterfaceC9664aL6 interfaceC9664aL615 = this.k;
            InterfaceC9664aL6 interfaceC9664aL616 = this.l;
            InterfaceC9664aL6 interfaceC9664aL617 = this.m;
            InterfaceC9664aL6 interfaceC9664aL618 = this.n;
            InterfaceC9664aL6 interfaceC9664aL619 = this.o;
            LK3 lk32 = this.p;
            InterfaceC9664aL6 interfaceC9664aL620 = this.q;
            InterfaceC9664aL6 interfaceC9664aL621 = this.e;
            InterfaceC9664aL6 interfaceC9664aL622 = this.r;
            Context context3 = this.d;
            InterfaceC9102Ym4 interfaceC9102Ym46 = this.s;
            InterfaceC9102Ym4 interfaceC9102Ym47 = this.t;
            InterfaceC9664aL6 interfaceC9664aL623 = this.u;
            InterfaceC12529em.a aVar10 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar10.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
            InterfaceC16030kb1.a aVar11 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar11.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar11.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar11.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar11.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar11.f());
            androidx.compose.foundation.layout.h hVar2 = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub1.W(-2041608837);
            if (!J55.v(interfaceC9664aL615).s() || J55.c(interfaceC9664aL613).w()) {
                c12767fA0 = c12767fA04;
                interfaceC9664aL6 = interfaceC9664aL614;
                f = f3;
                interfaceC9664aL62 = interfaceC9664aL613;
                g10 = g108;
                interfaceC9664aL63 = interfaceC9664aL615;
                z = z3;
                i2 = i13;
            } else {
                float f4 = 8;
                z = z3;
                c12767fA0 = c12767fA04;
                interfaceC9664aL6 = interfaceC9664aL614;
                f = f3;
                interfaceC9664aL62 = interfaceC9664aL613;
                interfaceC9664aL63 = interfaceC9664aL615;
                i2 = i13;
                g10 = g108;
                AbstractC24667z03.b(FV4.c(KB5.ic_muted_participant, interfaceC22053ub1, 0), null, Ac8.a(androidx.compose.foundation.layout.q.m(hVar2.h(aVar8, aVar10.n()), 0.0f, C17784nZ1.q(f4), C17784nZ1.q(f4), 0.0f, 9, null), 2.0f), g108.b(interfaceC22053ub1, i13).i(), interfaceC22053ub1, 48, 0);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-2041586989);
            if (J55.h(interfaceC9664aL616)) {
                float f5 = 8;
                androidx.compose.ui.e eVarA2 = Ac8.a(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.b.d(FV0.a(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.j(aVar8, C17784nZ1.q(f5), C17784nZ1.q(!J55.c(interfaceC9664aL62).u() ? 40 : 8)), 0.0f, 1, null), N46.d(C17784nZ1.q(f5))), g10.b(interfaceC22053ub1, i2).a(), null, 2, null), 0.0f, C17784nZ1.q(12), 1, null), 2.0f);
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.b(), aVar10.i(), interfaceC22053ub1, 54);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarA2);
                SA2 sa2A2 = aVar11.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A2);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar11.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar11.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar11.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar11.f());
                M66 m66 = M66.a;
                interfaceC9664aL64 = interfaceC9664aL617;
                g102 = g10;
                aVar = aVar8;
                context = context3;
                interfaceC9102Ym4 = interfaceC9102Ym46;
                interfaceC9102Ym42 = interfaceC9102Ym47;
                interfaceC9664aL65 = interfaceC9664aL623;
                interfaceC9664aL66 = interfaceC9664aL619;
                interfaceC9664aL67 = interfaceC9664aL620;
                interfaceC9664aL68 = interfaceC9664aL621;
                interfaceC9664aL69 = interfaceC9664aL622;
                interfaceC9664aL610 = interfaceC9664aL618;
                lk3 = lk32;
                i3 = i2;
                AbstractC9105Ym7.b(UY6.c(AbstractC12217eE5.call_vpn_is_on, interfaceC22053ub1, 0), null, C24381yX0.b.j(), AbstractC13784go7.g(14), null, null, M10.p(), 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, C4049Dl7.b.c(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16711679, (ED1) null), interfaceC22053ub1, 3456, 0, 64946);
                interfaceC22053ub1.u();
            } else {
                interfaceC9664aL64 = interfaceC9664aL617;
                g102 = g10;
                aVar = aVar8;
                i3 = i2;
                context = context3;
                interfaceC9102Ym4 = interfaceC9102Ym46;
                interfaceC9102Ym42 = interfaceC9102Ym47;
                interfaceC9664aL65 = interfaceC9664aL623;
                interfaceC9664aL66 = interfaceC9664aL619;
                interfaceC9664aL67 = interfaceC9664aL620;
                interfaceC9664aL68 = interfaceC9664aL621;
                interfaceC9664aL69 = interfaceC9664aL622;
                interfaceC9664aL610 = interfaceC9664aL618;
                lk3 = lk32;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-2041538208);
            if (((Boolean) J55.n(interfaceC9664aL64).e()).booleanValue()) {
                if (J55.c(interfaceC9664aL62).u()) {
                    i12 = 8;
                    fQ = C17784nZ1.q(8);
                } else {
                    fQ = C17784nZ1.q(40);
                    i12 = 8;
                }
                float f6 = i12;
                e.a aVar12 = aVar;
                G10 g109 = g102;
                int i14 = i3;
                androidx.compose.ui.e eVarA3 = Ac8.a(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.b.d(FV0.a(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.j(aVar12, C17784nZ1.q(f6), fQ), 0.0f, 1, null), N46.d(C17784nZ1.q(f6))), g109.b(interfaceC22053ub1, i14).a(), null, 2, null), 0.0f, C17784nZ1.q(12), 1, null), 2.0f);
                InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(C24254yJ.a.b(), aVar10.i(), interfaceC22053ub1, 54);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarA3);
                SA2 sa2A3 = aVar11.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A3);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar11.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar11.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar11.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar11.f());
                M66 m662 = M66.a;
                String str2 = (String) J55.n(interfaceC9664aL64).f();
                C24381yX0.a aVar13 = C24381yX0.b;
                i6 = 12;
                i4 = i14;
                g103 = g109;
                i7 = i12;
                AbstractC9105Ym7.b(str2, null, aVar13.j(), AbstractC13784go7.g(14), null, null, M10.p(), 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, C4049Dl7.b.c(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16711679, (ED1) null), interfaceC22053ub1, 3456, 0, 64946);
                float fQ2 = C17784nZ1.q(f6);
                aVar2 = aVar12;
                f2 = 0.0f;
                zg6 = null;
                i5 = 2;
                interfaceC22053ub12 = interfaceC22053ub1;
                r10 = 0;
                AbstractC24667z03.b(FV4.c(KB5.call_low_connection_quality, interfaceC22053ub12, 0), null, androidx.compose.foundation.layout.q.k(aVar2, fQ2, 0.0f, 2, null), aVar13.i(), interfaceC22053ub1, 3504, 0);
                interfaceC22053ub1.u();
            } else {
                interfaceC22053ub12 = interfaceC22053ub1;
                aVar2 = aVar;
                g103 = g102;
                i4 = i3;
                r10 = 0;
                f2 = 0.0f;
                zg6 = null;
                i5 = 2;
                i6 = 12;
                i7 = 8;
            }
            interfaceC22053ub1.Q();
            if (J55.l(interfaceC9664aL610)) {
                interfaceC22053ub12.W(1138877969);
                AV7 av7I = J55.c(interfaceC9664aL62).w() ? J55.w(interfaceC9664aL66).o() ? J55.w(interfaceC9664aL66).i() : J55.w(interfaceC9664aL66).k() : (J55.v(interfaceC9664aL63).i() == null || !J55.v(interfaceC9664aL63).n()) ? J55.v(interfaceC9664aL63).k() : J55.v(interfaceC9664aL63).i();
                if (av7I == null || J55.c(interfaceC9664aL62).w() || !J55.v(interfaceC9664aL63).n()) {
                    e.a aVar14 = aVar2;
                    i11 = i4;
                    g107 = g103;
                    interfaceC22053ub1.W(1143232415);
                    AV7.b bVar = av7I instanceof AV7.b ? (AV7.b) av7I : null;
                    if (bVar == null) {
                        aVar6 = aVar14;
                    } else {
                        aVar6 = aVar14;
                        androidx.compose.ui.e eVarH = hVar2.h(aVar6, aVar10.e());
                        InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar10.o(), false);
                        int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
                        SA2 sa2A4 = aVar11.a();
                        if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                            AbstractC6797Pa1.c();
                        }
                        interfaceC22053ub1.G();
                        if (interfaceC22053ub1.h()) {
                            interfaceC22053ub1.g(sa2A4);
                        } else {
                            interfaceC22053ub1.r();
                        }
                        InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1);
                        DG7.c(interfaceC22053ub1A4, interfaceC10970cW3G2, aVar11.e());
                        DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar11.g());
                        InterfaceC14603iB2 interfaceC14603iB2B4 = aVar11.b();
                        if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                            interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                            interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
                        }
                        DG7.c(interfaceC22053ub1A4, eVarE4, aVar11.f());
                        bVar.a().invoke(interfaceC22053ub1, 0);
                        interfaceC22053ub1.u();
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    }
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub12.W(1139811751);
                    interfaceC22053ub12.W(-2041443868);
                    Object objB5 = interfaceC22053ub1.B();
                    if (objB5 == aVar9.a()) {
                        objB5 = AbstractC13472gH6.d(Float.valueOf(1.0f), zg6, i5, zg6);
                        interfaceC22053ub12.s(objB5);
                    }
                    InterfaceC9102Ym4 interfaceC9102Ym48 = (InterfaceC9102Ym4) objB5;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub12.W(-2041441363);
                    Object objB6 = interfaceC22053ub1.B();
                    if (objB6 == aVar9.a()) {
                        objB6 = AbstractC13472gH6.d(ZG4.d(ZG4.b.c()), zg6, i5, zg6);
                        interfaceC22053ub12.s(objB6);
                    }
                    InterfaceC9102Ym4 interfaceC9102Ym49 = (InterfaceC9102Ym4) objB6;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub12.W(-2041438450);
                    Object objB7 = interfaceC22053ub1.B();
                    if (objB7 == aVar9.a()) {
                        objB7 = AbstractC13472gH6.d(C4414Fa3.b(C4414Fa3.b.a()), zg6, i5, zg6);
                        interfaceC22053ub12.s(objB7);
                    }
                    final InterfaceC9102Ym4 interfaceC9102Ym410 = (InterfaceC9102Ym4) objB7;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub12.W(-2041435602);
                    Object objB8 = interfaceC22053ub1.B();
                    if (objB8 == aVar9.a()) {
                        objB8 = AbstractC13472gH6.d(C4414Fa3.b(C4414Fa3.b.a()), zg6, i5, zg6);
                        interfaceC22053ub12.s(objB8);
                    }
                    final InterfaceC9102Ym4 interfaceC9102Ym411 = (InterfaceC9102Ym4) objB8;
                    interfaceC22053ub1.Q();
                    androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar2, f2, 1, zg6);
                    interfaceC22053ub12.W(-2041427415);
                    Object objB9 = interfaceC22053ub1.B();
                    if (objB9 == aVar9.a()) {
                        objB9 = new UA2() { // from class: ir.nasim.U55
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return J55.c.N(interfaceC9102Ym410, (InterfaceC11379cu3) obj);
                            }
                        };
                        interfaceC22053ub12.s(objB9);
                    }
                    interfaceC22053ub1.Q();
                    androidx.compose.ui.e eVarA4 = androidx.compose.ui.layout.c.a(eVarF, (UA2) objB9);
                    C19938rB7 c19938rB72 = C19938rB7.a;
                    interfaceC22053ub12.W(-2041420090);
                    Object objB10 = interfaceC22053ub1.B();
                    if (objB10 == aVar9.a()) {
                        objB10 = new b(interfaceC9102Ym48, interfaceC9102Ym411, interfaceC9102Ym410, interfaceC9102Ym49);
                        interfaceC22053ub12.s(objB10);
                    }
                    interfaceC22053ub1.Q();
                    androidx.compose.ui.e eVarC2 = AbstractC21071t37.c(eVarA4, c19938rB72, (PointerInputEventHandler) objB10);
                    InterfaceC10970cW3 interfaceC10970cW3G3 = androidx.compose.foundation.layout.f.g(aVar10.e(), r10);
                    int iA5 = AbstractC6797Pa1.a(interfaceC22053ub12, r10);
                    InterfaceC11819dc1 interfaceC11819dc1Q5 = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE5 = androidx.compose.ui.c.e(interfaceC22053ub12, eVarC2);
                    SA2 sa2A5 = aVar11.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub12.g(sa2A5);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A5 = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A5, interfaceC10970cW3G3, aVar11.e());
                    DG7.c(interfaceC22053ub1A5, interfaceC11819dc1Q5, aVar11.g());
                    InterfaceC14603iB2 interfaceC14603iB2B5 = aVar11.b();
                    if (interfaceC22053ub1A5.h() || !AbstractC13042fc3.d(interfaceC22053ub1A5.B(), Integer.valueOf(iA5))) {
                        interfaceC22053ub1A5.s(Integer.valueOf(iA5));
                        interfaceC22053ub1A5.v(Integer.valueOf(iA5), interfaceC14603iB2B5);
                    }
                    DG7.c(interfaceC22053ub1A5, eVarE5, aVar11.f());
                    interfaceC22053ub12.W(1605248941);
                    Object objB11 = interfaceC22053ub1.B();
                    if (objB11 == aVar9.a()) {
                        objB11 = new UA2() { // from class: ir.nasim.V55
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return J55.c.O(interfaceC9102Ym411, (InterfaceC11379cu3) obj);
                            }
                        };
                        interfaceC22053ub12.s(objB11);
                    }
                    interfaceC22053ub1.Q();
                    int i15 = i4;
                    G10 g1010 = g103;
                    androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.ui.graphics.b.c(androidx.compose.ui.layout.c.a(aVar2, (UA2) objB11), F(interfaceC9102Ym48), F(interfaceC9102Ym48), 0.0f, Float.intBitsToFloat((int) (H(interfaceC9102Ym49) >> 32)), Float.intBitsToFloat((int) (H(interfaceC9102Ym49) & 4294967295L)), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131044, null), g1010.c(interfaceC22053ub12, i15).b().b());
                    InterfaceC10970cW3 interfaceC10970cW3G4 = androidx.compose.foundation.layout.f.g(aVar10.o(), r10);
                    int iA6 = AbstractC6797Pa1.a(interfaceC22053ub12, r10);
                    InterfaceC11819dc1 interfaceC11819dc1Q6 = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE6 = androidx.compose.ui.c.e(interfaceC22053ub12, eVarI);
                    SA2 sa2A6 = aVar11.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub12.g(sa2A6);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A6 = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A6, interfaceC10970cW3G4, aVar11.e());
                    DG7.c(interfaceC22053ub1A6, interfaceC11819dc1Q6, aVar11.g());
                    InterfaceC14603iB2 interfaceC14603iB2B6 = aVar11.b();
                    if (interfaceC22053ub1A6.h() || !AbstractC13042fc3.d(interfaceC22053ub1A6.B(), Integer.valueOf(iA6))) {
                        interfaceC22053ub1A6.s(Integer.valueOf(iA6));
                        interfaceC22053ub1A6.v(Integer.valueOf(iA6), interfaceC14603iB2B6);
                    }
                    DG7.c(interfaceC22053ub1A6, eVarE6, aVar11.f());
                    AV7.b bVar2 = av7I instanceof AV7.b ? (AV7.b) av7I : zg6;
                    interfaceC22053ub12.W(1637269328);
                    if (bVar2 != 0) {
                        bVar2.a().invoke(interfaceC22053ub12, Integer.valueOf((int) r10));
                    }
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.u();
                    interfaceC22053ub12.W(1605275547);
                    if (J55.c(interfaceC9664aL62).l()) {
                        i11 = i15;
                        g107 = g1010;
                        aVar7 = aVar2;
                        AbstractC15878kK3.a(J55.d(lk3), null, false, false, null, 0.0f, 0, false, false, false, false, null, false, false, null, aVar10.e(), null, false, false, null, false, null, interfaceC22053ub1, 0, 196608, 0, 4161534);
                    } else {
                        i11 = i15;
                        g107 = g1010;
                        aVar7 = aVar2;
                    }
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.Q();
                    aVar6 = aVar7;
                }
                interfaceC22053ub1.Q();
                aVar3 = aVar6;
                i8 = i11;
                g104 = g107;
            } else {
                boolean z4 = r10;
                InterfaceC22053ub1 interfaceC22053ub13 = interfaceC22053ub12;
                e.a aVar15 = aVar2;
                int i16 = i4;
                G10 g1011 = g103;
                interfaceC22053ub13.W(1143671065);
                androidx.compose.ui.e eVarH2 = hVar2.h(aVar15, aVar10.e());
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), aVar10.g(), interfaceC22053ub13, 48);
                int iA7 = AbstractC6797Pa1.a(interfaceC22053ub13, z4 ? 1 : 0);
                InterfaceC11819dc1 interfaceC11819dc1Q7 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE7 = androidx.compose.ui.c.e(interfaceC22053ub13, eVarH2);
                SA2 sa2A7 = aVar11.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub13.g(sa2A7);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A7 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A7, interfaceC10970cW3A, aVar11.e());
                DG7.c(interfaceC22053ub1A7, interfaceC11819dc1Q7, aVar11.g());
                InterfaceC14603iB2 interfaceC14603iB2B7 = aVar11.b();
                if (interfaceC22053ub1A7.h() || !AbstractC13042fc3.d(interfaceC22053ub1A7.B(), Integer.valueOf(iA7))) {
                    interfaceC22053ub1A7.s(Integer.valueOf(iA7));
                    interfaceC22053ub1A7.v(Integer.valueOf(iA7), interfaceC14603iB2B7);
                }
                DG7.c(interfaceC22053ub1A7, eVarE7, aVar11.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                androidx.compose.ui.e eVarA5 = Ac8.a(FV0.a(androidx.compose.foundation.layout.t.t(aVar15, C17784nZ1.q(90)), N46.g()), 2.0f);
                C24381yX0.a aVar16 = C24381yX0.b;
                androidx.compose.ui.e eVarD2 = androidx.compose.foundation.b.d(eVarA5, aVar16.i(), null, 2, null);
                if (J55.c(interfaceC9664aL62).w()) {
                    interfaceC22053ub13.W(-1774578275);
                    ev4H = AvatarAsyncImagePainterKt.h((Avatar) J55.k(interfaceC9664aL67).f(), FV4.c(KB5.ic_voice_call_profile, interfaceC22053ub13, z4 ? 1 : 0), false, 0, interfaceC22053ub1, 0, 12);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub13.W(-1774253953);
                    C8942Xx0 c8942Xx0D2 = J55.p(interfaceC9664aL68).d();
                    ev4H = AvatarAsyncImagePainterKt.h(c8942Xx0D2 != null ? c8942Xx0D2.a() : null, FV4.c(KB5.ic_voice_call_profile, interfaceC22053ub13, z4 ? 1 : 0), false, 0, interfaceC22053ub1, 0, 12);
                    interfaceC22053ub1.Q();
                }
                AbstractC11456d23.b(ev4H, null, eVarD2, null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(c9784aZ0.c(aVar15, aVar10.g()), 0.0f, g1011.c(interfaceC22053ub13, i16).b().r(), 0.0f, 0.0f, 13, null);
                interfaceC22053ub13.W(1605357471);
                Object objB12 = interfaceC22053ub1.B();
                if (objB12 == aVar9.a()) {
                    objB12 = new UA2() { // from class: ir.nasim.W55
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return J55.c.P((InterfaceC11943do6) obj);
                        }
                    };
                    interfaceC22053ub13.s(objB12);
                }
                interfaceC22053ub1.Q();
                g104 = g1011;
                i8 = i16;
                aVar3 = aVar15;
                AbstractC9105Ym7.b(J55.i(interfaceC9664aL69), AbstractC6919Pn6.d(eVarM, z4, (UA2) objB12, 1, null), aVar16.j(), AbstractC13784go7.g(i6), null, null, M10.q(), 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, C4049Dl7.b.e(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16711679, (ED1) null), interfaceC22053ub1, 3456, 0, 64944);
                interfaceC22053ub1.u();
                interfaceC22053ub1.Q();
                C19938rB7 c19938rB73 = C19938rB7.a;
            }
            C18039nz0 c18039nz0 = C18039nz0.a;
            AbstractC11610dI5.c(c18039nz0.c(), interfaceC22053ub1, 0);
            InterfaceC10040ay6 interfaceC10040ay6C = c18039nz0.c();
            interfaceC22053ub1.W(-2041239677);
            final InterfaceC9664aL6 interfaceC9664aL624 = interfaceC9664aL62;
            boolean zV2 = interfaceC22053ub1.V(interfaceC9664aL624);
            Object objB13 = interfaceC22053ub1.B();
            if (zV2 || objB13 == aVar9.a()) {
                objB13 = new UA2() { // from class: ir.nasim.X55
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(J55.c.Q(interfaceC9664aL624, (Integer) obj));
                    }
                };
                interfaceC22053ub1.s(objB13);
            }
            interfaceC22053ub1.Q();
            AbstractC11610dI5.g(interfaceC10040ay6C, (UA2) objB13, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-2041233110);
            C17448mz0.a aVarE = J55.p(interfaceC9664aL68).e();
            C17448mz0.a aVar17 = C17448mz0.a.g;
            if (aVarE == aVar17) {
                androidx.compose.ui.e eVarH3 = hVar2.h(androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.t.h(Ac8.a(androidx.compose.foundation.layout.q.m(aVar3, 0.0f, 0.0f, 0.0f, ((C17784nZ1) interfaceC9664aL6.getValue()).v(), 7, null), 1.0f), 0.0f, 1, null), null, false, 3, null), aVar10.b());
                InterfaceC10970cW3 interfaceC10970cW3G5 = androidx.compose.foundation.layout.f.g(aVar10.o(), false);
                int iA8 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q8 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE8 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH3);
                SA2 sa2A8 = aVar11.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A8);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A8 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A8, interfaceC10970cW3G5, aVar11.e());
                DG7.c(interfaceC22053ub1A8, interfaceC11819dc1Q8, aVar11.g());
                InterfaceC14603iB2 interfaceC14603iB2B8 = aVar11.b();
                if (interfaceC22053ub1A8.h() || !AbstractC13042fc3.d(interfaceC22053ub1A8.B(), Integer.valueOf(iA8))) {
                    interfaceC22053ub1A8.s(Integer.valueOf(iA8));
                    interfaceC22053ub1A8.v(Integer.valueOf(iA8), interfaceC14603iB2B8);
                }
                DG7.c(interfaceC22053ub1A8, eVarE8, aVar11.f());
                e.a aVar18 = aVar3;
                androidx.compose.ui.e eVarH4 = hVar2.h(aVar18, aVar10.e());
                InterfaceC18507om4 interfaceC18507om4A = AbstractC23831xb3.a();
                InterfaceC17521n63 interfaceC17521n63F = androidx.compose.material.a.f(false, 0.0f, C24381yX0.b.j(), 2, null);
                interfaceC22053ub1.W(1605420194);
                final C12767fA0 c12767fA05 = c12767fA0;
                boolean zD2 = interfaceC22053ub1.D(c12767fA05);
                Object objB14 = interfaceC22053ub1.B();
                if (zD2 || objB14 == aVar9.a()) {
                    objB14 = new SA2() { // from class: ir.nasim.Y55
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return J55.c.R(c12767fA05);
                        }
                    };
                    interfaceC22053ub1.s(objB14);
                }
                interfaceC22053ub1.Q();
                G10 g1012 = g104;
                int i17 = i8;
                androidx.compose.ui.e eVarA6 = Ac8.a(FV0.a(androidx.compose.foundation.layout.q.i(androidx.compose.foundation.e.d(eVarH4, interfaceC18507om4A, interfaceC17521n63F, false, null, null, (SA2) objB14, 28, null), g1012.c(interfaceC22053ub1, i17).b().u()), N46.g()), 5.0f);
                interfaceC22053ub1.W(1605433491);
                Object objB15 = interfaceC22053ub1.B();
                if (objB15 == aVar9.a()) {
                    objB15 = new UA2() { // from class: ir.nasim.N55
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return J55.c.S((InterfaceC11943do6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB15);
                }
                interfaceC22053ub1.Q();
                i9 = i17;
                g105 = g1012;
                c12767fA02 = c12767fA05;
                aVar4 = aVar18;
                zg62 = null;
                AbstractC11456d23.b(FV4.c(KB5.ic_call_heart, interfaceC22053ub1, 0), null, AbstractC6919Pn6.d(eVarA6, false, (UA2) objB15, 1, null), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                interfaceC22053ub1.u();
            } else {
                c12767fA02 = c12767fA0;
                aVar4 = aVar3;
                g105 = g104;
                i9 = i8;
                zg62 = null;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-2041166091);
            if (J55.p(interfaceC9664aL68).e() == aVar17 || J55.p(interfaceC9664aL68).e() == C17448mz0.a.a || J55.p(interfaceC9664aL68).e() == C17448mz0.a.b || J55.p(interfaceC9664aL68).e() == C17448mz0.a.c) {
                boolean zW2 = J55.c(interfaceC9664aL624).w();
                interfaceC22053ub1.W(-2041158305);
                boolean zA2 = interfaceC22053ub1.a(zW2);
                Object objB16 = interfaceC22053ub1.B();
                if (zA2 || objB16 == aVar9.a()) {
                    if (J55.c(interfaceC9664aL624).w()) {
                        C8942Xx0 c8942Xx0D3 = J55.p(interfaceC9664aL68).d();
                        if (c8942Xx0D3 != null) {
                            c8942Xx0D3.c();
                        }
                        string = context.getResources().getString(BD5.content_description_is_mute);
                    } else {
                        string = context.getResources().getString(BD5.content_description_you);
                    }
                    objB16 = AbstractC13472gH6.d(string, zg62, 2, zg62);
                    interfaceC22053ub1.s(objB16);
                }
                final InterfaceC9102Ym4 interfaceC9102Ym412 = (InterfaceC9102Ym4) objB16;
                interfaceC22053ub1.Q();
                InterfaceC9664aL6 interfaceC9664aL6C = AbstractC4572Fs.c(J55.c(interfaceC9664aL624).u() ? C17784nZ1.q(0) : C17784nZ1.q(4), null, null, null, interfaceC22053ub1, 0, 14);
                aVar5 = aVar4;
                androidx.compose.ui.e eVarA7 = Ac8.a(aVar5, 4.0f);
                interfaceC22053ub1.W(-2041127643);
                Object objB17 = interfaceC22053ub1.B();
                if (objB17 == aVar9.a()) {
                    interfaceC9102Ym43 = interfaceC9102Ym4;
                    interfaceC9102Ym44 = interfaceC9102Ym42;
                    objB17 = new UA2() { // from class: ir.nasim.O55
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return J55.c.U(interfaceC9102Ym43, interfaceC9102Ym44, (WH1) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB17);
                } else {
                    interfaceC9102Ym43 = interfaceC9102Ym4;
                    interfaceC9102Ym44 = interfaceC9102Ym42;
                }
                interfaceC22053ub1.Q();
                int i18 = i9;
                G10 g1013 = g105;
                androidx.compose.ui.e eVarC3 = androidx.compose.foundation.b.c(hVar2.h(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(FV0.a(androidx.compose.foundation.layout.q.l(androidx.compose.foundation.layout.n.a(eVarA7, (UA2) objB17), g1013.c(interfaceC22053ub1, i18).b().n(), g1013.c(interfaceC22053ub1, i18).b().n(), C17784nZ1.q(g1013.c(interfaceC22053ub1, i18).b().n() + ((C17784nZ1) interfaceC9664aL6C.getValue()).v()), C17784nZ1.q(C17784nZ1.q(44) + ((C17784nZ1) interfaceC9664aL6.getValue()).v())), N46.b(i7)), C17784nZ1.q(f / 4)), C17784nZ1.q(C17784nZ1.q(38 * f) / 100)), aVar10.c()), g1013.b(interfaceC22053ub1, i18).a(), N46.b(4));
                interfaceC22053ub1.W(-2041087277);
                final C12767fA0 c12767fA06 = c12767fA02;
                boolean zD3 = interfaceC22053ub1.D(c12767fA06);
                Object objB18 = interfaceC22053ub1.B();
                if (zD3 || objB18 == aVar9.a()) {
                    objB18 = new SA2() { // from class: ir.nasim.P55
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return J55.c.V(c12767fA06);
                        }
                    };
                    interfaceC22053ub1.s(objB18);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarF2 = androidx.compose.foundation.e.f(eVarC3, false, null, null, (SA2) objB18, 7, null);
                interfaceC22053ub1.W(-2041081337);
                boolean zV3 = interfaceC22053ub1.V(interfaceC9102Ym412);
                Object objB19 = interfaceC22053ub1.B();
                if (zV3 || objB19 == aVar9.a()) {
                    objB19 = new UA2() { // from class: ir.nasim.Q55
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return J55.c.W(interfaceC9102Ym412, (InterfaceC11943do6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB19);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarC4 = AbstractC6919Pn6.c(eVarF2, true, (UA2) objB19);
                C19938rB7 c19938rB74 = C19938rB7.a;
                interfaceC22053ub1.W(-2041072978);
                boolean z5 = z;
                boolean zA3 = interfaceC22053ub1.a(z5);
                Object objB20 = interfaceC22053ub1.B();
                if (zA3 || objB20 == aVar9.a()) {
                    objB20 = new a(z5, interfaceC9102Ym43, interfaceC9102Ym44);
                    interfaceC22053ub1.s(objB20);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarC5 = AbstractC21071t37.c(eVarC4, c19938rB74, (PointerInputEventHandler) objB20);
                InterfaceC10970cW3 interfaceC10970cW3G6 = androidx.compose.foundation.layout.f.g(aVar10.o(), false);
                int iA9 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q9 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE9 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC5);
                SA2 sa2A9 = aVar11.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A9);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A9 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A9, interfaceC10970cW3G6, aVar11.e());
                DG7.c(interfaceC22053ub1A9, interfaceC11819dc1Q9, aVar11.g());
                InterfaceC14603iB2 interfaceC14603iB2B9 = aVar11.b();
                if (interfaceC22053ub1A9.h() || !AbstractC13042fc3.d(interfaceC22053ub1A9.B(), Integer.valueOf(iA9))) {
                    interfaceC22053ub1A9.s(Integer.valueOf(iA9));
                    interfaceC22053ub1A9.v(Integer.valueOf(iA9), interfaceC14603iB2B9);
                }
                DG7.c(interfaceC22053ub1A9, eVarE9, aVar11.f());
                interfaceC22053ub1.W(1605566477);
                if (J55.v(interfaceC9664aL63).s() && J55.c(interfaceC9664aL624).w()) {
                    i10 = i18;
                    AbstractC24667z03.b(FV4.c(KB5.ic_muted_participant, interfaceC22053ub1, 0), null, Ac8.a(androidx.compose.foundation.layout.q.m(hVar2.h(aVar5, aVar10.n()), 0.0f, g1013.c(interfaceC22053ub1, i18).b().u(), g1013.c(interfaceC22053ub1, i18).b().u(), 0.0f, 9, null), 2.0f), g1013.b(interfaceC22053ub1, i18).i(), interfaceC22053ub1, 48, 0);
                } else {
                    i10 = i18;
                }
                interfaceC22053ub1.Q();
                if (J55.m(interfaceC9664aL65)) {
                    interfaceC22053ub1.W(-1766089607);
                    AV7 av7K = J55.c(interfaceC9664aL624).w() ? J55.v(interfaceC9664aL63).k() : J55.w(interfaceC9664aL66).o() ? J55.w(interfaceC9664aL66).i() : J55.w(interfaceC9664aL66).k();
                    if (av7K instanceof AV7.b) {
                        ((AV7.b) av7K).a().invoke(interfaceC22053ub1, 0);
                    }
                    interfaceC22053ub1.Q();
                    hVar = hVar2;
                    g106 = g1013;
                } else {
                    interfaceC22053ub1.W(-1765207006);
                    androidx.compose.ui.e eVarC6 = androidx.compose.foundation.b.c(hVar2.h(FV0.a(androidx.compose.foundation.layout.t.t(aVar5, C17784nZ1.q(60)), N46.g()), aVar10.e()), C24381yX0.b.i(), N46.g());
                    if (J55.c(interfaceC9664aL624).w()) {
                        interfaceC22053ub1.W(-1764728149);
                        C8942Xx0 c8942Xx0D4 = J55.p(interfaceC9664aL68).d();
                        ev4H2 = AvatarAsyncImagePainterKt.h(c8942Xx0D4 != null ? c8942Xx0D4.a() : null, FV4.c(KB5.ic_voice_call_profile, interfaceC22053ub1, 0), false, 0, interfaceC22053ub1, 0, 12);
                        interfaceC22053ub1.Q();
                    } else {
                        interfaceC22053ub1.W(-1764385847);
                        ev4H2 = AvatarAsyncImagePainterKt.h((Avatar) J55.k(interfaceC9664aL67).f(), FV4.c(KB5.ic_voice_call_profile, interfaceC22053ub1, 0), false, 0, interfaceC22053ub1, 0, 12);
                        interfaceC22053ub1.Q();
                    }
                    hVar = hVar2;
                    g106 = g1013;
                    AbstractC11456d23.b(ev4H2, null, eVarC6, null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                    interfaceC22053ub1.Q();
                }
                InterfaceC10040ay6 interfaceC10040ay6C2 = c18039nz0.c();
                interfaceC22053ub1.W(1605670675);
                boolean zV4 = interfaceC22053ub1.V(interfaceC9664aL624);
                Object objB21 = interfaceC22053ub1.B();
                if (zV4 || objB21 == aVar9.a()) {
                    objB21 = new UA2() { // from class: ir.nasim.R55
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(J55.c.X(interfaceC9664aL624, (Integer) obj));
                        }
                    };
                    interfaceC22053ub1.s(objB21);
                }
                interfaceC22053ub1.Q();
                z2 = false;
                AbstractC11610dI5.g(interfaceC10040ay6C2, (UA2) objB21, interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
            } else {
                hVar = hVar2;
                i10 = i9;
                g106 = g105;
                aVar5 = aVar4;
                z2 = false;
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.c(hVar.h(androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.q.i(aVar5, g106.c(interfaceC22053ub1, i10).b().n()), null, z2, 3, null), aVar10.c()), C24381yX0.o(g106.b(interfaceC22053ub1, i10).d(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), N46.d(g106.c(interfaceC22053ub1, i10).a().d())), g106.c(interfaceC22053ub1, i10).b().u(), g106.c(interfaceC22053ub1, i10).b().n());
            interfaceC22053ub1.W(-2040917318);
            Object objB22 = interfaceC22053ub1.B();
            if (objB22 == aVar9.a()) {
                objB22 = new UA2() { // from class: ir.nasim.S55
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return J55.c.Y((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB22);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD3 = AbstractC6919Pn6.d(eVarJ, false, (UA2) objB22, 1, null);
            if (!J55.c(interfaceC9664aL624).w()) {
                C8942Xx0 c8942Xx0D5 = J55.p(interfaceC9664aL68).d();
                if (c8942Xx0D5 == null || (strC2 = c8942Xx0D5.c()) == null) {
                    str = "";
                }
                AbstractC9105Ym7.b(str, eVarD3, C24381yX0.b.j(), AbstractC13784go7.g(16), null, null, M10.p(), 0L, null, null, 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, C6399Nk7.b.a(), C4049Dl7.b.e(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16678911, (ED1) null), interfaceC22053ub1, 3456, 3120, 55216);
                interfaceC22053ub1.u();
            }
            strC2 = (String) J55.k(interfaceC9664aL67).e();
            str = strC2;
            AbstractC9105Ym7.b(str, eVarD3, C24381yX0.b.j(), AbstractC13784go7.g(16), null, null, M10.p(), 0L, null, null, 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, C6399Nk7.b.a(), C4049Dl7.b.e(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16678911, (ED1) null), interfaceC22053ub1, 3456, 3120, 55216);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
            C((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ C12767fA0 b;
        final /* synthetic */ Context c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[C17448mz0.a.values().length];
                try {
                    iArr[C17448mz0.a.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[C17448mz0.a.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[C17448mz0.a.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[C17448mz0.a.g.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[C17448mz0.a.f.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[C17448mz0.a.i.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[C17448mz0.a.h.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[C17448mz0.a.d.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[C17448mz0.a.e.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[C17448mz0.a.l.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[C17448mz0.a.j.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[C17448mz0.a.k.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[C17448mz0.a.m.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[C17448mz0.a.n.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[C17448mz0.a.o.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                a = iArr;
            }
        }

        d(SA2 sa2, C12767fA0 c12767fA0, Context context, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63) {
            this.a = sa2;
            this.b = c12767fA0;
            this.c = context;
            this.d = interfaceC9664aL6;
            this.e = interfaceC9664aL62;
            this.f = interfaceC9664aL63;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 A(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.P2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 B(C12767fA0 c12767fA0, C21753u45.d dVar) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            AbstractC13042fc3.i(dVar, "permission");
            c12767fA0.s2(AbstractC4363Eu6.c(dVar));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 C(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.Q2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.S1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$openMoreOptionBottomSheet");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.o2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 w(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.P2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 x(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.S1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y() {
            C20384rv0.a.S();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z() {
            C20384rv0.a.A();
            return C19938rB7.a;
        }

        public final void p(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            float f = 20;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.q.l(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), C17784nZ1.q(f), C17784nZ1.q(16), C17784nZ1.q(f), C17784nZ1.q(28)), C17784nZ1.q(Type.EUI48));
            C24254yJ.f fVarF = C24254yJ.a.f();
            final SA2 sa2 = this.a;
            final C12767fA0 c12767fA0 = this.b;
            Context context = this.c;
            InterfaceC9664aL6 interfaceC9664aL6 = this.d;
            InterfaceC9664aL6 interfaceC9664aL62 = this.e;
            InterfaceC9664aL6 interfaceC9664aL63 = this.f;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarF, InterfaceC12529em.a.l(), interfaceC22053ub1, 6);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            M66 m66 = M66.a;
            switch (a.a[J55.p(interfaceC9664aL6).e().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    interfaceC22053ub1.W(1157748506);
                    AbstractC7031Pz0 abstractC7031Pz0F = J55.p(interfaceC9664aL6).f();
                    C17448mz0.a aVarE = J55.p(interfaceC9664aL6).e();
                    InterfaceC8534Wj4 interfaceC8534Wj4H = J55.c(interfaceC9664aL62).h();
                    boolean zY = J55.c(interfaceC9664aL62).y();
                    boolean zX = J55.c(interfaceC9664aL62).x();
                    boolean zP = J55.c(interfaceC9664aL62).p();
                    boolean zM = J55.c(interfaceC9664aL62).m();
                    interfaceC22053ub1.W(-2040853532);
                    boolean zV = interfaceC22053ub1.V(sa2);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.b65
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return J55.d.t(sa2);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa22 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-2040845423);
                    boolean zD = interfaceC22053ub1.D(c12767fA0);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.c65
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return J55.d.A(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa23 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-2040833101);
                    boolean zD2 = interfaceC22053ub1.D(c12767fA0);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new UA2() { // from class: ir.nasim.d65
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return J55.d.B(c12767fA0, (C21753u45.d) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    UA2 ua2 = (UA2) objB3;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-2040840241);
                    boolean zD3 = interfaceC22053ub1.D(c12767fA0);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD3 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.e65
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return J55.d.C(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    SA2 sa24 = (SA2) objB4;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-2040826765);
                    boolean zD4 = interfaceC22053ub1.D(c12767fA0);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD4 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new SA2() { // from class: ir.nasim.f65
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return J55.d.D(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB5);
                    }
                    SA2 sa25 = (SA2) objB5;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-2040818154);
                    boolean zD5 = interfaceC22053ub1.D(c12767fA0);
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD5 || objB6 == InterfaceC22053ub1.a.a()) {
                        objB6 = new SA2() { // from class: ir.nasim.g65
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return J55.d.v(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB6);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC18693p53.h(abstractC7031Pz0F, aVarE, interfaceC8534Wj4H, sa22, zY, sa23, zX, context, ua2, sa24, sa25, zP, (SA2) objB6, zM, interfaceC22053ub1, AbstractC7031Pz0.a, 0);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    interfaceC22053ub1.W(1159732723);
                    boolean zS = J55.w(interfaceC9664aL63).s();
                    interfaceC22053ub1.W(-2040793019);
                    boolean zD6 = interfaceC22053ub1.D(c12767fA0);
                    Object objB7 = interfaceC22053ub1.B();
                    if (zD6 || objB7 == InterfaceC22053ub1.a.a()) {
                        objB7 = new SA2() { // from class: ir.nasim.h65
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return J55.d.w(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB7);
                    }
                    SA2 sa26 = (SA2) objB7;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-2040790169);
                    boolean zD7 = interfaceC22053ub1.D(c12767fA0);
                    Object objB8 = interfaceC22053ub1.B();
                    if (zD7 || objB8 == InterfaceC22053ub1.a.a()) {
                        objB8 = new SA2() { // from class: ir.nasim.i65
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return J55.d.x(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB8);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC8103Un5.e(zS, sa26, (SA2) objB8, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB72 = C19938rB7.a;
                    break;
                case 9:
                    interfaceC22053ub1.W(1160182502);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB73 = C19938rB7.a;
                    break;
                case 10:
                case 11:
                case 12:
                case 13:
                    interfaceC22053ub1.W(1160576047);
                    interfaceC22053ub1.W(-2040768749);
                    Object objB9 = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
                    if (objB9 == aVar2.a()) {
                        objB9 = new SA2() { // from class: ir.nasim.j65
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return J55.d.y();
                            }
                        };
                        interfaceC22053ub1.s(objB9);
                    }
                    SA2 sa27 = (SA2) objB9;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-2040763399);
                    Object objB10 = interfaceC22053ub1.B();
                    if (objB10 == aVar2.a()) {
                        objB10 = new SA2() { // from class: ir.nasim.k65
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return J55.d.z();
                            }
                        };
                        interfaceC22053ub1.s(objB10);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC5245In0.d(sa27, (SA2) objB10, interfaceC22053ub1, 54);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB74 = C19938rB7.a;
                    break;
                case 14:
                case 15:
                    interfaceC22053ub1.W(1161180609);
                    AbstractC15166j72.b(interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB75 = C19938rB7.a;
                    break;
                default:
                    interfaceC22053ub1.W(-2040872022);
                    interfaceC22053ub1.Q();
                    throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            p((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;

        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC4616Fw7.a((C17448mz0) this.c, AbstractC6392Nk0.a(!((List) this.d).isEmpty()));
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(C17448mz0 c17448mz0, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = c17448mz0;
                aVar.d = list;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC14415hs5 a;

            b(InterfaceC14415hs5 interfaceC14415hs5) {
                this.a = interfaceC14415hs5;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.setValue(str);
                return C19938rB7.a;
            }
        }

        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ InterfaceC9664aL6 b;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ InterfaceC9664aL6 b;

                /* renamed from: ir.nasim.J55$e$c$a$a, reason: collision with other inner class name */
                public static final class C0428a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0428a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = interfaceC4806Gq2;
                    this.b = interfaceC9664aL6;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) throws android.content.res.Resources.NotFoundException {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ir.nasim.J55.e.c.a.C0428a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.J55$e$c$a$a r0 = (ir.nasim.J55.e.c.a.C0428a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.J55$e$c$a$a r0 = new ir.nasim.J55$e$c$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L71
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        ir.nasim.XV4 r7 = (ir.nasim.XV4) r7
                        java.lang.Object r2 = r7.a()
                        ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                        java.lang.Object r7 = r7.b()
                        java.lang.Boolean r7 = (java.lang.Boolean) r7
                        boolean r7 = r7.booleanValue()
                        ir.nasim.mz0$a r4 = r2.e()
                        ir.nasim.Pz0 r2 = r2.f()
                        ir.nasim.aL6 r5 = r6.b
                        ir.nasim.mz0 r5 = ir.nasim.J55.L(r5)
                        ir.nasim.Xx0 r5 = r5.d()
                        if (r5 == 0) goto L62
                        java.lang.String r5 = r5.c()
                        if (r5 != 0) goto L64
                    L62:
                        java.lang.String r5 = ""
                    L64:
                        java.lang.String r7 = ir.nasim.AbstractC24230yG2.a(r4, r2, r7, r5)
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r7, r0)
                        if (r7 != r1) goto L71
                        return r1
                    L71:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.e.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = interfaceC4557Fq2;
                this.b = interfaceC9664aL6;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
            this.e = interfaceC9664aL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.d, this.e, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                c cVar = new c(AbstractC6459Nq2.S(this.d, AbstractC6459Nq2.o0(C18039nz0.a.f(), interfaceC14415hs5, InterfaceC16863lz6.a.c(), AbstractC10360bX0.m()), new a(null)), this.e);
                b bVar = new b(interfaceC14415hs5);
                this.b = 1;
                if (cVar.b(bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12767fA0 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ InterfaceC9664aL6 g;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC14415hs5 a;
            final /* synthetic */ InterfaceC9664aL6 b;
            final /* synthetic */ InterfaceC9664aL6 c;
            final /* synthetic */ InterfaceC9664aL6 d;

            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63) {
                this.a = interfaceC14415hs5;
                this.b = interfaceC9664aL6;
                this.c = interfaceC9664aL62;
                this.d = interfaceC9664aL63;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C9215Yz0 c9215Yz0, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.setValue(AbstractC6392Nk0.a(((!c9215Yz0.w() && J55.v(this.b).m()) || ((!c9215Yz0.w() && J55.v(this.b).n()) || ((c9215Yz0.w() && J55.w(this.c).m()) || (c9215Yz0.w() && J55.w(this.c).o())))) && J55.p(this.d).e() != C17448mz0.a.h));
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C12767fA0 c12767fA0, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12767fA0;
            this.e = interfaceC9664aL6;
            this.f = interfaceC9664aL62;
            this.g = interfaceC9664aL63;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, this.e, this.f, this.g, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                InterfaceC10258bL6 interfaceC10258bL6I1 = this.d.I1();
                a aVar = new a(interfaceC14415hs5, this.e, this.f, this.g);
                this.b = 1;
                if (interfaceC10258bL6I1.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Context d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ InterfaceC9664aL6 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Context context, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = context;
            this.e = interfaceC9664aL6;
            this.f = interfaceC9664aL62;
            this.g = interfaceC9664aL63;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(this.d, this.e, this.f, this.g, interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String string;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
            EnumC23259wd1 enumC23259wd1D = J55.w(this.e).d();
            EnumC23259wd1 enumC23259wd1 = EnumC23259wd1.c;
            boolean z = enumC23259wd1D == enumC23259wd1;
            boolean z2 = J55.v(this.f).d() == enumC23259wd1;
            boolean z3 = z || z2;
            if (z) {
                string = this.d.getString(BD5.internet_for_local_peer_is_weak);
            } else if (z2) {
                Context context = this.d;
                int i = BD5.internet_for_remote_peer_is_weak;
                C8942Xx0 c8942Xx0D = J55.p(this.g).d();
                string = context.getString(i, c8942Xx0D != null ? c8942Xx0D.c() : null);
            } else {
                string = "";
            }
            AbstractC13042fc3.f(string);
            interfaceC14415hs5.setValue(AbstractC4616Fw7.a(AbstractC6392Nk0.a(z3), string));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12767fA0 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC14415hs5 a;
            final /* synthetic */ InterfaceC9664aL6 b;
            final /* synthetic */ InterfaceC9664aL6 c;

            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
                this.a = interfaceC14415hs5;
                this.b = interfaceC9664aL6;
                this.c = interfaceC9664aL62;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C9215Yz0 c9215Yz0, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.setValue(AbstractC6392Nk0.a((!c9215Yz0.w() && J55.w(this.b).m()) || (!c9215Yz0.w() && J55.w(this.b).o()) || ((c9215Yz0.w() && J55.v(this.c).m()) || (c9215Yz0.w() && J55.v(this.c).o()))));
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C12767fA0 c12767fA0, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12767fA0;
            this.e = interfaceC9664aL6;
            this.f = interfaceC9664aL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(this.d, this.e, this.f, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                InterfaceC10258bL6 interfaceC10258bL6I1 = this.d.I1();
                a aVar = new a(interfaceC14415hs5, this.e, this.f);
                this.b = 1;
                if (interfaceC10258bL6I1.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* renamed from: ir.nasim.J55$i$a$a, reason: collision with other inner class name */
            static final class C0429a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ InterfaceC14415hs5 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0429a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = interfaceC14415hs5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0429a c0429a = new C0429a(this.d, interfaceC20295rm1);
                    c0429a.c = obj;
                    return c0429a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    M26 m26 = (M26) this.c;
                    C19406qI3.a("PersonalCall", "local ui State " + m26, new Object[0]);
                    this.d.setValue(m26);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(M26 m26, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0429a) create(m26, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2 = (InterfaceC4557Fq2) this.c;
                    C0429a c0429a = new C0429a(this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2, c0429a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC4557Fq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.J55$i$b$a$a, reason: collision with other inner class name */
                public static final class C0430a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0430a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.J55.i.b.a.C0430a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.J55$i$b$a$a r0 = (ir.nasim.J55.i.b.a.C0430a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.J55$i$b$a$a r0 = new ir.nasim.J55$i$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L4a
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                        ir.nasim.mz0$a r2 = r2.e()
                        ir.nasim.mz0$a r4 = ir.nasim.C17448mz0.a.n
                        if (r2 == r4) goto L4a
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L4a
                        return r1
                    L4a:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.i.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.J55$i$c$a$a, reason: collision with other inner class name */
                public static final class C0431a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0431a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.J55.i.c.a.C0431a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.J55$i$c$a$a r0 = (ir.nasim.J55.i.c.a.C0431a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.J55$i$c$a$a r0 = new ir.nasim.J55$i$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                        ir.nasim.Fq2 r5 = r5.h()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.i.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = new i(this.d, interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(new c(new b(this.d)));
                a aVar = new a(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2F, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(InterfaceC14415hs5 interfaceC14415hs5, C21231tK7 c21231tK7) {
            interfaceC14415hs5.setValue(new XV4(c21231tK7.r().b(), c21231tK7.h().b()));
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = new j(interfaceC20295rm1);
            jVar.c = obj;
            return jVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            final InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
            AbstractC5969Lp4.g().k(AbstractC5969Lp4.f()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.l65
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    J55.j.y(interfaceC14415hs5, (C21231tK7) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* renamed from: ir.nasim.J55$k$a$a, reason: collision with other inner class name */
            static final class C0432a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ InterfaceC14415hs5 d;

                /* renamed from: ir.nasim.J55$k$a$a$a, reason: collision with other inner class name */
                static final class C0433a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;
                    final /* synthetic */ InterfaceC14415hs5 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0433a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = interfaceC14415hs5;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C0433a c0433a = new C0433a(this.d, interfaceC20295rm1);
                        c0433a.c = obj;
                        return c0433a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        M26 m26 = (M26) this.c;
                        C19406qI3.a("PersonalCall", "remoteUiState ui State " + m26, new Object[0]);
                        this.d.setValue(m26);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(M26 m26, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0433a) create(m26, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0432a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = interfaceC14415hs5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0432a c0432a = new C0432a(this.d, interfaceC20295rm1);
                    c0432a.c = obj;
                    return c0432a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2 = (InterfaceC4557Fq2) AbstractC15401jX0.q0((List) this.c);
                        C0433a c0433a = new C0433a(this.d, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2, c0433a, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0432a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class b implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.J55$k$a$b$a, reason: collision with other inner class name */
                public static final class C0434a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.J55$k$a$b$a$a, reason: collision with other inner class name */
                    public static final class C0435a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C0435a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C0434a.this.a(null, this);
                        }
                    }

                    public C0434a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.J55.k.a.b.C0434a.C0435a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.J55$k$a$b$a$a r0 = (ir.nasim.J55.k.a.b.C0434a.C0435a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.J55$k$a$b$a$a r0 = new ir.nasim.J55$k$a$b$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L4b
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            r2 = r5
                            java.util.List r2 = (java.util.List) r2
                            java.util.Collection r2 = (java.util.Collection) r2
                            boolean r2 = r2.isEmpty()
                            r2 = r2 ^ r3
                            if (r2 == 0) goto L4b
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L4b
                            return r1
                        L4b:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.k.a.b.C0434a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C0434a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    b bVar = new b((InterfaceC4557Fq2) this.c);
                    C0432a c0432a = new C0432a(this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(bVar, c0432a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC4557Fq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.J55$k$b$a$a, reason: collision with other inner class name */
                public static final class C0436a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0436a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.J55.k.b.a.C0436a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.J55$k$b$a$a r0 = (ir.nasim.J55.k.b.a.C0436a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.J55$k$b$a$a r0 = new ir.nasim.J55$k$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L4a
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                        ir.nasim.mz0$a r2 = r2.e()
                        ir.nasim.mz0$a r4 = ir.nasim.C17448mz0.a.n
                        if (r2 == r4) goto L4a
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L4a
                        return r1
                    L4a:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.k.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.J55$k$c$a$a, reason: collision with other inner class name */
                public static final class C0437a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0437a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.J55.k.c.a.C0437a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.J55$k$c$a$a r0 = (ir.nasim.J55.k.c.a.C0437a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.J55$k$c$a$a r0 = new ir.nasim.J55$k$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                        ir.nasim.Fq2 r5 = r5.k()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.k.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = new k(this.d, interfaceC20295rm1);
            kVar.c = obj;
            return kVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(new c(new b(this.d)));
                a aVar = new a(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2F, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;

        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ double c;
            /* synthetic */ Object d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC4616Fw7.a(AbstractC6392Nk0.b(this.c), ((C17448mz0) this.d).e());
            }

            public final Object n(double d, C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = d;
                aVar.d = c17448mz0;
                return aVar.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return n(((Number) obj).doubleValue(), (C17448mz0) obj2, (InterfaceC20295rm1) obj3);
            }
        }

        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC14415hs5 a;

            b(InterfaceC14415hs5 interfaceC14415hs5) {
                this.a = interfaceC14415hs5;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.setValue(str);
                return C19938rB7.a;
            }
        }

        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.J55$m$c$a$a, reason: collision with other inner class name */
                public static final class C0440a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0440a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ir.nasim.J55.m.c.a.C0440a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.J55$m$c$a$a r0 = (ir.nasim.J55.m.c.a.C0440a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.J55$m$c$a$a r0 = new ir.nasim.J55$m$c$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L55
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        ir.nasim.XV4 r7 = (ir.nasim.XV4) r7
                        java.lang.Object r2 = r7.e()
                        java.lang.Number r2 = (java.lang.Number) r2
                        double r4 = r2.doubleValue()
                        java.lang.Object r7 = r7.f()
                        ir.nasim.mz0$a r7 = (ir.nasim.C17448mz0.a) r7
                        java.lang.String r7 = ir.nasim.AbstractC19576qb1.e(r4, r7)
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r7, r0)
                        if (r7 != r1) goto L55
                        return r1
                    L55:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.m.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C17448mz0.a y(C17448mz0 c17448mz0) {
            return c17448mz0.e();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            m mVar = new m(this.d, interfaceC20295rm1);
            mVar.c = obj;
            return mVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                c cVar = new c(AbstractC6459Nq2.S(C18039nz0.a.a(), AbstractC6459Nq2.x(this.d, new UA2() { // from class: ir.nasim.m65
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return J55.m.y((C17448mz0) obj2);
                    }
                }), new a(null)));
                b bVar = new b(interfaceC14415hs5);
                this.b = 1;
                if (cVar.b(bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC14415hs5 a;

            a(InterfaceC14415hs5 interfaceC14415hs5) {
                this.a = interfaceC14415hs5;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.setValue(c17448mz0);
                return C19938rB7.a;
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.J55$n$b$a$a, reason: collision with other inner class name */
                public static final class C0441a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0441a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.J55.n.b.a.C0441a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.J55$n$b$a$a r0 = (ir.nasim.J55.n.b.a.C0441a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.J55$n$b$a$a r0 = new ir.nasim.J55$n$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L4a
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                        ir.nasim.mz0$a r2 = r2.e()
                        ir.nasim.mz0$a r4 = ir.nasim.C17448mz0.a.n
                        if (r2 == r4) goto L4a
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L4a
                        return r1
                    L4a:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.n.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            n nVar = new n(this.d, interfaceC20295rm1);
            nVar.c = obj;
            return nVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                b bVar = new b(this.d);
                a aVar = new a(interfaceC14415hs5);
                this.b = 1;
                if (bVar.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x0735  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final ir.nasim.InterfaceC10258bL6 r52, final ir.nasim.UA2 r53, final java.lang.Integer r54, final ir.nasim.UA2 r55, final ir.nasim.C12767fA0 r56, final ir.nasim.SA2 r57, final boolean r58, final ir.nasim.SA2 r59, ir.nasim.InterfaceC22053ub1 r60, final int r61) {
        /*
            Method dump skipped, instructions count: 1873
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.b(ir.nasim.bL6, ir.nasim.UA2, java.lang.Integer, ir.nasim.UA2, ir.nasim.fA0, ir.nasim.SA2, boolean, ir.nasim.SA2, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9215Yz0 c(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C9215Yz0) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23677xK3 d(LK3 lk3) {
        return (C23677xK3) lk3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(InterfaceC9102Ym4 interfaceC9102Ym4, float f2) {
        interfaceC9102Ym4.setValue(Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(InterfaceC9102Ym4 interfaceC9102Ym4, float f2) {
        interfaceC9102Ym4.setValue(Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(InterfaceC9664aL6 interfaceC9664aL6) {
        return (String) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(InterfaceC9664aL6 interfaceC9664aL6) {
        return (String) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final XV4 k(InterfaceC9664aL6 interfaceC9664aL6) {
        return (XV4) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final XV4 n(InterfaceC9664aL6 interfaceC9664aL6) {
        return (XV4) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17448mz0 p(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C17448mz0) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C18519on6 r(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C18519on6) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CK5 t(InterfaceC9664aL6 interfaceC9664aL6) {
        return (CK5) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, Integer num, UA2 ua22, C12767fA0 c12767fA0, SA2 sa2, boolean z, SA2 sa22, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$callState");
        AbstractC13042fc3.i(ua2, "$openSpeakerBottomSheet");
        AbstractC13042fc3.i(ua22, "$showCallErrorsSnackbar");
        AbstractC13042fc3.i(c12767fA0, "$viewModel");
        AbstractC13042fc3.i(sa2, "$openInviteBottomSheet");
        AbstractC13042fc3.i(sa22, "$openMoreOptionBottomSheet");
        b(interfaceC10258bL6, ua2, num, ua22, c12767fA0, sa2, z, sa22, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M26 v(InterfaceC9664aL6 interfaceC9664aL6) {
        return (M26) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M26 w(InterfaceC9664aL6 interfaceC9664aL6) {
        return (M26) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float x(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).floatValue();
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ UA2 f;

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.setValue((C18519on6) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C18519on6 c18519on6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c18519on6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ UA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2) {
                super(3, interfaceC20295rm1);
                this.e = interfaceC9102Ym4;
                this.f = ua2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    EN4 en4 = (EN4) this.d;
                    InterfaceC4557Fq2 interfaceC4557Fq2P = AbstractC6459Nq2.p(en4.e(), en4.a(), new a(this.e, this.f, en4, null));
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2P, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(interfaceC20295rm1, this.e, this.f);
                cVar.c = interfaceC4806Gq2;
                cVar.d = obj;
                return cVar.invokeSuspend(C19938rB7.a);
            }
        }

        public static final class d implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.J55$l$d$a$a, reason: collision with other inner class name */
                public static final class C0439a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0439a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.J55.l.d.a.C0439a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.J55$l$d$a$a r0 = (ir.nasim.J55.l.d.a.C0439a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.J55$l$d$a$a r0 = new ir.nasim.J55$l$d$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                        ir.nasim.EN4 r5 = r5.j()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J55.l.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
            this.e = interfaceC9102Ym4;
            this.f = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            l lVar = new l(this.d, this.e, this.f, interfaceC20295rm1);
            lVar.c = obj;
            return lVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2S0 = AbstractC6459Nq2.s0(AbstractC6459Nq2.F(AbstractC6459Nq2.v(new d(this.d))), new c(null, this.e, this.f));
                b bVar = new b(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2S0, bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ UA2 f;
            final /* synthetic */ EN4 g;

            /* renamed from: ir.nasim.J55$l$a$a, reason: collision with other inner class name */
            static final class C0438a implements SA2 {
                final /* synthetic */ UA2 a;
                final /* synthetic */ EnumC25128zm6 b;

                C0438a(UA2 ua2, EnumC25128zm6 enumC25128zm6) {
                    this.a = ua2;
                    this.b = enumC25128zm6;
                }

                public final void a() {
                    this.a.invoke(this.b);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            static final class b implements SA2 {
                final /* synthetic */ EnumC25128zm6 a;
                final /* synthetic */ EN4 b;
                final /* synthetic */ SortedSet c;

                b(EnumC25128zm6 enumC25128zm6, EN4 en4, SortedSet sortedSet) {
                    this.a = enumC25128zm6;
                    this.b = en4;
                    this.c = sortedSet;
                }

                public final void a() {
                    EnumC25128zm6 enumC25128zm6 = this.a;
                    EnumC25128zm6 enumC25128zm62 = EnumC25128zm6.b;
                    if (enumC25128zm6 != enumC25128zm62) {
                        this.b.b(enumC25128zm62);
                        return;
                    }
                    EN4 en4 = this.b;
                    Object objLast = this.c.last();
                    AbstractC13042fc3.h(objLast, "last(...)");
                    en4.b((EnumC25128zm6) objLast);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2, EN4 en4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.e = interfaceC9102Ym4;
                this.f = ua2;
                this.g = en4;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                EnumC25128zm6 enumC25128zm6 = (EnumC25128zm6) this.c;
                SortedSet sortedSet = (SortedSet) this.d;
                C12889fL5 c12889fL5 = new C12889fL5();
                c12889fL5.a = c.a;
                J55.q(this.e, sortedSet.contains(EnumC25128zm6.d));
                if (enumC25128zm6 != null) {
                    InterfaceC9102Ym4 interfaceC9102Ym4 = this.e;
                    UA2 ua2 = this.f;
                    EN4 en4 = this.g;
                    if (J55.o(interfaceC9102Ym4)) {
                        c12889fL5.a = new C0438a(ua2, enumC25128zm6);
                    } else {
                        c12889fL5.a = new b(enumC25128zm6, en4, sortedSet);
                    }
                }
                return new C18519on6(enumC25128zm6, (SA2) c12889fL5.a);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(EnumC25128zm6 enumC25128zm6, SortedSet sortedSet, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.e, this.f, this.g, interfaceC20295rm1);
                aVar.c = enumC25128zm6;
                aVar.d = sortedSet;
                return aVar.invokeSuspend(C19938rB7.a);
            }

            static final class c implements SA2 {
                public static final c a = new c();

                c() {
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }

                public final void a() {
                }
            }
        }
    }
}
