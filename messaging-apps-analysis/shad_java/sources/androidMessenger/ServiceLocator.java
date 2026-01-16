package androidMessenger;

import androidMessenger.DB.DBImpl;
import androidMessenger.KeyEncryptionHelper.CoreEncryptionHelperImpl;
import androidMessenger.deviceUtils.DeviceUtilsImpl;
import androidMessenger.deviceUtils.PhoneBookHelperImpl;
import androidMessenger.jsonHelper.JsonHelperImpl;
import androidMessenger.keyValueStorageHelper.KeyValueStorageImpl;
import androidMessenger.log.CoreLogImpl;
import androidMessenger.network.ApiRequestRx;
import androidMessenger.network.CacheDatabaseHelper;
import androidMessenger.network.NetworkImpl;
import androidMessenger.notificationCenter.NotificationCenter;
import androidMessenger.proxy.CallProxy;
import androidMessenger.proxy.ContactsProxy;
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.proxy.FileLoadProxy;
import androidMessenger.proxy.MediaProxy;
import androidMessenger.proxy.MessageProxy;
import androidMessenger.proxy.RubinoProxy;
import androidMessenger.pushNotification.PushNotificationImpl;
import androidMessenger.rubinoUtls.RubinoUtilsImpl;
import androidMessenger.timerHelper.TimerHelperImpl;
import androidMessenger.utilites.MessengerLinkHandler;
import ir.aaap.messengercore.CoreEncryptionHelper;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.JsonHelper;
import ir.aaap.messengercore.KeyValueStorage;
import ir.aaap.messengercore.PhoneBookHelper;
import ir.aaap.messengercore.RubinoUtils;
import ir.aaap.messengercore.TimerHelper;
import ir.aaap.messengercore.db.DB;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.Network;
import ir.resaneh1.iptv.logger.MyLog;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes.dex */
public class ServiceLocator {
    private static LaunchActivity tag;
    private ApiRequestRx apiRequestRx;
    private CallProxy callProxy;
    private ContactsProxy contactsProxy;
    private CoreMainClassImpl core;
    private int currentAccount;
    private DB db;
    private DialogsProxy dialogsProxy;
    private final Network.NetworkErrorListener errorListener;
    private FileLoadProxy fileLoadProxy;
    private JsonHelper jsonHelper;
    private CoreEncryptionHelper keyEncryptionHelper;
    private KeyValueStorage keyValueStorageHelper;
    private MediaProxy mediaProxy;
    private MessageProxy messageProxy;
    private MessengerLinkHandler messengerLinkHandler;
    private Network network;
    private PhoneBookHelper phoneBookHelper;
    private RubinoProxy rubinoProxy;
    private RubinoUtils rubinoUtils;
    private TimerHelper timerHelper;
    public static final Object lock = new Object();
    private static final ServiceLocator[] Instance = new ServiceLocator[3];

    public static ServiceLocator getInstance(int i) {
        ServiceLocator[] serviceLocatorArr = Instance;
        ServiceLocator serviceLocator = serviceLocatorArr[i];
        if (serviceLocator == null) {
            synchronized (ServiceLocator.class) {
                serviceLocator = serviceLocatorArr[i];
                if (serviceLocator == null) {
                    serviceLocator = new ServiceLocator(i);
                    serviceLocatorArr[i] = serviceLocator;
                    serviceLocator.currentAccount = i;
                }
            }
        }
        return serviceLocator;
    }

    private ServiceLocator(int i) {
        Network.NetworkErrorListener networkErrorListener = new Network.NetworkErrorListener() { // from class: androidMessenger.ServiceLocator.1
            @Override // ir.aaap.messengercore.network.Network.NetworkErrorListener
            public void onNetworkError(boolean z) {
                if (z && ServiceLocator.this.core != null && ServiceLocator.this.core.isCoreInitiated()) {
                    ServiceLocator.this.core.increaseApiServerOnError();
                }
            }

            @Override // ir.aaap.messengercore.network.Network.NetworkErrorListener
            public void onGetFileError(String str) {
                if (ServiceLocator.this.core == null || !ServiceLocator.this.core.isCoreInitiated()) {
                    return;
                }
                ServiceLocator.this.core.increaseCdnCounterIfNeeded(str);
            }

            @Override // ir.aaap.messengercore.network.Network.NetworkErrorListener
            public void onNotRegistered() {
                if (ServiceLocator.this.core == null || !ServiceLocator.this.core.isCoreInitiated()) {
                    return;
                }
                ServiceLocator.this.core.forceRegisterDevice(ServiceLocator.getActivatedAccountsCount() > 1);
            }

            @Override // ir.aaap.messengercore.network.Network.NetworkErrorListener
            public void onInvalidAuth() {
                if (ServiceLocator.this.core == null || !ServiceLocator.this.core.isCoreInitiated()) {
                    return;
                }
                ServiceLocator.this.core.onInvalidAuth();
            }

            @Override // ir.aaap.messengercore.network.Network.NetworkErrorListener
            public void onShowMessage(Object obj) {
                if (ServiceLocator.this.messageProxy != null) {
                    ServiceLocator.this.messageProxy.proxyClientShowMessageFromCore(obj);
                }
            }

            @Override // ir.aaap.messengercore.network.Network.NetworkErrorListener
            public void handleError(ApiServerException apiServerException, Object obj) {
                if (ServiceLocator.this.messageProxy != null) {
                    ServiceLocator.this.messageProxy.proxyNetworkError(apiServerException, obj);
                }
            }
        };
        this.errorListener = networkErrorListener;
        this.currentAccount = i;
        this.core = new CoreMainClassImpl(i);
        this.db = new DBImpl(ApplicationLoader.applicationContext, i);
        this.network = new NetworkImpl(this.currentAccount);
        this.jsonHelper = new JsonHelperImpl();
        this.keyEncryptionHelper = new CoreEncryptionHelperImpl();
        this.timerHelper = new TimerHelperImpl();
        this.keyValueStorageHelper = new KeyValueStorageImpl(i);
        this.messageProxy = new MessageProxy(i);
        this.apiRequestRx = new ApiRequestRx(i);
        this.rubinoProxy = new RubinoProxy(i);
        this.mediaProxy = new MediaProxy(i);
        this.callProxy = new CallProxy(i);
        this.fileLoadProxy = new FileLoadProxy(i);
        this.dialogsProxy = new DialogsProxy(i);
        this.contactsProxy = new ContactsProxy(i);
        this.phoneBookHelper = new PhoneBookHelperImpl();
        this.messengerLinkHandler = new MessengerLinkHandler(i);
        this.rubinoUtils = new RubinoUtilsImpl(i);
        CoreLogImpl coreLogImpl = new CoreLogImpl();
        PushNotificationImpl pushNotificationImpl = new PushNotificationImpl();
        DeviceUtilsImpl deviceUtilsImpl = new DeviceUtilsImpl();
        this.core.init(i == UserConfig.selectedAccount, getActivatedAccountsCount() > 1, this.db, this.network, NotificationCenter.getInstance(i), this.jsonHelper, this.keyEncryptionHelper, this.keyValueStorageHelper, coreLogImpl, this.timerHelper, pushNotificationImpl, deviceUtilsImpl, this.phoneBookHelper, networkErrorListener, this.rubinoUtils);
        this.messageProxy.loadAllNotification();
        this.apiRequestRx.init(new ApiRequestRx.AuthDelegate() { // from class: androidMessenger.ServiceLocator$$ExternalSyntheticLambda0
            @Override // androidMessenger.network.ApiRequestRx.AuthDelegate
            public final String provideAuth() {
                return this.f$0.lambda$new$0();
            }
        }, networkErrorListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$new$0() {
        return this.core.getAuth();
    }

    public static void setTag(LaunchActivity launchActivity) {
        synchronized (lock) {
            tag = launchActivity;
        }
    }

    public static boolean checkTag(LaunchActivity launchActivity) {
        boolean zEquals;
        synchronized (lock) {
            zEquals = tag.equals(launchActivity);
        }
        return zEquals;
    }

    public void initOnActivateCore() {
        this.core.initOnActivated(getActivatedAccountsCount() > 1);
    }

    public void loadMyUserInfo() {
        this.core.loadMyUserInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getActivatedAccountsCount() {
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            if (isAccountLoggedIn(i2)) {
                i++;
            }
        }
        return i;
    }

    public static void clearInstance(int i) {
        ServiceLocator[] serviceLocatorArr = Instance;
        if (serviceLocatorArr[i] != null) {
            synchronized (ServiceLocator.class) {
                if (serviceLocatorArr[i] != null) {
                    serviceLocatorArr[i] = null;
                }
            }
        }
    }

    public static void onFinish() {
        for (int i = 0; i < 3; i++) {
            if (isAccountLoggedIn(i)) {
                getInstance(i).onFinishInstance();
            }
        }
    }

    public CoreMainClass getCoreMainClass() {
        return this.core;
    }

    public MessengerLinkHandler getMessengerLinkHandler() {
        return this.messengerLinkHandler;
    }

    public ApiRequestRx getAppRequestRx() {
        return this.apiRequestRx;
    }

    public RubinoProxy getRubinoProxy() {
        return this.rubinoProxy;
    }

    public MessageProxy getMessageProxy() {
        return this.messageProxy;
    }

    public MediaProxy getMediaProxy() {
        return this.mediaProxy;
    }

    public FileLoadProxy getFileLoadProxy() {
        return this.fileLoadProxy;
    }

    public DialogsProxy getDialogsProxy() {
        return this.dialogsProxy;
    }

    public ContactsProxy getContactsProxy() {
        return this.contactsProxy;
    }

    public CallProxy getCallProxy() {
        return this.callProxy;
    }

    public static boolean isAccountLoggedIn(int i) {
        return CoreMainClass.CC.isAccountLoggedIn(KeyValueStorageImpl.getInstance(i), new JsonHelperImpl(), new CoreLogImpl());
    }

    public static void setLastAuth(int i, String str) {
        CoreMainClass.CC.setLastAuth(str, KeyValueStorageImpl.getInstance(i), new JsonHelperImpl(), new CoreLogImpl());
    }

    public static void setLastAuthV6(int i, String str, String str2) {
        CoreMainClass.CC.setLastAuthV6(str, str2, KeyValueStorageImpl.getInstance(i), new JsonHelperImpl(), new CoreLogImpl());
    }

    public void cleanUp() {
        clearApiCache();
        disposeApiRequest();
    }

    private void disposeApiRequest() {
        if (this.network != null) {
            MyLog.d(ServiceLocator.class.getName(), "Dispose Network");
            this.network.disposeObservables();
        }
        if (this.apiRequestRx != null) {
            MyLog.d(ServiceLocator.class.getName(), "Dispose ApiRequestRx");
            this.apiRequestRx.disposeObservables();
        }
    }

    public void onFinishInstance() {
        disposeApiRequest();
        clearInstance(this.currentAccount);
    }

    public void clearApiCache() {
        CacheDatabaseHelper.getInstance(this.currentAccount).removeAll();
    }

    public void checkDisposable() {
        Network network = this.network;
        if (network != null) {
            network.checkDisposables();
        }
        ApiRequestRx apiRequestRx = this.apiRequestRx;
        if (apiRequestRx != null) {
            apiRequestRx.checkDisposables();
        }
    }

    public void onAuthSuccess() {
        getCoreMainClass().onAuthSuccess(getActivatedAccountsCount() > 1);
    }
}
