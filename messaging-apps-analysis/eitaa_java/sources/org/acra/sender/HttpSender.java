package org.acra.sender;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.attachment.AttachmentUriProvider;
import org.acra.attachment.DefaultAttachmentProvider;
import org.acra.config.ConfigUtils;
import org.acra.config.CoreConfiguration;
import org.acra.config.HttpSenderConfiguration;
import org.acra.data.CrashReportData;
import org.acra.data.StringFormat;
import org.acra.http.BinaryHttpRequest;
import org.acra.http.DefaultHttpRequest;
import org.acra.http.MultipartHttpRequest;
import org.acra.util.InstanceCreator;
import org.acra.util.UriUtils;

/* loaded from: classes.dex */
public class HttpSender implements ReportSender {
    private final CoreConfiguration config;
    private final HttpSenderConfiguration httpConfig;
    private final Uri mFormUri;
    private final Method mMethod;
    private String mPassword;
    private final StringFormat mType;
    private String mUsername;

    public HttpSender(CoreConfiguration coreConfiguration, Method method, StringFormat stringFormat) {
        this(coreConfiguration, method, stringFormat, null);
    }

    public HttpSender(CoreConfiguration coreConfiguration, Method method, StringFormat stringFormat, String str) {
        this.config = coreConfiguration;
        HttpSenderConfiguration httpSenderConfiguration = (HttpSenderConfiguration) ConfigUtils.getPluginConfiguration(coreConfiguration, HttpSenderConfiguration.class);
        this.httpConfig = httpSenderConfiguration;
        this.mMethod = method == null ? httpSenderConfiguration.httpMethod() : method;
        this.mFormUri = Uri.parse(str == null ? httpSenderConfiguration.uri() : str);
        this.mType = stringFormat == null ? coreConfiguration.reportFormat() : stringFormat;
        this.mUsername = null;
        this.mPassword = null;
    }

    @Override // org.acra.sender.ReportSender
    public void send(Context context, CrashReportData crashReportData) throws ReportSenderException {
        String str;
        String str2;
        try {
            String string = this.mFormUri.toString();
            if (ACRA.DEV_LOGGING) {
                ACRA.log.d(ACRA.LOG_TAG, "Connect to " + string);
            }
            String strBasicAuthLogin = this.mUsername;
            if (strBasicAuthLogin != null) {
                str = strBasicAuthLogin;
            } else if (isNull(this.httpConfig.basicAuthLogin())) {
                str = null;
            } else {
                strBasicAuthLogin = this.httpConfig.basicAuthLogin();
                str = strBasicAuthLogin;
            }
            String strBasicAuthPassword = this.mPassword;
            if (strBasicAuthPassword != null) {
                str2 = strBasicAuthPassword;
            } else if (isNull(this.httpConfig.basicAuthPassword())) {
                str2 = null;
            } else {
                strBasicAuthPassword = this.httpConfig.basicAuthPassword();
                str2 = strBasicAuthPassword;
            }
            sendHttpRequests(this.config, context, this.mMethod, this.mType.getMatchingHttpContentType(), str, str2, this.httpConfig.connectionTimeout(), this.httpConfig.socketTimeout(), this.httpConfig.httpHeaders(), convertToString(crashReportData, this.mType), this.mMethod.createURL(string, crashReportData), ((AttachmentUriProvider) new InstanceCreator().create(this.config.attachmentUriProvider(), new InstanceCreator.Fallback() { // from class: org.acra.sender.-$$Lambda$_PXyfyQX9WnAueu9dAZOzoYxX4Y
                @Override // org.acra.util.InstanceCreator.Fallback
                public final Object get() {
                    return new DefaultAttachmentProvider();
                }
            })).getAttachments(context, this.config));
        } catch (Exception e) {
            throw new ReportSenderException("Error while sending " + this.config.reportFormat() + " report via Http " + this.mMethod.name(), e);
        }
    }

    /* renamed from: org.acra.sender.HttpSender$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$acra$sender$HttpSender$Method;

        static {
            int[] iArr = new int[Method.values().length];
            $SwitchMap$org$acra$sender$HttpSender$Method = iArr;
            try {
                iArr[Method.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$acra$sender$HttpSender$Method[Method.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected void sendHttpRequests(CoreConfiguration coreConfiguration, Context context, Method method, String str, String str2, String str3, int i, int i2, Map<String, String> map, String str4, URL url, List<Uri> list) throws IOException {
        int i3 = AnonymousClass1.$SwitchMap$org$acra$sender$HttpSender$Method[method.ordinal()];
        if (i3 == 1) {
            if (list.isEmpty()) {
                sendWithoutAttachments(coreConfiguration, context, method, str, str2, str3, i, i2, map, str4, url);
                return;
            } else {
                postMultipart(coreConfiguration, context, str, str2, str3, i, i2, map, str4, url, list);
                return;
            }
        }
        if (i3 != 2) {
            return;
        }
        sendWithoutAttachments(coreConfiguration, context, method, str, str2, str3, i, i2, map, str4, url);
        Iterator<Uri> it = list.iterator();
        while (it.hasNext()) {
            putAttachment(coreConfiguration, context, str2, str3, i, i2, map, url, it.next());
        }
    }

    protected void sendWithoutAttachments(CoreConfiguration coreConfiguration, Context context, Method method, String str, String str2, String str3, int i, int i2, Map<String, String> map, String str4, URL url) throws IOException {
        new DefaultHttpRequest(coreConfiguration, context, method, str, str2, str3, i, i2, map).send(url, str4);
    }

    protected void postMultipart(CoreConfiguration coreConfiguration, Context context, String str, String str2, String str3, int i, int i2, Map<String, String> map, String str4, URL url, List<Uri> list) throws IOException {
        new MultipartHttpRequest(coreConfiguration, context, str, str2, str3, i, i2, map).send(url, Pair.create(str4, list));
    }

    protected void putAttachment(CoreConfiguration coreConfiguration, Context context, String str, String str2, int i, int i2, Map<String, String> map, URL url, Uri uri) throws IOException {
        try {
            new BinaryHttpRequest(coreConfiguration, context, str, str2, i, i2, map).send(new URL(url.toString() + "-" + UriUtils.getFileNameFromUri(context, uri)), uri);
        } catch (FileNotFoundException e) {
            ACRA.log.w("Not sending attachment", e);
        }
    }

    protected String convertToString(CrashReportData crashReportData, StringFormat stringFormat) throws Exception {
        return stringFormat.toFormattedString(crashReportData, this.config.reportContent(), "&", "\n", true);
    }

    private boolean isNull(String str) {
        return str == null || "ACRA-NULL-STRING".equals(str);
    }

    public enum Method {
        POST { // from class: org.acra.sender.HttpSender.Method.1
            @Override // org.acra.sender.HttpSender.Method
            URL createURL(String str, CrashReportData crashReportData) throws MalformedURLException {
                return new URL(str);
            }
        },
        PUT { // from class: org.acra.sender.HttpSender.Method.2
            @Override // org.acra.sender.HttpSender.Method
            URL createURL(String str, CrashReportData crashReportData) throws MalformedURLException {
                return new URL(str + '/' + crashReportData.getString(ReportField.REPORT_ID));
            }
        };

        abstract URL createURL(String str, CrashReportData crashReportData) throws MalformedURLException;

        /* synthetic */ Method(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
