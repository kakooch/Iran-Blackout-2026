package org.linphone.core.tools.firebase;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import org.json.JSONObject;
import org.linphone.core.tools.compatibility.DeviceUtils;
import org.linphone.core.tools.service.AndroidDispatcher;
import org.linphone.core.tools.service.CoreManager;

/* loaded from: classes3.dex */
public class FirebaseMessaging extends FirebaseMessagingService {
    public void onNewToken(String str) {
        Log.i("FirebaseIdService", "[Push Notification] Refreshed token: " + str);
        if (CoreManager.isReady()) {
            CoreManager.instance().setPushToken(str);
        }
    }

    public void onMessageReceived(final RemoteMessage remoteMessage) {
        Log.i("FirebaseMessaging", "[Push Notification] Received");
        AndroidDispatcher.dispatchOnUIThread(new Runnable() { // from class: org.linphone.core.tools.firebase.FirebaseMessaging.1
            @Override // java.lang.Runnable
            public void run() {
                FirebaseMessaging.this.onPushReceived(remoteMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPushReceived(RemoteMessage remoteMessage) {
        if (!CoreManager.isReady()) {
            storePushRemoteMessage(remoteMessage);
            notifyAppPushReceivedWithoutCoreAvailable();
            return;
        }
        org.linphone.core.tools.Log.i("[Push Notification] Received: " + remoteMessageToString(remoteMessage));
        if (CoreManager.instance() != null) {
            if (CoreManager.instance().getCore() != null) {
                Map data = remoteMessage.getData();
                String stringOrDefaultFromMap = DeviceUtils.getStringOrDefaultFromMap(data, "call-id", "");
                String string = new JSONObject(data).toString();
                org.linphone.core.tools.Log.i("[Push Notification] Notifying Core we have received a push for Call-ID [" + stringOrDefaultFromMap + "]");
                CoreManager.instance().processPushNotification(stringOrDefaultFromMap, string, false);
                return;
            }
            org.linphone.core.tools.Log.w("[Push Notification] No Core found, notifying application directly");
            storePushRemoteMessage(remoteMessage);
            notifyAppPushReceivedWithoutCoreAvailable();
        }
    }

    private void storePushRemoteMessage(RemoteMessage remoteMessage) {
        SharedPreferences.Editor editorEdit = getApplicationContext().getSharedPreferences("push_notification_storage", 0).edit();
        Map data = remoteMessage.getData();
        String stringOrDefaultFromMap = DeviceUtils.getStringOrDefaultFromMap(data, "call-id", "");
        editorEdit.putString("call-id", stringOrDefaultFromMap);
        editorEdit.putString("payload", new JSONObject(data).toString());
        editorEdit.apply();
        Log.i("FirebaseMessaging", "[Push Notification] Push information stored for Call-ID [" + stringOrDefaultFromMap + "]");
    }

    private void notifyAppPushReceivedWithoutCoreAvailable() {
        Intent intent = new Intent();
        intent.setAction("org.linphone.core.action.PUSH_RECEIVED");
        for (ResolveInfo resolveInfo : getPackageManager().queryBroadcastReceivers(intent, 0)) {
            String str = resolveInfo.activityInfo.applicationInfo.packageName;
            if (str.equals(getPackageName())) {
                Intent intent2 = new Intent(intent);
                intent2.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
                sendBroadcast(intent2);
                return;
            }
        }
    }

    private String remoteMessageToString(RemoteMessage remoteMessage) {
        return "From [" + remoteMessage.getFrom() + "], Message Id [" + remoteMessage.getMessageId() + "], TTL [" + remoteMessage.getTtl() + "], Original Priority [" + remoteMessage.getOriginalPriority() + "], Received Priority [" + remoteMessage.getPriority() + "], Sent Time [" + remoteMessage.getSentTime() + "], Data [" + new JSONObject(remoteMessage.getData()).toString() + "]";
    }
}
