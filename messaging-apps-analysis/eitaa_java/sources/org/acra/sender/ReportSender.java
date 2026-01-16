package org.acra.sender;

import android.content.Context;
import org.acra.data.CrashReportData;

/* loaded from: classes.dex */
public interface ReportSender {
    void send(Context context, CrashReportData crashReportData) throws ReportSenderException;
}
