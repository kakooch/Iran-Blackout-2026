package org.acra.builder;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ReportBuilder {
    private Throwable exception;
    private String message;
    private Thread uncaughtExceptionThread;
    private final Map<String, String> customData = new HashMap();
    private boolean sendSilently = false;
    private boolean endApplication = false;

    public String getMessage() {
        return this.message;
    }

    public ReportBuilder uncaughtExceptionThread(Thread thread) {
        this.uncaughtExceptionThread = thread;
        return this;
    }

    public Thread getUncaughtExceptionThread() {
        return this.uncaughtExceptionThread;
    }

    public ReportBuilder exception(Throwable th) {
        this.exception = th;
        return this;
    }

    public Throwable getException() {
        return this.exception;
    }

    public ReportBuilder customData(Map<String, String> map) {
        this.customData.putAll(map);
        return this;
    }

    public Map<String, String> getCustomData() {
        return new HashMap(this.customData);
    }

    public boolean isSendSilently() {
        return this.sendSilently;
    }

    public ReportBuilder endApplication() {
        this.endApplication = true;
        return this;
    }

    public boolean isEndApplication() {
        return this.endApplication;
    }

    public void build(ReportExecutor reportExecutor) {
        if (this.message == null && this.exception == null) {
            this.message = "Report requested by developer";
        }
        reportExecutor.execute(this);
    }
}
