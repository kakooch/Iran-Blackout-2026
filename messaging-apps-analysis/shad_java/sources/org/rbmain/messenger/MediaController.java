package org.rbmain.messenger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
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
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.collection.LongSparseArray;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2t.analytics.AnalyticsListener;
import com.google.android.exoplayer2t.ui.AspectRatioFrameLayout;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.components.sshCrop.SSHCropView;
import ir.appp.rghapp.video.SSHMediaCodecVideoConvertor;
import ir.appp.rghapp.video.SSHMediaPhotoConvertor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.messenger.audioinfo.AudioInfo;
import org.rbmain.messenger.video.MediaCodecVideoConvertor;
import org.rbmain.messenger.voip.VoIPService;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInlineResult;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$InputDocument;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_document;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAnimated;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAudio;
import org.rbmain.tgnet.TLRPC$TL_encryptedChat;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterEmpty;
import org.rbmain.tgnet.TLRPC$TL_messages_messages;
import org.rbmain.tgnet.TLRPC$TL_messages_search;
import org.rbmain.tgnet.TLRPC$TL_messages_searchGlobal;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Adapters.FiltersView;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AnimatedFileDrawable;
import org.rbmain.ui.Components.EmbedBottomSheet;
import org.rbmain.ui.Components.PhotoFilterView;
import org.rbmain.ui.Components.PipRoundVideoView;
import org.rbmain.ui.Components.Point;
import org.rbmain.ui.Components.VideoPlayer;
import org.rbmain.ui.PhotoViewer;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class MediaController implements AudioManager.OnAudioFocusChangeListener, NotificationCenter.NotificationCenterDelegate, SensorEventListener {
    private static final int AUDIO_FOCUSED = 2;
    private static final int AUDIO_NO_FOCUS_CAN_DUCK = 1;
    private static final int AUDIO_NO_FOCUS_NO_DUCK = 0;
    public static final String AUIDO_MIME_TYPE = "audio/mp4a-latm";
    public static final int IMAGE_EXPORT_QUALITY = 87;
    private static volatile MediaController Instance = null;
    public static final float MAX_LANDSCAPE_SCALE = 0.5f;
    public static final float MAX_PORTRAIT_SCALE = 0.834f;
    public static final int MAX_WIDTH_HEIGHT_SIZE = 800;
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
    private static long volumeBarLastTimeShown;
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
    private long lastMessageId;
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
    private LongSparseArray<MessageObject> voiceMessagesPlaylistMap;
    private boolean voiceMessagesPlaylistUnread;
    private final RectF cropArea = new RectF();
    private boolean isLockRatio = false;
    public ArrayList<SSHMediaConvertRequest> mediaConvertQueue = new ArrayList<>();
    private final Object mediaConvertSync = new Object();
    AudioManager.OnAudioFocusChangeListener audioRecordFocusChangedListener = new AudioManager.OnAudioFocusChangeListener() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda2
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i) {
            this.f$0.lambda$new$0(i);
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
    public boolean isSilent = false;
    private boolean isPaused = false;
    private VideoPlayer audioPlayer = null;
    private VideoPlayer emojiSoundPlayer = null;
    private int emojiSoundPlayerNum = 0;
    private float currentPlaybackSpeed = VOLUME_NORMAL;
    private float currentMusicPlaybackSpeed = VOLUME_NORMAL;
    private long lastProgress = 0;
    private Timer progressTimer = null;
    private final Object progressTimerSync = new Object();
    private ArrayList<MessageObject> playlist = new ArrayList<>();
    private HashMap<Long, MessageObject> playlistMap = new HashMap<>();
    private ArrayList<MessageObject> shuffledPlaylist = new ArrayList<>();
    private boolean[] playlistEndReached = {false, false};
    private long[] playlistMaxId = {Long.MAX_VALUE, Long.MAX_VALUE};
    private Runnable setLoadingRunnable = new Runnable() { // from class: org.rbmain.messenger.MediaController.1
        @Override // java.lang.Runnable
        public void run() {
            if (MediaController.this.playingMessageObject == null) {
                return;
            }
            FileLoader.getInstance(MediaController.this.playingMessageObject.currentAccount).setLoadingVideo(MediaController.this.playingMessageObject.getDocument(), true, false);
        }
    };
    private int recordingGuid = -1;
    private short[] recordSamples = new short[1024];
    private final Object sync = new Object();
    private ArrayList<ByteBuffer> recordBuffers = new ArrayList<>();
    public int recordBufferSize = 1280;
    public int sampleRate = 16000;
    private Runnable recordRunnable = new AnonymousClass2();
    private final ValueAnimator.AnimatorUpdateListener audioVolumeUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.messenger.MediaController.3
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MediaController.this.audioVolume = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            MediaController.this.setPlayerVolume();
        }
    };

    /* loaded from: classes4.dex */
    public static class AudioEntry {
        public String author;
        public int duration;
        public String genre;
        public long id;
        public MessageObject messageObject;
        public String path;
        public String title;
    }

    /* loaded from: classes4.dex */
    public static class CropState {
        public float cropPx;
        public float cropPy;
        public float cropRotate;
        public boolean freeform;
        public int height;
        public boolean initied;
        public float lockedAspectRatio;
        public Matrix matrix;
        public float minScale;
        public boolean mirrored;
        public float scale;
        public float stateScale;
        public int transformHeight;
        public int transformRotation;
        public int transformWidth;
        public int translateX;
        public int translateY;
        public int width;
        public float cropScale = MediaController.VOLUME_NORMAL;
        public float cropPw = MediaController.VOLUME_NORMAL;
        public float cropPh = MediaController.VOLUME_NORMAL;
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public interface VideoConvertorListener {
        boolean checkConversionCanceled();

        void didWriteData(long j, float f);

        void finishMakeVideo();
    }

    private static int getVideoBitrateWithFactor(float f) {
        return (int) (f * 2000.0f * 1000.0f * 1.13f);
    }

    public static native int isOpusFile(String str);

    private static boolean isRecognizedFormat(int i) {
        if (i == 39 || i == 2130706688) {
            return true;
        }
        switch (i) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    private native int startRecord(String str, int i);

    private native void stopRecord();

    /* JADX INFO: Access modifiers changed from: private */
    public native int writeFrame(ByteBuffer byteBuffer, int i);

    public native byte[] getWaveform(String str);

    public native byte[] getWaveform2(short[] sArr, int i);

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
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

    /* loaded from: classes4.dex */
    private static class AudioBuffer {
        ByteBuffer buffer;
        byte[] bufferBytes;
        int finished;
        long pcmOffset;
        int size;

        public AudioBuffer(int i) {
            this.buffer = ByteBuffer.allocateDirect(i);
            this.bufferBytes = new byte[i];
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

    /* loaded from: classes4.dex */
    public static class AlbumEntry {
        public int bucketId;
        public String bucketName;
        public PhotoEntry coverPhoto;
        public ArrayList<PhotoEntry> photos = new ArrayList<>();
        public SparseArray<PhotoEntry> photosByIds = new SparseArray<>();
        public boolean videoOnly;

        public AlbumEntry(int i, String str, PhotoEntry photoEntry) {
            this.bucketId = i;
            this.bucketName = str;
            this.coverPhoto = photoEntry;
        }

        public void addPhoto(PhotoEntry photoEntry) {
            this.photos.add(photoEntry);
            this.photosByIds.put(photoEntry.imageId, photoEntry);
        }
    }

    /* loaded from: classes4.dex */
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

        public void copyFrom(MediaEditState mediaEditState) {
            this.caption = mediaEditState.caption;
            this.thumbPath = mediaEditState.thumbPath;
            this.imagePath = mediaEditState.imagePath;
            this.filterPath = mediaEditState.filterPath;
            this.paintPath = mediaEditState.paintPath;
            this.croppedPaintPath = mediaEditState.croppedPaintPath;
            this.fullPaintPath = mediaEditState.fullPaintPath;
            this.entities = mediaEditState.entities;
            this.savedFilterState = mediaEditState.savedFilterState;
            this.mediaEntities = mediaEditState.mediaEntities;
            this.croppedMediaEntities = mediaEditState.croppedMediaEntities;
            this.stickers = mediaEditState.stickers;
            this.editedInfo = mediaEditState.editedInfo;
            this.averageDuration = mediaEditState.averageDuration;
            this.isFiltered = mediaEditState.isFiltered;
            this.isPainted = mediaEditState.isPainted;
            this.isCropped = mediaEditState.isCropped;
            this.ttl = mediaEditState.ttl;
            this.cropState = mediaEditState.cropState;
        }
    }

    /* loaded from: classes4.dex */
    public static class PhotoEntry extends MediaEditState {
        public int bucketId;
        public boolean canDeleteAfter;
        public long dateTaken;
        public int duration;
        public TLRPC$VideoSize emojiMarkup;
        public boolean hasSpoiler;
        public int height;
        public int imageId;
        public int invert;
        public boolean isAttachSpoilerRevealed;
        public boolean isChatPreviewSpoilerRevealed;
        public boolean isMuted;
        public boolean isVideo;
        public int orientation;
        public String path;
        public long size;
        public int width;

        public PhotoEntry(int i, int i2, long j, String str, int i3, boolean z, int i4, int i5, long j2) {
            this.bucketId = i;
            this.imageId = i2;
            this.dateTaken = j;
            this.path = str;
            this.width = i4;
            this.height = i5;
            this.size = j2;
            if (z) {
                this.duration = i3;
            } else {
                this.orientation = i3;
            }
            this.isVideo = z;
        }

        public PhotoEntry setOrientation(Pair<Integer, Integer> pair) {
            this.orientation = ((Integer) pair.first).intValue();
            this.invert = ((Integer) pair.second).intValue();
            return this;
        }

        public PhotoEntry setOrientation(int i, int i2) {
            this.orientation = i;
            this.invert = i2;
            return this;
        }

        @Override // org.rbmain.messenger.MediaController.MediaEditState
        public void copyFrom(MediaEditState mediaEditState) {
            super.copyFrom(mediaEditState);
            this.hasSpoiler = (mediaEditState instanceof PhotoEntry) && ((PhotoEntry) mediaEditState).hasSpoiler;
        }

        @Override // org.rbmain.messenger.MediaController.MediaEditState
        public String getPath() {
            return this.path;
        }

        @Override // org.rbmain.messenger.MediaController.MediaEditState
        public void reset() {
            if (this.isVideo && this.filterPath != null) {
                new File(this.filterPath).delete();
                this.filterPath = null;
            }
            this.hasSpoiler = false;
            super.reset();
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // org.rbmain.messenger.MediaController.MediaEditState
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

        @Override // org.rbmain.messenger.MediaController.MediaEditState
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
    public /* synthetic */ void lambda$new$0(int i) {
        if (i != 1) {
            this.hasRecordAudioFocus = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    static class VideoConvertMessage {
        public int currentAccount;
        public MessageObject messageObject;
        public VideoEditedInfo videoEditedInfo;

        public VideoConvertMessage(MessageObject messageObject, VideoEditedInfo videoEditedInfo) {
            this.messageObject = messageObject;
            this.currentAccount = messageObject.currentAccount;
            this.videoEditedInfo = videoEditedInfo;
        }
    }

    /* renamed from: org.rbmain.messenger.MediaController$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 358
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaController.AnonymousClass2.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(final ByteBuffer byteBuffer, boolean z) {
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
                        MediaController.access$1614(MediaController.this, (r1.fileBuffer.limit() / 2) / (MediaController.this.sampleRate / CloseCodes.NORMAL_CLOSURE));
                    }
                }
                if (iLimit != -1) {
                    byteBuffer.limit(iLimit);
                }
            }
            MediaController.this.recordQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0(byteBuffer);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(ByteBuffer byteBuffer) {
            MediaController.this.recordBuffers.add(byteBuffer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$2(double d) {
            NotificationCenter.getInstance(MediaController.this.recordingCurrentAccount).postNotificationName(NotificationCenter.recordProgressChanged, Integer.valueOf(MediaController.this.recordingGuid), Double.valueOf(d));
        }
    }

    /* loaded from: classes4.dex */
    private class InternalObserver extends ContentObserver {
        public InternalObserver() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            MediaController.this.processMediaObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        }
    }

    /* loaded from: classes4.dex */
    private class ExternalObserver extends ContentObserver {
        public ExternalObserver() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            MediaController.this.processMediaObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    static class GalleryObserverInternal extends ContentObserver {
        public GalleryObserverInternal() {
            super(null);
        }

        private void scheduleReloadRunnable() {
            AndroidUtilities.runOnUIThread(MediaController.refreshGalleryRunnable = new Runnable() { // from class: org.rbmain.messenger.MediaController$GalleryObserverInternal$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$scheduleReloadRunnable$0();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$scheduleReloadRunnable$0() {
            if (!PhotoViewer.getInstance().isVisible()) {
                Runnable unused = MediaController.refreshGalleryRunnable = null;
                MediaController.loadGalleryPhotosAlbums(0);
            } else {
                scheduleReloadRunnable();
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (MediaController.refreshGalleryRunnable != null) {
                AndroidUtilities.cancelRunOnUIThread(MediaController.refreshGalleryRunnable);
            }
            scheduleReloadRunnable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    static class GalleryObserverExternal extends ContentObserver {
        public GalleryObserverExternal() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (MediaController.refreshGalleryRunnable != null) {
                AndroidUtilities.cancelRunOnUIThread(MediaController.refreshGalleryRunnable);
            }
            AndroidUtilities.runOnUIThread(MediaController.refreshGalleryRunnable = new Runnable() { // from class: org.rbmain.messenger.MediaController$GalleryObserverExternal$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaController.GalleryObserverExternal.lambda$onChange$0();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onChange$0() {
            Runnable unused = MediaController.refreshGalleryRunnable = null;
            MediaController.loadGalleryPhotosAlbums(0);
        }
    }

    public static void checkGallery() {
        AlbumEntry albumEntry;
        if (Build.VERSION.SDK_INT < 24 || (albumEntry = allPhotosAlbumEntry) == null) {
            return;
        }
        final int size = albumEntry.photos.size();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MediaController.lambda$checkGallery$1(size);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:61|3)|(7:5|(4:55|7|(2:9|10)|(1:16))|57|23|(2:29|30)|(1:32)|(4:38|(1:40)|41|42)(1:63))(1:13)|14|(0)|57|23|(4:25|27|29|30)|(0)|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0074, code lost:
    
        org.rbmain.messenger.FileLog.e(r0);
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
    public static /* synthetic */ void lambda$checkGallery$1(int r13) {
        /*
            java.lang.String r0 = "COUNT(_id)"
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            r2 = 1
            r3 = 0
            r4 = 0
            android.content.Context r5 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L3a
            int r5 = r5.checkSelfPermission(r1)     // Catch: java.lang.Throwable -> L3a
            if (r5 != 0) goto L32
            android.content.Context r5 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L3a
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
            org.rbmain.messenger.FileLog.e(r6)     // Catch: java.lang.Throwable -> L90
            if (r5 == 0) goto L44
            r5.close()
        L44:
            r6 = 0
        L45:
            android.content.Context r7 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L73
            int r1 = r7.checkSelfPermission(r1)     // Catch: java.lang.Throwable -> L73
            if (r1 != 0) goto L6d
            android.content.Context r1 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L73
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
            org.rbmain.messenger.FileLog.e(r0)     // Catch: java.lang.Throwable -> L89
            if (r5 == 0) goto L7a
            goto L6f
        L7a:
            if (r13 == r6) goto L88
            java.lang.Runnable r13 = org.rbmain.messenger.MediaController.refreshGalleryRunnable
            if (r13 == 0) goto L85
            org.rbmain.messenger.AndroidUtilities.cancelRunOnUIThread(r13)
            org.rbmain.messenger.MediaController.refreshGalleryRunnable = r3
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaController.lambda$checkGallery$1(int):void");
    }

    /* loaded from: classes4.dex */
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
        this.recordQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$2();
            }
        });
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$3();
            }
        });
        this.fileBuffer = ByteBuffer.allocateDirect(1920);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$4();
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
    public /* synthetic */ void lambda$new$2() {
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
    public /* synthetic */ void lambda$new$3() {
        try {
            this.currentPlaybackSpeed = MessagesController.getGlobalMainSettings().getFloat("playbackSpeed", VOLUME_NORMAL);
            this.currentMusicPlaybackSpeed = MessagesController.getGlobalMainSettings().getFloat("musicPlaybackSpeed", VOLUME_NORMAL);
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
            this.proximityWakeLock = ((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).newWakeLock(32, "rubika:proximity_lock");
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

    /* renamed from: org.rbmain.messenger.MediaController$4, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass4 extends PhoneStateListener {
        AnonymousClass4() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(final int i, String str) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCallStateChanged$0(i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallStateChanged$0(int i) {
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
    public /* synthetic */ void lambda$new$4() {
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.fileDidLoad);
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
    public void onAudioFocusChange(final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAudioFocusChange$5(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAudioFocusChange$5(int i) {
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
        float f;
        try {
            if (this.isSilent) {
                f = 0.0f;
            } else {
                f = this.audioFocus != 1 ? VOLUME_NORMAL : VOLUME_DUCK;
            }
            VideoPlayer videoPlayer = this.audioPlayer;
            if (videoPlayer != null) {
                videoPlayer.setVolume(f * this.audioVolume);
                return;
            }
            VideoPlayer videoPlayer2 = this.videoPlayer;
            if (videoPlayer2 != null) {
                videoPlayer2.setVolume(f);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void startProgressTimer(MessageObject messageObject) {
        synchronized (this.progressTimerSync) {
            Timer timer = this.progressTimer;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.progressTimer = null;
                } catch (Exception e) {
                    FileLog.e(e);
                }
                messageObject.getFileName();
                Timer timer2 = new Timer();
                this.progressTimer = timer2;
                timer2.schedule(new AnonymousClass5(messageObject), 0L, 17L);
            } else {
                messageObject.getFileName();
                Timer timer22 = new Timer();
                this.progressTimer = timer22;
                timer22.schedule(new AnonymousClass5(messageObject), 0L, 17L);
            }
        }
    }

    /* renamed from: org.rbmain.messenger.MediaController$5, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass5 extends TimerTask {
        final /* synthetic */ MessageObject val$currentPlayingMessageObject;

        AnonymousClass5(MessageObject messageObject) {
            this.val$currentPlayingMessageObject = messageObject;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (MediaController.this.sync) {
                final MessageObject messageObject = this.val$currentPlayingMessageObject;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$5$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$1(messageObject);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(MessageObject messageObject) {
            long duration;
            long currentPosition;
            final float f;
            float bufferedPosition;
            if (messageObject != null) {
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
                            f = duration >= 0 ? currentPosition / f2 : 0.0f;
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
                        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$5$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                MediaController.AnonymousClass5.lambda$run$0(str, f);
                            }
                        });
                    }
                    NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Long.valueOf(messageObject.getId()), Float.valueOf(f));
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(String str, float f) {
            ApplicationLoader.applicationContext.getSharedPreferences("media_saved_pos", 0).edit().putFloat(str, f).apply();
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
        cancelVideoConvert((MessageObject) null);
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
        long[] jArr = this.playlistMaxId;
        jArr[1] = Long.MAX_VALUE;
        jArr[0] = Long.MAX_VALUE;
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
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda27
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$processMediaObserver$6(arrayList);
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
    public /* synthetic */ void lambda$processMediaObserver$6(ArrayList arrayList) {
        NotificationCenter.getInstance(this.lastChatAccount).postNotificationName(NotificationCenter.screenshotTook, new Object[0]);
        checkScreenshots(arrayList);
    }

    private void checkScreenshots(ArrayList<Long> arrayList) {
        if (arrayList == null || arrayList.isEmpty() || this.lastChatEnterTime == 0) {
            return;
        }
        if (this.lastUser != null || (this.lastSecretChat instanceof TLRPC$TL_encryptedChat)) {
            boolean z = false;
            for (int i = 0; i < arrayList.size(); i++) {
                Long l = arrayList.get(i);
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

    public void setLastVisibleMessageIds(int i, long j, long j2, TLRPC$User tLRPC$User, TLRPC$EncryptedChat tLRPC$EncryptedChat, ArrayList<Long> arrayList, long j3) {
        this.lastChatEnterTime = j;
        this.lastChatLeaveTime = j2;
        this.lastChatAccount = i;
        this.lastSecretChat = tLRPC$EncryptedChat;
        this.lastUser = tLRPC$User;
        this.lastMessageId = j3;
        this.lastChatVisibleMessages = arrayList;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        ArrayList<MessageObject> arrayList;
        int iIndexOf;
        int iIndexOf2;
        int i3 = 0;
        if (i == NotificationCenter.fileDidLoad || i == NotificationCenter.httpFileDidLoad) {
            String str = (String) objArr[0];
            MessageObject messageObject = this.playingMessageObject;
            if (messageObject != null && messageObject.currentAccount == i2 && FileLoader.getAttachFileName(messageObject.getDocument()).equals(str)) {
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
        if (i == NotificationCenter.messagesDeleted) {
            if (((Boolean) objArr[2]).booleanValue()) {
                return;
            }
            int iIntValue = ((Integer) objArr[1]).intValue();
            ArrayList arrayList2 = (ArrayList) objArr[0];
            MessageObject messageObject2 = this.playingMessageObject;
            if (messageObject2 != null && iIntValue == messageObject2.messageOwner.peer_id.channel_id && arrayList2.contains(Long.valueOf(messageObject2.getId()))) {
                cleanupPlayer(true, true);
            }
            ArrayList<MessageObject> arrayList3 = this.voiceMessagesPlaylist;
            if (arrayList3 == null || arrayList3.isEmpty() || iIntValue != this.voiceMessagesPlaylist.get(0).messageOwner.peer_id.channel_id) {
                return;
            }
            while (i3 < arrayList2.size()) {
                Long l = (Long) arrayList2.get(i3);
                MessageObject messageObject3 = this.voiceMessagesPlaylistMap.get(l.longValue());
                this.voiceMessagesPlaylistMap.remove(l.longValue());
                if (messageObject3 != null) {
                    this.voiceMessagesPlaylist.remove(messageObject3);
                }
                i3++;
            }
            return;
        }
        if (i == NotificationCenter.removeAllMessagesFromDialog) {
            long jLongValue = ((Long) objArr[0]).longValue();
            MessageObject messageObject4 = this.playingMessageObject;
            if (messageObject4 == null || messageObject4.getDialogId() != jLongValue) {
                return;
            }
            cleanupPlayer(false, true);
            return;
        }
        if (i == NotificationCenter.musicDidLoad) {
            long jLongValue2 = ((Long) objArr[0]).longValue();
            MessageObject messageObject5 = this.playingMessageObject;
            if (messageObject5 == null || !messageObject5.isMusic() || this.playingMessageObject.getDialogId() != jLongValue2 || this.playingMessageObject.scheduled) {
                return;
            }
            ArrayList arrayList4 = (ArrayList) objArr[1];
            ArrayList arrayList5 = (ArrayList) objArr[2];
            this.playlist.addAll(0, arrayList4);
            this.playlist.addAll(arrayList5);
            int size = this.playlist.size();
            for (int i4 = 0; i4 < size; i4++) {
                MessageObject messageObject6 = this.playlist.get(i4);
                this.playlistMap.put(Long.valueOf(messageObject6.getId()), messageObject6);
                long[] jArr = this.playlistMaxId;
                jArr[0] = Math.min(jArr[0], messageObject6.getId());
            }
            sortPlaylist();
            if (SharedConfig.shuffleMusic) {
                buildShuffledPlayList();
            } else {
                MessageObject messageObject7 = this.playingMessageObject;
                if (messageObject7 != null && (iIndexOf2 = this.playlist.indexOf(messageObject7)) >= 0) {
                    this.currentPlaylistNum = iIndexOf2;
                }
            }
            this.playlistClassGuid = ConnectionsManager.generateClassGuid();
            return;
        }
        if (i == NotificationCenter.mediaDidLoad) {
            if (((Integer) objArr[3]).intValue() != this.playlistClassGuid || this.playingMessageObject == null) {
                return;
            }
            long jLongValue3 = ((Long) objArr[0]).longValue();
            ((Integer) objArr[4]).intValue();
            ArrayList arrayList6 = (ArrayList) objArr[2];
            char c = jLongValue3 == this.playlistMergeDialogId ? (char) 1 : (char) 0;
            if (!arrayList6.isEmpty()) {
                this.playlistEndReached[c] = ((Boolean) objArr[5]).booleanValue();
            }
            int i5 = 0;
            for (int i6 = 0; i6 < arrayList6.size(); i6++) {
                MessageObject messageObject8 = (MessageObject) arrayList6.get(i6);
                if (!this.playlistMap.containsKey(Long.valueOf(messageObject8.getId()))) {
                    i5++;
                    this.playlist.add(0, messageObject8);
                    this.playlistMap.put(Long.valueOf(messageObject8.getId()), messageObject8);
                    long[] jArr2 = this.playlistMaxId;
                    jArr2[c] = Math.min(jArr2[c], messageObject8.getId());
                }
            }
            sortPlaylist();
            MessageObject messageObject9 = this.playingMessageObject;
            if (messageObject9 != null && (iIndexOf = this.playlist.indexOf(messageObject9)) >= 0) {
                this.currentPlaylistNum = iIndexOf;
            }
            this.loadingPlaylist = false;
            if (SharedConfig.shuffleMusic) {
                buildShuffledPlayList();
            }
            if (i5 != 0) {
                NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.moreMusicDidLoad, Integer.valueOf(i5));
                return;
            }
            return;
        }
        if (i == NotificationCenter.didReceiveNewMessages) {
            if (((Boolean) objArr[2]).booleanValue() || (arrayList = this.voiceMessagesPlaylist) == null || arrayList.isEmpty() || ((Long) objArr[0]).longValue() != this.voiceMessagesPlaylist.get(0).getDialogId()) {
                return;
            }
            ArrayList arrayList7 = (ArrayList) objArr[1];
            while (i3 < arrayList7.size()) {
                MessageObject messageObject10 = (MessageObject) arrayList7.get(i3);
                if ((messageObject10.isVoice() || messageObject10.isRoundVideo()) && (!this.voiceMessagesPlaylistUnread || (messageObject10.isContentUnread() && !messageObject10.isOut()))) {
                    this.voiceMessagesPlaylist.add(messageObject10);
                    this.voiceMessagesPlaylistMap.put(messageObject10.getId(), messageObject10);
                }
                i3++;
            }
            return;
        }
        if (i == NotificationCenter.playerDidStartPlaying && (objArr[0] instanceof VideoPlayer) && !getInstance().isCurrentPlayer((VideoPlayer) objArr[0])) {
            getInstance().lambda$startAudioAgain$7(getInstance().getPlayingMessageObject());
        }
    }

    protected boolean isRecordingAudio() {
        return (this.recordStartRunnable == null && this.recordingAudio == null) ? false : true;
    }

    private boolean isNearToSensor(float f) {
        return f < 5.0f && f != this.proximitySensor.getMaximumRange();
    }

    public boolean isRecordingOrListeningByProximity() {
        MessageObject messageObject;
        return this.proximityTouched && (isRecordingAudio() || ((messageObject = this.playingMessageObject) != null && (messageObject.isVoice() || this.playingMessageObject.isRoundVideo())));
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d;
        boolean z;
        int i;
        PowerManager.WakeLock wakeLock;
        PowerManager.WakeLock wakeLock2;
        PowerManager.WakeLock wakeLock3;
        PowerManager.WakeLock wakeLock4;
        PowerManager.WakeLock wakeLock5;
        if (this.sensorsStarted && VoIPService.getSharedInstance() == null) {
            Sensor sensor = sensorEvent.sensor;
            if (sensor == this.proximitySensor) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("proximity changed to " + sensorEvent.values[0] + " max value = " + this.proximitySensor.getMaximumRange());
                }
                float f = this.lastProximityValue;
                if (f == -100.0f) {
                    this.lastProximityValue = sensorEvent.values[0];
                } else if (f != sensorEvent.values[0]) {
                    this.proximityHasDifferentValues = true;
                }
                if (this.proximityHasDifferentValues) {
                    this.proximityTouched = isNearToSensor(sensorEvent.values[0]);
                }
            } else if (sensor == this.accelerometerSensor) {
                long j = this.lastTimestamp;
                if (j == 0) {
                    d = 0.9800000190734863d;
                } else {
                    double d2 = sensorEvent.timestamp - j;
                    Double.isNaN(d2);
                    d = 1.0d / ((d2 / 1.0E9d) + 1.0d);
                }
                this.lastTimestamp = sensorEvent.timestamp;
                float[] fArr = this.gravity;
                double d3 = fArr[0];
                Double.isNaN(d3);
                double d4 = 1.0d - d;
                float[] fArr2 = sensorEvent.values;
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
                float[] fArr6 = sensorEvent.values;
                fArr5[0] = fArr6[0];
                fArr5[1] = fArr6[1];
                fArr5[2] = fArr6[2];
            } else if (sensor == this.gravitySensor) {
                float[] fArr7 = this.gravityFast;
                float[] fArr8 = this.gravity;
                float[] fArr9 = sensorEvent.values;
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
            Sensor sensor2 = sensorEvent.sensor;
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
                    if (this.playingMessageObject != null && !ApplicationLoader.mainInterfacePaused && ((this.playingMessageObject.isVoice() || this.playingMessageObject.isRoundVideo()) && !this.useFrontSpeaker && !NotificationsController.audioManager.isWiredHeadsetOn())) {
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

    private void setUseFrontSpeaker(boolean z) {
        this.useFrontSpeaker = z;
        AudioManager audioManager = NotificationsController.audioManager;
        if (z) {
            audioManager.setBluetoothScoOn(false);
            audioManager.setSpeakerphoneOn(false);
        } else {
            audioManager.setSpeakerphoneOn(true);
        }
    }

    public void startRecordingIfFromSpeaker() {
        ChatActivity chatActivity;
        if (this.useFrontSpeaker && (chatActivity = this.raiseChat) != null && this.allowStartRecord && SharedConfig.raiseToSpeak) {
            this.raiseToEarRecord = true;
            startRecording(chatActivity.getCurrentAccount(), this.raiseChat.getDialogId(), null, this.raiseChat.getThreadMessage(), this.raiseChat.getClassGuid());
            this.ignoreOnPause = true;
        }
    }

    private void startAudioAgain(boolean z) {
        MessageObject messageObject = this.playingMessageObject;
        if (messageObject == null) {
            return;
        }
        NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.audioRouteChanged, Boolean.valueOf(this.useFrontSpeaker));
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setStreamType(this.useFrontSpeaker ? 0 : 3);
            if (!z) {
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
        boolean z2 = videoPlayer2 != null;
        final MessageObject messageObject2 = this.playingMessageObject;
        float f = messageObject2.audioProgress;
        int i = messageObject2.audioPlayerDuration;
        if (z || videoPlayer2 == null || !videoPlayer2.isPlaying() || i * f > VOLUME_NORMAL) {
            messageObject2.audioProgress = f;
        } else {
            messageObject2.audioProgress = 0.0f;
        }
        cleanupPlayer(false, true);
        playMessage(messageObject2);
        if (z) {
            if (z2) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda28
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$startAudioAgain$7(messageObject2);
                    }
                }, 100L);
            } else {
                lambda$startAudioAgain$7(messageObject2);
            }
        }
    }

    public void setInputFieldHasText(boolean z) {
        this.inputFieldHasText = z;
    }

    public void setAllowStartRecord(boolean z) {
        this.allowStartRecord = z;
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
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startRaiseToEarSensors$8();
                }
            });
            this.sensorsStarted = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRaiseToEarSensors$8() {
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

    public void stopRaiseToEarSensors(ChatActivity chatActivity, boolean z) {
        PowerManager.WakeLock wakeLock;
        if (this.ignoreOnPause) {
            this.ignoreOnPause = false;
            return;
        }
        stopRecording(z ? 2 : 0, false, 0);
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
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopRaiseToEarSensors$9();
            }
        });
        if (this.proximityHasDifferentValues && (wakeLock = this.proximityWakeLock) != null && wakeLock.isHeld()) {
            this.proximityWakeLock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopRaiseToEarSensors$9() {
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

    public void cleanupPlayer(boolean z, boolean z2) {
        cleanupPlayer(z, z2, false, false);
    }

    public void cleanupPlayer(boolean z, boolean z2, boolean z3, boolean z4) {
        PipRoundVideoView pipRoundVideoView;
        MessageObject messageObject;
        if (this.audioPlayer != null) {
            ValueAnimator valueAnimator = this.audioVolumeAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.audioVolumeAnimator.cancel();
            }
            if (this.audioPlayer.isPlaying() && (messageObject = this.playingMessageObject) != null && !messageObject.isVoice()) {
                final VideoPlayer videoPlayer = this.audioPlayer;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.audioVolume, 0.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$cleanupPlayer$10(videoPlayer, valueAnimator2);
                    }
                });
                valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.messenger.MediaController.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            videoPlayer.releasePlayer(true);
                        } catch (Exception e) {
                            FileLog.e(e);
                        }
                    }
                });
                valueAnimatorOfFloat.setDuration(300L);
                valueAnimatorOfFloat.start();
            } else {
                try {
                    this.audioPlayer.releasePlayer(true);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            this.audioPlayer = null;
            Theme.unrefAudioVisualizeDrawable(this.playingMessageObject);
        } else {
            VideoPlayer videoPlayer2 = this.videoPlayer;
            if (videoPlayer2 != null) {
                this.currentAspectRatioFrameLayout = null;
                this.currentTextureViewContainer = null;
                this.currentAspectRatioFrameLayoutReady = false;
                this.isDrawingWasReady = false;
                this.currentTextureView = null;
                this.goingToShowMessageObject = null;
                if (z4) {
                    PhotoViewer.getInstance().injectVideoPlayer(this.videoPlayer);
                    MessageObject messageObject2 = this.playingMessageObject;
                    this.goingToShowMessageObject = messageObject2;
                    NotificationCenter.getInstance(messageObject2.currentAccount).postNotificationName(NotificationCenter.messagePlayingGoingToStop, this.playingMessageObject, Boolean.TRUE);
                } else {
                    long currentPosition = videoPlayer2.getCurrentPosition();
                    MessageObject messageObject3 = this.playingMessageObject;
                    if (messageObject3 != null && messageObject3.isVideo() && currentPosition > 0 && currentPosition != -9223372036854775807L) {
                        MessageObject messageObject4 = this.playingMessageObject;
                        messageObject4.audioProgressMs = (int) currentPosition;
                        NotificationCenter.getInstance(messageObject4.currentAccount).postNotificationName(NotificationCenter.messagePlayingGoingToStop, this.playingMessageObject, Boolean.FALSE);
                    }
                    this.videoPlayer.releasePlayer(true);
                    this.videoPlayer = null;
                }
                try {
                    this.baseActivity.getWindow().clearFlags(128);
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
                if (this.playingMessageObject != null && !z4) {
                    AndroidUtilities.cancelRunOnUIThread(this.setLoadingRunnable);
                    FileLoader.getInstance(this.playingMessageObject.currentAccount).removeLoadingVideo(this.playingMessageObject.getDocument(), true, false);
                }
            }
        }
        stopProgressTimer();
        this.lastProgress = 0L;
        this.isPaused = false;
        if (!this.useFrontSpeaker && !SharedConfig.raiseToSpeak) {
            ChatActivity chatActivity = this.raiseChat;
            stopRaiseToEarSensors(chatActivity, false);
            this.raiseChat = chatActivity;
        }
        PowerManager.WakeLock wakeLock = this.proximityWakeLock;
        if (wakeLock != null && wakeLock.isHeld() && !this.proximityTouched) {
            this.proximityWakeLock.release();
        }
        MessageObject messageObject5 = this.playingMessageObject;
        if (messageObject5 != null) {
            if (this.downloadingCurrentMessage) {
                FileLoader.getInstance(messageObject5.currentAccount).cancelLoadFile(this.playingMessageObject.getDocument());
            }
            MessageObject messageObject6 = this.playingMessageObject;
            if (z) {
                messageObject6.resetPlayingProgress();
                NotificationCenter.getInstance(messageObject6.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Long.valueOf(this.playingMessageObject.getId()), 0);
            }
            this.playingMessageObject = null;
            this.downloadingCurrentMessage = false;
            if (z) {
                NotificationsController.audioManager.abandonAudioFocus(this);
                this.hasAudioFocus = 0;
                int iIndexOf = -1;
                ArrayList<MessageObject> arrayList = this.voiceMessagesPlaylist;
                if (arrayList != null) {
                    if (z3 && (iIndexOf = arrayList.indexOf(messageObject6)) >= 0) {
                        this.voiceMessagesPlaylist.remove(iIndexOf);
                        this.voiceMessagesPlaylistMap.remove(messageObject6.getId());
                        if (this.voiceMessagesPlaylist.isEmpty()) {
                            this.voiceMessagesPlaylist = null;
                            this.voiceMessagesPlaylistMap = null;
                        }
                    } else {
                        this.voiceMessagesPlaylist = null;
                        this.voiceMessagesPlaylistMap = null;
                    }
                }
                ArrayList<MessageObject> arrayList2 = this.voiceMessagesPlaylist;
                if (arrayList2 != null && iIndexOf < arrayList2.size()) {
                    MessageObject messageObject7 = this.voiceMessagesPlaylist.get(iIndexOf);
                    playMessage(messageObject7);
                    if (!messageObject7.isRoundVideo() && (pipRoundVideoView = this.pipRoundVideoView) != null) {
                        pipRoundVideoView.close(true);
                        this.pipRoundVideoView = null;
                    }
                } else {
                    if ((messageObject6.isVoice() || messageObject6.isRoundVideo()) && messageObject6.getId() != 0) {
                        startRecordingIfFromSpeaker();
                    }
                    NotificationCenter.getInstance(messageObject6.currentAccount).postNotificationName(NotificationCenter.messagePlayingDidReset, Long.valueOf(messageObject6.getId()), Boolean.valueOf(z2));
                    this.pipSwitchingState = 0;
                    PipRoundVideoView pipRoundVideoView2 = this.pipRoundVideoView;
                    if (pipRoundVideoView2 != null) {
                        pipRoundVideoView2.close(true);
                        this.pipRoundVideoView = null;
                    }
                }
            }
            if (z2) {
                ApplicationLoader.applicationContext.stopService(new Intent(ApplicationLoader.applicationContext, (Class<?>) MusicPlayerService.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanupPlayer$10(VideoPlayer videoPlayer, ValueAnimator valueAnimator) {
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

    public boolean seekToProgress(MessageObject messageObject, float f) {
        if ((this.audioPlayer != null || this.videoPlayer != null) && messageObject != null && this.playingMessageObject != null && isSamePlayingMessage(messageObject)) {
            try {
                VideoPlayer videoPlayer = this.audioPlayer;
                if (videoPlayer != null) {
                    long duration = videoPlayer.getDuration();
                    if (duration == -9223372036854775807L) {
                        this.seekToProgressPending = f;
                    } else {
                        this.playingMessageObject.audioProgress = f;
                        long j = (int) (duration * f);
                        this.audioPlayer.seekTo(j);
                        this.lastProgress = j;
                    }
                } else {
                    VideoPlayer videoPlayer2 = this.videoPlayer;
                    if (videoPlayer2 != null) {
                        videoPlayer2.seekTo((long) (videoPlayer2.getDuration() * f));
                    }
                }
                NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingDidSeek, Long.valueOf(this.playingMessageObject.getId()), Float.valueOf(f));
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
    public void loadMoreMusic() {
        MessageObject messageObject;
        final int i;
        TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal;
        if (this.loadingPlaylist || (messageObject = this.playingMessageObject) == null || messageObject.scheduled || ((int) messageObject.getDialogId()) == 0 || (i = this.playlistClassGuid) == 0) {
            return;
        }
        PlaylistGlobalSearchParams playlistGlobalSearchParams = this.playlistGlobalSearchParams;
        if (playlistGlobalSearchParams != null) {
            if (playlistGlobalSearchParams.endReached || this.playlist.isEmpty()) {
                return;
            }
            final int i2 = this.playlist.get(0).currentAccount;
            if (this.playlistGlobalSearchParams.dialogId != 0) {
                TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
                PlaylistGlobalSearchParams playlistGlobalSearchParams2 = this.playlistGlobalSearchParams;
                tLRPC$TL_messages_search.q = playlistGlobalSearchParams2.query;
                tLRPC$TL_messages_search.limit = 20;
                FiltersView.MediaFilterData mediaFilterData = playlistGlobalSearchParams2.filter;
                tLRPC$TL_messages_search.filter = mediaFilterData == null ? new TLRPC$TL_inputMessagesFilterEmpty() : mediaFilterData.filter;
                tLRPC$TL_messages_search.peer = AccountInstance.getInstance(i2).getMessagesController().getInputPeer(this.playlistGlobalSearchParams.dialogId);
                ArrayList<MessageObject> arrayList = this.playlist;
                tLRPC$TL_messages_search.offset_id = arrayList.get(arrayList.size() - 1).getId();
                PlaylistGlobalSearchParams playlistGlobalSearchParams3 = this.playlistGlobalSearchParams;
                long j = playlistGlobalSearchParams3.minDate;
                if (j > 0) {
                    tLRPC$TL_messages_search.min_date = (int) (j / 1000);
                }
                long j2 = playlistGlobalSearchParams3.maxDate;
                tLRPC$TL_messages_searchGlobal = tLRPC$TL_messages_search;
                if (j2 > 0) {
                    tLRPC$TL_messages_search.min_date = (int) (j2 / 1000);
                    tLRPC$TL_messages_searchGlobal = tLRPC$TL_messages_search;
                }
            } else {
                TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal2 = new TLRPC$TL_messages_searchGlobal();
                tLRPC$TL_messages_searchGlobal2.limit = 20;
                PlaylistGlobalSearchParams playlistGlobalSearchParams4 = this.playlistGlobalSearchParams;
                tLRPC$TL_messages_searchGlobal2.q = playlistGlobalSearchParams4.query;
                tLRPC$TL_messages_searchGlobal2.filter = playlistGlobalSearchParams4.filter.filter;
                ArrayList<MessageObject> arrayList2 = this.playlist;
                MessageObject messageObject2 = arrayList2.get(arrayList2.size() - 1);
                tLRPC$TL_messages_searchGlobal2.offset_id = messageObject2.getId();
                PlaylistGlobalSearchParams playlistGlobalSearchParams5 = this.playlistGlobalSearchParams;
                tLRPC$TL_messages_searchGlobal2.offset_rate = playlistGlobalSearchParams5.nextSearchRate;
                tLRPC$TL_messages_searchGlobal2.flags |= 1;
                tLRPC$TL_messages_searchGlobal2.folder_id = playlistGlobalSearchParams5.folderId;
                TLRPC$Peer tLRPC$Peer = messageObject2.messageOwner.peer_id;
                int i3 = tLRPC$Peer.channel_id;
                tLRPC$TL_messages_searchGlobal2.offset_peer = MessagesController.getInstance(i2).getInputPeer((i3 == 0 && (i3 = tLRPC$Peer.chat_id) == 0) ? tLRPC$Peer.user_id : -i3);
                PlaylistGlobalSearchParams playlistGlobalSearchParams6 = this.playlistGlobalSearchParams;
                long j3 = playlistGlobalSearchParams6.minDate;
                if (j3 > 0) {
                    tLRPC$TL_messages_searchGlobal2.min_date = (int) (j3 / 1000);
                }
                long j4 = playlistGlobalSearchParams6.maxDate;
                tLRPC$TL_messages_searchGlobal = tLRPC$TL_messages_searchGlobal2;
                if (j4 > 0) {
                    tLRPC$TL_messages_searchGlobal2.min_date = (int) (j4 / 1000);
                    tLRPC$TL_messages_searchGlobal = tLRPC$TL_messages_searchGlobal2;
                }
            }
            this.loadingPlaylist = true;
            ConnectionsManager.getInstance(i2).sendRequest(tLRPC$TL_messages_searchGlobal, new RequestDelegate() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda43
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadMoreMusic$12(i, i2, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        boolean[] zArr = this.playlistEndReached;
        if (!zArr[0]) {
            this.loadingPlaylist = true;
            AccountInstance.getInstance(this.playingMessageObject.currentAccount).getMediaDataController().loadMedia(this.playingMessageObject.getDialogId(), 50, this.playlistMaxId[0], 4, 1, this.playlistClassGuid);
        } else {
            if (this.playlistMergeDialogId == 0 || zArr[1]) {
                return;
            }
            this.loadingPlaylist = true;
            AccountInstance.getInstance(this.playingMessageObject.currentAccount).getMediaDataController().loadMedia(this.playlistMergeDialogId, 50, this.playlistMaxId[0], 4, 1, this.playlistClassGuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMoreMusic$12(final int i, final int i2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMoreMusic$11(i, tLRPC$TL_error, tLObject, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMoreMusic$11(int i, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i2) {
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
            if (!this.playlistMap.containsKey(Long.valueOf(messageObject.getId()))) {
                this.playlist.add(0, messageObject);
                this.playlistMap.put(Long.valueOf(messageObject.getId()), messageObject);
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

    public boolean setPlaylist(ArrayList<MessageObject> arrayList, MessageObject messageObject, long j, PlaylistGlobalSearchParams playlistGlobalSearchParams) {
        return setPlaylist(arrayList, messageObject, j, true, playlistGlobalSearchParams);
    }

    public boolean setPlaylist(ArrayList<MessageObject> arrayList, MessageObject messageObject, long j) {
        return setPlaylist(arrayList, messageObject, j, true, null);
    }

    public boolean setPlaylist(ArrayList<MessageObject> arrayList, MessageObject messageObject, long j, boolean z, PlaylistGlobalSearchParams playlistGlobalSearchParams) {
        if (this.playingMessageObject == messageObject) {
            int iIndexOf = this.playlist.indexOf(messageObject);
            if (iIndexOf >= 0) {
                this.currentPlaylistNum = iIndexOf;
            }
            return playMessage(messageObject);
        }
        this.forceLoopCurrentPlaylist = !z;
        this.playlistMergeDialogId = j;
        this.playMusicAgain = !this.playlist.isEmpty();
        clearPlaylist();
        this.playlistGlobalSearchParams = playlistGlobalSearchParams;
        boolean z2 = false;
        if (!arrayList.isEmpty() && ((int) arrayList.get(0).getDialogId()) == 0) {
            z2 = true;
        }
        long jMax = Long.MIN_VALUE;
        long jMin = Long.MAX_VALUE;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            MessageObject messageObject2 = arrayList.get(size);
            if (messageObject2.isMusic()) {
                long idWithChannel = messageObject2.getIdWithChannel();
                if (idWithChannel > 0 || z2) {
                    jMin = Math.min(jMin, idWithChannel);
                    jMax = Math.max(jMax, idWithChannel);
                }
                this.playlist.add(messageObject2);
                this.playlistMap.put(Long.valueOf(messageObject2.getId()), messageObject2);
            }
        }
        sortPlaylist();
        int iIndexOf2 = this.playlist.indexOf(messageObject);
        this.currentPlaylistNum = iIndexOf2;
        if (iIndexOf2 == -1) {
            clearPlaylist();
            this.currentPlaylistNum = this.playlist.size();
            this.playlist.add(messageObject);
            this.playlistMap.put(Long.valueOf(messageObject.getId()), messageObject);
        }
        if (messageObject.isMusic() && !messageObject.scheduled) {
            if (SharedConfig.shuffleMusic) {
                buildShuffledPlayList();
            }
            if (z) {
                if (this.playlistGlobalSearchParams == null) {
                    MediaDataController.getInstance(messageObject.currentAccount).loadMusic(messageObject.getDialogId(), jMin, jMax);
                } else {
                    this.playlistClassGuid = ConnectionsManager.generateClassGuid();
                }
            }
        }
        return playMessage(messageObject);
    }

    private void sortPlaylist() {
        Collections.sort(this.playlist, new Comparator() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda42
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaController.lambda$sortPlaylist$13((MessageObject) obj, (MessageObject) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortPlaylist$13(MessageObject messageObject, MessageObject messageObject2) {
        long id = messageObject.getId();
        long id2 = messageObject2.getId();
        long j = messageObject.messageOwner.grouped_id;
        long j2 = messageObject2.messageOwner.grouped_id;
        return (id >= 0 || id2 >= 0) ? (j == 0 || j != j2) ? (id > id2 ? 1 : (id == id2 ? 0 : -1)) : (id2 > id ? 1 : (id2 == id ? 0 : -1)) : (j == 0 || j != j2) ? (id2 > id ? 1 : (id2 == id ? 0 : -1)) : (id > id2 ? 1 : (id == id2 ? 0 : -1));
    }

    public void playNextMessage() {
        playNextMessageWithoutOrder(false);
    }

    public boolean findMessageInPlaylistAndPlay(MessageObject messageObject) {
        int iIndexOf = this.playlist.indexOf(messageObject);
        if (iIndexOf == -1) {
            return playMessage(messageObject);
        }
        playMessageAtIndex(iIndexOf);
        return true;
    }

    public void playMessageAtIndex(int i) {
        int i2 = this.currentPlaylistNum;
        if (i2 < 0 || i2 >= this.playlist.size()) {
            return;
        }
        this.currentPlaylistNum = i;
        this.playMusicAgain = true;
        MessageObject messageObject = this.playlist.get(i);
        if (this.playingMessageObject != null && !isSamePlayingMessage(messageObject)) {
            this.playingMessageObject.resetPlayingProgress();
        }
        playMessage(messageObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playNextMessageWithoutOrder(boolean z) {
        boolean z2;
        int i;
        ArrayList<MessageObject> arrayList = SharedConfig.shuffleMusic ? this.shuffledPlaylist : this.playlist;
        if (z && (((i = SharedConfig.repeatMode) == 2 || (i == 1 && arrayList.size() == 1)) && !this.forceLoopCurrentPlaylist)) {
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
                z2 = true;
            }
            z2 = false;
        } else {
            int i3 = this.currentPlaylistNum - 1;
            this.currentPlaylistNum = i3;
            if (i3 < 0) {
                this.currentPlaylistNum = arrayList.size() - 1;
                z2 = true;
            }
            z2 = false;
        }
        if (z2 && z && SharedConfig.repeatMode == 0 && !this.forceLoopCurrentPlaylist) {
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
                VideoPlayer videoPlayer2 = this.videoPlayer;
                if (videoPlayer2 != null) {
                    this.currentAspectRatioFrameLayout = null;
                    this.currentTextureViewContainer = null;
                    this.currentAspectRatioFrameLayoutReady = false;
                    this.currentTextureView = null;
                    videoPlayer2.releasePlayer(true);
                    this.videoPlayer = null;
                    try {
                        this.baseActivity.getWindow().clearFlags(128);
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    AndroidUtilities.cancelRunOnUIThread(this.setLoadingRunnable);
                    FileLoader.getInstance(this.playingMessageObject.currentAccount).removeLoadingVideo(this.playingMessageObject.getDocument(), true, false);
                }
            }
            stopProgressTimer();
            this.lastProgress = 0L;
            this.isPaused = true;
            MessageObject messageObject2 = this.playingMessageObject;
            messageObject2.audioProgress = 0.0f;
            messageObject2.audioProgressSec = 0;
            NotificationCenter.getInstance(messageObject2.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Long.valueOf(this.playingMessageObject.getId()), 0);
            NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingPlayStateChanged, Long.valueOf(this.playingMessageObject.getId()));
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

    public void playPreviousMessage() {
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
        int i4 = this.currentPlaylistNum;
        if (i4 < 0 || i4 >= arrayList.size()) {
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

    private void checkIsNextVoiceFileDownloaded(int i) {
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
        if (pathToMessage != null) {
            pathToMessage.exists();
        }
        if (pathToMessage == null || pathToMessage == file || pathToMessage.exists()) {
            return;
        }
        FileLoader.getInstance(i).loadFile(messageObject.getDocument(), messageObject, 0, 0);
    }

    private void checkIsNextMusicFileDownloaded(int i) {
        int size;
        if (DownloadController.getInstance(i).canDownloadNextTrack()) {
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
            if (pathToMessage != null) {
                pathToMessage.exists();
            }
            if (pathToMessage == null || pathToMessage == file || pathToMessage.exists() || !messageObject.isMusic()) {
                return;
            }
            FileLoader.getInstance(i).loadFile(messageObject.getDocument(), messageObject, 0, 0);
        }
    }

    public void setVoiceMessagesPlaylist(ArrayList<MessageObject> arrayList, boolean z) {
        this.voiceMessagesPlaylist = arrayList;
        if (arrayList != null) {
            this.voiceMessagesPlaylistUnread = z;
            this.voiceMessagesPlaylistMap = new LongSparseArray<>();
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

    public void setCurrentVideoVisible(boolean z) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.currentAspectRatioFrameLayout;
        if (aspectRatioFrameLayout == null) {
            return;
        }
        if (z) {
            PipRoundVideoView pipRoundVideoView = this.pipRoundVideoView;
            if (pipRoundVideoView != null) {
                this.pipSwitchingState = 2;
                pipRoundVideoView.close(true);
                this.pipRoundVideoView = null;
                return;
            } else {
                if (aspectRatioFrameLayout != null) {
                    if (aspectRatioFrameLayout.getParent() == null) {
                        this.currentTextureViewContainer.addView(this.currentAspectRatioFrameLayout);
                    }
                    this.videoPlayer.setTextureView(this.currentTextureView);
                    return;
                }
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
                pipRoundVideoView2.show(this.baseActivity, new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setCurrentVideoVisible$14();
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
    public /* synthetic */ void lambda$setCurrentVideoVisible$14() {
        cleanupPlayer(true, true);
    }

    public void setTextureView(TextureView textureView, AspectRatioFrameLayout aspectRatioFrameLayout, FrameLayout frameLayout, boolean z) {
        if (textureView == null) {
            return;
        }
        if (!z && this.currentTextureView == textureView) {
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
        this.currentTextureViewContainer = frameLayout;
        if (!this.currentAspectRatioFrameLayoutReady || aspectRatioFrameLayout == null || aspectRatioFrameLayout == null) {
            return;
        }
        aspectRatioFrameLayout.setAspectRatio(this.currentAspectRatioFrameLayoutRatio, this.currentAspectRatioFrameLayoutRotation);
    }

    public void setBaseActivity(Activity activity, boolean z) {
        if (z) {
            this.baseActivity = activity;
        } else if (this.baseActivity == activity) {
            this.baseActivity = null;
        }
    }

    public void setFeedbackView(View view, boolean z) {
        if (z) {
            this.feedbackView = view;
        } else if (this.feedbackView == view) {
            this.feedbackView = null;
        }
    }

    public void setPlaybackSpeed(boolean z, float f) {
        if (z) {
            if (this.currentMusicPlaybackSpeed >= 6.0f && f == VOLUME_NORMAL && this.playingMessageObject != null) {
                this.audioPlayer.pause();
                final MessageObject messageObject = this.playingMessageObject;
                final float f2 = messageObject.audioProgress;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda29
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setPlaybackSpeed$15(messageObject, f2);
                    }
                }, 50L);
            }
            this.currentMusicPlaybackSpeed = f;
        } else {
            this.currentPlaybackSpeed = f;
        }
        VideoPlayer videoPlayer = this.audioPlayer;
        if (videoPlayer != null) {
            videoPlayer.setPlaybackSpeed(f);
        } else {
            VideoPlayer videoPlayer2 = this.videoPlayer;
            if (videoPlayer2 != null) {
                videoPlayer2.setPlaybackSpeed(f);
            }
        }
        MessagesController.getGlobalMainSettings().edit().putFloat(z ? "musicPlaybackSpeed" : "playbackSpeed", f).apply();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.messagePlayingSpeedChanged, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPlaybackSpeed$15(MessageObject messageObject, float f) {
        if (this.audioPlayer == null || this.playingMessageObject == null || this.isPaused) {
            return;
        }
        if (isSamePlayingMessage(messageObject)) {
            seekToProgress(this.playingMessageObject, f);
        }
        this.audioPlayer.play();
    }

    public float getPlaybackSpeed(boolean z) {
        return z ? this.currentMusicPlaybackSpeed : this.currentPlaybackSpeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoState(MessageObject messageObject, int[] iArr, boolean z, boolean z2, int i) {
        MessageObject messageObject2;
        if (this.videoPlayer == null) {
            return;
        }
        if (i != 4 && i != 1) {
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
        if (i == 3) {
            this.playerWasReady = true;
            MessageObject messageObject3 = this.playingMessageObject;
            if (messageObject3 != null && (messageObject3.isVideo() || this.playingMessageObject.isRoundVideo())) {
                AndroidUtilities.cancelRunOnUIThread(this.setLoadingRunnable);
                FileLoader.getInstance(messageObject.currentAccount).removeLoadingVideo(this.playingMessageObject.getDocument(), true, false);
            }
            this.currentAspectRatioFrameLayoutReady = true;
            return;
        }
        if (i == 2) {
            if (!z2 || (messageObject2 = this.playingMessageObject) == null) {
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
        if (this.videoPlayer.isPlaying() && i == 4) {
            if (this.playingMessageObject.isVideo() && !z && (iArr == null || iArr[0] < 4)) {
                this.videoPlayer.seekTo(0L);
                if (iArr != null) {
                    iArr[0] = iArr[0] + 1;
                    return;
                }
                return;
            }
            cleanupPlayer(true, true, true, false);
        }
    }

    public void injectVideoPlayer(VideoPlayer videoPlayer, MessageObject messageObject) {
        if (videoPlayer == null || messageObject == null) {
            return;
        }
        FileLoader.getInstance(messageObject.currentAccount).setLoadingVideoForPlayer(messageObject.getDocument(), true);
        this.playerWasReady = false;
        clearPlaylist();
        this.videoPlayer = videoPlayer;
        this.playingMessageObject = messageObject;
        int i = this.playerNum + 1;
        this.playerNum = i;
        videoPlayer.setDelegate(new AnonymousClass7(i, messageObject, null, true));
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

    /* renamed from: org.rbmain.messenger.MediaController$7, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass7 implements VideoPlayer.VideoPlayerDelegate {
        final /* synthetic */ boolean val$destroyAtEnd;
        final /* synthetic */ MessageObject val$messageObject;
        final /* synthetic */ int[] val$playCount;
        final /* synthetic */ int val$tag;

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        AnonymousClass7(int i, MessageObject messageObject, int[] iArr, boolean z) {
            this.val$tag = i;
            this.val$messageObject = messageObject;
            this.val$playCount = iArr;
            this.val$destroyAtEnd = z;
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean z, int i) {
            if (this.val$tag != MediaController.this.playerNum) {
                return;
            }
            MediaController.this.updateVideoState(this.val$messageObject, this.val$playCount, this.val$destroyAtEnd, z, i);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer videoPlayer, Exception exc) {
            FileLog.e(exc);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            MediaController.this.currentAspectRatioFrameLayoutRotation = i3;
            if (i3 != 90 && i3 != 270) {
                i2 = i;
                i = i2;
            }
            MediaController.this.currentAspectRatioFrameLayoutRatio = i == 0 ? MediaController.VOLUME_NORMAL : (i2 * f) / i;
            if (MediaController.this.currentAspectRatioFrameLayout != null) {
                MediaController.this.currentAspectRatioFrameLayout.setAspectRatio(MediaController.this.currentAspectRatioFrameLayoutRatio, MediaController.this.currentAspectRatioFrameLayoutRotation);
            }
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
            if (MediaController.this.currentAspectRatioFrameLayout == null || MediaController.this.currentAspectRatioFrameLayout.isDrawingReady()) {
                return;
            }
            MediaController.this.isDrawingWasReady = true;
            MediaController.this.currentAspectRatioFrameLayout.setDrawingReady(true);
            MediaController.this.currentTextureViewContainer.setTag(1);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
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
                            MediaController.this.pipRoundVideoView.show(MediaController.this.baseActivity, new Runnable() { // from class: org.rbmain.messenger.MediaController$7$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onSurfaceDestroyed$0();
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
        public /* synthetic */ void lambda$onSurfaceDestroyed$0() {
            MediaController.this.cleanupPlayer(true, true);
        }
    }

    public void playEmojiSound(final AccountInstance accountInstance, String str, final MessagesController.EmojiSound emojiSound, final boolean z) {
        if (emojiSound == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playEmojiSound$18(emojiSound, accountInstance, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playEmojiSound$18(MessagesController.EmojiSound emojiSound, final AccountInstance accountInstance, boolean z) {
        final TLRPC$TL_document tLRPC$TL_document = new TLRPC$TL_document();
        tLRPC$TL_document.access_hash = emojiSound.accessHash;
        tLRPC$TL_document.id = emojiSound.id;
        tLRPC$TL_document.mime_type = "sound/ogg";
        tLRPC$TL_document.file_reference = emojiSound.fileReference;
        tLRPC$TL_document.dc_id = accountInstance.getConnectionsManager().getCurrentDatacenterId();
        final File pathToAttach = FileLoader.getPathToAttach(tLRPC$TL_document, true);
        if (!pathToAttach.exists()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    MediaController.lambda$playEmojiSound$17(accountInstance, tLRPC$TL_document);
                }
            });
        } else {
            if (z) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$playEmojiSound$16(pathToAttach);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playEmojiSound$16(File file) {
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

    /* renamed from: org.rbmain.messenger.MediaController$8, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass8 implements VideoPlayer.VideoPlayerDelegate {
        final /* synthetic */ int val$tag;

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer videoPlayer, Exception exc) {
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        }

        AnonymousClass8(int i) {
            this.val$tag = i;
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean z, final int i) {
            final int i2 = this.val$tag;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$8$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStateChanged$0(i2, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onStateChanged$0(int i, int i2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$playEmojiSound$17(AccountInstance accountInstance, TLRPC$Document tLRPC$Document) {
        accountInstance.getFileLoader().loadFile(tLRPC$Document, null, 1, 1);
    }

    public void checkVolumeBarUI() {
        if (this.isSilent) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - volumeBarLastTimeShown) < 5000) {
                return;
            }
            AudioManager audioManager = (AudioManager) ApplicationLoader.applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            int i = this.useFrontSpeaker ? 0 : 3;
            int streamVolume = audioManager.getStreamVolume(i);
            if (streamVolume == 0) {
                audioManager.adjustStreamVolume(i, streamVolume, 1);
                volumeBarLastTimeShown = jCurrentTimeMillis;
            }
        } catch (Exception unused) {
        }
    }

    public boolean playMessage(MessageObject messageObject) {
        return playMessage(messageObject, false);
    }

    public boolean playMessage(final MessageObject messageObject, boolean z) {
        File file;
        boolean zExists;
        final File pathToMessage;
        PowerManager.WakeLock wakeLock;
        if (messageObject == null) {
            return false;
        }
        this.isSilent = z;
        checkVolumeBarUI();
        if ((this.audioPlayer != null || this.videoPlayer != null) && isSamePlayingMessage(messageObject)) {
            if (this.isPaused) {
                resumeAudio(messageObject);
            }
            if (!SharedConfig.enabledRaiseTo(true)) {
                startRaiseToEarSensors(this.raiseChat);
            }
            return true;
        }
        if (!messageObject.isOut() && messageObject.isContentUnread()) {
            MessagesController.getInstance(messageObject.currentAccount).markMessageContentAsRead(messageObject);
        }
        boolean z2 = this.playMusicAgain;
        boolean z3 = !z2;
        MessageObject messageObject2 = this.playingMessageObject;
        if (messageObject2 != null) {
            if (!z2) {
                messageObject2.resetPlayingProgress();
                NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Long.valueOf(this.playingMessageObject.getId()), 0);
            }
            z3 = false;
        }
        cleanupPlayer(z3, false);
        this.shouldSavePositionForCurrentAudio = null;
        this.lastSaveTime = 0L;
        this.playMusicAgain = false;
        this.seekToProgressPending = 0.0f;
        String str = messageObject.messageOwner.attachPath;
        if (str == null || str.length() <= 0) {
            file = null;
            zExists = false;
        } else {
            File file2 = new File(messageObject.messageOwner.attachPath);
            zExists = file2.exists();
            file = !zExists ? null : file2;
        }
        if (file != null) {
            pathToMessage = file;
        } else {
            FileLoader.getInstance(messageObject.currentAccount);
            pathToMessage = FileLoader.getPathToMessage(messageObject.messageOwner);
        }
        boolean z4 = SharedConfig.streamMedia && (messageObject.isMusic() || messageObject.isRoundVideo() || (messageObject.isVideo() && messageObject.canStreamVideo())) && !DialogObject.isEncryptedDialog(messageObject.getDialogId());
        if (pathToMessage != file && !(zExists = pathToMessage.exists()) && !z4) {
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
            NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingPlayStateChanged, Long.valueOf(this.playingMessageObject.getId()));
            return true;
        }
        boolean z5 = zExists;
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
            final File file3 = pathToMessage;
            File file4 = file;
            FileLoader.getInstance(messageObject.currentAccount).setLoadingVideoForPlayer(messageObject.getDocument(), true);
            this.playerWasReady = false;
            boolean z6 = !zIsVideo || (messageObject.messageOwner.peer_id.channel_id == 0 && messageObject.audioProgress <= 0.1f);
            int[] iArr = (!zIsVideo || messageObject.getDuration() > 30) ? null : new int[]{1};
            clearPlaylist();
            VideoPlayer videoPlayer = new VideoPlayer();
            this.videoPlayer = videoPlayer;
            videoPlayer.setLooping(z);
            int i = this.playerNum + 1;
            this.playerNum = i;
            this.videoPlayer.setDelegate(new AnonymousClass9(i, messageObject, iArr, z6));
            this.currentAspectRatioFrameLayoutReady = false;
            if (this.pipRoundVideoView != null || !MessagesController.getInstance(messageObject.currentAccount).isDialogVisible(messageObject.getDialogId(), messageObject.scheduled)) {
                if (this.pipRoundVideoView == null) {
                    try {
                        PipRoundVideoView pipRoundVideoView = new PipRoundVideoView();
                        this.pipRoundVideoView = pipRoundVideoView;
                        pipRoundVideoView.show(this.baseActivity, new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda14
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$playMessage$19();
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
            if (z5) {
                if (!messageObject.mediaExists && file3 != file4) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda36
                        @Override // java.lang.Runnable
                        public final void run() {
                            MediaController.lambda$playMessage$20(messageObject, file3);
                        }
                    });
                }
                this.videoPlayer.preparePlayer(Uri.fromFile(file3), "other");
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
                    sb.append(URLEncoder.encode(document.mime_type, Utf8Charset.NAME));
                    sb.append("&rid=");
                    sb.append(fileReference);
                    sb.append("&name=");
                    sb.append(URLEncoder.encode(FileLoader.getDocumentFileName(document), Utf8Charset.NAME));
                    sb.append("&reference=");
                    byte[] bArr = document.file_reference;
                    if (bArr == null) {
                        bArr = new byte[0];
                    }
                    sb.append(Utilities.bytesToHex(bArr));
                    this.videoPlayer.preparePlayer(Uri.parse("tg://" + messageObject.getFileName() + sb.toString()), "other");
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            if (messageObject.isRoundVideo()) {
                this.videoPlayer.setStreamType(this.useFrontSpeaker ? 0 : 3);
                if (Math.abs(this.currentPlaybackSpeed - VOLUME_NORMAL) > 0.001f) {
                    this.videoPlayer.setPlaybackSpeed(Math.round(this.currentPlaybackSpeed * 10.0f) / 10.0f);
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
                final int i2 = this.playerNum + 1;
                this.playerNum = i2;
                videoPlayer2.setDelegate(new VideoPlayer.VideoPlayerDelegate() { // from class: org.rbmain.messenger.MediaController.10
                    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onError(VideoPlayer videoPlayer3, Exception exc) {
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onRenderedFirstFrame() {
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public /* bridge */ /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
                        VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public /* bridge */ /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
                        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public /* bridge */ /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
                        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
                        return false;
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onVideoSizeChanged(int i3, int i4, int i5, float f2) {
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onStateChanged(boolean z7, int i3) {
                        if (i2 != MediaController.this.playerNum) {
                            return;
                        }
                        if (i3 != 4 && ((i3 != 1 && i3 != 2) || !z7 || messageObject.audioProgress < 0.999f)) {
                            if (MediaController.this.audioPlayer == null || MediaController.this.seekToProgressPending == 0.0f) {
                                return;
                            }
                            if (i3 == 3 || i3 == 1) {
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
                        NotificationCenter.getInstance(messageObject3.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Long.valueOf(messageObject.getId()), 0);
                        if (!MediaController.this.playlist.isEmpty() && (MediaController.this.playlist.size() > 1 || !messageObject.isVoice())) {
                            MediaController.this.playNextMessageWithoutOrder(true);
                        } else {
                            MediaController.this.cleanupPlayer(true, true, messageObject.isVoice(), false);
                        }
                    }
                });
                this.audioPlayer.setAudioVisualizerDelegate(new VideoPlayer.AudioVisualizerDelegate() { // from class: org.rbmain.messenger.MediaController.11
                    @Override // org.rbmain.ui.Components.VideoPlayer.AudioVisualizerDelegate
                    public void onVisualizerUpdate(boolean z7, boolean z8, float[] fArr) {
                        Theme.getCurrentAudiVisualizerDrawable().setWaveform(z7, z8, fArr);
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer.AudioVisualizerDelegate
                    public boolean needUpdate() {
                        return Theme.getCurrentAudiVisualizerDrawable().getParentView() != null;
                    }
                });
                if (z5) {
                    if (!messageObject.mediaExists && pathToMessage != file) {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda35
                            @Override // java.lang.Runnable
                            public final void run() {
                                MediaController.lambda$playMessage$21(messageObject, pathToMessage);
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
                    sb2.append(URLEncoder.encode(document2.mime_type, Utf8Charset.NAME));
                    sb2.append("&rid=");
                    sb2.append(fileReference2);
                    sb2.append("&name=");
                    sb2.append(URLEncoder.encode(FileLoader.getDocumentFileName(document2), Utf8Charset.NAME));
                    sb2.append("&reference=");
                    byte[] bArr2 = document2.file_reference;
                    if (bArr2 == null) {
                        bArr2 = new byte[0];
                    }
                    sb2.append(Utilities.bytesToHex(bArr2));
                    this.audioPlayer.preparePlayer(Uri.parse("tg://" + messageObject.getFileName() + sb2.toString()), "other");
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
                        this.audioPlayer.setPlaybackSpeed(Math.round(this.currentPlaybackSpeed * 10.0f) / 10.0f);
                    }
                    this.audioInfo = null;
                    clearPlaylist();
                } else {
                    try {
                        this.audioInfo = AudioInfo.getAudioInfo(pathToMessage);
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    String fileName2 = messageObject.getFileName();
                    if (!TextUtils.isEmpty(fileName2) && messageObject.getDuration() >= 600) {
                        float f3 = ApplicationLoader.applicationContext.getSharedPreferences("media_saved_pos", 0).getFloat(fileName2, -1.0f);
                        if (f3 > 0.0f && f3 < 0.999f) {
                            this.seekToProgressPending = f3;
                            messageObject.audioProgress = f3;
                        }
                        this.shouldSavePositionForCurrentAudio = fileName2;
                        if (Math.abs(this.currentMusicPlaybackSpeed - VOLUME_NORMAL) > 0.001f) {
                            this.audioPlayer.setPlaybackSpeed(Math.round(this.currentMusicPlaybackSpeed * 10.0f) / 10.0f);
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
            } catch (Exception e3) {
                FileLog.e(e3);
                NotificationCenter notificationCenter = NotificationCenter.getInstance(messageObject.currentAccount);
                int i3 = NotificationCenter.messagePlayingPlayStateChanged;
                Object[] objArr = new Object[1];
                MessageObject messageObject3 = this.playingMessageObject;
                objArr[0] = Long.valueOf(messageObject3 != null ? messageObject3.getId() : 0L);
                notificationCenter.postNotificationName(i3, objArr);
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
        if (!SharedConfig.enabledRaiseTo(true)) {
            startRaiseToEarSensors(this.raiseChat);
        }
        if (!ApplicationLoader.mainInterfacePaused && (wakeLock = this.proximityWakeLock) != null && !wakeLock.isHeld() && ((this.playingMessageObject.isVoice() || this.playingMessageObject.isRoundVideo()) && SharedConfig.enabledRaiseTo(false) && ignoreAccelerometerGestures())) {
            this.proximityWakeLock.acquire();
        }
        startProgressTimer(this.playingMessageObject);
        NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingDidStart, messageObject, messageObject2);
        VideoPlayer videoPlayer4 = this.videoPlayer;
        if (videoPlayer4 != null) {
            try {
                if (this.playingMessageObject.audioProgress != 0.0f) {
                    long duration = videoPlayer4.getDuration();
                    if (duration == -9223372036854775807L) {
                        duration = this.playingMessageObject.getDuration() * 1000;
                    }
                    MessageObject messageObject4 = this.playingMessageObject;
                    int i4 = (int) (duration * messageObject4.audioProgress);
                    int i5 = messageObject4.audioProgressMs;
                    if (i5 != 0) {
                        messageObject4.audioProgressMs = 0;
                        i4 = i5;
                    }
                    this.videoPlayer.seekTo(i4);
                }
            } catch (Exception e4) {
                MessageObject messageObject5 = this.playingMessageObject;
                messageObject5.audioProgress = 0.0f;
                messageObject5.audioProgressSec = 0;
                NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Long.valueOf(this.playingMessageObject.getId()), 0);
                FileLog.e(e4);
            }
            this.videoPlayer.play();
        } else {
            VideoPlayer videoPlayer5 = this.audioPlayer;
            if (videoPlayer5 != null) {
                try {
                    if (this.playingMessageObject.audioProgress != 0.0f) {
                        long duration2 = videoPlayer5.getDuration();
                        if (duration2 == -9223372036854775807L) {
                            duration2 = this.playingMessageObject.getDuration() * 1000;
                        }
                        this.audioPlayer.seekTo((int) (duration2 * this.playingMessageObject.audioProgress));
                    }
                } catch (Exception e5) {
                    this.playingMessageObject.resetPlayingProgress();
                    NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingProgressDidChanged, Long.valueOf(this.playingMessageObject.getId()), 0);
                    FileLog.e(e5);
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

    /* renamed from: org.rbmain.messenger.MediaController$9, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass9 implements VideoPlayer.VideoPlayerDelegate {
        final /* synthetic */ boolean val$destroyAtEnd;
        final /* synthetic */ MessageObject val$messageObject;
        final /* synthetic */ int[] val$playCount;
        final /* synthetic */ int val$tag;

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* bridge */ /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        AnonymousClass9(int i, MessageObject messageObject, int[] iArr, boolean z) {
            this.val$tag = i;
            this.val$messageObject = messageObject;
            this.val$playCount = iArr;
            this.val$destroyAtEnd = z;
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean z, int i) {
            if (this.val$tag != MediaController.this.playerNum) {
                return;
            }
            MediaController.this.updateVideoState(this.val$messageObject, this.val$playCount, this.val$destroyAtEnd, z, i);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer videoPlayer, Exception exc) {
            FileLog.e(exc);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            MediaController.this.currentAspectRatioFrameLayoutRotation = i3;
            if (i3 != 90 && i3 != 270) {
                i2 = i;
                i = i2;
            }
            MediaController.this.currentAspectRatioFrameLayoutRatio = i == 0 ? MediaController.VOLUME_NORMAL : (i2 * f) / i;
            if (MediaController.this.currentAspectRatioFrameLayout != null) {
                MediaController.this.currentAspectRatioFrameLayout.setAspectRatio(MediaController.this.currentAspectRatioFrameLayoutRatio, MediaController.this.currentAspectRatioFrameLayoutRotation);
            }
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
            if (MediaController.this.currentAspectRatioFrameLayout == null || MediaController.this.currentAspectRatioFrameLayout.isDrawingReady()) {
                return;
            }
            MediaController.this.isDrawingWasReady = true;
            MediaController.this.currentAspectRatioFrameLayout.setDrawingReady(true);
            MediaController.this.currentTextureViewContainer.setTag(1);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
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
                            MediaController.this.pipRoundVideoView.show(MediaController.this.baseActivity, new Runnable() { // from class: org.rbmain.messenger.MediaController$9$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onSurfaceDestroyed$0();
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
        public /* synthetic */ void lambda$onSurfaceDestroyed$0() {
            MediaController.this.cleanupPlayer(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playMessage$19() {
        cleanupPlayer(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$playMessage$20(MessageObject messageObject, File file) {
        NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.fileDidLoad, FileLoader.getAttachFileName(messageObject.getDocument()), file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$playMessage$21(MessageObject messageObject, File file) {
        NotificationCenter.getInstance(messageObject.currentAccount).postNotificationName(NotificationCenter.fileDidLoad, FileLoader.getAttachFileName(messageObject.getDocument()), file);
    }

    public static boolean ignoreAccelerometerGestures() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung");
    }

    public void updateSilent(boolean z) {
        this.isSilent = z;
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setLooping(z);
        }
        setPlayerVolume();
        checkVolumeBarUI();
        MessageObject messageObject = this.playingMessageObject;
        if (messageObject != null) {
            NotificationCenter notificationCenter = NotificationCenter.getInstance(messageObject.currentAccount);
            int i = NotificationCenter.messagePlayingPlayStateChanged;
            Object[] objArr = new Object[1];
            MessageObject messageObject2 = this.playingMessageObject;
            objArr[0] = Long.valueOf(messageObject2 != null ? messageObject2.getId() : 0L);
            notificationCenter.postNotificationName(i, objArr);
        }
    }

    public AudioInfo getAudioInfo() {
        return this.audioInfo;
    }

    public void setPlaybackOrderType(int i) {
        boolean z = SharedConfig.shuffleMusic;
        SharedConfig.setPlaybackOrderType(i);
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

    public boolean isCurrentPlayer(VideoPlayer videoPlayer) {
        return this.videoPlayer == videoPlayer || this.audioPlayer == videoPlayer;
    }

    /* renamed from: pauseMessage, reason: merged with bridge method [inline-methods] */
    public boolean lambda$startAudioAgain$7(MessageObject messageObject) {
        if ((this.audioPlayer != null || this.videoPlayer != null) && messageObject != null && this.playingMessageObject != null && isSamePlayingMessage(messageObject)) {
            stopProgressTimer();
            try {
                if (this.audioPlayer != null) {
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
                        this.audioVolumeAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.messenger.MediaController.12
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
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
                NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingPlayStateChanged, Long.valueOf(this.playingMessageObject.getId()));
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
                NotificationCenter.getInstance(this.playingMessageObject.currentAccount).postNotificationName(NotificationCenter.messagePlayingPlayStateChanged, Long.valueOf(this.playingMessageObject.getId()));
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

    public void setReplyingMessage(MessageObject messageObject, MessageObject messageObject2) {
        this.recordReplyingMsg = messageObject;
        this.recordReplyingTopMsg = messageObject2;
    }

    public void requestAudioFocus(boolean z) {
        if (z) {
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

    public void startRecording(final int i, final long j, final MessageObject messageObject, final MessageObject messageObject2, final int i2) {
        MessageObject messageObject3 = this.playingMessageObject;
        boolean z = (messageObject3 == null || !isPlayingMessage(messageObject3) || isMessagePaused()) ? false : true;
        requestAudioFocus(true);
        try {
            this.feedbackView.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        DispatchQueue dispatchQueue = this.recordQueue;
        Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f$0.lambda$startRecording$26(i, i2, j, messageObject, messageObject2);
            }
        };
        this.recordStartRunnable = runnable;
        dispatchQueue.postRunnable(runnable, z ? 500L : 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecording$26(final int i, final int i2, long j, MessageObject messageObject, MessageObject messageObject2) throws IllegalStateException {
        if (this.audioRecorder != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startRecording$22(i, i2);
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda17
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$startRecording$23(i, i2);
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startRecording$25(i, i2);
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startRecording$24(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecording$22(int i, int i2) {
        this.recordStartRunnable = null;
        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.recordStartError, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecording$23(int i, int i2) {
        this.recordStartRunnable = null;
        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.recordStartError, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecording$24(int i, int i2) {
        this.recordStartRunnable = null;
        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.recordStartError, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecording$25(int i, int i2) {
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
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateWaveform$28(absolutePath, str, messageObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateWaveform$28(String str, final String str2, final MessageObject messageObject) {
        final byte[] waveform = getWaveform(str);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateWaveform$27(str2, waveform, messageObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateWaveform$27(String str, byte[] bArr, MessageObject messageObject) {
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
        MessagesStorage.getInstance(messageObjectRemove.currentAccount).putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages, messageObjectRemove.getDialogId(), -1, 0L, false, messageObject.scheduled);
        ArrayList arrayList = new ArrayList();
        arrayList.add(messageObjectRemove);
        NotificationCenter.getInstance(messageObjectRemove.currentAccount).postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(messageObjectRemove.getDialogId()), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecordingInternal(final int i, final boolean z, final int i2) {
        if (i != 0) {
            final TLRPC$TL_document tLRPC$TL_document = this.recordingAudio;
            final File file = this.recordingAudioFile;
            this.fileEncodingQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$stopRecordingInternal$30(tLRPC$TL_document, file, i, z, i2);
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
    public /* synthetic */ void lambda$stopRecordingInternal$30(final TLRPC$TL_document tLRPC$TL_document, final File file, final int i, final boolean z, final int i2) {
        stopRecord();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopRecordingInternal$29(tLRPC$TL_document, file, i, z, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopRecordingInternal$29(TLRPC$TL_document tLRPC$TL_document, File file, int i, boolean z, int i2) {
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
                SendMessagesHelper.getInstance(this.recordingCurrentAccount).sendMessage(tLRPC$TL_document, null, file.getAbsolutePath(), this.recordDialogId, this.recordReplyingMsg, this.recordReplyingTopMsg, null, null, null, null, z, i2, 0, null);
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

    public void stopRecording(final int i, final boolean z, final int i2) {
        Runnable runnable = this.recordStartRunnable;
        if (runnable != null) {
            this.recordQueue.cancelRunnable(runnable);
            this.recordStartRunnable = null;
        }
        this.recordQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f$0.lambda$stopRecording$32(i, z, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopRecording$32(final int i, boolean z, int i2) throws IllegalStateException {
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopRecording$31(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopRecording$31(int i) {
        NotificationCenter notificationCenter = NotificationCenter.getInstance(this.recordingCurrentAccount);
        int i2 = NotificationCenter.recordStopped;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.recordingGuid);
        objArr[1] = Integer.valueOf(i == 2 ? 1 : 0);
        notificationCenter.postNotificationName(i2, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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

        public MediaLoader(Context context, AccountInstance accountInstance, ArrayList<MessageObject> arrayList, MessagesStorage.IntCallback intCallback) {
            this.currentAccount = accountInstance;
            this.messageObjects = arrayList;
            this.onFinishRunnable = intCallback;
            this.isMusic = arrayList.get(0).isMusic();
            this.currentAccount.getNotificationCenter().addObserver(this, NotificationCenter.fileDidLoad);
            this.currentAccount.getNotificationCenter().addObserver(this, NotificationCenter.FileLoadProgressChanged);
            this.currentAccount.getNotificationCenter().addObserver(this, NotificationCenter.fileDidFailToLoad);
            AlertDialog alertDialog = new AlertDialog(context, 2);
            this.progressDialog = alertDialog;
            alertDialog.setMessage(LocaleController.getString("Loading", ir.medu.shad.R.string.Loading));
            this.progressDialog.setCanceledOnTouchOutside(false);
            this.progressDialog.setCancelable(true);
            this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.messenger.MediaController$MediaLoader$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$new$0(dialogInterface);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(DialogInterface dialogInterface) {
            this.cancelled = true;
        }

        public void start() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$MediaLoader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$start$1();
                }
            }, 250L);
            new Thread(new Runnable() { // from class: org.rbmain.messenger.MediaController$MediaLoader$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$start$2();
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$start$1() {
            if (this.finished) {
                return;
            }
            this.progressDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$start$2() throws Throwable {
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$MediaLoader$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkIfFinished$4();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$checkIfFinished$4() {
            try {
                if (this.progressDialog.isShowing()) {
                    this.progressDialog.dismiss();
                } else {
                    this.finished = true;
                }
                if (this.onFinishRunnable != null) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$MediaLoader$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$checkIfFinished$3();
                        }
                    });
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.currentAccount.getNotificationCenter().removeObserver(this, NotificationCenter.fileDidLoad);
            this.currentAccount.getNotificationCenter().removeObserver(this, NotificationCenter.FileLoadProgressChanged);
            this.currentAccount.getNotificationCenter().removeObserver(this, NotificationCenter.fileDidFailToLoad);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$checkIfFinished$3() {
            this.onFinishRunnable.run(this.copiedFiles);
        }

        private void addMessageToLoad(final MessageObject messageObject) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$MediaLoader$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addMessageToLoad$5(messageObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addMessageToLoad$5(MessageObject messageObject) {
            TLRPC$Document document = messageObject.getDocument();
            if (document == null) {
                return;
            }
            this.loadingMessageObjects.put(FileLoader.getAttachFileName(document), messageObject);
            this.currentAccount.getFileLoader().loadFile(document, messageObject, 1, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:113:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean copyFile(java.io.File r32, java.io.File r33, java.lang.String r34) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 399
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaController.MediaLoader.copyFile(java.io.File, java.io.File, java.lang.String):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$copyFile$6() {
            try {
                this.progressDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$copyFile$7(int i) {
            try {
                this.progressDialog.setProgress(i);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$copyFile$8(int i) {
            try {
                this.progressDialog.setProgress(i);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int i, int i2, Object... objArr) {
            if (i == NotificationCenter.fileDidLoad || i == NotificationCenter.fileDidFailToLoad) {
                if (this.loadingMessageObjects.remove((String) objArr[0]) != null) {
                    this.waitingForFile.countDown();
                    return;
                }
                return;
            }
            if (i == NotificationCenter.FileLoadProgressChanged) {
                if (this.loadingMessageObjects.containsKey((String) objArr[0])) {
                    final int iLongValue = (int) (this.finishedProgress + (((((Long) objArr[1]).longValue() / ((Long) objArr[2]).longValue()) / this.messageObjects.size()) * 100.0f));
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$MediaLoader$$ExternalSyntheticLambda8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$didReceivedNotification$9(iLongValue);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didReceivedNotification$9(int i) {
            try {
                this.progressDialog.setProgress(i);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static void saveFilesFromMessages(Context context, AccountInstance accountInstance, ArrayList<MessageObject> arrayList, MessagesStorage.IntCallback intCallback) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        new MediaLoader(context, accountInstance, arrayList, intCallback).start();
    }

    public static void saveFile(String str, Context context, int i, String str2, String str3) {
        saveFile(str, context, i, str2, str3, null);
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
            boolean r0 = org.rbmain.messenger.AndroidUtilities.isInternalUri(r0)
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
            org.rbmain.ui.ActionBar.AlertDialog r4 = new org.rbmain.ui.ActionBar.AlertDialog     // Catch: java.lang.Exception -> L66
            r5 = 2
            r4.<init>(r14, r5)     // Catch: java.lang.Exception -> L66
            java.lang.String r1 = "Loading"
            r5 = 2131889395(0x7f120cf3, float:1.9413452E38)
            java.lang.String r1 = org.rbmain.messenger.LocaleController.getString(r1, r5)     // Catch: java.lang.Exception -> L66
            r4.setMessage(r1)     // Catch: java.lang.Exception -> L66
            r4.setCanceledOnTouchOutside(r2)     // Catch: java.lang.Exception -> L66
            r4.setCancelable(r0)     // Catch: java.lang.Exception -> L66
            org.rbmain.messenger.MediaController$$ExternalSyntheticLambda1 r0 = new org.rbmain.messenger.MediaController$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L66
            r0.<init>()     // Catch: java.lang.Exception -> L66
            r4.setOnCancelListener(r0)     // Catch: java.lang.Exception -> L66
            org.rbmain.messenger.MediaController$$ExternalSyntheticLambda40 r0 = new org.rbmain.messenger.MediaController$$ExternalSyntheticLambda40     // Catch: java.lang.Exception -> L66
            r0.<init>()     // Catch: java.lang.Exception -> L66
            r1 = 250(0xfa, double:1.235E-321)
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0, r1)     // Catch: java.lang.Exception -> L66
            r8 = r4
            goto L6b
        L66:
            r0 = move-exception
            org.rbmain.messenger.FileLog.e(r0)
        L6a:
            r8 = r3
        L6b:
            java.lang.Thread r0 = new java.lang.Thread
            org.rbmain.messenger.MediaController$$ExternalSyntheticLambda5 r1 = new org.rbmain.messenger.MediaController$$ExternalSyntheticLambda5
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaController.saveFile(java.lang.String, android.content.Context, int, java.lang.String, java.lang.String, java.lang.Runnable):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveFile$33(boolean[] zArr, DialogInterface dialogInterface) {
        zArr[0] = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveFile$34(boolean[] zArr, AlertDialog alertDialog) {
        if (zArr[0]) {
            return;
        }
        alertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(1:120)|(20:(1:4)(1:(1:8)(30:(1:11)(1:12)|13|(3:15|16|(2:17|(1:129)(4:19|(1:21)(1:22)|23|(2:130|25)(1:26))))(0)|27|(1:29)|30|31|121|32|118|33|107|34|113|35|114|36|(5:(1:39)|(1:41)|42|43|44)|47|(6:53|111|54|(1:128)(2:58|126)|59|48)|125|62|(1:64)|65|66|67|88|(1:90)(1:91)|(3:93|(1:95)(1:96)|(1:98))|(2:102|103)(1:131)))|107|34|113|35|114|36|(0)|47|(7:50|53|111|54|(2:56|128)(1:127)|59|48)|124|62|(0)|65|66|67|88|(0)(0)|(0)|(0)(0))|9|27|(0)|30|31|121|32|118|33|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:(1:4)(1:(1:8)(30:(1:11)(1:12)|13|(3:15|16|(2:17|(1:129)(4:19|(1:21)(1:22)|23|(2:130|25)(1:26))))(0)|27|(1:29)|30|31|121|32|118|33|107|34|113|35|114|36|(5:(1:39)|(1:41)|42|43|44)|47|(6:53|111|54|(1:128)(2:58|126)|59|48)|125|62|(1:64)|65|66|67|88|(1:90)(1:91)|(3:93|(1:95)(1:96)|(1:98))|(2:102|103)(1:131)))|113|35|114|36|(0)|47|(7:50|53|111|54|(2:56|128)(1:127)|59|48)|124|62|(0)|65|66|67|88|(0)(0)|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f9, code lost:
    
        org.rbmain.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0173, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0174, code lost:
    
        org.rbmain.messenger.FileLog.e(r0);
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
    public static /* synthetic */ void lambda$saveFile$38(int r20, java.io.File r21, java.lang.String r22, final org.rbmain.ui.ActionBar.AlertDialog r23, boolean[] r24, java.lang.String r25, java.lang.Runnable r26, final boolean[] r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaController.lambda$saveFile$38(int, java.io.File, java.lang.String, org.rbmain.ui.ActionBar.AlertDialog, boolean[], java.lang.String, java.lang.Runnable, boolean[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveFile$35(AlertDialog alertDialog) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveFile$36(AlertDialog alertDialog, int i) {
        try {
            alertDialog.setProgress(i);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveFile$37(AlertDialog alertDialog, boolean[] zArr) {
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
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
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
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String copyFileToCache(android.net.Uri r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaController.copyFileToCache(android.net.Uri, java.lang.String):java.lang.String");
    }

    public static void loadGalleryPhotosAlbums(final int i) {
        Thread thread = new Thread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                MediaController.lambda$loadGalleryPhotosAlbums$40(i);
            }
        });
        thread.setPriority(1);
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(6:274|3|4|262|5|6)|12|(2:278|13)|(6:21|22|(1:24)(1:25)|258|26|(40:272|28|29|260|30|31|252|32|33|246|34|35|(1:37)(1:38)|240|39|40|288|41|42|286|43|44|276|45|46|(7:49|264|50|(3:299|52|302)(11:298|53|(3:55|254|56)(1:57)|(3:59|256|60)(1:63)|64|(2:66|(1:73)(1:72))|74|(2:76|(1:83)(1:82))|84|85|301)|300|268|47)|297|90|(2:284|113)|130|248|131|(4:138|(1:140)(1:141)|142|(5:144|(1:146)(1:147)|148|(4:151|(3:293|153|296)(10:292|154|(7:156|157|270|158|(1:160)(1:161)|(1:163)|164)(1:165)|(3:167|266|168)(1:174)|238|175|(2:177|(1:185)(3:183|232|184))(1:186)|187|188|295)|294|149)|291))|137|(2:236|195)|208|(2:211|209)|290|212|213)(1:111))(1:19)|20|(0)|130|248|131|(8:134|136|138|(0)(0)|142|(0)|137|(0))(0)|208|(1:209)|290|212|213|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0432, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02d3 A[Catch: all -> 0x0432, TryCatch #8 {all -> 0x0432, blocks: (B:131:0x02bd, B:134:0x02c5, B:138:0x02d3, B:142:0x02ed, B:144:0x02ff, B:148:0x0320, B:149:0x033c, B:151:0x0342, B:154:0x034d, B:156:0x038d), top: B:248:0x02bd }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02ff A[Catch: all -> 0x0432, TryCatch #8 {all -> 0x0432, blocks: (B:131:0x02bd, B:134:0x02c5, B:138:0x02d3, B:142:0x02ed, B:144:0x02ff, B:148:0x0320, B:149:0x033c, B:151:0x0342, B:154:0x034d, B:156:0x038d), top: B:248:0x02bd }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x044f A[LOOP:0: B:209:0x0449->B:211:0x044f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088 A[Catch: all -> 0x0292, TRY_LEAVE, TryCatch #23 {all -> 0x0292, blocks: (B:13:0x005b, B:16:0x0063, B:21:0x0088), top: B:278:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x042b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0439 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0279 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void lambda$loadGalleryPhotosAlbums$40(int r51) {
        /*
            Method dump skipped, instructions count: 1157
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaController.lambda$loadGalleryPhotosAlbums$40(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$loadGalleryPhotosAlbums$39(PhotoEntry photoEntry, PhotoEntry photoEntry2) {
        long j = photoEntry.dateTaken;
        long j2 = photoEntry2.dateTaken;
        if (j < j2) {
            return 1;
        }
        return j > j2 ? -1 : 0;
    }

    private static void broadcastNewPhotos(final int i, final ArrayList<AlbumEntry> arrayList, final ArrayList<AlbumEntry> arrayList2, final Integer num, final AlbumEntry albumEntry, final AlbumEntry albumEntry2, final AlbumEntry albumEntry3, int i2) {
        Runnable runnable = broadcastPhotosRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                MediaController.lambda$broadcastNewPhotos$41(i, arrayList, arrayList2, num, albumEntry, albumEntry2, albumEntry3);
            }
        };
        broadcastPhotosRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$broadcastNewPhotos$41(int i, ArrayList arrayList, ArrayList arrayList2, Integer num, AlbumEntry albumEntry, AlbumEntry albumEntry2, AlbumEntry albumEntry3) {
        if (PhotoViewer.getInstance().isVisible()) {
            broadcastNewPhotos(i, arrayList, arrayList2, num, albumEntry, albumEntry2, albumEntry3, CloseCodes.NORMAL_CLOSURE);
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

    public boolean scheduleVideoConvert(MessageObject messageObject, boolean z) {
        if (messageObject == null || messageObject.videoEditedInfo == null) {
            return false;
        }
        if (z && !this.videoConvertQueue.isEmpty()) {
            return false;
        }
        if (z) {
            new File(messageObject.messageOwner.attachPath).delete();
        }
        this.videoConvertQueue.add(new VideoConvertMessage(messageObject, messageObject.videoEditedInfo));
        if (this.videoConvertQueue.size() == 1) {
            startVideoConvertFromQueue();
        }
        return true;
    }

    public boolean scheduleMediaConvert(Context context, SSHMediaConvertRequest sSHMediaConvertRequest) throws InterruptedException {
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry;
        boolean z = false;
        if (sSHMediaConvertRequest != null && (rGHMediaHelper$PhotoEntry = sSHMediaConvertRequest.media) != null) {
            if (rGHMediaHelper$PhotoEntry.isVideo) {
                File file = sSHMediaConvertRequest.cacheFile;
                if (file == null || sSHMediaConvertRequest.coverFile == null) {
                    return false;
                }
                file.delete();
                sSHMediaConvertRequest.coverFile.delete();
            } else {
                File file2 = sSHMediaConvertRequest.cacheFile;
                if (file2 == null) {
                    return false;
                }
                file2.delete();
            }
            this.mediaConvertQueue.add(sSHMediaConvertRequest);
            z = true;
            if (this.mediaConvertQueue.size() == 1) {
                startMediaConvertFromQueue(context);
            }
        }
        return z;
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

    public void cancelVideoConvert(int i) {
        if (this.mediaConvertQueue.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < this.mediaConvertQueue.size(); i2++) {
            SSHMediaConvertRequest sSHMediaConvertRequest = this.mediaConvertQueue.get(i2);
            if (i == -1 || sSHMediaConvertRequest.postRnd == i) {
                if (i2 == 0) {
                    synchronized (this.mediaConvertSync) {
                        sSHMediaConvertRequest.media.editedInfo.canceled = true;
                    }
                    return;
                }
                this.mediaConvertQueue.remove(i2);
                return;
            }
        }
    }

    public void cleanupSSH() {
        this.mediaConvertQueue.clear();
        cancelVideoConvert(-1);
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

    public static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
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

    public static int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        int i;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i2 >= iArr.length) {
                return i3;
            }
            i = iArr[i2];
            if (isRecognizedFormat(i)) {
                if (!mediaCodecInfo.getName().equals("OMX.SEC.AVC.Encoder") || i != 19) {
                    break;
                }
                i3 = i;
            }
            i2++;
        }
        return i;
    }

    public static int findTrack(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = mediaExtractor.getTrackFormat(i).getString("mime");
            if (z) {
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
    public void didWriteData(final VideoConvertMessage videoConvertMessage, final File file, final boolean z, final long j, final long j2, final boolean z2, final float f) {
        VideoEditedInfo videoEditedInfo = videoConvertMessage.videoEditedInfo;
        final boolean z3 = videoEditedInfo.videoConvertFirstWrite;
        if (z3) {
            videoEditedInfo.videoConvertFirstWrite = false;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didWriteData$42(z2, z, videoConvertMessage, file, f, j, z3, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didWriteData$42(boolean z, boolean z2, VideoConvertMessage videoConvertMessage, File file, float f, long j, boolean z3, long j2) {
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

    public void resumeByRewind() {
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
    /* loaded from: classes4.dex */
    static class VideoConvertRunnable implements Runnable {
        private VideoConvertMessage convertMessage;

        private VideoConvertRunnable(VideoConvertMessage videoConvertMessage) {
            this.convertMessage = videoConvertMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaController.getInstance().convertVideo(this.convertMessage);
        }

        public static void runConversion(final VideoConvertMessage videoConvertMessage) {
            new Thread(new Runnable() { // from class: org.rbmain.messenger.MediaController$VideoConvertRunnable$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    MediaController.VideoConvertRunnable.lambda$runConversion$0(videoConvertMessage);
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$runConversion$0(VideoConvertMessage videoConvertMessage) throws InterruptedException {
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
    public boolean convertVideo(final VideoConvertMessage videoConvertMessage) {
        boolean z;
        int i;
        int i2;
        int i3;
        final VideoEditedInfo videoEditedInfo;
        long j;
        long j2;
        int i4;
        int i5;
        MessageObject messageObject = videoConvertMessage.messageObject;
        VideoEditedInfo videoEditedInfo2 = videoConvertMessage.videoEditedInfo;
        if (messageObject == null || videoEditedInfo2 == null) {
            return false;
        }
        String str = videoEditedInfo2.originalPath;
        long j3 = videoEditedInfo2.startTime;
        long j4 = videoEditedInfo2.avatarStartTime;
        long j5 = videoEditedInfo2.endTime;
        int i6 = videoEditedInfo2.resultWidth;
        int i7 = videoEditedInfo2.resultHeight;
        int i8 = videoEditedInfo2.rotationValue;
        int i9 = videoEditedInfo2.originalWidth;
        int i10 = videoEditedInfo2.originalHeight;
        int i11 = videoEditedInfo2.framerate;
        int i12 = videoEditedInfo2.bitrate;
        int i13 = videoEditedInfo2.originalBitrate;
        boolean z2 = ((int) messageObject.getDialogId()) == 0;
        final File file = new File(messageObject.messageOwner.attachPath);
        if (file.exists()) {
            file.delete();
        }
        if (BuildVars.LOGS_ENABLED) {
            StringBuilder sb = new StringBuilder();
            z = z2;
            sb.append("begin convert ");
            sb.append(str);
            sb.append(" startTime = ");
            sb.append(j3);
            sb.append(" avatarStartTime = ");
            sb.append(j4);
            sb.append(" endTime ");
            sb.append(j5);
            sb.append(" rWidth = ");
            sb.append(i6);
            sb.append(" rHeight = ");
            sb.append(i7);
            sb.append(" rotation = ");
            sb.append(i8);
            sb.append(" oWidth = ");
            sb.append(i9);
            sb.append(" oHeight = ");
            i = i10;
            sb.append(i);
            i2 = i6;
            sb.append(" framerate = ");
            sb.append(i11);
            sb.append(" bitrate = ");
            sb.append(i12);
            sb.append(" originalBitrate = ");
            sb.append(i13);
            FileLog.d(sb.toString());
        } else {
            z = z2;
            i = i10;
            i2 = i6;
        }
        if (str == null) {
            str = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        if (j3 > 0 && j5 > 0) {
            j2 = j5 - j3;
            videoEditedInfo = videoEditedInfo2;
            i3 = i7;
        } else if (j5 > 0) {
            j2 = j5;
            i3 = i7;
            videoEditedInfo = videoEditedInfo2;
        } else {
            if (j3 > 0) {
                i3 = i7;
                videoEditedInfo = videoEditedInfo2;
                j = videoEditedInfo.originalDuration - j3;
            } else {
                i3 = i7;
                videoEditedInfo = videoEditedInfo2;
                j = videoEditedInfo.originalDuration;
            }
            j2 = j;
        }
        int i14 = i11 == 0 ? 25 : i11;
        if (i8 == 90 || i8 == 270) {
            i4 = i2;
            i5 = i3;
        } else {
            i5 = i2;
            i4 = i3;
        }
        boolean z3 = (j4 == -1 && videoEditedInfo.cropState == null && videoEditedInfo.mediaEntities == null && videoEditedInfo.paintPath == null && videoEditedInfo.filterState == null && i5 == i9 && i4 == i && i8 == 0 && !videoEditedInfo.roundVideo && j3 == -1) ? false : true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        VideoConvertorListener videoConvertorListener = new VideoConvertorListener() { // from class: org.rbmain.messenger.MediaController.13
            private long lastAvailableSize = 0;

            @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
            public void finishMakeVideo() {
            }

            @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
            public boolean checkConversionCanceled() {
                return videoEditedInfo.canceled;
            }

            @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
            public void didWriteData(long j6, float f) {
                if (videoEditedInfo.canceled) {
                    return;
                }
                if (j6 < 0) {
                    j6 = file.length();
                }
                long j7 = j6;
                if (videoEditedInfo.needUpdateProgress || this.lastAvailableSize != j7) {
                    this.lastAvailableSize = j7;
                    MediaController.this.didWriteData(videoConvertMessage, file, false, 0L, j7, false, f);
                }
            }
        };
        videoEditedInfo.videoConvertFirstWrite = true;
        MediaCodecVideoConvertor mediaCodecVideoConvertor = new MediaCodecVideoConvertor();
        boolean zConvertVideo = mediaCodecVideoConvertor.convertVideo(str, file, i8, z, i9, i, i5, i4, i14, i12, i13, j3, j5, j4, z3, j2, videoEditedInfo.filterState, videoEditedInfo.paintPath, videoEditedInfo.mediaEntities, videoEditedInfo.isPhoto, videoEditedInfo.cropState, videoEditedInfo.roundVideo, videoConvertorListener);
        boolean z4 = videoEditedInfo.canceled;
        if (!z4) {
            synchronized (this.videoConvertSync) {
                z4 = videoEditedInfo.canceled;
            }
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + " canceled=" + z4);
        }
        didWriteData(videoConvertMessage, file, true, mediaCodecVideoConvertor.getLastFrameTimestamp(), file.length(), zConvertVideo || z4, VOLUME_NORMAL);
        return true;
    }

    public static int getVideoBitrate(String str) throws IOException, IllegalArgumentException {
        int i;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        } catch (Exception e) {
            FileLog.e(e);
            i = 0;
        }
        mediaMetadataRetriever.release();
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
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
            goto L36
        L10:
            int r0 = java.lang.Math.min(r8, r9)
            r2 = 720(0x2d0, float:1.009E-42)
            if (r0 < r2) goto L1b
            r0 = 2621440(0x280000, float:3.67342E-39)
            goto Ld
        L1b:
            int r0 = java.lang.Math.min(r8, r9)
            r1 = 480(0x1e0, float:6.73E-43)
            if (r0 < r1) goto L2d
            r0 = 1000000(0xf4240, float:1.401298E-39)
            r1 = 1061997773(0x3f4ccccd, float:0.8)
            r2 = 1063675494(0x3f666666, float:0.9)
            goto L36
        L2d:
            r0 = 750000(0xb71b0, float:1.050974E-39)
            r1 = 1058642330(0x3f19999a, float:0.6)
            r2 = 1060320051(0x3f333333, float:0.7)
        L36:
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
            if (r7 >= r6) goto L57
            return r5
        L57:
            if (r5 <= r0) goto L5a
            return r0
        L5a:
            int r5 = java.lang.Math.max(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaController.makeVideoBitrate(int, int, int, int, int):int");
    }

    /* loaded from: classes4.dex */
    public static class PlaylistGlobalSearchParams {
        final int dialogId;
        public boolean endReached;
        final FiltersView.MediaFilterData filter;
        public int folderId;
        final long maxDate;
        final long minDate;
        public int nextSearchRate;
        final String query;
        public int totalCount;

        public PlaylistGlobalSearchParams(String str, int i, long j, long j2, FiltersView.MediaFilterData mediaFilterData) {
            this.filter = mediaFilterData;
            this.query = str;
            this.dialogId = i;
            this.minDate = j;
            this.maxDate = j2;
        }
    }

    public boolean currentPlaylistIsGlobalSearch() {
        return this.playlistGlobalSearchParams != null;
    }

    public void setAddPostCropArea(float f, float f2, float f3, float f4) {
        this.cropArea.set(f, f2, f3, f4);
    }

    public RectF getAddPostCropArea() {
        return this.cropArea;
    }

    public static int getRubinoContainerViewHeight() {
        return AndroidUtilities.displayMetrics.widthPixels;
    }

    public static int getRubinoContainerViewWidth() {
        return AndroidUtilities.displayMetrics.widthPixels;
    }

    public static void setMediaInfo(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
        rGHMediaHelper$PhotoEntry.size = new File(rGHMediaHelper$PhotoEntry.path).length();
        if (rGHMediaHelper$PhotoEntry.editedInfo == null) {
            VideoEditedInfo videoEditedInfo = new VideoEditedInfo();
            rGHMediaHelper$PhotoEntry.editedInfo = videoEditedInfo;
            videoEditedInfo.cropState = new CropState();
        }
        boolean z = true;
        if (rGHMediaHelper$PhotoEntry.isVideo) {
            int[] iArr = new int[11];
            AnimatedFileDrawable.getVideoInfo(rGHMediaHelper$PhotoEntry.path, iArr);
            int i = iArr[8];
            int i2 = iArr[1];
            int i3 = iArr[2];
            while (i < 0) {
                i += 360;
            }
            while (i > 360) {
                i -= 360;
            }
            rGHMediaHelper$PhotoEntry.orientation = i;
            if (i == 90 || i == 270) {
                i3 = i2;
                i2 = i3;
            }
            boolean z2 = iArr[10] != 0;
            if (iArr[0] == 0 || (z2 && iArr[9] == 0)) {
                z = false;
            }
            if (z) {
                rGHMediaHelper$PhotoEntry.width = i2;
                rGHMediaHelper$PhotoEntry.height = i3;
                rGHMediaHelper$PhotoEntry.duration = iArr[4];
                VideoEditedInfo videoEditedInfo2 = rGHMediaHelper$PhotoEntry.editedInfo;
                videoEditedInfo2.originalDuration = iArr[4];
                videoEditedInfo2.framerate = iArr[7];
                return;
            }
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(new File(rGHMediaHelper$PhotoEntry.path).getAbsolutePath(), options);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        int i6 = rGHMediaHelper$PhotoEntry.orientation;
        while (i6 < 0) {
            i6 += 360;
        }
        while (i6 > 360) {
            i6 -= 360;
        }
        rGHMediaHelper$PhotoEntry.orientation = i6;
        if (i6 == 90 || i6 == 270) {
            i4 = i5;
            i5 = i4;
        }
        rGHMediaHelper$PhotoEntry.width = i4;
        rGHMediaHelper$PhotoEntry.height = i5;
        SSHCropView.SSHCropState sSHCropState = rGHMediaHelper$PhotoEntry.cropState;
        sSHCropState.width = i4;
        sSHCropState.height = i5;
    }

    public static void setSavedCropStateOnPhotoEntry(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, float f, float f2, float f3, float f4, float f5) {
        int iRound;
        int i;
        VideoEditedInfo videoEditedInfo;
        int i2;
        boolean z = rGHMediaHelper$PhotoEntry.isVideo;
        float f6 = VOLUME_NORMAL;
        if (z) {
            int i3 = rGHMediaHelper$PhotoEntry.width;
            int i4 = rGHMediaHelper$PhotoEntry.height;
            int iMin = Math.min(MAX_WIDTH_HEIGHT_SIZE, Math.min(i3, i4));
            if (i3 > i4) {
                iMin = (int) (i3 * (iMin / i4));
                i = iMin;
            } else {
                i = (int) (i4 * (iMin / i3));
            }
            VideoEditedInfo videoEditedInfo2 = rGHMediaHelper$PhotoEntry.editedInfo;
            videoEditedInfo2.resultWidth = iMin;
            videoEditedInfo2.resultHeight = i;
            if (rGHMediaHelper$PhotoEntry.width > rGHMediaHelper$PhotoEntry.height) {
                CropState cropState = videoEditedInfo2.cropState;
                cropState.cropPw = i / iMin;
                cropState.cropPh = VOLUME_NORMAL;
            } else {
                CropState cropState2 = videoEditedInfo2.cropState;
                cropState2.cropPh = iMin / i;
                cropState2.cropPw = VOLUME_NORMAL;
            }
            videoEditedInfo2.rotationValue += videoEditedInfo2.cropState.transformRotation;
            while (true) {
                videoEditedInfo = rGHMediaHelper$PhotoEntry.editedInfo;
                i2 = videoEditedInfo.rotationValue;
                if (i2 < 360) {
                    break;
                } else {
                    videoEditedInfo.rotationValue = i2 - 360;
                }
            }
            if (i2 == 90 || i2 == 270) {
                CropState cropState3 = videoEditedInfo.cropState;
                cropState3.transformWidth = (int) (videoEditedInfo.resultWidth * cropState3.cropPh);
                cropState3.transformHeight = (int) (videoEditedInfo.resultHeight * cropState3.cropPw);
            } else {
                CropState cropState4 = videoEditedInfo.cropState;
                cropState4.transformWidth = (int) (videoEditedInfo.resultWidth * cropState4.cropPw);
                cropState4.transformHeight = (int) (videoEditedInfo.resultHeight * cropState4.cropPh);
            }
            CropState cropState5 = videoEditedInfo.cropState;
            int[] iArrFixVideoWidthHeight = fixVideoWidthHeight(cropState5.transformWidth, cropState5.transformHeight);
            CropState cropState6 = rGHMediaHelper$PhotoEntry.editedInfo.cropState;
            cropState6.transformWidth = iArrFixVideoWidthHeight[0];
            cropState6.transformHeight = iArrFixVideoWidthHeight[1];
            return;
        }
        CropState cropState7 = rGHMediaHelper$PhotoEntry.editedInfo.cropState;
        cropState7.scale = f / f3;
        cropState7.minScale = f2 / f3;
        cropState7.translateX = 0;
        cropState7.translateY = 0;
        if (getInstance().isLockRatio()) {
            rGHMediaHelper$PhotoEntry.cropState.reset();
            rGHMediaHelper$PhotoEntry.cropState.reset(getInstance().getAddPostCropArea(), Math.max(VOLUME_NORMAL, rGHMediaHelper$PhotoEntry.editedInfo.cropState.scale), 0.0f, false);
            SSHCropView.SSHCropState sSHCropState = rGHMediaHelper$PhotoEntry.cropState;
            CropState cropState8 = rGHMediaHelper$PhotoEntry.editedInfo.cropState;
            sSHCropState.translate(cropState8.translateX, cropState8.translateY);
        } else {
            rGHMediaHelper$PhotoEntry.cropState.reset();
            rGHMediaHelper$PhotoEntry.cropState.scale(Math.max(VOLUME_NORMAL, rGHMediaHelper$PhotoEntry.editedInfo.cropState.scale), 0.0f, 0.0f);
            SSHCropView.SSHCropState sSHCropState2 = rGHMediaHelper$PhotoEntry.cropState;
            CropState cropState9 = rGHMediaHelper$PhotoEntry.editedInfo.cropState;
            sSHCropState2.translate(cropState9.translateX, cropState9.translateY);
        }
        int i5 = rGHMediaHelper$PhotoEntry.width;
        int i6 = rGHMediaHelper$PhotoEntry.height;
        int iMin2 = Math.min(MAX_WIDTH_HEIGHT_SIZE, Math.min(i5, i6));
        if (getInstance().isLockRatio()) {
            f = f2;
        }
        float f7 = f / f3;
        if (f7 >= VOLUME_NORMAL && !getInstance().isLockRatio()) {
            iRound = iMin2;
        } else if (i5 > i6) {
            float f8 = iMin2;
            int iRound2 = Math.round(getInstance().getAddPostCropArea().width() * (f8 / (getInstance().getAddPostCropArea().height() * f7)));
            f6 = f8 / iRound2;
            iMin2 = iRound2;
            iRound = iMin2;
        } else {
            float f9 = iMin2;
            iRound = Math.round(getInstance().getAddPostCropArea().height() * (f9 / (getInstance().getAddPostCropArea().width() * f7)));
            f6 = f9 / iRound;
        }
        int i7 = (int) (iMin2 * f6);
        int i8 = (int) (iRound * f6);
        VideoEditedInfo videoEditedInfo3 = rGHMediaHelper$PhotoEntry.editedInfo;
        videoEditedInfo3.resultWidth = i7;
        videoEditedInfo3.resultHeight = i8;
        int[] iArrFixVideoWidthHeight2 = fixVideoWidthHeight(i7, i8);
        VideoEditedInfo videoEditedInfo4 = rGHMediaHelper$PhotoEntry.editedInfo;
        videoEditedInfo4.resultWidth = iArrFixVideoWidthHeight2[0];
        videoEditedInfo4.resultHeight = iArrFixVideoWidthHeight2[1];
    }

    public static int[] fixVideoWidthHeight(int i, int i2) {
        int[] iArr = {i, i2};
        if (iArr[0] % 2 != 0) {
            iArr[0] = iArr[0] + 1;
        }
        if (iArr[1] % 2 != 0) {
            iArr[1] = iArr[1] + 1;
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int makeVideoBitrate2(int r5, int r6, int r7, int r8, int r9) {
        /*
            int r0 = java.lang.Math.min(r8, r9)
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 1080(0x438, float:1.513E-42)
            if (r0 < r2) goto L14
            r0 = 3000000(0x2dc6c0, float:4.203895E-39)
            int r0 = java.lang.Math.min(r0, r7)
        L11:
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L46
        L14:
            int r0 = java.lang.Math.min(r8, r9)
            r2 = 720(0x2d0, float:1.009E-42)
            if (r0 < r2) goto L23
            r0 = 2621440(0x280000, float:3.67342E-39)
            int r0 = java.lang.Math.min(r0, r7)
            goto L11
        L23:
            int r0 = java.lang.Math.min(r8, r9)
            r1 = 480(0x1e0, float:6.73E-43)
            if (r0 < r1) goto L39
            r0 = 1000000(0xf4240, float:1.401298E-39)
            int r0 = java.lang.Math.min(r0, r7)
            r1 = 1061997773(0x3f4ccccd, float:0.8)
            r2 = 1063675494(0x3f666666, float:0.9)
            goto L46
        L39:
            r0 = 750000(0xb71b0, float:1.050974E-39)
            int r0 = java.lang.Math.min(r0, r7)
            r1 = 1058642330(0x3f19999a, float:0.6)
            r2 = 1060320051(0x3f333333, float:0.7)
        L46:
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
            if (r7 >= r6) goto L67
            return r5
        L67:
            if (r5 <= r0) goto L6a
            return r0
        L6a:
            int r5 = java.lang.Math.max(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaController.makeVideoBitrate2(int, int, int, int, int):int");
    }

    public boolean isLockRatio() {
        return this.isLockRatio;
    }

    public void setLockRatio(boolean z) {
        this.isLockRatio = z;
    }

    /* loaded from: classes4.dex */
    public static class SSHMediaConvertRequest {
        public File cacheFile;
        public File coverFile;
        public final int currentAccount;
        public long id;
        public RGHMediaHelper$PhotoEntry media;
        public int postRnd;

        public SSHMediaConvertRequest(int i, long j, File file, File file2, RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
            this.id = j;
            this.cacheFile = file;
            this.coverFile = file2;
            this.media = rGHMediaHelper$PhotoEntry;
            this.currentAccount = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.id == ((SSHMediaConvertRequest) obj).id;
        }
    }

    public void didWriteData(final Context context, final SSHMediaConvertRequest sSHMediaConvertRequest, final File file, final boolean z, final long j, final long j2, final boolean z2, final float f) {
        VideoEditedInfo videoEditedInfo = sSHMediaConvertRequest.media.editedInfo;
        final boolean z3 = videoEditedInfo.videoConvertFirstWrite;
        if (z3) {
            videoEditedInfo.videoConvertFirstWrite = false;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaController$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$didWriteData$43(z2, z, sSHMediaConvertRequest, context, file, f, j, z3, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didWriteData$43(boolean z, boolean z2, SSHMediaConvertRequest sSHMediaConvertRequest, Context context, File file, float f, long j, boolean z3, long j2) throws InterruptedException {
        if (z || z2) {
            synchronized (this.mediaConvertSync) {
                sSHMediaConvertRequest.media.editedInfo.canceled = false;
            }
            this.mediaConvertQueue.remove(sSHMediaConvertRequest);
            startMediaConvertFromQueue(context);
        }
        if (z) {
            NotificationCenter.getInstance(sSHMediaConvertRequest.currentAccount).postNotificationName(NotificationCenter.sshFilePreparingFailed, sSHMediaConvertRequest, file.toString(), Float.valueOf(f), Long.valueOf(j));
            return;
        }
        if (z3) {
            NotificationCenter.getInstance(sSHMediaConvertRequest.currentAccount).postNotificationName(NotificationCenter.sshFilePreparingStarted, sSHMediaConvertRequest, file.toString(), Float.valueOf(f), Long.valueOf(j));
        }
        NotificationCenter notificationCenter = NotificationCenter.getInstance(sSHMediaConvertRequest.currentAccount);
        int i = NotificationCenter.sshFileNewChunkAvailable;
        Object[] objArr = new Object[6];
        objArr[0] = sSHMediaConvertRequest;
        objArr[1] = file.toString();
        objArr[2] = Long.valueOf(j2);
        objArr[3] = Long.valueOf(z2 ? file.length() : 0L);
        objArr[4] = Float.valueOf(f);
        objArr[5] = Long.valueOf(j);
        notificationCenter.postNotificationName(i, objArr);
        Log.d("SAEEED", "didWriteData: " + f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean convertMedia(final Context context, final SSHMediaConvertRequest sSHMediaConvertRequest) {
        File file;
        File file2;
        int i;
        long j;
        long j2;
        int i2;
        File file3 = sSHMediaConvertRequest.cacheFile;
        File file4 = sSHMediaConvertRequest.coverFile;
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = sSHMediaConvertRequest.media;
        final VideoEditedInfo videoEditedInfo = rGHMediaHelper$PhotoEntry.editedInfo;
        if (file3 == null || videoEditedInfo == null) {
            return false;
        }
        String str = rGHMediaHelper$PhotoEntry.path;
        long j3 = videoEditedInfo.startTime;
        long j4 = videoEditedInfo.endTime;
        int i3 = videoEditedInfo.resultWidth;
        int i4 = videoEditedInfo.resultHeight;
        int i5 = videoEditedInfo.rotationValue;
        int i6 = videoEditedInfo.originalWidth;
        int i7 = videoEditedInfo.originalHeight;
        int i8 = videoEditedInfo.framerate;
        int i9 = videoEditedInfo.bitrate;
        if (file3.exists()) {
            file3.delete();
        }
        if (file4.exists()) {
            file4.delete();
        }
        if (BuildVars.LOGS_ENABLED) {
            file = file4;
            StringBuilder sb = new StringBuilder();
            file2 = file3;
            sb.append("begin convert ");
            sb.append(str);
            sb.append(" startTime = ");
            sb.append(j3);
            sb.append(" endTime ");
            sb.append(j4);
            sb.append(" rWidth = ");
            sb.append(i3);
            sb.append(" rHeight = ");
            sb.append(i4);
            sb.append(" rotation = ");
            sb.append(i5);
            sb.append(" oWidth = ");
            sb.append(i6);
            sb.append(" oHeight = ");
            sb.append(i7);
            sb.append(" framerate = ");
            sb.append(i8);
            sb.append(" bitrate = ");
            sb.append(i9);
            sb.append(" originalBitrate = ");
            sb.append(i9);
            FileLog.d(sb.toString());
        } else {
            file = file4;
            file2 = file3;
        }
        if (str == null) {
            str = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        String str2 = str;
        if (j3 > 0 && j4 > 0) {
            i = i3;
            j2 = j4 - j3;
        } else if (j4 > 0) {
            i = i3;
            j2 = j4;
        } else {
            if (j3 > 0) {
                i = i3;
                j = videoEditedInfo.originalDuration - j3;
            } else {
                i = i3;
                j = videoEditedInfo.originalDuration;
            }
            j2 = j;
        }
        int i10 = i8 == 0 ? 25 : i8;
        if (i5 == 90 || i5 == 270) {
            i2 = i;
            i = i4;
        } else {
            i2 = i4;
        }
        boolean z = (videoEditedInfo.cropState == null && videoEditedInfo.paintPath == null && sSHMediaConvertRequest.media.savedFilterState == null && i == i6 && i2 == i7 && i5 == 0 && !videoEditedInfo.roundVideo && j3 == -1) ? false : true;
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("videoconvert", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        final File file5 = file2;
        int i11 = i;
        final File file6 = file;
        VideoConvertorListener videoConvertorListener = new VideoConvertorListener() { // from class: org.rbmain.messenger.MediaController.14
            private long lastAvailableSize = 0;

            @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
            public boolean checkConversionCanceled() {
                return videoEditedInfo.canceled;
            }

            @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
            public void didWriteData(long j5, float f) {
                if (videoEditedInfo.canceled) {
                    return;
                }
                if (j5 < 0) {
                    j5 = file5.length();
                }
                long j6 = j5;
                if (videoEditedInfo.needUpdateProgress || this.lastAvailableSize != j6) {
                    this.lastAvailableSize = j6;
                    MediaController.this.didWriteData(context, sSHMediaConvertRequest, file5, false, 0L, j6, false, f);
                }
            }

            @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
            public void finishMakeVideo() throws IOException, IllegalArgumentException {
                Bitmap bitmapGenerateThumbnail;
                MediaMetadataRetriever mediaMetadataRetriever;
                VideoEditedInfo videoEditedInfo2 = sSHMediaConvertRequest.media.editedInfo;
                Bitmap bitmap = videoEditedInfo2.coverPhotoBitmap;
                if (bitmap == null) {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(file5.getAbsolutePath());
                    bitmapGenerateThumbnail = mediaMetadataRetriever.getFrameAtTime(sSHMediaConvertRequest.media.editedInfo.coverPhotoTime);
                } else {
                    CropState cropState = videoEditedInfo2.cropState;
                    bitmapGenerateThumbnail = ImageLoader.generateThumbnail(bitmap, MediaController.VOLUME_NORMAL, cropState.translateX, cropState.translateY, cropState.transformWidth, cropState.transformHeight);
                    mediaMetadataRetriever = null;
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file6);
                    bitmapGenerateThumbnail.compress(Bitmap.CompressFormat.JPEG, sSHMediaConvertRequest.media.editedInfo.quality, fileOutputStream);
                    fileOutputStream.close();
                    bitmapGenerateThumbnail.recycle();
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                MediaController.this.mediaConvertQueue.remove(sSHMediaConvertRequest);
            }
        };
        videoEditedInfo.videoConvertFirstWrite = true;
        SSHMediaCodecVideoConvertor sSHMediaCodecVideoConvertor = new SSHMediaCodecVideoConvertor();
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry2 = sSHMediaConvertRequest.media;
        File file7 = file2;
        boolean zConvertVideo = sSHMediaCodecVideoConvertor.convertVideo(context, str2, file2, i5, rGHMediaHelper$PhotoEntry2.orientation, i11, i2, i10, i9, i9, j3, j4, z, j2, rGHMediaHelper$PhotoEntry2.savedFilterState, videoEditedInfo.paintPath, videoEditedInfo.cropState, videoConvertorListener);
        boolean z2 = videoEditedInfo.canceled;
        if (!z2) {
            synchronized (this.mediaConvertSync) {
                z2 = videoEditedInfo.canceled;
            }
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + " canceled=" + z2);
        }
        sharedPreferences.edit().putBoolean("isPreviousOk", true).apply();
        didWriteData(context, sSHMediaConvertRequest, file7, true, sSHMediaCodecVideoConvertor.getLastFrameTimestamp(), file7.length(), zConvertVideo || z2, VOLUME_NORMAL);
        return true;
    }

    private boolean startMediaConvertFromQueue(Context context) throws InterruptedException {
        Log.d("SANA", "startMediaConvertFromQueue: " + this.mediaConvertQueue.size());
        if (this.mediaConvertQueue.isEmpty()) {
            return false;
        }
        SSHMediaConvertRequest sSHMediaConvertRequest = this.mediaConvertQueue.get(0);
        VideoEditedInfo videoEditedInfo = sSHMediaConvertRequest.media.editedInfo;
        synchronized (this.mediaConvertSync) {
            if (videoEditedInfo != null) {
                videoEditedInfo.canceled = false;
            }
        }
        SSHMediaConvertRunnable.runConversion(context, sSHMediaConvertRequest);
        Log.d("SANA", "startMediaConvertFromQueue: " + sSHMediaConvertRequest.media.editedInfo.resultWidth + "," + sSHMediaConvertRequest.media.editedInfo.resultHeight);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    static class SSHMediaConvertRunnable implements Runnable {
        private final Context context;
        private final SSHMediaConvertRequest mediaConvertRequest;

        private SSHMediaConvertRunnable(Context context, SSHMediaConvertRequest sSHMediaConvertRequest) {
            this.context = context;
            this.mediaConvertRequest = sSHMediaConvertRequest;
        }

        public static void runConversion(final Context context, final SSHMediaConvertRequest sSHMediaConvertRequest) throws InterruptedException {
            if (sSHMediaConvertRequest.media.isVideo) {
                new Thread(new Runnable() { // from class: org.rbmain.messenger.MediaController$SSHMediaConvertRunnable$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        MediaController.SSHMediaConvertRunnable.lambda$runConversion$0(context, sSHMediaConvertRequest);
                    }
                }).start();
                return;
            }
            try {
                SSHMediaPhotoConvertor sSHMediaPhotoConvertor = new SSHMediaPhotoConvertor(context, sSHMediaConvertRequest);
                sSHMediaPhotoConvertor.start();
                sSHMediaPhotoConvertor.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$runConversion$0(Context context, SSHMediaConvertRequest sSHMediaConvertRequest) throws InterruptedException {
            try {
                Thread thread = new Thread(new SSHMediaConvertRunnable(context, sSHMediaConvertRequest), "VideoConvertRunnable");
                thread.start();
                thread.join();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaController.getInstance().convertMedia(this.context, this.mediaConvertRequest);
        }
    }

    public boolean isPiPShown() {
        return this.pipRoundVideoView != null;
    }
}
