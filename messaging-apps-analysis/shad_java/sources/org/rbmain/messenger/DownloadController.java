package org.rbmain.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Pair;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_account_autoDownloadSettings;
import org.rbmain.tgnet.TLRPC$TL_account_saveAutoDownloadSettings;
import org.rbmain.tgnet.TLRPC$TL_autoDownloadSettings;
import org.rbmain.tgnet.TLRPC$TL_error;

/* loaded from: classes.dex */
public class DownloadController extends BaseController implements NotificationCenter.NotificationCenterDelegate {
    public static final int AUTODOWNLOAD_TYPE_AUDIO = 2;
    public static final int AUTODOWNLOAD_TYPE_DOCUMENT = 8;
    public static final int AUTODOWNLOAD_TYPE_PHOTO = 1;
    public static final int AUTODOWNLOAD_TYPE_VIDEO = 4;
    private static volatile DownloadController[] Instance = new DownloadController[3];
    public static final int PRESET_NUM_CHANNEL = 3;
    public static final int PRESET_NUM_CONTACT = 0;
    public static final int PRESET_NUM_GROUP = 2;
    public static final int PRESET_NUM_PM = 1;
    public static final int PRESET_SIZE_NUM_AUDIO = 3;
    public static final int PRESET_SIZE_NUM_DOCUMENT = 2;
    public static final int PRESET_SIZE_NUM_PHOTO = 0;
    public static final int PRESET_SIZE_NUM_VIDEO = 1;
    private HashMap<String, FileDownloadProgressListener> addLaterArray;
    private ArrayList<DownloadObject> audioDownloadQueue;
    public int currentMobilePreset;
    public int currentRoamingPreset;
    public int currentWifiPreset;
    private ArrayList<FileDownloadProgressListener> deleteLaterArray;
    private ArrayList<DownloadObject> documentDownloadQueue;
    private HashMap<String, DownloadObject> downloadQueueKeys;
    private HashMap<Pair<Long, Integer>, DownloadObject> downloadQueuePairs;
    public final ArrayList<MessageObject> downloadingFiles;
    public Preset highPreset;
    private int lastCheckMask;
    private int lastTag;
    private boolean listenerInProgress;
    private boolean loadingAutoDownloadConfig;
    private HashMap<String, ArrayList<MessageObject>> loadingFileMessagesObservers;
    private HashMap<String, ArrayList<WeakReference<FileDownloadProgressListener>>> loadingFileObservers;
    public Preset lowPreset;
    public Preset mediumPreset;
    public Preset mobilePreset;
    private SparseArray<String> observersByTag;
    private ArrayList<DownloadObject> photoDownloadQueue;
    public final ArrayList<MessageObject> recentDownloadingFiles;
    public Preset roamingPreset;
    private LongSparseArray<Long> typingTimes;
    public final SparseArray<MessageObject> unviewedDownloads;
    private ArrayList<DownloadObject> videoDownloadQueue;
    public Preset wifiPreset;

    /* loaded from: classes4.dex */
    public interface FileDownloadProgressListener {
        int getObserverTag();

        void onFailedDownload(String str, boolean z);

        void onProgressDownload(String str, long j, long j2);

        void onProgressUpload(String str, long j, long j2, boolean z);

        void onSuccessDownload(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$savePresetToServer$3(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public static int typeToIndex(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 4) {
            return 1;
        }
        return i == 8 ? 2 : 0;
    }

    /* loaded from: classes4.dex */
    public static class Preset {
        public boolean enabled;
        public boolean lessCallData;
        public int[] mask;
        public int maxVideoBitrate;
        public boolean preloadMusic;
        public boolean preloadVideo;
        public int[] sizes;

        public Preset(int[] iArr, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, int i4) {
            int[] iArr2 = new int[4];
            this.mask = iArr2;
            this.sizes = new int[4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            int[] iArr3 = this.sizes;
            iArr3[0] = i;
            iArr3[1] = i2;
            iArr3[2] = i3;
            iArr3[3] = 524288;
            this.preloadVideo = z;
            this.preloadMusic = z2;
            this.lessCallData = z4;
            this.maxVideoBitrate = i4;
            this.enabled = z3;
        }

        public Preset(String str, String str2) {
            String[] strArrSplit;
            this.mask = new int[4];
            this.sizes = new int[4];
            String[] strArrSplit2 = str.split("_");
            if (strArrSplit2.length >= 11) {
                this.mask[0] = Utilities.parseInt(strArrSplit2[0]).intValue();
                this.mask[1] = Utilities.parseInt(strArrSplit2[1]).intValue();
                this.mask[2] = Utilities.parseInt(strArrSplit2[2]).intValue();
                this.mask[3] = Utilities.parseInt(strArrSplit2[3]).intValue();
                this.sizes[0] = Utilities.parseInt(strArrSplit2[4]).intValue();
                this.sizes[1] = Utilities.parseInt(strArrSplit2[5]).intValue();
                this.sizes[2] = Utilities.parseInt(strArrSplit2[6]).intValue();
                this.sizes[3] = Utilities.parseInt(strArrSplit2[7]).intValue();
                this.preloadVideo = Utilities.parseInt(strArrSplit2[8]).intValue() == 1;
                this.preloadMusic = Utilities.parseInt(strArrSplit2[9]).intValue() == 1;
                this.enabled = Utilities.parseInt(strArrSplit2[10]).intValue() == 1;
                if (strArrSplit2.length >= 12) {
                    this.lessCallData = Utilities.parseInt(strArrSplit2[11]).intValue() == 1;
                    strArrSplit = null;
                } else {
                    strArrSplit = str2.split("_");
                    this.lessCallData = Utilities.parseInt(strArrSplit[11]).intValue() == 1;
                }
                if (strArrSplit2.length >= 13) {
                    this.maxVideoBitrate = Utilities.parseInt(strArrSplit2[12]).intValue();
                } else {
                    this.maxVideoBitrate = Utilities.parseInt((strArrSplit == null ? str2.split("_") : strArrSplit)[12]).intValue();
                }
            }
        }

        public void set(Preset preset) {
            int[] iArr = preset.mask;
            int[] iArr2 = this.mask;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            int[] iArr3 = preset.sizes;
            int[] iArr4 = this.sizes;
            System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
            this.preloadVideo = preset.preloadVideo;
            this.preloadMusic = preset.preloadMusic;
            this.lessCallData = preset.lessCallData;
            this.maxVideoBitrate = preset.maxVideoBitrate;
        }

        public void set(TLRPC$TL_autoDownloadSettings tLRPC$TL_autoDownloadSettings) {
            this.preloadMusic = tLRPC$TL_autoDownloadSettings.audio_preload_next;
            this.preloadVideo = tLRPC$TL_autoDownloadSettings.video_preload_large;
            this.lessCallData = tLRPC$TL_autoDownloadSettings.phonecalls_less_data;
            this.maxVideoBitrate = tLRPC$TL_autoDownloadSettings.video_upload_maxbitrate;
            int i = 0;
            this.sizes[0] = Math.max(512000, tLRPC$TL_autoDownloadSettings.photo_size_max);
            this.sizes[1] = Math.max(512000, tLRPC$TL_autoDownloadSettings.video_size_max);
            this.sizes[2] = Math.max(512000, tLRPC$TL_autoDownloadSettings.file_size_max);
            while (true) {
                int[] iArr = this.mask;
                if (i >= iArr.length) {
                    return;
                }
                if (tLRPC$TL_autoDownloadSettings.photo_size_max != 0 && !tLRPC$TL_autoDownloadSettings.disabled) {
                    iArr[i] = iArr[i] | 1;
                } else {
                    iArr[i] = iArr[i] & (-2);
                }
                if (tLRPC$TL_autoDownloadSettings.video_size_max != 0 && !tLRPC$TL_autoDownloadSettings.disabled) {
                    iArr[i] = iArr[i] | 4;
                } else {
                    iArr[i] = iArr[i] & (-5);
                }
                if (tLRPC$TL_autoDownloadSettings.file_size_max != 0 && !tLRPC$TL_autoDownloadSettings.disabled) {
                    iArr[i] = iArr[i] | 8;
                } else {
                    iArr[i] = iArr[i] & (-9);
                }
                i++;
            }
        }

        public String toString() {
            return this.mask[0] + "_" + this.mask[1] + "_" + this.mask[2] + "_" + this.mask[3] + "_" + this.sizes[0] + "_" + this.sizes[1] + "_" + this.sizes[2] + "_" + this.sizes[3] + "_" + (this.preloadVideo ? 1 : 0) + "_" + (this.preloadMusic ? 1 : 0) + "_" + (this.enabled ? 1 : 0) + "_" + (this.lessCallData ? 1 : 0) + "_" + this.maxVideoBitrate;
        }

        public boolean equals(Preset preset) {
            int[] iArr = this.mask;
            int i = iArr[0];
            int[] iArr2 = preset.mask;
            if (i != iArr2[0] || iArr[1] != iArr2[1] || iArr[2] != iArr2[2] || iArr[3] != iArr2[3]) {
                return false;
            }
            int[] iArr3 = this.sizes;
            int i2 = iArr3[0];
            int[] iArr4 = preset.sizes;
            return i2 == iArr4[0] && iArr3[1] == iArr4[1] && iArr3[2] == iArr4[2] && iArr3[3] == iArr4[3] && this.preloadVideo == preset.preloadVideo && this.preloadMusic == preset.preloadMusic && this.maxVideoBitrate == preset.maxVideoBitrate;
        }

        public boolean isEnabled() {
            int i = 0;
            while (true) {
                int[] iArr = this.mask;
                if (i >= iArr.length) {
                    return false;
                }
                if (iArr[i] != 0) {
                    return true;
                }
                i++;
            }
        }
    }

    public static DownloadController getInstance(int i) {
        DownloadController downloadController = Instance[i];
        if (downloadController == null) {
            synchronized (DownloadController.class) {
                downloadController = Instance[i];
                if (downloadController == null) {
                    DownloadController[] downloadControllerArr = Instance;
                    DownloadController downloadController2 = new DownloadController(i);
                    downloadControllerArr[i] = downloadController2;
                    downloadController = downloadController2;
                }
            }
        }
        return downloadController;
    }

    public DownloadController(int i) {
        Object obj;
        super(i);
        this.lastCheckMask = 0;
        this.photoDownloadQueue = new ArrayList<>();
        this.audioDownloadQueue = new ArrayList<>();
        this.documentDownloadQueue = new ArrayList<>();
        this.videoDownloadQueue = new ArrayList<>();
        this.downloadQueueKeys = new HashMap<>();
        this.downloadQueuePairs = new HashMap<>();
        this.loadingFileObservers = new HashMap<>();
        this.loadingFileMessagesObservers = new HashMap<>();
        this.observersByTag = new SparseArray<>();
        this.listenerInProgress = false;
        this.addLaterArray = new HashMap<>();
        this.deleteLaterArray = new ArrayList<>();
        this.lastTag = 0;
        this.typingTimes = new LongSparseArray<>();
        this.downloadingFiles = new ArrayList<>();
        this.recentDownloadingFiles = new ArrayList<>();
        this.unviewedDownloads = new SparseArray<>();
        SharedPreferences mainSettings = MessagesController.getMainSettings(this.currentAccount);
        this.lowPreset = new Preset(mainSettings.getString("preset0", "1_1_1_1_1048576_512000_512000_524288_0_0_1_1_50"), "1_1_1_1_1048576_512000_512000_524288_0_0_1_1_50");
        this.mediumPreset = new Preset(mainSettings.getString("preset1", "13_13_13_13_1048576_10485760_1048576_524288_1_1_1_0_100"), "13_13_13_13_1048576_10485760_1048576_524288_1_1_1_0_100");
        this.highPreset = new Preset(mainSettings.getString("preset2", "13_13_13_13_1048576_15728640_3145728_524288_1_1_1_0_100"), "13_13_13_13_1048576_15728640_3145728_524288_1_1_1_0_100");
        boolean zContains = mainSettings.contains("newConfig");
        String str = "currentWifiPreset";
        if (zContains || !getUserConfig().isClientActivated()) {
            this.mobilePreset = new Preset(mainSettings.getString("mobilePreset", "13_13_13_13_1048576_10485760_1048576_524288_1_1_1_0_100"), "13_13_13_13_1048576_10485760_1048576_524288_1_1_1_0_100");
            this.wifiPreset = new Preset(mainSettings.getString("wifiPreset", "13_13_13_13_1048576_15728640_3145728_524288_1_1_1_0_100"), "13_13_13_13_1048576_15728640_3145728_524288_1_1_1_0_100");
            this.roamingPreset = new Preset(mainSettings.getString("roamingPreset", "1_1_1_1_1048576_512000_512000_524288_0_0_1_1_50"), "1_1_1_1_1048576_512000_512000_524288_0_0_1_1_50");
            this.currentMobilePreset = mainSettings.getInt("currentMobilePreset", 3);
            this.currentWifiPreset = mainSettings.getInt("currentWifiPreset", 3);
            this.currentRoamingPreset = mainSettings.getInt("currentRoamingPreset", 3);
            if (!zContains) {
                mainSettings.edit().putBoolean("newConfig", true).apply();
            }
        } else {
            int[] iArr = new int[4];
            int[] iArr2 = new int[4];
            int[] iArr3 = new int[4];
            int[] iArr4 = new int[7];
            int[] iArr5 = new int[7];
            int[] iArr6 = new int[7];
            int i2 = 0;
            for (int i3 = 4; i2 < i3; i3 = 4) {
                StringBuilder sb = new StringBuilder();
                String str2 = str;
                sb.append("mobileDataDownloadMask");
                Object obj2 = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                if (i2 == 0) {
                    obj = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                } else {
                    Integer numValueOf = Integer.valueOf(i2);
                    obj = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                    obj2 = numValueOf;
                }
                sb.append(obj2);
                String string = sb.toString();
                if (i2 == 0 || mainSettings.contains(string)) {
                    iArr[i2] = mainSettings.getInt(string, 13);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("wifiDownloadMask");
                    sb2.append(i2 == 0 ? obj : Integer.valueOf(i2));
                    iArr2[i2] = mainSettings.getInt(sb2.toString(), 13);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("roamingDownloadMask");
                    sb3.append(i2 == 0 ? obj : Integer.valueOf(i2));
                    iArr3[i2] = mainSettings.getInt(sb3.toString(), 1);
                } else {
                    iArr[i2] = iArr[0];
                    iArr2[i2] = iArr2[0];
                    iArr3[i2] = iArr3[0];
                }
                i2++;
                str = str2;
            }
            iArr4[2] = mainSettings.getInt("mobileMaxDownloadSize2", this.mediumPreset.sizes[1]);
            iArr4[3] = mainSettings.getInt("mobileMaxDownloadSize3", this.mediumPreset.sizes[2]);
            iArr5[2] = mainSettings.getInt("wifiMaxDownloadSize2", this.highPreset.sizes[1]);
            iArr5[3] = mainSettings.getInt("wifiMaxDownloadSize3", this.highPreset.sizes[2]);
            iArr6[2] = mainSettings.getInt("roamingMaxDownloadSize2", this.lowPreset.sizes[1]);
            iArr6[3] = mainSettings.getInt("roamingMaxDownloadSize3", this.lowPreset.sizes[2]);
            boolean z = mainSettings.getBoolean("globalAutodownloadEnabled", true);
            this.mobilePreset = new Preset(iArr, this.mediumPreset.sizes[0], iArr4[2], iArr4[3], true, true, z, false, 100);
            this.wifiPreset = new Preset(iArr2, this.highPreset.sizes[0], iArr5[2], iArr5[3], true, true, z, false, 100);
            this.roamingPreset = new Preset(iArr3, this.lowPreset.sizes[0], iArr6[2], iArr6[3], false, false, z, true, 50);
            SharedPreferences.Editor editorEdit = mainSettings.edit();
            editorEdit.putBoolean("newConfig", true);
            editorEdit.putString("mobilePreset", this.mobilePreset.toString());
            editorEdit.putString("wifiPreset", this.wifiPreset.toString());
            editorEdit.putString("roamingPreset", this.roamingPreset.toString());
            this.currentMobilePreset = 3;
            editorEdit.putInt("currentMobilePreset", 3);
            this.currentWifiPreset = 3;
            editorEdit.putInt(str, 3);
            this.currentRoamingPreset = 3;
            editorEdit.putInt("currentRoamingPreset", 3);
            editorEdit.apply();
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.DownloadController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        });
        ApplicationLoader.applicationContext.registerReceiver(new BroadcastReceiver() { // from class: org.rbmain.messenger.DownloadController.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                DownloadController.this.checkAutodownloadSettings();
            }
        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        if (getUserConfig().isClientActivated()) {
            checkAutodownloadSettings();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        getNotificationCenter().addObserver(this, NotificationCenter.fileDidFailToLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.fileDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.FileLoadProgressChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.FileUploadProgressChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.httpFileDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.httpFileDidFailedLoad);
        loadAutoDownloadConfig(false);
    }

    public void loadAutoDownloadConfig(boolean z) {
        if (this.loadingAutoDownloadConfig) {
            return;
        }
        if (z || Math.abs(System.currentTimeMillis() - getUserConfig().autoDownloadConfigLoadTime) >= 86400000) {
            this.loadingAutoDownloadConfig = true;
            getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_account_getAutoDownloadSettings
                public static int constructor = 1457130303;

                @Override // org.rbmain.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z2) {
                    return TLRPC$TL_account_autoDownloadSettings.TLdeserialize(abstractSerializedData, i, z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: org.rbmain.messenger.DownloadController$$ExternalSyntheticLambda2
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadAutoDownloadConfig$2(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAutoDownloadConfig$2(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.DownloadController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAutoDownloadConfig$1(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAutoDownloadConfig$1(TLObject tLObject) {
        Preset preset;
        this.loadingAutoDownloadConfig = false;
        getUserConfig().autoDownloadConfigLoadTime = System.currentTimeMillis();
        getUserConfig().saveConfig(false);
        if (tLObject != null) {
            TLRPC$TL_account_autoDownloadSettings tLRPC$TL_account_autoDownloadSettings = (TLRPC$TL_account_autoDownloadSettings) tLObject;
            this.lowPreset.set(tLRPC$TL_account_autoDownloadSettings.low);
            this.mediumPreset.set(tLRPC$TL_account_autoDownloadSettings.medium);
            this.highPreset.set(tLRPC$TL_account_autoDownloadSettings.high);
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    preset = this.mobilePreset;
                } else if (i == 1) {
                    preset = this.wifiPreset;
                } else {
                    preset = this.roamingPreset;
                }
                if (preset.equals(this.lowPreset)) {
                    preset.set(tLRPC$TL_account_autoDownloadSettings.low);
                } else if (preset.equals(this.mediumPreset)) {
                    preset.set(tLRPC$TL_account_autoDownloadSettings.medium);
                } else if (preset.equals(this.highPreset)) {
                    preset.set(tLRPC$TL_account_autoDownloadSettings.high);
                }
            }
            SharedPreferences.Editor editorEdit = MessagesController.getMainSettings(this.currentAccount).edit();
            editorEdit.putString("mobilePreset", this.mobilePreset.toString());
            editorEdit.putString("wifiPreset", this.wifiPreset.toString());
            editorEdit.putString("roamingPreset", this.roamingPreset.toString());
            editorEdit.putString("preset0", this.lowPreset.toString());
            editorEdit.putString("preset1", this.mediumPreset.toString());
            editorEdit.putString("preset2", this.highPreset.toString());
            editorEdit.apply();
            this.lowPreset.toString();
            this.mediumPreset.toString();
            this.highPreset.toString();
            checkAutodownloadSettings();
        }
    }

    public Preset getCurrentMobilePreset() {
        int i = this.currentMobilePreset;
        if (i == 0) {
            return this.lowPreset;
        }
        if (i == 1) {
            return this.mediumPreset;
        }
        if (i == 2) {
            return this.highPreset;
        }
        return this.mobilePreset;
    }

    public Preset getCurrentWiFiPreset() {
        int i = this.currentWifiPreset;
        if (i == 0) {
            return this.lowPreset;
        }
        if (i == 1) {
            return this.mediumPreset;
        }
        if (i == 2) {
            return this.highPreset;
        }
        return this.wifiPreset;
    }

    public Preset getCurrentRoamingPreset() {
        int i = this.currentRoamingPreset;
        if (i == 0) {
            return this.lowPreset;
        }
        if (i == 1) {
            return this.mediumPreset;
        }
        if (i == 2) {
            return this.highPreset;
        }
        return this.roamingPreset;
    }

    public void cleanup() {
        this.photoDownloadQueue.clear();
        this.audioDownloadQueue.clear();
        this.documentDownloadQueue.clear();
        this.videoDownloadQueue.clear();
        this.downloadQueueKeys.clear();
        this.downloadQueuePairs.clear();
        this.typingTimes.clear();
    }

    public int getMaxVideoBitrate() {
        int autodownloadNetworkType = ApplicationLoader.getAutodownloadNetworkType();
        if (autodownloadNetworkType == 1) {
            return getCurrentWiFiPreset().maxVideoBitrate;
        }
        if (autodownloadNetworkType == 2) {
            return getCurrentRoamingPreset().maxVideoBitrate;
        }
        return getCurrentMobilePreset().maxVideoBitrate;
    }

    public int getAutodownloadMask() {
        int[] iArr;
        int autodownloadNetworkType = ApplicationLoader.getAutodownloadNetworkType();
        if (autodownloadNetworkType == 1) {
            if (!this.wifiPreset.enabled) {
                return 0;
            }
            iArr = getCurrentWiFiPreset().mask;
        } else if (autodownloadNetworkType == 2) {
            if (!this.roamingPreset.enabled) {
                return 0;
            }
            iArr = getCurrentRoamingPreset().mask;
        } else {
            if (!this.mobilePreset.enabled) {
                return 0;
            }
            iArr = getCurrentMobilePreset().mask;
        }
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = (iArr[i2] & 1) != 0 ? 1 : 0;
            if ((iArr[i2] & 2) != 0) {
                i3 |= 2;
            }
            if ((iArr[i2] & 4) != 0) {
                i3 |= 4;
            }
            if ((iArr[i2] & 8) != 0) {
                i3 |= 8;
            }
            i |= i3 << (i2 * 8);
        }
        return i;
    }

    protected int getAutodownloadMaskAll() {
        if (!this.mobilePreset.enabled && !this.roamingPreset.enabled && !this.wifiPreset.enabled) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            if ((getCurrentMobilePreset().mask[i2] & 1) != 0 || (getCurrentWiFiPreset().mask[i2] & 1) != 0 || (getCurrentRoamingPreset().mask[i2] & 1) != 0) {
                i |= 1;
            }
            if ((getCurrentMobilePreset().mask[i2] & 2) != 0 || (getCurrentWiFiPreset().mask[i2] & 2) != 0 || (getCurrentRoamingPreset().mask[i2] & 2) != 0) {
                i |= 2;
            }
            if ((getCurrentMobilePreset().mask[i2] & 4) != 0 || (getCurrentWiFiPreset().mask[i2] & 4) != 0 || (4 & getCurrentRoamingPreset().mask[i2]) != 0) {
                i |= 4;
            }
            if ((getCurrentMobilePreset().mask[i2] & 8) != 0 || (getCurrentWiFiPreset().mask[i2] & 8) != 0 || (getCurrentRoamingPreset().mask[i2] & 8) != 0) {
                i |= 8;
            }
        }
        return i;
    }

    public void checkAutodownloadSettings() {
        int currentDownloadMask = getCurrentDownloadMask();
        if (currentDownloadMask == this.lastCheckMask) {
            return;
        }
        this.lastCheckMask = currentDownloadMask;
        if ((currentDownloadMask & 1) != 0) {
            if (this.photoDownloadQueue.isEmpty()) {
                newDownloadObjectsAvailable(1);
            }
        } else {
            for (int i = 0; i < this.photoDownloadQueue.size(); i++) {
                DownloadObject downloadObject = this.photoDownloadQueue.get(i);
                TLObject tLObject = downloadObject.object;
                if (tLObject instanceof TLRPC$Photo) {
                    getFileLoader().cancelLoadFile(FileLoader.getClosestPhotoSizeWithSize(((TLRPC$Photo) tLObject).sizes, AndroidUtilities.getPhotoSize()));
                } else if (tLObject instanceof TLRPC$Document) {
                    getFileLoader().cancelLoadFile((TLRPC$Document) downloadObject.object);
                }
            }
            this.photoDownloadQueue.clear();
        }
        if ((currentDownloadMask & 2) != 0) {
            if (this.audioDownloadQueue.isEmpty()) {
                newDownloadObjectsAvailable(2);
            }
        } else {
            for (int i2 = 0; i2 < this.audioDownloadQueue.size(); i2++) {
                getFileLoader().cancelLoadFile((TLRPC$Document) this.audioDownloadQueue.get(i2).object);
            }
            this.audioDownloadQueue.clear();
        }
        if ((currentDownloadMask & 8) != 0) {
            if (this.documentDownloadQueue.isEmpty()) {
                newDownloadObjectsAvailable(8);
            }
        } else {
            for (int i3 = 0; i3 < this.documentDownloadQueue.size(); i3++) {
                getFileLoader().cancelLoadFile((TLRPC$Document) this.documentDownloadQueue.get(i3).object);
            }
            this.documentDownloadQueue.clear();
        }
        if ((currentDownloadMask & 4) != 0) {
            if (this.videoDownloadQueue.isEmpty()) {
                newDownloadObjectsAvailable(4);
            }
        } else {
            for (int i4 = 0; i4 < this.videoDownloadQueue.size(); i4++) {
                getFileLoader().cancelLoadFile((TLRPC$Document) this.videoDownloadQueue.get(i4).object);
            }
            this.videoDownloadQueue.clear();
        }
        int autodownloadMaskAll = getAutodownloadMaskAll();
        if (autodownloadMaskAll == 0) {
            getMessagesStorage().clearDownloadQueue(0);
            return;
        }
        if ((autodownloadMaskAll & 1) == 0) {
            getMessagesStorage().clearDownloadQueue(1);
        }
        if ((autodownloadMaskAll & 2) == 0) {
            getMessagesStorage().clearDownloadQueue(2);
        }
        if ((autodownloadMaskAll & 4) == 0) {
            getMessagesStorage().clearDownloadQueue(4);
        }
        if ((autodownloadMaskAll & 8) == 0) {
            getMessagesStorage().clearDownloadQueue(8);
        }
    }

    public boolean canDownloadMedia(MessageObject messageObject) {
        return canDownloadMedia(messageObject.messageOwner) == 1;
    }

    public boolean canDownloadMedia(int i, int i2) {
        Preset currentMobilePreset;
        int autodownloadNetworkType = ApplicationLoader.getAutodownloadNetworkType();
        if (autodownloadNetworkType == 1) {
            if (!this.wifiPreset.enabled) {
                return false;
            }
            currentMobilePreset = getCurrentWiFiPreset();
        } else if (autodownloadNetworkType == 2) {
            if (!this.roamingPreset.enabled) {
                return false;
            }
            currentMobilePreset = getCurrentRoamingPreset();
        } else {
            if (!this.mobilePreset.enabled) {
                return false;
            }
            currentMobilePreset = getCurrentMobilePreset();
        }
        int i3 = currentMobilePreset.mask[1];
        int i4 = currentMobilePreset.sizes[typeToIndex(i)];
        if (i == 1 || (i2 != 0 && i2 <= i4)) {
            return i == 2 || (i & i3) != 0;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int canDownloadMedia(org.rbmain.tgnet.TLRPC$Message r11) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.DownloadController.canDownloadMedia(org.rbmain.tgnet.TLRPC$Message):int");
    }

    protected boolean canDownloadNextTrack() {
        int autodownloadNetworkType = ApplicationLoader.getAutodownloadNetworkType();
        return autodownloadNetworkType == 1 ? this.wifiPreset.enabled && getCurrentWiFiPreset().preloadMusic : autodownloadNetworkType == 2 ? this.roamingPreset.enabled && getCurrentRoamingPreset().preloadMusic : this.mobilePreset.enabled && getCurrentMobilePreset().preloadMusic;
    }

    public int getCurrentDownloadMask() {
        int autodownloadNetworkType = ApplicationLoader.getAutodownloadNetworkType();
        int i = 0;
        if (autodownloadNetworkType == 1) {
            if (!this.wifiPreset.enabled) {
                return 0;
            }
            int i2 = 0;
            while (i < 4) {
                i2 |= getCurrentWiFiPreset().mask[i];
                i++;
            }
            return i2;
        }
        if (autodownloadNetworkType == 2) {
            if (!this.roamingPreset.enabled) {
                return 0;
            }
            int i3 = 0;
            while (i < 4) {
                i3 |= getCurrentRoamingPreset().mask[i];
                i++;
            }
            return i3;
        }
        if (!this.mobilePreset.enabled) {
            return 0;
        }
        int i4 = 0;
        while (i < 4) {
            i4 |= getCurrentMobilePreset().mask[i];
            i++;
        }
        return i4;
    }

    public void savePresetToServer(int i) {
        Preset currentRoamingPreset;
        boolean z;
        TLRPC$TL_account_saveAutoDownloadSettings tLRPC$TL_account_saveAutoDownloadSettings = new TLRPC$TL_account_saveAutoDownloadSettings();
        if (i == 0) {
            currentRoamingPreset = getCurrentMobilePreset();
            z = this.mobilePreset.enabled;
        } else if (i == 1) {
            currentRoamingPreset = getCurrentWiFiPreset();
            z = this.wifiPreset.enabled;
        } else {
            currentRoamingPreset = getCurrentRoamingPreset();
            z = this.roamingPreset.enabled;
        }
        TLRPC$TL_autoDownloadSettings tLRPC$TL_autoDownloadSettings = new TLRPC$TL_autoDownloadSettings();
        tLRPC$TL_account_saveAutoDownloadSettings.settings = tLRPC$TL_autoDownloadSettings;
        tLRPC$TL_autoDownloadSettings.audio_preload_next = currentRoamingPreset.preloadMusic;
        tLRPC$TL_autoDownloadSettings.video_preload_large = currentRoamingPreset.preloadVideo;
        tLRPC$TL_autoDownloadSettings.phonecalls_less_data = currentRoamingPreset.lessCallData;
        tLRPC$TL_autoDownloadSettings.video_upload_maxbitrate = currentRoamingPreset.maxVideoBitrate;
        tLRPC$TL_autoDownloadSettings.disabled = !z;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            int[] iArr = currentRoamingPreset.mask;
            if (i2 < iArr.length) {
                if ((iArr[i2] & 1) != 0) {
                    z2 = true;
                }
                if ((iArr[i2] & 4) != 0) {
                    z3 = true;
                }
                if ((iArr[i2] & 8) != 0) {
                    z4 = true;
                }
                if (z2 && z3 && z4) {
                    break;
                } else {
                    i2++;
                }
            } else {
                break;
            }
        }
        TLRPC$TL_autoDownloadSettings tLRPC$TL_autoDownloadSettings2 = tLRPC$TL_account_saveAutoDownloadSettings.settings;
        tLRPC$TL_autoDownloadSettings2.photo_size_max = z2 ? currentRoamingPreset.sizes[0] : 0;
        tLRPC$TL_autoDownloadSettings2.video_size_max = z3 ? currentRoamingPreset.sizes[1] : 0;
        tLRPC$TL_autoDownloadSettings2.file_size_max = z4 ? currentRoamingPreset.sizes[2] : 0;
        getConnectionsManager().sendRequest(tLRPC$TL_account_saveAutoDownloadSettings, new RequestDelegate() { // from class: org.rbmain.messenger.DownloadController$$ExternalSyntheticLambda3
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                DownloadController.lambda$savePresetToServer$3(tLObject, tLRPC$TL_error);
            }
        });
    }

    protected void cancelDownloading(ArrayList<Pair<Long, Integer>> arrayList) {
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            DownloadObject downloadObject = this.downloadQueuePairs.get(arrayList.get(i));
            if (downloadObject != null) {
                TLObject tLObject = downloadObject.object;
                if (tLObject instanceof TLRPC$Document) {
                    getFileLoader().cancelLoadFile((TLRPC$Document) tLObject, true);
                } else if ((tLObject instanceof TLRPC$Photo) && (closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(((TLRPC$Photo) tLObject).sizes, AndroidUtilities.getPhotoSize())) != null) {
                    getFileLoader().cancelLoadFile(closestPhotoSizeWithSize, true);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void processDownloadObjects(int r20, java.util.ArrayList<org.rbmain.messenger.DownloadObject> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r21.isEmpty()
            if (r2 == 0) goto Lb
            return
        Lb:
            r2 = 2
            r3 = 1
            if (r1 != r3) goto L12
            java.util.ArrayList<org.rbmain.messenger.DownloadObject> r1 = r0.photoDownloadQueue
            goto L1f
        L12:
            if (r1 != r2) goto L17
            java.util.ArrayList<org.rbmain.messenger.DownloadObject> r1 = r0.audioDownloadQueue
            goto L1f
        L17:
            r4 = 4
            if (r1 != r4) goto L1d
            java.util.ArrayList<org.rbmain.messenger.DownloadObject> r1 = r0.videoDownloadQueue
            goto L1f
        L1d:
            java.util.ArrayList<org.rbmain.messenger.DownloadObject> r1 = r0.documentDownloadQueue
        L1f:
            r4 = 0
            r5 = 0
        L21:
            int r6 = r21.size()
            if (r5 >= r6) goto Lc9
            r6 = r21
            java.lang.Object r7 = r6.get(r5)
            org.rbmain.messenger.DownloadObject r7 = (org.rbmain.messenger.DownloadObject) r7
            org.rbmain.tgnet.TLObject r8 = r7.object
            boolean r9 = r8 instanceof org.rbmain.tgnet.TLRPC$Document
            r10 = 0
            if (r9 == 0) goto L42
            org.rbmain.tgnet.TLRPC$Document r8 = (org.rbmain.tgnet.TLRPC$Document) r8
            java.lang.String r8 = org.rbmain.messenger.FileLoader.getAttachFileName(r8)
        L3c:
            r18 = r10
            r10 = r8
            r8 = r18
            goto L58
        L42:
            boolean r9 = r8 instanceof org.rbmain.tgnet.TLRPC$Photo
            if (r9 == 0) goto L57
            org.rbmain.tgnet.TLRPC$Photo r8 = (org.rbmain.tgnet.TLRPC$Photo) r8
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$PhotoSize> r8 = r8.sizes
            int r9 = org.rbmain.messenger.AndroidUtilities.getPhotoSize()
            org.rbmain.tgnet.TLRPC$PhotoSize r10 = org.rbmain.messenger.FileLoader.getClosestPhotoSizeWithSize(r8, r9)
            java.lang.String r8 = org.rbmain.messenger.FileLoader.getAttachFileName(r10)
            goto L3c
        L57:
            r8 = r10
        L58:
            if (r10 == 0) goto Lc5
            java.util.HashMap<java.lang.String, org.rbmain.messenger.DownloadObject> r9 = r0.downloadQueueKeys
            boolean r9 = r9.containsKey(r10)
            if (r9 == 0) goto L63
            goto Lc5
        L63:
            if (r8 == 0) goto L8a
            org.rbmain.tgnet.TLObject r9 = r7.object
            org.rbmain.tgnet.TLRPC$Photo r9 = (org.rbmain.tgnet.TLRPC$Photo) r9
            boolean r11 = r7.secret
            if (r11 == 0) goto L70
            r17 = 2
            goto L79
        L70:
            boolean r11 = r7.forceCache
            if (r11 == 0) goto L77
            r17 = 1
            goto L79
        L77:
            r17 = 0
        L79:
            org.rbmain.messenger.FileLoader r12 = r19.getFileLoader()
            org.rbmain.messenger.ImageLocation r13 = org.rbmain.messenger.ImageLocation.getForPhoto(r8, r9)
            java.lang.String r14 = r7.parent
            r15 = 0
            r16 = 0
            r12.loadFile(r13, r14, r15, r16, r17)
            goto La2
        L8a:
            org.rbmain.tgnet.TLObject r8 = r7.object
            boolean r9 = r8 instanceof org.rbmain.tgnet.TLRPC$Document
            if (r9 == 0) goto La4
            org.rbmain.tgnet.TLRPC$Document r8 = (org.rbmain.tgnet.TLRPC$Document) r8
            org.rbmain.messenger.FileLoader r9 = r19.getFileLoader()
            java.lang.String r11 = r7.parent
            boolean r12 = r7.secret
            if (r12 == 0) goto L9e
            r12 = 2
            goto L9f
        L9e:
            r12 = 0
        L9f:
            r9.loadFile(r8, r11, r4, r12)
        La2:
            r8 = 1
            goto La5
        La4:
            r8 = 0
        La5:
            if (r8 == 0) goto Lc5
            r1.add(r7)
            java.util.HashMap<java.lang.String, org.rbmain.messenger.DownloadObject> r8 = r0.downloadQueueKeys
            r8.put(r10, r7)
            java.util.HashMap<android.util.Pair<java.lang.Long, java.lang.Integer>, org.rbmain.messenger.DownloadObject> r8 = r0.downloadQueuePairs
            android.util.Pair r9 = new android.util.Pair
            long r10 = r7.id
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            int r11 = r7.type
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r9.<init>(r10, r11)
            r8.put(r9, r7)
        Lc5:
            int r5 = r5 + 1
            goto L21
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.DownloadController.processDownloadObjects(int, java.util.ArrayList):void");
    }

    protected void newDownloadObjectsAvailable(int i) {
        int currentDownloadMask = getCurrentDownloadMask();
        if ((currentDownloadMask & 1) != 0 && (i & 1) != 0 && this.photoDownloadQueue.isEmpty()) {
            getMessagesStorage().getDownloadQueue(1);
        }
        if ((currentDownloadMask & 2) != 0 && (i & 2) != 0 && this.audioDownloadQueue.isEmpty()) {
            getMessagesStorage().getDownloadQueue(2);
        }
        if ((currentDownloadMask & 4) != 0 && (i & 4) != 0 && this.videoDownloadQueue.isEmpty()) {
            getMessagesStorage().getDownloadQueue(4);
        }
        if ((currentDownloadMask & 8) == 0 || (i & 8) == 0 || !this.documentDownloadQueue.isEmpty()) {
            return;
        }
        getMessagesStorage().getDownloadQueue(8);
    }

    private void checkDownloadFinished(String str, int i) {
        DownloadObject downloadObject = this.downloadQueueKeys.get(str);
        if (downloadObject != null) {
            this.downloadQueueKeys.remove(str);
            this.downloadQueuePairs.remove(new Pair(Long.valueOf(downloadObject.id), Integer.valueOf(downloadObject.type)));
            if (i == 0 || i == 2) {
                getMessagesStorage().removeFromDownloadQueue(downloadObject.id, downloadObject.type, false);
            }
            int i2 = downloadObject.type;
            if (i2 == 1) {
                this.photoDownloadQueue.remove(downloadObject);
                if (this.photoDownloadQueue.isEmpty()) {
                    newDownloadObjectsAvailable(1);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                this.audioDownloadQueue.remove(downloadObject);
                if (this.audioDownloadQueue.isEmpty()) {
                    newDownloadObjectsAvailable(2);
                    return;
                }
                return;
            }
            if (i2 == 4) {
                this.videoDownloadQueue.remove(downloadObject);
                if (this.videoDownloadQueue.isEmpty()) {
                    newDownloadObjectsAvailable(4);
                    return;
                }
                return;
            }
            if (i2 == 8) {
                this.documentDownloadQueue.remove(downloadObject);
                if (this.documentDownloadQueue.isEmpty()) {
                    newDownloadObjectsAvailable(8);
                }
            }
        }
    }

    public int generateObserverTag() {
        int i = this.lastTag;
        this.lastTag = i + 1;
        return i;
    }

    public void addLoadingFileObserver(String str, FileDownloadProgressListener fileDownloadProgressListener) {
        addLoadingFileObserver(str, null, fileDownloadProgressListener);
    }

    public void addLoadingFileObserver(String str, MessageObject messageObject, FileDownloadProgressListener fileDownloadProgressListener) {
        if (this.listenerInProgress) {
            this.addLaterArray.put(str, fileDownloadProgressListener);
            return;
        }
        removeLoadingFileObserver(fileDownloadProgressListener);
        ArrayList<WeakReference<FileDownloadProgressListener>> arrayList = this.loadingFileObservers.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.loadingFileObservers.put(str, arrayList);
        }
        arrayList.add(new WeakReference<>(fileDownloadProgressListener));
        if (messageObject != null) {
            ArrayList<MessageObject> arrayList2 = this.loadingFileMessagesObservers.get(str);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                this.loadingFileMessagesObservers.put(str, arrayList2);
            }
            arrayList2.add(messageObject);
        }
        this.observersByTag.put(fileDownloadProgressListener.getObserverTag(), str);
    }

    public void removeLoadingFileObserver(FileDownloadProgressListener fileDownloadProgressListener) {
        if (this.listenerInProgress) {
            this.deleteLaterArray.add(fileDownloadProgressListener);
            return;
        }
        String str = this.observersByTag.get(fileDownloadProgressListener.getObserverTag());
        if (str != null) {
            ArrayList<WeakReference<FileDownloadProgressListener>> arrayList = this.loadingFileObservers.get(str);
            if (arrayList != null) {
                int i = 0;
                while (i < arrayList.size()) {
                    WeakReference<FileDownloadProgressListener> weakReference = arrayList.get(i);
                    if (weakReference.get() == null || weakReference.get() == fileDownloadProgressListener) {
                        arrayList.remove(i);
                        i--;
                    }
                    i++;
                }
                if (arrayList.isEmpty()) {
                    this.loadingFileObservers.remove(str);
                }
            }
            this.observersByTag.remove(fileDownloadProgressListener.getObserverTag());
        }
    }

    private void processLaterArrays() {
        for (Map.Entry<String, FileDownloadProgressListener> entry : this.addLaterArray.entrySet()) {
            addLoadingFileObserver(entry.getKey(), entry.getValue());
        }
        this.addLaterArray.clear();
        Iterator<FileDownloadProgressListener> it = this.deleteLaterArray.iterator();
        while (it.hasNext()) {
            removeLoadingFileObserver(it.next());
        }
        this.deleteLaterArray.clear();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.fileDidFailToLoad || i == NotificationCenter.httpFileDidFailedLoad) {
            String str = (String) objArr[0];
            Integer num = (Integer) objArr[1];
            this.listenerInProgress = true;
            ArrayList<WeakReference<FileDownloadProgressListener>> arrayList = this.loadingFileObservers.get(str);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    WeakReference<FileDownloadProgressListener> weakReference = arrayList.get(i3);
                    if (weakReference.get() != null) {
                        weakReference.get().onFailedDownload(str, num.intValue() == 1);
                        if (num.intValue() != 1) {
                            this.observersByTag.remove(weakReference.get().getObserverTag());
                        }
                    }
                }
                if (num.intValue() != 1) {
                    this.loadingFileObservers.remove(str);
                }
            }
            this.listenerInProgress = false;
            processLaterArrays();
            checkDownloadFinished(str, num.intValue());
            return;
        }
        if (i == NotificationCenter.fileDidLoad || i == NotificationCenter.httpFileDidLoad) {
            this.listenerInProgress = true;
            String str2 = (String) objArr[0];
            ArrayList<MessageObject> arrayList2 = this.loadingFileMessagesObservers.get(str2);
            if (arrayList2 != null) {
                int size2 = arrayList2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    arrayList2.get(i4).mediaExists = true;
                }
                this.loadingFileMessagesObservers.remove(str2);
            }
            ArrayList<WeakReference<FileDownloadProgressListener>> arrayList3 = this.loadingFileObservers.get(str2);
            if (arrayList3 != null) {
                int size3 = arrayList3.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    WeakReference<FileDownloadProgressListener> weakReference2 = arrayList3.get(i5);
                    if (weakReference2.get() != null) {
                        weakReference2.get().onSuccessDownload(str2);
                        this.observersByTag.remove(weakReference2.get().getObserverTag());
                    }
                }
                this.loadingFileObservers.remove(str2);
            }
            this.listenerInProgress = false;
            processLaterArrays();
            checkDownloadFinished(str2, 0);
            return;
        }
        if (i == NotificationCenter.FileLoadProgressChanged) {
            this.listenerInProgress = true;
            String str3 = (String) objArr[0];
            ArrayList<WeakReference<FileDownloadProgressListener>> arrayList4 = this.loadingFileObservers.get(str3);
            if (arrayList4 != null) {
                Long l = (Long) objArr[1];
                Long l2 = (Long) objArr[2];
                int size4 = arrayList4.size();
                for (int i6 = 0; i6 < size4; i6++) {
                    WeakReference<FileDownloadProgressListener> weakReference3 = arrayList4.get(i6);
                    if (weakReference3.get() != null) {
                        weakReference3.get().onProgressDownload(str3, l.longValue(), l2.longValue());
                    }
                }
            }
            this.listenerInProgress = false;
            processLaterArrays();
            return;
        }
        if (i == NotificationCenter.FileUploadProgressChanged) {
            this.listenerInProgress = true;
            String str4 = (String) objArr[0];
            ArrayList<WeakReference<FileDownloadProgressListener>> arrayList5 = this.loadingFileObservers.get(str4);
            if (arrayList5 != null) {
                Long l3 = (Long) objArr[1];
                Long l4 = (Long) objArr[2];
                Boolean bool = (Boolean) objArr[3];
                int size5 = arrayList5.size();
                for (int i7 = 0; i7 < size5; i7++) {
                    WeakReference<FileDownloadProgressListener> weakReference4 = arrayList5.get(i7);
                    if (weakReference4.get() != null) {
                        weakReference4.get().onProgressUpload(str4, l3.longValue(), l4.longValue(), bool.booleanValue());
                    }
                }
            }
            this.listenerInProgress = false;
            processLaterArrays();
            try {
                ArrayList<SendMessagesHelper.DelayedMessage> delayedMessages = getSendMessagesHelper().getDelayedMessages(str4);
                if (delayedMessages != null) {
                    for (int i8 = 0; i8 < delayedMessages.size(); i8++) {
                        SendMessagesHelper.DelayedMessage delayedMessage = delayedMessages.get(i8);
                        if (delayedMessage.encryptedChat == null) {
                            long j = delayedMessage.peer;
                            int i9 = delayedMessage.topMessageId;
                            Long l5 = this.typingTimes.get(j);
                            if (delayedMessage.type != 4) {
                                delayedMessage.obj.getDocument();
                                if (l5 == null || l5.longValue() + 4000 < System.currentTimeMillis()) {
                                    if (delayedMessage.obj.isRoundVideo()) {
                                        getMessagesController().sendTyping(j, i9, 8, 0);
                                    } else if (delayedMessage.obj.isVideo()) {
                                        getMessagesController().sendTyping(j, i9, 5, 0);
                                    } else if (delayedMessage.obj.isVoice()) {
                                        getMessagesController().sendTyping(j, i9, 9, 0);
                                    } else if (delayedMessage.obj.getDocument() != null) {
                                        getMessagesController().sendTyping(j, i9, 3, 0);
                                    } else if (delayedMessage.photoSize != null) {
                                        getMessagesController().sendTyping(j, i9, 4, 0);
                                    }
                                    this.typingTimes.put(j, Long.valueOf(System.currentTimeMillis()));
                                }
                            } else if (l5 == null || l5.longValue() + 4000 < System.currentTimeMillis()) {
                                MessageObject messageObject = (MessageObject) delayedMessage.extraHashMap.get(str4 + "_i");
                                if (messageObject != null && messageObject.isVideo()) {
                                    getMessagesController().sendTyping(j, i9, 5, 0);
                                } else if (messageObject != null && messageObject.getDocument() != null) {
                                    getMessagesController().sendTyping(j, i9, 3, 0);
                                } else {
                                    getMessagesController().sendTyping(j, i9, 4, 0);
                                }
                                this.typingTimes.put(j, Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static float getProgress(long[] jArr) {
        if (jArr == null || jArr.length < 2 || jArr[1] == 0) {
            return 0.0f;
        }
        return Math.min(1.0f, jArr[0] / jArr[1]);
    }

    public boolean isDownloading(long j) {
        for (int i = 0; i < this.downloadingFiles.size(); i++) {
            if (this.downloadingFiles.get(i).messageOwner.id == j) {
                return true;
            }
        }
        return false;
    }
}
