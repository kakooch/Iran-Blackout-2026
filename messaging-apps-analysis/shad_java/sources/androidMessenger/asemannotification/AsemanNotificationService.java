package androidMessenger.asemannotification;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import androidMessenger.ServiceLocator;
import androidMessenger.model.AckInputObject;
import androidMessenger.model.HandShakeInputObject;
import androidMessenger.model.MessangerInput2;
import androidMessenger.model.NotificationObject;
import androidMessenger.model.PushNotificationObject;
import androidMessenger.utilites.MyLog;
import com.google.gson.Gson;
import com.neovisionaries.ws.client.ThreadType;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;
import com.neovisionaries.ws.client.WebSocketListener;
import com.neovisionaries.ws.client.WebSocketState;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.aaap.messengercore.model.MessengerUpdateObject;
import ir.resaneh1.iptv.messanger.RubikaNotificationManager;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.NotificationsController;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes.dex */
public class AsemanNotificationService extends Service {
    private static String LOG_TAG = "LogSocket";
    private static String LOG_TAG_DATA = "LogSocketData";
    public static String TAG = "LogSocket";
    public static AsemanNotificationService instance;
    private static int tryCounter;
    private long lastActiveTime;
    private DisposableObserver<Integer> timeoutsCheckerObserver;
    private DisposableObserver<Integer> timerForRetryConnect;
    public WebSocket ws;
    int currentAccount = 0;
    public Gson gson = ApplicationLoader.getGson();
    public boolean isConnecting = false;
    public boolean isConnected = false;
    private long lastPingTime = 0;
    private long retryToConnectDelayMilis = 10000;
    private long notActiveTimeout = 1200000;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    WebSocketListener webSocketListener = new WebSocketListener() { // from class: androidMessenger.asemannotification.AsemanNotificationService.1
        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void handleCallbackError(WebSocket webSocket, Throwable th) throws Exception {
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onTextMessage(WebSocket webSocket, byte[] bArr) throws Exception {
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onTextMessage(WebSocket webSocket, String str) {
            MyLog.e(AsemanNotificationService.TAG, "onTextMessage: " + str);
            try {
                NotificationObject notificationObject = (NotificationObject) ApplicationLoader.getGson().fromJson(str, NotificationObject.class);
                AsemanNotificationService.newNotif(notificationObject);
                if (notificationObject == null || TextUtils.isEmpty(notificationObject.ack_id)) {
                    return;
                }
                AsemanNotificationService.this.sendMessage("ack", new AckInputObject(notificationObject.ack_id));
            } catch (Exception e) {
                MyLog.handleException(e);
            }
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onConnected(WebSocket webSocket, Map<String, List<String>> map) throws Exception {
            Log.d(AsemanNotificationService.TAG, "onConnected: ");
            AsemanNotificationService.this.sendMessage("handShake", new HandShakeInputObject());
            AsemanNotificationService.this.lastPingTime = System.currentTimeMillis();
            AsemanNotificationService.this.refreshLastActive();
            AsemanNotificationService asemanNotificationService = AsemanNotificationService.this;
            asemanNotificationService.isConnecting = false;
            asemanNotificationService.isConnected = true;
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onConnectError(WebSocket webSocket, WebSocketException webSocketException) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onConnectError: " + webSocketException.getMessage());
            AsemanNotificationService asemanNotificationService = AsemanNotificationService.this;
            asemanNotificationService.isConnecting = false;
            asemanNotificationService.isConnected = false;
            asemanNotificationService.setTimerForTryToConnectIfNeeded();
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onUnexpectedError(WebSocket webSocket, WebSocketException webSocketException) throws Exception {
            Log.d(AsemanNotificationService.TAG, "onUnexpectedError: ");
            AsemanNotificationService asemanNotificationService = AsemanNotificationService.this;
            asemanNotificationService.isConnecting = false;
            asemanNotificationService.isConnected = false;
            asemanNotificationService.setTimerForTryToConnectIfNeeded();
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onDisconnected(WebSocket webSocket, WebSocketFrame webSocketFrame, WebSocketFrame webSocketFrame2, boolean z) throws Exception {
            Log.d(AsemanNotificationService.TAG, "onDisconnected: ");
            AsemanNotificationService asemanNotificationService = AsemanNotificationService.this;
            asemanNotificationService.isConnecting = false;
            asemanNotificationService.isConnected = false;
            asemanNotificationService.setTimerForTryToConnectIfNeeded();
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onError(WebSocket webSocket, WebSocketException webSocketException) throws Exception {
            AsemanNotificationService asemanNotificationService = AsemanNotificationService.this;
            asemanNotificationService.isConnecting = false;
            asemanNotificationService.isConnected = false;
            asemanNotificationService.setTimerForTryToConnectIfNeeded();
            Log.d(AsemanNotificationService.TAG, "onError: " + webSocketException.getMessage());
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onStateChanged(WebSocket webSocket, WebSocketState webSocketState) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, webSocketState.name() + "ssss");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onFrame");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onContinuationFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onContinuationFrame");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onTextFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onTextFrame");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onBinaryFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onBinaryFrame");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onCloseFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onCloseFrame");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onPingFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onPingFrame");
            AsemanNotificationService.this.lastPingTime = System.currentTimeMillis();
            if (AsemanNotificationService.this.isMessengerAppActive()) {
                AsemanNotificationService.this.refreshLastActive();
            }
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onPongFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onPongFrame");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onBinaryMessage(WebSocket webSocket, byte[] bArr) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onBinaryMessage");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onSendingFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onSendingFrame");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onFrameSent(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onFrameSent");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onFrameUnsent(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onFrameUnsent");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onThreadCreated(WebSocket webSocket, ThreadType threadType, Thread thread) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onThreadCreated");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onThreadStarted(WebSocket webSocket, ThreadType threadType, Thread thread) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onThreadStarted");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onThreadStopping(WebSocket webSocket, ThreadType threadType, Thread thread) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onThreadStopping");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onFrameError(WebSocket webSocket, WebSocketException webSocketException, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onFrameError");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onMessageError(WebSocket webSocket, WebSocketException webSocketException, List<WebSocketFrame> list) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onMessageError");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onMessageDecompressionError(WebSocket webSocket, WebSocketException webSocketException, byte[] bArr) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onMessageDecompressionError");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onTextMessageError(WebSocket webSocket, WebSocketException webSocketException, byte[] bArr) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onTextMessageError");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onSendError(WebSocket webSocket, WebSocketException webSocketException, WebSocketFrame webSocketFrame) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onSendError");
        }

        @Override // com.neovisionaries.ws.client.WebSocketListener
        public void onSendingHandshake(WebSocket webSocket, String str, List<String[]> list) throws Exception {
            MyLog.e(AsemanNotificationService.TAG, "onSendingHandshake");
        }
    };

    boolean isMessengerAppActive() {
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MyLog.e(LOG_TAG, "in onCreate");
        instance = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        WebSocket webSocket = this.ws;
        if (webSocket != null) {
            webSocket.disconnect();
        }
        this.compositeDisposable.dispose();
        instance = null;
        MyLog.e(LOG_TAG, "in onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.currentAccount = UserConfig.selectedAccount;
        MyLog.e(TAG, "start Command" + i + " " + i2 + " ");
        instance = this;
        tryToConnect();
        return 2;
    }

    public void tryToConnect() {
        DisposableObserver<Integer> disposableObserver = this.timerForRetryConnect;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        if (this.isConnecting) {
            return;
        }
        refreshLastActive();
        this.isConnecting = true;
        MyLog.e(TAG, "connect To socket2");
        try {
            WebSocket webSocket = this.ws;
            if (webSocket != null) {
                webSocket.removeListener(this.webSocketListener);
                this.ws.disconnect();
                this.ws = null;
            }
            this.lastPingTime = System.currentTimeMillis();
            startTimeoutsChecker();
            WebSocketFactory webSocketFactory = new WebSocketFactory();
            String socketUrl = ServiceLocator.getInstance(this.currentAccount).getCoreMainClass().getSocketUrl(tryCounter);
            MyLog.e(TAG, "selected URl " + socketUrl);
            WebSocket webSocketCreateSocket = webSocketFactory.createSocket(socketUrl, 15000);
            this.ws = webSocketCreateSocket;
            webSocketCreateSocket.addListener(this.webSocketListener);
            this.ws.connectAsynchronously();
        } catch (IOException e) {
            MyLog.e(TAG, "io Exception" + e.getMessage());
            e.printStackTrace();
        }
        tryCounter++;
    }

    public void destroyService() {
        WebSocket webSocket = this.ws;
        if (webSocket != null && webSocket.isOpen()) {
            this.ws.removeListener(this.webSocketListener);
            this.ws.disconnect();
            this.ws = null;
            this.isConnecting = false;
        }
        stopSelf();
    }

    public void sendMessage(String str, Object obj) {
        MessangerInput2 messangerInput2 = new MessangerInput2(ServiceLocator.getInstance(this.currentAccount).getCoreMainClass().getAuth());
        messangerInput2.method = str;
        if (obj != null && ApplicationLoader.getGson() != null) {
            messangerInput2.data = ApplicationLoader.getGson().toJson(obj);
        } else {
            messangerInput2.data = "{}";
        }
        this.ws.sendText(this.gson.toJson(messangerInput2));
    }

    void refreshLastActive() {
        this.lastActiveTime = System.currentTimeMillis();
    }

    public static void startNotificationService(Context context) {
        AsemanNotificationService asemanNotificationService = instance;
        if (asemanNotificationService == null) {
            context.startService(new Intent(context, (Class<?>) AsemanNotificationService.class));
        } else {
            if (asemanNotificationService.isSocketConnectedOrConnecting()) {
                return;
            }
            instance.tryToConnect();
        }
    }

    boolean isSocketConnectedOrConnecting() {
        return (this.ws != null && this.isConnected) || this.isConnecting;
    }

    public static void newNotif(NotificationObject notificationObject) {
        if (notificationObject == null || notificationObject.type == null) {
            return;
        }
        notificationObject.makeData();
        NotificationObject.TypeEnum typeEnum = notificationObject.type;
        if (typeEnum == NotificationObject.TypeEnum.messenger) {
            MessengerUpdateObject messengerUpdateObject = notificationObject.messenger;
            if (messengerUpdateObject != null) {
                String str = messengerUpdateObject.user_guid;
                if (str == null || str.equals(ServiceLocator.getInstance(notificationObject.currentAccount).getCoreMainClass().getMyUserInfo().user_guid)) {
                    if (MyLog.isDebugAble) {
                        String str2 = LOG_TAG_DATA;
                        StringBuilder sb = new StringBuilder();
                        sb.append("messenger ");
                        sb.append(notificationObject.messenger != null ? ApplicationLoader.getGson().toJson(notificationObject.messenger) : "null");
                        MyLog.e(str2, sb.toString());
                    }
                    handleMessengerUpdate(notificationObject.currentAccount, notificationObject.messenger);
                    return;
                }
                return;
            }
            return;
        }
        if (typeEnum == NotificationObject.TypeEnum.rubino) {
            if (notificationObject.rubino_data != null) {
                RubikaNotificationManager.getInstance(notificationObject.currentAccount).createNotificationInstaEvent(notificationObject.rubino_data);
            }
        } else {
            if (typeEnum != NotificationObject.TypeEnum.notif || notificationObject.notif == null) {
                return;
            }
            NotificationsController notificationsController = AccountInstance.getInstance(instance.currentAccount).getNotificationsController();
            PushNotificationObject pushNotificationObject = notificationObject.notif;
            notificationsController.createNotificationWithLink(false, pushNotificationObject.title, pushNotificationObject.msg, pushNotificationObject.link, (notificationObject.notif.msg + BuildConfig.FLAVOR).hashCode(), NotificationsController.groupNameGeneral);
        }
    }

    public static void handleMessengerUpdate(int i, MessengerUpdateObject messengerUpdateObject) {
        if (messengerUpdateObject == null) {
            return;
        }
        ServiceLocator.getInstance(i).getCoreMainClass().handleMessengerNotification(messengerUpdateObject, false);
    }

    public void setTimerForTryToConnectIfNeeded() {
        DisposableObserver<Integer> disposableObserver = this.timerForRetryConnect;
        if (disposableObserver == null || disposableObserver.isDisposed()) {
            if (!isMessengerAppActive()) {
                destroyService();
                return;
            }
            DisposableObserver<Integer> disposableObserver2 = (DisposableObserver) Observable.just(1).delay(this.retryToConnectDelayMilis, TimeUnit.MILLISECONDS).subscribeWith(new DisposableObserver<Integer>() { // from class: androidMessenger.asemannotification.AsemanNotificationService.2
                @Override // io.reactivex.Observer
                public void onNext(Integer num) {
                    AsemanNotificationService.this.tryToConnect();
                    AsemanNotificationService.this.timerForRetryConnect.dispose();
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    AsemanNotificationService.this.timerForRetryConnect.dispose();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    AsemanNotificationService.this.timerForRetryConnect.dispose();
                }
            });
            this.timerForRetryConnect = disposableObserver2;
            this.compositeDisposable.add(disposableObserver2);
        }
    }

    public void startTimeoutsChecker() {
        DisposableObserver<Integer> disposableObserver = this.timeoutsCheckerObserver;
        if (disposableObserver == null || disposableObserver.isDisposed()) {
            DisposableObserver<Integer> disposableObserver2 = (DisposableObserver) Observable.just(1).subscribeOn(Schedulers.io()).delay(12000L, TimeUnit.MILLISECONDS, Schedulers.io()).repeat().subscribeWith(new DisposableObserver<Integer>() { // from class: androidMessenger.asemannotification.AsemanNotificationService.3
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Integer num) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    boolean zIsMessengerAppActive = AsemanNotificationService.this.isMessengerAppActive();
                    if (zIsMessengerAppActive && jCurrentTimeMillis - AsemanNotificationService.this.lastPingTime > 30000 && AsemanNotificationService.this.isSocketConnectedOrConnecting()) {
                        AsemanNotificationService asemanNotificationService = AsemanNotificationService.this;
                        asemanNotificationService.isConnecting = false;
                        asemanNotificationService.isConnected = false;
                        asemanNotificationService.tryToConnect();
                    }
                    if (jCurrentTimeMillis - AsemanNotificationService.this.lastActiveTime > AsemanNotificationService.this.notActiveTimeout) {
                        if (zIsMessengerAppActive) {
                            AsemanNotificationService.this.refreshLastActive();
                        } else {
                            AsemanNotificationService.this.destroyService();
                        }
                    }
                }
            });
            this.timeoutsCheckerObserver = disposableObserver2;
            this.compositeDisposable.add(disposableObserver2);
        }
    }
}
