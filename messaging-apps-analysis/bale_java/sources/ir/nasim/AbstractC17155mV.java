package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.mV, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC17155mV {
    private static final List a = AbstractC11342cq6.K(AbstractC11342cq6.D(AbstractC9962aq6.c(new VU().a().iterator()), new InterfaceC14603iB2() { // from class: ir.nasim.lV
        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return AbstractC17155mV.b(((Integer) obj).intValue(), (UU) obj2);
        }
    }));

    /* renamed from: ir.nasim.mV$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ UU a;

        a(UU uu) {
            this.a = uu;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                TU.r(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15800kB6 b(int i, UU uu) {
        AbstractC13042fc3.i(uu, "previewParam");
        return new C15800kB6("ir.nasim.components.avatar_AvatarWithMultipleStatusPreview_null_DialogList_Avatar_0_EN_" + i, "DialogList", "Avatar", "", AbstractC19242q11.c(1135088498, true, new a(uu)), "EN", false, null, null, null, null, 1920, null);
    }

    public static final List c() {
        return a;
    }
}
