package ir.eitaa.ui.Components.Paint;

import ir.eitaa.messenger.AndroidUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public class UndoStore {
    private UndoStoreDelegate delegate;
    private Map<UUID, Runnable> uuidToOperationMap = new HashMap();
    private List<UUID> operations = new ArrayList();

    public interface UndoStoreDelegate {
        void historyChanged();
    }

    public boolean canUndo() {
        return !this.operations.isEmpty();
    }

    public void setDelegate(UndoStoreDelegate undoStoreDelegate) {
        this.delegate = undoStoreDelegate;
    }

    public void registerUndo(UUID uuid, Runnable undoRunnable) {
        this.uuidToOperationMap.put(uuid, undoRunnable);
        this.operations.add(uuid);
        notifyOfHistoryChanges();
    }

    public void unregisterUndo(UUID uuid) {
        this.uuidToOperationMap.remove(uuid);
        this.operations.remove(uuid);
        notifyOfHistoryChanges();
    }

    public void undo() {
        if (this.operations.size() == 0) {
            return;
        }
        int size = this.operations.size() - 1;
        UUID uuid = this.operations.get(size);
        Runnable runnable = this.uuidToOperationMap.get(uuid);
        this.uuidToOperationMap.remove(uuid);
        this.operations.remove(size);
        runnable.run();
        notifyOfHistoryChanges();
    }

    private void notifyOfHistoryChanges() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$UndoStore$14l3H2a9r1gLL7znqUXIBgSllAQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$notifyOfHistoryChanges$0$UndoStore();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$notifyOfHistoryChanges$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$notifyOfHistoryChanges$0$UndoStore() {
        UndoStoreDelegate undoStoreDelegate = this.delegate;
        if (undoStoreDelegate != null) {
            undoStoreDelegate.historyChanged();
        }
    }
}
