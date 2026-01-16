package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.dp5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC11952dp5 {
    private static final List a = AbstractC11342cq6.K(AbstractC11342cq6.D(AbstractC9962aq6.c(new C23101wM().a().iterator()), new InterfaceC14603iB2() { // from class: ir.nasim.cp5
        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return AbstractC11952dp5.b(((Integer) obj).intValue(), (KA7) obj2);
        }
    }));

    /* renamed from: ir.nasim.dp5$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ KA7 a;

        a(KA7 ka7) {
            this.a = ka7;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18847pM.p(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15800kB6 b(int i, KA7 ka7) {
        AbstractC13042fc3.i(ka7, "previewParam");
        return new C15800kB6("ir.nasim.designsystem.audiobar_PreviewAudioBar_null_AudioBar_AudioBar_0_null_" + i, "AudioBar", "AudioBar", "", AbstractC19242q11.c(846284264, true, new a(ka7)), null, false, null, null, null, null, 1952, null);
    }

    public static final List c() {
        return a;
    }
}
