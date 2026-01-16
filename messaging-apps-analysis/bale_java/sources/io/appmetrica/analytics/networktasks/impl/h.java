package io.appmetrica.analytics.networktasks.impl;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.network.internal.NetworkClient;
import io.appmetrica.analytics.network.internal.Request;
import io.appmetrica.analytics.network.internal.Response;
import io.appmetrica.analytics.networktasks.internal.ExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20762sZ6;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class h implements Runnable {
    public final NetworkTask a;
    public final InterruptionSafeThread b;
    public final f c;

    public h(NetworkTask networkTask, InterruptionSafeThread interruptionSafeThread, f fVar) {
        this.a = networkTask;
        this.b = interruptionSafeThread;
        this.c = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zOnRequestComplete;
        byte[] postData;
        ExponentialBackoffPolicy exponentialBackoffPolicy = this.a.getExponentialBackoffPolicy();
        IExecutionPolicy connectionExecutionPolicy = this.a.getConnectionExecutionPolicy();
        if (!this.b.isRunning() || !connectionExecutionPolicy.canBeExecuted() || !exponentialBackoffPolicy.canBeExecuted(this.a.getRetryPolicyConfig())) {
            this.a.onShouldNotExecute();
            return;
        }
        boolean zOnCreateNetworkTask = this.a.onCreateNetworkTask();
        Boolean boolValueOf = null;
        while (this.b.isRunning() && zOnCreateNetworkTask && exponentialBackoffPolicy.canBeExecuted(this.a.getRetryPolicyConfig())) {
            f fVar = this.c;
            NetworkTask networkTask = this.a;
            fVar.getClass();
            boolean z = false;
            if (networkTask.onPerformRequest()) {
                String url = networkTask.getUrl();
                if (url == null || TextUtils.isEmpty(AbstractC20762sZ6.n1(url).toString())) {
                    StringBuilder sb = new StringBuilder("Task ");
                    sb.append(networkTask.description());
                    sb.append(" url is `");
                    sb.append(url);
                    sb.append("`. All hosts = ");
                    List<String> allHosts = networkTask.getUnderlyingTask().getFullUrlFormer().getAllHosts();
                    sb.append(allHosts != null ? allHosts.toString() : null);
                    networkTask.onRequestError(new IllegalArgumentException(sb.toString()));
                } else {
                    Request.Builder builderAddHeader = new Request.Builder(url).addHeader(SIPHeaderNames.ACCEPT, "application/json").addHeader(SIPHeaderNames.USER_AGENT, networkTask.getUserAgent());
                    RequestDataHolder requestDataHolder = networkTask.getRequestDataHolder();
                    Iterator<T> it = requestDataHolder.getHeaders().entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        builderAddHeader.addHeader((String) entry.getKey(), AbstractC15401jX0.A0((Iterable) entry.getValue(), ",", null, null, 0, null, null, 62, null));
                    }
                    if (NetworkTask.Method.POST == requestDataHolder.getMethod() && (postData = requestDataHolder.getPostData()) != null) {
                        if (!(postData.length == 0)) {
                            builderAddHeader.post(postData);
                            Long sendTimestamp = requestDataHolder.getSendTimestamp();
                            if (sendTimestamp != null) {
                                builderAddHeader.addHeader("Send-Timestamp", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(sendTimestamp.longValue())));
                            }
                            Integer sendTimezoneSec = requestDataHolder.getSendTimezoneSec();
                            if (sendTimezoneSec != null) {
                                builderAddHeader.addHeader("Send-Timezone", String.valueOf(sendTimezoneSec.intValue()));
                            }
                        }
                    }
                    NetworkClient.Builder builder = new NetworkClient.Builder();
                    int i = b.a;
                    Response responseExecute = builder.withConnectTimeout(i).withReadTimeout(i).withSslSocketFactory(networkTask.getSslSocketFactory()).build().newCall(builderAddHeader.build()).execute();
                    int code = responseExecute.getCode();
                    ResponseDataHolder responseDataHolder = networkTask.getResponseDataHolder();
                    responseDataHolder.setResponseCode(code);
                    responseDataHolder.setResponseHeaders(CollectionUtils.convertMapKeysToLowerCase(responseExecute.getHeaders()));
                    if (responseDataHolder.isValidResponse()) {
                        responseDataHolder.setResponseData(responseExecute.getResponseData());
                    }
                    if (responseExecute.isCompleted()) {
                        zOnRequestComplete = networkTask.onRequestComplete();
                        boolValueOf = Boolean.valueOf(zOnRequestComplete);
                        if (zOnRequestComplete && this.a.shouldTryNextHost()) {
                            z = true;
                        }
                        exponentialBackoffPolicy.onHostAttemptFinished(zOnRequestComplete);
                        zOnCreateNetworkTask = z;
                    } else {
                        networkTask.onRequestError(responseExecute.getException());
                    }
                }
            } else {
                networkTask.onRequestError(null);
            }
            zOnRequestComplete = false;
            boolValueOf = Boolean.valueOf(zOnRequestComplete);
            if (zOnRequestComplete) {
            }
            exponentialBackoffPolicy.onHostAttemptFinished(zOnRequestComplete);
            zOnCreateNetworkTask = z;
        }
        if (boolValueOf != null) {
            exponentialBackoffPolicy.onAllHostsAttemptsFinished(boolValueOf.booleanValue());
        }
    }
}
