package ir.eitaa.ui.Components.voip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.voip.VideoCapturerDevice;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BlobDrawable;
import ir.eitaa.ui.Components.CrossOutDrawable;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.GroupCallFullscreenAdapter;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.voip.GroupCallStatusIcon;
import ir.eitaa.ui.GroupCallActivity;
import java.util.ArrayList;
import java.util.HashMap;
import org.webrtc.GlGenericDrawer;
import org.webrtc.RendererCommon;
import org.webrtc.TextureViewRenderer;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class GroupCallMiniTextureView extends FrameLayout implements GroupCallStatusIcon.Callback {
    GroupCallActivity activity;
    boolean animateEnter;
    int animateToColor;
    public boolean animateToFullscreen;
    public boolean animateToScrimView;
    boolean attached;
    ArrayList<GroupCallMiniTextureView> attachedRenderers;
    ImageView blurredFlippingStub;
    ChatObject.Call call;
    private Drawable castingScreenDrawable;
    private boolean checkScale;
    int collapseSize;
    ValueAnimator colorAnimator;
    int currentAccount;
    public boolean drawFirst;
    ValueAnimator flipAnimator;
    boolean flipHalfReached;
    public boolean forceDetached;
    int fullSize;
    Paint gradientPaint;
    LinearGradient gradientShader;
    int gridItemsCount;
    public boolean hasVideo;
    ImageReceiver imageReceiver;
    boolean inPinchToZoom;
    FrameLayout infoContainer;
    private boolean invalidateFromChild;
    boolean isFullscreenMode;
    int lastIconColor;
    private boolean lastLandscapeMode;
    private int lastSize;
    int lastSpeakingFrameColor;
    private final RLottieImageView micIconView;
    private final SimpleTextView nameView;
    ValueAnimator noVideoStubAnimator;
    private NoVideoStubLayout noVideoStubLayout;
    ArrayList<Runnable> onFirstFrameRunnables;
    float overlayIconAlpha;
    GroupCallRenderersContainer parentContainer;
    public ChatObject.VideoParticipant participant;
    private CrossOutDrawable pausedVideoDrawable;
    float pinchCenterX;
    float pinchCenterY;
    float pinchScale;
    float pinchTranslationX;
    float pinchTranslationY;
    public GroupCallGridCell primaryView;
    private float progressToBackground;
    public float progressToNoVideoStub;
    float progressToSpeaking;
    private Rect rect;
    private final ImageView screencastIcon;
    public GroupCallFullscreenAdapter.GroupCallUserCell secondaryView;
    private boolean showingAsScrimView;
    public boolean showingInFullscreen;
    float spanCount;
    Paint speakingPaint;
    private GroupCallStatusIcon statusIcon;
    private TextView stopSharingTextView;
    private boolean swipeToBack;
    private float swipeToBackDy;
    public GroupCallGridCell tabletGridView;
    public final VoIPTextureView textureView;
    Bitmap thumb;
    Paint thumbPaint;
    private boolean updateNextLayoutAnimated;
    boolean useSpanSize;
    private boolean videoIsPaused;
    private float videoIsPausedProgress;

    static /* synthetic */ float access$116(GroupCallMiniTextureView groupCallMiniTextureView, float f) {
        float f2 = groupCallMiniTextureView.progressToBackground + f;
        groupCallMiniTextureView.progressToBackground = f2;
        return f2;
    }

    static /* synthetic */ float access$616(GroupCallMiniTextureView groupCallMiniTextureView, float f) {
        float f2 = groupCallMiniTextureView.videoIsPausedProgress + f;
        groupCallMiniTextureView.videoIsPausedProgress = f2;
        return f2;
    }

    static /* synthetic */ float access$624(GroupCallMiniTextureView groupCallMiniTextureView, float f) {
        float f2 = groupCallMiniTextureView.videoIsPausedProgress - f;
        groupCallMiniTextureView.videoIsPausedProgress = f2;
        return f2;
    }

    public GroupCallMiniTextureView(final GroupCallRenderersContainer parentContainer, ArrayList<GroupCallMiniTextureView> attachedRenderers, final ChatObject.Call call, final GroupCallActivity activity) {
        super(parentContainer.getContext());
        this.gradientPaint = new Paint(1);
        this.speakingPaint = new Paint(1);
        this.progressToNoVideoStub = 1.0f;
        this.imageReceiver = new ImageReceiver();
        this.onFirstFrameRunnables = new ArrayList<>();
        this.rect = new Rect();
        this.call = call;
        this.currentAccount = activity.getCurrentAccount();
        CrossOutDrawable crossOutDrawable = new CrossOutDrawable(parentContainer.getContext(), R.drawable.calls_video, null);
        this.pausedVideoDrawable = crossOutDrawable;
        crossOutDrawable.setCrossOut(true, false);
        this.pausedVideoDrawable.setOffsets(-AndroidUtilities.dp(4.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f));
        this.pausedVideoDrawable.setStrokeWidth(AndroidUtilities.dpf2(3.4f));
        this.castingScreenDrawable = parentContainer.getContext().getResources().getDrawable(R.drawable.screencast_big).mutate();
        final TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        textPaint.setTextSize(AndroidUtilities.dp(13.0f));
        textPaint.setColor(-1);
        final TextPaint textPaint2 = new TextPaint(1);
        textPaint2.setTypeface(AndroidUtilities.getFontFamily(true));
        textPaint2.setTextSize(AndroidUtilities.dp(15.0f));
        textPaint2.setColor(-1);
        final String string = LocaleController.getString("VoipVideoOnPause", R.string.VoipVideoOnPause);
        final StaticLayout staticLayout = new StaticLayout(LocaleController.getString("VoipVideoScreenSharingTwoLines", R.string.VoipVideoScreenSharingTwoLines), textPaint, AndroidUtilities.dp(400.0f), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(call.chatId));
        final StaticLayout staticLayout2 = new StaticLayout(LocaleController.formatString("VoipVideoNotAvailable", R.string.VoipVideoNotAvailable, LocaleController.formatPluralString("Participants", MessagesController.getInstance(this.currentAccount).groipCallVideoMaxParticipants)), textPaint, AndroidUtilities.dp(400.0f), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        final String string2 = LocaleController.getString("VoipVideoScreenSharing", R.string.VoipVideoScreenSharing);
        final float fMeasureText = textPaint.measureText(string);
        final float fMeasureText2 = textPaint2.measureText(string2);
        boolean z = true;
        VoIPTextureView voIPTextureView = new VoIPTextureView(parentContainer.getContext(), false, false, z, z) { // from class: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.1
            float overlayIconAlphaFrom;

            @Override // ir.eitaa.ui.Components.voip.VoIPTextureView
            public void animateToLayout() {
                super.animateToLayout();
                this.overlayIconAlphaFrom = GroupCallMiniTextureView.this.overlayIconAlpha;
            }

            @Override // ir.eitaa.ui.Components.voip.VoIPTextureView
            protected void updateRendererSize() {
                super.updateRendererSize();
                ImageView imageView = GroupCallMiniTextureView.this.blurredFlippingStub;
                if (imageView == null || imageView.getParent() == null) {
                    return;
                }
                GroupCallMiniTextureView.this.blurredFlippingStub.getLayoutParams().width = GroupCallMiniTextureView.this.textureView.renderer.getMeasuredWidth();
                GroupCallMiniTextureView.this.blurredFlippingStub.getLayoutParams().height = GroupCallMiniTextureView.this.textureView.renderer.getMeasuredHeight();
            }

            @Override // ir.eitaa.ui.Components.voip.VoIPTextureView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                float f;
                float fDp;
                float f2;
                float f3;
                if (!this.renderer.isFirstFrameRendered() || ((this.renderer.getAlpha() != 1.0f && this.blurRenderer.getAlpha() != 1.0f) || GroupCallMiniTextureView.this.videoIsPaused)) {
                    if (GroupCallMiniTextureView.this.progressToBackground != 1.0f) {
                        GroupCallMiniTextureView.access$116(GroupCallMiniTextureView.this, 0.10666667f);
                        if (GroupCallMiniTextureView.this.progressToBackground > 1.0f) {
                            GroupCallMiniTextureView.this.progressToBackground = 1.0f;
                        } else {
                            invalidate();
                        }
                    }
                    GroupCallMiniTextureView groupCallMiniTextureView = GroupCallMiniTextureView.this;
                    if (groupCallMiniTextureView.thumb != null) {
                        canvas.save();
                        float f4 = this.currentThumbScale;
                        canvas.scale(f4, f4, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
                        GroupCallMiniTextureView groupCallMiniTextureView2 = GroupCallMiniTextureView.this;
                        if (groupCallMiniTextureView2.thumbPaint == null) {
                            groupCallMiniTextureView2.thumbPaint = new Paint(1);
                            GroupCallMiniTextureView.this.thumbPaint.setFilterBitmap(true);
                        }
                        canvas.drawBitmap(GroupCallMiniTextureView.this.thumb, (getMeasuredWidth() - GroupCallMiniTextureView.this.thumb.getWidth()) / 2.0f, (getMeasuredHeight() - GroupCallMiniTextureView.this.thumb.getHeight()) / 2.0f, GroupCallMiniTextureView.this.thumbPaint);
                        canvas.restore();
                    } else {
                        groupCallMiniTextureView.imageReceiver.setImageCoords(this.currentClipHorizontal, this.currentClipVertical, getMeasuredWidth() - (this.currentClipHorizontal * 2.0f), getMeasuredHeight() - (this.currentClipVertical * 2.0f));
                        GroupCallMiniTextureView groupCallMiniTextureView3 = GroupCallMiniTextureView.this;
                        groupCallMiniTextureView3.imageReceiver.setAlpha(groupCallMiniTextureView3.progressToBackground);
                        GroupCallMiniTextureView.this.imageReceiver.draw(canvas);
                    }
                    GroupCallMiniTextureView groupCallMiniTextureView4 = GroupCallMiniTextureView.this;
                    ChatObject.VideoParticipant videoParticipant = groupCallMiniTextureView4.participant;
                    if (videoParticipant == call.videoNotAvailableParticipant) {
                        if (groupCallMiniTextureView4.showingInFullscreen || !parentContainer.inFullscreenMode) {
                            float fDp2 = AndroidUtilities.dp(48.0f);
                            textPaint.setAlpha(255);
                            canvas.save();
                            canvas.translate((((getMeasuredWidth() - fDp2) / 2.0f) - (AndroidUtilities.dp(400.0f) / 2.0f)) + (fDp2 / 2.0f), ((getMeasuredHeight() / 2) - fDp2) + fDp2 + AndroidUtilities.dp(10.0f));
                            staticLayout2.draw(canvas);
                            canvas.restore();
                        }
                        if (GroupCallMiniTextureView.this.stopSharingTextView.getVisibility() != 4) {
                            GroupCallMiniTextureView.this.stopSharingTextView.setVisibility(4);
                        }
                    } else if (!videoParticipant.presentation || !videoParticipant.participant.self) {
                        if (groupCallMiniTextureView4.stopSharingTextView.getVisibility() != 4) {
                            GroupCallMiniTextureView.this.stopSharingTextView.setVisibility(4);
                        }
                        activity.cellFlickerDrawable.draw(canvas, GroupCallMiniTextureView.this);
                    } else {
                        if (groupCallMiniTextureView4.stopSharingTextView.getVisibility() != 0) {
                            GroupCallMiniTextureView.this.stopSharingTextView.setVisibility(0);
                            GroupCallMiniTextureView.this.stopSharingTextView.setScaleX(1.0f);
                            GroupCallMiniTextureView.this.stopSharingTextView.setScaleY(1.0f);
                        }
                        float f5 = GroupCallMiniTextureView.this.drawFirst ? 0.0f : parentContainer.progressToFullscreenMode;
                        int iDp = AndroidUtilities.dp(33.0f);
                        GroupCallMiniTextureView groupCallMiniTextureView5 = GroupCallMiniTextureView.this;
                        if (groupCallMiniTextureView5.animateToFullscreen || groupCallMiniTextureView5.showingInFullscreen) {
                            f = iDp;
                            fDp = AndroidUtilities.dp(10.0f) + (AndroidUtilities.dp(39.0f) * parentContainer.progressToFullscreenMode);
                        } else {
                            f = iDp;
                            fDp = AndroidUtilities.dp(10.0f) * Math.max(1.0f - parentContainer.progressToFullscreenMode, (GroupCallMiniTextureView.this.showingAsScrimView || GroupCallMiniTextureView.this.animateToScrimView) ? parentContainer.progressToScrimView : 0.0f);
                        }
                        int i = (int) (f + fDp);
                        int measuredWidth = (getMeasuredWidth() - i) / 2;
                        float f6 = (GroupCallMiniTextureView.this.showingAsScrimView || GroupCallMiniTextureView.this.animateToScrimView) ? parentContainer.progressToScrimView : 0.0f;
                        GroupCallMiniTextureView groupCallMiniTextureView6 = GroupCallMiniTextureView.this;
                        if (groupCallMiniTextureView6.showingInFullscreen) {
                            f2 = f5;
                        } else {
                            f5 = groupCallMiniTextureView6.animateToFullscreen ? parentContainer.progressToFullscreenMode : f6;
                            f2 = (groupCallMiniTextureView6.showingAsScrimView || GroupCallMiniTextureView.this.animateToScrimView) ? parentContainer.progressToScrimView : parentContainer.progressToFullscreenMode;
                        }
                        float measuredHeight = ((getMeasuredHeight() - i) / 2) - AndroidUtilities.dp(28.0f);
                        float fDp3 = AndroidUtilities.dp(17.0f);
                        float fDp4 = AndroidUtilities.dp(74.0f);
                        GroupCallMiniTextureView groupCallMiniTextureView7 = GroupCallMiniTextureView.this;
                        int iDp2 = (int) ((measuredHeight - ((fDp3 + (fDp4 * ((groupCallMiniTextureView7.showingInFullscreen || groupCallMiniTextureView7.animateToFullscreen) ? parentContainer.progressToFullscreenMode : 0.0f))) * f5)) + (AndroidUtilities.dp(17.0f) * f2));
                        GroupCallMiniTextureView.this.castingScreenDrawable.setBounds(measuredWidth, iDp2, measuredWidth + i, iDp2 + i);
                        GroupCallMiniTextureView.this.castingScreenDrawable.draw(canvas);
                        float f7 = parentContainer.progressToFullscreenMode;
                        if (f7 <= 0.0f && f6 <= 0.0f) {
                            GroupCallMiniTextureView.this.stopSharingTextView.setAlpha(0.0f);
                        } else {
                            float fMax = Math.max(f7, f6) * f5;
                            textPaint2.setAlpha((int) (fMax * 255.0f));
                            GroupCallMiniTextureView groupCallMiniTextureView8 = GroupCallMiniTextureView.this;
                            if (groupCallMiniTextureView8.animateToFullscreen || groupCallMiniTextureView8.showingInFullscreen) {
                                groupCallMiniTextureView8.stopSharingTextView.setAlpha(fMax * (1.0f - f6));
                            } else {
                                groupCallMiniTextureView8.stopSharingTextView.setAlpha(0.0f);
                            }
                            canvas.drawText(string2, (measuredWidth - (fMeasureText2 / 2.0f)) + (i / 2.0f), AndroidUtilities.dp(32.0f) + r11, textPaint2);
                        }
                        GroupCallMiniTextureView.this.stopSharingTextView.setTranslationY(((AndroidUtilities.dp(72.0f) + r11) + GroupCallMiniTextureView.this.swipeToBackDy) - this.currentClipVertical);
                        GroupCallMiniTextureView.this.stopSharingTextView.setTranslationX(((getMeasuredWidth() - GroupCallMiniTextureView.this.stopSharingTextView.getMeasuredWidth()) / 2) - this.currentClipHorizontal);
                        float f8 = parentContainer.progressToFullscreenMode;
                        if (f8 < 1.0f && f6 < 1.0f) {
                            TextPaint textPaint3 = textPaint;
                            double dMax = Math.max(f8, f6);
                            Double.isNaN(dMax);
                            textPaint3.setAlpha((int) ((1.0d - dMax) * 255.0d));
                            canvas.save();
                            canvas.translate((measuredWidth - (AndroidUtilities.dp(400.0f) / 2.0f)) + (i / 2.0f), r11 + AndroidUtilities.dp(10.0f));
                            staticLayout.draw(canvas);
                            canvas.restore();
                        }
                    }
                    invalidate();
                }
                ImageView imageView = GroupCallMiniTextureView.this.blurredFlippingStub;
                if (imageView != null && imageView.getParent() != null) {
                    GroupCallMiniTextureView groupCallMiniTextureView9 = GroupCallMiniTextureView.this;
                    groupCallMiniTextureView9.blurredFlippingStub.setScaleX(groupCallMiniTextureView9.textureView.renderer.getScaleX());
                    GroupCallMiniTextureView groupCallMiniTextureView10 = GroupCallMiniTextureView.this;
                    groupCallMiniTextureView10.blurredFlippingStub.setScaleY(groupCallMiniTextureView10.textureView.renderer.getScaleY());
                }
                super.dispatchDraw(canvas);
                float measuredHeight2 = (getMeasuredHeight() - this.currentClipVertical) - AndroidUtilities.dp(80.0f);
                if (GroupCallMiniTextureView.this.participant != call.videoNotAvailableParticipant) {
                    canvas.save();
                    GroupCallMiniTextureView groupCallMiniTextureView11 = GroupCallMiniTextureView.this;
                    if ((groupCallMiniTextureView11.showingInFullscreen || groupCallMiniTextureView11.animateToFullscreen) && !GroupCallActivity.isLandscapeMode && !GroupCallActivity.isTabletMode) {
                        float fDp5 = AndroidUtilities.dp(90.0f);
                        GroupCallRenderersContainer groupCallRenderersContainer = parentContainer;
                        measuredHeight2 -= (fDp5 * groupCallRenderersContainer.progressToFullscreenMode) * (1.0f - groupCallRenderersContainer.progressToHideUi);
                    }
                    canvas.translate(0.0f, measuredHeight2);
                    canvas.drawPaint(GroupCallMiniTextureView.this.gradientPaint);
                    canvas.restore();
                }
                if (GroupCallMiniTextureView.this.videoIsPaused || GroupCallMiniTextureView.this.videoIsPausedProgress != 0.0f) {
                    if (!GroupCallMiniTextureView.this.videoIsPaused || GroupCallMiniTextureView.this.videoIsPausedProgress == 1.0f) {
                        if (!GroupCallMiniTextureView.this.videoIsPaused && GroupCallMiniTextureView.this.videoIsPausedProgress != 0.0f) {
                            GroupCallMiniTextureView.access$624(GroupCallMiniTextureView.this, 0.064f);
                            if (GroupCallMiniTextureView.this.videoIsPausedProgress < 0.0f) {
                                GroupCallMiniTextureView.this.videoIsPausedProgress = 0.0f;
                            } else {
                                invalidate();
                            }
                        }
                    } else {
                        GroupCallMiniTextureView.access$616(GroupCallMiniTextureView.this, 0.064f);
                        if (GroupCallMiniTextureView.this.videoIsPausedProgress > 1.0f) {
                            GroupCallMiniTextureView.this.videoIsPausedProgress = 1.0f;
                        } else {
                            invalidate();
                        }
                    }
                    float f9 = GroupCallMiniTextureView.this.videoIsPausedProgress;
                    if (isInAnimation()) {
                        float f10 = this.overlayIconAlphaFrom;
                        float f11 = this.animationProgress;
                        f3 = (f10 * (1.0f - f11)) + (GroupCallMiniTextureView.this.overlayIconAlpha * f11);
                    } else {
                        f3 = GroupCallMiniTextureView.this.overlayIconAlpha;
                    }
                    float f12 = f9 * f3;
                    if (f12 > 0.0f) {
                        float fDp6 = AndroidUtilities.dp(48.0f);
                        float measuredWidth2 = (getMeasuredWidth() - fDp6) / 2.0f;
                        float measuredHeight3 = (getMeasuredHeight() - fDp6) / 2.0f;
                        if (GroupCallMiniTextureView.this.participant == call.videoNotAvailableParticipant) {
                            measuredHeight3 -= fDp6 / 2.5f;
                        }
                        RectF rectF = AndroidUtilities.rectTmp;
                        float f13 = measuredHeight3 + fDp6;
                        rectF.set((int) measuredWidth2, (int) measuredHeight3, (int) (measuredWidth2 + fDp6), (int) f13);
                        if (f12 != 1.0f) {
                            canvas.saveLayerAlpha(rectF, (int) (f12 * 255.0f), 31);
                        } else {
                            canvas.save();
                        }
                        GroupCallMiniTextureView.this.pausedVideoDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        GroupCallMiniTextureView.this.pausedVideoDrawable.draw(canvas);
                        canvas.restore();
                        float f14 = f12 * parentContainer.progressToFullscreenMode;
                        if (f14 <= 0.0f || GroupCallMiniTextureView.this.participant == call.videoNotAvailableParticipant) {
                            return;
                        }
                        textPaint.setAlpha((int) (f14 * 255.0f));
                        canvas.drawText(string, (measuredWidth2 - (fMeasureText / 2.0f)) + (fDp6 / 2.0f), f13 + AndroidUtilities.dp(16.0f), textPaint);
                    }
                }
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                GroupCallMiniTextureView groupCallMiniTextureView = GroupCallMiniTextureView.this;
                if (groupCallMiniTextureView.inPinchToZoom && child == groupCallMiniTextureView.textureView.renderer) {
                    canvas.save();
                    GroupCallMiniTextureView groupCallMiniTextureView2 = GroupCallMiniTextureView.this;
                    float f = groupCallMiniTextureView2.pinchScale;
                    canvas.scale(f, f, groupCallMiniTextureView2.pinchCenterX, groupCallMiniTextureView2.pinchCenterY);
                    GroupCallMiniTextureView groupCallMiniTextureView3 = GroupCallMiniTextureView.this;
                    canvas.translate(groupCallMiniTextureView3.pinchTranslationX, groupCallMiniTextureView3.pinchTranslationY);
                    boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                    canvas.restore();
                    return zDrawChild;
                }
                return super.drawChild(canvas, child, drawingTime);
            }

            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                GroupCallMiniTextureView.this.invalidateFromChild = true;
                GroupCallMiniTextureView.this.invalidate();
                GroupCallMiniTextureView.this.invalidateFromChild = false;
            }

            @Override // ir.eitaa.ui.Components.voip.VoIPTextureView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                int i;
                ChatObject.VideoParticipant videoParticipant;
                GroupCallMiniTextureView groupCallMiniTextureView = GroupCallMiniTextureView.this;
                if (groupCallMiniTextureView.attached && groupCallMiniTextureView.checkScale) {
                    TextureViewRenderer textureViewRenderer = this.renderer;
                    if (textureViewRenderer.rotatedFrameHeight != 0 && textureViewRenderer.rotatedFrameWidth != 0) {
                        if (GroupCallMiniTextureView.this.showingAsScrimView) {
                            GroupCallMiniTextureView.this.textureView.scaleType = VoIPTextureView.SCALE_TYPE_FIT;
                        } else {
                            GroupCallMiniTextureView groupCallMiniTextureView2 = GroupCallMiniTextureView.this;
                            boolean z2 = groupCallMiniTextureView2.showingInFullscreen;
                            if (z2) {
                                groupCallMiniTextureView2.textureView.scaleType = VoIPTextureView.SCALE_TYPE_FIT;
                            } else {
                                boolean z3 = parentContainer.inFullscreenMode;
                                if (z3 && !z2) {
                                    groupCallMiniTextureView2.textureView.scaleType = VoIPTextureView.SCALE_TYPE_FILL;
                                } else if (!z3) {
                                    groupCallMiniTextureView2.textureView.scaleType = groupCallMiniTextureView2.participant.presentation ? VoIPTextureView.SCALE_TYPE_FIT : VoIPTextureView.SCALE_TYPE_ADAPTIVE;
                                } else {
                                    groupCallMiniTextureView2.textureView.scaleType = VoIPTextureView.SCALE_TYPE_FIT;
                                }
                            }
                        }
                        GroupCallMiniTextureView.this.checkScale = false;
                    }
                }
                super.onLayout(changed, left, top, right, bottom);
                TextureViewRenderer textureViewRenderer2 = this.renderer;
                int i2 = textureViewRenderer2.rotatedFrameHeight;
                if (i2 == 0 || (i = textureViewRenderer2.rotatedFrameWidth) == 0 || (videoParticipant = GroupCallMiniTextureView.this.participant) == null) {
                    return;
                }
                videoParticipant.setAspectRatio(i / i2, call);
            }

            @Override // ir.eitaa.ui.Components.voip.VoIPTextureView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                GroupCallMiniTextureView.this.requestLayout();
                super.requestLayout();
            }

            @Override // ir.eitaa.ui.Components.voip.VoIPTextureView
            protected void onFirstFrameRendered() {
                invalidate();
                if (!GroupCallMiniTextureView.this.videoIsPaused && this.renderer.getAlpha() != 1.0f) {
                    this.renderer.animate().setDuration(300L).alpha(1.0f);
                }
                TextureView textureView = this.blurRenderer;
                if (textureView != null && textureView.getAlpha() != 1.0f) {
                    this.blurRenderer.animate().setDuration(300L).alpha(1.0f);
                }
                ImageView imageView = GroupCallMiniTextureView.this.blurredFlippingStub;
                if (imageView == null || imageView.getParent() == null) {
                    return;
                }
                if (GroupCallMiniTextureView.this.blurredFlippingStub.getAlpha() == 1.0f) {
                    GroupCallMiniTextureView.this.blurredFlippingStub.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (GroupCallMiniTextureView.this.blurredFlippingStub.getParent() != null) {
                                GroupCallMiniTextureView groupCallMiniTextureView = GroupCallMiniTextureView.this;
                                groupCallMiniTextureView.textureView.removeView(groupCallMiniTextureView.blurredFlippingStub);
                            }
                        }
                    }).start();
                } else if (GroupCallMiniTextureView.this.blurredFlippingStub.getParent() != null) {
                    GroupCallMiniTextureView groupCallMiniTextureView = GroupCallMiniTextureView.this;
                    groupCallMiniTextureView.textureView.removeView(groupCallMiniTextureView.blurredFlippingStub);
                }
            }
        };
        this.textureView = voIPTextureView;
        voIPTextureView.renderer.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
        this.parentContainer = parentContainer;
        this.attachedRenderers = attachedRenderers;
        this.activity = activity;
        voIPTextureView.renderer.init(VideoCapturerDevice.getEglBase().getEglBaseContext(), new RendererCommon.RendererEvents() { // from class: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.2
            @Override // org.webrtc.RendererCommon.RendererEvents
            public void onFrameResolutionChanged(int videoWidth, int videoHeight, int rotation) {
            }

            @Override // org.webrtc.RendererCommon.RendererEvents
            public void onFirstFrameRendered() {
                for (int i = 0; i < GroupCallMiniTextureView.this.onFirstFrameRunnables.size(); i++) {
                    AndroidUtilities.cancelRunOnUIThread(GroupCallMiniTextureView.this.onFirstFrameRunnables.get(i));
                    GroupCallMiniTextureView.this.onFirstFrameRunnables.get(i).run();
                }
                GroupCallMiniTextureView.this.onFirstFrameRunnables.clear();
            }
        });
        voIPTextureView.attachBackgroundRenderer();
        setClipChildren(false);
        voIPTextureView.renderer.setAlpha(0.0f);
        addView(voIPTextureView);
        NoVideoStubLayout noVideoStubLayout = new NoVideoStubLayout(getContext());
        this.noVideoStubLayout = noVideoStubLayout;
        addView(noVideoStubLayout);
        SimpleTextView simpleTextView = new SimpleTextView(parentContainer.getContext());
        this.nameView = simpleTextView;
        simpleTextView.setTextSize(13);
        simpleTextView.setTextColor(ColorUtils.setAlphaComponent(-1, 229));
        simpleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        simpleTextView.setFullTextMaxLines(1);
        simpleTextView.setBuildFullLayout(true);
        FrameLayout frameLayout = new FrameLayout(parentContainer.getContext());
        this.infoContainer = frameLayout;
        frameLayout.addView(simpleTextView, LayoutHelper.createFrame(-1, -2.0f, 19, 32.0f, 0.0f, 8.0f, 0.0f));
        addView(this.infoContainer, LayoutHelper.createFrame(-1, 32.0f));
        this.speakingPaint.setStyle(Paint.Style.STROKE);
        this.speakingPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.speakingPaint.setColor(Theme.getColor("voipgroup_speakingText"));
        this.infoContainer.setClipChildren(false);
        RLottieImageView rLottieImageView = new RLottieImageView(parentContainer.getContext());
        this.micIconView = rLottieImageView;
        addView(rLottieImageView, LayoutHelper.createFrame(24, 24.0f, 0, 4.0f, 6.0f, 4.0f, 0.0f));
        ImageView imageView = new ImageView(parentContainer.getContext());
        this.screencastIcon = imageView;
        addView(imageView, LayoutHelper.createFrame(24, 24.0f, 0, 4.0f, 6.0f, 4.0f, 0.0f));
        imageView.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        imageView.setImageDrawable(ContextCompat.getDrawable(parentContainer.getContext(), R.drawable.voicechat_screencast));
        imageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        Drawable drawableCreateSimpleSelectorRoundRectDrawable = Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(19.0f), 0, ColorUtils.setAlphaComponent(-1, 100));
        TextView textView = new TextView(parentContainer.getContext()) { // from class: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.3
            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (Math.abs(GroupCallMiniTextureView.this.stopSharingTextView.getAlpha() - 1.0f) > 0.001f) {
                    return false;
                }
                return super.onTouchEvent(event);
            }
        };
        this.stopSharingTextView = textView;
        textView.setText(LocaleController.getString("VoipVideoScreenStopSharing", R.string.VoipVideoScreenStopSharing));
        this.stopSharingTextView.setTextSize(1, 15.0f);
        this.stopSharingTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.stopSharingTextView.setPadding(AndroidUtilities.dp(21.0f), 0, AndroidUtilities.dp(21.0f), 0);
        this.stopSharingTextView.setTextColor(-1);
        this.stopSharingTextView.setBackground(drawableCreateSimpleSelectorRoundRectDrawable);
        this.stopSharingTextView.setGravity(17);
        this.stopSharingTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallMiniTextureView$tgyMBbfrPYRtx7CbC3jArYj9dWA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$GroupCallMiniTextureView(view);
            }
        });
        addView(this.stopSharingTextView, LayoutHelper.createFrame(-2, 38, 51));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$GroupCallMiniTextureView(View view) {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().stopScreenCapture();
        }
        this.stopSharingTextView.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setDuration(180L).start();
    }

    public boolean isInsideStopScreenButton(float x, float y) {
        this.stopSharingTextView.getHitRect(this.rect);
        return this.rect.contains((int) x, (int) y);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0150  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void dispatchDraw(android.graphics.Canvas r9) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.dispatchDraw(android.graphics.Canvas):void");
    }

    public void getRenderBufferBitmap(GlGenericDrawer.TextureCallback callback) {
        this.textureView.renderer.getRenderBufferBitmap(callback);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        if (this.swipeToBack && (child == this.textureView || child == this.noVideoStubLayout)) {
            float fMax = (Math.max(0.0f, 1.0f - (Math.abs(this.swipeToBackDy) / AndroidUtilities.dp(300.0f))) * 0.1f) + 0.9f;
            canvas.save();
            canvas.scale(fMax, fMax, child.getX() + (child.getMeasuredWidth() / 2.0f), child.getY() + (child.getMeasuredHeight() / 2.0f));
            canvas.translate(0.0f, this.swipeToBackDy);
            boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
            canvas.restore();
            return zDrawChild;
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a8  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.onMeasure(int, int):void");
    }

    public static GroupCallMiniTextureView getOrCreate(ArrayList<GroupCallMiniTextureView> attachedRenderers, GroupCallRenderersContainer renderersContainer, GroupCallGridCell primaryView, GroupCallFullscreenAdapter.GroupCallUserCell secondaryView, GroupCallGridCell tabletGridView, ChatObject.VideoParticipant participant, ChatObject.Call call, GroupCallActivity activity) {
        GroupCallMiniTextureView groupCallMiniTextureView;
        int i = 0;
        while (true) {
            if (i >= attachedRenderers.size()) {
                groupCallMiniTextureView = null;
                break;
            }
            if (participant.equals(attachedRenderers.get(i).participant)) {
                groupCallMiniTextureView = attachedRenderers.get(i);
                break;
            }
            i++;
        }
        if (groupCallMiniTextureView == null) {
            groupCallMiniTextureView = new GroupCallMiniTextureView(renderersContainer, attachedRenderers, call, activity);
        }
        if (primaryView != null) {
            groupCallMiniTextureView.setPrimaryView(primaryView);
        }
        if (secondaryView != null) {
            groupCallMiniTextureView.setSecondaryView(secondaryView);
        }
        if (tabletGridView != null) {
            groupCallMiniTextureView.setTabletGridView(tabletGridView);
        }
        return groupCallMiniTextureView;
    }

    public void setTabletGridView(GroupCallGridCell tabletGridView) {
        if (this.tabletGridView != tabletGridView) {
            this.tabletGridView = tabletGridView;
            updateAttachState(true);
        }
    }

    public void setPrimaryView(GroupCallGridCell primaryView) {
        if (this.primaryView != primaryView) {
            this.primaryView = primaryView;
            this.checkScale = true;
            updateAttachState(true);
        }
    }

    public void setSecondaryView(GroupCallFullscreenAdapter.GroupCallUserCell secondaryView) {
        if (this.secondaryView != secondaryView) {
            this.secondaryView = secondaryView;
            this.checkScale = true;
            updateAttachState(true);
        }
    }

    public void setShowingAsScrimView(boolean showing, boolean animated) {
        this.showingAsScrimView = showing;
        updateAttachState(animated);
    }

    public void setShowingInFullscreen(boolean showing, boolean animated) {
        if (this.showingInFullscreen != showing) {
            this.showingInFullscreen = showing;
            this.checkScale = true;
            updateAttachState(animated);
        }
    }

    public void setFullscreenMode(boolean fullscreenMode, boolean animated) {
        if (this.isFullscreenMode != fullscreenMode) {
            this.isFullscreenMode = fullscreenMode;
            updateAttachState(!(this.primaryView == null && this.tabletGridView == null) && animated);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:148:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateAttachState(boolean r24) {
        /*
            Method dump skipped, instructions count: 1663
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.updateAttachState(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateAttachState$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateAttachState$1$GroupCallMiniTextureView(View view) {
        this.parentContainer.removeView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateAttachState$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateAttachState$2$GroupCallMiniTextureView(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.progressToNoVideoStub = fFloatValue;
        this.noVideoStubLayout.setAlpha(fFloatValue);
        this.textureView.invalidate();
    }

    private void loadThumb() {
        if (this.thumb != null) {
            return;
        }
        HashMap<String, Bitmap> map = this.call.thumbs;
        ChatObject.VideoParticipant videoParticipant = this.participant;
        boolean z = videoParticipant.presentation;
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = videoParticipant.participant;
        Bitmap bitmap = map.get(z ? tLRPC$TL_groupCallParticipant.presentationEndpoint : tLRPC$TL_groupCallParticipant.videoEndpoint);
        this.thumb = bitmap;
        this.textureView.setThumb(bitmap);
        if (this.thumb == null) {
            long peerId = MessageObject.getPeerId(this.participant.participant.peer);
            ChatObject.VideoParticipant videoParticipant2 = this.participant;
            if (videoParticipant2.participant.self && videoParticipant2.presentation) {
                this.imageReceiver.setImageBitmap(new MotionBackgroundDrawable(-14602694, -13935795, -14395293, -14203560, true));
                return;
            }
            if (peerId > 0) {
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(peerId));
                ImageLocation forUser = ImageLocation.getForUser(user, 1);
                int colorForId = user != null ? AvatarDrawable.getColorForId(user.id) : ColorUtils.blendARGB(-16777216, -1, 0.2f);
                this.imageReceiver.setImage(forUser, "50_50_b", new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ColorUtils.blendARGB(colorForId, -16777216, 0.2f), ColorUtils.blendARGB(colorForId, -16777216, 0.4f)}), null, user, 0);
                return;
            }
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-peerId));
            ImageLocation forChat = ImageLocation.getForChat(chat, 1);
            int colorForId2 = chat != null ? AvatarDrawable.getColorForId(chat.id) : ColorUtils.blendARGB(-16777216, -1, 0.2f);
            this.imageReceiver.setImage(forChat, "50_50_b", new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ColorUtils.blendARGB(colorForId2, -16777216, 0.2f), ColorUtils.blendARGB(colorForId2, -16777216, 0.4f)}), null, chat, 0);
        }
    }

    public void updateInfo() {
        if (this.attached) {
            String userName = null;
            long peerId = MessageObject.getPeerId(this.participant.participant.peer);
            if (DialogObject.isUserDialog(peerId)) {
                userName = UserObject.getUserName(AccountInstance.getInstance(this.currentAccount).getMessagesController().getUser(Long.valueOf(peerId)));
            } else {
                TLRPC$Chat chat = AccountInstance.getInstance(this.currentAccount).getMessagesController().getChat(Long.valueOf(-peerId));
                if (chat != null) {
                    userName = chat.title;
                }
            }
            this.nameView.setText(userName);
        }
    }

    public boolean hasImage() {
        return this.textureView.stubVisibleProgress == 1.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6 A[PHI: r11
      0x00c6: PHI (r11v15 ir.eitaa.ui.Components.voip.GroupCallGridCell) = (r11v12 ir.eitaa.ui.Components.voip.GroupCallGridCell), (r11v16 ir.eitaa.ui.Components.voip.GroupCallGridCell) binds: [B:51:0x00cb, B:47:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updatePosition(android.view.ViewGroup r9, android.view.ViewGroup r10, ir.eitaa.ui.Components.RecyclerListView r11, ir.eitaa.ui.Components.voip.GroupCallRenderersContainer r12) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.updatePosition(android.view.ViewGroup, android.view.ViewGroup, ir.eitaa.ui.Components.RecyclerListView, ir.eitaa.ui.Components.voip.GroupCallRenderersContainer):void");
    }

    public boolean isAttached() {
        return this.attached;
    }

    public void release() {
        this.textureView.renderer.release();
        GroupCallStatusIcon groupCallStatusIcon = this.statusIcon;
        if (groupCallStatusIcon != null) {
            this.activity.statusIconPool.add(groupCallStatusIcon);
            this.statusIcon.setCallback(null);
            this.statusIcon.setImageView(null);
        }
        this.statusIcon = null;
    }

    public boolean isFullyVisible() {
        return !this.showingInFullscreen && !this.animateToFullscreen && this.attached && this.textureView.renderer.isFirstFrameRendered() && getAlpha() == 1.0f;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (!this.invalidateFromChild) {
            this.textureView.invalidate();
        }
        GroupCallGridCell groupCallGridCell = this.primaryView;
        if (groupCallGridCell != null) {
            groupCallGridCell.invalidate();
            if (this.activity.getScrimView() == this.primaryView) {
                this.activity.getContainerView().invalidate();
            }
        }
        GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell = this.secondaryView;
        if (groupCallUserCell != null) {
            groupCallUserCell.invalidate();
            if (this.secondaryView.getParent() != null) {
                ((View) this.secondaryView.getParent()).invalidate();
            }
        }
        if (getParent() != null) {
            ((View) getParent()).invalidate();
        }
    }

    public void forceDetach(boolean removeSink) {
        this.forceDetached = true;
        this.attached = false;
        this.parentContainer.detach(this);
        if (removeSink) {
            if (this.participant.participant.self) {
                if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().setLocalSink(null, this.participant.presentation);
                }
            } else if (VoIPService.getSharedInstance() != null) {
                VoIPService sharedInstance = VoIPService.getSharedInstance();
                ChatObject.VideoParticipant videoParticipant = this.participant;
                sharedInstance.removeRemoteSink(videoParticipant.participant, videoParticipant.presentation);
            }
        }
        saveThumb();
        ValueAnimator valueAnimator = this.noVideoStubAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.noVideoStubAnimator.cancel();
        }
        this.textureView.renderer.release();
    }

    public void saveThumb() {
        if (this.participant == null || this.textureView.renderer.getMeasuredHeight() == 0 || this.textureView.renderer.getMeasuredWidth() == 0) {
            return;
        }
        getRenderBufferBitmap(new GlGenericDrawer.TextureCallback() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallMiniTextureView$C86KbkubT6EL49bpklJeUTVjKuU
            @Override // org.webrtc.GlGenericDrawer.TextureCallback
            public final void run(Bitmap bitmap, int i) {
                this.f$0.lambda$saveThumb$4$GroupCallMiniTextureView(bitmap, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveThumb$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveThumb$4$GroupCallMiniTextureView(final Bitmap bitmap, int i) {
        if (bitmap == null || bitmap.getPixel(0, 0) == 0) {
            return;
        }
        Utilities.stackBlurBitmap(bitmap, Math.max(7, Math.max(bitmap.getWidth(), bitmap.getHeight()) / 180));
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallMiniTextureView$AK6e3bD7041vIDBQeTW9ar1f4os
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveThumb$3$GroupCallMiniTextureView(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveThumb$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveThumb$3$GroupCallMiniTextureView(Bitmap bitmap) {
        HashMap<String, Bitmap> map = this.call.thumbs;
        ChatObject.VideoParticipant videoParticipant = this.participant;
        boolean z = videoParticipant.presentation;
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = videoParticipant.participant;
        map.put(z ? tLRPC$TL_groupCallParticipant.presentationEndpoint : tLRPC$TL_groupCallParticipant.videoEndpoint, bitmap);
    }

    public void setViews(GroupCallGridCell primaryView, GroupCallFullscreenAdapter.GroupCallUserCell secondaryView, GroupCallGridCell tabletGrid) {
        this.primaryView = primaryView;
        this.secondaryView = secondaryView;
        this.tabletGridView = tabletGrid;
    }

    public void setAmplitude(double value) {
        this.statusIcon.setAmplitude(value);
        this.noVideoStubLayout.setAmplitude(value);
    }

    public void setZoom(boolean inPinchToZoom, float pinchScale, float pinchCenterX, float pinchCenterY, float pinchTranslationX, float pinchTranslationY) {
        if (this.pinchScale == pinchScale && this.pinchCenterX == pinchCenterX && this.pinchCenterY == pinchCenterY && this.pinchTranslationX == pinchTranslationX && this.pinchTranslationY == pinchTranslationY) {
            return;
        }
        this.inPinchToZoom = inPinchToZoom;
        this.pinchScale = pinchScale;
        this.pinchCenterX = pinchCenterX;
        this.pinchCenterY = pinchCenterY;
        this.pinchTranslationX = pinchTranslationX;
        this.pinchTranslationY = pinchTranslationY;
        this.textureView.invalidate();
    }

    public void setSwipeToBack(boolean swipeToBack, float swipeToBackDy) {
        if (this.swipeToBack == swipeToBack && this.swipeToBackDy == swipeToBackDy) {
            return;
        }
        this.swipeToBack = swipeToBack;
        this.swipeToBackDy = swipeToBackDy;
        this.textureView.invalidate();
        invalidate();
    }

    public void runOnFrameRendered(Runnable runnable) {
        if (this.textureView.renderer.isFirstFrameRendered()) {
            runnable.run();
        } else {
            AndroidUtilities.runOnUIThread(runnable, 250L);
            this.onFirstFrameRunnables.add(runnable);
        }
    }

    @Override // ir.eitaa.ui.Components.voip.GroupCallStatusIcon.Callback
    public void onStatusChanged() {
        invalidate();
        updateIconColor(true);
        if (this.noVideoStubLayout.getVisibility() == 0) {
            this.noVideoStubLayout.updateMuteButtonState(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateIconColor(boolean r10) {
        /*
            r9 = this;
            ir.eitaa.ui.Components.voip.GroupCallStatusIcon r0 = r9.statusIcon
            if (r0 != 0) goto L5
            return
        L5:
            boolean r0 = r0.isMutedByMe()
            if (r0 == 0) goto L13
            java.lang.String r0 = "voipgroup_mutedByAdminIcon"
            int r0 = ir.eitaa.ui.ActionBar.Theme.getColor(r0)
        L11:
            r1 = r0
            goto L29
        L13:
            ir.eitaa.ui.Components.voip.GroupCallStatusIcon r0 = r9.statusIcon
            boolean r0 = r0.isSpeaking()
            java.lang.String r1 = "voipgroup_speakingText"
            if (r0 == 0) goto L22
            int r0 = ir.eitaa.ui.ActionBar.Theme.getColor(r1)
            goto L11
        L22:
            int r0 = ir.eitaa.ui.ActionBar.Theme.getColor(r1)
            r1 = -1
            r1 = r0
            r0 = -1
        L29:
            int r2 = r9.animateToColor
            if (r2 != r0) goto L2e
            return
        L2e:
            android.animation.ValueAnimator r2 = r9.colorAnimator
            if (r2 == 0) goto L3a
            r2.removeAllListeners()
            android.animation.ValueAnimator r2 = r9.colorAnimator
            r2.cancel()
        L3a:
            if (r10 != 0) goto L44
            android.graphics.Paint r10 = r9.speakingPaint
            r9.lastSpeakingFrameColor = r1
            r10.setColor(r1)
            goto L71
        L44:
            int r4 = r9.lastIconColor
            int r6 = r9.lastSpeakingFrameColor
            r9.animateToColor = r0
            r10 = 2
            float[] r10 = new float[r10]
            r10 = {x0072: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
            android.animation.ValueAnimator r10 = android.animation.ValueAnimator.ofFloat(r10)
            r9.colorAnimator = r10
            ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallMiniTextureView$V-aM4ACETAvhobUm05MVQom8ulw r8 = new ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallMiniTextureView$V-aM4ACETAvhobUm05MVQom8ulw
            r2 = r8
            r3 = r9
            r5 = r0
            r7 = r1
            r2.<init>()
            r10.addUpdateListener(r8)
            android.animation.ValueAnimator r10 = r9.colorAnimator
            ir.eitaa.ui.Components.voip.GroupCallMiniTextureView$7 r2 = new ir.eitaa.ui.Components.voip.GroupCallMiniTextureView$7
            r2.<init>()
            r10.addListener(r2)
            android.animation.ValueAnimator r10 = r9.colorAnimator
            r10.start()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.updateIconColor(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateIconColor$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateIconColor$5$GroupCallMiniTextureView(int i, int i2, int i3, int i4, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.lastIconColor = ColorUtils.blendARGB(i, i2, fFloatValue);
        int iBlendARGB = ColorUtils.blendARGB(i3, i4, fFloatValue);
        this.lastSpeakingFrameColor = iBlendARGB;
        this.speakingPaint.setColor(iBlendARGB);
        if (this.progressToSpeaking > 0.0f) {
            invalidate();
        }
    }

    public void runDelayedAnimations() {
        for (int i = 0; i < this.onFirstFrameRunnables.size(); i++) {
            this.onFirstFrameRunnables.get(i).run();
        }
        this.onFirstFrameRunnables.clear();
    }

    public void updateSize(int collapseSize) {
        int measuredWidth = this.parentContainer.getMeasuredWidth() - AndroidUtilities.dp(6.0f);
        if ((this.collapseSize == collapseSize || collapseSize <= 0) && (this.fullSize == measuredWidth || measuredWidth <= 0)) {
            return;
        }
        if (collapseSize != 0) {
            this.collapseSize = collapseSize;
        }
        if (measuredWidth != 0) {
            this.fullSize = measuredWidth;
        }
        this.nameView.setFullLayoutAdditionalWidth(measuredWidth - collapseSize, 0);
    }

    private class NoVideoStubLayout extends View {
        float amplitude;
        float animateAmplitudeDiff;
        float animateToAmplitude;
        AvatarDrawable avatarDrawable;
        public ImageReceiver avatarImageReceiver;
        public ImageReceiver backgroundImageReceiver;
        Paint backgroundPaint;
        BlobDrawable bigWaveDrawable;
        private GroupCallActivity.WeavingState currentState;
        float cx;
        float cy;
        int muteButtonState;
        Paint paint;
        private GroupCallActivity.WeavingState prevState;
        float speakingProgress;
        private GroupCallActivity.WeavingState[] states;
        float switchProgress;
        BlobDrawable tinyWaveDrawable;
        float wavesEnter;

        public NoVideoStubLayout(Context context) {
            super(context);
            this.avatarImageReceiver = new ImageReceiver();
            this.backgroundImageReceiver = new ImageReceiver();
            this.avatarDrawable = new AvatarDrawable();
            this.paint = new Paint(1);
            this.backgroundPaint = new Paint(1);
            this.wavesEnter = 0.0f;
            this.states = new GroupCallActivity.WeavingState[3];
            this.muteButtonState = -1;
            this.switchProgress = 1.0f;
            this.tinyWaveDrawable = new BlobDrawable(9);
            this.bigWaveDrawable = new BlobDrawable(12);
            this.tinyWaveDrawable.minRadius = AndroidUtilities.dp(76.0f);
            this.tinyWaveDrawable.maxRadius = AndroidUtilities.dp(92.0f);
            this.tinyWaveDrawable.generateBlob();
            this.bigWaveDrawable.minRadius = AndroidUtilities.dp(80.0f);
            this.bigWaveDrawable.maxRadius = AndroidUtilities.dp(95.0f);
            this.bigWaveDrawable.generateBlob();
            this.paint.setColor(ColorUtils.blendARGB(Theme.getColor("voipgroup_listeningText"), Theme.getColor("voipgroup_speakingText"), this.speakingProgress));
            this.paint.setAlpha(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle);
            this.backgroundPaint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            float fDp = AndroidUtilities.dp(157.0f);
            this.cx = getMeasuredWidth() >> 1;
            this.cy = (getMeasuredHeight() >> 1) + (GroupCallActivity.isLandscapeMode ? 0.0f : (-getMeasuredHeight()) * 0.12f);
            float f = fDp / 2.0f;
            this.avatarImageReceiver.setRoundRadius((int) f);
            this.avatarImageReceiver.setImageCoords(this.cx - f, this.cy - f, fDp, fDp);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            GroupCallActivity.WeavingState weavingState;
            float f;
            GroupCallActivity.WeavingState weavingState2;
            super.onDraw(canvas);
            RectF rectF = AndroidUtilities.rectTmp;
            float x = GroupCallMiniTextureView.this.textureView.getX();
            VoIPTextureView voIPTextureView = GroupCallMiniTextureView.this.textureView;
            float f2 = x + voIPTextureView.currentClipHorizontal;
            float y = voIPTextureView.getY();
            VoIPTextureView voIPTextureView2 = GroupCallMiniTextureView.this.textureView;
            float f3 = y + voIPTextureView2.currentClipVertical;
            float x2 = voIPTextureView2.getX() + GroupCallMiniTextureView.this.textureView.getMeasuredWidth();
            VoIPTextureView voIPTextureView3 = GroupCallMiniTextureView.this.textureView;
            rectF.set(f2, f3, x2 - voIPTextureView3.currentClipHorizontal, voIPTextureView3.getY() + GroupCallMiniTextureView.this.textureView.getMeasuredHeight() + GroupCallMiniTextureView.this.textureView.currentClipVertical);
            this.backgroundImageReceiver.setImageCoords(rectF.left, rectF.top, rectF.width(), rectF.height());
            this.backgroundImageReceiver.setRoundRadius((int) GroupCallMiniTextureView.this.textureView.roundRadius);
            this.backgroundImageReceiver.draw(canvas);
            float f4 = GroupCallMiniTextureView.this.textureView.roundRadius;
            canvas.drawRoundRect(rectF, f4, f4, this.backgroundPaint);
            float f5 = this.animateToAmplitude;
            float f6 = this.amplitude;
            if (f5 != f6) {
                float f7 = this.animateAmplitudeDiff;
                float f8 = f6 + (16.0f * f7);
                this.amplitude = f8;
                if (f7 > 0.0f) {
                    if (f8 > f5) {
                        this.amplitude = f5;
                    }
                } else if (f8 < f5) {
                    this.amplitude = f5;
                }
            }
            float f9 = this.switchProgress;
            if (f9 != 1.0f) {
                if (this.prevState != null) {
                    this.switchProgress = f9 + 0.07272727f;
                }
                if (this.switchProgress >= 1.0f) {
                    this.switchProgress = 1.0f;
                    this.prevState = null;
                }
            }
            float f10 = (this.amplitude * 0.8f) + 1.0f;
            canvas.save();
            canvas.scale(f10, f10, this.cx, this.cy);
            GroupCallActivity.WeavingState weavingState3 = this.currentState;
            if (weavingState3 != null) {
                weavingState3.update((int) (this.cy - AndroidUtilities.dp(100.0f)), (int) (this.cx - AndroidUtilities.dp(100.0f)), AndroidUtilities.dp(200.0f), 16L, this.amplitude);
            }
            this.bigWaveDrawable.update(this.amplitude, 1.0f);
            this.tinyWaveDrawable.update(this.amplitude, 1.0f);
            for (int i = 0; i < 2; i++) {
                if (i == 0 && (weavingState2 = this.prevState) != null) {
                    this.paint.setShader(weavingState2.shader);
                    f = 1.0f - this.switchProgress;
                } else if (i == 1 && (weavingState = this.currentState) != null) {
                    this.paint.setShader(weavingState.shader);
                    f = this.switchProgress;
                }
                this.paint.setAlpha((int) (f * 76.0f));
                this.bigWaveDrawable.draw(this.cx, this.cy, canvas, this.paint);
                this.tinyWaveDrawable.draw(this.cx, this.cy, canvas, this.paint);
            }
            canvas.restore();
            float f11 = (this.amplitude * 0.2f) + 1.0f;
            canvas.save();
            canvas.scale(f11, f11, this.cx, this.cy);
            this.avatarImageReceiver.draw(canvas);
            canvas.restore();
            invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateMuteButtonState(boolean animated) {
            int i;
            if (GroupCallMiniTextureView.this.statusIcon.isMutedByMe() || GroupCallMiniTextureView.this.statusIcon.isMutedByAdmin()) {
                i = 2;
            } else {
                i = GroupCallMiniTextureView.this.statusIcon.isSpeaking() ? 1 : 0;
            }
            if (i == this.muteButtonState) {
                return;
            }
            this.muteButtonState = i;
            GroupCallActivity.WeavingState[] weavingStateArr = this.states;
            if (weavingStateArr[i] == null) {
                weavingStateArr[i] = new GroupCallActivity.WeavingState(i);
                int i2 = this.muteButtonState;
                if (i2 == 2) {
                    this.states[i2].shader = new LinearGradient(0.0f, 400.0f, 400.0f, 0.0f, new int[]{Theme.getColor("voipgroup_mutedByAdminGradient"), Theme.getColor("voipgroup_mutedByAdminGradient3"), Theme.getColor("voipgroup_mutedByAdminGradient2")}, (float[]) null, Shader.TileMode.CLAMP);
                } else if (i2 == 1) {
                    this.states[i2].shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{Theme.getColor("voipgroup_muteButton"), Theme.getColor("voipgroup_muteButton3")}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    this.states[i2].shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{Theme.getColor("voipgroup_unmuteButton2"), Theme.getColor("voipgroup_unmuteButton")}, (float[]) null, Shader.TileMode.CLAMP);
                }
            }
            GroupCallActivity.WeavingState[] weavingStateArr2 = this.states;
            int i3 = this.muteButtonState;
            GroupCallActivity.WeavingState weavingState = weavingStateArr2[i3];
            GroupCallActivity.WeavingState weavingState2 = this.currentState;
            if (weavingState != weavingState2) {
                this.prevState = weavingState2;
                this.currentState = weavingStateArr2[i3];
                if (weavingState2 == null || !animated) {
                    this.switchProgress = 1.0f;
                    this.prevState = null;
                } else {
                    this.switchProgress = 0.0f;
                }
            }
            invalidate();
        }

        public void setAmplitude(double value) {
            float f = ((float) value) / 80.0f;
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            this.animateToAmplitude = f;
            this.animateAmplitudeDiff = (f - this.amplitude) / 200.0f;
        }

        @Override // android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.avatarImageReceiver.onAttachedToWindow();
            this.backgroundImageReceiver.onAttachedToWindow();
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.avatarImageReceiver.onDetachedFromWindow();
            this.backgroundImageReceiver.onDetachedFromWindow();
        }
    }

    public String getName() {
        long peerId = MessageObject.getPeerId(this.participant.participant.peer);
        if (DialogObject.isUserDialog(peerId)) {
            return UserObject.getUserName(AccountInstance.getInstance(UserConfig.selectedAccount).getMessagesController().getUser(Long.valueOf(peerId)));
        }
        return AccountInstance.getInstance(UserConfig.selectedAccount).getMessagesController().getChat(Long.valueOf(-peerId)).title;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.imageReceiver.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.imageReceiver.onAttachedToWindow();
    }

    public void startFlipAnimation() {
        if (this.flipAnimator != null) {
            return;
        }
        this.flipHalfReached = false;
        ImageView imageView = this.blurredFlippingStub;
        if (imageView == null) {
            this.blurredFlippingStub = new ImageView(getContext());
        } else {
            imageView.animate().cancel();
        }
        if (this.textureView.renderer.isFirstFrameRendered()) {
            Bitmap bitmap = this.textureView.blurRenderer.getBitmap(100, 100);
            if (bitmap != null) {
                Utilities.blurBitmap(bitmap, 3, 1, bitmap.getWidth(), bitmap.getHeight(), bitmap.getRowBytes());
                this.blurredFlippingStub.setBackground(new BitmapDrawable(bitmap));
            }
            this.blurredFlippingStub.setAlpha(0.0f);
        } else {
            this.blurredFlippingStub.setAlpha(1.0f);
        }
        if (this.blurredFlippingStub.getParent() == null) {
            this.textureView.addView(this.blurredFlippingStub);
        }
        ((FrameLayout.LayoutParams) this.blurredFlippingStub.getLayoutParams()).gravity = 17;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.flipAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallMiniTextureView$GaMmVZqgvcNUhKDV3MtqHvgAQFQ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startFlipAnimation$6$GroupCallMiniTextureView(valueAnimator);
            }
        });
        this.flipAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.GroupCallMiniTextureView.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                GroupCallMiniTextureView groupCallMiniTextureView = GroupCallMiniTextureView.this;
                groupCallMiniTextureView.flipAnimator = null;
                groupCallMiniTextureView.textureView.setRotationY(0.0f);
                GroupCallMiniTextureView groupCallMiniTextureView2 = GroupCallMiniTextureView.this;
                if (groupCallMiniTextureView2.flipHalfReached) {
                    return;
                }
                groupCallMiniTextureView2.textureView.renderer.clearImage();
            }
        });
        this.flipAnimator.setDuration(400L);
        this.flipAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.flipAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startFlipAnimation$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startFlipAnimation$6$GroupCallMiniTextureView(ValueAnimator valueAnimator) {
        boolean z;
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (fFloatValue < 0.5f) {
            z = false;
        } else {
            fFloatValue -= 1.0f;
            z = true;
        }
        if (z && !this.flipHalfReached) {
            this.blurredFlippingStub.setAlpha(1.0f);
            this.flipHalfReached = true;
            this.textureView.renderer.clearImage();
        }
        float f = fFloatValue * 180.0f;
        this.blurredFlippingStub.setRotationY(f);
        this.textureView.renderer.setRotationY(f);
    }
}
