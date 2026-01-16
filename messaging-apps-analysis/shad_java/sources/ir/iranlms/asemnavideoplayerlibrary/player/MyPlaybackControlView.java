package ir.iranlms.asemnavideoplayerlibrary.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.Glide;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.FixedTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import ir.iranlms.asemnavideoplayerlibrary.SeekBarWithPins;
import ir.iranlms.asemnavideoplayerlibrary.player.SettingListAdapter;
import ir.iranlms.asemnavideoplayerlibrary.player.interfaces.AsemanPlayerListener;
import ir.iranlms.asemnavideoplayerlibrary.player.models.AdsObject;
import ir.iranlms.asemnavideoplayerlibrary.player.models.BookmarkObject;
import ir.iranlms.asemnavideoplayerlibrary.player.models.EnumStreamType;
import ir.iranlms.asemnavideoplayerlibrary.player.models.PinObject;
import ir.iranlms.asemnavideoplayerlibrary.player.models.PlayObject;
import ir.iranlms.asemnavideoplayerlibrary.player.models.QualityObject;
import ir.iranlms.asemnavideoplayerlibrary.player.models.SettingItem;
import ir.iranlms.asemnavideoplayerlibrary.player.models.SubtitleObject;
import ir.iranlms.asemnavideoplayerlibrary.player.models.ThumbnailItem;
import ir.medu.shad.R;
import ir.resaneh1.iptv.api.ApiRequest;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.PlayerStateObject;
import ir.resaneh1.iptv.model.ViewStreamInput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationBadge;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RadialProgressView;
import org.webrtc.MediaStreamTrack;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class MyPlaybackControlView extends FrameLayout {
    public static final SeekDispatcher DEFAULT_SEEK_DISPATCHER = new SeekDispatcher() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.2
        @Override // ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.SeekDispatcher
        public boolean dispatchSeek(ExoPlayer exoPlayer, int i, long j) {
            exoPlayer.seekTo(i, j);
            return true;
        }
    };
    private Runnable adsCallback;
    private ImageView adsImageView;
    View adsLayout;
    private final CardView alertLayout;
    private AsemanPlayerListener asemanPlayerListener;
    private final View back15SecButton;
    private boolean brithnessChanged;
    TextView buttonAdsLink;
    private ImageView centerImage;
    private View centerLayout;
    private TextView centerText;
    RingProgressBar circleProgressBar;
    private final ComponentListener componentListener;
    private int counter;
    private final Timeline.Window currentWindow;
    private SettingsDialog dialog;
    private boolean dragging;
    private final TextView durationSlashView;
    private final TextView durationView;
    PlayerView exoPlayerView;
    private final View fastForwardButton;
    private int fastForwardMs;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private final ImageView fullScreenButton;
    private final Runnable hideAction;
    private long hideAtMs;
    private final Runnable hideInstaVolum;
    private ImageView imageViewPreview;
    private boolean isAttachedToWindow;
    public boolean isCurrentFullScreen;
    public boolean isJustFullScreen;
    private boolean isLive;
    public boolean isLock;
    private boolean isShowVideoPreview;
    private boolean isShowedAlertOneTime;
    private boolean isShowingAlert;
    private long lastDuration;
    int lastSelectedQualityPosition;
    int lastSelectedSubtitlePosition;
    private final RelativeLayout layoutPreview;
    LinearLayout linearLayoutTouchHandler;
    FrameLayout loadingProgressBar;
    private final View lockButton;
    ImageView muteImageView;
    int navigationWidth;
    private final View nextButton;
    ViewGroup normalScreenLayout;
    View.OnFocusChangeListener onFocusChangeListener;
    View.OnClickListener onSettingItemDeleteListener;
    View.OnClickListener onSettingItemListener;
    View.OnTouchListener onTouchListener;
    private final View pauseButton;
    View playBar;
    private final View playButton;
    private PlayObject playObject;
    private ExoPlayer player;
    public SimpleExoPlayer playerAds;
    private ObservableEmitter<PlayerStateObject> playerStateObjectEmitter;
    private Observable<PlayerStateObject> playerStateObjectObservable;
    private final TextView positionView;
    private final TextView positionViewPreview;
    private long positionWhenClickedOnSetting;
    private final View previousButton;
    private final SeekBarWithPins progressBar;
    public ImageView retryImageView;
    private final View rewindButton;
    private int rewindMs;
    private SeekDispatcher seekDispatcher;
    private final View settingButton;
    private int showTimeoutMs;
    TextView skipButton;
    private final TextView textViewAlert;
    private DiscreteScrollView thumbnailsDiscreteScrollView;
    private boolean touchControllerAlwaysEnabled;
    private DefaultTrackSelector trackSelector;
    private final View unLockButton;
    private final Runnable updateProgressAction;
    private VisibilityListener visibilityListener;

    public interface SeekDispatcher {
        boolean dispatchSeek(ExoPlayer exoPlayer, int i, long j);
    }

    public enum TouchState {
        nothing,
        slidingHorizontal,
        slidingVerticalRight,
        slidingVerticalLeft
    }

    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    private static boolean isHandledMediaKey(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return true;
    }

    public void release() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.removeListener(this.componentListener);
        }
        if (this.brithnessChanged) {
            WindowManager.LayoutParams attributes = ((Activity) getContext()).getWindow().getAttributes();
            attributes.screenBrightness = -1.0f;
            ((Activity) getContext()).getWindow().setAttributes(attributes);
        }
    }

    public Observable<PlayerStateObject> getPlayerStateObjectObservable() {
        if (this.playerStateObjectObservable == null) {
            this.playerStateObjectObservable = Observable.create(new ObservableOnSubscribe<PlayerStateObject>() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.1
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<PlayerStateObject> observableEmitter) throws Exception {
                    MyPlaybackControlView.this.playerStateObjectEmitter = observableEmitter;
                }
            });
        }
        return this.playerStateObjectObservable;
    }

    public void setTrackSelector(DefaultTrackSelector defaultTrackSelector) {
        this.trackSelector = defaultTrackSelector;
    }

    public void setPlayObject(PlayObject playObject) {
        MyLog.e("ContentValues", "setPlayObject: " + playObject.type);
        DiscreteScrollView discreteScrollView = (DiscreteScrollView) findViewById(R.id.forecast_city_picker);
        this.thumbnailsDiscreteScrollView = discreteScrollView;
        discreteScrollView.setAdapter(new VideoPreviewAdapter(getContext(), playObject.thumbnailItems));
        this.thumbnailsDiscreteScrollView.scrollToPosition(0);
        this.thumbnailsDiscreteScrollView.setItemTransitionTimeMillis(100);
        this.thumbnailsDiscreteScrollView.setItemTransformer(new ScaleTransformer.Builder().setMinScale(0.7f).build());
        this.playObject = playObject;
        PlayObject.Setting setting = playObject.setting;
        this.isJustFullScreen = setting.isJustFullScreen;
        this.touchControllerAlwaysEnabled = setting.isTouchControllerAlwaysEnabled;
        this.isShowVideoPreview = playObject.thumbnailItems.size() > 0;
        EnumStreamType enumStreamType = playObject.type;
        this.isLive = enumStreamType == EnumStreamType.live || enumStreamType == EnumStreamType.timeshift;
        if (this.isJustFullScreen) {
            showVideoInFullScreen();
        }
        if (playObject.type == EnumStreamType.aod) {
            MyLog.e("ContentValues", "setPlayObject: if");
            if (playObject.imageUrl != null && this.imageViewPreview != null) {
                MyLog.e("ContentValues", "setPlayObject: " + playObject.imageUrl);
                try {
                    MyLog.e("ContentValues", "setPlayObject: try");
                    Glide.with(getContext()).load(playObject.imageUrl).into(this.imageViewPreview);
                } catch (Exception e) {
                    MyLog.e("ContentValues", "setPlayObject: catch" + e.getMessage());
                }
            }
        }
        setSelectedQualityPosition();
        setSelectedSubtitlePosition();
        if (this.muteImageView != null && playObject.isForInsta) {
            refreshMuteImageView();
        }
        updateProgress();
    }

    public void refreshMuteImageView() {
        PlayObject playObject = this.playObject;
        if (playObject != null && playObject.isForExplore) {
            this.muteImageView.setVisibility(8);
            return;
        }
        if (playObject == null || !playObject.isForInsta) {
            return;
        }
        this.muteImageView.setVisibility(0);
        if (PlayerBaseFragment.instaIsMute) {
            this.muteImageView.setImageResource(R.drawable.ic_mute_insta);
            removeCallbacks(this.hideInstaVolum);
        } else {
            this.muteImageView.setImageResource(R.drawable.ic_unmute_insta);
            postDelayed(this.hideInstaVolum, 1000L);
        }
    }

    void setSelectedQualityPosition() {
        this.lastSelectedQualityPosition = 0;
        PlayObject playObject = this.playObject;
        if (playObject.setting.quality_id < 0) {
            return;
        }
        Iterator<QualityObject> it = playObject.qualityObjects.iterator();
        while (it.hasNext()) {
            int i = it.next().id;
            if (i == this.playObject.setting.quality_id) {
                this.lastSelectedQualityPosition = i + 1;
            }
        }
    }

    void setSelectedSubtitlePosition() {
        int i = 0;
        this.lastSelectedSubtitlePosition = 0;
        PlayObject playObject = this.playObject;
        if (playObject.setting.subtitle_id < 0) {
            return;
        }
        Iterator<SubtitleObject> it = playObject.subtitleObjects.iterator();
        while (it.hasNext()) {
            i++;
            if (it.next().id == this.playObject.setting.subtitle_id) {
                this.lastSelectedSubtitlePosition = i;
            }
        }
    }

    public void addBookMark(String str) {
        BookmarkObject bookmarkObject = new BookmarkObject();
        bookmarkObject.text = str;
        bookmarkObject.location = this.positionWhenClickedOnSetting / 1000;
        this.playObject.bookmarkObjects.add(bookmarkObject);
        AsemanPlayerListener asemanPlayerListener = this.asemanPlayerListener;
        if (asemanPlayerListener != null) {
            asemanPlayerListener.onBookmarkAdded(bookmarkObject);
        }
        updatePins();
    }

    public void setAsemanPlayerListener(AsemanPlayerListener asemanPlayerListener) {
        this.asemanPlayerListener = asemanPlayerListener;
    }

    static {
        new FixedTrackSelection.Factory();
    }

    public MyPlaybackControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyPlaybackControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowVideoPreview = true;
        this.isLive = false;
        this.isJustFullScreen = false;
        this.isCurrentFullScreen = false;
        this.navigationWidth = 0;
        this.trackSelector = null;
        this.counter = 25;
        this.lastDuration = 0L;
        this.brithnessChanged = false;
        this.isShowedAlertOneTime = false;
        this.isLock = false;
        this.updateProgressAction = new Runnable() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.3
            @Override // java.lang.Runnable
            public void run() {
                MyPlaybackControlView.this.updateProgress();
            }
        };
        this.hideAction = new Runnable() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.4
            @Override // java.lang.Runnable
            public void run() {
                MyPlaybackControlView.this.hide();
            }
        };
        this.hideInstaVolum = new Runnable() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.5
            @Override // java.lang.Runnable
            public void run() {
                MyPlaybackControlView.this.muteImageView.setVisibility(4);
            }
        };
        this.onFocusChangeListener = new View.OnFocusChangeListener(this) { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
            }
        };
        this.onTouchListener = new View.OnTouchListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.7
            AudioManager audioManager = null;
            float firstBrightnessValue;
            long firstSeekPositon;
            int firstVolumePositon;
            float firstX;
            float firstY;
            public boolean hideAfterTouchUp;
            int maxVolumeNumber;
            public DisplayMetrics metrics;
            TouchState touchState;

            void seekPosition(float f) {
                if (MyPlaybackControlView.this.player == null) {
                    return;
                }
                float f2 = f / this.metrics.density;
                long duration = MyPlaybackControlView.this.getPlayer().getDuration();
                float fSignum = Math.signum(f2);
                long jPow = (long) (this.firstSeekPositon + (((float) Math.pow(Math.abs(f2), 2.0d)) * fSignum));
                if (jPow < 0) {
                    jPow = 0;
                }
                if (jPow <= duration) {
                    duration = jPow;
                }
                MyPlaybackControlView.this.seekTo(duration);
                MyPlaybackControlView.this.centerImage.setImageResource(0);
                if (fSignum > 0.0f) {
                    MyPlaybackControlView.this.centerText.setText("+" + MyPlaybackControlView.this.stringForTime(Math.abs(duration - this.firstSeekPositon)));
                    return;
                }
                MyPlaybackControlView.this.centerText.setText("-" + MyPlaybackControlView.this.stringForTime(Math.abs(duration - this.firstSeekPositon)));
            }

            void setAudioVolume(float f) {
                float f2 = this.firstVolumePositon;
                int i2 = this.maxVolumeNumber;
                int i3 = (int) (f2 - (i2 * ((f / 1000.0f) * this.metrics.density)));
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 <= i2) {
                    i2 = i3;
                }
                this.audioManager.setStreamVolume(3, i2, 0);
                int i4 = (i2 * 100) / this.maxVolumeNumber;
                if (i4 == 0) {
                    MyPlaybackControlView.this.centerImage.setImageResource(R.drawable.ic_player_sound_0);
                } else if (i4 < 40) {
                    MyPlaybackControlView.this.centerImage.setImageResource(R.drawable.ic_player_sound1);
                } else if (i4 < 80) {
                    MyPlaybackControlView.this.centerImage.setImageResource(R.drawable.ic_player_sound2);
                } else {
                    MyPlaybackControlView.this.centerImage.setImageResource(R.drawable.ic_player_sound3);
                }
                MyPlaybackControlView.this.centerText.setText(i2 + BuildConfig.FLAVOR);
            }

            boolean isDefBigEnough(float f, float f2) {
                return ((double) ((f * f) + (f2 * f2))) > Math.pow((double) (this.metrics.density * 10.0f), 2.0d);
            }

            void setBrightness(float f) {
                WindowManager.LayoutParams attributes = ((Activity) MyPlaybackControlView.this.getContext()).getWindow().getAttributes();
                float f2 = this.firstBrightnessValue - ((f / 1000.0f) * this.metrics.density);
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                } else if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                attributes.screenBrightness = f2;
                ((Activity) MyPlaybackControlView.this.getContext()).getWindow().setAttributes(attributes);
                MyPlaybackControlView.this.brithnessChanged = true;
                MyPlaybackControlView.this.centerImage.setImageResource(R.drawable.ic_player_brightness);
                MyPlaybackControlView.this.centerText.setText(((int) (f2 * 100.0f)) + "%");
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MyLog.e("touchState", this.touchState + "build/generated/source/r");
                if (this.audioManager == null) {
                    Context context2 = MyPlaybackControlView.this.getContext();
                    MyPlaybackControlView.this.getContext();
                    AudioManager audioManager = (AudioManager) context2.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                    this.audioManager = audioManager;
                    this.maxVolumeNumber = audioManager.getStreamMaxVolume(3);
                    this.metrics = MyPlaybackControlView.this.getResources().getDisplayMetrics();
                }
                if (motionEvent.getAction() == 0) {
                    MyPlaybackControlView.this.centerLayout.setVisibility(0);
                    MyPlaybackControlView.this.centerImage.setImageResource(0);
                    MyPlaybackControlView.this.centerText.setText(BuildConfig.FLAVOR);
                    this.firstX = motionEvent.getX();
                    this.firstY = motionEvent.getY();
                    MyLog.e("motion", "Down");
                    this.touchState = TouchState.nothing;
                    this.hideAfterTouchUp = false;
                    return true;
                }
                if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX() - this.firstX;
                    float y = motionEvent.getY() - this.firstY;
                    if (isDefBigEnough(x, y) && MyPlaybackControlView.this.player != null && this.touchState == TouchState.nothing) {
                        MyPlaybackControlView myPlaybackControlView = MyPlaybackControlView.this;
                        if (!myPlaybackControlView.isLock && myPlaybackControlView.player.getDuration() > 0) {
                            MyPlaybackControlView myPlaybackControlView2 = MyPlaybackControlView.this;
                            if (myPlaybackControlView2.isCurrentFullScreen || myPlaybackControlView2.touchControllerAlwaysEnabled) {
                                if (Math.abs(x) > Math.abs(y)) {
                                    this.firstSeekPositon = MyPlaybackControlView.this.player.getCurrentPosition();
                                    this.touchState = TouchState.slidingHorizontal;
                                    if (!MyPlaybackControlView.this.isVisible()) {
                                        MyPlaybackControlView.this.show();
                                        this.hideAfterTouchUp = true;
                                    }
                                } else if (this.firstX > view.getWidth() / 2) {
                                    this.firstVolumePositon = this.audioManager.getStreamVolume(3);
                                    this.touchState = TouchState.slidingVerticalRight;
                                } else {
                                    float f = ((Activity) MyPlaybackControlView.this.getContext()).getWindow().getAttributes().screenBrightness;
                                    this.firstBrightnessValue = f;
                                    if (f < 0.0f) {
                                        this.firstBrightnessValue = 0.5f;
                                    }
                                    this.touchState = TouchState.slidingVerticalLeft;
                                }
                            }
                        }
                    }
                    if (this.touchState == TouchState.slidingHorizontal) {
                        MyPlaybackControlView.this.show();
                        seekPosition(x);
                    }
                    if (this.touchState == TouchState.slidingVerticalRight) {
                        setAudioVolume(y);
                    }
                    if (this.touchState == TouchState.slidingVerticalLeft) {
                        setBrightness(y);
                    }
                    MyLog.e("motion", "Move");
                    return true;
                }
                if (motionEvent.getAction() == 1) {
                    MyPlaybackControlView.this.centerLayout.setVisibility(4);
                    if (this.hideAfterTouchUp) {
                        MyPlaybackControlView.this.hide();
                    } else if (this.touchState == TouchState.nothing) {
                        if (MyPlaybackControlView.this.isVisible()) {
                            MyPlaybackControlView.this.hide();
                        } else {
                            MyPlaybackControlView.this.show();
                        }
                    }
                    MyLog.e("motion", "Up");
                }
                return true;
            }
        };
        this.lastSelectedQualityPosition = 0;
        this.lastSelectedSubtitlePosition = 0;
        this.onSettingItemListener = new View.OnClickListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyPlaybackControlView.this.dialog.dismiss();
                MyPlaybackControlView.this.hideAfterTimeout();
                SettingListAdapter.MyViewHolder myViewHolder = (SettingListAdapter.MyViewHolder) view.getTag();
                SettingItem settingItem = myViewHolder.item;
                SettingItem.SettingType settingType = settingItem.type;
                SettingItem.SettingType settingType2 = SettingItem.SettingType.fixedQualityItem;
                if (settingType == SettingItem.SettingType.smartQuality) {
                    MyPlaybackControlView myPlaybackControlView = MyPlaybackControlView.this;
                    myPlaybackControlView.lastSelectedQualityPosition = settingItem.position;
                    myPlaybackControlView.playObject.setting.quality_id = -1;
                }
                SettingItem settingItem2 = myViewHolder.item;
                if (settingItem2.type == SettingItem.SettingType.bookmark) {
                    MyPlaybackControlView.this.seekTo(settingItem2.bookmarkObject.location * 1000);
                }
                SettingItem.SettingType settingType3 = myViewHolder.item.type;
                SettingItem.SettingType settingType4 = SettingItem.SettingType.subtitleItem;
            }
        };
        this.onSettingItemDeleteListener = new View.OnClickListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingListAdapter.MyViewHolder myViewHolder = (SettingListAdapter.MyViewHolder) view.getTag();
                MyPlaybackControlView.this.playObject.bookmarkObjects.remove(myViewHolder.item.bookmarkObject);
                if (MyPlaybackControlView.this.playObject.bookmarkObjects.size() == 0) {
                    MyPlaybackControlView.this.dialog.dismiss();
                }
                if (MyPlaybackControlView.this.asemanPlayerListener != null) {
                    MyPlaybackControlView.this.asemanPlayerListener.onBookmarkRemoved(myViewHolder.item.bookmarkObject);
                }
            }
        };
        this.rewindMs = 5000;
        this.fastForwardMs = 15000;
        this.showTimeoutMs = 3500;
        if (attributeSet != null) {
            this.rewindMs = 5000;
            this.fastForwardMs = 15000;
            this.showTimeoutMs = 3500;
        }
        this.currentWindow = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.formatBuilder = sb;
        this.formatter = new Formatter(sb, Locale.getDefault());
        ComponentListener componentListener = new ComponentListener();
        this.componentListener = componentListener;
        this.seekDispatcher = DEFAULT_SEEK_DISPATCHER;
        LayoutInflater.from(context).inflate(R.layout.my_media_control, this);
        setDescendantFocusability(MessagesController.UPDATE_MASK_CHAT_MUTE);
        this.layoutPreview = (RelativeLayout) findViewById(R.id.layoutPreview);
        this.adsLayout = findViewById(R.id.layoutAds);
        View viewFindViewById = findViewById(R.id.centerLayout);
        this.centerLayout = viewFindViewById;
        viewFindViewById.setVisibility(4);
        this.centerImage = (ImageView) findViewById(R.id.imageViewCenter);
        this.centerText = (TextView) findViewById(R.id.textViewCenter);
        this.alertLayout = (CardView) findViewById(R.id.alertLayout);
        this.textViewAlert = (TextView) findViewById(R.id.textViewAlert);
        this.muteImageView = (ImageView) findViewById(R.id.imageViewMute);
        ImageView imageView = (ImageView) findViewById(R.id.retryImageView);
        this.retryImageView = imageView;
        imageView.setVisibility(4);
        this.durationView = (TextView) findViewById(R.id.exo_duration);
        this.positionView = (TextView) findViewById(R.id.exo_position);
        this.durationSlashView = (TextView) findViewById(R.id.durationSlash);
        this.positionViewPreview = (TextView) findViewById(R.id.position2);
        SeekBarWithPins seekBarWithPins = (SeekBarWithPins) findViewById(R.id.exo_progress);
        this.progressBar = seekBarWithPins;
        if (seekBarWithPins != null) {
            seekBarWithPins.setOnSeekBarChangeListener(componentListener);
            seekBarWithPins.setMax(CloseCodes.NORMAL_CLOSURE);
            seekBarWithPins.setKeyProgressIncrement(38);
            seekBarWithPins.setFocusable(true);
            seekBarWithPins.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById2 = findViewById(R.id.exo_play);
        this.playButton = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(componentListener);
            viewFindViewById2.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById3 = findViewById(R.id.exo_pause);
        this.pauseButton = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(componentListener);
            viewFindViewById3.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById4 = findViewById(R.id.exo_prev);
        this.previousButton = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(componentListener);
            viewFindViewById4.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById5 = findViewById(R.id.exo_next);
        this.nextButton = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(componentListener);
            viewFindViewById5.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById6 = findViewById(R.id.exo_rew);
        this.rewindButton = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(componentListener);
            viewFindViewById6.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById7 = findViewById(R.id.exo_ffwd);
        this.fastForwardButton = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(componentListener);
            viewFindViewById7.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById8 = findViewById(R.id.buttonBack15Second);
        this.back15SecButton = viewFindViewById8;
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(componentListener);
            viewFindViewById8.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById9 = findViewById(R.id.imageButtonLock);
        this.lockButton = viewFindViewById9;
        if (viewFindViewById9 != null) {
            viewFindViewById9.setOnClickListener(componentListener);
            viewFindViewById9.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById10 = findViewById(R.id.imageButtonUnlock);
        this.unLockButton = viewFindViewById10;
        if (viewFindViewById10 != null) {
            viewFindViewById10.setOnClickListener(componentListener);
            viewFindViewById10.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        View viewFindViewById11 = findViewById(R.id.imageButtonSettings);
        this.settingButton = viewFindViewById11;
        if (viewFindViewById11 != null) {
            viewFindViewById11.setOnClickListener(componentListener);
            viewFindViewById11.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.imageButtonFullScreen);
        this.fullScreenButton = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(componentListener);
            imageView2.setOnFocusChangeListener(this.onFocusChangeListener);
        }
        this.imageViewPreview = (ImageView) findViewById(R.id.imageViewPreview);
        this.adsImageView = (ImageView) findViewById(R.id.imageViewAds);
        this.skipButton = (TextView) findViewById(R.id.buttonSkip);
        this.buttonAdsLink = (TextView) findViewById(R.id.buttonAdsLink);
        this.circleProgressBar = (RingProgressBar) findViewById(R.id.circleProgress);
        this.loadingProgressBar = (FrameLayout) findViewById(R.id.progressBarLoadingFrame);
        View view = new View(context);
        view.setBackground(Theme.createServiceDrawable(AndroidUtilities.dp(18.0f), view, this));
        this.loadingProgressBar.addView(view, LayoutHelper.createFrame(36, 36, 17));
        RadialProgressView radialProgressView = new RadialProgressView(context);
        radialProgressView.setSize(AndroidUtilities.dp(28.0f));
        radialProgressView.setProgressColor(Theme.getColor(Theme.key_chat_serviceText));
        this.loadingProgressBar.addView(radialProgressView, LayoutHelper.createFrame(32, 32, 17));
        this.loadingProgressBar.setVisibility(4);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.touchHandlerLayout);
        this.linearLayoutTouchHandler = linearLayout;
        linearLayout.setOnTouchListener(this.onTouchListener);
        this.exoPlayerView = (PlayerView) findViewById(R.id.simpleExoPlayerViewAds);
        this.playBar = findViewById(R.id.playBar);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.navigationWidth = resources.getDimensionPixelSize(identifier);
        }
    }

    public ExoPlayer getPlayer() {
        return this.player;
    }

    public void setPlayer(ExoPlayer exoPlayer) {
        if (exoPlayer == null) {
            this.player = null;
            return;
        }
        ExoPlayer exoPlayer2 = this.player;
        if (exoPlayer2 == exoPlayer) {
            return;
        }
        if (exoPlayer2 != null) {
            exoPlayer2.removeListener(this.componentListener);
        }
        this.player = exoPlayer;
        exoPlayer.addListener(this.componentListener);
        updateAll();
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        this.visibilityListener = visibilityListener;
    }

    public void setSeekDispatcher(SeekDispatcher seekDispatcher) {
        if (seekDispatcher == null) {
            seekDispatcher = DEFAULT_SEEK_DISPATCHER;
        }
        this.seekDispatcher = seekDispatcher;
    }

    public void setRewindIncrementMs(int i) {
        this.rewindMs = i;
        updateNavigation();
    }

    public void setFastForwardIncrementMs(int i) {
        this.fastForwardMs = i;
        updateNavigation();
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public void setShowTimeoutMs(int i) {
        this.showTimeoutMs = i;
    }

    public void show() {
        if (this.playObject.isForInsta) {
            return;
        }
        if (this.isLock) {
            this.lockButton.setVisibility(0);
            hideAfterTimeout();
        } else if (!isVisible()) {
            toggleFullscreenSwitch(false);
            if (this.isCurrentFullScreen) {
                this.unLockButton.setVisibility(0);
            } else {
                this.unLockButton.setVisibility(4);
            }
            this.playBar.setVisibility(0);
            VisibilityListener visibilityListener = this.visibilityListener;
            if (visibilityListener != null) {
                visibilityListener.onVisibilityChange(getVisibility());
            }
            updateAll();
        }
        hideAfterTimeout();
    }

    public void hide() {
        this.lockButton.setVisibility(4);
        if (isVisible()) {
            toggleFullscreenSwitch(true);
            this.playBar.setVisibility(4);
            this.layoutPreview.setVisibility(4);
            this.unLockButton.setVisibility(4);
            VisibilityListener visibilityListener = this.visibilityListener;
            if (visibilityListener != null) {
                visibilityListener.onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.hideAction);
            this.hideAtMs = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return this.playBar.getVisibility() == 0 || (this.isLock && this.lockButton.getVisibility() == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAfterTimeout() {
        removeCallbacks(this.hideAction);
        if (this.showTimeoutMs > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            int i = this.showTimeoutMs;
            this.hideAtMs = jUptimeMillis + i;
            if (this.isAttachedToWindow) {
                postDelayed(this.hideAction, i);
                return;
            }
            return;
        }
        this.hideAtMs = -9223372036854775807L;
    }

    private void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayPauseButton() {
        ExoPlayer exoPlayer;
        if (isVisible() && this.isAttachedToWindow && (exoPlayer = this.player) != null) {
            boolean z = exoPlayer != null && exoPlayer.getPlayWhenReady();
            View view = this.playButton;
            if (view != null) {
                if (z) {
                    view.isFocused();
                }
                this.playButton.setVisibility(z ? 8 : 0);
            }
            View view2 = this.pauseButton;
            if (view2 != null) {
                if (!z) {
                    view2.isFocused();
                }
                this.pauseButton.setVisibility(z ? 0 : 8);
            }
            updateProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigation() {
        boolean z;
        boolean z2;
        boolean z3;
        if (isVisible() && this.isAttachedToWindow) {
            ExoPlayer exoPlayer = this.player;
            Timeline currentTimeline = exoPlayer != null ? exoPlayer.getCurrentTimeline() : null;
            if ((currentTimeline == null || currentTimeline.isEmpty()) ? false : true) {
                int currentWindowIndex = this.player.getCurrentWindowIndex();
                currentTimeline.getWindow(currentWindowIndex, this.currentWindow);
                Timeline.Window window = this.currentWindow;
                z3 = window.isSeekable;
                z2 = currentWindowIndex > 0 || z3 || !window.isDynamic;
                z = currentWindowIndex < currentTimeline.getWindowCount() - 1 || this.currentWindow.isDynamic;
            } else {
                z = false;
                z2 = false;
                z3 = false;
            }
            setButtonEnabled(z2, this.previousButton);
            setButtonEnabled(z, this.nextButton);
            setButtonEnabled(this.fastForwardMs > 0 && z3, this.fastForwardButton);
            setButtonEnabled(this.rewindMs > 0 && z3, this.rewindButton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePins() {
        PlayObject playObject = this.playObject;
        if (playObject == null || playObject.adsObjectArrayList == null) {
            return;
        }
        ArrayList<PinObject> arrayList = new ArrayList<>();
        Iterator<AdsObject> it = this.playObject.adsObjectArrayList.iterator();
        while (it.hasNext()) {
            int iProgressBarValue = progressBarValue(it.next().time_location * CloseCodes.NORMAL_CLOSURE);
            PinObject pinObject = new PinObject();
            pinObject.location = iProgressBarValue;
            pinObject.color = -1114303;
            arrayList.add(pinObject);
        }
        Iterator<BookmarkObject> it2 = this.playObject.bookmarkObjects.iterator();
        while (it2.hasNext()) {
            int iProgressBarValue2 = progressBarValue(it2.next().location * 1000);
            PinObject pinObject2 = new PinObject();
            pinObject2.location = iProgressBarValue2;
            pinObject2.color = -1684967;
            pinObject2.drawonTop = true;
            pinObject2.pinShape = PinObject.PinShape.circle;
            arrayList.add(pinObject2);
        }
        if (this.player.getDuration() > 0) {
            this.progressBar.setPins(arrayList);
        }
    }

    void hideAds() {
        try {
            this.linearLayoutTouchHandler.setVisibility(0);
            this.adsLayout.setVisibility(4);
            if (this.playerStateObjectEmitter != null) {
                PlayerStateObject playerStateObject = new PlayerStateObject();
                playerStateObject.state = PlayerStateObject.PlayerStateEnum.stopAds;
                this.playerStateObjectEmitter.onNext(playerStateObject);
            }
            this.exoPlayerView.setVisibility(4);
            removeCallbacks(this.adsCallback);
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.setPlayWhenReady(true);
            }
            this.adsImageView.setVisibility(8);
            this.skipButton.setVisibility(8);
            this.buttonAdsLink.setVisibility(8);
            this.circleProgressBar.setVisibility(8);
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    void showAdsObject(final AdsObject adsObject) {
        Link link;
        this.adsLayout.setVisibility(0);
        this.adsLayout.setOnClickListener(new View.OnClickListener(this) { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.linearLayoutTouchHandler.setVisibility(4);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.adsCallback = new Runnable() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.9
            @Override // java.lang.Runnable
            public void run() {
                int currentPosition;
                Link link2;
                if (MyPlaybackControlView.this.player != null) {
                    MyPlaybackControlView.this.player.setPlayWhenReady(false);
                }
                MyLog.e("skip time", (System.currentTimeMillis() - jCurrentTimeMillis) + "  ? " + (adsObject.skip_duration * CloseCodes.NORMAL_CLOSURE));
                if (System.currentTimeMillis() - jCurrentTimeMillis > adsObject.skip_duration * CloseCodes.NORMAL_CLOSURE) {
                    MyLog.e("visible skip button", "skip visible");
                    MyPlaybackControlView.this.skipButton.setVisibility(0);
                    MyPlaybackControlView.this.skipButton.setAlpha(1.0f);
                    MyPlaybackControlView.this.skipButton.setEnabled(true);
                    MyPlaybackControlView.this.skipButton.setText("بستن تبلیغ");
                } else {
                    MyPlaybackControlView.this.skipButton.setVisibility(0);
                    MyPlaybackControlView.this.skipButton.setEnabled(false);
                    MyPlaybackControlView.this.skipButton.setAlpha(0.6f);
                    long jCurrentTimeMillis2 = ((((System.currentTimeMillis() - jCurrentTimeMillis) - (adsObject.skip_duration * CloseCodes.NORMAL_CLOSURE)) * (-1)) / 1000) + 1;
                    TextView textView = MyPlaybackControlView.this.skipButton;
                    StringBuilder sb = new StringBuilder();
                    sb.append("بستن تبلیغ(");
                    sb.append(NumberUtils.toPersian(jCurrentTimeMillis2 + BuildConfig.FLAVOR));
                    sb.append(")");
                    textView.setText(sb.toString());
                }
                AdsObject adsObject2 = adsObject;
                if (adsObject2.has_link && (link2 = adsObject2.link) != null && link2.type != Link.LinkTypeEnum.none) {
                    MyLog.e("visible skip button", "skip visible");
                    MyPlaybackControlView.this.buttonAdsLink.setVisibility(0);
                    String str = adsObject.link_text;
                    if (str != null) {
                        MyPlaybackControlView.this.buttonAdsLink.setText(str);
                    } else {
                        MyPlaybackControlView.this.buttonAdsLink.setText("کلیک کنید");
                    }
                } else {
                    MyPlaybackControlView.this.buttonAdsLink.setVisibility(8);
                }
                if (adsObject.type == AdsObject.AdsType.image) {
                    RingProgressBar ringProgressBar = MyPlaybackControlView.this.circleProgressBar;
                    ringProgressBar.setProgress(ringProgressBar.getProgress() + 1);
                }
                if (adsObject.type == AdsObject.AdsType.video && MyPlaybackControlView.this.playerAds.getDuration() > 0) {
                    try {
                        if (MyPlaybackControlView.this.playerAds.getDuration() > 0 && (currentPosition = (int) ((MyPlaybackControlView.this.playerAds.getCurrentPosition() * 100.0f) / MyPlaybackControlView.this.playerAds.getDuration())) > 0) {
                            MyPlaybackControlView.this.circleProgressBar.setProgress(currentPosition);
                        }
                    } catch (Exception unused) {
                    }
                }
                if (MyPlaybackControlView.this.circleProgressBar.getProgress() == 100) {
                    MyPlaybackControlView.this.hideAds();
                    MyPlaybackControlView.this.circleProgressBar.setVisibility(4);
                } else {
                    MyPlaybackControlView myPlaybackControlView = MyPlaybackControlView.this;
                    myPlaybackControlView.postDelayed(myPlaybackControlView.adsCallback, adsObject.totalDuration * 10);
                }
            }
        };
        AdsObject.AdsType adsType = adsObject.type;
        if (adsType == AdsObject.AdsType.image) {
            try {
                Glide.with(getContext()).load(adsObject.url).into(this.adsImageView);
                hide();
            } catch (Exception unused) {
            }
        } else if (adsType == AdsObject.AdsType.video) {
            Handler handler = new Handler();
            SimpleExoPlayer simpleExoPlayerNewSimpleInstance = ExoPlayerFactory.newSimpleInstance(getContext(), new DefaultTrackSelector(new AdaptiveTrackSelection.Factory()));
            this.playerAds = simpleExoPlayerNewSimpleInstance;
            this.exoPlayerView.setPlayer(simpleExoPlayerNewSimpleInstance);
            this.exoPlayerView.setUseController(false);
            ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(Uri.parse(adsObject.url), new DefaultDataSourceFactory(getContext(), Util.getUserAgent(getContext(), "AsemanVideoPlayer"), new DefaultBandwidthMeter()), new DefaultExtractorsFactory(), handler, null);
            this.player.setPlayWhenReady(false);
            this.playerAds.prepare(extractorMediaSource);
            this.playerAds.setPlayWhenReady(true);
            this.circleProgressBar.setVisibility(0);
            this.skipButton.setVisibility(0);
            this.skipButton.setEnabled(false);
            this.skipButton.setAlpha(0.6f);
            if (adsObject.has_link && (link = adsObject.link) != null && link.type != Link.LinkTypeEnum.none) {
                this.buttonAdsLink.setVisibility(0);
                String str = adsObject.link_text;
                if (str != null) {
                    this.buttonAdsLink.setText(str);
                } else {
                    this.buttonAdsLink.setText("کلیک کنید");
                }
                this.buttonAdsLink.setOnClickListener(new View.OnClickListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ArrayList<String> arrayList = adsObject.click_calls;
                        if (arrayList != null) {
                            Iterator<String> it = arrayList.iterator();
                            while (it.hasNext()) {
                                ApiRequest.getInstance().callUrl(it.next());
                            }
                        }
                        if (ApplicationLoader.applicationActivity != null) {
                            MyPlaybackControlView.this.hideAds();
                            new MainClickHandler().onLinkClick(ApplicationLoader.applicationActivity.getLastFragment(), adsObject.link);
                        }
                    }
                });
            }
            this.exoPlayerView.setVisibility(0);
            this.playerAds.addListener(new Player.EventListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.11
                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
                    Player.EventListener.CC.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onIsLoadingChanged(boolean z) {
                    onLoadingChanged(z);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onIsPlayingChanged(boolean z) {
                    Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onLoadingChanged(boolean z) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
                    Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                    Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onPlaybackStateChanged(int i) {
                    Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                    Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onPositionDiscontinuity(int i) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onRepeatModeChanged(int i) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onSeekProcessed() {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onShuffleModeEnabledChanged(boolean z) {
                }

                /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
                /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                    Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onTimelineChanged(Timeline timeline, Object obj, int i) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onPlayerStateChanged(boolean z, int i) {
                    if (i != 3) {
                        if (i == 4) {
                            ArrayList<String> arrayList = adsObject.complete_calls;
                            if (arrayList != null) {
                                Iterator<String> it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ApiRequest.getInstance().callUrl(it.next());
                                }
                            }
                            MyPlaybackControlView.this.hideAds();
                            return;
                        }
                        return;
                    }
                    if (MyPlaybackControlView.this.playerStateObjectEmitter != null) {
                        PlayerStateObject playerStateObject = new PlayerStateObject();
                        playerStateObject.state = PlayerStateObject.PlayerStateEnum.playAds;
                        MyPlaybackControlView.this.playerStateObjectEmitter.onNext(playerStateObject);
                    }
                    MyPlaybackControlView.this.circleProgressBar.setVisibility(0);
                    MyPlaybackControlView.this.exoPlayerView.setVisibility(0);
                    ArrayList<String> arrayList2 = adsObject.start_calls;
                    if (arrayList2 != null) {
                        Iterator<String> it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            ApiRequest.getInstance().callUrl(it2.next());
                        }
                    }
                    MyPlaybackControlView.this.hide();
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onPlayerError(ExoPlaybackException exoPlaybackException) {
                    if (MyPlaybackControlView.this.playerStateObjectEmitter != null) {
                        PlayerStateObject playerStateObject = new PlayerStateObject();
                        playerStateObject.state = PlayerStateObject.PlayerStateEnum.errorAds;
                        MyPlaybackControlView.this.playerStateObjectEmitter.onNext(playerStateObject);
                    }
                }
            });
        }
        AdsObject.AdsType adsType2 = adsObject.type;
        AdsObject.AdsType adsType3 = AdsObject.AdsType.image;
        if (adsType2 == adsType3) {
            this.adsImageView.setVisibility(0);
            this.circleProgressBar.setVisibility(0);
        }
        this.circleProgressBar.setProgress(0);
        removeCallbacks(this.adsCallback);
        this.skipButton.setOnClickListener(new View.OnClickListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList<String> arrayList = adsObject.skip_calls;
                if (arrayList != null) {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ApiRequest.getInstance().callUrl(it.next());
                    }
                }
                MyPlaybackControlView.this.hideAds();
            }
        });
        if (adsObject.type == adsType3) {
            this.player.setPlayWhenReady(false);
            postDelayed(this.adsCallback, 300L);
        }
        if (adsObject.type == AdsObject.AdsType.video) {
            this.player.setPlayWhenReady(false);
            postDelayed(this.adsCallback, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        PlayObject playObject;
        PlayObject.Setting setting;
        int i;
        ExoPlayer exoPlayer;
        ExoPlayer exoPlayer2;
        PlayObject playObject2 = this.playObject;
        if (playObject2 != null && (exoPlayer2 = this.player) != null && playObject2.endTimeForInsta > 0) {
            long currentPosition = exoPlayer2.getCurrentPosition();
            PlayObject playObject3 = this.playObject;
            if (currentPosition > playObject3.endTimeForInsta) {
                this.player.seekTo(playObject3.startTimeForInsta);
            }
        }
        long j = 1000;
        if (this.playObject != null && getContext() != null && (exoPlayer = this.player) != null && this.playObject.adsObjectArrayList != null) {
            int currentPosition2 = (int) (exoPlayer.getCurrentPosition() / 1000);
            Iterator<AdsObject> it = this.playObject.adsObjectArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdsObject next = it.next();
                int i2 = next.time_location;
                if (currentPosition2 >= i2 && currentPosition2 < next.totalDuration + i2 && !next.isShowed) {
                    next.isShowed = true;
                    showAdsObject(next);
                    break;
                }
            }
        }
        if (!this.isShowedAlertOneTime) {
            this.isShowedAlertOneTime = true;
            PlayObject.AlertObject alertObject = this.playObject.alert;
        }
        if (this.isShowingAlert) {
            try {
                long currentPosition3 = this.player.getCurrentPosition() / 1000;
                PlayObject.AlertObject alertObject2 = this.playObject.alert;
                throw null;
            } catch (Exception unused) {
            }
        }
        if (!this.isAttachedToWindow) {
            MyLog.e("detach", "deeeee");
            return;
        }
        ExoPlayer exoPlayer3 = this.player;
        long duration = exoPlayer3 == null ? 0L : exoPlayer3.getDuration();
        if (duration <= 0) {
            long j2 = this.lastDuration;
            if (j2 != 0) {
                duration = j2;
            }
        }
        if (duration > 0) {
            this.lastDuration = duration;
        }
        ExoPlayer exoPlayer4 = this.player;
        long currentPosition4 = exoPlayer4 == null ? 0L : exoPlayer4.getCurrentPosition();
        if (currentPosition4 == 0 && (playObject = this.playObject) != null && (setting = playObject.setting) != null && (i = setting.startTime) > 0) {
            currentPosition4 = i * CloseCodes.NORMAL_CLOSURE;
        }
        if (this.isLive) {
            long j3 = duration - currentPosition4;
            if (Math.abs(j3) < 60000) {
                this.positionView.setText("پخش زنده");
            } else {
                this.positionView.setText("- " + stringForTime(j3));
            }
            this.durationSlashView.setText(BuildConfig.FLAVOR);
            this.durationView.setText(BuildConfig.FLAVOR);
        } else {
            this.durationSlashView.setText("/");
            TextView textView = this.durationView;
            if (textView != null) {
                textView.setText(stringForTime(duration));
            }
            TextView textView2 = this.positionView;
            if (textView2 != null && !this.dragging) {
                textView2.setText(stringForTime(currentPosition4));
            }
        }
        if (this.progressBar != null) {
            if (!this.dragging) {
                setViewStream(currentPosition4);
                if (this.player != null) {
                    this.progressBar.setProgress(progressBarValue(currentPosition4));
                }
            }
            ExoPlayer exoPlayer5 = this.player;
            if (exoPlayer5 != null) {
                exoPlayer5.getBufferedPosition();
            }
        }
        removeCallbacks(this.updateProgressAction);
        ExoPlayer exoPlayer6 = this.player;
        int playbackState = exoPlayer6 == null ? 1 : exoPlayer6.getPlaybackState();
        if (playbackState == 1 || playbackState == 4) {
            return;
        }
        if (this.player.getPlayWhenReady() && playbackState == 3) {
            long j4 = 1000 - (currentPosition4 % 1000);
            j = j4 < 200 ? 1000 + j4 : j4;
        }
        postDelayed(this.updateProgressAction, j);
    }

    private void setViewStream(long j) {
        if (this.playObject.viewId.equals(BuildConfig.FLAVOR)) {
            return;
        }
        int i = this.counter + 1;
        this.counter = i;
        if (i > 30) {
            this.counter = 0;
            ViewStreamInput viewStreamInput = new ViewStreamInput();
            viewStreamInput.view_id = this.playObject.viewId;
            viewStreamInput.view_point = (j / 1000) + BuildConfig.FLAVOR;
            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).viewStream(viewStreamInput, new ApiRequestIPTV.Listener(this) { // from class: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.13
                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                public void onFailure(Call call, Throwable th) {
                }

                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                public void onResponse(Call call, Response response) {
                }
            });
        }
    }

    private void setButtonEnabled(boolean z, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        if (Util.SDK_INT >= 11) {
            setViewAlphaV11(view, z ? 1.0f : 0.3f);
            view.setVisibility(0);
        } else {
            view.setVisibility(z ? 0 : 4);
        }
    }

    private void setViewAlphaV11(View view, float f) {
        view.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String stringForTime(long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j2 = (j + 500) / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        this.formatBuilder.setLength(0);
        return j5 > 0 ? this.formatter.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : this.formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
    }

    private int progressBarValue(long j) {
        PlayObject playObject;
        PlayObject.Setting setting;
        int i;
        ExoPlayer exoPlayer = this.player;
        long duration = exoPlayer == null ? -9223372036854775807L : exoPlayer.getDuration();
        if (duration <= 0) {
            long j2 = this.lastDuration;
            if (j2 > 0) {
                duration = j2;
            }
        }
        if (j == 0 && (playObject = this.playObject) != null && (setting = playObject.setting) != null && (i = setting.startTime) > 0) {
            j = i * CloseCodes.NORMAL_CLOSURE;
        }
        if (duration == -9223372036854775807L || duration == 0) {
            return 0;
        }
        return (int) ((j * 1000) / duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long positionValue(int i) {
        ExoPlayer exoPlayer = this.player;
        long duration = exoPlayer == null ? -9223372036854775807L : exoPlayer.getDuration();
        if (duration <= 0) {
            long j = this.lastDuration;
            if (j > 0) {
                duration = j;
            }
        }
        if (duration == -9223372036854775807L) {
            return 0L;
        }
        return (duration * i) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        if (r0.isSeekable == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void previous() {
        /*
            r6 = this;
            com.google.android.exoplayer2.ExoPlayer r0 = r6.player
            com.google.android.exoplayer2.Timeline r0 = r0.getCurrentTimeline()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto Ld
            return
        Ld:
            com.google.android.exoplayer2.ExoPlayer r1 = r6.player
            int r1 = r1.getCurrentWindowIndex()
            com.google.android.exoplayer2.Timeline$Window r2 = r6.currentWindow
            r0.getWindow(r1, r2)
            if (r1 <= 0) goto L3b
            com.google.android.exoplayer2.ExoPlayer r0 = r6.player
            long r2 = r0.getCurrentPosition()
            r4 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L30
            com.google.android.exoplayer2.Timeline$Window r0 = r6.currentWindow
            boolean r2 = r0.isDynamic
            if (r2 == 0) goto L3b
            boolean r0 = r0.isSeekable
            if (r0 != 0) goto L3b
        L30:
            int r1 = r1 + (-1)
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.seekTo(r1, r2)
            goto L40
        L3b:
            r0 = 0
            r6.seekTo(r0)
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.previous():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void back15sec() {
        if (this.player.getCurrentPosition() > 10000) {
            seekTo(this.player.getCurrentPosition() - 10000);
        } else {
            seekTo(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return;
        }
        int currentWindowIndex = this.player.getCurrentWindowIndex();
        if (currentWindowIndex < currentTimeline.getWindowCount() - 1) {
            seekTo(currentWindowIndex + 1, -9223372036854775807L);
        } else if (currentTimeline.getWindow(currentWindowIndex, this.currentWindow, false).isDynamic) {
            seekTo(currentWindowIndex, -9223372036854775807L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.rewindMs <= 0) {
            return;
        }
        seekTo(Math.max(this.player.getCurrentPosition() - this.rewindMs, 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.fastForwardMs <= 0) {
            return;
        }
        long duration = this.player.getDuration();
        if (duration <= 0) {
            long j = this.lastDuration;
            if (j > 0) {
                duration = j;
            }
        }
        seekTo(Math.min(this.player.getCurrentPosition() + this.fastForwardMs, duration));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unLock() {
        this.isLock = false;
        this.lockButton.setVisibility(4);
        this.unLockButton.setVisibility(0);
        show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lock() {
        this.isLock = true;
        this.lockButton.setVisibility(0);
        this.unLockButton.setVisibility(4);
        hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekTo(long j) {
        seekTo(this.player.getCurrentWindowIndex(), j);
    }

    private void seekTo(int i, long j) {
        if (this.seekDispatcher.dispatchSeek(this.player, i, j)) {
            return;
        }
        updateProgress();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        long j = this.hideAtMs;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.hideAction, jUptimeMillis);
            }
        }
        if (this.player != null) {
            updateAll();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        removeCallbacks(this.hideAction);
        removeCallbacks(this.hideInstaVolum);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        if (z) {
            show();
        }
        return z;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.player == null || !isHandledMediaKey(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 85) {
                this.player.setPlayWhenReady(!r4.getPlayWhenReady());
            } else if (keyCode == 126) {
                this.player.setPlayWhenReady(true);
            } else if (keyCode == 127) {
                this.player.setPlayWhenReady(false);
            } else {
                switch (keyCode) {
                    case 87:
                        next();
                        break;
                    case 88:
                        previous();
                        break;
                    case 89:
                        rewind();
                        break;
                    case 90:
                        fastForward();
                        break;
                }
            }
        }
        show();
        return true;
    }

    private final class ComponentListener implements Player.EventListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener {
        long lastVideoPreviewShowed;

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            onLoadingChanged(z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onLoadingChanged(boolean z) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackStateChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onSeekProcessed() {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
        }

        /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
        /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        }

        private ComponentListener() {
            this.lastVideoPreviewShowed = 0L;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            MyPlaybackControlView myPlaybackControlView = MyPlaybackControlView.this;
            myPlaybackControlView.removeCallbacks(myPlaybackControlView.hideAction);
            MyPlaybackControlView.this.dragging = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            long jPositionValue = MyPlaybackControlView.this.positionValue(i);
            if (!z) {
                if (System.currentTimeMillis() - this.lastVideoPreviewShowed > 2500) {
                    MyPlaybackControlView.this.layoutPreview.setVisibility(4);
                    return;
                }
                return;
            }
            MyLog.e("progress Changed", "changed");
            if (MyPlaybackControlView.this.isShowVideoPreview && MyPlaybackControlView.this.isCurrentFullScreen) {
                MyLog.e("progress Changed", "preview" + MyPlaybackControlView.this.isShowVideoPreview);
                MyPlaybackControlView.this.setReleventPreview(seekBar);
                MyPlaybackControlView.this.layoutPreview.setVisibility(0);
                this.lastVideoPreviewShowed = System.currentTimeMillis();
            }
            if (MyPlaybackControlView.this.isLive) {
                if (Math.abs(MyPlaybackControlView.this.getPlayer().getDuration() - jPositionValue) < 60000) {
                    MyPlaybackControlView.this.positionView.setText("پخش زنده");
                } else {
                    TextView textView = MyPlaybackControlView.this.positionView;
                    StringBuilder sb = new StringBuilder();
                    sb.append("- ");
                    MyPlaybackControlView myPlaybackControlView = MyPlaybackControlView.this;
                    sb.append(myPlaybackControlView.stringForTime(myPlaybackControlView.getPlayer().getDuration() - jPositionValue));
                    textView.setText(sb.toString());
                }
                MyPlaybackControlView.this.durationSlashView.setText(BuildConfig.FLAVOR);
                MyPlaybackControlView.this.durationView.setText(BuildConfig.FLAVOR);
            } else {
                MyPlaybackControlView.this.positionView.setText(MyPlaybackControlView.this.stringForTime(jPositionValue));
                MyPlaybackControlView.this.positionViewPreview.setText(MyPlaybackControlView.this.stringForTime(jPositionValue));
            }
            if (MyPlaybackControlView.this.player != null && !MyPlaybackControlView.this.dragging) {
                MyPlaybackControlView.this.seekTo(jPositionValue);
            }
            if (MyPlaybackControlView.this.player == null || MyPlaybackControlView.this.player.getPlaybackState() != 1 || MyPlaybackControlView.this.playObject == null || MyPlaybackControlView.this.playObject.setting == null) {
                return;
            }
            MyPlaybackControlView.this.playObject.setting.startTime = (int) (MyPlaybackControlView.this.player.getContentPosition() / 1000);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            MyPlaybackControlView.this.layoutPreview.setVisibility(4);
            MyPlaybackControlView.this.dragging = false;
            if (MyPlaybackControlView.this.player != null) {
                MyPlaybackControlView myPlaybackControlView = MyPlaybackControlView.this;
                myPlaybackControlView.seekTo(myPlaybackControlView.positionValue(seekBar.getProgress()));
            }
            MyPlaybackControlView.this.hideAfterTimeout();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            MyPlaybackControlView myPlaybackControlView = MyPlaybackControlView.this;
            FrameLayout frameLayout = myPlaybackControlView.loadingProgressBar;
            if (frameLayout != null) {
                if (i == 2) {
                    if (myPlaybackControlView.playObject != null && MyPlaybackControlView.this.playObject.isForExplore) {
                        MyPlaybackControlView.this.loadingProgressBar.setVisibility(4);
                    } else {
                        MyPlaybackControlView.this.loadingProgressBar.setVisibility(0);
                    }
                } else if (i == 3) {
                    frameLayout.setVisibility(4);
                }
            }
            MyPlaybackControlView.this.updatePlayPauseButton();
            MyPlaybackControlView.this.updateProgress();
            MyPlaybackControlView.this.updatePins();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj, int i) {
            MyPlaybackControlView.this.updateNavigation();
            MyPlaybackControlView.this.updateProgress();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MyPlaybackControlView.this.player != null) {
                if (MyPlaybackControlView.this.nextButton == view) {
                    MyPlaybackControlView.this.next();
                } else if (MyPlaybackControlView.this.previousButton == view) {
                    MyPlaybackControlView.this.previous();
                } else if (MyPlaybackControlView.this.fastForwardButton == view) {
                    MyPlaybackControlView.this.fastForward();
                } else if (MyPlaybackControlView.this.rewindButton == view) {
                    MyPlaybackControlView.this.rewind();
                } else if (MyPlaybackControlView.this.playButton == view) {
                    MyPlaybackControlView.this.player.setPlayWhenReady(true);
                } else if (MyPlaybackControlView.this.pauseButton == view) {
                    MyPlaybackControlView.this.player.setPlayWhenReady(false);
                } else if (MyPlaybackControlView.this.back15SecButton == view) {
                    MyPlaybackControlView.this.back15sec();
                } else if (MyPlaybackControlView.this.lockButton == view) {
                    MyPlaybackControlView.this.unLock();
                } else if (MyPlaybackControlView.this.unLockButton == view) {
                    MyPlaybackControlView.this.lock();
                } else if (MyPlaybackControlView.this.settingButton == view) {
                    MyPlaybackControlView.this.showSettings();
                } else if (MyPlaybackControlView.this.fullScreenButton == view) {
                    MyPlaybackControlView myPlaybackControlView = MyPlaybackControlView.this;
                    if (!myPlaybackControlView.isCurrentFullScreen) {
                        myPlaybackControlView.fullScreenButton.setImageResource(R.drawable.ic_playe_exit_fullscreen);
                        MyPlaybackControlView.this.showVideoInFullScreen();
                    } else {
                        myPlaybackControlView.showVideoInNormalMode();
                        MyPlaybackControlView.this.fullScreenButton.setImageResource(R.drawable.ic_playe_fullscreen);
                    }
                }
            }
            MyPlaybackControlView.this.hideAfterTimeout();
        }
    }

    public void showVideoInFullScreen() {
        Window window = ((Activity) getContext()).getWindow();
        window.setFlags(134217728, 134217728);
        window.setFlags(ConnectionsManager.FileTypeFile, ConnectionsManager.FileTypeFile);
        this.playBar.setPadding(0, 0, this.navigationWidth, 0);
        toggleFullscreenSwitch(true);
        View view = (View) getParent().getParent();
        MyLog.e("ContentValues", "showVideoInFullScreen: " + getParent());
        MyLog.e("ContentValues", "showVideoInFullScreen: " + getParent().getParent());
        view.setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.removeView(view);
        MyLog.e("ContentValues", "showVideoInFullScreen: " + getParent().getParent());
        this.normalScreenLayout = viewGroup;
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView().getRootView()).addView(view);
        view.setVisibility(0);
        this.isCurrentFullScreen = true;
        if (isVisible()) {
            hide();
            show();
        } else {
            show();
            hide();
        }
        this.fullScreenButton.setImageResource(R.drawable.ic_playe_exit_fullscreen);
        lockOrientationLandscape();
    }

    public void showVideoInNormalMode() {
        this.playBar.setPadding(0, 0, 0, 0);
        Window window = ((Activity) getContext()).getWindow();
        window.clearFlags(134217728);
        window.clearFlags(ConnectionsManager.FileTypeFile);
        toggleFullscreenSwitch(false);
        this.isCurrentFullScreen = false;
        View view = (View) getParent().getParent();
        ((ViewGroup) view.getParent()).removeView(view);
        this.normalScreenLayout.addView(view);
        this.fullScreenButton.setImageResource(R.drawable.ic_playe_fullscreen);
        this.unLockButton.setVisibility(4);
        unlockOrientation();
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.applyTheme();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSettings() {
        try {
            this.positionWhenClickedOnSetting = this.player.getContentPosition();
            SettingsDialog settingsDialog = new SettingsDialog((Activity) getContext(), this);
            this.dialog = settingsDialog;
            settingsDialog.show();
            removeCallbacks(this.hideAction);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReleventPreview(SeekBar seekBar) {
        long jPositionValue = positionValue(seekBar.getProgress()) / 1000;
        Iterator<ThumbnailItem> it = this.playObject.thumbnailItems.iterator();
        ThumbnailItem thumbnailItem = null;
        int count = 0;
        while (it.hasNext()) {
            ThumbnailItem next = it.next();
            MyLog.e("getRelevant thumbnail", jPositionValue + " " + next.startTime + " " + next.endTime + " " + count);
            if (next.startTime <= jPositionValue && next.endTime >= jPositionValue) {
                thumbnailItem = next;
            } else if (next.endTime < jPositionValue) {
                count += next.getCount();
            }
        }
        MyLog.e("relevant thumbnail:", thumbnailItem + " fffffff");
        if (thumbnailItem == null) {
            return;
        }
        int i = thumbnailItem.startTime;
        long j = jPositionValue - i;
        int i2 = thumbnailItem.endTime;
        if (i2 - i == 0) {
            thumbnailItem.endTime = i2 + 1;
        }
        int count2 = count + ((int) ((thumbnailItem.getCount() * j) / (thumbnailItem.endTime - thumbnailItem.startTime)));
        MyLog.e("getRelevant thumbnail", NotificationBadge.NewHtcHomeBadger.COUNT + count2 + " " + this.thumbnailsDiscreteScrollView.getAdapter().getItemCount() + " " + j + " ");
        if (count2 < this.thumbnailsDiscreteScrollView.getAdapter().getItemCount()) {
            this.thumbnailsDiscreteScrollView.scrollToPosition(count2);
        }
    }

    private void toggleFullscreenSwitch(boolean z) {
        if (this.isCurrentFullScreen) {
            int i = Build.VERSION.SDK_INT;
            WindowManager.LayoutParams attributes = ((Activity) getContext()).getWindow().getAttributes();
            if (!z) {
                ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(0);
                attributes.flags &= -1025;
                ((Activity) getContext()).getWindow().setAttributes(attributes);
            } else {
                if (i >= 19) {
                    ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(5382);
                    return;
                }
                ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(2);
                attributes.flags |= 1024;
                ((Activity) getContext()).getWindow().setAttributes(attributes);
            }
        }
    }

    public void lockOrientationLandscape() {
        ((Activity) getContext()).setRequestedOrientation(6);
    }

    public void unlockOrientation() {
        ((Activity) getContext()).setRequestedOrientation(-1);
    }

    SettingListAdapter getVideoQualityAdapter() {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        SettingItem settingItem = new SettingItem();
        settingItem.type = SettingItem.SettingType.smartQuality;
        settingItem.name = "انتخاب هوشمند";
        settingItem.position = 0;
        arrayList.add(settingItem);
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector != null && (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) != null) {
            for (int i = 0; i < currentMappedTrackInfo.length; i++) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
                if (trackGroups.length != 0 && this.player.getRendererType(i) == 2) {
                    TrackGroup trackGroup = trackGroups.get(0);
                    int i2 = 0;
                    while (i2 < trackGroup.length) {
                        SettingItem settingItem2 = new SettingItem();
                        settingItem2.type = SettingItem.SettingType.fixedQualityItem;
                        settingItem2.name = trackGroup.getFormat(i2).height + "p";
                        Iterator<QualityObject> it = this.playObject.qualityObjects.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            QualityObject next = it.next();
                            if (next.id == i2) {
                                settingItem2.name = next.title;
                                StringBuilder sb = new StringBuilder();
                                sb.append(next.id);
                                sb.append(BuildConfig.FLAVOR);
                                break;
                            }
                        }
                        int i3 = i2 + 1;
                        settingItem2.position = i3;
                        if (trackGroup.getFormat(i2).height > 10) {
                            arrayList.add(settingItem2);
                        }
                        i2 = i3;
                    }
                }
            }
        }
        int size = arrayList.size();
        int i4 = this.lastSelectedQualityPosition;
        if (size > i4) {
            ((SettingItem) arrayList.get(i4)).isSelected = true;
        }
        return new SettingListAdapter((Activity) getContext(), arrayList, this.onSettingItemListener, null);
    }

    SettingListAdapter getVideoSubtitleAdapter() {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector != null && (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) != null) {
            for (int i = 0; i < currentMappedTrackInfo.length; i++) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
                if (trackGroups.length != 0 && this.player.getRendererType(i) == 3) {
                    MyLog.e("trackGropus Subtitle", trackGroups.length + " " + trackGroups.toString());
                    for (int i2 = 0; i2 < trackGroups.length; i2++) {
                        SettingItem settingItem = new SettingItem();
                        settingItem.type = SettingItem.SettingType.subtitleItem;
                        if (trackGroups.get(i2).getFormat(0).language != null) {
                            settingItem.name = trackGroups.get(i2).getFormat(0).language + " ";
                            String str = trackGroups.get(i2).getFormat(0).id;
                        } else {
                            settingItem.name = "عدم نمایش زیرنویس ";
                        }
                        settingItem.position = i2;
                        arrayList.add(settingItem);
                    }
                }
            }
        }
        int size = arrayList.size();
        int i3 = this.lastSelectedSubtitlePosition;
        if (size > i3) {
            ((SettingItem) arrayList.get(i3)).isSelected = true;
        }
        return new SettingListAdapter((Activity) getContext(), arrayList, this.onSettingItemListener, null);
    }

    SettingListAdapter getBookmarkAdapter() {
        ArrayList arrayList = new ArrayList();
        Iterator<BookmarkObject> it = this.playObject.bookmarkObjects.iterator();
        while (it.hasNext()) {
            BookmarkObject next = it.next();
            SettingItem settingItem = new SettingItem();
            settingItem.name = next.text;
            settingItem.type = SettingItem.SettingType.bookmark;
            settingItem.bookmarkObject = next;
            arrayList.add(settingItem);
        }
        return new SettingListAdapter((Activity) getContext(), arrayList, this.onSettingItemListener, this.onSettingItemDeleteListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        MyLog.e("dispach keyyy", "dispatchKeyEventPreIme(" + keyEvent + ")");
        if (keyEvent.getKeyCode() == 4 && (keyDispatcherState = getKeyDispatcherState()) != null) {
            MyLog.e("dispach keyyy", "dispatchKeyEventPreIme state != null");
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            }
            if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                keyDispatcherState.isTracking(keyEvent);
            }
        }
        return true;
    }

    public boolean consumeBackPress() {
        if (!this.isLock) {
            return false;
        }
        show();
        Toast.makeText(getContext(), "قفل را باز کنید", 0).show();
        return true;
    }
}
