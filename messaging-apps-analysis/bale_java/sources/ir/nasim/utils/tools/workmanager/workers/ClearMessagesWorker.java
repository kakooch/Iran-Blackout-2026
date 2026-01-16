package ir.nasim.utils.tools.workmanager.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21784u76;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11335cq;
import ir.nasim.C19406qI3;
import ir.nasim.C5735Kp4;
import ir.nasim.C9057Yh4;
import ir.nasim.E84;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lir/nasim/utils/tools/workmanager/workers/ClearMessagesWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/ListenableWorker$a;", "r", "()Landroidx/work/ListenableWorker$a;", "g", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class ClearMessagesWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearMessagesWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        AbstractC13042fc3.i(context, "appContext");
        AbstractC13042fc3.i(workerParameters, "workerParams");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a r() {
        long[] jArrL;
        C9057Yh4 c9057Yh4O2;
        E84 e84G;
        try {
            jArrL = g().l("peers_id_to_clear");
        } catch (Exception e) {
            if (AbstractC21784u76.c()) {
                C19406qI3.c("ClearMessagesWorker", "Error on executing ClearMessagesWorker doWork!", e);
            }
        }
        if (jArrL != null && jArrL.length != 0) {
            if (AbstractC5969Lp4.d() == null) {
                C5735Kp4.w().L();
            }
            C11335cq c11335cqD = AbstractC5969Lp4.d();
            if (c11335cqD != null && (c9057Yh4O2 = c11335cqD.o2()) != null && (e84G = c9057Yh4O2.G()) != null) {
                e84G.n0(AbstractC10242bK.e1(jArrL));
            }
            ListenableWorker.a aVarC = ListenableWorker.a.c();
            AbstractC13042fc3.h(aVarC, "success(...)");
            return aVarC;
        }
        ListenableWorker.a aVarC2 = ListenableWorker.a.c();
        AbstractC13042fc3.h(aVarC2, "success(...)");
        return aVarC2;
    }
}
