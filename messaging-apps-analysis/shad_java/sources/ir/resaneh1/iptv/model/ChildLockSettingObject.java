package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class ChildLockSettingObject {
    public String password;
    public String passwordForDebug;
    public RubinoChildLockSettingObject rubinoSettingObject = new RubinoChildLockSettingObject();
    public MessengerChildLockSettingObject messengerSettingObject = new MessengerChildLockSettingObject();
    public ServicesChildLockSettingObject servicesSettingObject = new ServicesChildLockSettingObject();

    public boolean hasPassword() {
        String str = this.password;
        return (str == null || str.isEmpty()) ? false : true;
    }
}
