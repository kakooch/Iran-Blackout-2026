package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC24357yU3;
import ir.nasim.core.markdown.bot.BotSpans;

/* renamed from: ir.nasim.dj0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11888dj0 implements InterfaceC24357yU3.c {
    @Override // ir.nasim.InterfaceC24357yU3.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(InterfaceC24357yU3 interfaceC24357yU3, C11266cj0 c11266cj0) {
        AbstractC13042fc3.i(interfaceC24357yU3, "visitor");
        AbstractC13042fc3.i(c11266cj0, "node");
        int length = interfaceC24357yU3.length();
        String str = Separators.SLASH + c11266cj0.m();
        interfaceC24357yU3.m().d(str);
        interfaceC24357yU3.m().i(new BotSpans(str, c11266cj0.n()), length, str.length() + length);
    }
}
