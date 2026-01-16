package org.acra.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import ir.eitaa.tgnet.ConnectionsManager;
import java.util.List;
import org.acra.ACRA;
import org.acra.builder.LastActivityManager;
import org.acra.config.CoreConfiguration;
import org.acra.sender.SenderService;
import org.acra.util.SystemServices;

/* loaded from: classes.dex */
public final class ProcessFinisher {
    private final CoreConfiguration config;
    private final Context context;
    private final LastActivityManager lastActivityManager;

    public ProcessFinisher(Context context, CoreConfiguration coreConfiguration, LastActivityManager lastActivityManager) {
        this.context = context;
        this.config = coreConfiguration;
        this.lastActivityManager = lastActivityManager;
    }

    public void endApplication() throws SecurityException {
        stopServices();
        killProcessAndExit();
    }

    public void finishLastActivity(Thread thread) {
        final Activity lastActivity = this.lastActivityManager.getLastActivity();
        if (lastActivity != null) {
            boolean z = thread == lastActivity.getMainLooper().getThread();
            if (ACRA.DEV_LOGGING) {
                ACRA.log.d(ACRA.LOG_TAG, "Finishing the last Activity prior to killing the Process");
            }
            Runnable runnable = new Runnable() { // from class: org.acra.util.-$$Lambda$ProcessFinisher$OmeRxmCVVMKxLT4IxnHMK87eyrc
                @Override // java.lang.Runnable
                public final void run() {
                    ProcessFinisher.lambda$finishLastActivity$0(lastActivity);
                }
            };
            if (z) {
                runnable.run();
            } else {
                lastActivity.runOnUiThread(runnable);
            }
            if (!z) {
                this.lastActivityManager.waitForActivityStop(100);
            }
            this.lastActivityManager.clearLastActivity();
        }
    }

    static /* synthetic */ void lambda$finishLastActivity$0(Activity activity) {
        activity.finish();
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "Finished " + activity.getClass());
        }
    }

    private void stopServices() throws SecurityException {
        if (this.config.stopServicesOnCrash()) {
            try {
                List<ActivityManager.RunningServiceInfo> runningServices = SystemServices.getActivityManager(this.context).getRunningServices(ConnectionsManager.DEFAULT_DATACENTER_ID);
                int iMyPid = Process.myPid();
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.pid == iMyPid && !SenderService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                        try {
                            Intent intent = new Intent();
                            intent.setComponent(runningServiceInfo.service);
                            this.context.stopService(intent);
                        } catch (SecurityException unused) {
                            if (ACRA.DEV_LOGGING) {
                                ACRA.log.d(ACRA.LOG_TAG, "Unable to stop Service " + runningServiceInfo.service.getClassName() + ". Permission denied");
                            }
                        }
                    }
                }
            } catch (SystemServices.ServiceNotReachedException e) {
                ACRA.log.e(ACRA.LOG_TAG, "Unable to stop services", e);
            }
        }
    }

    private void killProcessAndExit() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}
