package androidx.work;

import android.net.Uri;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class WorkerParameters {
    private Executor mBackgroundExecutor;
    private ForegroundUpdater mForegroundUpdater;
    private UUID mId;
    private Data mInputData;
    private TaskExecutor mWorkTaskExecutor;
    private WorkerFactory mWorkerFactory;

    public static class RuntimeExtras {
        public List<String> triggeredContentAuthorities = Collections.emptyList();
        public List<Uri> triggeredContentUris = Collections.emptyList();
    }

    public WorkerParameters(UUID id, Data inputData, Collection<String> tags, RuntimeExtras runtimeExtras, int runAttemptCount, Executor backgroundExecutor, TaskExecutor workTaskExecutor, WorkerFactory workerFactory, ProgressUpdater progressUpdater, ForegroundUpdater foregroundUpdater) {
        this.mId = id;
        this.mInputData = inputData;
        new HashSet(tags);
        this.mBackgroundExecutor = backgroundExecutor;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkerFactory = workerFactory;
        this.mForegroundUpdater = foregroundUpdater;
    }

    public UUID getId() {
        return this.mId;
    }

    public Data getInputData() {
        return this.mInputData;
    }

    public Executor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }

    public ForegroundUpdater getForegroundUpdater() {
        return this.mForegroundUpdater;
    }
}
