package ir.eitaa.tgnet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import ir.eitaa.helper.http.HelperHttp;
import ir.eitaa.helper.schedule.ScheduleController;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BaseController;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ByteArrayOutputStreamExpand;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.KeepAliveJob;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.StatsController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TcpConnection;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public class ConnectionsManager extends BaseController implements TcpConnection.TcpConnectionDelegate {
    public static final int AllConnectionTypes = 7;
    public static final int ConnectionStateConnected = 3;
    public static final int ConnectionStateConnecting = 1;
    public static final int ConnectionStateConnectingToProxy = 5;
    public static final int ConnectionStateUpdating = 4;
    public static final int ConnectionStateWaitingForNetwork = 2;
    public static final int ConnectionTypeDownload = 2;
    public static final int ConnectionTypeDownload2 = 65538;
    public static final int ConnectionTypeGeneric = 1;
    public static final int ConnectionTypePush = 8;
    public static final int ConnectionTypeUpload = 4;
    public static final int ConnectionTypeUpload2 = 65540;
    private static final int DC_UPDATE_TIME = 3600;
    public static final int DEFAULT_DATACENTER_ID = Integer.MAX_VALUE;
    public static final int FileTypeAudio = 50331648;
    public static final int FileTypeFile = 67108864;
    public static final int FileTypePhoto = 16777216;
    public static final int FileTypeVideo = 33554432;
    public static final int RequestFlagCanCompress = 4;
    public static final int RequestFlagEnableUnauthorized = 1;
    public static final int RequestFlagFailOnServerErrors = 2;
    public static final int RequestFlagForceDownload = 32;
    public static final int RequestFlagInvokeAfter = 64;
    public static final int RequestFlagNeedQuickAck = 128;
    public static final int RequestFlagTryDifferentDc = 16;
    public static final int RequestFlagWithoutLogin = 8;
    public static final int TcpConnectionTypeDownload = 16;
    public static final int TcpConnectionTypeGeneric = 64;
    public static final int TcpConnectionTypeUpload = 32;
    private static final int UW_UPDATE_TIME = 43200;
    private static final String WEB_ADD = "/eitaa/index.php";
    private static final String WEB_ADD2 = "/eitaa/index.php";
    private static byte[] decompressBuffer;
    private static ByteArrayOutputStreamExpand decompressStream;
    public ArrayList<String> addressesIpv4;
    public ArrayList<String> addressesIpv4Download;
    private boolean appPaused;
    private int appResumeCount;
    private int connectionState;
    private int connectionToken;
    private int currentAccount;
    private volatile int currentAddressNumIpv4;
    private volatile int currentAddressNumIpv4Download;
    protected int currentDatacenterId;
    private volatile int currentPortNumIpv4;
    private volatile int currentPortNumIpv4Download;
    private HashMap<Integer, DataCenter> datacenters;
    public int[] defaultPorts;
    public int[] defaultPorts8888;
    private boolean disableSchedule;
    private int failedConnectionCount;
    private int isTestBackend;
    private boolean isUpdating;
    private int lastDcUpdateTime;
    public long lastGetDifferenceTime;
    private int lastInitVersion;
    private long lastIsUpdatingTime;
    private long lastOutgoingMessageId;
    public long lastPauseTime;
    private long lastPingTime;
    private AtomicInteger lastRequestToken;
    private long lastSocketPingTime;
    private int lastUWUpdateTime;
    private int messageSeqNo;
    private long nextPingId;
    private int nextSleepTimeout;
    private long nextSocketPingId;
    public int overridePort;
    private boolean paused;
    public boolean pingOK;
    public HashMap<String, Integer> ports;
    private HashMap<Integer, ArrayList<Long>> quickAckIdToRequestIds;
    private boolean refreshingToken;
    private long refreshingTokenTime;
    private ArrayList<Integer> requestInvalid;
    private ConcurrentLinkedQueue<RPCRequest> requestQueue;
    private ConcurrentHashMap<Long, Integer> requestsByClass;
    private ConcurrentHashMap<Integer, ArrayList<Long>> requestsByGuids;
    private ConcurrentLinkedQueue<RPCRequest> runningRequests;
    public int socketSessionId;
    public int socketconnectionState;
    private Runnable stageRunnable;
    private int timeDifference;
    private ExecutorService transportService;
    private boolean updatingDcSettings;
    private int updatingDcStartTime;
    private boolean updatingUWList;
    private int updatingUWStartTime;
    private PowerManager.WakeLock wakeLock;
    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static ThreadLocal<HashMap<String, ?>> dnsCache = new ThreadLocal<HashMap<String, ?>>() { // from class: ir.eitaa.tgnet.ConnectionsManager.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public HashMap<String, ?> initialValue() {
            return new HashMap<>();
        }
    };
    private static int lastClassGuid = 1;
    private static volatile ConnectionsManager[] Instance = new ConnectionsManager[3];

    public static void getHostByName(String hostName, long address) {
    }

    public static int getInitFlags() {
        return 0;
    }

    public static native void native_applyDatacenterAddress(int currentAccount, int datacenterId, String ipAddress, int port);

    public static native void native_applyDnsConfig(int currentAccount, long address, String phone, int date);

    public static native void native_bindRequestToGuid(int currentAccount, int requestToken, int guid);

    public static native void native_cancelRequest(int currentAccount, int token, boolean notifyServer);

    public static native void native_cancelRequestsForGuid(int currentAccount, int guid);

    public static native long native_checkProxy(int currentAccount, String address, int port, String username, String password, String secret, RequestTimeDelegate requestTimeDelegate);

    public static native void native_cleanUp(int currentAccount, boolean resetKeys);

    public static native int native_getConnectionState(int currentAccount);

    public static native int native_getCurrentDatacenterId(int currentAccount);

    public static native int native_getCurrentTime(int currentAccount);

    public static native long native_getCurrentTimeMillis(int currentAccount);

    public static native int native_getTimeDifference(int currentAccount);

    public static native void native_init(int currentAccount, int version, int layer, int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, String systemLangCode, String configPath, String logPath, String regId, String cFingerprint, String installer, String packageId, int timezoneOffset, long userId, boolean enablePushConnection, boolean hasNetwork, int networkType);

    public static native int native_isTestBackend(int currentAccount);

    public static native void native_onHostNameResolved(String host, long address, String ip);

    public static native void native_pauseNetwork(int currentAccount);

    public static native void native_resumeNetwork(int currentAccount, boolean partial);

    public static native void native_seSystemLangCode(int currentAccount, String langCode);

    public static native void native_sendRequest(int currentAccount, long object, RequestDelegateInternal onComplete, QuickAckDelegate onQuickAck, WriteToSocketDelegate onWriteToSocket, int flags, int datacenterId, int connetionType, boolean immediate, int requestToken);

    public static native void native_setIpStrategy(int currentAccount, byte value);

    public static native void native_setJava(boolean useJavaByteBuffers);

    public static native void native_setLangCode(int currentAccount, String langCode);

    public static native void native_setNetworkAvailable(int currentAccount, boolean value, int networkType, boolean slow);

    public static native void native_setProxySettings(int currentAccount, String address, int port, String username, String password, String secret);

    public static native void native_setPushConnectionEnabled(int currentAccount, boolean value);

    public static native void native_setRegId(int currentAccount, String regId);

    public static native void native_setSystemLangCode(int currentAccount, String langCode);

    public static native void native_setUserId(int currentAccount, long id);

    public static native void native_switchBackend(int currentAccount, boolean restart);

    public static native void native_updateDcSettings(int currentAccount);

    public static void onRequestNewServerIpAndPort(int second, int currentAccount) {
    }

    protected static boolean useIpv6Address() {
        return false;
    }

    public void applyCountryPortNumber(String number) {
    }

    public void applyDatacenterAddress(int datacenterId, String ipAddress, int port) {
    }

    public String getServerURL() {
        return "/eitaa/index.php";
    }

    public void setPushConnectionEnabled(boolean value) {
    }

    public void setUserId(long id) {
    }

    public void tcpConnectionQuiackAckReceived(TcpConnection connection, int ack) {
    }

    @Override // ir.eitaa.tgnet.TcpConnection.TcpConnectionDelegate
    public void tcpConnectionClosed(TcpConnection connection) throws IOException {
        int i = 0;
        if (connection.getDatacenterId() == this.currentDatacenterId && (connection.transportRequestClass & 64) != 0) {
            if (isNetworkOnline()) {
                this.socketconnectionState = 1;
            } else {
                this.socketconnectionState = 2;
            }
            if (BuildVars.DEBUG_VERSION) {
                try {
                    NetworkInfo[] allNetworkInfo = ((ConnectivityManager) ApplicationLoader.applicationContext.getSystemService("connectivity")).getAllNetworkInfo();
                    while (i < 2 && i < allNetworkInfo.length) {
                        NetworkInfo networkInfo = allNetworkInfo[i];
                        FileLog.e("tmessages - Network: " + networkInfo.getTypeName() + " status: " + networkInfo.getState() + " info: " + networkInfo.getExtraInfo() + " object: " + networkInfo.getDetailedState() + " other: " + networkInfo);
                        i++;
                    }
                    if (allNetworkInfo.length == 0) {
                        FileLog.e("tmessages -  no network available");
                    }
                } catch (Exception e) {
                    FileLog.e("tmessages - NETWORK STATE GET ERROR", e);
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.1
                @Override // java.lang.Runnable
                public void run() {
                }
            });
            return;
        }
        if ((connection.transportRequestClass & 8) != 0) {
            FileLog.e("tmessages - push connection closed");
            if (BuildVars.DEBUG_VERSION) {
                try {
                    NetworkInfo[] allNetworkInfo2 = ((ConnectivityManager) ApplicationLoader.applicationContext.getSystemService("connectivity")).getAllNetworkInfo();
                    while (i < 2 && i < allNetworkInfo2.length) {
                        NetworkInfo networkInfo2 = allNetworkInfo2[i];
                        FileLog.e("tmessages - Network: " + networkInfo2.getTypeName() + " status: " + networkInfo2.getState() + " info: " + networkInfo2.getExtraInfo() + " object: " + networkInfo2.getDetailedState() + " other: " + networkInfo2);
                        i++;
                    }
                    if (allNetworkInfo2.length == 0) {
                        FileLog.e("tmessages -  no network available");
                    }
                } catch (Exception e2) {
                    FileLog.e("tmessages - NETWORK STATE GET ERROR", e2);
                }
            }
        }
    }

    @Override // ir.eitaa.tgnet.TcpConnection.TcpConnectionDelegate
    public void tcpConnectionConnected(TcpConnection connection) {
        this.nextSocketPingId = 0L;
        DataCenter dataCenterDatacenterWithId = datacenterWithId(this.currentDatacenterId);
        if (dataCenterDatacenterWithId != null) {
            generatePing(dataCenterDatacenterWithId, false);
        }
    }

    @Override // ir.eitaa.tgnet.TcpConnection.TcpConnectionDelegate
    public void tcpConnectionReceivedData(TcpConnection connection, NativeByteBuffer data, int length) throws InterruptedException, IOException {
        int i;
        if (connection.getDatacenterId() == this.currentDatacenterId && (connection.transportRequestClass & 64) != 0 && ((i = this.socketconnectionState) == 1 || i == 2)) {
            this.socketconnectionState = 3;
        }
        if (length == 4) {
            FileLog.e("tmessages - mtproto error = " + data.readInt32(false));
            connection.suspendConnection(true);
            connection.connect();
            return;
        }
        datacenterWithId(connection.getDatacenterId());
        data.readInt64(true);
        data.readInt64(true);
        long int64 = data.readInt64(true);
        data.readInt32(true);
        data.readInt32(true);
        RPCRequest rPCRequestWithMessageId = getRPCRequestWithMessageId(int64);
        if (connection.isMessageIdProcessed(int64)) {
            return;
        }
        if (rPCRequestWithMessageId == null) {
            onUnparsedMessageReceived(data, this.currentAccount);
            return;
        }
        if (!rPCRequestWithMessageId.responseReceived.compareAndSet(false, true)) {
            FileLog.w(rPCRequestWithMessageId.rawRequest + " response has been received in another request, ignore the response ");
            return;
        }
        onConnectionDataReceived(rPCRequestWithMessageId, data);
    }

    private RPCRequest getRPCRequestWithMessageId(long msgId) {
        Iterator<RPCRequest> it = this.runningRequests.iterator();
        while (it.hasNext()) {
            RPCRequest next = it.next();
            if (msgId == next.messageId) {
                return next;
            }
        }
        return null;
    }

    public static ConnectionsManager getInstance(int num) {
        ConnectionsManager connectionsManager = Instance[num];
        if (connectionsManager == null) {
            synchronized (ConnectionsManager.class) {
                connectionsManager = Instance[num];
                if (connectionsManager == null) {
                    ConnectionsManager[] connectionsManagerArr = Instance;
                    ConnectionsManager connectionsManager2 = new ConnectionsManager(num);
                    connectionsManagerArr[num] = connectionsManager2;
                    connectionsManager = connectionsManager2;
                }
            }
        }
        return connectionsManager;
    }

    public ConnectionsManager(int instance) throws InterruptedException, PackageManager.NameNotFoundException, IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String lowerCase;
        super(instance);
        this.updatingDcSettings = false;
        this.updatingDcStartTime = 0;
        this.lastDcUpdateTime = 0;
        this.lastUWUpdateTime = 0;
        this.updatingUWStartTime = 0;
        this.updatingUWList = false;
        this.isTestBackend = 0;
        this.lastPauseTime = getCurrentTimeMillis();
        this.appPaused = true;
        this.disableSchedule = false;
        this.isUpdating = false;
        this.lastIsUpdatingTime = 0L;
        this.connectionState = 2;
        this.socketconnectionState = 1;
        this.lastRequestToken = new AtomicInteger(1);
        this.wakeLock = null;
        this.datacenters = new HashMap<>();
        this.quickAckIdToRequestIds = new HashMap<>();
        this.requestsByGuids = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.requestsByClass = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.requestQueue = new ConcurrentLinkedQueue<>();
        this.runningRequests = new ConcurrentLinkedQueue<>();
        this.requestInvalid = new ArrayList<>();
        this.connectionToken = 1;
        this.timeDifference = 0;
        this.paused = false;
        this.nextSleepTimeout = 30000;
        this.lastInitVersion = 0;
        this.lastOutgoingMessageId = 0L;
        this.nextPingId = 0L;
        this.nextSocketPingId = 0L;
        this.lastPingTime = getCurrentTimeMillis();
        this.lastSocketPingTime = getCurrentTimeMillis();
        this.lastGetDifferenceTime = 0L;
        this.pingOK = true;
        this.addressesIpv4 = new ArrayList<>();
        this.addressesIpv4Download = new ArrayList<>();
        this.ports = new HashMap<>();
        this.defaultPorts = new int[]{443};
        this.defaultPorts8888 = new int[]{443};
        this.currentPortNumIpv4 = 0;
        this.currentAddressNumIpv4 = 0;
        this.currentPortNumIpv4Download = 0;
        this.currentAddressNumIpv4Download = 0;
        this.overridePort = -1;
        this.socketSessionId = 0;
        this.refreshingToken = false;
        this.transportService = Executors.newCachedThreadPool();
        this.stageRunnable = new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.3
            @Override // java.lang.Runnable
            public void run() throws InterruptedException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException {
                boolean z;
                Utilities.stageQueue.handler.removeCallbacks(ConnectionsManager.this.stageRunnable);
                if (UserConfig.getInstance(ConnectionsManager.this.currentAccount).isClientActivated() && !ConnectionsManager.this.disableSchedule) {
                    long currentTimeMillis = ConnectionsManager.this.getCurrentTimeMillis();
                    long j = ConnectionsManager.this.lastPauseTime;
                    if (j != 0 && j < currentTimeMillis - r2.nextSleepTimeout) {
                        Iterator it = ConnectionsManager.this.runningRequests.iterator();
                        while (it.hasNext()) {
                            RPCRequest rPCRequest = (RPCRequest) it.next();
                            if (rPCRequest.retryCount < 10 && rPCRequest.startTime + 60 > ((int) (currentTimeMillis / 1000))) {
                                int i = rPCRequest.connectionType;
                                if ((i & 2) != 0 || (i & 4) != 0) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            Iterator it2 = ConnectionsManager.this.requestQueue.iterator();
                            while (it2.hasNext()) {
                                int i2 = ((RPCRequest) it2.next()).connectionType;
                                if ((i2 & 2) != 0 || (i2 & 4) != 0) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        if (!z) {
                            if (!ConnectionsManager.this.paused) {
                                FileLog.w("pausing network and timers by sleep time = " + ConnectionsManager.this.nextSleepTimeout);
                                ConnectionsManager.this.suspendConnections();
                            }
                            try {
                                ConnectionsManager.this.paused = true;
                                Utilities.stageQueue.postRunnable(ConnectionsManager.this.stageRunnable, 1000L);
                                return;
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        } else {
                            ConnectionsManager.this.lastPauseTime += 30000;
                            FileLog.w("don't sleep 30 seconds because of salt, upload or download request");
                        }
                    }
                    if (ConnectionsManager.this.paused) {
                        ConnectionsManager.this.paused = false;
                        FileLog.w("resume network and timers");
                    }
                    if (!ConnectionsManager.isNetworkOnline()) {
                        ConnectionsManager.onConnectionStateChanged(2, ConnectionsManager.this.currentAccount);
                    } else {
                        if (ConnectionsManager.this.lastPingTime < System.currentTimeMillis() - 19000) {
                            ConnectionsManager connectionsManager = ConnectionsManager.this;
                            connectionsManager.lastPingTime = connectionsManager.getCurrentTimeMillis();
                            ConnectionsManager.this.generatePing();
                        }
                        if (ConnectionsManager.this.lastSocketPingTime < System.currentTimeMillis() - 19000) {
                            ConnectionsManager connectionsManager2 = ConnectionsManager.this;
                            DataCenter dataCenterDatacenterWithId = connectionsManager2.datacenterWithId(connectionsManager2.currentDatacenterId);
                            if (dataCenterDatacenterWithId != null) {
                                ConnectionsManager.this.generatePing(dataCenterDatacenterWithId, false);
                            }
                        }
                        if (ConnectionsManager.this.getPingStatus()) {
                            if (!ConnectionsManager.this.appPaused && ConnectionsManager.this.lastGetDifferenceTime < System.currentTimeMillis() - MessagesController.getInstance(ConnectionsManager.this.currentAccount).schedule_period_forground_ms) {
                                if (!BuildVars.DEBUG_PRIVATE_VERSION) {
                                    MessagesController.getInstance(ConnectionsManager.this.currentAccount).getDifference();
                                }
                                ConnectionsManager connectionsManager3 = ConnectionsManager.this;
                                connectionsManager3.lastGetDifferenceTime = connectionsManager3.getCurrentTimeMillis();
                            }
                            if (!ConnectionsManager.this.updatingDcSettings && ConnectionsManager.this.lastDcUpdateTime < ((int) (System.currentTimeMillis() / 1000)) - 3600) {
                                ConnectionsManager.this.updateDcSettings();
                            }
                            MessagesController.getInstance(ConnectionsManager.this.currentAccount).updateTimerProc();
                            ConnectionsManager.this.processRequestQueue(0, 0);
                            if (ConnectionsManager.this.updatingUWList || ConnectionsManager.this.lastUWUpdateTime >= ((int) (System.currentTimeMillis() / 1000)) - ConnectionsManager.UW_UPDATE_TIME) {
                                if (!MessagesController.getInstance(ConnectionsManager.this.currentAccount).isUrlWhiteListLoaded) {
                                    MessagesController.getInstance(ConnectionsManager.this.currentAccount).loadUrlWhiteList();
                                }
                            } else {
                                ConnectionsManager.this.updateUrlWhiteList();
                            }
                        } else {
                            ConnectionsManager.onConnectionStateChanged(1, ConnectionsManager.this.currentAccount);
                        }
                    }
                    Utilities.stageQueue.postRunnable(ConnectionsManager.this.stageRunnable, ConnectionsManager.this.appPaused ? 19000L : 1000L);
                }
            }
        };
        this.currentAccount = instance;
        this.messageSeqNo = 0;
        this.lastOutgoingMessageId = 0L;
        if (!isNetworkOnline()) {
            this.connectionState = 1;
        }
        UserConfig.getInstance(this.currentAccount).loadConfig();
        loadSession();
        Utilities.stageQueue.postRunnable(this.stageRunnable, 1000L);
        try {
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).newWakeLock(1, "eitaa:lock");
            this.wakeLock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.connectionState = native_getConnectionState(this.currentAccount);
        File filesDirFixed = ApplicationLoader.getFilesDirFixed();
        if (instance != 0) {
            File file = new File(filesDirFixed, "account" + instance);
            file.mkdirs();
            filesDirFixed = file;
        }
        String string = filesDirFixed.toString();
        boolean zIsPushConnectionEnabled = isPushConnectionEnabled();
        try {
            lowerCase = LocaleController.getSystemLocaleStringIso639().toLowerCase();
            String lowerCase2 = LocaleController.getLocaleStringIso639().toLowerCase();
            str4 = Build.MANUFACTURER + Build.MODEL;
            PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
            str3 = packageInfo.versionName + " (" + packageInfo.versionCode + ")";
            if (BuildVars.DEBUG_PRIVATE_VERSION) {
                str3 = str3 + " pbeta";
            } else if (BuildVars.DEBUG_VERSION) {
                str3 = str3 + " beta";
            }
            str = "SDK " + Build.VERSION.SDK_INT;
            str2 = lowerCase2;
        } catch (Exception unused) {
            str = "SDK " + Build.VERSION.SDK_INT;
            str2 = "";
            str3 = "App version unknown";
            str4 = "Android unknown";
            lowerCase = "en";
        }
        String str5 = lowerCase.trim().length() == 0 ? "en" : lowerCase;
        String str6 = str4.trim().length() == 0 ? "Android unknown" : str4;
        String str7 = str3.trim().length() == 0 ? "App version unknown" : str3;
        String str8 = str.trim().length() == 0 ? "SDK Unknown" : str;
        getUserConfig().loadConfig();
        String str9 = SharedConfig.pushString;
        if (TextUtils.isEmpty(str9) && !TextUtils.isEmpty(SharedConfig.pushStringStatus)) {
            str9 = SharedConfig.pushStringStatus;
        }
        String certificateSHA256Fingerprint = AndroidUtilities.getCertificateSHA256Fingerprint();
        int rawOffset = (TimeZone.getDefault().getRawOffset() + TimeZone.getDefault().getDSTSavings()) / 1000;
        generateSocketSessionId();
        init(BuildVars.BUILD_VERSION, 133, BuildVars.APP_ID, str6, str8, str7, str2, str5, string, FileLog.getNetworkLogPath(), str9, certificateSHA256Fingerprint, rawOffset, getUserConfig().getClientUserId(), zIsPushConnectionEnabled);
    }

    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    void setTimeDifference(int diff) {
        Math.abs(diff - this.timeDifference);
        this.timeDifference = diff;
    }

    public int getCurrentTime() {
        return ((int) (System.currentTimeMillis() / 1000)) + this.timeDifference;
    }

    public int getTimeDifference() {
        return this.timeDifference;
    }

    public int sendRequest(TLObject object, RequestDelegate completionBlock) {
        return sendRequest(object, completionBlock, (QuickAckDelegate) null, 0);
    }

    public int sendRequest(TLObject object, RequestDelegate completionBlock, int flags) {
        return sendRequest(object, completionBlock, null, null, flags, DEFAULT_DATACENTER_ID, 1, true);
    }

    public int sendRequest(TLObject object, RequestDelegate completionBlock, int flags, int connetionType) {
        return sendRequest(object, completionBlock, null, null, flags, DEFAULT_DATACENTER_ID, connetionType, true);
    }

    public int sendRequest(TLObject object, RequestDelegateTimestamp completionBlock, int flags, int connetionType, int datacenterId) {
        return sendRequest(object, null, completionBlock, null, null, flags, datacenterId, connetionType, true);
    }

    public int sendRequest(TLObject object, RequestDelegate completionBlock, QuickAckDelegate quickAckBlock, int flags) {
        return sendRequest(object, completionBlock, null, quickAckBlock, null, flags, DEFAULT_DATACENTER_ID, 1, true);
    }

    public int sendRequest(final TLObject object, final RequestDelegate onComplete, final QuickAckDelegate onQuickAck, final WriteToSocketDelegate onWriteToSocket, final int flags, final int datacenterId, final int connetionType, final boolean immediate) {
        return sendRequest(object, onComplete, null, onQuickAck, onWriteToSocket, flags, datacenterId, connetionType, immediate);
    }

    public int sendRequest(final TLObject object, final RequestDelegate onComplete, final RequestDelegateTimestamp onCompleteTimestamp, final QuickAckDelegate onQuickAck, final WriteToSocketDelegate onWriteToSocket, final int flags, final int datacenterId, final int connetionType, final boolean immediate) throws IOException {
        final int andIncrement = this.lastRequestToken.getAndIncrement();
        if (object == null || (!UserConfig.getInstance(this.currentAccount).isClientActivated() && (flags & 8) == 0)) {
            FileLog.w("can't do request without login " + object);
            return 0;
        }
        if (this.requestInvalid.contains(Integer.valueOf(object.getClass().hashCode()))) {
            FileLog.w("Request is in INVALID_CONSTRUCTOR." + object);
            return 0;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.4
            @Override // java.lang.Runnable
            public void run() throws IOException {
                RPCRequest rPCRequest = new RPCRequest();
                rPCRequest.token = andIncrement;
                rPCRequest.flags = flags;
                rPCRequest.connectionType = connetionType;
                rPCRequest.runningDatacenterId = datacenterId;
                TLObject tLObject = object;
                rPCRequest.rawRequest = tLObject;
                rPCRequest.rpcRequest = ConnectionsManager.this.wrapInLayer(tLObject, rPCRequest);
                rPCRequest.completionBlock = onComplete;
                rPCRequest.quickAckBlock = onQuickAck;
                ConnectionsManager.this.requestQueue.add(rPCRequest);
                if (object instanceof TLRPC$TL_updates_getDifference) {
                    FileLog.d("sendRequest getdifference: accountIndex: " + ConnectionsManager.this.currentAccount + ", immediate: " + immediate + ", isNetworkOnline: " + ConnectionsManager.isNetworkOnline() + ", pingStatus: " + ConnectionsManager.this.getPingStatus());
                }
                if (immediate && ConnectionsManager.isNetworkOnline() && ConnectionsManager.this.getPingStatus()) {
                    ConnectionsManager.this.processRequestQueue(0, 0);
                }
            }
        });
        return andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processRequestQueue(int r19, int r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.tgnet.ConnectionsManager.processRequestQueue(int, int):void");
    }

    private void sendMessagesToTransport(final RPCRequest request, final TcpConnection connection) {
        FileLog.d("accountIndex: " + this.currentAccount + "; send " + request.rawRequest + " to transport");
        this.transportService.execute(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.5
            @Override // java.lang.Runnable
            public void run() throws IOException {
                FileLog.d("accountIndex: " + ConnectionsManager.this.currentAccount + "; " + request.rawRequest + " is in transport");
                if (request.responseReceived.get()) {
                    FileLog.w(request.rawRequest + "response has been received in another request, don't send request ");
                    return;
                }
                TLRPC$TL_clientRequest tLRPC$TL_clientRequest = new TLRPC$TL_clientRequest() { // from class: ir.eitaa.tgnet.TLRPC$TL_clientRequestAPK
                    public static int constructor = 2059302894;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream, boolean exception) {
                        this.token = stream.readString(exception);
                        this.imei = stream.readString(exception);
                        int int32 = stream.readInt32(exception);
                        this.flags = int32;
                        this.isWifi = (int32 & 2) != 0;
                        this.isData = (int32 & 4) != 0;
                        this.appPause = (int32 & 8) != 0;
                        this.foregreoundConnection = (int32 & 16) != 0;
                        this.packed_data = stream.readByteArray(exception);
                        this.layer = stream.readInt32(exception);
                        this.buildVersion = stream.readInt32(exception);
                        this.lang = stream.readString(exception);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_clientRequest, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream) {
                        stream.writeInt32(constructor);
                        int i = this.isWifi ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.isData ? i | 4 : i & (-5);
                        this.flags = i2;
                        int i3 = this.appPause ? i2 | 8 : i2 & (-9);
                        this.flags = i3;
                        this.flags = this.foregreoundConnection ? i3 | 16 : i3 & (-17);
                        if (LocaleController.getInstance().getCurrentLocaleInfo() != null) {
                            if (LocaleController.getInstance().getCurrentLocaleInfo().shortName.equals("en")) {
                                this.flags |= 128;
                            } else if (LocaleController.getInstance().getCurrentLocaleInfo().shortName.equals("ar")) {
                                this.flags |= 64;
                            } else {
                                this.flags |= 32;
                            }
                        } else {
                            this.flags |= 32;
                        }
                        stream.writeString(this.token);
                        stream.writeString(this.imei);
                        stream.writeInt32(this.flags);
                        stream.writeByteArray(this.packed_data);
                        stream.writeInt32(this.layer);
                        stream.writeInt32(this.buildVersion);
                        stream.writeString(this.lang);
                    }
                };
                tLRPC$TL_clientRequest.isWifi = ConnectionsManager.isConnectedToWiFi();
                tLRPC$TL_clientRequest.isData = ConnectionsManager.isConnectedToData();
                tLRPC$TL_clientRequest.appPause = ConnectionsManager.this.getAppPaused();
                tLRPC$TL_clientRequest.buildVersion = BuildVars.BUILD_VERSION;
                tLRPC$TL_clientRequest.layer = 133;
                tLRPC$TL_clientRequest.foregreoundConnection = MessagesController.getInstance(ConnectionsManager.this.currentAccount).foregroundConnection;
                tLRPC$TL_clientRequest.imei = UserConfig.getInstance(ConnectionsManager.this.currentAccount).imei;
                tLRPC$TL_clientRequest.token = UserConfig.getInstance(ConnectionsManager.this.currentAccount).token;
                if (LocaleController.getInstance().getCurrentLocaleInfo() != null) {
                    tLRPC$TL_clientRequest.lang = LocaleController.getInstance().getCurrentLocaleInfo().shortName;
                } else {
                    tLRPC$TL_clientRequest.lang = "en";
                }
                SerializedData serializedData = new SerializedData(false);
                if ((request.flags & 8) == 0 && ConnectionsManager.this.lastInitVersion != BuildVars.BUILD_VERSION) {
                    request.rpcRequest.serializeToStream(serializedData);
                } else {
                    request.rawRequest.serializeToStream(serializedData);
                }
                try {
                    tLRPC$TL_clientRequest.packed_data = serializedData.toByteArray();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                serializedData.cleanup();
                ConnectionsManager connectionsManager = ConnectionsManager.this;
                final DataCenter dataCenterDatacenterWithId = connectionsManager.datacenterWithId(connectionsManager.currentDatacenterId);
                if ((request.flags & 8) != 0 && connection == null) {
                    HelperHttp genericConnection = dataCenterDatacenterWithId.getGenericConnection();
                    SerializedData serializedData2 = new SerializedData();
                    tLRPC$TL_clientRequest.serializeToStream(serializedData2);
                    byte[] byteArray = serializedData2.toByteArray();
                    serializedData2.cleanup();
                    ConnectionsManager.onBytesSent(byteArray.length, ConnectionsManager.getCurrentNetworkType(), ConnectionsManager.this.currentAccount);
                    final NativeByteBuffer nativeByteBufferSend = genericConnection.send(request.rawRequest, byteArray);
                    if (nativeByteBufferSend != null) {
                        ConnectionsManager.onBytesReceived(nativeByteBufferSend.buffer.remaining(), ConnectionsManager.getCurrentNetworkType(), ConnectionsManager.this.currentAccount);
                        if (!request.responseReceived.compareAndSet(false, true)) {
                            FileLog.w(request.rawRequest + " response has been received in another request, ignore the response ");
                            return;
                        }
                        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.5.2
                            @Override // java.lang.Runnable
                            public void run() throws InterruptedException, IOException {
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                ConnectionsManager.this.onConnectionDataReceived(request, nativeByteBufferSend);
                                nativeByteBufferSend.reuse();
                            }
                        });
                        return;
                    }
                    if (request.responseReceived.get()) {
                        FileLog.w(request.rawRequest + " response has been received in another request, ignore the null response ");
                        return;
                    }
                    Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.5.1
                        @Override // java.lang.Runnable
                        public void run() throws IOException {
                            dataCenterDatacenterWithId.nextAddress(0);
                            ConnectionsManager.this.tcpConnectionClosed();
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            TLObject tLObject = request.rawRequest;
                            if (!(tLObject instanceof TLRPC$TL_ping)) {
                                ConnectionsManager.this.generatePing();
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                RPCRequest rPCRequest = request;
                                if ((rPCRequest.connectionType & 1) != 0) {
                                    ConnectionsManager.this.reSendRequest(rPCRequest);
                                    return;
                                }
                                return;
                            }
                            TLRPC$TL_ping tLRPC$TL_ping = (TLRPC$TL_ping) tLObject;
                            FileLog.d("accountIndex: " + ConnectionsManager.this.currentAccount + ", " + tLRPC$TL_ping + " not successful");
                            FileLog.d("accountIndex: " + ConnectionsManager.this.currentAccount + ", " + tLRPC$TL_ping + " id = " + tLRPC$TL_ping.ping_id + ", nextPingId = " + ConnectionsManager.this.nextPingId);
                            if (tLRPC$TL_ping.ping_id >= ConnectionsManager.this.nextPingId) {
                                ConnectionsManager.this.pingOK = false;
                            }
                            FileLog.d("accountIndex: " + ConnectionsManager.this.currentAccount + ", " + tLRPC$TL_ping + "OK = " + ConnectionsManager.this.pingOK);
                        }
                    });
                    return;
                }
                TcpConnection tcpConnection = connection;
                if (tcpConnection != null) {
                    SerializedData serializedData3 = new SerializedData();
                    SerializedData serializedData4 = new SerializedData();
                    tLRPC$TL_clientRequest.serializeToStream(serializedData4);
                    serializedData3.writeInt64(UserConfig.getInstance(ConnectionsManager.this.currentAccount).getClientUserId());
                    serializedData3.writeInt64(ConnectionsManager.this.socketSessionId);
                    long jGenerateMessageId = request.messageId;
                    if (jGenerateMessageId == 0) {
                        jGenerateMessageId = ConnectionsManager.this.generateMessageId();
                    }
                    serializedData3.writeInt64(jGenerateMessageId);
                    serializedData3.writeInt32(ConnectionsManager.this.generateMessageSeqNo());
                    serializedData3.writeInt32(serializedData4.length());
                    tLRPC$TL_clientRequest.serializeToStream(serializedData3);
                    byte[] byteArray2 = serializedData3.toByteArray();
                    try {
                        NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(byteArray2.length);
                        nativeByteBuffer.writeBytes(byteArray2);
                        connection.sendData(nativeByteBuffer, true, false);
                        return;
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
                if (tcpConnection == null) {
                    final int[] iArr = {0};
                    HelperHttp genericConnection2 = dataCenterDatacenterWithId.getGenericConnection();
                    int i = request.connectionType;
                    if ((i & 2) != 0 || (i & ConnectionsManager.ConnectionTypeDownload2) != 0) {
                        iArr[0] = 2;
                        genericConnection2 = dataCenterDatacenterWithId.getDownloadConnection();
                    }
                    RPCRequest rPCRequest = request;
                    TLObject tLObject = rPCRequest.rawRequest;
                    if ((tLObject instanceof TLRPC$TL_messages_sendMedia) || (tLObject instanceof TLRPC$TL_channels_editPhoto) || (tLObject instanceof TLRPC$TL_messages_editChatPhoto) || (tLObject instanceof TLRPC$TL_photos_uploadProfilePhoto) || (tLObject instanceof TLRPC$TL_messages_uploadMedia) || (((tLObject instanceof TLRPC$TL_messages_editMessage) && ((TLRPC$TL_messages_editMessage) tLObject).media != null && (((TLRPC$TL_messages_editMessage) tLObject).flags & 16384) != 0) || (rPCRequest.connectionType & 4) != 0)) {
                        iArr[0] = 4;
                        genericConnection2 = dataCenterDatacenterWithId.getUploadConnection();
                    }
                    SerializedData serializedData5 = new SerializedData();
                    tLRPC$TL_clientRequest.serializeToStream(serializedData5);
                    byte[] byteArray3 = serializedData5.toByteArray();
                    serializedData5.cleanup();
                    ConnectionsManager.onBytesSent(byteArray3.length, ConnectionsManager.getCurrentNetworkType(), ConnectionsManager.this.currentAccount);
                    FileLog.d("accountIndex: " + ConnectionsManager.this.currentAccount + "; " + request.rawRequest + " send via HelperHttp");
                    final NativeByteBuffer nativeByteBufferSend2 = genericConnection2.send(request.rawRequest, byteArray3);
                    if (nativeByteBufferSend2 != null) {
                        ConnectionsManager.onBytesReceived(nativeByteBufferSend2.buffer.remaining(), ConnectionsManager.getCurrentNetworkType(), ConnectionsManager.this.currentAccount);
                        if (!request.responseReceived.compareAndSet(false, true)) {
                            FileLog.w(request.rawRequest + " response has been received in another request, ignore the response ");
                            return;
                        }
                        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.5.4
                            @Override // java.lang.Runnable
                            public void run() throws InterruptedException, IOException {
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                ConnectionsManager.this.onConnectionDataReceived(request, nativeByteBufferSend2);
                                nativeByteBufferSend2.reuse();
                            }
                        });
                        return;
                    }
                    if (request.responseReceived.get()) {
                        FileLog.w(request.rawRequest + " response has been received in another request, ignore the null response ");
                        return;
                    }
                    Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.5.3
                        @Override // java.lang.Runnable
                        public void run() throws IOException {
                            dataCenterDatacenterWithId.nextAddress(iArr[0]);
                            if (iArr[0] == 0) {
                                ConnectionsManager.this.tcpConnectionClosed();
                            }
                            ConnectionsManager.this.generatePing();
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            ConnectionsManager.this.reSendRequest(request);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendRequest(RPCRequest request) {
        if (this.runningRequests.remove(request)) {
            FileLog.d("resendRequest: " + request.rawRequest);
            request.connectionToken = 0;
            request.retryCount = request.retryCount + 1;
            this.requestQueue.add(request);
        }
    }

    public long generateMessageId() {
        double dCurrentTimeMillis = System.currentTimeMillis();
        double d = this.timeDifference;
        Double.isNaN(d);
        Double.isNaN(dCurrentTimeMillis);
        long j = (long) (((dCurrentTimeMillis + (d * 1000.0d)) * 4.294967296E9d) / 1000.0d);
        long j2 = this.lastOutgoingMessageId;
        if (j <= j2) {
            j = j2 + 1;
        }
        while (j % 4 != 0) {
            j++;
        }
        this.lastOutgoingMessageId = j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TLObject wrapInLayer(TLObject object, RPCRequest request) throws PackageManager.NameNotFoundException {
        if (this.lastInitVersion == BuildVars.BUILD_VERSION || !UserConfig.getInstance(this.currentAccount).isClientActivated()) {
            return object;
        }
        request.initRequest = true;
        TLRPC$initConnection tLRPC$initConnection = new TLRPC$initConnection();
        tLRPC$initConnection.query = object;
        tLRPC$initConnection.api_id = BuildVars.APP_ID;
        try {
            String localeString = LocaleController.getInstance().getLocaleString(LocaleController.getInstance().getSystemDefaultLocale());
            tLRPC$initConnection.lang_code = localeString;
            if (localeString.length() == 0) {
                tLRPC$initConnection.lang_code = "en";
            }
            tLRPC$initConnection.device_model = Build.MANUFACTURER + Build.MODEL;
            PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
            tLRPC$initConnection.app_version = packageInfo.versionName + " (" + packageInfo.versionCode + ")";
            StringBuilder sb = new StringBuilder();
            sb.append("SDK ");
            sb.append(Build.VERSION.SDK_INT);
            tLRPC$initConnection.system_version = sb.toString();
        } catch (Exception e) {
            FileLog.e(e);
            tLRPC$initConnection.lang_code = "en";
            tLRPC$initConnection.device_model = "Android unknown";
            tLRPC$initConnection.app_version = "App version unknown";
            tLRPC$initConnection.system_version = "SDK " + Build.VERSION.SDK_INT;
        }
        String str = tLRPC$initConnection.lang_code;
        if (str == null || str.length() == 0) {
            tLRPC$initConnection.lang_code = "en";
        }
        String str2 = tLRPC$initConnection.device_model;
        if (str2 == null || str2.length() == 0) {
            tLRPC$initConnection.device_model = "Android unknown";
        }
        String str3 = tLRPC$initConnection.app_version;
        if (str3 == null || str3.length() == 0) {
            tLRPC$initConnection.app_version = "App version unknown";
        }
        String str4 = tLRPC$initConnection.system_version;
        if (str4 == null || str4.length() == 0) {
            tLRPC$initConnection.system_version = "SDK Unknown";
        }
        TLRPC$invokeWithLayer tLRPC$invokeWithLayer = new TLRPC$invokeWithLayer();
        tLRPC$invokeWithLayer.query = tLRPC$initConnection;
        FileLog.d("" + object);
        return tLRPC$invokeWithLayer;
    }

    public void cancelRequest(long token, boolean notifyServer) {
        cancelRpc(token, false);
    }

    private void cancelRpc(final long token, final boolean ifNotSent) {
        if (token == 0) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.6
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                boolean z2;
                Iterator it = ConnectionsManager.this.requestQueue.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    RPCRequest rPCRequest = (RPCRequest) it.next();
                    if (rPCRequest.token == token) {
                        rPCRequest.cancelled = true;
                        FileLog.d("===== Cancelled queued rpc request " + rPCRequest.rawRequest);
                        ConnectionsManager.this.requestQueue.remove(rPCRequest);
                        z2 = true;
                        break;
                    }
                }
                if (ifNotSent) {
                    return;
                }
                Iterator it2 = ConnectionsManager.this.runningRequests.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = z2;
                        break;
                    }
                    RPCRequest rPCRequest2 = (RPCRequest) it2.next();
                    if (rPCRequest2.token == token) {
                        FileLog.d("===== Cancelled running rpc request " + rPCRequest2.rawRequest);
                        rPCRequest2.cancelled = true;
                        rPCRequest2.rawRequest.freeResources();
                        rPCRequest2.rpcRequest.freeResources();
                        ConnectionsManager.this.runningRequests.remove(rPCRequest2);
                        break;
                    }
                }
                if (z) {
                    return;
                }
                FileLog.d("***** Warning: cancelling unknown request");
            }
        });
    }

    public void cleanup(boolean resetKeys) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.7
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ConnectionsManager.this.requestQueue.iterator();
                while (it.hasNext()) {
                    RPCRequest rPCRequest = (RPCRequest) it.next();
                    if ((rPCRequest.flags & 8) == 0) {
                        ConnectionsManager.this.requestQueue.remove(rPCRequest);
                        if (rPCRequest.completionBlock != null) {
                            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                            tLRPC$TL_error.code = -1000;
                            tLRPC$TL_error.text = "";
                            rPCRequest.completionBlock.run(null, tLRPC$TL_error);
                        }
                    }
                }
                Iterator it2 = ConnectionsManager.this.runningRequests.iterator();
                while (it2.hasNext()) {
                    RPCRequest rPCRequest2 = (RPCRequest) it2.next();
                    if ((rPCRequest2.flags & 8) == 0) {
                        ConnectionsManager.this.runningRequests.remove(rPCRequest2);
                        if (rPCRequest2.completionBlock != null) {
                            TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
                            tLRPC$TL_error2.code = -1000;
                            tLRPC$TL_error2.text = "";
                            rPCRequest2.completionBlock.run(null, tLRPC$TL_error2);
                        }
                    }
                }
                ConnectionsManager.this.quickAckIdToRequestIds.clear();
                ConnectionsManager.this.saveSession();
            }
        });
    }

    public void cancelRequestsForGuid(int guid) {
        ArrayList arrayList = (ArrayList) this.requestsByGuids.get(Integer.valueOf(guid));
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                cancelRequest(((Long) arrayList.get(i)).longValue(), true);
            }
            this.requestsByGuids.remove(Integer.valueOf(guid));
        }
    }

    public void bindRequestToGuid(final int request, final int guid) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.8
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = (ArrayList) ConnectionsManager.this.requestsByGuids.get(Integer.valueOf(guid));
                if (arrayList != null) {
                    arrayList.add(Long.valueOf(request));
                    ConnectionsManager.this.requestsByClass.put(Long.valueOf(request), Integer.valueOf(guid));
                }
            }
        });
    }

    public int getConnectionState() {
        if (this.connectionState == 3 && this.isUpdating && System.currentTimeMillis() > this.lastIsUpdatingTime + (MessagesController.getInstance(this.currentAccount).schedule_period_forground_ms * 4)) {
            return 4;
        }
        return this.connectionState;
    }

    public void checkConnection() {
        if (isNetworkOnline()) {
            this.disableSchedule = false;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.9
                @Override // java.lang.Runnable
                public void run() throws IOException {
                    ConnectionsManager.this.generatePing();
                    ConnectionsManager connectionsManager = ConnectionsManager.this;
                    DataCenter dataCenterDatacenterWithId = connectionsManager.datacenterWithId(connectionsManager.currentDatacenterId);
                    if (dataCenterDatacenterWithId.tcpConnection != null) {
                        ConnectionsManager.this.generatePing(dataCenterDatacenterWithId, false);
                    }
                }
            });
            Utilities.stageQueue.postRunnable(this.stageRunnable, 1000L);
            if (this.appPaused) {
                FileLog.w("accountIndex: " + this.currentAccount + ", scheduleGetDifference from checkConnection");
                ScheduleController.getInstance(this.currentAccount).scheduleGetDifference(true, true);
                return;
            }
            return;
        }
        this.disableSchedule = true;
        onConnectionStateChanged(2, this.currentAccount);
    }

    public void init(int version, int layer, int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, String systemLangCode, String configPath, String logPath, String regId, String cFingerprint, int timezoneOffset, long userId, boolean enablePushConnection) throws IOException {
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
        String string = sharedPreferences.getString("proxy_ip", "");
        String string2 = sharedPreferences.getString("proxy_user", "");
        String string3 = sharedPreferences.getString("proxy_pass", "");
        String string4 = sharedPreferences.getString("proxy_secret", "");
        int i = sharedPreferences.getInt("proxy_port", 1080);
        if (sharedPreferences.getBoolean("proxy_enabled", false) && !TextUtils.isEmpty(string)) {
            native_setProxySettings(this.currentAccount, string, i, string2, string3, string4);
        }
        try {
            ApplicationLoader.applicationContext.getPackageManager().getInstallerPackageName(ApplicationLoader.applicationContext.getPackageName());
        } catch (Throwable unused) {
        }
        checkConnection();
        ApplicationLoader.applicationContext.registerReceiver(new BroadcastReceiver() { // from class: ir.eitaa.tgnet.ConnectionsManager.10
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) throws IOException {
                String str;
                FileLog.w("accountIndex: " + ConnectionsManager.this.currentAccount + ", networkStateReceiver onReceive");
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                NetworkInfo networkInfo2 = (NetworkInfo) intent.getParcelableExtra("otherNetwork");
                String stringExtra = intent.getStringExtra("reason");
                boolean booleanExtra2 = intent.getBooleanExtra("isFailover", false);
                StringBuilder sb = new StringBuilder();
                sb.append("accountIndex: ");
                sb.append(ConnectionsManager.this.currentAccount);
                sb.append(", onReceive(): mNetworkInfo=");
                sb.append(networkInfo);
                sb.append(" ,mOtherNetworkInfo = ");
                if (networkInfo2 == null) {
                    str = "[none]";
                } else {
                    str = networkInfo2 + ", noConn=" + booleanExtra + ", reason: " + stringExtra + ", failOver: " + booleanExtra2;
                }
                sb.append(str);
                FileLog.d(sb.toString());
                ConnectionsManager.this.checkConnection();
                FileLoader.getInstance(ConnectionsManager.this.currentAccount).onNetworkChanged(ConnectionsManager.isConnectionSlow());
            }
        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        FileLog.w("ConnectionsManager initialized, appPaused: " + this.appPaused);
        TLRPC$TL_SendAppInfo tLRPC$TL_SendAppInfo = new TLRPC$TL_SendAppInfo();
        tLRPC$TL_SendAppInfo.app_info = ApplicationLoader.getAppInfo();
        sendRequest(tLRPC$TL_SendAppInfo, null);
    }

    public void switchBackend(boolean b) throws IOException {
        if (this.isTestBackend == 0) {
            this.isTestBackend = 1;
        } else {
            this.isTestBackend = 0;
        }
        this.datacenters.clear();
        this.ports.clear();
        this.addressesIpv4.clear();
        this.addressesIpv4Download.clear();
        fillDatacenters();
        saveSession();
        UserConfig.switchBackEnd = Boolean.valueOf(this.isTestBackend == 1);
        UserConfig.getInstance(this.currentAccount).saveConfig(true);
        Toast.makeText(ApplicationLoader.applicationContext, ((Object) getHostName()) + " : " + UserConfig.switchBackEnd, 0).show();
        StringBuilder sb = new StringBuilder();
        sb.append("switchBackend to: ");
        sb.append((Object) getHostName());
        FileLog.w(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeNetworkInternal(boolean partial) throws IOException {
        if (partial) {
            if (this.paused) {
                this.lastPauseTime = getCurrentTimeMillis();
                this.nextSleepTimeout = 30000;
                this.paused = false;
                FileLog.w("wakeup network in background");
                return;
            }
            if (this.lastPauseTime != 0) {
                this.lastPauseTime = getCurrentTimeMillis();
                this.paused = false;
                FileLog.w("reset sleep timeout");
                return;
            }
            return;
        }
        this.lastPauseTime = 0L;
        this.paused = false;
    }

    public void resumeNetworkMaybe() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.11
            @Override // java.lang.Runnable
            public void run() throws IOException {
                ConnectionsManager.this.resumeNetworkInternal(true);
            }
        });
    }

    public void pauseNetwork() {
        if (this.lastPauseTime != 0) {
            return;
        }
        this.lastPauseTime = getCurrentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillDatacenters() {
        if (this.datacenters.size() == 0) {
            if (this.isTestBackend == 0) {
                DataCenter dataCenter = new DataCenter(1);
                this.datacenters.put(Integer.valueOf(dataCenter.datacenterId), dataCenter);
                ArrayList arrayList = new ArrayList();
                arrayList.add("alzheimer.eitaa.com");
                arrayList.add("fateme.eitaa.com");
                Collections.shuffle(arrayList);
                dataCenter.addAddressAndPort((String) arrayList.get(0), 443, 4);
                dataCenter.addAddressAndPort((String) arrayList.get(1), 443, 4);
                arrayList.clear();
                arrayList.add("ghasem.eitaa.com");
                arrayList.add("mohsen.eitaa.com");
                arrayList.add("hossein.eitaa.com");
                arrayList.add("ghasem.eitaa.ir");
                arrayList.add("mohsen.eitaa.ir");
                arrayList.add("hossein.eitaa.ir");
                Collections.shuffle(arrayList);
                dataCenter.addAddressAndPort((String) arrayList.get(0), 443, 2);
                dataCenter.addAddressAndPort((String) arrayList.get(1), 443, 2);
                dataCenter.addAddressAndPort((String) arrayList.get(2), 443, 2);
                dataCenter.addAddressAndPort((String) arrayList.get(3), 443, 2);
                dataCenter.addAddressAndPort((String) arrayList.get(4), 443, 2);
                dataCenter.addAddressAndPort((String) arrayList.get(5), 443, 2);
                arrayList.clear();
                arrayList.add("armita.eitaa.com");
                arrayList.add("majid.eitaa.com");
                arrayList.add("mostafa.eitaa.com");
                arrayList.add("alireza.eitaa.com");
                arrayList.add("hosna.eitaa.com");
                Collections.shuffle(arrayList);
                dataCenter.addAddressAndPort((String) arrayList.get(0), 443, 0);
                dataCenter.addAddressAndPort((String) arrayList.get(1), 443, 0);
                dataCenter.addAddressAndPort((String) arrayList.get(2), 443, 0);
                dataCenter.addAddressAndPort((String) arrayList.get(3), 443, 0);
                dataCenter.addAddressAndPort((String) arrayList.get(4), 443, 0);
                arrayList.clear();
                arrayList.add("armita.eitaa.ir");
                arrayList.add("majid.eitaa.ir");
                arrayList.add("mostafa.eitaa.ir");
                arrayList.add("alireza.eitaa.ir");
                arrayList.add("hosna.eitaa.ir");
                Collections.shuffle(arrayList);
                dataCenter.addAddressAndPort((String) arrayList.get(0), 443, 0);
                dataCenter.addAddressAndPort((String) arrayList.get(1), 443, 0);
                dataCenter.addAddressAndPort((String) arrayList.get(2), 443, 0);
                dataCenter.addAddressAndPort((String) arrayList.get(3), 443, 0);
                dataCenter.addAddressAndPort((String) arrayList.get(4), 443, 0);
                arrayList.clear();
                return;
            }
            DataCenter dataCenter2 = new DataCenter(1);
            this.datacenters.put(Integer.valueOf(dataCenter2.datacenterId), dataCenter2);
            dataCenter2.addAddressAndPort("dev.eitaa.com", 443, 0);
            dataCenter2.addAddressAndPort("dev.eitaa.com", 443, 2);
            dataCenter2.addAddressAndPort("dev.eitaa.com", 443, 4);
        }
    }

    public DataCenter datacenterWithId(int datacenterId) {
        if (datacenterId == Integer.MAX_VALUE) {
            return this.datacenters.get(Integer.valueOf(this.currentDatacenterId));
        }
        return this.datacenters.get(Integer.valueOf(datacenterId));
    }

    public void updateDcSettings() {
        if (this.updatingDcSettings) {
            return;
        }
        this.updatingDcStartTime = (int) (System.currentTimeMillis() / 1000);
        this.updatingDcSettings = true;
        TLRPC$TL_help_getConfig tLRPC$TL_help_getConfig = new TLRPC$TL_help_getConfig();
        tLRPC$TL_help_getConfig.user_id = (int) UserConfig.getInstance(this.currentAccount).getClientUserId();
        tLRPC$TL_help_getConfig.appInfo = ApplicationLoader.getAppInfo();
        getInstance(this.currentAccount).sendRequest(tLRPC$TL_help_getConfig, new RequestDelegate() { // from class: ir.eitaa.tgnet.ConnectionsManager.12
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(TLObject response, TLRPC$TL_error error) throws IOException {
                if (ConnectionsManager.this.updatingDcSettings) {
                    if (error == null) {
                        TLRPC$TL_config tLRPC$TL_config = (TLRPC$TL_config) response;
                        int currentTime = tLRPC$TL_config.expires - ConnectionsManager.this.getCurrentTime();
                        if (currentTime <= 0) {
                            currentTime = R.styleable.AppCompatTheme_windowNoTitle;
                        }
                        ConnectionsManager.this.lastDcUpdateTime = (((int) (System.currentTimeMillis() / 1000)) - 3600) + currentTime;
                        ArrayList arrayList = new ArrayList();
                        HashMap map = new HashMap();
                        for (int i = 0; i < tLRPC$TL_config.dc_options.size(); i++) {
                            TLRPC$TL_dcOption tLRPC$TL_dcOption = tLRPC$TL_config.dc_options.get(i);
                            DataCenter dataCenter = (DataCenter) map.get(Integer.valueOf(tLRPC$TL_dcOption.id));
                            if (dataCenter == null) {
                                dataCenter = new DataCenter(tLRPC$TL_dcOption.id);
                                arrayList.add(dataCenter);
                                map.put(Integer.valueOf(dataCenter.datacenterId), dataCenter);
                            }
                            dataCenter.addAddressAndPort(tLRPC$TL_dcOption.ip_address, tLRPC$TL_dcOption.port, tLRPC$TL_dcOption.flags);
                        }
                        if (!arrayList.isEmpty()) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                DataCenter dataCenter2 = (DataCenter) arrayList.get(i2);
                                DataCenter dataCenterDatacenterWithId = ConnectionsManager.this.datacenterWithId(dataCenter2.datacenterId);
                                if (dataCenterDatacenterWithId == null) {
                                    ConnectionsManager.this.datacenters.put(Integer.valueOf(dataCenter2.datacenterId), dataCenter2);
                                } else {
                                    dataCenterDatacenterWithId.replaceAddressesAndPorts(dataCenter2.addressesIpv4, dataCenter2.ports, 0);
                                    dataCenterDatacenterWithId.replaceAddressesAndPorts(dataCenter2.addressesIpv4Download, dataCenter2.ports, 2);
                                    dataCenterDatacenterWithId.replaceAddressesAndPorts(dataCenter2.addressesIpv4Upload, dataCenter2.ports, 4);
                                    dataCenterDatacenterWithId.replaceAddressesAndPorts(dataCenter2.tcpAddressesIpv4, dataCenter2.ports, 64);
                                }
                            }
                            ConnectionsManager.this.saveSession();
                            ConnectionsManager.this.processRequestQueue(7, 0);
                        }
                        MessagesController.getInstance(ConnectionsManager.this.currentAccount).updateConfig(tLRPC$TL_config);
                    }
                    ConnectionsManager.this.updatingDcSettings = false;
                }
            }
        }, 25, 1);
    }

    public void updateUrlWhiteList() {
        if (this.updatingUWList) {
            return;
        }
        this.updatingUWStartTime = (int) (System.currentTimeMillis() / 1000);
        this.updatingUWList = true;
        getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_getUrlWhiteList
            public static int constructor = 469608672;
            public static int flags;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$TL_UrlWhiteList.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
                stream.writeInt32(flags);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.tgnet.ConnectionsManager.13
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(TLObject response, TLRPC$TL_error error) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
                if (ConnectionsManager.this.updatingUWList) {
                    if (error == null) {
                        ConnectionsManager.this.lastUWUpdateTime = (int) (System.currentTimeMillis() / 1000);
                        ConnectionsManager.this.getMessagesController().saveUrlWhiteList((TLRPC$TL_UrlWhiteList) response);
                    }
                    ConnectionsManager.this.updatingUWList = false;
                }
            }
        }, 25, 1);
    }

    private void loadSession() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.14
            @Override // java.lang.Runnable
            public void run() {
                byte[] bArrDecode;
                SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("dataconfig", 0);
                ConnectionsManager.this.isTestBackend = sharedPreferences.getInt("datacenterSetId", 0);
                UserConfig.switchBackEnd = Boolean.valueOf(ConnectionsManager.this.isTestBackend == 1);
                ConnectionsManager.this.currentDatacenterId = sharedPreferences.getInt("currentDatacenterId", 0);
                ConnectionsManager.this.timeDifference = sharedPreferences.getInt("timeDifference", 0);
                ConnectionsManager.this.lastDcUpdateTime = sharedPreferences.getInt("lastDcUpdateTime", 0);
                ConnectionsManager.this.lastUWUpdateTime = sharedPreferences.getInt("lastUWUpdateTime", 0);
                String string = sharedPreferences.getString("datacenters", null);
                if (string != null) {
                    try {
                        byte[] bArrDecode2 = Base64.decode(string, 0);
                        if (bArrDecode2 != null) {
                            SerializedData serializedData = new SerializedData(bArrDecode2);
                            DataCenter dataCenter = new DataCenter(serializedData, 0);
                            ConnectionsManager.this.datacenters.put(Integer.valueOf(dataCenter.datacenterId), dataCenter);
                            serializedData.cleanup();
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                } else {
                    try {
                        String string2 = sharedPreferences.getString("datacenters_v1", null);
                        if (string2 != null && (bArrDecode = Base64.decode(string2, 0)) != null) {
                            SerializedData serializedData2 = new SerializedData(bArrDecode);
                            int int32 = serializedData2.readInt32(false);
                            for (int i = 0; i < int32; i++) {
                                DataCenter dataCenter2 = new DataCenter(serializedData2, 1);
                                ConnectionsManager.this.datacenters.put(Integer.valueOf(dataCenter2.datacenterId), dataCenter2);
                            }
                            serializedData2.cleanup();
                        }
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }
                ConnectionsManager connectionsManager = ConnectionsManager.this;
                if (connectionsManager.currentDatacenterId != 0 && UserConfig.getInstance(connectionsManager.currentAccount).isClientActivated()) {
                    ConnectionsManager connectionsManager2 = ConnectionsManager.this;
                    if (connectionsManager2.datacenterWithId(connectionsManager2.currentDatacenterId) == null) {
                        ConnectionsManager connectionsManager3 = ConnectionsManager.this;
                        connectionsManager3.currentDatacenterId = 0;
                        connectionsManager3.datacenters.clear();
                        UserConfig.getInstance(ConnectionsManager.this.currentAccount).clearConfig();
                    }
                }
                ConnectionsManager.this.fillDatacenters();
                if (ConnectionsManager.this.datacenters.size() != 0) {
                    ConnectionsManager connectionsManager4 = ConnectionsManager.this;
                    if (connectionsManager4.currentDatacenterId == 0) {
                        connectionsManager4.currentDatacenterId = 1;
                    }
                    connectionsManager4.saveSession();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSession() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("dataconfig", 0).edit();
                    editorEdit.putInt("datacenterSetId", ConnectionsManager.this.isTestBackend);
                    ConnectionsManager connectionsManager = ConnectionsManager.this;
                    if (connectionsManager.datacenterWithId(connectionsManager.currentDatacenterId) != null) {
                        editorEdit.putInt("currentDatacenterId", ConnectionsManager.this.currentDatacenterId);
                        editorEdit.putInt("timeDifference", ConnectionsManager.this.timeDifference);
                        editorEdit.putInt("lastDcUpdateTime", ConnectionsManager.this.lastDcUpdateTime);
                        editorEdit.putInt("lastUWUpdateTime", ConnectionsManager.this.lastUWUpdateTime);
                        if (!ConnectionsManager.this.datacenters.isEmpty()) {
                            SerializedData serializedData = new SerializedData();
                            serializedData.writeInt32(ConnectionsManager.this.datacenters.size());
                            Iterator it = ConnectionsManager.this.datacenters.values().iterator();
                            while (it.hasNext()) {
                                ((DataCenter) it.next()).SerializeToStream(serializedData);
                            }
                            editorEdit.putString("datacenters_v1", Base64.encodeToString(serializedData.toByteArray(), 0));
                            serializedData.cleanup();
                        } else {
                            editorEdit.remove("datacenters_v1");
                        }
                    } else {
                        editorEdit.remove("datacenters_v1");
                        editorEdit.remove("currentDatacenterId");
                        editorEdit.remove("timeDifference");
                    }
                    editorEdit.remove("datacenters");
                    editorEdit.commit();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        });
    }

    public long getPauseTime() {
        return this.lastPauseTime;
    }

    public boolean getAppPaused() {
        return this.appPaused;
    }

    public long checkProxy(String address, int port, String username, String password, String secret, RequestTimeDelegate requestTimeDelegate) {
        if (TextUtils.isEmpty(address)) {
            return 0L;
        }
        return native_checkProxy(this.currentAccount, address == null ? "" : address, port, username == null ? "" : username, password == null ? "" : password, secret == null ? "" : secret, requestTimeDelegate);
    }

    public void setAppPaused(final boolean value, final boolean byScreenState) throws InterruptedException, IOException {
        if (!byScreenState) {
            this.appPaused = value;
            DataCenter dataCenterDatacenterWithId = datacenterWithId(this.currentDatacenterId);
            if (dataCenterDatacenterWithId != null) {
                generatePing(dataCenterDatacenterWithId, false);
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("app paused = " + value);
            }
            if (value) {
                this.appResumeCount--;
            } else {
                this.appResumeCount++;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("app resume count " + this.appResumeCount);
            }
            if (this.appResumeCount < 0) {
                this.appResumeCount = 0;
            }
        }
        if (this.appResumeCount == 0) {
            if (this.lastPauseTime == 0) {
                this.lastPauseTime = System.currentTimeMillis();
                FileLog.w("accountIndex: " + this.currentAccount + ", scheduleGetDifference from setAppPaused.");
                ScheduleController.getInstance(this.currentAccount).scheduleGetDifference(true, false);
            }
            pauseNetwork();
            return;
        }
        if (this.appPaused) {
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("reset app pause time");
        }
        ScheduleController.getInstance(this.currentAccount).scheduleGetDifference(false, false);
        Utilities.stageQueue.postRunnable(this.stageRunnable, 1000L);
        if (this.lastPauseTime != 0 && System.currentTimeMillis() - this.lastPauseTime > 5000) {
            ContactsController.getInstance(this.currentAccount).checkContacts();
        }
        this.lastPauseTime = 0L;
        resumeNetworkInternal(false);
    }

    private void onUnparsedMessageReceived(NativeByteBuffer buff, final int currentAccount) {
        try {
            buff.reused = true;
            final TLObject tLObjectTLdeserialize = TLClassStore.Instance().TLdeserialize(buff, buff.readInt32(true), true);
            if (tLObjectTLdeserialize instanceof TLRPC$Updates) {
                if (tLObjectTLdeserialize instanceof TLRPC$TL_phoneCallDiscarded) {
                    Log.i("discard", "TL_phoneCallDiscarded");
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectionsManager.getInstance(currentAccount).wakeLock.isHeld()) {
                            FileLog.d("release wakelock");
                            ConnectionsManager.getInstance(currentAccount).wakeLock.release();
                        }
                    }
                });
                Utilities.socketQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.17
                    @Override // java.lang.Runnable
                    public void run() {
                        FileLog.e("currentAccount = " + currentAccount + " -  response received  = " + tLObjectTLdeserialize.getClass().toString());
                        MessagesController.getInstance(currentAccount).processUpdates((TLRPC$Updates) tLObjectTLdeserialize, false);
                    }
                });
                return;
            }
            if (tLObjectTLdeserialize instanceof TLRPC$TL_socketPong) {
                Log.i("", "socket Log: " + currentAccount + ", received  pong: " + ((TLRPC$TL_socketPong) tLObjectTLdeserialize).ping_id);
            }
        } catch (Exception e) {
            FileLog.e("currentAccount = " + currentAccount + " --- send exception = " + e.toString());
            FileLog.e(e);
        }
    }

    public static void onUpdate(final int currentAccount) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.18
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                MessagesController.getInstance(currentAccount).updateTimerProc();
            }
        });
    }

    public static void onSessionCreated(final int currentAccount) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.19
            @Override // java.lang.Runnable
            public void run() {
                MessagesController.getInstance(currentAccount).getDifference();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onConnectionStateChanged(final int state, final int currentAccount) {
        FileLog.d("accountIndex: " + currentAccount + "; onConnectionStateChanged: " + state);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.20
            @Override // java.lang.Runnable
            public void run() {
                ConnectionsManager.getInstance(currentAccount).connectionState = state;
                NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.didUpdateConnectionState, new Object[0]);
            }
        });
    }

    private static void onLogout(final int currentAccount) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.21
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                if (UserConfig.getInstance(currentAccount).getClientUserId() != 0) {
                    UserConfig.getInstance(currentAccount).clearConfig();
                    MessagesController.getInstance(currentAccount).performLogout(0);
                }
            }
        });
    }

    public static int getCurrentNetworkType() {
        if (isConnectedOrConnectingToWiFi()) {
            return 1;
        }
        return isRoaming() ? 2 : 0;
    }

    public static void onBytesSent(int amount, int networkType, final int currentAccount) {
        try {
            StatsController.getInstance(currentAccount).incrementSentBytesCount(networkType, 6, amount);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void onBytesReceived(int amount, int networkType, final int currentAccount) {
        try {
            StatsController.getInstance(currentAccount).incrementReceivedBytesCount(networkType, 6, amount);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static boolean isConnectedOrConnectingToWiFi() {
        try {
            NetworkInfo.State state = ((ConnectivityManager) ApplicationLoader.applicationContext.getSystemService("connectivity")).getNetworkInfo(1).getState();
            if (state != NetworkInfo.State.CONNECTED && state != NetworkInfo.State.CONNECTING) {
                if (state != NetworkInfo.State.SUSPENDED) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public static void onUpdateConfig(long address, final int currentAccount) {
        try {
            NativeByteBuffer nativeByteBufferWrap = NativeByteBuffer.wrap(address);
            nativeByteBufferWrap.reused = true;
            final TLRPC$TL_config tLRPC$TL_configTLdeserialize = TLRPC$TL_config.TLdeserialize(nativeByteBufferWrap, nativeByteBufferWrap.readInt32(true), true);
            if (tLRPC$TL_configTLdeserialize != null) {
                Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.22
                    @Override // java.lang.Runnable
                    public void run() {
                        MessagesController.getInstance(currentAccount).updateConfig(tLRPC$TL_configTLdeserialize);
                    }
                });
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void onInternalPushReceived(int currentAccount) {
        KeepAliveJob.startJob();
    }

    public static void onProxyError() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.23
            @Override // java.lang.Runnable
            public void run() {
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needShowAlert, 3);
            }
        });
    }

    public static int generateClassGuid() {
        int i = lastClassGuid;
        lastClassGuid = i + 1;
        return i;
    }

    public static boolean isRoaming() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ApplicationLoader.applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isRoaming();
            }
            return false;
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public static boolean isConnectedToWiFi() {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) ApplicationLoader.applicationContext.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                return networkInfo.getState() == NetworkInfo.State.CONNECTED;
            }
            return false;
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public static boolean isConnectedToData() {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) ApplicationLoader.applicationContext.getSystemService("connectivity")).getNetworkInfo(0);
            if (networkInfo != null) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        return false;
    }

    public void setIsUpdating(final boolean value) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.24
            @Override // java.lang.Runnable
            public void run() {
                if (ConnectionsManager.this.isUpdating == value) {
                    return;
                }
                if (ConnectionsManager.this.isUpdating) {
                    ConnectionsManager.this.lastIsUpdatingTime = System.currentTimeMillis();
                }
                ConnectionsManager.this.isUpdating = value;
                if (ConnectionsManager.this.connectionState == 3) {
                    NotificationCenter.getInstance(ConnectionsManager.this.currentAccount).postNotificationName(NotificationCenter.didUpdateConnectionState, new Object[0]);
                }
            }
        });
    }

    public static boolean isNetworkOnline() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ApplicationLoader.applicationContext.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && (activeNetworkInfo.isConnectedOrConnecting() || activeNetworkInfo.isAvailable())) {
                return true;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return true;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo2 != null) {
                if (networkInfo2.isConnectedOrConnecting()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            FileLog.e(e);
            return true;
        }
    }

    long getTimeFromMsgId(long messageId) {
        double d = messageId;
        Double.isNaN(d);
        return (long) ((d / 4.294967296E9d) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRequestInClass(final Long request) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.25
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                Integer num = (Integer) ConnectionsManager.this.requestsByClass.get(request);
                if (num == null || (arrayList = (ArrayList) ConnectionsManager.this.requestsByGuids.get(num)) == null) {
                    return;
                }
                arrayList.remove(request);
            }
        });
    }

    public static boolean isConnectionSlow() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ApplicationLoader.applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() != 0) {
                return false;
            }
            int subtype = activeNetworkInfo.getSubtype();
            return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
        } catch (Throwable unused) {
            return false;
        }
    }

    protected TLObject deserialize(TLObject request, NativeByteBuffer data, boolean exception) throws IOException {
        int int32;
        try {
            int32 = data.readInt32(exception);
        } catch (Exception e) {
            FileLog.e(e);
            int32 = 0;
        }
        TLObject tLObjectDeserializeResponse = null;
        try {
            tLObjectDeserializeResponse = TLClassStore.Instance().TLdeserialize(data, int32, exception);
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        if (tLObjectDeserializeResponse == null) {
            if (request != null) {
                try {
                    tLObjectDeserializeResponse = request.deserializeResponse(data, int32, exception);
                } catch (Exception e3) {
                    FileLog.e(e3);
                }
                if (tLObjectDeserializeResponse == null) {
                    FileLog.w(String.format(Locale.US, "***** Error parsing message: %x", Integer.valueOf(int32)));
                }
            } else {
                FileLog.d(String.format(Locale.US, "***** Not found request to parse message: %x", Integer.valueOf(int32)));
            }
        }
        return tLObjectDeserializeResponse;
    }

    public TLObject deserialize(TLObject request, AbstractSerializedData data, boolean exception) throws IOException {
        int int32;
        try {
            int32 = data.readInt32(exception);
        } catch (Exception e) {
            FileLog.e(e);
            int32 = 0;
        }
        TLObject tLObjectDeserializeResponse = null;
        try {
            tLObjectDeserializeResponse = TLClassStore.Instance().TLdeserialize(data, int32, exception);
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        if (tLObjectDeserializeResponse == null) {
            if (request != null) {
                try {
                    tLObjectDeserializeResponse = request.deserializeResponse(data, int32, exception);
                } catch (Exception e3) {
                    FileLog.e(e3);
                }
                if (tLObjectDeserializeResponse == null) {
                    FileLog.w(String.format(Locale.US, "***** Error parsing message: %x", Integer.valueOf(int32)));
                }
            } else {
                FileLog.d(String.format(Locale.US, "***** Not found request to parse message: %x", Integer.valueOf(int32)));
            }
        }
        return tLObjectDeserializeResponse;
    }

    public TLObject getRequestWithMessageId(long msgId) {
        Iterator<RPCRequest> it = this.runningRequests.iterator();
        while (it.hasNext()) {
            RPCRequest next = it.next();
            if (msgId == next.messageId) {
                return next.rawRequest;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectionDataReceived(final RPCRequest request, final NativeByteBuffer resData) throws InterruptedException, IOException {
        FileLog.w("accountIndex: " + this.currentAccount + "; " + request.rawRequest + " data received");
        if ((request.connectionType & 1) != 0 && this.connectionState != 3) {
            onConnectionStateChanged(3, this.currentAccount);
        }
        TLObject tLObjectDeserialize = deserialize(request.rawRequest, resData, true);
        if (request.rawRequest instanceof TLRPC$TL_phone_receivedCall) {
            Log.i("socket response", "res = " + tLObjectDeserialize.getClass().toString());
        }
        new AndroidUtilities();
        if (tLObjectDeserialize instanceof TLRPC$TL_error) {
            if (((TLRPC$TL_error) tLObjectDeserialize).text.contains("INVALID_CONSTRUCTOR")) {
                if (!this.requestInvalid.contains(Integer.valueOf(request.rawRequest.getClass().hashCode()))) {
                    this.requestInvalid.add(Integer.valueOf(request.rawRequest.getClass().hashCode()));
                }
                rpcCompleted(request.messageId);
            }
        } else if (tLObjectDeserialize instanceof TLRPC$TL_updates_ExpireToken) {
            refreshToken();
            reSendRequest(request);
            request.responseReceived.set(false);
            return;
        } else if (tLObjectDeserialize instanceof TLRPC$TL_tokenUpdateing) {
            reSendRequest(request);
            request.responseReceived.set(false);
            return;
        } else if (tLObjectDeserialize instanceof TLRPC$TL_updates_token) {
            UserConfig.getInstance(this.currentAccount).token = ((TLRPC$TL_updates_token) tLObjectDeserialize).token;
            UserConfig.getInstance(this.currentAccount).saveConfig(false);
            this.refreshingToken = false;
            this.refreshingTokenTime = 0L;
            return;
        }
        if (tLObjectDeserialize != null) {
            tLObjectDeserialize.networkType = getCurrentNetworkType();
            this.pingOK = true;
            this.nextPingId++;
            processMessage(tLObjectDeserialize, request);
            return;
        }
        FileLog.d("server message is null to request: " + request.rawRequest.getClass().toString());
        if (request.connectionType == 1) {
            processMessage(null, request);
            rpcCompleted(request.messageId);
        }
    }

    public void refreshToken() {
        if (this.refreshingToken) {
            long j = this.refreshingTokenTime;
            if (j != 0 && j > System.currentTimeMillis() - 60000) {
                return;
            }
        }
        this.refreshingToken = true;
        this.refreshingTokenTime = System.currentTimeMillis();
        TLRPC$TL_refreshToken tLRPC$TL_refreshToken = new TLRPC$TL_refreshToken();
        try {
            tLRPC$TL_refreshToken.appInfo = ApplicationLoader.getAppInfo();
        } catch (Exception unused) {
        }
        RPCRequest rPCRequest = new RPCRequest();
        rPCRequest.messageId = generateMessageId();
        rPCRequest.startTime = (int) (System.currentTimeMillis() / 1000);
        rPCRequest.connectionToken = getConnectionToken();
        rPCRequest.connectionType = 1;
        rPCRequest.rawRequest = tLRPC$TL_refreshToken;
        rPCRequest.rpcRequest = wrapInLayer(tLRPC$TL_refreshToken, rPCRequest);
        sendMessagesToTransport(rPCRequest, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void processMessage(ir.eitaa.tgnet.TLObject r17, ir.eitaa.tgnet.RPCRequest r18) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.tgnet.ConnectionsManager.processMessage(ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.RPCRequest):void");
    }

    private void rpcCompleted(final long requestMsgId) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.28
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ConnectionsManager.this.runningRequests.iterator();
                while (it.hasNext()) {
                    RPCRequest rPCRequest = (RPCRequest) it.next();
                    ConnectionsManager.this.removeRequestInClass(Long.valueOf(rPCRequest.token));
                    if (rPCRequest.respondsToMessageId(requestMsgId)) {
                        rPCRequest.rawRequest.freeResources();
                        rPCRequest.rpcRequest.freeResources();
                        ConnectionsManager.this.runningRequests.remove(rPCRequest);
                    }
                }
            }
        });
    }

    public CharSequence getHostName() {
        return datacenterWithId(this.currentDatacenterId).getCurrentAddress(2);
    }

    public void tcpConnectionClosed() {
        if (isNetworkOnline()) {
            onConnectionStateChanged(1, this.currentAccount);
        } else {
            onConnectionStateChanged(2, this.currentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generatePing() throws IOException {
        TLRPC$TL_ping tLRPC$TL_ping = new TLRPC$TL_ping();
        long j = this.nextPingId + 1;
        this.nextPingId = j;
        tLRPC$TL_ping.ping_id = j;
        RPCRequest rPCRequest = new RPCRequest();
        rPCRequest.token = this.lastRequestToken.getAndIncrement();
        rPCRequest.flags = 8;
        rPCRequest.connectionType = 1;
        rPCRequest.rawRequest = tLRPC$TL_ping;
        rPCRequest.rpcRequest = wrapInLayer(tLRPC$TL_ping, rPCRequest);
        this.lastPingTime = getCurrentTimeMillis();
        FileLog.w("accountIndex: " + this.currentAccount + ", generate " + tLRPC$TL_ping + "; id: " + tLRPC$TL_ping.ping_id);
        sendMessagesToTransport(rPCRequest, null);
        datacenterWithId(this.currentDatacenterId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generatePing(DataCenter datacenter, boolean push) {
        TcpConnection tcpConnection;
        if (push) {
            tcpConnection = datacenter.tcpPushConnection;
        } else {
            tcpConnection = datacenter.tcpConnection;
        }
        if (tcpConnection == null || !UserConfig.getInstance(this.currentAccount).isClientActivated()) {
            return;
        }
        TLRPC$TL_socketPing tLRPC$TL_socketPing = new TLRPC$TL_socketPing();
        long j = this.nextSocketPingId + 1;
        this.nextSocketPingId = j;
        tLRPC$TL_socketPing.ping_id = j;
        RPCRequest rPCRequest = new RPCRequest();
        rPCRequest.token = this.lastRequestToken.getAndIncrement();
        rPCRequest.flags = 8;
        rPCRequest.connectionType = 64;
        rPCRequest.rawRequest = tLRPC$TL_socketPing;
        rPCRequest.rpcRequest = wrapInLayer(tLRPC$TL_socketPing, rPCRequest);
        this.lastSocketPingTime = getCurrentTimeMillis();
        Log.w("", "socket Log: " + this.currentAccount + ", generate  ping: " + tLRPC$TL_socketPing.ping_id);
        SerializedData serializedData = new SerializedData(true);
        rPCRequest.rpcRequest.serializeToStream(serializedData);
        int length = serializedData.length();
        rPCRequest.messageId = generateMessageId();
        rPCRequest.serializedLength = length;
        rPCRequest.startTime = (int) (System.currentTimeMillis() / 1000);
        rPCRequest.connectionToken = getConnectionToken();
        sendMessagesToTransport(rPCRequest, tcpConnection);
    }

    public boolean getPingStatus() {
        return this.pingOK;
    }

    private int getConnectionToken() {
        return this.connectionToken;
    }

    public TLObject decompress(byte[] data, TLObject parentObject, boolean exception) throws IOException {
        SerializedData serializedData;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            if (decompressBuffer == null) {
                decompressBuffer = new byte[16384];
                decompressStream = new ByteArrayOutputStreamExpand(16384);
            }
            decompressStream.reset();
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 16384);
            while (true) {
                int i = gZIPInputStream.read(decompressBuffer);
                if (i != -1) {
                    decompressStream.write(decompressBuffer, 0, i);
                } else {
                    try {
                        break;
                    } catch (Exception e) {
                        FileLog.e("tmessages", e);
                    }
                }
            }
            gZIPInputStream.close();
            try {
                byteArrayInputStream.close();
            } catch (Exception e2) {
                FileLog.e("tmessages", e2);
            }
            serializedData = new SerializedData(decompressStream.toByteArray());
        } catch (IOException e3) {
            FileLog.e("tmessages", e3);
            serializedData = null;
        }
        if (serializedData == null) {
            return null;
        }
        TLObject tLObjectDeserialize = deserialize(parentObject, serializedData, exception);
        serializedData.cleanup();
        return tLObjectDeserialize;
    }

    public void logTheQueues() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.-$$Lambda$ConnectionsManager$Aq484zfRu9pdb3i2dgXx1lPBtQk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$logTheQueues$0$ConnectionsManager();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$logTheQueues$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$logTheQueues$0$ConnectionsManager() {
        FileLog.d("ConnectionsManager runningRequests");
        Iterator<RPCRequest> it = this.runningRequests.iterator();
        while (it.hasNext()) {
            RPCRequest next = it.next();
            FileLog.d("" + next.rawRequest);
            TLObject tLObject = next.rawRequest;
            if (tLObject instanceof TLRPC$TL_updates_getChannelDifference) {
                FileLog.d("getChannelDifference channel_id: " + ((TLRPC$TL_updates_getChannelDifference) tLObject).channel.channel_id);
            }
        }
        FileLog.d("ConnectionsManager requestQueue");
        Iterator<RPCRequest> it2 = this.requestQueue.iterator();
        while (it2.hasNext()) {
            RPCRequest next2 = it2.next();
            FileLog.d("" + next2.rawRequest);
            TLObject tLObject2 = next2.rawRequest;
            if (tLObject2 instanceof TLRPC$TL_updates_getChannelDifference) {
                FileLog.d("getChannelDifference channel_id: " + ((TLRPC$TL_updates_getChannelDifference) tLObject2).channel.channel_id);
            }
        }
    }

    public boolean isPushConnectionEnabled() {
        SharedPreferences globalNotificationsSettings = MessagesController.getGlobalNotificationsSettings();
        if (globalNotificationsSettings.contains("pushConnection")) {
            return globalNotificationsSettings.getBoolean("pushConnection", true);
        }
        return MessagesController.getMainSettings(UserConfig.selectedAccount).getBoolean("backgroundConnection", true);
    }

    public int getCurrentDatacenterId() {
        return native_getCurrentDatacenterId(this.currentAccount);
    }

    public static void setProxySettings(boolean enabled, String address, int port, String username, String password, String secret) {
        if (address == null) {
            address = "";
        }
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        if (secret == null) {
            secret = "";
        }
        for (int i = 0; i < 3; i++) {
            if (enabled && !TextUtils.isEmpty(address)) {
                native_setProxySettings(i, address, port, username, password, secret);
            } else {
                native_setProxySettings(i, "", 1080, "", "", "");
            }
            AccountInstance accountInstance = AccountInstance.getInstance(i);
            if (accountInstance.getUserConfig().isClientActivated()) {
                accountInstance.getMessagesController().checkPromoInfo(true);
            }
        }
    }

    public static void setLangCode(String langCode) {
        String lowerCase = langCode.replace('_', '-').toLowerCase();
        for (int i = 0; i < 3; i++) {
            native_setLangCode(i, lowerCase);
        }
    }

    public static void setSystemLangCode(String langCode) {
        String lowerCase = langCode.replace('_', '-').toLowerCase();
        for (int i = 0; i < 3; i++) {
            native_setSystemLangCode(i, lowerCase);
        }
    }

    public static void setRegId(String regId, String status) {
        if (TextUtils.isEmpty(regId) && !TextUtils.isEmpty(status)) {
            regId = status;
        }
        for (int i = 0; i < 3; i++) {
            native_setRegId(i, regId);
        }
    }

    public void initTcpConnection() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.ConnectionsManager.29
            @Override // java.lang.Runnable
            public void run() {
                ConnectionsManager connectionsManager = ConnectionsManager.this;
                DataCenter dataCenterDatacenterWithId = connectionsManager.datacenterWithId(connectionsManager.currentDatacenterId);
                if (dataCenterDatacenterWithId == null || dataCenterDatacenterWithId.tcpConnection != null) {
                    return;
                }
                dataCenterDatacenterWithId.tcpConnection = new TcpConnection(dataCenterDatacenterWithId.datacenterId, ConnectionsManager.this.currentAccount);
                dataCenterDatacenterWithId.tcpConnection.setSessionId(UserConfig.getInstance(ConnectionsManager.this.currentAccount).getClientUserId());
                dataCenterDatacenterWithId.tcpConnection.delegate = ConnectionsManager.this;
                dataCenterDatacenterWithId.tcpConnection.transportRequestClass = 64;
                dataCenterDatacenterWithId.tcpConnection.connect();
            }
        });
    }

    private void generateSocketSessionId() {
        this.socketSessionId = new Random().nextInt(2147483646);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int generateMessageSeqNo() {
        int i = this.messageSeqNo + 1;
        this.messageSeqNo = i;
        return i;
    }

    public void suspendConnections() {
        Iterator<DataCenter> it = this.datacenters.values().iterator();
        while (it.hasNext()) {
            it.next().suspendConnections();
        }
    }

    public boolean isTestBackend() {
        return native_isTestBackend(this.currentAccount) != 0;
    }
}
