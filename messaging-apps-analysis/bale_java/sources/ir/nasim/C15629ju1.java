package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ju1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15629ju1 {
    public final String a(J44 j44, boolean z, C14733iO2 c14733iO2, String str) {
        AbstractC13042fc3.i(j44, "originalMessage");
        AbstractC13042fc3.i(str, "channelUrl");
        if (c14733iO2 == null) {
            return null;
        }
        if (j44.F() instanceof C11907dl) {
            AbstractC17457n0 abstractC17457n0F = j44.F();
            AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
            j44 = (J44) ((C11907dl) abstractC17457n0F).r().get(r6.size() - 1);
        }
        String str2 = (String) c14733iO2.w().b();
        if (str2 != null && str2.length() > 0) {
            return str + str2 + Separators.SLASH + j44.i() + Separators.SLASH + j44.W();
        }
        return str + "post/" + c14733iO2.r() + Separators.SLASH + j44.i() + Separators.SLASH + j44.W();
    }
}
