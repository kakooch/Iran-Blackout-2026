package org.linphone.core.tools.compatibility;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.text.format.DateFormat;
import j$.C$r8$wrapper$java$util$stream$Stream$VWRP;
import j$.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class DeviceUtils30 {
    public static void logPreviousCrashesIfAny(Context context) throws IOException {
        for (ApplicationExitInfo applicationExitInfo : ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 5)) {
            Log.i("==== Previous exit reason information dump ====");
            Log.i("REASON=", getReasonAsString(applicationExitInfo.getReason()));
            Log.i("TIMESTAMP=", getHumanReadableDateAndTimeFromTimestamp(applicationExitInfo.getTimestamp()));
            Log.i("DESCRIPTION=", applicationExitInfo.getDescription());
            if (applicationExitInfo.getReason() == 6) {
                try {
                    InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
                    if (traceInputStream != null) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(traceInputStream));
                        Log.w("TRACE=", (String) C$r8$wrapper$java$util$stream$Stream$VWRP.convert(bufferedReader.lines()).collect(Collectors.joining("\n")));
                        bufferedReader.close();
                    } else {
                        Log.w("[Device Utils 30] No input stream for exit info");
                    }
                } catch (IOException e) {
                    Log.e("[Device Utils 30] IO Exception while trying to get trace input stream: ", e);
                } catch (IllegalStateException e2) {
                    Log.e("[Device Utils 30] Illegal State Exception while trying to get trace input stream: ", e2);
                } catch (Exception e3) {
                    Log.e("[Device Utils 30] Exception while trying to get trace input stream: ", e3);
                }
            }
            Log.i("=========================================");
        }
    }

    public static String getReasonAsString(int i) {
        if (i == 0) {
            return "Unknown";
        }
        if (i == 10) {
            return "User requested";
        }
        if (i == 11) {
            return "User stopped";
        }
        if (i == 2) {
            return "Signaled";
        }
        if (i == 8) {
            return "Permission changed";
        }
        if (i == 13) {
            return "Other";
        }
        if (i == 3) {
            return "Low memory";
        }
        if (i == 7) {
            return "Initialization failure";
        }
        if (i == 1) {
            return "Self stop";
        }
        if (i == 9) {
            return "Excessive resource usage";
        }
        if (i == 12) {
            return "Dependency died";
        }
        if (i == 5) {
            return "Native crash";
        }
        if (i == 4) {
            return "Crash";
        }
        if (i == 6) {
            return "ANR";
        }
        return "Unexpected: " + i;
    }

    public static String getHumanReadableDateAndTimeFromTimestamp(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return DateFormat.format("dd-MM-yyyy HH:mm:ss", calendar).toString();
    }
}
