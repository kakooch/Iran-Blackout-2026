package androidMessenger.model;

import androidMessenger.ServiceLocator;
import androidMessenger.network.EncryptionHelper;
import ir.aaap.messengercore.model.MessengerUpdateObject;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.model.RubinoNewEventObject;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes.dex */
public class NotificationObject {
    public String ack_id;
    public transient int currentAccount = UserConfig.selectedAccount;
    public String data_enc;
    public MessengerUpdateObject messenger;
    public PushNotificationObject notif;
    public RubinoNewEventObject rubino_data;
    public TypeEnum type;

    public enum TypeEnum {
        rubino,
        messenger,
        notif
    }

    public void makeData() {
        int i = 0;
        if (this.data_enc == null) {
            RubinoNewEventObject rubinoNewEventObject = this.rubino_data;
            if (rubinoNewEventObject == null || rubinoNewEventObject.profile_id == null) {
                return;
            }
            while (i < 3) {
                if (AppRubinoPreferences.getInstance(i).getMyProfileFromList(this.rubino_data.profile_id) != null) {
                    this.currentAccount = i;
                    return;
                }
                i++;
            }
            return;
        }
        String strDecryptAuth = null;
        while (i < 3) {
            if (ServiceLocator.isAccountLoggedIn(i)) {
                strDecryptAuth = EncryptionHelper.decryptAuth(this.data_enc, ServiceLocator.getInstance(i).getCoreMainClass().getAuth());
                this.currentAccount = i;
                break;
            }
            continue;
            i++;
        }
        if (strDecryptAuth != null) {
            try {
                TypeEnum typeEnum = this.type;
                if (typeEnum == TypeEnum.messenger && this.messenger == null) {
                    this.messenger = (MessengerUpdateObject) ApplicationLoader.getGson().fromJson(strDecryptAuth, MessengerUpdateObject.class);
                } else if (typeEnum == TypeEnum.notif && this.notif == null) {
                    this.notif = (PushNotificationObject) ApplicationLoader.getGson().fromJson(strDecryptAuth, PushNotificationObject.class);
                } else if (typeEnum == TypeEnum.rubino && this.rubino_data == null) {
                    this.rubino_data = (RubinoNewEventObject) ApplicationLoader.getGson().fromJson(strDecryptAuth, RubinoNewEventObject.class);
                }
            } catch (Exception unused) {
            }
        }
    }
}
