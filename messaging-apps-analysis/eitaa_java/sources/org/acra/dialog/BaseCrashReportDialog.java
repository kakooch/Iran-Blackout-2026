package org.acra.dialog;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.file.BulkReportDeleter;
import org.acra.file.CrashReportPersister;
import org.acra.interaction.DialogInteraction;
import org.acra.scheduler.SchedulerStarter;
import org.json.JSONException;

/* loaded from: classes.dex */
public abstract class BaseCrashReportDialog extends FragmentActivity {
    private CoreConfiguration config;
    private File reportFile;

    protected void init(Bundle bundle) {
    }

    protected void preInit(Bundle bundle) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        preInit(bundle);
        super.onCreate(bundle);
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "CrashReportDialog extras=" + getIntent().getExtras());
        }
        Serializable serializableExtra = getIntent().getSerializableExtra(DialogInteraction.EXTRA_REPORT_CONFIG);
        Serializable serializableExtra2 = getIntent().getSerializableExtra(DialogInteraction.EXTRA_REPORT_FILE);
        if ((serializableExtra instanceof CoreConfiguration) && (serializableExtra2 instanceof File)) {
            this.config = (CoreConfiguration) serializableExtra;
            this.reportFile = (File) serializableExtra2;
            init(bundle);
        } else {
            ACRA.log.w(ACRA.LOG_TAG, "Illegal or incomplete call of BaseCrashReportDialog.");
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cancelReports$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cancelReports$0$BaseCrashReportDialog() {
        new BulkReportDeleter(this).deleteReports(false, 0);
    }

    protected final void cancelReports() {
        new Thread(new Runnable() { // from class: org.acra.dialog.-$$Lambda$BaseCrashReportDialog$eecg0rtBkogjRHDtixsoFCC0aBc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelReports$0$BaseCrashReportDialog();
            }
        }).start();
    }

    protected final void sendCrash(final String str, final String str2) {
        new Thread(new Runnable() { // from class: org.acra.dialog.-$$Lambda$BaseCrashReportDialog$-WHfXsa3GESaM7ezjVhHln2qBkc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendCrash$1$BaseCrashReportDialog(str, str2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendCrash$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendCrash$1$BaseCrashReportDialog(String str, String str2) {
        CrashReportPersister crashReportPersister = new CrashReportPersister();
        try {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.d(ACRA.LOG_TAG, "Add user comment to " + this.reportFile);
            }
            CrashReportData crashReportDataLoad = crashReportPersister.load(this.reportFile);
            ReportField reportField = ReportField.USER_COMMENT;
            if (str == null) {
                str = "";
            }
            crashReportDataLoad.put(reportField, str);
            ReportField reportField2 = ReportField.USER_EMAIL;
            if (str2 == null) {
                str2 = "";
            }
            crashReportDataLoad.put(reportField2, str2);
            crashReportPersister.store(crashReportDataLoad, this.reportFile);
        } catch (IOException | JSONException e) {
            ACRA.log.w(ACRA.LOG_TAG, "User comment not added: ", e);
        }
        new SchedulerStarter(this, this.config).scheduleReports(this.reportFile, false);
    }

    protected final CoreConfiguration getConfig() {
        return this.config;
    }
}
