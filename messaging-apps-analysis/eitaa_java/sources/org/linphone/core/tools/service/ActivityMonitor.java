package org.linphone.core.tools.service;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class ActivityMonitor implements Application.ActivityLifecycleCallbacks {
    private InactivityChecker mLastChecker;
    private final ArrayList<Activity> activities = new ArrayList<>();
    private boolean mActive = false;
    private int mRunningActivities = 0;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        Log.i("[Activity Monitor] Activity created:" + activity);
        if (!this.activities.contains(activity)) {
            this.activities.add(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Log.i("Activity started:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        Log.i("[Activity Monitor] Activity resumed:" + activity);
        if (!this.activities.contains(activity)) {
            Log.w("[Activity Monitor] Activity wasn't registered yet...");
            this.activities.add(activity);
        }
        this.mRunningActivities++;
        Log.i("[Activity Monitor] runningActivities=" + this.mRunningActivities);
        checkActivity();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityPaused(Activity activity) {
        Log.i("[Activity Monitor] Activity paused:" + activity);
        if (!this.activities.contains(activity)) {
            Log.w("[Activity Monitor] Activity wasn't registered yet...");
            this.activities.add(activity);
        } else {
            this.mRunningActivities--;
            Log.i("[Activity Monitor] runningActivities=" + this.mRunningActivities);
            checkActivity();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Log.i("[Activity Monitor] Activity stopped:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityDestroyed(Activity activity) {
        Log.i("[Activity Monitor] Activity destroyed:" + activity);
        this.activities.remove(activity);
    }

    void startInactivityChecker() {
        InactivityChecker inactivityChecker = this.mLastChecker;
        if (inactivityChecker != null) {
            inactivityChecker.cancel();
        }
        InactivityChecker inactivityChecker2 = new InactivityChecker();
        this.mLastChecker = inactivityChecker2;
        AndroidDispatcher.dispatchOnUIThreadAfter(inactivityChecker2, 2000L);
    }

    void checkActivity() {
        int i = this.mRunningActivities;
        if (i == 0) {
            if (this.mActive) {
                startInactivityChecker();
            }
        } else if (i > 0) {
            if (!this.mActive) {
                this.mActive = true;
                onForegroundMode();
            }
            InactivityChecker inactivityChecker = this.mLastChecker;
            if (inactivityChecker != null) {
                inactivityChecker.cancel();
                this.mLastChecker = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackgroundMode() {
        Log.i("[Activity Monitor] App has entered background mode");
        if (CoreManager.isReady()) {
            CoreManager.instance().onBackgroundMode();
        }
    }

    private void onForegroundMode() {
        Log.i("[Activity Monitor] App has left background mode");
        if (CoreManager.isReady()) {
            CoreManager.instance().onForegroundMode();
        }
    }

    class InactivityChecker implements Runnable {
        private boolean isCanceled;

        InactivityChecker() {
        }

        void cancel() {
            this.isCanceled = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CoreManager.isReady()) {
                synchronized (CoreManager.instance()) {
                    if (!this.isCanceled && ActivityMonitor.this.mRunningActivities == 0 && ActivityMonitor.this.mActive) {
                        ActivityMonitor.this.mActive = false;
                        ActivityMonitor.this.onBackgroundMode();
                    }
                }
            }
        }
    }
}
