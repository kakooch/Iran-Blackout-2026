package ir.eitaa.messenger.voip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRouter;
import android.media.RingtoneManager;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Vibrator;
import android.telecom.CallAudioState;
import android.telecom.Connection;
import android.telecom.DisconnectCause;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.KeyEvent;
import android.widget.Toast;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.StatsController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.XiaomiUtilities;
import ir.eitaa.messenger.voip.Instance;
import ir.eitaa.messenger.voip.NativeInstance;
import ir.eitaa.messenger.voip.VoIPController;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.RequestDelegateTimestamp;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$GroupCall;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$PhoneCall;
import ir.eitaa.tgnet.TLRPC$TL_chatFull;
import ir.eitaa.tgnet.TLRPC$TL_dataJSON;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_groupCall;
import ir.eitaa.tgnet.TLRPC$TL_groupCallDiscarded;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipantVideo;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipantVideoSourceGroup;
import ir.eitaa.tgnet.TLRPC$TL_inputGroupCallStream;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_inputPhoneCall;
import ir.eitaa.tgnet.TLRPC$TL_messages_dhConfig;
import ir.eitaa.tgnet.TLRPC$TL_messages_getDhConfig;
import ir.eitaa.tgnet.TLRPC$TL_messages_setTyping;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscardReasonBusy;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscardReasonDisconnect;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscardReasonHangup;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscardReasonMissed;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscarded;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallProtocol;
import ir.eitaa.tgnet.TLRPC$TL_phone_acceptCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_checkGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_confirmCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_createGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_discardCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_discardGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_editGroupCallParticipant;
import ir.eitaa.tgnet.TLRPC$TL_phone_joinGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_joinGroupCallPresentation;
import ir.eitaa.tgnet.TLRPC$TL_phone_leaveGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_leaveGroupCallPresentation;
import ir.eitaa.tgnet.TLRPC$TL_phone_phoneCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_receivedCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_requestCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_saveCallDebug;
import ir.eitaa.tgnet.TLRPC$TL_phone_sendSignalingData;
import ir.eitaa.tgnet.TLRPC$TL_speakingInGroupCallAction;
import ir.eitaa.tgnet.TLRPC$TL_updateGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_updateGroupCallConnection;
import ir.eitaa.tgnet.TLRPC$TL_updateGroupCallParticipants;
import ir.eitaa.tgnet.TLRPC$TL_updatePhoneCallSignalingData;
import ir.eitaa.tgnet.TLRPC$TL_updates;
import ir.eitaa.tgnet.TLRPC$TL_upload_getFile;
import ir.eitaa.tgnet.TLRPC$Update;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.tgnet.TLRPC$messages_DhConfig;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.JoinCallAlert;
import ir.eitaa.ui.Components.voip.VoIPHelper;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.VoIPFeedbackActivity;
import ir.eitaa.ui.VoIPFragment;
import ir.eitaa.ui.VoIPPermissionActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.linphone.mediastream.Factory;
import org.webrtc.MediaStreamTrack;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
import org.webrtc.voiceengine.WebRtcAudioTrack;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class VoIPService extends Service implements SensorEventListener, AudioManager.OnAudioFocusChangeListener, VoIPController.ConnectionStateListener, NotificationCenter.NotificationCenterDelegate {
    public static final String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";
    public static final int AUDIO_ROUTE_BLUETOOTH = 2;
    public static final int AUDIO_ROUTE_EARPIECE = 0;
    public static final int AUDIO_ROUTE_SPEAKER = 1;
    public static final int CALL_MIN_LAYER = 65;
    public static final int CAPTURE_DEVICE_CAMERA = 0;
    public static final int CAPTURE_DEVICE_SCREEN = 1;
    public static final int DISCARD_REASON_DISCONNECT = 2;
    public static final int DISCARD_REASON_HANGUP = 1;
    public static final int DISCARD_REASON_LINE_BUSY = 4;
    public static final int DISCARD_REASON_MISSED = 3;
    private static final int ID_INCOMING_CALL_NOTIFICATION = 202;
    private static final int ID_ONGOING_CALL_NOTIFICATION = 201;
    private static final int PROXIMITY_SCREEN_OFF_WAKE_LOCK = 32;
    public static final int QUALITY_FULL = 2;
    public static final int QUALITY_MEDIUM = 1;
    public static final int QUALITY_SMALL = 0;
    public static final int STATE_BUSY = 17;
    public static final int STATE_CREATING = 6;
    public static final int STATE_ENDED = 11;
    public static final int STATE_ESTABLISHED = 3;
    public static final int STATE_EXCHANGING_KEYS = 12;
    public static final int STATE_FAILED = 4;
    public static final int STATE_HANGING_UP = 10;
    public static final int STATE_RECONNECTING = 5;
    public static final int STATE_REQUESTING = 14;
    public static final int STATE_RINGING = 16;
    public static final int STATE_WAITING = 13;
    public static final int STATE_WAITING_INCOMING = 15;
    public static final int STATE_WAIT_INIT = 1;
    public static final int STATE_WAIT_INIT_ACK = 2;
    public static NativeInstance.AudioLevelsCallback audioLevelsCallback;
    public static TLRPC$PhoneCall callIShouldHavePutIntoIntent;
    private static Runnable setModeRunnable;
    private static VoIPService sharedInstance;
    private byte[] a_or_b;
    private boolean audioConfigured;
    private byte[] authKey;
    private boolean bluetoothScoActive;
    private boolean bluetoothScoConnecting;
    private BluetoothAdapter btAdapter;
    private int callDiscardReason;
    private int callReqId;
    private long callStartTime;
    private TLRPC$Chat chat;
    private int checkRequestId;
    private int classGuid;
    private Runnable connectingSoundRunnable;
    private PowerManager.WakeLock cpuWakelock;
    private boolean createGroupCall;
    public String currentBluetoothDeviceName;
    public boolean currentGroupModeStreaming;
    private Runnable delayedStartOutgoingCall;
    private boolean didDeleteConnectionServiceContact;
    private boolean endCallAfterRequest;
    boolean fetchingBluetoothDeviceName;
    private boolean forceRating;
    private byte[] g_a;
    private byte[] g_a_hash;
    public ChatObject.Call groupCall;
    private TLRPC$InputPeer groupCallPeer;
    private boolean hasAudioFocus;
    public boolean hasFewPeers;
    private boolean isBtHeadsetConnected;
    private boolean isHeadsetPlugged;
    private boolean isOutgoing;
    private boolean isPrivateScreencast;
    private boolean isProximityNear;
    private boolean isVideoAvailable;
    private String joinHash;
    private long keyFingerprint;
    private String lastError;
    private NetworkInfo lastNetInfo;
    private long lastTypingTimeSend;
    private Boolean mHasEarpiece;
    private boolean micMute;
    public boolean micSwitching;
    private TLRPC$TL_dataJSON myParams;
    private boolean needPlayEndSound;
    private boolean needRateCall;
    private boolean needSendDebugLog;
    private boolean needSwitchToBluetoothAfterScoActivates;
    private boolean notificationsDisabled;
    private Runnable onDestroyRunnable;
    private boolean playedConnectedSound;
    private boolean playingSound;
    private Instance.TrafficStats prevTrafficStats;
    public TLRPC$PhoneCall privateCall;
    private PowerManager.WakeLock proximityWakelock;
    private boolean reconnectScreenCapture;
    private MediaPlayer ringtonePlayer;
    private int scheduleDate;
    private Runnable shortPollRunnable;
    private int signalBarCount;
    private SoundPool soundPool;
    private int spAllowTalkId;
    private int spBusyId;
    private int spConnectingId;
    private int spEndId;
    private int spFailedID;
    private int spPlayId;
    private int spRingbackID;
    private int spStartRecordId;
    private int spVoiceChatConnecting;
    private int spVoiceChatEndId;
    private int spVoiceChatStartId;
    private boolean speakerphoneStateToSet;
    private boolean startedRinging;
    private boolean switchingAccount;
    private boolean switchingCamera;
    private boolean switchingStream;
    private Runnable switchingStreamTimeoutRunnable;
    private CallConnection systemCallConnection;
    private Runnable timeoutRunnable;
    private boolean unmutedByHold;
    private Runnable updateNotificationRunnable;
    private TLRPC$User user;
    private Vibrator vibrator;
    public boolean videoCall;
    private boolean wasConnected;
    private boolean wasEstablished;
    private static final boolean USE_CONNECTION_SERVICE = isDeviceCompatibleWithConnectionServiceAPI();
    private static final Object sync = new Object();
    private int currentAccount = -1;
    private int currentState = 0;
    private boolean isFrontFaceCamera = true;
    private int previousAudioOutput = -1;
    private ArrayList<StateListener> stateListeners = new ArrayList<>();
    private int remoteVideoState = 0;
    private int[] mySource = new int[2];
    private NativeInstance[] tgVoip = new NativeInstance[2];
    private long[] captureDevice = new long[2];
    private boolean[] destroyCaptureDevice = {true, true};
    private int[] videoState = {0, 0};
    private int remoteAudioState = 1;
    private int audioRouteToSet = 2;
    public final SharedUIParams sharedUIParams = new SharedUIParams();
    private ArrayList<TLRPC$PhoneCall> pendingUpdates = new ArrayList<>();
    private HashMap<String, Integer> currentStreamRequestTimestamp = new HashMap<>();
    private Runnable afterSoundRunnable = new AnonymousClass1();
    private BluetoothProfile.ServiceListener serviceListener = new BluetoothProfile.ServiceListener() { // from class: ir.eitaa.messenger.voip.VoIPService.2
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int profile) {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            Iterator<BluetoothDevice> it = proxy.getConnectedDevices().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BluetoothDevice next = it.next();
                if (proxy.getConnectionState(next) == 2) {
                    VoIPService.this.currentBluetoothDeviceName = next.getName();
                    break;
                }
            }
            BluetoothAdapter.getDefaultAdapter().closeProfileProxy(profile, proxy);
            VoIPService.this.fetchingBluetoothDeviceName = false;
        }
    };
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: ir.eitaa.messenger.voip.VoIPService.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IllegalStateException, InterruptedException {
            if (VoIPService.ACTION_HEADSET_PLUG.equals(intent.getAction())) {
                VoIPService.this.isHeadsetPlugged = intent.getIntExtra("state", 0) == 1;
                if (VoIPService.this.isHeadsetPlugged && VoIPService.this.proximityWakelock != null && VoIPService.this.proximityWakelock.isHeld()) {
                    VoIPService.this.proximityWakelock.release();
                }
                if (!VoIPService.this.isHeadsetPlugged) {
                    if (VoIPService.this.previousAudioOutput >= 0) {
                        VoIPService voIPService = VoIPService.this;
                        voIPService.setAudioOutput(voIPService.previousAudioOutput);
                        VoIPService.this.previousAudioOutput = -1;
                    }
                } else {
                    AudioManager audioManager = (AudioManager) VoIPService.this.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                    if (audioManager.isSpeakerphoneOn()) {
                        VoIPService.this.previousAudioOutput = 0;
                    } else if (audioManager.isBluetoothScoOn()) {
                        VoIPService.this.previousAudioOutput = 2;
                    } else {
                        VoIPService.this.previousAudioOutput = 1;
                    }
                    VoIPService.this.setAudioOutput(1);
                }
                VoIPService.this.isProximityNear = false;
                VoIPService.this.updateOutputGainControlState();
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                VoIPService.this.updateNetworkType();
                return;
            }
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("bt headset state = " + intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0));
                }
                VoIPService.this.updateBluetoothHeadsetState(intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0) == 2);
                return;
            }
            if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("Bluetooth SCO state updated: " + intExtra);
                }
                if (intExtra == 0 && VoIPService.this.isBtHeadsetConnected && (!VoIPService.this.btAdapter.isEnabled() || VoIPService.this.btAdapter.getProfileConnectionState(1) != 2)) {
                    VoIPService.this.updateBluetoothHeadsetState(false);
                    return;
                }
                VoIPService.this.bluetoothScoConnecting = intExtra == 2;
                VoIPService.this.bluetoothScoActive = intExtra == 1;
                if (VoIPService.this.bluetoothScoActive) {
                    VoIPService.this.fetchBluetoothDeviceName();
                    if (VoIPService.this.needSwitchToBluetoothAfterScoActivates) {
                        VoIPService.this.needSwitchToBluetoothAfterScoActivates = false;
                        AudioManager audioManager2 = (AudioManager) VoIPService.this.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                        audioManager2.setSpeakerphoneOn(false);
                        audioManager2.setBluetoothScoOn(true);
                    }
                }
                Iterator it = VoIPService.this.stateListeners.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).onAudioSettingsChanged();
                }
                return;
            }
            if ("android.intent.action.PHONE_STATE".equals(intent.getAction())) {
                if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(intent.getStringExtra("state"))) {
                    VoIPService.this.hangUp();
                }
            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                for (int i = 0; i < VoIPService.this.stateListeners.size(); i++) {
                    ((StateListener) VoIPService.this.stateListeners.get(i)).onScreenOnChange(true);
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                for (int i2 = 0; i2 < VoIPService.this.stateListeners.size(); i2++) {
                    ((StateListener) VoIPService.this.stateListeners.get(i2)).onScreenOnChange(false);
                }
            }
        }
    };
    private final HashMap<String, TLRPC$TL_groupCallParticipant> waitingFrameParticipant = new HashMap<>();
    private final LruCache<String, ProxyVideoSink> proxyVideoSinkLruCache = new LruCache<String, ProxyVideoSink>(6) { // from class: ir.eitaa.messenger.voip.VoIPService.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public void entryRemoved(boolean evicted, String key, ProxyVideoSink oldValue, ProxyVideoSink newValue) {
            super.entryRemoved(evicted, (boolean) key, oldValue, newValue);
            VoIPService.this.tgVoip[0].removeIncomingVideoOutput(oldValue.nativeInstance);
        }
    };
    private ProxyVideoSink[] localSink = new ProxyVideoSink[2];
    private ProxyVideoSink[] remoteSink = new ProxyVideoSink[2];
    private ProxyVideoSink[] currentBackgroundSink = new ProxyVideoSink[2];
    private String[] currentBackgroundEndpointId = new String[2];
    private HashMap<String, ProxyVideoSink> remoteSinks = new HashMap<>();

    public static class SharedUIParams {
        public boolean cameraAlertWasShowed;
        public boolean tapToVideoTooltipWasShowed;
        public boolean wasVideoCall;
    }

    public interface StateListener {

        /* renamed from: ir.eitaa.messenger.voip.VoIPService$StateListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onAudioSettingsChanged(StateListener stateListener) {
            }

            public static void $default$onCameraFirstFrameAvailable(StateListener stateListener) {
            }

            public static void $default$onCameraSwitch(StateListener stateListener, boolean z) {
            }

            public static void $default$onMediaStateUpdated(StateListener stateListener, int i, int i2) {
            }

            public static void $default$onScreenOnChange(StateListener stateListener, boolean z) {
            }

            public static void $default$onSignalBarsCountChanged(StateListener stateListener, int i) {
            }

            public static void $default$onStateChanged(StateListener stateListener, int i) {
            }

            public static void $default$onVideoAvailableChange(StateListener stateListener, boolean z) {
            }
        }

        void onAudioSettingsChanged();

        void onCameraFirstFrameAvailable();

        void onCameraSwitch(boolean isFrontFace);

        void onMediaStateUpdated(int audioState, int videoState);

        void onScreenOnChange(boolean screenOn);

        void onSignalBarsCountChanged(int count);

        void onStateChanged(int state);

        void onVideoAvailableChange(boolean isAvailable);
    }

    static /* synthetic */ void lambda$createGroupInstance$37(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$onSignalingData$58(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    private void onTgVoipPreStop() {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: ir.eitaa.messenger.voip.VoIPService$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            final AudioManager audioManager = (AudioManager) VoIPService.this.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            audioManager.abandonAudioFocus(VoIPService.this);
            audioManager.unregisterMediaButtonEventReceiver(new ComponentName(VoIPService.this, (Class<?>) VoIPMediaButtonReceiver.class));
            if (!VoIPService.USE_CONNECTION_SERVICE && VoIPService.sharedInstance == null) {
                if (VoIPService.this.isBtHeadsetConnected) {
                    audioManager.stopBluetoothSco();
                    audioManager.setBluetoothScoOn(false);
                    VoIPService.this.bluetoothScoActive = false;
                    VoIPService.this.bluetoothScoConnecting = false;
                }
                audioManager.setSpeakerphoneOn(false);
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$1$3YkEtkQiaDr8nR2SNkdW_oAL0gw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0$VoIPService$1();
                }
            });
            Utilities.globalQueue.postRunnable(VoIPService.setModeRunnable = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$1$F2DyStdMqjZNRlJodIvXqpmXC8g
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    VoIPService.AnonymousClass1.lambda$run$1(audioManager);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$VoIPService$1() {
            VoIPService.this.soundPool.release();
        }

        static /* synthetic */ void lambda$run$1(AudioManager audioManager) throws IOException {
            synchronized (VoIPService.sync) {
                if (VoIPService.setModeRunnable == null) {
                    return;
                }
                Runnable unused = VoIPService.setModeRunnable = null;
                try {
                    audioManager.setMode(0);
                } catch (SecurityException e) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("Error setting audio more to normal", e);
                    }
                }
            }
        }
    }

    public boolean isFrontFaceCamera() {
        return this.isFrontFaceCamera;
    }

    public boolean isScreencast() {
        return this.isPrivateScreencast;
    }

    public void setMicMute(boolean mute, boolean hold, boolean send) {
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
        if (this.micMute == mute || this.micSwitching) {
            return;
        }
        this.micMute = mute;
        ChatObject.Call call = this.groupCall;
        if (call != null) {
            if (!send && (tLRPC$TL_groupCallParticipant = call.participants.get(getSelfId())) != null && tLRPC$TL_groupCallParticipant.muted && !tLRPC$TL_groupCallParticipant.can_self_unmute) {
                send = true;
            }
            if (send) {
                editCallMember(UserConfig.getInstance(this.currentAccount).getCurrentUser(), Boolean.valueOf(mute), null, null, null, null);
                DispatchQueue dispatchQueue = Utilities.globalQueue;
                Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$pUGP7PYOABRc-m8UkTP-7pzdUF0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setMicMute$0$VoIPService();
                    }
                };
                this.updateNotificationRunnable = runnable;
                dispatchQueue.postRunnable(runnable);
            }
        }
        this.unmutedByHold = !this.micMute && hold;
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[0] != null) {
            nativeInstanceArr[0].setMuteMicrophone(mute);
        }
        Iterator<StateListener> it = this.stateListeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSettingsChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setMicMute$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setMicMute$0$VoIPService() {
        if (this.updateNotificationRunnable == null) {
            return;
        }
        this.updateNotificationRunnable = null;
        TLRPC$Chat tLRPC$Chat = this.chat;
        showNotification(tLRPC$Chat.title, getRoundAvatarBitmap(tLRPC$Chat));
    }

    public boolean mutedByAdmin() {
        ChatObject.Call call = this.groupCall;
        if (call == null) {
            return false;
        }
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = call.participants.get(getSelfId());
        return (tLRPC$TL_groupCallParticipant == null || tLRPC$TL_groupCallParticipant.can_self_unmute || !tLRPC$TL_groupCallParticipant.muted || ChatObject.canManageCalls(this.chat)) ? false : true;
    }

    public boolean hasVideoCapturer() {
        return this.captureDevice[0] != 0;
    }

    public void checkVideoFrame(TLRPC$TL_groupCallParticipant participant, boolean screencast) {
        String str = screencast ? participant.presentationEndpoint : participant.videoEndpoint;
        if (str == null) {
            return;
        }
        if (!screencast || participant.hasPresentationFrame == 0) {
            if (screencast || participant.hasCameraFrame == 0) {
                if (this.proxyVideoSinkLruCache.get(str) != null || (this.remoteSinks.get(str) != null && this.waitingFrameParticipant.get(str) == null)) {
                    if (screencast) {
                        participant.hasPresentationFrame = 2;
                        return;
                    } else {
                        participant.hasCameraFrame = 2;
                        return;
                    }
                }
                if (this.waitingFrameParticipant.containsKey(str)) {
                    this.waitingFrameParticipant.put(str, participant);
                    if (screencast) {
                        participant.hasPresentationFrame = 1;
                        return;
                    } else {
                        participant.hasCameraFrame = 1;
                        return;
                    }
                }
                if (screencast) {
                    participant.hasPresentationFrame = 1;
                } else {
                    participant.hasCameraFrame = 1;
                }
                this.waitingFrameParticipant.put(str, participant);
                addRemoteSink(participant, screencast, new AnonymousClass5(str, screencast), null);
            }
        }
    }

    /* renamed from: ir.eitaa.messenger.voip.VoIPService$5, reason: invalid class name */
    class AnonymousClass5 implements VideoSink {
        final /* synthetic */ String val$endpointId;
        final /* synthetic */ boolean val$screencast;

        @Override // org.webrtc.VideoSink
        public /* synthetic */ void setParentSink(VideoSink videoSink) {
            VideoSink.CC.$default$setParentSink(this, videoSink);
        }

        AnonymousClass5(final String val$endpointId, final boolean val$screencast) {
            this.val$endpointId = val$endpointId;
            this.val$screencast = val$screencast;
        }

        @Override // org.webrtc.VideoSink
        public void onFrame(VideoFrame frame) {
            if (frame == null || frame.getBuffer().getHeight() == 0 || frame.getBuffer().getWidth() == 0) {
                return;
            }
            final String str = this.val$endpointId;
            final boolean z = this.val$screencast;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$5$BfgvsPECB3FKx-8vD7SgysVxzzk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFrame$0$VoIPService$5(str, this, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onFrame$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onFrame$0$VoIPService$5(String str, VideoSink videoSink, boolean z) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = (TLRPC$TL_groupCallParticipant) VoIPService.this.waitingFrameParticipant.remove(str);
            ProxyVideoSink proxyVideoSink = (ProxyVideoSink) VoIPService.this.remoteSinks.get(str);
            if (proxyVideoSink != null && proxyVideoSink.target == videoSink) {
                VoIPService.this.proxyVideoSinkLruCache.put(str, proxyVideoSink);
                VoIPService.this.remoteSinks.remove(str);
                proxyVideoSink.setTarget(null);
            }
            if (tLRPC$TL_groupCallParticipant != null) {
                if (z) {
                    tLRPC$TL_groupCallParticipant.hasPresentationFrame = 2;
                } else {
                    tLRPC$TL_groupCallParticipant.hasCameraFrame = 2;
                }
            }
            ChatObject.Call call = VoIPService.this.groupCall;
            if (call != null) {
                call.updateVisibleParticipants();
            }
        }
    }

    public void clearRemoteSinks() {
        this.proxyVideoSinkLruCache.evictAll();
    }

    public void setAudioRoute(int route) {
        if (route == 1) {
            setAudioOutput(0);
        } else if (route == 0) {
            setAudioOutput(1);
        } else if (route == 2) {
            setAudioOutput(2);
        }
    }

    public static class ProxyVideoSink implements VideoSink {
        private VideoSink background;
        private long nativeInstance;
        private VideoSink target;

        @Override // org.webrtc.VideoSink
        public /* synthetic */ void setParentSink(VideoSink videoSink) {
            VideoSink.CC.$default$setParentSink(this, videoSink);
        }

        @Override // org.webrtc.VideoSink
        public synchronized void onFrame(VideoFrame frame) {
            VideoSink videoSink = this.target;
            if (videoSink != null) {
                videoSink.onFrame(frame);
            }
            VideoSink videoSink2 = this.background;
            if (videoSink2 != null) {
                videoSink2.onFrame(frame);
            }
        }

        public synchronized void setTarget(VideoSink newTarget) {
            VideoSink videoSink = this.target;
            if (videoSink != newTarget) {
                if (videoSink != null) {
                    videoSink.setParentSink(null);
                }
                this.target = newTarget;
                if (newTarget != null) {
                    newTarget.setParentSink(this);
                }
            }
        }

        public synchronized void setBackground(VideoSink newBackground) {
            VideoSink videoSink = this.background;
            if (videoSink != null) {
                videoSink.setParentSink(null);
            }
            this.background = newBackground;
            if (newBackground != null) {
                newBackground.setParentSink(this);
            }
        }

        public synchronized void removeTarget(VideoSink target) {
            if (this.target == target) {
                this.target = null;
            }
        }

        public synchronized void removeBackground(VideoSink background) {
            if (this.background == background) {
                this.background = null;
            }
        }

        public synchronized void swap() {
            VideoSink videoSink;
            if (this.target != null && (videoSink = this.background) != null) {
                this.target = videoSink;
                this.background = null;
            }
        }
    }

    @Override // android.app.Service
    @SuppressLint({"MissingPermission", "InlinedApi"})
    public int onStartCommand(Intent intent, int i, int i2) throws InterruptedException, IOException, RemoteException, NumberFormatException, OperationApplicationException {
        boolean z;
        boolean z2;
        int i3;
        if (sharedInstance != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Tried to start the VoIP service when it's already started");
            }
            return 2;
        }
        int intExtra = intent.getIntExtra("account", -1);
        this.currentAccount = intExtra;
        if (intExtra == -1) {
            throw new IllegalStateException("No account specified when starting VoIP service");
        }
        this.classGuid = ConnectionsManager.generateClassGuid();
        long longExtra = intent.getLongExtra("user_id", 0L);
        long longExtra2 = intent.getLongExtra("chat_id", 0L);
        this.createGroupCall = intent.getBooleanExtra("createGroupCall", false);
        this.hasFewPeers = intent.getBooleanExtra("hasFewPeers", false);
        this.joinHash = intent.getStringExtra("hash");
        long longExtra3 = intent.getLongExtra("peerChannelId", 0L);
        long longExtra4 = intent.getLongExtra("peerChatId", 0L);
        long longExtra5 = intent.getLongExtra("peerUserId", 0L);
        if (longExtra4 != 0) {
            TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            this.groupCallPeer = tLRPC$TL_inputPeerChat;
            tLRPC$TL_inputPeerChat.chat_id = longExtra4;
            tLRPC$TL_inputPeerChat.access_hash = intent.getLongExtra("peerAccessHash", 0L);
        } else if (longExtra3 != 0) {
            TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
            this.groupCallPeer = tLRPC$TL_inputPeerChannel;
            tLRPC$TL_inputPeerChannel.channel_id = longExtra3;
            tLRPC$TL_inputPeerChannel.access_hash = intent.getLongExtra("peerAccessHash", 0L);
        } else if (longExtra5 != 0) {
            TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
            this.groupCallPeer = tLRPC$TL_inputPeerUser;
            tLRPC$TL_inputPeerUser.user_id = longExtra5;
            tLRPC$TL_inputPeerUser.access_hash = intent.getLongExtra("peerAccessHash", 0L);
        }
        this.scheduleDate = intent.getIntExtra("scheduleDate", 0);
        this.isOutgoing = intent.getBooleanExtra("is_outgoing", false);
        this.videoCall = intent.getBooleanExtra("video_call", false);
        this.isVideoAvailable = intent.getBooleanExtra("can_video_call", false);
        this.notificationsDisabled = intent.getBooleanExtra("notifications_disabled", false);
        if (longExtra != 0) {
            this.user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(longExtra));
        }
        if (longExtra2 != 0) {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(longExtra2));
            this.chat = chat;
            if (ChatObject.isChannel(chat)) {
                MessagesController.getInstance(this.currentAccount).startShortPoll(this.chat, this.classGuid, false);
            }
        }
        loadResources();
        int i4 = 0;
        while (true) {
            ProxyVideoSink[] proxyVideoSinkArr = this.localSink;
            if (i4 < proxyVideoSinkArr.length) {
                proxyVideoSinkArr[i4] = new ProxyVideoSink();
                this.remoteSink[i4] = new ProxyVideoSink();
                i4++;
            } else {
                try {
                    break;
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }
        this.isHeadsetPlugged = ((AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isWiredHeadsetOn();
        if (this.chat != null && !this.createGroupCall && MessagesController.getInstance(this.currentAccount).getGroupCall(this.chat.id, false) == null) {
            FileLog.w("VoIPService: trying to open group call without call " + this.chat.id);
            stopSelf();
            return 2;
        }
        if (this.videoCall) {
            if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.CAMERA") == 0) {
                i3 = 0;
                this.captureDevice[0] = NativeInstance.createVideoCapturer(this.localSink[0], this.isFrontFaceCamera ? 1 : 0);
                if (longExtra2 != 0) {
                    this.videoState[0] = 1;
                } else {
                    this.videoState[0] = 2;
                }
            } else {
                i3 = 0;
                this.videoState[0] = 1;
            }
            if (!this.isBtHeadsetConnected && !this.isHeadsetPlugged) {
                setAudioOutput(i3);
            }
        }
        if (this.user == null && this.chat == null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.w("VoIPService: user == null AND chat == null");
            }
            stopSelf();
            return 2;
        }
        sharedInstance = this;
        synchronized (sync) {
            if (setModeRunnable != null) {
                Utilities.globalQueue.cancelRunnable(setModeRunnable);
                setModeRunnable = null;
            }
        }
        if (this.isOutgoing) {
            if (this.user != null) {
                dispatchStateChanged(14);
                if (USE_CONNECTION_SERVICE) {
                    TelecomManager telecomManager = (TelecomManager) getSystemService("telecom");
                    Bundle bundle = new Bundle();
                    Bundle bundle2 = new Bundle();
                    bundle.putParcelable("android.telecom.extra.PHONE_ACCOUNT_HANDLE", addAccountToTelecomManager());
                    bundle2.putInt("call_type", 1);
                    bundle.putBundle("android.telecom.extra.OUTGOING_CALL_EXTRAS", bundle2);
                    ContactsController contactsController = ContactsController.getInstance(this.currentAccount);
                    TLRPC$User tLRPC$User = this.user;
                    contactsController.createOrUpdateConnectionServiceContact(tLRPC$User.id, tLRPC$User.first_name, tLRPC$User.last_name);
                    telecomManager.placeCall(Uri.fromParts("tel", "+99084" + this.user.id, null), bundle);
                } else {
                    Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$QEGIV4T7QCBR8c9Ut6-AwhC_rf0
                        @Override // java.lang.Runnable
                        public final void run() throws IOException {
                            this.f$0.lambda$onStartCommand$1$VoIPService();
                        }
                    };
                    this.delayedStartOutgoingCall = runnable;
                    AndroidUtilities.runOnUIThread(runnable, 2000L);
                }
                z2 = false;
            } else {
                this.micMute = true;
                z2 = false;
                startGroupCall(0, null, false);
                if (!this.isBtHeadsetConnected && !this.isHeadsetPlugged) {
                    setAudioOutput(0);
                }
            }
            if (intent.getBooleanExtra("start_incall_activity", z2)) {
                Intent intentAddFlags = new Intent(this, (Class<?>) LaunchActivity.class).setAction(this.user != null ? "voip" : "voip_chat").addFlags(268435456);
                if (this.chat != null) {
                    intentAddFlags.putExtra("currentAccount", this.currentAccount);
                }
                startActivity(intentAddFlags);
            }
        } else {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.closeInCallActivity, new Object[0]);
            TLRPC$PhoneCall tLRPC$PhoneCall = callIShouldHavePutIntoIntent;
            this.privateCall = tLRPC$PhoneCall;
            boolean z3 = tLRPC$PhoneCall != null && tLRPC$PhoneCall.video;
            this.videoCall = z3;
            if (z3) {
                this.isVideoAvailable = true;
            }
            if (!z3 || this.isBtHeadsetConnected || this.isHeadsetPlugged) {
                z = false;
            } else {
                z = false;
                setAudioOutput(0);
            }
            callIShouldHavePutIntoIntent = null;
            if (USE_CONNECTION_SERVICE) {
                acknowledgeCall(z);
                showNotification();
            } else {
                acknowledgeCall(true);
            }
        }
        initializeAccountRelatedThings();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$g0QYQ7LqOnJYRHD8Uvpnw0cll4w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStartCommand$2$VoIPService();
            }
        });
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onStartCommand$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onStartCommand$1$VoIPService() throws IOException {
        this.delayedStartOutgoingCall = null;
        startOutgoingCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onStartCommand$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onStartCommand$2$VoIPService() {
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.voipServiceCreated, new Object[0]);
    }

    public static VoIPService getSharedInstance() {
        return sharedInstance;
    }

    public TLRPC$User getUser() {
        return this.user;
    }

    public TLRPC$Chat getChat() {
        return this.chat;
    }

    public void setNoiseSupressionEnabled(boolean enabled) {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[0] == null) {
            return;
        }
        nativeInstanceArr[0].setNoiseSuppressionEnabled(enabled);
    }

    public void setGroupCallHash(String hash) {
        if (!this.currentGroupModeStreaming || TextUtils.isEmpty(hash) || hash.equals(this.joinHash)) {
            return;
        }
        this.joinHash = hash;
        createGroupInstance(0, false);
    }

    public long getCallerId() {
        TLRPC$User tLRPC$User = this.user;
        if (tLRPC$User != null) {
            return tLRPC$User.id;
        }
        return -this.chat.id;
    }

    public void hangUp(int discard, Runnable onDone) throws IllegalStateException, InterruptedException {
        int i = this.currentState;
        declineIncomingCall((i == 16 || (i == 13 && this.isOutgoing)) ? 3 : 1, onDone);
        if (this.groupCall == null || discard == 2) {
            return;
        }
        if (discard == 1) {
            TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(this.chat.id);
            if (chatFull != null) {
                chatFull.flags &= -2097153;
                chatFull.call = null;
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chat.id), Long.valueOf(this.groupCall.call.id), Boolean.FALSE);
            }
            TLRPC$TL_phone_discardGroupCall tLRPC$TL_phone_discardGroupCall = new TLRPC$TL_phone_discardGroupCall();
            tLRPC$TL_phone_discardGroupCall.call = this.groupCall.getInputGroupCall();
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_discardGroupCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$tzoFOeeSmKpGcqndXzkh8crsiy8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$hangUp$3$VoIPService(tLObject, tLRPC$TL_error);
                }
            }, 0, 64);
            return;
        }
        TLRPC$TL_phone_leaveGroupCall tLRPC$TL_phone_leaveGroupCall = new TLRPC$TL_phone_leaveGroupCall();
        tLRPC$TL_phone_leaveGroupCall.call = this.groupCall.getInputGroupCall();
        tLRPC$TL_phone_leaveGroupCall.source = this.mySource[0];
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_leaveGroupCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$_VE5xzAfIykhr2UkEzfWgWUBatU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$hangUp$4$VoIPService(tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hangUp$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hangUp$3$VoIPService(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_updates) {
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$TL_updates) tLObject, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hangUp$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hangUp$4$VoIPService(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_updates) {
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$TL_updates) tLObject, false);
        }
    }

    private void startOutgoingCall() throws IOException {
        CallConnection callConnection;
        if (USE_CONNECTION_SERVICE && (callConnection = this.systemCallConnection) != null) {
            callConnection.setDialing();
        }
        configureDeviceForCall();
        showNotification();
        startConnectingSound();
        dispatchStateChanged(14);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$5cOMghyzPb8NWbMsYo7RCpfgE6s
            @Override // java.lang.Runnable
            public final void run() {
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
            }
        });
        Utilities.random.nextBytes(new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES]);
        TLRPC$TL_messages_getDhConfig tLRPC$TL_messages_getDhConfig = new TLRPC$TL_messages_getDhConfig();
        tLRPC$TL_messages_getDhConfig.random_length = Factory.DEVICE_HAS_CRAPPY_OPENSLES;
        final MessagesStorage messagesStorage = MessagesStorage.getInstance(this.currentAccount);
        tLRPC$TL_messages_getDhConfig.version = messagesStorage.getLastSecretVersion();
        this.callReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getDhConfig, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$EXR6W1dCTGT_Y9C_dYOo_YZpgXI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws Exception {
                this.f$0.lambda$startOutgoingCall$10$VoIPService(messagesStorage, tLObject, tLRPC$TL_error);
            }
        }, 2, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startOutgoingCall$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startOutgoingCall$10$VoIPService(MessagesStorage messagesStorage, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws Exception {
        this.callReqId = 0;
        if (this.endCallAfterRequest) {
            callEnded();
            return;
        }
        if (tLRPC$TL_error == null) {
            TLRPC$messages_DhConfig tLRPC$messages_DhConfig = (TLRPC$messages_DhConfig) tLObject;
            if (tLObject instanceof TLRPC$TL_messages_dhConfig) {
                if (!Utilities.isGoodPrime(tLRPC$messages_DhConfig.p, tLRPC$messages_DhConfig.g)) {
                    callFailed();
                    return;
                }
                messagesStorage.setSecretPBytes(tLRPC$messages_DhConfig.p);
                messagesStorage.setSecretG(tLRPC$messages_DhConfig.g);
                messagesStorage.setLastSecretVersion(tLRPC$messages_DhConfig.version);
                messagesStorage.saveSecretParams(messagesStorage.getLastSecretVersion(), messagesStorage.getSecretG(), messagesStorage.getSecretPBytes());
            }
            final byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
            for (int i = 0; i < 256; i++) {
                bArr[i] = (byte) (((byte) (Utilities.random.nextDouble() * 256.0d)) ^ tLRPC$messages_DhConfig.random[i]);
            }
            byte[] byteArray = BigInteger.valueOf(messagesStorage.getSecretG()).modPow(new BigInteger(1, bArr), new BigInteger(1, messagesStorage.getSecretPBytes())).toByteArray();
            if (byteArray.length > 256) {
                byte[] bArr2 = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
                System.arraycopy(byteArray, 1, bArr2, 0, Factory.DEVICE_HAS_CRAPPY_OPENSLES);
                byteArray = bArr2;
            }
            TLRPC$TL_phone_requestCall tLRPC$TL_phone_requestCall = new TLRPC$TL_phone_requestCall();
            tLRPC$TL_phone_requestCall.user_id = MessagesController.getInstance(this.currentAccount).getInputUser(this.user);
            TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol = new TLRPC$TL_phoneCallProtocol();
            tLRPC$TL_phone_requestCall.protocol = tLRPC$TL_phoneCallProtocol;
            tLRPC$TL_phone_requestCall.video = this.videoCall;
            tLRPC$TL_phoneCallProtocol.udp_p2p = true;
            tLRPC$TL_phoneCallProtocol.udp_reflector = true;
            tLRPC$TL_phoneCallProtocol.min_layer = 65;
            tLRPC$TL_phoneCallProtocol.max_layer = Instance.getConnectionMaxLayer();
            tLRPC$TL_phone_requestCall.protocol.library_versions.addAll(Instance.AVAILABLE_VERSIONS);
            this.g_a = byteArray;
            tLRPC$TL_phone_requestCall.g_a_hash = Utilities.computeSHA256(byteArray, 0, byteArray.length);
            tLRPC$TL_phone_requestCall.random_id = Utilities.random.nextInt();
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_requestCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$caMP3erCxTZFobGGZgI_3xhkN0w
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$startOutgoingCall$9$VoIPService(bArr, tLObject2, tLRPC$TL_error2);
                }
            }, 2, 64);
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e("Error on getDhConfig " + tLRPC$TL_error);
        }
        callFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startOutgoingCall$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startOutgoingCall$9$VoIPService(final byte[] bArr, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$mv22PbuRryvJyrYpExJypr7pe_s
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$startOutgoingCall$8$VoIPService(tLRPC$TL_error, tLObject, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startOutgoingCall$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startOutgoingCall$8$VoIPService(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, byte[] bArr) throws Exception {
        if (tLRPC$TL_error == null) {
            this.privateCall = ((TLRPC$TL_phone_phoneCall) tLObject).phone_call;
            this.a_or_b = bArr;
            dispatchStateChanged(13);
            if (this.endCallAfterRequest) {
                hangUp();
                return;
            }
            if (this.pendingUpdates.size() > 0 && this.privateCall != null) {
                Iterator<TLRPC$PhoneCall> it = this.pendingUpdates.iterator();
                while (it.hasNext()) {
                    onCallUpdated(it.next());
                }
                this.pendingUpdates.clear();
            }
            Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$qUzS_OZ5tSRu33OVp-9qLPyfeso
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startOutgoingCall$7$VoIPService();
                }
            };
            this.timeoutRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, MessagesController.getInstance(this.currentAccount).callReceiveTimeout);
            return;
        }
        if (tLRPC$TL_error.code == 400 && "PARTICIPANT_VERSION_OUTDATED".equals(tLRPC$TL_error.text)) {
            callFailed(Instance.ERROR_PEER_OUTDATED);
            return;
        }
        int i = tLRPC$TL_error.code;
        if (i == 403) {
            callFailed(Instance.ERROR_PRIVACY);
            return;
        }
        if (i == 406) {
            callFailed(Instance.ERROR_LOCALIZED);
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e("Error on phone.requestCall: " + tLRPC$TL_error);
        }
        callFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startOutgoingCall$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startOutgoingCall$7$VoIPService() {
        this.timeoutRunnable = null;
        TLRPC$TL_phone_discardCall tLRPC$TL_phone_discardCall = new TLRPC$TL_phone_discardCall();
        TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
        tLRPC$TL_phone_discardCall.peer = tLRPC$TL_inputPhoneCall;
        TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
        tLRPC$TL_inputPhoneCall.access_hash = tLRPC$PhoneCall.access_hash;
        tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
        tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonMissed();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_discardCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$PbwrTExV264EOgj_fipxIg0Mnng
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startOutgoingCall$6$VoIPService(tLObject, tLRPC$TL_error);
            }
        }, 2, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startOutgoingCall$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startOutgoingCall$6$VoIPService(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (BuildVars.LOGS_ENABLED) {
            if (tLRPC$TL_error != null) {
                FileLog.e("error on phone.discardCall: " + tLRPC$TL_error);
            } else {
                FileLog.d("phone.discardCall " + tLObject);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$hbxRpxukpDvJvKUN1Ux9FJRlN9k
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.callFailed();
            }
        });
    }

    private void acknowledgeCall(final boolean startRinging) throws IOException {
        if (this.privateCall instanceof TLRPC$TL_phoneCallDiscarded) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.w("Call " + this.privateCall.id + " was discarded before the service started, stopping");
            }
            stopSelf();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19 && XiaomiUtilities.isMIUI() && !XiaomiUtilities.isCustomPermissionGranted(XiaomiUtilities.OP_SHOW_WHEN_LOCKED) && ((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("MIUI: no permission to show when locked but the screen is locked. ¯\\_(ツ)_/¯");
            }
            stopSelf();
            return;
        }
        TLRPC$TL_phone_receivedCall tLRPC$TL_phone_receivedCall = new TLRPC$TL_phone_receivedCall();
        TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
        tLRPC$TL_phone_receivedCall.peer = tLRPC$TL_inputPhoneCall;
        TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
        tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
        tLRPC$TL_inputPhoneCall.access_hash = tLRPC$PhoneCall.access_hash;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_receivedCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$UC4dl8FeBR_kj6ruv7pw_e88fF0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$acknowledgeCall$12$VoIPService(startRinging, tLObject, tLRPC$TL_error);
            }
        }, 2, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$acknowledgeCall$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$acknowledgeCall$12$VoIPService(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$4agH7EZPJQXDsW2phnusak-0sf8
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, Resources.NotFoundException, PendingIntent.CanceledException, IOException, RemoteException, SecurityException, IllegalArgumentException, OperationApplicationException {
                this.f$0.lambda$acknowledgeCall$11$VoIPService(tLObject, tLRPC$TL_error, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$acknowledgeCall$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$acknowledgeCall$11$VoIPService(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error, boolean z) throws IllegalStateException, Resources.NotFoundException, PendingIntent.CanceledException, IOException, RemoteException, SecurityException, IllegalArgumentException, OperationApplicationException {
        if (sharedInstance == null) {
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.w("receivedCall response = " + tLObject);
        }
        if (tLRPC$TL_error != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("error on receivedCall: " + tLRPC$TL_error);
            }
            stopSelf();
            return;
        }
        if (USE_CONNECTION_SERVICE) {
            ContactsController contactsController = ContactsController.getInstance(this.currentAccount);
            TLRPC$User tLRPC$User = this.user;
            contactsController.createOrUpdateConnectionServiceContact(tLRPC$User.id, tLRPC$User.first_name, tLRPC$User.last_name);
            TelecomManager telecomManager = (TelecomManager) getSystemService("telecom");
            Bundle bundle = new Bundle();
            bundle.putInt("call_type", 1);
            telecomManager.addNewIncomingCall(addAccountToTelecomManager(), bundle);
        }
        if (z) {
            startRinging();
        }
    }

    private boolean isRinging() {
        return this.currentState == 15;
    }

    public boolean isJoined() {
        int i = this.currentState;
        return (i == 1 || i == 6) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestVideoCall(boolean r9) {
        /*
            r8 = this;
            ir.eitaa.messenger.voip.NativeInstance[] r0 = r8.tgVoip
            r1 = 0
            r2 = r0[r1]
            if (r2 != 0) goto L8
            return
        L8:
            if (r9 != 0) goto L20
            long[] r2 = r8.captureDevice
            r3 = r2[r1]
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L20
            r0 = r0[r1]
            r3 = r2[r1]
            r0.setupOutgoingVideoCreated(r3)
            boolean[] r0 = r8.destroyCaptureDevice
            r0[r1] = r1
            goto L32
        L20:
            r0 = r0[r1]
            ir.eitaa.messenger.voip.VoIPService$ProxyVideoSink[] r2 = r8.localSink
            r2 = r2[r1]
            if (r9 == 0) goto L2a
            r1 = 2
            goto L2f
        L2a:
            boolean r3 = r8.isFrontFaceCamera
            if (r3 == 0) goto L2f
            r1 = 1
        L2f:
            r0.setupOutgoingVideo(r2, r1)
        L32:
            r8.isPrivateScreencast = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.voip.VoIPService.requestVideoCall(boolean):void");
    }

    public void switchCamera() {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[0] == null || !nativeInstanceArr[0].hasVideoCapturer() || this.switchingCamera) {
            long[] jArr = this.captureDevice;
            if (jArr[0] == 0 || this.switchingCamera) {
                return;
            }
            NativeInstance.switchCameraCapturer(jArr[0], !this.isFrontFaceCamera);
            return;
        }
        this.switchingCamera = true;
        this.tgVoip[0].switchCamera(!this.isFrontFaceCamera);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public void createCaptureDevice(boolean z) {
        ?? r1 = z ? 2 : this.isFrontFaceCamera;
        if (this.groupCall == null) {
            if (!this.isPrivateScreencast && z) {
                setVideoState(false, 0);
            }
            this.isPrivateScreencast = z;
            NativeInstance[] nativeInstanceArr = this.tgVoip;
            if (nativeInstanceArr[0] != null) {
                nativeInstanceArr[0].clearVideoCapturer();
            }
        }
        if (z) {
            if (this.groupCall != null) {
                long[] jArr = this.captureDevice;
                if (jArr[z ? 1 : 0] != 0) {
                    return;
                }
                jArr[z ? 1 : 0] = NativeInstance.createVideoCapturer(this.localSink[z ? 1 : 0], r1);
                createGroupInstance(1, false);
                setVideoState(true, 2);
                AccountInstance.getInstance(this.currentAccount).getNotificationCenter().postNotificationName(NotificationCenter.groupCallScreencastStateChanged, new Object[0]);
                return;
            }
            requestVideoCall(true);
            setVideoState(true, 2);
            if (VoIPFragment.getInstance() != null) {
                VoIPFragment.getInstance().onScreenCastStart();
                return;
            }
            return;
        }
        long[] jArr2 = this.captureDevice;
        if (jArr2[z ? 1 : 0] != 0 || this.tgVoip[z ? 1 : 0] == null) {
            NativeInstance[] nativeInstanceArr2 = this.tgVoip;
            if (nativeInstanceArr2[z ? 1 : 0] != null && jArr2[z ? 1 : 0] != 0) {
                nativeInstanceArr2[z ? 1 : 0].activateVideoCapturer(jArr2[z ? 1 : 0]);
            }
            if (this.captureDevice[z ? 1 : 0] != 0) {
                return;
            }
        }
        this.captureDevice[z ? 1 : 0] = NativeInstance.createVideoCapturer(this.localSink[z ? 1 : 0], r1);
    }

    public void setupCaptureDevice(boolean z, boolean z2) {
        if (!z) {
            long[] jArr = this.captureDevice;
            if (jArr[z ? 1 : 0] == 0) {
                return;
            }
            NativeInstance[] nativeInstanceArr = this.tgVoip;
            if (nativeInstanceArr[z ? 1 : 0] == null) {
                return;
            }
            nativeInstanceArr[z ? 1 : 0].setupOutgoingVideoCreated(jArr[z ? 1 : 0]);
            this.destroyCaptureDevice[z ? 1 : 0] = false;
            this.videoState[z ? 1 : 0] = 2;
        }
        if (this.micMute == z2) {
            setMicMute(!z2, false, false);
            this.micSwitching = true;
        }
        if (this.groupCall != null) {
            editCallMember(UserConfig.getInstance(this.currentAccount).getCurrentUser(), Boolean.valueOf(!z2), Boolean.valueOf(this.videoState[0] != 2), null, null, new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$218o4hu8ha13HaljCg0WYYcYAQg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setupCaptureDevice$13$VoIPService();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupCaptureDevice$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setupCaptureDevice$13$VoIPService() {
        this.micSwitching = false;
    }

    public void clearCamera() {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[0] != null) {
            nativeInstanceArr[0].clearVideoCapturer();
        }
    }

    public void setVideoState(boolean z, int i) {
        int i2;
        char c = this.groupCall != null ? z ? 1 : 0 : (char) 0;
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[c] == null) {
            long[] jArr = this.captureDevice;
            if (jArr[z ? 1 : 0] != 0) {
                int[] iArr = this.videoState;
                iArr[c] = i;
                NativeInstance.setVideoStateCapturer(jArr[z ? 1 : 0], iArr[c]);
                return;
            } else {
                if (i != 2 || (i2 = this.currentState) == 17 || i2 == 11) {
                    return;
                }
                jArr[z ? 1 : 0] = NativeInstance.createVideoCapturer(this.localSink[c], this.isFrontFaceCamera ? 1 : 0);
                this.videoState[c] = 2;
                return;
            }
        }
        int[] iArr2 = this.videoState;
        iArr2[c] = i;
        nativeInstanceArr[c].setVideoState(iArr2[c]);
        long[] jArr2 = this.captureDevice;
        if (jArr2[z ? 1 : 0] != 0) {
            NativeInstance.setVideoStateCapturer(jArr2[z ? 1 : 0], this.videoState[c]);
        }
        if (z) {
            return;
        }
        if (this.groupCall != null) {
            editCallMember(UserConfig.getInstance(this.currentAccount).getCurrentUser(), null, Boolean.valueOf(this.videoState[0] != 2), null, null, null);
        }
        checkIsNear();
    }

    public void sendBitrateUpdated(boolean enableHighBitrate) {
        this.tgVoip[0].sendBitrateUpdated(enableHighBitrate);
    }

    public void stopScreenCapture() {
        if (this.groupCall == null || this.videoState[1] != 2) {
            return;
        }
        TLRPC$TL_phone_leaveGroupCallPresentation tLRPC$TL_phone_leaveGroupCallPresentation = new TLRPC$TL_phone_leaveGroupCallPresentation();
        tLRPC$TL_phone_leaveGroupCallPresentation.call = this.groupCall.getInputGroupCall();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_leaveGroupCallPresentation, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$syMDUyTn_GLAeM-LEuBxjH-OPLA
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$stopScreenCapture$14$VoIPService(tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
        NativeInstance nativeInstance = this.tgVoip[1];
        if (nativeInstance != null) {
            Utilities.globalQueue.postRunnable(new $$Lambda$xmImj2EkjnYcdM0GeYy5ctwRwME(nativeInstance));
        }
        this.mySource[1] = 0;
        this.tgVoip[1] = null;
        this.destroyCaptureDevice[1] = true;
        this.captureDevice[1] = 0;
        this.videoState[1] = 0;
        AccountInstance.getInstance(this.currentAccount).getNotificationCenter().postNotificationName(NotificationCenter.groupCallScreencastStateChanged, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$stopScreenCapture$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$stopScreenCapture$14$VoIPService(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public int getVideoState(boolean z) {
        return this.videoState[z ? 1 : 0];
    }

    public void setSinks(VideoSink local, VideoSink remote) {
        setSinks(local, false, remote);
    }

    public void setSinks(VideoSink videoSink, boolean z, VideoSink videoSink2) {
        this.localSink[z ? 1 : 0].setTarget(videoSink);
        this.remoteSink[z ? 1 : 0].setTarget(videoSink2);
    }

    public void setLocalSink(VideoSink local, boolean screencast) {
        if (screencast) {
            return;
        }
        this.localSink[0].setTarget(local);
    }

    public void setRemoteSink(VideoSink videoSink, boolean z) {
        this.remoteSink[z ? 1 : 0].setTarget(videoSink);
    }

    public ProxyVideoSink addRemoteSink(TLRPC$TL_groupCallParticipant participant, boolean screencast, VideoSink remote, VideoSink background) {
        if (this.tgVoip[0] == null) {
            return null;
        }
        String str = screencast ? participant.presentationEndpoint : participant.videoEndpoint;
        if (str == null) {
            return null;
        }
        ProxyVideoSink proxyVideoSink = this.remoteSinks.get(str);
        if (proxyVideoSink != null && proxyVideoSink.target == remote) {
            return proxyVideoSink;
        }
        if (proxyVideoSink == null) {
            proxyVideoSink = this.proxyVideoSinkLruCache.remove(str);
        }
        if (proxyVideoSink == null) {
            proxyVideoSink = new ProxyVideoSink();
        }
        if (remote != null) {
            proxyVideoSink.setTarget(remote);
        }
        if (background != null) {
            proxyVideoSink.setBackground(background);
        }
        this.remoteSinks.put(str, proxyVideoSink);
        proxyVideoSink.nativeInstance = this.tgVoip[0].addIncomingVideoOutput(1, str, createSsrcGroups(screencast ? participant.presentation : participant.video), proxyVideoSink);
        return proxyVideoSink;
    }

    private NativeInstance.SsrcGroup[] createSsrcGroups(TLRPC$TL_groupCallParticipantVideo video) {
        if (video.source_groups.isEmpty()) {
            return null;
        }
        int size = video.source_groups.size();
        NativeInstance.SsrcGroup[] ssrcGroupArr = new NativeInstance.SsrcGroup[size];
        for (int i = 0; i < size; i++) {
            ssrcGroupArr[i] = new NativeInstance.SsrcGroup();
            TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup = video.source_groups.get(i);
            ssrcGroupArr[i].semantics = tLRPC$TL_groupCallParticipantVideoSourceGroup.semantics;
            ssrcGroupArr[i].ssrcs = new int[tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.size()];
            for (int i2 = 0; i2 < ssrcGroupArr[i].ssrcs.length; i2++) {
                ssrcGroupArr[i].ssrcs[i2] = tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.get(i2).intValue();
            }
        }
        return ssrcGroupArr;
    }

    public void requestFullScreen(TLRPC$TL_groupCallParticipant participant, boolean full, boolean screencast) {
        String str = screencast ? participant.presentationEndpoint : participant.videoEndpoint;
        if (str == null) {
            return;
        }
        if (full) {
            this.tgVoip[0].setVideoEndpointQuality(str, 2);
        } else {
            this.tgVoip[0].setVideoEndpointQuality(str, 1);
        }
    }

    public void removeRemoteSink(TLRPC$TL_groupCallParticipant participant, boolean presentation) {
        if (presentation) {
            ProxyVideoSink proxyVideoSinkRemove = this.remoteSinks.remove(participant.presentationEndpoint);
            if (proxyVideoSinkRemove != null) {
                this.tgVoip[0].removeIncomingVideoOutput(proxyVideoSinkRemove.nativeInstance);
                return;
            }
            return;
        }
        ProxyVideoSink proxyVideoSinkRemove2 = this.remoteSinks.remove(participant.videoEndpoint);
        if (proxyVideoSinkRemove2 != null) {
            this.tgVoip[0].removeIncomingVideoOutput(proxyVideoSinkRemove2.nativeInstance);
        }
    }

    public boolean isFullscreen(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, boolean z) {
        if (this.currentBackgroundSink[z ? 1 : 0] != null) {
            if (TextUtils.equals(this.currentBackgroundEndpointId[z ? 1 : 0], z ? tLRPC$TL_groupCallParticipant.presentationEndpoint : tLRPC$TL_groupCallParticipant.videoEndpoint)) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundSinks(VideoSink local, VideoSink remote) {
        this.localSink[0].setBackground(local);
        this.remoteSink[0].setBackground(remote);
    }

    public void swapSinks() {
        this.localSink[0].swap();
        this.remoteSink[0].swap();
    }

    public boolean isHangingUp() {
        return this.currentState == 10;
    }

    public void onSignalingData(TLRPC$TL_updatePhoneCallSignalingData data) {
        if (this.user != null) {
            NativeInstance[] nativeInstanceArr = this.tgVoip;
            if (nativeInstanceArr[0] == null || nativeInstanceArr[0].isGroup() || getCallID() != data.phone_call_id) {
                return;
            }
            this.tgVoip[0].onSignalingDataReceive(data.data);
        }
    }

    public long getSelfId() {
        TLRPC$InputPeer tLRPC$InputPeer = this.groupCallPeer;
        if (tLRPC$InputPeer == null) {
            return UserConfig.getInstance(this.currentAccount).clientUserId;
        }
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
            return tLRPC$InputPeer.user_id;
        }
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChannel) {
            return -tLRPC$InputPeer.channel_id;
        }
        return -tLRPC$InputPeer.chat_id;
    }

    public void onGroupCallParticipantsUpdate(TLRPC$TL_updateGroupCallParticipants update) {
        ChatObject.Call call;
        if (this.chat == null || (call = this.groupCall) == null || call.call.id != update.call.id) {
            return;
        }
        long selfId = getSelfId();
        int size = update.participants.size();
        for (int i = 0; i < size; i++) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = update.participants.get(i);
            if (tLRPC$TL_groupCallParticipant.left) {
                int i2 = tLRPC$TL_groupCallParticipant.source;
                if (i2 != 0 && i2 == this.mySource[0]) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < size; i4++) {
                        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = update.participants.get(i4);
                        if (tLRPC$TL_groupCallParticipant2.self || tLRPC$TL_groupCallParticipant2.source == this.mySource[0]) {
                            i3++;
                        }
                    }
                    if (i3 > 1) {
                        hangUp(2);
                        return;
                    }
                }
            } else if (MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) == selfId) {
                int i5 = tLRPC$TL_groupCallParticipant.source;
                int[] iArr = this.mySource;
                if (i5 != iArr[0] && iArr[0] != 0 && i5 != 0) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("source mismatch my = " + this.mySource[0] + " psrc = " + tLRPC$TL_groupCallParticipant.source);
                    }
                    hangUp(2);
                    return;
                }
                if (ChatObject.isChannel(this.chat) && this.currentGroupModeStreaming && tLRPC$TL_groupCallParticipant.can_self_unmute) {
                    this.switchingStream = true;
                    createGroupInstance(0, false);
                }
                if (tLRPC$TL_groupCallParticipant.muted) {
                    setMicMute(true, false, false);
                }
            } else {
                continue;
            }
        }
    }

    public void onGroupCallUpdated(TLRPC$GroupCall call) {
        ChatObject.Call call2;
        boolean zOptBoolean;
        TLRPC$TL_dataJSON tLRPC$TL_dataJSON;
        if (this.chat == null || (call2 = this.groupCall) == null) {
            return;
        }
        TLRPC$GroupCall tLRPC$GroupCall = call2.call;
        if (tLRPC$GroupCall.id != call.id) {
            return;
        }
        if (tLRPC$GroupCall instanceof TLRPC$TL_groupCallDiscarded) {
            hangUp(2);
            return;
        }
        if (this.myParams != null) {
            try {
                zOptBoolean = new JSONObject(this.myParams.data).optBoolean("stream");
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else {
            zOptBoolean = false;
        }
        if ((this.currentState == 1 || zOptBoolean != this.currentGroupModeStreaming) && (tLRPC$TL_dataJSON = this.myParams) != null) {
            if (this.playedConnectedSound && zOptBoolean != this.currentGroupModeStreaming) {
                this.switchingStream = true;
            }
            this.currentGroupModeStreaming = zOptBoolean;
            try {
                if (zOptBoolean) {
                    this.tgVoip[0].prepareForStream();
                } else {
                    this.tgVoip[0].setJoinResponsePayload(tLRPC$TL_dataJSON.data);
                }
                dispatchStateChanged(2);
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCallUpdated(ir.eitaa.tgnet.TLRPC$PhoneCall r7) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.voip.VoIPService.onCallUpdated(ir.eitaa.tgnet.TLRPC$PhoneCall):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCallUpdated$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCallUpdated$15$VoIPService() {
        this.soundPool.play(this.spBusyId, 1.0f, 1.0f, 0, -1, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCallUpdated$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCallUpdated$16$VoIPService() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
        }
        this.spPlayId = this.soundPool.play(this.spRingbackID, 1.0f, 1.0f, 0, -1, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCallUpdated$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCallUpdated$17$VoIPService() throws IllegalStateException, InterruptedException {
        this.timeoutRunnable = null;
        declineIncomingCall(3, null);
    }

    private void startRatingActivity() throws PendingIntent.CanceledException, IOException {
        try {
            PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) VoIPFeedbackActivity.class).putExtra("call_id", this.privateCall.id).putExtra("call_access_hash", this.privateCall.access_hash).putExtra("call_video", this.privateCall.video).putExtra("account", this.currentAccount).addFlags(805306368), 0).send();
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error starting incall activity", e);
            }
        }
    }

    public byte[] getEncryptionKey() {
        return this.authKey;
    }

    private void processAcceptedCall() throws Exception {
        byte[] bArr;
        dispatchStateChanged(12);
        BigInteger bigInteger = new BigInteger(1, MessagesStorage.getInstance(this.currentAccount).getSecretPBytes());
        BigInteger bigInteger2 = new BigInteger(1, this.privateCall.g_b);
        if (!Utilities.isGoodGaAndGb(bigInteger2, bigInteger)) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.w("stopping VoIP service, bad Ga and Gb");
            }
            callFailed();
            return;
        }
        byte[] byteArray = bigInteger2.modPow(new BigInteger(1, this.a_or_b), bigInteger).toByteArray();
        if (byteArray.length > 256) {
            bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
            System.arraycopy(byteArray, byteArray.length - Factory.DEVICE_HAS_CRAPPY_OPENSLES, bArr, 0, Factory.DEVICE_HAS_CRAPPY_OPENSLES);
        } else {
            if (byteArray.length < 256) {
                bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
                System.arraycopy(byteArray, 0, bArr, 256 - byteArray.length, byteArray.length);
                for (int i = 0; i < 256 - byteArray.length; i++) {
                    bArr[i] = 0;
                }
            }
            byte[] bArrComputeSHA1 = Utilities.computeSHA1(byteArray);
            byte[] bArr2 = new byte[8];
            System.arraycopy(bArrComputeSHA1, bArrComputeSHA1.length - 8, bArr2, 0, 8);
            long jBytesToLong = Utilities.bytesToLong(bArr2);
            this.authKey = byteArray;
            this.keyFingerprint = jBytesToLong;
            TLRPC$TL_phone_confirmCall tLRPC$TL_phone_confirmCall = new TLRPC$TL_phone_confirmCall();
            tLRPC$TL_phone_confirmCall.g_a = this.g_a;
            tLRPC$TL_phone_confirmCall.key_fingerprint = jBytesToLong;
            TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
            tLRPC$TL_phone_confirmCall.peer = tLRPC$TL_inputPhoneCall;
            TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
            tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
            tLRPC$TL_inputPhoneCall.access_hash = tLRPC$PhoneCall.access_hash;
            TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol = new TLRPC$TL_phoneCallProtocol();
            tLRPC$TL_phone_confirmCall.protocol = tLRPC$TL_phoneCallProtocol;
            tLRPC$TL_phoneCallProtocol.max_layer = Instance.getConnectionMaxLayer();
            TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol2 = tLRPC$TL_phone_confirmCall.protocol;
            tLRPC$TL_phoneCallProtocol2.min_layer = 65;
            tLRPC$TL_phoneCallProtocol2.udp_reflector = true;
            tLRPC$TL_phoneCallProtocol2.udp_p2p = true;
            tLRPC$TL_phoneCallProtocol2.library_versions.addAll(Instance.AVAILABLE_VERSIONS);
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_confirmCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$CyjRE-HGtDlsrm8Wqoo_2Iagq5I
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$processAcceptedCall$19$VoIPService(tLObject, tLRPC$TL_error);
                }
            }, 0, 64);
        }
        byteArray = bArr;
        byte[] bArrComputeSHA12 = Utilities.computeSHA1(byteArray);
        byte[] bArr22 = new byte[8];
        System.arraycopy(bArrComputeSHA12, bArrComputeSHA12.length - 8, bArr22, 0, 8);
        long jBytesToLong2 = Utilities.bytesToLong(bArr22);
        this.authKey = byteArray;
        this.keyFingerprint = jBytesToLong2;
        TLRPC$TL_phone_confirmCall tLRPC$TL_phone_confirmCall2 = new TLRPC$TL_phone_confirmCall();
        tLRPC$TL_phone_confirmCall2.g_a = this.g_a;
        tLRPC$TL_phone_confirmCall2.key_fingerprint = jBytesToLong2;
        TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall2 = new TLRPC$TL_inputPhoneCall();
        tLRPC$TL_phone_confirmCall2.peer = tLRPC$TL_inputPhoneCall2;
        TLRPC$PhoneCall tLRPC$PhoneCall2 = this.privateCall;
        tLRPC$TL_inputPhoneCall2.id = tLRPC$PhoneCall2.id;
        tLRPC$TL_inputPhoneCall2.access_hash = tLRPC$PhoneCall2.access_hash;
        TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol3 = new TLRPC$TL_phoneCallProtocol();
        tLRPC$TL_phone_confirmCall2.protocol = tLRPC$TL_phoneCallProtocol3;
        tLRPC$TL_phoneCallProtocol3.max_layer = Instance.getConnectionMaxLayer();
        TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol22 = tLRPC$TL_phone_confirmCall2.protocol;
        tLRPC$TL_phoneCallProtocol22.min_layer = 65;
        tLRPC$TL_phoneCallProtocol22.udp_reflector = true;
        tLRPC$TL_phoneCallProtocol22.udp_p2p = true;
        tLRPC$TL_phoneCallProtocol22.library_versions.addAll(Instance.AVAILABLE_VERSIONS);
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_confirmCall2, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$CyjRE-HGtDlsrm8Wqoo_2Iagq5I
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$processAcceptedCall$19$VoIPService(tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processAcceptedCall$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processAcceptedCall$19$VoIPService(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$mkMzL20fwvSwGKcF8y7_S7_tn7k
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$processAcceptedCall$18$VoIPService(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processAcceptedCall$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processAcceptedCall$18$VoIPService(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) throws Exception {
        if (tLRPC$TL_error != null) {
            callFailed();
        } else {
            this.privateCall = ((TLRPC$TL_phone_phoneCall) tLObject).phone_call;
            initiateActualEncryptedCall();
        }
    }

    private int convertDataSavingMode(int i) {
        return i != 3 ? i : ApplicationLoader.isRoaming() ? 1 : 0;
    }

    public void migrateToChat(TLRPC$Chat newChat) {
        this.chat = newChat;
    }

    public void setGroupCallPeer(TLRPC$InputPeer peer) {
        ChatObject.Call call = this.groupCall;
        if (call == null) {
            return;
        }
        this.groupCallPeer = peer;
        call.setSelfPeer(peer);
        TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(this.groupCall.chatId);
        if (chatFull != null) {
            TLRPC$Peer tLRPC$Peer = this.groupCall.selfPeer;
            chatFull.groupcall_default_join_as = tLRPC$Peer;
            if (tLRPC$Peer != null) {
                if (chatFull instanceof TLRPC$TL_chatFull) {
                    chatFull.flags |= 32768;
                } else {
                    chatFull.flags |= ConnectionsManager.FileTypeFile;
                }
            } else if (chatFull instanceof TLRPC$TL_chatFull) {
                chatFull.flags &= -32769;
            } else {
                chatFull.flags &= -67108865;
            }
        }
        createGroupInstance(0, true);
        if (this.videoState[1] == 2) {
            createGroupInstance(1, true);
        }
    }

    private void startGroupCall(final int ssrc, String json, final boolean create) throws IOException {
        if (sharedInstance != this) {
            return;
        }
        if (this.createGroupCall) {
            ChatObject.Call call = new ChatObject.Call();
            this.groupCall = call;
            call.call = new TLRPC$TL_groupCall();
            ChatObject.Call call2 = this.groupCall;
            TLRPC$GroupCall tLRPC$GroupCall = call2.call;
            tLRPC$GroupCall.participants_count = 0;
            tLRPC$GroupCall.version = 1;
            tLRPC$GroupCall.can_start_video = true;
            tLRPC$GroupCall.can_change_join_muted = true;
            call2.chatId = this.chat.id;
            call2.currentAccount = AccountInstance.getInstance(this.currentAccount);
            this.groupCall.setSelfPeer(this.groupCallPeer);
            this.groupCall.createNoVideoParticipant();
            dispatchStateChanged(6);
            TLRPC$TL_phone_createGroupCall tLRPC$TL_phone_createGroupCall = new TLRPC$TL_phone_createGroupCall();
            tLRPC$TL_phone_createGroupCall.peer = MessagesController.getInputPeer(this.chat);
            tLRPC$TL_phone_createGroupCall.random_id = Utilities.random.nextInt();
            int i = this.scheduleDate;
            if (i != 0) {
                tLRPC$TL_phone_createGroupCall.schedule_date = i;
                tLRPC$TL_phone_createGroupCall.flags |= 2;
            }
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_createGroupCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$OAWeMup79OgS5FMcT4pdLvWzoP8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$startGroupCall$22$VoIPService(tLObject, tLRPC$TL_error);
                }
            }, 2, 64);
            this.createGroupCall = false;
            return;
        }
        if (json == null) {
            if (this.groupCall == null) {
                ChatObject.Call groupCall = MessagesController.getInstance(this.currentAccount).getGroupCall(this.chat.id, false);
                this.groupCall = groupCall;
                if (groupCall != null) {
                    groupCall.setSelfPeer(this.groupCallPeer);
                }
            }
            configureDeviceForCall();
            showNotification();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$PCgVWgbATX3L8SFYRkvufM32jnc
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
                }
            });
            createGroupInstance(0, false);
            return;
        }
        if (getSharedInstance() == null || this.groupCall == null) {
            return;
        }
        dispatchStateChanged(1);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("initital source = " + ssrc);
        }
        TLRPC$TL_phone_joinGroupCall tLRPC$TL_phone_joinGroupCall = new TLRPC$TL_phone_joinGroupCall();
        tLRPC$TL_phone_joinGroupCall.muted = true;
        tLRPC$TL_phone_joinGroupCall.video_stopped = this.videoState[0] != 2;
        tLRPC$TL_phone_joinGroupCall.call = this.groupCall.getInputGroupCall();
        TLRPC$TL_dataJSON tLRPC$TL_dataJSON = new TLRPC$TL_dataJSON();
        tLRPC$TL_phone_joinGroupCall.params = tLRPC$TL_dataJSON;
        tLRPC$TL_dataJSON.data = json;
        if (!TextUtils.isEmpty(this.joinHash)) {
            tLRPC$TL_phone_joinGroupCall.invite_hash = this.joinHash;
            tLRPC$TL_phone_joinGroupCall.flags |= 2;
        }
        TLRPC$InputPeer tLRPC$InputPeer = this.groupCallPeer;
        if (tLRPC$InputPeer != null) {
            tLRPC$TL_phone_joinGroupCall.join_as = tLRPC$InputPeer;
        } else {
            TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
            tLRPC$TL_phone_joinGroupCall.join_as = tLRPC$TL_inputPeerUser;
            tLRPC$TL_inputPeerUser.user_id = AccountInstance.getInstance(this.currentAccount).getUserConfig().getClientUserId();
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_joinGroupCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$l_KlyGqpYKCngl7dfOmbfPU9obo
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startGroupCall$28$VoIPService(ssrc, create, tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCall$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCall$22$VoIPService(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            int i = 0;
            while (true) {
                if (i >= tLRPC$Updates.updates.size()) {
                    break;
                }
                TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i);
                if (tLRPC$Update instanceof TLRPC$TL_updateGroupCall) {
                    final TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall = (TLRPC$TL_updateGroupCall) tLRPC$Update;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$6Pfz2w5zbRoFGJmuPYr60GRnxYE
                        @Override // java.lang.Runnable
                        public final void run() throws IOException {
                            this.f$0.lambda$startGroupCall$20$VoIPService(tLRPC$TL_updateGroupCall);
                        }
                    });
                    break;
                }
                i++;
            }
            MessagesController.getInstance(this.currentAccount).processUpdates(tLRPC$Updates, false);
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$sq0X0Ph0bqLXE0rsaxWS337EWA0
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, InterruptedException {
                this.f$0.lambda$startGroupCall$21$VoIPService(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCall$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCall$20$VoIPService(TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall) throws IOException {
        if (sharedInstance == null) {
            return;
        }
        TLRPC$GroupCall tLRPC$GroupCall = this.groupCall.call;
        TLRPC$GroupCall tLRPC$GroupCall2 = tLRPC$TL_updateGroupCall.call;
        tLRPC$GroupCall.access_hash = tLRPC$GroupCall2.access_hash;
        tLRPC$GroupCall.id = tLRPC$GroupCall2.id;
        MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
        ChatObject.Call call = this.groupCall;
        messagesController.putGroupCall(call.chatId, call);
        startGroupCall(0, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCall$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCall$21$VoIPService(TLRPC$TL_error tLRPC$TL_error) throws IllegalStateException, InterruptedException {
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.needShowAlert, 6, tLRPC$TL_error.text);
        hangUp(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCall$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCall$24$VoIPService(int i) {
        this.mySource[0] = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCall$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCall$28$VoIPService(final int i, final boolean z, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$9nj4A-g2aWR_eKg82Rj8DnG1TyY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startGroupCall$24$VoIPService(i);
                }
            });
            TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            long selfId = getSelfId();
            int size = tLRPC$Updates.updates.size();
            for (int i2 = 0; i2 < size; i2++) {
                TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i2);
                if (tLRPC$Update instanceof TLRPC$TL_updateGroupCallParticipants) {
                    TLRPC$TL_updateGroupCallParticipants tLRPC$TL_updateGroupCallParticipants = (TLRPC$TL_updateGroupCallParticipants) tLRPC$Update;
                    int size2 = tLRPC$TL_updateGroupCallParticipants.participants.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 < size2) {
                            final TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = tLRPC$TL_updateGroupCallParticipants.participants.get(i3);
                            if (MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) == selfId) {
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$Ghk6C2KXYp5RxSPYCVi3H7b6jjY
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$startGroupCall$25$VoIPService(tLRPC$TL_groupCallParticipant);
                                    }
                                });
                                if (BuildVars.LOGS_ENABLED) {
                                    FileLog.d("join source = " + tLRPC$TL_groupCallParticipant.source);
                                }
                            } else {
                                i3++;
                            }
                        }
                    }
                } else if (tLRPC$Update instanceof TLRPC$TL_updateGroupCallConnection) {
                    TLRPC$TL_updateGroupCallConnection tLRPC$TL_updateGroupCallConnection = (TLRPC$TL_updateGroupCallConnection) tLRPC$Update;
                    if (!tLRPC$TL_updateGroupCallConnection.presentation) {
                        this.myParams = tLRPC$TL_updateGroupCallConnection.params;
                    }
                }
            }
            MessagesController.getInstance(this.currentAccount).processUpdates(tLRPC$Updates, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$VdWpC6CdxTCWv5nMOJBkvzyvJ9g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startGroupCall$26$VoIPService(z);
                }
            });
            startGroupCheckShortpoll();
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$xeiVWR2xSk0m65ZNWeaFMHXEptY
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, InterruptedException {
                this.f$0.lambda$startGroupCall$27$VoIPService(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCall$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCall$25$VoIPService(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant) {
        this.mySource[0] = tLRPC$TL_groupCallParticipant.source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCall$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCall$26$VoIPService(boolean z) {
        this.groupCall.loadMembers(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCall$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCall$27$VoIPService(TLRPC$TL_error tLRPC$TL_error) throws IllegalStateException, InterruptedException {
        if ("JOIN_AS_PEER_INVALID".equals(tLRPC$TL_error.text)) {
            TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(this.chat.id);
            if (chatFull != null) {
                if (chatFull instanceof TLRPC$TL_chatFull) {
                    chatFull.flags &= -32769;
                } else {
                    chatFull.flags &= -67108865;
                }
                chatFull.groupcall_default_join_as = null;
                JoinCallAlert.resetCache();
            }
            hangUp(2);
            return;
        }
        if ("GROUPCALL_SSRC_DUPLICATE_MUCH".equals(tLRPC$TL_error.text)) {
            createGroupInstance(0, false);
            return;
        }
        if ("GROUPCALL_INVALID".equals(tLRPC$TL_error.text)) {
            MessagesController.getInstance(this.currentAccount).loadFullChat(this.chat.id, 0, true);
        }
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.needShowAlert, 6, tLRPC$TL_error.text);
        hangUp(0);
    }

    private void startScreenCapture(final int ssrc, String json) {
        if (getSharedInstance() == null || this.groupCall == null) {
            return;
        }
        this.mySource[1] = 0;
        TLRPC$TL_phone_joinGroupCallPresentation tLRPC$TL_phone_joinGroupCallPresentation = new TLRPC$TL_phone_joinGroupCallPresentation();
        tLRPC$TL_phone_joinGroupCallPresentation.call = this.groupCall.getInputGroupCall();
        TLRPC$TL_dataJSON tLRPC$TL_dataJSON = new TLRPC$TL_dataJSON();
        tLRPC$TL_phone_joinGroupCallPresentation.params = tLRPC$TL_dataJSON;
        tLRPC$TL_dataJSON.data = json;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_joinGroupCallPresentation, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$8IyGxakHXccQ1VPJDuIeHKNg4R4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startScreenCapture$32$VoIPService(ssrc, tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startScreenCapture$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startScreenCapture$29$VoIPService(int i) {
        this.mySource[1] = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startScreenCapture$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startScreenCapture$32$VoIPService(final int i, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$INfXYrPi-dRPF_teUnp4EJse1uo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startScreenCapture$29$VoIPService(i);
                }
            });
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$yq-nV4vw79oHguoe0y88IegPOZ4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startScreenCapture$30$VoIPService(tLRPC$Updates);
                }
            });
            MessagesController.getInstance(this.currentAccount).processUpdates(tLRPC$Updates, false);
            startGroupCheckShortpoll();
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$tabuVRuAHg7PfOQtYY-mNUpLxqE
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, InterruptedException {
                this.f$0.lambda$startScreenCapture$31$VoIPService(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startScreenCapture$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startScreenCapture$30$VoIPService(TLRPC$Updates tLRPC$Updates) {
        if (this.tgVoip[1] != null) {
            long selfId = getSelfId();
            int size = tLRPC$Updates.updates.size();
            for (int i = 0; i < size; i++) {
                TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i);
                if (tLRPC$Update instanceof TLRPC$TL_updateGroupCallConnection) {
                    TLRPC$TL_updateGroupCallConnection tLRPC$TL_updateGroupCallConnection = (TLRPC$TL_updateGroupCallConnection) tLRPC$Update;
                    if (tLRPC$TL_updateGroupCallConnection.presentation) {
                        this.tgVoip[1].setJoinResponsePayload(tLRPC$TL_updateGroupCallConnection.params.data);
                    }
                } else if (tLRPC$Update instanceof TLRPC$TL_updateGroupCallParticipants) {
                    TLRPC$TL_updateGroupCallParticipants tLRPC$TL_updateGroupCallParticipants = (TLRPC$TL_updateGroupCallParticipants) tLRPC$Update;
                    int size2 = tLRPC$TL_updateGroupCallParticipants.participants.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 < size2) {
                            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = tLRPC$TL_updateGroupCallParticipants.participants.get(i2);
                            if (MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) == selfId) {
                                TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo = tLRPC$TL_groupCallParticipant.presentation;
                                if (tLRPC$TL_groupCallParticipantVideo != null) {
                                    if ((tLRPC$TL_groupCallParticipantVideo.flags & 2) != 0) {
                                        this.mySource[1] = tLRPC$TL_groupCallParticipantVideo.audio_source;
                                    } else {
                                        int size3 = tLRPC$TL_groupCallParticipantVideo.source_groups.size();
                                        for (int i3 = 0; i3 < size3; i3++) {
                                            TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup = tLRPC$TL_groupCallParticipant.presentation.source_groups.get(i3);
                                            if (tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.size() > 0) {
                                                this.mySource[1] = tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.get(0).intValue();
                                            }
                                        }
                                    }
                                }
                            } else {
                                i2++;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startScreenCapture$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startScreenCapture$31$VoIPService(TLRPC$TL_error tLRPC$TL_error) throws IllegalStateException, InterruptedException {
        if ("GROUPCALL_VIDEO_TOO_MUCH".equals(tLRPC$TL_error.text)) {
            this.groupCall.reloadGroupCall();
            return;
        }
        if ("JOIN_AS_PEER_INVALID".equals(tLRPC$TL_error.text)) {
            TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(this.chat.id);
            if (chatFull != null) {
                if (chatFull instanceof TLRPC$TL_chatFull) {
                    chatFull.flags &= -32769;
                } else {
                    chatFull.flags &= -67108865;
                }
                chatFull.groupcall_default_join_as = null;
                JoinCallAlert.resetCache();
            }
            hangUp(2);
            return;
        }
        if ("GROUPCALL_SSRC_DUPLICATE_MUCH".equals(tLRPC$TL_error.text)) {
            createGroupInstance(1, false);
        } else if ("GROUPCALL_INVALID".equals(tLRPC$TL_error.text)) {
            MessagesController.getInstance(this.currentAccount).loadFullChat(this.chat.id, 0, true);
        }
    }

    private void startGroupCheckShortpoll() {
        if (this.shortPollRunnable != null || sharedInstance == null || this.groupCall == null) {
            return;
        }
        int[] iArr = this.mySource;
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$D12rmH3yasjTkpsF5Rmx7eExvGg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startGroupCheckShortpoll$35$VoIPService();
            }
        };
        this.shortPollRunnable = runnable;
        AndroidUtilities.runOnUIThread(runnable, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCheckShortpoll$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCheckShortpoll$35$VoIPService() {
        if (this.shortPollRunnable == null || sharedInstance == null || this.groupCall == null) {
            return;
        }
        int[] iArr = this.mySource;
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        final TLRPC$TL_phone_checkGroupCall tLRPC$TL_phone_checkGroupCall = new TLRPC$TL_phone_checkGroupCall();
        tLRPC$TL_phone_checkGroupCall.call = this.groupCall.getInputGroupCall();
        int i = 0;
        while (true) {
            int[] iArr2 = this.mySource;
            if (i < iArr2.length) {
                if (iArr2[i] != 0) {
                    tLRPC$TL_phone_checkGroupCall.sources.add(Integer.valueOf(iArr2[i]));
                }
                i++;
            } else {
                this.checkRequestId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_checkGroupCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$sI-8M_U6beqwqSdOMjIpCugEwks
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$startGroupCheckShortpoll$34$VoIPService(tLRPC$TL_phone_checkGroupCall, tLObject, tLRPC$TL_error);
                    }
                }, 0, 64);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCheckShortpoll$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCheckShortpoll$34$VoIPService(final TLRPC$TL_phone_checkGroupCall tLRPC$TL_phone_checkGroupCall, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$-ED4Fhf_UKQc_i37Rv2mAP3xrsM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startGroupCheckShortpoll$33$VoIPService(tLObject, tLRPC$TL_phone_checkGroupCall, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startGroupCheckShortpoll$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startGroupCheckShortpoll$33$VoIPService(TLObject tLObject, TLRPC$TL_phone_checkGroupCall tLRPC$TL_phone_checkGroupCall, TLRPC$TL_error tLRPC$TL_error) {
        boolean z;
        boolean z2;
        if (this.shortPollRunnable == null || sharedInstance == null || this.groupCall == null) {
            return;
        }
        this.shortPollRunnable = null;
        this.checkRequestId = 0;
        if (tLObject instanceof TLRPC$Vector) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            int[] iArr = this.mySource;
            z2 = (iArr[0] == 0 || !tLRPC$TL_phone_checkGroupCall.sources.contains(Integer.valueOf(iArr[0])) || tLRPC$Vector.objects.contains(Integer.valueOf(this.mySource[0]))) ? false : true;
            int[] iArr2 = this.mySource;
            z = (iArr2[1] == 0 || !tLRPC$TL_phone_checkGroupCall.sources.contains(Integer.valueOf(iArr2[1])) || tLRPC$Vector.objects.contains(Integer.valueOf(this.mySource[1]))) ? false : true;
        } else if (tLRPC$TL_error == null || tLRPC$TL_error.code != 400) {
            z = false;
            z2 = false;
        } else {
            int[] iArr3 = this.mySource;
            z = iArr3[1] != 0 && tLRPC$TL_phone_checkGroupCall.sources.contains(Integer.valueOf(iArr3[1]));
            z2 = true;
        }
        if (z2) {
            createGroupInstance(0, false);
        }
        if (z) {
            createGroupInstance(1, false);
        }
        int[] iArr4 = this.mySource;
        if (iArr4[1] == 0 && iArr4[0] == 0) {
            return;
        }
        startGroupCheckShortpoll();
    }

    private void cancelGroupCheckShortPoll() {
        int[] iArr = this.mySource;
        if (iArr[1] == 0 && iArr[0] == 0) {
            if (this.checkRequestId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.checkRequestId, false);
                this.checkRequestId = 0;
            }
            Runnable runnable = this.shortPollRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.shortPollRunnable = null;
            }
        }
    }

    private static class RequestedParticipant {
        public int audioSsrc;
        public TLRPC$TL_groupCallParticipant participant;

        public RequestedParticipant(TLRPC$TL_groupCallParticipant p, int ssrc) {
            this.participant = p;
            this.audioSsrc = ssrc;
        }
    }

    private void broadcastUnknownParticipants(long taskPtr, int[] unknown) {
        if (this.groupCall == null || this.tgVoip[0] == null) {
            return;
        }
        long selfId = getSelfId();
        ArrayList arrayList = null;
        int length = unknown.length;
        for (int i = 0; i < length; i++) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.groupCall.participantsBySources.get(unknown[i]);
            if (tLRPC$TL_groupCallParticipant == null && (tLRPC$TL_groupCallParticipant = this.groupCall.participantsByVideoSources.get(unknown[i])) == null) {
                tLRPC$TL_groupCallParticipant = this.groupCall.participantsByPresentationSources.get(unknown[i]);
            }
            if (tLRPC$TL_groupCallParticipant != null && MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) != selfId && tLRPC$TL_groupCallParticipant.source != 0) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(new RequestedParticipant(tLRPC$TL_groupCallParticipant, unknown[i]));
            }
        }
        if (arrayList != null) {
            int[] iArr = new int[arrayList.size()];
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = ((RequestedParticipant) arrayList.get(i2)).audioSsrc;
            }
            this.tgVoip[0].onMediaDescriptionAvailable(taskPtr, iArr);
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                RequestedParticipant requestedParticipant = (RequestedParticipant) arrayList.get(i3);
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = requestedParticipant.participant;
                if (tLRPC$TL_groupCallParticipant2.muted_by_you) {
                    this.tgVoip[0].setVolume(requestedParticipant.audioSsrc, 0.0d);
                } else {
                    NativeInstance nativeInstance = this.tgVoip[0];
                    int i4 = requestedParticipant.audioSsrc;
                    double participantVolume = ChatObject.getParticipantVolume(tLRPC$TL_groupCallParticipant2);
                    Double.isNaN(participantVolume);
                    nativeInstance.setVolume(i4, participantVolume / 10000.0d);
                }
            }
        }
    }

    private void createGroupInstance(final int type, boolean switchAccount) {
        boolean z;
        String logFilePath;
        if (switchAccount) {
            this.mySource[type] = 0;
            if (type == 0) {
                this.switchingAccount = switchAccount;
            }
        }
        cancelGroupCheckShortPoll();
        if (type == 0) {
            this.wasConnected = false;
        } else if (!this.wasConnected) {
            this.reconnectScreenCapture = true;
            return;
        }
        if (this.tgVoip[type] == null) {
            if (BuildVars.DEBUG_VERSION) {
                logFilePath = VoIPHelper.getLogFilePath("voip_" + type + "_" + this.groupCall.call.id);
            } else {
                logFilePath = VoIPHelper.getLogFilePath(this.groupCall.call.id, false);
            }
            this.tgVoip[type] = NativeInstance.makeGroup(logFilePath, this.captureDevice[type], type == 1, type == 0 && SharedConfig.noiseSupression, new NativeInstance.PayloadCallback() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$nidVbjDYCVF24Xgfci_IyM1aSUw
                @Override // ir.eitaa.messenger.voip.NativeInstance.PayloadCallback
                public final void run(int i, String str) throws IOException {
                    this.f$0.lambda$createGroupInstance$36$VoIPService(type, i, str);
                }
            }, new NativeInstance.AudioLevelsCallback() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$nFYNaBM2uKeT1ej_91NR84SN83w
                @Override // ir.eitaa.messenger.voip.NativeInstance.AudioLevelsCallback
                public final void run(int[] iArr, float[] fArr, boolean[] zArr) {
                    this.f$0.lambda$createGroupInstance$38$VoIPService(type, iArr, fArr, zArr);
                }
            }, new NativeInstance.VideoSourcesCallback() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$Kmu1RuJbcZD7ri4v7H24hPwNh_8
                @Override // ir.eitaa.messenger.voip.NativeInstance.VideoSourcesCallback
                public final void run(long j, int[] iArr) {
                    this.f$0.lambda$createGroupInstance$40$VoIPService(type, j, iArr);
                }
            }, new NativeInstance.RequestBroadcastPartCallback() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$ARkh3fsm2VzmyJ1khDiMeEKNBjI
                @Override // ir.eitaa.messenger.voip.NativeInstance.RequestBroadcastPartCallback
                public final void run(long j, long j2, int i, int i2) {
                    this.f$0.lambda$createGroupInstance$45$VoIPService(type, j, j2, i, i2);
                }
            }, new NativeInstance.RequestBroadcastPartCallback() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$rQYpVkOnuzq6eYHDVa4VeeEWYT4
                @Override // ir.eitaa.messenger.voip.NativeInstance.RequestBroadcastPartCallback
                public final void run(long j, long j2, int i, int i2) {
                    this.f$0.lambda$createGroupInstance$47$VoIPService(type, j, j2, i, i2);
                }
            });
            this.tgVoip[type].setOnStateUpdatedListener(new Instance.OnStateUpdatedListener() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$8AoVmQoQ--Ms0EAH1AcI8Qeqbto
                @Override // ir.eitaa.messenger.voip.Instance.OnStateUpdatedListener
                public final void onStateUpdated(int i, boolean z2) {
                    this.f$0.lambda$createGroupInstance$48$VoIPService(type, i, z2);
                }
            });
            z = true;
        } else {
            z = false;
        }
        this.tgVoip[type].resetGroupInstance(!z, false);
        if (this.captureDevice[type] != 0) {
            this.destroyCaptureDevice[type] = false;
        }
        if (type == 0) {
            dispatchStateChanged(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createGroupInstance$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createGroupInstance$36$VoIPService(int i, int i2, String str) throws IOException {
        if (i == 0) {
            startGroupCall(i2, str, true);
        } else {
            startScreenCapture(i2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createGroupInstance$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createGroupInstance$38$VoIPService(int i, int[] iArr, float[] fArr, boolean[] zArr) {
        ChatObject.Call call;
        if (sharedInstance == null || (call = this.groupCall) == null || i != 0) {
            return;
        }
        call.processVoiceLevelsUpdate(iArr, fArr, zArr);
        float fMax = 0.0f;
        boolean z = false;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == 0) {
                if (this.lastTypingTimeSend < SystemClock.uptimeMillis() - 5000 && fArr[i2] > 0.1f && zArr[i2]) {
                    this.lastTypingTimeSend = SystemClock.uptimeMillis();
                    TLRPC$TL_messages_setTyping tLRPC$TL_messages_setTyping = new TLRPC$TL_messages_setTyping();
                    tLRPC$TL_messages_setTyping.action = new TLRPC$TL_speakingInGroupCallAction();
                    tLRPC$TL_messages_setTyping.peer = MessagesController.getInputPeer(this.chat);
                    ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_setTyping, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$h0E1B60LsGF67CiHVjEwUzN0PYc
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            VoIPService.lambda$createGroupInstance$37(tLObject, tLRPC$TL_error);
                        }
                    }, 0, 64);
                }
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.webRtcMicAmplitudeEvent, Float.valueOf(fArr[i2]));
            } else {
                fMax = Math.max(fMax, fArr[i2]);
                z = true;
            }
        }
        if (z) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.webRtcSpeakerAmplitudeEvent, Float.valueOf(fMax));
            NativeInstance.AudioLevelsCallback audioLevelsCallback2 = audioLevelsCallback;
            if (audioLevelsCallback2 != null) {
                audioLevelsCallback2.run(iArr, fArr, zArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createGroupInstance$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createGroupInstance$40$VoIPService(int i, final long j, final int[] iArr) {
        ChatObject.Call call;
        if (sharedInstance == null || (call = this.groupCall) == null || i != 0) {
            return;
        }
        call.processUnknownVideoParticipants(iArr, new ChatObject.Call.OnParticipantsLoad() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$HDA7JvuL7xx-t8_xyff1umAmeX8
            @Override // ir.eitaa.messenger.ChatObject.Call.OnParticipantsLoad
            public final void onLoad(ArrayList arrayList) {
                this.f$0.lambda$createGroupInstance$39$VoIPService(j, iArr, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createGroupInstance$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createGroupInstance$39$VoIPService(long j, int[] iArr, ArrayList arrayList) {
        if (sharedInstance == null || this.groupCall == null) {
            return;
        }
        broadcastUnknownParticipants(j, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createGroupInstance$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createGroupInstance$45$VoIPService(final int i, final long j, long j2, final int i2, final int i3) {
        StringBuilder sb;
        if (i != 0) {
            return;
        }
        TLRPC$TL_upload_getFile tLRPC$TL_upload_getFile = new TLRPC$TL_upload_getFile();
        tLRPC$TL_upload_getFile.limit = 131072;
        TLRPC$TL_inputGroupCallStream tLRPC$TL_inputGroupCallStream = new TLRPC$TL_inputGroupCallStream();
        tLRPC$TL_inputGroupCallStream.call = this.groupCall.getInputGroupCall();
        tLRPC$TL_inputGroupCallStream.time_ms = j;
        if (j2 == 500) {
            tLRPC$TL_inputGroupCallStream.scale = 1;
        }
        if (i2 != 0) {
            tLRPC$TL_inputGroupCallStream.flags |= 1;
            tLRPC$TL_inputGroupCallStream.video_channel = i2;
            tLRPC$TL_inputGroupCallStream.video_quality = i3;
        }
        tLRPC$TL_upload_getFile.location = tLRPC$TL_inputGroupCallStream;
        if (i2 == 0) {
            sb = new StringBuilder();
            sb.append("");
            sb.append(j);
        } else {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append("_");
            sb.append(j);
            sb.append("_");
            sb.append(i3);
        }
        final String string = sb.toString();
        final int iSendRequest = AccountInstance.getInstance(this.currentAccount).getConnectionsManager().sendRequest(tLRPC$TL_upload_getFile, new RequestDelegateTimestamp() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$zmw98YaDj2q2iAMUyKx4t9jnGHo
        }, 2, 2, this.groupCall.call.stream_dc_id);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$36iIjgfb4Qa3bh9knGt0UHsz4_E
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createGroupInstance$44$VoIPService(string, iSendRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createGroupInstance$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createGroupInstance$44$VoIPService(String str, int i) {
        this.currentStreamRequestTimestamp.put(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createGroupInstance$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createGroupInstance$47$VoIPService(int i, final long j, long j2, final int i2, final int i3) {
        if (i != 0) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$QuAf_G4IMhrSRssBCKwOOhKXttQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createGroupInstance$46$VoIPService(i2, j, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createGroupInstance$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createGroupInstance$46$VoIPService(int i, long j, int i2) {
        String str;
        if (i == 0) {
            str = "" + j;
        } else {
            str = i + "_" + j + "_" + i2;
        }
        if (this.currentStreamRequestTimestamp.get(str) != null) {
            AccountInstance.getInstance(this.currentAccount).getConnectionsManager().cancelRequest(r4.intValue(), true);
            this.currentStreamRequestTimestamp.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateConnectionState, reason: merged with bridge method [inline-methods] */
    public void lambda$createGroupInstance$48$VoIPService(final int type, int state, boolean inTransition) {
        if (type != 0) {
            return;
        }
        dispatchStateChanged((state == 1 || this.switchingStream) ? 3 : 5);
        if (this.switchingStream && (state == 0 || (state == 1 && inTransition))) {
            Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$054BtkZx-31X4iQ63PiUNnEL74c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateConnectionState$49$VoIPService(type);
                }
            };
            this.switchingStreamTimeoutRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 3000L);
        }
        if (state == 0) {
            startGroupCheckShortpoll();
            if (!this.playedConnectedSound || this.spPlayId != 0 || this.switchingStream || this.switchingAccount) {
                return;
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$lTK9T08EnVTM-p2qFZOXty-GZyc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateConnectionState$50$VoIPService();
                }
            });
            return;
        }
        cancelGroupCheckShortPoll();
        if (!inTransition) {
            this.switchingStream = false;
            this.switchingAccount = false;
        }
        Runnable runnable2 = this.switchingStreamTimeoutRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.switchingStreamTimeoutRunnable = null;
        }
        if (this.playedConnectedSound) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$SL35PestKbz48Rt13Uh1JWoLpkI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateConnectionState$51$VoIPService();
                }
            });
            Runnable runnable3 = this.connectingSoundRunnable;
            if (runnable3 != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable3);
                this.connectingSoundRunnable = null;
            }
        } else {
            playConnectedSound();
        }
        if (this.wasConnected) {
            return;
        }
        this.wasConnected = true;
        if (this.reconnectScreenCapture) {
            createGroupInstance(1, false);
            this.reconnectScreenCapture = false;
        }
        NativeInstance nativeInstance = this.tgVoip[0];
        if (nativeInstance != null && !this.micMute) {
            nativeInstance.setMuteMicrophone(false);
        }
        setParticipantsVolume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateConnectionState$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateConnectionState$49$VoIPService(int i) {
        if (this.switchingStreamTimeoutRunnable == null) {
            return;
        }
        this.switchingStream = false;
        lambda$createGroupInstance$48(i, 0, true);
        this.switchingStreamTimeoutRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateConnectionState$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateConnectionState$50$VoIPService() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
        }
        this.spPlayId = this.soundPool.play(this.spVoiceChatConnecting, 1.0f, 1.0f, 0, -1, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateConnectionState$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateConnectionState$51$VoIPService() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
            this.spPlayId = 0;
        }
    }

    public void setParticipantsVolume() {
        if (this.tgVoip[0] != null) {
            int size = this.groupCall.participants.size();
            for (int i = 0; i < size; i++) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipantValueAt = this.groupCall.participants.valueAt(i);
                if (!tLRPC$TL_groupCallParticipantValueAt.self && tLRPC$TL_groupCallParticipantValueAt.source != 0 && (tLRPC$TL_groupCallParticipantValueAt.can_self_unmute || !tLRPC$TL_groupCallParticipantValueAt.muted)) {
                    if (tLRPC$TL_groupCallParticipantValueAt.muted_by_you) {
                        setParticipantVolume(tLRPC$TL_groupCallParticipantValueAt, 0);
                    } else {
                        setParticipantVolume(tLRPC$TL_groupCallParticipantValueAt, ChatObject.getParticipantVolume(tLRPC$TL_groupCallParticipantValueAt));
                    }
                }
            }
        }
    }

    public void setParticipantVolume(TLRPC$TL_groupCallParticipant participant, int volume) {
        int i;
        NativeInstance nativeInstance = this.tgVoip[0];
        int i2 = participant.source;
        double d = volume;
        Double.isNaN(d);
        double d2 = d / 10000.0d;
        nativeInstance.setVolume(i2, d2);
        TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo = participant.presentation;
        if (tLRPC$TL_groupCallParticipantVideo == null || (i = tLRPC$TL_groupCallParticipantVideo.audio_source) == 0) {
            return;
        }
        this.tgVoip[0].setVolume(i, d2);
    }

    public boolean isSwitchingStream() {
        return this.switchingStream;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x030c A[Catch: Exception -> 0x0337, TryCatch #4 {Exception -> 0x0337, blocks: (B:5:0x0010, B:7:0x0014, B:8:0x002a, B:10:0x0036, B:12:0x0041, B:13:0x0068, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x008e, B:26:0x009f, B:28:0x00a5, B:29:0x00a9, B:39:0x00c8, B:41:0x00df, B:43:0x00e7, B:45:0x00fb, B:51:0x0107, B:56:0x0111, B:58:0x0115, B:60:0x0138, B:64:0x0173, B:74:0x01dc, B:76:0x01e5, B:78:0x01f0, B:80:0x01f8, B:82:0x020b, B:84:0x0211, B:86:0x0230, B:90:0x0251, B:93:0x025e, B:94:0x026b, B:96:0x026f, B:98:0x0273, B:100:0x0279, B:102:0x0281, B:106:0x028f, B:107:0x029b, B:108:0x02a0, B:110:0x030c, B:111:0x030f, B:113:0x0317, B:114:0x0327, B:59:0x0130, B:11:0x003c, B:22:0x0092), top: B:131:0x0010, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0115 A[Catch: Exception -> 0x0337, TryCatch #4 {Exception -> 0x0337, blocks: (B:5:0x0010, B:7:0x0014, B:8:0x002a, B:10:0x0036, B:12:0x0041, B:13:0x0068, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x008e, B:26:0x009f, B:28:0x00a5, B:29:0x00a9, B:39:0x00c8, B:41:0x00df, B:43:0x00e7, B:45:0x00fb, B:51:0x0107, B:56:0x0111, B:58:0x0115, B:60:0x0138, B:64:0x0173, B:74:0x01dc, B:76:0x01e5, B:78:0x01f0, B:80:0x01f8, B:82:0x020b, B:84:0x0211, B:86:0x0230, B:90:0x0251, B:93:0x025e, B:94:0x026b, B:96:0x026f, B:98:0x0273, B:100:0x0279, B:102:0x0281, B:106:0x028f, B:107:0x029b, B:108:0x02a0, B:110:0x030c, B:111:0x030f, B:113:0x0317, B:114:0x0327, B:59:0x0130, B:11:0x003c, B:22:0x0092), top: B:131:0x0010, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0130 A[Catch: Exception -> 0x0337, TryCatch #4 {Exception -> 0x0337, blocks: (B:5:0x0010, B:7:0x0014, B:8:0x002a, B:10:0x0036, B:12:0x0041, B:13:0x0068, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x008e, B:26:0x009f, B:28:0x00a5, B:29:0x00a9, B:39:0x00c8, B:41:0x00df, B:43:0x00e7, B:45:0x00fb, B:51:0x0107, B:56:0x0111, B:58:0x0115, B:60:0x0138, B:64:0x0173, B:74:0x01dc, B:76:0x01e5, B:78:0x01f0, B:80:0x01f8, B:82:0x020b, B:84:0x0211, B:86:0x0230, B:90:0x0251, B:93:0x025e, B:94:0x026b, B:96:0x026f, B:98:0x0273, B:100:0x0279, B:102:0x0281, B:106:0x028f, B:107:0x029b, B:108:0x02a0, B:110:0x030c, B:111:0x030f, B:113:0x0317, B:114:0x0327, B:59:0x0130, B:11:0x003c, B:22:0x0092), top: B:131:0x0010, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d8 A[Catch: Exception -> 0x01cc, TRY_LEAVE, TryCatch #2 {Exception -> 0x01cc, blocks: (B:67:0x0180, B:72:0x01d8), top: B:127:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026f A[Catch: Exception -> 0x0337, TryCatch #4 {Exception -> 0x0337, blocks: (B:5:0x0010, B:7:0x0014, B:8:0x002a, B:10:0x0036, B:12:0x0041, B:13:0x0068, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x008e, B:26:0x009f, B:28:0x00a5, B:29:0x00a9, B:39:0x00c8, B:41:0x00df, B:43:0x00e7, B:45:0x00fb, B:51:0x0107, B:56:0x0111, B:58:0x0115, B:60:0x0138, B:64:0x0173, B:74:0x01dc, B:76:0x01e5, B:78:0x01f0, B:80:0x01f8, B:82:0x020b, B:84:0x0211, B:86:0x0230, B:90:0x0251, B:93:0x025e, B:94:0x026b, B:96:0x026f, B:98:0x0273, B:100:0x0279, B:102:0x0281, B:106:0x028f, B:107:0x029b, B:108:0x02a0, B:110:0x030c, B:111:0x030f, B:113:0x0317, B:114:0x0327, B:59:0x0130, B:11:0x003c, B:22:0x0092), top: B:131:0x0010, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initiateActualEncryptedCall() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 837
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.voip.VoIPService.initiateActualEncryptedCall():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initiateActualEncryptedCall$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initiateActualEncryptedCall$52$VoIPService() {
        Toast.makeText(this, "This call uses TCP which will degrade its quality.", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initiateActualEncryptedCall$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initiateActualEncryptedCall$53$VoIPService(int[] iArr, float[] fArr, boolean[] zArr) {
        if (sharedInstance == null || this.privateCall == null) {
            return;
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.webRtcMicAmplitudeEvent, Float.valueOf(fArr[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initiateActualEncryptedCall$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initiateActualEncryptedCall$55$VoIPService(final int i, final int i2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$gW9HmNe-1-AzFyZq3rIgAL9HFNE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initiateActualEncryptedCall$54$VoIPService(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initiateActualEncryptedCall$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initiateActualEncryptedCall$54$VoIPService(int i, int i2) {
        this.remoteAudioState = i;
        this.remoteVideoState = i2;
        checkIsNear();
        for (int i3 = 0; i3 < this.stateListeners.size(); i3++) {
            this.stateListeners.get(i3).onMediaStateUpdated(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$playConnectedSound$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$playConnectedSound$56$VoIPService() {
        this.soundPool.play(this.spVoiceChatStartId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void playConnectedSound() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$9vi0YCVsHwLN6NC2cScqjtTsgCs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playConnectedSound$56$VoIPService();
            }
        });
        this.playedConnectedSound = true;
    }

    private void startConnectingSound() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$mqIMd1mVeZa0va7q1gavJxuylqo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startConnectingSound$57$VoIPService();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startConnectingSound$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startConnectingSound$57$VoIPService() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
        }
        int iPlay = this.soundPool.play(this.spConnectingId, 1.0f, 1.0f, 0, -1, 1.0f);
        this.spPlayId = iPlay;
        if (iPlay == 0) {
            AnonymousClass7 anonymousClass7 = new AnonymousClass7();
            this.connectingSoundRunnable = anonymousClass7;
            AndroidUtilities.runOnUIThread(anonymousClass7, 100L);
        }
    }

    /* renamed from: ir.eitaa.messenger.voip.VoIPService$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoIPService.sharedInstance == null) {
                return;
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$7$f1etubId-2vt3SWwZhpK_BAd2QA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0$VoIPService$7();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$VoIPService$7() {
            if (VoIPService.this.spPlayId == 0) {
                VoIPService voIPService = VoIPService.this;
                voIPService.spPlayId = voIPService.soundPool.play(VoIPService.this.spConnectingId, 1.0f, 1.0f, 0, -1, 1.0f);
            }
            if (VoIPService.this.spPlayId != 0) {
                VoIPService.this.connectingSoundRunnable = null;
            } else {
                AndroidUtilities.runOnUIThread(this, 100L);
            }
        }
    }

    public void onSignalingData(byte[] data) {
        if (this.privateCall == null) {
            return;
        }
        TLRPC$TL_phone_sendSignalingData tLRPC$TL_phone_sendSignalingData = new TLRPC$TL_phone_sendSignalingData();
        TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
        tLRPC$TL_phone_sendSignalingData.peer = tLRPC$TL_inputPhoneCall;
        TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
        tLRPC$TL_inputPhoneCall.access_hash = tLRPC$PhoneCall.access_hash;
        tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
        tLRPC$TL_phone_sendSignalingData.data = data;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_sendSignalingData, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$aTxpQgoxvFJU7d3rzea2upJzqEk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                VoIPService.lambda$onSignalingData$58(tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
    }

    public boolean isVideoAvailable() {
        return this.isVideoAvailable;
    }

    void onMediaButtonEvent(KeyEvent ev) throws IllegalStateException, IOException {
        if (ev == null) {
            return;
        }
        if ((ev.getKeyCode() == 79 || ev.getKeyCode() == 127 || ev.getKeyCode() == 85) && ev.getAction() == 1) {
            if (this.currentState == 15) {
                acceptIncomingCall();
            } else {
                setMicMute(!isMicMute(), false, true);
            }
        }
    }

    public byte[] getGA() {
        return this.g_a;
    }

    public void forceRating() {
        this.forceRating = true;
    }

    private String[] getEmoji() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.authKey);
            byteArrayOutputStream.write(this.g_a);
        } catch (IOException unused) {
        }
        return EncryptionKeyEmojifier.emojifyForCall(Utilities.computeSHA256(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size()));
    }

    public boolean hasEarpiece() throws IOException {
        CallConnection callConnection;
        if (USE_CONNECTION_SERVICE && (callConnection = this.systemCallConnection) != null && callConnection.getCallAudioState() != null) {
            return (this.systemCallConnection.getCallAudioState().getSupportedRouteMask() & 5) != 0;
        }
        if (((TelephonyManager) getSystemService("phone")).getPhoneType() != 0) {
            return true;
        }
        Boolean bool = this.mHasEarpiece;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            Method method = AudioManager.class.getMethod("getDevicesForStream", Integer.TYPE);
            int i = AudioManager.class.getField("DEVICE_OUT_EARPIECE").getInt(null);
            if ((((Integer) method.invoke(audioManager, 0)).intValue() & i) == i) {
                this.mHasEarpiece = Boolean.TRUE;
            } else {
                this.mHasEarpiece = Boolean.FALSE;
            }
        } catch (Throwable th) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error while checking earpiece! ", th);
            }
            this.mHasEarpiece = Boolean.TRUE;
        }
        return this.mHasEarpiece.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStatsNetworkType() {
        NetworkInfo networkInfo = this.lastNetInfo;
        if (networkInfo == null || networkInfo.getType() != 0) {
            return 1;
        }
        return this.lastNetInfo.isRoaming() ? 2 : 0;
    }

    protected void setSwitchingCamera(boolean switching, boolean isFrontFace) {
        this.switchingCamera = switching;
        if (switching) {
            return;
        }
        this.isFrontFaceCamera = isFrontFace;
        for (int i = 0; i < this.stateListeners.size(); i++) {
            this.stateListeners.get(i).onCameraSwitch(this.isFrontFaceCamera);
        }
    }

    protected void onCameraFirstFrameAvailable() {
        for (int i = 0; i < this.stateListeners.size(); i++) {
            this.stateListeners.get(i).onCameraFirstFrameAvailable();
        }
    }

    public void registerStateListener(StateListener l) {
        if (this.stateListeners.contains(l)) {
            return;
        }
        this.stateListeners.add(l);
        int i = this.currentState;
        if (i != 0) {
            l.onStateChanged(i);
        }
        int i2 = this.signalBarCount;
        if (i2 != 0) {
            l.onSignalBarsCountChanged(i2);
        }
    }

    public void unregisterStateListener(StateListener l) {
        this.stateListeners.remove(l);
    }

    public void editCallMember(TLObject object, Boolean mute, Boolean muteVideo, Integer volume, Boolean raiseHand, final Runnable onComplete) {
        TLRPC$InputPeer tLRPC$InputPeer;
        if (object == null || this.groupCall == null) {
            return;
        }
        TLRPC$TL_phone_editGroupCallParticipant tLRPC$TL_phone_editGroupCallParticipant = new TLRPC$TL_phone_editGroupCallParticipant();
        tLRPC$TL_phone_editGroupCallParticipant.call = this.groupCall.getInputGroupCall();
        if (object instanceof TLRPC$User) {
            TLRPC$User tLRPC$User = (TLRPC$User) object;
            if (UserObject.isUserSelf(tLRPC$User) && (tLRPC$InputPeer = this.groupCallPeer) != null) {
                tLRPC$TL_phone_editGroupCallParticipant.participant = tLRPC$InputPeer;
            } else {
                tLRPC$TL_phone_editGroupCallParticipant.participant = MessagesController.getInputPeer(tLRPC$User);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("edit group call part id = " + tLRPC$TL_phone_editGroupCallParticipant.participant.user_id + " access_hash = " + tLRPC$TL_phone_editGroupCallParticipant.participant.user_id);
                }
            }
        } else if (object instanceof TLRPC$Chat) {
            tLRPC$TL_phone_editGroupCallParticipant.participant = MessagesController.getInputPeer((TLRPC$Chat) object);
            if (BuildVars.LOGS_ENABLED) {
                StringBuilder sb = new StringBuilder();
                sb.append("edit group call part id = ");
                TLRPC$InputPeer tLRPC$InputPeer2 = tLRPC$TL_phone_editGroupCallParticipant.participant;
                long j = tLRPC$InputPeer2.chat_id;
                if (j == 0) {
                    j = tLRPC$InputPeer2.channel_id;
                }
                sb.append(j);
                sb.append(" access_hash = ");
                sb.append(tLRPC$TL_phone_editGroupCallParticipant.participant.access_hash);
                FileLog.d(sb.toString());
            }
        }
        if (mute != null) {
            tLRPC$TL_phone_editGroupCallParticipant.muted = mute.booleanValue();
            tLRPC$TL_phone_editGroupCallParticipant.flags |= 1;
        }
        if (volume != null) {
            tLRPC$TL_phone_editGroupCallParticipant.volume = volume.intValue();
            tLRPC$TL_phone_editGroupCallParticipant.flags |= 2;
        }
        if (raiseHand != null) {
            tLRPC$TL_phone_editGroupCallParticipant.raise_hand = raiseHand.booleanValue();
            tLRPC$TL_phone_editGroupCallParticipant.flags |= 4;
        }
        if (muteVideo != null) {
            tLRPC$TL_phone_editGroupCallParticipant.video_stopped = muteVideo.booleanValue();
            tLRPC$TL_phone_editGroupCallParticipant.flags |= 8;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("edit group call flags = " + tLRPC$TL_phone_editGroupCallParticipant.flags);
        }
        final int i = this.currentAccount;
        ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_phone_editGroupCallParticipant, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$NUfZV6svKV6_QL2HSwPGoyUkb04
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$editCallMember$59$VoIPService(i, onComplete, tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$editCallMember$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$editCallMember$59$VoIPService(int i, Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AccountInstance.getInstance(i).getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        } else if (tLRPC$TL_error != null && "GROUPCALL_VIDEO_TOO_MUCH".equals(tLRPC$TL_error.text)) {
            this.groupCall.reloadGroupCall();
        }
        if (runnable != null) {
            AndroidUtilities.runOnUIThread(runnable);
        }
    }

    public boolean isMicMute() {
        return this.micMute;
    }

    public void toggleSpeakerphoneOrShowRouteSheet(Context context, boolean fromOverlayWindow) {
        CallConnection callConnection;
        int i;
        String str;
        if (isBluetoothHeadsetConnected() && hasEarpiece()) {
            BottomSheet.Builder title = new BottomSheet.Builder(context).setTitle(LocaleController.getString("VoipOutputDevices", R.string.VoipOutputDevices), true);
            CharSequence[] charSequenceArr = new CharSequence[3];
            charSequenceArr[0] = LocaleController.getString("VoipAudioRoutingSpeaker", R.string.VoipAudioRoutingSpeaker);
            if (this.isHeadsetPlugged) {
                i = R.string.VoipAudioRoutingHeadset;
                str = "VoipAudioRoutingHeadset";
            } else {
                i = R.string.VoipAudioRoutingEarpiece;
                str = "VoipAudioRoutingEarpiece";
            }
            charSequenceArr[1] = LocaleController.getString(str, i);
            String string = this.currentBluetoothDeviceName;
            if (string == null) {
                string = LocaleController.getString("VoipAudioRoutingBluetooth", R.string.VoipAudioRoutingBluetooth);
            }
            charSequenceArr[2] = string;
            int[] iArr = new int[3];
            iArr[0] = R.drawable.calls_menu_speaker;
            iArr[1] = this.isHeadsetPlugged ? R.drawable.calls_menu_headset : R.drawable.calls_menu_phone;
            iArr[2] = R.drawable.calls_menu_bluetooth;
            BottomSheet.Builder items = title.setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$fYwUDa7vHxNehKsa83JLbjGlhIM
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$toggleSpeakerphoneOrShowRouteSheet$60$VoIPService(dialogInterface, i2);
                }
            });
            BottomSheet bottomSheetCreate = items.create();
            if (fromOverlayWindow) {
                if (Build.VERSION.SDK_INT >= 26) {
                    bottomSheetCreate.getWindow().setType(2038);
                } else {
                    bottomSheetCreate.getWindow().setType(2003);
                }
            }
            items.show();
            return;
        }
        boolean z = USE_CONNECTION_SERVICE;
        if (z && (callConnection = this.systemCallConnection) != null && callConnection.getCallAudioState() != null) {
            if (hasEarpiece()) {
                CallConnection callConnection2 = this.systemCallConnection;
                callConnection2.setAudioRoute(callConnection2.getCallAudioState().getRoute() != 8 ? 8 : 5);
            } else {
                CallConnection callConnection3 = this.systemCallConnection;
                callConnection3.setAudioRoute(callConnection3.getCallAudioState().getRoute() == 2 ? 5 : 2);
            }
        } else if (this.audioConfigured && !z) {
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (hasEarpiece()) {
                audioManager.setSpeakerphoneOn(!audioManager.isSpeakerphoneOn());
            } else {
                audioManager.setBluetoothScoOn(!audioManager.isBluetoothScoOn());
            }
            updateOutputGainControlState();
        } else {
            this.speakerphoneStateToSet = !this.speakerphoneStateToSet;
        }
        Iterator<StateListener> it = this.stateListeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSettingsChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleSpeakerphoneOrShowRouteSheet$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleSpeakerphoneOrShowRouteSheet$60$VoIPService(DialogInterface dialogInterface, int i) {
        if (getSharedInstance() == null) {
            return;
        }
        setAudioOutput(i);
    }

    public void setAudioOutput(int which) {
        CallConnection callConnection;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("setAudioOutput " + which);
        }
        AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        boolean z = USE_CONNECTION_SERVICE;
        if (!z || (callConnection = this.systemCallConnection) == null) {
            if (this.audioConfigured && !z) {
                if (which == 0) {
                    this.needSwitchToBluetoothAfterScoActivates = false;
                    if (this.bluetoothScoActive || this.bluetoothScoConnecting) {
                        audioManager.stopBluetoothSco();
                        this.bluetoothScoActive = false;
                        this.bluetoothScoConnecting = false;
                    }
                    audioManager.setBluetoothScoOn(false);
                    audioManager.setSpeakerphoneOn(true);
                    this.audioRouteToSet = 1;
                } else if (which == 1) {
                    this.needSwitchToBluetoothAfterScoActivates = false;
                    if (this.bluetoothScoActive || this.bluetoothScoConnecting) {
                        audioManager.stopBluetoothSco();
                        this.bluetoothScoActive = false;
                        this.bluetoothScoConnecting = false;
                    }
                    audioManager.setSpeakerphoneOn(false);
                    audioManager.setBluetoothScoOn(false);
                    this.audioRouteToSet = 0;
                } else if (which == 2) {
                    if (!this.bluetoothScoActive) {
                        this.needSwitchToBluetoothAfterScoActivates = true;
                        try {
                            audioManager.startBluetoothSco();
                        } catch (Throwable th) {
                            FileLog.e(th);
                        }
                    } else {
                        audioManager.setBluetoothScoOn(true);
                        audioManager.setSpeakerphoneOn(false);
                    }
                    this.audioRouteToSet = 2;
                }
                updateOutputGainControlState();
            } else if (which == 0) {
                this.audioRouteToSet = 1;
                this.speakerphoneStateToSet = true;
            } else if (which == 1) {
                this.audioRouteToSet = 0;
                this.speakerphoneStateToSet = false;
            } else if (which == 2) {
                this.audioRouteToSet = 2;
                this.speakerphoneStateToSet = false;
            }
        } else if (which == 0) {
            callConnection.setAudioRoute(8);
        } else if (which == 1) {
            callConnection.setAudioRoute(5);
        } else if (which == 2) {
            callConnection.setAudioRoute(2);
        }
        Iterator<StateListener> it = this.stateListeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSettingsChanged();
        }
    }

    public boolean isSpeakerphoneOn() {
        CallConnection callConnection;
        boolean z = USE_CONNECTION_SERVICE;
        if (z && (callConnection = this.systemCallConnection) != null && callConnection.getCallAudioState() != null) {
            int route = this.systemCallConnection.getCallAudioState().getRoute();
            if (hasEarpiece()) {
                if (route == 8) {
                    return true;
                }
            } else if (route == 2) {
                return true;
            }
            return false;
        }
        if (this.audioConfigured && !z) {
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            return hasEarpiece() ? audioManager.isSpeakerphoneOn() : audioManager.isBluetoothScoOn();
        }
        return this.speakerphoneStateToSet;
    }

    public int getCurrentAudioRoute() {
        if (USE_CONNECTION_SERVICE) {
            CallConnection callConnection = this.systemCallConnection;
            if (callConnection != null && callConnection.getCallAudioState() != null) {
                int route = this.systemCallConnection.getCallAudioState().getRoute();
                if (route != 1) {
                    if (route == 2) {
                        return 2;
                    }
                    if (route != 4) {
                        if (route == 8) {
                            return 1;
                        }
                    }
                }
                return 0;
            }
            return this.audioRouteToSet;
        }
        if (this.audioConfigured) {
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (audioManager.isBluetoothScoOn()) {
                return 2;
            }
            return audioManager.isSpeakerphoneOn() ? 1 : 0;
        }
        return this.audioRouteToSet;
    }

    public String getDebugString() {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        return nativeInstanceArr[0] != null ? nativeInstanceArr[0].getDebugInfo() : "";
    }

    public long getCallDuration() {
        if (this.callStartTime == 0) {
            return 0L;
        }
        return SystemClock.elapsedRealtime() - this.callStartTime;
    }

    public void stopRinging() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.ringtonePlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.ringtonePlayer.release();
            this.ringtonePlayer = null;
        }
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
            this.vibrator = null;
        }
    }

    private void showNotification(String name, Bitmap photo) {
        int i;
        String str;
        int i2;
        String str2;
        Intent action = new Intent(this, (Class<?>) LaunchActivity.class).setAction(this.groupCall != null ? "voip_chat" : "voip");
        if (this.groupCall != null) {
            action.putExtra("currentAccount", this.currentAccount);
        }
        Notification.Builder contentIntent = new Notification.Builder(this).setContentText(name).setContentIntent(PendingIntent.getActivity(this, 50, action, 0));
        if (this.groupCall != null) {
            if (ChatObject.isChannelOrGiga(this.chat)) {
                i2 = R.string.VoipLiveStream;
                str2 = "VoipLiveStream";
            } else {
                i2 = R.string.VoipVoiceChat;
                str2 = "VoipVoiceChat";
            }
            contentIntent.setContentTitle(LocaleController.getString(str2, i2));
            contentIntent.setSmallIcon(isMicMute() ? R.drawable.voicechat_muted : R.drawable.voicechat_active);
        } else {
            contentIntent.setContentTitle(LocaleController.getString("VoipOutgoingCall", R.string.VoipOutgoingCall));
            contentIntent.setSmallIcon(R.drawable.notification);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 16) {
            Intent intent = new Intent(this, (Class<?>) VoIPActionsReceiver.class);
            intent.setAction(getPackageName() + ".END_CALL");
            if (this.groupCall != null) {
                if (ChatObject.isChannelOrGiga(this.chat)) {
                    i = R.string.VoipChannelLeaveAlertTitle;
                    str = "VoipChannelLeaveAlertTitle";
                } else {
                    i = R.string.VoipGroupLeaveAlertTitle;
                    str = "VoipGroupLeaveAlertTitle";
                }
                contentIntent.addAction(R.drawable.ic_call_end_white_24dp, LocaleController.getString(str, i), PendingIntent.getBroadcast(this, 0, intent, 134217728));
            } else {
                contentIntent.addAction(R.drawable.ic_call_end_white_24dp, LocaleController.getString("VoipEndCall", R.string.VoipEndCall), PendingIntent.getBroadcast(this, 0, intent, 134217728));
            }
            contentIntent.setPriority(2);
        }
        if (i3 >= 17) {
            contentIntent.setShowWhen(false);
        }
        if (i3 >= 26) {
            contentIntent.setColor(-14143951);
            contentIntent.setColorized(true);
        } else if (i3 >= 21) {
            contentIntent.setColor(-13851168);
        }
        if (i3 >= 26) {
            NotificationsController.checkOtherNotificationsChannel();
            contentIntent.setChannelId(NotificationsController.OTHER_NOTIFICATIONS_CHANNEL);
        }
        if (photo != null) {
            contentIntent.setLargeIcon(photo);
        }
        startForeground(ID_ONGOING_CALL_NOTIFICATION, contentIntent.getNotification());
    }

    private void startRingtoneAndVibration(long chatID) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        int i;
        String string;
        SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(this.currentAccount);
        AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (audioManager.getRingerMode() != 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.ringtonePlayer = mediaPlayer;
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$ozGo3nf5IjZUnlhgVVaynhSYlE4
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer2) {
                    this.f$0.lambda$startRingtoneAndVibration$61$VoIPService(mediaPlayer2);
                }
            });
            this.ringtonePlayer.setLooping(true);
            if (this.isHeadsetPlugged) {
                this.ringtonePlayer.setAudioStreamType(0);
            } else {
                this.ringtonePlayer.setAudioStreamType(2);
                if (!USE_CONNECTION_SERVICE) {
                    audioManager.requestAudioFocus(this, 2, 1);
                }
            }
            try {
                if (notificationsSettings.getBoolean("custom_" + chatID, false)) {
                    string = notificationsSettings.getString("ringtone_path_" + chatID, RingtoneManager.getDefaultUri(1).toString());
                } else {
                    string = notificationsSettings.getString("CallsRingtonePath", RingtoneManager.getDefaultUri(1).toString());
                }
                this.ringtonePlayer.setDataSource(this, Uri.parse(string));
                this.ringtonePlayer.prepareAsync();
            } catch (Exception e) {
                FileLog.e(e);
                MediaPlayer mediaPlayer2 = this.ringtonePlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.release();
                    this.ringtonePlayer = null;
                }
            }
            if (notificationsSettings.getBoolean("custom_" + chatID, false)) {
                i = notificationsSettings.getInt("calls_vibrate_" + chatID, 0);
            } else {
                i = notificationsSettings.getInt("vibrate_calls", 0);
            }
            if ((i == 2 || i == 4 || !(audioManager.getRingerMode() == 1 || audioManager.getRingerMode() == 2)) && !(i == 4 && audioManager.getRingerMode() == 1)) {
                return;
            }
            Vibrator vibrator = (Vibrator) getSystemService("vibrator");
            this.vibrator = vibrator;
            long j = 700;
            if (i == 1) {
                j = 350;
            } else if (i == 3) {
                j = 1400;
            }
            vibrator.vibrate(new long[]{0, j, 500}, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startRingtoneAndVibration$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startRingtoneAndVibration$61$VoIPService(MediaPlayer mediaPlayer) {
        try {
            this.ringtonePlayer.start();
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    @Override // android.app.Service
    public void onDestroy() throws IllegalStateException, InterruptedException, PendingIntent.CanceledException, IOException {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("=============== VoIPService STOPPING ===============");
        }
        stopForeground(true);
        stopRinging();
        if (this.currentAccount >= 0) {
            if (ApplicationLoader.mainInterfacePaused || !ApplicationLoader.isScreenOn) {
                MessagesController.getInstance(this.currentAccount).ignoreSetOnline = false;
            }
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.appDidLogout);
        }
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        if (sensorManager.getDefaultSensor(8) != null) {
            sensorManager.unregisterListener(this);
        }
        PowerManager.WakeLock wakeLock = this.proximityWakelock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.proximityWakelock.release();
        }
        if (this.updateNotificationRunnable != null) {
            Utilities.globalQueue.cancelRunnable(this.updateNotificationRunnable);
            this.updateNotificationRunnable = null;
        }
        Runnable runnable = this.switchingStreamTimeoutRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.switchingStreamTimeoutRunnable = null;
        }
        unregisterReceiver(this.receiver);
        Runnable runnable2 = this.timeoutRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.timeoutRunnable = null;
        }
        super.onDestroy();
        sharedInstance = null;
        Arrays.fill(this.mySource, 0);
        cancelGroupCheckShortPoll();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$g7vyq8dNMi0UzDxVDhFNHv9gnpE
            @Override // java.lang.Runnable
            public final void run() {
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didEndCall, new Object[0]);
            }
        });
        if (this.tgVoip[0] != null) {
            StatsController.getInstance(this.currentAccount).incrementTotalCallsTime(getStatsNetworkType(), ((int) (getCallDuration() / 1000)) % 5);
            onTgVoipPreStop();
            if (this.tgVoip[0].isGroup()) {
                NativeInstance nativeInstance = this.tgVoip[0];
                DispatchQueue dispatchQueue = Utilities.globalQueue;
                nativeInstance.getClass();
                dispatchQueue.postRunnable(new $$Lambda$xmImj2EkjnYcdM0GeYy5ctwRwME(nativeInstance));
                Iterator<Map.Entry<String, Integer>> it = this.currentStreamRequestTimestamp.entrySet().iterator();
                while (it.hasNext()) {
                    AccountInstance.getInstance(this.currentAccount).getConnectionsManager().cancelRequest(it.next().getValue().intValue(), true);
                }
                this.currentStreamRequestTimestamp.clear();
            } else {
                Instance.FinalState finalStateStop = this.tgVoip[0].stop();
                updateTrafficStats(this.tgVoip[0], finalStateStop.trafficStats);
                onTgVoipStop(finalStateStop);
            }
            this.prevTrafficStats = null;
            this.callStartTime = 0L;
            this.tgVoip[0] = null;
            Instance.destroyInstance();
        }
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[1] != null) {
            NativeInstance nativeInstance2 = nativeInstanceArr[1];
            DispatchQueue dispatchQueue2 = Utilities.globalQueue;
            nativeInstance2.getClass();
            dispatchQueue2.postRunnable(new $$Lambda$xmImj2EkjnYcdM0GeYy5ctwRwME(nativeInstance2));
            this.tgVoip[1] = null;
        }
        int i = 0;
        while (true) {
            long[] jArr = this.captureDevice;
            if (i >= jArr.length) {
                break;
            }
            if (jArr[i] != 0) {
                if (this.destroyCaptureDevice[i]) {
                    NativeInstance.destroyVideoCapturer(jArr[i]);
                }
                this.captureDevice[i] = 0;
            }
            i++;
        }
        this.cpuWakelock.release();
        if (!this.playingSound) {
            final AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (!USE_CONNECTION_SERVICE) {
                if (this.isBtHeadsetConnected || this.bluetoothScoActive || this.bluetoothScoConnecting) {
                    audioManager.stopBluetoothSco();
                    audioManager.setBluetoothScoOn(false);
                    audioManager.setSpeakerphoneOn(false);
                    this.bluetoothScoActive = false;
                    this.bluetoothScoConnecting = false;
                }
                if (this.onDestroyRunnable == null) {
                    DispatchQueue dispatchQueue3 = Utilities.globalQueue;
                    Runnable runnable3 = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$nvKLFjltuE91jvvqmAdt-naJ1QE
                        @Override // java.lang.Runnable
                        public final void run() throws IOException {
                            VoIPService.lambda$onDestroy$63(audioManager);
                        }
                    };
                    setModeRunnable = runnable3;
                    dispatchQueue3.postRunnable(runnable3);
                }
                audioManager.abandonAudioFocus(this);
            }
            audioManager.unregisterMediaButtonEventReceiver(new ComponentName(this, (Class<?>) VoIPMediaButtonReceiver.class));
            if (this.hasAudioFocus) {
                audioManager.abandonAudioFocus(this);
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$orgJJSHAjL59yMDcnVMrJkR570s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDestroy$64$VoIPService();
                }
            });
        }
        if (USE_CONNECTION_SERVICE) {
            if (!this.didDeleteConnectionServiceContact) {
                ContactsController.getInstance(this.currentAccount).deleteConnectionServiceContact();
            }
            CallConnection callConnection = this.systemCallConnection;
            if (callConnection != null && !this.playingSound) {
                callConnection.destroy();
            }
        }
        VoIPHelper.lastCallTime = SystemClock.elapsedRealtime();
        setSinks(null, null);
        Runnable runnable4 = this.onDestroyRunnable;
        if (runnable4 != null) {
            runnable4.run();
        }
        if (this.currentAccount < 0 || !ChatObject.isChannel(this.chat)) {
            return;
        }
        MessagesController.getInstance(this.currentAccount).startShortPoll(this.chat, this.classGuid, true);
    }

    static /* synthetic */ void lambda$onDestroy$63(AudioManager audioManager) throws IOException {
        synchronized (sync) {
            if (setModeRunnable == null) {
                return;
            }
            setModeRunnable = null;
            try {
                audioManager.setMode(0);
            } catch (SecurityException e) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("Error setting audio more to normal", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDestroy$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDestroy$64$VoIPService() {
        this.soundPool.release();
    }

    public long getCallID() {
        TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
        if (tLRPC$PhoneCall != null) {
            return tLRPC$PhoneCall.id;
        }
        return 0L;
    }

    public void hangUp() throws IllegalStateException, InterruptedException {
        hangUp(0, null);
    }

    public void hangUp(int discard) throws IllegalStateException, InterruptedException {
        hangUp(discard, null);
    }

    public void hangUp(Runnable onDone) throws IllegalStateException, InterruptedException {
        hangUp(0, onDone);
    }

    public void acceptIncomingCall() throws IllegalStateException, IOException {
        MessagesController.getInstance(this.currentAccount).ignoreSetOnline = false;
        stopRinging();
        showNotification();
        configureDeviceForCall();
        startConnectingSound();
        dispatchStateChanged(12);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$_n-2-F7isqKUfrxhMWKryWL9Y1w
            @Override // java.lang.Runnable
            public final void run() {
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
            }
        });
        final MessagesStorage messagesStorage = MessagesStorage.getInstance(this.currentAccount);
        TLRPC$TL_messages_getDhConfig tLRPC$TL_messages_getDhConfig = new TLRPC$TL_messages_getDhConfig();
        tLRPC$TL_messages_getDhConfig.random_length = Factory.DEVICE_HAS_CRAPPY_OPENSLES;
        tLRPC$TL_messages_getDhConfig.version = messagesStorage.getLastSecretVersion();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getDhConfig, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$bOb_s8X98FO2vscFfkdzGx0JyBQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws Exception {
                this.f$0.lambda$acceptIncomingCall$68$VoIPService(messagesStorage, tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$acceptIncomingCall$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$acceptIncomingCall$68$VoIPService(MessagesStorage messagesStorage, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws Exception {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_DhConfig tLRPC$messages_DhConfig = (TLRPC$messages_DhConfig) tLObject;
            if (tLObject instanceof TLRPC$TL_messages_dhConfig) {
                if (!Utilities.isGoodPrime(tLRPC$messages_DhConfig.p, tLRPC$messages_DhConfig.g)) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("stopping VoIP service, bad prime");
                    }
                    callFailed();
                    return;
                } else {
                    messagesStorage.setSecretPBytes(tLRPC$messages_DhConfig.p);
                    messagesStorage.setSecretG(tLRPC$messages_DhConfig.g);
                    messagesStorage.setLastSecretVersion(tLRPC$messages_DhConfig.version);
                    MessagesStorage.getInstance(this.currentAccount).saveSecretParams(messagesStorage.getLastSecretVersion(), messagesStorage.getSecretG(), messagesStorage.getSecretPBytes());
                }
            }
            byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
            for (int i = 0; i < 256; i++) {
                bArr[i] = (byte) (((byte) (Utilities.random.nextDouble() * 256.0d)) ^ tLRPC$messages_DhConfig.random[i]);
            }
            if (this.privateCall == null) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("call is null");
                }
                callFailed();
                return;
            }
            this.a_or_b = bArr;
            BigInteger bigIntegerModPow = BigInteger.valueOf(messagesStorage.getSecretG()).modPow(new BigInteger(1, bArr), new BigInteger(1, messagesStorage.getSecretPBytes()));
            this.g_a_hash = this.privateCall.g_a_hash;
            byte[] byteArray = bigIntegerModPow.toByteArray();
            if (byteArray.length > 256) {
                byte[] bArr2 = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
                System.arraycopy(byteArray, 1, bArr2, 0, Factory.DEVICE_HAS_CRAPPY_OPENSLES);
                byteArray = bArr2;
            }
            TLRPC$TL_phone_acceptCall tLRPC$TL_phone_acceptCall = new TLRPC$TL_phone_acceptCall();
            tLRPC$TL_phone_acceptCall.g_b = byteArray;
            TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
            tLRPC$TL_phone_acceptCall.peer = tLRPC$TL_inputPhoneCall;
            TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
            tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
            tLRPC$TL_inputPhoneCall.access_hash = tLRPC$PhoneCall.access_hash;
            TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol = new TLRPC$TL_phoneCallProtocol();
            tLRPC$TL_phone_acceptCall.protocol = tLRPC$TL_phoneCallProtocol;
            tLRPC$TL_phoneCallProtocol.udp_reflector = true;
            tLRPC$TL_phoneCallProtocol.udp_p2p = true;
            tLRPC$TL_phoneCallProtocol.min_layer = 65;
            tLRPC$TL_phoneCallProtocol.max_layer = Instance.getConnectionMaxLayer();
            tLRPC$TL_phone_acceptCall.protocol.library_versions.addAll(Instance.AVAILABLE_VERSIONS);
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_acceptCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$IKTx6J0FfeVhJcagf8OauYOb4Ls
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$acceptIncomingCall$67$VoIPService(tLObject2, tLRPC$TL_error2);
                }
            }, 2, 64);
            return;
        }
        callFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$acceptIncomingCall$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$acceptIncomingCall$67$VoIPService(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$eGtZChrEaOxAkf6fGsn3LJ5Rw0M
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$acceptIncomingCall$66$VoIPService(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$acceptIncomingCall$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$acceptIncomingCall$66$VoIPService(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) throws Exception {
        if (tLRPC$TL_error == null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.w("accept call ok! " + tLObject);
            }
            TLRPC$PhoneCall tLRPC$PhoneCall = ((TLRPC$TL_phone_phoneCall) tLObject).phone_call;
            this.privateCall = tLRPC$PhoneCall;
            if (tLRPC$PhoneCall instanceof TLRPC$TL_phoneCallDiscarded) {
                onCallUpdated(tLRPC$PhoneCall);
                return;
            }
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e("Error on phone.acceptCall: " + tLRPC$TL_error);
        }
        callFailed();
    }

    public void declineIncomingCall(int reason, final Runnable onDone) throws IllegalStateException, InterruptedException {
        stopRinging();
        this.callDiscardReason = reason;
        int i = this.currentState;
        if (i == 14) {
            Runnable runnable = this.delayedStartOutgoingCall;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                callEnded();
                return;
            } else {
                dispatchStateChanged(10);
                this.endCallAfterRequest = true;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$oasq4cOirkxpf5ycB-ymkuBNTko
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        this.f$0.lambda$declineIncomingCall$69$VoIPService();
                    }
                }, 5000L);
                return;
            }
        }
        if (i == 10 || i == 11) {
            return;
        }
        dispatchStateChanged(10);
        if (this.privateCall == null) {
            this.onDestroyRunnable = onDone;
            callEnded();
            if (this.callReqId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.callReqId, false);
                this.callReqId = 0;
                return;
            }
            return;
        }
        TLRPC$TL_phone_discardCall tLRPC$TL_phone_discardCall = new TLRPC$TL_phone_discardCall();
        TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
        tLRPC$TL_phone_discardCall.peer = tLRPC$TL_inputPhoneCall;
        TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
        tLRPC$TL_inputPhoneCall.access_hash = tLRPC$PhoneCall.access_hash;
        tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
        tLRPC$TL_phone_discardCall.duration = (int) (getCallDuration() / 1000);
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        tLRPC$TL_phone_discardCall.connection_id = nativeInstanceArr[0] != null ? nativeInstanceArr[0].getPreferredRelayId() : 0L;
        if (reason == 2) {
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonDisconnect();
        } else if (reason == 3) {
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonMissed();
        } else if (reason == 4) {
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonBusy();
        } else {
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonHangup();
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_discardCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$9uu89_7NU6ofIB4bEWxQDZOPpD8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$declineIncomingCall$70$VoIPService(tLObject, tLRPC$TL_error);
            }
        }, 2, 64);
        this.onDestroyRunnable = onDone;
        callEnded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$declineIncomingCall$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$declineIncomingCall$69$VoIPService() throws InterruptedException {
        if (this.currentState == 10) {
            callEnded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$declineIncomingCall$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$declineIncomingCall$70$VoIPService(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("error on phone.discardCall: " + tLRPC$TL_error);
                return;
            }
            return;
        }
        if (tLObject instanceof TLRPC$TL_updates) {
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$TL_updates) tLObject, false);
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("phone.discardCall " + tLObject);
        }
    }

    public void declineIncomingCall() throws IllegalStateException, InterruptedException {
        declineIncomingCall(1, null);
    }

    private Class<? extends Activity> getUIActivityClass() {
        return LaunchActivity.class;
    }

    @TargetApi(26)
    public CallConnection getConnectionAndStartCall() {
        if (this.systemCallConnection == null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("creating call connection");
            }
            CallConnection callConnection = new CallConnection();
            this.systemCallConnection = callConnection;
            callConnection.setInitializing();
            if (this.isOutgoing) {
                Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$SzbiucjOjOFz_un8bMxeHmV0xEQ
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        this.f$0.lambda$getConnectionAndStartCall$71$VoIPService();
                    }
                };
                this.delayedStartOutgoingCall = runnable;
                AndroidUtilities.runOnUIThread(runnable, 2000L);
            }
            this.systemCallConnection.setAddress(Uri.fromParts("tel", "+99084" + this.user.id, null), 1);
            CallConnection callConnection2 = this.systemCallConnection;
            TLRPC$User tLRPC$User = this.user;
            callConnection2.setCallerDisplayName(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name), 1);
        }
        return this.systemCallConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getConnectionAndStartCall$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getConnectionAndStartCall$71$VoIPService() throws IOException {
        this.delayedStartOutgoingCall = null;
        startOutgoingCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRinging() throws IllegalStateException, Resources.NotFoundException, PendingIntent.CanceledException, IOException, SecurityException, IllegalArgumentException {
        CallConnection callConnection;
        if (this.currentState == 15) {
            return;
        }
        if (USE_CONNECTION_SERVICE && (callConnection = this.systemCallConnection) != null) {
            callConnection.setRinging();
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("starting ringing for call " + this.privateCall.id);
        }
        dispatchStateChanged(15);
        if (!this.notificationsDisabled && Build.VERSION.SDK_INT >= 21) {
            TLRPC$User tLRPC$User = this.user;
            showIncomingNotification(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name), null, this.user, this.privateCall.video, 0);
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("Showing incoming call notification");
                return;
            }
            return;
        }
        startRingtoneAndVibration(this.user.id);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("Starting incall activity for incoming call");
        }
        try {
            PendingIntent.getActivity(this, 12345, new Intent(this, (Class<?>) LaunchActivity.class).setAction("voip"), 0).send();
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error starting incall activity", e);
            }
        }
    }

    public void startRingtoneAndVibration() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.startedRinging) {
            return;
        }
        startRingtoneAndVibration(this.user.id);
        this.startedRinging = true;
    }

    private void updateServerConfig() throws IOException {
        final SharedPreferences mainSettings = MessagesController.getMainSettings(this.currentAccount);
        Instance.setGlobalServerConfig(mainSettings.getString("voip_server_config", "{}"));
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_phone_getCallConfig
            public static int constructor = 1430593449;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$TL_dataJSON.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$vdy7JIZUPikry3YplA04Tnc3LfU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws IOException {
                VoIPService.lambda$updateServerConfig$72(mainSettings, tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
    }

    static /* synthetic */ void lambda$updateServerConfig$72(SharedPreferences sharedPreferences, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws IOException {
        if (tLRPC$TL_error == null) {
            String str = ((TLRPC$TL_dataJSON) tLObject).data;
            Instance.setGlobalServerConfig(str);
            sharedPreferences.edit().putString("voip_server_config", str).commit();
        }
    }

    private void showNotification() {
        TLRPC$User tLRPC$User = this.user;
        if (tLRPC$User != null) {
            showNotification(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name), getRoundAvatarBitmap(this.user));
        } else {
            TLRPC$Chat tLRPC$Chat = this.chat;
            showNotification(tLRPC$Chat.title, getRoundAvatarBitmap(tLRPC$Chat));
        }
    }

    private void onTgVoipStop(Instance.FinalState finalState) throws PendingIntent.CanceledException, IOException {
        if (this.user == null) {
            return;
        }
        if (this.needRateCall || this.forceRating || finalState.isRatingSuggested) {
            startRatingActivity();
            this.needRateCall = false;
        }
        if (!this.needSendDebugLog || finalState.debugLog == null) {
            return;
        }
        TLRPC$TL_phone_saveCallDebug tLRPC$TL_phone_saveCallDebug = new TLRPC$TL_phone_saveCallDebug();
        TLRPC$TL_dataJSON tLRPC$TL_dataJSON = new TLRPC$TL_dataJSON();
        tLRPC$TL_phone_saveCallDebug.debug = tLRPC$TL_dataJSON;
        tLRPC$TL_dataJSON.data = finalState.debugLog;
        TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
        tLRPC$TL_phone_saveCallDebug.peer = tLRPC$TL_inputPhoneCall;
        TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
        tLRPC$TL_inputPhoneCall.access_hash = tLRPC$PhoneCall.access_hash;
        tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_saveCallDebug, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$jgH4XzY4-oDwCr8FbGQqVQUba8M
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                VoIPService.lambda$onTgVoipStop$73(tLObject, tLRPC$TL_error);
            }
        }, 0, 64);
        this.needSendDebugLog = false;
    }

    static /* synthetic */ void lambda$onTgVoipStop$73(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("Sent debug logs, response = " + tLObject);
        }
    }

    private void initializeAccountRelatedThings() throws InterruptedException, IOException {
        updateServerConfig();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.appDidLogout);
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
    }

    @Override // android.app.Service
    @SuppressLint({"InvalidWakeLockTag"})
    public void onCreate() throws Exception {
        BluetoothAdapter bluetoothAdapter;
        super.onCreate();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("=============== VoIPService STARTING ===============");
        }
        try {
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            int i = Build.VERSION.SDK_INT;
            if (i >= 17 && audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER") != null) {
                Instance.setBufferSize(Integer.parseInt(audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")));
            } else {
                Instance.setBufferSize(AudioTrack.getMinBufferSize(48000, 4, 2) / 2);
            }
            boolean z = true;
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "eitaa-voip");
            this.cpuWakelock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.acquire();
            this.btAdapter = audioManager.isBluetoothScoAvailableOffCall() ? BluetoothAdapter.getDefaultAdapter() : null;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            boolean z2 = USE_CONNECTION_SERVICE;
            if (!z2) {
                intentFilter.addAction(ACTION_HEADSET_PLUG);
                if (this.btAdapter != null) {
                    intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                    intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
                }
                intentFilter.addAction("android.intent.action.PHONE_STATE");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
            registerReceiver(this.receiver, intentFilter);
            fetchBluetoothDeviceName();
            audioManager.registerMediaButtonEventReceiver(new ComponentName(this, (Class<?>) VoIPMediaButtonReceiver.class));
            if (!z2 && (bluetoothAdapter = this.btAdapter) != null && bluetoothAdapter.isEnabled()) {
                try {
                    MediaRouter mediaRouter = (MediaRouter) getSystemService("media_router");
                    if (i < 24) {
                        if (this.btAdapter.getProfileConnectionState(1) != 2) {
                            z = false;
                        }
                        updateBluetoothHeadsetState(z);
                        Iterator<StateListener> it = this.stateListeners.iterator();
                        while (it.hasNext()) {
                            it.next().onAudioSettingsChanged();
                        }
                    } else if (mediaRouter.getSelectedRoute(1).getDeviceType() == 3) {
                        if (this.btAdapter.getProfileConnectionState(1) != 2) {
                            z = false;
                        }
                        updateBluetoothHeadsetState(z);
                        Iterator<StateListener> it2 = this.stateListeners.iterator();
                        while (it2.hasNext()) {
                            it2.next().onAudioSettingsChanged();
                        }
                    } else {
                        updateBluetoothHeadsetState(false);
                    }
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("error initializing voip controller", e);
            }
            callFailed();
        }
        if (callIShouldHavePutIntoIntent == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationsController.checkOtherNotificationsChannel();
        Notification.Builder showWhen = new Notification.Builder(this, NotificationsController.OTHER_NOTIFICATIONS_CHANNEL).setContentTitle(LocaleController.getString("VoipOutgoingCall", R.string.VoipOutgoingCall)).setShowWhen(false);
        if (this.groupCall != null) {
            showWhen.setSmallIcon(isMicMute() ? R.drawable.voicechat_muted : R.drawable.voicechat_active);
        } else {
            showWhen.setSmallIcon(R.drawable.notification);
        }
        startForeground(ID_ONGOING_CALL_NOTIFICATION, showWhen.build());
    }

    private void loadResources() {
        if (Build.VERSION.SDK_INT >= 21) {
            WebRtcAudioTrack.setAudioTrackUsageAttribute(2);
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$FalegpalRfnQcvNKKDy8Tevk4Fg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadResources$74$VoIPService();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadResources$74, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadResources$74$VoIPService() {
        SoundPool soundPool = new SoundPool(1, 0, 0);
        this.soundPool = soundPool;
        this.spConnectingId = soundPool.load(this, R.raw.voip_connecting, 1);
        this.spRingbackID = this.soundPool.load(this, R.raw.voip_ringback, 1);
        this.spFailedID = this.soundPool.load(this, R.raw.voip_failed, 1);
        this.spEndId = this.soundPool.load(this, R.raw.voip_end, 1);
        this.spBusyId = this.soundPool.load(this, R.raw.voip_busy, 1);
        this.spVoiceChatEndId = this.soundPool.load(this, R.raw.voicechat_leave, 1);
        this.spVoiceChatStartId = this.soundPool.load(this, R.raw.voicechat_join, 1);
        this.spVoiceChatConnecting = this.soundPool.load(this, R.raw.voicechat_connecting, 1);
        this.spAllowTalkId = this.soundPool.load(this, R.raw.voip_onallowtalk, 1);
        this.spStartRecordId = this.soundPool.load(this, R.raw.voip_recordstart, 1);
    }

    private void dispatchStateChanged(int state) {
        CallConnection callConnection;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("== Call " + getCallID() + " state changed to " + state + " ==");
        }
        this.currentState = state;
        if (USE_CONNECTION_SERVICE && state == 3 && (callConnection = this.systemCallConnection) != null) {
            callConnection.setActive();
        }
        for (int i = 0; i < this.stateListeners.size(); i++) {
            this.stateListeners.get(i).onStateChanged(state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrafficStats(NativeInstance instance, Instance.TrafficStats trafficStats) {
        if (trafficStats == null) {
            trafficStats = instance.getTrafficStats();
        }
        long j = trafficStats.bytesSentWifi;
        Instance.TrafficStats trafficStats2 = this.prevTrafficStats;
        long j2 = j - (trafficStats2 != null ? trafficStats2.bytesSentWifi : 0L);
        long j3 = trafficStats.bytesReceivedWifi - (trafficStats2 != null ? trafficStats2.bytesReceivedWifi : 0L);
        long j4 = trafficStats.bytesSentMobile - (trafficStats2 != null ? trafficStats2.bytesSentMobile : 0L);
        long j5 = trafficStats.bytesReceivedMobile - (trafficStats2 != null ? trafficStats2.bytesReceivedMobile : 0L);
        this.prevTrafficStats = trafficStats;
        if (j2 > 0) {
            StatsController.getInstance(this.currentAccount).incrementSentBytesCount(1, 0, j2);
        }
        if (j3 > 0) {
            StatsController.getInstance(this.currentAccount).incrementReceivedBytesCount(1, 0, j3);
        }
        if (j4 > 0) {
            StatsController statsController = StatsController.getInstance(this.currentAccount);
            NetworkInfo networkInfo = this.lastNetInfo;
            statsController.incrementSentBytesCount((networkInfo == null || !networkInfo.isRoaming()) ? 0 : 2, 0, j4);
        }
        if (j5 > 0) {
            StatsController statsController2 = StatsController.getInstance(this.currentAccount);
            NetworkInfo networkInfo2 = this.lastNetInfo;
            statsController2.incrementReceivedBytesCount((networkInfo2 == null || !networkInfo2.isRoaming()) ? 0 : 2, 0, j5);
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    private void configureDeviceForCall() throws IOException {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("configureDeviceForCall, route to set = " + this.audioRouteToSet);
        }
        this.needPlayEndSound = true;
        final AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (!USE_CONNECTION_SERVICE) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$BEqPg_Om0mTsAB0FO_Ux7ool3tQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$configureDeviceForCall$76$VoIPService(audioManager);
                }
            });
        }
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(8);
        if (defaultSensor != null) {
            try {
                this.proximityWakelock = ((PowerManager) getSystemService("power")).newWakeLock(32, "eitaa-voip-prx");
                sensorManager.registerListener(this, defaultSensor, 3);
            } catch (Exception e) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("Error initializing proximity sensor", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$configureDeviceForCall$76, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$configureDeviceForCall$76$VoIPService(final AudioManager audioManager) {
        try {
            audioManager.setMode(3);
        } catch (Exception e) {
            FileLog.e(e);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$s8jrDX5Sp-BOfo4CZ0Nt0803L0s
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$configureDeviceForCall$75$VoIPService(audioManager);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$configureDeviceForCall$75, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$configureDeviceForCall$75$VoIPService(AudioManager audioManager) {
        audioManager.requestAudioFocus(this, 0, 1);
        if (isBluetoothHeadsetConnected() && hasEarpiece()) {
            int i = this.audioRouteToSet;
            if (i == 0) {
                audioManager.setBluetoothScoOn(false);
                audioManager.setSpeakerphoneOn(false);
            } else if (i == 1) {
                audioManager.setBluetoothScoOn(false);
                audioManager.setSpeakerphoneOn(true);
            } else if (i == 2) {
                if (!this.bluetoothScoActive) {
                    this.needSwitchToBluetoothAfterScoActivates = true;
                    try {
                        audioManager.startBluetoothSco();
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                } else {
                    audioManager.setBluetoothScoOn(true);
                    audioManager.setSpeakerphoneOn(false);
                }
            }
        } else if (isBluetoothHeadsetConnected()) {
            audioManager.setBluetoothScoOn(this.speakerphoneStateToSet);
        } else {
            audioManager.setSpeakerphoneOn(this.speakerphoneStateToSet);
            if (this.speakerphoneStateToSet) {
                this.audioRouteToSet = 1;
            } else {
                this.audioRouteToSet = 0;
            }
        }
        updateOutputGainControlState();
        this.audioConfigured = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchBluetoothDeviceName() {
        if (this.fetchingBluetoothDeviceName) {
            return;
        }
        try {
            this.currentBluetoothDeviceName = null;
            this.fetchingBluetoothDeviceName = true;
            BluetoothAdapter.getDefaultAdapter().getProfileProxy(this, this.serviceListener, 1);
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent event) {
        if (this.unmutedByHold || this.remoteVideoState == 2) {
            return;
        }
        if (this.videoState[0] != 2 && event.sensor.getType() == 8) {
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (this.audioRouteToSet != 0 || this.isHeadsetPlugged || audioManager.isSpeakerphoneOn()) {
                return;
            }
            if (isBluetoothHeadsetConnected() && audioManager.isBluetoothScoOn()) {
                return;
            }
            checkIsNear(event.values[0] < Math.min(event.sensor.getMaximumRange(), 3.0f));
        }
    }

    private void checkIsNear() {
        if (this.remoteVideoState == 2 || this.videoState[0] == 2) {
            checkIsNear(false);
        }
    }

    private void checkIsNear(boolean newIsNear) {
        if (newIsNear != this.isProximityNear) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("proximity " + newIsNear);
            }
            this.isProximityNear = newIsNear;
            try {
                if (newIsNear) {
                    this.proximityWakelock.acquire();
                } else {
                    this.proximityWakelock.release(1);
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public boolean isBluetoothHeadsetConnected() {
        CallConnection callConnection;
        if (!USE_CONNECTION_SERVICE || (callConnection = this.systemCallConnection) == null || callConnection.getCallAudioState() == null) {
            return this.isBtHeadsetConnected;
        }
        return (this.systemCallConnection.getCallAudioState().getSupportedRouteMask() & 2) != 0;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        if (focusChange == 1) {
            this.hasAudioFocus = true;
        } else {
            this.hasAudioFocus = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBluetoothHeadsetState(boolean connected) {
        if (connected == this.isBtHeadsetConnected) {
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("updateBluetoothHeadsetState: " + connected);
        }
        this.isBtHeadsetConnected = connected;
        final AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (connected && !isRinging() && this.currentState != 0) {
            if (this.bluetoothScoActive) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("SCO already active, setting audio routing");
                }
                audioManager.setSpeakerphoneOn(false);
                audioManager.setBluetoothScoOn(true);
            } else {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("startBluetoothSco");
                }
                this.needSwitchToBluetoothAfterScoActivates = true;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$EMRpCRejX4k6E4_cJNcMnKC_qCA
                    @Override // java.lang.Runnable
                    public final void run() {
                        audioManager.startBluetoothSco();
                    }
                }, 500L);
            }
        } else {
            this.bluetoothScoActive = false;
            this.bluetoothScoConnecting = false;
        }
        Iterator<StateListener> it = this.stateListeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSettingsChanged();
        }
    }

    public String getLastError() {
        return this.lastError;
    }

    public int getCallState() {
        return this.currentState;
    }

    public TLRPC$InputPeer getGroupCallPeer() {
        return this.groupCallPeer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNetworkType() {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[0] != null) {
            if (nativeInstanceArr[0].isGroup()) {
                return;
            }
            this.tgVoip[0].setNetworkType(getNetworkType());
            return;
        }
        this.lastNetInfo = getActiveNetworkInfo();
    }

    private int getNetworkType() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.lastNetInfo = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                        return 1;
                    case 2:
                    case 7:
                        return 2;
                    case 3:
                    case 5:
                        return 3;
                    case 4:
                    case 11:
                    case 14:
                    default:
                        return 11;
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 15:
                        return 4;
                    case 13:
                        return 5;
                }
            }
            if (type == 1) {
                return 6;
            }
            if (type == 9) {
                return 7;
            }
        }
        return 0;
    }

    private NetworkInfo getActiveNetworkInfo() {
        return ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callFailed() throws Exception {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        callFailed(nativeInstanceArr[0] != null ? nativeInstanceArr[0].getLastError() : Instance.ERROR_UNKNOWN);
    }

    private Bitmap getRoundAvatarBitmap(TLObject userOrChat) throws Resources.NotFoundException {
        AvatarDrawable avatarDrawable;
        Bitmap bitmapDecodeFile = null;
        try {
            if (userOrChat instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) userOrChat;
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User.photo;
                if (tLRPC$UserProfilePhoto != null && tLRPC$UserProfilePhoto.photo_small != null) {
                    BitmapDrawable imageFromMemory = ImageLoader.getInstance().getImageFromMemory(tLRPC$User.photo.photo_small, null, "50_50");
                    if (imageFromMemory != null) {
                        bitmapDecodeFile = imageFromMemory.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inMutable = true;
                            bitmapDecodeFile = BitmapFactory.decodeFile(FileLoader.getPathToAttach(tLRPC$User.photo.photo_small, true).toString(), options);
                        } catch (Throwable th) {
                            FileLog.e(th);
                        }
                    }
                }
            } else {
                TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) userOrChat;
                TLRPC$ChatPhoto tLRPC$ChatPhoto = tLRPC$Chat.photo;
                if (tLRPC$ChatPhoto != null && tLRPC$ChatPhoto.photo_small != null) {
                    BitmapDrawable imageFromMemory2 = ImageLoader.getInstance().getImageFromMemory(tLRPC$Chat.photo.photo_small, null, "50_50");
                    if (imageFromMemory2 != null) {
                        bitmapDecodeFile = imageFromMemory2.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        try {
                            BitmapFactory.Options options2 = new BitmapFactory.Options();
                            options2.inMutable = true;
                            bitmapDecodeFile = BitmapFactory.decodeFile(FileLoader.getPathToAttach(tLRPC$Chat.photo.photo_small, true).toString(), options2);
                        } catch (Throwable th2) {
                            FileLog.e(th2);
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            FileLog.e(th3);
        }
        if (bitmapDecodeFile == null) {
            Theme.createDialogsResources(this);
            if (userOrChat instanceof TLRPC$User) {
                avatarDrawable = new AvatarDrawable((TLRPC$User) userOrChat);
            } else {
                avatarDrawable = new AvatarDrawable((TLRPC$Chat) userOrChat);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(AndroidUtilities.dp(42.0f), AndroidUtilities.dp(42.0f), Bitmap.Config.ARGB_8888);
            avatarDrawable.setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
            avatarDrawable.draw(new Canvas(bitmapCreateBitmap));
            bitmapDecodeFile = bitmapCreateBitmap;
        }
        Canvas canvas = new Canvas(bitmapDecodeFile);
        Path path = new Path();
        path.addCircle(bitmapDecodeFile.getWidth() / 2, bitmapDecodeFile.getHeight() / 2, bitmapDecodeFile.getWidth() / 2, Path.Direction.CW);
        path.toggleInverseFillType();
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(path, paint);
        return bitmapDecodeFile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013b  */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showIncomingNotification(java.lang.String r19, java.lang.CharSequence r20, ir.eitaa.tgnet.TLObject r21, boolean r22, int r23) throws java.lang.IllegalStateException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 848
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.voip.VoIPService.showIncomingNotification(java.lang.String, java.lang.CharSequence, ir.eitaa.tgnet.TLObject, boolean, int):void");
    }

    private void callFailed(String error) throws Exception {
        CallConnection callConnection;
        if (this.privateCall != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("Discarding failed call");
            }
            TLRPC$TL_phone_discardCall tLRPC$TL_phone_discardCall = new TLRPC$TL_phone_discardCall();
            TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
            tLRPC$TL_phone_discardCall.peer = tLRPC$TL_inputPhoneCall;
            TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
            tLRPC$TL_inputPhoneCall.access_hash = tLRPC$PhoneCall.access_hash;
            tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
            tLRPC$TL_phone_discardCall.duration = (int) (getCallDuration() / 1000);
            NativeInstance[] nativeInstanceArr = this.tgVoip;
            tLRPC$TL_phone_discardCall.connection_id = nativeInstanceArr[0] != null ? nativeInstanceArr[0].getPreferredRelayId() : 0L;
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonDisconnect();
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_discardCall, new RequestDelegate() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$a3FW-HEJWkrsTGGAkkFG8aH5IlM
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    VoIPService.lambda$callFailed$78(tLObject, tLRPC$TL_error);
                }
            }, 0, 64);
        }
        try {
            throw new Exception("Call " + getCallID() + " failed with error: " + error);
        } catch (Exception e) {
            FileLog.e(e);
            this.lastError = error;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$VGo03-h3ehuWBbEJZH6yK7Wsje8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$callFailed$79$VoIPService();
                }
            });
            if (TextUtils.equals(error, Instance.ERROR_LOCALIZED) && this.soundPool != null) {
                this.playingSound = true;
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$8jtsJ27gACwa5_6gUAqeoj1Srxo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$callFailed$80$VoIPService();
                    }
                });
                AndroidUtilities.runOnUIThread(this.afterSoundRunnable, 1000L);
            }
            if (USE_CONNECTION_SERVICE && (callConnection = this.systemCallConnection) != null) {
                callConnection.setDisconnected(new DisconnectCause(1));
                this.systemCallConnection.destroy();
                this.systemCallConnection = null;
            }
            stopSelf();
        }
    }

    static /* synthetic */ void lambda$callFailed$78(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("error on phone.discardCall: " + tLRPC$TL_error);
                return;
            }
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("phone.discardCall " + tLObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$callFailed$79, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$callFailed$79$VoIPService() {
        dispatchStateChanged(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$callFailed$80, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$callFailed$80$VoIPService() {
        this.soundPool.play(this.spFailedID, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    void callFailedFromConnectionService() throws Exception {
        if (this.isOutgoing) {
            callFailed(Instance.ERROR_CONNECTION_SERVICE);
        } else {
            hangUp();
        }
    }

    @Override // ir.eitaa.messenger.voip.VoIPController.ConnectionStateListener
    public void onConnectionStateChanged(final int newState, boolean inTransition) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$j6pQ5T9L8qZd7uVAeYS01dM7jJ8
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$onConnectionStateChanged$83$VoIPService(newState);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onConnectionStateChanged$83, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onConnectionStateChanged$83$VoIPService(int i) throws Exception {
        if (i == 3 && this.callStartTime == 0) {
            this.callStartTime = SystemClock.elapsedRealtime();
        }
        if (i == 4) {
            callFailed();
            return;
        }
        if (i == 3) {
            Runnable runnable = this.connectingSoundRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.connectingSoundRunnable = null;
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$xHVh-Y6APR-tqQCVy344udn27Lo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnectionStateChanged$81$VoIPService();
                }
            });
            if (this.groupCall == null && !this.wasEstablished) {
                this.wasEstablished = true;
                if (!this.isProximityNear && !this.privateCall.video) {
                    Vibrator vibrator = (Vibrator) getSystemService("vibrator");
                    if (vibrator.hasVibrator()) {
                        vibrator.vibrate(100L);
                    }
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.VoIPService.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoIPService.this.tgVoip[0] != null) {
                            StatsController.getInstance(VoIPService.this.currentAccount).incrementTotalCallsTime(VoIPService.this.getStatsNetworkType(), 5);
                            AndroidUtilities.runOnUIThread(this, 5000L);
                        }
                    }
                }, 5000L);
                if (this.isOutgoing) {
                    StatsController.getInstance(this.currentAccount).incrementSentItemsCount(getStatsNetworkType(), 0, 1);
                } else {
                    StatsController.getInstance(this.currentAccount).incrementReceivedItemsCount(getStatsNetworkType(), 0, 1);
                }
            }
        }
        if (i == 5) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$gmv2Xf7HDoKpLpzJfDuUF83gmYQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnectionStateChanged$82$VoIPService();
                }
            });
        }
        dispatchStateChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onConnectionStateChanged$81, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onConnectionStateChanged$81$VoIPService() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
            this.spPlayId = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onConnectionStateChanged$82, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onConnectionStateChanged$82$VoIPService() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
        }
        this.spPlayId = this.soundPool.play(this.groupCall != null ? this.spVoiceChatConnecting : this.spConnectingId, 1.0f, 1.0f, 0, -1, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$playStartRecordSound$84, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$playStartRecordSound$84$VoIPService() {
        this.soundPool.play(this.spStartRecordId, 0.5f, 0.5f, 0, 0, 1.0f);
    }

    public void playStartRecordSound() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$qZyNtHq46n8HPLat7xB0UIjnXv0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playStartRecordSound$84$VoIPService();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$playAllowTalkSound$85, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$playAllowTalkSound$85$VoIPService() {
        this.soundPool.play(this.spAllowTalkId, 0.5f, 0.5f, 0, 0, 1.0f);
    }

    public void playAllowTalkSound() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$IJp-fB2OpGlLmVwAfMIIAOaA1eI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playAllowTalkSound$85$VoIPService();
            }
        });
    }

    @Override // ir.eitaa.messenger.voip.VoIPController.ConnectionStateListener
    public void onSignalBarCountChanged(final int newCount) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$HrFxcla0tzHQH_d3KX95zBH8S08
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onSignalBarCountChanged$86$VoIPService(newCount);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onSignalBarCountChanged$86, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onSignalBarCountChanged$86$VoIPService(int i) {
        this.signalBarCount = i;
        for (int i2 = 0; i2 < this.stateListeners.size(); i2++) {
            this.stateListeners.get(i2).onSignalBarsCountChanged(i);
        }
    }

    public boolean isBluetoothOn() {
        return ((AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isBluetoothScoOn();
    }

    public boolean isBluetoothWillOn() {
        return this.needSwitchToBluetoothAfterScoActivates;
    }

    public boolean isHeadsetPlugged() {
        return this.isHeadsetPlugged;
    }

    private void callEnded() throws InterruptedException {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("Call " + getCallID() + " ended");
        }
        if (this.groupCall != null && (!this.playedConnectedSound || this.onDestroyRunnable != null)) {
            this.needPlayEndSound = false;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$H18JJemWfSjLhhBDmf-QCGmYVns
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callEnded$87$VoIPService();
            }
        });
        int i = 700;
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$doMAgHBZ-Qw1pxljhr9_exeB3Hw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callEnded$88$VoIPService();
            }
        });
        Runnable runnable = this.connectingSoundRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.connectingSoundRunnable = null;
        }
        if (this.needPlayEndSound) {
            this.playingSound = true;
            if (this.groupCall == null) {
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$ffs8FMqqdc8wtk6QciZJKZdcjH4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$callEnded$89$VoIPService();
                    }
                });
            } else {
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$b9Hep77Bbvw2ZJs353tu4ktgq7c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$callEnded$90$VoIPService();
                    }
                }, 100L);
                i = 500;
            }
            AndroidUtilities.runOnUIThread(this.afterSoundRunnable, i);
        }
        Runnable runnable2 = this.timeoutRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.timeoutRunnable = null;
        }
        endConnectionServiceCall(this.needPlayEndSound ? i : 0L);
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$callEnded$87, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$callEnded$87$VoIPService() {
        dispatchStateChanged(11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$callEnded$88, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$callEnded$88$VoIPService() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
            this.spPlayId = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$callEnded$89, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$callEnded$89$VoIPService() {
        this.soundPool.play(this.spEndId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$callEnded$90, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$callEnded$90$VoIPService() {
        this.soundPool.play(this.spVoiceChatEndId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    private void endConnectionServiceCall(long delay) {
        if (USE_CONNECTION_SERVICE) {
            Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPService$lH8btW4XRxo4AKGb4eRVx7Ec2yU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$endConnectionServiceCall$91$VoIPService();
                }
            };
            if (delay > 0) {
                AndroidUtilities.runOnUIThread(runnable, delay);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$endConnectionServiceCall$91, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$endConnectionServiceCall$91$VoIPService() {
        CallConnection callConnection = this.systemCallConnection;
        if (callConnection != null) {
            int i = this.callDiscardReason;
            if (i == 1) {
                callConnection.setDisconnected(new DisconnectCause(this.isOutgoing ? 2 : 6));
            } else if (i != 2) {
                if (i == 3) {
                    callConnection.setDisconnected(new DisconnectCause(this.isOutgoing ? 4 : 5));
                } else if (i == 4) {
                    callConnection.setDisconnected(new DisconnectCause(7));
                } else {
                    callConnection.setDisconnected(new DisconnectCause(3));
                }
            } else {
                callConnection.setDisconnected(new DisconnectCause(1));
            }
            this.systemCallConnection.destroy();
            this.systemCallConnection = null;
        }
    }

    public boolean isOutgoing() {
        return this.isOutgoing;
    }

    public void handleNotificationAction(Intent intent) throws IllegalStateException, InterruptedException, PendingIntent.CanceledException, IOException {
        if ((getPackageName() + ".END_CALL").equals(intent.getAction())) {
            stopForeground(true);
            hangUp();
            return;
        }
        if ((getPackageName() + ".DECLINE_CALL").equals(intent.getAction())) {
            stopForeground(true);
            declineIncomingCall(4, null);
            return;
        }
        if ((getPackageName() + ".ANSWER_CALL").equals(intent.getAction())) {
            acceptIncomingCallFromNotification();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acceptIncomingCallFromNotification() throws IllegalStateException, PendingIntent.CanceledException, IOException {
        showNotification();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 && i < 30 && (checkSelfPermission("android.permission.RECORD_AUDIO") != 0 || (this.privateCall.video && checkSelfPermission("android.permission.CAMERA") != 0))) {
            try {
                PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) VoIPPermissionActivity.class).addFlags(268435456), 1073741824).send();
                return;
            } catch (Exception e) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("Error starting permission activity", e);
                    return;
                }
                return;
            }
        }
        acceptIncomingCall();
        try {
            PendingIntent.getActivity(this, 0, new Intent(this, getUIActivityClass()).setAction("voip"), 0).send();
        } catch (Exception e2) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error starting incall activity", e2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateOutputGainControlState() {
        int i = 0;
        if (this.tgVoip[0] != null) {
            if (!USE_CONNECTION_SERVICE) {
                AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                this.tgVoip[0].setAudioOutputGainControlEnabled((!hasEarpiece() || audioManager.isSpeakerphoneOn() || audioManager.isBluetoothScoOn() || this.isHeadsetPlugged) ? false : true);
                NativeInstance nativeInstance = this.tgVoip[0];
                if (!this.isHeadsetPlugged && (!hasEarpiece() || audioManager.isSpeakerphoneOn() || audioManager.isBluetoothScoOn() || this.isHeadsetPlugged)) {
                    i = 1;
                }
                nativeInstance.setEchoCancellationStrength(i);
                return;
            }
            boolean z = this.systemCallConnection.getCallAudioState().getRoute() == 1 ? 1 : 0;
            this.tgVoip[0].setAudioOutputGainControlEnabled(z);
            this.tgVoip[0].setEchoCancellationStrength(!z);
        }
    }

    public int getAccount() {
        return this.currentAccount;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws InterruptedException {
        if (id == NotificationCenter.appDidLogout) {
            callEnded();
        }
    }

    public static boolean isAnyKindOfCallActive() {
        return (getSharedInstance() == null || getSharedInstance().getCallState() == 15) ? false : true;
    }

    private boolean isFinished() {
        int i = this.currentState;
        return i == 11 || i == 4;
    }

    public int getRemoteAudioState() {
        return this.remoteAudioState;
    }

    public int getRemoteVideoState() {
        return this.remoteVideoState;
    }

    @TargetApi(26)
    private PhoneAccountHandle addAccountToTelecomManager() {
        TelecomManager telecomManager = (TelecomManager) getSystemService("telecom");
        TLRPC$User currentUser = UserConfig.getInstance(this.currentAccount).getCurrentUser();
        PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(new ComponentName(this, (Class<?>) EitaaConnectionService.class), "" + currentUser.id);
        telecomManager.registerPhoneAccount(new PhoneAccount.Builder(phoneAccountHandle, ContactsController.formatName(currentUser.first_name, currentUser.last_name)).setCapabilities(Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS).setIcon(Icon.createWithResource(this, R.drawable.ic_launcher_dr)).setHighlightColor(-13851168).addSupportedUriScheme("sip").build());
        return phoneAccountHandle;
    }

    private static boolean isDeviceCompatibleWithConnectionServiceAPI() {
        if (Build.VERSION.SDK_INT < 26) {
        }
        return false;
    }

    public class CallConnection extends Connection {
        public CallConnection() {
            setConnectionProperties(128);
            setAudioModeIsVoip(true);
        }

        @Override // android.telecom.Connection
        public void onCallAudioStateChanged(CallAudioState state) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("ConnectionService call audio state changed: " + state);
            }
            Iterator it = VoIPService.this.stateListeners.iterator();
            while (it.hasNext()) {
                ((StateListener) it.next()).onAudioSettingsChanged();
            }
        }

        @Override // android.telecom.Connection
        public void onDisconnect() throws IllegalStateException, InterruptedException {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("ConnectionService onDisconnect");
            }
            setDisconnected(new DisconnectCause(2));
            destroy();
            VoIPService.this.systemCallConnection = null;
            VoIPService.this.hangUp();
        }

        @Override // android.telecom.Connection
        public void onAnswer() throws IllegalStateException, PendingIntent.CanceledException, IOException {
            VoIPService.this.acceptIncomingCallFromNotification();
        }

        @Override // android.telecom.Connection
        public void onReject() throws IllegalStateException, InterruptedException {
            VoIPService.this.needPlayEndSound = false;
            VoIPService.this.declineIncomingCall(1, null);
        }

        @Override // android.telecom.Connection
        public void onShowIncomingCallUi() throws IllegalStateException, Resources.NotFoundException, PendingIntent.CanceledException, IOException, SecurityException, IllegalArgumentException {
            VoIPService.this.startRinging();
        }

        @Override // android.telecom.Connection
        public void onStateChanged(int state) {
            super.onStateChanged(state);
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("ConnectionService onStateChanged " + Connection.stateToString(state));
            }
            if (state == 4) {
                ContactsController.getInstance(VoIPService.this.currentAccount).deleteConnectionServiceContact();
                VoIPService.this.didDeleteConnectionServiceContact = true;
            }
        }

        @Override // android.telecom.Connection
        public void onCallEvent(String event, Bundle extras) {
            super.onCallEvent(event, extras);
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("ConnectionService onCallEvent " + event);
            }
        }

        @Override // android.telecom.Connection
        public void onSilence() throws IllegalStateException {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("onSlience");
            }
            VoIPService.this.stopRinging();
        }
    }
}
