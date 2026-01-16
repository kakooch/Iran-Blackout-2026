package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC24357yU3;
import ir.nasim.core.markdown.hashtag.HashTagSpans;

/* loaded from: classes4.dex */
public final class DU2 implements InterfaceC24357yU3.c {
    @Override // ir.nasim.InterfaceC24357yU3.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(InterfaceC24357yU3 interfaceC24357yU3, C24356yU2 c24356yU2) {
        AbstractC13042fc3.i(interfaceC24357yU3, "visitor");
        AbstractC13042fc3.i(c24356yU2, "node");
        int length = interfaceC24357yU3.length();
        String str = Separators.POUND + c24356yU2.m();
        interfaceC24357yU3.m().d(str);
        interfaceC24357yU3.m().i(new HashTagSpans(str), length, str.length() + length);
    }
}
