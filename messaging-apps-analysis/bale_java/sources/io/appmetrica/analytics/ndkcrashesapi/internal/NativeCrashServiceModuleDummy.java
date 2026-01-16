package io.appmetrica.analytics.ndkcrashesapi.internal;

import android.content.Context;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC10360bX0;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0003¨\u0006\u0018"}, d2 = {"Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashServiceModuleDummy;", "Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashServiceModule;", "<init>", "()V", "Landroid/content/Context;", "context", "Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashServiceConfig;", "config", "Lir/nasim/rB7;", "init", "(Landroid/content/Context;Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashServiceConfig;)V", "Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashHandler;", "handler", "setDefaultCrashHandler", "(Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashHandler;)V", "", "Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrash;", "getAllCrashes", "()Ljava/util/List;", "", CommonUrlParts.UUID, "markCrashCompleted", "(Ljava/lang/String;)V", "deleteCompletedCrashes", "ndkcrashes-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class NativeCrashServiceModuleDummy extends NativeCrashServiceModule {
    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule
    public void deleteCompletedCrashes() {
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule
    public List<NativeCrash> getAllCrashes() {
        return AbstractC10360bX0.m();
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule
    public void init(Context context, NativeCrashServiceConfig config) {
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule
    public void markCrashCompleted(String uuid) {
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule
    public void setDefaultCrashHandler(NativeCrashHandler handler) {
    }
}
