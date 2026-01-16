package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.SP6;
import ir.nasim.W23;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class SP6 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ SA2 e;

        a(androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24) {
            this.a = eVar;
            this.b = sa2;
            this.c = sa22;
            this.d = sa23;
            this.e = sa24;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(this.a, 0.0f, 1, null);
            C24254yJ.f fVarE = C24254yJ.a.e();
            SA2 sa2 = this.b;
            SA2 sa22 = this.c;
            SA2 sa23 = this.d;
            SA2 sa24 = this.e;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarE, InterfaceC12529em.a.l(), interfaceC22053ub1, 6);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
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
            SP6.r(null, UY6.c(SD5.story_old_text_story_title, interfaceC22053ub1, 0), AbstractC23008wB5.ic_story_editor, sa2, null, interfaceC22053ub1, 0, 17);
            SP6.r(null, UY6.c(SD5.story_text_story, interfaceC22053ub1, 0), AbstractC23008wB5.ic_story_text_story, sa22, "STORY_ADDER_SCREEN_AFKAR_BUTTON", interfaceC22053ub1, 24576, 1);
            SP6.r(null, UY6.c(SD5.story_type_select_gallery, interfaceC22053ub1, 0), AbstractC23008wB5.ic_story_gallery, sa23, "STORY_ADDER_SCREEN_GALLERY_BUTTON", interfaceC22053ub1, 24576, 1);
            SP6.r(null, UY6.c(SD5.story_type_select_camera, interfaceC22053ub1, 0), AbstractC23008wB5.ic_story_camera, sa24, null, interfaceC22053ub1, 0, 17);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ C13636ga b;

        b(boolean z, C13636ga c13636ga) {
            this.a = z;
            this.b = c13636ga;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C13636ga c13636ga) {
            AbstractC13042fc3.i(c13636ga, "$addStoryUIEvents");
            c13636ga.v().invoke();
            return C19938rB7.a;
        }

        public final void b(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(l66, "$this$BaleTopAppbar");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (this.a) {
                interfaceC22053ub1.W(-758629548);
                boolean zD = interfaceC22053ub1.D(this.b);
                final C13636ga c13636ga = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.TP6
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return SP6.b.c(c13636ga);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC20434s03.a((SA2) objB, null, false, null, null, T91.a.a(), interfaceC22053ub1, 196608, 30);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC16978mB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ List b;
        final /* synthetic */ InterfaceC15974kV0 c;
        final /* synthetic */ List d;

        c(androidx.compose.ui.e eVar, List list, InterfaceC15974kV0 interfaceC15974kV0, List list2) {
            this.a = eVar;
            this.b = list;
            this.c = interfaceC15974kV0;
            this.d = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, int i, InterfaceC15974kV0 interfaceC15974kV0) {
            AbstractC13042fc3.i(list, "$suggestedList");
            AbstractC13042fc3.i(interfaceC15974kV0, "$onSelectSuggestion");
            FileReference fileReference = (FileReference) AbstractC15401jX0.t0(list, i);
            if (fileReference != null) {
                interfaceC15974kV0.a(fileReference);
            }
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, final int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(this.a, C17784nZ1.q(6));
            interfaceC22053ub1.W(460072704);
            boolean zD = ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.c);
            final List list = this.b;
            final InterfaceC15974kV0 interfaceC15974kV0 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.UP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return SP6.c.c(list, i, interfaceC15974kV0);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.e.f(eVarI, false, null, null, (SA2) objB, 7, null), C17784nZ1.q(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER)), C17784nZ1.q(70)), AbstractC5345Iy1.a(interfaceC22053ub1, 0) ? C24381yX0.b.h() : C24381yX0.b.j(), N46.c(AbstractC10554bo1.c(C17784nZ1.q(8))));
            androidx.compose.ui.e eVar = this.a;
            List list2 = this.d;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
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
            coil.compose.d.a(new W23.a((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).d(((InterfaceC3346Am2) list2.get(i)).getDescriptor()).c(true).a(), null, androidx.compose.foundation.layout.t.f(FV0.a(eVar, N46.d(C17784nZ1.q(10))), 0.0f, 1, null), null, null, null, InterfaceC13157fl1.a.a(), 0.0f, null, 0, false, null, interfaceC22053ub1, 1572912, 0, 4024);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;

        d(SA2 sa2) {
            this.a = sa2;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(2067642413);
            interfaceC22053ub1.W(-1191657936);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.e.d(eVar, (InterfaceC18507om4) objB, null, false, null, null, this.a, 28, null);
            interfaceC22053ub1.Q();
            return eVarD;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final void A(androidx.compose.ui.e eVar, final String str, final SA2 sa2, final InterfaceC15974kV0 interfaceC15974kV0, final List list, final List list2, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        final androidx.compose.ui.e eVar2;
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        final InterfaceC15974kV0 interfaceC15974kV02;
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(sa2, "onCloseSuggestedListClick");
        AbstractC13042fc3.i(interfaceC15974kV0, "onSelectSuggestion");
        AbstractC13042fc3.i(list, "suggestedList");
        AbstractC13042fc3.i(list2, "suggestedListFileReference");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2059079179);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = i | (interfaceC22053ub1J.V(eVar2) ? 4 : 2);
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        int i5 = i3;
        if ((i2 & 4) != 0) {
            i5 |= 384;
        } else if ((i & 384) == 0) {
            i5 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i5 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i5 |= (i & 4096) == 0 ? interfaceC22053ub1J.V(interfaceC15974kV0) : interfaceC22053ub1J.D(interfaceC15974kV0) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i5 |= 24576;
        } else if ((i & 24576) == 0) {
            i5 |= interfaceC22053ub1J.D(list) ? 16384 : 8192;
        }
        if ((i2 & 32) != 0) {
            i5 |= 196608;
        } else if ((i & 196608) == 0) {
            i5 |= interfaceC22053ub1J.D(list2) ? 131072 : 65536;
        }
        int i6 = i5;
        if ((74899 & i6) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            if (i4 != 0) {
                eVar2 = androidx.compose.ui.e.a;
            }
            float f = 12;
            androidx.compose.ui.e eVar3 = eVar2;
            float f2 = 14;
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(AbstractC9287Zh0.e(androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.j(androidx.compose.foundation.layout.t.h(eVar2, 0.0f, 1, null), C17784nZ1.q(SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER), C17784nZ1.q(280)), C17784nZ1.q(f)), AbstractC11256ci0.a(C17784nZ1.q(1), WX0.a(GA5.n40_light, interfaceC22053ub1J, 0)), N46.d(C17784nZ1.q(f2))), WX0.a(AbstractC5345Iy1.a(interfaceC22053ub1J, 0) ? GA5.n10_dark : GA5.n10_light, interfaceC22053ub1J, 0), N46.d(C17784nZ1.q(f2)));
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar.g();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), bVarG, interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(eVar3, 0.0f, 1, null), C17784nZ1.q(f));
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.e(), aVar.i(), interfaceC22053ub1J, 54);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            SA2 sa2A2 = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar2.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar2.f());
            M66 m66 = M66.a;
            C9348Zn7 c9348Zn7M = G10.a.d(interfaceC22053ub1J, G10.b).m();
            AbstractC9339Zm7.b(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7M.b((16744447 & 1) != 0 ? c9348Zn7M.a.g() : WX0.a(AbstractC5345Iy1.a(interfaceC22053ub1J, 0) ? GA5.n200_dark : GA5.n200_light, interfaceC22053ub1J, 0), (16744447 & 2) != 0 ? c9348Zn7M.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7M.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7M.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7M.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7M.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7M.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7M.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7M.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7M.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7M.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7M.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7M.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7M.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7M.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7M.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7M.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7M.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7M.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7M.c : null, (16744447 & 1048576) != 0 ? c9348Zn7M.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7M.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7M.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7M.b.k() : null), interfaceC22053ub1J, (i6 >> 3) & 14, 0, 65534);
            interfaceC22053ub12 = interfaceC22053ub1J;
            EV4 ev4C = FV4.c(AbstractC23008wB5.delete_input_card_number, interfaceC22053ub12, 0);
            long jA = WX0.a(AbstractC5345Iy1.a(interfaceC22053ub12, 0) ? GA5.n200_dark : GA5.n200_light, interfaceC22053ub12, 0);
            interfaceC22053ub12.W(-1119279637);
            boolean z = (i6 & 896) == 256;
            Object objB = interfaceC22053ub12.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.NP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return SP6.B(sa2);
                    }
                };
                interfaceC22053ub12.s(objB);
            }
            interfaceC22053ub12.Q();
            AbstractC24077y03.b(ev4C, "delete suggested stories", androidx.compose.foundation.e.f(eVar3, false, null, null, (SA2) objB, 7, null), jA, interfaceC22053ub12, 48, 0);
            interfaceC22053ub12.u();
            C24254yJ.f fVarO = c24254yJ.o(C17784nZ1.q(10));
            eVar2 = eVar3;
            boolean z2 = true;
            androidx.compose.ui.e eVarI2 = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(eVar2, 0.0f, 1, null), C17784nZ1.q(4));
            interfaceC22053ub12.W(-90168734);
            boolean zD = interfaceC22053ub12.D(list2) | ((i6 & 14) == 4) | interfaceC22053ub12.D(list);
            if ((i6 & 7168) != 2048) {
                interfaceC15974kV02 = interfaceC15974kV0;
                if ((i6 & 4096) == 0 || !interfaceC22053ub12.D(interfaceC15974kV02)) {
                    z2 = false;
                }
            } else {
                interfaceC15974kV02 = interfaceC15974kV0;
            }
            boolean z3 = z2 | zD;
            Object objB2 = interfaceC22053ub12.B();
            if (z3 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.OP6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return SP6.C(list2, eVar2, list, interfaceC15974kV02, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub12.s(objB2);
            }
            interfaceC22053ub12.Q();
            AbstractC12623ev3.d(eVarI2, null, null, false, fVarO, null, null, false, null, (UA2) objB2, interfaceC22053ub12, 24576, 494);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            final androidx.compose.ui.e eVar4 = eVar2;
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.PP6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return SP6.D(eVar4, str, sa2, interfaceC15974kV0, list, list2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onCloseSuggestedListClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(List list, androidx.compose.ui.e eVar, List list2, InterfaceC15974kV0 interfaceC15974kV0, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$suggestedListFileReference");
        AbstractC13042fc3.i(list2, "$suggestedList");
        AbstractC13042fc3.i(interfaceC15974kV0, "$onSelectSuggestion");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
        InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), null, null, AbstractC19242q11.c(-1707731711, true, new c(eVar, list2, interfaceC15974kV0, list)), 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(androidx.compose.ui.e eVar, String str, SA2 sa2, InterfaceC15974kV0 interfaceC15974kV0, List list, List list2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(sa2, "$onCloseSuggestedListClick");
        AbstractC13042fc3.i(interfaceC15974kV0, "$onSelectSuggestion");
        AbstractC13042fc3.i(list, "$suggestedList");
        AbstractC13042fc3.i(list2, "$suggestedListFileReference");
        A(eVar, str, sa2, interfaceC15974kV0, list, list2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e E(androidx.compose.ui.e eVar, SA2 sa2) {
        AbstractC13042fc3.i(eVar, "<this>");
        AbstractC13042fc3.i(sa2, "onClick");
        return androidx.compose.ui.c.c(eVar, null, new d(sa2), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(androidx.compose.ui.e r48, final ir.nasim.SA2 r49, boolean r50, ir.nasim.InterfaceC22053ub1 r51, final int r52, final int r53) {
        /*
            Method dump skipped, instructions count: 605
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SP6.m(androidx.compose.ui.e, ir.nasim.SA2, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onGetFallClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(androidx.compose.ui.e eVar, SA2 sa2, boolean z, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onGetFallClick");
        m(eVar, sa2, z, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void p(androidx.compose.ui.e eVar, final int i, final float f, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        androidx.compose.ui.e eVar2;
        int i4;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1982203869);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
            eVar2 = eVar;
        } else if ((i2 & 6) == 0) {
            eVar2 = eVar;
            i4 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i2;
        } else {
            eVar2 = eVar;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.c(f) ? 256 : 128;
        }
        int i6 = i4;
        if ((i6 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVar3 = i5 != 0 ? androidx.compose.ui.e.a : eVar2;
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.m(eVar3, 0.0f, 0.0f, 0.0f, f, 7, null), 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.b(), bVarG, interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
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
            androidx.compose.ui.e eVar4 = eVar3;
            AbstractC11456d23.b(FV4.c(AbstractC23008wB5.ic_story_type_select_empty_state, interfaceC22053ub1J, 0), "Story adder camera icon", null, null, null, 0.0f, AbstractC24975zX0.a.b(AbstractC24975zX0.b, WX0.a(GA5.n300, interfaceC22053ub1J, 0), 0, 2, null), interfaceC22053ub1J, 48, 60);
            ZH6.a(androidx.compose.foundation.layout.t.i(eVar4, C17784nZ1.q(12)), interfaceC22053ub1J, 0);
            String strC = UY6.c(i, interfaceC22053ub1J, (i6 >> 3) & 14);
            C9348Zn7 c9348Zn7C = G10.a.d(interfaceC22053ub1J, G10.b).c();
            AbstractC9339Zm7.b(strC, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7C.b((16744447 & 1) != 0 ? c9348Zn7C.a.g() : WX0.a(AbstractC5345Iy1.a(interfaceC22053ub1J, 0) ? GA5.n300_dark : GA5.n300_light, interfaceC22053ub1J, 0), (16744447 & 2) != 0 ? c9348Zn7C.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7C.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7C.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C.b.k() : null), interfaceC22053ub1J, 0, 0, 65534);
            interfaceC22053ub1J.u();
            eVar2 = eVar4;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            final androidx.compose.ui.e eVar5 = eVar2;
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.MP6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return SP6.q(eVar5, i, f, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(androidx.compose.ui.e eVar, int i, float f, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        p(eVar, i, f, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r(androidx.compose.ui.e r58, final java.lang.String r59, final int r60, final ir.nasim.SA2 r61, java.lang.String r62, ir.nasim.InterfaceC22053ub1 r63, final int r64, final int r65) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SP6.r(androidx.compose.ui.e, java.lang.String, int, ir.nasim.SA2, java.lang.String, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(String str, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        if (str != null) {
            AbstractC9939ao6.v0(interfaceC11943do6, str);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onActionClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(androidx.compose.ui.e eVar, String str, int i, SA2 sa2, String str2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$labelText");
        AbstractC13042fc3.i(sa2, "$onActionClick");
        r(eVar, str, i, sa2, str2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void v(androidx.compose.ui.e eVar, final SA2 sa2, final SA2 sa22, final SA2 sa23, final SA2 sa24, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        final androidx.compose.ui.e eVar2;
        int i3;
        AbstractC13042fc3.i(sa2, "onCameraClick");
        AbstractC13042fc3.i(sa22, "onGalleryClick");
        AbstractC13042fc3.i(sa23, "onThoughtsClick");
        AbstractC13042fc3.i(sa24, "onTextStoryClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2006477129);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(sa23) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(sa24) ? 16384 : 8192;
        }
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(599415287, true, new a(eVar3, sa24, sa23, sa22, sa2), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            eVar2 = eVar3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.QP6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return SP6.w(eVar2, sa2, sa22, sa23, sa24, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onCameraClick");
        AbstractC13042fc3.i(sa22, "$onGalleryClick");
        AbstractC13042fc3.i(sa23, "$onThoughtsClick");
        AbstractC13042fc3.i(sa24, "$onTextStoryClick");
        v(eVar, sa2, sa22, sa23, sa24, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fd A[PHI: r18
      0x00fd: PHI (r18v13 int) = (r18v4 int), (r18v7 int), (r18v8 int) binds: [B:80:0x00fb, B:88:0x0111, B:87:0x010e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void x(androidx.compose.ui.e r33, final ir.nasim.C13636ga r34, final boolean r35, int r36, boolean r37, final java.lang.String r38, ir.nasim.SA2 r39, boolean r40, final java.util.List r41, final java.util.List r42, ir.nasim.InterfaceC22053ub1 r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SP6.x(androidx.compose.ui.e, ir.nasim.ga, boolean, int, boolean, java.lang.String, ir.nasim.SA2, boolean, java.util.List, java.util.List, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(androidx.compose.ui.e eVar, C13636ga c13636ga, boolean z, int i, boolean z2, String str, SA2 sa2, boolean z3, List list, List list2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c13636ga, "$addStoryUIEvents");
        AbstractC13042fc3.i(str, "$suggestedStoryTitle");
        AbstractC13042fc3.i(list, "$suggestedList");
        AbstractC13042fc3.i(list2, "$suggestedListFileReference");
        x(eVar, c13636ga, z, i, z2, str, sa2, z3, list, list2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }
}
