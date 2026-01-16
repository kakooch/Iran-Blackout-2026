package ir.eitaa.features.CallOut;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import ir.eitaa.features.CallOut.CallOutSingleton;
import ir.eitaa.features.CallOut.helper.CallOutAudioManager;
import ir.eitaa.features.CallOut.helper.CallOutManager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_GetCallOutAuthHash;
import ir.eitaa.tgnet.TLRPC$TL_UserPayHash;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackgroundGradientDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.voip.VoIPButtonsLayout;
import ir.eitaa.ui.Components.voip.VoIPStatusTextView;
import ir.eitaa.ui.Components.voip.VoIPToggleButton;
import java.io.IOException;
import java.util.Locale;
import org.linphone.core.Account;
import org.linphone.core.AccountParams;
import org.linphone.core.Address;
import org.linphone.core.AudioDevice;
import org.linphone.core.AuthInfo;
import org.linphone.core.Call;
import org.linphone.core.CallParams;
import org.linphone.core.Core;
import org.linphone.core.CoreListenerStub;
import org.linphone.core.Factory;
import org.linphone.core.MediaEncryption;
import org.linphone.core.RegistrationState;
import org.linphone.core.TransportType;

/* loaded from: classes.dex */
public class CallOutActivity extends BaseFragment implements SensorEventListener {
    private TLRPC$TL_UserPayHash authData;
    private VoIPButtonsLayout buttonsLayout;
    private BackupImageView callingUserPhotoView;
    private TextView callingUserTitle;
    private ContactsController.Contact contact;
    private FrameLayout contentView;
    CoreListenerStub coreListener;
    private VoIPToggleButton endCallButton;
    private Handler handler;
    private boolean isFromKeypad;
    private VoIPToggleButton micButton;
    private int prevOrientation;
    private PowerManager.WakeLock proximityWakelock;
    private SensorManager sensorManager;
    private VoIPToggleButton speakerButton;
    private LinearLayout statusLayout;
    private VoIPStatusTextView statusTextView;
    String TAG = "CallOut";
    private boolean isMicMute = false;
    private boolean isCallStarted = false;
    private boolean isCallAnswered = false;
    private int seconds = 0;
    private int AUDIO_REQUEST_PERMISSION = 1380;
    protected ServiceConnection mServerConn = new ServiceConnection() { // from class: ir.eitaa.features.CallOut.CallOutActivity.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.d(CallOutActivity.this.TAG, "onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Log.d(CallOutActivity.this.TAG, "onServiceDisconnected");
        }
    };

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    static /* synthetic */ int access$408(CallOutActivity callOutActivity) {
        int i = callOutActivity.seconds;
        callOutActivity.seconds = i + 1;
        return i;
    }

    public CallOutActivity(ContactsController.Contact contact, boolean isFromKeypad) {
        this.contact = contact;
        this.isFromKeypad = isFromKeypad;
        Log.e("Callout", "CallOutActivity|phone: " + contact.phones.get(0));
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        if (this.isFromKeypad) {
            return;
        }
        getParentActivity().setRequestedOrientation(this.prevOrientation);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.isFromKeypad) {
            return;
        }
        this.prevOrientation = getParentActivity().getRequestedOrientation();
        getParentActivity().setRequestedOrientation(1);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) throws IOException {
        String str;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.getString("CallOutTitle", R.string.CallOutTitle));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.features.CallOut.CallOutActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    CallOutActivity.this.finishFragment();
                }
            }
        });
        this.contentView = new FrameLayout(context);
        BackgroundGradientDrawable backgroundGradientDrawable = new BackgroundGradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Theme.getColor("actionBarDefault"), Theme.getColor("chats_actionPressedBackground")});
        this.contentView.setBackground(backgroundGradientDrawable);
        ContactsController.Contact contact = this.contact;
        if (contact != null && contact.user != null) {
            BackupImageView backupImageView = new BackupImageView(context) { // from class: ir.eitaa.features.CallOut.CallOutActivity.3
                final int blackoutColor = ColorUtils.setAlphaComponent(-16777216, 76);

                @Override // ir.eitaa.ui.Components.BackupImageView, android.view.View
                protected void onDraw(Canvas canvas) {
                    super.onDraw(canvas);
                    canvas.drawColor(this.blackoutColor);
                }
            };
            this.callingUserPhotoView = backupImageView;
            this.contentView.addView(backupImageView, LayoutHelper.createFrame(-1, -1.0f));
            this.callingUserPhotoView.setImage(ImageLocation.getForUserOrChat(this.contact.user, 0), (String) null, backgroundGradientDrawable, this.contact.user);
        }
        this.buttonsLayout = new VoIPButtonsLayout(context);
        VoIPToggleButton voIPToggleButton = new VoIPToggleButton(context);
        this.endCallButton = voIPToggleButton;
        voIPToggleButton.setData(R.drawable.calls_decline, -1, -1041108, LocaleController.getString("VoipEndCall", R.string.VoipEndCall), false, true);
        this.endCallButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.features.CallOut.CallOutActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CallOutActivity.this.terminate();
                CallOutActivity.this.finishFragment();
            }
        });
        VoIPToggleButton voIPToggleButton2 = new VoIPToggleButton(context);
        this.micButton = voIPToggleButton2;
        voIPToggleButton2.setData(R.drawable.calls_unmute, -1, ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipMute", R.string.VoipMute), false, true);
        this.micButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.features.CallOut.CallOutActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CallOutActivity.this.isMicMute = !r8.isMicMute;
                if (CallOutActivity.this.isMicMute) {
                    CallOutActivity.this.micButton.setData(R.drawable.calls_unmute, -16777216, -1, LocaleController.getString("VoipUnmute", R.string.VoipUnmute), true, true);
                } else {
                    CallOutActivity.this.micButton.setData(R.drawable.calls_unmute, -1, ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipMute", R.string.VoipMute), false, true);
                }
                CallOutAudioManager.toggleMic(Boolean.valueOf(!CallOutActivity.this.isMicMute));
            }
        });
        this.speakerButton = new VoIPToggleButton(context);
        if (CallOutAudioManager.isSpeakerActive()) {
            this.speakerButton.setData(R.drawable.calls_speaker, -16777216, -1, LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, true);
            this.speakerButton.setChecked(true, true);
        } else {
            this.speakerButton.setData(R.drawable.calls_speaker, -1, ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, true);
            this.speakerButton.setChecked(false, true);
        }
        this.speakerButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.features.CallOut.CallOutActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CallOutAudioManager.toggleSpeaker();
                if (CallOutAudioManager.isSpeakerActive()) {
                    CallOutActivity.this.speakerButton.setData(R.drawable.calls_speaker, -16777216, -1, LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, true);
                    CallOutActivity.this.speakerButton.setChecked(true, true);
                } else {
                    CallOutActivity.this.speakerButton.setData(R.drawable.calls_speaker, -1, ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, true);
                    CallOutActivity.this.speakerButton.setChecked(false, true);
                }
            }
        });
        this.buttonsLayout.addView(this.speakerButton);
        this.buttonsLayout.addView(this.micButton);
        this.buttonsLayout.addView(this.endCallButton);
        this.contentView.addView(this.buttonsLayout, LayoutHelper.createFrame(-1, -2.0f, 81, 32.0f, 32.0f, 32.0f, 32.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.statusLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.statusLayout.setFocusable(true);
        this.statusLayout.setFocusableInTouchMode(true);
        TextView textView = new TextView(context);
        this.callingUserTitle = textView;
        textView.setTextSize(1, 24.0f);
        this.callingUserTitle.setTypeface(AndroidUtilities.getFontFamily(false));
        this.callingUserTitle.setShadowLayer(AndroidUtilities.dp(3.0f), 0.0f, AndroidUtilities.dp(0.6666667f), 1275068416);
        this.callingUserTitle.setTextColor(-1);
        this.callingUserTitle.setGravity(1);
        this.callingUserTitle.setImportantForAccessibility(2);
        this.statusLayout.addView(this.callingUserTitle, LayoutHelper.createLinear(-2, -2, 1, 0, 0, 0, 6));
        ContactsController.Contact contact2 = this.contact;
        if (contact2 != null) {
            String str2 = "";
            TLRPC$User tLRPC$User = contact2.user;
            if (tLRPC$User != null) {
                String str3 = tLRPC$User.first_name;
                if (str3 != null && !str3.isEmpty()) {
                    str2 = "" + this.contact.user.first_name;
                }
                String str4 = this.contact.user.last_name;
                if (str4 != null && !str4.isEmpty()) {
                    str2 = str2 + " " + this.contact.user.last_name;
                }
            } else {
                String str5 = contact2.first_name;
                if ((str5 != null && !str5.isEmpty()) || ((str = this.contact.last_name) != null && !str.isEmpty())) {
                    String str6 = this.contact.first_name;
                    if (str6 != null && !str6.isEmpty()) {
                        str2 = "" + this.contact.first_name;
                    }
                    String str7 = this.contact.last_name;
                    if (str7 != null && !str7.isEmpty()) {
                        str2 = str2 + " " + this.contact.last_name;
                    }
                } else {
                    str2 = this.contact.phones.get(0);
                }
            }
            this.callingUserTitle.setText(str2);
        }
        VoIPStatusTextView voIPStatusTextView = new VoIPStatusTextView(context);
        this.statusTextView = voIPStatusTextView;
        voIPStatusTextView.setText(LocaleController.getString("WaitingForConnection", R.string.WaitingForConnection), true, true);
        this.statusTextView.setForegroundGravity(17);
        ViewCompat.setImportantForAccessibility(this.statusTextView, 4);
        this.statusLayout.addView(this.statusTextView, LayoutHelper.createLinear(-2, -2, 1, 0, 0, 0, 6));
        this.statusLayout.setClipChildren(false);
        this.statusLayout.setClipToPadding(false);
        this.statusLayout.setPadding(0, 0, 0, AndroidUtilities.dp(15.0f));
        this.contentView.addView(this.statusLayout, LayoutHelper.createFrame(-1, -2.0f, 49, 32.0f, 32.0f, 32.0f, 32.0f));
        preInit();
        if (CallOutManager.checkPermissions(getParentActivity())) {
            init();
        } else {
            CallOutManager.requestPermissions(this, this.AUDIO_REQUEST_PERMISSION);
        }
        FrameLayout frameLayout = this.contentView;
        this.fragmentView = frameLayout;
        return frameLayout;
    }

    @SuppressLint({"InvalidWakeLockTag"})
    private void preInit() throws IOException {
        SensorManager sensorManager = (SensorManager) this.actionBar.getContext().getSystemService("sensor");
        this.sensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(8);
        if (defaultSensor != null) {
            try {
                this.proximityWakelock = ((PowerManager) this.actionBar.getContext().getSystemService("power")).newWakeLock(32, "eitaa-callout-prx");
                this.sensorManager.registerListener(this, defaultSensor, 3);
            } catch (Exception e) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("Error initializing proximity sensor", e);
                }
            }
        }
    }

    private void init() {
        CallOutSingleton.getInstance().start(new CallOutSingleton.CallOutDelegate() { // from class: ir.eitaa.features.CallOut.-$$Lambda$CallOutActivity$6uID2w_Y-VfcpkPy50qH8U5To7k
            @Override // ir.eitaa.features.CallOut.CallOutSingleton.CallOutDelegate
            public final void onInitializeFinished() {
                this.f$0.lambda$init$0$CallOutActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$init$0$CallOutActivity() {
        this.coreListener = new CoreListenerStub() { // from class: ir.eitaa.features.CallOut.CallOutActivity.7
            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onCallStateChanged(Core core, Call call, Call.State state, String message) {
                super.onCallStateChanged(core, call, state, message);
                CallOutSingleton.getInstance().lastCallState = state;
                CallOutSingleton.getInstance().lastCallMessage = message;
                CallOutActivity.this.handleCallState(state, message, false);
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onAccountRegistrationStateChanged(Core core, Account account, RegistrationState state, String message) {
                super.onAccountRegistrationStateChanged(core, account, state, message);
                if (state == RegistrationState.Failed) {
                    Log.e(CallOutActivity.this.TAG, "Register Failed");
                    CallOutActivity.this.statusTextView.setText(LocaleController.getString("ConnectionFailed", R.string.ConnectionFailed), true, true);
                    Toast.makeText(CallOutActivity.this.getParentActivity(), "Register Failed | Message: " + message, 1).show();
                    CallOutActivity.this.finishFragment();
                    return;
                }
                if (state == RegistrationState.Refreshing) {
                    Log.e(CallOutActivity.this.TAG, "Refreshing");
                    return;
                }
                if (state == RegistrationState.Cleared) {
                    Log.e(CallOutActivity.this.TAG, "Cleared");
                    return;
                }
                if (state == RegistrationState.Ok) {
                    if (!CallOutActivity.this.isCallAnswered) {
                        CallOutActivity.this.statusTextView.setText(LocaleController.getString("ConnectionSuccess", R.string.ConnectionSuccess), true, true);
                    }
                    Log.e(CallOutActivity.this.TAG, "Register Success");
                    if (CallOutActivity.this.isCallStarted) {
                        return;
                    }
                    CallOutActivity.this.isCallStarted = true;
                    Log.e("Callout", "RegistrationState.Ok |phone: " + CallOutActivity.this.contact.phones.get(0));
                    CallOutActivity.this.startCall();
                }
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onAudioDevicesListUpdated(Core core) {
                if (CallOutAudioManager.isBluetoothAudioRouteAvailable()) {
                    if (CallOutAudioManager.isSpeakerActive()) {
                        return;
                    }
                    CallOutAudioManager.routeAudioToBluetooth();
                } else {
                    if (!CallOutAudioManager.isHeadsetAudioRouteAvailable() || CallOutAudioManager.isSpeakerActive()) {
                        return;
                    }
                    CallOutAudioManager.routeAudioToHeadset();
                }
            }
        };
        if (CallOutManager.getCall() != null && this.contact == CallOutSingleton.getInstance().lastCallContact) {
            CallOutSingleton.getInstance().core.addListener(this.coreListener);
            this.isCallStarted = true;
            this.seconds = (int) ((System.currentTimeMillis() - CallOutSingleton.getInstance().lastCallStartTime) / 1000);
            handleCallState(CallOutSingleton.getInstance().lastCallState, CallOutSingleton.getInstance().lastCallMessage, true);
            return;
        }
        TLRPC$TL_GetCallOutAuthHash tLRPC$TL_GetCallOutAuthHash = new TLRPC$TL_GetCallOutAuthHash();
        tLRPC$TL_GetCallOutAuthHash.phone = this.contact.phones.get(0);
        getConnectionsManager().sendRequest(tLRPC$TL_GetCallOutAuthHash, new RequestDelegate() { // from class: ir.eitaa.features.CallOut.CallOutActivity.8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, final TLRPC$TL_error error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.features.CallOut.CallOutActivity.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (error == null) {
                            TLObject tLObject = response;
                            if (tLObject instanceof TLRPC$TL_UserPayHash) {
                                CallOutActivity.this.authData = (TLRPC$TL_UserPayHash) tLObject;
                                CallOutActivity callOutActivity = CallOutActivity.this;
                                callOutActivity.registerService(callOutActivity.coreListener);
                                return;
                            }
                        }
                        Toast.makeText(CallOutActivity.this.getParentActivity(), "Error while getting token from server!", 1).show();
                        CallOutActivity.this.finishFragment();
                    }
                });
            }
        });
    }

    void registerService(CoreListenerStub coreListener) {
        if (this.authData != null) {
            Log.e("Callout", "registerService******************");
            TransportType transportType = TransportType.Tls;
            Factory factoryInstance = Factory.instance();
            TLRPC$TL_UserPayHash tLRPC$TL_UserPayHash = this.authData;
            AuthInfo authInfoCreateAuthInfo = factoryInstance.createAuthInfo(tLRPC$TL_UserPayHash.voipUserName, null, tLRPC$TL_UserPayHash.voipPassword, null, null, tLRPC$TL_UserPayHash.voipHostName, null);
            AccountParams accountParamsCreateAccountParams = CallOutSingleton.getInstance().core.createAccountParams();
            accountParamsCreateAccountParams.setIdentityAddress(Factory.instance().createAddress("sip:" + this.authData.voipUserName + "@" + this.authData.voipHostName));
            accountParamsCreateAccountParams.setExpires(60);
            accountParamsCreateAccountParams.setRegisterEnabled(true);
            Address addressCreateAddress = Factory.instance().createAddress("sip:" + this.authData.voipHostName);
            if (addressCreateAddress == null) {
                finishFragment();
                return;
            }
            addressCreateAddress.setTransport(transportType);
            addressCreateAddress.setPort(this.authData.voipPort);
            accountParamsCreateAccountParams.setServerAddress(addressCreateAddress);
            Account accountCreateAccount = CallOutSingleton.getInstance().core.createAccount(accountParamsCreateAccountParams);
            accountParamsCreateAccountParams.setOutboundProxyEnabled(true);
            CallOutSingleton.getInstance().core.addAuthInfo(authInfoCreateAuthInfo);
            CallOutSingleton.getInstance().core.addAccount(accountCreateAccount);
            CallOutSingleton.getInstance().core.setDefaultAccount(accountCreateAccount);
            CallOutSingleton.getInstance().core.addListener(coreListener);
            CallOutSingleton.getInstance().core.start();
        }
    }

    void startCall() {
        if (this.authData == null || CallOutSingleton.getInstance().core == null) {
            return;
        }
        Log.e(this.TAG, "Start New Call");
        Address addressCreateAddress = Factory.instance().createAddress("sip:eitaacallout@" + this.authData.voipHostName);
        CallParams callParamsCreateCallParams = CallOutSingleton.getInstance().core.createCallParams(null);
        if (callParamsCreateCallParams != null) {
            callParamsCreateCallParams.setLowBandwidthEnabled(true);
        }
        if (CallOutAudioManager.isHeadsetAudioRouteAvailable()) {
            for (int i = 0; i < CallOutSingleton.getInstance().core.getAudioDevices().length; i++) {
                AudioDevice audioDevice = CallOutSingleton.getInstance().core.getAudioDevices()[i];
                if (audioDevice.getType() == AudioDevice.Type.Headset || audioDevice.getType() == AudioDevice.Type.Headphones) {
                    CallOutSingleton.getInstance().core.setDefaultOutputAudioDevice(audioDevice);
                }
            }
        }
        if (addressCreateAddress != null && callParamsCreateCallParams != null) {
            callParamsCreateCallParams.addCustomHeader("TOKEN", this.authData.hash);
            callParamsCreateCallParams.setMediaEncryption(MediaEncryption.None);
            CallOutSingleton.getInstance().core.inviteAddressWithParams(addressCreateAddress, callParamsCreateCallParams);
            Intent intent = new Intent(getParentActivity(), (Class<?>) CallOutCoreService.class);
            getParentActivity().startService(intent);
            getParentActivity().bindService(intent, this.mServerConn, 1);
            return;
        }
        Toast.makeText(getParentActivity(), LocaleController.getString("ServiceUnavailable", R.string.ServiceUnavailable), 1).show();
        finishFragment();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (CallOutSingleton.getInstance().core != null) {
            CallOutSingleton.getInstance().core.removeListener(this.coreListener);
        }
        this.sensorManager.unregisterListener(this);
        PowerManager.WakeLock wakeLock = this.proximityWakelock;
        if (wakeLock != null && wakeLock.isHeld()) {
            try {
                this.proximityWakelock.release();
            } catch (Exception unused) {
            }
        }
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == this.AUDIO_REQUEST_PERMISSION) {
            int length = grantResults.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                } else if (grantResults[i] != 0) {
                    break;
                } else {
                    i++;
                }
            }
            if (grantResults.length > 0 && z) {
                init();
            } else {
                finishFragment();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void terminate() {
        if (CallOutSingleton.getInstance().core == null) {
            return;
        }
        if (this.coreListener != null) {
            CallOutSingleton.getInstance().core.removeListener(this.coreListener);
        }
        CallOutManager.terminateCall();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == 8) {
            checkIsNear(event.values[0] < Math.min(event.sensor.getMaximumRange(), 3.0f));
        }
    }

    private void checkIsNear(boolean isProximityNear) {
        if (CallOutAudioManager.isHeadsetAudioRouteAvailable() || CallOutAudioManager.isSpeakerActive()) {
            return;
        }
        try {
            if (isProximityNear) {
                this.proximityWakelock.acquire();
            } else {
                this.proximityWakelock.release(1);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void startCallTimer() {
        Handler handler = new Handler();
        this.handler = handler;
        handler.post(new Runnable() { // from class: ir.eitaa.features.CallOut.CallOutActivity.9
            @Override // java.lang.Runnable
            public void run() {
                final String str;
                int i = CallOutActivity.this.seconds / 3600;
                int i2 = (CallOutActivity.this.seconds % 3600) / 60;
                int i3 = CallOutActivity.this.seconds % 60;
                if (i > 0) {
                    str = String.format(Locale.getDefault(), "%d:%02d:%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                } else {
                    str = String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.features.CallOut.CallOutActivity.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CallOutActivity.this.statusTextView.setText(str, false, false);
                    }
                });
                if (CallOutActivity.this.isCallAnswered) {
                    CallOutActivity.access$408(CallOutActivity.this);
                    CallOutActivity.this.handler.postDelayed(this, 1000L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCallState(Call.State state, String message, boolean isContinueCall) {
        if (state == Call.State.OutgoingInit) {
            Log.e(this.TAG, "OutgoingInit");
            this.statusTextView.setText(LocaleController.getString("Calling2", R.string.Calling2), true, true);
            return;
        }
        if (state == Call.State.OutgoingProgress) {
            Log.e(this.TAG, "OutgoingProgress");
            return;
        }
        if (state == Call.State.OutgoingEarlyMedia) {
            Log.e(this.TAG, "OutgoingEarlyMedia");
            return;
        }
        if (state == Call.State.Connected) {
            Log.e(this.TAG, "Connected");
            return;
        }
        if (state == Call.State.StreamsRunning) {
            if (!isContinueCall) {
                CallOutSingleton.getInstance().lastCallStartTime = System.currentTimeMillis();
            }
            Log.e(this.TAG, "StreamsRunning");
            this.isCallAnswered = true;
            startCallTimer();
            return;
        }
        if (state == Call.State.End) {
            Log.e(this.TAG, "End");
            this.statusTextView.setText(LocaleController.getString("End", R.string.End), true, true);
            Toast.makeText(this.actionBar.getContext(), LocaleController.getString("End", R.string.End), 1).show();
            return;
        }
        if (state == Call.State.Released) {
            Log.e(this.TAG, "Released");
            finishFragment();
            return;
        }
        if (state == Call.State.Paused) {
            Log.e(this.TAG, "Paused");
            this.statusTextView.setText(LocaleController.getString("CallPaused", R.string.CallPaused), true, true);
            return;
        }
        if (state == Call.State.Pausing) {
            Log.e(this.TAG, "Pausing");
            return;
        }
        if (state == Call.State.Error) {
            Log.e(this.TAG, "Error");
            if (message.contains("Service Unavailable")) {
                this.statusTextView.setText(message, true, true);
                Toast.makeText(this.actionBar.getContext(), LocaleController.getString("ServiceUnavailable", R.string.ServiceUnavailable), 1).show();
            } else if (message.contains("Busy Here")) {
                this.statusTextView.setText(LocaleController.getString("CallRejected", R.string.CallRejected), true, true);
                Toast.makeText(this.actionBar.getContext(), LocaleController.getString("CallRejected", R.string.CallRejected), 1).show();
            } else {
                this.statusTextView.setText(message, true, true);
                Toast.makeText(this.actionBar.getContext(), message, 1).show();
            }
        }
    }
}
