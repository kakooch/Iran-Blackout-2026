package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes.dex */
public final class zzau implements FusedLocationProviderApi {
    static /* bridge */ /* synthetic */ TaskCompletionSource zza(final BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzah
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                BaseImplementation$ResultHolder baseImplementation$ResultHolder2 = baseImplementation$ResultHolder;
                if (task.isSuccessful()) {
                    baseImplementation$ResultHolder2.setResult(Status.RESULT_SUCCESS);
                    return;
                }
                if (task.isCanceled()) {
                    baseImplementation$ResultHolder2.setFailedResult(Status.RESULT_CANCELED);
                    return;
                }
                Exception exception = task.getException();
                if (exception instanceof ApiException) {
                    baseImplementation$ResultHolder2.setFailedResult(((ApiException) exception).getStatus());
                } else {
                    baseImplementation$ResultHolder2.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
            }
        });
        return taskCompletionSource;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final Location getLastLocation(GoogleApiClient googleApiClient) throws Throwable {
        boolean zAwait;
        boolean z = false;
        Preconditions.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzda zzdaVar = (zzda) googleApiClient.getClient(zzbp.zza);
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            zzdaVar.zzt(new LastLocationRequest.Builder().build(), taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzai
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    AtomicReference atomicReference2 = atomicReference;
                    CountDownLatch countDownLatch2 = countDownLatch;
                    if (task.isSuccessful()) {
                        atomicReference2.set((Location) task.getResult());
                    }
                    countDownLatch2.countDown();
                }
            });
            try {
                long nanos = TimeUnit.SECONDS.toNanos(30L);
                long jNanoTime = System.nanoTime() + nanos;
                while (true) {
                    try {
                        try {
                            zAwait = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                            break;
                        } catch (InterruptedException unused) {
                            nanos = jNanoTime - System.nanoTime();
                            z = true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
                if (zAwait) {
                    return (Location) atomicReference.get();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.execute(new zzan(this, googleApiClient, locationListener));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        Looper looperMyLooper = Looper.myLooper();
        Preconditions.checkNotNull(looperMyLooper, "invalid null looper");
        return googleApiClient.execute(new zzak(this, googleApiClient, ListenerHolders.createListenerHolder(locationListener, looperMyLooper, LocationListener.class.getSimpleName()), locationRequest));
    }
}
