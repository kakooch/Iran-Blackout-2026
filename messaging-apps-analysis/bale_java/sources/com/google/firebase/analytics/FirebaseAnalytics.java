package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.installations.c;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.C15566jn8;
import ir.nasim.Kp8;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics b;
    private final C15566jn8 a;

    public FirebaseAnalytics(C15566jn8 c15566jn8) {
        AbstractC3795Cj5.j(c15566jn8);
        this.a = c15566jn8;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (b == null) {
                        b = new FirebaseAnalytics(C15566jn8.q(context, null, null, null, null));
                    }
                } finally {
                }
            }
        }
        return b;
    }

    @Keep
    public static Kp8 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        C15566jn8 c15566jn8Q = C15566jn8.q(context, null, null, null, bundle);
        if (c15566jn8Q == null) {
            return null;
        }
        return new a(c15566jn8Q);
    }

    public void a(String str, Bundle bundle) {
        this.a.E(str, bundle);
    }

    public void b(String str, String str2) {
        this.a.d(null, str, str2, false);
    }

    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) AbstractC9078Yj7.b(c.p().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.a.c(activity, str, str2);
    }
}
