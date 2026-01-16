package org.linphone.core.tools.firebase;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import org.linphone.core.tools.Log;
import org.linphone.core.tools.PushNotificationUtils;
import org.linphone.core.tools.service.CoreManager;

@Keep
/* loaded from: classes3.dex */
public class FirebasePushHelper implements PushNotificationUtils.PushHelperInterface {
    @Override // org.linphone.core.tools.PushNotificationUtils.PushHelperInterface
    public void init(Context context) {
        try {
            com.google.firebase.messaging.FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: org.linphone.core.tools.firebase.FirebasePushHelper.1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<String> task) {
                    if (!task.isSuccessful()) {
                        Log.e("[Push Notification] Firebase getToken failed: " + task.getException());
                        return;
                    }
                    String result = task.getResult();
                    Log.i("[Push Notification] Token fetched from Firebase: " + result);
                    if (CoreManager.isReady()) {
                        CoreManager.instance().setPushToken(result);
                    }
                }
            });
        } catch (Exception unused) {
            Log.e("[Push Notification] Firebase not available.");
        }
    }

    @Override // org.linphone.core.tools.PushNotificationUtils.PushHelperInterface
    public boolean isAvailable(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
    }
}
