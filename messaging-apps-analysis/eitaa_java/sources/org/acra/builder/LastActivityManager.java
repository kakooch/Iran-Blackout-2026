package org.acra.builder;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import org.acra.ACRA;

/* loaded from: classes.dex */
public final class LastActivityManager {
    private WeakReference<Activity> lastActivityCreated = new WeakReference<>(null);

    public LastActivityManager(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: org.acra.builder.LastActivityManager.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "onActivityCreated " + activity.getClass());
                }
                LastActivityManager.this.lastActivityCreated = new WeakReference(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "onActivityStarted " + activity.getClass());
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "onActivityResumed " + activity.getClass());
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "onActivityPaused " + activity.getClass());
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "onActivityStopped " + activity.getClass());
                }
                synchronized (this) {
                    notify();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "onActivitySaveInstanceState " + activity.getClass());
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "onActivityDestroyed " + activity.getClass());
                }
            }
        });
    }

    public Activity getLastActivity() {
        return this.lastActivityCreated.get();
    }

    public void clearLastActivity() {
        this.lastActivityCreated.clear();
    }

    public void waitForActivityStop(int i) {
        synchronized (this) {
            try {
                wait(i);
            } catch (InterruptedException unused) {
            }
        }
    }
}
