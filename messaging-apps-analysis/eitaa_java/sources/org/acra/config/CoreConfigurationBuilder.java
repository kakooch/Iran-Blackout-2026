package org.acra.config;

import android.content.Context;
import java.util.List;
import java.util.Set;
import org.acra.ReportField;
import org.acra.annotation.AcraCore;
import org.acra.attachment.AttachmentUriProvider;
import org.acra.attachment.DefaultAttachmentProvider;
import org.acra.data.StringFormat;
import org.acra.file.Directory;
import org.acra.plugins.PluginLoader;
import org.acra.sender.ReportSenderFactory;

/* loaded from: classes.dex */
public final class CoreConfigurationBuilder implements ConfigurationBuilder {
    private String[] additionalDropBoxTags;
    private String[] additionalSharedPreferences;
    private boolean alsoReportToAndroidFramework;
    private String applicationLogFile;
    private Directory applicationLogFileDir;
    private int applicationLogFileLines;
    private Class<? extends AttachmentUriProvider> attachmentUriProvider;
    private String[] attachmentUris;
    private Class buildConfigClass;
    private final Context context;
    private final BaseCoreConfigurationBuilder delegate;
    private boolean deleteOldUnsentReportsOnApplicationStart;
    private boolean deleteUnapprovedReportsOnApplicationStart;
    private int dropboxCollectionMinutes;
    private boolean enabled;
    private String[] excludeMatchingSettingsKeys;
    private String[] excludeMatchingSharedPreferencesKeys;
    private boolean includeDropBoxSystemTags;
    private String[] logcatArguments;
    private boolean logcatFilterByPid;
    private boolean logcatReadNonBlocking;
    private boolean parallel;
    private ReportField[] reportContent;
    private StringFormat reportFormat;
    private String reportSendFailureToast;
    private String reportSendSuccessToast;

    @Deprecated
    private Class<? extends ReportSenderFactory>[] reportSenderFactoryClasses;
    private Class<? extends RetryPolicy> retryPolicyClass;
    private boolean sendReportsInDevMode;
    private String sharedPreferencesName;
    private boolean stopServicesOnCrash;

    public CoreConfigurationBuilder(Context context) {
        AcraCore acraCore = (AcraCore) context.getClass().getAnnotation(AcraCore.class);
        this.context = context;
        this.enabled = acraCore != null;
        this.delegate = new BaseCoreConfigurationBuilder(context);
        if (this.enabled) {
            this.sharedPreferencesName = acraCore.sharedPreferencesName();
            this.includeDropBoxSystemTags = acraCore.includeDropBoxSystemTags();
            this.additionalDropBoxTags = acraCore.additionalDropBoxTags();
            this.dropboxCollectionMinutes = acraCore.dropboxCollectionMinutes();
            this.logcatArguments = acraCore.logcatArguments();
            this.reportContent = acraCore.reportContent();
            this.deleteUnapprovedReportsOnApplicationStart = acraCore.deleteUnapprovedReportsOnApplicationStart();
            this.deleteOldUnsentReportsOnApplicationStart = acraCore.deleteOldUnsentReportsOnApplicationStart();
            this.alsoReportToAndroidFramework = acraCore.alsoReportToAndroidFramework();
            this.additionalSharedPreferences = acraCore.additionalSharedPreferences();
            this.logcatFilterByPid = acraCore.logcatFilterByPid();
            this.logcatReadNonBlocking = acraCore.logcatReadNonBlocking();
            this.sendReportsInDevMode = acraCore.sendReportsInDevMode();
            this.excludeMatchingSharedPreferencesKeys = acraCore.excludeMatchingSharedPreferencesKeys();
            this.excludeMatchingSettingsKeys = acraCore.excludeMatchingSettingsKeys();
            this.buildConfigClass = acraCore.buildConfigClass();
            this.reportSenderFactoryClasses = acraCore.reportSenderFactoryClasses();
            this.applicationLogFile = acraCore.applicationLogFile();
            this.applicationLogFileLines = acraCore.applicationLogFileLines();
            this.applicationLogFileDir = acraCore.applicationLogFileDir();
            this.retryPolicyClass = acraCore.retryPolicyClass();
            this.stopServicesOnCrash = acraCore.stopServicesOnCrash();
            this.attachmentUris = acraCore.attachmentUris();
            this.attachmentUriProvider = acraCore.attachmentUriProvider();
            if (acraCore.resReportSendSuccessToast() != 0) {
                this.reportSendSuccessToast = context.getString(acraCore.resReportSendSuccessToast());
            }
            if (acraCore.resReportSendFailureToast() != 0) {
                this.reportSendFailureToast = context.getString(acraCore.resReportSendFailureToast());
            }
            this.reportFormat = acraCore.reportFormat();
            this.parallel = acraCore.parallel();
            return;
        }
        this.sharedPreferencesName = "";
        this.includeDropBoxSystemTags = false;
        this.additionalDropBoxTags = new String[0];
        this.dropboxCollectionMinutes = 5;
        this.logcatArguments = new String[]{"-t", "100", "-v", "time"};
        this.reportContent = new ReportField[0];
        this.deleteUnapprovedReportsOnApplicationStart = true;
        this.deleteOldUnsentReportsOnApplicationStart = true;
        this.alsoReportToAndroidFramework = false;
        this.additionalSharedPreferences = new String[0];
        this.logcatFilterByPid = true;
        this.logcatReadNonBlocking = false;
        this.sendReportsInDevMode = true;
        this.excludeMatchingSharedPreferencesKeys = new String[0];
        this.excludeMatchingSettingsKeys = new String[0];
        this.buildConfigClass = Object.class;
        this.reportSenderFactoryClasses = new Class[0];
        this.applicationLogFile = "";
        this.applicationLogFileLines = 100;
        this.applicationLogFileDir = Directory.FILES_LEGACY;
        this.retryPolicyClass = DefaultRetryPolicy.class;
        this.stopServicesOnCrash = false;
        this.attachmentUris = new String[0];
        this.attachmentUriProvider = DefaultAttachmentProvider.class;
        this.reportFormat = StringFormat.JSON;
        this.parallel = true;
    }

    boolean enabled() {
        return this.enabled;
    }

    String sharedPreferencesName() {
        return this.sharedPreferencesName;
    }

    boolean includeDropBoxSystemTags() {
        return this.includeDropBoxSystemTags;
    }

    String[] additionalDropBoxTags() {
        return this.additionalDropBoxTags;
    }

    int dropboxCollectionMinutes() {
        return this.dropboxCollectionMinutes;
    }

    String[] logcatArguments() {
        return this.logcatArguments;
    }

    Set<ReportField> reportContent() {
        return this.delegate.transformReportContent(this.reportContent);
    }

    boolean deleteUnapprovedReportsOnApplicationStart() {
        return this.deleteUnapprovedReportsOnApplicationStart;
    }

    boolean deleteOldUnsentReportsOnApplicationStart() {
        return this.deleteOldUnsentReportsOnApplicationStart;
    }

    boolean alsoReportToAndroidFramework() {
        return this.alsoReportToAndroidFramework;
    }

    String[] additionalSharedPreferences() {
        return this.additionalSharedPreferences;
    }

    boolean logcatFilterByPid() {
        return this.logcatFilterByPid;
    }

    boolean logcatReadNonBlocking() {
        return this.logcatReadNonBlocking;
    }

    boolean sendReportsInDevMode() {
        return this.sendReportsInDevMode;
    }

    String[] excludeMatchingSharedPreferencesKeys() {
        return this.excludeMatchingSharedPreferencesKeys;
    }

    String[] excludeMatchingSettingsKeys() {
        return this.excludeMatchingSettingsKeys;
    }

    public CoreConfigurationBuilder setBuildConfigClass(Class cls) {
        this.buildConfigClass = cls;
        return this;
    }

    Class buildConfigClass() {
        return this.buildConfigClass;
    }

    @Deprecated
    Class<? extends ReportSenderFactory>[] reportSenderFactoryClasses() {
        return this.reportSenderFactoryClasses;
    }

    String applicationLogFile() {
        return this.applicationLogFile;
    }

    int applicationLogFileLines() {
        return this.applicationLogFileLines;
    }

    Directory applicationLogFileDir() {
        return this.applicationLogFileDir;
    }

    Class<? extends RetryPolicy> retryPolicyClass() {
        return this.retryPolicyClass;
    }

    boolean stopServicesOnCrash() {
        return this.stopServicesOnCrash;
    }

    String[] attachmentUris() {
        return this.attachmentUris;
    }

    Class<? extends AttachmentUriProvider> attachmentUriProvider() {
        return this.attachmentUriProvider;
    }

    String reportSendSuccessToast() {
        return this.reportSendSuccessToast;
    }

    String reportSendFailureToast() {
        return this.reportSendFailureToast;
    }

    public CoreConfigurationBuilder setReportFormat(StringFormat stringFormat) {
        this.reportFormat = stringFormat;
        return this;
    }

    StringFormat reportFormat() {
        return this.reportFormat;
    }

    boolean parallel() {
        return this.parallel;
    }

    PluginLoader pluginLoader() {
        return this.delegate.pluginLoader();
    }

    List<Configuration> pluginConfigurations() {
        return this.delegate.pluginConfigurations();
    }

    public <R extends ConfigurationBuilder> R getPluginConfigurationBuilder(Class<R> cls) {
        return (R) this.delegate.getPluginConfigurationBuilder(cls);
    }

    @Override // org.acra.config.ConfigurationBuilder
    public CoreConfiguration build() throws ACRAConfigurationException, NoSuchMethodException, SecurityException {
        if (this.enabled) {
            ClassValidator.check(this.reportSenderFactoryClasses);
            ClassValidator.check(this.retryPolicyClass);
            ClassValidator.check(this.attachmentUriProvider);
        }
        this.delegate.preBuild();
        return new CoreConfiguration(this);
    }
}
