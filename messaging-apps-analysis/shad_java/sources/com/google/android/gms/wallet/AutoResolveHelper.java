package com.google.android.gms.wallet;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public class AutoResolveHelper {
    private static final long zzu = TimeUnit.MINUTES.toMillis(10);
    static long zzv = SystemClock.elapsedRealtime();

    /* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
    public static class zza extends Fragment {
        private static String zzw = "resolveCallId";
        private static String zzx = "requestCode";
        private static String zzy = "initializationElapsedRealtime";
        private static String zzz = "delivered";
        private int zzaa;
        private zzb<?> zzab;
        private boolean zzac;

        /* JADX INFO: Access modifiers changed from: private */
        public static Fragment zza(int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt(zzw, i);
            bundle.putInt(zzx, i2);
            bundle.putLong(zzy, AutoResolveHelper.zzv);
            zza zzaVar = new zza();
            zzaVar.setArguments(bundle);
            return zzaVar;
        }

        @Override // android.app.Fragment
        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.zzaa = getArguments().getInt(zzx);
            if (AutoResolveHelper.zzv != getArguments().getLong(zzy)) {
                this.zzab = null;
            } else {
                this.zzab = zzb.zzae.get(getArguments().getInt(zzw));
            }
            this.zzac = bundle != null && bundle.getBoolean(zzz);
        }

        @Override // android.app.Fragment
        public final void onResume() throws PendingIntent.CanceledException {
            super.onResume();
            zzb<?> zzbVar = this.zzab;
            if (zzbVar != null) {
                zzbVar.zza(this);
                return;
            }
            if (Log.isLoggable("AutoResolveHelper", 5)) {
                Log.w("AutoResolveHelper", "Sending canceled result for garbage collected task!");
            }
            zza(null);
        }

        @Override // android.app.Fragment
        public final void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(zzz, this.zzac);
            zzc();
        }

        @Override // android.app.Fragment
        public final void onPause() {
            super.onPause();
            zzc();
        }

        private final void zzc() {
            zzb<?> zzbVar = this.zzab;
            if (zzbVar != null) {
                zzbVar.zzb(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Task<? extends AutoResolvableResult> task) throws PendingIntent.CanceledException {
            if (this.zzac) {
                return;
            }
            this.zzac = true;
            Activity activity = getActivity();
            activity.getFragmentManager().beginTransaction().remove(this).commit();
            if (task != null) {
                AutoResolveHelper.zza(activity, this.zzaa, task);
            } else {
                AutoResolveHelper.zza(activity, this.zzaa, 0, new Intent());
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
    static class zzb<TResult extends AutoResolvableResult> implements OnCompleteListener<TResult>, Runnable {
        private static final Handler zzad = new com.google.android.gms.internal.wallet.zzi(Looper.getMainLooper());
        static final SparseArray<zzb<?>> zzae = new SparseArray<>(2);
        private static final AtomicInteger zzaf = new AtomicInteger();
        int zzag;
        private zza zzah;
        private Task<TResult> zzai;

        zzb() {
        }

        public static <TResult extends AutoResolvableResult> zzb<TResult> zzb(Task<TResult> task) {
            zzb<TResult> zzbVar = new zzb<>();
            int iIncrementAndGet = zzaf.incrementAndGet();
            zzbVar.zzag = iIncrementAndGet;
            zzae.put(iIncrementAndGet, zzbVar);
            zzad.postDelayed(zzbVar, AutoResolveHelper.zzu);
            task.addOnCompleteListener(zzbVar);
            return zzbVar;
        }

        public final void zza(zza zzaVar) throws PendingIntent.CanceledException {
            this.zzah = zzaVar;
            zzd();
        }

        public final void zzb(zza zzaVar) {
            if (this.zzah == zzaVar) {
                this.zzah = null;
            }
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task<TResult> task) throws PendingIntent.CanceledException {
            this.zzai = task;
            zzd();
        }

        @Override // java.lang.Runnable
        public final void run() {
            zzae.delete(this.zzag);
        }

        private final void zzd() throws PendingIntent.CanceledException {
            if (this.zzai == null || this.zzah == null) {
                return;
            }
            zzae.delete(this.zzag);
            zzad.removeCallbacks(this);
            this.zzah.zza(this.zzai);
        }
    }

    public static <TResult extends AutoResolvableResult> void resolveTask(Task<TResult> task, Activity activity, int i) {
        zzb zzbVarZzb = zzb.zzb(task);
        FragmentTransaction fragmentTransactionBeginTransaction = activity.getFragmentManager().beginTransaction();
        Fragment fragmentZza = zza.zza(zzbVarZzb.zzag, i);
        int i2 = zzbVarZzb.zzag;
        StringBuilder sb = new StringBuilder(58);
        sb.append("com.google.android.gms.wallet.AutoResolveHelper");
        sb.append(i2);
        fragmentTransactionBeginTransaction.add(fragmentZza, sb.toString()).commit();
    }

    public static Status getStatusFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Status) intent.getParcelableExtra("com.google.android.gms.common.api.AutoResolveHelper.status");
    }

    public static void putStatusIntoIntent(Intent intent, Status status) {
        if (status == null) {
            intent.removeExtra("com.google.android.gms.common.api.AutoResolveHelper.status");
        } else {
            intent.putExtra("com.google.android.gms.common.api.AutoResolveHelper.status", status);
        }
    }

    public static <TResult> void zza(Status status, TResult tresult, TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.setResult(tresult);
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(status));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Activity activity, int i, Task<? extends AutoResolvableResult> task) throws PendingIntent.CanceledException {
        if (activity.isFinishing()) {
            if (Log.isLoggable("AutoResolveHelper", 3)) {
                Log.d("AutoResolveHelper", "Ignoring task result for, Activity is finishing.");
                return;
            }
            return;
        }
        if (task.getException() instanceof ResolvableApiException) {
            try {
                ((ResolvableApiException) task.getException()).startResolutionForResult(activity, i);
                return;
            } catch (IntentSender.SendIntentException e) {
                if (Log.isLoggable("AutoResolveHelper", 6)) {
                    Log.e("AutoResolveHelper", "Error starting pending intent!", e);
                    return;
                }
                return;
            }
        }
        Intent intent = new Intent();
        int i2 = 1;
        if (task.isSuccessful()) {
            i2 = -1;
            task.getResult().putIntoIntent(intent);
        } else if (task.getException() instanceof ApiException) {
            ApiException apiException = (ApiException) task.getException();
            putStatusIntoIntent(intent, new Status(apiException.getStatusCode(), apiException.getMessage(), (PendingIntent) null));
        } else {
            if (Log.isLoggable("AutoResolveHelper", 6)) {
                Log.e("AutoResolveHelper", "Unexpected non API exception!", task.getException());
            }
            putStatusIntoIntent(intent, new Status(8, "Unexpected non API exception when trying to deliver the task result to an activity!"));
        }
        zza(activity, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Activity activity, int i, int i2, Intent intent) throws PendingIntent.CanceledException {
        PendingIntent pendingIntentCreatePendingResult = activity.createPendingResult(i, intent, 1073741824);
        if (pendingIntentCreatePendingResult == null) {
            if (Log.isLoggable("AutoResolveHelper", 5)) {
                Log.w("AutoResolveHelper", "Null pending result returned when trying to deliver task result!");
            }
        } else {
            try {
                pendingIntentCreatePendingResult.send(i2);
            } catch (PendingIntent.CanceledException e) {
                if (Log.isLoggable("AutoResolveHelper", 6)) {
                    Log.e("AutoResolveHelper", "Exception sending pending result", e);
                }
            }
        }
    }
}
