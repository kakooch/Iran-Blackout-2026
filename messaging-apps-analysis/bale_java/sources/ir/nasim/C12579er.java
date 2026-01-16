package ir.nasim;

import android.content.Context;
import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import java.util.List;

/* renamed from: ir.nasim.er, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12579er implements InterfaceC10056b03 {
    private final Context a;
    private final ShortcutManager b;

    public C12579er(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = IA6.a(context.getSystemService(FA6.a()));
    }

    @Override // ir.nasim.InterfaceC10056b03
    public List a() {
        List pinnedShortcuts;
        ShortcutManager shortcutManager = this.b;
        return (shortcutManager == null || (pinnedShortcuts = shortcutManager.getPinnedShortcuts()) == null) ? AbstractC10360bX0.m() : pinnedShortcuts;
    }

    @Override // ir.nasim.InterfaceC10056b03
    public boolean b() {
        ShortcutManager shortcutManager = this.b;
        return shortcutManager != null && shortcutManager.isRequestPinShortcutSupported();
    }

    @Override // ir.nasim.InterfaceC10056b03
    public void c(ShortcutInfo shortcutInfo, IntentSender intentSender) {
        AbstractC13042fc3.i(shortcutInfo, "shortcut");
        ShortcutManager shortcutManager = this.b;
        if (shortcutManager != null) {
            shortcutManager.requestPinShortcut(shortcutInfo, intentSender);
        }
    }
}
