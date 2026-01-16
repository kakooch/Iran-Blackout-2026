package org.acra.file;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.acra.ACRAConstants;

/* loaded from: classes.dex */
public final class CrashReportFileNameParser {
    public boolean isSilent(String str) {
        return str.contains(ACRAConstants.SILENT_SUFFIX);
    }

    @Deprecated
    public boolean isApproved(String str) {
        return isSilent(str) || str.contains("-approved");
    }

    public Calendar getTimestamp(String str) {
        String strReplace = str.replace(".stacktrace", "").replace(ACRAConstants.SILENT_SUFFIX, "");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ", Locale.ENGLISH).parse(strReplace));
        } catch (ParseException unused) {
        }
        return calendar;
    }
}
