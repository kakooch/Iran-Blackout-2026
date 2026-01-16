package ir.resaneh1.iptv.model;

import ir.aaap.messengercore.model.ChatType;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.MessengerChildLockObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.Set;

/* loaded from: classes3.dex */
public class ChildLockCheck {
    public static boolean canOpenRubinoWithAlert() {
        RubinoChildLockSettingObject rubinoChildLockSettingObject;
        ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
        if (childLockSettingObject == null || (rubinoChildLockSettingObject = childLockSettingObject.rubinoSettingObject) == null || !rubinoChildLockSettingObject.isRubinoLock) {
            return true;
        }
        showAlert();
        return false;
    }

    public static boolean canOpenExploreWithAlert() {
        RubinoChildLockSettingObject rubinoChildLockSettingObject;
        ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
        if (childLockSettingObject == null || (rubinoChildLockSettingObject = childLockSettingObject.rubinoSettingObject) == null || !rubinoChildLockSettingObject.isRubinoLock) {
            return true;
        }
        showAlert();
        return false;
    }

    public static boolean canPayWithAlert() {
        ServicesChildLockSettingObject servicesChildLockSettingObject;
        ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
        if (childLockSettingObject == null || (servicesChildLockSettingObject = childLockSettingObject.servicesSettingObject) == null || !servicesChildLockSettingObject.isPayLock) {
            return true;
        }
        showAlert();
        return false;
    }

    public static boolean canPlayVideoWithAlert() {
        ServicesChildLockSettingObject servicesChildLockSettingObject;
        ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
        if (childLockSettingObject == null || (servicesChildLockSettingObject = childLockSettingObject.servicesSettingObject) == null || !servicesChildLockSettingObject.isVodLock) {
            return true;
        }
        showAlert();
        return false;
    }

    public static boolean canPlayAudioWithAlert() {
        ServicesChildLockSettingObject servicesChildLockSettingObject;
        ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
        if (childLockSettingObject == null || (servicesChildLockSettingObject = childLockSettingObject.servicesSettingObject) == null || !servicesChildLockSettingObject.isAodLock) {
            return true;
        }
        showAlert();
        return false;
    }

    public static boolean canOpenMessengerChatWithAlert(String str, ChatType chatType) {
        MessengerChildLockSettingObject messengerChildLockSettingObject;
        MessengerChildLockObject messengerChildLockObject;
        ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
        if (childLockSettingObject != null && (messengerChildLockSettingObject = childLockSettingObject.messengerSettingObject) != null) {
            if (messengerChildLockSettingObject.isMessengerLock) {
                showAlert();
                return false;
            }
            if (chatType == ChatType.User) {
                MessengerChildLockObject messengerChildLockObject2 = messengerChildLockSettingObject.chatSetting;
                if (messengerChildLockObject2 != null) {
                    MessengerChildLockObject.AccessLevelEnum accessLevelEnum = messengerChildLockObject2.accessLevel;
                    if (accessLevelEnum == MessengerChildLockObject.AccessLevelEnum.Everybody) {
                        Set<String> set = messengerChildLockObject2.exceptionsMines;
                        if (set == null || !set.contains(str)) {
                            return true;
                        }
                        showAlert();
                        return false;
                    }
                    if (accessLevelEnum == MessengerChildLockObject.AccessLevelEnum.Nobody) {
                        Set<String> set2 = messengerChildLockObject2.exceptionsPlus;
                        if (set2 != null && set2.contains(str)) {
                            return true;
                        }
                        showAlert();
                        return false;
                    }
                }
            } else if (chatType == ChatType.Channel) {
                MessengerChildLockObject messengerChildLockObject3 = messengerChildLockSettingObject.channelSetting;
                if (messengerChildLockObject3 != null) {
                    MessengerChildLockObject.AccessLevelEnum accessLevelEnum2 = messengerChildLockObject3.accessLevel;
                    if (accessLevelEnum2 == MessengerChildLockObject.AccessLevelEnum.Everybody) {
                        Set<String> set3 = messengerChildLockObject3.exceptionsMines;
                        if (set3 == null || !set3.contains(str)) {
                            return true;
                        }
                        showAlert();
                        return false;
                    }
                    if (accessLevelEnum2 == MessengerChildLockObject.AccessLevelEnum.Nobody) {
                        Set<String> set4 = messengerChildLockObject3.exceptionsPlus;
                        if (set4 != null && set4.contains(str)) {
                            return true;
                        }
                        showAlert();
                        return false;
                    }
                }
            } else if (chatType == ChatType.Group && (messengerChildLockObject = messengerChildLockSettingObject.groupSetting) != null) {
                MessengerChildLockObject.AccessLevelEnum accessLevelEnum3 = messengerChildLockObject.accessLevel;
                if (accessLevelEnum3 == MessengerChildLockObject.AccessLevelEnum.Everybody) {
                    Set<String> set5 = messengerChildLockObject.exceptionsMines;
                    if (set5 == null || !set5.contains(str)) {
                        return true;
                    }
                    showAlert();
                    return false;
                }
                if (accessLevelEnum3 == MessengerChildLockObject.AccessLevelEnum.Nobody) {
                    Set<String> set6 = messengerChildLockObject.exceptionsPlus;
                    if (set6 != null && set6.contains(str)) {
                        return true;
                    }
                    showAlert();
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean canOpenMessengerWithAlert() {
        MessengerChildLockSettingObject messengerChildLockSettingObject;
        ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
        if (childLockSettingObject == null || (messengerChildLockSettingObject = childLockSettingObject.messengerSettingObject) == null || !messengerChildLockSettingObject.isMessengerLock) {
            return true;
        }
        showAlert();
        return false;
    }

    public static boolean canLogoutWithAlert() {
        ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
        if (childLockSettingObject == null || !childLockSettingObject.hasPassword()) {
            return true;
        }
        showAlert();
        return false;
    }

    static void showAlert() {
        Link link = new Link();
        link.type = Link.LinkTypeEnum.alert;
        Link.AlertData alertData = new Link.AlertData();
        link.alert_data = alertData;
        alertData.message = "به دلیل تنظیمات کنترل والدین به این قسمت دسترسی ندارید";
        new MainClickHandler().onLinkClick(link);
    }

    public static boolean canShowLinkWithAlert(Link link) {
        if (link.isForRubino()) {
            return canOpenRubinoWithAlert();
        }
        return true;
    }
}
