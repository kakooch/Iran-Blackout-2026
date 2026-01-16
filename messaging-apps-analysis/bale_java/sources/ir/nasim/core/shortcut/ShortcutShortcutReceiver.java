package ir.nasim.core.shortcut;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.UA2;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR(\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lir/nasim/core/shortcut/ShortcutShortcutReceiver;", "Landroid/content/BroadcastReceiver;", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function1;", "", "Lir/nasim/rB7;", "onShortcutCreated", "<init>", "(Ljava/lang/ref/WeakReference;)V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Ljava/lang/ref/WeakReference;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ShortcutShortcutReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    private final WeakReference onShortcutCreated;

    public ShortcutShortcutReceiver(WeakReference weakReference) {
        this.onShortcutCreated = weakReference;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        UA2 ua2;
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        if (AbstractC13042fc3.d(intent.getAction(), "android.intent.action.CREATE_SHORTCUT")) {
            WeakReference weakReference = this.onShortcutCreated;
            if (weakReference != null && (ua2 = (UA2) weakReference.get()) != null) {
                ua2.invoke(Boolean.TRUE);
            }
            context.unregisterReceiver(this);
        }
    }
}
