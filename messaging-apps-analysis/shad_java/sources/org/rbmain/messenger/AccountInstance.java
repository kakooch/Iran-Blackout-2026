package org.rbmain.messenger;

import android.content.SharedPreferences;
import androidMessenger.ServiceLocator;
import androidMessenger.network.ApiRequestRx;
import androidMessenger.proxy.CallProxy;
import androidMessenger.proxy.ContactsProxy;
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.proxy.FileLoadProxy;
import androidMessenger.proxy.MediaProxy;
import androidMessenger.proxy.MessageProxy;
import androidMessenger.proxy.RubinoProxy;
import androidMessenger.utilites.MessengerLinkHandler;
import ir.aaap.messengercore.CoreMainClass;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes.dex */
public class AccountInstance {
    private static volatile AccountInstance[] Instance = new AccountInstance[3];
    private int currentAccount;

    public static AccountInstance getInstance(int i) {
        AccountInstance accountInstance = Instance[i];
        if (accountInstance == null) {
            synchronized (AccountInstance.class) {
                accountInstance = Instance[i];
                if (accountInstance == null) {
                    AccountInstance[] accountInstanceArr = Instance;
                    AccountInstance accountInstance2 = new AccountInstance(i);
                    accountInstanceArr[i] = accountInstance2;
                    accountInstance = accountInstance2;
                }
            }
        }
        return accountInstance;
    }

    public AccountInstance(int i) {
        this.currentAccount = i;
    }

    public MessagesController getMessagesController() {
        return MessagesController.getInstance(this.currentAccount);
    }

    public CoreMainClass getCoreMainClass() {
        return ServiceLocator.getInstance(this.currentAccount).getCoreMainClass();
    }

    public MessengerLinkHandler getMessengerLinkHandler() {
        return ServiceLocator.getInstance(this.currentAccount).getMessengerLinkHandler();
    }

    public ApiRequestRx getAppRequestRx() {
        return ServiceLocator.getInstance(this.currentAccount).getAppRequestRx();
    }

    public RubinoProxy getRubinoProxy() {
        return ServiceLocator.getInstance(this.currentAccount).getRubinoProxy();
    }

    public MessageProxy getMessageProxy() {
        return ServiceLocator.getInstance(this.currentAccount).getMessageProxy();
    }

    public MediaProxy getMediaProxy() {
        return ServiceLocator.getInstance(this.currentAccount).getMediaProxy();
    }

    public CallProxy getCallProxy() {
        return ServiceLocator.getInstance(this.currentAccount).getCallProxy();
    }

    public DialogsProxy getDialogsProxy() {
        return ServiceLocator.getInstance(this.currentAccount).getDialogsProxy();
    }

    public ContactsProxy getContactsProxy() {
        return ServiceLocator.getInstance(this.currentAccount).getContactsProxy();
    }

    public FileLoadProxy getFileProxy() {
        return ServiceLocator.getInstance(this.currentAccount).getFileLoadProxy();
    }

    public MessagesStorage getMessagesStorage() {
        return MessagesStorage.getInstance(this.currentAccount);
    }

    public ContactsController getContactsController() {
        return ContactsController.getInstance(this.currentAccount);
    }

    public MediaDataController getMediaDataController() {
        return MediaDataController.getInstance(this.currentAccount);
    }

    public ConnectionsManager getConnectionsManager() {
        return ConnectionsManager.getInstance(this.currentAccount);
    }

    public NotificationsController getNotificationsController() {
        return NotificationsController.getInstance(this.currentAccount);
    }

    public NotificationCenter getNotificationCenter() {
        return NotificationCenter.getInstance(this.currentAccount);
    }

    public LocationController getLocationController() {
        return LocationController.getInstance(this.currentAccount);
    }

    public UserConfig getUserConfig() {
        return UserConfig.getInstance(this.currentAccount);
    }

    public DownloadController getDownloadController() {
        return DownloadController.getInstance(this.currentAccount);
    }

    public SendMessagesHelper getSendMessagesHelper() {
        return SendMessagesHelper.getInstance(this.currentAccount);
    }

    public SecretChatHelper getSecretChatHelper() {
        return SecretChatHelper.getInstance(this.currentAccount);
    }

    public StatsController getStatsController() {
        return StatsController.getInstance(this.currentAccount);
    }

    public FileLoader getFileLoader() {
        return FileLoader.getInstance(this.currentAccount);
    }

    public FileRefController getFileRefController() {
        return FileRefController.getInstance(this.currentAccount);
    }

    public SharedPreferences getNotificationsSettings() {
        return MessagesController.getNotificationsSettings(this.currentAccount);
    }

    public int getCurrentAccount() {
        return this.currentAccount;
    }
}
