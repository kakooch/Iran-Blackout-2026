package ir.nasim.utils.tools.workmanager.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC21784u76;
import ir.nasim.C18495ol2;
import ir.nasim.C19406qI3;
import ir.nasim.C7183Qq;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u001b\u0010\u0014\u001a\u00020\b2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012H\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lir/nasim/utils/tools/workmanager/workers/RemoveFilePreferencesFromDefaultProperties;", "Landroidx/work/Worker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Lir/nasim/rB7;", "v", "()V", "", "removedCount", "allItemsCount", "u", "(II)V", "t", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "s", "(Ljava/lang/Exception;)V", "Landroidx/work/ListenableWorker$a;", "r", "()Landroidx/work/ListenableWorker$a;", "g", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class RemoveFilePreferencesFromDefaultProperties extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoveFilePreferencesFromDefaultProperties(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        AbstractC13042fc3.i(context, "appContext");
        AbstractC13042fc3.i(workerParameters, "workerParams");
    }

    private final void s(Exception exception) {
        if (AbstractC21784u76.c()) {
            C19406qI3.c("removeDownloadPrefs", "Error on executing removeDownloadPrefs doWork!", exception);
        }
    }

    private final void t() {
        if (AbstractC21784u76.c()) {
            C19406qI3.a("removeDownloadPrefs", "removeDownloadPrefs done: no items are removed!", new Object[0]);
        }
    }

    private final void u(int removedCount, int allItemsCount) {
        if (AbstractC21784u76.c()) {
            C19406qI3.a("removeDownloadPrefs", "removeDownloadPrefs done, removed " + removedCount + " items from " + allItemsCount + " items!", new Object[0]);
        }
    }

    private final void v() {
        if (AbstractC21784u76.c()) {
            C19406qI3.a("removeDownloadPrefs", "removeDownloadPrefs started!", new Object[0]);
        }
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a r() {
        try {
            v();
            Map all = C7183Qq.p().getAll();
            Set setKeySet = all.keySet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : setKeySet) {
                String str = (String) obj;
                AbstractC13042fc3.f(str);
                if (AbstractC20153rZ6.S(str, C18495ol2.E.a(), false, 2, null) || AbstractC20153rZ6.S(str, "Upload_Parts_Of_", false, 2, null)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                C7183Qq.p().i(arrayList);
                u(arrayList.size(), all.size());
                C7183Qq.p().remove("sender_pending");
            } else {
                t();
            }
        } catch (Exception e) {
            s(e);
        }
        ListenableWorker.a aVarC = ListenableWorker.a.c();
        AbstractC13042fc3.h(aVarC, "success(...)");
        return aVarC;
    }
}
