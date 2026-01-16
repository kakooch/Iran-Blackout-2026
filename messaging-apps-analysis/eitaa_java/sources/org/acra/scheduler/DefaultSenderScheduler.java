package org.acra.scheduler;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.sender.SenderService;

/* loaded from: classes.dex */
public class DefaultSenderScheduler implements SenderScheduler {
    private final CoreConfiguration config;
    private final Context context;

    public DefaultSenderScheduler(Context context, CoreConfiguration coreConfiguration) {
        this.context = context;
        this.config = coreConfiguration;
    }

    @Override // org.acra.scheduler.SenderScheduler
    public void scheduleReportSending(boolean z) {
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "About to start SenderService");
        }
        Intent intent = new Intent();
        intent.putExtra("onlySendSilentReports", z);
        intent.putExtra("acraConfig", this.config);
        JobIntentService.enqueueWork(this.context, (Class<?>) SenderService.class, 0, intent);
    }
}
