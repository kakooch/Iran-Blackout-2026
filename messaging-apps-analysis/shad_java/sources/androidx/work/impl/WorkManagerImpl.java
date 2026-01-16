package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.Configuration;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.R$bool;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class WorkManagerImpl extends WorkManager {
    private static WorkManagerImpl sDefaultInstance;
    private static WorkManagerImpl sDelegatedInstance;
    private static final Object sLock;
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    static {
        Logger.tagWithPrefix("WorkManagerImpl");
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    @Deprecated
    public static WorkManagerImpl getInstance() {
        synchronized (sLock) {
            WorkManagerImpl workManagerImpl = sDelegatedInstance;
            if (workManagerImpl != null) {
                return workManagerImpl;
            }
            return sDefaultInstance;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static WorkManagerImpl getInstance(Context context) {
        WorkManagerImpl workManagerImpl;
        synchronized (sLock) {
            workManagerImpl = getInstance();
            if (workManagerImpl == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Configuration.Provider) {
                    initialize(applicationContext, ((Configuration.Provider) applicationContext).getWorkManagerConfiguration());
                    workManagerImpl = getInstance(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return workManagerImpl;
    }

    public static void initialize(Context context, Configuration configuration) {
        synchronized (sLock) {
            WorkManagerImpl workManagerImpl = sDelegatedInstance;
            if (workManagerImpl != null && sDefaultInstance != null) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
            }
            if (workManagerImpl == null) {
                Context applicationContext = context.getApplicationContext();
                if (sDefaultInstance == null) {
                    sDefaultInstance = new WorkManagerImpl(applicationContext, configuration, new WorkManagerTaskExecutor(configuration.getTaskExecutor()));
                }
                sDelegatedInstance = sDefaultInstance;
            }
        }
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor) {
        this(context, configuration, workTaskExecutor, context.getResources().getBoolean(R$bool.workmanager_test_configuration));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, boolean useTestDatabase) {
        this(context, configuration, workTaskExecutor, WorkDatabase.create(context.getApplicationContext(), workTaskExecutor.getBackgroundExecutor(), useTestDatabase));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase database) {
        Context applicationContext = context.getApplicationContext();
        Logger.setLogger(new Logger.LogcatLogger(configuration.getMinimumLoggingLevel()));
        List<Scheduler> listCreateSchedulers = createSchedulers(applicationContext, configuration, workTaskExecutor);
        internalInit(context, configuration, workTaskExecutor, database, listCreateSchedulers, new Processor(context, configuration, workTaskExecutor, database, listCreateSchedulers));
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    public Processor getProcessor() {
        return this.mProcessor;
    }

    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    @Override // androidx.work.WorkManager
    public Operation enqueue(List<? extends WorkRequest> requests) {
        if (requests.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new WorkContinuationImpl(this, requests).enqueue();
    }

    @Override // androidx.work.WorkManager
    public Operation enqueueUniqueWork(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> work) {
        return new WorkContinuationImpl(this, uniqueWorkName, existingWorkPolicy, work).enqueue();
    }

    public Operation cancelWorkById(UUID id) {
        CancelWorkRunnable cancelWorkRunnableForId = CancelWorkRunnable.forId(id, this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(cancelWorkRunnableForId);
        return cancelWorkRunnableForId.getOperation();
    }

    public void startWork(String workSpecId) {
        startWork(workSpecId, null);
    }

    public void startWork(String workSpecId, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StartWorkRunnable(this, workSpecId, runtimeExtras));
    }

    public void stopWork(String workSpecId) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(this, workSpecId, false));
    }

    public void stopForegroundWork(String workSpecId) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(this, workSpecId, true));
    }

    public void rescheduleEligibleWork() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.cancelAll(getApplicationContext());
        }
        getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(getConfiguration(), getWorkDatabase(), getSchedulers());
    }

    public void onForceStopRunnableCompleted() {
        synchronized (sLock) {
            this.mForceStopRunnableCompleted = true;
            BroadcastReceiver.PendingResult pendingResult = this.mRescheduleReceiverResult;
            if (pendingResult != null) {
                pendingResult.finish();
                this.mRescheduleReceiverResult = null;
            }
        }
    }

    public void setReschedulePendingResult(BroadcastReceiver.PendingResult rescheduleReceiverResult) {
        synchronized (sLock) {
            this.mRescheduleReceiverResult = rescheduleReceiverResult;
            if (this.mForceStopRunnableCompleted) {
                rescheduleReceiverResult.finish();
                this.mRescheduleReceiverResult = null;
            }
        }
    }

    private void internalInit(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, List<Scheduler> schedulers, Processor processor) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = schedulers;
        this.mProcessor = processor;
        this.mPreferenceUtils = new PreferenceUtils(workDatabase);
        this.mForceStopRunnableCompleted = false;
        if (Build.VERSION.SDK_INT >= 24 && applicationContext.isDeviceProtectedStorage()) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.mWorkTaskExecutor.executeOnBackgroundThread(new ForceStopRunnable(applicationContext, this));
    }

    public List<Scheduler> createSchedulers(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        return Arrays.asList(Schedulers.createBestAvailableBackgroundScheduler(context, this), new GreedyScheduler(context, configuration, taskExecutor, this));
    }
}
