package ir.appp.vod.ui.customViews.exo;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.R$styleable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import ir.medu.shad.R;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.MessagesController;

/* compiled from: PlayerControlView.kt */
/* loaded from: classes3.dex */
public final class PlayerControlView extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    private boolean _isAttachedToWindow;
    private long[] adGroupTimesMs;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final ComponentListener componentListener;
    private ControlDispatcher controlDispatcher;
    private long currentWindowOffset;
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;
    private final View fastForwardButton;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private final Runnable hideAction;
    private long hideAtMs;
    private boolean mVisibility;
    private boolean multiWindowTimeBar;
    private final View nextButton;
    private final View pauseButton;
    private final Timeline.Period period;
    private final View playButton;
    private PlaybackPreparer playbackPreparer;
    private boolean[] playedAdGroups;
    private Player player;
    private final TextView positionView;
    private final View previousButton;
    private ProgressUpdateListener progressUpdateListener;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;
    private final ImageView repeatToggleButton;
    private int repeatToggleModes;
    private final View rewindButton;
    private boolean scrubbing;
    private boolean showFastForwardButton;
    private boolean showMultiWindowTimeBar;
    private boolean showNextButton;
    private boolean showPreviousButton;
    private boolean showRewindButton;
    private boolean showShuffleButton;
    private long showTimeoutMs;
    private final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;
    private TimeBar timeBar;
    private long timeBarMinUpdateIntervalMs;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList<VisibilityListener> visibilityListeners;
    private final View vrButton;
    private final Timeline.Window window;

    /* compiled from: PlayerControlView.kt */
    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    /* compiled from: PlayerControlView.kt */
    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    private static /* synthetic */ void getRepeatToggleModes$annotations() {
    }

    /* compiled from: PlayerControlView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isHandledMediaKey(int i) {
            return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getRepeatToggleModes(TypedArray typedArray, int i) {
            return typedArray.getInt(9, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean canShowMultiWindowTimeBar(Timeline timeline, Timeline.Window window) {
            if (timeline.getWindowCount() > 100) {
                return false;
            }
            int windowCount = timeline.getWindowCount();
            int i = 0;
            while (i < windowCount) {
                int i2 = i + 1;
                if (timeline.getWindow(i, window).durationUs == -9223372036854775807L) {
                    return false;
                }
                i = i2;
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerControlView(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.showTimeoutMs = 5000L;
        this.repeatToggleModes = DEFAULT_REPEAT_TOGGLE_MODES;
        this.timeBarMinUpdateIntervalMs = 200L;
        this.hideAtMs = -9223372036854775807L;
        this.showRewindButton = true;
        this.showFastForwardButton = true;
        this.showPreviousButton = true;
        this.showNextButton = true;
        this.showShuffleButton = false;
        int resourceId = R.layout.exo_player_control_view;
        int i2 = 5000;
        int i3 = 15000;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context\n                ….PlayerControlView, 0, 0)");
            try {
                i2 = typedArrayObtainStyledAttributes.getInt(10, 5000);
                i3 = typedArrayObtainStyledAttributes.getInt(6, 15000);
                this.showTimeoutMs = typedArrayObtainStyledAttributes.getInt(21, (int) this.showTimeoutMs);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(5, R.layout.exo_player_control_view);
                this.repeatToggleModes = Companion.getRepeatToggleModes(typedArrayObtainStyledAttributes, this.repeatToggleModes);
                this.showRewindButton = typedArrayObtainStyledAttributes.getBoolean(19, this.showRewindButton);
                this.showFastForwardButton = typedArrayObtainStyledAttributes.getBoolean(16, this.showFastForwardButton);
                this.showPreviousButton = typedArrayObtainStyledAttributes.getBoolean(18, this.showPreviousButton);
                this.showNextButton = typedArrayObtainStyledAttributes.getBoolean(17, this.showNextButton);
                this.showShuffleButton = typedArrayObtainStyledAttributes.getBoolean(20, this.showShuffleButton);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(22, (int) this.timeBarMinUpdateIntervalMs));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.visibilityListeners = new CopyOnWriteArrayList<>();
        this.period = new Timeline.Period();
        this.window = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.formatBuilder = sb;
        this.formatter = new Formatter(sb, Locale.getDefault());
        this.adGroupTimesMs = new long[0];
        this.playedAdGroups = new boolean[0];
        this.extraAdGroupTimesMs = new long[0];
        this.extraPlayedAdGroups = new boolean[0];
        ComponentListener componentListener = new ComponentListener(this);
        this.componentListener = componentListener;
        this.controlDispatcher = new DefaultControlDispatcher(i3, i2);
        this.updateProgressAction = new Runnable() { // from class: ir.appp.vod.ui.customViews.exo.PlayerControlView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView.m386_init_$lambda0(this.f$0);
            }
        };
        this.hideAction = new Runnable() { // from class: ir.appp.vod.ui.customViews.exo.PlayerControlView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView.m387_init_$lambda1(this.f$0);
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(MessagesController.UPDATE_MASK_CHAT_MUTE);
        TimeBar timeBar = (TimeBar) findViewById(R.id.exo_progress);
        View viewFindViewById = findViewById(R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.timeBar = timeBar;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(R.id.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewParent parent = viewFindViewById.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.timeBar = defaultTimeBar;
        } else {
            this.timeBar = null;
        }
        this.durationView = (TextView) findViewById(R.id.exo_duration);
        this.positionView = (TextView) findViewById(R.id.exo_position);
        TimeBar timeBar2 = this.timeBar;
        if (timeBar2 != null && timeBar2 != null) {
            timeBar2.addListener(componentListener);
        }
        View viewFindViewById2 = findViewById(R.id.exo_play);
        this.playButton = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(componentListener);
        }
        View viewFindViewById3 = findViewById(R.id.exo_pause);
        this.pauseButton = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(componentListener);
        }
        View viewFindViewById4 = findViewById(R.id.exo_prev);
        this.previousButton = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(componentListener);
        }
        View viewFindViewById5 = findViewById(R.id.exo_next);
        this.nextButton = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(componentListener);
        }
        View viewFindViewById6 = findViewById(R.id.exo_rew);
        this.rewindButton = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(componentListener);
        }
        View viewFindViewById7 = findViewById(R.id.exo_ffwd);
        this.fastForwardButton = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(componentListener);
        }
        ImageView imageView = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.repeatToggleButton = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_shuffle);
        this.shuffleButton = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(componentListener);
        }
        View viewFindViewById8 = findViewById(R.id.exo_vr);
        this.vrButton = viewFindViewById8;
        setShowVrButton(false);
        updateButton(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        float f = 100;
        this.buttonAlphaEnabled = resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled) / f;
        this.buttonAlphaDisabled = resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled) / f;
        Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.exo_controls_repeat_off, null);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(resources, R…trols_repeat_off, null)!!");
        this.repeatOffButtonDrawable = drawable;
        Drawable drawable2 = ResourcesCompat.getDrawable(resources, R.drawable.exo_controls_repeat_one, null);
        Intrinsics.checkNotNull(drawable2);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(resources, R…trols_repeat_one, null)!!");
        this.repeatOneButtonDrawable = drawable2;
        Drawable drawable3 = ResourcesCompat.getDrawable(resources, R.drawable.exo_controls_repeat_all, null);
        Intrinsics.checkNotNull(drawable3);
        Intrinsics.checkNotNullExpressionValue(drawable3, "getDrawable(resources, R…trols_repeat_all, null)!!");
        this.repeatAllButtonDrawable = drawable3;
        Drawable drawable4 = ResourcesCompat.getDrawable(resources, R.drawable.exo_controls_shuffle_on, null);
        Intrinsics.checkNotNull(drawable4);
        Intrinsics.checkNotNullExpressionValue(drawable4, "getDrawable(resources, R…trols_shuffle_on, null)!!");
        this.shuffleOnButtonDrawable = drawable4;
        Drawable drawable5 = ResourcesCompat.getDrawable(resources, R.drawable.exo_controls_shuffle_off, null);
        Intrinsics.checkNotNull(drawable5);
        Intrinsics.checkNotNullExpressionValue(drawable5, "getDrawable(resources, R…rols_shuffle_off, null)!!");
        this.shuffleOffButtonDrawable = drawable5;
        String string = resources.getString(R.string.exo_controls_repeat_off_description);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…s_repeat_off_description)");
        this.repeatOffButtonContentDescription = string;
        String string2 = resources.getString(R.string.exo_controls_repeat_one_description);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…s_repeat_one_description)");
        this.repeatOneButtonContentDescription = string2;
        String string3 = resources.getString(R.string.exo_controls_repeat_all_description);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…s_repeat_all_description)");
        this.repeatAllButtonContentDescription = string3;
        String string4 = resources.getString(R.string.exo_controls_shuffle_on_description);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…s_shuffle_on_description)");
        this.shuffleOnContentDescription = string4;
        String string5 = resources.getString(R.string.exo_controls_shuffle_off_description);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…_shuffle_off_description)");
        this.shuffleOffContentDescription = string5;
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public final Player getPlayer() {
        return this.player;
    }

    public final void setPlayer(Player player) {
        Assertions.checkState(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        Assertions.checkArgument(player == null || Intrinsics.areEqual(player.getApplicationLooper(), Looper.getMainLooper()));
        Player player2 = this.player;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            Intrinsics.checkNotNull(player2);
            player2.removeListener(this.componentListener);
        }
        this.player = player;
        if (player != null) {
            player.addListener(this.componentListener);
        }
        updateAll();
    }

    public final void setShowMultiWindowTimeBar(boolean z) {
        this.showMultiWindowTimeBar = z;
        updateTimeline();
    }

    public final void addVisibilityListener(VisibilityListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Assertions.checkNotNull(listener);
        this.visibilityListeners.add(listener);
    }

    public final void removeVisibilityListener(VisibilityListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.visibilityListeners.remove(listener);
    }

    public final void setProgressUpdateListener(ProgressUpdateListener progressUpdateListener) {
        this.progressUpdateListener = progressUpdateListener;
    }

    public final void setPlaybackPreparer(PlaybackPreparer playbackPreparer) {
        this.playbackPreparer = playbackPreparer;
    }

    public final void setControlDispatcher(ControlDispatcher controlDispatcher) {
        Intrinsics.checkNotNullParameter(controlDispatcher, "controlDispatcher");
        if (this.controlDispatcher != controlDispatcher) {
            this.controlDispatcher = controlDispatcher;
            updateNavigation();
        }
    }

    public final void setShowRewindButton(boolean z) {
        this.showRewindButton = z;
        updateNavigation();
    }

    public final void setShowFastForwardButton(boolean z) {
        this.showFastForwardButton = z;
        updateNavigation();
    }

    public final void setShowPreviousButton(boolean z) {
        this.showPreviousButton = z;
        updateNavigation();
    }

    public final void setShowNextButton(boolean z) {
        this.showNextButton = z;
        updateNavigation();
    }

    public final void setRewindIncrementMs(int i) {
        ControlDispatcher controlDispatcher = this.controlDispatcher;
        if (controlDispatcher instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher).setRewindIncrementMs(i);
            updateNavigation();
        }
    }

    public final void setFastForwardIncrementMs(int i) {
        ControlDispatcher controlDispatcher = this.controlDispatcher;
        if (controlDispatcher instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher).setFastForwardIncrementMs(i);
            updateNavigation();
        }
    }

    public final long getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public final void setShowTimeoutMs(long j) {
        this.showTimeoutMs = j;
        if (isVisible()) {
            hideAfterTimeout();
        }
    }

    public final int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public final void setRepeatToggleModes(int i) {
        this.repeatToggleModes = i;
        Player player = this.player;
        if (player != null) {
            Intrinsics.checkNotNull(player);
            int repeatMode = player.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                ControlDispatcher controlDispatcher = this.controlDispatcher;
                Player player2 = this.player;
                Intrinsics.checkNotNull(player2);
                controlDispatcher.dispatchSetRepeatMode(player2, 0);
            } else if (i == 1 && repeatMode == 2) {
                ControlDispatcher controlDispatcher2 = this.controlDispatcher;
                Player player3 = this.player;
                Intrinsics.checkNotNull(player3);
                controlDispatcher2.dispatchSetRepeatMode(player3, 1);
            } else if (i == 2 && repeatMode == 1) {
                ControlDispatcher controlDispatcher3 = this.controlDispatcher;
                Player player4 = this.player;
                Intrinsics.checkNotNull(player4);
                controlDispatcher3.dispatchSetRepeatMode(player4, 2);
            }
        }
        updateRepeatModeButton();
    }

    public final boolean getShowShuffleButton() {
        return this.showShuffleButton;
    }

    public final void setShowShuffleButton(boolean z) {
        this.showShuffleButton = z;
        updateShuffleButton();
    }

    public final boolean getShowVrButton() {
        View view = this.vrButton;
        return view != null && view.getVisibility() == 0;
    }

    public final void setShowVrButton(boolean z) {
        View view = this.vrButton;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.vrButton;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            updateButton(getShowVrButton(), onClickListener != null, this.vrButton);
        }
    }

    public final void setTimeBarMinUpdateInterval(long j) {
        this.timeBarMinUpdateIntervalMs = Util.constrainValue(j, 16L, 1000L);
    }

    public final void showWithAnimation() {
        if (!isVisible()) {
            this.mVisibility = true;
            Iterator<VisibilityListener> it = this.visibilityListeners.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(0);
            }
            updateAll();
            requestPlayPauseFocus();
        }
        hideAfterTimeout();
    }

    public final void hideWithAnimation() {
        if (isVisible()) {
            this.mVisibility = false;
            Iterator<VisibilityListener> it = this.visibilityListeners.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(8);
            }
            removeCallbacks(this.updateProgressAction);
            removeCallbacks(this.hideAction);
            this.hideAtMs = -9223372036854775807L;
        }
    }

    public final boolean isVisible() {
        return this.mVisibility;
    }

    private final void hideAfterTimeout() {
        removeCallbacks(this.hideAction);
        if (this.showTimeoutMs > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j = this.showTimeoutMs;
            this.hideAtMs = jUptimeMillis + j;
            if (this._isAttachedToWindow) {
                postDelayed(this.hideAction, j);
                return;
            }
            return;
        }
        this.hideAtMs = -9223372036854775807L;
    }

    private final void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateRepeatModeButton();
        updateShuffleButton();
        updateTimeline();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePlayPauseButton() {
        boolean z;
        if (isVisible() && this._isAttachedToWindow) {
            boolean zShouldShowPauseButton = shouldShowPauseButton();
            View view = this.playButton;
            if (view != null) {
                z = (zShouldShowPauseButton && view.isFocused()) | false;
                this.playButton.setVisibility(zShouldShowPauseButton ? 8 : 0);
            } else {
                z = false;
            }
            View view2 = this.pauseButton;
            if (view2 != null) {
                z |= !zShouldShowPauseButton && view2.isFocused();
                this.pauseButton.setVisibility(zShouldShowPauseButton ? 0 : 8);
            }
            if (z) {
                requestPlayPauseFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateNavigation() {
        /*
            r8 = this;
            boolean r0 = r8.isVisible()
            if (r0 == 0) goto L96
            boolean r0 = r8._isAttachedToWindow
            if (r0 != 0) goto Lc
            goto L96
        Lc:
            com.google.android.exoplayer2.Player r0 = r8.player
            r1 = 0
            if (r0 == 0) goto L6e
            com.google.android.exoplayer2.Timeline r2 = r0.getCurrentTimeline()
            java.lang.String r3 = "player.currentTimeline"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L6e
            boolean r3 = r0.isPlayingAd()
            if (r3 != 0) goto L6e
            int r3 = r0.getCurrentWindowIndex()
            com.google.android.exoplayer2.Timeline$Window r4 = r8.window
            r2.getWindow(r3, r4)
            com.google.android.exoplayer2.Timeline$Window r2 = r8.window
            boolean r3 = r2.isSeekable
            r4 = 1
            if (r3 != 0) goto L43
            boolean r2 = r2.isDynamic
            if (r2 == 0) goto L43
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L41
            goto L43
        L41:
            r2 = 0
            goto L44
        L43:
            r2 = 1
        L44:
            if (r3 == 0) goto L50
            com.google.android.exoplayer2.ControlDispatcher r5 = r8.controlDispatcher
            boolean r5 = r5.isRewindEnabled()
            if (r5 == 0) goto L50
            r5 = 1
            goto L51
        L50:
            r5 = 0
        L51:
            if (r3 == 0) goto L5d
            com.google.android.exoplayer2.ControlDispatcher r6 = r8.controlDispatcher
            boolean r6 = r6.isFastForwardEnabled()
            if (r6 == 0) goto L5d
            r6 = 1
            goto L5e
        L5d:
            r6 = 0
        L5e:
            com.google.android.exoplayer2.Timeline$Window r7 = r8.window
            boolean r7 = r7.isDynamic
            if (r7 != 0) goto L6a
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L6b
        L6a:
            r1 = 1
        L6b:
            r0 = r1
            r1 = r2
            goto L72
        L6e:
            r0 = 0
            r3 = 0
            r5 = 0
            r6 = 0
        L72:
            boolean r2 = r8.showPreviousButton
            android.view.View r4 = r8.previousButton
            r8.updateButton(r2, r1, r4)
            boolean r1 = r8.showRewindButton
            android.view.View r2 = r8.rewindButton
            r8.updateButton(r1, r5, r2)
            boolean r1 = r8.showFastForwardButton
            android.view.View r2 = r8.fastForwardButton
            r8.updateButton(r1, r6, r2)
            boolean r1 = r8.showNextButton
            android.view.View r2 = r8.nextButton
            r8.updateButton(r1, r0, r2)
            com.google.android.exoplayer2.ui.TimeBar r0 = r8.timeBar
            if (r0 != 0) goto L93
            goto L96
        L93:
            r0.setEnabled(r3)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.ui.customViews.exo.PlayerControlView.updateNavigation():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRepeatModeButton() {
        ImageView imageView;
        if (isVisible() && this._isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                updateButton(false, false, imageView);
                return;
            }
            Player player = this.player;
            if (player == null) {
                updateButton(true, false, imageView);
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                return;
            }
            updateButton(true, true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
            } else if (repeatMode == 1) {
                this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
            } else if (repeatMode == 2) {
                this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
            }
            this.repeatToggleButton.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateShuffleButton() {
        ImageView imageView;
        if (isVisible() && this._isAttachedToWindow && (imageView = this.shuffleButton) != null) {
            Player player = this.player;
            if (!this.showShuffleButton) {
                updateButton(false, false, imageView);
                return;
            }
            if (player == null) {
                updateButton(true, false, imageView);
                this.shuffleButton.setImageDrawable(this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(this.shuffleOffContentDescription);
            } else {
                updateButton(true, true, imageView);
                this.shuffleButton.setImageDrawable(player.getShuffleModeEnabled() ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(player.getShuffleModeEnabled() ? this.shuffleOnContentDescription : this.shuffleOffContentDescription);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6 A[PHI: r6
      0x00a6: PHI (r6v11 long) = (r6v10 long), (r6v16 long) binds: [B:33:0x0093, B:35:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateTimeline() {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.ui.customViews.exo.PlayerControlView.updateTimeline():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProgress() {
        long contentBufferedPosition;
        if (isVisible() && this._isAttachedToWindow) {
            Player player = this.player;
            long contentPosition = 0;
            if (player != null) {
                contentPosition = this.currentWindowOffset + player.getContentPosition();
                contentBufferedPosition = this.currentWindowOffset + player.getContentBufferedPosition();
            } else {
                contentBufferedPosition = 0;
            }
            TextView textView = this.positionView;
            if (textView != null && !this.scrubbing) {
                textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, contentPosition));
            }
            TimeBar timeBar = this.timeBar;
            if (timeBar != null) {
                timeBar.setPosition(contentPosition);
            }
            TimeBar timeBar2 = this.timeBar;
            if (timeBar2 != null) {
                timeBar2.setBufferedPosition(contentBufferedPosition);
            }
            ProgressUpdateListener progressUpdateListener = this.progressUpdateListener;
            if (progressUpdateListener != null) {
                Intrinsics.checkNotNull(progressUpdateListener);
                progressUpdateListener.onProgressUpdate(contentPosition, contentBufferedPosition);
            }
            removeCallbacks(this.updateProgressAction);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.updateProgressAction, 1000L);
                return;
            }
            TimeBar timeBar3 = this.timeBar;
            long preferredUpdateDelay = timeBar3 == null ? 1000L : timeBar3.getPreferredUpdateDelay();
            long j = CloseCodes.NORMAL_CLOSURE;
            long jMin = Math.min(preferredUpdateDelay, j - (contentPosition % j));
            float f = player.getPlaybackParameters().speed;
            postDelayed(this.updateProgressAction, Util.constrainValue(f > 0.0f ? (long) (jMin / f) : 1000L, this.timeBarMinUpdateIntervalMs, 1000L));
        }
    }

    private final void requestPlayPauseFocus() {
        View view;
        View view2;
        boolean zShouldShowPauseButton = shouldShowPauseButton();
        if (!zShouldShowPauseButton && (view2 = this.playButton) != null) {
            view2.requestFocus();
        } else {
            if (!zShouldShowPauseButton || (view = this.pauseButton) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    private final void updateButton(boolean z, boolean z2, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        view.setAlpha(z2 ? this.buttonAlphaEnabled : this.buttonAlphaDisabled);
        view.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekToTimeBarPosition(Player player, long j) {
        int currentWindowIndex;
        Timeline currentTimeline = player.getCurrentTimeline();
        Intrinsics.checkNotNullExpressionValue(currentTimeline, "player.currentTimeline");
        if (this.multiWindowTimeBar && !currentTimeline.isEmpty()) {
            int windowCount = currentTimeline.getWindowCount();
            currentWindowIndex = 0;
            while (true) {
                long durationMs = currentTimeline.getWindow(currentWindowIndex, this.window).getDurationMs();
                if (j < durationMs) {
                    break;
                }
                if (currentWindowIndex == windowCount - 1) {
                    j = durationMs;
                    break;
                } else {
                    j -= durationMs;
                    currentWindowIndex++;
                }
            }
        } else {
            currentWindowIndex = player.getCurrentWindowIndex();
        }
        if (seekTo(player, currentWindowIndex, j)) {
            return;
        }
        updateProgress();
    }

    private final boolean seekTo(Player player, int i, long j) {
        return this.controlDispatcher.dispatchSeekTo(player, i, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this._isAttachedToWindow = true;
        long j = this.hideAtMs;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                hideWithAnimation();
            } else {
                postDelayed(this.hideAction, jUptimeMillis);
            }
        } else if (isVisible()) {
            hideAfterTimeout();
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this._isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        removeCallbacks(this.hideAction);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            removeCallbacks(this.hideAction);
        } else if (ev.getAction() == 1) {
            hideAfterTimeout();
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return dispatchMediaKeyEvent(event) || super.dispatchKeyEvent(event);
    }

    public final boolean dispatchMediaKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int keyCode = event.getKeyCode();
        Player player = this.player;
        if (player == null || !Companion.isHandledMediaKey(keyCode)) {
            return false;
        }
        if (event.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4) {
                return true;
            }
            this.controlDispatcher.dispatchFastForward(player);
            return true;
        }
        if (keyCode == 89) {
            this.controlDispatcher.dispatchRewind(player);
            return true;
        }
        if (event.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            dispatchPlayPause(player);
            return true;
        }
        if (keyCode == 87) {
            this.controlDispatcher.dispatchNext(player);
            return true;
        }
        if (keyCode == 88) {
            this.controlDispatcher.dispatchPrevious(player);
            return true;
        }
        if (keyCode == 126) {
            dispatchPlay(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        dispatchPause(player);
        return true;
    }

    private final boolean shouldShowPauseButton() {
        Player player = this.player;
        if (player != null) {
            Intrinsics.checkNotNull(player);
            if (player.getPlaybackState() != 4) {
                Player player2 = this.player;
                Intrinsics.checkNotNull(player2);
                if (player2.getPlaybackState() != 1) {
                    Player player3 = this.player;
                    Intrinsics.checkNotNull(player3);
                    if (player3.getPlayWhenReady()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final void dispatchPlayPause(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !player.getPlayWhenReady()) {
            dispatchPlay(player);
        } else {
            dispatchPause(player);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchPlay(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            PlaybackPreparer playbackPreparer = this.playbackPreparer;
            if (playbackPreparer != null) {
                Intrinsics.checkNotNull(playbackPreparer);
                playbackPreparer.preparePlayback();
            } else {
                this.controlDispatcher.dispatchPrepare(player);
            }
        } else if (playbackState == 4) {
            seekTo(player, player.getCurrentWindowIndex(), -9223372036854775807L);
        }
        this.controlDispatcher.dispatchSetPlayWhenReady(player, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchPause(Player player) {
        this.controlDispatcher.dispatchSetPlayWhenReady(player, false);
    }

    /* compiled from: PlayerControlView.kt */
    private final class ComponentListener implements Player.EventListener, TimeBar.OnScrubListener, View.OnClickListener {
        final /* synthetic */ PlayerControlView this$0;

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            onLoadingChanged(z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayerStateChanged(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        public ComponentListener(PlayerControlView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStart(TimeBar timeBar, long j) {
            Intrinsics.checkNotNullParameter(timeBar, "timeBar");
            this.this$0.scrubbing = true;
            if (this.this$0.positionView != null) {
                this.this$0.positionView.setText(Util.getStringForTime(this.this$0.formatBuilder, this.this$0.formatter, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubMove(TimeBar timeBar, long j) {
            Intrinsics.checkNotNullParameter(timeBar, "timeBar");
            if (this.this$0.positionView != null) {
                this.this$0.positionView.setText(Util.getStringForTime(this.this$0.formatBuilder, this.this$0.formatter, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStop(TimeBar timeBar, long j, boolean z) {
            Intrinsics.checkNotNullParameter(timeBar, "timeBar");
            this.this$0.scrubbing = false;
            if (z || this.this$0.player == null) {
                return;
            }
            PlayerControlView playerControlView = this.this$0;
            Player player = playerControlView.player;
            Intrinsics.checkNotNull(player);
            playerControlView.seekToTimeBarPosition(player, j);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            this.this$0.updatePlayPauseButton();
            this.this$0.updateProgress();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            this.this$0.updatePlayPauseButton();
            this.this$0.updateProgress();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onIsPlayingChanged(boolean z) {
            this.this$0.updateProgress();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
            this.this$0.updateRepeatModeButton();
            this.this$0.updateNavigation();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            this.this$0.updateShuffleButton();
            this.this$0.updateNavigation();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
            this.this$0.updateNavigation();
            this.this$0.updateTimeline();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, int i) {
            Intrinsics.checkNotNullParameter(timeline, "timeline");
            this.this$0.updateNavigation();
            this.this$0.updateTimeline();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Player player = this.this$0.player;
            if (player == null) {
                return;
            }
            if (this.this$0.nextButton == view) {
                this.this$0.controlDispatcher.dispatchNext(player);
                return;
            }
            if (this.this$0.previousButton == view) {
                this.this$0.controlDispatcher.dispatchPrevious(player);
                return;
            }
            if (this.this$0.fastForwardButton != view) {
                if (this.this$0.rewindButton == view) {
                    this.this$0.controlDispatcher.dispatchRewind(player);
                    return;
                }
                if (this.this$0.playButton == view) {
                    this.this$0.dispatchPlay(player);
                    return;
                }
                if (this.this$0.pauseButton == view) {
                    this.this$0.dispatchPause(player);
                    return;
                } else {
                    if (this.this$0.repeatToggleButton != view) {
                        if (this.this$0.shuffleButton == view) {
                            this.this$0.controlDispatcher.dispatchSetShuffleModeEnabled(player, !player.getShuffleModeEnabled());
                            return;
                        }
                        return;
                    }
                    this.this$0.controlDispatcher.dispatchSetRepeatMode(player, RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), this.this$0.repeatToggleModes));
                    return;
                }
            }
            if (player.getPlaybackState() != 4) {
                this.this$0.controlDispatcher.dispatchFastForward(player);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0, reason: not valid java name */
    public static final void m386_init_$lambda0(PlayerControlView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1, reason: not valid java name */
    public static final void m387_init_$lambda1(PlayerControlView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideWithAnimation();
    }
}
