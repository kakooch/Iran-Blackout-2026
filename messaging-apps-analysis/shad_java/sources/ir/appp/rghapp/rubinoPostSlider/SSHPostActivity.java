package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2t.ui.AspectRatioFrameLayout;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.RGHMediaHelper$SavedFilterState;
import ir.appp.rghapp.components.SSHFilterGLThread;
import ir.appp.rghapp.components.SSHFilterShaders;
import ir.appp.rghapp.components.SSHFilterView;
import ir.appp.rghapp.components.SSHLoadingDotsDrawable;
import ir.appp.rghapp.components.SSHPhotoCropView;
import ir.appp.rghapp.components.SSHPhotoEditCell;
import ir.appp.rghapp.components.SSHPhotoEditColorView;
import ir.appp.rghapp.components.SSHPhotoEditTiltShiftView;
import ir.appp.rghapp.components.SSHPhotoEditView;
import ir.appp.rghapp.components.SSHPhotoFilterBlurControl;
import ir.appp.rghapp.components.SSHPlayAnimatedDrawable;
import ir.appp.rghapp.components.SSHSeekBarView;
import ir.appp.rghapp.components.SSHVideoCoverTimelinePlayView;
import ir.appp.rghapp.components.SSHVideoTimelinePlayView;
import ir.appp.rghapp.components.sshCrop.SSHCropView;
import ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.messanger.RubinoCaptionPostActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.insta.RubinoDraftManager;
import ir.resaneh1.iptv.model.FragmentType;
import java.io.File;
import java.io.IOException;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarAnimationType;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Point;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.SizeNotifierFrameLayoutPhoto;

/* loaded from: classes3.dex */
public class SSHPostActivity extends BaseFragment implements SSHFilterShaders.FilterShadersDelegate {
    private static long mDeBounce;
    private ActionBarMenuItem actionBarMuteOrLuxItem;
    private ActionBarMenuItem actionBarNextItem;
    private ActionBarMenuItem actionBarRotateItem;
    private ActionBarMenuItem actionBarTitleItem;
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private int bitrate;
    private float blurAngle;
    private SSHPhotoFilterBlurControl blurControl;
    private float blurExcludeBlurSize;
    private Point blurExcludePoint;
    private float blurExcludeSize;
    private int blurType;
    private AddPostBottomTab bottomScrollSlidingTextTabStrip;
    private float brightnessValue;
    private int centerTranslateX;
    private int centerTranslateY;
    private SSHPhotoEditColorView colorView;
    private FrameLayoutDrawer2 containerView;
    private float contrastValue;
    private final RGHMediaHelper$PhotoEntry currentMedia;
    private int currentTintType;
    private SSHFilterGLThread eglThread;
    private float fadeValue;
    private int filterIdValue;
    private float filterSizeValue;
    private SSHFilterView filterView;
    private int firstX;
    private int firstY;
    private float highlightsValue;
    private final int id;
    private boolean isLoading;
    private boolean isMirrored;
    private boolean isPlaying;
    private float lastBlurAngle;
    private float lastBlurExcludeBlurSize;
    private Point lastBlurExcludePoint;
    private float lastBlurExcludeSize;
    private int lastBlurType;
    private float lastLuxValue;
    private long lastMoveTime;
    private int lastTintHighlightsColor;
    private int lastTintHighlightsIntensity;
    private int lastTintShadowsColor;
    private int lastTintShadowsIntensity;
    private SSHLoadingDotsDrawable loading;
    private float luxValue;
    private float maxX;
    private float maxY;
    private float minX;
    private float minY;
    private boolean muteVideo;
    private final OnMediaEditFinished onFinishListener;
    private Bitmap originalBitmap;
    private int originalBitrate;
    private SSHPhotoCropView photoCropView;
    private SSHPhotoEditView photoEditView;
    private SSHPlayAnimatedDrawable playButton;
    private ImageView previewImageView;
    private AlertDialog progressDialog;
    private float saturationValue;
    private float scale;
    private SSHSeekBarView seekBarView;
    private long seekTo;
    private SSHFilterView.FilterItem selectedFilter;
    private SSHPhotoEditView.EditListItem selectedPhotoEditItem;
    private float shadowsValue;
    private float sharpenValue;
    private boolean showOriginal;
    private int startX;
    private int startY;
    private TextureView textureView;
    private SSHPhotoEditTiltShiftView tiltShiftView;
    private int tintHighlightsColor;
    private int tintHighlightsIntensity;
    private int tintShadowsColor;
    private int tintShadowsIntensity;
    private int translateX;
    private int translateY;
    private SSHVideoCoverTimelinePlayView videoCoverTimelineView;
    private float videoCutEnd;
    private float videoCutStart;
    private float videoDuration;
    private int videoFramerate;
    private VideoPlayer videoPlayer;
    private int videoTimeLineSwipeX;
    private SSHVideoTimelinePlayView videoTimelineView;
    private float vignetteValue;
    private float warmthValue;
    private float whiteSurfaceAlphaSize;
    private int editMode = -1;
    private int lastEditMode = -1;
    private int originalWidth = 1;
    private int originalHeight = 1;
    private int resultWidth = 1;
    private int resultHeight = 1;
    private final Runnable updateProgressRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (SSHPostActivity.this.videoPlayer != null) {
                if (SSHPostActivity.this.videoTimelineView == null || SSHPostActivity.this.videoTimelineView.isDragging()) {
                    if (SSHPostActivity.this.videoPlayer.getCurrentPosition() >= (SSHPostActivity.this.videoPlayer.getDuration() > SSHPostActivity.this.getMaxVideoDuration() ? r0.getMaxVideoDuration() : SSHPostActivity.this.videoPlayer.getDuration())) {
                        SSHPostActivity.this.videoPlayer.seekTo(0L);
                        SSHPostActivity.this.videoPlayer.pause();
                        SSHPostActivity.this.containerView.invalidate();
                    }
                } else {
                    float currentPosition = SSHPostActivity.this.videoPlayer.getCurrentPosition() / SSHPostActivity.this.videoDuration;
                    if (currentPosition >= SSHPostActivity.this.videoCutEnd) {
                        SSHPostActivity.this.videoTimelineView.setProgress(SSHPostActivity.this.videoCutStart);
                        SSHPostActivity.this.videoPlayer.seekTo((int) (SSHPostActivity.this.videoCutStart * SSHPostActivity.this.videoDuration));
                        SSHPostActivity.this.videoPlayer.pause();
                        SSHPostActivity.this.videoTimelineView.isPlaying(false);
                        SSHPostActivity.this.containerView.invalidate();
                    } else {
                        SSHPostActivity.this.videoTimelineView.setProgress(currentPosition);
                    }
                }
            }
            if (SSHPostActivity.this.isPlaying) {
                AndroidUtilities.runOnUIThread(SSHPostActivity.this.updateProgressRunnable, 17L);
            }
        }
    };
    private boolean firstVisibleLuxFilter = true;
    private boolean finishVideoEditing = false;
    private final Object lock = new Object();

    interface OnMediaEditFinished {
        void onMediaEditFinished(int i, RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry);
    }

    public boolean isMulti() {
        return false;
    }

    public SSHPostActivity(int i, RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, OnMediaEditFinished onMediaEditFinished) {
        this.id = i;
        this.currentMedia = rGHMediaHelper$PhotoEntry;
        this.onFinishListener = onMediaEditFinished;
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoEditMediaActivity";
        this.isSmallActionBar = true;
        this.swipeBackEnabled = false;
        this.needLockOrientation = true;
        this.isFullScreen = DimensionHelper.isShowstoryNeedFullScreen();
        ActionBarAnimationType actionBarAnimationType = ActionBarAnimationType.ALPHA;
        this.presentAnimationType = actionBarAnimationType;
        this.dismissAnimationType = actionBarAnimationType;
        this.fragmentAnimationDuration = 150.0f;
        setInPreviewMode(true);
        RGHMediaHelper$SavedFilterState rGHMediaHelper$SavedFilterState = rGHMediaHelper$PhotoEntry.savedFilterState;
        float f = rGHMediaHelper$SavedFilterState.shadowsValue;
        this.shadowsValue = f;
        this.highlightsValue = rGHMediaHelper$SavedFilterState.highlightsValue;
        this.luxValue = rGHMediaHelper$SavedFilterState.luxValue;
        this.brightnessValue = rGHMediaHelper$SavedFilterState.brightnessValue;
        this.contrastValue = rGHMediaHelper$SavedFilterState.contrastValue;
        this.warmthValue = rGHMediaHelper$SavedFilterState.warmthValue;
        this.filterIdValue = rGHMediaHelper$SavedFilterState.filterId;
        this.filterSizeValue = rGHMediaHelper$SavedFilterState.filterSize;
        this.vignetteValue = rGHMediaHelper$SavedFilterState.vignetteValue;
        this.shadowsValue = f;
        this.fadeValue = rGHMediaHelper$SavedFilterState.fadeValue;
        this.tintHighlightsColor = rGHMediaHelper$SavedFilterState.tintHighlightsColor;
        this.tintShadowsColor = rGHMediaHelper$SavedFilterState.tintShadowsColor;
        int i2 = rGHMediaHelper$SavedFilterState.tintHighlightsIntensity;
        this.tintHighlightsIntensity = i2 == 0 ? 50 : i2;
        int i3 = rGHMediaHelper$SavedFilterState.tintShadowsIntensity;
        this.tintShadowsIntensity = i3 == 0 ? 50 : i3;
        this.lastTintHighlightsIntensity = i2 == 0 ? 50 : i2;
        this.lastTintShadowsIntensity = i3 != 0 ? i3 : 50;
        this.blurAngle = rGHMediaHelper$SavedFilterState.blurAngle;
        this.blurExcludeBlurSize = rGHMediaHelper$SavedFilterState.blurExcludeBlurSize;
        this.blurExcludePoint = rGHMediaHelper$SavedFilterState.blurExcludePoint;
        this.blurExcludeSize = rGHMediaHelper$SavedFilterState.blurExcludeSize;
        this.blurType = rGHMediaHelper$SavedFilterState.blurType;
        this.whiteSurfaceAlphaSize = rGHMediaHelper$SavedFilterState.whiteSurfaceAlphaSize;
        VideoEditedInfo videoEditedInfo = rGHMediaHelper$PhotoEntry.editedInfo;
        this.muteVideo = videoEditedInfo.muted;
        MediaController.CropState cropState = videoEditedInfo.cropState;
        this.translateX = cropState.translateX;
        this.translateY = cropState.translateY;
        this.scale = cropState.scale;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getShadowsValue() {
        return ((this.shadowsValue * 0.55f) + 100.0f) / 100.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getHighlightsValue() {
        return ((this.highlightsValue * 0.75f) + 100.0f) / 100.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getLuxValue() {
        return this.luxValue / 100.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getBrightnessValue() {
        return this.brightnessValue / 100.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getContrastValue() {
        return ((this.contrastValue / 100.0f) * 0.3f) + 1.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getWarmthValue() {
        return this.warmthValue / 100.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public int filterId() {
        return this.filterIdValue;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float filterSize() {
        return this.filterSizeValue / 100.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getVignetteValue() {
        return this.vignetteValue / 100.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getSharpenValue() {
        return ((this.sharpenValue / 100.0f) * 0.6f) + 0.11f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getFadeValue() {
        return this.fadeValue / 100.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getTintHighlightsIntensityValue() {
        if (this.tintHighlightsColor == 0) {
            return 0.0f;
        }
        return this.tintHighlightsIntensity / 75.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getTintShadowsIntensityValue() {
        if (this.tintShadowsColor == 0) {
            return 0.0f;
        }
        return this.tintShadowsIntensity / 75.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getSaturationValue() {
        float f = this.saturationValue / 100.0f;
        if (f > 0.0f) {
            f *= 1.05f;
        }
        return f + 1.0f;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public int getTintHighlightsColor() {
        return this.tintHighlightsColor;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public int getTintShadowsColor() {
        return this.tintShadowsColor;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public int getBlurType() {
        return this.blurType;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getWhiteSurfaceAlphaSize() {
        return this.whiteSurfaceAlphaSize;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getBlurExcludeSize() {
        return this.blurExcludeSize;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getBlurExcludeBlurSize() {
        return this.blurExcludeBlurSize;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public float getBlurAngle() {
        return this.blurAngle;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public Point getBlurExcludePoint() {
        return this.blurExcludePoint;
    }

    @Override // ir.appp.rghapp.components.SSHFilterShaders.FilterShadersDelegate
    public boolean shouldShowOriginal() {
        return this.showOriginal;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(final Context context) {
        ActionBar actionBarCreateActionBar = super.createActionBar(context);
        actionBarCreateActionBar.setCastShadows(false);
        actionBarCreateActionBar.setAddToContainer(true);
        actionBarCreateActionBar.isSmallActionBar = this.isSmallActionBar;
        actionBarCreateActionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        final ActionBarMenu actionBarMenuCreateMenu = actionBarCreateActionBar.createMenu();
        this.actionBarMuteOrLuxItem = new ActionBarMenuItem(context, actionBarMenuCreateMenu, 0, 0);
        actionBarCreateActionBar.setRtlLayout(this.rtlLayout);
        RLottieImageView rLottieImageView = this.actionBarMuteOrLuxItem.iconView;
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
        rLottieImageView.setImageResource(rGHMediaHelper$PhotoEntry.isVideo ? rGHMediaHelper$PhotoEntry.editedInfo.muted ? R.drawable.ic_rubino_mute : R.drawable.ic_rubino_unmute : R.drawable.ic_rubino_lux);
        this.actionBarMuteOrLuxItem.iconView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RLottieImageView rLottieImageView2 = this.actionBarMuteOrLuxItem.iconView;
        int i = Theme.key_rubinoBlackColor;
        rLottieImageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP));
        this.actionBarMuteOrLuxItem.iconView.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f));
        this.actionBarMuteOrLuxItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_rubino_add_post_TabSelector), 3));
        this.actionBarMuteOrLuxItem.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                actionBarMenuCreateMenu.onItemClick(3);
            }
        });
        actionBarCreateActionBar.addView(this.actionBarMuteOrLuxItem, LayoutHelper.createFrame(42, -1, 17));
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, actionBarMenuCreateMenu, 0, 0, true);
        this.actionBarTitleItem = actionBarMenuItem;
        actionBarMenuItem.setRtlLayout(this.rtlLayout);
        this.actionBarTitleItem.textView.setTextColor(Theme.getColor(i));
        this.actionBarTitleItem.textView.setTextSize(1, 18.0f);
        this.actionBarTitleItem.textView.setSingleLine(true);
        this.actionBarTitleItem.textView.setTypeface(Theme.getRubinoTypeFaceBold());
        this.actionBarTitleItem.setVisibility(4);
        actionBarCreateActionBar.addView(this.actionBarTitleItem, LayoutHelper.createFrame(-2, -1.0f, 21, 0.0f, 0.0f, AndroidUtilities.isTablet() ? 64.0f : 56.0f, 0.0f));
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(2, LocaleController.getString("NEXT", R.string.rubinoActionNext));
        this.actionBarNextItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        this.actionBarNextItem.textView.setTextColor(ContextCompat.getColor(context, R.color.rubino_blue));
        ActionBarMenuItem actionBarMenuItemAddItem2 = actionBarMenuCreateMenu.addItem(4, R.drawable.tool_rotate);
        this.actionBarRotateItem = actionBarMenuItemAddItem2;
        actionBarMenuItemAddItem2.iconView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        this.actionBarRotateItem.setVisibility(8);
        actionBarCreateActionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.2
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i2) throws IOException, IllegalArgumentException {
                if (i2 == -1 || i2 == 1) {
                    SSHPostActivity.this.onBackPressed();
                    return;
                }
                if (i2 == 2) {
                    SSHPostActivity.this.done();
                } else if (i2 == 3) {
                    SSHPostActivity.this.toggleMuteOrLux(context);
                } else {
                    if (i2 != 4) {
                        return;
                    }
                    SSHPostActivity.this.photoCropView.rotate90Degrees();
                }
            }
        });
        return actionBarCreateActionBar;
    }

    public int getMaxVideoDuration() {
        return (isMulti() ? RGHAddPostActivity.maxMultiVideoDurationInSecond : RGHAddPostActivity.maxVideoDurationInSecond) * CloseCodes.NORMAL_CLOSURE;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        FrameLayoutDrawer2 frameLayoutDrawer2 = new FrameLayoutDrawer2(context);
        this.containerView = frameLayoutDrawer2;
        frameLayoutDrawer2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        needShowProgress();
        FrameLayoutDrawer2 frameLayoutDrawer22 = this.containerView;
        this.fragmentView = frameLayoutDrawer22;
        ViewCompat.setLayoutDirection(frameLayoutDrawer22, 0);
        this.compositeDisposable.add((Disposable) Observable.just(this.currentMedia).observeOn(Schedulers.computation()).doOnNext(new Consumer() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$createView$1((RGHMediaHelper$PhotoEntry) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<RGHMediaHelper$PhotoEntry>() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) throws IllegalArgumentException {
                SSHPostActivity.this.initViews(context);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                th.printStackTrace();
            }
        }));
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$1(ir.appp.rghapp.RGHMediaHelper$PhotoEntry r9) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.lambda$createView$1(ir.appp.rghapp.RGHMediaHelper$PhotoEntry):void");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null || !videoPlayer.isPlaying()) {
            return;
        }
        this.loading.stop();
        this.playButton.setIsVisible(false, false);
        this.videoPlayer.pause();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() throws IllegalArgumentException {
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry;
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry2;
        super.onResume();
        if (this.videoPlayer == null && (rGHMediaHelper$PhotoEntry2 = this.currentMedia) != null && rGHMediaHelper$PhotoEntry2.isVideo) {
            preparePlayer(Uri.fromFile(new File(this.currentMedia.path)), false);
        }
        if (this.onFinishListener == null && (rGHMediaHelper$PhotoEntry = this.currentMedia) != null && rGHMediaHelper$PhotoEntry.bitmap != null) {
            createTextureView(getParentActivity());
        }
        int i = this.editMode;
        if (i != -1) {
            setEditMode(i);
        }
        SSHFilterGLThread sSHFilterGLThread = this.eglThread;
        if (sSHFilterGLThread != null) {
            sSHFilterGLThread.requestRender(true, true, false);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        destroy(false);
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() throws IllegalArgumentException {
        SSHPhotoCropView sSHPhotoCropView = this.photoCropView;
        if (sSHPhotoCropView != null && sSHPhotoCropView.getVisibility() == 0) {
            this.photoCropView.reset();
            this.photoCropView.onDisappear();
            this.photoCropView.setVisibility(8);
            this.selectedPhotoEditItem.selected = false;
            this.photoEditView.setVisibility(0);
            this.textureView.setVisibility(0);
            this.photoEditView.updateSelectedFilter(this.selectedPhotoEditItem.id);
            updateActionBarTitleText(false, null);
            this.showOriginal = false;
            SSHFilterGLThread sSHFilterGLThread = this.eglThread;
            if (sSHFilterGLThread != null) {
                sSHFilterGLThread.requestRender(true);
            }
            this.containerView.invalidate();
            return false;
        }
        SSHPhotoEditTiltShiftView sSHPhotoEditTiltShiftView = this.tiltShiftView;
        if (sSHPhotoEditTiltShiftView != null && sSHPhotoEditTiltShiftView.getVisibility() == 0) {
            int i = this.lastBlurType;
            this.blurType = i;
            float f = this.lastBlurExcludeSize;
            this.blurExcludeSize = f;
            Point point = this.lastBlurExcludePoint;
            this.blurExcludePoint = point;
            float f2 = this.lastBlurExcludeBlurSize;
            this.blurExcludeBlurSize = f2;
            float f3 = this.lastBlurAngle;
            this.blurAngle = f3;
            SSHPhotoFilterBlurControl sSHPhotoFilterBlurControl = this.blurControl;
            sSHPhotoFilterBlurControl.centerPoint = point;
            sSHPhotoFilterBlurControl.falloff = f2;
            sSHPhotoFilterBlurControl.size = f;
            sSHPhotoFilterBlurControl.angle = f3;
            sSHPhotoFilterBlurControl.setType(i == 2 ? 0 : 1, false);
            this.whiteSurfaceAlphaSize = 0.0f;
            SSHFilterGLThread sSHFilterGLThread2 = this.eglThread;
            if (sSHFilterGLThread2 != null) {
                sSHFilterGLThread2.requestRender(false);
            }
            this.tiltShiftView.setSelectedPosition(this.blurType);
            this.photoEditView.setVisibility(0);
            this.tiltShiftView.setVisibility(8);
            this.blurControl.setVisibility(8);
            SSHPhotoEditView.EditListItem editListItem = this.selectedPhotoEditItem;
            editListItem.selected = this.blurType != 0;
            this.photoEditView.updateSelectedFilter(editListItem.id);
            updateActionBarTitleText(false, null);
            return false;
        }
        SSHPhotoEditColorView sSHPhotoEditColorView = this.colorView;
        if (sSHPhotoEditColorView != null && sSHPhotoEditColorView.getVisibility() == 0) {
            this.tintShadowsColor = this.lastTintShadowsColor;
            this.tintShadowsIntensity = this.lastTintShadowsIntensity;
            this.tintHighlightsColor = this.lastTintHighlightsColor;
            this.tintHighlightsIntensity = this.lastTintHighlightsIntensity;
            SSHFilterGLThread sSHFilterGLThread3 = this.eglThread;
            if (sSHFilterGLThread3 != null) {
                sSHFilterGLThread3.requestRender(true);
            }
            this.photoEditView.setVisibility(0);
            this.colorView.setVisibility(8);
            this.colorView.setSelectedColor(0, this.tintShadowsColor, this.tintHighlightsColor);
            SSHPhotoEditView.EditListItem editListItem2 = this.selectedPhotoEditItem;
            if (this.tintShadowsColor == 0 && this.tintHighlightsColor == 0) {
                z = false;
            }
            editListItem2.selected = z;
            this.photoEditView.updateSelectedFilter(editListItem2.id);
            updateActionBarTitleText(false, null);
            return false;
        }
        SSHSeekBarView sSHSeekBarView = this.seekBarView;
        if (sSHSeekBarView != null && sSHSeekBarView.getVisibility() == 0) {
            int i2 = this.editMode;
            if (i2 == 102) {
                SSHFilterView.FilterItem filterItem = this.selectedFilter;
                if (filterItem != null) {
                    updateFilterSizeValue(filterItem.id, 100);
                    this.filterView.setVisibility(0);
                }
            } else if (i2 == 105) {
                SSHPhotoEditView.EditListItem editListItem3 = this.selectedPhotoEditItem;
                if (editListItem3.mode == 2) {
                    this.tintShadowsIntensity = this.lastTintShadowsIntensity;
                    this.tintHighlightsIntensity = this.lastTintHighlightsIntensity;
                    this.colorView.setVisibility(0);
                    SSHFilterGLThread sSHFilterGLThread4 = this.eglThread;
                    if (sSHFilterGLThread4 != null) {
                        sSHFilterGLThread4.requestRender(true);
                    }
                } else {
                    SSHPhotoEditView.SeekBarValue seekBarValue = editListItem3.seekBarValue;
                    if (seekBarValue != null) {
                        updatePhotoEditValue(editListItem3.id, seekBarValue.defaultValue);
                        this.photoEditView.setVisibility(0);
                    }
                }
            } else if (i2 == 106) {
                this.luxValue = this.lastLuxValue;
                SSHFilterGLThread sSHFilterGLThread5 = this.eglThread;
                if (sSHFilterGLThread5 != null) {
                    sSHFilterGLThread5.requestRender(true);
                }
                setEditMode(this.lastEditMode);
            }
            updateActionBarTitleText(false, null);
            this.seekBarView.setVisibility(8);
            return false;
        }
        if (this.onFinishListener == null) {
            showDiscardDialog();
        } else {
            finishFragment();
        }
        return false;
    }

    public void destroy(boolean z) {
        releasePlayer();
        if (z && this.onFinishListener == null) {
            Bitmap bitmap = this.originalBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.originalBitmap.recycle();
                this.originalBitmap = null;
            }
            this.currentMedia.resetForAddPost();
        }
        this.compositeDisposable.dispose();
    }

    public void shutdown() {
        SSHFilterGLThread sSHFilterGLThread = this.eglThread;
        if (sSHFilterGLThread != null) {
            sSHFilterGLThread.shutdown();
            this.eglThread = null;
        }
    }

    private void releasePlayer() {
        try {
            VideoPlayer videoPlayer = this.videoPlayer;
            if (videoPlayer != null) {
                videoPlayer.releasePlayer();
                this.videoPlayer = null;
            }
            if (this.aspectRatioFrameLayout != null) {
                if (this.textureView != null) {
                    shutdown();
                    this.aspectRatioFrameLayout.removeView(this.textureView);
                    this.textureView = null;
                }
                try {
                    this.containerView.removeView(this.aspectRatioFrameLayout);
                } catch (Throwable unused) {
                }
                this.aspectRatioFrameLayout = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void done() throws IOException, IllegalArgumentException {
        TextureView textureView;
        if (this.currentMedia == null) {
            return;
        }
        getSavedFilterState();
        getCurrentVideoEditedInfo();
        getSavedCropState();
        ImageView imageView = this.previewImageView;
        if (imageView != null && (textureView = this.textureView) != null && this.currentMedia.isVideo) {
            imageView.setImageBitmap(textureView.getBitmap());
            this.previewImageView.setVisibility(0);
            this.textureView.setVisibility(4);
        }
        needShowProgress();
        if (this.onFinishListener != null) {
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
            if (rGHMediaHelper$PhotoEntry.isVideo) {
                File file = new File(this.currentMedia.path);
                this.currentMedia.size = file.length();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
                RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry2 = this.currentMedia;
                rGHMediaHelper$PhotoEntry2.bitmap = mediaMetadataRetriever.getFrameAtTime(rGHMediaHelper$PhotoEntry2.editedInfo.startTime);
                mediaMetadataRetriever.release();
                this.finishVideoEditing = true;
                if (this.currentMedia.editedInfo.coverPhotoTime / 1000 == this.videoPlayer.getCurrentPosition()) {
                    SSHFilterGLThread sSHFilterGLThread = this.eglThread;
                    if (sSHFilterGLThread != null) {
                        sSHFilterGLThread.requestRender(true, true, true);
                        return;
                    }
                    return;
                }
                this.videoPlayer.seekTo(0L);
                this.videoPlayer.seekTo(this.currentMedia.editedInfo.coverPhotoTime / 1000);
                return;
            }
            VideoEditedInfo videoEditedInfo = rGHMediaHelper$PhotoEntry.editedInfo;
            float fMin = Math.min(512, Math.min(videoEditedInfo.resultWidth, videoEditedInfo.resultHeight));
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry3 = this.currentMedia;
            int i = rGHMediaHelper$PhotoEntry3.editedInfo.resultWidth;
            float f = fMin / i;
            rGHMediaHelper$PhotoEntry3.bitmap = ImageLoader.generateThumbnail(this.originalBitmap, rGHMediaHelper$PhotoEntry3.cropState, (int) (i * f), (int) (f * r3.resultHeight));
            this.onFinishListener.onMediaEditFinished(this.id, this.currentMedia);
            needHideProgress();
            finishFragment(true);
            return;
        }
        send();
    }

    private void send() {
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
        if (rGHMediaHelper$PhotoEntry.isVideo) {
            this.finishVideoEditing = true;
            if (rGHMediaHelper$PhotoEntry.editedInfo.coverPhotoTime / 1000 == this.videoPlayer.getCurrentPosition()) {
                SSHFilterGLThread sSHFilterGLThread = this.eglThread;
                if (sSHFilterGLThread != null) {
                    sSHFilterGLThread.requestRender(true, true, true);
                    return;
                }
                return;
            }
            this.videoPlayer.seekTo(0L);
            this.videoPlayer.seekTo(this.currentMedia.editedInfo.coverPhotoTime / 1000);
            return;
        }
        VideoEditedInfo videoEditedInfo = rGHMediaHelper$PhotoEntry.editedInfo;
        float fMin = 150.0f / Math.min(videoEditedInfo.resultWidth, videoEditedInfo.resultHeight);
        this.currentMedia.bitmap = this.eglThread.getTexture();
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry2 = this.currentMedia;
        Bitmap bitmap = rGHMediaHelper$PhotoEntry2.bitmap;
        VideoEditedInfo videoEditedInfo2 = rGHMediaHelper$PhotoEntry2.editedInfo;
        rGHMediaHelper$PhotoEntry2.thumbBitmap = ImageLoader.generateThumbnail(bitmap, 1.0f, 0, 0, (int) (videoEditedInfo2.resultWidth * fMin), (int) (fMin * videoEditedInfo2.resultHeight));
        needHideProgress();
        presentFragment(new RubinoCaptionPostActivity(RubinoDraftManager.getInstance(this.currentAccount).createSendingPost(this.currentMedia.copy(), AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishVideoEditing() {
        OnMediaEditFinished onMediaEditFinished = this.onFinishListener;
        if (onMediaEditFinished != null) {
            onMediaEditFinished.onMediaEditFinished(this.id, this.currentMedia);
            needHideProgress();
            releasePlayer();
            finishFragment(true);
            return;
        }
        needHideProgress();
        VideoEditedInfo videoEditedInfo = this.currentMedia.editedInfo;
        if (videoEditedInfo.coverPhotoBitmap != null) {
            MediaController.CropState cropState = videoEditedInfo.cropState;
            float fMin = 150.0f / Math.min(cropState.transformWidth, cropState.transformHeight);
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
            VideoEditedInfo videoEditedInfo2 = rGHMediaHelper$PhotoEntry.editedInfo;
            Bitmap bitmap = videoEditedInfo2.coverPhotoBitmap;
            int i = this.translateX;
            int i2 = this.translateY;
            MediaController.CropState cropState2 = videoEditedInfo2.cropState;
            rGHMediaHelper$PhotoEntry.thumbBitmap = ImageLoader.generateThumbnail(bitmap, 1.0f, i, i2, (int) (cropState2.transformWidth * fMin), (int) (fMin * cropState2.transformHeight));
            releasePlayer();
            presentFragment(new RubinoCaptionPostActivity(RubinoDraftManager.getInstance(this.currentAccount).createSendingPost(this.currentMedia.copy(), AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleMuteOrLux(Context context) throws IllegalArgumentException {
        if (this.currentMedia.isVideo) {
            boolean z = !this.muteVideo;
            this.muteVideo = z;
            if (z) {
                this.actionBarMuteOrLuxItem.iconView.setImageResource(R.drawable.ic_rubino_mute);
                Toast.makeText(context, "ویدیو بی صدا است.", 0).show();
            } else {
                this.actionBarMuteOrLuxItem.iconView.setImageResource(R.drawable.ic_rubino_unmute);
                Toast.makeText(context, "ویدیو با صدا است.", 0).show();
            }
            VideoPlayer videoPlayer = this.videoPlayer;
            if (videoPlayer != null) {
                videoPlayer.setMute(this.muteVideo);
                return;
            }
            return;
        }
        this.lastEditMode = this.editMode;
        setEditMode(106);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActionBarTitleText(boolean z, String str) {
        this.actionBarTitleItem.textView.setText(str);
        this.actionBarRotateItem.setVisibility(8);
        if (z) {
            this.actionBarMuteOrLuxItem.setVisibility(4);
            this.actionBarNextItem.setVisibility(4);
            this.actionBarTitleItem.setVisibility(0);
        } else {
            this.actionBarMuteOrLuxItem.setVisibility(0);
            this.actionBarNextItem.setVisibility(0);
            this.actionBarTitleItem.setVisibility(4);
        }
    }

    private void needShowProgress() {
        if (this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCancel(false);
        this.progressDialog.show();
    }

    protected void needHideProgress() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$needHideProgress$2();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$needHideProgress$2() {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog == null) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.progressDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViews(Context context) throws IllegalArgumentException {
        if (this.currentMedia.isVideo) {
            preparePlayer(Uri.fromFile(new File(this.currentMedia.path)), false);
        } else {
            prepareImageView(context);
        }
        createTextureView(context);
        prepareBottomNavigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEditMode(int i) throws IllegalArgumentException {
        hideViews();
        switch (i) {
            case 102:
                prepareFilterView();
                break;
            case 103:
                prepareVideoTimeLine();
                break;
            case 104:
                prepareVideoCoverTimeLine();
                break;
            case 105:
                preparePhotoEditView();
                break;
            case 106:
                updateActionBarTitleText(true, "Lux");
                if (this.firstVisibleLuxFilter) {
                    this.luxValue = 50.0f;
                }
                this.seekBarView.setValue(this.luxValue, 0, 100);
                this.seekBarView.setVisibility(0);
                SSHFilterGLThread sSHFilterGLThread = this.eglThread;
                if (sSHFilterGLThread != null) {
                    sSHFilterGLThread.requestRender(true);
                    break;
                }
                break;
        }
        this.editMode = i;
    }

    private void preparePhotoEditView() {
        if (this.photoEditView == null) {
            SSHPhotoEditView sSHPhotoEditView = new SSHPhotoEditView(getParentActivity());
            this.photoEditView = sSHPhotoEditView;
            sSHPhotoEditView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            this.photoEditView.setOnPhotoEditClickedListener(new SSHPhotoEditView.OnPhotoEditClickedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda6
                @Override // ir.appp.rghapp.components.SSHPhotoEditView.OnPhotoEditClickedListener
                public final void onItemClicked(SSHPhotoEditView.EditListItem editListItem) {
                    this.f$0.lambda$preparePhotoEditView$3(editListItem);
                }
            });
            this.containerView.addView(this.photoEditView, LayoutHelper.createFrame(-1, -1.0f, 83, 0.0f, 0.0f, 0.0f, 44.0f));
            if (this.seekBarView == null) {
                prepareSeekBarView();
            }
        }
        SSHPhotoEditView sSHPhotoEditView2 = this.photoEditView;
        sSHPhotoEditView2.scrollToPosition(sSHPhotoEditView2.getSelectedItemPosition(), false);
        this.photoEditView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preparePhotoEditView$3(SSHPhotoEditView.EditListItem editListItem) {
        this.selectedPhotoEditItem = editListItem;
        this.photoEditView.setVisibility(8);
        updateActionBarTitleText(true, editListItem.title);
        int i = editListItem.mode;
        if (i == 0) {
            SSHPhotoEditView.SeekBarValue seekBarValue = editListItem.seekBarValue;
            if (seekBarValue != null) {
                this.seekBarView.setValue(seekBarValue.progress, seekBarValue.min, seekBarValue.max);
                this.seekBarView.setVisibility(0);
                return;
            }
            return;
        }
        if (i == 1) {
            this.actionBarRotateItem.setVisibility(0);
            prepareAdjustView();
        } else if (i == 2) {
            prepareColorView();
        } else {
            if (i != 3) {
                return;
            }
            prepareTiltShiftView();
        }
    }

    private void prepareAdjustView() {
        if (this.photoCropView == null) {
            SSHPhotoCropView sSHPhotoCropView = new SSHPhotoCropView(getParentActivity());
            this.photoCropView = sSHPhotoCropView;
            sSHPhotoCropView.setVisibility(8);
            this.containerView.addView(this.photoCropView, LayoutHelper.createFrame(-1, -1, 51));
            this.photoCropView.setDelegate(new SSHPhotoCropView.SSHPhotoCropViewDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.4
                @Override // ir.appp.rghapp.components.SSHPhotoCropView.SSHPhotoCropViewDelegate
                public void onChange(boolean z) {
                }

                @Override // ir.appp.rghapp.components.SSHPhotoCropView.SSHPhotoCropViewDelegate
                public Bitmap getBitmap() {
                    return SSHPostActivity.this.originalBitmap;
                }
            });
        }
        this.photoCropView.setOnActionClickedListener(new SSHPhotoCropView.OnActionClickedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.5
            @Override // ir.appp.rghapp.components.SSHPhotoCropView.OnActionClickedListener
            public void onDoneClicked() {
                SSHPostActivity.this.currentMedia.bitmap = SSHPostActivity.this.photoCropView.getBitmap();
                SSHPostActivity.this.showOriginal = false;
                if (SSHPostActivity.this.eglThread != null) {
                    SSHPostActivity.this.eglThread.shutdown();
                    SSHPostActivity.this.eglThread = null;
                }
                SSHPostActivity.this.aspectRatioFrameLayout.removeView(SSHPostActivity.this.textureView);
                SSHPostActivity.this.textureView = null;
                SSHPostActivity sSHPostActivity = SSHPostActivity.this;
                sSHPostActivity.createTextureView(sSHPostActivity.getParentActivity());
                SSHPostActivity.this.containerView.invalidate();
                SSHPostActivity.this.selectedPhotoEditItem.selected = false;
                SSHPostActivity.this.photoEditView.updateSelectedFilter(SSHPostActivity.this.selectedPhotoEditItem.id);
                SSHPostActivity.this.updateActionBarTitleText(false, null);
                SSHPostActivity.this.textureView.setVisibility(0);
                SSHPostActivity.this.photoEditView.setVisibility(0);
                SSHPostActivity.this.photoCropView.setVisibility(8);
                SSHPostActivity.this.currentMedia.cropState = new SSHCropView.SSHCropState(SSHPostActivity.this.photoCropView.getCropState());
            }

            @Override // ir.appp.rghapp.components.SSHPhotoCropView.OnActionClickedListener
            public void onCancelClicked() throws IllegalArgumentException {
                SSHPostActivity.this.onBackPressed();
            }
        });
        this.photoCropView.onAppear();
        this.photoCropView.setBitmap(this.originalBitmap, this.currentMedia.cropState, false);
        this.photoCropView.onAppeared();
        this.photoCropView.setVisibility(0);
        this.textureView.setVisibility(4);
    }

    private void updateMinMax(float f) {
        int width;
        int height;
        if (this.currentMedia.isVideo) {
            width = ((int) ((this.textureView.getWidth() * f) - MediaController.getInstance().getAddPostCropArea().width())) / 2;
            height = ((int) ((this.textureView.getHeight() * f) - MediaController.getInstance().getAddPostCropArea().height())) / 2;
        } else {
            width = ((int) ((this.photoCropView.getWidth() * f) - MediaController.getInstance().getAddPostCropArea().width())) / 2;
            height = ((int) ((this.photoCropView.getHeight() * f) - MediaController.getInstance().getAddPostCropArea().height())) / 2;
        }
        if (width > 0) {
            this.minX = -width;
            this.maxX = width;
        } else {
            this.maxX = 0.0f;
            this.minX = 0.0f;
        }
        if (height > 0) {
            this.minY = -height;
            this.maxY = height;
        } else {
            this.maxY = 0.0f;
            this.minY = 0.0f;
        }
        SSHPhotoCropView sSHPhotoCropView = this.photoCropView;
        if (sSHPhotoCropView == null || sSHPhotoCropView.getVisibility() != 0) {
            return;
        }
        this.maxX += this.photoCropView.getLimitX();
        this.maxY += this.photoCropView.getLimitY();
        this.minX -= this.photoCropView.getLimitWidth();
        this.minY -= this.photoCropView.getLimitHeight();
    }

    private void prepareColorView() {
        if (this.colorView == null) {
            SSHPhotoEditColorView sSHPhotoEditColorView = new SSHPhotoEditColorView(getParentActivity());
            this.colorView = sSHPhotoEditColorView;
            sSHPhotoEditColorView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            this.colorView.setOnColorClickedListener(new SSHPhotoEditColorView.OnColorClickedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda4
                @Override // ir.appp.rghapp.components.SSHPhotoEditColorView.OnColorClickedListener
                public final void onColorClicked(int i, int i2, int i3) {
                    this.f$0.lambda$prepareColorView$4(i, i2, i3);
                }
            });
            this.colorView.setOnActionClickedListener(new SSHPhotoEditColorView.OnActionClickedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.6
                @Override // ir.appp.rghapp.components.SSHPhotoEditColorView.OnActionClickedListener
                public void onDoneClicked() {
                    SSHPostActivity sSHPostActivity = SSHPostActivity.this;
                    sSHPostActivity.lastTintShadowsColor = sSHPostActivity.tintShadowsColor;
                    SSHPostActivity sSHPostActivity2 = SSHPostActivity.this;
                    sSHPostActivity2.lastTintShadowsIntensity = sSHPostActivity2.tintShadowsIntensity;
                    SSHPostActivity sSHPostActivity3 = SSHPostActivity.this;
                    sSHPostActivity3.lastTintHighlightsColor = sSHPostActivity3.tintHighlightsColor;
                    SSHPostActivity sSHPostActivity4 = SSHPostActivity.this;
                    sSHPostActivity4.lastTintHighlightsIntensity = sSHPostActivity4.tintHighlightsIntensity;
                    SSHPostActivity.this.photoEditView.setVisibility(0);
                    SSHPostActivity.this.colorView.setVisibility(8);
                    SSHPostActivity.this.selectedPhotoEditItem.selected = (SSHPostActivity.this.tintShadowsColor == 0 && SSHPostActivity.this.tintHighlightsColor == 0) ? false : true;
                    SSHPostActivity.this.photoEditView.updateSelectedFilter(SSHPostActivity.this.selectedPhotoEditItem.id);
                    SSHPostActivity.this.updateActionBarTitleText(false, null);
                }

                @Override // ir.appp.rghapp.components.SSHPhotoEditColorView.OnActionClickedListener
                public void onCancelClicked() throws IllegalArgumentException {
                    SSHPostActivity.this.onBackPressed();
                }
            });
            this.containerView.addView(this.colorView, LayoutHelper.createFrame(-1, -1, 83));
        }
        this.colorView.setSelectedColor(0, this.tintShadowsColor, this.tintHighlightsColor);
        this.colorView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareColorView$4(int i, int i2, int i3) {
        this.currentTintType = i;
        if (this.tintShadowsColor == i2 && this.tintHighlightsColor == i3) {
            if (i2 == 0 && i3 == 0) {
                return;
            }
            this.seekBarView.setValue(i == 0 ? this.tintShadowsIntensity : this.tintHighlightsIntensity, 0, 100);
            this.colorView.setVisibility(8);
            this.seekBarView.setVisibility(0);
            return;
        }
        this.tintShadowsColor = i2;
        this.tintHighlightsColor = i3;
        SSHFilterGLThread sSHFilterGLThread = this.eglThread;
        if (sSHFilterGLThread != null) {
            sSHFilterGLThread.requestRender(false);
        }
    }

    private void prepareTiltShiftView() {
        float rubinoContainerViewHeight;
        if (this.tiltShiftView == null) {
            SSHPhotoEditTiltShiftView sSHPhotoEditTiltShiftView = new SSHPhotoEditTiltShiftView(getParentActivity());
            this.tiltShiftView = sSHPhotoEditTiltShiftView;
            sSHPhotoEditTiltShiftView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            this.tiltShiftView.setOnTiltShiftedClickListener(new SSHPhotoEditTiltShiftView.OnTiltShiftedClicked() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda5
                @Override // ir.appp.rghapp.components.SSHPhotoEditTiltShiftView.OnTiltShiftedClicked
                public final void onTiltShiftedClicked(int i, SSHPhotoEditCell sSHPhotoEditCell) {
                    this.f$0.lambda$prepareTiltShiftView$5(i, sSHPhotoEditCell);
                }
            });
            this.tiltShiftView.setOnActionClickedListener(new SSHPhotoEditTiltShiftView.OnActionClickedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.7
                @Override // ir.appp.rghapp.components.SSHPhotoEditTiltShiftView.OnActionClickedListener
                public void onDoneClicked() {
                    SSHPostActivity sSHPostActivity = SSHPostActivity.this;
                    sSHPostActivity.lastBlurType = sSHPostActivity.blurType;
                    SSHPostActivity sSHPostActivity2 = SSHPostActivity.this;
                    sSHPostActivity2.lastBlurExcludeSize = sSHPostActivity2.blurExcludeSize;
                    SSHPostActivity sSHPostActivity3 = SSHPostActivity.this;
                    sSHPostActivity3.lastBlurExcludePoint = sSHPostActivity3.blurExcludePoint;
                    SSHPostActivity sSHPostActivity4 = SSHPostActivity.this;
                    sSHPostActivity4.lastBlurExcludeBlurSize = sSHPostActivity4.blurExcludeBlurSize;
                    SSHPostActivity sSHPostActivity5 = SSHPostActivity.this;
                    sSHPostActivity5.lastBlurAngle = sSHPostActivity5.blurAngle;
                    SSHPostActivity.this.photoEditView.setVisibility(0);
                    SSHPostActivity.this.tiltShiftView.setVisibility(8);
                    SSHPostActivity.this.blurControl.setVisibility(8);
                    SSHPostActivity.this.selectedPhotoEditItem.selected = SSHPostActivity.this.blurType != 0;
                    SSHPostActivity.this.photoEditView.updateSelectedFilter(SSHPostActivity.this.selectedPhotoEditItem.id);
                    SSHPostActivity.this.updateActionBarTitleText(false, null);
                }

                @Override // ir.appp.rghapp.components.SSHPhotoEditTiltShiftView.OnActionClickedListener
                public void onCancelClicked() throws IllegalArgumentException {
                    SSHPostActivity.this.onBackPressed();
                }
            });
            this.containerView.addView(this.tiltShiftView, LayoutHelper.createFrame(-1, -1, 83));
        }
        if (this.currentMedia.bitmap.getWidth() > this.currentMedia.bitmap.getHeight()) {
            rubinoContainerViewHeight = MediaController.getRubinoContainerViewWidth() / this.currentMedia.bitmap.getWidth();
            this.blurControl.setActualAreaSize(MediaController.getRubinoContainerViewWidth(), Math.min(MediaController.getRubinoContainerViewHeight(), this.currentMedia.bitmap.getHeight() * rubinoContainerViewHeight));
        } else {
            rubinoContainerViewHeight = MediaController.getRubinoContainerViewHeight() / this.currentMedia.bitmap.getHeight();
            this.blurControl.setActualAreaSize(Math.min(MediaController.getRubinoContainerViewWidth(), this.currentMedia.bitmap.getWidth() * rubinoContainerViewHeight), MediaController.getRubinoContainerViewHeight());
        }
        this.blurControl.setContentSize(this.currentMedia.bitmap.getWidth() * rubinoContainerViewHeight, this.currentMedia.height * rubinoContainerViewHeight);
        if (this.blurType != 0) {
            this.blurControl.setVisibility(0);
            this.blurControl.setType(this.blurType, true);
        }
        this.tiltShiftView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareTiltShiftView$5(int i, SSHPhotoEditCell sSHPhotoEditCell) {
        if (i == 0) {
            this.blurType = 0;
            this.blurControl.setVisibility(8);
            SSHFilterGLThread sSHFilterGLThread = this.eglThread;
            if (sSHFilterGLThread != null) {
                sSHFilterGLThread.requestRender(false);
                return;
            }
            return;
        }
        if (i == 1) {
            this.blurType = 1;
            this.blurControl.setVisibility(0);
            this.blurControl.setType(1, true);
            SSHFilterGLThread sSHFilterGLThread2 = this.eglThread;
            if (sSHFilterGLThread2 != null) {
                sSHFilterGLThread2.requestRender(false);
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        this.blurType = 2;
        this.blurControl.setVisibility(0);
        this.blurControl.setType(0, true);
        SSHFilterGLThread sSHFilterGLThread3 = this.eglThread;
        if (sSHFilterGLThread3 != null) {
            sSHFilterGLThread3.requestRender(false);
        }
    }

    private void prepareSeekBarView() {
        SSHSeekBarView sSHSeekBarView = new SSHSeekBarView(getParentActivity());
        this.seekBarView = sSHSeekBarView;
        sSHSeekBarView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.seekBarView.setSeekBarDelegate(new SSHSeekBarView.SeekBarDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda8
            @Override // ir.appp.rghapp.components.SSHSeekBarView.SeekBarDelegate
            public final void onProgressChanged(int i) {
                this.f$0.lambda$prepareSeekBarView$6(i);
            }
        });
        this.seekBarView.setOnActionClickedListener(new SSHSeekBarView.OnActionClickedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.8
            @Override // ir.appp.rghapp.components.SSHSeekBarView.OnActionClickedListener
            public void onDoneClicked() throws IllegalArgumentException {
                int i = SSHPostActivity.this.editMode;
                if (i != 102) {
                    if (i != 105) {
                        if (i == 106) {
                            SSHPostActivity sSHPostActivity = SSHPostActivity.this;
                            sSHPostActivity.lastLuxValue = sSHPostActivity.luxValue;
                            if (SSHPostActivity.this.firstVisibleLuxFilter && SSHPostActivity.this.luxValue != 50.0f) {
                                SSHPostActivity.this.firstVisibleLuxFilter = false;
                            }
                            SSHPostActivity sSHPostActivity2 = SSHPostActivity.this;
                            sSHPostActivity2.setEditMode(sSHPostActivity2.lastEditMode);
                        }
                    } else if (SSHPostActivity.this.selectedPhotoEditItem.mode != 2) {
                        if (SSHPostActivity.this.selectedPhotoEditItem.seekBarValue != null) {
                            SSHPostActivity.this.selectedPhotoEditItem.seekBarValue.progress = SSHPostActivity.this.seekBarView.getProgress();
                            SSHPostActivity.this.photoEditView.updateSelectedFilter(SSHPostActivity.this.selectedPhotoEditItem.id);
                            SSHPostActivity.this.photoEditView.setVisibility(0);
                        }
                    } else {
                        SSHPostActivity sSHPostActivity3 = SSHPostActivity.this;
                        sSHPostActivity3.lastTintShadowsIntensity = sSHPostActivity3.tintShadowsIntensity;
                        SSHPostActivity sSHPostActivity4 = SSHPostActivity.this;
                        sSHPostActivity4.lastTintHighlightsIntensity = sSHPostActivity4.tintHighlightsIntensity;
                        SSHPostActivity.this.colorView.setVisibility(0);
                    }
                } else if (SSHPostActivity.this.selectedFilter != null) {
                    SSHPostActivity.this.selectedFilter.progress = SSHPostActivity.this.seekBarView.getProgress();
                    SSHPostActivity.this.filterView.updateSelectedFilter(SSHPostActivity.this.selectedFilter.id);
                    SSHPostActivity.this.filterView.setVisibility(0);
                }
                SSHPostActivity.this.seekBarView.setVisibility(8);
                SSHPostActivity.this.updateActionBarTitleText(false, null);
            }

            @Override // ir.appp.rghapp.components.SSHSeekBarView.OnActionClickedListener
            public void onCancelClicked() throws IllegalArgumentException {
                SSHPostActivity.this.onBackPressed();
            }
        });
        this.seekBarView.setVisibility(8);
        this.containerView.addView(this.seekBarView, LayoutHelper.createFrame(-1, -1, 83));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareSeekBarView$6(int i) {
        int i2 = this.editMode;
        if (i2 == 102) {
            SSHFilterView.FilterItem filterItem = this.selectedFilter;
            if (filterItem != null) {
                updateFilterSizeValue(filterItem.id, i);
                return;
            }
            return;
        }
        if (i2 == 105) {
            updatePhotoEditValue(this.selectedPhotoEditItem.id, i);
            return;
        }
        if (i2 != 106) {
            return;
        }
        this.luxValue = i;
        SSHFilterGLThread sSHFilterGLThread = this.eglThread;
        if (sSHFilterGLThread != null) {
            sSHFilterGLThread.requestRender(true);
        }
    }

    private void updateFilterSizeValue(int i, int i2) {
        this.filterIdValue = i;
        this.filterSizeValue = i2;
        SSHFilterGLThread sSHFilterGLThread = this.eglThread;
        if (sSHFilterGLThread != null) {
            sSHFilterGLThread.requestRender(true);
        }
    }

    private void updatePhotoEditValue(int i, int i2) {
        switch (i) {
            case 1:
                this.brightnessValue = i2;
                break;
            case 2:
                this.contrastValue = i2;
                break;
            case 3:
                this.warmthValue = i2;
                break;
            case 4:
                this.saturationValue = i2;
                break;
            case 5:
                if (this.currentTintType == 0) {
                    this.tintShadowsIntensity = i2;
                } else {
                    this.tintHighlightsIntensity = i2;
                }
                SSHFilterGLThread sSHFilterGLThread = this.eglThread;
                if (sSHFilterGLThread != null) {
                    sSHFilterGLThread.requestRender(true);
                    break;
                }
                break;
            case 6:
                this.fadeValue = i2;
                break;
            case 7:
                this.highlightsValue = i2;
                break;
            case 8:
                this.shadowsValue = i2;
                break;
            case 9:
                this.vignetteValue = i2;
                break;
            case 11:
                this.sharpenValue = i2;
                break;
        }
        SSHFilterGLThread sSHFilterGLThread2 = this.eglThread;
        if (sSHFilterGLThread2 != null) {
            sSHFilterGLThread2.requestRender(true);
        }
    }

    private void prepareFilterView() {
        int iMin;
        if (this.filterView == null) {
            SSHFilterView sSHFilterView = new SSHFilterView(getParentActivity(), false, false);
            this.filterView = sSHFilterView;
            sSHFilterView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
            int i = rGHMediaHelper$PhotoEntry.width;
            int i2 = rGHMediaHelper$PhotoEntry.height;
            if (i > i2) {
                iMin = Math.min(250, i2);
            } else {
                iMin = Math.min(250, i);
            }
            int i3 = iMin;
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry2 = this.currentMedia;
            Bitmap bitmap = rGHMediaHelper$PhotoEntry2.bitmap;
            if (bitmap != null) {
                if (rGHMediaHelper$PhotoEntry2.isVideo) {
                    SSHFilterView sSHFilterView2 = this.filterView;
                    MediaController.CropState cropState = rGHMediaHelper$PhotoEntry2.editedInfo.cropState;
                    sSHFilterView2.setBitmapPath(ImageLoader.generateThumbnail(bitmap, 1.0f, cropState.translateX, cropState.translateY, i3, i3));
                } else {
                    this.filterView.setBitmapPath(ThumbnailUtils.extractThumbnail(this.originalBitmap, i3, i3));
                }
            }
            this.filterView.setDelegate(new SSHFilterView.FilterViewDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda3
                @Override // ir.appp.rghapp.components.SSHFilterView.FilterViewDelegate
                public final void onFilterChanged(SSHFilterView.FilterItem filterItem) {
                    this.f$0.lambda$prepareFilterView$7(filterItem);
                }
            });
            this.containerView.addView(this.filterView, LayoutHelper.createFrame(-1, -1.0f, 83, 0.0f, 0.0f, 0.0f, 44.0f));
            if (this.seekBarView == null) {
                prepareSeekBarView();
            }
        }
        this.filterView.setSelectedPosition(this.filterIdValue);
        this.filterView.setVisibility(0);
        if (this.currentMedia.isVideo) {
            this.playButton.setIsVisible(true, false);
            SSHVideoTimelinePlayView sSHVideoTimelinePlayView = this.videoTimelineView;
            if (sSHVideoTimelinePlayView != null) {
                this.videoPlayer.seekTo((long) (this.videoDuration * sSHVideoTimelinePlayView.getLeftProgress()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareFilterView$7(SSHFilterView.FilterItem filterItem) {
        SSHFilterView.FilterItem filterItem2;
        int i = filterItem.id;
        if (i != 0 && (filterItem2 = this.selectedFilter) != null && i == filterItem2.id) {
            this.seekBarView.setValue(filterItem.progress, filterItem.min, filterItem.max);
            this.filterView.setVisibility(8);
            this.seekBarView.setVisibility(0);
            updateActionBarTitleText(true, filterItem.title);
        }
        this.selectedFilter = filterItem;
        updateFilterSizeValue(filterItem.id, 100);
    }

    private void showDiscardDialog() {
        if (ApplicationLoader.applicationActivity != null) {
            String string = LocaleController.getString("Are you sure to discard changes?", R.string.rubinoAddPostDiscardMessage);
            SpannableString spannableString = new SpannableString(string);
            int length = string.length();
            int i = Theme.key_rubinoBlackColor;
            RubinoController.showRubinoCenterDialog(false, true, null, SpanHelper.makeBoldWithColorAndRelativeSize(spannableString, 0, length, Theme.getColor(i), 1.4f), LocaleController.getString("Discard", R.string.rubinoAddPostDiscard), LocaleController.getString("Close", R.string.rubinoAddPostContinue), -769226, Theme.getColor(i), new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$showDiscardDialog$8(view);
                }
            }, null);
            return;
        }
        destroy(true);
        presentFragment(new RGHAddPostActivity(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDiscardDialog$8(View view) {
        destroy(true);
        presentFragment(new RGHAddPostActivity(), true);
    }

    private void prepareVideoTimeLine() throws IllegalArgumentException {
        if (this.videoTimelineView == null) {
            SSHVideoTimelinePlayView sSHVideoTimelinePlayView = new SSHVideoTimelinePlayView(getParentActivity());
            this.videoTimelineView = sSHVideoTimelinePlayView;
            sSHVideoTimelinePlayView.setDelegate(new AnonymousClass9());
            this.videoTimelineView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            this.videoTimelineView.setVideoPath(this.currentMedia.path, this.videoCutStart, this.videoCutEnd, this.videoTimeLineSwipeX);
            this.containerView.addView(this.videoTimelineView, LayoutHelper.createFrame(-1, -1.0f, 83, 0.0f, 0.0f, 0.0f, 44.0f));
        }
        this.playButton.setIsVisible(true, false);
        this.videoTimelineView.setVisibility(0);
        this.videoPlayer.seekTo((long) (this.videoDuration * this.videoTimelineView.getLeftProgress()));
    }

    /* renamed from: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$9, reason: invalid class name */
    class AnonymousClass9 implements SSHVideoTimelinePlayView.VideoTimelineViewDelegate {
        private Runnable seekToRunnable;

        AnonymousClass9() {
        }

        @Override // ir.appp.rghapp.components.SSHVideoTimelinePlayView.VideoTimelineViewDelegate
        public void onLeftProgressChanged(float f) {
            seekTo(f);
        }

        @Override // ir.appp.rghapp.components.SSHVideoTimelinePlayView.VideoTimelineViewDelegate
        public void onRightProgressChanged(float f) {
            seekTo(SSHPostActivity.this.videoTimelineView.getLeftProgress());
        }

        @Override // ir.appp.rghapp.components.SSHVideoTimelinePlayView.VideoTimelineViewDelegate
        public void onPlayProgressChanged(float f, float f2, float f3, int i) {
            SSHPostActivity.this.videoTimeLineSwipeX = i;
            seekTo(f3);
        }

        private void seekTo(float f) {
            if (SSHPostActivity.this.videoPlayer == null) {
                return;
            }
            SSHPostActivity.this.lastMoveTime = System.currentTimeMillis();
            if (SSHPostActivity.this.videoPlayer.isPlaying()) {
                SSHPostActivity.this.videoPlayer.pause();
                SSHPostActivity.this.containerView.invalidate();
            }
            SSHPostActivity sSHPostActivity = SSHPostActivity.this;
            sSHPostActivity.seekTo = (long) (sSHPostActivity.videoDuration * f * 1000.0f);
            if (this.seekToRunnable == null) {
                Runnable runnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$9$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$seekTo$0();
                    }
                };
                this.seekToRunnable = runnable;
                AndroidUtilities.runOnUIThread(runnable, 10L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$seekTo$0() {
            if (SSHPostActivity.this.videoPlayer != null) {
                SSHPostActivity.this.videoPlayer.seekTo(SSHPostActivity.this.seekTo / 1000);
            }
            this.seekToRunnable = null;
        }

        @Override // ir.appp.rghapp.components.SSHVideoTimelinePlayView.VideoTimelineViewDelegate
        public void didStartDragging(int i) {
            SSHPostActivity.this.lastMoveTime = System.currentTimeMillis();
            if (SSHPostActivity.this.isLoading) {
                return;
            }
            SSHPostActivity.this.playButton.setIsVisible(false, false);
            SSHPostActivity.this.loading.start();
            SSHPostActivity.this.isLoading = true;
        }

        @Override // ir.appp.rghapp.components.SSHVideoTimelinePlayView.VideoTimelineViewDelegate
        public void didStopDragging(int i) {
            SSHPostActivity.this.updateCoverPhotoTime();
            Runnable runnable = this.seekToRunnable;
            if (runnable == null) {
                SSHPostActivity.this.isLoading = false;
                SSHPostActivity.this.playButton.setIsVisible(true, false);
                SSHPostActivity.this.loading.stop();
            } else {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.seekToRunnable.run();
            }
        }

        @Override // ir.appp.rghapp.components.SSHVideoTimelinePlayView.VideoTimelineViewDelegate
        public void didStartFling() {
            SSHPostActivity.this.lastMoveTime = System.currentTimeMillis();
            if (SSHPostActivity.this.isLoading) {
                return;
            }
            SSHPostActivity.this.playButton.setIsVisible(false, false);
            SSHPostActivity.this.loading.start();
            SSHPostActivity.this.isLoading = true;
        }

        @Override // ir.appp.rghapp.components.SSHVideoTimelinePlayView.VideoTimelineViewDelegate
        public void didStopFling(float f, float f2, float f3, int i) {
            SSHPostActivity.this.videoTimeLineSwipeX = i;
            if (SSHPostActivity.this.videoPlayer == null) {
                return;
            }
            Runnable runnable = this.seekToRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.seekToRunnable.run();
            }
            if (SSHPostActivity.this.videoPlayer.isPlaying()) {
                SSHPostActivity.this.videoPlayer.pause();
                SSHPostActivity.this.containerView.invalidate();
            }
            seekTo(f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCoverPhotoTime() {
        SSHVideoTimelinePlayView sSHVideoTimelinePlayView = this.videoTimelineView;
        if (sSHVideoTimelinePlayView != null) {
            this.videoCutStart = sSHVideoTimelinePlayView.getLeftProgress();
            this.videoCutEnd = this.videoTimelineView.getRightProgress();
        }
        float f = this.videoDuration;
        long j = (long) (this.videoCutStart * f * 1000.0f);
        this.seekTo = j;
        long j2 = (long) (f * this.videoCutEnd * 1000.0f);
        VideoEditedInfo videoEditedInfo = this.currentMedia.editedInfo;
        if (videoEditedInfo.coverPhotoTime < j) {
            videoEditedInfo.coverPhotoTime = j;
        }
        if (videoEditedInfo.coverPhotoTime > j2) {
            videoEditedInfo.coverPhotoTime = j2;
        }
    }

    private void prepareVideoCoverTimeLine() throws IllegalArgumentException {
        if (this.videoCoverTimelineView == null) {
            SSHVideoCoverTimelinePlayView sSHVideoCoverTimelinePlayView = new SSHVideoCoverTimelinePlayView(getParentActivity());
            this.videoCoverTimelineView = sSHVideoCoverTimelinePlayView;
            sSHVideoCoverTimelinePlayView.setDelegate(new SSHVideoCoverTimelinePlayView.VideoCoverTimelineViewDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.10
                @Override // ir.appp.rghapp.components.SSHVideoCoverTimelinePlayView.VideoCoverTimelineViewDelegate
                public void didStartDragging() {
                }

                @Override // ir.appp.rghapp.components.SSHVideoCoverTimelinePlayView.VideoCoverTimelineViewDelegate
                public void didStopDragging() {
                }

                @Override // ir.appp.rghapp.components.SSHVideoCoverTimelinePlayView.VideoCoverTimelineViewDelegate
                public void onProgressChanged(float f) {
                    seekTo(f);
                }

                private void seekTo(float f) {
                    SSHPostActivity.this.seekTo = ((int) (SSHPostActivity.this.videoDuration * SSHPostActivity.this.videoCutStart * 1000.0f)) + ((long) ((((int) ((SSHPostActivity.this.videoDuration * SSHPostActivity.this.videoCutEnd) * 1000.0f)) - r0) * (((int) (f * 100.0f)) / 100.0f)));
                    SSHPostActivity.this.currentMedia.editedInfo.coverPhotoTime = SSHPostActivity.this.seekTo;
                    if (SSHPostActivity.this.videoPlayer != null) {
                        SSHPostActivity.this.videoPlayer.seekTo(SSHPostActivity.this.seekTo / 1000);
                    }
                }
            });
            this.videoCoverTimelineView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            this.containerView.addView(this.videoCoverTimelineView, LayoutHelper.createFrame(-1, -1.0f, 83, 0.0f, 0.0f, 0.0f, 44.0f));
        }
        float f = this.videoDuration;
        this.seekTo = (long) (this.videoCutStart * f * 1000.0f);
        long j = (long) (f * this.videoCutEnd * 1000.0f);
        long j2 = this.currentMedia.editedInfo.coverPhotoTime;
        if (j2 != 0) {
            this.seekTo = j2;
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.seekTo(this.seekTo / 1000);
        }
        float f2 = (this.seekTo - r3) / (j - r3);
        this.playButton.setIsVisible(false, false);
        this.videoCoverTimelineView.setVideoPath(this.textureView, this.currentMedia.path, 1.0f - (((r0 - this.translateX) * 0.5f) / this.centerTranslateX), 1.0f - (((r7 - this.translateY) * 0.5f) / this.centerTranslateY), f2, this.videoCutStart, this.videoCutEnd);
        this.videoCoverTimelineView.setVisibility(0);
    }

    private void prepareBottomNavigation() throws IllegalArgumentException {
        AddPostBottomTab addPostBottomTab = new AddPostBottomTab(getParentActivity());
        this.bottomScrollSlidingTextTabStrip = addPostBottomTab;
        addPostBottomTab.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.bottomScrollSlidingTextTabStrip.setColors(Theme.key_rubino_add_post_TabLine, Theme.key_rubino_add_post_TabActiveText, Theme.key_rubino_add_post_TabUnactiveText, Theme.key_rubino_add_post_TabSelector);
        this.bottomScrollSlidingTextTabStrip.setUseSameWidth(true);
        this.containerView.addView(this.bottomScrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 44, 83));
        this.bottomScrollSlidingTextTabStrip.setDelegate(new AddPostBottomTab.AddPostBottomTabDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.11
            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab.AddPostBottomTabDelegate
            public void onPageScrolled(float f) {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab.AddPostBottomTabDelegate
            public /* synthetic */ void onSamePageSelected() {
                AddPostBottomTab.AddPostBottomTabDelegate.CC.$default$onSamePageSelected(this);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab.AddPostBottomTabDelegate
            public void onPageSelected(int i, boolean z) throws IllegalArgumentException {
                SSHPostActivity.this.setEditMode(i);
            }
        });
        this.bottomScrollSlidingTextTabStrip.addTextTab(102, LocaleController.getString("FILTER", R.string.rubinoActionFilter));
        if (this.currentMedia.isVideo) {
            this.bottomScrollSlidingTextTabStrip.addTextTab(103, LocaleController.getString("TRIM", R.string.rubinoActionTrim));
            this.bottomScrollSlidingTextTabStrip.addTextTab(104, LocaleController.getString("COVER", R.string.rubinoActionCover));
        } else {
            this.bottomScrollSlidingTextTabStrip.addTextTab(105, LocaleController.getString("Edit", R.string.rubinoActionEdit));
        }
        this.bottomScrollSlidingTextTabStrip.setVisibility(0);
        this.bottomScrollSlidingTextTabStrip.finishAddingTabs();
        setEditMode(102);
    }

    private void hideViews() {
        SSHVideoTimelinePlayView sSHVideoTimelinePlayView = this.videoTimelineView;
        if (sSHVideoTimelinePlayView != null) {
            sSHVideoTimelinePlayView.setVisibility(8);
        }
        SSHVideoCoverTimelinePlayView sSHVideoCoverTimelinePlayView = this.videoCoverTimelineView;
        if (sSHVideoCoverTimelinePlayView != null) {
            sSHVideoCoverTimelinePlayView.setVisibility(8);
        }
        SSHFilterView sSHFilterView = this.filterView;
        if (sSHFilterView != null) {
            sSHFilterView.scrollToPosition(0, false);
            this.filterView.setVisibility(8);
        }
        SSHPhotoEditView sSHPhotoEditView = this.photoEditView;
        if (sSHPhotoEditView != null) {
            sSHPhotoEditView.setVisibility(8);
        }
        if (this.currentMedia.isVideo) {
            this.loading.stop();
            this.playButton.setIsVisible(false, false);
            this.videoPlayer.pause();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void preparePlayer(android.net.Uri r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.preparePlayer(android.net.Uri, boolean):void");
    }

    /* renamed from: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$14, reason: invalid class name */
    class AnonymousClass14 implements AnalyticsListener {
        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
            AnalyticsListener.CC.$default$onAudioAttributesChanged(this, eventTime, audioAttributes);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
            AnalyticsListener.CC.$default$onAudioDecoderInitialized(this, eventTime, str, j);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onAudioDisabled(this, eventTime, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onAudioEnabled(this, eventTime, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
            AnalyticsListener.CC.$default$onAudioInputFormatChanged(this, eventTime, format);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j) {
            AnalyticsListener.CC.$default$onAudioPositionAdvancing(this, eventTime, j);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onAudioSessionId(this, eventTime, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
            AnalyticsListener.CC.$default$onAudioUnderrun(this, eventTime, i, j, j2);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
            AnalyticsListener.CC.$default$onBandwidthEstimate(this, eventTime, i, j, j2);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onDecoderDisabled(this, eventTime, i, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onDecoderEnabled(this, eventTime, i, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
            AnalyticsListener.CC.$default$onDecoderInitialized(this, eventTime, i, str, j);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
            AnalyticsListener.CC.$default$onDecoderInputFormatChanged(this, eventTime, i, format);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onDownstreamFormatChanged(this, eventTime, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmKeysLoaded(this, eventTime);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmKeysRemoved(this, eventTime);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmKeysRestored(this, eventTime);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmSessionAcquired(this, eventTime);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
            AnalyticsListener.CC.$default$onDrmSessionManagerError(this, eventTime, exc);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmSessionReleased(this, eventTime);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
            AnalyticsListener.CC.$default$onDroppedVideoFrames(this, eventTime, i, j);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            onLoadingChanged(eventTime, z);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            AnalyticsListener.CC.$default$onIsPlayingChanged(this, eventTime, z);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onLoadCanceled(this, eventTime, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onLoadCompleted(this, eventTime, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            AnalyticsListener.CC.$default$onLoadError(this, eventTime, loadEventInfo, mediaLoadData, iOException, z);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onLoadStarted(this, eventTime, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            AnalyticsListener.CC.$default$onLoadingChanged(this, eventTime, z);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
            AnalyticsListener.CC.$default$onMediaItemTransition(this, eventTime, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
            AnalyticsListener.CC.$default$onMetadata(this, eventTime, metadata);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
            AnalyticsListener.CC.$default$onPlayWhenReadyChanged(this, eventTime, z, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
            AnalyticsListener.CC.$default$onPlaybackParametersChanged(this, eventTime, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onPlaybackStateChanged(this, eventTime, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onPlaybackSuppressionReasonChanged(this, eventTime, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
            AnalyticsListener.CC.$default$onPlayerError(this, eventTime, exoPlaybackException);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
            AnalyticsListener.CC.$default$onPlayerStateChanged(this, eventTime, z, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onPositionDiscontinuity(this, eventTime, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
            AnalyticsListener.CC.$default$onRenderedFirstFrame(this, eventTime, surface);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onRepeatModeChanged(this, eventTime, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            AnalyticsListener.CC.$default$onShuffleModeChanged(this, eventTime, z);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            AnalyticsListener.CC.$default$onSkipSilenceEnabledChanged(this, eventTime, z);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
            AnalyticsListener.CC.$default$onSurfaceSizeChanged(this, eventTime, i, i2);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onTimelineChanged(this, eventTime, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            AnalyticsListener.CC.$default$onTracksChanged(this, eventTime, trackGroupArray, trackSelectionArray);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onUpstreamDiscarded(this, eventTime, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
            AnalyticsListener.CC.$default$onVideoDecoderInitialized(this, eventTime, str, j);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onVideoDisabled(this, eventTime, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onVideoEnabled(this, eventTime, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j, int i) {
            AnalyticsListener.CC.$default$onVideoFrameProcessingOffset(this, eventTime, j, i);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
            AnalyticsListener.CC.$default$onVideoInputFormatChanged(this, eventTime, format);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
            AnalyticsListener.CC.$default$onVideoSizeChanged(this, eventTime, i, i2, i3, f);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
            AnalyticsListener.CC.$default$onVolumeChanged(this, eventTime, f);
        }

        AnonymousClass14() {
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            if (SSHPostActivity.this.isLoading) {
                return;
            }
            if (SSHPostActivity.this.editMode == 103 || SSHPostActivity.this.editMode == 102) {
                SSHPostActivity.this.playButton.setIsVisible(true, false);
                SSHPostActivity.this.loading.start();
                SSHPostActivity.this.isLoading = true;
            }
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        /* renamed from: onSeekProcessed, reason: merged with bridge method [inline-methods] */
        public void lambda$onSeekProcessed$0(final AnalyticsListener.EventTime eventTime) {
            if (SSHPostActivity.this.editMode == 104) {
                SSHPostActivity.this.videoCoverTimelineView.loadCurrentFrameBitmap();
                return;
            }
            if (SSHPostActivity.this.editMode == 103 || SSHPostActivity.this.editMode == 102) {
                synchronized (SSHPostActivity.this.lock) {
                    if (SSHPostActivity.this.isLoading) {
                        if (System.currentTimeMillis() - SSHPostActivity.this.lastMoveTime > 250) {
                            SSHPostActivity.this.isLoading = false;
                            SSHPostActivity.this.playButton.setIsVisible(true, false);
                            SSHPostActivity.this.loading.stop();
                        } else {
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$14$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onSeekProcessed$0(eventTime);
                                }
                            }, 150L);
                        }
                    }
                }
            }
        }
    }

    private void prepareImageView(Context context) {
        SSHPhotoFilterBlurControl sSHPhotoFilterBlurControl = new SSHPhotoFilterBlurControl(context);
        this.blurControl = sSHPhotoFilterBlurControl;
        sSHPhotoFilterBlurControl.setVisibility(4);
        this.blurControl.setDelegate(new SSHPhotoFilterBlurControl.PhotoFilterLinearBlurControlDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$$ExternalSyntheticLambda7
            @Override // ir.appp.rghapp.components.SSHPhotoFilterBlurControl.PhotoFilterLinearBlurControlDelegate
            public final void valueChanged(Point point, float f, float f2, float f3, boolean z, float f4) {
                this.f$0.lambda$prepareImageView$9(point, f, f2, f3, z, f4);
            }
        });
        SSHPhotoFilterBlurControl sSHPhotoFilterBlurControl2 = this.blurControl;
        float f = sSHPhotoFilterBlurControl2.size;
        this.blurExcludeSize = f;
        Point point = sSHPhotoFilterBlurControl2.centerPoint;
        this.blurExcludePoint = point;
        float f2 = sSHPhotoFilterBlurControl2.falloff;
        this.blurExcludeBlurSize = f2;
        float f3 = sSHPhotoFilterBlurControl2.angle;
        this.blurAngle = f3;
        this.lastBlurExcludeSize = f;
        this.lastBlurExcludePoint = point;
        this.lastBlurExcludeBlurSize = f2;
        this.lastBlurAngle = f3;
        this.containerView.addView(sSHPhotoFilterBlurControl2, LayoutHelper.createFrame(-1, -1, 51));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareImageView$9(Point point, float f, float f2, float f3, boolean z, float f4) {
        this.blurExcludeSize = f2;
        float height = (this.currentMedia.bitmap.getHeight() - this.currentMedia.bitmap.getWidth()) / 2.0f;
        float f5 = point.y;
        this.blurExcludePoint = new Point(point.x, f5 - (((((-height) * f5) / 0.5f) + height) / this.currentMedia.bitmap.getWidth()));
        this.blurExcludeBlurSize = f;
        this.whiteSurfaceAlphaSize = f4;
        this.blurAngle = f3;
        SSHFilterGLThread sSHFilterGLThread = this.eglThread;
        if (sSHFilterGLThread != null) {
            sSHFilterGLThread.requestRender(true, z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTextureView(Context context) {
        if (this.textureView != null) {
            return;
        }
        if (this.aspectRatioFrameLayout == null) {
            AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(context);
            this.aspectRatioFrameLayout = aspectRatioFrameLayout;
            this.containerView.addView(aspectRatioFrameLayout, 0, LayoutHelper.createFrame(-1, -1, 48));
        }
        TextureView textureView = new TextureView(context);
        this.textureView = textureView;
        textureView.setSurfaceTextureListener(new AnonymousClass15(context));
        this.textureView.setPivotX(0.0f);
        this.textureView.setPivotY(0.0f);
        this.textureView.setOpaque(false);
        this.aspectRatioFrameLayout.setAspectRatio(this.currentMedia.bitmap.getWidth() / this.currentMedia.bitmap.getHeight(), 0);
        ImageView imageView = new ImageView(context);
        this.previewImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.previewImageView.setVisibility(8);
        this.aspectRatioFrameLayout.addView(this.textureView, LayoutHelper.createFrame(-1, -1, 48));
        this.aspectRatioFrameLayout.addView(this.previewImageView, LayoutHelper.createFrame(-1, -1, 48));
    }

    /* renamed from: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$15, reason: invalid class name */
    class AnonymousClass15 implements TextureView.SurfaceTextureListener {
        final /* synthetic */ Context val$context;

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        AnonymousClass15(Context context) {
            this.val$context = context;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (SSHPostActivity.this.eglThread != null || surfaceTexture == null) {
                return;
            }
            if (SSHPostActivity.this.currentMedia.isVideo) {
                SSHPostActivity.this.eglThread = new SSHFilterGLThread(0, this.val$context, surfaceTexture, true, SSHPostActivity.this.currentMedia.bitmap, SSHPostActivity.this.currentMedia.orientation, SSHPostActivity.this.isMirrored, new SSHFilterGLThread.FilterGLThreadVideoDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$15$$ExternalSyntheticLambda1
                    @Override // ir.appp.rghapp.components.SSHFilterGLThread.FilterGLThreadVideoDelegate
                    public final void onVideoSurfaceCreated(SurfaceTexture surfaceTexture2) {
                        this.f$0.lambda$onSurfaceTextureAvailable$0(surfaceTexture2);
                    }
                }, new SSHFilterGLThread.FilterGLThreadRenderDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$15$$ExternalSyntheticLambda0
                    @Override // ir.appp.rghapp.components.SSHFilterGLThread.FilterGLThreadRenderDelegate
                    public final void onRenderDataAvailable(int i3) {
                        this.f$0.lambda$onSurfaceTextureAvailable$2(i3);
                    }
                });
            } else {
                SSHPostActivity.this.eglThread = new SSHFilterGLThread(0, this.val$context, surfaceTexture, false, SSHPostActivity.this.currentMedia.bitmap, 0, SSHPostActivity.this.isMirrored, null, null);
            }
            SSHPostActivity.this.eglThread.setFilterGLThreadDelegate(SSHPostActivity.this);
            SSHPostActivity.this.eglThread.setSurfaceTextureSize(i, i2);
            SSHPostActivity.this.eglThread.requestRender(true, true, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSurfaceTextureAvailable$0(SurfaceTexture surfaceTexture) {
            SSHPostActivity.this.videoPlayer.setSurface(new Surface(surfaceTexture));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSurfaceTextureAvailable$2(int i) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$15$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSurfaceTextureAvailable$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSurfaceTextureAvailable$1() {
            if (SSHPostActivity.this.finishVideoEditing) {
                SSHPostActivity.this.finishVideoEditing = false;
                SSHPostActivity.this.currentMedia.editedInfo.coverPhotoBitmap = SSHPostActivity.this.textureView.getBitmap();
                SSHPostActivity.this.finishVideoEditing();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (SSHPostActivity.this.eglThread != null) {
                SSHPostActivity.this.eglThread.setSurfaceTextureSize(i, i2);
                SSHPostActivity.this.eglThread.requestRender(false, true, false);
                SSHPostActivity.this.eglThread.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity$15$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onSurfaceTextureSizeChanged$3();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSurfaceTextureSizeChanged$3() {
            if (SSHPostActivity.this.eglThread != null) {
                SSHPostActivity.this.eglThread.requestRender(false, true, false);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (SSHPostActivity.this.eglThread == null) {
                return true;
            }
            SSHPostActivity.this.eglThread.shutdown();
            SSHPostActivity.this.eglThread = null;
            return true;
        }
    }

    public void getSavedFilterState() {
        RGHMediaHelper$SavedFilterState rGHMediaHelper$SavedFilterState = this.currentMedia.savedFilterState;
        rGHMediaHelper$SavedFilterState.luxValue = this.luxValue;
        rGHMediaHelper$SavedFilterState.brightnessValue = this.brightnessValue;
        rGHMediaHelper$SavedFilterState.contrastValue = this.contrastValue;
        rGHMediaHelper$SavedFilterState.warmthValue = this.warmthValue;
        rGHMediaHelper$SavedFilterState.saturationValue = this.saturationValue;
        rGHMediaHelper$SavedFilterState.fadeValue = this.fadeValue;
        rGHMediaHelper$SavedFilterState.tintShadowsColor = this.tintShadowsColor;
        rGHMediaHelper$SavedFilterState.tintShadowsIntensity = this.tintShadowsIntensity;
        rGHMediaHelper$SavedFilterState.tintHighlightsColor = this.tintHighlightsColor;
        rGHMediaHelper$SavedFilterState.tintHighlightsIntensity = this.tintHighlightsIntensity;
        rGHMediaHelper$SavedFilterState.highlightsValue = this.highlightsValue;
        rGHMediaHelper$SavedFilterState.shadowsValue = this.shadowsValue;
        rGHMediaHelper$SavedFilterState.vignetteValue = this.vignetteValue;
        rGHMediaHelper$SavedFilterState.blurType = this.blurType;
        rGHMediaHelper$SavedFilterState.sharpenValue = this.sharpenValue;
        rGHMediaHelper$SavedFilterState.blurExcludeSize = this.blurExcludeSize;
        rGHMediaHelper$SavedFilterState.blurExcludePoint = this.blurExcludePoint;
        rGHMediaHelper$SavedFilterState.blurExcludeBlurSize = this.blurExcludeBlurSize;
        rGHMediaHelper$SavedFilterState.blurAngle = this.blurAngle;
        rGHMediaHelper$SavedFilterState.filterId = this.filterIdValue;
        rGHMediaHelper$SavedFilterState.filterSize = this.filterSizeValue;
    }

    public void getSavedCropState() {
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
        if (rGHMediaHelper$PhotoEntry.isVideo) {
            rGHMediaHelper$PhotoEntry.editedInfo.cropState.cropPx = this.translateX / (this.textureView.getWidth() * this.scale);
            this.currentMedia.editedInfo.cropState.cropPy = this.translateY / (this.textureView.getHeight() * this.scale);
            return;
        }
        RectF rectF = new RectF();
        rectF.set(MediaController.getInstance().getAddPostCropArea());
        this.currentMedia.editedInfo.resultWidth = (int) Math.ceil(ImageLoader.scaleWidthToMaxSize(rectF, new RectF(0.0f, 0.0f, 800.0f, 800.0f)));
        this.currentMedia.editedInfo.resultHeight = (int) Math.ceil(r0.resultWidth / (MediaController.getInstance().getAddPostCropArea().width() / MediaController.getInstance().getAddPostCropArea().height()));
        VideoEditedInfo videoEditedInfo = this.currentMedia.editedInfo;
        int[] iArrFixVideoWidthHeight = MediaController.fixVideoWidthHeight(videoEditedInfo.resultWidth, videoEditedInfo.resultHeight);
        VideoEditedInfo videoEditedInfo2 = this.currentMedia.editedInfo;
        videoEditedInfo2.resultWidth = iArrFixVideoWidthHeight[0];
        videoEditedInfo2.resultHeight = iArrFixVideoWidthHeight[1];
    }

    private void getCurrentVideoEditedInfo() {
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
        if (rGHMediaHelper$PhotoEntry.isVideo) {
            VideoEditedInfo videoEditedInfo = rGHMediaHelper$PhotoEntry.editedInfo;
            MediaController.CropState cropState = videoEditedInfo.cropState;
            cropState.translateX = this.translateX;
            cropState.translateY = this.translateY;
            videoEditedInfo.swipeX = this.videoTimeLineSwipeX;
            float f = this.videoCutStart;
            float f2 = this.videoDuration;
            videoEditedInfo.startTime = (long) (f * f2 * 1000.0f);
            float f3 = this.videoCutEnd;
            videoEditedInfo.endTime = (long) (f3 * f2 * 1000.0f);
            videoEditedInfo.start = f;
            videoEditedInfo.end = f3;
            videoEditedInfo.rotationValue = 0;
            videoEditedInfo.originalWidth = this.originalWidth;
            videoEditedInfo.originalHeight = this.originalHeight;
            videoEditedInfo.originalPath = rGHMediaHelper$PhotoEntry.path;
            double d = rGHMediaHelper$PhotoEntry.size;
            double dCeil = Math.ceil((f3 - f) * f2);
            double d2 = this.videoDuration;
            Double.isNaN(d2);
            Double.isNaN(d);
            videoEditedInfo.estimatedSize = (long) (d * (dCeil / d2));
            this.currentMedia.editedInfo.estimatedDuration = ((long) Math.ceil((this.videoCutEnd - this.videoCutStart) * r0)) * 1000;
            VideoEditedInfo videoEditedInfo2 = this.currentMedia.editedInfo;
            videoEditedInfo2.framerate = this.videoFramerate;
            videoEditedInfo2.originalDuration = (long) (this.videoDuration * 1000.0f);
            if (this.bitrate != 0) {
                this.bitrate = MediaController.makeVideoBitrate2(this.originalHeight, this.originalWidth, this.originalBitrate, this.resultHeight, this.resultWidth);
            }
            VideoEditedInfo videoEditedInfo3 = this.currentMedia.editedInfo;
            boolean z = this.muteVideo;
            videoEditedInfo3.bitrate = z ? -1 : this.bitrate;
            videoEditedInfo3.muted = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDraw(Canvas canvas) {
        float rubinoContainerViewHeight;
        int width;
        if (this.textureView == null || this.currentMedia == null) {
            return;
        }
        canvas.save();
        canvas.clipRect(MediaController.getInstance().getAddPostCropArea());
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
        if (rGHMediaHelper$PhotoEntry.isVideo) {
            this.scale = rGHMediaHelper$PhotoEntry.editedInfo.cropState.scale;
            if (this.textureView.getHeight() > this.textureView.getWidth()) {
                this.scale = MediaController.getInstance().getAddPostCropArea().width() / this.textureView.getWidth();
            } else if (this.textureView.getHeight() < this.textureView.getWidth()) {
                this.scale = MediaController.getInstance().getAddPostCropArea().height() / this.textureView.getHeight();
            }
            updateMinMax(this.scale);
            this.centerTranslateX = (-(((int) (this.textureView.getWidth() * this.scale)) - MediaController.getRubinoContainerViewWidth())) / 2;
            this.centerTranslateY = (-(((int) (this.textureView.getHeight() * this.scale)) - MediaController.getRubinoContainerViewHeight())) / 2;
            canvas.translate(this.translateX + this.centerTranslateX, this.translateY + r0);
            float f = this.scale;
            canvas.scale(f, f);
        } else {
            if (this.textureView.getHeight() > this.textureView.getWidth()) {
                rubinoContainerViewHeight = MediaController.getRubinoContainerViewWidth();
                width = this.textureView.getHeight();
            } else {
                rubinoContainerViewHeight = MediaController.getRubinoContainerViewHeight();
                width = this.textureView.getWidth();
            }
            float f2 = rubinoContainerViewHeight / width;
            canvas.translate((-(((int) (this.textureView.getWidth() * f2)) - MediaController.getRubinoContainerViewWidth())) / 2, (-(((int) (this.textureView.getHeight() * f2)) - MediaController.getRubinoContainerViewHeight())) / 2);
            canvas.scale(f2, f2);
        }
        this.aspectRatioFrameLayout.draw(canvas);
        needHideProgress();
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            if (!this.currentMedia.isVideo) {
                this.showOriginal = true;
                SSHFilterGLThread sSHFilterGLThread = this.eglThread;
                if (sSHFilterGLThread != null) {
                    sSHFilterGLThread.requestRender(true);
                }
            }
            int i = (int) x;
            this.startX = i;
            this.firstX = i;
            int i2 = (int) y;
            this.startY = i2;
            this.firstY = i2;
            return true;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (!this.currentMedia.isVideo) {
                this.showOriginal = false;
                SSHFilterGLThread sSHFilterGLThread2 = this.eglThread;
                if (sSHFilterGLThread2 != null) {
                    sSHFilterGLThread2.requestRender(true);
                }
            }
            if ((Math.abs(x - this.firstX) >= 3.0f && Math.abs(x - this.firstY) >= 3.0f) || mDeBounce > motionEvent.getDownTime() || this.editMode == 104) {
                return true;
            }
            onSingleTapConfirmed(motionEvent);
            mDeBounce = motionEvent.getEventTime();
            return true;
        }
        if (motionEvent.getAction() != 2 || this.editMode != 103) {
            return true;
        }
        this.startX = (int) x;
        this.startY = (int) y;
        int i3 = this.translateX + ((int) (x - this.startX));
        this.translateX = i3;
        int i4 = this.translateY + ((int) (y - this.startY));
        this.translateY = i4;
        float f = i3;
        float f2 = this.minX;
        if (f < f2) {
            this.translateX = (int) f2;
        }
        float f3 = this.translateX;
        float f4 = this.maxX;
        if (f3 > f4) {
            this.translateX = (int) f4;
        }
        float f5 = i4;
        float f6 = this.minY;
        if (f5 < f6) {
            this.translateY = (int) f6;
        }
        float f7 = this.translateY;
        float f8 = this.maxY;
        if (f7 > f8) {
            this.translateY = (int) f8;
        }
        this.containerView.invalidate();
        return true;
    }

    public void onSingleTapConfirmed(MotionEvent motionEvent) {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null) {
            return;
        }
        if (videoPlayer.isPlaying()) {
            SSHVideoTimelinePlayView sSHVideoTimelinePlayView = this.videoTimelineView;
            if (sSHVideoTimelinePlayView != null) {
                sSHVideoTimelinePlayView.isPlaying(false);
            }
            this.playButton.setIsVisible(true, true);
            this.videoPlayer.pause();
            return;
        }
        SSHVideoTimelinePlayView sSHVideoTimelinePlayView2 = this.videoTimelineView;
        if (sSHVideoTimelinePlayView2 != null) {
            sSHVideoTimelinePlayView2.isPlaying(true);
        }
        this.videoPlayer.play();
        this.playButton.setIsVisible(false, true);
    }

    private class FrameLayoutDrawer2 extends SizeNotifierFrameLayoutPhoto {
        public FrameLayoutDrawer2(Context context) {
            super(context, false);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return SSHPostActivity.this.onTouchEvent(motionEvent);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    if (childAt == SSHPostActivity.this.aspectRatioFrameLayout) {
                        childAt.measure(i, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.displaySize.y, 1073741824));
                    } else {
                        measureChildWithMargins(childAt, i, 0, i2, 0);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayoutPhoto, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r14, int r15, int r16, int r17, int r18) {
            /*
                r13 = this;
                r0 = r13
                int r1 = r13.getChildCount()
                r2 = 0
            L6:
                if (r2 >= r1) goto L94
                android.view.View r3 = r13.getChildAt(r2)
                int r4 = r3.getVisibility()
                r5 = 8
                if (r4 != r5) goto L16
                goto L90
            L16:
                ir.appp.rghapp.rubinoPostSlider.SSHPostActivity r4 = ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.this
                com.google.android.exoplayer2t.ui.AspectRatioFrameLayout r4 = ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.access$1700(r4)
                if (r3 != r4) goto L24
                r4 = r15
                r5 = r17
                r6 = r18
                goto L35
            L24:
                int r4 = r13.getPaddingLeft()
                int r4 = r4 + r15
                int r5 = r13.getPaddingRight()
                int r5 = r17 - r5
                int r6 = r13.getPaddingBottom()
                int r6 = r18 - r6
            L35:
                android.view.ViewGroup$LayoutParams r7 = r3.getLayoutParams()
                android.widget.FrameLayout$LayoutParams r7 = (android.widget.FrameLayout.LayoutParams) r7
                int r8 = r3.getMeasuredWidth()
                int r9 = r3.getMeasuredHeight()
                int r10 = r7.gravity
                r11 = -1
                if (r10 != r11) goto L4a
                r10 = 51
            L4a:
                r11 = r10 & 7
                r10 = r10 & 112(0x70, float:1.57E-43)
                r11 = r11 & 7
                r12 = 1
                if (r11 == r12) goto L5e
                r12 = 5
                if (r11 == r12) goto L59
                int r5 = r7.leftMargin
                goto L68
            L59:
                int r5 = r5 - r4
                int r5 = r5 - r8
                int r11 = r7.rightMargin
                goto L67
            L5e:
                int r5 = r5 - r4
                int r5 = r5 - r8
                int r5 = r5 / 2
                int r11 = r7.leftMargin
                int r5 = r5 + r11
                int r11 = r7.rightMargin
            L67:
                int r5 = r5 - r11
            L68:
                r11 = 16
                if (r10 == r11) goto L7b
                r11 = 80
                if (r10 == r11) goto L73
                int r6 = r7.topMargin
                goto L88
            L73:
                int r6 = r6 + 0
                int r6 = r6 - r16
                int r6 = r6 - r9
                int r7 = r7.bottomMargin
                goto L87
            L7b:
                int r6 = r6 + 0
                int r6 = r6 - r16
                int r6 = r6 - r9
                int r6 = r6 / 2
                int r10 = r7.topMargin
                int r6 = r6 + r10
                int r7 = r7.bottomMargin
            L87:
                int r6 = r6 - r7
            L88:
                int r7 = r5 + r4
                int r5 = r5 + r8
                int r5 = r5 + r4
                int r9 = r9 + r6
                r3.layout(r7, r6, r5, r9)
            L90:
                int r2 = r2 + 1
                goto L6
            L94:
                r13.notifyHeightChanged()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.FrameLayoutDrawer2.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            try {
                if (view != SSHPostActivity.this.aspectRatioFrameLayout) {
                    if (super.drawChild(canvas, view, j)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                return true;
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            SSHPostActivity.this.onDraw(canvas);
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            super.requestLayout();
        }
    }
}
