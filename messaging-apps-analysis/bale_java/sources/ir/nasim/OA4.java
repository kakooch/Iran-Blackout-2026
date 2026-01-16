package ir.nasim;

import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import java.util.List;

/* loaded from: classes5.dex */
public final class OA4 implements InterfaceC10056b03 {
    @Override // ir.nasim.InterfaceC10056b03
    public List a() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC10056b03
    public boolean b() {
        return false;
    }

    @Override // ir.nasim.InterfaceC10056b03
    public void c(ShortcutInfo shortcutInfo, IntentSender intentSender) {
        AbstractC13042fc3.i(shortcutInfo, "shortcut");
    }
}
