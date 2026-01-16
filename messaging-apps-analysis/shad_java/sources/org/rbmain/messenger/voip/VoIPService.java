package org.rbmain.messenger.voip;

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
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRouter;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
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
import androidMessenger.ServiceLocator;
import androidMessenger.model.GroupCallSdp;
import androidMessenger.proxy.CallProxy;
import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import com.facebook.stetho.server.http.HttpStatus;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.StatsController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.XiaomiUtilities;
import org.rbmain.messenger.voip.Instance;
import org.rbmain.messenger.voip.NativeInstance;
import org.rbmain.messenger.voip.VoIPController;
import org.rbmain.messenger.voip.VoIPService;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.RequestDelegateTimestamp;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$GroupCall;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$PhoneCall;
import org.rbmain.tgnet.TLRPC$TL_chatFull;
import org.rbmain.tgnet.TLRPC$TL_dataJSON;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_groupCall;
import org.rbmain.tgnet.TLRPC$TL_groupCallDiscarded;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipant;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipantVideo;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipantVideoSourceGroup;
import org.rbmain.tgnet.TLRPC$TL_inputGroupCallStream;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_inputPhoneCall;
import org.rbmain.tgnet.TLRPC$TL_messages_getDhConfig;
import org.rbmain.tgnet.TLRPC$TL_messages_setTyping;
import org.rbmain.tgnet.TLRPC$TL_phoneCall;
import org.rbmain.tgnet.TLRPC$TL_phoneCallAccepted;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonBusy;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonDisconnect;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonHangup;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonMissed;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscarded;
import org.rbmain.tgnet.TLRPC$TL_phoneCallProtocol;
import org.rbmain.tgnet.TLRPC$TL_phone_acceptCall;
import org.rbmain.tgnet.TLRPC$TL_phone_checkGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_createGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_discardCall;
import org.rbmain.tgnet.TLRPC$TL_phone_discardGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_editGroupCallParticipant;
import org.rbmain.tgnet.TLRPC$TL_phone_getGroupCallStreamChannels;
import org.rbmain.tgnet.TLRPC$TL_phone_groupCallStreamChannels;
import org.rbmain.tgnet.TLRPC$TL_phone_joinGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_joinGroupCallPresentation;
import org.rbmain.tgnet.TLRPC$TL_phone_leaveGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_leaveGroupCallPresentation;
import org.rbmain.tgnet.TLRPC$TL_phone_phoneCall;
import org.rbmain.tgnet.TLRPC$TL_phone_receivedCall;
import org.rbmain.tgnet.TLRPC$TL_phone_requestCall;
import org.rbmain.tgnet.TLRPC$TL_phone_saveCallDebug;
import org.rbmain.tgnet.TLRPC$TL_phone_sendSignalingData;
import org.rbmain.tgnet.TLRPC$TL_speakingInGroupCallAction;
import org.rbmain.tgnet.TLRPC$TL_updateGroupCall;
import org.rbmain.tgnet.TLRPC$TL_updateGroupCallConnection;
import org.rbmain.tgnet.TLRPC$TL_updateGroupCallParticipants;
import org.rbmain.tgnet.TLRPC$TL_updatePhoneCallSignalingData;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$TL_upload_file;
import org.rbmain.tgnet.TLRPC$TL_upload_getFile;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.JoinCallAlert;
import org.rbmain.ui.Components.voip.VoIPHelper;
import org.rbmain.ui.LaunchActivity;
import org.rbmain.ui.VoIPFeedbackActivity;
import org.rbmain.ui.VoIPFragment;
import org.rbmain.ui.VoIPPermissionActivity;
import org.webrtc.MediaStreamTrack;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
import org.webrtc.voiceengine.WebRtcAudioTrack;

/* loaded from: classes4.dex */
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
    protected static final long Get_SIGNAL_PERIOD = 700;
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
    private AudioDeviceCallback audioDeviceCallback;
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
    private volatile CountDownLatch groupCallBottomSheetLatch;
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
    private BluetoothProfile.ServiceListener serviceListener = new BluetoothProfile.ServiceListener() { // from class: org.rbmain.messenger.voip.VoIPService.2
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 31 || VoIPService.this.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0) {
                if (i2 < 31) {
                    try {
                        Iterator<BluetoothDevice> it = bluetoothProfile.getConnectedDevices().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            BluetoothDevice next = it.next();
                            if (bluetoothProfile.getConnectionState(next) == 2) {
                                VoIPService.this.currentBluetoothDeviceName = next.getName();
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        FileLog.e(th);
                        return;
                    }
                }
                BluetoothAdapter.getDefaultAdapter().closeProfileProxy(i, bluetoothProfile);
                VoIPService.this.fetchingBluetoothDeviceName = false;
            }
        }
    };
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: org.rbmain.messenger.voip.VoIPService.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
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
                    if (VoipAudioManager.get().isSpeakerphoneOn()) {
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
                        VoipAudioManager.get().setSpeakerphoneOn(false);
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
    private final LruCache<String, ProxyVideoSink> proxyVideoSinkLruCache = new LruCache<String, ProxyVideoSink>(6) { // from class: org.rbmain.messenger.voip.VoIPService.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public void entryRemoved(boolean z, String str, ProxyVideoSink proxyVideoSink, ProxyVideoSink proxyVideoSink2) {
            super.entryRemoved(z, (boolean) str, proxyVideoSink, proxyVideoSink2);
            VoIPService.this.tgVoip[0].removeIncomingVideoOutput(proxyVideoSink.nativeInstance);
        }
    };
    private ProxyVideoSink[] localSink = new ProxyVideoSink[2];
    private ProxyVideoSink[] remoteSink = new ProxyVideoSink[2];
    private ProxyVideoSink[] currentBackgroundSink = new ProxyVideoSink[2];
    private String[] currentBackgroundEndpointId = new String[2];
    private HashMap<String, ProxyVideoSink> remoteSinks = new HashMap<>();
    protected final Runnable getSignalingDataRunnable = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService.10
        @Override // java.lang.Runnable
        public void run() {
            VoIPService voIPService = VoIPService.this;
            if (voIPService.privateCall != null) {
                ServiceLocator.getInstance(voIPService.currentAccount).getCoreMainClass().getSignalingData(VoIPService.this.privateCall.id);
            }
            AndroidUtilities.runOnUIThread(VoIPService.this.getSignalingDataRunnable, VoIPService.Get_SIGNAL_PERIOD);
        }
    };

    public static class SharedUIParams {
        public boolean cameraAlertWasShowed;
        public boolean tapToVideoTooltipWasShowed;
        public boolean wasVideoCall;
    }

    public interface StateListener {

        /* renamed from: org.rbmain.messenger.voip.VoIPService$StateListener$-CC, reason: invalid class name */
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

        void onCameraSwitch(boolean z);

        void onMediaStateUpdated(int i, int i2);

        void onScreenOnChange(boolean z);

        void onSignalBarsCountChanged(int i);

        void onStateChanged(int i);

        void onVideoAvailableChange(boolean z);
    }

    private static boolean isDeviceCompatibleWithConnectionServiceAPI() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onSignalingData$58(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    private void onTgVoipPreStop() {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: org.rbmain.messenger.voip.VoIPService$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            final AudioManager audioManager = (AudioManager) VoIPService.this.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            VoipAudioManager voipAudioManager = VoipAudioManager.get();
            audioManager.abandonAudioFocus(VoIPService.this);
            audioManager.unregisterMediaButtonEventReceiver(new ComponentName(VoIPService.this, (Class<?>) VoIPMediaButtonReceiver.class));
            if (VoIPService.this.audioDeviceCallback != null) {
                audioManager.unregisterAudioDeviceCallback(VoIPService.this.audioDeviceCallback);
            }
            if (!VoIPService.USE_CONNECTION_SERVICE && VoIPService.sharedInstance == null) {
                if (VoIPService.this.isBtHeadsetConnected) {
                    audioManager.stopBluetoothSco();
                    audioManager.setBluetoothScoOn(false);
                    VoIPService.this.bluetoothScoActive = false;
                    VoIPService.this.bluetoothScoConnecting = false;
                }
                voipAudioManager.setSpeakerphoneOn(false);
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0();
                }
            });
            Utilities.globalQueue.postRunnable(VoIPService.setModeRunnable = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    VoIPService.AnonymousClass1.lambda$run$1(audioManager);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            VoIPService.this.soundPool.release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$1(AudioManager audioManager) {
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

    public CountDownLatch getGroupCallBottomSheetLatch() {
        return this.groupCallBottomSheetLatch;
    }

    public boolean isFrontFaceCamera() {
        return this.isFrontFaceCamera;
    }

    public boolean isScreencast() {
        return this.isPrivateScreencast;
    }

    public void setMicMute(boolean z, boolean z2, boolean z3) {
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
        if (this.micMute == z || this.micSwitching) {
            return;
        }
        this.micMute = z;
        ChatObject.Call call = this.groupCall;
        if (call != null) {
            if (!z3 && (tLRPC$TL_groupCallParticipant = call.participants.get(getSelfId())) != null && tLRPC$TL_groupCallParticipant.muted && !tLRPC$TL_groupCallParticipant.can_self_unmute) {
                z3 = true;
            }
            if (z3) {
                editCallMember(UserConfig.getInstance(this.currentAccount).getCurrentUser(), Boolean.valueOf(z), null, null, null, null);
                DispatchQueue dispatchQueue = Utilities.globalQueue;
                Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setMicMute$0();
                    }
                };
                this.updateNotificationRunnable = runnable;
                dispatchQueue.postRunnable(runnable);
            }
        }
        this.unmutedByHold = !this.micMute && z2;
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[0] != null) {
            nativeInstanceArr[0].setMuteMicrophone(z);
        }
        Iterator<StateListener> it = this.stateListeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSettingsChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMicMute$0() {
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

    public void checkVideoFrame(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, boolean z) {
        String str = z ? tLRPC$TL_groupCallParticipant.presentationEndpoint : tLRPC$TL_groupCallParticipant.videoEndpoint;
        if (str == null) {
            return;
        }
        if (!z || tLRPC$TL_groupCallParticipant.hasPresentationFrame == 0) {
            if (z || tLRPC$TL_groupCallParticipant.hasCameraFrame == 0) {
                if (this.proxyVideoSinkLruCache.get(str) != null || (this.remoteSinks.get(str) != null && this.waitingFrameParticipant.get(str) == null)) {
                    if (z) {
                        tLRPC$TL_groupCallParticipant.hasPresentationFrame = 2;
                        return;
                    } else {
                        tLRPC$TL_groupCallParticipant.hasCameraFrame = 2;
                        return;
                    }
                }
                if (this.waitingFrameParticipant.containsKey(str)) {
                    this.waitingFrameParticipant.put(str, tLRPC$TL_groupCallParticipant);
                    if (z) {
                        tLRPC$TL_groupCallParticipant.hasPresentationFrame = 1;
                        return;
                    } else {
                        tLRPC$TL_groupCallParticipant.hasCameraFrame = 1;
                        return;
                    }
                }
                if (z) {
                    tLRPC$TL_groupCallParticipant.hasPresentationFrame = 1;
                } else {
                    tLRPC$TL_groupCallParticipant.hasCameraFrame = 1;
                }
                this.waitingFrameParticipant.put(str, tLRPC$TL_groupCallParticipant);
                addRemoteSink(tLRPC$TL_groupCallParticipant, z, new AnonymousClass5(str, z), null);
            }
        }
    }

    /* renamed from: org.rbmain.messenger.voip.VoIPService$5, reason: invalid class name */
    class AnonymousClass5 implements VideoSink {
        final /* synthetic */ String val$endpointId;
        final /* synthetic */ boolean val$screencast;

        @Override // org.webrtc.VideoSink
        public /* synthetic */ void setParentSink(VideoSink videoSink) {
            VideoSink.CC.$default$setParentSink(this, videoSink);
        }

        AnonymousClass5(String str, boolean z) {
            this.val$endpointId = str;
            this.val$screencast = z;
        }

        @Override // org.webrtc.VideoSink
        public void onFrame(VideoFrame videoFrame) {
            if (videoFrame == null || videoFrame.getBuffer().getHeight() == 0 || videoFrame.getBuffer().getWidth() == 0) {
                return;
            }
            final String str = this.val$endpointId;
            final boolean z = this.val$screencast;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFrame$0(str, this, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFrame$0(String str, VideoSink videoSink, boolean z) {
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

    public void setAudioRoute(int i) {
        if (i == 1) {
            setAudioOutput(0);
        } else if (i == 0) {
            setAudioOutput(1);
        } else if (i == 2) {
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
        public synchronized void onFrame(VideoFrame videoFrame) {
            VideoSink videoSink = this.target;
            if (videoSink != null) {
                videoSink.onFrame(videoFrame);
            }
            VideoSink videoSink2 = this.background;
            if (videoSink2 != null) {
                videoSink2.onFrame(videoFrame);
            }
        }

        public synchronized void setTarget(VideoSink videoSink) {
            VideoSink videoSink2 = this.target;
            if (videoSink2 != videoSink) {
                if (videoSink2 != null) {
                    videoSink2.setParentSink(null);
                }
                this.target = videoSink;
                if (videoSink != null) {
                    videoSink.setParentSink(this);
                }
            }
        }

        public synchronized void setBackground(VideoSink videoSink) {
            VideoSink videoSink2 = this.background;
            if (videoSink2 != null) {
                videoSink2.setParentSink(null);
            }
            this.background = videoSink;
            if (videoSink != null) {
                videoSink.setParentSink(this);
            }
        }

        public synchronized void removeTarget(VideoSink videoSink) {
            if (this.target == videoSink) {
                this.target = null;
            }
        }

        public synchronized void removeBackground(VideoSink videoSink) {
            if (this.background == videoSink) {
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
    public int onStartCommand(Intent intent, int i, int i2) throws IOException {
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
        int intExtra2 = intent.getIntExtra("user_id", 0);
        int intExtra3 = intent.getIntExtra("chat_id", 0);
        this.createGroupCall = intent.getBooleanExtra("createGroupCall", false);
        this.hasFewPeers = intent.getBooleanExtra("hasFewPeers", false);
        this.joinHash = intent.getStringExtra("hash");
        int intExtra4 = intent.getIntExtra("peerChannelId", 0);
        int intExtra5 = intent.getIntExtra("peerChatId", 0);
        int intExtra6 = intent.getIntExtra("peerUserId", 0);
        if (intExtra5 != 0) {
            TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            this.groupCallPeer = tLRPC$TL_inputPeerChat;
            tLRPC$TL_inputPeerChat.chat_id = intExtra5;
            tLRPC$TL_inputPeerChat.access_hash = intent.getLongExtra("peerAccessHash", 0L);
        } else if (intExtra4 != 0) {
            TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
            this.groupCallPeer = tLRPC$TL_inputPeerChannel;
            tLRPC$TL_inputPeerChannel.channel_id = intExtra4;
            tLRPC$TL_inputPeerChannel.access_hash = intent.getLongExtra("peerAccessHash", 0L);
        } else if (intExtra6 != 0) {
            TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
            this.groupCallPeer = tLRPC$TL_inputPeerUser;
            tLRPC$TL_inputPeerUser.user_id = intExtra6;
            tLRPC$TL_inputPeerUser.access_hash = intent.getLongExtra("peerAccessHash", 0L);
        }
        this.scheduleDate = intent.getIntExtra("scheduleDate", 0);
        this.isOutgoing = intent.getBooleanExtra("is_outgoing", false);
        this.videoCall = intent.getBooleanExtra("video_call", false);
        this.isVideoAvailable = intent.getBooleanExtra("can_video_call", false);
        this.notificationsDisabled = intent.getBooleanExtra("notifications_disabled", false);
        if (intExtra2 != 0) {
            this.user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(intExtra2));
        }
        if (intExtra3 != 0) {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(intExtra3));
            this.chat = chat;
            if (ChatObject.isChannel(chat)) {
                MessagesController.getInstance(this.currentAccount).startShortPoll(this.chat, this.classGuid, false);
            }
        }
        loadResources();
        int i3 = 0;
        while (true) {
            ProxyVideoSink[] proxyVideoSinkArr = this.localSink;
            if (i3 < proxyVideoSinkArr.length) {
                proxyVideoSinkArr[i3] = new ProxyVideoSink();
                this.remoteSink[i3] = new ProxyVideoSink();
                i3++;
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
                this.captureDevice[0] = NativeInstance.createVideoCapturer(this.localSink[0], this.isFrontFaceCamera ? 1 : 0);
                if (intExtra3 != 0) {
                    this.videoState[0] = 1;
                } else {
                    this.videoState[0] = 2;
                }
            } else {
                this.videoState[0] = 1;
            }
            if (!this.isBtHeadsetConnected && !this.isHeadsetPlugged) {
                setAudioOutput(0);
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
                    Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda21
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onStartCommand$1();
                        }
                    };
                    this.delayedStartOutgoingCall = runnable;
                    AndroidUtilities.runOnUIThread(runnable, 2000L);
                }
            } else {
                this.micMute = true;
                startGroupCall(0, null, false);
                if (!this.isBtHeadsetConnected && !this.isHeadsetPlugged) {
                    setAudioOutput(0);
                }
            }
            if (intent.getBooleanExtra("start_incall_activity", false)) {
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
            boolean z = tLRPC$PhoneCall != null && tLRPC$PhoneCall.video;
            this.videoCall = z;
            if (z) {
                this.isVideoAvailable = true;
            }
            if (z && !this.isBtHeadsetConnected && !this.isHeadsetPlugged) {
                setAudioOutput(0);
            }
            callIShouldHavePutIntoIntent = null;
            if (USE_CONNECTION_SERVICE) {
                acknowledgeCall(false);
                showNotification();
            } else {
                acknowledgeCall(true);
            }
        }
        initializeAccountRelatedThings();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStartCommand$2();
            }
        });
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartCommand$1() {
        this.delayedStartOutgoingCall = null;
        startOutgoingCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartCommand$2() {
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.voipServiceCreated, new Object[0]);
    }

    public static boolean hasRtmpStream() {
        return (getSharedInstance() == null || getSharedInstance().groupCall == null || !getSharedInstance().groupCall.call.rtmp_stream) ? false : true;
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

    public void setNoiseSupressionEnabled(boolean z) {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[0] == null) {
            return;
        }
        nativeInstanceArr[0].setNoiseSuppressionEnabled(z);
    }

    public void setGroupCallHash(String str) {
        if (!this.currentGroupModeStreaming || TextUtils.isEmpty(str) || str.equals(this.joinHash)) {
            return;
        }
        this.joinHash = str;
        createGroupInstance(0, false);
    }

    public int getCallerId() {
        TLRPC$User tLRPC$User = this.user;
        if (tLRPC$User != null) {
            return tLRPC$User.id;
        }
        return -this.chat.id;
    }

    public void reJoin() {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[0] != null) {
            if (nativeInstanceArr[0].isGroup()) {
                NativeInstance nativeInstance = this.tgVoip[0];
                DispatchQueue dispatchQueue = Utilities.globalQueue;
                nativeInstance.getClass();
                dispatchQueue.postRunnable(new VoIPService$$ExternalSyntheticLambda4(nativeInstance));
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
            this.callStartTime = 0L;
            this.tgVoip[0] = null;
        }
        startGroupCall(0, null, true);
    }

    public void detectVoiceChatNotExist() {
        if (this.groupCall != null) {
            TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall = new TLRPC$TL_updateGroupCall();
            tLRPC$TL_updateGroupCall.chat_id = this.groupCall.chatId;
            TLRPC$TL_groupCallDiscarded tLRPC$TL_groupCallDiscarded = new TLRPC$TL_groupCallDiscarded();
            tLRPC$TL_updateGroupCall.call = tLRPC$TL_groupCallDiscarded;
            ChatObject.Call call = this.groupCall;
            TLRPC$GroupCall tLRPC$GroupCall = call.call;
            tLRPC$TL_groupCallDiscarded.id = tLRPC$GroupCall.id;
            tLRPC$TL_groupCallDiscarded.access_hash = tLRPC$GroupCall.access_hash;
            call.processGroupCallUpdate(tLRPC$TL_updateGroupCall);
            if (getSharedInstance() != null) {
                getSharedInstance().onGroupCallUpdated(tLRPC$TL_updateGroupCall.call);
            }
        }
        MessagesController.getInstance(this.currentAccount).loadFullChat(this.groupCall.chatId, 0, true);
    }

    public void hangUp(int i, Runnable runnable) {
        int i2 = this.currentState;
        declineIncomingCall((i2 == 16 || (i2 == 13 && this.isOutgoing)) ? 3 : 1, runnable);
        if (this.groupCall == null || i == 2) {
            return;
        }
        if (i == 1) {
            TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(this.chat.id);
            if (chatFull != null) {
                chatFull.flags &= -2097153;
                chatFull.call = null;
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chat.id), this.groupCall.call.id, Boolean.FALSE);
            }
            TLRPC$TL_phone_discardGroupCall tLRPC$TL_phone_discardGroupCall = new TLRPC$TL_phone_discardGroupCall();
            tLRPC$TL_phone_discardGroupCall.call = this.groupCall.getInputGroupCall();
            CallProxy.getInstance(this.currentAccount).discardGroupVoiceChat(tLRPC$TL_phone_discardGroupCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda84
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$hangUp$3(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (i == 3) {
            TLRPC$ChatFull chatFull2 = MessagesController.getInstance(this.currentAccount).getChatFull(this.chat.id);
            if (chatFull2 != null) {
                chatFull2.call = null;
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chat.id), this.groupCall.call.id, Boolean.FALSE);
                return;
            }
            return;
        }
        TLRPC$TL_phone_leaveGroupCall tLRPC$TL_phone_leaveGroupCall = new TLRPC$TL_phone_leaveGroupCall();
        tLRPC$TL_phone_leaveGroupCall.call = this.groupCall.getInputGroupCall();
        tLRPC$TL_phone_leaveGroupCall.source = this.mySource[0];
        CallProxy.getInstance(this.currentAccount).leaveGroupVoiceChat(tLRPC$TL_phone_leaveGroupCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda80
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$hangUp$4(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hangUp$3(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_updates) {
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$TL_updates) tLObject, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hangUp$4(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_updates) {
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$TL_updates) tLObject, false);
        }
    }

    private void startOutgoingCall() {
        CallConnection callConnection;
        if (USE_CONNECTION_SERVICE && (callConnection = this.systemCallConnection) != null) {
            callConnection.setDialing();
        }
        configureDeviceForCall();
        showNotification();
        startConnectingSound();
        dispatchStateChanged(14);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda61
            @Override // java.lang.Runnable
            public final void run() {
                VoIPService.lambda$startOutgoingCall$5();
            }
        });
        Utilities.random.nextBytes(new byte[256]);
        TLRPC$TL_messages_getDhConfig tLRPC$TL_messages_getDhConfig = new TLRPC$TL_messages_getDhConfig();
        tLRPC$TL_messages_getDhConfig.random_length = 256;
        tLRPC$TL_messages_getDhConfig.version = MessagesStorage.getInstance(this.currentAccount).getLastSecretVersion();
        this.callReqId = CallProxy.getInstance(this.currentAccount).secureCall(tLRPC$TL_messages_getDhConfig, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda83
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startOutgoingCall$10(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startOutgoingCall$5() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startOutgoingCall$10(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        this.callReqId = 0;
        if (this.endCallAfterRequest) {
            callEnded();
            return;
        }
        if (tLRPC$TL_error == null) {
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
            tLRPC$TL_phone_requestCall.random_id = Utilities.random.nextInt();
            CallProxy.getInstance(this.currentAccount).requestCall(tLRPC$TL_phone_requestCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda86
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$startOutgoingCall$9(tLObject2, tLRPC$TL_error2);
                }
            });
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e("Error on getDhConfig " + tLRPC$TL_error);
        }
        callFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startOutgoingCall$9(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda52
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$startOutgoingCall$8(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startOutgoingCall$8(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) throws Exception {
        if (tLRPC$TL_error == null) {
            this.privateCall = ((TLRPC$TL_phone_phoneCall) tLObject).phone_call;
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
            Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startOutgoingCall$7();
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
    public /* synthetic */ void lambda$startOutgoingCall$7() {
        this.timeoutRunnable = null;
        TLRPC$TL_phone_discardCall tLRPC$TL_phone_discardCall = new TLRPC$TL_phone_discardCall();
        TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
        tLRPC$TL_phone_discardCall.peer = tLRPC$TL_inputPhoneCall;
        TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
        long j = tLRPC$PhoneCall.access_hash;
        tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
        tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonMissed();
        CallProxy.getInstance(this.currentAccount).discardCall(tLRPC$TL_phone_discardCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda79
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startOutgoingCall$6(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startOutgoingCall$6(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (BuildVars.LOGS_ENABLED) {
            if (tLRPC$TL_error != null) {
                FileLog.e("error on phone.discardCall: " + tLRPC$TL_error);
            } else {
                FileLog.d("phone.discardCall " + tLObject);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.callFailed();
            }
        });
    }

    private void acknowledgeCall(final boolean z) throws IOException {
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
        long j = tLRPC$PhoneCall.access_hash;
        CallProxy.getInstance(this.currentAccount).receivedCall(tLRPC$TL_phone_receivedCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda92
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$acknowledgeCall$12(z, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acknowledgeCall$12(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException, PendingIntent.CanceledException, IOException {
                this.f$0.lambda$acknowledgeCall$11(tLObject, tLRPC$TL_error, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acknowledgeCall$11(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error, boolean z) throws Resources.NotFoundException, PendingIntent.CanceledException, IOException {
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
            org.rbmain.messenger.voip.NativeInstance[] r0 = r8.tgVoip
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
            org.rbmain.messenger.voip.VoIPService$ProxyVideoSink[] r2 = r8.localSink
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.voip.VoIPService.requestVideoCall(boolean):void");
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
            editCallMember(UserConfig.getInstance(this.currentAccount).getCurrentUser(), Boolean.valueOf(!z2), Boolean.valueOf(this.videoState[0] != 2), null, null, new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setupCaptureDevice$13();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupCaptureDevice$13() {
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

    public void stopScreenCapture() {
        if (this.groupCall == null || this.videoState[1] != 2) {
            return;
        }
        TLRPC$TL_phone_leaveGroupCallPresentation tLRPC$TL_phone_leaveGroupCallPresentation = new TLRPC$TL_phone_leaveGroupCallPresentation();
        tLRPC$TL_phone_leaveGroupCallPresentation.call = this.groupCall.getInputGroupCall();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_leaveGroupCallPresentation, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda78
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$stopScreenCapture$14(tLObject, tLRPC$TL_error);
            }
        });
        NativeInstance nativeInstance = this.tgVoip[1];
        if (nativeInstance != null) {
            Utilities.globalQueue.postRunnable(new VoIPService$$ExternalSyntheticLambda4(nativeInstance));
        }
        this.mySource[1] = 0;
        this.tgVoip[1] = null;
        this.destroyCaptureDevice[1] = true;
        this.captureDevice[1] = 0;
        this.videoState[1] = 0;
        AccountInstance.getInstance(this.currentAccount).getNotificationCenter().postNotificationName(NotificationCenter.groupCallScreencastStateChanged, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopScreenCapture$14(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public int getVideoState(boolean z) {
        return this.videoState[z ? 1 : 0];
    }

    public void setSinks(VideoSink videoSink, VideoSink videoSink2) {
        setSinks(videoSink, false, videoSink2);
    }

    public void setSinks(VideoSink videoSink, boolean z, VideoSink videoSink2) {
        ProxyVideoSink proxyVideoSink = this.localSink[z ? 1 : 0];
        ProxyVideoSink proxyVideoSink2 = this.remoteSink[z ? 1 : 0];
        if (proxyVideoSink != null) {
            proxyVideoSink.setTarget(videoSink);
        }
        if (proxyVideoSink2 != null) {
            proxyVideoSink2.setTarget(videoSink2);
        }
    }

    public void setLocalSink(VideoSink videoSink, boolean z) {
        if (z) {
            this.localSink[1].setTarget(videoSink);
        } else {
            this.localSink[0].setTarget(videoSink);
        }
    }

    public void setRemoteSink(VideoSink videoSink, boolean z) {
        this.remoteSink[z ? 1 : 0].setTarget(videoSink);
    }

    public ProxyVideoSink addRemoteSink(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, boolean z, VideoSink videoSink, VideoSink videoSink2) {
        if (this.tgVoip[0] == null) {
            return null;
        }
        String str = z ? tLRPC$TL_groupCallParticipant.presentationEndpoint : tLRPC$TL_groupCallParticipant.videoEndpoint;
        if (str == null) {
            return null;
        }
        ProxyVideoSink proxyVideoSink = this.remoteSinks.get(str);
        if (proxyVideoSink != null && proxyVideoSink.target == videoSink) {
            return proxyVideoSink;
        }
        if (proxyVideoSink == null) {
            proxyVideoSink = this.proxyVideoSinkLruCache.remove(str);
        }
        if (proxyVideoSink == null) {
            proxyVideoSink = new ProxyVideoSink();
        }
        if (videoSink != null) {
            proxyVideoSink.setTarget(videoSink);
        }
        if (videoSink2 != null) {
            proxyVideoSink.setBackground(videoSink2);
        }
        this.remoteSinks.put(str, proxyVideoSink);
        proxyVideoSink.nativeInstance = this.tgVoip[0].addIncomingVideoOutput(1, str, createSsrcGroups(z ? tLRPC$TL_groupCallParticipant.presentation : tLRPC$TL_groupCallParticipant.video), proxyVideoSink);
        return proxyVideoSink;
    }

    private NativeInstance.SsrcGroup[] createSsrcGroups(TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo) {
        if (tLRPC$TL_groupCallParticipantVideo.source_groups.isEmpty()) {
            return null;
        }
        int size = tLRPC$TL_groupCallParticipantVideo.source_groups.size();
        NativeInstance.SsrcGroup[] ssrcGroupArr = new NativeInstance.SsrcGroup[size];
        for (int i = 0; i < size; i++) {
            ssrcGroupArr[i] = new NativeInstance.SsrcGroup();
            TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup = tLRPC$TL_groupCallParticipantVideo.source_groups.get(i);
            ssrcGroupArr[i].semantics = tLRPC$TL_groupCallParticipantVideoSourceGroup.semantics;
            ssrcGroupArr[i].ssrcs = new int[tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.size()];
            for (int i2 = 0; i2 < ssrcGroupArr[i].ssrcs.length; i2++) {
                ssrcGroupArr[i].ssrcs[i2] = tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.get(i2).intValue();
            }
        }
        return ssrcGroupArr;
    }

    public void requestFullScreen(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, boolean z, boolean z2) {
        String str = z2 ? tLRPC$TL_groupCallParticipant.presentationEndpoint : tLRPC$TL_groupCallParticipant.videoEndpoint;
        if (str == null) {
            return;
        }
        if (z) {
            this.tgVoip[0].setVideoEndpointQuality(str, 2);
        } else {
            this.tgVoip[0].setVideoEndpointQuality(str, 1);
        }
    }

    public void removeRemoteSink(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, boolean z) {
        if (z) {
            ProxyVideoSink proxyVideoSinkRemove = this.remoteSinks.remove(tLRPC$TL_groupCallParticipant.presentationEndpoint);
            if (proxyVideoSinkRemove != null) {
                this.tgVoip[0].removeIncomingVideoOutput(proxyVideoSinkRemove.nativeInstance);
                return;
            }
            return;
        }
        ProxyVideoSink proxyVideoSinkRemove2 = this.remoteSinks.remove(tLRPC$TL_groupCallParticipant.videoEndpoint);
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

    public void setBackgroundSinks(VideoSink videoSink, VideoSink videoSink2) {
        this.localSink[0].setBackground(videoSink);
        this.remoteSink[0].setBackground(videoSink2);
    }

    public void swapSinks() {
        this.localSink[0].swap();
        this.remoteSink[0].swap();
    }

    public boolean isHangingUp() {
        return this.currentState == 10;
    }

    public void onSignalingData(TLRPC$TL_updatePhoneCallSignalingData tLRPC$TL_updatePhoneCallSignalingData) {
        if (this.user != null) {
            NativeInstance[] nativeInstanceArr = this.tgVoip;
            if (nativeInstanceArr[0] == null || nativeInstanceArr[0].isGroup() || !CallProxy$$ExternalSyntheticBackport0.m(getCallID(), tLRPC$TL_updatePhoneCallSignalingData.phone_call_id)) {
                return;
            }
            this.tgVoip[0].onSignalingDataReceive(tLRPC$TL_updatePhoneCallSignalingData.data);
        }
    }

    public int getSelfId() {
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

    public void onGroupCallParticipantsUpdate(TLRPC$TL_updateGroupCallParticipants tLRPC$TL_updateGroupCallParticipants) {
        ChatObject.Call call;
        if (this.chat == null || (call = this.groupCall) == null || !CallProxy$$ExternalSyntheticBackport0.m(call.call.id, tLRPC$TL_updateGroupCallParticipants.call.id)) {
            return;
        }
        long selfId = getSelfId();
        int size = tLRPC$TL_updateGroupCallParticipants.participants.size();
        for (int i = 0; i < size; i++) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = tLRPC$TL_updateGroupCallParticipants.participants.get(i);
            if (tLRPC$TL_groupCallParticipant.left) {
                int i2 = tLRPC$TL_groupCallParticipant.source;
                if (i2 != 0 && i2 == this.mySource[0]) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < size; i4++) {
                        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = tLRPC$TL_updateGroupCallParticipants.participants.get(i4);
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

    public void onGroupCallUpdated(TLRPC$GroupCall tLRPC$GroupCall) {
        ChatObject.Call call;
        boolean zOptBoolean;
        TLRPC$TL_dataJSON tLRPC$TL_dataJSON;
        if (this.chat == null || (call = this.groupCall) == null || !CallProxy$$ExternalSyntheticBackport0.m(call.call.id, tLRPC$GroupCall.id)) {
            return;
        }
        if (this.groupCall.call instanceof TLRPC$TL_groupCallDiscarded) {
            hangUp(2);
            return;
        }
        boolean z = false;
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
                    NativeInstance nativeInstance = this.tgVoip[0];
                    TLRPC$GroupCall tLRPC$GroupCall2 = this.groupCall.call;
                    if (tLRPC$GroupCall2 != null && tLRPC$GroupCall2.rtmp_stream) {
                        z = true;
                    }
                    nativeInstance.prepareForStream(z);
                } else {
                    this.tgVoip[0].setJoinResponsePayload(tLRPC$TL_dataJSON.data);
                }
                dispatchStateChanged(2);
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
    }

    public void onCallUpdated(TLRPC$PhoneCall tLRPC$PhoneCall) {
        if (this.user == null) {
            return;
        }
        TLRPC$PhoneCall tLRPC$PhoneCall2 = this.privateCall;
        if (tLRPC$PhoneCall2 == null) {
            this.pendingUpdates.add(tLRPC$PhoneCall);
            return;
        }
        if (tLRPC$PhoneCall == null) {
            return;
        }
        if (!CallProxy$$ExternalSyntheticBackport0.m(tLRPC$PhoneCall.id, tLRPC$PhoneCall2.id)) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.w("onCallUpdated called with wrong call id (got " + tLRPC$PhoneCall.id + ", expected " + this.privateCall.id + ")");
                return;
            }
            return;
        }
        if (tLRPC$PhoneCall.access_hash == 0) {
            tLRPC$PhoneCall.access_hash = this.privateCall.access_hash;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("Call updated: " + tLRPC$PhoneCall);
        }
        this.privateCall = tLRPC$PhoneCall;
        if (tLRPC$PhoneCall instanceof TLRPC$TL_phoneCallDiscarded) {
            this.needSendDebugLog = tLRPC$PhoneCall.need_debug;
            this.needRateCall = tLRPC$PhoneCall.need_rating;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("call discarded, stopping service");
            }
            if (tLRPC$PhoneCall.reason instanceof TLRPC$TL_phoneCallDiscardReasonBusy) {
                dispatchStateChanged(17);
                this.playingSound = true;
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda33
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCallUpdated$15();
                    }
                });
                AndroidUtilities.runOnUIThread(this.afterSoundRunnable, 1500L);
                endConnectionServiceCall(1500L);
                stopSelf();
                return;
            }
            callEnded();
            return;
        }
        if ((tLRPC$PhoneCall instanceof TLRPC$TL_phoneCall) && this.authKey == null) {
            byte[] bytes = tLRPC$PhoneCall.key.getBytes();
            byte[] bArrComputeSHA1 = Utilities.computeSHA1(bytes);
            byte[] bArr = new byte[8];
            System.arraycopy(bArrComputeSHA1, bArrComputeSHA1.length - 8, bArr, 0, 8);
            this.authKey = bytes;
            this.keyFingerprint = Utilities.bytesToLong(bArr);
            initiateActualEncryptedCall();
            return;
        }
        if ((tLRPC$PhoneCall instanceof TLRPC$TL_phoneCallAccepted) && this.authKey == null) {
            processAcceptedCall();
            return;
        }
        if (this.currentState != 13 || tLRPC$PhoneCall.receive_date == 0) {
            return;
        }
        dispatchStateChanged(16);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("!!!!!! CALL RECEIVED");
        }
        Runnable runnable = this.connectingSoundRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.connectingSoundRunnable = null;
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCallUpdated$16();
            }
        });
        Runnable runnable2 = this.timeoutRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.timeoutRunnable = null;
        }
        Runnable runnable3 = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCallUpdated$17();
            }
        };
        this.timeoutRunnable = runnable3;
        AndroidUtilities.runOnUIThread(runnable3, MessagesController.getInstance(this.currentAccount).callRingTimeout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCallUpdated$15() {
        this.soundPool.play(this.spBusyId, 1.0f, 1.0f, 0, -1, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCallUpdated$16() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
        }
        this.spPlayId = this.soundPool.play(this.spRingbackID, 1.0f, 1.0f, 0, -1, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCallUpdated$17() {
        this.timeoutRunnable = null;
        declineIncomingCall(3, null);
    }

    private void startRatingActivity() throws PendingIntent.CanceledException {
        try {
            PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) VoIPFeedbackActivity.class).putExtra("call_id", this.privateCall.id).putExtra("call_access_hash", this.privateCall.access_hash).putExtra("call_video", this.privateCall.video).putExtra("account", this.currentAccount).addFlags(805306368), ConnectionsManager.FileTypeVideo).send();
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error starting incall activity", e);
            }
        }
    }

    public byte[] getEncryptionKey() {
        return this.authKey;
    }

    private void processAcceptedCall() throws NumberFormatException {
        dispatchStateChanged(12);
        byte[] bytes = this.privateCall.key.getBytes();
        byte[] bArrComputeSHA1 = Utilities.computeSHA1(bytes);
        byte[] bArr = new byte[8];
        System.arraycopy(bArrComputeSHA1, bArrComputeSHA1.length - 8, bArr, 0, 8);
        long jBytesToLong = Utilities.bytesToLong(bArr);
        this.authKey = bytes;
        this.keyFingerprint = jBytesToLong;
        initiateActualEncryptedCall();
    }

    private int convertDataSavingMode(int i) {
        return i != 3 ? i : ApplicationLoader.isRoaming() ? 1 : 0;
    }

    public void migrateToChat(TLRPC$Chat tLRPC$Chat) {
        this.chat = tLRPC$Chat;
    }

    public void setGroupCallPeer(TLRPC$InputPeer tLRPC$InputPeer) {
        ChatObject.Call call = this.groupCall;
        if (call == null) {
            return;
        }
        this.groupCallPeer = tLRPC$InputPeer;
        call.setSelfPeer(tLRPC$InputPeer);
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

    private void startGroupCall(final int i, String str, final boolean z) {
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
            int i2 = this.scheduleDate;
            if (i2 != 0) {
                tLRPC$TL_phone_createGroupCall.schedule_date = i2;
                tLRPC$TL_phone_createGroupCall.flags |= 2;
            }
            this.groupCallBottomSheetLatch = new CountDownLatch(1);
            CallProxy.getInstance(this.currentAccount).createGroupVoiceChat(tLRPC$TL_phone_createGroupCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda85
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
                    this.f$0.lambda$startGroupCall$20(tLObject, tLRPC$TL_error);
                }
            });
            this.createGroupCall = false;
            return;
        }
        if (str == null) {
            if (this.groupCall == null) {
                ChatObject.Call groupCall = MessagesController.getInstance(this.currentAccount).getGroupCall(this.chat.id, false);
                this.groupCall = groupCall;
                if (groupCall != null) {
                    groupCall.setSelfPeer(this.groupCallPeer);
                }
            }
            configureDeviceForCall();
            showNotification();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda62
                @Override // java.lang.Runnable
                public final void run() {
                    VoIPService.lambda$startGroupCall$21();
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
            FileLog.d("initital source = " + i);
        }
        TLRPC$TL_phone_joinGroupCall tLRPC$TL_phone_joinGroupCall = new TLRPC$TL_phone_joinGroupCall();
        tLRPC$TL_phone_joinGroupCall.muted = true;
        int i3 = this.videoState[0];
        tLRPC$TL_phone_joinGroupCall.call = this.groupCall.getInputGroupCall();
        TLRPC$TL_dataJSON tLRPC$TL_dataJSON = new TLRPC$TL_dataJSON();
        tLRPC$TL_phone_joinGroupCall.params = tLRPC$TL_dataJSON;
        tLRPC$TL_dataJSON.data = convertJson(str);
        tLRPC$TL_phone_joinGroupCall.chatId = this.chat.id;
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
        CallProxy.getInstance(this.currentAccount).joinGroupVoiceChatRequest(tLRPC$TL_phone_joinGroupCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda90
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startGroupCall$26(i, z, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCall$20(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
        if (tLObject != null) {
            try {
                this.groupCallBottomSheetLatch.await(800L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                FileLog.e(e);
            }
            TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            int i = 0;
            while (true) {
                if (i >= tLRPC$Updates.updates.size()) {
                    break;
                }
                TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i);
                if (tLRPC$Update instanceof TLRPC$TL_updateGroupCall) {
                    final TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall = (TLRPC$TL_updateGroupCall) tLRPC$Update;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda55
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$startGroupCall$18(tLRPC$TL_updateGroupCall);
                        }
                    });
                    break;
                }
                i++;
            }
            MessagesController.getInstance(this.currentAccount).processUpdates(tLRPC$Updates, false);
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda51
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startGroupCall$19(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCall$18(TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall) {
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
    public /* synthetic */ void lambda$startGroupCall$19(TLRPC$TL_error tLRPC$TL_error) {
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.needShowAlert, 6, tLRPC$TL_error.text);
        hangUp(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startGroupCall$21() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCall$22(int i) {
        this.mySource[0] = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCall$26(final int i, final boolean z, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startGroupCall$22(i);
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
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda54
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$startGroupCall$23(tLRPC$TL_groupCallParticipant);
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda57
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startGroupCall$24(z);
                }
            });
            startGroupCheckShortpoll();
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda50
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startGroupCall$25(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCall$23(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant) {
        this.mySource[0] = tLRPC$TL_groupCallParticipant.source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCall$24(boolean z) {
        this.groupCall.loadMembers(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCall$25(TLRPC$TL_error tLRPC$TL_error) {
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

    private void startScreenCapture(final int i, String str) {
        if (getSharedInstance() == null || this.groupCall == null) {
            return;
        }
        this.mySource[1] = 0;
        TLRPC$TL_phone_joinGroupCallPresentation tLRPC$TL_phone_joinGroupCallPresentation = new TLRPC$TL_phone_joinGroupCallPresentation();
        tLRPC$TL_phone_joinGroupCallPresentation.call = this.groupCall.getInputGroupCall();
        TLRPC$TL_dataJSON tLRPC$TL_dataJSON = new TLRPC$TL_dataJSON();
        tLRPC$TL_phone_joinGroupCallPresentation.params = tLRPC$TL_dataJSON;
        tLRPC$TL_dataJSON.data = str;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_joinGroupCallPresentation, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda88
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startScreenCapture$30(i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startScreenCapture$27(int i) {
        this.mySource[1] = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startScreenCapture$30(final int i, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startScreenCapture$27(i);
                }
            });
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda56
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startScreenCapture$28(tLRPC$Updates);
                }
            });
            MessagesController.getInstance(this.currentAccount).processUpdates(tLRPC$Updates, false);
            startGroupCheckShortpoll();
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startScreenCapture$29(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startScreenCapture$28(TLRPC$Updates tLRPC$Updates) {
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
    public /* synthetic */ void lambda$startScreenCapture$29(TLRPC$TL_error tLRPC$TL_error) {
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
        ChatObject.Call call;
        TLRPC$GroupCall tLRPC$GroupCall;
        if (this.shortPollRunnable != null || sharedInstance == null || (call = this.groupCall) == null) {
            return;
        }
        int[] iArr = this.mySource;
        if (iArr[0] == 0 && iArr[1] == 0 && ((tLRPC$GroupCall = call.call) == null || !tLRPC$GroupCall.rtmp_stream)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startGroupCheckShortpoll$33();
            }
        };
        this.shortPollRunnable = runnable;
        AndroidUtilities.runOnUIThread(runnable, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCheckShortpoll$33() {
        ChatObject.Call call;
        TLRPC$GroupCall tLRPC$GroupCall;
        if (this.shortPollRunnable == null || sharedInstance == null || (call = this.groupCall) == null) {
            return;
        }
        int[] iArr = this.mySource;
        int i = 0;
        if (iArr[0] == 0 && iArr[1] == 0 && ((tLRPC$GroupCall = call.call) == null || !tLRPC$GroupCall.rtmp_stream)) {
            return;
        }
        final TLRPC$TL_phone_checkGroupCall tLRPC$TL_phone_checkGroupCall = new TLRPC$TL_phone_checkGroupCall();
        tLRPC$TL_phone_checkGroupCall.call = this.groupCall.getInputGroupCall();
        while (true) {
            int[] iArr2 = this.mySource;
            if (i < iArr2.length) {
                if (iArr2[i] != 0) {
                    tLRPC$TL_phone_checkGroupCall.sources.add(Integer.valueOf(iArr2[i]));
                }
                i++;
            } else {
                this.checkRequestId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_checkGroupCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda91
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$startGroupCheckShortpoll$32(tLRPC$TL_phone_checkGroupCall, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCheckShortpoll$32(final TLRPC$TL_phone_checkGroupCall tLRPC$TL_phone_checkGroupCall, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startGroupCheckShortpoll$31(tLObject, tLRPC$TL_phone_checkGroupCall, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGroupCheckShortpoll$31(TLObject tLObject, TLRPC$TL_phone_checkGroupCall tLRPC$TL_phone_checkGroupCall, TLRPC$TL_error tLRPC$TL_error) {
        boolean z;
        boolean z2;
        TLRPC$GroupCall tLRPC$GroupCall;
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
        if (iArr4[1] == 0 && iArr4[0] == 0 && ((tLRPC$GroupCall = this.groupCall.call) == null || !tLRPC$GroupCall.rtmp_stream)) {
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

        public RequestedParticipant(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, int i) {
            this.participant = tLRPC$TL_groupCallParticipant;
            this.audioSsrc = i;
        }
    }

    private void broadcastUnknownParticipants(long j, int[] iArr) {
        TLRPC$TL_dataJSON tLRPC$TL_dataJSON;
        JSONArray jSONArrayOptJSONArray;
        if (this.groupCall == null || this.tgVoip[0] == null || (tLRPC$TL_dataJSON = this.myParams) == null || TextUtils.isEmpty(tLRPC$TL_dataJSON.data) || this.myParams == null) {
            return;
        }
        int[] iArr2 = null;
        try {
            jSONArrayOptJSONArray = new JSONObject(this.myParams.data).optJSONArray("ssrcs");
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        iArr2 = new int[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            iArr2[i] = jSONArrayOptJSONArray.optInt(i);
        }
        if (iArr2 == null || iArr2.length <= 0) {
            return;
        }
        this.tgVoip[0].onMediaDescriptionAvailable(j, iArr2);
    }

    private void createGroupInstance(final int i, boolean z) {
        boolean z2;
        String logFilePath;
        if (z) {
            this.mySource[i] = 0;
            if (i == 0) {
                this.switchingAccount = z;
            }
        }
        cancelGroupCheckShortPoll();
        if (i == 0) {
            this.wasConnected = false;
        } else if (!this.wasConnected) {
            this.reconnectScreenCapture = true;
            return;
        }
        if (this.tgVoip[i] == null) {
            if (BuildVars.DEBUG_VERSION) {
                logFilePath = VoIPHelper.getLogFilePath("voip_" + i + "_" + this.groupCall.call.id);
            } else {
                logFilePath = VoIPHelper.getLogFilePath(this.groupCall.call.id, false);
            }
            this.tgVoip[i] = NativeInstance.makeGroup(logFilePath, this.captureDevice[i], i == 1, i == 0 && SharedConfig.noiseSupression, new NativeInstance.PayloadCallback() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda71
                @Override // org.rbmain.messenger.voip.NativeInstance.PayloadCallback
                public final void run(int i2, String str) {
                    this.f$0.lambda$createGroupInstance$34(i, i2, str);
                }
            }, new NativeInstance.AudioLevelsCallback() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda70
                @Override // org.rbmain.messenger.voip.NativeInstance.AudioLevelsCallback
                public final void run(int[] iArr, float[] fArr, boolean[] zArr) {
                    this.f$0.lambda$createGroupInstance$36(i, iArr, fArr, zArr);
                }
            }, new NativeInstance.VideoSourcesCallback() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda75
                @Override // org.rbmain.messenger.voip.NativeInstance.VideoSourcesCallback
                public final void run(long j, int[] iArr) {
                    this.f$0.lambda$createGroupInstance$38(i, j, iArr);
                }
            }, new NativeInstance.RequestBroadcastPartCallback() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda72
                @Override // org.rbmain.messenger.voip.NativeInstance.RequestBroadcastPartCallback
                public final void run(long j, long j2, int i2, int i3) {
                    this.f$0.lambda$createGroupInstance$43(i, j, j2, i2, i3);
                }
            }, new NativeInstance.RequestBroadcastPartCallback() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda73
                @Override // org.rbmain.messenger.voip.NativeInstance.RequestBroadcastPartCallback
                public final void run(long j, long j2, int i2, int i3) {
                    this.f$0.lambda$createGroupInstance$45(i, j, j2, i2, i3);
                }
            }, new NativeInstance.RequestCurrentTimeCallback() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda74
                @Override // org.rbmain.messenger.voip.NativeInstance.RequestCurrentTimeCallback
                public final void run(long j) {
                    this.f$0.lambda$createGroupInstance$47(i, j);
                }
            });
            this.tgVoip[i].setOnStateUpdatedListener(new Instance.OnStateUpdatedListener() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda68
                @Override // org.rbmain.messenger.voip.Instance.OnStateUpdatedListener
                public final void onStateUpdated(int i2, boolean z3) {
                    this.f$0.lambda$createGroupInstance$48(i, i2, z3);
                }
            });
            z2 = true;
        } else {
            z2 = false;
        }
        this.tgVoip[i].resetGroupInstance(!z2, false);
        if (this.captureDevice[i] != 0) {
            this.destroyCaptureDevice[i] = false;
        }
        if (i == 0) {
            dispatchStateChanged(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$34(int i, int i2, String str) {
        if (i == 0) {
            startGroupCall(i2, str, true);
        } else {
            startScreenCapture(i2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$36(int i, int[] iArr, float[] fArr, boolean[] zArr) {
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
                    tLRPC$TL_messages_setTyping.call = this.groupCall.getInputGroupCall();
                    CallProxy.getInstance(this.currentAccount).sendGroupVoiceChatActivity(tLRPC$TL_messages_setTyping, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda82
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$createGroupInstance$35(tLObject, tLRPC$TL_error);
                        }
                    });
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
    public /* synthetic */ void lambda$createGroupInstance$35(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null || tLRPC$TL_error.code != 100) {
            return;
        }
        detectVoiceChatNotExist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$38(int i, final long j, final int[] iArr) {
        ChatObject.Call call;
        if (sharedInstance == null || (call = this.groupCall) == null || i != 0) {
            return;
        }
        call.processUnknownVideoParticipants(iArr, new ChatObject.Call.OnParticipantsLoad() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda63
            @Override // org.rbmain.messenger.ChatObject.Call.OnParticipantsLoad
            public final void onLoad(ArrayList arrayList) {
                this.f$0.lambda$createGroupInstance$37(j, iArr, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$37(long j, int[] iArr, ArrayList arrayList) {
        if (sharedInstance == null || this.groupCall == null) {
            return;
        }
        broadcastUnknownParticipants(j, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$43(final int i, final long j, long j2, final int i2, final int i3) {
        StringBuilder sb;
        String string;
        if (i != 0) {
            return;
        }
        TLRPC$TL_upload_getFile tLRPC$TL_upload_getFile = new TLRPC$TL_upload_getFile();
        tLRPC$TL_upload_getFile.limit = MessagesController.UPDATE_MASK_REORDER;
        TLRPC$TL_inputGroupCallStream tLRPC$TL_inputGroupCallStream = new TLRPC$TL_inputGroupCallStream();
        tLRPC$TL_inputGroupCallStream.call = this.groupCall.getInputGroupCall();
        tLRPC$TL_inputGroupCallStream.time_ms = j;
        if (j2 == 500) {
            tLRPC$TL_inputGroupCallStream.scale = 1;
        }
        if (i2 != 0) {
            tLRPC$TL_inputGroupCallStream.flags |= 1;
        }
        tLRPC$TL_upload_getFile.location = tLRPC$TL_inputGroupCallStream;
        if (i2 == 0) {
            sb = new StringBuilder();
            sb.append(BuildConfig.FLAVOR);
            sb.append(j);
            string = sb.toString();
        } else {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append("_");
            sb.append(j);
            sb.append("_");
            sb.append(i3);
            string = sb.toString();
        }
        final String str = string;
        final int iSendRequest = AccountInstance.getInstance(this.currentAccount).getConnectionsManager().sendRequest(tLRPC$TL_upload_getFile, new RequestDelegateTimestamp(this, str, i, j, i2, i3) { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda97
        }, 2, 2, this.groupCall.call.stream_dc_id);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createGroupInstance$42(str, iSendRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$39(String str) {
        this.currentStreamRequestTimestamp.remove(str);
    }

    private /* synthetic */ void lambda$createGroupInstance$41(final String str, final int i, long j, int i2, int i3, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error, long j2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createGroupInstance$39(str);
            }
        });
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[i] == null) {
            return;
        }
        if (tLObject != null) {
            NativeInstance nativeInstance = nativeInstanceArr[i];
            NativeByteBuffer nativeByteBuffer = ((TLRPC$TL_upload_file) tLObject).bytes;
            nativeInstance.onStreamPartAvailable(j, nativeByteBuffer.buffer, nativeByteBuffer.limit(), j2, i2, i3);
        } else if ("GROUPCALL_JOIN_MISSING".equals(tLRPC$TL_error.text)) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createGroupInstance$40(i);
                }
            });
        } else {
            this.tgVoip[i].onStreamPartAvailable(j, null, ("TIME_TOO_BIG".equals(tLRPC$TL_error.text) || tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) ? 0 : -1, j2, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$40(int i) {
        createGroupInstance(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$42(String str, int i) {
        this.currentStreamRequestTimestamp.put(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$45(int i, final long j, long j2, final int i2, final int i3) {
        if (i != 0) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createGroupInstance$44(i2, j, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$44(int i, long j, int i2) {
        String str;
        if (i == 0) {
            str = BuildConfig.FLAVOR + j;
        } else {
            str = i + "_" + j + "_" + i2;
        }
        Integer num = this.currentStreamRequestTimestamp.get(str);
        if (num != null) {
            AccountInstance.getInstance(this.currentAccount).getConnectionsManager().cancelRequest(num.intValue(), true);
            this.currentStreamRequestTimestamp.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupInstance$47(final int i, final long j) {
        TLRPC$GroupCall tLRPC$GroupCall;
        ChatObject.Call call = this.groupCall;
        if (call != null && (tLRPC$GroupCall = call.call) != null && tLRPC$GroupCall.rtmp_stream) {
            TLRPC$TL_phone_getGroupCallStreamChannels tLRPC$TL_phone_getGroupCallStreamChannels = new TLRPC$TL_phone_getGroupCallStreamChannels();
            tLRPC$TL_phone_getGroupCallStreamChannels.call = this.groupCall.getInputGroupCall();
            ChatObject.Call call2 = this.groupCall;
            if (call2 == null || call2.call == null || this.tgVoip[i] == null) {
                NativeInstance[] nativeInstanceArr = this.tgVoip;
                if (nativeInstanceArr[i] != null) {
                    nativeInstanceArr[i].onRequestTimeComplete(j, 0L);
                    return;
                }
                return;
            }
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_getGroupCallStreamChannels, new RequestDelegateTimestamp(this, i, j) { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda96
            }, 2, 2, this.groupCall.call.stream_dc_id);
            return;
        }
        NativeInstance[] nativeInstanceArr2 = this.tgVoip;
        if (nativeInstanceArr2[i] != null) {
            nativeInstanceArr2[i].onRequestTimeComplete(j, ConnectionsManager.getInstance(this.currentAccount).getCurrentTimeMillis());
        }
    }

    private /* synthetic */ void lambda$createGroupInstance$46(int i, long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error, long j2) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_phone_groupCallStreamChannels tLRPC$TL_phone_groupCallStreamChannels = (TLRPC$TL_phone_groupCallStreamChannels) tLObject;
            j = tLRPC$TL_phone_groupCallStreamChannels.channels.isEmpty() ? 0L : tLRPC$TL_phone_groupCallStreamChannels.channels.get(0).last_timestamp_ms;
            ChatObject.Call call = this.groupCall;
            if (!call.loadedRtmpStreamParticipant) {
                call.createRtmpStreamParticipant(tLRPC$TL_phone_groupCallStreamChannels.channels);
                this.groupCall.loadedRtmpStreamParticipant = true;
            }
        }
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        if (nativeInstanceArr[i] != null) {
            nativeInstanceArr[i].onRequestTimeComplete(j, j);
        }
    }

    private String convertJson(String str) {
        if (str == null) {
            return null;
        }
        GroupCallSdp.SdpOffer sdpOffer = (GroupCallSdp.SdpOffer) ApplicationLoader.getGson().fromJson(str, GroupCallSdp.SdpOffer.class);
        GroupCallSdp.Fingerprint fingerprint = sdpOffer.fingerprints.get(0);
        return "v=0\no=- " + (new Random().nextLong() + BuildConfig.FLAVOR) + " 2 IN IP4 127.0.0.1\ns=-\nt=0 0\na=group:BUNDLE 0\na=msid-semantic: WMS audio0\nm=audio 9 UDP/TLS/RTP/SAVPF 111\nc=IN IP4 0.0.0.0\na=rtcp:9 IN IP4 0.0.0.0\na=ice-ufrag:" + sdpOffer.ufrag + "\na=ice-pwd:" + sdpOffer.pwd + "\na=ice-options:trickle\na=fingerprint:" + fingerprint.hash + " " + fingerprint.fingerprint + "\na=setup:" + fingerprint.setup + "\na=mid:0\na=sendrecv\na=msid:audio0 audio0\na=rtcp-mux\na=rtpmap:111 opus/48000/2\na=rtcp-fb:111 transport-cc\na=fmtp:111 minptime=10;useinbandfec=1\na=rtpmap:110 telephone-event/48000\na=ssrc:" + sdpOffer.ssrc + "\na=ssrc:" + sdpOffer.ssrc + " msid:audio0 audio0\na=ssrc:" + sdpOffer.ssrc + " mslabel:audio0\na=ssrc:" + sdpOffer.ssrc + " label:audio0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateConnectionState, reason: merged with bridge method [inline-methods] */
    public void lambda$createGroupInstance$48(final int i, int i2, boolean z) {
        if (i != 0) {
            return;
        }
        dispatchStateChanged((i2 == 1 || this.switchingStream) ? 3 : 5);
        if (this.switchingStream && (i2 == 0 || (i2 == 1 && z))) {
            Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda39
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateConnectionState$49(i);
                }
            };
            this.switchingStreamTimeoutRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 3000L);
        }
        if (i2 == 0) {
            startGroupCheckShortpoll();
            if (!this.playedConnectedSound || this.spPlayId != 0 || this.switchingStream || this.switchingAccount) {
                return;
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateConnectionState$50();
                }
            });
            return;
        }
        cancelGroupCheckShortPoll();
        if (!z) {
            this.switchingStream = false;
            this.switchingAccount = false;
        }
        Runnable runnable2 = this.switchingStreamTimeoutRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.switchingStreamTimeoutRunnable = null;
        }
        if (this.playedConnectedSound) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateConnectionState$51();
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
    public /* synthetic */ void lambda$updateConnectionState$49(int i) {
        if (this.switchingStreamTimeoutRunnable == null) {
            return;
        }
        this.switchingStream = false;
        lambda$createGroupInstance$48(i, 0, true);
        this.switchingStreamTimeoutRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateConnectionState$50() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
        }
        this.spPlayId = this.soundPool.play(this.spVoiceChatConnecting, 1.0f, 1.0f, 0, -1, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateConnectionState$51() {
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

    public void setParticipantVolume(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, int i) {
        int i2;
        NativeInstance nativeInstance = this.tgVoip[0];
        int i3 = tLRPC$TL_groupCallParticipant.source;
        double d = i;
        Double.isNaN(d);
        double d2 = d / 10000.0d;
        nativeInstance.setVolume(i3, d2);
        TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo = tLRPC$TL_groupCallParticipant.presentation;
        if (tLRPC$TL_groupCallParticipantVideo == null || (i2 = tLRPC$TL_groupCallParticipantVideo.audio_source) == 0) {
            return;
        }
        this.tgVoip[0].setVolume(i2, d2);
    }

    public void setParticipantVolume(int i, int i2) {
        NativeInstance nativeInstance = this.tgVoip[0];
        double d = i2;
        Double.isNaN(d);
        nativeInstance.setVolume(i, d / 10000.0d);
    }

    public boolean isSwitchingStream() {
        return this.switchingStream;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02eb A[Catch: Exception -> 0x03c1, TryCatch #4 {Exception -> 0x03c1, blocks: (B:5:0x0010, B:7:0x0014, B:8:0x002a, B:10:0x0036, B:12:0x0041, B:13:0x0068, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x008e, B:26:0x009f, B:28:0x00a5, B:29:0x00a9, B:39:0x00c8, B:41:0x00df, B:43:0x00e7, B:45:0x00fc, B:51:0x0108, B:56:0x0112, B:58:0x0116, B:60:0x0139, B:64:0x017b, B:84:0x0258, B:86:0x0261, B:88:0x026c, B:90:0x0274, B:92:0x0287, B:94:0x028d, B:96:0x02ac, B:100:0x02cd, B:103:0x02da, B:104:0x02e7, B:106:0x02eb, B:108:0x02ef, B:110:0x02f5, B:112:0x02fd, B:116:0x030b, B:117:0x0317, B:118:0x031c, B:120:0x0392, B:121:0x0395, B:123:0x039d, B:124:0x03ad, B:59:0x0131, B:11:0x003c, B:22:0x0092), top: B:143:0x0010, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0392 A[Catch: Exception -> 0x03c1, TryCatch #4 {Exception -> 0x03c1, blocks: (B:5:0x0010, B:7:0x0014, B:8:0x002a, B:10:0x0036, B:12:0x0041, B:13:0x0068, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x008e, B:26:0x009f, B:28:0x00a5, B:29:0x00a9, B:39:0x00c8, B:41:0x00df, B:43:0x00e7, B:45:0x00fc, B:51:0x0108, B:56:0x0112, B:58:0x0116, B:60:0x0139, B:64:0x017b, B:84:0x0258, B:86:0x0261, B:88:0x026c, B:90:0x0274, B:92:0x0287, B:94:0x028d, B:96:0x02ac, B:100:0x02cd, B:103:0x02da, B:104:0x02e7, B:106:0x02eb, B:108:0x02ef, B:110:0x02f5, B:112:0x02fd, B:116:0x030b, B:117:0x0317, B:118:0x031c, B:120:0x0392, B:121:0x0395, B:123:0x039d, B:124:0x03ad, B:59:0x0131, B:11:0x003c, B:22:0x0092), top: B:143:0x0010, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0116 A[Catch: Exception -> 0x03c1, TryCatch #4 {Exception -> 0x03c1, blocks: (B:5:0x0010, B:7:0x0014, B:8:0x002a, B:10:0x0036, B:12:0x0041, B:13:0x0068, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x008e, B:26:0x009f, B:28:0x00a5, B:29:0x00a9, B:39:0x00c8, B:41:0x00df, B:43:0x00e7, B:45:0x00fc, B:51:0x0108, B:56:0x0112, B:58:0x0116, B:60:0x0139, B:64:0x017b, B:84:0x0258, B:86:0x0261, B:88:0x026c, B:90:0x0274, B:92:0x0287, B:94:0x028d, B:96:0x02ac, B:100:0x02cd, B:103:0x02da, B:104:0x02e7, B:106:0x02eb, B:108:0x02ef, B:110:0x02f5, B:112:0x02fd, B:116:0x030b, B:117:0x0317, B:118:0x031c, B:120:0x0392, B:121:0x0395, B:123:0x039d, B:124:0x03ad, B:59:0x0131, B:11:0x003c, B:22:0x0092), top: B:143:0x0010, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0131 A[Catch: Exception -> 0x03c1, TryCatch #4 {Exception -> 0x03c1, blocks: (B:5:0x0010, B:7:0x0014, B:8:0x002a, B:10:0x0036, B:12:0x0041, B:13:0x0068, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x008e, B:26:0x009f, B:28:0x00a5, B:29:0x00a9, B:39:0x00c8, B:41:0x00df, B:43:0x00e7, B:45:0x00fc, B:51:0x0108, B:56:0x0112, B:58:0x0116, B:60:0x0139, B:64:0x017b, B:84:0x0258, B:86:0x0261, B:88:0x026c, B:90:0x0274, B:92:0x0287, B:94:0x028d, B:96:0x02ac, B:100:0x02cd, B:103:0x02da, B:104:0x02e7, B:106:0x02eb, B:108:0x02ef, B:110:0x02f5, B:112:0x02fd, B:116:0x030b, B:117:0x0317, B:118:0x031c, B:120:0x0392, B:121:0x0395, B:123:0x039d, B:124:0x03ad, B:59:0x0131, B:11:0x003c, B:22:0x0092), top: B:143:0x0010, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x020e A[Catch: Exception -> 0x03bd, TryCatch #2 {Exception -> 0x03bd, blocks: (B:67:0x018d, B:69:0x01e1, B:70:0x01ed, B:71:0x01ff, B:73:0x020e, B:74:0x0217, B:76:0x021d, B:80:0x0232, B:82:0x0254), top: B:139:0x018d }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0254 A[Catch: Exception -> 0x03bd, TRY_LEAVE, TryCatch #2 {Exception -> 0x03bd, blocks: (B:67:0x018d, B:69:0x01e1, B:70:0x01ed, B:71:0x01ff, B:73:0x020e, B:74:0x0217, B:76:0x021d, B:80:0x0232, B:82:0x0254), top: B:139:0x018d }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initiateActualEncryptedCall() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 975
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.voip.VoIPService.initiateActualEncryptedCall():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiateActualEncryptedCall$52() {
        Toast.makeText(this, "This call uses TCP which will degrade its quality.", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiateActualEncryptedCall$53(int[] iArr, float[] fArr, boolean[] zArr) {
        if (sharedInstance == null || this.privateCall == null) {
            return;
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.webRtcMicAmplitudeEvent, Float.valueOf(fArr[0]));
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.webRtcSpeakerAmplitudeEvent, Float.valueOf(fArr[1]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiateActualEncryptedCall$55(final int i, final int i2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initiateActualEncryptedCall$54(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiateActualEncryptedCall$54(int i, int i2) {
        this.remoteAudioState = i;
        this.remoteVideoState = i2;
        checkIsNear();
        for (int i3 = 0; i3 < this.stateListeners.size(); i3++) {
            this.stateListeners.get(i3).onMediaStateUpdated(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playConnectedSound$56() {
        this.soundPool.play(this.spVoiceChatStartId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void playConnectedSound() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playConnectedSound$56();
            }
        });
        this.playedConnectedSound = true;
    }

    private void startConnectingSound() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startConnectingSound$57();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startConnectingSound$57() {
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

    /* renamed from: org.rbmain.messenger.voip.VoIPService$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoIPService.sharedInstance == null) {
                return;
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
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

    public void onSignalingData(byte[] bArr) {
        if (this.privateCall == null) {
            return;
        }
        TLRPC$TL_phone_sendSignalingData tLRPC$TL_phone_sendSignalingData = new TLRPC$TL_phone_sendSignalingData();
        TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
        tLRPC$TL_phone_sendSignalingData.peer = tLRPC$TL_inputPhoneCall;
        TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
        long j = tLRPC$PhoneCall.access_hash;
        tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
        tLRPC$TL_phone_sendSignalingData.data = bArr;
        CallProxy.getInstance(this.currentAccount).onSignalingData(tLRPC$TL_phone_sendSignalingData, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda94
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                VoIPService.lambda$onSignalingData$58(tLObject, tLRPC$TL_error);
            }
        });
    }

    public boolean isVideoAvailable() {
        return this.isVideoAvailable;
    }

    void onMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            return;
        }
        if ((keyEvent.getKeyCode() == 79 || keyEvent.getKeyCode() == 127 || keyEvent.getKeyCode() == 85) && keyEvent.getAction() == 1) {
            if (this.currentState == 15) {
                acceptIncomingCall();
            } else {
                setMicMute(!isMicMute(), false, true);
            }
        }
    }

    public byte[] getGA() {
        if (this.g_a == null) {
            this.g_a = new byte[0];
        }
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

    public boolean hasEarpiece() {
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

    protected void setSwitchingCamera(boolean z, boolean z2) {
        this.switchingCamera = z;
        if (z) {
            return;
        }
        this.isFrontFaceCamera = z2;
        for (int i = 0; i < this.stateListeners.size(); i++) {
            this.stateListeners.get(i).onCameraSwitch(this.isFrontFaceCamera);
        }
    }

    protected void onCameraFirstFrameAvailable() {
        for (int i = 0; i < this.stateListeners.size(); i++) {
            this.stateListeners.get(i).onCameraFirstFrameAvailable();
        }
    }

    public void registerStateListener(StateListener stateListener) {
        if (this.stateListeners.contains(stateListener)) {
            return;
        }
        this.stateListeners.add(stateListener);
        int i = this.currentState;
        if (i != 0) {
            stateListener.onStateChanged(i);
        }
        int i2 = this.signalBarCount;
        if (i2 != 0) {
            stateListener.onSignalBarsCountChanged(i2);
        }
    }

    public void unregisterStateListener(StateListener stateListener) {
        this.stateListeners.remove(stateListener);
    }

    public void editCallMember(TLObject tLObject, Boolean bool, Boolean bool2, Integer num, Boolean bool3, final Runnable runnable) {
        TLRPC$InputPeer tLRPC$InputPeer;
        if (tLObject == null || this.groupCall == null) {
            return;
        }
        TLRPC$TL_phone_editGroupCallParticipant tLRPC$TL_phone_editGroupCallParticipant = new TLRPC$TL_phone_editGroupCallParticipant();
        tLRPC$TL_phone_editGroupCallParticipant.call = this.groupCall.getInputGroupCall();
        if (tLObject instanceof TLRPC$User) {
            TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
            if (UserObject.isUserSelf(tLRPC$User) && (tLRPC$InputPeer = this.groupCallPeer) != null) {
                tLRPC$TL_phone_editGroupCallParticipant.participant = tLRPC$InputPeer;
            } else {
                tLRPC$TL_phone_editGroupCallParticipant.participant = MessagesController.getInputPeer(tLRPC$User);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("edit group call part id = " + tLRPC$TL_phone_editGroupCallParticipant.participant.user_id + " access_hash = " + tLRPC$TL_phone_editGroupCallParticipant.participant.user_id);
                }
            }
        } else if (tLObject instanceof TLRPC$Chat) {
            tLRPC$TL_phone_editGroupCallParticipant.participant = MessagesController.getInputPeer((TLRPC$Chat) tLObject);
            if (BuildVars.LOGS_ENABLED) {
                StringBuilder sb = new StringBuilder();
                sb.append("edit group call part id = ");
                TLRPC$InputPeer tLRPC$InputPeer2 = tLRPC$TL_phone_editGroupCallParticipant.participant;
                int i = tLRPC$InputPeer2.chat_id;
                if (i == 0) {
                    i = tLRPC$InputPeer2.channel_id;
                }
                sb.append(i);
                sb.append(" access_hash = ");
                sb.append(tLRPC$TL_phone_editGroupCallParticipant.participant.access_hash);
                FileLog.d(sb.toString());
            }
        }
        tLRPC$TL_phone_editGroupCallParticipant.chat_id = this.groupCall.chatId;
        if (bool != null) {
            tLRPC$TL_phone_editGroupCallParticipant.muted = bool.booleanValue();
            tLRPC$TL_phone_editGroupCallParticipant.flags |= 1;
        }
        if (num != null) {
            tLRPC$TL_phone_editGroupCallParticipant.volume = num.intValue();
            tLRPC$TL_phone_editGroupCallParticipant.flags |= 2;
        }
        if (bool3 != null) {
            tLRPC$TL_phone_editGroupCallParticipant.raise_hand = bool3.booleanValue();
            tLRPC$TL_phone_editGroupCallParticipant.flags |= 4;
        }
        if (bool2 != null) {
            bool2.booleanValue();
            tLRPC$TL_phone_editGroupCallParticipant.flags |= 8;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("edit group call flags = " + tLRPC$TL_phone_editGroupCallParticipant.flags);
        }
        final int i2 = this.currentAccount;
        AccountInstance.getInstance(i2).getCallProxy().setGroupVoiceChatState(tLRPC$TL_phone_editGroupCallParticipant, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda89
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$editCallMember$59(i2, runnable, tLObject2, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$editCallMember$59(int i, Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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

    public void toggleSpeakerphoneOrShowRouteSheet(Context context, boolean z) {
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
            BottomSheet.Builder items = title.setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$toggleSpeakerphoneOrShowRouteSheet$60(dialogInterface, i2);
                }
            });
            BottomSheet bottomSheetCreate = items.create();
            if (z) {
                if (Build.VERSION.SDK_INT >= 26) {
                    bottomSheetCreate.getWindow().setType(2038);
                } else {
                    bottomSheetCreate.getWindow().setType(2003);
                }
            }
            items.show();
            return;
        }
        boolean z2 = USE_CONNECTION_SERVICE;
        if (z2 && (callConnection = this.systemCallConnection) != null && callConnection.getCallAudioState() != null) {
            if (hasEarpiece()) {
                CallConnection callConnection2 = this.systemCallConnection;
                callConnection2.setAudioRoute(callConnection2.getCallAudioState().getRoute() != 8 ? 8 : 5);
            } else {
                CallConnection callConnection3 = this.systemCallConnection;
                callConnection3.setAudioRoute(callConnection3.getCallAudioState().getRoute() == 2 ? 5 : 2);
            }
        } else if (this.audioConfigured && !z2) {
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            VoipAudioManager voipAudioManager = VoipAudioManager.get();
            if (hasEarpiece()) {
                voipAudioManager.setSpeakerphoneOn(!voipAudioManager.isSpeakerphoneOn());
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
    public /* synthetic */ void lambda$toggleSpeakerphoneOrShowRouteSheet$60(DialogInterface dialogInterface, int i) {
        if (getSharedInstance() == null) {
            return;
        }
        setAudioOutput(i);
    }

    public void setAudioOutput(int i) {
        CallConnection callConnection;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("setAudioOutput " + i);
        }
        AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        VoipAudioManager voipAudioManager = VoipAudioManager.get();
        boolean z = USE_CONNECTION_SERVICE;
        if (!z || (callConnection = this.systemCallConnection) == null) {
            if (this.audioConfigured && !z) {
                if (i == 0) {
                    this.needSwitchToBluetoothAfterScoActivates = false;
                    if (this.bluetoothScoActive || this.bluetoothScoConnecting) {
                        audioManager.stopBluetoothSco();
                        this.bluetoothScoActive = false;
                        this.bluetoothScoConnecting = false;
                    }
                    audioManager.setBluetoothScoOn(false);
                    voipAudioManager.setSpeakerphoneOn(true);
                    this.audioRouteToSet = 1;
                } else if (i == 1) {
                    this.needSwitchToBluetoothAfterScoActivates = false;
                    if (this.bluetoothScoActive || this.bluetoothScoConnecting) {
                        audioManager.stopBluetoothSco();
                        this.bluetoothScoActive = false;
                        this.bluetoothScoConnecting = false;
                    }
                    voipAudioManager.setSpeakerphoneOn(false);
                    audioManager.setBluetoothScoOn(false);
                    this.audioRouteToSet = 0;
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
                        voipAudioManager.setSpeakerphoneOn(false);
                    }
                    this.audioRouteToSet = 2;
                }
                updateOutputGainControlState();
            } else if (i == 0) {
                this.audioRouteToSet = 1;
                this.speakerphoneStateToSet = true;
            } else if (i == 1) {
                this.audioRouteToSet = 0;
                this.speakerphoneStateToSet = false;
            } else if (i == 2) {
                this.audioRouteToSet = 2;
                this.speakerphoneStateToSet = false;
            }
        } else if (i == 0) {
            callConnection.setAudioRoute(8);
        } else if (i == 1) {
            callConnection.setAudioRoute(5);
        } else if (i == 2) {
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
            return hasEarpiece() ? VoipAudioManager.get().isSpeakerphoneOn() : ((AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isBluetoothScoOn();
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
            VoipAudioManager voipAudioManager = VoipAudioManager.get();
            if (audioManager.isBluetoothScoOn()) {
                return 2;
            }
            return voipAudioManager.isSpeakerphoneOn() ? 1 : 0;
        }
        return this.audioRouteToSet;
    }

    public String getDebugString() {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        return nativeInstanceArr[0] != null ? nativeInstanceArr[0].getDebugInfo() : BuildConfig.FLAVOR;
    }

    public long getCallDuration() {
        if (this.callStartTime == 0) {
            return 0L;
        }
        return SystemClock.elapsedRealtime() - this.callStartTime;
    }

    public void stopRinging() {
        synchronized (sync) {
            MediaPlayer mediaPlayer = this.ringtonePlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.ringtonePlayer.release();
                this.ringtonePlayer = null;
            }
        }
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
            this.vibrator = null;
        }
    }

    private void showNotification(String str, Bitmap bitmap) {
        int i;
        String str2;
        Intent action = new Intent(this, (Class<?>) LaunchActivity.class).setAction(this.groupCall != null ? "voip_chat" : "voip");
        if (this.groupCall != null) {
            action.putExtra("currentAccount", this.currentAccount);
        }
        Notification.Builder contentIntent = new Notification.Builder(this).setContentText(str).setContentIntent(PendingIntent.getActivity(this, 50, action, ConnectionsManager.FileTypeVideo));
        if (this.groupCall != null) {
            contentIntent.setContentTitle(LocaleController.getString("VoipVoiceChat", R.string.VoipVoiceChat));
            contentIntent.setSmallIcon(isMicMute() ? R.drawable.voicechat_muted : R.drawable.voicechat_active);
        } else {
            contentIntent.setContentTitle(LocaleController.getString("VoipOutgoingCall", R.string.VoipOutgoingCall));
            contentIntent.setSmallIcon(R.drawable.ic_notif_shad);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16) {
            Intent intent = new Intent(this, (Class<?>) VoIPActionsReceiver.class);
            intent.setAction(getPackageName() + ".END_CALL");
            if (this.groupCall != null) {
                if (ChatObject.isChannel(this.chat)) {
                    i = R.string.VoipChannelLeaveAlertTitle;
                    str2 = "VoipChannelLeaveAlertTitle";
                } else {
                    i = R.string.VoipGroupLeaveAlertTitle;
                    str2 = "VoipGroupLeaveAlertTitle";
                }
                contentIntent.addAction(R.drawable.ic_call_end_white_24dp, LocaleController.getString(str2, i), PendingIntent.getBroadcast(this, 0, intent, 167772160));
            } else {
                contentIntent.addAction(R.drawable.ic_call_end_white_24dp, LocaleController.getString("VoipEndCall", R.string.VoipEndCall), PendingIntent.getBroadcast(this, 0, intent, 167772160));
            }
            contentIntent.setPriority(2);
        }
        if (i2 >= 17) {
            contentIntent.setShowWhen(false);
        }
        if (i2 >= 26) {
            contentIntent.setColor(-14143951);
            contentIntent.setColorized(true);
        } else if (i2 >= 21) {
            contentIntent.setColor(-13851168);
        }
        if (i2 >= 26) {
            NotificationsController.checkOtherNotificationsChannel();
            contentIntent.setChannelId(NotificationsController.OTHER_NOTIFICATIONS_CHANNEL);
        }
        if (bitmap != null) {
            contentIntent.setLargeIcon(bitmap);
        }
        try {
            startForeground(ID_ONGOING_CALL_NOTIFICATION, contentIntent.getNotification());
        } catch (Exception e) {
            if (bitmap == null || !(e instanceof IllegalArgumentException)) {
                return;
            }
            showNotification(str, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4 A[Catch: all -> 0x0152, TryCatch #1 {, blocks: (B:12:0x0023, B:14:0x0027, B:16:0x0029, B:18:0x0042, B:23:0x0055, B:25:0x006c, B:28:0x008a, B:36:0x00a8, B:42:0x00dd, B:44:0x00f4, B:49:0x0116, B:51:0x011c, B:56:0x012a, B:61:0x0141, B:62:0x0150, B:54:0x0124, B:45:0x010a, B:30:0x0090, B:32:0x0094, B:34:0x009e, B:35:0x00a3, B:26:0x0082, B:39:0x00d1, B:41:0x00d8, B:19:0x0048, B:21:0x0051), top: B:70:0x0023, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010a A[Catch: all -> 0x0152, TryCatch #1 {, blocks: (B:12:0x0023, B:14:0x0027, B:16:0x0029, B:18:0x0042, B:23:0x0055, B:25:0x006c, B:28:0x008a, B:36:0x00a8, B:42:0x00dd, B:44:0x00f4, B:49:0x0116, B:51:0x011c, B:56:0x012a, B:61:0x0141, B:62:0x0150, B:54:0x0124, B:45:0x010a, B:30:0x0090, B:32:0x0094, B:34:0x009e, B:35:0x00a3, B:26:0x0082, B:39:0x00d1, B:41:0x00d8, B:19:0x0048, B:21:0x0051), top: B:70:0x0023, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void startRingtoneAndVibration(long r12) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.voip.VoIPService.startRingtoneAndVibration(long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRingtoneAndVibration$61(MediaPlayer mediaPlayer) {
        try {
            this.ringtonePlayer.start();
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    @Override // android.app.Service
    public void onDestroy() throws InterruptedException, PendingIntent.CanceledException {
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda60
            @Override // java.lang.Runnable
            public final void run() {
                VoIPService.lambda$onDestroy$62();
            }
        });
        if (this.tgVoip[0] != null) {
            StatsController.getInstance(this.currentAccount).incrementTotalCallsTime(getStatsNetworkType(), ((int) (getCallDuration() / 1000)) % 5);
            onTgVoipPreStop();
            if (this.tgVoip[0].isGroup()) {
                NativeInstance nativeInstance = this.tgVoip[0];
                DispatchQueue dispatchQueue = Utilities.globalQueue;
                nativeInstance.getClass();
                dispatchQueue.postRunnable(new VoIPService$$ExternalSyntheticLambda4(nativeInstance));
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
            dispatchQueue2.postRunnable(new VoIPService$$ExternalSyntheticLambda4(nativeInstance2));
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
            VoipAudioManager voipAudioManager = VoipAudioManager.get();
            if (!USE_CONNECTION_SERVICE) {
                if (this.isBtHeadsetConnected || this.bluetoothScoActive || this.bluetoothScoConnecting) {
                    audioManager.stopBluetoothSco();
                    audioManager.setBluetoothScoOn(false);
                    voipAudioManager.setSpeakerphoneOn(false);
                    this.bluetoothScoActive = false;
                    this.bluetoothScoConnecting = false;
                }
                if (this.onDestroyRunnable == null) {
                    DispatchQueue dispatchQueue3 = Utilities.globalQueue;
                    Runnable runnable3 = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            VoIPService.lambda$onDestroy$63(audioManager);
                        }
                    };
                    setModeRunnable = runnable3;
                    dispatchQueue3.postRunnable(runnable3);
                }
                audioManager.abandonAudioFocus(this);
            }
            try {
                audioManager.unregisterMediaButtonEventReceiver(new ComponentName(this, (Class<?>) VoIPMediaButtonReceiver.class));
            } catch (Exception e) {
                FileLog.e(e);
            }
            AudioDeviceCallback audioDeviceCallback = this.audioDeviceCallback;
            if (audioDeviceCallback != null) {
                audioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
            }
            if (this.hasAudioFocus) {
                audioManager.abandonAudioFocus(this);
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDestroy$64();
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
        AndroidUtilities.cancelRunOnUIThread(this.getSignalingDataRunnable);
        Runnable runnable4 = this.onDestroyRunnable;
        if (runnable4 != null) {
            runnable4.run();
        }
        int i2 = this.currentAccount;
        if (i2 >= 0) {
            ConnectionsManager.getInstance(i2).setAppPaused(true, false);
            if (ChatObject.isChannel(this.chat)) {
                MessagesController.getInstance(this.currentAccount).startShortPoll(this.chat, this.classGuid, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDestroy$62() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didEndCall, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDestroy$63(AudioManager audioManager) {
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
    public /* synthetic */ void lambda$onDestroy$64() {
        SoundPool soundPool = this.soundPool;
        if (soundPool != null) {
            soundPool.release();
        }
    }

    public String getCallID() {
        TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
        if (tLRPC$PhoneCall != null) {
            return tLRPC$PhoneCall.id;
        }
        return null;
    }

    public void hangUp() {
        hangUp(0, null);
    }

    public void hangUp(int i) {
        hangUp(i, null);
    }

    public void hangUp(Runnable runnable) {
        hangUp(0, runnable);
    }

    public void acceptIncomingCall() {
        MessagesController.getInstance(this.currentAccount).ignoreSetOnline = false;
        stopRinging();
        showNotification();
        configureDeviceForCall();
        startConnectingSound();
        dispatchStateChanged(12);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda58
            @Override // java.lang.Runnable
            public final void run() {
                VoIPService.lambda$acceptIncomingCall$65();
            }
        });
        MessagesStorage messagesStorage = MessagesStorage.getInstance(this.currentAccount);
        TLRPC$TL_messages_getDhConfig tLRPC$TL_messages_getDhConfig = new TLRPC$TL_messages_getDhConfig();
        tLRPC$TL_messages_getDhConfig.random_length = 256;
        tLRPC$TL_messages_getDhConfig.version = messagesStorage.getLastSecretVersion();
        CallProxy.getInstance(this.currentAccount).secureCall(tLRPC$TL_messages_getDhConfig, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda77
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$acceptIncomingCall$68(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$acceptIncomingCall$65() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acceptIncomingCall$68(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            if (this.privateCall == null) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("call is null");
                }
                callFailed();
                return;
            }
            TLRPC$TL_phone_acceptCall tLRPC$TL_phone_acceptCall = new TLRPC$TL_phone_acceptCall();
            TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
            tLRPC$TL_phone_acceptCall.peer = tLRPC$TL_inputPhoneCall;
            TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
            tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
            long j = tLRPC$PhoneCall.access_hash;
            TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol = new TLRPC$TL_phoneCallProtocol();
            tLRPC$TL_phone_acceptCall.protocol = tLRPC$TL_phoneCallProtocol;
            tLRPC$TL_phoneCallProtocol.udp_reflector = true;
            tLRPC$TL_phoneCallProtocol.udp_p2p = true;
            tLRPC$TL_phoneCallProtocol.min_layer = 65;
            tLRPC$TL_phoneCallProtocol.max_layer = Instance.getConnectionMaxLayer();
            tLRPC$TL_phone_acceptCall.protocol.library_versions.addAll(Instance.AVAILABLE_VERSIONS);
            CallProxy.getInstance(this.currentAccount).acceptCall(tLRPC$TL_phone_acceptCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda87
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$acceptIncomingCall$67(tLObject2, tLRPC$TL_error2);
                }
            });
            return;
        }
        callFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acceptIncomingCall$67(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$acceptIncomingCall$66(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acceptIncomingCall$66(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) throws IOException {
        if (tLRPC$TL_error == null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.w("accept call ok! " + tLObject);
            }
            TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
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

    public void declineIncomingCall(int i, Runnable runnable) {
        if (this.groupCall != null) {
            stopScreenCapture();
        }
        stopRinging();
        this.callDiscardReason = i;
        int i2 = this.currentState;
        if (i2 == 14) {
            Runnable runnable2 = this.delayedStartOutgoingCall;
            if (runnable2 != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable2);
                callEnded();
                return;
            } else {
                dispatchStateChanged(10);
                this.endCallAfterRequest = true;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda15
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$declineIncomingCall$69();
                    }
                }, 5000L);
                return;
            }
        }
        if (i2 == 10 || i2 == 11) {
            return;
        }
        dispatchStateChanged(10);
        if (this.privateCall == null) {
            this.onDestroyRunnable = runnable;
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
        long j = tLRPC$PhoneCall.access_hash;
        tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
        tLRPC$TL_phone_discardCall.duration = (int) (getCallDuration() / 1000);
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        tLRPC$TL_phone_discardCall.connection_id = nativeInstanceArr[0] != null ? nativeInstanceArr[0].getPreferredRelayId() : 0L;
        if (i == 2) {
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonDisconnect();
        } else if (i == 3) {
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonMissed();
        } else if (i == 4) {
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonBusy();
        } else {
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonHangup();
        }
        CallProxy.getInstance(this.currentAccount).discardCall(tLRPC$TL_phone_discardCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda81
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$declineIncomingCall$70(tLObject, tLRPC$TL_error);
            }
        });
        this.onDestroyRunnable = runnable;
        callEnded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$declineIncomingCall$69() {
        if (this.currentState == 10) {
            callEnded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$declineIncomingCall$70(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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

    public void declineIncomingCall() {
        declineIncomingCall(1, null);
    }

    private Class<? extends Activity> getUIActivityClass() {
        return LaunchActivity.class;
    }

    public CallConnection getConnectionAndStartCall() {
        if (this.systemCallConnection == null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("creating call connection");
            }
            CallConnection callConnection = new CallConnection();
            this.systemCallConnection = callConnection;
            callConnection.setInitializing();
            if (this.isOutgoing) {
                Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getConnectionAndStartCall$71();
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
    public /* synthetic */ void lambda$getConnectionAndStartCall$71() {
        this.delayedStartOutgoingCall = null;
        startOutgoingCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRinging() throws Resources.NotFoundException, PendingIntent.CanceledException {
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
            showIncomingNotification(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name), this.user, this.privateCall.video, 0);
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
            PendingIntent.getActivity(this, 12345, new Intent(this, (Class<?>) LaunchActivity.class).setAction("voip"), ConnectionsManager.FileTypeVideo).send();
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error starting incall activity", e);
            }
        }
    }

    public void startRingtoneAndVibration() {
        if (this.startedRinging) {
            return;
        }
        startRingtoneAndVibration(this.user.id);
        this.startedRinging = true;
    }

    private void updateServerConfig() {
        final SharedPreferences mainSettings = MessagesController.getMainSettings(this.currentAccount);
        Instance.setGlobalServerConfig(mainSettings.getString("voip_server_config", "{}"));
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_phone_getCallConfig
            public static int constructor = 1430593449;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                return TLRPC$TL_dataJSON.TLdeserialize(abstractSerializedData, i, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda76
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                VoIPService.lambda$updateServerConfig$72(mainSettings, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateServerConfig$72(SharedPreferences sharedPreferences, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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

    public static String convertStreamToString(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
                sb.append("\n");
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public static String getStringFromFile(String str) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        String strConvertStreamToString = convertStreamToString(fileInputStream);
        fileInputStream.close();
        return strConvertStreamToString;
    }

    private void onTgVoipStop(Instance.FinalState finalState) throws PendingIntent.CanceledException {
        if (this.user == null) {
            return;
        }
        if (TextUtils.isEmpty(finalState.debugLog)) {
            try {
                finalState.debugLog = getStringFromFile(VoIPHelper.getLogFilePath(this.privateCall.id, true));
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        long j = tLRPC$PhoneCall.access_hash;
        tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_phone_saveCallDebug, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda93
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                VoIPService.lambda$onTgVoipStop$73(tLObject, tLRPC$TL_error);
            }
        });
        this.needSendDebugLog = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onTgVoipStop$73(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("Sent debug logs, response = " + tLObject);
        }
    }

    private void initializeAccountRelatedThings() {
        updateServerConfig();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.appDidLogout);
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("=============== VoIPService STARTING ===============");
        }
        try {
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (Build.VERSION.SDK_INT >= 17 && audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER") != null) {
                Instance.setBufferSize(Integer.parseInt(audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")));
            } else {
                Instance.setBufferSize(AudioTrack.getMinBufferSize(48000, 4, 2) / 2);
            }
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, LocaleController.getString(R.string.AppName) + "-voip");
            this.cpuWakelock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.acquire();
            this.btAdapter = audioManager.isBluetoothScoAvailableOffCall() ? BluetoothAdapter.getDefaultAdapter() : null;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (!USE_CONNECTION_SERVICE) {
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
            if (this.audioDeviceCallback == null) {
                try {
                    this.audioDeviceCallback = new AudioDeviceCallback() { // from class: org.rbmain.messenger.voip.VoIPService.8
                        @Override // android.media.AudioDeviceCallback
                        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                            VoIPService.this.checkUpdateBluetoothHeadset();
                        }

                        @Override // android.media.AudioDeviceCallback
                        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                            VoIPService.this.checkUpdateBluetoothHeadset();
                        }
                    };
                } catch (Throwable th) {
                    FileLog.e(th);
                    this.audioDeviceCallback = null;
                }
            }
            AudioDeviceCallback audioDeviceCallback = this.audioDeviceCallback;
            if (audioDeviceCallback != null) {
                audioManager.registerAudioDeviceCallback(audioDeviceCallback, new Handler(Looper.getMainLooper()));
            }
            audioManager.registerMediaButtonEventReceiver(new ComponentName(this, (Class<?>) VoIPMediaButtonReceiver.class));
            checkUpdateBluetoothHeadset();
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
            showWhen.setSmallIcon(R.drawable.ic_notif_shad);
        }
        startForeground(ID_ONGOING_CALL_NOTIFICATION, showWhen.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdateBluetoothHeadset() {
        BluetoothAdapter bluetoothAdapter;
        if (USE_CONNECTION_SERVICE || (bluetoothAdapter = this.btAdapter) == null || !bluetoothAdapter.isEnabled()) {
            return;
        }
        try {
            MediaRouter mediaRouter = (MediaRouter) getSystemService("media_router");
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (Build.VERSION.SDK_INT < 24) {
                updateBluetoothHeadsetState(this.btAdapter.getProfileConnectionState(1) == 2);
                Iterator<StateListener> it = this.stateListeners.iterator();
                while (it.hasNext()) {
                    it.next().onAudioSettingsChanged();
                }
                return;
            }
            if (mediaRouter.getSelectedRoute(1).getDeviceType() == 3) {
                updateBluetoothHeadsetState(this.btAdapter.getProfileConnectionState(1) == 2);
                Iterator<StateListener> it2 = this.stateListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onAudioSettingsChanged();
                }
                return;
            }
            updateBluetoothHeadsetState(audioManager.isBluetoothA2dpOn());
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    private void loadResources() {
        if (Build.VERSION.SDK_INT >= 21) {
            WebRtcAudioTrack.setAudioTrackUsageAttribute(2);
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadResources$74();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadResources$74() {
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

    private void dispatchStateChanged(int i) {
        CallConnection callConnection;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("== Call " + getCallID() + " state changed to " + i + " ==");
        }
        this.currentState = i;
        if (USE_CONNECTION_SERVICE && i == 3 && (callConnection = this.systemCallConnection) != null) {
            callConnection.setActive();
        }
        for (int i2 = 0; i2 < this.stateListeners.size(); i2++) {
            this.stateListeners.get(i2).onStateChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrafficStats(NativeInstance nativeInstance, Instance.TrafficStats trafficStats) {
        if (trafficStats == null) {
            trafficStats = nativeInstance.getTrafficStats();
        }
        long j = trafficStats.bytesSentWifi;
        Instance.TrafficStats trafficStats2 = this.prevTrafficStats;
        long j2 = j - (trafficStats2 != null ? trafficStats2.bytesSentWifi : 0L);
        long j3 = trafficStats.bytesReceivedWifi - (trafficStats2 != null ? trafficStats2.bytesReceivedWifi : 0L);
        long j4 = trafficStats.bytesSentMobile - (trafficStats2 != null ? trafficStats2.bytesSentMobile : 0L);
        long j5 = trafficStats.bytesReceivedMobile - (trafficStats2 != null ? trafficStats2.bytesReceivedMobile : 0L);
        this.prevTrafficStats = trafficStats;
        int i = 0;
        if (j2 > 0) {
            StatsController.getInstance(this.currentAccount).incrementSentBytesCount(1, 0, j2);
            StatsController.getInstance(this.currentAccount).incrementSentBytesCount(1, 6, j2);
        }
        if (j3 > 0) {
            StatsController.getInstance(this.currentAccount).incrementReceivedBytesCount(1, 0, j3);
            StatsController.getInstance(this.currentAccount).incrementReceivedBytesCount(1, 6, j3);
        }
        if (j4 > 0) {
            StatsController statsController = StatsController.getInstance(this.currentAccount);
            NetworkInfo networkInfo = this.lastNetInfo;
            statsController.incrementSentBytesCount((networkInfo == null || !networkInfo.isRoaming()) ? 0 : 2, 0, j4);
            StatsController statsController2 = StatsController.getInstance(this.currentAccount);
            NetworkInfo networkInfo2 = this.lastNetInfo;
            statsController2.incrementSentBytesCount((networkInfo2 == null || !networkInfo2.isRoaming()) ? 0 : 2, 6, j4);
        }
        if (j5 > 0) {
            StatsController statsController3 = StatsController.getInstance(this.currentAccount);
            NetworkInfo networkInfo3 = this.lastNetInfo;
            statsController3.incrementReceivedBytesCount((networkInfo3 == null || !networkInfo3.isRoaming()) ? 0 : 2, 0, j5);
            StatsController statsController4 = StatsController.getInstance(this.currentAccount);
            NetworkInfo networkInfo4 = this.lastNetInfo;
            if (networkInfo4 != null && networkInfo4.isRoaming()) {
                i = 2;
            }
            statsController4.incrementReceivedBytesCount(i, 6, j5);
        }
    }

    private void configureDeviceForCall() {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("configureDeviceForCall, route to set = " + this.audioRouteToSet);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            WebRtcAudioTrack.setAudioTrackUsageAttribute(hasRtmpStream() ? 1 : 2);
            WebRtcAudioTrack.setAudioStreamType(hasRtmpStream() ? Integer.MIN_VALUE : 0);
        }
        this.needPlayEndSound = true;
        final AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (!USE_CONNECTION_SERVICE) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda44
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$configureDeviceForCall$77(audioManager);
                }
            });
        }
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(8);
        if (defaultSensor != null) {
            try {
                this.proximityWakelock = ((PowerManager) getSystemService("power")).newWakeLock(32, LocaleController.getString(R.string.AppName) + "-voip-prx");
                sensorManager.registerListener(this, defaultSensor, 3);
            } catch (Exception e) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("Error initializing proximity sensor", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureDeviceForCall$77(final AudioManager audioManager) {
        try {
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (hasRtmpStream()) {
            audioManager.setMode(0);
            audioManager.setBluetoothScoOn(false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda59
                @Override // java.lang.Runnable
                public final void run() {
                    VoIPService.lambda$configureDeviceForCall$75();
                }
            });
        } else {
            audioManager.setMode(3);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda43
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$configureDeviceForCall$76(audioManager);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$configureDeviceForCall$75() {
        if (MediaController.getInstance().isMessagePaused()) {
            return;
        }
        MediaController.getInstance().lambda$startAudioAgain$7(MediaController.getInstance().getPlayingMessageObject());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureDeviceForCall$76(AudioManager audioManager) {
        audioManager.requestAudioFocus(this, 0, 1);
        VoipAudioManager voipAudioManager = VoipAudioManager.get();
        if (isBluetoothHeadsetConnected() && hasEarpiece()) {
            int i = this.audioRouteToSet;
            if (i == 0) {
                audioManager.setBluetoothScoOn(false);
                voipAudioManager.setSpeakerphoneOn(false);
            } else if (i == 1) {
                audioManager.setBluetoothScoOn(false);
                voipAudioManager.setSpeakerphoneOn(true);
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
                    voipAudioManager.setSpeakerphoneOn(false);
                }
            }
        } else if (isBluetoothHeadsetConnected()) {
            audioManager.setBluetoothScoOn(this.speakerphoneStateToSet);
        } else {
            voipAudioManager.setSpeakerphoneOn(this.speakerphoneStateToSet);
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
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.unmutedByHold || this.remoteVideoState == 2) {
            return;
        }
        if (this.videoState[0] != 2 && sensorEvent.sensor.getType() == 8) {
            AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            VoipAudioManager voipAudioManager = VoipAudioManager.get();
            if (this.audioRouteToSet != 0 || this.isHeadsetPlugged || voipAudioManager.isSpeakerphoneOn()) {
                return;
            }
            if (isBluetoothHeadsetConnected() && audioManager.isBluetoothScoOn()) {
                return;
            }
            checkIsNear(sensorEvent.values[0] < Math.min(sensorEvent.sensor.getMaximumRange(), 3.0f));
        }
    }

    private void checkIsNear() {
        if (this.remoteVideoState == 2 || this.videoState[0] == 2) {
            checkIsNear(false);
        }
    }

    private void checkIsNear(boolean z) {
        if (z != this.isProximityNear) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("proximity " + z);
            }
            this.isProximityNear = z;
            try {
                if (z) {
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
    public void onAudioFocusChange(int i) {
        if (i == 1) {
            this.hasAudioFocus = true;
        } else {
            this.hasAudioFocus = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBluetoothHeadsetState(boolean z) {
        if (z == this.isBtHeadsetConnected) {
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("updateBluetoothHeadsetState: " + z);
        }
        this.isBtHeadsetConnected = z;
        final AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (z && !isRinging() && this.currentState != 0) {
            if (this.bluetoothScoActive) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("SCO already active, setting audio routing");
                }
                if (!hasRtmpStream()) {
                    audioManager.setSpeakerphoneOn(false);
                    audioManager.setBluetoothScoOn(true);
                }
            } else {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("startBluetoothSco");
                }
                if (!hasRtmpStream()) {
                    this.needSwitchToBluetoothAfterScoActivates = true;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            VoIPService.lambda$updateBluetoothHeadsetState$78(audioManager);
                        }
                    }, 500L);
                }
            }
        } else {
            this.bluetoothScoActive = false;
            this.bluetoothScoConnecting = false;
            audioManager.setBluetoothScoOn(false);
        }
        Iterator<StateListener> it = this.stateListeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSettingsChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateBluetoothHeadsetState$78(AudioManager audioManager) {
        try {
            audioManager.startBluetoothSco();
        } catch (Throwable unused) {
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

    public void callFailed() {
        NativeInstance[] nativeInstanceArr = this.tgVoip;
        callFailed(nativeInstanceArr[0] != null ? nativeInstanceArr[0].getLastError() : Instance.ERROR_UNKNOWN);
    }

    private Bitmap getRoundAvatarBitmap(TLObject tLObject) throws Resources.NotFoundException {
        AvatarDrawable avatarDrawable;
        Bitmap bitmapDecodeFile = null;
        try {
            if (tLObject instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User.photo;
                if (tLRPC$UserProfilePhoto != null && tLRPC$UserProfilePhoto.photo_small != null) {
                    BitmapDrawable imageFromMemory = ImageLoader.getInstance().getImageFromMemory(tLRPC$User.photo.photo_small, null, "50_50");
                    if (imageFromMemory != null) {
                        bitmapDecodeFile = imageFromMemory.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inMutable = true;
                            FileLoader.getInstance(this.currentAccount);
                            bitmapDecodeFile = BitmapFactory.decodeFile(FileLoader.getPathToAttach(tLRPC$User.photo.photo_small, true).toString(), options);
                        } catch (Throwable th) {
                            FileLog.e(th);
                        }
                    }
                }
            } else {
                TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) tLObject;
                TLRPC$ChatPhoto tLRPC$ChatPhoto = tLRPC$Chat.photo;
                if (tLRPC$ChatPhoto != null && tLRPC$ChatPhoto.photo_small != null) {
                    BitmapDrawable imageFromMemory2 = ImageLoader.getInstance().getImageFromMemory(tLRPC$Chat.photo.photo_small, null, "50_50");
                    if (imageFromMemory2 != null) {
                        bitmapDecodeFile = imageFromMemory2.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        try {
                            BitmapFactory.Options options2 = new BitmapFactory.Options();
                            options2.inMutable = true;
                            FileLoader.getInstance(this.currentAccount);
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
            if (tLObject instanceof TLRPC$User) {
                avatarDrawable = new AvatarDrawable((TLRPC$User) tLObject);
            } else {
                avatarDrawable = new AvatarDrawable((TLRPC$Chat) tLObject);
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
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014b  */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showIncomingNotification(java.lang.String r19, org.rbmain.tgnet.TLObject r20, boolean r21, int r22) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.voip.VoIPService.showIncomingNotification(java.lang.String, org.rbmain.tgnet.TLObject, boolean, int):void");
    }

    private void callFailed(String str) throws Exception {
        CallConnection callConnection;
        if (this.privateCall != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("Discarding failed call");
            }
            TLRPC$TL_phone_discardCall tLRPC$TL_phone_discardCall = new TLRPC$TL_phone_discardCall();
            TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
            tLRPC$TL_phone_discardCall.peer = tLRPC$TL_inputPhoneCall;
            TLRPC$PhoneCall tLRPC$PhoneCall = this.privateCall;
            long j = tLRPC$PhoneCall.access_hash;
            tLRPC$TL_inputPhoneCall.id = tLRPC$PhoneCall.id;
            tLRPC$TL_phone_discardCall.duration = (int) (getCallDuration() / 1000);
            NativeInstance[] nativeInstanceArr = this.tgVoip;
            tLRPC$TL_phone_discardCall.connection_id = nativeInstanceArr[0] != null ? nativeInstanceArr[0].getPreferredRelayId() : 0L;
            tLRPC$TL_phone_discardCall.reason = new TLRPC$TL_phoneCallDiscardReasonDisconnect();
            CallProxy.getInstance(this.currentAccount).discardCall(tLRPC$TL_phone_discardCall, new RequestDelegate() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda95
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    VoIPService.lambda$callFailed$79(tLObject, tLRPC$TL_error);
                }
            });
        }
        try {
            throw new Exception("Call " + getCallID() + " failed with error: " + str);
        } catch (Exception e) {
            FileLog.e(e);
            this.lastError = str;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$callFailed$80();
                }
            });
            if (TextUtils.equals(str, Instance.ERROR_LOCALIZED) && this.soundPool != null) {
                this.playingSound = true;
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$callFailed$81();
                    }
                });
                AndroidUtilities.runOnUIThread(this.afterSoundRunnable, 1000L);
            }
            if (USE_CONNECTION_SERVICE && (callConnection = this.systemCallConnection) != null) {
                callConnection.setDisconnected(new DisconnectCause(1));
                this.systemCallConnection.destroy();
                this.systemCallConnection = null;
            }
            AndroidUtilities.cancelRunOnUIThread(this.getSignalingDataRunnable);
            stopSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$callFailed$79(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
    public /* synthetic */ void lambda$callFailed$80() {
        dispatchStateChanged(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callFailed$81() {
        this.soundPool.play(this.spFailedID, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    void callFailedFromConnectionService() throws Exception {
        if (this.isOutgoing) {
            callFailed(Instance.ERROR_CONNECTION_SERVICE);
        } else {
            hangUp();
        }
    }

    @Override // org.rbmain.messenger.voip.VoIPController.ConnectionStateListener
    public void onConnectionStateChanged(final int i, boolean z) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onConnectionStateChanged$84(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectionStateChanged$84(int i) {
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
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnectionStateChanged$82();
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService.9
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
                    StatsController.getInstance(this.currentAccount).incrementSentItemsCount(getStatsNetworkType(), 6, 1);
                } else {
                    StatsController.getInstance(this.currentAccount).incrementReceivedItemsCount(getStatsNetworkType(), 0, 1);
                    StatsController.getInstance(this.currentAccount).incrementReceivedItemsCount(getStatsNetworkType(), 6, 1);
                }
                if (this.privateCall != null) {
                    ServiceLocator.getInstance(this.currentAccount).getCoreMainClass().callStarted(this.privateCall.id);
                }
            }
            AndroidUtilities.cancelRunOnUIThread(this.getSignalingDataRunnable);
        }
        if (i == 5) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnectionStateChanged$83();
                }
            });
        }
        dispatchStateChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectionStateChanged$82() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
            this.spPlayId = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectionStateChanged$83() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
        }
        this.spPlayId = this.soundPool.play(this.groupCall != null ? this.spVoiceChatConnecting : this.spConnectingId, 1.0f, 1.0f, 0, -1, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playStartRecordSound$85() {
        this.soundPool.play(this.spStartRecordId, 0.5f, 0.5f, 0, 0, 1.0f);
    }

    public void playStartRecordSound() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playStartRecordSound$85();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playAllowTalkSound$86() {
        this.soundPool.play(this.spAllowTalkId, 0.5f, 0.5f, 0, 0, 1.0f);
    }

    public void playAllowTalkSound() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playAllowTalkSound$86();
            }
        });
    }

    @Override // org.rbmain.messenger.voip.VoIPController.ConnectionStateListener
    public void onSignalBarCountChanged(final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onSignalBarCountChanged$87(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSignalBarCountChanged$87(int i) {
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

    private void callEnded() {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("Call " + getCallID() + " ended");
        }
        if (this.groupCall != null && (!this.playedConnectedSound || this.onDestroyRunnable != null)) {
            this.needPlayEndSound = false;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callEnded$88();
            }
        });
        int i = 700;
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callEnded$89();
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
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda18
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$callEnded$90();
                    }
                });
            } else {
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$callEnded$91();
                    }
                }, 100L);
                i = HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
            }
            AndroidUtilities.runOnUIThread(this.afterSoundRunnable, i);
        }
        Runnable runnable2 = this.timeoutRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.timeoutRunnable = null;
        }
        endConnectionServiceCall(this.needPlayEndSound ? i : 0L);
        AndroidUtilities.cancelRunOnUIThread(this.getSignalingDataRunnable);
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callEnded$88() {
        dispatchStateChanged(11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callEnded$89() {
        int i = this.spPlayId;
        if (i != 0) {
            this.soundPool.stop(i);
            this.spPlayId = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callEnded$90() {
        this.soundPool.play(this.spEndId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callEnded$91() {
        this.soundPool.play(this.spVoiceChatEndId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    private void endConnectionServiceCall(long j) {
        if (USE_CONNECTION_SERVICE) {
            Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.voip.VoIPService$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$endConnectionServiceCall$92();
                }
            };
            if (j > 0) {
                AndroidUtilities.runOnUIThread(runnable, j);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$endConnectionServiceCall$92() {
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

    public void handleNotificationAction(Intent intent) throws PendingIntent.CanceledException {
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
    public void acceptIncomingCallFromNotification() throws PendingIntent.CanceledException {
        showNotification();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 && i < 30 && (checkSelfPermission("android.permission.RECORD_AUDIO") != 0 || (this.privateCall.video && checkSelfPermission("android.permission.CAMERA") != 0))) {
            try {
                PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) VoIPPermissionActivity.class).addFlags(268435456), 1107296256).send();
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
            PendingIntent.getActivity(this, 0, new Intent(this, getUIActivityClass()).setAction("voip"), ConnectionsManager.FileTypeVideo).send();
        } catch (Exception e2) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error starting incall activity", e2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateOutputGainControlState() {
        if (hasRtmpStream()) {
            return;
        }
        int i = 0;
        if (this.tgVoip[0] != null) {
            if (!USE_CONNECTION_SERVICE) {
                AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                boolean zIsSpeakerphoneOn = VoipAudioManager.get().isSpeakerphoneOn();
                this.tgVoip[0].setAudioOutputGainControlEnabled((!hasEarpiece() || zIsSpeakerphoneOn || audioManager.isBluetoothScoOn() || this.isHeadsetPlugged) ? false : true);
                NativeInstance nativeInstance = this.tgVoip[0];
                if (!this.isHeadsetPlugged && (!hasEarpiece() || zIsSpeakerphoneOn || audioManager.isBluetoothScoOn() || this.isHeadsetPlugged)) {
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

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.appDidLogout) {
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

    private PhoneAccountHandle addAccountToTelecomManager() {
        TelecomManager telecomManager = (TelecomManager) getSystemService("telecom");
        TLRPC$User currentUser = UserConfig.getInstance(this.currentAccount).getCurrentUser();
        telecomManager.registerPhoneAccount(new PhoneAccount.Builder(new PhoneAccountHandle(new ComponentName(this, (Class<?>) RubikaConnectionService.class), BuildConfig.FLAVOR + currentUser.id), ContactsController.formatName(currentUser.first_name, currentUser.last_name)).setCapabilities(2048).setIcon(Icon.createWithResource(this, R.drawable.ic_notif_shad)).setHighlightColor(-13851168).addSupportedUriScheme("sip").build());
        return null;
    }

    public class CallConnection extends Connection {
        public CallConnection() {
            setConnectionProperties(128);
            setAudioModeIsVoip(true);
        }

        @Override // android.telecom.Connection
        public void onCallAudioStateChanged(CallAudioState callAudioState) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("ConnectionService call audio state changed: " + callAudioState);
            }
            Iterator it = VoIPService.this.stateListeners.iterator();
            while (it.hasNext()) {
                ((StateListener) it.next()).onAudioSettingsChanged();
            }
        }

        @Override // android.telecom.Connection
        public void onDisconnect() {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("ConnectionService onDisconnect");
            }
            setDisconnected(new DisconnectCause(2));
            destroy();
            VoIPService.this.systemCallConnection = null;
            VoIPService.this.hangUp();
        }

        @Override // android.telecom.Connection
        public void onAnswer() throws PendingIntent.CanceledException {
            VoIPService.this.acceptIncomingCallFromNotification();
        }

        @Override // android.telecom.Connection
        public void onReject() {
            VoIPService.this.needPlayEndSound = false;
            VoIPService.this.declineIncomingCall(1, null);
        }

        @Override // android.telecom.Connection
        public void onShowIncomingCallUi() throws Resources.NotFoundException, PendingIntent.CanceledException {
            VoIPService.this.startRinging();
        }

        @Override // android.telecom.Connection
        public void onStateChanged(int i) {
            super.onStateChanged(i);
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("ConnectionService onStateChanged " + Connection.stateToString(i));
            }
            if (i == 4) {
                ContactsController.getInstance(VoIPService.this.currentAccount).deleteConnectionServiceContact();
                VoIPService.this.didDeleteConnectionServiceContact = true;
            }
        }

        @Override // android.telecom.Connection
        public void onCallEvent(String str, Bundle bundle) {
            super.onCallEvent(str, bundle);
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("ConnectionService onCallEvent " + str);
            }
        }

        @Override // android.telecom.Connection
        public void onSilence() {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("onSlience");
            }
            VoIPService.this.stopRinging();
        }
    }
}
