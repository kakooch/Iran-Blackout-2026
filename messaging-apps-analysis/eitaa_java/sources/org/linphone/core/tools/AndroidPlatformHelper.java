package org.linphone.core.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.view.Surface;
import android.view.TextureView;
import android.view.WindowManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.linphone.core.BuildConfig;
import org.linphone.core.tools.compatibility.DeviceUtils;
import org.linphone.core.tools.network.NetworkManager;
import org.linphone.core.tools.network.NetworkManagerAbove21;
import org.linphone.core.tools.network.NetworkManagerAbove23;
import org.linphone.core.tools.network.NetworkManagerAbove24;
import org.linphone.core.tools.network.NetworkManagerAbove26;
import org.linphone.core.tools.network.NetworkManagerInterface;
import org.linphone.core.tools.receiver.DozeReceiver;
import org.linphone.core.tools.receiver.InteractivityReceiver;
import org.linphone.core.tools.service.CoreManager;
import org.linphone.core.tools.service.PushService;
import org.linphone.mediastream.MediastreamerAndroidContext;
import org.linphone.mediastream.video.capture.CaptureTextureView;

/* loaded from: classes3.dex */
public class AndroidPlatformHelper {
    private static int mTempCountCPU;
    private static int mTempCountMCast;
    private static int mTempCountWifi;
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private String[] mDnsServers;
    private BroadcastReceiver mDozeReceiver;
    private InteractivityReceiver mInteractivityReceiver;
    private int mLastNetworkType = -1;
    private Handler mMainHandler;
    private WifiManager.MulticastLock mMcastLock;
    private boolean mMonitoringEnabled;
    private long mNativePtr;
    private NetworkManagerInterface mNetworkManager;
    private Map<Long, TextureView> mParticipantTextureView;
    private PowerManager mPowerManager;
    private TextureView mPreviewTextureView;
    private boolean mPushServiceStarted;
    private Resources mResources;
    private boolean mUsingHttpProxy;
    private TextureView mVideoTextureView;
    private PowerManager.WakeLock mWakeLock;
    private WifiManager.WifiLock mWifiLock;
    private boolean mWifiOnly;

    private native void enableKeepAlive(long j, boolean z);

    private native boolean isInBackground(long j);

    private native void setHttpProxy(long j, String str, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void setNativePreviewWindowId(long j, Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public native void setNativeVideoWindowId(long j, Object obj);

    private native void setNetworkReachable(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void setParticipantDeviceNativeVideoWindowId(long j, long j2, Object obj);

    private native boolean useSystemHttpProxy(long j);

    public AndroidPlatformHelper(long j, Object obj, boolean z) throws Resources.NotFoundException {
        this.mNativePtr = j;
        Context applicationContext = ((Context) obj).getApplicationContext();
        this.mContext = applicationContext;
        this.mWifiOnly = z;
        this.mDnsServers = null;
        this.mResources = applicationContext.getResources();
        this.mMainHandler = new Handler(this.mContext.getMainLooper());
        MediastreamerAndroidContext.setContext(this.mContext);
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("[Platform Helper] Created, wifi only mode is ");
        sb.append(this.mWifiOnly ? "enabled" : "disabled");
        objArr[0] = sb.toString();
        Log.i(objArr);
        WifiManager wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        PowerManager.WakeLock wakeLockNewWakeLock = this.mPowerManager.newWakeLock(1, "AndroidPlatformHelper");
        this.mWakeLock = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(true);
        WifiManager.MulticastLock multicastLockCreateMulticastLock = wifiManager.createMulticastLock("AndroidPlatformHelper");
        this.mMcastLock = multicastLockCreateMulticastLock;
        multicastLockCreateMulticastLock.setReferenceCounted(true);
        WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "AndroidPlatformHelper");
        this.mWifiLock = wifiLockCreateWifiLock;
        wifiLockCreateWifiLock.setReferenceCounted(true);
        try {
            copyAssetsFromPackage();
        } catch (IOException unused) {
            Log.e("[Platform Helper] failed to install some resources.");
        }
        if (DeviceUtils.isAppUserRestricted(this.mContext)) {
            Log.w("[Platform Helper] Device has been restricted by user (Android 9+), push notifications won't work !");
        }
        int appStandbyBucket = DeviceUtils.getAppStandbyBucket(this.mContext);
        if (appStandbyBucket > 0) {
            Log.w("[Platform Helper] Device is in bucket " + DeviceUtils.getAppStandbyBucketNameFromValue(appStandbyBucket));
        }
        createNetworkManager().updateDnsServers();
    }

    public synchronized void onLinphoneCoreStart(boolean z) {
        Log.i("[Platform Helper] onLinphoneCoreStart, network monitoring is " + z);
        this.mMonitoringEnabled = z;
        startNetworkMonitoring();
    }

    public synchronized void onLinphoneCoreStop() {
        Log.i("[Platform Helper] onLinphoneCoreStop, network monitoring is " + this.mMonitoringEnabled);
        setVideoPreviewView(null);
        setVideoRenderingView(null);
        while (this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
        while (this.mWifiLock.isHeld()) {
            this.mWifiLock.release();
        }
        while (this.mMcastLock.isHeld()) {
            this.mMcastLock.release();
        }
        this.mNativePtr = 0L;
        this.mMainHandler.removeCallbacksAndMessages(null);
        stopNetworkMonitoring();
    }

    public synchronized void onWifiOnlyEnabled(boolean z) {
        this.mWifiOnly = z;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("[Platform Helper] Wifi only mode is now ");
        sb.append(this.mWifiOnly ? "enabled" : "disabled");
        objArr[0] = sb.toString();
        Log.i(objArr);
        NetworkManagerInterface networkManagerInterface = this.mNetworkManager;
        if (networkManagerInterface != null) {
            networkManagerInterface.setWifiOnly(this.mWifiOnly);
        }
        updateNetworkReachability();
    }

    public synchronized Object getPowerManager() {
        return this.mPowerManager;
    }

    public synchronized String[] getDnsServers() {
        String str = "";
        for (String str2 : this.mDnsServers) {
            str = (str + str2) + ", ";
        }
        Log.i("[Platform Helper] getDnsServers() returning " + str);
        return this.mDnsServers;
    }

    public static String getDataPath(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/";
    }

    public static String getConfigPath(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/";
    }

    public String getCachePath() {
        return this.mContext.getCacheDir().getAbsolutePath() + "/";
    }

    public static String getDownloadPath(Context context) {
        String absolutePath;
        if (Environment.getExternalStorageState().equals("mounted")) {
            Log.i("[Platform Helper] External storage is mounted, using download directory");
            absolutePath = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        } else {
            absolutePath = null;
        }
        if (absolutePath == null) {
            Log.w("[Platform Helper] Couldn't get external storage path, using internal");
            absolutePath = context.getFilesDir().getAbsolutePath();
        }
        Log.i("[Platform Helper] Download directory is " + absolutePath + "/");
        return absolutePath + "/";
    }

    public String getNativeLibraryDir() {
        return this.mContext.getApplicationInfo().nativeLibraryDir;
    }

    public synchronized void acquireWifiLock() {
        mTempCountWifi++;
        Log.d("[Platform Helper] acquireWifiLock(). count = " + mTempCountWifi);
        if (!this.mWifiLock.isHeld()) {
            this.mWifiLock.acquire();
        }
    }

    public synchronized void releaseWifiLock() {
        mTempCountWifi--;
        Log.d("[Platform Helper] releaseWifiLock(). count = " + mTempCountWifi);
        if (this.mWifiLock.isHeld()) {
            this.mWifiLock.release();
        }
    }

    public synchronized void acquireMcastLock() {
        mTempCountMCast++;
        Log.d("[Platform Helper] acquireMcastLock(). count = " + mTempCountMCast);
        if (!this.mMcastLock.isHeld()) {
            this.mMcastLock.acquire();
        }
    }

    public synchronized void releaseMcastLock() {
        mTempCountMCast--;
        Log.d("[Platform Helper] releaseMcastLock(). count = " + mTempCountMCast);
        if (this.mMcastLock.isHeld()) {
            this.mMcastLock.release();
        }
    }

    public synchronized void acquireCpuLock() {
        mTempCountCPU++;
        Log.d("[Platform Helper] acquireCpuLock(). count = " + mTempCountCPU);
        if (!this.mWakeLock.isHeld()) {
            this.mWakeLock.acquire();
        }
    }

    public synchronized void releaseCpuLock() {
        mTempCountCPU--;
        Log.d("[Platform Helper] releaseCpuLock(). count = " + mTempCountCPU);
        if (this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
    }

    private int getResourceIdentifierFromName(String str) {
        int identifier = this.mResources.getIdentifier(str, "raw", this.mContext.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        Log.d("[Platform Helper] App doesn't seem to embed resource " + str + " in it's res/raw/ directory, use linphone's instead");
        int identifier2 = this.mResources.getIdentifier(str, "raw", "org.linphone");
        if (identifier2 == 0) {
            Log.d("[Platform Helper] App doesn't seem to embed resource " + str + " in it's res/raw/ directory. Make sure this file is either brought as an asset or a resource");
        }
        return identifier2;
    }

    private void copyAssetsFromPackage() throws Resources.NotFoundException, IOException {
        Log.i("[Platform Helper] Starting copy from assets to application files directory");
        copyAssetsFromPackage(this.mContext, BuildConfig.LIBRARY_PACKAGE_NAME, ".");
        Log.i("[Platform Helper] Copy from assets done");
        if (getResourceIdentifierFromName("cpim_grammar") != 0) {
            copyLegacyAssets();
        }
    }

    private void copyLegacyAssets() throws Resources.NotFoundException, IOException {
        Log.i("[Platform Helper] Starting to copy legacy assets");
        String absolutePath = this.mContext.getFilesDir().getAbsolutePath();
        String str = absolutePath + "/share/linphone/rootca.pem";
        String str2 = absolutePath + "/share/sounds/linphone/rings/notes_of_the_optimistic.mkv";
        String str3 = absolutePath + "/share/sounds/linphone/ringback.wav";
        String str4 = absolutePath + "/share/sounds/linphone/rings/dont_wait_too_long.mkv";
        String str5 = absolutePath + "/share/sounds/linphone/incoming_chat.wav";
        String str6 = absolutePath + "/share/belr/grammars/cpim_grammar";
        String str7 = absolutePath + "/share/belr/grammars/ics_grammar";
        String str8 = absolutePath + "/share/belr/grammars/identity_grammar";
        copyEvenIfExists(getResourceIdentifierFromName("cpim_grammar"), str6);
        copyEvenIfExists(getResourceIdentifierFromName("ics_grammar"), str7);
        copyEvenIfExists(getResourceIdentifierFromName("identity_grammar"), str8);
        copyEvenIfExists(getResourceIdentifierFromName("vcard_grammar"), absolutePath + "/share/belr/grammars/vcard_grammar");
        copyEvenIfExists(getResourceIdentifierFromName("rootca"), str);
        copyIfNotExist(getResourceIdentifierFromName("notes_of_the_optimistic"), str2);
        copyIfNotExist(getResourceIdentifierFromName("ringback"), str3);
        copyIfNotExist(getResourceIdentifierFromName("hold"), str4);
        copyIfNotExist(getResourceIdentifierFromName("incoming_chat"), str5);
        Log.i("[Platform Helper] Copy from legacy resources done");
    }

    public void copyEvenIfExists(int i, String str) throws Resources.NotFoundException, IOException {
        copyFromPackage(i, new File(str));
    }

    public void copyIfNotExist(int i, String str) throws Resources.NotFoundException, IOException {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        copyFromPackage(i, file);
    }

    public void copyFromPackage(int i, File file) throws Resources.NotFoundException, IOException {
        if (i == 0) {
            Log.i("[Platform Helper] Resource identifier null for target [" + file.getName() + "]");
            return;
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        InputStream inputStreamOpenRawResource = this.mResources.openRawResource(i);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[8048];
        while (true) {
            int i2 = inputStreamOpenRawResource.read(bArr);
            if (i2 != -1) {
                fileOutputStream.write(bArr, 0, i2);
            } else {
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStreamOpenRawResource.close();
                return;
            }
        }
    }

    public static void copyAssetsFromPackage(Context context, String str, String str2) throws IOException {
        new File(context.getFilesDir().getPath() + "/" + str2).mkdir();
        for (String str3 : context.getAssets().list(str)) {
            String str4 = str + "/" + str3;
            String str5 = str2 + "/" + str3;
            File file = new File(context.getFilesDir().getPath() + "/" + str5);
            try {
                if (file.exists() && (str3.endsWith(".wav") || str3.endsWith(".mkv"))) {
                    Log.i("[Platform Helper] Resource " + str3 + " already installed, skipping...");
                } else {
                    InputStream inputStreamOpen = context.getAssets().open(str4);
                    Log.i("[Platform Helper] Installing Resource " + str3);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[8048];
                    while (true) {
                        int i = inputStreamOpen.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStreamOpen.close();
                }
            } catch (IOException unused) {
                copyAssetsFromPackage(context, str4, str5);
            }
        }
    }

    public synchronized void setVideoPreviewView(Object obj) {
        if (this.mPreviewTextureView != null) {
            Log.w("[Platform Helper] Found an existing preview TextureView, let's destroy it first");
            this.mPreviewTextureView.setSurfaceTextureListener(null);
            this.mPreviewTextureView = null;
        }
        if (obj == null) {
            Log.i("[Platform Helper] Preview window surface set to null");
            setNativePreviewWindowId(this.mNativePtr, null);
            return;
        }
        if (obj instanceof Surface) {
            Log.i("[Platform Helper] Preview window surface is a Surface");
            setNativePreviewWindowId(this.mNativePtr, (Surface) obj);
            return;
        }
        if (obj instanceof SurfaceTexture) {
            Log.i("[Platform Helper] Preview window surface is a SurfaceTexture");
            setNativePreviewWindowId(this.mNativePtr, (SurfaceTexture) obj);
            return;
        }
        if (!(obj instanceof TextureView)) {
            throw new RuntimeException("[Platform Helper] Preview window id is not an instance of TextureView, Surface or SurfaceTexture. Please update your UI layer so that the preview video view is one of the above types (or an instance of it) or enable compatibility mode by setting displaytype=MSAndroidOpenGLDisplay in the [video] section your linphonerc factory configuration file so you can keep using your existing application code for managing video views.");
        }
        TextureView textureView = (TextureView) obj;
        this.mPreviewTextureView = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: org.linphone.core.tools.AndroidPlatformHelper.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.i("[Platform Helper] Preview window surface texture [" + surfaceTexture + "] is available for texture view [" + AndroidPlatformHelper.this.mPreviewTextureView + "]");
                AndroidPlatformHelper.this.rotateVideoPreview();
                AndroidPlatformHelper androidPlatformHelper = AndroidPlatformHelper.this;
                androidPlatformHelper.setNativePreviewWindowId(androidPlatformHelper.mNativePtr, AndroidPlatformHelper.this.mPreviewTextureView);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.i("[Platform Helper] Preview surface texture [" + surfaceTexture + "] size changed: " + i + "x" + i2);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.i("[Platform Helper] Preview surface texture [" + surfaceTexture + "] destroyed");
                if (AndroidPlatformHelper.this.mNativePtr != 0 && AndroidPlatformHelper.this.mPreviewTextureView != null && surfaceTexture.equals(AndroidPlatformHelper.this.mPreviewTextureView.getSurfaceTexture())) {
                    Log.i("[Platform Helper] Current preview surface texture is no longer available");
                    AndroidPlatformHelper.this.mPreviewTextureView = null;
                    AndroidPlatformHelper androidPlatformHelper = AndroidPlatformHelper.this;
                    androidPlatformHelper.setNativePreviewWindowId(androidPlatformHelper.mNativePtr, null);
                }
                if (!DeviceUtils.isSurfaceTextureReleased(surfaceTexture)) {
                    Log.i("[Platform Helper] Releasing preview window surface texture [" + surfaceTexture + "]");
                    surfaceTexture.release();
                }
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Log.d("[Platform Helper] Preview surface texture [" + surfaceTexture + "] has been updated");
            }
        });
        if (this.mPreviewTextureView.isAvailable()) {
            Log.i("[Platform Helper] Preview window surface is directly available for texture view [" + this.mPreviewTextureView + "]");
            rotateVideoPreview();
            setNativePreviewWindowId(this.mNativePtr, this.mPreviewTextureView);
        }
    }

    public synchronized void setVideoRenderingView(Object obj) {
        TextureView textureView = this.mVideoTextureView;
        if (textureView != null) {
            Log.w("[Platform Helper] Found an existing video TextureView [", textureView, "], let's destroy it first");
            this.mVideoTextureView.setSurfaceTextureListener(null);
            this.mVideoTextureView = null;
        }
        if (obj == null) {
            Log.i("[Platform Helper] Video window surface set to null");
            setNativeVideoWindowId(this.mNativePtr, null);
            return;
        }
        if (obj instanceof Surface) {
            Log.i("[Platform Helper] Video window surface is a Surface");
            setNativeVideoWindowId(this.mNativePtr, (Surface) obj);
            return;
        }
        if (obj instanceof SurfaceTexture) {
            Log.i("[Platform Helper] Video window surface is a SurfaceTexture");
            setNativeVideoWindowId(this.mNativePtr, (SurfaceTexture) obj);
            return;
        }
        if (!(obj instanceof TextureView)) {
            throw new RuntimeException("[Platform Helper] Rendering window id is not an instance of TextureView, Surface or SurfaceTexture. Please update your UI layer so that the video rendering view is an object of any above types (or an instance of it) or enable compatibility mode by setting displaytype=MSAndroidOpenGLDisplay in the [video] section your linphonerc factory configuration file so you can keep using your existing application code for managing video views.");
        }
        TextureView textureView2 = (TextureView) obj;
        this.mVideoTextureView = textureView2;
        textureView2.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: org.linphone.core.tools.AndroidPlatformHelper.2
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.i("[Platform Helper] Rendering window surface texture [" + surfaceTexture + "] is available for texture view [" + AndroidPlatformHelper.this.mVideoTextureView + "]");
                AndroidPlatformHelper androidPlatformHelper = AndroidPlatformHelper.this;
                androidPlatformHelper.setNativeVideoWindowId(androidPlatformHelper.mNativePtr, AndroidPlatformHelper.this.mVideoTextureView);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.i("[Platform Helper] Surface texture [" + surfaceTexture + "] size changed: " + i + "x" + i2);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.i("[Platform Helper] Rendering surface texture [" + surfaceTexture + "] destroyed");
                if (AndroidPlatformHelper.this.mNativePtr != 0 && AndroidPlatformHelper.this.mVideoTextureView != null && surfaceTexture.equals(AndroidPlatformHelper.this.mVideoTextureView.getSurfaceTexture())) {
                    Log.i("[Platform Helper] Current rendering surface texture is no longer available");
                    AndroidPlatformHelper.this.mVideoTextureView = null;
                    AndroidPlatformHelper androidPlatformHelper = AndroidPlatformHelper.this;
                    androidPlatformHelper.setNativeVideoWindowId(androidPlatformHelper.mNativePtr, null);
                }
                if (!DeviceUtils.isSurfaceTextureReleased(surfaceTexture)) {
                    Log.i("[Platform Helper] Releasing window surface texture [" + surfaceTexture + "]");
                    surfaceTexture.release();
                }
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Log.d("[Platform Helper] Surface texture [" + surfaceTexture + "] has been updated");
            }
        });
        if (this.mVideoTextureView.isAvailable()) {
            Log.i("[Platform Helper] Rendering window surface is directly available for texture view [" + this.mVideoTextureView + "]");
            setNativeVideoWindowId(this.mNativePtr, this.mVideoTextureView);
        }
    }

    public synchronized void setParticipantDeviceVideoRenderingView(final long j, Object obj) {
        if (this.mParticipantTextureView == null) {
            this.mParticipantTextureView = new HashMap();
        }
        if (this.mParticipantTextureView.containsKey(Long.valueOf(j))) {
            Log.w("[Platform Helper] Found an existing TextureView for participant device, let's destroy it first");
            this.mParticipantTextureView.get(Long.valueOf(j)).setSurfaceTextureListener(null);
            this.mParticipantTextureView.remove(Long.valueOf(j));
        }
        if (obj == null) {
            Log.i("[Platform Helper] Participant device video window surface set to null");
            setParticipantDeviceNativeVideoWindowId(this.mNativePtr, j, null);
            return;
        }
        if (obj instanceof Surface) {
            Log.i("[Platform Helper] Participant device video window surface is a Surface");
            setParticipantDeviceNativeVideoWindowId(this.mNativePtr, j, (Surface) obj);
            return;
        }
        if (obj instanceof SurfaceTexture) {
            Log.i("[Platform Helper] Participant device video window surface is a SurfaceTexture");
            setParticipantDeviceNativeVideoWindowId(this.mNativePtr, j, (SurfaceTexture) obj);
            return;
        }
        if (!(obj instanceof TextureView)) {
            throw new RuntimeException("[Platform Helper] Rendering window id is not an instance of TextureView, Surface or SurfaceTexture. Please update your UI layer so that the video rendering view is an object of any above types (or an instance of it) or enable compatibility mode by setting displaytype=MSAndroidOpenGLDisplay in the [video] section your linphonerc factory configuration file so you can keep using your existing application code for managing video views.");
        }
        this.mParticipantTextureView.put(Long.valueOf(j), (TextureView) obj);
        this.mParticipantTextureView.get(Long.valueOf(j)).setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: org.linphone.core.tools.AndroidPlatformHelper.3
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.i("[Platform Helper] Rendering window surface texture [" + surfaceTexture + "] is available for texture view [" + AndroidPlatformHelper.this.mParticipantTextureView.get(Long.valueOf(j)) + "]");
                AndroidPlatformHelper androidPlatformHelper = AndroidPlatformHelper.this;
                androidPlatformHelper.setParticipantDeviceNativeVideoWindowId(androidPlatformHelper.mNativePtr, j, AndroidPlatformHelper.this.mParticipantTextureView.get(Long.valueOf(j)));
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.i("[Platform Helper] Surface texture [" + surfaceTexture + "] size changed: " + i + "x" + i2);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.w("[Platform Helper] TextureView [" + surfaceTexture + "] for participant device has been destroyed");
                AndroidPlatformHelper.this.mParticipantTextureView.remove(Long.valueOf(j));
                AndroidPlatformHelper androidPlatformHelper = AndroidPlatformHelper.this;
                androidPlatformHelper.setParticipantDeviceNativeVideoWindowId(androidPlatformHelper.mNativePtr, j, null);
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Log.d("[Platform Helper] Surface texture [" + surfaceTexture + "] has been updated");
            }
        });
        if (this.mParticipantTextureView.get(Long.valueOf(j)).isAvailable()) {
            Log.i("[Platform Helper] Rendering participant device window surface is directly available for texture view [" + this.mParticipantTextureView.get(Long.valueOf(j)) + "]");
            setParticipantDeviceNativeVideoWindowId(this.mNativePtr, j, this.mParticipantTextureView.get(Long.valueOf(j)));
        } else {
            Log.i("[Platform Helper] Rendering participant device window surface is not available !");
        }
    }

    public synchronized void rotateVideoPreview() {
        TextureView textureView = this.mPreviewTextureView;
        if (textureView != null && (textureView instanceof CaptureTextureView)) {
            Log.i("[Platform Helper] Found CaptureTextureView, rotating...");
            ((CaptureTextureView) this.mPreviewTextureView).rotateToMatchDisplayOrientation(((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation() * 90);
        } else if (textureView != null) {
            Log.w("[Platform Helper] It seems you are using a TextureView instead of our CaptureTextureView, we strongly advise you to use ours to benefit from correct rotation & ratio");
        }
    }

    public synchronized void resizeVideoPreview(int i, int i2) {
        TextureView textureView = this.mPreviewTextureView;
        if (textureView != null && (textureView instanceof CaptureTextureView)) {
            Log.i("[Platform Helper] Found CaptureTextureView, setting video capture size to " + i + "x" + i2);
            ((CaptureTextureView) this.mPreviewTextureView).setAspectRatio(i, i2);
        } else if (textureView != null) {
            Log.w("[Platform Helper] It seems you are using a TextureView instead of our CaptureTextureView, we strongly advise you to use ours to benefit from correct rotation & ratio");
        }
    }

    public synchronized Handler getHandler() {
        return this.mMainHandler;
    }

    public synchronized boolean isInBackground() {
        if (CoreManager.isReady() && CoreManager.instance().isServiceRunningAsForeground()) {
            Log.i("[Platform Helper] CoreService seems to be running as foreground, consider app is in foreground");
            return false;
        }
        return isInBackground(this.mNativePtr);
    }

    private String networkTypeToString(int i) {
        return i != 0 ? i != 1 ? i != 7 ? i != 9 ? i != 17 ? String.valueOf(i) : "VPN" : "ETHERNET" : "BLUETOOTH" : "WIFI" : "MOBILE";
    }

    public synchronized void updateDnsServers(ArrayList<String> arrayList) {
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                String[] strArr = new String[arrayList.size()];
                this.mDnsServers = strArr;
                arrayList.toArray(strArr);
                Log.i("[Platform Helper] DNS servers list updated");
            }
        }
    }

    public synchronized boolean isActiveNetworkWifiOnlyCompliant() {
        NetworkManagerInterface networkManagerInterface = this.mNetworkManager;
        if (networkManagerInterface == null) {
            Log.w("[Platform Helper] Network Manager is null, assuming network isn't WiFi only compliant");
            return false;
        }
        NetworkInfo activeNetworkInfo = networkManagerInterface.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            Log.i("[Platform Helper] Active network type is " + activeNetworkInfo.getTypeName());
            if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
                return true;
            }
        } else {
            Log.w("[Platform Helper] Active network info is null, assuming network isn't WiFi only compliant");
        }
        return false;
    }

    public synchronized void updateNetworkReachability() {
        if (this.mNativePtr == 0) {
            Log.w("[Platform Helper] Native pointer has been reset, stopping there");
            return;
        }
        NetworkManagerInterface networkManagerInterface = this.mNetworkManager;
        if (networkManagerInterface == null) {
            Log.w("[Platform Helper] Network Manager is null, stopping there");
            return;
        }
        if (!networkManagerInterface.isCurrentlyConnected(this.mContext)) {
            Log.i("[Platform Helper] No connectivity: setting network unreachable");
            setNetworkReachable(this.mNativePtr, false);
            return;
        }
        if (this.mNetworkManager.hasHttpProxy(this.mContext)) {
            if (useSystemHttpProxy(this.mNativePtr)) {
                setHttpProxy(this.mNativePtr, this.mNetworkManager.getProxyHost(this.mContext), this.mNetworkManager.getProxyPort(this.mContext));
                if (!this.mUsingHttpProxy) {
                    Log.i("[Platform Helper] Proxy wasn't set before, disabling network reachability first");
                    setNetworkReachable(this.mNativePtr, false);
                }
                this.mUsingHttpProxy = true;
            } else {
                Log.w("[Platform Helper] Proxy available but forbidden by linphone core [sip] use_system_http_proxy setting");
            }
        } else {
            setHttpProxy(this.mNativePtr, "", 0);
            if (this.mUsingHttpProxy) {
                Log.i("[Platform Helper] Proxy was set before, disabling network reachability first");
                setNetworkReachable(this.mNativePtr, false);
            }
            this.mUsingHttpProxy = false;
        }
        NetworkInfo activeNetworkInfo = this.mNetworkManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            Log.e("[Platform Helper] getActiveNetworkInfo() returned null !");
            setNetworkReachable(this.mNativePtr, false);
            return;
        }
        Log.i("[Platform Helper] Active network type is " + activeNetworkInfo.getTypeName() + ", state " + activeNetworkInfo.getState() + " / " + activeNetworkInfo.getDetailedState());
        if (activeNetworkInfo.getState() == NetworkInfo.State.DISCONNECTED && activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) {
            Log.w("[Platform Helper] Active network is in bad state...");
        }
        this.mNetworkManager.updateDnsServers();
        int type = activeNetworkInfo.getType();
        int i = this.mLastNetworkType;
        if (i != -1 && i != type) {
            Log.i("[Platform Helper] Network type has changed (last one was " + networkTypeToString(this.mLastNetworkType) + "), disabling network reachability first");
            setNetworkReachable(this.mNativePtr, false);
        }
        this.mLastNetworkType = type;
        Log.i("[Platform Helper] Network reachability enabled");
        setNetworkReachable(this.mNativePtr, true);
    }

    private NetworkManagerInterface createNetworkManager() {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return new NetworkManager(this, this.mConnectivityManager, this.mWifiOnly);
        }
        if (i < 23) {
            return new NetworkManagerAbove21(this, this.mConnectivityManager, this.mWifiOnly);
        }
        if (i < 24) {
            return new NetworkManagerAbove23(this, this.mConnectivityManager, this.mWifiOnly);
        }
        if (i < 26) {
            return new NetworkManagerAbove24(this, this.mConnectivityManager, this.mWifiOnly);
        }
        return new NetworkManagerAbove26(this, this.mConnectivityManager, this.mWifiOnly);
    }

    private synchronized void startNetworkMonitoring() {
        if (this.mMonitoringEnabled) {
            this.mNetworkManager = createNetworkManager();
            Log.i("[Platform Helper] Registering network callbacks");
            this.mNetworkManager.registerNetworkCallbacks(this.mContext);
            if (Build.VERSION.SDK_INT >= 23) {
                IntentFilter intentFilter = new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED");
                this.mDozeReceiver = new DozeReceiver();
                Log.i("[Platform Helper] Registering doze receiver");
                this.mContext.registerReceiver(this.mDozeReceiver, intentFilter);
            }
            this.mInteractivityReceiver = new InteractivityReceiver();
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter2.addAction("android.intent.action.SCREEN_OFF");
            Log.i("[Platform Helper] Registering interactivity receiver");
            this.mContext.registerReceiver(this.mInteractivityReceiver, intentFilter2);
            updateNetworkReachability();
        }
    }

    private synchronized void stopNetworkMonitoring() {
        if (this.mInteractivityReceiver != null) {
            Log.i("[Platform Helper] Unregistering interactivity receiver");
            this.mContext.unregisterReceiver(this.mInteractivityReceiver);
            this.mInteractivityReceiver = null;
        }
        if (this.mNetworkManager != null && this.mConnectivityManager != null) {
            Log.i("[Platform Helper] Unregistering network callbacks");
            this.mNetworkManager.unregisterNetworkCallbacks(this.mContext);
            this.mNetworkManager = null;
        }
        if (this.mDozeReceiver != null) {
            Log.i("[Platform Helper] Unregistering doze receiver");
            this.mContext.unregisterReceiver(this.mDozeReceiver);
            this.mDozeReceiver = null;
        }
        this.mMonitoringEnabled = false;
    }

    public synchronized void disableAudioRouteChanges(boolean z) {
        if (z) {
            Log.i("[Platform Helper] Disabling audio route changes in mediastreamer2");
        } else {
            Log.i("[Platform Helper] Enabling audio route changes in mediastreamer2");
        }
        MediastreamerAndroidContext.disableAudioRouteChanges(z);
    }

    public synchronized void startPushService() {
        if (!this.mNetworkManager.isCurrentlyConnected(this.mContext)) {
            Log.i("[Platform Helper] Push has been received but network seems unreachable, starting foreground push service");
            DeviceUtils.startForegroundService(this.mContext, new Intent(this.mContext, (Class<?>) PushService.class));
            this.mPushServiceStarted = true;
        }
    }

    public synchronized void stopPushService() {
        if (this.mPushServiceStarted) {
            Log.i("[Platform Helper] Foreground push service is no longer required");
            this.mContext.stopService(new Intent(this.mContext, (Class<?>) PushService.class));
            this.mPushServiceStarted = false;
        }
    }
}
