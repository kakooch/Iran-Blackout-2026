package ir.eitaa.messenger;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import ir.eitaa.tgnet.ConnectionsManager;

@TargetApi(28)
/* loaded from: classes.dex */
public class NotificationsDisabledReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.app.action.NOTIFICATION_CHANNEL_BLOCK_STATE_CHANGED".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("android.app.extra.NOTIFICATION_CHANNEL_ID");
            boolean booleanExtra = intent.getBooleanExtra("android.app.extra.BLOCKED_STATE", false);
            if (TextUtils.isEmpty(stringExtra) || stringExtra.contains("_ia_")) {
                return;
            }
            String[] strArrSplit = stringExtra.split("_");
            if (strArrSplit.length < 3) {
                return;
            }
            ApplicationLoader.postInitApplication();
            int iIntValue = Utilities.parseInt(strArrSplit[0]).intValue();
            if (iIntValue < 0 || iIntValue >= 3) {
                return;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("received disabled notification channel event for " + stringExtra + " state = " + booleanExtra);
            }
            if (SystemClock.elapsedRealtime() - AccountInstance.getInstance(iIntValue).getNotificationsController().lastNotificationChannelCreateTime <= 1000) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("received disable notification event right after creating notification channel, ignoring");
                    return;
                }
                return;
            }
            SharedPreferences notificationsSettings = AccountInstance.getInstance(iIntValue).getNotificationsSettings();
            boolean zStartsWith = strArrSplit[1].startsWith("channel");
            int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
            if (zStartsWith) {
                if (!stringExtra.equals(notificationsSettings.getString("channels", null))) {
                    return;
                }
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("apply channel " + stringExtra + " state");
                }
                notificationsSettings.edit().putInt(NotificationsController.getGlobalNotificationsKey(2), booleanExtra ? ConnectionsManager.DEFAULT_DATACENTER_ID : 0).commit();
                AccountInstance.getInstance(iIntValue).getNotificationsController().updateServerNotificationsSettings(2);
            } else if (strArrSplit[1].startsWith("groups")) {
                if (!stringExtra.equals(notificationsSettings.getString("groups", null))) {
                    return;
                }
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("apply channel " + stringExtra + " state");
                }
                SharedPreferences.Editor editorEdit = notificationsSettings.edit();
                String globalNotificationsKey = NotificationsController.getGlobalNotificationsKey(0);
                if (!booleanExtra) {
                    i = 0;
                }
                editorEdit.putInt(globalNotificationsKey, i).commit();
                AccountInstance.getInstance(iIntValue).getNotificationsController().updateServerNotificationsSettings(0);
            } else if (strArrSplit[1].startsWith("private")) {
                if (!stringExtra.equals(notificationsSettings.getString("private", null))) {
                    return;
                }
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("apply channel " + stringExtra + " state");
                }
                notificationsSettings.edit().putInt(NotificationsController.getGlobalNotificationsKey(1), booleanExtra ? ConnectionsManager.DEFAULT_DATACENTER_ID : 0).commit();
                AccountInstance.getInstance(iIntValue).getNotificationsController().updateServerNotificationsSettings(1);
            } else {
                long jLongValue = Utilities.parseLong(strArrSplit[1]).longValue();
                if (jLongValue == 0) {
                    return;
                }
                if (!stringExtra.equals(notificationsSettings.getString("ir.eitaa.key" + jLongValue, null))) {
                    return;
                }
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("apply channel " + stringExtra + " state");
                }
                SharedPreferences.Editor editorEdit2 = notificationsSettings.edit();
                editorEdit2.putInt("notify2_" + jLongValue, booleanExtra ? 2 : 0);
                if (!booleanExtra) {
                    editorEdit2.remove("notifyuntil_" + jLongValue);
                }
                editorEdit2.commit();
                AccountInstance.getInstance(iIntValue).getNotificationsController().updateServerNotificationsSettings(jLongValue, true);
            }
            AccountInstance.getInstance(iIntValue).getConnectionsManager().resumeNetworkMaybe();
        }
    }
}
