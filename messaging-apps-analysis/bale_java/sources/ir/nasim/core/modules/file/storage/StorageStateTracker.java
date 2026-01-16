package ir.nasim.core.modules.file.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u000eB\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lir/nasim/core/modules/file/storage/StorageStateTracker;", "Landroid/content/BroadcastReceiver;", "Lkotlin/Function1;", "", "Lir/nasim/rB7;", "onStorageStateChanged", "<init>", "(Lir/nasim/UA2;)V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Lir/nasim/UA2;", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class StorageStateTracker extends BroadcastReceiver {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final UA2 onStorageStateChanged;

    /* renamed from: ir.nasim.core.modules.file.storage.StorageStateTracker$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final IntentFilter a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            return intentFilter;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public StorageStateTracker(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onStorageStateChanged");
        this.onStorageStateChanged = ua2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        String action = intent.getAction();
        if (AbstractC13042fc3.d(action, "android.intent.action.DEVICE_STORAGE_OK") || AbstractC13042fc3.d(action, "android.intent.action.DEVICE_STORAGE_LOW")) {
            this.onStorageStateChanged.invoke(action);
        }
    }
}
