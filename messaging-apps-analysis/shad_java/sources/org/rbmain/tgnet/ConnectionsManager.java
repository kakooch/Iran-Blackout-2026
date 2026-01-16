package org.rbmain.tgnet;

import android.os.AsyncTask;
import androidMessenger.proxy.IdStorage;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes.dex */
public class ConnectionsManager extends BaseController {
    private static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int ConnectionStateConnected = 3;
    public static final int ConnectionStateConnecting = 1;
    public static final int ConnectionStateConnectingToProxy = 4;
    public static final int ConnectionStateUpdating = 5;
    public static final int ConnectionStateWaitingForNetwork = 2;
    public static final int ConnectionTypeDownload = 2;
    public static final int ConnectionTypeDownload2 = 65538;
    public static final int ConnectionTypeGeneric = 1;
    public static final int ConnectionTypePush = 8;
    public static final int ConnectionTypeUpload = 4;
    public static final int DEFAULT_DATACENTER_ID = Integer.MAX_VALUE;
    public static final Executor DNS_THREAD_POOL_EXECUTOR;
    public static final int FileTypeAudio = 50331648;
    public static final int FileTypeFile = 67108864;
    public static final int FileTypePhoto = 16777216;
    public static final int FileTypeVideo = 33554432;
    private static volatile ConnectionsManager[] Instance = null;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE;
    public static final int RequestFlagCanCompress = 4;
    public static final int RequestFlagEnableUnauthorized = 1;
    public static final int RequestFlagFailOnServerErrors = 2;
    public static final int RequestFlagForceDownload = 32;
    public static final int RequestFlagInvokeAfter = 64;
    public static final int RequestFlagNeedQuickAck = 128;
    public static final int RequestFlagTryDifferentDc = 16;
    public static final int RequestFlagWithoutLogin = 8;
    public static final byte USE_IPV4_IPV6_RANDOM = 2;
    public static final byte USE_IPV4_ONLY = 0;
    public static final byte USE_IPV6_ONLY = 1;
    private static AsyncTask currentTask;
    private static HashMap<String, Object> dnsCache;
    private static int lastClassGuid;
    private static long lastDnsRequestTime;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private boolean appPaused;
    private int appResumeCount;
    private int connectionState;
    private boolean isUpdating;
    private long lastPauseTime;
    private AtomicInteger lastRequestToken;

    public static void getHostByName(String str, long j) {
    }

    public static int getInitFlags() {
        return 0;
    }

    public static void native_applyDatacenterAddress(int i, int i2, String str, int i3) {
    }

    public static void native_applyDnsConfig(int i, long j, String str, int i2) {
    }

    public static void native_bindRequestToGuid(int i, int i2, int i3) {
    }

    public static void native_cancelRequest(int i, int i2, boolean z) {
    }

    public static void native_cancelRequestsForGuid(int i, int i2) {
    }

    public static long native_checkProxy(int i, String str, int i2, String str2, String str3, String str4, RequestTimeDelegate requestTimeDelegate) {
        return 0L;
    }

    public static void native_cleanUp(int i, boolean z) {
    }

    public static int native_getConnectionState(int i) {
        return 0;
    }

    public static int native_getCurrentDatacenterId(int i) {
        return 0;
    }

    public static int native_getCurrentTime(int i) {
        return 0;
    }

    public static long native_getCurrentTimeMillis(int i) {
        return 0L;
    }

    public static int native_getTimeDifference(int i) {
        return 0;
    }

    public static void native_init(int i, int i2, int i3, int i4, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i5, int i6, boolean z, boolean z2, int i7) {
    }

    public static int native_isTestBackend(int i) {
        return 0;
    }

    public static void native_onHostNameResolved(String str, long j, String str2) {
    }

    public static void native_pauseNetwork(int i) {
    }

    public static void native_resumeNetwork(int i, boolean z) {
    }

    public static void native_seSystemLangCode(int i, String str) {
    }

    public static void native_sendRequest(int i, long j, RequestDelegateInternal requestDelegateInternal, QuickAckDelegate quickAckDelegate, WriteToSocketDelegate writeToSocketDelegate, int i2, int i3, int i4, boolean z, int i5) {
    }

    public static void native_setIpStrategy(int i, byte b) {
    }

    public static native void native_setJava(boolean z);

    public static void native_setLangCode(int i, String str) {
    }

    public static void native_setNetworkAvailable(int i, boolean z, int i2, boolean z2) {
    }

    public static void native_setProxySettings(int i, String str, int i2, String str2, String str3, String str4) {
    }

    public static void native_setPushConnectionEnabled(int i, boolean z) {
    }

    public static void native_setRegId(int i, String str) {
    }

    public static void native_setSystemLangCode(int i, String str) {
    }

    public static void native_setUserId(int i, int i2) {
    }

    public static void native_switchBackend(int i) {
    }

    public static void native_updateDcSettings(int i) {
    }

    public static void onBytesReceived(int i, int i2, int i3) {
    }

    public static void onBytesSent(int i, int i2, int i3) {
    }

    public static void onInternalPushReceived(int i) {
    }

    public static void onLogout(int i) {
    }

    public static void onProxyError() {
    }

    public static void onRequestNewServerIpAndPort(int i, int i2) {
    }

    public static void onSessionCreated(int i) {
    }

    public static void onUnparsedMessageReceived(long j, int i) {
    }

    public static void onUpdate(int i) {
    }

    public static void onUpdateConfig(long j, int i) {
    }

    public static void setLangCode(String str) {
    }

    public static void setProxySettings(boolean z, String str, int i, String str2, String str3, String str4) {
    }

    public static void setRegId(String str, String str2) {
    }

    public static void setSystemLangCode(String str) {
    }

    public void applyDatacenterAddress(int i, String str, int i2) {
    }

    public void bindRequestToGuid(int i, int i2) {
    }

    public void cancelRequestsForGuid(int i) {
    }

    public void checkConnection() {
    }

    public long checkProxy(String str, int i, String str2, String str3, String str4, RequestTimeDelegate requestTimeDelegate) {
        return 0L;
    }

    public void cleanup(boolean z) {
    }

    public int getCurrentDatacenterId() {
        return 0;
    }

    public int getDiffForOnline() {
        return 90;
    }

    public void init(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i4, int i5, boolean z) {
    }

    public boolean isPushConnectionEnabled() {
        return false;
    }

    public void resumeNetworkMaybe() {
    }

    public void setAppPaused(boolean z, boolean z2) {
    }

    public void setPushConnectionEnabled(boolean z) {
    }

    public void setUserId(int i) {
    }

    public void switchBackend() {
    }

    public void updateDcSettings() {
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        CORE_POOL_SIZE = iMax;
        int i = (iAvailableProcessors * 2) + 1;
        MAXIMUM_POOL_SIZE = i;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        sPoolWorkQueue = linkedBlockingQueue;
        ThreadFactory threadFactory = new ThreadFactory() { // from class: org.rbmain.tgnet.ConnectionsManager.1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "DnsAsyncTask #" + this.mCount.getAndIncrement());
            }
        };
        sThreadFactory = threadFactory;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iMax, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        DNS_THREAD_POOL_EXECUTOR = threadPoolExecutor;
        dnsCache = new HashMap<>();
        lastClassGuid = 1;
        Instance = new ConnectionsManager[3];
    }

    public static ConnectionsManager getInstance(int i) {
        ConnectionsManager connectionsManager = Instance[i];
        if (connectionsManager == null) {
            synchronized (ConnectionsManager.class) {
                connectionsManager = Instance[i];
                if (connectionsManager == null) {
                    ConnectionsManager[] connectionsManagerArr = Instance;
                    ConnectionsManager connectionsManager2 = new ConnectionsManager(i);
                    connectionsManagerArr[i] = connectionsManager2;
                    connectionsManager = connectionsManager2;
                }
            }
        }
        return connectionsManager;
    }

    public ConnectionsManager(int i) {
        super(i);
        this.lastPauseTime = System.currentTimeMillis();
        this.appPaused = true;
        this.connectionState = 3;
        this.lastRequestToken = new AtomicInteger(1);
    }

    public long getCurrentTimeMillis() {
        return AccountInstance.getInstance(this.currentAccount).getCoreMainClass().getTimeMillis();
    }

    public int getCurrentTime() {
        return (int) (AccountInstance.getInstance(this.currentAccount).getCoreMainClass().getTimeMillis() / 1000);
    }

    public int getTimeDifference() {
        return AccountInstance.getInstance(this.currentAccount).getCoreMainClass().getServerTimeDiffMillis();
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate) {
        return sendRequest(tLObject, requestDelegate, (QuickAckDelegate) null, 0);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, int i) {
        return sendRequest(tLObject, requestDelegate, null, null, null, i, DEFAULT_DATACENTER_ID, 1, true);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, int i, int i2) {
        return sendRequest(tLObject, requestDelegate, null, null, null, i, DEFAULT_DATACENTER_ID, i2, true);
    }

    public int sendRequest(TLObject tLObject, RequestDelegateTimestamp requestDelegateTimestamp, int i, int i2, int i3) {
        return sendRequest(tLObject, null, requestDelegateTimestamp, null, null, i, i3, i2, true);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, QuickAckDelegate quickAckDelegate, int i) {
        return sendRequest(tLObject, requestDelegate, null, quickAckDelegate, null, i, DEFAULT_DATACENTER_ID, 1, true);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, QuickAckDelegate quickAckDelegate, WriteToSocketDelegate writeToSocketDelegate, int i, int i2, int i3, boolean z) {
        return sendRequest(tLObject, requestDelegate, null, quickAckDelegate, writeToSocketDelegate, i, i2, i3, z);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, RequestDelegateTimestamp requestDelegateTimestamp, QuickAckDelegate quickAckDelegate, WriteToSocketDelegate writeToSocketDelegate, int i, int i2, int i3, boolean z) {
        return this.lastRequestToken.getAndIncrement();
    }

    public void cancelRequest(int i, boolean z) {
        Integer reqId;
        if (i > 0 && (reqId = IdStorage.getInstance().getReqId(i)) != null) {
            getCoreMainClass().cancelRequest(reqId.intValue());
        }
    }

    public void cancelRequest(int i) {
        Integer reqId;
        if (i > 0 && (reqId = IdStorage.getInstance().getReqId(i)) != null) {
            getCoreMainClass().cancelRequest(reqId.intValue());
        }
    }

    public int getConnectionState() {
        int i = this.connectionState;
        if (i == 3 && this.isUpdating) {
            return 5;
        }
        return i;
    }

    public long getPauseTime() {
        return this.lastPauseTime;
    }

    public static void onConnectionStateChanged(int i, final int i2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.tgnet.ConnectionsManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConnectionsManager.lambda$onConnectionStateChanged$0(i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onConnectionStateChanged$0(int i) {
        getInstance(i).connectionState = 3;
        AccountInstance.getInstance(i).getNotificationCenter().postNotificationName(NotificationCenter.didUpdateConnectionState, new Object[0]);
    }

    public static int generateClassGuid() {
        int i = lastClassGuid;
        lastClassGuid = i + 1;
        return i;
    }

    public void setIsUpdating(final boolean z) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.tgnet.ConnectionsManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setIsUpdating$1(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setIsUpdating$1(boolean z) {
        if (this.isUpdating == z) {
            return;
        }
        this.isUpdating = z;
        if (this.connectionState == 3) {
            AccountInstance.getInstance(this.currentAccount).getNotificationCenter().postNotificationName(NotificationCenter.didUpdateConnectionState, new Object[0]);
        }
    }
}
