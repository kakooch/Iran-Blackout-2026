package org.acra.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Handler;
import java.io.File;
import java.util.Calendar;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.file.BulkReportDeleter;
import org.acra.file.CrashReportFileNameParser;
import org.acra.file.ReportLocator;
import org.acra.interaction.ReportInteractionExecutor;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.scheduler.SchedulerStarter;

/* loaded from: classes.dex */
public final class ApplicationStartupProcessor {
    private final CoreConfiguration config;
    private final Context context;
    private final BulkReportDeleter reportDeleter;
    private final ReportLocator reportLocator;
    private final SchedulerStarter schedulerStarter;

    public ApplicationStartupProcessor(Context context, CoreConfiguration coreConfiguration, SchedulerStarter schedulerStarter) {
        this.context = context;
        this.config = coreConfiguration;
        this.reportDeleter = new BulkReportDeleter(context);
        this.reportLocator = new ReportLocator(context);
        this.schedulerStarter = schedulerStarter;
    }

    public void checkReports(final boolean z) {
        final Calendar calendar = Calendar.getInstance();
        new Handler(this.context.getMainLooper()).post(new Runnable() { // from class: org.acra.util.-$$Lambda$ApplicationStartupProcessor$gsGQ_bWQOlGxVnUwSwoPmRBZaeg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkReports$1$ApplicationStartupProcessor(z, calendar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkReports$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkReports$1$ApplicationStartupProcessor(final boolean z, final Calendar calendar) {
        new Thread(new Runnable() { // from class: org.acra.util.-$$Lambda$ApplicationStartupProcessor$T_nuF9syxSuZv5EkksUS_Q3Ds4k
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$null$0$ApplicationStartupProcessor(z, calendar);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$null$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$null$0$ApplicationStartupProcessor(boolean z, Calendar calendar) {
        if (this.config.deleteOldUnsentReportsOnApplicationStart()) {
            deleteUnsentReportsFromOldAppVersion();
        }
        if (this.config.deleteUnapprovedReportsOnApplicationStart()) {
            this.reportDeleter.deleteReports(false, 1);
        }
        if (z) {
            sendApprovedReports();
            approveOneReport(calendar);
        }
    }

    private void approveOneReport(Calendar calendar) {
        File[] unapprovedReports = this.reportLocator.getUnapprovedReports();
        if (unapprovedReports.length != 0 && new CrashReportFileNameParser().getTimestamp(unapprovedReports[0].getName()).before(calendar)) {
            new ReportInteractionExecutor(this.context, this.config).performInteractions(unapprovedReports[0]);
        }
    }

    private void deleteUnsentReportsFromOldAppVersion() {
        SharedPreferences sharedPreferencesCreate = new SharedPreferencesFactory(this.context, this.config).create();
        long j = sharedPreferencesCreate.getInt(ACRA.PREF_LAST_VERSION_NR, 0);
        int appVersion = getAppVersion();
        if (appVersion > j) {
            this.reportDeleter.deleteReports(true, 0);
            this.reportDeleter.deleteReports(false, 0);
            sharedPreferencesCreate.edit().putInt(ACRA.PREF_LAST_VERSION_NR, appVersion).apply();
        }
    }

    private void sendApprovedReports() {
        if (this.reportLocator.getApprovedReports().length == 0) {
            return;
        }
        this.schedulerStarter.scheduleReports(null, false);
    }

    private int getAppVersion() {
        PackageInfo packageInfo = new PackageManagerWrapper(this.context).getPackageInfo();
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }
}
