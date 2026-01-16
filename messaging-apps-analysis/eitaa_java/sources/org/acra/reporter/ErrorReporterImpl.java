package org.acra.reporter;

import android.app.Application;
import android.content.SharedPreferences;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRA;
import org.acra.ErrorReporter;
import org.acra.builder.LastActivityManager;
import org.acra.builder.ReportBuilder;
import org.acra.builder.ReportExecutor;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportDataFactory;
import org.acra.log.ACRALog;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.scheduler.SchedulerStarter;
import org.acra.util.ApplicationStartupProcessor;
import org.acra.util.InstanceCreator;
import org.acra.util.ProcessFinisher;

/* loaded from: classes.dex */
public class ErrorReporterImpl implements Thread.UncaughtExceptionHandler, SharedPreferences.OnSharedPreferenceChangeListener, ErrorReporter {
    private final Application context;
    private final Map<String, String> customData = new HashMap();
    private final Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private final ReportExecutor reportExecutor;
    private final SchedulerStarter schedulerStarter;
    private final boolean supportedAndroidVersion;

    public ErrorReporterImpl(Application application, CoreConfiguration coreConfiguration, boolean z, boolean z2, boolean z3) {
        this.context = application;
        this.supportedAndroidVersion = z2;
        CrashReportDataFactory crashReportDataFactory = new CrashReportDataFactory(application, coreConfiguration);
        crashReportDataFactory.collectStartUp();
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.defaultExceptionHandler = defaultUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
        LastActivityManager lastActivityManager = new LastActivityManager(application);
        new InstanceCreator();
        ProcessFinisher processFinisher = new ProcessFinisher(application, coreConfiguration, lastActivityManager);
        SchedulerStarter schedulerStarter = new SchedulerStarter(application, coreConfiguration);
        this.schedulerStarter = schedulerStarter;
        ReportExecutor reportExecutor = new ReportExecutor(application, coreConfiguration, crashReportDataFactory, defaultUncaughtExceptionHandler, processFinisher, schedulerStarter, lastActivityManager);
        this.reportExecutor = reportExecutor;
        reportExecutor.setEnabled(z);
        if (z3) {
            new ApplicationStartupProcessor(application, coreConfiguration, schedulerStarter).checkReports(z);
        }
    }

    @Override // org.acra.ErrorReporter
    public String putCustomData(String str, String str2) {
        return this.customData.put(str, str2);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!this.reportExecutor.isEnabled()) {
            this.reportExecutor.handReportToDefaultExceptionHandler(thread, th);
            return;
        }
        try {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.e(str, "ACRA caught a " + th.getClass().getSimpleName() + " for " + this.context.getPackageName(), th);
            if (ACRA.DEV_LOGGING) {
                ACRA.log.d(str, "Building report");
            }
            new ReportBuilder().uncaughtExceptionThread(thread).exception(th).customData(this.customData).endApplication().build(this.reportExecutor);
        } catch (Exception e) {
            ACRA.log.e(ACRA.LOG_TAG, "ACRA failed to capture the error - handing off to native error reporter", e);
            this.reportExecutor.handReportToDefaultExceptionHandler(thread, th);
        }
    }

    public void setEnabled(boolean z) {
        if (this.supportedAndroidVersion) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("ACRA is ");
            sb.append(z ? "enabled" : "disabled");
            sb.append(" for ");
            sb.append(this.context.getPackageName());
            aCRALog.i(str, sb.toString());
            this.reportExecutor.setEnabled(z);
            return;
        }
        ACRA.log.w(ACRA.LOG_TAG, "ACRA requires ICS or greater. ACRA is disabled and will NOT catch crashes or send messages.");
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (ACRA.PREF_DISABLE_ACRA.equals(str) || ACRA.PREF_ENABLE_ACRA.equals(str)) {
            setEnabled(SharedPreferencesFactory.shouldEnableACRA(sharedPreferences));
        }
    }

    public void unregister() {
        Thread.setDefaultUncaughtExceptionHandler(this.defaultExceptionHandler);
    }
}
