package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public class WorkProgressUpdater implements ProgressUpdater {
    static {
        Logger.tagWithPrefix("WorkProgressUpdater");
    }

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
    }
}
