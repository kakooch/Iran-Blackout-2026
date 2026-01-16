package org.rbmain.messenger;

import android.content.SharedPreferences;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$PeerNotifySettings;

/* loaded from: classes4.dex */
public class NotificationsSettingsFacade {
    public static final String PROPERTY_CONTENT_PREVIEW = "content_preview_";
    public static final String PROPERTY_CUSTOM = "custom_";
    public static final String PROPERTY_NOTIFY = "notify2_";
    public static final String PROPERTY_NOTIFY_UNTIL = "notifyuntil_";
    public static final String PROPERTY_SILENT = "silent_";
    private final int currentAccount;

    public NotificationsSettingsFacade(int i) {
        this.currentAccount = i;
    }

    public boolean isDefault(long j, int i) {
        NotificationsController.getSharedPrefKey(j, i);
        return false;
    }

    public void clearPreference(long j, int i) {
        String sharedPrefKey = NotificationsController.getSharedPrefKey(j, i);
        getPreferences().edit().remove(PROPERTY_NOTIFY + sharedPrefKey).remove(PROPERTY_CUSTOM + sharedPrefKey).remove(PROPERTY_NOTIFY_UNTIL + sharedPrefKey).remove(PROPERTY_CONTENT_PREVIEW + sharedPrefKey).remove(PROPERTY_SILENT + sharedPrefKey).apply();
    }

    public int getProperty(String str, long j, int i, int i2) {
        String sharedPrefKey = NotificationsController.getSharedPrefKey(j, i);
        if (getPreferences().contains(str + sharedPrefKey)) {
            return getPreferences().getInt(str + sharedPrefKey, i2);
        }
        String sharedPrefKey2 = NotificationsController.getSharedPrefKey(j, 0);
        return getPreferences().getInt(str + sharedPrefKey2, i2);
    }

    public long getProperty(String str, long j, int i, long j2) {
        String sharedPrefKey = NotificationsController.getSharedPrefKey(j, i);
        if (getPreferences().contains(str + sharedPrefKey)) {
            return getPreferences().getLong(str + sharedPrefKey, j2);
        }
        String sharedPrefKey2 = NotificationsController.getSharedPrefKey(j, 0);
        return getPreferences().getLong(str + sharedPrefKey2, j2);
    }

    public boolean getProperty(String str, long j, int i, boolean z) {
        String sharedPrefKey = NotificationsController.getSharedPrefKey(j, i);
        if (getPreferences().contains(str + sharedPrefKey)) {
            return getPreferences().getBoolean(str + sharedPrefKey, z);
        }
        String sharedPrefKey2 = NotificationsController.getSharedPrefKey(j, 0);
        return getPreferences().getBoolean(str + sharedPrefKey2, z);
    }

    public String getPropertyString(String str, long j, int i, String str2) {
        String sharedPrefKey = NotificationsController.getSharedPrefKey(j, i);
        if (getPreferences().contains(str + sharedPrefKey)) {
            return getPreferences().getString(str + sharedPrefKey, str2);
        }
        String sharedPrefKey2 = NotificationsController.getSharedPrefKey(j, 0);
        return getPreferences().getString(str + sharedPrefKey2, str2);
    }

    public void removeProperty(String str, long j, int i) {
        String sharedPrefKey = NotificationsController.getSharedPrefKey(j, i);
        getPreferences().edit().remove(str + sharedPrefKey).apply();
    }

    private SharedPreferences getPreferences() {
        return MessagesController.getNotificationsSettings(this.currentAccount);
    }

    public void applyDialogNotificationsSettings(final long j, final int i, final TLRPC$PeerNotifySettings tLRPC$PeerNotifySettings) {
        if (tLRPC$PeerNotifySettings == null) {
            return;
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsSettingsFacade$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$applyDialogNotificationsSettings$1(j, i, tLRPC$PeerNotifySettings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0193  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$applyDialogNotificationsSettings$1(long r18, int r20, org.rbmain.tgnet.TLRPC$PeerNotifySettings r21) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsSettingsFacade.lambda$applyDialogNotificationsSettings$1(long, int, org.rbmain.tgnet.TLRPC$PeerNotifySettings):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyDialogNotificationsSettings$0() {
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.notificationsSettingsUpdated, new Object[0]);
    }

    public void setSettingsForDialog(TLRPC$Dialog tLRPC$Dialog, TLRPC$PeerNotifySettings tLRPC$PeerNotifySettings) {
        SharedPreferences.Editor editorEdit = getPreferences().edit();
        long peerId = MessageObject.getPeerId(tLRPC$Dialog.peer);
        if ((tLRPC$Dialog.notify_settings.flags & 2) != 0) {
            editorEdit.putBoolean(PROPERTY_SILENT + peerId, tLRPC$Dialog.notify_settings.silent);
        } else {
            editorEdit.remove(PROPERTY_SILENT + peerId);
        }
        ConnectionsManager connectionsManager = ConnectionsManager.getInstance(this.currentAccount);
        TLRPC$PeerNotifySettings tLRPC$PeerNotifySettings2 = tLRPC$Dialog.notify_settings;
        if ((tLRPC$PeerNotifySettings2.flags & 4) != 0) {
            if (tLRPC$PeerNotifySettings2.mute_until > connectionsManager.getCurrentTime()) {
                if (tLRPC$Dialog.notify_settings.mute_until > connectionsManager.getCurrentTime() + 31536000) {
                    editorEdit.putInt(PROPERTY_NOTIFY + peerId, 2);
                    tLRPC$Dialog.notify_settings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
                } else {
                    editorEdit.putInt(PROPERTY_NOTIFY + peerId, 3);
                    editorEdit.putInt(PROPERTY_NOTIFY_UNTIL + peerId, tLRPC$Dialog.notify_settings.mute_until);
                }
            } else {
                editorEdit.putInt(PROPERTY_NOTIFY + peerId, 0);
            }
        } else {
            editorEdit.remove(PROPERTY_NOTIFY + peerId);
        }
        editorEdit.apply();
    }
}
