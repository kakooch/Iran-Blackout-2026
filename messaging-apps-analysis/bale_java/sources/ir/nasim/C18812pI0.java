package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;

/* renamed from: ir.nasim.pI0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18812pI0 {
    private final E84 a;
    private final C8054Ui1 b;

    public C18812pI0(E84 e84, C8054Ui1 c8054Ui1) {
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        this.a = e84;
        this.b = c8054Ui1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C18812pI0 c18812pI0, J44 j44, C11458d25 c11458d25, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c18812pI0, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(c11458d25, "$peer");
        Object objA = c4382Ew7.a();
        AbstractC13042fc3.h(objA, "getT1(...)");
        if (!(((Object[]) objA).length == 0)) {
            C8054Ui1 c8054Ui1 = c18812pI0.b;
            AbstractC13042fc3.h(c4382Ew7.a(), "getT1(...)");
            C3512Be1 c3512Be1K0 = c8054Ui1.k0(((C21231tK7) AbstractC10242bK.b0((Object[]) r4)).o());
            boolean z = (c3512Be1K0 != null ? Integer.valueOf(c3512Be1K0.r()) : null) != null;
            AbstractC17457n0 abstractC17457n0F = j44.F();
            AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.ContactContent");
            Object objA2 = c4382Ew7.a();
            AbstractC13042fc3.h(objA2, "getT1(...)");
            int iO = ((C21231tK7) AbstractC10242bK.b0((Object[]) objA2)).o();
            Object objA3 = c4382Ew7.a();
            AbstractC13042fc3.h(objA3, "getT1(...)");
            C6833Pe1 c6833Pe1C = ((C6833Pe1) abstractC17457n0F).C(iO, z, (Avatar) ((C21231tK7) AbstractC10242bK.b0((Object[]) objA3)).h().b());
            AbstractC13042fc3.h(c6833Pe1C, "updateContactContent(...)");
            c18812pI0.a.H0(c11458d25).d(j44.u(c6833Pe1C, true));
        }
    }

    public final void b(final J44 j44, final C11458d25 c11458d25) {
        ArrayList arrayListW;
        String str;
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(c11458d25, "peer");
        if (j44.F() instanceof C6833Pe1) {
            AbstractC17457n0 abstractC17457n0F = j44.F();
            String strM = null;
            C6833Pe1 c6833Pe1 = abstractC17457n0F instanceof C6833Pe1 ? (C6833Pe1) abstractC17457n0F : null;
            if (c6833Pe1 != null && (arrayListW = c6833Pe1.w()) != null && (str = (String) AbstractC15401jX0.t0(arrayListW, 0)) != null) {
                strM = AbstractC20153rZ6.M(str, Separators.SP, "", false, 4, null);
            }
            C8054Ui1 c8054Ui1 = this.b;
            if (strM == null) {
                return;
            }
            c8054Ui1.h0(strM).m0(new InterfaceC24449ye1() { // from class: ir.nasim.oI0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C18812pI0.c(this.a, j44, c11458d25, (C4382Ew7) obj);
                }
            });
        }
    }
}
