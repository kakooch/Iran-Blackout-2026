package ir.appp.vod.ui.customViews.exo;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.R$styleable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsLoader$AdViewProvider;
import com.google.android.exoplayer2.source.ads.AdsLoader$OverlayInfo;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.ui.spherical.SingleTapListener;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.common.collect.ImmutableList;
import ir.appp.vod.ui.customViews.exo.PlayerControlView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.MessagesController;

/* compiled from: PlayerView.kt */
/* loaded from: classes3.dex */
public final class PlayerView extends FrameLayout implements AdsLoader$AdViewProvider {
    public static final Companion Companion = new Companion(null);
    private FrameLayout adOverlayFrameLayout;
    private ImageView artworkView;
    private View bufferingView;
    private final ComponentListener componentListener;
    private AspectRatioFrameLayout contentFrame;
    private PlayerControlView controller;
    private boolean controllerAutoShow;
    private boolean controllerHideDuringAds;
    private boolean controllerHideOnTouch;
    private long controllerShowTimeoutMs;
    private PlayerControlView.VisibilityListener controllerVisibilityListener;
    private CharSequence customErrorMessage;
    private Drawable defaultArtwork;
    private Function1<? super MotionEvent, Unit> doubleTapListener;
    private ErrorMessageProvider<? super ExoPlaybackException> errorMessageProvider;
    private TextView errorMessageView;
    private boolean keepContentOnPlayerReset;
    private FrameLayout overlayFrameLayout;
    private Player player;
    private final GestureDetector playerSimpleGestureDetector;
    private int showBuffering;
    private View shutterView;
    private Function1<? super MotionEvent, Unit> singleTapListener;
    private SubtitleView subtitleView;
    private int textureViewRotation;
    private boolean useArtwork;
    private boolean useController;
    private boolean useSensorRotation;
    private View videoSurfaceView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private static /* synthetic */ void getShowBuffering$annotations() {
    }

    private final boolean isDpadKey(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    @Deprecated
    public /* bridge */ /* synthetic */ View[] getAdOverlayViews() {
        return AdsLoader$AdViewProvider.CC.$default$getAdOverlayViews(this);
    }

    public /* synthetic */ PlayerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        long j;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        boolean z6;
        View textureView;
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.playerSimpleGestureDetector = new GestureDetector(context, new PlayerSimpleGestureDetectorListener(this));
        ComponentListener componentListener = new ComponentListener(this);
        this.componentListener = componentListener;
        if (isInEditMode()) {
            this.contentFrame = null;
            this.shutterView = null;
            this.videoSurfaceView = null;
            this.artworkView = null;
            this.subtitleView = null;
            this.bufferingView = null;
            this.errorMessageView = null;
            this.controller = null;
            this.adOverlayFrameLayout = null;
            this.overlayFrameLayout = null;
            ImageView imageView = new ImageView(context);
            if (Util.SDK_INT >= 23) {
                Companion companion = Companion;
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                companion.configureEditModeLogoV23(resources, imageView);
            } else {
                Companion companion2 = Companion;
                Resources resources2 = getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                companion2.configureEditModeLogo(resources2, imageView);
            }
            addView(imageView);
            return;
        }
        int i7 = R.layout.exo_player_view;
        this.useSensorRotation = true;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.PlayerView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…yleable.PlayerView, 0, 0)");
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(25);
                int color = typedArrayObtainStyledAttributes.getColor(25, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(13, R.layout.exo_player_view);
                boolean z7 = typedArrayObtainStyledAttributes.getBoolean(30, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(6, 0);
                boolean z8 = typedArrayObtainStyledAttributes.getBoolean(31, true);
                int i8 = typedArrayObtainStyledAttributes.getInt(26, 1);
                int i9 = typedArrayObtainStyledAttributes.getInt(15, 0);
                long j2 = typedArrayObtainStyledAttributes.getInt(24, (int) 5000);
                z3 = typedArrayObtainStyledAttributes.getBoolean(9, true);
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(2, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(22, 0);
                this.keepContentOnPlayerReset = typedArrayObtainStyledAttributes.getBoolean(10, this.keepContentOnPlayerReset);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(8, true);
                this.useSensorRotation = typedArrayObtainStyledAttributes.getBoolean(32, this.useSensorRotation);
                typedArrayObtainStyledAttributes.recycle();
                i4 = i9;
                z = z10;
                i7 = resourceId;
                i3 = integer;
                z5 = zHasValue;
                z6 = z7;
                z4 = z8;
                i6 = color;
                i5 = i8;
                i2 = resourceId2;
                z2 = z9;
                j = j2;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            j = 5000;
            z = true;
            z2 = true;
            i2 = 0;
            i3 = 0;
            z3 = true;
            i4 = 0;
            i5 = 1;
            z4 = true;
            i6 = 0;
            z5 = false;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i7, this);
        setDescendantFocusability(MessagesController.UPDATE_MASK_CHAT_MUTE);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.exo_content_frame);
        this.contentFrame = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            Companion companion3 = Companion;
            Intrinsics.checkNotNull(aspectRatioFrameLayout);
            companion3.setResizeModeRaw(aspectRatioFrameLayout, i4);
        }
        View viewFindViewById = findViewById(R.id.exo_shutter);
        this.shutterView = viewFindViewById;
        if (z5 && viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(i6);
        }
        if (this.contentFrame != null && i5 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i5 == 2) {
                textureView = new TextureView(context);
            } else if (i5 == 3) {
                SphericalGLSurfaceView sphericalGLSurfaceView = new SphericalGLSurfaceView(context);
                sphericalGLSurfaceView.setSingleTapListener(componentListener);
                sphericalGLSurfaceView.setUseSensorRotation(this.useSensorRotation);
                textureView = sphericalGLSurfaceView;
            } else if (i5 == 4) {
                textureView = new VideoDecoderGLSurfaceView(context);
            } else {
                textureView = new SurfaceView(context);
            }
            this.videoSurfaceView = textureView;
            textureView.setLayoutParams(layoutParams);
            AspectRatioFrameLayout aspectRatioFrameLayout2 = this.contentFrame;
            if (aspectRatioFrameLayout2 != null) {
                aspectRatioFrameLayout2.addView(this.videoSurfaceView, 0);
            }
        } else {
            this.videoSurfaceView = null;
        }
        this.adOverlayFrameLayout = (FrameLayout) findViewById(R.id.exo_ad_overlay);
        this.overlayFrameLayout = (FrameLayout) findViewById(R.id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_artwork);
        this.artworkView = imageView2;
        this.useArtwork = z6 && imageView2 != null;
        if (i2 != 0) {
            this.defaultArtwork = ContextCompat.getDrawable(getContext(), i2);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.exo_subtitles);
        this.subtitleView = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
        }
        SubtitleView subtitleView2 = this.subtitleView;
        if (subtitleView2 != null) {
            subtitleView2.setUserDefaultTextSize();
        }
        View viewFindViewById2 = findViewById(R.id.exo_buffering);
        this.bufferingView = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.showBuffering = i3;
        TextView textView = (TextView) findViewById(R.id.exo_error_message);
        this.errorMessageView = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(R.id.exo_controller);
        View viewFindViewById3 = findViewById(R.id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.controller = playerControlView;
        } else if (viewFindViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.controller = playerControlView2;
            playerControlView2.setId(R.id.exo_controller);
            PlayerControlView playerControlView3 = this.controller;
            if (playerControlView3 != null) {
                playerControlView3.setLayoutParams(viewFindViewById3.getLayoutParams());
            }
            ViewParent parent = viewFindViewById3.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(this.controller, iIndexOfChild);
        } else {
            this.controller = null;
        }
        PlayerControlView playerControlView4 = this.controller;
        this.controllerShowTimeoutMs = playerControlView4 != null ? j : 0L;
        this.controllerHideOnTouch = z3;
        this.controllerAutoShow = z2;
        this.controllerHideDuringAds = z;
        this.useController = z4 && playerControlView4 != null;
        hideController();
        updateContentDescription();
        PlayerControlView playerControlView5 = this.controller;
        if (playerControlView5 == null) {
            return;
        }
        playerControlView5.addVisibilityListener(componentListener);
    }

    public final View getVideoSurfaceView() {
        return this.videoSurfaceView;
    }

    public final void setVideoSurfaceView(View view) {
        this.videoSurfaceView = view;
    }

    public final SubtitleView getSubtitleView() {
        return this.subtitleView;
    }

    public final void setSubtitleView(SubtitleView subtitleView) {
        this.subtitleView = subtitleView;
    }

    public final FrameLayout getOverlayFrameLayout() {
        return this.overlayFrameLayout;
    }

    public final void setOverlayFrameLayout(FrameLayout frameLayout) {
        this.overlayFrameLayout = frameLayout;
    }

    public final Drawable getDefaultArtwork() {
        return this.defaultArtwork;
    }

    public final boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    public final void setControllerAutoShow(boolean z) {
        this.controllerAutoShow = z;
    }

    public final Player getPlayer() {
        return this.player;
    }

    public final void setPlayer(Player player) {
        PlayerControlView playerControlView;
        Assertions.checkState(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        Assertions.checkArgument(player == null || Intrinsics.areEqual(player.getApplicationLooper(), Looper.getMainLooper()));
        Player player2 = this.player;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.componentListener);
            Player.VideoComponent videoComponent = player2.getVideoComponent();
            if (videoComponent != null) {
                videoComponent.removeVideoListener(this.componentListener);
                View view = this.videoSurfaceView;
                if (view instanceof TextureView) {
                    if (view == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.TextureView");
                    }
                    videoComponent.clearVideoTextureView((TextureView) view);
                } else if (view instanceof SphericalGLSurfaceView) {
                    if (view == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView");
                    }
                    ((SphericalGLSurfaceView) view).setVideoComponent(null);
                } else if (view instanceof VideoDecoderGLSurfaceView) {
                    videoComponent.setVideoDecoderOutputBufferRenderer(null);
                } else if (view instanceof SurfaceView) {
                    if (view == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
                    }
                    videoComponent.clearVideoSurfaceView((SurfaceView) view);
                }
            }
            Player.TextComponent textComponent = player2.getTextComponent();
            if (textComponent != null) {
                textComponent.removeTextOutput(this.componentListener);
            }
        }
        SubtitleView subtitleView = this.subtitleView;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.player = player;
        if (useController() && (playerControlView = this.controller) != null) {
            playerControlView.setPlayer(player);
        }
        updateBuffering();
        updateErrorMessage();
        updateForCurrentTrackSelections(true);
        if (player != null) {
            Player.VideoComponent videoComponent2 = player.getVideoComponent();
            if (videoComponent2 != null) {
                View view2 = this.videoSurfaceView;
                if (view2 instanceof TextureView) {
                    if (view2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.TextureView");
                    }
                    videoComponent2.setVideoTextureView((TextureView) view2);
                } else if (view2 instanceof SphericalGLSurfaceView) {
                    if (view2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView");
                    }
                    ((SphericalGLSurfaceView) view2).setVideoComponent(videoComponent2);
                } else if (view2 instanceof VideoDecoderGLSurfaceView) {
                    if (view2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView");
                    }
                    videoComponent2.setVideoDecoderOutputBufferRenderer(((VideoDecoderGLSurfaceView) view2).getVideoDecoderOutputBufferRenderer());
                } else if (view2 instanceof SurfaceView) {
                    if (view2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
                    }
                    videoComponent2.setVideoSurfaceView((SurfaceView) view2);
                }
                videoComponent2.addVideoListener(this.componentListener);
            }
            Player.TextComponent textComponent2 = player.getTextComponent();
            if (textComponent2 != null) {
                textComponent2.addTextOutput(this.componentListener);
                SubtitleView subtitleView2 = this.subtitleView;
                if (subtitleView2 != null) {
                    subtitleView2.setCues(textComponent2.getCurrentCues());
                }
            }
            player.addListener(this.componentListener);
            maybeShowController(false);
            return;
        }
        hideController();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.videoSurfaceView;
        if (view instanceof SurfaceView) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
            }
            ((SurfaceView) view).setVisibility(i);
        }
    }

    public final int getResizeMode() {
        Assertions.checkStateNotNull(this.contentFrame);
        AspectRatioFrameLayout aspectRatioFrameLayout = this.contentFrame;
        Intrinsics.checkNotNull(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    public final void setResizeMode(int i) {
        Assertions.checkStateNotNull(this.contentFrame);
        AspectRatioFrameLayout aspectRatioFrameLayout = this.contentFrame;
        Intrinsics.checkNotNull(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public final boolean getUseArtwork() {
        return this.useArtwork;
    }

    public final void setUseArtwork(boolean z) {
        Assertions.checkState((z && this.artworkView == null) ? false : true);
        if (this.useArtwork != z) {
            this.useArtwork = z;
            updateForCurrentTrackSelections(false);
        }
    }

    public final void setDefaultArtwork(Bitmap bitmap) {
        setDefaultArtwork(bitmap == null ? null : new BitmapDrawable(getResources(), bitmap));
    }

    public final void setDefaultArtwork(Drawable drawable) {
        if (this.defaultArtwork != drawable) {
            this.defaultArtwork = drawable;
            updateForCurrentTrackSelections(false);
        }
    }

    public final boolean getUseController() {
        return this.useController;
    }

    public final void setUseController(boolean z) throws Resources.NotFoundException {
        Assertions.checkState((z && this.controller == null) ? false : true);
        if (this.useController == z) {
            return;
        }
        this.useController = z;
        if (useController()) {
            PlayerControlView playerControlView = this.controller;
            if (playerControlView != null) {
                playerControlView.setPlayer(this.player);
            }
        } else {
            PlayerControlView playerControlView2 = this.controller;
            if (playerControlView2 != null) {
                playerControlView2.hideWithAnimation();
            }
            PlayerControlView playerControlView3 = this.controller;
            if (playerControlView3 != null) {
                playerControlView3.setPlayer(null);
            }
        }
        updateContentDescription();
    }

    public final void setShutterBackgroundColor(int i) {
        View view = this.shutterView;
        if (view == null) {
            return;
        }
        view.setBackgroundColor(i);
    }

    public final void setKeepContentOnPlayerReset(boolean z) {
        if (this.keepContentOnPlayerReset != z) {
            this.keepContentOnPlayerReset = z;
            updateForCurrentTrackSelections(false);
        }
    }

    public final void setUseSensorRotation(boolean z) {
        if (this.useSensorRotation != z) {
            this.useSensorRotation = z;
            View view = this.videoSurfaceView;
            if (view instanceof SphericalGLSurfaceView) {
                if (view == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView");
                }
                ((SphericalGLSurfaceView) view).setUseSensorRotation(z);
            }
        }
    }

    public final void setShowBuffering(boolean z) {
        setShowBuffering(z ? 1 : 0);
    }

    public final void setShowBuffering(int i) {
        if (this.showBuffering != i) {
            this.showBuffering = i;
            updateBuffering();
        }
    }

    public final void setErrorMessageProvider(ErrorMessageProvider<? super ExoPlaybackException> errorMessageProvider) {
        if (this.errorMessageProvider != errorMessageProvider) {
            this.errorMessageProvider = errorMessageProvider;
            updateErrorMessage();
        }
    }

    public final void setCustomErrorMessage(CharSequence charSequence) {
        Assertions.checkState(this.errorMessageView != null);
        this.customErrorMessage = charSequence;
        updateErrorMessage();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.google.android.exoplayer2.Player r0 = r4.player
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Ld
        Lb:
            r0 = 0
            goto L14
        Ld:
            boolean r0 = r0.isPlayingAd()
            if (r0 != r2) goto Lb
            r0 = 1
        L14:
            if (r0 == 0) goto L1b
            boolean r5 = super.dispatchKeyEvent(r5)
            return r5
        L1b:
            int r0 = r5.getKeyCode()
            boolean r0 = r4.isDpadKey(r0)
            if (r0 == 0) goto L3e
            boolean r3 = r4.useController()
            if (r3 == 0) goto L3e
            ir.appp.vod.ui.customViews.exo.PlayerControlView r3 = r4.controller
            if (r3 != 0) goto L31
        L2f:
            r3 = 0
            goto L38
        L31:
            boolean r3 = r3.isVisible()
            if (r3 != 0) goto L2f
            r3 = 1
        L38:
            if (r3 == 0) goto L3e
            r4.maybeShowController(r2)
            goto L5a
        L3e:
            boolean r3 = r4.dispatchMediaKeyEvent(r5)
            if (r3 != 0) goto L57
            boolean r5 = super.dispatchKeyEvent(r5)
            if (r5 == 0) goto L4b
            goto L57
        L4b:
            if (r0 == 0) goto L5b
            boolean r5 = r4.useController()
            if (r5 == 0) goto L5b
            r4.maybeShowController(r2)
            goto L5b
        L57:
            r4.maybeShowController(r2)
        L5a:
            r1 = 1
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.ui.customViews.exo.PlayerView.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public final boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        if (useController()) {
            PlayerControlView playerControlView = this.controller;
            Intrinsics.checkNotNull(playerControlView);
            Intrinsics.checkNotNull(keyEvent);
            if (playerControlView.dispatchMediaKeyEvent(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public final void showController() {
        showController(shouldShowControllerIndefinitely());
    }

    public final void hideController() {
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.hideWithAnimation();
    }

    public final PlayerControlView getController() {
        return this.controller;
    }

    public final long getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    public final void setControllerShowTimeoutMs(long j) {
        Assertions.checkStateNotNull(this.controller);
        this.controllerShowTimeoutMs = j;
        PlayerControlView playerControlView = this.controller;
        boolean z = false;
        if (playerControlView != null && playerControlView.isVisible()) {
            z = true;
        }
        if (z) {
            showController();
        }
    }

    public final boolean getControllerHideOnTouch() {
        return this.controllerHideOnTouch;
    }

    public final void setControllerHideOnTouch(boolean z) throws Resources.NotFoundException {
        Assertions.checkStateNotNull(this.controller);
        this.controllerHideOnTouch = z;
        updateContentDescription();
    }

    public final void setControllerHideDuringAds(boolean z) {
        this.controllerHideDuringAds = z;
    }

    public final void setControllerVisibilityListener(PlayerControlView.VisibilityListener visibilityListener) {
        PlayerControlView playerControlView;
        PlayerControlView playerControlView2;
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView.VisibilityListener visibilityListener2 = this.controllerVisibilityListener;
        if (visibilityListener2 == visibilityListener) {
            return;
        }
        if (visibilityListener2 != null && (playerControlView2 = this.controller) != null) {
            Intrinsics.checkNotNull(visibilityListener2);
            playerControlView2.removeVisibilityListener(visibilityListener2);
        }
        this.controllerVisibilityListener = visibilityListener;
        if (visibilityListener == null || (playerControlView = this.controller) == null) {
            return;
        }
        playerControlView.addVisibilityListener(visibilityListener);
    }

    public final void setPlaybackPreparer(PlaybackPreparer playbackPreparer) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setPlaybackPreparer(playbackPreparer);
    }

    public final void setControlDispatcher(ControlDispatcher controlDispatcher) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        Intrinsics.checkNotNull(controlDispatcher);
        playerControlView.setControlDispatcher(controlDispatcher);
    }

    public final void setShowRewindButton(boolean z) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setShowRewindButton(z);
    }

    public final void setShowFastForwardButton(boolean z) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setShowFastForwardButton(z);
    }

    public final void setShowPreviousButton(boolean z) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setShowPreviousButton(z);
    }

    public final void setShowNextButton(boolean z) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setShowNextButton(z);
    }

    public final void setRewindIncrementMs(int i) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setRewindIncrementMs(i);
    }

    public final void setFastForwardIncrementMs(int i) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setFastForwardIncrementMs(i);
    }

    public final void setRepeatToggleModes(int i) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setRepeatToggleModes(i);
    }

    public final void setShowShuffleButton(boolean z) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setShowShuffleButton(z);
    }

    public final void setShowMultiWindowTimeBar(boolean z) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null) {
            return;
        }
        playerControlView.setShowMultiWindowTimeBar(z);
    }

    public final void setAspectRatioListener(AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.checkStateNotNull(this.contentFrame);
        AspectRatioFrameLayout aspectRatioFrameLayout = this.contentFrame;
        if (aspectRatioFrameLayout == null) {
            return;
        }
        aspectRatioFrameLayout.setAspectRatioListener(aspectRatioListener);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!useController() || this.player == null) {
            return false;
        }
        this.playerSimpleGestureDetector.onTouchEvent(event);
        return true;
    }

    public final void setDoubleTapListener(Function1<? super MotionEvent, Unit> function1) {
        this.doubleTapListener = function1;
    }

    public final void setSingleTapListener(Function1<? super MotionEvent, Unit> function1) {
        this.singleTapListener = function1;
    }

    /* compiled from: PlayerView.kt */
    private final class PlayerSimpleGestureDetectorListener extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ PlayerView this$0;

        public PlayerSimpleGestureDetectorListener(PlayerView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Function1 function1 = this.this$0.singleTapListener;
            if (function1 == null) {
                return true;
            }
            function1.invoke(e);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Function1 function1 = this.this$0.doubleTapListener;
            if (function1 == null) {
                return true;
            }
            function1.invoke(e);
            return true;
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return toggleControllerVisibility();
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!useController() || this.player == null) {
            return false;
        }
        maybeShowController(true);
        return true;
    }

    public final void onContentAspectRatioChanged(float f, AspectRatioFrameLayout aspectRatioFrameLayout, View view) {
        if (aspectRatioFrameLayout == null) {
            return;
        }
        if (view instanceof SphericalGLSurfaceView) {
            f = 0.0f;
        }
        aspectRatioFrameLayout.setAspectRatio(f);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.checkStateNotNull(this.adOverlayFrameLayout, "exo_ad_overlay must be present for ad playback");
    }

    public List<AdsLoader$OverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.overlayFrameLayout;
        if (frameLayout != null) {
            Intrinsics.checkNotNull(frameLayout);
            arrayList.add(new AdsLoader$OverlayInfo(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.controller;
        if (playerControlView != null) {
            Intrinsics.checkNotNull(playerControlView);
            arrayList.add(new AdsLoader$OverlayInfo(playerControlView, 0));
        }
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) arrayList);
        Intrinsics.checkNotNullExpressionValue(immutableListCopyOf, "copyOf(overlayViews)");
        return immutableListCopyOf;
    }

    private final boolean useController() {
        if (!this.useController) {
            return false;
        }
        Assertions.checkStateNotNull(this.controller);
        return true;
    }

    private final boolean useArtwork() {
        if (!this.useArtwork) {
            return false;
        }
        Assertions.checkStateNotNull(this.artworkView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean toggleControllerVisibility() {
        PlayerControlView playerControlView;
        boolean z = false;
        if (!useController() || this.player == null) {
            return false;
        }
        PlayerControlView playerControlView2 = this.controller;
        if (playerControlView2 != null && !playerControlView2.isVisible()) {
            z = true;
        }
        if (z) {
            maybeShowController(true);
        } else if (this.controllerHideOnTouch && (playerControlView = this.controller) != null) {
            playerControlView.hideWithAnimation();
        }
        return true;
    }

    private final void maybeShowController(boolean z) {
        if (!(isPlayingAd() && this.controllerHideDuringAds) && useController()) {
            PlayerControlView playerControlView = this.controller;
            boolean z2 = false;
            if (playerControlView != null && playerControlView.isVisible()) {
                PlayerControlView playerControlView2 = this.controller;
                Intrinsics.checkNotNull(playerControlView2);
                if (playerControlView2.getShowTimeoutMs() <= 0) {
                    z2 = true;
                }
            }
            boolean zShouldShowControllerIndefinitely = shouldShowControllerIndefinitely();
            if (z || z2 || zShouldShowControllerIndefinitely) {
                showController(zShouldShowControllerIndefinitely);
            }
        }
    }

    private final boolean shouldShowControllerIndefinitely() {
        Player player = this.player;
        if (player == null) {
            return true;
        }
        Integer numValueOf = player == null ? null : Integer.valueOf(player.getPlaybackState());
        if (this.controllerAutoShow) {
            if (numValueOf != null && numValueOf.intValue() == 1) {
                return true;
            }
            if (numValueOf != null && numValueOf.intValue() == 4) {
                return true;
            }
            Player player2 = this.player;
            if ((player2 == null || player2.getPlayWhenReady()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    private final void showController(boolean z) {
        if (useController()) {
            PlayerControlView playerControlView = this.controller;
            if (playerControlView != null) {
                playerControlView.setShowTimeoutMs(z ? 0L : this.controllerShowTimeoutMs);
            }
            PlayerControlView playerControlView2 = this.controller;
            if (playerControlView2 == null) {
                return;
            }
            playerControlView2.showWithAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPlayingAd() {
        Player player = this.player;
        if (!(player != null && player.isPlayingAd())) {
            return false;
        }
        Player player2 = this.player;
        return player2 != null && player2.getPlayWhenReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateForCurrentTrackSelections(boolean z) {
        Player player = this.player;
        if (player == null || player.getCurrentTrackGroups().isEmpty()) {
            if (this.keepContentOnPlayerReset) {
                return;
            }
            hideArtwork();
            closeShutter();
            return;
        }
        if (z && !this.keepContentOnPlayerReset) {
            closeShutter();
        }
        TrackSelectionArray currentTrackSelections = player.getCurrentTrackSelections();
        Intrinsics.checkNotNullExpressionValue(currentTrackSelections, "player.currentTrackSelections");
        int i = currentTrackSelections.length;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            if (player.getRendererType(i2) == 2 && currentTrackSelections.get(i2) != null) {
                hideArtwork();
                return;
            }
            i2 = i3;
        }
        closeShutter();
        if (useArtwork()) {
            int i4 = currentTrackSelections.length;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = i5 + 1;
                TrackSelection trackSelection = currentTrackSelections.get(i5);
                if (trackSelection != null) {
                    int length = trackSelection.length();
                    int i7 = 0;
                    while (i7 < length) {
                        int i8 = i7 + 1;
                        Metadata metadata = trackSelection.getFormat(i7).metadata;
                        if (metadata != null && setArtworkFromMetadata(metadata)) {
                            return;
                        } else {
                            i7 = i8;
                        }
                    }
                }
                i5 = i6;
            }
            if (setDrawableArtwork(this.defaultArtwork)) {
                return;
            }
        }
        hideArtwork();
    }

    private final boolean setArtworkFromMetadata(Metadata metadata) {
        byte[] bArr;
        int i;
        int length = metadata.length();
        int i2 = 0;
        int i3 = -1;
        boolean drawableArtwork = false;
        while (i2 < length) {
            int i4 = i2 + 1;
            Metadata.Entry entry = metadata.get(i2);
            Intrinsics.checkNotNullExpressionValue(entry, "metadata[i]");
            if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                bArr = apicFrame.pictureData;
                Intrinsics.checkNotNullExpressionValue(bArr, "metadataEntry.pictureData");
                i = apicFrame.pictureType;
            } else if (entry instanceof PictureFrame) {
                PictureFrame pictureFrame = (PictureFrame) entry;
                bArr = pictureFrame.pictureData;
                Intrinsics.checkNotNullExpressionValue(bArr, "metadataEntry.pictureData");
                i = pictureFrame.pictureType;
            } else {
                continue;
                i2 = i4;
            }
            if (i3 == -1 || i == 3) {
                drawableArtwork = setDrawableArtwork(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                if (i == 3) {
                    break;
                }
                i3 = i;
            }
            i2 = i4;
        }
        return drawableArtwork;
    }

    private final boolean setDrawableArtwork(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                onContentAspectRatioChanged(intrinsicWidth / intrinsicHeight, this.contentFrame, this.artworkView);
                ImageView imageView = this.artworkView;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
                ImageView imageView2 = this.artworkView;
                if (imageView2 == null) {
                    return true;
                }
                imageView2.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private final void hideArtwork() {
        ImageView imageView = this.artworkView;
        if (imageView != null) {
            if (imageView != null) {
                imageView.setImageResource(android.R.color.transparent);
            }
            ImageView imageView2 = this.artworkView;
            if (imageView2 == null) {
                return;
            }
            imageView2.setVisibility(4);
        }
    }

    private final void closeShutter() {
        View view = this.shutterView;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateBuffering() {
        /*
            r4 = this;
            android.view.View r0 = r4.bufferingView
            if (r0 == 0) goto L3c
            com.google.android.exoplayer2.Player r0 = r4.player
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2e
            r3 = 2
            if (r0 != 0) goto Lf
        Ld:
            r0 = 0
            goto L16
        Lf:
            int r0 = r0.getPlaybackState()
            if (r0 != r3) goto Ld
            r0 = 1
        L16:
            if (r0 == 0) goto L2e
            int r0 = r4.showBuffering
            if (r0 == r3) goto L2f
            if (r0 != r1) goto L2e
            com.google.android.exoplayer2.Player r0 = r4.player
            if (r0 != 0) goto L24
        L22:
            r0 = 0
            goto L2b
        L24:
            boolean r0 = r0.getPlayWhenReady()
            if (r0 != r1) goto L22
            r0 = 1
        L2b:
            if (r0 == 0) goto L2e
            goto L2f
        L2e:
            r1 = 0
        L2f:
            android.view.View r0 = r4.bufferingView
            if (r0 != 0) goto L34
            goto L3c
        L34:
            if (r1 == 0) goto L37
            goto L39
        L37:
            r2 = 8
        L39:
            r0.setVisibility(r2)
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.ui.customViews.exo.PlayerView.updateBuffering():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateErrorMessage() {
        ErrorMessageProvider<? super ExoPlaybackException> errorMessageProvider;
        Pair<Integer, String> errorMessage;
        CharSequence charSequence = this.customErrorMessage;
        if (charSequence != null) {
            TextView textView = this.errorMessageView;
            if (textView != null) {
                textView.setText(charSequence);
            }
            TextView textView2 = this.errorMessageView;
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(0);
            return;
        }
        Player player = this.player;
        String str = null;
        ExoPlaybackException playerError = player == null ? null : player.getPlayerError();
        if (playerError != null && (errorMessageProvider = this.errorMessageProvider) != null) {
            TextView textView3 = this.errorMessageView;
            if (textView3 != null) {
                if (errorMessageProvider != null && (errorMessage = errorMessageProvider.getErrorMessage(playerError)) != null) {
                    str = (String) errorMessage.second;
                }
                textView3.setText(str);
            }
            TextView textView4 = this.errorMessageView;
            if (textView4 == null) {
                return;
            }
            textView4.setVisibility(0);
            return;
        }
        TextView textView5 = this.errorMessageView;
        if (textView5 == null) {
            return;
        }
        textView5.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContentDescription() throws Resources.NotFoundException {
        PlayerControlView playerControlView = this.controller;
        String string = null;
        if (playerControlView != null && this.useController) {
            boolean z = false;
            if (playerControlView != null && playerControlView.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                if (this.controllerHideOnTouch) {
                    string = getResources().getString(R.string.exo_controls_hide);
                }
            } else {
                string = getResources().getString(R.string.exo_controls_show);
            }
        }
        setContentDescription(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateControllerVisibility() {
        if (isPlayingAd() && this.controllerHideDuringAds) {
            hideController();
        } else {
            maybeShowController(false);
        }
    }

    /* compiled from: PlayerView.kt */
    private final class ComponentListener implements Player.EventListener, TextOutput, VideoListener, View.OnLayoutChangeListener, SingleTapListener, PlayerControlView.VisibilityListener {
        private Object lastPeriodUidWithTracks;
        private final Timeline.Period period;
        final /* synthetic */ PlayerView this$0;

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
        public /* synthetic */ void onRepeatModeChanged(int i) {
            Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            VideoListener.CC.$default$onSurfaceSizeChanged(this, i, i2);
        }

        /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
        /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
        }

        public ComponentListener(PlayerView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.period = new Timeline.Period();
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> cues) {
            Intrinsics.checkNotNullParameter(cues, "cues");
            SubtitleView subtitleView = this.this$0.getSubtitleView();
            if (subtitleView == null) {
                return;
            }
            subtitleView.onCues(cues);
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            View videoSurfaceView;
            View videoSurfaceView2;
            float f2 = (i2 == 0 || i == 0) ? 1.0f : (i * f) / i2;
            if (this.this$0.getVideoSurfaceView() instanceof TextureView) {
                if (i3 == 90 || i3 == 270) {
                    f2 = 1 / f2;
                }
                if (this.this$0.textureViewRotation != 0 && (videoSurfaceView2 = this.this$0.getVideoSurfaceView()) != null) {
                    videoSurfaceView2.removeOnLayoutChangeListener(this);
                }
                this.this$0.textureViewRotation = i3;
                if (this.this$0.textureViewRotation != 0 && (videoSurfaceView = this.this$0.getVideoSurfaceView()) != null) {
                    videoSurfaceView.addOnLayoutChangeListener(this);
                }
                View videoSurfaceView3 = this.this$0.getVideoSurfaceView();
                TextureView textureView = videoSurfaceView3 instanceof TextureView ? (TextureView) videoSurfaceView3 : null;
                if (textureView != null) {
                    PlayerView.Companion.applyTextureViewRotation(textureView, this.this$0.textureViewRotation);
                }
            }
            PlayerView playerView = this.this$0;
            playerView.onContentAspectRatioChanged(f2, playerView.contentFrame, this.this$0.getVideoSurfaceView());
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onRenderedFirstFrame() {
            View view = this.this$0.shutterView;
            if (view == null) {
                return;
            }
            view.setVisibility(4);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray tracks, TrackSelectionArray selections) {
            Intrinsics.checkNotNullParameter(tracks, "tracks");
            Intrinsics.checkNotNullParameter(selections, "selections");
            Object objCheckNotNull = Assertions.checkNotNull(this.this$0.player);
            Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(player)");
            Player player = (Player) objCheckNotNull;
            Timeline currentTimeline = player.getCurrentTimeline();
            Intrinsics.checkNotNullExpressionValue(currentTimeline, "player.currentTimeline");
            if (currentTimeline.isEmpty()) {
                this.lastPeriodUidWithTracks = null;
            } else if (!player.getCurrentTrackGroups().isEmpty()) {
                this.lastPeriodUidWithTracks = currentTimeline.getPeriod(player.getCurrentPeriodIndex(), this.period, true).uid;
            } else {
                Object obj = this.lastPeriodUidWithTracks;
                if (obj != null) {
                    Intrinsics.checkNotNull(obj);
                    int indexOfPeriod = currentTimeline.getIndexOfPeriod(obj);
                    if (indexOfPeriod != -1) {
                        if (player.getCurrentWindowIndex() == currentTimeline.getPeriod(indexOfPeriod, this.period).windowIndex) {
                            return;
                        }
                    }
                    this.lastPeriodUidWithTracks = null;
                }
            }
            this.this$0.updateForCurrentTrackSelections(false);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            this.this$0.updateBuffering();
            this.this$0.updateErrorMessage();
            this.this$0.updateControllerVisibility();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            this.this$0.updateBuffering();
            this.this$0.updateControllerVisibility();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
            if (this.this$0.isPlayingAd() && this.this$0.controllerHideDuringAds) {
                this.this$0.hideController();
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Intrinsics.checkNotNullParameter(view, "view");
            PlayerView.Companion.applyTextureViewRotation((TextureView) view, this.this$0.textureViewRotation);
        }

        @Override // com.google.android.exoplayer2.ui.spherical.SingleTapListener
        public boolean onSingleTapUp(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            return this.this$0.toggleControllerVisibility();
        }

        @Override // ir.appp.vod.ui.customViews.exo.PlayerControlView.VisibilityListener
        public void onVisibilityChange(int i) throws Resources.NotFoundException {
            this.this$0.updateContentDescription();
        }
    }

    /* compiled from: PlayerView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void configureEditModeLogoV23(Resources resources, ImageView imageView) {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.exo_edit_mode_logo, null));
            imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void configureEditModeLogo(Resources resources, ImageView imageView) {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.exo_edit_mode_logo, null));
            imageView.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.exo_edit_mode_background_color, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
            aspectRatioFrameLayout.setResizeMode(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyTextureViewRotation(TextureView textureView, int i) {
            Matrix matrix = new Matrix();
            float width = textureView.getWidth();
            float height = textureView.getHeight();
            if (!(width == 0.0f)) {
                if (!(height == 0.0f) && i != 0) {
                    float f = 2;
                    float f2 = width / f;
                    float f3 = height / f;
                    matrix.postRotate(i, f2, f3);
                    RectF rectF = new RectF(0.0f, 0.0f, width, height);
                    RectF rectF2 = new RectF();
                    matrix.mapRect(rectF2, rectF);
                    matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f3);
                }
            }
            textureView.setTransform(matrix);
        }
    }
}
