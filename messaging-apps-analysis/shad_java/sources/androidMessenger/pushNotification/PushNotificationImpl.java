package androidMessenger.pushNotification;

import android.util.Log;
import androidMessenger.utilites.MyLog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.PushNotification;
import ir.aaap.messengercore.model.GetTokenResult;
import ir.aaap.messengercore.model.api.RegisterDeviceInput;

/* loaded from: classes.dex */
public class PushNotificationImpl implements PushNotification {
    @Override // ir.aaap.messengercore.PushNotification
    public void getToken(final LoadListener<GetTokenResult> loadListener) {
        FirebaseMessaging.getInstance().getToken().addOnFailureListener(new OnFailureListener() { // from class: androidMessenger.pushNotification.PushNotificationImpl$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                PushNotificationImpl.lambda$getToken$0(loadListener, exc);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: androidMessenger.pushNotification.PushNotificationImpl$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                PushNotificationImpl.lambda$getToken$1(loadListener, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getToken$0(LoadListener loadListener, Exception exc) {
        if (loadListener != null) {
            GetTokenResult getTokenResult = new GetTokenResult();
            getTokenResult.token = BuildConfig.FLAVOR;
            getTokenResult.tokenType = RegisterDeviceInput.TokenTypeEnum.Firebase;
            loadListener.onDidLoad(getTokenResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getToken$1(LoadListener loadListener, Task task) {
        String str;
        if (!task.isSuccessful() || task.getResult() == null) {
            Log.w("FireBase", "getInstanceId failed", task.getException());
            MyLog.handleExceptionThrowOnDebug(new Exception("getInstanceId failed", task.getException()));
            str = null;
        } else {
            str = (String) task.getResult();
        }
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        if (loadListener != null) {
            GetTokenResult getTokenResult = new GetTokenResult();
            getTokenResult.token = str;
            getTokenResult.tokenType = RegisterDeviceInput.TokenTypeEnum.Firebase;
            loadListener.onDidLoad(getTokenResult);
        }
    }
}
