package ir.eitaa.messenger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.messenger.audioinfo.AudioInfo;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$InputDocument;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAnimated;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_encryptedChat;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_messages;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.FiltersView;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.EmbedBottomSheet;
import ir.eitaa.ui.Components.PhotoFilterView;
import ir.eitaa.ui.Components.PipRoundVideoView;
import ir.eitaa.ui.Components.Point;
import ir.eitaa.ui.Components.VideoPlayer;
import ir.eitaa.ui.PhotoViewer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class MediaController implements AudioManager.OnAudioFocusChangeListener, NotificationCenter.NotificationCenterDelegate, SensorEventListener {
    private static final int AUDIO_FOCUSED = 2;
    private static final int AUDIO_NO_FOCUS_CAN_DUCK = 1;
    private static final int AUDIO_NO_FOCUS_NO_DUCK = 0;
    public static final String AUIDO_MIME_TYPE = "audio/mp4a-latm";
    private static volatile MediaController Instance = null;
    public static final int VIDEO_BITRATE_1080 = 6800000;
    public static final int VIDEO_BITRATE_360 = 750000;
    public static final int VIDEO_BITRATE_480 = 1000000;
    public static final int VIDEO_BITRATE_720 = 2621440;
    public static final String VIDEO_MIME_TYPE = "video/avc";
    private static final float VOLUME_DUCK = 0.2f;
    private static final float VOLUME_NORMAL = 1.0f;
    public static AlbumEntry allMediaAlbumEntry;
    public static ArrayList<AlbumEntry> allMediaAlbums;
    public static ArrayList<AlbumEntry> allPhotoAlbums;
    public static AlbumEntry allPhotosAlbumEntry;
    public static AlbumEntry allVideosAlbumEntry;
    private static Runnable broadcastPhotosRunnable;
    private static final String[] projectionPhotos;
    private static final String[] projectionVideo;
    private static Runnable refreshGalleryRunnable;
    private Sensor accelerometerSensor;
    private boolean accelerometerVertical;
    private boolean allowStartRecord;
    private AudioInfo audioInfo;
    private AudioRecord audioRecorder;
    private float audioVolume;
    private ValueAnimator audioVolumeAnimator;
    private Activity baseActivity;
    private boolean callInProgress;
    private int countLess;
    private AspectRatioFrameLayout currentAspectRatioFrameLayout;
    private float currentAspectRatioFrameLayoutRatio;
    private boolean currentAspectRatioFrameLayoutReady;
    private int currentAspectRatioFrameLayoutRotation;
    private int currentPlaylistNum;
    private TextureView currentTextureView;
    private FrameLayout currentTextureViewContainer;
    private boolean downloadingCurrentMessage;
    private ExternalObserver externalObserver;
    private View feedbackView;
    private ByteBuffer fileBuffer;
    private DispatchQueue fileEncodingQueue;
    private BaseFragment flagSecureFragment;
    private boolean forceLoopCurrentPlaylist;
    private MessageObject goingToShowMessageObject;
    private Sensor gravitySensor;
    private int hasAudioFocus;
    private boolean hasRecordAudioFocus;
    private boolean ignoreOnPause;
    private boolean ignoreProximity;
    private boolean inputFieldHasText;
    private InternalObserver internalObserver;
    private boolean isDrawingWasReady;
    private boolean isStreamingCurrentAudio;
    private int lastChatAccount;
    private long lastChatEnterTime;
    private long lastChatLeaveTime;
    private ArrayList<Long> lastChatVisibleMessages;
    private long lastMediaCheckTime;
    private int lastMessageId;
    private long lastSaveTime;
    private TLRPC$EncryptedChat lastSecretChat;
    private TLRPC$User lastUser;
    private Sensor linearSensor;
    private boolean loadingPlaylist;
    private String[] mediaProjections;
    private PipRoundVideoView pipRoundVideoView;
    private int pipSwitchingState;
    private boolean playMusicAgain;
    private int playerNum;
    private boolean playerWasReady;
    private MessageObject playingMessageObject;
    private int playlistClassGuid;
    private PlaylistGlobalSearchParams playlistGlobalSearchParams;
    private long playlistMergeDialogId;
    private float previousAccValue;
    private boolean proximityHasDifferentValues;
    private Sensor proximitySensor;
    private boolean proximityTouched;
    private PowerManager.WakeLock proximityWakeLock;
    private ChatActivity raiseChat;
    private boolean raiseToEarRecord;
    private int raisedToBack;
    private int raisedToTop;
    private int raisedToTopSign;
    private long recordDialogId;
    private DispatchQueue recordQueue;
    private MessageObject recordReplyingMsg;
    private MessageObject recordReplyingTopMsg;
    private Runnable recordStartRunnable;
    private long recordStartTime;
    private long recordTimeCount;
    private TLRPC$TL_document recordingAudio;
    private File recordingAudioFile;
    private int recordingCurrentAccount;
    private boolean resumeAudioOnFocusGain;
    private long samplesCount;
    private float seekToProgressPending;
    private int sendAfterDone;
    private boolean sendAfterDoneNotify;
    private int sendAfterDoneScheduleDate;
    private SensorManager sensorManager;
    private boolean sensorsStarted;
    private String shouldSavePositionForCurrentAudio;
    private int startObserverToken;
    private StopMediaObserverRunnable stopMediaObserverRunnable;
    private long timeSinceRaise;
    private boolean useFrontSpeaker;
    private VideoPlayer videoPlayer;
    private ArrayList<MessageObject> voiceMessagesPlaylist;
    private SparseArray<MessageObject> voiceMessagesPlaylistMap;
    private boolean voiceMessagesPlaylistUnread;
    AudioManager.OnAudioFocusChangeListener audioRecordFocusChangedListener = new AudioManager.OnAudioFocusChangeListener() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$jfxfEWlEUdPZ2koVX3xLZ1CCUqU
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i) {
            this.f$0.lambda$new$0$MediaController(i);
        }
    };
    private final Object videoConvertSync = new Object();
    private long lastTimestamp = 0;
    private float lastProximityValue = -100.0f;
    private float[] gravity = new float[3];
    private float[] gravityFast = new float[3];
    private float[] linearAcceleration = new float[3];
    private int audioFocus = 0;
    private ArrayList<VideoConvertMessage> videoConvertQueue = new ArrayList<>();
    private final Object videoQueueSync = new Object();
    private HashMap<String, MessageObject> generatingWaveform = new HashMap<>();
    private boolean isPaused = false;
    private VideoPlayer audioPlayer = null;
    private VideoPlayer emojiSoundPlayer = null;
    private int emojiSoundPlayerNum = 0;
    private float currentPlaybackSpeed = VOLUME_NORMAL;
    private float currentMusicPlaybackSpeed = VOLUME_NORMAL;
    private float fastPlaybackSpeed = VOLUME_NORMAL;
    private float fastMusicPlaybackSpeed = VOLUME_NORMAL;
    private long lastProgress = 0;
    private Timer progressTimer = null;
    private final Object progressTimerSync = new Object();
    private ArrayList<MessageObject> playlist = new ArrayList<>();
    private HashMap<Integer, MessageObject> playlistMap = new HashMap<>();
    private ArrayList<MessageObject> shuffledPlaylist = new ArrayList<>();
    private boolean[] playlistEndReached = {false, false};
    private int[] playlistMaxId = {ConnectionsManager.DEFAULT_DATACENTER_ID, ConnectionsManager.DEFAULT_DATACENTER_ID};
    private Runnable setLoadingRunnable = new Runnable() { // from class: ir.eitaa.messenger.MediaController.1
        @Override // java.lang.Runnable
        public void run() {
            if (MediaController.this.playingMessageObject == null) {
                return;
            }
            FileLoader.getInstance(MediaController.this.playingMessageObject.currentAccount).setLoadingVideo(MediaController.this.playingMessageObject.getDocument(), true, false);
        }
    };
    private int recordingGuid = -1;
    private short[] recordSamples = new short[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
    private final Object sync = new Object();
    private ArrayList<ByteBuffer> recordBuffers = new ArrayList<>();
    public int recordBufferSize = 1280;
    public int sampleRate = 16000;
    private Runnable recordRunnable = new AnonymousClass2();
    private final ValueAnimator.AnimatorUpdateListener audioVolumeUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.messenger.MediaController.3
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MediaController.this.audioVolume = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            MediaController.this.setPlayerVolume();
        }
    };

    public static class AudioEntry {
        public String author;
        public int duration;
        public String genre;
        public long id;
        public MessageObject messageObject;
        public String path;
        public String title;
    }

    public static class CropState {
        public float cropPx;
        public float cropPy;
        public float cropRotate;
        public boolean freeform;
        public int height;
        public boolean initied;
        public float lockedAspectRatio;
        public Matrix matrix;
        public boolean mirrored;
        public float scale;
        public float stateScale;
        public int transformHeight;
        public int transformRotation;
        public int transformWidth;
        public int width;
        public float cropScale = MediaController.VOLUME_NORMAL;
        public float cropPw = MediaController.VOLUME_NORMAL;
        public float cropPh = MediaController.VOLUME_NORMAL;
    }

    public static class SavedFilterState {
        public float blurAngle;
        public float blurExcludeBlurSize;
        public Point blurExcludePoint;
        public float blurExcludeSize;
        public int blurType;
        public float contrastValue;
        public PhotoFilterView.CurvesToolValue curvesToolValue = new PhotoFilterView.CurvesToolValue();
        public float enhanceValue;
        public float exposureValue;
        public float fadeValue;
        public float grainValue;
        public float highlightsValue;
        public float saturationValue;
        public float shadowsValue;
        public float sharpenValue;
        public float softenSkinValue;
        public int tintHighlightsColor;
        public int tintShadowsColor;
        public float vignetteValue;
        public float warmthValue;
    }

    public interface VideoConvertorListener {
        boolean checkConversionCanceled();

        void didWriteData(long availableSize, float progress);
    }

    private static int getVideoBitrateWithFactor(float f) {
        return (int) (f * 2000.0f * 1000.0f * 1.13f);
    }

    public static native int isOpusFile(String path);

    private static boolean isRecognizedFormat(int colorFormat) {
        if (colorFormat == 39 || colorFormat == 2130706688) {
            return true;
        }
        switch (colorFormat) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    private native int startRecord(String path, int sampleRate);

    private native void stopRecord();

    /* JADX INFO: Access modifiers changed from: private */
    public native int writeFrame(ByteBuffer frame, int len);

    public native byte[] getWaveform(String path);

    public native byte[] getWaveform2(short[] array, int length);

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    static /* synthetic */ long access$1614(MediaController mediaController, long j) {
        long j2 = mediaController.recordTimeCount + j;
        mediaController.recordTimeCount = j2;
        return j2;
    }

    public boolean isBuffering() {
        VideoPlayer videoPlayer = this.audioPlayer;
        if (videoPlayer != null) {
            return videoPlayer.isBuffering();
        }
        return false;
    }

    private static class AudioBuffer {
        ByteBuffer buffer;
        byte[] bufferBytes;
        int finished;
        long pcmOffset;
        int size;

        public AudioBuffer(int capacity) {
            this.buffer = ByteBuffer.allocateDirect(capacity);
            this.bufferBytes = new byte[capacity];
        }
    }

    static {
        String[] strArr = new String[9];
        strArr[0] = "_id";
        strArr[1] = "bucket_id";
        strArr[2] = "bucket_display_name";
        strArr[3] = "_data";
        int i = Build.VERSION.SDK_INT;
        strArr[4] = i > 28 ? "date_modified" : "datetaken";
        strArr[5] = "orientation";
        strArr[6] = "width";
        strArr[7] = "height";
        strArr[8] = "_size";
        projectionPhotos = strArr;
        String[] strArr2 = new String[9];
        strArr2[0] = "_id";
        strArr2[1] = "bucket_id";
        strArr2[2] = "bucket_display_name";
        strArr2[3] = "_data";
        strArr2[4] = i <= 28 ? "datetaken" : "date_modified";
        strArr2[5] = "duration";
        strArr2[6] = "width";
        strArr2[7] = "height";
        strArr2[8] = "_size";
        projectionVideo = strArr2;
        allMediaAlbums = new ArrayList<>();
        allPhotoAlbums = new ArrayList<>();
    }

    public static class AlbumEntry {
        public int bucketId;
        public String bucketName;
        public PhotoEntry coverPhoto;
        public ArrayList<PhotoEntry> photos = new ArrayList<>();
        public SparseArray<PhotoEntry> photosByIds = new SparseArray<>();
        public boolean videoOnly;

        public AlbumEntry(int bucketId, String bucketName, PhotoEntry coverPhoto) {
            this.bucketId = bucketId;
            this.bucketName = bucketName;
            this.coverPhoto = coverPhoto;
        }

        public void addPhoto(PhotoEntry photoEntry) {
            this.photos.add(photoEntry);
            this.photosByIds.put(photoEntry.imageId, photoEntry);
        }
    }

    public static class MediaEditState {
        public long averageDuration;
        public CharSequence caption;
        public CropState cropState;
        public ArrayList<VideoEditedInfo.MediaEntity> croppedMediaEntities;
        public String croppedPaintPath;
        public VideoEditedInfo editedInfo;
        public ArrayList<TLRPC$MessageEntity> entities;
        public String filterPath;
        public String fullPaintPath;
        public String imagePath;
        public boolean isCropped;
        public boolean isFiltered;
        public boolean isPainted;
        public ArrayList<VideoEditedInfo.MediaEntity> mediaEntities;
        public String paintPath;
        public SavedFilterState savedFilterState;
        public ArrayList<TLRPC$InputDocument> stickers;
        public String thumbPath;
        public int ttl;

        public String getPath() {
            return null;
        }

        public void reset() {
            this.caption = null;
            this.thumbPath = null;
            this.filterPath = null;
            this.imagePath = null;
            this.paintPath = null;
            this.croppedPaintPath = null;
            this.isFiltered = false;
            this.isPainted = false;
            this.isCropped = false;
            this.ttl = 0;
            this.mediaEntities = null;
            this.editedInfo = null;
            this.entities = null;
            this.savedFilterState = null;
            this.stickers = null;
            this.cropState = null;
        }

        public void copyFrom(MediaEditState state) {
            this.caption = state.caption;
            this.thumbPath = state.thumbPath;
            this.imagePath = state.imagePath;
            this.filterPath = state.filterPath;
            this.paintPath = state.paintPath;
            this.croppedPaintPath = state.croppedPaintPath;
            this.fullPaintPath = state.fullPaintPath;
            this.entities = state.entities;
            this.savedFilterState = state.savedFilterState;
            this.mediaEntities = state.mediaEntities;
            this.croppedMediaEntities = state.croppedMediaEntities;
            this.stickers = state.stickers;
            this.editedInfo = state.editedInfo;
            this.averageDuration = state.averageDuration;
            this.isFiltered = state.isFiltered;
            this.isPainted = state.isPainted;
            this.isCropped = state.isCropped;
            this.ttl = state.ttl;
            this.cropState = state.cropState;
        }
    }

    public static class PhotoEntry extends MediaEditState {
        public int bucketId;
        public boolean canDeleteAfter;
        public long dateTaken;
        public int duration;
        public int height;
        public int imageId;
        public boolean isMuted;
        public boolean isVideo;
        public int orientation;
        public String path;
        public long size;
        public int width;

        public PhotoEntry(int bucketId, int imageId, long dateTaken, String path, int orientation, boolean isVideo, int width, int height, long size) {
            this.bucketId = bucketId;
            this.imageId = imageId;
            this.dateTaken = dateTaken;
            this.path = path;
            this.width = width;
            this.height = height;
            this.size = size;
            if (isVideo) {
                this.duration = orientation;
            } else {
                this.orientation = orientation;
            }
            this.isVideo = isVideo;
        }

        @Override // ir.eitaa.messenger.MediaController.MediaEditState
        public String getPath() {
            return this.path;
        }

        @Override // ir.eitaa.messenger.MediaController.MediaEditState
        public void reset() {
            if (this.isVideo && this.filterPath != null) {
                new File(this.filterPath).delete();
                this.filterPath = null;
            }
            super.reset();
        }
    }

    public static class SearchImage extends MediaEditState {
        public CharSequence caption;
        public int date;
        public TLRPC$Document document;
        public int height;
        public String id;
        public String imageUrl;
        public TLRPC$BotInlineResult inlineResult;
        public HashMap<String, String> params;
        public TLRPC$Photo photo;
        public TLRPC$PhotoSize photoSize;
        public int size;
        public TLRPC$PhotoSize thumbPhotoSize;
        public String thumbUrl;
        public int type;
        public int width;

        @Override // ir.eitaa.messenger.MediaController.MediaEditState
        public String getPath() {
            TLRPC$PhotoSize tLRPC$PhotoSize = this.photoSize;
            if (tLRPC$PhotoSize != null) {
                return FileLoader.getPathToAttach(tLRPC$PhotoSize, true).getAbsolutePath();
            }
            TLRPC$Document tLRPC$Document = this.document;
            if (tLRPC$Document != null) {
                return FileLoader.getPathToAttach(tLRPC$Document, true).getAbsolutePath();
            }
            return ImageLoader.getHttpFilePath(this.imageUrl, "jpg").getAbsolutePath();
        }

        @Override // ir.eitaa.messenger.MediaController.MediaEditState
        public void reset() {
            super.reset();
        }

        public String getAttachName() {
            TLRPC$PhotoSize tLRPC$PhotoSize = this.photoSize;
            if (tLRPC$PhotoSize != null) {
                return FileLoader.getAttachFileName(tLRPC$PhotoSize);
            }
            TLRPC$Document tLRPC$Document = this.document;
            if (tLRPC$Document != null) {
                return FileLoader.getAttachFileName(tLRPC$Document);
            }
            return Utilities.MD5(this.imageUrl) + "." + ImageLoader.getHttpUrlExtension(this.imageUrl, "jpg");
        }

        public String getPathToAttach() {
            TLRPC$PhotoSize tLRPC$PhotoSize = this.photoSize;
            if (tLRPC$PhotoSize != null) {
                return FileLoader.getPathToAttach(tLRPC$PhotoSize, true).getAbsolutePath();
            }
            TLRPC$Document tLRPC$Document = this.document;
            if (tLRPC$Document != null) {
                return FileLoader.getPathToAttach(tLRPC$Document, true).getAbsolutePath();
            }
            return this.imageUrl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$MediaController(int i) {
        if (i != 1) {
            this.hasRecordAudioFocus = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class VideoConvertMessage {
        public int currentAccount;
        public MessageObject messageObject;
        public VideoEditedInfo videoEditedInfo;

        public VideoConvertMessage(MessageObject object, VideoEditedInfo info) {
            this.messageObject = object;
            this.currentAccount = object.currentAccount;
            this.videoEditedInfo = info;
        }
    }

    /* renamed from: ir.eitaa.messenger.MediaController$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x0115  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 356
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.AnonymousClass2.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$1$MediaController$2(final ByteBuffer byteBuffer, boolean z) {
            int iLimit;
            while (byteBuffer.hasRemaining()) {
                if (byteBuffer.remaining() > MediaController.this.fileBuffer.remaining()) {
                    iLimit = byteBuffer.limit();
                    byteBuffer.limit(MediaController.this.fileBuffer.remaining() + byteBuffer.position());
                } else {
                    iLimit = -1;
                }
                MediaController.this.fileBuffer.put(byteBuffer);
                if (MediaController.this.fileBuffer.position() == MediaController.this.fileBuffer.limit() || z) {
                    MediaController mediaController = MediaController.this;
                    if (mediaController.writeFrame(mediaController.fileBuffer, !z ? MediaController.this.fileBuffer.limit() : byteBuffer.position()) != 0) {
                        MediaController.this.fileBuffer.rewind();
                        MediaController.access$1614(MediaController.this, (r1.fileBuffer.limit() / 2) / (MediaController.this.sampleRate / 1000));
                    }
                }
                if (iLimit != -1) {
                    byteBuffer.limit(iLimit);
                }
            }
            MediaController.this.recordQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$2$yEs1VdeQBn3OKD_WX_l_InV--9Y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0$MediaController$2(byteBuffer);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$MediaController$2(ByteBuffer byteBuffer) {
            MediaController.this.recordBuffers.add(byteBuffer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$2$MediaController$2(double d) {
            NotificationCenter.getInstance(MediaController.this.recordingCurrentAccount).postNotificationName(NotificationCenter.recordProgressChanged, Integer.valueOf(MediaController.this.recordingGuid), Double.valueOf(d));
        }
    }

    private class InternalObserver extends ContentObserver {
        public InternalObserver() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            MediaController.this.processMediaObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        }
    }

    private class ExternalObserver extends ContentObserver {
        public ExternalObserver() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            MediaController.this.processMediaObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class GalleryObserverInternal extends ContentObserver {
        public GalleryObserverInternal() {
            super(null);
        }

        private void scheduleReloadRunnable() {
            AndroidUtilities.runOnUIThread(MediaController.refreshGalleryRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$GalleryObserverInternal$se7G2Ap22g3-xhxa-0_B2dwBjR0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$scheduleReloadRunnable$0$MediaController$GalleryObserverInternal();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$scheduleReloadRunnable$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$scheduleReloadRunnable$0$MediaController$GalleryObserverInternal() {
            if (!PhotoViewer.getInstance().isVisible()) {
                Runnable unused = MediaController.refreshGalleryRunnable = null;
                MediaController.loadGalleryPhotosAlbums(0);
            } else {
                scheduleReloadRunnable();
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            if (MediaController.refreshGalleryRunnable != null) {
                AndroidUtilities.cancelRunOnUIThread(MediaController.refreshGalleryRunnable);
            }
            scheduleReloadRunnable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class GalleryObserverExternal extends ContentObserver {
        public GalleryObserverExternal() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            if (MediaController.refreshGalleryRunnable != null) {
                AndroidUtilities.cancelRunOnUIThread(MediaController.refreshGalleryRunnable);
            }
            AndroidUtilities.runOnUIThread(MediaController.refreshGalleryRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$GalleryObserverExternal$hdu3kCTzCbGwOzNWzMxwEYr1Rjg
                @Override // java.lang.Runnable
                public final void run() {
                    MediaController.GalleryObserverExternal.lambda$onChange$0();
                }
            }, 2000L);
        }

        static /* synthetic */ void lambda$onChange$0() {
            Runnable unused = MediaController.refreshGalleryRunnable = null;
            MediaController.loadGalleryPhotosAlbums(0);
        }
    }

    public static void checkGallery() throws InterruptedException {
        AlbumEntry albumEntry;
        if (Build.VERSION.SDK_INT < 24 || (albumEntry = allPhotosAlbumEntry) == null) {
            return;
        }
        final int size = albumEntry.photos.size();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$hx7zPvx9ctWKyld2wmBUhwiSXMM
            @Override // java.lang.Runnable
            public final void run() {
                MediaController.lambda$checkGallery$1(size);
            }
        }, 2000L);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:61|3)|(7:5|(4:55|7|(2:9|10)|(1:16))|57|23|(2:29|30)|(1:32)|(4:38|(1:40)|41|42)(1:63))(1:13)|14|(0)|57|23|(4:25|27|29|30)|(0)|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0074, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
    
        if (r5 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0089, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008a, code lost:
    
        if (r5 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008c, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
    
        throw r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004d A[Catch: all -> 0x0073, TryCatch #2 {all -> 0x0073, blocks: (B:23:0x0045, B:25:0x004d, B:27:0x0062, B:29:0x0068), top: B:57:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f A[DONT_GENERATE, PHI: r5 r6
      0x006f: PHI (r5v4 android.database.Cursor) = (r5v3 android.database.Cursor), (r5v5 android.database.Cursor) binds: [B:35:0x0077, B:31:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r6v5 int) = (r6v3 int), (r6v6 int) binds: [B:35:0x0077, B:31:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$checkGallery$1(int r13) {
        /*
            java.lang.String r0 = "COUNT(_id)"
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            r2 = 1
            r3 = 0
            r4 = 0
            android.content.Context r5 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L3a
            int r5 = r5.checkSelfPermission(r1)     // Catch: java.lang.Throwable -> L3a
            if (r5 != 0) goto L32
            android.content.Context r5 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L3a
            android.content.ContentResolver r6 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L3a
            android.net.Uri r7 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L3a
            java.lang.String[] r8 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L3a
            r8[r4] = r0     // Catch: java.lang.Throwable -> L3a
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r5 = android.provider.MediaStore.Images.Media.query(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L33
            boolean r6 = r5.moveToNext()     // Catch: java.lang.Throwable -> L30
            if (r6 == 0) goto L33
            int r6 = r5.getInt(r4)     // Catch: java.lang.Throwable -> L30
            int r6 = r6 + r4
            goto L34
        L30:
            r6 = move-exception
            goto L3c
        L32:
            r5 = r3
        L33:
            r6 = 0
        L34:
            if (r5 == 0) goto L45
            r5.close()
            goto L45
        L3a:
            r6 = move-exception
            r5 = r3
        L3c:
            ir.eitaa.messenger.FileLog.e(r6)     // Catch: java.lang.Throwable -> L90
            if (r5 == 0) goto L44
            r5.close()
        L44:
            r6 = 0
        L45:
            android.content.Context r7 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L73
            int r1 = r7.checkSelfPermission(r1)     // Catch: java.lang.Throwable -> L73
            if (r1 != 0) goto L6d
            android.content.Context r1 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L73
            android.content.ContentResolver r7 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L73
            android.net.Uri r8 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L73
            java.lang.String[] r9 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L73
            r9[r4] = r0     // Catch: java.lang.Throwable -> L73
            r10 = 0
            r11 = 0
            r12 = 0
            android.database.Cursor r5 = android.provider.MediaStore.Images.Media.query(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L73
            if (r5 == 0) goto L6d
            boolean r0 = r5.moveToNext()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L6d
            int r0 = r5.getInt(r4)     // Catch: java.lang.Throwable -> L73
            int r6 = r6 + r0
        L6d:
            if (r5 == 0) goto L7a
        L6f:
            r5.close()
            goto L7a
        L73:
            r0 = move-exception
            ir.eitaa.messenger.FileLog.e(r0)     // Catch: java.lang.Throwable -> L89
            if (r5 == 0) goto L7a
            goto L6f
        L7a:
            if (r13 == r6) goto L88
            java.lang.Runnable r13 = ir.eitaa.messenger.MediaController.refreshGalleryRunnable
            if (r13 == 0) goto L85
            ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r13)
            ir.eitaa.messenger.MediaController.refreshGalleryRunnable = r3
        L85:
            loadGalleryPhotosAlbums(r4)
        L88:
            return
        L89:
            r13 = move-exception
            if (r5 == 0) goto L8f
            r5.close()
        L8f:
            throw r13
        L90:
            r13 = move-exception
            if (r5 == 0) goto L96
            r5.close()
        L96:
            goto L98
        L97:
            throw r13
        L98:
            goto L97
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.lambda$checkGallery$1(int):void");
    }

    private final class StopMediaObserverRunnable implements Runnable {
        public int currentObserverToken;

        private StopMediaObserverRunnable() {
            this.currentObserverToken = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.currentObserverToken == MediaController.this.startObserverToken) {
                try {
                    if (MediaController.this.internalObserver != null) {
                        ApplicationLoader.applicationContext.getContentResolver().unregisterContentObserver(MediaController.this.internalObserver);
                        MediaController.this.internalObserver = null;
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
                try {
                    if (MediaController.this.externalObserver != null) {
                        ApplicationLoader.applicationContext.getContentResolver().unregisterContentObserver(MediaController.this.externalObserver);
                        MediaController.this.externalObserver = null;
                    }
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
        }
    }

    public static MediaController getInstance() {
        MediaController mediaController = Instance;
        if (mediaController == null) {
            synchronized (MediaController.class) {
                mediaController = Instance;
                if (mediaController == null) {
                    mediaController = new MediaController();
                    Instance = mediaController;
                }
            }
        }
        return mediaController;
    }

    public MediaController() {
        DispatchQueue dispatchQueue = new DispatchQueue("recordQueue");
        this.recordQueue = dispatchQueue;
        dispatchQueue.setPriority(10);
        DispatchQueue dispatchQueue2 = new DispatchQueue("fileEncodingQueue");
        this.fileEncodingQueue = dispatchQueue2;
        dispatchQueue2.setPriority(10);
        this.recordQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$jf84v0b5K9v6ECvxX3LVj2cbexs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$2$MediaController();
            }
        });
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$TGKlaEkZHx7y1WXJY28xT1axcgA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$3$MediaController();
            }
        });
        this.fileBuffer = ByteBuffer.allocateDirect(1920);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$K48LRZdKvwg3rbPVOpM9XslSqsA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$4$MediaController();
            }
        });
        String[] strArr = new String[7];
        strArr[0] = "_data";
        strArr[1] = "_display_name";
        strArr[2] = "bucket_display_name";
        strArr[3] = Build.VERSION.SDK_INT > 28 ? "date_modified" : "datetaken";
        strArr[4] = "title";
        strArr[5] = "width";
        strArr[6] = "height";
        this.mediaProjections = strArr;
        ContentResolver contentResolver = ApplicationLoader.applicationContext.getContentResolver();
        try {
            contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, new GalleryObserverExternal());
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, new GalleryObserverInternal());
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, new GalleryObserverExternal());
        } catch (Exception e3) {
            FileLog.e(e3);
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Video.Media.INTERNAL_CONTENT_URI, true, new GalleryObserverInternal());
        } catch (Exception e4) {
            FileLog.e(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$MediaController() {
        try {
            this.sampleRate = 16000;
            int minBufferSize = AudioRecord.getMinBufferSize(16000, 16, 2);
            if (minBufferSize <= 0) {
                minBufferSize = 1280;
            }
            this.recordBufferSize = minBufferSize;
            for (int i = 0; i < 5; i++) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.recordBufferSize);
                byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
                this.recordBuffers.add(byteBufferAllocateDirect);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$MediaController() {
        try {
            this.currentPlaybackSpeed = MessagesController.getGlobalMainSettings().getFloat("playbackSpeed", VOLUME_NORMAL);
            this.currentMusicPlaybackSpeed = MessagesController.getGlobalMainSettings().getFloat("musicPlaybackSpeed", VOLUME_NORMAL);
            this.fastPlaybackSpeed = MessagesController.getGlobalMainSettings().getFloat("fastPlaybackSpeed", 1.8f);
            this.fastMusicPlaybackSpeed = MessagesController.getGlobalMainSettings().getFloat("fastMusicPlaybackSpeed", 1.8f);
            SensorManager sensorManager = (SensorManager) ApplicationLoader.applicationContext.getSystemService("sensor");
            this.sensorManager = sensorManager;
            this.linearSensor = sensorManager.getDefaultSensor(10);
            Sensor defaultSensor = this.sensorManager.getDefaultSensor(9);
            this.gravitySensor = defaultSensor;
            if (this.linearSensor == null || defaultSensor == null) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("gravity or linear sensor not found");
                }
                this.accelerometerSensor = this.sensorManager.getDefaultSensor(1);
                this.linearSensor = null;
                this.gravitySensor = null;
            }
            this.proximitySensor = this.sensorManager.getDefaultSensor(8);
            this.proximityWakeLock = ((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).newWakeLock(32, "eitaa:proximity_lock");
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4();
            TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
            if (telephonyManager != null) {
                telephonyManager.listen(anonymousClass4, 32);
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    /* renamed from: ir.eitaa.messenger.MediaController$4, reason: invalid class name */
    class AnonymousClass4 extends PhoneStateListener {
        AnonymousClass4() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(final int state, String incomingNumber) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$4$bBdNUE9PHz6wOhFT3tE5kZh8BOM
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$onCallStateChanged$0$MediaController$4(state);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCallStateChanged$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCallStateChanged$0$MediaController$4(int i) throws InterruptedException {
            if (i != 1) {
                if (i == 0) {
                    MediaController.this.callInProgress = false;
                    return;
                } else {
                    if (i == 2) {
                        EmbedBottomSheet embedBottomSheet = EmbedBottomSheet.getInstance();
                        if (embedBottomSheet != null) {
                            embedBottomSheet.pause();
                        }
                        MediaController.this.callInProgress = true;
                        return;
                    }
                    return;
                }
            }
            MediaController mediaController = MediaController.this;
            if (!mediaController.isPlayingMessage(mediaController.playingMessageObject) || MediaController.this.isMessagePaused()) {
                if (MediaController.this.recordStartRunnable != null || MediaController.this.recordingAudio != null) {
                    MediaController.this.stopRecording(2, false, 0);
                }
            } else {
                MediaController mediaController2 = MediaController.this;
                mediaController2.lambda$startAudioAgain$7(mediaController2.playingMessageObject);
            }
            EmbedBottomSheet embedBottomSheet2 = EmbedBottomSheet.getInstance();
            if (embedBottomSheet2 != null) {
                embedBottomSheet2.pause();
            }
            MediaController.this.callInProgress = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$MediaController() {
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.httpFileDidLoad);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.didReceiveNewMessages);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.messagesDeleted);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.removeAllMessagesFromDialog);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.musicDidLoad);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.mediaDidLoad);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.playerDidStartPlaying);
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(final int focusChange) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$WZCfXQf8oO_Feu419ZpvW4_Xiho
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$onAudioFocusChange$5$MediaController(focusChange);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onAudioFocusChange$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onAudioFocusChange$5$MediaController(int i) throws IOException {
        if (i == -1) {
            if (isPlayingMessage(getPlayingMessageObject()) && !isMessagePaused()) {
                lambda$startAudioAgain$7(this.playingMessageObject);
            }
            this.hasAudioFocus = 0;
            this.audioFocus = 0;
        } else if (i == 1) {
            this.audioFocus = 2;
            if (this.resumeAudioOnFocusGain) {
                this.resumeAudioOnFocusGain = false;
                if (isPlayingMessage(getPlayingMessageObject()) && isMessagePaused()) {
                    playMessage(getPlayingMessageObject());
                }
            }
        } else if (i == -3) {
            this.audioFocus = 1;
        } else if (i == -2) {
            this.audioFocus = 0;
            if (isPlayingMessage(getPlayingMessageObject()) && !isMessagePaused()) {
                lambda$startAudioAgain$7(this.playingMessageObject);
                this.resumeAudioOnFocusGain = true;
            }
        }
        setPlayerVolume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerVolume() {
        try {
            float f = this.audioFocus != 1 ? VOLUME_NORMAL : VOLUME_DUCK;
            VideoPlayer videoPlayer = this.audioPlayer;
            if (videoPlayer != null) {
                videoPlayer.setVolume(f * this.audioVolume);
            } else {
                VideoPlayer videoPlayer2 = this.videoPlayer;
                if (videoPlayer2 != null) {
                    videoPlayer2.setVolume(f);
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public VideoPlayer getVideoPlayer() {
        return this.videoPlayer;
    }

    private void startProgressTimer(final MessageObject currentPlayingMessageObject) {
        synchronized (this.progressTimerSync) {
            Timer timer = this.progressTimer;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.progressTimer = null;
                } catch (Exception e) {
                    FileLog.e(e);
                }
                currentPlayingMessageObject.getFileName();
                Timer timer2 = new Timer();
                this.progressTimer = timer2;
                timer2.schedule(new AnonymousClass5(currentPlayingMessageObject), 0L, 17L);
            } else {
                currentPlayingMessageObject.getFileName();
                Timer timer22 = new Timer();
                this.progressTimer = timer22;
                timer22.schedule(new AnonymousClass5(currentPlayingMessageObject), 0L, 17L);
            }
        }
    }

    /* renamed from: ir.eitaa.messenger.MediaController$5, reason: invalid class name */
    class AnonymousClass5 extends TimerTask {
        final /* synthetic */ MessageObject val$currentPlayingMessageObject;

        AnonymousClass5(final MessageObject val$currentPlayingMessageObject) {
            this.val$currentPlayingMessageObject = val$currentPlayingMessageObject;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (MediaController.this.sync) {
                final MessageObject messageObject = this.val$currentPlayingMessageObject;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$5$2OxgiL4S5uSyjfJPDXO-BoHTWR0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$1$MediaController$5(messageObject);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$1$MediaController$5(MessageObject messageObject) {
            long duration;
            long currentPosition;
            final float f;
            float bufferedPosition;
            if ((MediaController.this.audioPlayer == null && MediaController.this.videoPlayer == null) || MediaController.this.isPaused) {
                return;
            }
            try {
                if (MediaController.this.videoPlayer != null) {
                    duration = MediaController.this.videoPlayer.getDuration();
                    currentPosition = MediaController.this.videoPlayer.getCurrentPosition();
                    if (currentPosition >= 0 && duration > 0) {
                        float f2 = duration;
                        bufferedPosition = MediaController.this.videoPlayer.getBufferedPosition() / f2;
                        f = currentPosition / f2;
                        if (f >= MediaController.VOLUME_NORMAL) {
                            return;
                        }
                    }
                    return;
                }
                duration = MediaController.this.audioPlayer.getDuration();
                currentPosition = MediaController.this.audioPlayer.getCurrentPosition();
                float f3 = duration >= 0 ? currentPosition / duration : 0.0f;
                float bufferedPosition2 = MediaController.this.audioPlayer.getBufferedPosition() / duration;
                if (duration != -9223372036854775807L && currentPosition >= 0 && MediaController.this.seekToProgressPending == 0.0f) {
                    f = f3;
                    bufferedPosition = bufferedPosition2;
                }
                return;
                MediaController.this.lastProgress = currentPosition;
                messageObject.audioPlayerDuration = (int) (duration / 1000);
                messageObject.audioProgress = f;
                messageObject.audioProgressSec = (int) (MediaController.this.lastProgress / 1000);
                messageObject.bufferedProgress = bufferedPosition;
                if (f >= 0.0f && MediaController.this.shouldSavePositionForCurrentAudio != null && SystemClock.elapsedRealtime() - MediaController.this.lastSaveTime >= 1000) {
                    final String str = MediaController.this.shouldSavePositionForCurrentAudio;
                    MediaController.this.lastSaveTime = SystemClock.elapsedRealtime();
                    Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$5$CLVwJX-fnJ1o5JWXHCjz1qmrRdA
                        @Override // java.lang.Runnable
                        public final void run() {
                            ApplicationLoader.applicationContext.getSharedPreferences("media_saved_pos", 0).edit().putFloat(str, f).commit();
                        }
                    });
                }
                NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Integer.valueOf(messageObject.getId()), Float.valueOf(f));
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private void stopProgressTimer() {
        synchronized (this.progressTimerSync) {
            Timer timer = this.progressTimer;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.progressTimer = null;
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }
    }

    public void cleanup() {
        cleanupPlayer(true, true);
        this.audioInfo = null;
        this.playMusicAgain = false;
        for (int i = 0; i < 3; i++) {
            DownloadController.getInstance(i).cleanup();
        }
        this.videoConvertQueue.clear();
        this.generatingWaveform.clear();
        this.voiceMessagesPlaylist = null;
        this.voiceMessagesPlaylistMap = null;
        clearPlaylist();
        cancelVideoConvert(null);
    }

    private void clearPlaylist() {
        this.playlist.clear();
        this.playlistMap.clear();
        this.shuffledPlaylist.clear();
        this.playlistClassGuid = 0;
        boolean[] zArr = this.playlistEndReached;
        zArr[1] = false;
        zArr[0] = false;
        this.playlistMergeDialogId = 0L;
        int[] iArr = this.playlistMaxId;
        iArr[1] = Integer.MAX_VALUE;
        iArr[0] = Integer.MAX_VALUE;
        this.loadingPlaylist = false;
        this.playlistGlobalSearchParams = null;
    }

    public void startMediaObserver() {
        ApplicationLoader.applicationHandler.removeCallbacks(this.stopMediaObserverRunnable);
        this.startObserverToken++;
        try {
            if (this.internalObserver == null) {
                ContentResolver contentResolver = ApplicationLoader.applicationContext.getContentResolver();
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                ExternalObserver externalObserver = new ExternalObserver();
                this.externalObserver = externalObserver;
                contentResolver.registerContentObserver(uri, false, externalObserver);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            if (this.externalObserver == null) {
                ContentResolver contentResolver2 = ApplicationLoader.applicationContext.getContentResolver();
                Uri uri2 = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
                InternalObserver internalObserver = new InternalObserver();
                this.internalObserver = internalObserver;
                contentResolver2.registerContentObserver(uri2, false, internalObserver);
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    public void stopMediaObserver() {
        if (this.stopMediaObserverRunnable == null) {
            this.stopMediaObserverRunnable = new StopMediaObserverRunnable();
        }
        this.stopMediaObserverRunnable.currentObserverToken = this.startObserverToken;
        ApplicationLoader.applicationHandler.postDelayed(this.stopMediaObserverRunnable, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMediaObserver(Uri uri) {
        int i;
        Cursor cursorQuery = null;
        try {
            try {
                android.graphics.Point realScreenSize = AndroidUtilities.getRealScreenSize();
                cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(uri, this.mediaProjections, null, null, "date_added DESC LIMIT 1");
                final ArrayList arrayList = new ArrayList();
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        String string3 = cursorQuery.getString(2);
                        long j = cursorQuery.getLong(3);
                        String string4 = cursorQuery.getString(4);
                        int i2 = cursorQuery.getInt(5);
                        int i3 = cursorQuery.getInt(6);
                        if ((string != null && string.toLowerCase().contains("screenshot")) || ((string2 != null && string2.toLowerCase().contains("screenshot")) || ((string3 != null && string3.toLowerCase().contains("screenshot")) || (string4 != null && string4.toLowerCase().contains("screenshot"))))) {
                            if (i2 == 0 || i3 == 0) {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(string, options);
                                i2 = options.outWidth;
                                i3 = options.outHeight;
                            }
                            if (i2 > 0 && i3 > 0) {
                                try {
                                    i = realScreenSize.x;
                                } catch (Exception unused) {
                                    arrayList.add(Long.valueOf(j));
                                }
                                if ((i2 != i || i3 != realScreenSize.y) && (i3 != i || i2 != realScreenSize.y)) {
                                }
                            }
                            arrayList.add(Long.valueOf(j));
                        }
                    }
                    cursorQuery.close();
                }
                if (!arrayList.isEmpty()) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$OwvhxxuEwL7PIYrJ2v2LTdwKBJY
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$processMediaObserver$6$MediaController(arrayList);
                        }
                    });
                }
                if (cursorQuery == null) {
                    return;
                }
            } catch (Exception e) {
                FileLog.e(e);
                if (cursorQuery == null) {
                    return;
                }
            }
            try {
                cursorQuery.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processMediaObserver$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processMediaObserver$6$MediaController(ArrayList arrayList) {
        NotificationCenter.getInstance(this.lastChatAccount).postNotificationName(NotificationCenter.screenshotTook, new Object[0]);
        checkScreenshots(arrayList);
    }

    private void checkScreenshots(ArrayList<Long> dates) {
        if (dates == null || dates.isEmpty() || this.lastChatEnterTime == 0) {
            return;
        }
        if (this.lastUser != null || (this.lastSecretChat instanceof TLRPC$TL_encryptedChat)) {
            boolean z = false;
            for (int i = 0; i < dates.size(); i++) {
                Long l = dates.get(i);
                if ((this.lastMediaCheckTime == 0 || l.longValue() > this.lastMediaCheckTime) && l.longValue() >= this.lastChatEnterTime && (this.lastChatLeaveTime == 0 || l.longValue() <= this.lastChatLeaveTime + 2000)) {
                    this.lastMediaCheckTime = Math.max(this.lastMediaCheckTime, l.longValue());
                    z = true;
                }
            }
            if (z) {
                if (this.lastSecretChat != null) {
                    SecretChatHelper.getInstance(this.lastChatAccount).sendScreenshotMessage(this.lastSecretChat, this.lastChatVisibleMessages, null);
                } else {
                    SendMessagesHelper.getInstance(this.lastChatAccount).sendScreenshotMessage(this.lastUser, this.lastMessageId, null);
                }
            }
        }
    }

    public void setLastVisibleMessageIds(int account, long enterTime, long leaveTime, TLRPC$User user, TLRPC$EncryptedChat encryptedChat, ArrayList<Long> visibleMessages, int visibleMessage) {
        this.lastChatEnterTime = enterTime;
        this.lastChatLeaveTime = leaveTime;
        this.lastChatAccount = account;
        this.lastSecretChat = encryptedChat;
        this.lastUser = user;
        this.lastMessageId = visibleMessage;
        this.lastChatVisibleMessages = visibleMessages;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws InterruptedException, IOException {
        ArrayList<MessageObject> arrayList;
        int iIndexOf;
        int i = 0;
        if (id == NotificationCenter.fileLoaded || id == NotificationCenter.httpFileDidLoad) {
            String str = (String) args[0];
            MessageObject messageObject = this.playingMessageObject;
            if (messageObject != null && messageObject.currentAccount == account && FileLoader.getAttachFileName(messageObject.getDocument()).equals(str)) {
                if (this.downloadingCurrentMessage) {
                    this.playMusicAgain = true;
                    playMessage(this.playingMessageObject);
                    return;
                } else {
                    if (this.audioInfo == null) {
                        try {
                            this.audioInfo = AudioInfo.getAudioInfo(FileLoader.getPathToMessage(this.playingMessageObject.messageOwner));
                            return;
                        } catch (Exception e) {
                            FileLog.e(e);
                            return;
                        }
                    }
                    return;
                }
            }
            return;
        }
        if (id == NotificationCenter.messagesDeleted) {
            if (((Boolean) args[2]).booleanValue()) {
                return;
            }
            long jLongValue = ((Long) args[1]).longValue();
            ArrayList arrayList2 = (ArrayList) args[0];
            MessageObject messageObject2 = this.playingMessageObject;
            if (messageObject2 != null && jLongValue == messageObject2.messageOwner.peer_id.channel_id && arrayList2.contains(Integer.valueOf(messageObject2.getId()))) {
                cleanupPlayer(true, true);
            }
            ArrayList<MessageObject> arrayList3 = this.voiceMessagesPlaylist;
            if (arrayList3 == null || arrayList3.isEmpty() || jLongValue != this.voiceMessagesPlaylist.get(0).messageOwner.peer_id.channel_id) {
                return;
            }
            while (i < arrayList2.size()) {
                Integer num = (Integer) arrayList2.get(i);
                MessageObject messageObject3 = this.voiceMessagesPlaylistMap.get(num.intValue());
                this.voiceMessagesPlaylistMap.remove(num.intValue());
                if (messageObject3 != null) {
                    this.voiceMessagesPlaylist.remove(messageObject3);
                }
                i++;
            }
            return;
        }
        if (id == NotificationCenter.removeAllMessagesFromDialog) {
            long jLongValue2 = ((Long) args[0]).longValue();
            MessageObject messageObject4 = this.playingMessageObject;
            if (messageObject4 == null || messageObject4.getDialogId() != jLongValue2) {
                return;
            }
            cleanupPlayer(false, true);
            return;
        }
        if (id == NotificationCenter.musicDidLoad) {
            long jLongValue3 = ((Long) args[0]).longValue();
            MessageObject messageObject5 = this.playingMessageObject;
            if (messageObject5 == null || !messageObject5.isMusic() || this.playingMessageObject.getDialogId() != jLongValue3 || this.playingMessageObject.scheduled) {
                return;
            }
            ArrayList arrayList4 = (ArrayList) args[1];
            ArrayList arrayList5 = (ArrayList) args[2];
            this.playlist.addAll(0, arrayList4);
            this.playlist.addAll(arrayList5);
            int size = this.playlist.size();
            for (int i2 = 0; i2 < size; i2++) {
                MessageObject messageObject6 = this.playlist.get(i2);
                this.playlistMap.put(Integer.valueOf(messageObject6.getId()), messageObject6);
                int[] iArr = this.playlistMaxId;
                iArr[0] = Math.min(iArr[0], messageObject6.getId());
            }
            sortPlaylist();
            if (SharedConfig.shuffleMusic) {
                buildShuffledPlayList();
            } else {
                MessageObject messageObject7 = this.playingMessageObject;
                if (messageObject7 != null && (iIndexOf = this.playlist.indexOf(messageObject7)) >= 0) {
                    this.currentPlaylistNum = iIndexOf;
                }
            }
            this.playlistClassGuid = ConnectionsManager.generateClassGuid();
            return;
        }
        if (id == NotificationCenter.mediaDidLoad) {
            if (((Integer) args[3]).intValue() != this.playlistClassGuid || this.playingMessageObject == null) {
                return;
            }
            long jLongValue4 = ((Long) args[0]).longValue();
            ((Integer) args[4]).intValue();
            ArrayList arrayList6 = (ArrayList) args[2];
            DialogObject.isEncryptedDialog(jLongValue4);
            char c = jLongValue4 == this.playlistMergeDialogId ? (char) 1 : (char) 0;
            if (!arrayList6.isEmpty()) {
                this.playlistEndReached[c] = ((Boolean) args[5]).booleanValue();
            }
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList6.size(); i4++) {
                MessageObject messageObject8 = (MessageObject) arrayList6.get(i4);
                if (!this.playlistMap.containsKey(Integer.valueOf(messageObject8.getId()))) {
                    i3++;
                    this.playlist.add(0, messageObject8);
                    this.playlistMap.put(Integer.valueOf(messageObject8.getId()), messageObject8);
                    int[] iArr2 = this.playlistMaxId;
                    iArr2[c] = Math.min(iArr2[c], messageObject8.getId());
                }
            }
            sortPlaylist();
            int iIndexOf2 = this.playlist.indexOf(this.playingMessageObject);
            if (iIndexOf2 >= 0) {
                this.currentPlaylistNum = iIndexOf2;
            }
            this.loadingPlaylist = false;
            if (SharedConfig.shuffleMusic) {
                buildShuffledPlayList();
            }
            if (i3 != 0) {
                NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.moreMusicDidLoad, Integer.valueOf(i3));
                return;
            }
            return;
        }
        if (id == NotificationCenter.didReceiveNewMessages) {
            if (((Boolean) args[2]).booleanValue() || (arrayList = this.voiceMessagesPlaylist) == null || arrayList.isEmpty() || ((Long) args[0]).longValue() != this.voiceMessagesPlaylist.get(0).getDialogId()) {
                return;
            }
            ArrayList arrayList7 = (ArrayList) args[1];
            while (i < arrayList7.size()) {
                MessageObject messageObject9 = (MessageObject) arrayList7.get(i);
                if ((messageObject9.isVoice() || messageObject9.isRoundVideo()) && (!this.voiceMessagesPlaylistUnread || (messageObject9.isContentUnread() && !messageObject9.isOut()))) {
                    this.voiceMessagesPlaylist.add(messageObject9);
                    this.voiceMessagesPlaylistMap.put(messageObject9.getId(), messageObject9);
                }
                i++;
            }
            return;
        }
        if (id != NotificationCenter.playerDidStartPlaying || getInstance().isCurrentPlayer((VideoPlayer) args[0])) {
            return;
        }
        getInstance().lambda$startAudioAgain$7(getInstance().getPlayingMessageObject());
    }

    protected boolean isRecordingAudio() {
        return (this.recordStartRunnable == null && this.recordingAudio == null) ? false : true;
    }

    private boolean isNearToSensor(float value) {
        return value < 5.0f && value != this.proximitySensor.getMaximumRange();
    }

    public boolean isRecordingOrListeningByProximity() {
        MessageObject messageObject;
        return this.proximityTouched && (isRecordingAudio() || ((messageObject = this.playingMessageObject) != null && (messageObject.isVoice() || this.playingMessageObject.isRoundVideo())));
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) throws InterruptedException, IOException {
        double d;
        boolean z;
        int i;
        PowerManager.WakeLock wakeLock;
        PowerManager.WakeLock wakeLock2;
        PowerManager.WakeLock wakeLock3;
        PowerManager.WakeLock wakeLock4;
        PowerManager.WakeLock wakeLock5;
        if (this.sensorsStarted && VoIPService.getSharedInstance() == null) {
            Sensor sensor = event.sensor;
            if (sensor == this.proximitySensor) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("proximity changed to " + event.values[0] + " max value = " + this.proximitySensor.getMaximumRange());
                }
                float f = this.lastProximityValue;
                if (f == -100.0f) {
                    this.lastProximityValue = event.values[0];
                } else if (f != event.values[0]) {
                    this.proximityHasDifferentValues = true;
                }
                if (this.proximityHasDifferentValues) {
                    this.proximityTouched = isNearToSensor(event.values[0]);
                }
            } else if (sensor == this.accelerometerSensor) {
                long j = this.lastTimestamp;
                if (j == 0) {
                    d = 0.9800000190734863d;
                } else {
                    double d2 = event.timestamp - j;
                    Double.isNaN(d2);
                    d = 1.0d / ((d2 / 1.0E9d) + 1.0d);
                }
                this.lastTimestamp = event.timestamp;
                float[] fArr = this.gravity;
                double d3 = fArr[0];
                Double.isNaN(d3);
                double d4 = 1.0d - d;
                float[] fArr2 = event.values;
                double d5 = fArr2[0];
                Double.isNaN(d5);
                fArr[0] = (float) ((d3 * d) + (d5 * d4));
                double d6 = fArr[1];
                Double.isNaN(d6);
                double d7 = fArr2[1];
                Double.isNaN(d7);
                fArr[1] = (float) ((d6 * d) + (d7 * d4));
                double d8 = fArr[2];
                Double.isNaN(d8);
                double d9 = d * d8;
                double d10 = fArr2[2];
                Double.isNaN(d10);
                fArr[2] = (float) (d9 + (d4 * d10));
                float[] fArr3 = this.gravityFast;
                fArr3[0] = (fArr[0] * 0.8f) + (fArr2[0] * 0.19999999f);
                fArr3[1] = (fArr[1] * 0.8f) + (fArr2[1] * 0.19999999f);
                fArr3[2] = (fArr[2] * 0.8f) + (fArr2[2] * 0.19999999f);
                float[] fArr4 = this.linearAcceleration;
                fArr4[0] = fArr2[0] - fArr[0];
                fArr4[1] = fArr2[1] - fArr[1];
                fArr4[2] = fArr2[2] - fArr[2];
            } else if (sensor == this.linearSensor) {
                float[] fArr5 = this.linearAcceleration;
                float[] fArr6 = event.values;
                fArr5[0] = fArr6[0];
                fArr5[1] = fArr6[1];
                fArr5[2] = fArr6[2];
            } else if (sensor == this.gravitySensor) {
                float[] fArr7 = this.gravityFast;
                float[] fArr8 = this.gravity;
                float[] fArr9 = event.values;
                float f2 = fArr9[0];
                fArr8[0] = f2;
                fArr7[0] = f2;
                float f3 = fArr9[1];
                fArr8[1] = f3;
                fArr7[1] = f3;
                float f4 = fArr9[2];
                fArr8[2] = f4;
                fArr7[2] = f4;
            }
            Sensor sensor2 = event.sensor;
            if (sensor2 == this.linearSensor || sensor2 == this.gravitySensor || sensor2 == this.accelerometerSensor) {
                float[] fArr10 = this.gravity;
                float f5 = fArr10[0];
                float[] fArr11 = this.linearAcceleration;
                float f6 = (f5 * fArr11[0]) + (fArr10[1] * fArr11[1]) + (fArr10[2] * fArr11[2]);
                int i2 = this.raisedToBack;
                if (i2 != 6 && ((f6 > 0.0f && this.previousAccValue > 0.0f) || (f6 < 0.0f && this.previousAccValue < 0.0f))) {
                    if (f6 > 0.0f) {
                        z = f6 > 15.0f;
                        i = 1;
                    } else {
                        z = f6 < -15.0f;
                        i = 2;
                    }
                    int i3 = this.raisedToTopSign;
                    if (i3 != 0 && i3 != i) {
                        int i4 = this.raisedToTop;
                        if (i4 != 6 || !z) {
                            if (!z) {
                                this.countLess++;
                            }
                            if (this.countLess == 10 || i4 != 6 || i2 != 0) {
                                this.raisedToTop = 0;
                                this.raisedToTopSign = 0;
                                this.raisedToBack = 0;
                                this.countLess = 0;
                            }
                        } else if (i2 < 6) {
                            int i5 = i2 + 1;
                            this.raisedToBack = i5;
                            if (i5 == 6) {
                                this.raisedToTop = 0;
                                this.raisedToTopSign = 0;
                                this.countLess = 0;
                                this.timeSinceRaise = System.currentTimeMillis();
                                if (BuildVars.LOGS_ENABLED && BuildVars.DEBUG_PRIVATE_VERSION) {
                                    FileLog.d("motion detected");
                                }
                            }
                        }
                    } else if (z && i2 == 0 && (i3 == 0 || i3 == i)) {
                        int i6 = this.raisedToTop;
                        if (i6 < 6 && !this.proximityTouched) {
                            this.raisedToTopSign = i;
                            int i7 = i6 + 1;
                            this.raisedToTop = i7;
                            if (i7 == 6) {
                                this.countLess = 0;
                            }
                        }
                    } else {
                        if (!z) {
                            this.countLess++;
                        }
                        if (i3 != i || this.countLess == 10 || this.raisedToTop != 6 || i2 != 0) {
                            this.raisedToBack = 0;
                            this.raisedToTop = 0;
                            this.raisedToTopSign = 0;
                            this.countLess = 0;
                        }
                    }
                }
                this.previousAccValue = f6;
                float[] fArr12 = this.gravityFast;
                this.accelerometerVertical = fArr12[1] > 2.5f && Math.abs(fArr12[2]) < 4.0f && Math.abs(this.gravityFast[0]) > 1.5f;
            }
            if (this.raisedToBack == 6 && this.accelerometerVertical && this.proximityTouched && !NotificationsController.audioManager.isWiredHeadsetOn()) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("sensor values reached");
                }
                if (this.playingMessageObject == null && this.recordStartRunnable == null && this.recordingAudio == null && !PhotoViewer.getInstance().isVisible() && ApplicationLoader.isScreenOn && !this.inputFieldHasText && this.allowStartRecord && this.raiseChat != null && !this.callInProgress) {
                    if (!this.raiseToEarRecord) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("start record");
                        }
                        this.useFrontSpeaker = true;
                        if (!this.raiseChat.playFirstUnreadVoiceMessage()) {
                            this.raiseToEarRecord = true;
                            this.useFrontSpeaker = false;
                            startRecording(this.raiseChat.getCurrentAccount(), this.raiseChat.getDialogId(), null, this.raiseChat.getThreadMessage(), this.raiseChat.getClassGuid());
                        }
                        if (this.useFrontSpeaker) {
                            setUseFrontSpeaker(true);
                        }
                        this.ignoreOnPause = true;
                        if (this.proximityHasDifferentValues && (wakeLock5 = this.proximityWakeLock) != null && !wakeLock5.isHeld()) {
                            this.proximityWakeLock.acquire();
                        }
                    }
                } else {
                    MessageObject messageObject = this.playingMessageObject;
                    if (messageObject != null && ((messageObject.isVoice() || this.playingMessageObject.isRoundVideo()) && !this.useFrontSpeaker)) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("start listen");
                        }
                        if (this.proximityHasDifferentValues && (wakeLock4 = this.proximityWakeLock) != null && !wakeLock4.isHeld()) {
                            this.proximityWakeLock.acquire();
                        }
                        setUseFrontSpeaker(true);
                        startAudioAgain(false);
                        this.ignoreOnPause = true;
                    }
                }
                this.raisedToBack = 0;
                this.raisedToTop = 0;
                this.raisedToTopSign = 0;
                this.countLess = 0;
            } else {
                boolean z2 = this.proximityTouched;
                if (z2) {
                    if (this.playingMessageObject != null && !ApplicationLoader.mainInterfacePaused && ((this.playingMessageObject.isVoice() || this.playingMessageObject.isRoundVideo()) && SharedConfig.proximitysensor && !this.useFrontSpeaker && !NotificationsController.audioManager.isWiredHeadsetOn())) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("start listen by proximity only");
                        }
                        if (this.proximityHasDifferentValues && (wakeLock3 = this.proximityWakeLock) != null && !wakeLock3.isHeld()) {
                            this.proximityWakeLock.acquire();
                        }
                        setUseFrontSpeaker(true);
                        startAudioAgain(false);
                        this.ignoreOnPause = true;
                    }
                } else if (!z2) {
                    if (this.raiseToEarRecord) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("stop record");
                        }
                        stopRecording(2, false, 0);
                        this.raiseToEarRecord = false;
                        this.ignoreOnPause = false;
                        if (this.proximityHasDifferentValues && (wakeLock2 = this.proximityWakeLock) != null && wakeLock2.isHeld()) {
                            this.proximityWakeLock.release();
                        }
                    } else if (this.useFrontSpeaker) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("stop listen");
                        }
                        this.useFrontSpeaker = false;
                        startAudioAgain(true);
                        this.ignoreOnPause = false;
                        if (this.proximityHasDifferentValues && (wakeLock = this.proximityWakeLock) != null && wakeLock.isHeld()) {
                            this.proximityWakeLock.release();
                        }
                    }
                }
            }
            if (this.timeSinceRaise == 0 || this.raisedToBack != 6 || Math.abs(System.currentTimeMillis() - this.timeSinceRaise) <= 1000) {
                return;
            }
            this.raisedToBack = 0;
            this.raisedToTop = 0;
            this.raisedToTopSign = 0;
            this.countLess = 0;
            this.timeSinceRaise = 0L;
        }
    }

    private void setUseFrontSpeaker(boolean value) {
        this.useFrontSpeaker = value;
        AudioManager audioManager = NotificationsController.audioManager;
        if (value) {
            audioManager.setBluetoothScoOn(false);
            audioManager.setSpeakerphoneOn(false);
        } else {
            audioManager.setSpeakerphoneOn(true);
        }
    }

    public void startRecordingIfFromSpeaker() throws InterruptedException {
        ChatActivity chatActivity;
        if (this.useFrontSpeaker && (chatActivity = this.raiseChat) != null && this.allowStartRecord && SharedConfig.raiseToSpeak) {
            this.raiseToEarRecord = true;
            startRecording(chatActivity.getCurrentAccount(), this.raiseChat.getDialogId(), null, this.raiseChat.getThreadMessage(), this.raiseChat.getClassGuid());
            this.ignoreOnPause = true;
        }
    }

    private void startAudioAgain(boolean paused) throws InterruptedException, IOException {
        MessageObject messageObject = this.playingMessageObject;
        if (messageObject == null) {
            return;
        }
        NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.audioRouteChanged, Boolean.valueOf(this.useFrontSpeaker));
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setStreamType(this.useFrontSpeaker ? 0 : 3);
            if (!paused) {
                if (this.videoPlayer.getCurrentPosition() < 1000) {
                    this.videoPlayer.seekTo(0L);
                }
                this.videoPlayer.play();
                return;
            }
            lambda$startAudioAgain$7(this.playingMessageObject);
            return;
        }
        VideoPlayer videoPlayer2 = this.audioPlayer;
        boolean z = videoPlayer2 != null;
        final MessageObject messageObject2 = this.playingMessageObject;
        float f = messageObject2.audioProgress;
        int i = messageObject2.audioPlayerDuration;
        if (paused || videoPlayer2 == null || !videoPlayer2.isPlaying() || i * f > VOLUME_NORMAL) {
            messageObject2.audioProgress = f;
        } else {
            messageObject2.audioProgress = 0.0f;
        }
        cleanupPlayer(false, true);
        playMessage(messageObject2);
        if (paused) {
            if (z) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$3VXXnD4J3TmQcQtpitMHZNycZXk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$startAudioAgain$7$MediaController(messageObject2);
                    }
                }, 100L);
            } else {
                lambda$startAudioAgain$7(messageObject2);
            }
        }
    }

    public void setInputFieldHasText(boolean value) {
        this.inputFieldHasText = value;
    }

    public void setAllowStartRecord(boolean value) {
        this.allowStartRecord = value;
    }

    public void startRaiseToEarSensors(ChatActivity chatActivity) {
        if (chatActivity != null) {
            if ((this.accelerometerSensor == null && (this.gravitySensor == null || this.linearAcceleration == null)) || this.proximitySensor == null) {
                return;
            }
            this.raiseChat = chatActivity;
            if (!SharedConfig.raiseToSpeak) {
                MessageObject messageObject = this.playingMessageObject;
                if (messageObject == null) {
                    return;
                }
                if (!messageObject.isVoice() && !this.playingMessageObject.isRoundVideo()) {
                    return;
                }
            }
            if (this.sensorsStarted) {
                return;
            }
            float[] fArr = this.gravity;
            fArr[2] = 0.0f;
            fArr[1] = 0.0f;
            fArr[0] = 0.0f;
            float[] fArr2 = this.linearAcceleration;
            fArr2[2] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[0] = 0.0f;
            float[] fArr3 = this.gravityFast;
            fArr3[2] = 0.0f;
            fArr3[1] = 0.0f;
            fArr3[0] = 0.0f;
            this.lastTimestamp = 0L;
            this.previousAccValue = 0.0f;
            this.raisedToTop = 0;
            this.raisedToTopSign = 0;
            this.countLess = 0;
            this.raisedToBack = 0;
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$3ltCetXKz9-6urh-plNQ77eCKSI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startRaiseToEarSensors$8$MediaController();
                }
            });
            this.sensorsStarted = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startRaiseToEarSensors$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startRaiseToEarSensors$8$MediaController() {
        Sensor sensor = this.gravitySensor;
        if (sensor != null) {
            this.sensorManager.registerListener(this, sensor, 30000);
        }
        Sensor sensor2 = this.linearSensor;
        if (sensor2 != null) {
            this.sensorManager.registerListener(this, sensor2, 30000);
        }
        Sensor sensor3 = this.accelerometerSensor;
        if (sensor3 != null) {
            this.sensorManager.registerListener(this, sensor3, 30000);
        }
        this.sensorManager.registerListener(this, this.proximitySensor, 3);
    }

    public void stopRaiseToEarSensors(ChatActivity chatActivity, boolean fromChat) throws InterruptedException {
        PowerManager.WakeLock wakeLock;
        if (this.ignoreOnPause) {
            this.ignoreOnPause = false;
            return;
        }
        stopRecording(fromChat ? 2 : 0, false, 0);
        if (!this.sensorsStarted || this.ignoreOnPause) {
            return;
        }
        if ((this.accelerometerSensor == null && (this.gravitySensor == null || this.linearAcceleration == null)) || this.proximitySensor == null || this.raiseChat != chatActivity) {
            return;
        }
        this.raiseChat = null;
        this.sensorsStarted = false;
        this.accelerometerVertical = false;
        this.proximityTouched = false;
        this.raiseToEarRecord = false;
        this.useFrontSpeaker = false;
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$EDzA4V5Ujggcb6COwpryIr5t34k
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopRaiseToEarSensors$9$MediaController();
            }
        });
        if (this.proximityHasDifferentValues && (wakeLock = this.proximityWakeLock) != null && wakeLock.isHeld()) {
            this.proximityWakeLock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$stopRaiseToEarSensors$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$stopRaiseToEarSensors$9$MediaController() {
        Sensor sensor = this.linearSensor;
        if (sensor != null) {
            this.sensorManager.unregisterListener(this, sensor);
        }
        Sensor sensor2 = this.gravitySensor;
        if (sensor2 != null) {
            this.sensorManager.unregisterListener(this, sensor2);
        }
        Sensor sensor3 = this.accelerometerSensor;
        if (sensor3 != null) {
            this.sensorManager.unregisterListener(this, sensor3);
        }
        this.sensorManager.unregisterListener(this, this.proximitySensor);
    }

    public void cleanupPlayer(boolean notify, boolean stopService) throws InterruptedException, IOException {
        cleanupPlayer(notify, stopService, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: Exception -> 0x0076, TryCatch #2 {Exception -> 0x0076, blocks: (B:4:0x000b, B:6:0x000f, B:8:0x0015, B:10:0x001b, B:16:0x0038, B:18:0x0049, B:21:0x0055, B:15:0x0030), top: B:118:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void cleanupPlayer(boolean r16, boolean r17, boolean r18, boolean r19) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 635
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.cleanupPlayer(boolean, boolean, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanupPlayer$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cleanupPlayer$10$MediaController(VideoPlayer videoPlayer, ValueAnimator valueAnimator) {
        videoPlayer.setVolume((this.audioFocus != 1 ? VOLUME_NORMAL : VOLUME_DUCK) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public boolean isGoingToShowMessageObject(MessageObject messageObject) {
        return this.goingToShowMessageObject == messageObject;
    }

    public void resetGoingToShowMessageObject() {
        this.goingToShowMessageObject = null;
    }

    private boolean isSamePlayingMessage(MessageObject messageObject) {
        MessageObject messageObject2 = this.playingMessageObject;
        if (messageObject2 != null && messageObject2.getDialogId() == messageObject.getDialogId() && this.playingMessageObject.getId() == messageObject.getId()) {
            if ((this.playingMessageObject.eventId == 0) == (messageObject.eventId == 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean seekToProgress(MessageObject messageObject, float progress) {
        if ((this.audioPlayer != null || this.videoPlayer != null) && messageObject != null && this.playingMessageObject != null && isSamePlayingMessage(messageObject)) {
            try {
                VideoPlayer videoPlayer = this.audioPlayer;
                if (videoPlayer != null) {
                    long duration = videoPlayer.getDuration();
                    if (duration == -9223372036854775807L) {
                        this.seekToProgressPending = progress;
                    } else {
                        this.playingMessageObject.audioProgress = progress;
                        long j = (int) (duration * progress);
                        this.audioPlayer.seekTo(j);
                        this.lastProgress = j;
                    }
                } else {
                    VideoPlayer videoPlayer2 = this.videoPlayer;
                    if (videoPlayer2 != null) {
                        videoPlayer2.seekTo((long) (videoPlayer2.getDuration() * progress));
                    }
                }
                NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingDidSeek, Integer.valueOf(this.playingMessageObject.getId()), Float.valueOf(progress));
                return true;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        return false;
    }

    public long getDuration() {
        VideoPlayer videoPlayer = this.audioPlayer;
        if (videoPlayer == null) {
            return 0L;
        }
        return videoPlayer.getDuration();
    }

    public MessageObject getPlayingMessageObject() {
        return this.playingMessageObject;
    }

    public int getPlayingMessageObjectNum() {
        return this.currentPlaylistNum;
    }

    private void buildShuffledPlayList() {
        if (this.playlist.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.playlist);
        this.shuffledPlaylist.clear();
        MessageObject messageObject = this.playlist.get(this.currentPlaylistNum);
        arrayList.remove(this.currentPlaylistNum);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int iNextInt = Utilities.random.nextInt(arrayList.size());
            this.shuffledPlaylist.add((MessageObject) arrayList.get(iNextInt));
            arrayList.remove(iNextInt);
        }
        this.shuffledPlaylist.add(messageObject);
        this.currentPlaylistNum = this.shuffledPlaylist.size() - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc A[PHI: r10
      0x00dc: PHI (r10v14 long) = (r10v6 long), (r10v7 long) binds: [B:32:0x00da, B:35:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadMoreMusic() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.loadMoreMusic():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMoreMusic$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMoreMusic$12$MediaController(final int i, final int i2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$n8cUwfeAB_Y-3yYMNgRZXOYke9Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMoreMusic$11$MediaController(i, tLRPC$TL_error, tLObject, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMoreMusic$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMoreMusic$11$MediaController(int i, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i2) {
        PlaylistGlobalSearchParams playlistGlobalSearchParams;
        if (this.playlistClassGuid != i || (playlistGlobalSearchParams = this.playlistGlobalSearchParams) == null || this.playingMessageObject == null || tLRPC$TL_error != null) {
            return;
        }
        this.loadingPlaylist = false;
        TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
        playlistGlobalSearchParams.nextSearchRate = tLRPC$messages_Messages.next_rate;
        MessagesStorage.getInstance(i2).putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
        MessagesController.getInstance(i2).putUsers(tLRPC$messages_Messages.users, false);
        MessagesController.getInstance(i2).putChats(tLRPC$messages_Messages.chats, false);
        int size = tLRPC$messages_Messages.messages.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            MessageObject messageObject = new MessageObject(i2, tLRPC$messages_Messages.messages.get(i4), false, true);
            if (!this.playlistMap.containsKey(Integer.valueOf(messageObject.getId()))) {
                this.playlist.add(0, messageObject);
                this.playlistMap.put(Integer.valueOf(messageObject.getId()), messageObject);
                i3++;
            }
        }
        sortPlaylist();
        this.loadingPlaylist = false;
        this.playlistGlobalSearchParams.endReached = this.playlist.size() == this.playlistGlobalSearchParams.totalCount;
        if (SharedConfig.shuffleMusic) {
            buildShuffledPlayList();
        }
        if (i3 != 0) {
            NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.moreMusicDidLoad, Integer.valueOf(i3));
        }
    }

    public boolean setPlaylist(ArrayList<MessageObject> messageObjects, MessageObject current, long mergeDialogId, PlaylistGlobalSearchParams globalSearchParams) {
        return setPlaylist(messageObjects, current, mergeDialogId, true, globalSearchParams);
    }

    public boolean setPlaylist(ArrayList<MessageObject> messageObjects, MessageObject current, long mergeDialogId) {
        return setPlaylist(messageObjects, current, mergeDialogId, true, null);
    }

    public boolean setPlaylist(ArrayList<MessageObject> messageObjects, MessageObject current, long mergeDialogId, boolean loadMusic, PlaylistGlobalSearchParams params) {
        if (this.playingMessageObject == current) {
            int iIndexOf = this.playlist.indexOf(current);
            if (iIndexOf >= 0) {
                this.currentPlaylistNum = iIndexOf;
            }
            return playMessage(current);
        }
        this.forceLoopCurrentPlaylist = !loadMusic;
        this.playlistMergeDialogId = mergeDialogId;
        this.playMusicAgain = !this.playlist.isEmpty();
        clearPlaylist();
        this.playlistGlobalSearchParams = params;
        boolean z = false;
        if (!messageObjects.isEmpty() && DialogObject.isEncryptedDialog(messageObjects.get(0).getDialogId())) {
            z = true;
        }
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        int iMax = Integer.MIN_VALUE;
        for (int size = messageObjects.size() - 1; size >= 0; size--) {
            MessageObject messageObject = messageObjects.get(size);
            if (messageObject.isMusic()) {
                int id = messageObject.getId();
                if (id > 0 || z) {
                    iMin = Math.min(iMin, id);
                    iMax = Math.max(iMax, id);
                }
                this.playlist.add(messageObject);
                this.playlistMap.put(Integer.valueOf(id), messageObject);
            }
        }
        sortPlaylist();
        int iIndexOf2 = this.playlist.indexOf(current);
        this.currentPlaylistNum = iIndexOf2;
        if (iIndexOf2 == -1) {
            clearPlaylist();
            this.currentPlaylistNum = this.playlist.size();
            this.playlist.add(current);
            this.playlistMap.put(Integer.valueOf(current.getId()), current);
        }
        if (current.isMusic() && !current.scheduled) {
            if (SharedConfig.shuffleMusic) {
                buildShuffledPlayList();
            }
            if (loadMusic) {
                if (this.playlistGlobalSearchParams == null) {
                    MediaDataController.getInstance(current.currentAccount).loadMusic(current.getDialogId(), iMin, iMax);
                } else {
                    this.playlistClassGuid = ConnectionsManager.generateClassGuid();
                }
            }
        }
        return playMessage(current);
    }

    private void sortPlaylist() {
        Collections.sort(this.playlist, $$Lambda$MediaController$6x1JY3qtzs45kyVSyjsGGBBQMo.INSTANCE);
    }

    static /* synthetic */ int lambda$sortPlaylist$13(MessageObject messageObject, MessageObject messageObject2) {
        int id = messageObject.getId();
        int id2 = messageObject2.getId();
        long j = messageObject.messageOwner.grouped_id;
        long j2 = messageObject2.messageOwner.grouped_id;
        if (id >= 0 || id2 >= 0) {
            if (j != 0 && j == j2) {
                return ChatObject$Call$$ExternalSynthetic0.m0(id2, id);
            }
            return ChatObject$Call$$ExternalSynthetic0.m0(id, id2);
        }
        if (j != 0 && j == j2) {
            return ChatObject$Call$$ExternalSynthetic0.m0(id, id2);
        }
        return ChatObject$Call$$ExternalSynthetic0.m0(id2, id);
    }

    public void playNextMessage() throws InterruptedException, IOException {
        playNextMessageWithoutOrder(false);
    }

    public boolean findMessageInPlaylistAndPlay(MessageObject messageObject) throws IOException {
        int iIndexOf = this.playlist.indexOf(messageObject);
        if (iIndexOf == -1) {
            return playMessage(messageObject);
        }
        playMessageAtIndex(iIndexOf);
        return true;
    }

    public void playMessageAtIndex(int index) throws IOException {
        int i = this.currentPlaylistNum;
        if (i < 0 || i >= this.playlist.size()) {
            return;
        }
        this.currentPlaylistNum = index;
        this.playMusicAgain = true;
        MessageObject messageObject = this.playlist.get(index);
        if (this.playingMessageObject != null && !isSamePlayingMessage(messageObject)) {
            this.playingMessageObject.resetPlayingProgress();
        }
        playMessage(messageObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playNextMessageWithoutOrder(boolean byStop) throws InterruptedException, IOException {
        boolean z;
        int i;
        ArrayList<MessageObject> arrayList = SharedConfig.shuffleMusic ? this.shuffledPlaylist : this.playlist;
        if (byStop && (((i = SharedConfig.repeatMode) == 2 || (i == 1 && arrayList.size() == 1)) && !this.forceLoopCurrentPlaylist)) {
            cleanupPlayer(false, false);
            MessageObject messageObject = arrayList.get(this.currentPlaylistNum);
            messageObject.audioProgress = 0.0f;
            messageObject.audioProgressSec = 0;
            playMessage(messageObject);
            return;
        }
        if (SharedConfig.playOrderReversed) {
            int i2 = this.currentPlaylistNum + 1;
            this.currentPlaylistNum = i2;
            if (i2 >= arrayList.size()) {
                this.currentPlaylistNum = 0;
                z = true;
            }
            z = false;
        } else {
            int i3 = this.currentPlaylistNum - 1;
            this.currentPlaylistNum = i3;
            if (i3 < 0) {
                this.currentPlaylistNum = arrayList.size() - 1;
                z = true;
            }
            z = false;
        }
        if (z && byStop && SharedConfig.repeatMode == 0 && !this.forceLoopCurrentPlaylist) {
            VideoPlayer videoPlayer = this.audioPlayer;
            if (videoPlayer == null && this.videoPlayer == null) {
                return;
            }
            if (videoPlayer != null) {
                try {
                    videoPlayer.releasePlayer(true);
                } catch (Exception e) {
                    FileLog.e(e);
                }
                this.audioPlayer = null;
                Theme.unrefAudioVisualizeDrawable(this.playingMessageObject);
            } else {
                this.currentAspectRatioFrameLayout = null;
                this.currentTextureViewContainer = null;
                this.currentAspectRatioFrameLayoutReady = false;
                this.currentTextureView = null;
                this.videoPlayer.releasePlayer(true);
                this.videoPlayer = null;
                try {
                    this.baseActivity.getWindow().clearFlags(128);
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
                AndroidUtilities.cancelRunOnUIThread(this.setLoadingRunnable);
                FileLoader.getInstance(this.playingMessageObject.currentAccount).removeLoadingVideo(this.playingMessageObject.getDocument(), true, false);
            }
            stopProgressTimer();
            this.lastProgress = 0L;
            this.isPaused = true;
            MessageObject messageObject2 = this.playingMessageObject;
            messageObject2.audioProgress = 0.0f;
            messageObject2.audioProgressSec = 0;
            NotificationCenter.getInstance(messageObject2.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Integer.valueOf(this.playingMessageObject.getId()), 0);
            NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingPlayStateChanged, Integer.valueOf(this.playingMessageObject.getId()));
            return;
        }
        int i4 = this.currentPlaylistNum;
        if (i4 < 0 || i4 >= arrayList.size()) {
            return;
        }
        MessageObject messageObject3 = this.playingMessageObject;
        if (messageObject3 != null) {
            messageObject3.resetPlayingProgress();
        }
        this.playMusicAgain = true;
        playMessage(arrayList.get(this.currentPlaylistNum));
    }

    public void playPreviousMessage() throws IOException {
        int i;
        ArrayList<MessageObject> arrayList = SharedConfig.shuffleMusic ? this.shuffledPlaylist : this.playlist;
        if (arrayList.isEmpty() || (i = this.currentPlaylistNum) < 0 || i >= arrayList.size()) {
            return;
        }
        MessageObject messageObject = arrayList.get(this.currentPlaylistNum);
        if (messageObject.audioProgressSec > 10) {
            seekToProgress(messageObject, 0.0f);
            return;
        }
        if (SharedConfig.playOrderReversed) {
            int i2 = this.currentPlaylistNum - 1;
            this.currentPlaylistNum = i2;
            if (i2 < 0) {
                this.currentPlaylistNum = arrayList.size() - 1;
            }
        } else {
            int i3 = this.currentPlaylistNum + 1;
            this.currentPlaylistNum = i3;
            if (i3 >= arrayList.size()) {
                this.currentPlaylistNum = 0;
            }
        }
        if (this.currentPlaylistNum >= arrayList.size()) {
            return;
        }
        this.playMusicAgain = true;
        playMessage(arrayList.get(this.currentPlaylistNum));
    }

    protected void checkIsNextMediaFileDownloaded() {
        MessageObject messageObject = this.playingMessageObject;
        if (messageObject == null || !messageObject.isMusic()) {
            return;
        }
        checkIsNextMusicFileDownloaded(this.playingMessageObject.currentAccount);
    }

    private void checkIsNextVoiceFileDownloaded(int currentAccount) {
        ArrayList<MessageObject> arrayList = this.voiceMessagesPlaylist;
        if (arrayList == null || arrayList.size() < 2) {
            return;
        }
        MessageObject messageObject = this.voiceMessagesPlaylist.get(1);
        String str = messageObject.messageOwner.attachPath;
        File file = null;
        if (str != null && str.length() > 0) {
            File file2 = new File(messageObject.messageOwner.attachPath);
            if (file2.exists()) {
                file = file2;
            }
        }
        File pathToMessage = file != null ? file : FileLoader.getPathToMessage(messageObject.messageOwner);
        pathToMessage.exists();
        if (pathToMessage == file || pathToMessage.exists()) {
            return;
        }
        FileLoader.getInstance(currentAccount).loadFile(messageObject.getDocument(), messageObject, 0, 0);
    }

    private void checkIsNextMusicFileDownloaded(int currentAccount) {
        int size;
        if (DownloadController.getInstance(currentAccount).canDownloadNextTrack()) {
            ArrayList<MessageObject> arrayList = SharedConfig.shuffleMusic ? this.shuffledPlaylist : this.playlist;
            if (arrayList == null || arrayList.size() < 2) {
                return;
            }
            if (SharedConfig.playOrderReversed) {
                size = this.currentPlaylistNum + 1;
                if (size >= arrayList.size()) {
                    size = 0;
                }
            } else {
                size = this.currentPlaylistNum - 1;
                if (size < 0) {
                    size = arrayList.size() - 1;
                }
            }
            if (size < 0 || size >= arrayList.size()) {
                return;
            }
            MessageObject messageObject = arrayList.get(size);
            File file = null;
            if (!TextUtils.isEmpty(messageObject.messageOwner.attachPath)) {
                File file2 = new File(messageObject.messageOwner.attachPath);
                if (file2.exists()) {
                    file = file2;
                }
            }
            File pathToMessage = file != null ? file : FileLoader.getPathToMessage(messageObject.messageOwner);
            pathToMessage.exists();
            if (pathToMessage == file || pathToMessage.exists() || !messageObject.isMusic()) {
                return;
            }
            FileLoader.getInstance(currentAccount).loadFile(messageObject.getDocument(), messageObject, 0, 0);
        }
    }

    public void setVoiceMessagesPlaylist(ArrayList<MessageObject> playlist, boolean unread) {
        this.voiceMessagesPlaylist = playlist;
        if (playlist != null) {
            this.voiceMessagesPlaylistUnread = unread;
            this.voiceMessagesPlaylistMap = new SparseArray<>();
            for (int i = 0; i < this.voiceMessagesPlaylist.size(); i++) {
                MessageObject messageObject = this.voiceMessagesPlaylist.get(i);
                this.voiceMessagesPlaylistMap.put(messageObject.getId(), messageObject);
            }
        }
    }

    private void checkAudioFocus(MessageObject messageObject) {
        int i;
        int iRequestAudioFocus;
        if (messageObject.isVoice() || messageObject.isRoundVideo()) {
            i = this.useFrontSpeaker ? 3 : 2;
        } else {
            i = 1;
        }
        if (this.hasAudioFocus != i) {
            this.hasAudioFocus = i;
            if (i == 3) {
                iRequestAudioFocus = NotificationsController.audioManager.requestAudioFocus(this, 0, 1);
            } else {
                iRequestAudioFocus = NotificationsController.audioManager.requestAudioFocus(this, 3, i == 2 ? 3 : 1);
            }
            if (iRequestAudioFocus == 1) {
                this.audioFocus = 2;
            }
        }
    }

    public void setCurrentVideoVisible(boolean visible) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.currentAspectRatioFrameLayout;
        if (aspectRatioFrameLayout == null) {
            return;
        }
        if (visible) {
            PipRoundVideoView pipRoundVideoView = this.pipRoundVideoView;
            if (pipRoundVideoView != null) {
                this.pipSwitchingState = 2;
                pipRoundVideoView.close(true);
                this.pipRoundVideoView = null;
                return;
            } else {
                if (aspectRatioFrameLayout.getParent() == null) {
                    this.currentTextureViewContainer.addView(this.currentAspectRatioFrameLayout);
                }
                this.videoPlayer.setTextureView(this.currentTextureView);
                return;
            }
        }
        if (aspectRatioFrameLayout.getParent() != null) {
            this.pipSwitchingState = 1;
            this.currentTextureViewContainer.removeView(this.currentAspectRatioFrameLayout);
            return;
        }
        if (this.pipRoundVideoView == null) {
            try {
                PipRoundVideoView pipRoundVideoView2 = new PipRoundVideoView();
                this.pipRoundVideoView = pipRoundVideoView2;
                pipRoundVideoView2.show(this.baseActivity, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$zBaeTld4RXWnbhnvKXmh6AEGnT8
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException, IOException {
                        this.f$0.lambda$setCurrentVideoVisible$14$MediaController();
                    }
                });
            } catch (Exception unused) {
                this.pipRoundVideoView = null;
            }
        }
        PipRoundVideoView pipRoundVideoView3 = this.pipRoundVideoView;
        if (pipRoundVideoView3 != null) {
            this.videoPlayer.setTextureView(pipRoundVideoView3.getTextureView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setCurrentVideoVisible$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setCurrentVideoVisible$14$MediaController() throws InterruptedException, IOException {
        cleanupPlayer(true, true);
    }

    public void setTextureView(TextureView textureView, AspectRatioFrameLayout aspectRatioFrameLayout, FrameLayout container, boolean set) {
        if (textureView == null) {
            return;
        }
        if (!set && this.currentTextureView == textureView) {
            this.pipSwitchingState = 1;
            this.currentTextureView = null;
            this.currentAspectRatioFrameLayout = null;
            this.currentTextureViewContainer = null;
            return;
        }
        if (this.videoPlayer == null || textureView == this.currentTextureView) {
            return;
        }
        this.isDrawingWasReady = aspectRatioFrameLayout != null && aspectRatioFrameLayout.isDrawingReady();
        this.currentTextureView = textureView;
        PipRoundVideoView pipRoundVideoView = this.pipRoundVideoView;
        if (pipRoundVideoView != null) {
            this.videoPlayer.setTextureView(pipRoundVideoView.getTextureView());
        } else {
            this.videoPlayer.setTextureView(textureView);
        }
        this.currentAspectRatioFrameLayout = aspectRatioFrameLayout;
        this.currentTextureViewContainer = container;
        if (!this.currentAspectRatioFrameLayoutReady || aspectRatioFrameLayout == null) {
            return;
        }
        aspectRatioFrameLayout.setAspectRatio(this.currentAspectRatioFrameLayoutRatio, this.currentAspectRatioFrameLayoutRotation);
    }

    public void setBaseActivity(Activity activity, boolean set) {
        if (set) {
            this.baseActivity = activity;
        } else if (this.baseActivity == activity) {
            this.baseActivity = null;
        }
    }

    public void setFeedbackView(View view, boolean set) {
        if (set) {
            this.feedbackView = view;
        } else if (this.feedbackView == view) {
            this.feedbackView = null;
        }
    }

    public void setPlaybackSpeed(boolean music, float speed) {
        if (music) {
            if (this.currentMusicPlaybackSpeed >= 6.0f && speed == VOLUME_NORMAL && this.playingMessageObject != null) {
                this.audioPlayer.pause();
                final MessageObject messageObject = this.playingMessageObject;
                final float f = messageObject.audioProgress;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$u3DkUbBuUsglgsaXxa4mp5QMoII
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setPlaybackSpeed$15$MediaController(messageObject, f);
                    }
                }, 50L);
            }
            this.currentMusicPlaybackSpeed = speed;
            if (Math.abs(speed - VOLUME_NORMAL) > 0.001f) {
                this.fastMusicPlaybackSpeed = speed;
            }
        } else {
            this.currentPlaybackSpeed = speed;
            if (Math.abs(speed - VOLUME_NORMAL) > 0.001f) {
                this.fastPlaybackSpeed = speed;
            }
        }
        VideoPlayer videoPlayer = this.audioPlayer;
        if (videoPlayer != null) {
            videoPlayer.setPlaybackSpeed(speed);
        } else {
            VideoPlayer videoPlayer2 = this.videoPlayer;
            if (videoPlayer2 != null) {
                videoPlayer2.setPlaybackSpeed(speed);
            }
        }
        MessagesController.getGlobalMainSettings().edit().putFloat(music ? "musicPlaybackSpeed" : "playbackSpeed", speed).putFloat(music ? "fastMusicPlaybackSpeed" : "fastPlaybackSpeed", music ? this.fastMusicPlaybackSpeed : this.fastPlaybackSpeed).commit();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.messagePlayingSpeedChanged, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setPlaybackSpeed$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setPlaybackSpeed$15$MediaController(MessageObject messageObject, float f) {
        if (this.audioPlayer == null || this.playingMessageObject == null || this.isPaused) {
            return;
        }
        if (isSamePlayingMessage(messageObject)) {
            seekToProgress(this.playingMessageObject, f);
        }
        this.audioPlayer.play();
    }

    public float getPlaybackSpeed(boolean music) {
        return music ? this.currentMusicPlaybackSpeed : this.currentPlaybackSpeed;
    }

    public float getFastPlaybackSpeed(boolean music) {
        return music ? this.fastMusicPlaybackSpeed : this.fastPlaybackSpeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoState(MessageObject messageObject, int[] playCount, boolean destroyAtEnd, boolean playWhenReady, int playbackState) throws InterruptedException, IOException {
        MessageObject messageObject2;
        if (this.videoPlayer == null) {
            return;
        }
        if (playbackState != 4 && playbackState != 1) {
            try {
                this.baseActivity.getWindow().addFlags(128);
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else {
            try {
                this.baseActivity.getWindow().clearFlags(128);
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        if (playbackState == 3) {
            this.playerWasReady = true;
            MessageObject messageObject3 = this.playingMessageObject;
            if (messageObject3 != null && (messageObject3.isVideo() || this.playingMessageObject.isRoundVideo())) {
                AndroidUtilities.cancelRunOnUIThread(this.setLoadingRunnable);
                FileLoader.getInstance(messageObject.currentAccount).removeLoadingVideo(this.playingMessageObject.getDocument(), true, false);
            }
            this.currentAspectRatioFrameLayoutReady = true;
            return;
        }
        if (playbackState == 2) {
            if (!playWhenReady || (messageObject2 = this.playingMessageObject) == null) {
                return;
            }
            if (messageObject2.isVideo() || this.playingMessageObject.isRoundVideo()) {
                if (this.playerWasReady) {
                    this.setLoadingRunnable.run();
                    return;
                } else {
                    AndroidUtilities.runOnUIThread(this.setLoadingRunnable, 1000L);
                    return;
                }
            }
            return;
        }
        if (this.videoPlayer.isPlaying() && playbackState == 4) {
            if (this.playingMessageObject.isVideo() && !destroyAtEnd && (playCount == null || playCount[0] < 4)) {
                this.videoPlayer.seekTo(0L);
                if (playCount != null) {
                    playCount[0] = playCount[0] + 1;
                    return;
                }
                return;
            }
            cleanupPlayer(true, true, true, false);
        }
    }

    public void injectVideoPlayer(VideoPlayer player, MessageObject messageObject) {
        if (player == null || messageObject == null) {
            return;
        }
        FileLoader.getInstance(messageObject.currentAccount).setLoadingVideoForPlayer(messageObject.getDocument(), true);
        this.playerWasReady = false;
        clearPlaylist();
        this.videoPlayer = player;
        this.playingMessageObject = messageObject;
        int i = this.playerNum + 1;
        this.playerNum = i;
        player.setDelegate(new AnonymousClass7(i, messageObject, null, true));
        this.currentAspectRatioFrameLayoutReady = false;
        TextureView textureView = this.currentTextureView;
        if (textureView != null) {
            this.videoPlayer.setTextureView(textureView);
        }
        checkAudioFocus(messageObject);
        setPlayerVolume();
        this.isPaused = false;
        this.lastProgress = 0L;
        this.playingMessageObject = messageObject;
        if (!SharedConfig.raiseToSpeak) {
            startRaiseToEarSensors(this.raiseChat);
        }
        startProgressTimer(this.playingMessageObject);
        NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingDidStart, messageObject);
    }

    /* renamed from: ir.eitaa.messenger.MediaController$7, reason: invalid class name */
    class AnonymousClass7 implements VideoPlayer.VideoPlayerDelegate {
        final /* synthetic */ boolean val$destroyAtEnd;
        final /* synthetic */ MessageObject val$messageObject;
        final /* synthetic */ int[] val$playCount;
        final /* synthetic */ int val$tag;

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        AnonymousClass7(final int val$tag, final MessageObject val$messageObject, final int[] val$playCount, final boolean val$destroyAtEnd) {
            this.val$tag = val$tag;
            this.val$messageObject = val$messageObject;
            this.val$playCount = val$playCount;
            this.val$destroyAtEnd = val$destroyAtEnd;
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean playWhenReady, int playbackState) throws InterruptedException, IOException {
            if (this.val$tag != MediaController.this.playerNum) {
                return;
            }
            MediaController.this.updateVideoState(this.val$messageObject, this.val$playCount, this.val$destroyAtEnd, playWhenReady, playbackState);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer player, Exception e) {
            FileLog.e(e);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
            MediaController.this.currentAspectRatioFrameLayoutRotation = unappliedRotationDegrees;
            if (unappliedRotationDegrees != 90 && unappliedRotationDegrees != 270) {
                height = width;
                width = height;
            }
            MediaController.this.currentAspectRatioFrameLayoutRatio = width == 0 ? MediaController.VOLUME_NORMAL : (height * pixelWidthHeightRatio) / width;
            if (MediaController.this.currentAspectRatioFrameLayout != null) {
                MediaController.this.currentAspectRatioFrameLayout.setAspectRatio(MediaController.this.currentAspectRatioFrameLayoutRatio, MediaController.this.currentAspectRatioFrameLayoutRotation);
            }
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
            if (MediaController.this.currentAspectRatioFrameLayout == null || MediaController.this.currentAspectRatioFrameLayout.isDrawingReady()) {
                return;
            }
            MediaController.this.isDrawingWasReady = true;
            MediaController.this.currentAspectRatioFrameLayout.setDrawingReady(true);
            MediaController.this.currentTextureViewContainer.setTag(1);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
            if (MediaController.this.videoPlayer == null) {
                return false;
            }
            if (MediaController.this.pipSwitchingState == 2) {
                if (MediaController.this.currentAspectRatioFrameLayout != null) {
                    if (MediaController.this.isDrawingWasReady) {
                        MediaController.this.currentAspectRatioFrameLayout.setDrawingReady(true);
                    }
                    if (MediaController.this.currentAspectRatioFrameLayout.getParent() == null) {
                        MediaController.this.currentTextureViewContainer.addView(MediaController.this.currentAspectRatioFrameLayout);
                    }
                    if (MediaController.this.currentTextureView.getSurfaceTexture() != surfaceTexture) {
                        MediaController.this.currentTextureView.setSurfaceTexture(surfaceTexture);
                    }
                    MediaController.this.videoPlayer.setTextureView(MediaController.this.currentTextureView);
                }
                MediaController.this.pipSwitchingState = 0;
                return true;
            }
            if (MediaController.this.pipSwitchingState == 1) {
                if (MediaController.this.baseActivity != null) {
                    if (MediaController.this.pipRoundVideoView == null) {
                        try {
                            MediaController.this.pipRoundVideoView = new PipRoundVideoView();
                            MediaController.this.pipRoundVideoView.show(MediaController.this.baseActivity, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$7$4KCw7WNPAwwlqTI98RBDrSgEQZQ
                                @Override // java.lang.Runnable
                                public final void run() throws InterruptedException, IOException {
                                    this.f$0.lambda$onSurfaceDestroyed$0$MediaController$7();
                                }
                            });
                        } catch (Exception unused) {
                            MediaController.this.pipRoundVideoView = null;
                        }
                    }
                    if (MediaController.this.pipRoundVideoView != null) {
                        if (MediaController.this.pipRoundVideoView.getTextureView().getSurfaceTexture() != surfaceTexture) {
                            MediaController.this.pipRoundVideoView.getTextureView().setSurfaceTexture(surfaceTexture);
                        }
                        MediaController.this.videoPlayer.setTextureView(MediaController.this.pipRoundVideoView.getTextureView());
                    }
                }
                MediaController.this.pipSwitchingState = 0;
                return true;
            }
            if (!PhotoViewer.hasInstance() || !PhotoViewer.getInstance().isInjectingVideoPlayer()) {
                return false;
            }
            PhotoViewer.getInstance().injectVideoPlayerSurface(surfaceTexture);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onSurfaceDestroyed$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onSurfaceDestroyed$0$MediaController$7() throws InterruptedException, IOException {
            MediaController.this.cleanupPlayer(true, true);
        }
    }

    public void playEmojiSound(final AccountInstance accountInstance, String emoji, final MessagesController.EmojiSound sound, final boolean loadOnly) {
        if (sound == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$Ddsj7ou_iWCvJbYw5KbimM5MKBk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playEmojiSound$18$MediaController(sound, accountInstance, loadOnly);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$playEmojiSound$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$playEmojiSound$18$MediaController(MessagesController.EmojiSound emojiSound, final AccountInstance accountInstance, boolean z) {
        final TLRPC$TL_document tLRPC$TL_document = new TLRPC$TL_document();
        tLRPC$TL_document.access_hash = emojiSound.accessHash;
        tLRPC$TL_document.id = emojiSound.id;
        tLRPC$TL_document.mime_type = "sound/ogg";
        tLRPC$TL_document.file_reference = emojiSound.fileReference;
        tLRPC$TL_document.dc_id = accountInstance.getConnectionsManager().getCurrentDatacenterId();
        final File pathToAttach = FileLoader.getPathToAttach(tLRPC$TL_document, true);
        if (!pathToAttach.exists()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$Zwyi0W8LREJym3DOyzc225xz7NI
                @Override // java.lang.Runnable
                public final void run() {
                    accountInstance.getFileLoader().loadFile(tLRPC$TL_document, null, 1, 1);
                }
            });
        } else {
            if (z) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$nedg77PwgvrJ5fzSW9DeRgnKD0Y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$playEmojiSound$16$MediaController(pathToAttach);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$playEmojiSound$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$playEmojiSound$16$MediaController(File file) {
        try {
            int i = this.emojiSoundPlayerNum + 1;
            this.emojiSoundPlayerNum = i;
            VideoPlayer videoPlayer = this.emojiSoundPlayer;
            if (videoPlayer != null) {
                videoPlayer.releasePlayer(true);
            }
            VideoPlayer videoPlayer2 = new VideoPlayer(false);
            this.emojiSoundPlayer = videoPlayer2;
            videoPlayer2.setDelegate(new AnonymousClass8(i));
            this.emojiSoundPlayer.preparePlayer(Uri.fromFile(file), "other");
            this.emojiSoundPlayer.setStreamType(3);
            this.emojiSoundPlayer.play();
        } catch (Exception e) {
            FileLog.e(e);
            VideoPlayer videoPlayer3 = this.emojiSoundPlayer;
            if (videoPlayer3 != null) {
                videoPlayer3.releasePlayer(true);
                this.emojiSoundPlayer = null;
            }
        }
    }

    /* renamed from: ir.eitaa.messenger.MediaController$8, reason: invalid class name */
    class AnonymousClass8 implements VideoPlayer.VideoPlayerDelegate {
        final /* synthetic */ int val$tag;

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer player, Exception e) {
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
        }

        AnonymousClass8(final int val$tag) {
            this.val$tag = val$tag;
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean playWhenReady, final int playbackState) {
            final int i = this.val$tag;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$8$6MxjLGdq1L8yurB2ag6cOEwxD44
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStateChanged$0$MediaController$8(i, playbackState);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onStateChanged$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onStateChanged$0$MediaController$8(int i, int i2) {
            if (i == MediaController.this.emojiSoundPlayerNum && i2 == 4 && MediaController.this.emojiSoundPlayer != null) {
                try {
                    MediaController.this.emojiSoundPlayer.releasePlayer(true);
                    MediaController.this.emojiSoundPlayer = null;
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }
    }

    public boolean playMessage(final MessageObject messageObject) throws IOException {
        File file;
        boolean zExists;
        PowerManager.WakeLock wakeLock;
        if (messageObject == null) {
            return false;
        }
        if ((this.audioPlayer != null || this.videoPlayer != null) && isSamePlayingMessage(messageObject)) {
            if (this.isPaused) {
                resumeAudio(messageObject);
            }
            if (!SharedConfig.raiseToSpeak) {
                startRaiseToEarSensors(this.raiseChat);
            }
            return true;
        }
        if (!messageObject.isOut() && messageObject.isContentUnread()) {
            MessagesController.getInstance(messageObject.currentAccount).markMessageContentAsRead(messageObject);
        }
        boolean z = this.playMusicAgain;
        boolean z2 = !z;
        MessageObject messageObject2 = this.playingMessageObject;
        if (messageObject2 != null) {
            if (!z) {
                messageObject2.resetPlayingProgress();
                NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Integer.valueOf(this.playingMessageObject.getId()), 0);
            }
            z2 = false;
        }
        cleanupPlayer(z2, false);
        this.shouldSavePositionForCurrentAudio = null;
        this.lastSaveTime = 0L;
        this.playMusicAgain = false;
        this.seekToProgressPending = 0.0f;
        String str = messageObject.messageOwner.attachPath;
        if (str == null || str.length() <= 0) {
            file = null;
            zExists = false;
        } else {
            file = new File(messageObject.messageOwner.attachPath);
            zExists = file.exists();
            if (!zExists) {
                file = null;
            }
        }
        final File pathToMessage = file != null ? file : FileLoader.getPathToMessage(messageObject.messageOwner);
        boolean z3 = SharedConfig.streamMedia && (messageObject.isMusic() || messageObject.isRoundVideo() || (messageObject.isVideo() && messageObject.canStreamVideo())) && !DialogObject.isEncryptedDialog(messageObject.getDialogId());
        if (pathToMessage != file && !(zExists = pathToMessage.exists()) && !z3) {
            FileLoader.getInstance(messageObject.currentAccount).loadFile(messageObject.getDocument(), messageObject, 0, 0);
            this.downloadingCurrentMessage = true;
            this.isPaused = false;
            this.lastProgress = 0L;
            this.audioInfo = null;
            this.playingMessageObject = messageObject;
            if (messageObject.isMusic()) {
                try {
                    ApplicationLoader.applicationContext.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) MusicPlayerService.class));
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            } else {
                ApplicationLoader.applicationContext.stopService(new Intent(ApplicationLoader.applicationContext, (Class<?>) MusicPlayerService.class));
            }
            NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingPlayStateChanged, Integer.valueOf(this.playingMessageObject.getId()));
            return true;
        }
        boolean z4 = zExists;
        this.downloadingCurrentMessage = false;
        if (messageObject.isMusic()) {
            checkIsNextMusicFileDownloaded(messageObject.currentAccount);
        } else {
            checkIsNextVoiceFileDownloaded(messageObject.currentAccount);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.currentAspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            this.isDrawingWasReady = false;
            aspectRatioFrameLayout.setDrawingReady(false);
        }
        boolean zIsVideo = messageObject.isVideo();
        if (messageObject.isRoundVideo() || zIsVideo) {
            final File file2 = pathToMessage;
            FileLoader.getInstance(messageObject.currentAccount).setLoadingVideoForPlayer(messageObject.getDocument(), true);
            this.playerWasReady = false;
            boolean z5 = !zIsVideo || (messageObject.messageOwner.peer_id.channel_id == 0 && messageObject.audioProgress <= 0.1f);
            int[] iArr = (!zIsVideo || messageObject.getDuration() > 30) ? null : new int[]{1};
            clearPlaylist();
            VideoPlayer videoPlayer = new VideoPlayer();
            this.videoPlayer = videoPlayer;
            int i = this.playerNum + 1;
            this.playerNum = i;
            videoPlayer.setDelegate(new AnonymousClass9(i, messageObject, iArr, z5));
            this.currentAspectRatioFrameLayoutReady = false;
            if (this.pipRoundVideoView != null || !MessagesController.getInstance(messageObject.currentAccount).isDialogVisible(messageObject.getDialogId(), messageObject.scheduled)) {
                if (this.pipRoundVideoView == null) {
                    try {
                        PipRoundVideoView pipRoundVideoView = new PipRoundVideoView();
                        this.pipRoundVideoView = pipRoundVideoView;
                        pipRoundVideoView.show(this.baseActivity, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$araH5TKUOSBdnIyqzNe1ON66ueg
                            @Override // java.lang.Runnable
                            public final void run() throws InterruptedException, IOException {
                                this.f$0.lambda$playMessage$19$MediaController();
                            }
                        });
                    } catch (Exception unused) {
                        this.pipRoundVideoView = null;
                    }
                }
                PipRoundVideoView pipRoundVideoView2 = this.pipRoundVideoView;
                if (pipRoundVideoView2 != null) {
                    this.videoPlayer.setTextureView(pipRoundVideoView2.getTextureView());
                }
            } else {
                TextureView textureView = this.currentTextureView;
                if (textureView != null) {
                    this.videoPlayer.setTextureView(textureView);
                }
            }
            if (z4) {
                if (!messageObject.mediaExists && file2 != file) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$cEl93DQ5S76IODUfHHsvBczke3g
                        @Override // java.lang.Runnable
                        public final void run() {
                            MessageObject messageObject3 = messageObject;
                            NotificationCenter.getInstance(messageObject3.currentAccount).postNotificationName(NotificationCenter.fileLoaded, FileLoader.getAttachFileName(messageObject3.getDocument()), file2);
                        }
                    });
                }
                this.videoPlayer.preparePlayer(Uri.fromFile(file2), "other");
            } else {
                try {
                    int fileReference = FileLoader.getInstance(messageObject.currentAccount).getFileReference(messageObject);
                    TLRPC$Document document = messageObject.getDocument();
                    StringBuilder sb = new StringBuilder();
                    sb.append("?account=");
                    sb.append(messageObject.currentAccount);
                    sb.append("&id=");
                    sb.append(document.id);
                    sb.append("&hash=");
                    sb.append(document.access_hash);
                    sb.append("&dc=");
                    sb.append(document.dc_id);
                    sb.append("&size=");
                    sb.append(document.size);
                    sb.append("&mime=");
                    sb.append(URLEncoder.encode(document.mime_type, "UTF-8"));
                    sb.append("&rid=");
                    sb.append(fileReference);
                    sb.append("&name=");
                    sb.append(URLEncoder.encode(FileLoader.getDocumentFileName(document), "UTF-8"));
                    sb.append("&reference=");
                    byte[] bArr = document.file_reference;
                    if (bArr == null) {
                        bArr = new byte[0];
                    }
                    sb.append(Utilities.bytesToHex(bArr));
                    this.videoPlayer.preparePlayer(Uri.parse("et://" + messageObject.getFileName() + sb.toString()), "other");
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            try {
                SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("AudioPlayerConfig", 0);
                boolean z6 = sharedPreferences.getBoolean("showDialogOnPressedButton", false);
                sharedPreferences.edit().putBoolean("showDialogOnPressedButton", false).apply();
                int i2 = sharedPreferences.getInt("current_position" + file2.getName(), -1);
                if (z6) {
                    long j = i2;
                    if (this.audioPlayer.getDuration() > j && i2 > 0) {
                        this.audioPlayer.seekTo(j);
                    }
                }
            } catch (Exception e2) {
                FileLog.e("resume audio", e2);
            }
            if (messageObject.isRoundVideo()) {
                this.videoPlayer.setStreamType(this.useFrontSpeaker ? 0 : 3);
                if (Math.abs(this.currentPlaybackSpeed - VOLUME_NORMAL) > 0.001f) {
                    this.videoPlayer.setPlaybackSpeed(this.currentPlaybackSpeed);
                }
                float f = messageObject.forceSeekTo;
                if (f >= 0.0f) {
                    this.seekToProgressPending = f;
                    messageObject.audioProgress = f;
                    messageObject.forceSeekTo = -1.0f;
                }
            } else {
                this.videoPlayer.setStreamType(3);
            }
        } else {
            PipRoundVideoView pipRoundVideoView3 = this.pipRoundVideoView;
            if (pipRoundVideoView3 != null) {
                pipRoundVideoView3.close(true);
                this.pipRoundVideoView = null;
            }
            try {
                VideoPlayer videoPlayer2 = new VideoPlayer();
                this.audioPlayer = videoPlayer2;
                final int i3 = this.playerNum + 1;
                this.playerNum = i3;
                videoPlayer2.setDelegate(new VideoPlayer.VideoPlayerDelegate() { // from class: ir.eitaa.messenger.MediaController.10
                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onError(VideoPlayer player, Exception e3) {
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onRenderedFirstFrame() {
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public /* bridge */ /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
                        VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public /* bridge */ /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
                        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public /* bridge */ /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
                        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
                        return false;
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onStateChanged(boolean playWhenReady, int playbackState) throws InterruptedException, IOException {
                        if (i3 != MediaController.this.playerNum) {
                            return;
                        }
                        if (playbackState != 4 && ((playbackState != 1 && playbackState != 2) || !playWhenReady || messageObject.audioProgress < 0.999f)) {
                            if (MediaController.this.audioPlayer == null || MediaController.this.seekToProgressPending == 0.0f) {
                                return;
                            }
                            if (playbackState == 3 || playbackState == 1) {
                                long duration = (int) (MediaController.this.audioPlayer.getDuration() * MediaController.this.seekToProgressPending);
                                MediaController.this.audioPlayer.seekTo(duration);
                                MediaController.this.lastProgress = duration;
                                MediaController.this.seekToProgressPending = 0.0f;
                                return;
                            }
                            return;
                        }
                        MessageObject messageObject3 = messageObject;
                        messageObject3.audioProgress = MediaController.VOLUME_NORMAL;
                        NotificationCenter.getInstance(messageObject3.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Integer.valueOf(messageObject.getId()), 0);
                        if (!MediaController.this.playlist.isEmpty() && (MediaController.this.playlist.size() > 1 || !messageObject.isVoice())) {
                            MediaController.this.playNextMessageWithoutOrder(true);
                        } else {
                            MediaController.this.cleanupPlayer(true, true, messageObject.isVoice(), false);
                        }
                    }
                });
                this.audioPlayer.setAudioVisualizerDelegate(new VideoPlayer.AudioVisualizerDelegate() { // from class: ir.eitaa.messenger.MediaController.11
                    @Override // ir.eitaa.ui.Components.VideoPlayer.AudioVisualizerDelegate
                    public void onVisualizerUpdate(boolean playing, boolean animate, float[] values) {
                        Theme.getCurrentAudiVisualizerDrawable().setWaveform(playing, animate, values);
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.AudioVisualizerDelegate
                    public boolean needUpdate() {
                        return Theme.getCurrentAudiVisualizerDrawable().getParentView() != null;
                    }
                });
                if (z4) {
                    if (!messageObject.mediaExists && pathToMessage != file) {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$OXxQ5q9fC3pvf2Rv-4pOMhVeKok
                            @Override // java.lang.Runnable
                            public final void run() {
                                MessageObject messageObject3 = messageObject;
                                NotificationCenter.getInstance(messageObject3.currentAccount).postNotificationName(NotificationCenter.fileLoaded, FileLoader.getAttachFileName(messageObject3.getDocument()), pathToMessage);
                            }
                        });
                    }
                    this.audioPlayer.preparePlayer(Uri.fromFile(pathToMessage), "other");
                    this.isStreamingCurrentAudio = false;
                } else {
                    int fileReference2 = FileLoader.getInstance(messageObject.currentAccount).getFileReference(messageObject);
                    TLRPC$Document document2 = messageObject.getDocument();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("?account=");
                    sb2.append(messageObject.currentAccount);
                    sb2.append("&id=");
                    sb2.append(document2.id);
                    sb2.append("&hash=");
                    sb2.append(document2.access_hash);
                    sb2.append("&dc=");
                    sb2.append(document2.dc_id);
                    sb2.append("&size=");
                    sb2.append(document2.size);
                    sb2.append("&mime=");
                    sb2.append(URLEncoder.encode(document2.mime_type, "UTF-8"));
                    sb2.append("&rid=");
                    sb2.append(fileReference2);
                    sb2.append("&name=");
                    sb2.append(URLEncoder.encode(FileLoader.getDocumentFileName(document2), "UTF-8"));
                    sb2.append("&reference=");
                    byte[] bArr2 = document2.file_reference;
                    if (bArr2 == null) {
                        bArr2 = new byte[0];
                    }
                    sb2.append(Utilities.bytesToHex(bArr2));
                    this.audioPlayer.preparePlayer(Uri.parse("et://" + messageObject.getFileName() + sb2.toString()), "other");
                    this.isStreamingCurrentAudio = true;
                }
                if (messageObject.isVoice()) {
                    String fileName = messageObject.getFileName();
                    if (fileName != null && messageObject.getDuration() >= 300) {
                        float f2 = ApplicationLoader.applicationContext.getSharedPreferences("media_saved_pos", 0).getFloat(fileName, -1.0f);
                        if (f2 > 0.0f && f2 < 0.99f) {
                            this.seekToProgressPending = f2;
                            messageObject.audioProgress = f2;
                        }
                        this.shouldSavePositionForCurrentAudio = fileName;
                    }
                    if (Math.abs(this.currentPlaybackSpeed - VOLUME_NORMAL) > 0.001f) {
                        this.audioPlayer.setPlaybackSpeed(this.currentPlaybackSpeed);
                    }
                    this.audioInfo = null;
                    clearPlaylist();
                } else {
                    try {
                        this.audioInfo = AudioInfo.getAudioInfo(pathToMessage);
                    } catch (Exception e3) {
                        FileLog.e(e3);
                    }
                    String fileName2 = messageObject.getFileName();
                    if (!TextUtils.isEmpty(fileName2)) {
                        SharedPreferences sharedPreferences2 = ApplicationLoader.applicationContext.getSharedPreferences("media_saved_pos", 0);
                        boolean z7 = sharedPreferences2.getBoolean("canResumeAudio", false);
                        sharedPreferences2.edit().putBoolean("canResumeAudio", false).apply();
                        float f3 = sharedPreferences2.getFloat(fileName2, -1.0f);
                        int duration = messageObject.getDuration();
                        if (z7 && f3 > 0.0f && f3 < 0.999f && duration * f3 < duration - 2) {
                            this.seekToProgressPending = f3;
                            messageObject.audioProgress = f3;
                        }
                        this.shouldSavePositionForCurrentAudio = fileName2;
                        if (Math.abs(this.currentMusicPlaybackSpeed - VOLUME_NORMAL) > 0.001f) {
                            this.audioPlayer.setPlaybackSpeed(this.currentMusicPlaybackSpeed);
                        }
                    }
                }
                float f4 = messageObject.forceSeekTo;
                if (f4 >= 0.0f) {
                    this.seekToProgressPending = f4;
                    messageObject.audioProgress = f4;
                    messageObject.forceSeekTo = -1.0f;
                }
                this.audioPlayer.setStreamType(this.useFrontSpeaker ? 0 : 3);
                this.audioPlayer.play();
                if (!messageObject.isVoice()) {
                    ValueAnimator valueAnimator = this.audioVolumeAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.removeAllListeners();
                        this.audioVolumeAnimator.cancel();
                    }
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.audioVolume, VOLUME_NORMAL);
                    this.audioVolumeAnimator = valueAnimatorOfFloat;
                    valueAnimatorOfFloat.addUpdateListener(this.audioVolumeUpdateListener);
                    this.audioVolumeAnimator.setDuration(300L);
                    this.audioVolumeAnimator.start();
                } else {
                    this.audioVolume = VOLUME_NORMAL;
                    setPlayerVolume();
                }
            } catch (Exception e4) {
                FileLog.e(e4);
                NotificationCenter notificationCenter = NotificationCenter.getInstance(messageObject.currentAccount);
                int i4 = NotificationCenter.messagePlayingPlayStateChanged;
                Object[] objArr = new Object[1];
                MessageObject messageObject3 = this.playingMessageObject;
                objArr[0] = Integer.valueOf(messageObject3 != null ? messageObject3.getId() : 0);
                notificationCenter.postNotificationName(i4, objArr);
                VideoPlayer videoPlayer3 = this.audioPlayer;
                if (videoPlayer3 != null) {
                    videoPlayer3.releasePlayer(true);
                    this.audioPlayer = null;
                    Theme.unrefAudioVisualizeDrawable(this.playingMessageObject);
                    this.isPaused = false;
                    this.playingMessageObject = null;
                    this.downloadingCurrentMessage = false;
                }
                return false;
            }
        }
        checkAudioFocus(messageObject);
        setPlayerVolume();
        this.isPaused = false;
        this.lastProgress = 0L;
        this.playingMessageObject = messageObject;
        if (!SharedConfig.raiseToSpeak) {
            startRaiseToEarSensors(this.raiseChat);
        }
        if (!ApplicationLoader.mainInterfacePaused && (wakeLock = this.proximityWakeLock) != null && !wakeLock.isHeld() && (this.playingMessageObject.isVoice() || this.playingMessageObject.isRoundVideo())) {
            this.proximityWakeLock.acquire();
        }
        startProgressTimer(this.playingMessageObject);
        NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingDidStart, messageObject);
        VideoPlayer videoPlayer4 = this.videoPlayer;
        if (videoPlayer4 != null) {
            try {
                if (this.playingMessageObject.audioProgress != 0.0f) {
                    long duration2 = videoPlayer4.getDuration();
                    if (duration2 == -9223372036854775807L) {
                        duration2 = this.playingMessageObject.getDuration() * 1000;
                    }
                    MessageObject messageObject4 = this.playingMessageObject;
                    int i5 = (int) (duration2 * messageObject4.audioProgress);
                    int i6 = messageObject4.audioProgressMs;
                    if (i6 != 0) {
                        messageObject4.audioProgressMs = 0;
                        i5 = i6;
                    }
                    this.videoPlayer.seekTo(i5);
                }
            } catch (Exception e5) {
                MessageObject messageObject5 = this.playingMessageObject;
                messageObject5.audioProgress = 0.0f;
                messageObject5.audioProgressSec = 0;
                NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Integer.valueOf(this.playingMessageObject.getId()), 0);
                FileLog.e(e5);
            }
            this.videoPlayer.play();
        } else {
            VideoPlayer videoPlayer5 = this.audioPlayer;
            if (videoPlayer5 != null) {
                try {
                    if (this.playingMessageObject.audioProgress != 0.0f) {
                        long duration3 = videoPlayer5.getDuration();
                        if (duration3 == -9223372036854775807L) {
                            duration3 = this.playingMessageObject.getDuration() * 1000;
                        }
                        this.audioPlayer.seekTo((int) (duration3 * this.playingMessageObject.audioProgress));
                    }
                } catch (Exception e6) {
                    this.playingMessageObject.resetPlayingProgress();
                    NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Integer.valueOf(this.playingMessageObject.getId()), 0);
                    FileLog.e(e6);
                }
            }
        }
        MessageObject messageObject6 = this.playingMessageObject;
        if (messageObject6 != null && messageObject6.isMusic()) {
            try {
                ApplicationLoader.applicationContext.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) MusicPlayerService.class));
                return true;
            } catch (Throwable th2) {
                FileLog.e(th2);
                return true;
            }
        }
        ApplicationLoader.applicationContext.stopService(new Intent(ApplicationLoader.applicationContext, (Class<?>) MusicPlayerService.class));
        return true;
    }

    /* renamed from: ir.eitaa.messenger.MediaController$9, reason: invalid class name */
    class AnonymousClass9 implements VideoPlayer.VideoPlayerDelegate {
        final /* synthetic */ boolean val$destroyAtEnd;
        final /* synthetic */ MessageObject val$messageObject;
        final /* synthetic */ int[] val$playCount;
        final /* synthetic */ int val$tag;

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        AnonymousClass9(final int val$tag, final MessageObject val$messageObject, final int[] val$playCount, final boolean val$destroyAtEnd) {
            this.val$tag = val$tag;
            this.val$messageObject = val$messageObject;
            this.val$playCount = val$playCount;
            this.val$destroyAtEnd = val$destroyAtEnd;
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean playWhenReady, int playbackState) throws InterruptedException, IOException {
            if (this.val$tag != MediaController.this.playerNum) {
                return;
            }
            MediaController.this.updateVideoState(this.val$messageObject, this.val$playCount, this.val$destroyAtEnd, playWhenReady, playbackState);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer player, Exception e) {
            FileLog.e(e);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
            MediaController.this.currentAspectRatioFrameLayoutRotation = unappliedRotationDegrees;
            if (unappliedRotationDegrees != 90 && unappliedRotationDegrees != 270) {
                height = width;
                width = height;
            }
            MediaController.this.currentAspectRatioFrameLayoutRatio = width == 0 ? MediaController.VOLUME_NORMAL : (height * pixelWidthHeightRatio) / width;
            if (MediaController.this.currentAspectRatioFrameLayout != null) {
                MediaController.this.currentAspectRatioFrameLayout.setAspectRatio(MediaController.this.currentAspectRatioFrameLayoutRatio, MediaController.this.currentAspectRatioFrameLayoutRotation);
            }
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
            if (MediaController.this.currentAspectRatioFrameLayout == null || MediaController.this.currentAspectRatioFrameLayout.isDrawingReady()) {
                return;
            }
            MediaController.this.isDrawingWasReady = true;
            MediaController.this.currentAspectRatioFrameLayout.setDrawingReady(true);
            MediaController.this.currentTextureViewContainer.setTag(1);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
            if (MediaController.this.videoPlayer == null) {
                return false;
            }
            if (MediaController.this.pipSwitchingState == 2) {
                if (MediaController.this.currentAspectRatioFrameLayout != null) {
                    if (MediaController.this.isDrawingWasReady) {
                        MediaController.this.currentAspectRatioFrameLayout.setDrawingReady(true);
                    }
                    if (MediaController.this.currentAspectRatioFrameLayout.getParent() == null) {
                        MediaController.this.currentTextureViewContainer.addView(MediaController.this.currentAspectRatioFrameLayout);
                    }
                    if (MediaController.this.currentTextureView.getSurfaceTexture() != surfaceTexture) {
                        MediaController.this.currentTextureView.setSurfaceTexture(surfaceTexture);
                    }
                    MediaController.this.videoPlayer.setTextureView(MediaController.this.currentTextureView);
                }
                MediaController.this.pipSwitchingState = 0;
                return true;
            }
            if (MediaController.this.pipSwitchingState == 1) {
                if (MediaController.this.baseActivity != null) {
                    if (MediaController.this.pipRoundVideoView == null) {
                        try {
                            MediaController.this.pipRoundVideoView = new PipRoundVideoView();
                            MediaController.this.pipRoundVideoView.show(MediaController.this.baseActivity, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$9$G4RjQCFxfBmEnFPDa6OHBPEiPGc
                                @Override // java.lang.Runnable
                                public final void run() throws InterruptedException, IOException {
                                    this.f$0.lambda$onSurfaceDestroyed$0$MediaController$9();
                                }
                            });
                        } catch (Exception unused) {
                            MediaController.this.pipRoundVideoView = null;
                        }
                    }
                    if (MediaController.this.pipRoundVideoView != null) {
                        if (MediaController.this.pipRoundVideoView.getTextureView().getSurfaceTexture() != surfaceTexture) {
                            MediaController.this.pipRoundVideoView.getTextureView().setSurfaceTexture(surfaceTexture);
                        }
                        MediaController.this.videoPlayer.setTextureView(MediaController.this.pipRoundVideoView.getTextureView());
                    }
                }
                MediaController.this.pipSwitchingState = 0;
                return true;
            }
            if (!PhotoViewer.hasInstance() || !PhotoViewer.getInstance().isInjectingVideoPlayer()) {
                return false;
            }
            PhotoViewer.getInstance().injectVideoPlayerSurface(surfaceTexture);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onSurfaceDestroyed$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onSurfaceDestroyed$0$MediaController$9() throws InterruptedException, IOException {
            MediaController.this.cleanupPlayer(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$playMessage$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$playMessage$19$MediaController() throws InterruptedException, IOException {
        cleanupPlayer(true, true);
    }

    public AudioInfo getAudioInfo() {
        return this.audioInfo;
    }

    public void setPlaybackOrderType(int type) throws InterruptedException, IOException {
        boolean z = SharedConfig.shuffleMusic;
        SharedConfig.setPlaybackOrderType(type);
        boolean z2 = SharedConfig.shuffleMusic;
        if (z != z2) {
            if (z2) {
                buildShuffledPlayList();
                return;
            }
            MessageObject messageObject = this.playingMessageObject;
            if (messageObject != null) {
                int iIndexOf = this.playlist.indexOf(messageObject);
                this.currentPlaylistNum = iIndexOf;
                if (iIndexOf == -1) {
                    clearPlaylist();
                    cleanupPlayer(true, true);
                }
            }
        }
    }

    public boolean isStreamingCurrentAudio() {
        return this.isStreamingCurrentAudio;
    }

    public boolean isCurrentPlayer(VideoPlayer player) {
        return this.videoPlayer == player || this.audioPlayer == player;
    }

    /* renamed from: pauseMessage, reason: merged with bridge method [inline-methods] */
    public boolean lambda$startAudioAgain$7$MediaController(MessageObject messageObject) {
        if ((this.audioPlayer != null || this.videoPlayer != null) && messageObject != null && this.playingMessageObject != null && isSamePlayingMessage(messageObject)) {
            stopProgressTimer();
            try {
                if (this.audioPlayer != null) {
                    String str = messageObject.messageOwner.attachPath;
                    File pathToMessage = null;
                    if (str != null && str.length() > 0) {
                        File file = new File(messageObject.messageOwner.attachPath);
                        if (file.exists()) {
                            pathToMessage = file;
                        }
                    }
                    if (pathToMessage == null) {
                        pathToMessage = FileLoader.getPathToMessage(messageObject.messageOwner);
                    }
                    SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("AudioPlayerConfig", 0);
                    int currentPosition = (int) this.audioPlayer.getCurrentPosition();
                    sharedPreferences.edit().putInt("current_position" + pathToMessage.getName(), currentPosition).apply();
                    if (!this.playingMessageObject.isVoice() && this.playingMessageObject.getDuration() * (VOLUME_NORMAL - this.playingMessageObject.audioProgress) > 1000.0f) {
                        ValueAnimator valueAnimator = this.audioVolumeAnimator;
                        if (valueAnimator != null) {
                            valueAnimator.removeAllUpdateListeners();
                            this.audioVolumeAnimator.cancel();
                        }
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(VOLUME_NORMAL, 0.0f);
                        this.audioVolumeAnimator = valueAnimatorOfFloat;
                        valueAnimatorOfFloat.addUpdateListener(this.audioVolumeUpdateListener);
                        this.audioVolumeAnimator.setDuration(300L);
                        this.audioVolumeAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.messenger.MediaController.12
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (MediaController.this.audioPlayer != null) {
                                    MediaController.this.audioPlayer.pause();
                                }
                            }
                        });
                        this.audioVolumeAnimator.start();
                    } else {
                        this.audioPlayer.pause();
                    }
                } else {
                    VideoPlayer videoPlayer = this.videoPlayer;
                    if (videoPlayer != null) {
                        videoPlayer.pause();
                    }
                }
                this.isPaused = true;
                NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingPlayStateChanged, Integer.valueOf(this.playingMessageObject.getId()));
                return true;
            } catch (Exception e) {
                FileLog.e(e);
                this.isPaused = false;
            }
        }
        return false;
    }

    private boolean resumeAudio(MessageObject messageObject) {
        if ((this.audioPlayer != null || this.videoPlayer != null) && messageObject != null && this.playingMessageObject != null && isSamePlayingMessage(messageObject)) {
            try {
                startProgressTimer(this.playingMessageObject);
                ValueAnimator valueAnimator = this.audioVolumeAnimator;
                if (valueAnimator != null) {
                    valueAnimator.removeAllListeners();
                    this.audioVolumeAnimator.cancel();
                }
                if (!messageObject.isVoice()) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.audioVolume, VOLUME_NORMAL);
                    this.audioVolumeAnimator = valueAnimatorOfFloat;
                    valueAnimatorOfFloat.addUpdateListener(this.audioVolumeUpdateListener);
                    this.audioVolumeAnimator.setDuration(300L);
                    this.audioVolumeAnimator.start();
                } else {
                    this.audioVolume = VOLUME_NORMAL;
                    setPlayerVolume();
                }
                VideoPlayer videoPlayer = this.audioPlayer;
                if (videoPlayer != null) {
                    videoPlayer.play();
                } else {
                    VideoPlayer videoPlayer2 = this.videoPlayer;
                    if (videoPlayer2 != null) {
                        videoPlayer2.play();
                    }
                }
                checkAudioFocus(messageObject);
                this.isPaused = false;
                NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingPlayStateChanged, Integer.valueOf(this.playingMessageObject.getId()));
                return true;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        return false;
    }

    public boolean isVideoDrawingReady() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.currentAspectRatioFrameLayout;
        return aspectRatioFrameLayout != null && aspectRatioFrameLayout.isDrawingReady();
    }

    public ArrayList<MessageObject> getPlaylist() {
        return this.playlist;
    }

    public boolean isPlayingMessage(MessageObject messageObject) {
        MessageObject messageObject2;
        if ((this.audioPlayer != null || this.videoPlayer != null) && messageObject != null && (messageObject2 = this.playingMessageObject) != null) {
            long j = messageObject2.eventId;
            if (j != 0 && j == messageObject.eventId) {
                return !this.downloadingCurrentMessage;
            }
            if (isSamePlayingMessage(messageObject)) {
                return !this.downloadingCurrentMessage;
            }
        }
        return false;
    }

    public boolean isPlayingMessageAndReadyToDraw(MessageObject messageObject) {
        return this.isDrawingWasReady && isPlayingMessage(messageObject);
    }

    public boolean isMessagePaused() {
        return this.isPaused || this.downloadingCurrentMessage;
    }

    public boolean isDownloadingCurrentMessage() {
        return this.downloadingCurrentMessage;
    }

    public void setReplyingMessage(MessageObject replyToMsg, MessageObject replyToTopMsg) {
        this.recordReplyingMsg = replyToMsg;
        this.recordReplyingTopMsg = replyToTopMsg;
    }

    public void requestAudioFocus(boolean request) {
        if (request) {
            if (!this.hasRecordAudioFocus && SharedConfig.pauseMusicOnRecord && NotificationsController.audioManager.requestAudioFocus(this.audioRecordFocusChangedListener, 3, 2) == 1) {
                this.hasRecordAudioFocus = true;
                return;
            }
            return;
        }
        if (this.hasRecordAudioFocus) {
            NotificationsController.audioManager.abandonAudioFocus(this.audioRecordFocusChangedListener);
            this.hasRecordAudioFocus = false;
        }
    }

    public void startRecording(final int currentAccount, final long dialogId, final MessageObject replyToMsg, final MessageObject replyToTopMsg, final int guid) throws InterruptedException {
        MessageObject messageObject = this.playingMessageObject;
        boolean z = (messageObject == null || !isPlayingMessage(messageObject) || isMessagePaused()) ? false : true;
        requestAudioFocus(true);
        try {
            this.feedbackView.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        DispatchQueue dispatchQueue = this.recordQueue;
        Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$SevxobWFnA6Fg6CBfb-5mDEgB9g
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f$0.lambda$startRecording$26$MediaController(currentAccount, guid, dialogId, replyToMsg, replyToTopMsg);
            }
        };
        this.recordStartRunnable = runnable;
        dispatchQueue.postRunnable(runnable, z ? 500L : 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startRecording$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startRecording$26$MediaController(final int i, final int i2, long j, MessageObject messageObject, MessageObject messageObject2) throws IllegalStateException {
        if (this.audioRecorder != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$2sCU9m8Bqx_wCmkjsisxwB72pN4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startRecording$22$MediaController(i, i2);
                }
            });
            return;
        }
        this.sendAfterDone = 0;
        TLRPC$TL_document tLRPC$TL_document = new TLRPC$TL_document();
        this.recordingAudio = tLRPC$TL_document;
        this.recordingGuid = i2;
        tLRPC$TL_document.file_reference = new byte[0];
        tLRPC$TL_document.dc_id = Integer.MIN_VALUE;
        tLRPC$TL_document.id = SharedConfig.getLastLocalId();
        this.recordingAudio.user_id = UserConfig.getInstance(i).getClientUserId();
        TLRPC$TL_document tLRPC$TL_document2 = this.recordingAudio;
        tLRPC$TL_document2.mime_type = "audio/ogg";
        tLRPC$TL_document2.file_reference = new byte[0];
        SharedConfig.saveConfig();
        File file = new File(FileLoader.getDirectory(4), FileLoader.getAttachFileName(this.recordingAudio));
        this.recordingAudioFile = file;
        try {
            if (startRecord(file.getAbsolutePath(), 16000) == 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$Ft7mu4YjntoIsZtQHUe-led3K0o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$startRecording$23$MediaController(i, i2);
                    }
                });
                return;
            }
            this.audioRecorder = new AudioRecord(0, this.sampleRate, 16, 2, this.recordBufferSize);
            this.recordStartTime = System.currentTimeMillis();
            this.recordTimeCount = 0L;
            this.samplesCount = 0L;
            this.recordDialogId = j;
            this.recordingCurrentAccount = i;
            this.recordReplyingMsg = messageObject;
            this.recordReplyingTopMsg = messageObject2;
            this.fileBuffer.rewind();
            this.audioRecorder.startRecording();
            this.recordQueue.postRunnable(this.recordRunnable);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$xizomQd2TjUgYLsIMX0novxQ6cQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startRecording$25$MediaController(i, i2);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
            this.recordingAudio = null;
            stopRecord();
            this.recordingAudioFile.delete();
            this.recordingAudioFile = null;
            try {
                this.audioRecorder.release();
                this.audioRecorder = null;
            } catch (Exception e2) {
                FileLog.e(e2);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$nuSiY0HRzkrfbrrWRQCN9yg7xyg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startRecording$24$MediaController(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startRecording$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startRecording$22$MediaController(int i, int i2) {
        this.recordStartRunnable = null;
        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.recordStartError, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startRecording$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startRecording$23$MediaController(int i, int i2) {
        this.recordStartRunnable = null;
        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.recordStartError, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startRecording$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startRecording$24$MediaController(int i, int i2) {
        this.recordStartRunnable = null;
        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.recordStartError, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startRecording$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startRecording$25$MediaController(int i, int i2) {
        this.recordStartRunnable = null;
        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.recordStarted, Integer.valueOf(i2), Boolean.TRUE);
    }

    public void generateWaveform(final MessageObject messageObject) {
        final String str = messageObject.getId() + "_" + messageObject.getDialogId();
        final String absolutePath = FileLoader.getPathToMessage(messageObject.messageOwner).getAbsolutePath();
        if (this.generatingWaveform.containsKey(str)) {
            return;
        }
        this.generatingWaveform.put(str, messageObject);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$9RMwsKwaope-3AC5MnysZfT_J8o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateWaveform$28$MediaController(absolutePath, str, messageObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateWaveform$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateWaveform$28$MediaController(String str, final String str2, final MessageObject messageObject) {
        final byte[] waveform = getWaveform(str);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$KWZ6V0aMs22kY-xzuE7RFZCEh88
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateWaveform$27$MediaController(str2, waveform, messageObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateWaveform$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateWaveform$27$MediaController(String str, byte[] bArr, MessageObject messageObject) {
        MessageObject messageObjectRemove = this.generatingWaveform.remove(str);
        if (messageObjectRemove == null || bArr == null || messageObjectRemove.getDocument() == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= messageObjectRemove.getDocument().attributes.size()) {
                break;
            }
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = messageObjectRemove.getDocument().attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                tLRPC$DocumentAttribute.waveform = bArr;
                tLRPC$DocumentAttribute.flags |= 4;
                break;
            }
            i++;
        }
        TLRPC$TL_messages_messages tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
        tLRPC$TL_messages_messages.messages.add(messageObjectRemove.messageOwner);
        MessagesStorage.getInstance(messageObjectRemove.currentAccount).putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages, messageObjectRemove.getDialogId(), -1, 0, false, messageObject.scheduled);
        ArrayList arrayList = new ArrayList();
        arrayList.add(messageObjectRemove);
        NotificationCenter.getInstance(messageObjectRemove.currentAccount).postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(messageObjectRemove.getDialogId()), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecordingInternal(final int send, final boolean notify, final int scheduleDate) {
        if (send != 0) {
            final TLRPC$TL_document tLRPC$TL_document = this.recordingAudio;
            final File file = this.recordingAudioFile;
            this.fileEncodingQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$M9FQSLAgZQzFO9EzvWDfCkpHLHI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$stopRecordingInternal$30$MediaController(tLRPC$TL_document, file, send, notify, scheduleDate);
                }
            });
        } else {
            File file2 = this.recordingAudioFile;
            if (file2 != null) {
                file2.delete();
            }
            requestAudioFocus(false);
        }
        try {
            AudioRecord audioRecord = this.audioRecorder;
            if (audioRecord != null) {
                audioRecord.release();
                this.audioRecorder = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.recordingAudio = null;
        this.recordingAudioFile = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$stopRecordingInternal$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$stopRecordingInternal$30$MediaController(final TLRPC$TL_document tLRPC$TL_document, final File file, final int i, final boolean z, final int i2) {
        stopRecord();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$V84zf7jNLXdXxxW0c74fgd4hW18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopRecordingInternal$29$MediaController(tLRPC$TL_document, file, i, z, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$stopRecordingInternal$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$stopRecordingInternal$29$MediaController(TLRPC$TL_document tLRPC$TL_document, File file, int i, boolean z, int i2) {
        boolean z2;
        char c;
        tLRPC$TL_document.date = ConnectionsManager.getInstance(this.recordingCurrentAccount).getCurrentTime();
        tLRPC$TL_document.size = (int) file.length();
        TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio = new TLRPC$TL_documentAttributeAudio();
        tLRPC$TL_documentAttributeAudio.voice = true;
        short[] sArr = this.recordSamples;
        byte[] waveform2 = getWaveform2(sArr, sArr.length);
        tLRPC$TL_documentAttributeAudio.waveform = waveform2;
        if (waveform2 != null) {
            tLRPC$TL_documentAttributeAudio.flags |= 4;
        }
        long j = this.recordTimeCount;
        tLRPC$TL_documentAttributeAudio.duration = (int) (j / 1000);
        tLRPC$TL_document.attributes.add(tLRPC$TL_documentAttributeAudio);
        if (j > 700) {
            if (i == 1) {
                c = 1;
                SendMessagesHelper.getInstance(this.recordingCurrentAccount).sendMessage(tLRPC$TL_document, null, file.getAbsolutePath(), this.recordDialogId, this.recordReplyingMsg, this.recordReplyingTopMsg, null, null, null, null, z, i2, 0, null, null);
            } else {
                c = 1;
            }
            NotificationCenter notificationCenter = NotificationCenter.getInstance(this.recordingCurrentAccount);
            int i3 = NotificationCenter.audioDidSent;
            Object[] objArr = new Object[3];
            z2 = false;
            objArr[0] = Integer.valueOf(this.recordingGuid);
            objArr[c] = i == 2 ? tLRPC$TL_document : null;
            objArr[2] = i == 2 ? file.getAbsolutePath() : null;
            notificationCenter.postNotificationName(i3, objArr);
        } else {
            z2 = false;
            NotificationCenter.getInstance(this.recordingCurrentAccount).postNotificationName(NotificationCenter.audioRecordTooShort, Integer.valueOf(this.recordingGuid), Boolean.FALSE, Integer.valueOf((int) j));
            file.delete();
        }
        requestAudioFocus(z2);
    }

    public void stopRecording(final int send, final boolean notify, final int scheduleDate) throws InterruptedException {
        Runnable runnable = this.recordStartRunnable;
        if (runnable != null) {
            this.recordQueue.cancelRunnable(runnable);
            this.recordStartRunnable = null;
        }
        this.recordQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$gdll7AJ9MJzGmOlpqX3O-ZXYUqs
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f$0.lambda$stopRecording$32$MediaController(send, notify, scheduleDate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$stopRecording$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$stopRecording$32$MediaController(final int i, boolean z, int i2) throws IllegalStateException {
        if (this.sendAfterDone == 3) {
            this.sendAfterDone = 0;
            stopRecordingInternal(i, z, i2);
            return;
        }
        AudioRecord audioRecord = this.audioRecorder;
        if (audioRecord == null) {
            return;
        }
        try {
            this.sendAfterDone = i;
            this.sendAfterDoneNotify = z;
            this.sendAfterDoneScheduleDate = i2;
            audioRecord.stop();
        } catch (Exception e) {
            FileLog.e(e);
            File file = this.recordingAudioFile;
            if (file != null) {
                file.delete();
            }
        }
        if (i == 0) {
            stopRecordingInternal(0, false, 0);
        }
        try {
            this.feedbackView.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$K1wNg1wAuSPwphWxLl7_5zPxHB4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopRecording$31$MediaController(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$stopRecording$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$stopRecording$31$MediaController(int i) {
        NotificationCenter notificationCenter = NotificationCenter.getInstance(this.recordingCurrentAccount);
        int i2 = NotificationCenter.recordStopped;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.recordingGuid);
        objArr[1] = Integer.valueOf(i == 2 ? 1 : 0);
        notificationCenter.postNotificationName(i2, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class MediaLoader implements NotificationCenter.NotificationCenterDelegate {
        private boolean cancelled;
        private int copiedFiles;
        private AccountInstance currentAccount;
        private boolean finished;
        private float finishedProgress;
        private boolean isMusic;
        private HashMap<String, MessageObject> loadingMessageObjects = new HashMap<>();
        private ArrayList<MessageObject> messageObjects;
        private MessagesStorage.IntCallback onFinishRunnable;
        private AlertDialog progressDialog;
        private CountDownLatch waitingForFile;

        public MediaLoader(Context context, AccountInstance accountInstance, ArrayList<MessageObject> messages, MessagesStorage.IntCallback onFinish) {
            this.currentAccount = accountInstance;
            this.messageObjects = messages;
            this.onFinishRunnable = onFinish;
            this.isMusic = messages.get(0).isMusic();
            this.currentAccount.getNotificationCenter().addObserver(this, NotificationCenter.fileLoaded);
            this.currentAccount.getNotificationCenter().addObserver(this, NotificationCenter.fileLoadProgressChanged);
            this.currentAccount.getNotificationCenter().addObserver(this, NotificationCenter.fileLoadFailed);
            AlertDialog alertDialog = new AlertDialog(context, 2);
            this.progressDialog = alertDialog;
            alertDialog.setMessage(LocaleController.getString("Loading", R.string.Loading));
            this.progressDialog.setCanceledOnTouchOutside(false);
            this.progressDialog.setCancelable(true);
            this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$MediaLoader$uBKjjNp5TwV2NGe-bAeW3xv_7PY
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$new$0$MediaController$MediaLoader(dialogInterface);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$MediaController$MediaLoader(DialogInterface dialogInterface) {
            this.cancelled = true;
        }

        public void start() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$MediaLoader$ctpKmRmu8x_vFL-tckwV4744alI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$start$1$MediaController$MediaLoader();
                }
            }, 250L);
            new Thread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$MediaLoader$n-h82XlhTIdWVHrfikq_R_UqPYs
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$start$2$MediaController$MediaLoader();
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$start$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$start$1$MediaController$MediaLoader() {
            if (this.finished) {
                return;
            }
            this.progressDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$start$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$start$2$MediaController$MediaLoader() throws Throwable {
            File externalStoragePublicDirectory;
            try {
                if (this.isMusic) {
                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                } else {
                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                }
                externalStoragePublicDirectory.mkdir();
                int size = this.messageObjects.size();
                for (int i = 0; i < size; i++) {
                    MessageObject messageObject = this.messageObjects.get(i);
                    String documentName = messageObject.getDocumentName();
                    File file = new File(externalStoragePublicDirectory, documentName);
                    if (file.exists()) {
                        int iLastIndexOf = documentName.lastIndexOf(46);
                        int i2 = 0;
                        while (true) {
                            if (i2 >= 10) {
                                break;
                            }
                            File file2 = new File(externalStoragePublicDirectory, iLastIndexOf != -1 ? documentName.substring(0, iLastIndexOf) + "(" + (i2 + 1) + ")" + documentName.substring(iLastIndexOf) : documentName + "(" + (i2 + 1) + ")");
                            if (!file2.exists()) {
                                file = file2;
                                break;
                            } else {
                                i2++;
                                file = file2;
                            }
                        }
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    String string = messageObject.messageOwner.attachPath;
                    if (string != null && string.length() > 0 && !new File(string).exists()) {
                        string = null;
                    }
                    if (string == null || string.length() == 0) {
                        string = FileLoader.getPathToMessage(messageObject.messageOwner).toString();
                    }
                    File file3 = new File(string);
                    if (!file3.exists()) {
                        this.waitingForFile = new CountDownLatch(1);
                        addMessageToLoad(messageObject);
                        this.waitingForFile.await();
                    }
                    copyFile(file3, file, messageObject.getMimeType());
                }
                checkIfFinished();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        private void checkIfFinished() {
            if (this.loadingMessageObjects.isEmpty()) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$MediaLoader$lkpqqJuqRby_0lHhJtOB892Z4ao
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkIfFinished$4$MediaController$MediaLoader();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$checkIfFinished$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$checkIfFinished$4$MediaController$MediaLoader() {
            try {
                if (this.progressDialog.isShowing()) {
                    this.progressDialog.dismiss();
                } else {
                    this.finished = true;
                }
                if (this.onFinishRunnable != null) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$MediaLoader$SjgW8_Q4_SnHZ--aPWyAe13PEMU
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$checkIfFinished$3$MediaController$MediaLoader();
                        }
                    });
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.currentAccount.getNotificationCenter().removeObserver(this, NotificationCenter.fileLoaded);
            this.currentAccount.getNotificationCenter().removeObserver(this, NotificationCenter.fileLoadProgressChanged);
            this.currentAccount.getNotificationCenter().removeObserver(this, NotificationCenter.fileLoadFailed);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$checkIfFinished$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$checkIfFinished$3$MediaController$MediaLoader() {
            this.onFinishRunnable.run(this.copiedFiles);
        }

        private void addMessageToLoad(final MessageObject messageObject) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$MediaLoader$a8M2M_ZrEcUhlABNEzchTCVjXrI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addMessageToLoad$5$MediaController$MediaLoader(messageObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$addMessageToLoad$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$addMessageToLoad$5$MediaController$MediaLoader(MessageObject messageObject) {
            TLRPC$Document document = messageObject.getDocument();
            if (document == null) {
                return;
            }
            this.loadingMessageObjects.put(FileLoader.getAttachFileName(document), messageObject);
            this.currentAccount.getFileLoader().loadFile(document, messageObject, 1, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:113:0x0172 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean copyFile(java.io.File r32, java.io.File r33, java.lang.String r34) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 398
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.MediaLoader.copyFile(java.io.File, java.io.File, java.lang.String):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$copyFile$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$copyFile$6$MediaController$MediaLoader() {
            try {
                this.progressDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$copyFile$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$copyFile$7$MediaController$MediaLoader(int i) {
            try {
                this.progressDialog.setProgress(i);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$copyFile$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$copyFile$8$MediaController$MediaLoader(int i) {
            try {
                this.progressDialog.setProgress(i);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int id, int account, Object... args) {
            if (id == NotificationCenter.fileLoaded || id == NotificationCenter.fileLoadFailed) {
                if (this.loadingMessageObjects.remove((String) args[0]) != null) {
                    this.waitingForFile.countDown();
                    return;
                }
                return;
            }
            if (id == NotificationCenter.fileLoadProgressChanged) {
                if (this.loadingMessageObjects.containsKey((String) args[0])) {
                    final int iLongValue = (int) (this.finishedProgress + (((((Long) args[1]).longValue() / ((Long) args[2]).longValue()) / this.messageObjects.size()) * 100.0f));
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$MediaLoader$uiyxfJr1px0VUWNIV0FmmL-seGM
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$didReceivedNotification$9$MediaController$MediaLoader(iLongValue);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didReceivedNotification$9, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didReceivedNotification$9$MediaController$MediaLoader(int i) {
            try {
                this.progressDialog.setProgress(i);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static void saveFilesFromMessages(Context context, AccountInstance accountInstance, ArrayList<MessageObject> messageObjects, final MessagesStorage.IntCallback onSaved) {
        if (messageObjects == null || messageObjects.isEmpty()) {
            return;
        }
        new MediaLoader(context, accountInstance, messageObjects, onSaved).start();
    }

    public static void saveFile(String fullPath, Context context, final int type, final String name, final String mime) {
        saveFile(fullPath, context, type, name, mime, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void saveFile(java.lang.String r13, android.content.Context r14, final int r15, final java.lang.String r16, final java.lang.String r17, final java.lang.Runnable r18) {
        /*
            r0 = r13
            r1 = r14
            if (r0 != 0) goto L5
            return
        L5:
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            r3 = 0
            if (r2 != 0) goto L24
            java.io.File r2 = new java.io.File
            r2.<init>(r13)
            boolean r0 = r2.exists()
            if (r0 == 0) goto L24
            android.net.Uri r0 = android.net.Uri.fromFile(r2)
            boolean r0 = ir.eitaa.messenger.AndroidUtilities.isInternalUri(r0)
            if (r0 == 0) goto L22
            goto L24
        L22:
            r6 = r2
            goto L25
        L24:
            r6 = r3
        L25:
            if (r6 != 0) goto L28
            return
        L28:
            r0 = 1
            boolean[] r9 = new boolean[r0]
            r2 = 0
            r9[r2] = r2
            boolean r4 = r6.exists()
            if (r4 == 0) goto L80
            boolean[] r12 = new boolean[r0]
            if (r1 == 0) goto L6a
            if (r15 == 0) goto L6a
            ir.eitaa.ui.ActionBar.AlertDialog r4 = new ir.eitaa.ui.ActionBar.AlertDialog     // Catch: java.lang.Exception -> L66
            r5 = 2
            r4.<init>(r14, r5)     // Catch: java.lang.Exception -> L66
            java.lang.String r1 = "Loading"
            r5 = 2131692202(0x7f0f0aaa, float:1.9013497E38)
            java.lang.String r1 = ir.eitaa.messenger.LocaleController.getString(r1, r5)     // Catch: java.lang.Exception -> L66
            r4.setMessage(r1)     // Catch: java.lang.Exception -> L66
            r4.setCanceledOnTouchOutside(r2)     // Catch: java.lang.Exception -> L66
            r4.setCancelable(r0)     // Catch: java.lang.Exception -> L66
            ir.eitaa.messenger.-$$Lambda$MediaController$Ap4hOG8dJFxLTBV4K0lYk0OgNxw r0 = new ir.eitaa.messenger.-$$Lambda$MediaController$Ap4hOG8dJFxLTBV4K0lYk0OgNxw     // Catch: java.lang.Exception -> L66
            r0.<init>()     // Catch: java.lang.Exception -> L66
            r4.setOnCancelListener(r0)     // Catch: java.lang.Exception -> L66
            ir.eitaa.messenger.-$$Lambda$MediaController$tN1czS7jso4uosLHvs8fkcqcwHc r0 = new ir.eitaa.messenger.-$$Lambda$MediaController$tN1czS7jso4uosLHvs8fkcqcwHc     // Catch: java.lang.Exception -> L66
            r0.<init>()     // Catch: java.lang.Exception -> L66
            r1 = 250(0xfa, double:1.235E-321)
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0, r1)     // Catch: java.lang.Exception -> L66
            r8 = r4
            goto L6b
        L66:
            r0 = move-exception
            ir.eitaa.messenger.FileLog.e(r0)
        L6a:
            r8 = r3
        L6b:
            java.lang.Thread r0 = new java.lang.Thread
            ir.eitaa.messenger.-$$Lambda$MediaController$SRQN5FxfyyE0PQInxAj6DmUmuNg r1 = new ir.eitaa.messenger.-$$Lambda$MediaController$SRQN5FxfyyE0PQInxAj6DmUmuNg
            r4 = r1
            r5 = r15
            r7 = r16
            r10 = r17
            r11 = r18
            r4.<init>()
            r0.<init>(r1)
            r0.start()
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.saveFile(java.lang.String, android.content.Context, int, java.lang.String, java.lang.String, java.lang.Runnable):void");
    }

    static /* synthetic */ void lambda$saveFile$33(boolean[] zArr, DialogInterface dialogInterface) {
        zArr[0] = true;
    }

    static /* synthetic */ void lambda$saveFile$34(boolean[] zArr, AlertDialog alertDialog) {
        if (zArr[0]) {
            return;
        }
        alertDialog.show();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(1:120)|(20:(1:4)(1:(1:8)(30:(1:11)(1:12)|13|(3:15|16|(2:17|(1:129)(4:19|(1:21)(1:22)|23|(2:130|25)(1:26))))(0)|27|(1:29)|30|31|121|32|118|33|107|34|113|35|114|36|(5:(1:39)|(1:41)|42|43|44)|47|(6:53|111|54|(1:128)(2:58|126)|59|48)|125|62|(1:64)|65|66|67|88|(1:90)(1:91)|(3:93|(1:95)(1:96)|(1:98))|(2:102|103)(1:131)))|107|34|113|35|114|36|(0)|47|(7:50|53|111|54|(2:56|128)(1:127)|59|48)|124|62|(0)|65|66|67|88|(0)(0)|(0)|(0)(0))|9|27|(0)|30|31|121|32|118|33|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:(1:4)(1:(1:8)(30:(1:11)(1:12)|13|(3:15|16|(2:17|(1:129)(4:19|(1:21)(1:22)|23|(2:130|25)(1:26))))(0)|27|(1:29)|30|31|121|32|118|33|107|34|113|35|114|36|(5:(1:39)|(1:41)|42|43|44)|47|(6:53|111|54|(1:128)(2:58|126)|59|48)|125|62|(1:64)|65|66|67|88|(1:90)(1:91)|(3:93|(1:95)(1:96)|(1:98))|(2:102|103)(1:131)))|113|35|114|36|(0)|47|(7:50|53|111|54|(2:56|128)(1:127)|59|48)|124|62|(0)|65|66|67|88|(0)(0)|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f9, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0173, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0174, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
        r3 = 0;
        r4 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0166 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0 A[Catch: Exception -> 0x0014, TryCatch #8 {Exception -> 0x0014, blocks: (B:4:0x000b, B:27:0x009a, B:29:0x00a0, B:30:0x00a3, B:88:0x0179, B:90:0x017d, B:95:0x0188, B:98:0x01b5, B:96:0x01ac, B:87:0x0174, B:8:0x0019, B:11:0x0022, B:13:0x002f, B:15:0x003d, B:21:0x004f, B:23:0x0089, B:26:0x0096, B:22:0x0072, B:12:0x0029, B:32:0x00aa, B:43:0x00f4, B:66:0x0150, B:85:0x0172), top: B:120:0x0009, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014a A[Catch: all -> 0x015f, TRY_ENTER, TRY_LEAVE, TryCatch #11 {all -> 0x015f, blocks: (B:72:0x015e, B:64:0x014a), top: B:107:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017d A[Catch: Exception -> 0x0014, TryCatch #8 {Exception -> 0x0014, blocks: (B:4:0x000b, B:27:0x009a, B:29:0x00a0, B:30:0x00a3, B:88:0x0179, B:90:0x017d, B:95:0x0188, B:98:0x01b5, B:96:0x01ac, B:87:0x0174, B:8:0x0019, B:11:0x0022, B:13:0x002f, B:15:0x003d, B:21:0x004f, B:23:0x0089, B:26:0x0096, B:22:0x0072, B:12:0x0029, B:32:0x00aa, B:43:0x00f4, B:66:0x0150, B:85:0x0172), top: B:120:0x0009, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0185  */
    /* JADX WARN: Type inference failed for: r22v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$saveFile$38(int r20, java.io.File r21, java.lang.String r22, final ir.eitaa.ui.ActionBar.AlertDialog r23, boolean[] r24, java.lang.String r25, java.lang.Runnable r26, final boolean[] r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.lambda$saveFile$38(int, java.io.File, java.lang.String, ir.eitaa.ui.ActionBar.AlertDialog, boolean[], java.lang.String, java.lang.Runnable, boolean[]):void");
    }

    static /* synthetic */ void lambda$saveFile$35(AlertDialog alertDialog) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    static /* synthetic */ void lambda$saveFile$36(AlertDialog alertDialog, int i) {
        try {
            alertDialog.setProgress(i);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    static /* synthetic */ void lambda$saveFile$37(AlertDialog alertDialog, boolean[] zArr) {
        try {
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            } else {
                zArr[0] = true;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00a4 -> B:82:0x00a7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getStickerExt(android.net.Uri r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "webp"
            r1 = 0
            android.content.Context r2 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            java.io.InputStream r8 = r2.openInputStream(r8)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            r2 = 12
            byte[] r3 = new byte[r2]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r4 = 0
            int r5 = r8.read(r3, r4, r2)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            if (r5 != r2) goto L90
            r2 = r3[r4]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r5 = -119(0xffffffffffffff89, float:NaN)
            r6 = 1
            if (r2 != r5) goto L59
            r2 = r3[r6]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r5 = 80
            if (r2 != r5) goto L59
            r2 = 2
            r2 = r3[r2]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r5 = 78
            if (r2 != r5) goto L59
            r2 = 3
            r2 = r3[r2]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r5 = 71
            if (r2 != r5) goto L59
            r2 = 4
            r2 = r3[r2]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r5 = 13
            if (r2 != r5) goto L59
            r2 = 5
            r2 = r3[r2]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r5 = 10
            if (r2 != r5) goto L59
            r2 = 6
            r2 = r3[r2]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r7 = 26
            if (r2 != r7) goto L59
            r2 = 7
            r2 = r3[r2]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            if (r2 != r5) goto L59
            java.lang.String r0 = "png"
            r8.close()     // Catch: java.lang.Exception -> L54
            goto L58
        L54:
            r8 = move-exception
            ir.eitaa.messenger.FileLog.e(r8)
        L58:
            return r0
        L59:
            r2 = r3[r4]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r4 = 31
            if (r2 != r4) goto L70
            r2 = r3[r6]     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r4 = -117(0xffffffffffffff8b, float:NaN)
            if (r2 != r4) goto L70
            java.lang.String r0 = "tgs"
            r8.close()     // Catch: java.lang.Exception -> L6b
            goto L6f
        L6b:
            r8 = move-exception
            ir.eitaa.messenger.FileLog.e(r8)
        L6f:
            return r0
        L70:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            r2.<init>(r3)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            java.lang.String r3 = "riff"
            boolean r3 = r2.startsWith(r3)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            if (r3 == 0) goto L90
            boolean r2 = r2.endsWith(r0)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> La8
            if (r2 == 0) goto L90
            r8.close()     // Catch: java.lang.Exception -> L8b
            goto L8f
        L8b:
            r8 = move-exception
            ir.eitaa.messenger.FileLog.e(r8)
        L8f:
            return r0
        L90:
            r8.close()     // Catch: java.lang.Exception -> La3
            goto La7
        L94:
            r0 = move-exception
            goto L9a
        L96:
            r0 = move-exception
            goto Laa
        L98:
            r0 = move-exception
            r8 = r1
        L9a:
            ir.eitaa.messenger.FileLog.e(r0)     // Catch: java.lang.Throwable -> La8
            if (r8 == 0) goto La7
            r8.close()     // Catch: java.lang.Exception -> La3
            goto La7
        La3:
            r8 = move-exception
            ir.eitaa.messenger.FileLog.e(r8)
        La7:
            return r1
        La8:
            r0 = move-exception
            r1 = r8
        Laa:
            if (r1 == 0) goto Lb4
            r1.close()     // Catch: java.lang.Exception -> Lb0
            goto Lb4
        Lb0:
            r8 = move-exception
            ir.eitaa.messenger.FileLog.e(r8)
        Lb4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.getStickerExt(android.net.Uri):java.lang.String");
    }

    public static boolean isWebp(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                try {
                    inputStreamOpenInputStream = ApplicationLoader.applicationContext.getContentResolver().openInputStream(uri);
                    byte[] bArr = new byte[12];
                    if (inputStreamOpenInputStream.read(bArr, 0, 12) == 12) {
                        String lowerCase = new String(bArr).toLowerCase();
                        if (lowerCase.startsWith("riff")) {
                            if (lowerCase.endsWith("webp")) {
                                try {
                                    inputStreamOpenInputStream.close();
                                } catch (Exception e) {
                                    FileLog.e(e);
                                }
                                return true;
                            }
                        }
                    }
                    inputStreamOpenInputStream.close();
                } catch (Exception e2) {
                    FileLog.e(e2);
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                }
            } catch (Exception e3) {
                FileLog.e(e3);
            }
            return false;
        } catch (Throwable th) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (Exception e4) {
                    FileLog.e(e4);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x003d -> B:32:0x0040). Please report as a decompilation issue!!! */
    public static boolean isGif(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                try {
                    inputStreamOpenInputStream = ApplicationLoader.applicationContext.getContentResolver().openInputStream(uri);
                    byte[] bArr = new byte[3];
                    if (inputStreamOpenInputStream.read(bArr, 0, 3) == 3) {
                        if (new String(bArr).equalsIgnoreCase("gif")) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                            return true;
                        }
                    }
                    inputStreamOpenInputStream.close();
                } catch (Throwable th) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Exception e2) {
                            FileLog.e(e2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                FileLog.e(e3);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
            }
        } catch (Exception e4) {
            FileLog.e(e4);
        }
        return false;
    }

    public static String getFileName(Uri uri) {
        if (uri == null) {
            return "";
        }
        try {
            if (uri.getScheme().equals("content")) {
                try {
                    Cursor cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                    try {
                        string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("_display_name")) : null;
                        cursorQuery.close();
                    } catch (Throwable th) {
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            if (string != null) {
                return string;
            }
            String path = uri.getPath();
            int iLastIndexOf = path.lastIndexOf(47);
            return iLastIndexOf != -1 ? path.substring(iLastIndexOf + 1) : path;
        } catch (Exception e2) {
            FileLog.e(e2);
            return "";
        }
    }

    public static String copyFileToCache(Uri uri, String ext) {
        return copyFileToCache(uri, ext, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d2, code lost:
    
        r0 = r5.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d6, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00da, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00db, code lost:
    
        ir.eitaa.messenger.FileLog.e(r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @android.annotation.SuppressLint({"DiscouragedPrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String copyFileToCache(android.net.Uri r11, java.lang.String r12, long r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.copyFileToCache(android.net.Uri, java.lang.String, long):java.lang.String");
    }

    public static void loadGalleryPhotosAlbums(final int guid) {
        Thread thread = new Thread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$q3cKNvlR-7Y00Lhe5vvzNcv4MZs
            @Override // java.lang.Runnable
            public final void run() {
                MediaController.lambda$loadGalleryPhotosAlbums$40(guid);
            }
        });
        thread.setPriority(1);
        thread.start();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(6:268|3|4|256|5|6)|12|(2:272|13)|(6:20|21|(1:23)(1:24)|252|25|(40:266|27|28|254|29|30|246|31|32|238|33|34|(1:36)(1:37)|230|38|39|282|40|41|274|42|43|270|44|45|(7:48|260|49|(3:297|51|300)(11:295|52|(3:54|248|55)(1:56)|(3:58|250|59)(1:62)|63|(2:65|(1:72)(1:71))|73|(2:75|(1:82)(1:81))|83|84|299)|298|264|46)|296|89|(2:276|112)|129|242|130|(4:136|(1:138)(1:139)|140|(5:142|(1:144)(1:145)|146|(4:149|(3:291|151|294)(10:290|152|(7:154|155|262|156|(1:158)(1:159)|(1:161)|162)(1:163)|(3:165|258|166)(1:172)|286|173|(2:175|(1:183)(3:181|284|182))(1:184)|185|186|293)|292|147)|289))|135|(2:236|193)|206|(2:209|207)|288|210|211)(1:110))(1:18)|19|(0)|129|242|130|(8:132|134|136|(0)(0)|140|(0)|135|(0))(0)|206|(1:207)|288|210|211|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x042f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02c2 A[Catch: all -> 0x042f, TryCatch #6 {all -> 0x042f, blocks: (B:130:0x02bc, B:132:0x02c2, B:136:0x02d0, B:140:0x02ea, B:142:0x02fc, B:146:0x031d, B:147:0x0339, B:149:0x033f, B:152:0x034a, B:154:0x038a), top: B:242:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02d0 A[Catch: all -> 0x042f, TryCatch #6 {all -> 0x042f, blocks: (B:130:0x02bc, B:132:0x02c2, B:136:0x02d0, B:140:0x02ea, B:142:0x02fc, B:146:0x031d, B:147:0x0339, B:149:0x033f, B:152:0x034a, B:154:0x038a), top: B:242:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02fc A[Catch: all -> 0x042f, TryCatch #6 {all -> 0x042f, blocks: (B:130:0x02bc, B:132:0x02c2, B:136:0x02d0, B:140:0x02ea, B:142:0x02fc, B:146:0x031d, B:147:0x0339, B:149:0x033f, B:152:0x034a, B:154:0x038a), top: B:242:0x02bc }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x044c A[LOOP:0: B:207:0x0446->B:209:0x044c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087 A[Catch: all -> 0x0291, TRY_LEAVE, TryCatch #21 {all -> 0x0291, blocks: (B:13:0x005c, B:15:0x0062, B:20:0x0087), top: B:272:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0428 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0278 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0436 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$loadGalleryPhotosAlbums$40(int r51) {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.lambda$loadGalleryPhotosAlbums$40(int):void");
    }

    static /* synthetic */ int lambda$loadGalleryPhotosAlbums$39(PhotoEntry photoEntry, PhotoEntry photoEntry2) {
        long j = photoEntry.dateTaken;
        long j2 = photoEntry2.dateTaken;
        if (j < j2) {
            return 1;
        }
        return j > j2 ? -1 : 0;
    }

    private static void broadcastNewPhotos(final int guid, final ArrayList<AlbumEntry> mediaAlbumsSorted, final ArrayList<AlbumEntry> photoAlbumsSorted, final Integer cameraAlbumIdFinal, final AlbumEntry allMediaAlbumFinal, final AlbumEntry allPhotosAlbumFinal, final AlbumEntry allVideosAlbumFinal, int delay) {
        Runnable runnable = broadcastPhotosRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$ziRkLNzva0KkbDatbOlKb74ZJyg
            @Override // java.lang.Runnable
            public final void run() {
                MediaController.lambda$broadcastNewPhotos$41(guid, mediaAlbumsSorted, photoAlbumsSorted, cameraAlbumIdFinal, allMediaAlbumFinal, allPhotosAlbumFinal, allVideosAlbumFinal);
            }
        };
        broadcastPhotosRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, delay);
    }

    static /* synthetic */ void lambda$broadcastNewPhotos$41(int i, ArrayList arrayList, ArrayList arrayList2, Integer num, AlbumEntry albumEntry, AlbumEntry albumEntry2, AlbumEntry albumEntry3) {
        if (PhotoViewer.getInstance().isVisible()) {
            broadcastNewPhotos(i, arrayList, arrayList2, num, albumEntry, albumEntry2, albumEntry3, 1000);
            return;
        }
        allMediaAlbums = arrayList;
        allPhotoAlbums = arrayList2;
        broadcastPhotosRunnable = null;
        allPhotosAlbumEntry = albumEntry2;
        allMediaAlbumEntry = albumEntry;
        allVideosAlbumEntry = albumEntry3;
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.albumsDidLoad, Integer.valueOf(i), arrayList, arrayList2, num);
    }

    public void scheduleVideoConvert(MessageObject messageObject) {
        scheduleVideoConvert(messageObject, false);
    }

    public boolean scheduleVideoConvert(MessageObject messageObject, boolean isEmpty) {
        if (messageObject == null || messageObject.videoEditedInfo == null) {
            return false;
        }
        if (isEmpty && !this.videoConvertQueue.isEmpty()) {
            return false;
        }
        if (isEmpty) {
            new File(messageObject.messageOwner.attachPath).delete();
        }
        this.videoConvertQueue.add(new VideoConvertMessage(messageObject, messageObject.videoEditedInfo));
        if (this.videoConvertQueue.size() == 1) {
            startVideoConvertFromQueue();
        }
        return true;
    }

    public void cancelVideoConvert(MessageObject messageObject) {
        if (messageObject == null || this.videoConvertQueue.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.videoConvertQueue.size(); i++) {
            VideoConvertMessage videoConvertMessage = this.videoConvertQueue.get(i);
            MessageObject messageObject2 = videoConvertMessage.messageObject;
            if (messageObject2.equals(messageObject) && messageObject2.currentAccount == messageObject.currentAccount) {
                if (i == 0) {
                    synchronized (this.videoConvertSync) {
                        videoConvertMessage.videoEditedInfo.canceled = true;
                    }
                    return;
                }
                this.videoConvertQueue.remove(i);
                return;
            }
        }
    }

    private boolean startVideoConvertFromQueue() {
        int i = 0;
        if (this.videoConvertQueue.isEmpty()) {
            return false;
        }
        VideoConvertMessage videoConvertMessage = this.videoConvertQueue.get(0);
        MessageObject messageObject = videoConvertMessage.messageObject;
        VideoEditedInfo videoEditedInfo = videoConvertMessage.videoEditedInfo;
        synchronized (this.videoConvertSync) {
            if (videoEditedInfo != null) {
                videoEditedInfo.canceled = false;
            }
        }
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) VideoEncodingService.class);
        intent.putExtra("path", messageObject.messageOwner.attachPath);
        intent.putExtra("currentAccount", messageObject.currentAccount);
        if (messageObject.messageOwner.media.document != null) {
            while (true) {
                if (i >= messageObject.messageOwner.media.document.attributes.size()) {
                    break;
                }
                if (messageObject.messageOwner.media.document.attributes.get(i) instanceof TLRPC$TL_documentAttributeAnimated) {
                    intent.putExtra("gif", true);
                    break;
                }
                i++;
            }
        }
        if (messageObject.getId() != 0) {
            try {
                ApplicationLoader.applicationContext.startService(intent);
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        VideoConvertRunnable.runConversion(videoConvertMessage);
        return true;
    }

    @SuppressLint({"NewApi"})
    public static MediaCodecInfo selectCodec(String mimeType) {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    if (str.equalsIgnoreCase(mimeType)) {
                        String name = codecInfoAt.getName();
                        if (name != null && (!name.equals("OMX.SEC.avc.enc") || name.equals("OMX.SEC.AVC.Encoder"))) {
                            return codecInfoAt;
                        }
                        mediaCodecInfo = codecInfoAt;
                    }
                }
            }
        }
        return mediaCodecInfo;
    }

    @SuppressLint({"NewApi"})
    public static int selectColorFormat(MediaCodecInfo codecInfo, String mimeType) {
        int i;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfo.getCapabilitiesForType(mimeType);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i2 >= iArr.length) {
                return i3;
            }
            i = iArr[i2];
            if (isRecognizedFormat(i)) {
                if (!codecInfo.getName().equals("OMX.SEC.AVC.Encoder") || i != 19) {
                    break;
                }
                i3 = i;
            }
            i2++;
        }
        return i;
    }

    public static int findTrack(MediaExtractor extractor, boolean audio) {
        int trackCount = extractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = extractor.getTrackFormat(i).getString("mime");
            if (audio) {
                if (string.startsWith("audio/")) {
                    return i;
                }
            } else if (string.startsWith("video/")) {
                return i;
            }
        }
        return -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void didWriteData(final VideoConvertMessage message, final File file, final boolean last, final long lastFrameTimestamp, final long availableSize, final boolean error, final float progress) {
        VideoEditedInfo videoEditedInfo = message.videoEditedInfo;
        final boolean z = videoEditedInfo.videoConvertFirstWrite;
        if (z) {
            videoEditedInfo.videoConvertFirstWrite = false;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$sgCbgwYtEO0pD_9WQ69YbkilM4Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didWriteData$42$MediaController(error, last, message, file, progress, lastFrameTimestamp, z, availableSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didWriteData$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didWriteData$42$MediaController(boolean z, boolean z2, VideoConvertMessage videoConvertMessage, File file, float f, long j, boolean z3, long j2) {
        if (z || z2) {
            synchronized (this.videoConvertSync) {
                videoConvertMessage.videoEditedInfo.canceled = false;
            }
            this.videoConvertQueue.remove(videoConvertMessage);
            startVideoConvertFromQueue();
        }
        if (z) {
            NotificationCenter.getInstance(videoConvertMessage.currentAccount).postNotificationName(NotificationCenter.filePreparingFailed, videoConvertMessage.messageObject, file.toString(), Float.valueOf(f), Long.valueOf(j));
            return;
        }
        if (z3) {
            NotificationCenter.getInstance(videoConvertMessage.currentAccount).postNotificationName(NotificationCenter.filePreparingStarted, videoConvertMessage.messageObject, file.toString(), Float.valueOf(f), Long.valueOf(j));
        }
        NotificationCenter notificationCenter = NotificationCenter.getInstance(videoConvertMessage.currentAccount);
        int i = NotificationCenter.fileNewChunkAvailable;
        Object[] objArr = new Object[6];
        objArr[0] = videoConvertMessage.messageObject;
        objArr[1] = file.toString();
        objArr[2] = Long.valueOf(j2);
        objArr[3] = Long.valueOf(z2 ? file.length() : 0L);
        objArr[4] = Float.valueOf(f);
        objArr[5] = Long.valueOf(j);
        notificationCenter.postNotificationName(i, objArr);
    }

    public void pauseByRewind() {
        VideoPlayer videoPlayer = this.audioPlayer;
        if (videoPlayer != null) {
            videoPlayer.pause();
        }
    }

    public void resumeByRewind() throws InterruptedException, IOException {
        VideoPlayer videoPlayer = this.audioPlayer;
        if (videoPlayer == null || this.playingMessageObject == null || this.isPaused) {
            return;
        }
        if (videoPlayer.isBuffering()) {
            MessageObject messageObject = this.playingMessageObject;
            cleanupPlayer(false, false);
            playMessage(messageObject);
            return;
        }
        this.audioPlayer.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class VideoConvertRunnable implements Runnable {
        private VideoConvertMessage convertMessage;

        private VideoConvertRunnable(VideoConvertMessage message) {
            this.convertMessage = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaController.getInstance().convertVideo(this.convertMessage);
        }

        public static void runConversion(final VideoConvertMessage obj) {
            new Thread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaController$VideoConvertRunnable$G03QrwcwyFbL6IJZSsudVfE-eiE
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    MediaController.VideoConvertRunnable.lambda$runConversion$0(obj);
                }
            }).start();
        }

        static /* synthetic */ void lambda$runConversion$0(VideoConvertMessage videoConvertMessage) throws InterruptedException {
            try {
                Thread thread = new Thread(new VideoConvertRunnable(videoConvertMessage), "VideoConvertRunnable");
                thread.start();
                thread.join();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean convertVideo(final ir.eitaa.messenger.MediaController.VideoConvertMessage r43) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.convertVideo(ir.eitaa.messenger.MediaController$VideoConvertMessage):boolean");
    }

    public static int getVideoBitrate(String path) {
        int i;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(path);
            i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        } catch (Exception e) {
            FileLog.e(e);
            i = 0;
        }
        mediaMetadataRetriever.release();
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int makeVideoBitrate(int r5, int r6, int r7, int r8, int r9) {
        /*
            int r0 = java.lang.Math.min(r8, r9)
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 1080(0x438, float:1.513E-42)
            if (r0 < r2) goto L10
            r0 = 6800000(0x67c280, float:9.52883E-39)
        Ld:
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L37
        L10:
            int r0 = java.lang.Math.min(r8, r9)
            r2 = 720(0x2d0, float:1.009E-42)
            if (r0 < r2) goto L1c
            r0 = 3200000(0x30d400, float:4.484155E-39)
            goto Ld
        L1c:
            int r0 = java.lang.Math.min(r8, r9)
            r1 = 480(0x1e0, float:6.73E-43)
            if (r0 < r1) goto L2e
            r0 = 1000000(0xf4240, float:1.401298E-39)
            r1 = 1061997773(0x3f4ccccd, float:0.8)
            r2 = 1063675494(0x3f666666, float:0.9)
            goto L37
        L2e:
            r0 = 750000(0xb71b0, float:1.050974E-39)
            r1 = 1058642330(0x3f19999a, float:0.6)
            r2 = 1060320051(0x3f333333, float:0.7)
        L37:
            float r3 = (float) r7
            float r5 = (float) r5
            float r4 = (float) r8
            float r5 = r5 / r4
            float r6 = (float) r6
            float r4 = (float) r9
            float r6 = r6 / r4
            float r5 = java.lang.Math.min(r5, r6)
            float r3 = r3 / r5
            int r5 = (int) r3
            float r5 = (float) r5
            float r5 = r5 * r1
            int r5 = (int) r5
            int r6 = getVideoBitrateWithFactor(r2)
            float r6 = (float) r6
            r1 = 1231093760(0x49610000, float:921600.0)
            int r9 = r9 * r8
            float r8 = (float) r9
            float r1 = r1 / r8
            float r6 = r6 / r1
            int r6 = (int) r6
            if (r7 >= r6) goto L58
            return r5
        L58:
            if (r5 <= r0) goto L5b
            return r0
        L5b:
            int r5 = java.lang.Math.max(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaController.makeVideoBitrate(int, int, int, int, int):int");
    }

    public static class PlaylistGlobalSearchParams {
        final long dialogId;
        public boolean endReached;
        final FiltersView.MediaFilterData filter;
        public int folderId;
        final long maxDate;
        final long minDate;
        public int nextSearchRate;
        final String query;
        public int totalCount;

        public PlaylistGlobalSearchParams(String query, long dialogId, long minDate, long maxDate, FiltersView.MediaFilterData filter) {
            this.filter = filter;
            this.query = query;
            this.dialogId = dialogId;
            this.minDate = minDate;
            this.maxDate = maxDate;
        }
    }

    public boolean currentPlaylistIsGlobalSearch() {
        return this.playlistGlobalSearchParams != null;
    }
}
