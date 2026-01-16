package androidx.work;

import android.content.Context;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class WorkManager {
    public abstract Operation enqueue(List<? extends WorkRequest> requests);

    public abstract Operation enqueueUniqueWork(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> work);

    public static WorkManager getInstance(Context context) {
        return WorkManagerImpl.getInstance(context);
    }

    public static void initialize(Context context, Configuration configuration) {
        WorkManagerImpl.initialize(context, configuration);
    }

    public final Operation enqueue(WorkRequest workRequest) {
        return enqueue(Collections.singletonList(workRequest));
    }

    public Operation enqueueUniqueWork(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest work) {
        return enqueueUniqueWork(uniqueWorkName, existingWorkPolicy, Collections.singletonList(work));
    }

    protected WorkManager() {
    }
}
