package ir.nasim;

import android.text.Spanned;
import android.text.style.StyleSpan;
import androidx.compose.ui.e;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.C13245fu;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import java.util.ArrayList;

/* renamed from: ir.nasim.Es1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC4340Es1 {

    /* renamed from: ir.nasim.Es1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        a(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(AbstractC24800zD5.features_authenticator_create_password_appbar, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Es1$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ C4574Fs1 b;
        final /* synthetic */ boolean c;

        b(SA2 sa2, C4574Fs1 c4574Fs1, boolean z) {
            this.a = sa2;
            this.b = c4574Fs1;
            this.c = z;
        }

        public final void a(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((((i & 6) == 0 ? i | (interfaceC22053ub1.V(ts4) ? 4 : 2) : i) & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            int i2 = 1;
            ED1 ed1 = null;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.foundation.layout.q.h(androidx.compose.ui.e.a, ts4), 0.0f, 1, null);
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            SA2 sa2 = this.a;
            C4574Fs1 c4574Fs1 = this.b;
            boolean z = this.c;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), bVarG, interfaceC22053ub1, 48);
            int i3 = 0;
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1.W(-1002148582);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB == aVar2.a()) {
                objB = AbstractC14221hZ2.a(c4574Fs1.P0(z), 0);
                interfaceC22053ub1.s(objB);
            }
            Spanned spanned = (Spanned) objB;
            interfaceC22053ub1.Q();
            AbstractC13042fc3.f(spanned);
            interfaceC22053ub1.W(-1002140805);
            boolean zV = interfaceC22053ub1.V(spanned);
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == aVar2.a()) {
                C13245fu.b bVar = new C13245fu.b(i3, i2, ed1);
                String string = spanned.toString();
                bVar.h(string);
                Object[] spans = spanned.getSpans(0, string.length(), StyleSpan.class);
                AbstractC13042fc3.h(spans, "getSpans(...)");
                ArrayList<StyleSpan> arrayList = new ArrayList();
                for (Object obj : spans) {
                    if (((StyleSpan) obj).getStyle() == 1) {
                        arrayList.add(obj);
                    }
                }
                for (StyleSpan styleSpan : arrayList) {
                    bVar.b(new C12863fI6(0L, 0L, C4593Fu2.b.c(), (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65531, (ED1) null), spanned.getSpanStart(styleSpan), spanned.getSpanEnd(styleSpan));
                }
                objB2 = bVar.o();
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            e.a aVar3 = androidx.compose.ui.e.a;
            ZH6.a(ZY0.b(c9784aZ0, aVar3, 1.0f, false, 2, null), interfaceC22053ub1, 0);
            AbstractC24975zX0.a aVar4 = AbstractC24975zX0.b;
            G10 g10 = G10.a;
            int i4 = G10.b;
            AbstractC11456d23.b(FV4.c(JB5.password, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar3, C17784nZ1.q(56)), null, null, 0.0f, AbstractC24975zX0.a.b(aVar4, g10.a(interfaceC22053ub1, i4).D(), 0, 2, null), interfaceC22053ub1, 432, 56);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar3, g10.c(interfaceC22053ub1, i4).b().e()), interfaceC22053ub1, 0);
            AbstractC9339Zm7.b(UY6.c(AbstractC24800zD5.features_authenticator_create_password_intro_title, interfaceC22053ub1, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).l(), interfaceC22053ub1, 0, 0, 65534);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar3, g10.c(interfaceC22053ub1, i4).b().c()), interfaceC22053ub1, 0);
            AbstractC9339Zm7.c((C13245fu) objB2, androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.k(aVar3, g10.c(interfaceC22053ub1, i4).b().m(), 0.0f, 2, null), 0.0f, 1, null), g10.a(interfaceC22053ub1, i4).z(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, null, g10.d(interfaceC22053ub1, i4).a(), interfaceC22053ub1, 0, 0, 130552);
            ZH6.a(ZY0.b(c9784aZ0, aVar3, 1.0f, false, 2, null), interfaceC22053ub1, 0);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            AbstractC17932no0.y(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.j(aVar3, g10.c(interfaceC22053ub1, i4).b().e(), g10.c(interfaceC22053ub1, i4).b().c()), 0.0f, 1, null), sa2, InterfaceC19114po0.b.a.a, null, UY6.c(AbstractC24800zD5.features_authenticator_create_password_confirm_and_continue_button, interfaceC22053ub1, 0), null, interfaceC22053ub1, InterfaceC19114po0.b.a.b << 6, 40);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Type inference failed for: r4v19, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(androidx.compose.ui.e r23, ir.nasim.C4574Fs1 r24, ir.nasim.SA2 r25, ir.nasim.SA2 r26, boolean r27, ir.nasim.InterfaceC22053ub1 r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4340Es1.e(androidx.compose.ui.e, ir.nasim.Fs1, ir.nasim.SA2, ir.nasim.SA2, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(androidx.compose.ui.e eVar, C4574Fs1 c4574Fs1, SA2 sa2, SA2 sa22, boolean z, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        e(eVar, c4574Fs1, sa2, sa22, z, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void i(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1263624696);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C10094b41.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.As1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4340Es1.j(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        i(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
