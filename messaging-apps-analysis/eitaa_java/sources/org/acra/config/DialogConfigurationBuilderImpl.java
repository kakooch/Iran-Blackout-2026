package org.acra.config;

import android.R;
import android.content.Context;
import org.acra.annotation.AcraDialog;
import org.acra.dialog.BaseCrashReportDialog;
import org.acra.dialog.CrashReportDialog;

/* loaded from: classes.dex */
final class DialogConfigurationBuilderImpl implements DialogConfigurationBuilder {
    private String commentPrompt;
    private final Context context;
    private String emailPrompt;
    private boolean enabled;
    private String negativeButtonText;
    private String positiveButtonText;
    private Class<? extends BaseCrashReportDialog> reportDialogClass;
    private int resIcon;
    private int resTheme;
    private String text;
    private String title;

    @Override // org.acra.config.DialogConfigurationBuilder
    public /* bridge */ /* synthetic */ DialogConfigurationBuilder setReportDialogClass(Class cls) {
        return setReportDialogClass((Class<? extends BaseCrashReportDialog>) cls);
    }

    DialogConfigurationBuilderImpl(Context context) {
        AcraDialog acraDialog = (AcraDialog) context.getClass().getAnnotation(AcraDialog.class);
        this.context = context;
        boolean z = acraDialog != null;
        this.enabled = z;
        if (z) {
            this.reportDialogClass = acraDialog.reportDialogClass();
            if (acraDialog.resPositiveButtonText() != 0) {
                this.positiveButtonText = context.getString(acraDialog.resPositiveButtonText());
            }
            if (acraDialog.resNegativeButtonText() != 0) {
                this.negativeButtonText = context.getString(acraDialog.resNegativeButtonText());
            }
            if (acraDialog.resCommentPrompt() != 0) {
                this.commentPrompt = context.getString(acraDialog.resCommentPrompt());
            }
            if (acraDialog.resEmailPrompt() != 0) {
                this.emailPrompt = context.getString(acraDialog.resEmailPrompt());
            }
            this.resIcon = acraDialog.resIcon();
            if (acraDialog.resText() != 0) {
                this.text = context.getString(acraDialog.resText());
            }
            if (acraDialog.resTitle() != 0) {
                this.title = context.getString(acraDialog.resTitle());
            }
            this.resTheme = acraDialog.resTheme();
            return;
        }
        this.reportDialogClass = CrashReportDialog.class;
        this.positiveButtonText = context.getString(R.string.ok);
        this.negativeButtonText = context.getString(R.string.cancel);
        this.resIcon = R.drawable.ic_dialog_alert;
        this.resTheme = 0;
    }

    @Override // org.acra.config.DialogConfigurationBuilder
    public DialogConfigurationBuilderImpl setEnabled(boolean z) {
        this.enabled = z;
        return this;
    }

    boolean enabled() {
        return this.enabled;
    }

    @Override // org.acra.config.DialogConfigurationBuilder
    public DialogConfigurationBuilderImpl setReportDialogClass(Class<? extends BaseCrashReportDialog> cls) {
        this.reportDialogClass = cls;
        return this;
    }

    Class<? extends BaseCrashReportDialog> reportDialogClass() {
        return this.reportDialogClass;
    }

    String positiveButtonText() {
        return this.positiveButtonText;
    }

    String negativeButtonText() {
        return this.negativeButtonText;
    }

    String commentPrompt() {
        return this.commentPrompt;
    }

    String emailPrompt() {
        return this.emailPrompt;
    }

    @Override // org.acra.config.DialogConfigurationBuilder
    public DialogConfigurationBuilderImpl setResIcon(int i) {
        this.resIcon = i;
        return this;
    }

    int resIcon() {
        return this.resIcon;
    }

    String text() {
        return this.text;
    }

    String title() {
        return this.title;
    }

    int resTheme() {
        return this.resTheme;
    }

    @Override // org.acra.config.ConfigurationBuilder
    public DialogConfiguration build() throws ACRAConfigurationException, NoSuchMethodException, SecurityException {
        if (this.enabled) {
            ClassValidator.check(this.reportDialogClass);
            if (this.reportDialogClass == CrashReportDialog.class && this.text == null) {
                throw new ACRAConfigurationException("One of reportDialogClass, text must not be default");
            }
        }
        return new DialogConfiguration(this);
    }
}
