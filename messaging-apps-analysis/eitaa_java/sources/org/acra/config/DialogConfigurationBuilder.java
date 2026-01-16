package org.acra.config;

import org.acra.dialog.BaseCrashReportDialog;

/* loaded from: classes.dex */
public interface DialogConfigurationBuilder extends ConfigurationBuilder {
    DialogConfigurationBuilder setEnabled(boolean z);

    DialogConfigurationBuilder setReportDialogClass(Class<? extends BaseCrashReportDialog> cls);

    DialogConfigurationBuilder setResIcon(int i);
}
