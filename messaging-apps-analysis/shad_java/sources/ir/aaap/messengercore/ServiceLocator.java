package ir.aaap.messengercore;

import ir.aaap.messengercore.db.DB;
import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.db.DBHelperImpl;
import ir.aaap.messengercore.network.DataCenterManager;
import ir.aaap.messengercore.network.Network;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.NetworkHelperImpl;
import ir.aaap.messengercore.usecase.GetMyUserGuidUsecase;
import ir.aaap.messengercore.usecase.LoadAbsUsecase;
import ir.aaap.messengercore.utilites.CoreLog;

/* loaded from: classes3.dex */
public class ServiceLocator {
    private BotUtils botUtils;
    private CallUtils callUtils;
    ChatUtils chatUtils;
    private DataCenterManager dataCenterManager;
    private DB db;
    private DBHelper dbHelper;
    public DeviceUtils deviceUtils;
    private JsonHelper jsonHelper;
    private CoreEncryptionHelper keyEncryptionHelper;
    private KeyValueStorage keyValueStorage;
    public KeyValueStorageHelper keyValueStorageHelper;
    private LiveUtils liveUtils;
    private LoginUtils loginUtils;
    MessageUtils messageUtils;
    public CoreLog myLog;
    private Network network;
    public NetworkHelper networkHelper;
    public AbsNotificationCenter notificationCenter;
    private NotificationUtils notificationUtils;
    private PhoneBookHelper phoneBookHelper;
    public PushNotification pushNotification;
    public RubinoUtils rubinoUtils;
    private SettingUtils settingUtils;
    private TimerHelper timerHelper;
    private WalletUtils walletUtils;

    public MessageUtils getMessageUtils() {
        MessageUtils messageUtils = this.messageUtils;
        if (messageUtils == null) {
            synchronized (MessageUtils.class) {
                messageUtils = this.messageUtils;
                if (messageUtils == null) {
                    messageUtils = new MessageUtils(getCoreLog());
                    this.messageUtils = messageUtils;
                }
            }
        }
        return messageUtils;
    }

    public ChatUtils getChatUtils(GetMyUserGuidUsecase getMyUserGuidUsecase) {
        ChatUtils chatUtils = this.chatUtils;
        if (chatUtils == null) {
            synchronized (ChatUtils.class) {
                chatUtils = this.chatUtils;
                if (chatUtils == null) {
                    chatUtils = new ChatUtils(getCoreLog(), getMyUserGuidUsecase);
                    this.chatUtils = chatUtils;
                }
            }
        }
        return chatUtils;
    }

    public SettingUtils getSettingUtils() {
        SettingUtils settingUtils = this.settingUtils;
        if (settingUtils == null) {
            synchronized (SettingUtils.class) {
                settingUtils = this.settingUtils;
                if (settingUtils == null) {
                    settingUtils = new SettingUtils(getCoreLog(), getJsonHelper());
                    this.settingUtils = settingUtils;
                }
            }
        }
        return settingUtils;
    }

    public BotUtils getBotUtils() {
        BotUtils botUtils = this.botUtils;
        if (botUtils == null) {
            synchronized (BotUtils.class) {
                botUtils = this.botUtils;
                if (botUtils == null) {
                    botUtils = new BotUtils(getCoreLog());
                    this.botUtils = botUtils;
                }
            }
        }
        return botUtils;
    }

    public WalletUtils getWalletUtils() {
        WalletUtils walletUtils = this.walletUtils;
        if (walletUtils == null) {
            synchronized (WalletUtils.class) {
                walletUtils = this.walletUtils;
                if (walletUtils == null) {
                    walletUtils = new WalletUtils(getCoreLog());
                    this.walletUtils = walletUtils;
                }
            }
        }
        return walletUtils;
    }

    public LiveUtils getLiveUtils() {
        LiveUtils liveUtils = this.liveUtils;
        if (liveUtils == null) {
            synchronized (LiveUtils.class) {
                liveUtils = this.liveUtils;
                if (liveUtils == null) {
                    liveUtils = new LiveUtils(getCoreLog());
                    this.liveUtils = liveUtils;
                }
            }
        }
        return liveUtils;
    }

    public LoginUtils getLoginUtils() {
        LoginUtils loginUtils = this.loginUtils;
        if (loginUtils == null) {
            synchronized (LoginUtils.class) {
                loginUtils = this.loginUtils;
                if (loginUtils == null) {
                    loginUtils = new LoginUtils(getCoreLog());
                    this.loginUtils = loginUtils;
                }
            }
        }
        return loginUtils;
    }

    public NetworkHelper getNetworkHelper() {
        NetworkHelper networkHelperImpl = this.networkHelper;
        if (networkHelperImpl == null) {
            synchronized (NetworkHelperImpl.class) {
                networkHelperImpl = this.networkHelper;
                if (networkHelperImpl == null) {
                    networkHelperImpl = new NetworkHelperImpl(this.network, getJsonHelper(), getCoreLog());
                    this.networkHelper = networkHelperImpl;
                }
            }
        }
        return networkHelperImpl;
    }

    public CallUtils getCallUtils(GetMyUserGuidUsecase getMyUserGuidUsecase, LoadAbsUsecase loadAbsUsecase) {
        CallUtils callUtils = this.callUtils;
        if (callUtils == null) {
            synchronized (CallUtils.class) {
                callUtils = this.callUtils;
                if (callUtils == null) {
                    callUtils = new CallUtils(getCoreLog(), getMyUserGuidUsecase, loadAbsUsecase);
                    this.callUtils = callUtils;
                }
            }
        }
        return callUtils;
    }

    public DataCenterManager getDataCenterManager() {
        DataCenterManager dataCenterManager = this.dataCenterManager;
        if (dataCenterManager == null) {
            synchronized (DataCenterManager.class) {
                dataCenterManager = this.dataCenterManager;
                if (dataCenterManager == null) {
                    dataCenterManager = new DataCenterManager(getNetworkHelper(), getKeyValueStorageHelper(), getJsonHelper(), getCoreLog());
                    this.dataCenterManager = dataCenterManager;
                }
            }
        }
        return dataCenterManager;
    }

    public DBHelper getDBHelper() {
        DBHelper dBHelperImpl = this.dbHelper;
        if (dBHelperImpl == null) {
            synchronized (DBHelperImpl.class) {
                dBHelperImpl = this.dbHelper;
                if (dBHelperImpl == null) {
                    dBHelperImpl = new DBHelperImpl(this.db, getJsonHelper(), getCoreLog());
                    this.dbHelper = dBHelperImpl;
                }
            }
        }
        return dBHelperImpl;
    }

    public KeyValueStorageHelper getKeyValueStorageHelper() {
        KeyValueStorageHelper keyValueStorageHelper = this.keyValueStorageHelper;
        if (keyValueStorageHelper == null) {
            synchronized (KeyValueStorageHelper.class) {
                keyValueStorageHelper = this.keyValueStorageHelper;
                if (keyValueStorageHelper == null) {
                    keyValueStorageHelper = new KeyValueStorageHelper(this.keyValueStorage, getJsonHelper(), getCoreEncryptionHelper(), getCoreLog());
                    this.keyValueStorageHelper = keyValueStorageHelper;
                }
            }
        }
        return keyValueStorageHelper;
    }

    public RubinoUtils getRubinoUtils() {
        return this.rubinoUtils;
    }

    public AbsNotificationCenter getNotificationCenter() {
        return this.notificationCenter;
    }

    public PhoneBookHelper getPhoneBookHelper() {
        return this.phoneBookHelper;
    }

    public JsonHelper getJsonHelper() {
        return this.jsonHelper;
    }

    public CoreEncryptionHelper getCoreEncryptionHelper() {
        return this.keyEncryptionHelper;
    }

    public TimerHelper getTimerHelper() {
        return this.timerHelper;
    }

    public PushNotification getPushNotification() {
        return this.pushNotification;
    }

    public DeviceUtils getDeviceUtils() {
        return this.deviceUtils;
    }

    public CoreLog getCoreLog() {
        return this.myLog;
    }

    public void init(DB db, Network network, AbsNotificationCenter absNotificationCenter, JsonHelper jsonHelper, CoreEncryptionHelper coreEncryptionHelper, KeyValueStorage keyValueStorage, CoreLog coreLog, TimerHelper timerHelper, PushNotification pushNotification, DeviceUtils deviceUtils, PhoneBookHelper phoneBookHelper, RubinoUtils rubinoUtils) {
        this.db = db;
        this.network = network;
        this.notificationCenter = absNotificationCenter;
        this.jsonHelper = jsonHelper;
        this.keyEncryptionHelper = coreEncryptionHelper;
        this.timerHelper = timerHelper;
        this.keyValueStorage = keyValueStorage;
        this.myLog = coreLog;
        this.pushNotification = pushNotification;
        this.deviceUtils = deviceUtils;
        this.phoneBookHelper = phoneBookHelper;
        this.rubinoUtils = rubinoUtils;
    }

    public NotificationUtils getNotificationUtils() {
        NotificationUtils notificationUtils = this.notificationUtils;
        if (notificationUtils == null) {
            synchronized (NotificationUtils.class) {
                notificationUtils = this.notificationUtils;
                if (notificationUtils == null) {
                    notificationUtils = new NotificationUtils(getCoreLog());
                    this.notificationUtils = notificationUtils;
                }
            }
        }
        return notificationUtils;
    }
}
