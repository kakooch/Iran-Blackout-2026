package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC24357yU3;
import ir.nasim.core.markdown.mention.MentionSpans;

/* renamed from: ir.nasim.b44, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10097b44 implements InterfaceC24357yU3.c {
    @Override // ir.nasim.InterfaceC24357yU3.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(InterfaceC24357yU3 interfaceC24357yU3, C9503a44 c9503a44) {
        AbstractC13042fc3.i(interfaceC24357yU3, "visitor");
        AbstractC13042fc3.i(c9503a44, "node");
        int length = interfaceC24357yU3.length();
        String str = Separators.AT + c9503a44.n();
        interfaceC24357yU3.m().d(str);
        interfaceC24357yU3.m().i(new MentionSpans(c9503a44.n(), c9503a44.m(), 0, 4, null), length, str.length() + length);
    }
}
