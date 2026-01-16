package org.linphone.core.tools.compatibility;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import j$.C$r8$wrapper$java$util$stream$Stream$VWRP;
import j$.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class DeviceUtils31 {
    public static void logPreviousCrashesIfAny(Context context) throws IOException {
        for (ApplicationExitInfo applicationExitInfo : ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 5)) {
            Log.i("==== Previous exit reason information dump ====");
            Log.i("REASON=", DeviceUtils30.getReasonAsString(applicationExitInfo.getReason()));
            Log.i("TIMESTAMP=", DeviceUtils30.getHumanReadableDateAndTimeFromTimestamp(applicationExitInfo.getTimestamp()));
            Log.i("DESCRIPTION=", applicationExitInfo.getDescription());
            if (applicationExitInfo.getReason() == 6 || applicationExitInfo.getReason() == 5) {
                try {
                    InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
                    if (traceInputStream != null) {
                        if (applicationExitInfo.getReason() != 5) {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(traceInputStream));
                            Log.w("TRACE=", (String) C$r8$wrapper$java$util$stream$Stream$VWRP.convert(bufferedReader.lines()).collect(Collectors.joining("\n")));
                            bufferedReader.close();
                        }
                    } else {
                        Log.w("[Device Utils 31] No input stream for exit info");
                    }
                } catch (IOException e) {
                    Log.e("[Device Utils 31] IO Exception while trying to get trace input stream: ", e);
                } catch (IllegalStateException e2) {
                    Log.e("[Device Utils 31] Illegal State Exception while trying to get trace input stream: ", e2);
                } catch (Exception e3) {
                    Log.e("[Device Utils 31] Exception while trying to get trace input stream: ", e3);
                }
            }
            Log.i("=========================================");
        }
    }

    public static int getPerformanceClass() {
        return Build.VERSION.MEDIA_PERFORMANCE_CLASS;
    }

    public static boolean isBluetoothConnectPermissionGranted(Context context) {
        return context.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0;
    }

    public static void startForegroundService(Service service, int i, Notification notification) {
        try {
            service.startForeground(i, notification);
        } catch (Exception e) {
            Log.e("[Device Utils 31] Can't start service as foreground!", e);
        }
    }
}
