package org.linphone.core.tools.compatibility;

import android.app.Notification;
import android.app.Service;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class DeviceUtils34 {
    public static void startCallForegroundService(Service service, int i, Notification notification) {
        try {
            service.startForeground(i, notification, 196);
        } catch (Exception e) {
            Log.e("[Device Utils 34] Can't start service as foreground!", e);
        }
    }

    public static void startDataSyncForegroundService(Service service, int i, Notification notification) {
        try {
            service.startForeground(i, notification, 1);
        } catch (Exception e) {
            Log.e("[Device Utils 34] Can't start service as foreground!", e);
        }
    }
}
