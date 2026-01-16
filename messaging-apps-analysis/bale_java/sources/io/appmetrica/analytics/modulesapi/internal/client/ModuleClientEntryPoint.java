package io.appmetrica.analytics.modulesapi.internal.client;

import android.gov.nist.javax.sip.parser.TokenNames;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/client/ModuleClientEntryPoint;", "", TokenNames.T, "Lio/appmetrica/analytics/modulesapi/internal/client/ClientContext;", "clientContext", "Lir/nasim/rB7;", "initClientSide", "(Lio/appmetrica/analytics/modulesapi/internal/client/ClientContext;)V", "onActivated", "()V", "", "getIdentifier", "()Ljava/lang/String;", "identifier", "modules-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public interface ModuleClientEntryPoint<T> {
    String getIdentifier();

    void initClientSide(ClientContext clientContext);

    void onActivated();
}
