package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
final class zabr<T> implements OnCompleteListener<T> {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey<?> zac;
    private final long zad;

    private zabr(GoogleApiManager googleApiManager, int i, ApiKey<?> apiKey, long j) {
        this.zaa = googleApiManager;
        this.zab = i;
        this.zac = apiKey;
        this.zad = j;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<T> task) {
        int batchPeriodMillis;
        int i;
        int i2;
        int i3;
        int errorCode;
        long j;
        long jCurrentTimeMillis;
        if (this.zaa.zad()) {
            boolean methodTimingTelemetryEnabled = this.zad > 0;
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if (config == null) {
                batchPeriodMillis = 5000;
                i = 0;
                i2 = 100;
            } else {
                if (!config.getMethodInvocationTelemetryEnabled()) {
                    return;
                }
                methodTimingTelemetryEnabled &= config.getMethodTimingTelemetryEnabled();
                batchPeriodMillis = config.getBatchPeriodMillis();
                int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                int version = config.getVersion();
                GoogleApiManager.zaa zaaVarZaa = this.zaa.zaa(this.zac);
                if (zaaVarZaa != null && zaaVarZaa.zab().isConnected() && (zaaVarZaa.zab() instanceof BaseGmsClient)) {
                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationZaa = zaa(zaaVarZaa, this.zab);
                    if (connectionTelemetryConfigurationZaa == null) {
                        return;
                    }
                    boolean z = connectionTelemetryConfigurationZaa.getMethodTimingTelemetryEnabled() && this.zad > 0;
                    maxMethodInvocationsInBatch = connectionTelemetryConfigurationZaa.getMaxMethodInvocationsLogged();
                    methodTimingTelemetryEnabled = z;
                }
                i = version;
                i2 = maxMethodInvocationsInBatch;
            }
            GoogleApiManager googleApiManager = this.zaa;
            if (task.isSuccessful()) {
                i3 = 0;
                errorCode = 0;
            } else {
                if (task.isCanceled()) {
                    i3 = 100;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        Status status = ((ApiException) exception).getStatus();
                        int statusCode = status.getStatusCode();
                        ConnectionResult connectionResult = status.getConnectionResult();
                        errorCode = connectionResult == null ? -1 : connectionResult.getErrorCode();
                        i3 = statusCode;
                    } else {
                        i3 = 101;
                    }
                }
                errorCode = -1;
            }
            if (methodTimingTelemetryEnabled) {
                j = this.zad;
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                j = 0;
                jCurrentTimeMillis = 0;
            }
            googleApiManager.zaa(new com.google.android.gms.common.internal.zao(this.zab, i3, errorCode, j, jCurrentTimeMillis), i, batchPeriodMillis, i2);
        }
    }

    private static ConnectionTelemetryConfiguration zaa(GoogleApiManager.zaa<?> zaaVar, int i) {
        int[] methodInvocationMethodKeyAllowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = ((BaseGmsClient) zaaVar.zab()).getTelemetryConfiguration();
        if (telemetryConfiguration != null) {
            boolean z = false;
            if (telemetryConfiguration.getMethodInvocationTelemetryEnabled() && ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) == null || ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i))) {
                z = true;
            }
            if (z && zaaVar.zam() < telemetryConfiguration.getMaxMethodInvocationsLogged()) {
                return telemetryConfiguration;
            }
        }
        return null;
    }

    static <T> zabr<T> zaa(GoogleApiManager googleApiManager, int i, ApiKey<?> apiKey) {
        if (!googleApiManager.zad()) {
            return null;
        }
        boolean methodTimingTelemetryEnabled = true;
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null) {
            if (!config.getMethodInvocationTelemetryEnabled()) {
                return null;
            }
            methodTimingTelemetryEnabled = config.getMethodTimingTelemetryEnabled();
            GoogleApiManager.zaa zaaVarZaa = googleApiManager.zaa(apiKey);
            if (zaaVarZaa != null && zaaVarZaa.zab().isConnected() && (zaaVarZaa.zab() instanceof BaseGmsClient)) {
                ConnectionTelemetryConfiguration connectionTelemetryConfigurationZaa = zaa(zaaVarZaa, i);
                if (connectionTelemetryConfigurationZaa == null) {
                    return null;
                }
                zaaVarZaa.zan();
                methodTimingTelemetryEnabled = connectionTelemetryConfigurationZaa.getMethodTimingTelemetryEnabled();
            }
        }
        return new zabr<>(googleApiManager, i, apiKey, methodTimingTelemetryEnabled ? System.currentTimeMillis() : 0L);
    }
}
