package org.acra.interaction;

import android.content.Context;
import android.content.Intent;
import java.io.File;
import org.acra.ACRA;
import org.acra.config.ConfigUtils;
import org.acra.config.CoreConfiguration;
import org.acra.config.DialogConfiguration;
import org.acra.plugins.HasConfigPlugin;
import org.acra.prefs.SharedPreferencesFactory;

/* loaded from: classes.dex */
public class DialogInteraction extends HasConfigPlugin implements ReportInteraction {
    public static final String EXTRA_REPORT_CONFIG = "REPORT_CONFIG";
    public static final String EXTRA_REPORT_FILE = "REPORT_FILE";

    public DialogInteraction() {
        super(DialogConfiguration.class);
    }

    @Override // org.acra.interaction.ReportInteraction
    public boolean performInteraction(Context context, CoreConfiguration coreConfiguration, File file) {
        if (new SharedPreferencesFactory(context, coreConfiguration).create().getBoolean(ACRA.PREF_ALWAYS_ACCEPT, false)) {
            return true;
        }
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "Creating CrashReportDialog for " + file);
        }
        Intent intentCreateCrashReportDialogIntent = createCrashReportDialogIntent(context, coreConfiguration, file);
        intentCreateCrashReportDialogIntent.setFlags(268435456);
        context.startActivity(intentCreateCrashReportDialogIntent);
        return false;
    }

    private Intent createCrashReportDialogIntent(Context context, CoreConfiguration coreConfiguration, File file) {
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "Creating DialogIntent for " + file);
        }
        Intent intent = new Intent(context, ((DialogConfiguration) ConfigUtils.getPluginConfiguration(coreConfiguration, DialogConfiguration.class)).reportDialogClass());
        intent.putExtra(EXTRA_REPORT_FILE, file);
        intent.putExtra(EXTRA_REPORT_CONFIG, coreConfiguration);
        return intent;
    }
}
