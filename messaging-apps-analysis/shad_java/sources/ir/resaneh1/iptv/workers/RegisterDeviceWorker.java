package ir.resaneh1.iptv.workers;

import android.content.Context;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.messaging.FirebaseMessaging;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.logger.MyLog;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes.dex */
public class RegisterDeviceWorker extends ListenableWorker {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    interface TokenCallback {
        void onFailure();

        void onSuccess();
    }

    public RegisterDeviceWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: ir.resaneh1.iptv.workers.RegisterDeviceWorker$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.lambda$startWork$0(completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$startWork$0(final CallbackToFutureAdapter.Completer completer) throws Exception {
        TokenCallback tokenCallback = new TokenCallback(this) { // from class: ir.resaneh1.iptv.workers.RegisterDeviceWorker.1
            @Override // ir.resaneh1.iptv.workers.RegisterDeviceWorker.TokenCallback
            public void onSuccess() {
                RegisterDeviceWorker.scheduleNextWorker(ApplicationLoader.applicationContext, ExistingWorkPolicy.REPLACE, 86400L);
                completer.set(ListenableWorker.Result.success());
            }

            @Override // ir.resaneh1.iptv.workers.RegisterDeviceWorker.TokenCallback
            public void onFailure() {
                RegisterDeviceWorker.scheduleNextWorker(ApplicationLoader.applicationContext, ExistingWorkPolicy.REPLACE, 900L);
                completer.set(ListenableWorker.Result.failure());
            }
        };
        getToken(tokenCallback);
        return tokenCallback;
    }

    private void getToken(final TokenCallback tokenCallback) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: ir.resaneh1.iptv.workers.RegisterDeviceWorker$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                RegisterDeviceWorker.lambda$getToken$1(tokenCallback, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getToken$1(TokenCallback tokenCallback, Task task) {
        if (!task.isSuccessful() || task.getResult() == null) {
            Log.w("RegisterDeviceWorker", "getInstanceId failed", task.getException());
            MyLog.handleException(new Exception());
            tokenCallback.onFailure();
        } else {
            MyLog.e("RegisterDeviceWorker", ((String) task.getResult()) + BuildConfig.FLAVOR);
            tokenCallback.onSuccess();
        }
    }

    public static void scheduleNextWorker(Context context, ExistingWorkPolicy existingWorkPolicy, long j) {
        boolean z = MyLog.isDebugAble;
        Constraints.Builder builder = new Constraints.Builder();
        builder.setRequiredNetworkType(NetworkType.CONNECTED);
        WorkManager.getInstance(context).enqueueUniqueWork("RegisterWorker", existingWorkPolicy, new OneTimeWorkRequest.Builder(RegisterDeviceWorker.class).setConstraints(builder.build()).setInitialDelay(j, TimeUnit.SECONDS).build());
        MyLog.e("RegisterDeviceWorker", "worker with id RegisterWorker scheduled for " + j + " seconds later");
    }
}
