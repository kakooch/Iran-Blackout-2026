package io.appmetrica.analytics.billingv6.internal;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import io.appmetrica.analytics.billinginterface.internal.update.UpdatePolicy;
import io.appmetrica.analytics.billingv6.impl.e;
import io.appmetrica.analytics.billingv6.impl.u;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/appmetrica/analytics/billingv6/internal/BillingLibraryMonitor;", "Lio/appmetrica/analytics/billinginterface/internal/monitor/BillingMonitor;", "Landroid/content/Context;", "context", "Ljava/util/concurrent/Executor;", "workerExecutor", "uiExecutor", "Lio/appmetrica/analytics/billinginterface/internal/storage/BillingInfoStorage;", "billingInfoStorage", "Lio/appmetrica/analytics/billinginterface/internal/storage/BillingInfoSender;", "billingInfoSender", "Lio/appmetrica/analytics/billinginterface/internal/storage/BillingInfoManager;", "billingInfoManager", "Lio/appmetrica/analytics/billinginterface/internal/update/UpdatePolicy;", "updatePolicy", "<init>", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lio/appmetrica/analytics/billinginterface/internal/storage/BillingInfoStorage;Lio/appmetrica/analytics/billinginterface/internal/storage/BillingInfoSender;Lio/appmetrica/analytics/billinginterface/internal/storage/BillingInfoManager;Lio/appmetrica/analytics/billinginterface/internal/update/UpdatePolicy;)V", "Lir/nasim/rB7;", "onSessionResumed", "()V", "Lio/appmetrica/analytics/billinginterface/internal/config/BillingConfig;", "billingConfig", "onBillingConfigChanged", "(Lio/appmetrica/analytics/billinginterface/internal/config/BillingConfig;)V", "billing-v6_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class BillingLibraryMonitor implements BillingMonitor {
    private final Context a;
    private final Executor b;
    private final Executor c;
    private final BillingInfoSender d;
    private final BillingInfoManager e;
    private final UpdatePolicy f;
    private BillingConfig g;

    public BillingLibraryMonitor(Context context, Executor executor, Executor executor2, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender, BillingInfoManager billingInfoManager, UpdatePolicy updatePolicy) {
        this.a = context;
        this.b = executor;
        this.c = executor2;
        this.d = billingInfoSender;
        this.e = billingInfoManager;
        this.f = updatePolicy;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.config.BillingConfigChangedListener
    public synchronized void onBillingConfigChanged(BillingConfig billingConfig) {
        if (AbstractC13042fc3.d(this.g, billingConfig)) {
            return;
        }
        this.g = billingConfig;
        if (billingConfig != null) {
            this.c.execute(new BillingLibraryMonitor$updateBilling$1(this, billingConfig));
        }
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor
    public void onSessionResumed() {
        BillingConfig billingConfig = this.g;
        if (billingConfig == null) {
            return;
        }
        this.c.execute(new BillingLibraryMonitor$updateBilling$1(this, billingConfig));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ BillingLibraryMonitor(Context context, Executor executor, Executor executor2, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender, BillingInfoManager billingInfoManager, UpdatePolicy updatePolicy, int i, ED1 ed1) {
        UpdatePolicy uVar;
        BillingInfoManager eVar = (i & 32) != 0 ? new e(billingInfoStorage) : billingInfoManager;
        if ((i & 64) != 0) {
            uVar = new u(null, 1, 0 == true ? 1 : 0);
        } else {
            uVar = updatePolicy;
        }
        this(context, executor, executor2, billingInfoStorage, billingInfoSender, eVar, uVar);
    }
}
