package org.linphone.core.tools;

import android.content.Context;
import com.google.firebase.FirebaseApp;

/* loaded from: classes3.dex */
public class PushNotificationUtils {
    private static PushHelperInterface mHelper;

    public interface PushHelperInterface {
        void init(Context context);

        boolean isAvailable(Context context);
    }

    public static void init(Context context) {
        mHelper = null;
        if (!isFirebaseCloudMessaging23Available()) {
            Log.w("[Push Utils] Firebase Cloud Messaging 23+ isn't available. Ensure you have a dependency on com.google.firebase:firebase-messaging (23.0.6 or newer) in your app's build.gradle file or that you use a BoM at least 'com.google.firebase:firebase-bom:30.2.0'.");
            return;
        }
        if (!isGoogleApiAvailable()) {
            Log.w("[Push Utils] Google services aren't available. Ensure you have correctly applied the com.google.gms.google-services plugin in your app's build.gradle file (cf https://firebase.google.com/docs/android/setup#add-config-file).");
            return;
        }
        if (context.getResources().getIdentifier("gcm_defaultSenderId", "string", context.getPackageName()) == 0) {
            Log.e("[Push Utils] Couldn't find gcm_defaultSenderId string resource.");
            return;
        }
        FirebaseApp.initializeApp(context);
        try {
            PushHelperInterface pushHelperInterface = (PushHelperInterface) Class.forName("org.linphone.core.tools.firebase.FirebasePushHelper").getConstructor(new Class[0]).newInstance(new Object[0]);
            mHelper = pushHelperInterface;
            pushHelperInterface.init(context);
        } catch (ClassNotFoundException e) {
            Log.w("[Push Utils] Couldn't find class: " + e);
        } catch (NoSuchMethodException unused) {
            Log.w("[Push Utils] Couldn't get push helper constructor");
        } catch (Exception e2) {
            Log.w("[Push Utils] Couldn't get push helper instance: " + e2);
        }
    }

    public static boolean isAvailable(Context context) {
        PushHelperInterface pushHelperInterface = mHelper;
        if (pushHelperInterface == null) {
            return false;
        }
        return pushHelperInterface.isAvailable(context);
    }

    private static boolean isFirebaseCloudMessaging23Available() throws ClassNotFoundException {
        try {
            Class.forName("com.google.firebase.FirebaseApp");
            Class.forName("com.google.firebase.messaging.FirebaseMessaging");
            return true;
        } catch (ClassNotFoundException e) {
            Log.w("[Push Utils] Couldn't find class: ", e);
            return false;
        } catch (Exception e2) {
            Log.w("[Push Utils] Exception: " + e2);
            return false;
        }
    }

    private static boolean isGoogleApiAvailable() throws ClassNotFoundException {
        try {
            Class.forName("com.google.android.gms.common.GoogleApiAvailability");
            Class.forName("com.google.android.gms.tasks.Task");
            Class.forName("com.google.android.gms.common.ConnectionResult");
            Class.forName("com.google.android.gms.tasks.OnCompleteListener");
            return true;
        } catch (ClassNotFoundException e) {
            Log.w("[Push Utils] Couldn't find class: ", e);
            return false;
        } catch (Exception e2) {
            Log.w("[Push Utils] Exception: " + e2);
            return false;
        }
    }
}
