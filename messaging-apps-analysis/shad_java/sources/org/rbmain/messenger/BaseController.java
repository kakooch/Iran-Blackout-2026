package org.rbmain.messenger;

import androidMessenger.network.ApiRequestRx;
import androidMessenger.proxy.CallProxy;
import androidMessenger.proxy.ContactsProxy;
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.proxy.MessageProxy;
import androidMessenger.proxy.RubinoProxy;
import androidMessenger.utilites.MessengerLinkHandler;
import ir.aaap.messengercore.CoreMainClass;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.StoryController;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes.dex */
public class BaseController {
    protected int currentAccount;
    private AccountInstance parentAccountInstance;

    public BaseController(int i) {
        this.parentAccountInstance = AccountInstance.getInstance(i);
        this.currentAccount = i;
    }

    public final AppPreferences getAppPreferences() {
        return AppPreferences.getInstance(this.currentAccount);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AccountInstance getAccountInstance() {
        return this.parentAccountInstance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CoreMainClass getCoreMainClass() {
        return this.parentAccountInstance.getCoreMainClass();
    }

    protected final MessengerLinkHandler getMessengerLinkHandler() {
        return this.parentAccountInstance.getMessengerLinkHandler();
    }

    protected final ApiRequestRx getAppRequestRx() {
        return this.parentAccountInstance.getAppRequestRx();
    }

    protected final RubinoProxy getRubinoProxy() {
        return this.parentAccountInstance.getRubinoProxy();
    }

    protected final MessageProxy getMessagesProxy() {
        return this.parentAccountInstance.getMessageProxy();
    }

    protected final CallProxy getCallProxy() {
        return this.parentAccountInstance.getCallProxy();
    }

    protected final DialogsProxy getDialogsProxy() {
        return this.parentAccountInstance.getDialogsProxy();
    }

    protected final ContactsProxy getContactsProxy() {
        return this.parentAccountInstance.getContactsProxy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MessagesController getMessagesController() {
        return this.parentAccountInstance.getMessagesController();
    }

    protected final ContactsController getContactsController() {
        return this.parentAccountInstance.getContactsController();
    }

    protected final MediaDataController getMediaDataController() {
        return this.parentAccountInstance.getMediaDataController();
    }

    protected final ConnectionsManager getConnectionsManager() {
        return this.parentAccountInstance.getConnectionsManager();
    }

    protected final LocationController getLocationController() {
        return this.parentAccountInstance.getLocationController();
    }

    protected final NotificationsController getNotificationsController() {
        return this.parentAccountInstance.getNotificationsController();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final NotificationCenter getNotificationCenter() {
        return this.parentAccountInstance.getNotificationCenter();
    }

    public final RubinoController getRubinoController() {
        return RubinoController.getInstance(this.currentAccount);
    }

    public final StoryController getStoryController() {
        return StoryController.getInstance(this.currentAccount);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final UserConfig getUserConfig() {
        return this.parentAccountInstance.getUserConfig();
    }

    protected final MessagesStorage getMessagesStorage() {
        return this.parentAccountInstance.getMessagesStorage();
    }

    protected final DownloadController getDownloadController() {
        return this.parentAccountInstance.getDownloadController();
    }

    protected final SendMessagesHelper getSendMessagesHelper() {
        return this.parentAccountInstance.getSendMessagesHelper();
    }

    protected final SecretChatHelper getSecretChatHelper() {
        return this.parentAccountInstance.getSecretChatHelper();
    }

    protected final StatsController getStatsController() {
        return this.parentAccountInstance.getStatsController();
    }

    protected final FileLoader getFileLoader() {
        return this.parentAccountInstance.getFileLoader();
    }

    protected final FileRefController getFileRefController() {
        return this.parentAccountInstance.getFileRefController();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ApiRequestMessangerRx getApiRequestMessangerRx() {
        return ApiRequestMessangerRx.getInstance(this.currentAccount);
    }
}
