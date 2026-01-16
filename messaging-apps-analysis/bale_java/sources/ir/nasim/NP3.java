package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.widget.TextView;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.NP3;
import ir.nasim.SO3;

/* loaded from: classes4.dex */
public abstract class NP3 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ long a;
        final /* synthetic */ float b;

        a(long j, float f) {
            this.a = j;
            this.b = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(float f, long j, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
            float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) - (f / 2);
            InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), f, 0, null, 0.0f, null, 0, 496, null);
            return C19938rB7.a;
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(833198775);
            final float fW1 = ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).w1(this.b);
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(-349372046);
            boolean zC = interfaceC22053ub1.c(fW1) | interfaceC22053ub1.f(this.a);
            final long j = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zC || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.MP3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return NP3.a.c(fW1, j, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarB = androidx.compose.ui.draw.b.b(aVar, (UA2) objB);
            interfaceC22053ub1.Q();
            return eVarB;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ long a;
        final /* synthetic */ float b;

        b(long j, float f) {
            this.a = j;
            this.b = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(long j, float f, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
            float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
            InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(0.0f) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), f, 0, null, 0.0f, null, 0, 496, null);
            return C19938rB7.a;
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(1451656894);
            final float fW1 = ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).w1(this.b);
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(1093197189);
            boolean zF = interfaceC22053ub1.f(this.a) | interfaceC22053ub1.c(fW1);
            final long j = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zF || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.OP3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return NP3.b.c(j, fW1, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarB = androidx.compose.ui.draw.b.b(aVar, (UA2) objB);
            interfaceC22053ub1.Q();
            return eVarB;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final void e(final int i, final String str, final String str2, final int i2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i3) {
        int i4;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(str2, "emojiText");
        AbstractC13042fc3.i(ua2, "onClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1083898559);
        if ((i3 & 6) == 0) {
            i4 = (interfaceC22053ub1J.e(i) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i3 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.e(i2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.D(ua2) ? 16384 : 8192;
        }
        int i5 = i4;
        if ((i5 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            float f = 5;
            float f2 = 20;
            androidx.compose.ui.e eVarB = AbstractC6033Lw6.b(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(androidx.compose.ui.e.a, C17784nZ1.q(56)), C17784nZ1.q(70)), C17784nZ1.q(f), N46.e(C17784nZ1.q(f2), C17784nZ1.q(f2), C17784nZ1.q(f), C17784nZ1.q(f)), false, 0L, 0L, 24, null);
            float f3 = 8;
            androidx.compose.ui.e eVarA = FV0.a(eVarB, N46.d(C17784nZ1.q(f3)));
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            androidx.compose.ui.e eVarF = AbstractC9287Zh0.f(androidx.compose.foundation.b.d(eVarA, DX0.b(c5495Jo7.s0()), null, 2, null), C17784nZ1.q(i2 == i ? 2 : 0), i2 == i ? DX0.b(c5495Jo7.u2()) : C24381yX0.b.i(), N46.d(C17784nZ1.q(f3)));
            interfaceC22053ub1J.W(1833778778);
            boolean z = ((57344 & i5) == 16384) | ((i5 & 14) == 4);
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.IP3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return NP3.f(ua2, i);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.e.f(eVarF, false, null, null, (SA2) objB, 7, null), C17784nZ1.q(4), C17784nZ1.q(f3));
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1J.W(-374157396);
            Object objB2 = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB2 == aVar2.a()) {
                objB2 = new UA2() { // from class: ir.nasim.JP3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return NP3.g((Context) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            UA2 ua22 = (UA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-374155354);
            boolean z2 = (i5 & 896) == 256;
            Object objB3 = interfaceC22053ub1J.B();
            if (z2 || objB3 == aVar2.a()) {
                objB3 = new UA2() { // from class: ir.nasim.KP3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return NP3.h(str2, (TextView) obj);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC11355cs.a(ua22, null, (UA2) objB3, interfaceC22053ub1J, 6, 2);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9339Zm7.b(str, null, WX0.a(IA5.color8, interfaceC22053ub1J, 0), AbstractC13784go7.g(12), null, null, M10.q(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub12, ((i5 >> 3) & 14) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122802);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.LP3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return NP3.i(i, str, str2, i2, ua2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(UA2 ua2, int i) {
        AbstractC13042fc3.i(ua2, "$onClick");
        ua2.invoke(Integer.valueOf(i));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView g(Context context) {
        AbstractC13042fc3.i(context, "context");
        return new TextView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(String str, TextView textView) {
        AbstractC13042fc3.i(str, "$emojiText");
        AbstractC13042fc3.i(textView, "it");
        textView.setText(R62.V(str, textView.getPaint().getFontMetricsInt(), false));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(int i, String str, String str2, int i2, UA2 ua2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$text");
        AbstractC13042fc3.i(str2, "$emojiText");
        AbstractC13042fc3.i(ua2, "$onClick");
        e(i, str, str2, i2, ua2, interfaceC22053ub1, QJ5.a(i3 | 1));
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e j(androidx.compose.ui.e eVar, float f, long j) {
        AbstractC13042fc3.i(eVar, "$this$endBoarder");
        return androidx.compose.ui.c.c(eVar, null, new a(j, f), 1, null);
    }

    public static final String k(int i, Context context) {
        AbstractC13042fc3.i(context, "context");
        String string = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : context.getString(JD5.rate4_how_to_be_great) : context.getString(JD5.rate3_how_improve) : context.getString(JD5.rate2_why_bad) : context.getString(JD5.rate1_why_so_bad);
        AbstractC13042fc3.f(string);
        return string;
    }

    public static final void l(String str, int i) {
        AbstractC13042fc3.i(str, "opinion");
        AbstractC5969Lp4.e().F().i0(new SO3.g(i, str));
    }

    public static final androidx.compose.ui.e m(androidx.compose.ui.e eVar, float f, long j) {
        AbstractC13042fc3.i(eVar, "$this$topBorder");
        return androidx.compose.ui.c.c(eVar, null, new b(j, f), 1, null);
    }
}
