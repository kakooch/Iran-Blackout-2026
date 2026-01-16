package ir.nasim.utils.tools.workmanager.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21784u76;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C10299bQ2;
import ir.nasim.C11335cq;
import ir.nasim.C19406qI3;
import ir.nasim.C5735Kp4;
import ir.nasim.C9057Yh4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lir/nasim/utils/tools/workmanager/workers/ClearAllGroupPermissions;", "Landroidx/work/Worker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/ListenableWorker$a;", "r", "()Landroidx/work/ListenableWorker$a;", "g", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class ClearAllGroupPermissions extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearAllGroupPermissions(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        AbstractC13042fc3.i(context, "appContext");
        AbstractC13042fc3.i(workerParameters, "workerParams");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a r() {
        C9057Yh4 c9057Yh4O2;
        C10299bQ2 c10299bQ2E;
        try {
            C19406qI3.a("clearGroupPermissions", "Start clearAllGroupPermissions worker", new Object[0]);
            if (AbstractC5969Lp4.d() == null) {
                C5735Kp4.w().L();
            }
            C11335cq c11335cqD = AbstractC5969Lp4.d();
            if (c11335cqD != null && (c9057Yh4O2 = c11335cqD.o2()) != null && (c10299bQ2E = c9057Yh4O2.E()) != null) {
                c10299bQ2E.s1();
            }
        } catch (Exception e) {
            if (AbstractC21784u76.c()) {
                C19406qI3.c("clearGroupPermissions", "Error on executing ClearAllGroupPermissions doWork!", e);
            }
        }
        ListenableWorker.a aVarC = ListenableWorker.a.c();
        AbstractC13042fc3.h(aVarC, "success(...)");
        return aVarC;
    }
}
