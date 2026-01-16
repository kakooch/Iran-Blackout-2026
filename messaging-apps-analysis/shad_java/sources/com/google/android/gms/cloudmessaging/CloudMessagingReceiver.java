package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes.dex */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    private final ExecutorService zza = com.google.android.gms.internal.cloudmessaging.zza.zza().zza(new NamedThreadFactory("firebase-iid-executor"), com.google.android.gms.internal.cloudmessaging.zzf.zza);

    protected abstract int onMessageReceive(Context context, CloudMessage cloudMessage);

    protected abstract void onNotificationDismissed(Context context, Bundle bundle);

    protected void onNotificationOpen(Context context, Bundle bundle) {
    }

    protected Executor getBroadcastExecutor() {
        return this.zza;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean zIsOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        getBroadcastExecutor().execute(new Runnable(this, intent, context, zIsOrderedBroadcast, pendingResultGoAsync) { // from class: com.google.android.gms.cloudmessaging.zzd
            private final CloudMessagingReceiver zza;
            private final Intent zzb;
            private final Context zzc;
            private final boolean zzd;
            private final BroadcastReceiver.PendingResult zze;

            {
                this.zza = this;
                this.zzb = intent;
                this.zzc = context;
                this.zzd = zIsOrderedBroadcast;
                this.zze = pendingResultGoAsync;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
    }

    private final int zza(Context context, Intent intent) throws PendingIntent.CanceledException {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            onNotificationOpen(context, extras);
            return -1;
        }
        if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            onNotificationDismissed(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
    }

    private final int zzb(Context context, Intent intent) {
        Task<Void> taskZza;
        if (intent.getExtras() == null) {
            return HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
        }
        String stringExtra = intent.getStringExtra("google.message_id");
        if (TextUtils.isEmpty(stringExtra)) {
            taskZza = Tasks.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            taskZza = zze.zza(context).zza(2, bundle);
        }
        int iOnMessageReceive = onMessageReceive(context, new CloudMessage(intent));
        try {
            Tasks.await(taskZza, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
            sb.append("Message ack failed: ");
            sb.append(strValueOf);
            Log.w("CloudMessagingReceiver", sb.toString());
        }
        return iOnMessageReceive;
    }

    final /* synthetic */ void zza(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        int iZzb;
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                iZzb = zza(context, intent2);
            } else {
                iZzb = zzb(context, intent);
            }
            if (z) {
                pendingResult.setResultCode(iZzb);
            }
        } finally {
            pendingResult.finish();
        }
    }
}
