package ir.eitaa.ui.Components.voip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.support.LongSparseIntArray;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarsImageView;
import ir.eitaa.ui.Components.CrossOutDrawable;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.TypefaceSpan;
import ir.eitaa.ui.Components.UndoView;
import ir.eitaa.ui.GroupCallActivity;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class GroupCallRenderersContainer extends FrameLayout {
    private boolean animateSpeakingOnNextDraw;
    int animationIndex;
    private LongSparseIntArray attachedPeerIds;
    private final ArrayList<GroupCallMiniTextureView> attachedRenderers;
    private final ImageView backButton;
    ChatObject.Call call;
    private boolean canZoomGesture;
    private boolean drawFirst;
    private boolean drawRenderesOnly;
    ValueAnimator fullscreenAnimator;
    private final RecyclerView fullscreenListView;
    public ChatObject.VideoParticipant fullscreenParticipant;
    public long fullscreenPeerId;
    public GroupCallMiniTextureView fullscreenTextureView;
    GroupCallActivity groupCallActivity;
    public boolean hasPinnedVideo;
    Runnable hideUiRunnable;
    boolean hideUiRunnableIsScheduled;
    public boolean inFullscreenMode;
    public boolean inLayout;
    private boolean isInPinchToZoomTouchMode;
    private boolean isTablet;
    public long lastUpdateTime;
    long lastUpdateTooltipTime;
    private final RecyclerView listView;
    public int listWidth;
    boolean maybeSwipeToBackGesture;
    private boolean notDrawRenderes;
    private GroupCallMiniTextureView outFullscreenTextureView;
    private final ImageView pinButton;
    View pinContainer;
    CrossOutDrawable pinDrawable;
    TextView pinTextView;
    private float pinchCenterX;
    private float pinchCenterY;
    float pinchScale;
    private float pinchStartCenterX;
    private float pinchStartCenterY;
    private float pinchStartDistance;
    private float pinchTranslationX;
    private float pinchTranslationY;
    private int pointerId1;
    private int pointerId2;
    public float progressToFullscreenMode;
    float progressToHideUi;
    public float progressToScrimView;
    ValueAnimator replaceFullscreenViewAnimator;
    private boolean showSpeakingMembersToast;
    private float showSpeakingMembersToastProgress;
    private final AvatarsImageView speakingMembersAvatars;
    private final TextView speakingMembersText;
    private final FrameLayout speakingMembersToast;
    private float speakingMembersToastChangeProgress;
    private float speakingMembersToastFromLeft;
    private float speakingMembersToastFromRight;
    private float speakingMembersToastFromTextLeft;
    private long speakingToastPeerId;
    ValueAnimator swipeToBackAnimator;
    float swipeToBackDy;
    boolean swipeToBackGesture;
    public boolean swipedBack;
    boolean tapGesture;
    long tapTime;
    float tapX;
    float tapY;
    Drawable topShadowDrawable;
    private final View topShadowView;
    private final int touchSlop;
    boolean uiVisible;
    public UndoView[] undoView;
    TextView unpinTextView;
    Runnable updateTooltipRunnbale;
    ValueAnimator zoomBackAnimator;
    private boolean zoomStarted;

    protected void onBackPressed() {
    }

    protected void onFullScreenModeChanged(boolean startAnimaion) {
    }

    protected void onUiVisibilityChanged() {
    }

    public GroupCallRenderersContainer(Context context, RecyclerView listView, RecyclerView fullscreenListView, ArrayList<GroupCallMiniTextureView> attachedRenderers, ChatObject.Call call, GroupCallActivity groupCallActivity) {
        super(context);
        this.attachedPeerIds = new LongSparseIntArray();
        this.speakingMembersToastChangeProgress = 1.0f;
        this.animateSpeakingOnNextDraw = true;
        this.uiVisible = true;
        this.hideUiRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (!GroupCallRenderersContainer.this.canHideUI()) {
                    AndroidUtilities.runOnUIThread(GroupCallRenderersContainer.this.hideUiRunnable, 3000L);
                    return;
                }
                GroupCallRenderersContainer groupCallRenderersContainer = GroupCallRenderersContainer.this;
                groupCallRenderersContainer.hideUiRunnableIsScheduled = false;
                groupCallRenderersContainer.setUiVisible(false);
            }
        };
        this.pinchScale = 1.0f;
        this.undoView = new UndoView[2];
        this.listView = listView;
        this.fullscreenListView = fullscreenListView;
        this.attachedRenderers = attachedRenderers;
        this.call = call;
        this.groupCallActivity = groupCallActivity;
        ImageView imageView = new ImageView(context) { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.2
            @Override // android.widget.ImageView, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(ActionBar.getCurrentActionBarHeight(), 1073741824));
            }
        };
        this.backButton = imageView;
        BackDrawable backDrawable = new BackDrawable(false);
        backDrawable.setColor(-1);
        imageView.setImageDrawable(backDrawable);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        imageView.setBackground(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(-1, 55)));
        View view = new View(context);
        this.topShadowView = view;
        Drawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0, ColorUtils.setAlphaComponent(-16777216, R.styleable.AppCompatTheme_windowFixedHeightMajor)});
        this.topShadowDrawable = gradientDrawable;
        view.setBackgroundDrawable(gradientDrawable);
        addView(view, LayoutHelper.createFrame(-1, 120.0f));
        addView(imageView, LayoutHelper.createFrame(56, -1, 51));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallRenderersContainer$7qqASdnfD3Kbt0icINkzGhpo1AY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0$GroupCallRenderersContainer(view2);
            }
        });
        ImageView imageView2 = new ImageView(context) { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.3
            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                GroupCallRenderersContainer.this.pinContainer.invalidate();
                GroupCallRenderersContainer.this.invalidate();
            }

            @Override // android.widget.ImageView, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(ActionBar.getCurrentActionBarHeight(), 1073741824));
            }
        };
        this.pinButton = imageView2;
        final Drawable drawableCreateSimpleSelectorRoundRectDrawable = Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(20.0f), 0, ColorUtils.setAlphaComponent(-1, 100));
        View view2 = new View(context) { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.4
            @Override // android.view.View
            protected void drawableStateChanged() {
                super.drawableStateChanged();
                drawableCreateSimpleSelectorRoundRectDrawable.setState(getDrawableState());
            }

            @Override // android.view.View
            public boolean verifyDrawable(Drawable drawable) {
                return drawableCreateSimpleSelectorRoundRectDrawable == drawable || super.verifyDrawable(drawable);
            }

            @Override // android.view.View
            public void jumpDrawablesToCurrentState() {
                super.jumpDrawablesToCurrentState();
                drawableCreateSimpleSelectorRoundRectDrawable.jumpToCurrentState();
            }

            @Override // android.view.View
            protected void dispatchDraw(Canvas canvas) {
                float measuredWidth = (GroupCallRenderersContainer.this.pinTextView.getMeasuredWidth() * (1.0f - GroupCallRenderersContainer.this.pinDrawable.getProgress())) + (GroupCallRenderersContainer.this.unpinTextView.getMeasuredWidth() * GroupCallRenderersContainer.this.pinDrawable.getProgress());
                canvas.save();
                drawableCreateSimpleSelectorRoundRectDrawable.setBounds(0, 0, AndroidUtilities.dp(50.0f) + ((int) measuredWidth), getMeasuredHeight());
                drawableCreateSimpleSelectorRoundRectDrawable.draw(canvas);
                super.dispatchDraw(canvas);
            }
        };
        this.pinContainer = view2;
        view2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallRenderersContainer$IKdMzMpDt0oV41MHbpvbLvBPwV0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$1$GroupCallRenderersContainer(view3);
            }
        });
        drawableCreateSimpleSelectorRoundRectDrawable.setCallback(this.pinContainer);
        addView(this.pinContainer);
        CrossOutDrawable crossOutDrawable = new CrossOutDrawable(context, R.drawable.msg_pin_filled, null);
        this.pinDrawable = crossOutDrawable;
        crossOutDrawable.setOffsets(-AndroidUtilities.dp(1.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(1.0f));
        imageView2.setImageDrawable(this.pinDrawable);
        imageView2.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        addView(imageView2, LayoutHelper.createFrame(56, -1, 51));
        TextView textView = new TextView(context);
        this.pinTextView = textView;
        textView.setTextColor(-1);
        this.pinTextView.setTextSize(1, 15.0f);
        this.pinTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.pinTextView.setText(LocaleController.getString("CallVideoPin", R.string.CallVideoPin));
        TextView textView2 = new TextView(context);
        this.unpinTextView = textView2;
        textView2.setTextColor(-1);
        this.unpinTextView.setTextSize(1, 15.0f);
        this.unpinTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.unpinTextView.setText(LocaleController.getString("CallVideoUnpin", R.string.CallVideoUnpin));
        addView(this.pinTextView, LayoutHelper.createFrame(-2, -2, 51));
        addView(this.unpinTextView, LayoutHelper.createFrame(-2, -2, 51));
        final Drawable drawableCreateRoundRectDrawable = Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), ColorUtils.setAlphaComponent(Theme.getColor("voipgroup_listViewBackground"), 204));
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.5
            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                if (GroupCallRenderersContainer.this.speakingMembersToastChangeProgress != 1.0f) {
                    float interpolation = 1.0f - CubicBezierInterpolator.DEFAULT.getInterpolation(GroupCallRenderersContainer.this.speakingMembersToastChangeProgress);
                    float left = (GroupCallRenderersContainer.this.speakingMembersToastFromLeft - getLeft()) * interpolation;
                    float left2 = (GroupCallRenderersContainer.this.speakingMembersToastFromTextLeft - GroupCallRenderersContainer.this.speakingMembersText.getLeft()) * interpolation;
                    drawableCreateRoundRectDrawable.setBounds((int) left, 0, getMeasuredWidth() + ((int) ((GroupCallRenderersContainer.this.speakingMembersToastFromRight - getRight()) * interpolation)), getMeasuredHeight());
                    GroupCallRenderersContainer.this.speakingMembersAvatars.setTranslationX(left);
                    GroupCallRenderersContainer.this.speakingMembersText.setTranslationX(-left2);
                } else {
                    drawableCreateRoundRectDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                    GroupCallRenderersContainer.this.speakingMembersAvatars.setTranslationX(0.0f);
                    GroupCallRenderersContainer.this.speakingMembersText.setTranslationX(0.0f);
                }
                drawableCreateRoundRectDrawable.draw(canvas);
                super.dispatchDraw(canvas);
            }
        };
        this.speakingMembersToast = frameLayout;
        AvatarsImageView avatarsImageView = new AvatarsImageView(context, true);
        this.speakingMembersAvatars = avatarsImageView;
        avatarsImageView.setStyle(10);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        frameLayout.addView(avatarsImageView, LayoutHelper.createFrame(100, 32.0f, 16, 0.0f, 0.0f, 0.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.speakingMembersText = textView3;
        textView3.setTextSize(1, 14.0f);
        textView3.setTextColor(-1);
        textView3.setLines(1);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        frameLayout.addView(textView3, LayoutHelper.createFrame(-2, -2, 16));
        addView(frameLayout, LayoutHelper.createFrame(-2, 36.0f, 1, 0.0f, 0.0f, 0.0f, 0.0f));
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        for (int i = 0; i < 2; i++) {
            this.undoView[i] = new UndoView(context) { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.6
                @Override // ir.eitaa.ui.Components.UndoView, android.view.View
                public void invalidate() {
                    super.invalidate();
                    GroupCallRenderersContainer.this.invalidate();
                }
            };
            this.undoView[i].setHideAnimationType(2);
            this.undoView[i].setAdditionalTranslationY(AndroidUtilities.dp(10.0f));
            addView(this.undoView[i], LayoutHelper.createFrame(-1, -2.0f, 80, 16.0f, 0.0f, 0.0f, 8.0f));
        }
        this.pinContainer.setVisibility(8);
        setIsTablet(GroupCallActivity.isTabletMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$GroupCallRenderersContainer(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$GroupCallRenderersContainer(View view) {
        if (this.inFullscreenMode) {
            boolean z = !this.hasPinnedVideo;
            this.hasPinnedVideo = z;
            this.pinDrawable.setCrossOut(z, true);
            requestLayout();
        }
    }

    public void setIsTablet(boolean tablet) {
        if (this.isTablet != tablet) {
            this.isTablet = tablet;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.backButton.getLayoutParams();
            layoutParams.gravity = tablet ? 85 : 51;
            layoutParams.rightMargin = tablet ? AndroidUtilities.dp(328.0f) : 0;
            layoutParams.bottomMargin = tablet ? -AndroidUtilities.dp(8.0f) : 0;
            if (this.isTablet) {
                this.backButton.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.msg_calls_minimize));
                return;
            }
            BackDrawable backDrawable = new BackDrawable(false);
            backDrawable.setColor(-1);
            this.backButton.setImageDrawable(backDrawable);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        if (this.drawFirst) {
            if (!(child instanceof GroupCallMiniTextureView) || !((GroupCallMiniTextureView) child).drawFirst) {
                return true;
            }
            float y = this.listView.getY() - getTop();
            float measuredHeight = (this.listView.getMeasuredHeight() + y) - this.listView.getTranslationY();
            canvas.save();
            canvas.clipRect(0.0f, y, getMeasuredWidth(), measuredHeight);
            boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
            canvas.restore();
            return zDrawChild;
        }
        UndoView[] undoViewArr = this.undoView;
        if (child == undoViewArr[0] || child == undoViewArr[1]) {
            return true;
        }
        if (child instanceof GroupCallMiniTextureView) {
            GroupCallMiniTextureView groupCallMiniTextureView = (GroupCallMiniTextureView) child;
            if (groupCallMiniTextureView == this.fullscreenTextureView || groupCallMiniTextureView == this.outFullscreenTextureView || this.notDrawRenderes || groupCallMiniTextureView.drawFirst) {
                return true;
            }
            if (groupCallMiniTextureView.primaryView != null) {
                float y2 = this.listView.getY() - getTop();
                float measuredHeight2 = (this.listView.getMeasuredHeight() + y2) - this.listView.getTranslationY();
                float f = this.progressToFullscreenMode;
                if (groupCallMiniTextureView.secondaryView == null) {
                    f = 0.0f;
                }
                canvas.save();
                float f2 = 1.0f - f;
                canvas.clipRect(0.0f, y2 * f2, getMeasuredWidth(), (measuredHeight2 * f2) + (getMeasuredHeight() * f));
                boolean zDrawChild2 = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
                return zDrawChild2;
            }
            if (GroupCallActivity.isTabletMode) {
                canvas.save();
                canvas.clipRect(0, 0, getMeasuredWidth(), getMeasuredHeight());
                boolean zDrawChild3 = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
                return zDrawChild3;
            }
            return super.drawChild(canvas, child, drawingTime);
        }
        if (this.drawRenderesOnly) {
            return true;
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x03c4  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void dispatchDraw(android.graphics.Canvas r23) {
        /*
            Method dump skipped, instructions count: 1182
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.dispatchDraw(android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestFullscreen(ir.eitaa.messenger.ChatObject.VideoParticipant r17) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.requestFullscreen(ir.eitaa.messenger.ChatObject$VideoParticipant):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestFullscreen$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestFullscreen$2$GroupCallRenderersContainer(final GroupCallMiniTextureView groupCallMiniTextureView, final GroupCallMiniTextureView groupCallMiniTextureView2) {
        ValueAnimator valueAnimator = this.replaceFullscreenViewAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        groupCallMiniTextureView.animate().scaleX(0.5f).scaleY(0.5f).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (groupCallMiniTextureView.getParent() != null) {
                    GroupCallRenderersContainer.this.removeView(groupCallMiniTextureView);
                    groupCallMiniTextureView.release();
                }
            }
        }).setDuration(100L).start();
        if (groupCallMiniTextureView2 != null) {
            groupCallMiniTextureView2.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(100L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    groupCallMiniTextureView2.animateEnter = false;
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestFullscreen$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestFullscreen$3$GroupCallRenderersContainer(final GroupCallMiniTextureView groupCallMiniTextureView) {
        groupCallMiniTextureView.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                groupCallMiniTextureView.animateEnter = false;
            }
        }).setDuration(150L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestFullscreen$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestFullscreen$4$GroupCallRenderersContainer(GroupCallMiniTextureView groupCallMiniTextureView, ValueAnimator valueAnimator) {
        groupCallMiniTextureView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestFullscreen$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestFullscreen$5$GroupCallRenderersContainer(ValueAnimator valueAnimator) {
        this.progressToFullscreenMode = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurrentFullscreenTextureView() {
        GroupCallMiniTextureView groupCallMiniTextureView = this.fullscreenTextureView;
        if (groupCallMiniTextureView != null) {
            groupCallMiniTextureView.setSwipeToBack(false, 0.0f);
            this.fullscreenTextureView.setZoom(false, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    protected void update() {
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUiVisible(boolean uiVisible) {
        if (this.uiVisible != uiVisible) {
            this.uiVisible = uiVisible;
            onUiVisibilityChanged();
            if (uiVisible && this.inFullscreenMode) {
                if (!this.hideUiRunnableIsScheduled) {
                    this.hideUiRunnableIsScheduled = true;
                    AndroidUtilities.runOnUIThread(this.hideUiRunnable, 3000L);
                }
            } else {
                this.hideUiRunnableIsScheduled = false;
                AndroidUtilities.cancelRunOnUIThread(this.hideUiRunnable);
            }
            GroupCallMiniTextureView groupCallMiniTextureView = this.fullscreenTextureView;
            if (groupCallMiniTextureView != null) {
                groupCallMiniTextureView.requestLayout();
            }
        }
    }

    protected boolean canHideUI() {
        return this.inFullscreenMode;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return onTouchEvent(ev);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x025a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 1197
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void animateSwipeToBack(boolean aplay) {
        ValueAnimator valueAnimatorOfFloat;
        if (this.swipeToBackGesture) {
            this.swipeToBackGesture = false;
            float[] fArr = new float[2];
            float f = this.swipeToBackDy;
            if (aplay) {
                fArr[0] = f;
                fArr[1] = 0.0f;
                valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            } else {
                fArr[0] = f;
                fArr[1] = 0.0f;
                valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            }
            this.swipeToBackAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallRenderersContainer$wSi-4-F1MRtNf0thdRp2BWQIp74
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$animateSwipeToBack$6$GroupCallRenderersContainer(valueAnimator);
                }
            });
            this.swipeToBackAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.15
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    GroupCallRenderersContainer groupCallRenderersContainer = GroupCallRenderersContainer.this;
                    groupCallRenderersContainer.swipeToBackAnimator = null;
                    groupCallRenderersContainer.swipeToBackDy = 0.0f;
                    groupCallRenderersContainer.invalidate();
                }
            });
            ValueAnimator valueAnimator = this.swipeToBackAnimator;
            CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
            valueAnimator.setInterpolator(cubicBezierInterpolator);
            this.swipeToBackAnimator.setDuration(aplay ? 350L : 200L);
            this.swipeToBackAnimator.setInterpolator(cubicBezierInterpolator);
            GroupCallMiniTextureView groupCallMiniTextureView = this.fullscreenTextureView;
            if (groupCallMiniTextureView != null) {
                groupCallMiniTextureView.textureView.synchOrRunAnimation(this.swipeToBackAnimator);
            } else {
                this.swipeToBackAnimator.start();
            }
            this.lastUpdateTime = System.currentTimeMillis();
        }
        this.maybeSwipeToBackGesture = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$animateSwipeToBack$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$animateSwipeToBack$6$GroupCallRenderersContainer(ValueAnimator valueAnimator) {
        this.swipeToBackDy = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private void finishZoom() {
        if (this.zoomStarted) {
            this.zoomStarted = false;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.zoomBackAnimator = valueAnimatorOfFloat;
            final float f = this.pinchScale;
            final float f2 = this.pinchTranslationX;
            final float f3 = this.pinchTranslationY;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallRenderersContainer$vrMelWffRuparXDTVFm3QsuX7RA
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$finishZoom$7$GroupCallRenderersContainer(f, f2, f3, valueAnimator);
                }
            });
            this.zoomBackAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.GroupCallRenderersContainer.16
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    GroupCallRenderersContainer groupCallRenderersContainer = GroupCallRenderersContainer.this;
                    groupCallRenderersContainer.zoomBackAnimator = null;
                    groupCallRenderersContainer.pinchScale = 1.0f;
                    groupCallRenderersContainer.pinchTranslationX = 0.0f;
                    GroupCallRenderersContainer.this.pinchTranslationY = 0.0f;
                    GroupCallRenderersContainer.this.invalidate();
                }
            });
            this.zoomBackAnimator.setDuration(350L);
            this.zoomBackAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.zoomBackAnimator.start();
            this.lastUpdateTime = System.currentTimeMillis();
        }
        this.canZoomGesture = false;
        this.isInPinchToZoomTouchMode = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$finishZoom$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$finishZoom$7$GroupCallRenderersContainer(float f, float f2, float f3, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.pinchScale = (f * fFloatValue) + ((1.0f - fFloatValue) * 1.0f);
        this.pinchTranslationX = f2 * fFloatValue;
        this.pinchTranslationY = f3 * fFloatValue;
        invalidate();
    }

    private boolean checkPointerIds(MotionEvent ev) {
        if (ev.getPointerCount() < 2) {
            return false;
        }
        if (this.pointerId1 == ev.getPointerId(0) && this.pointerId2 == ev.getPointerId(1)) {
            return true;
        }
        return this.pointerId1 == ev.getPointerId(1) && this.pointerId2 == ev.getPointerId(0);
    }

    public void delayHideUi() {
        if (this.hideUiRunnableIsScheduled) {
            AndroidUtilities.cancelRunOnUIThread(this.hideUiRunnable);
            AndroidUtilities.runOnUIThread(this.hideUiRunnable, 3000L);
        }
    }

    public boolean isUiVisible() {
        return this.uiVisible;
    }

    public void setProgressToHideUi(float progressToHideUi) {
        if (this.progressToHideUi != progressToHideUi) {
            this.progressToHideUi = progressToHideUi;
            invalidate();
            GroupCallMiniTextureView groupCallMiniTextureView = this.fullscreenTextureView;
            if (groupCallMiniTextureView != null) {
                groupCallMiniTextureView.invalidate();
            }
        }
    }

    public void setAmplitude(TLRPC$TL_groupCallParticipant participant, float v) {
        for (int i = 0; i < this.attachedRenderers.size(); i++) {
            if (MessageObject.getPeerId(this.attachedRenderers.get(i).participant.participant.peer) == MessageObject.getPeerId(participant.peer)) {
                this.attachedRenderers.get(i).setAmplitude(v);
            }
        }
    }

    public boolean isAnimating() {
        return this.fullscreenAnimator != null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (GroupCallActivity.isTabletMode) {
            ((ViewGroup.MarginLayoutParams) this.topShadowView.getLayoutParams()).rightMargin = AndroidUtilities.dp(328.0f);
        } else if (GroupCallActivity.isLandscapeMode) {
            ((ViewGroup.MarginLayoutParams) this.topShadowView.getLayoutParams()).rightMargin = AndroidUtilities.dp(90.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) this.topShadowView.getLayoutParams()).rightMargin = 0;
        }
        this.pinContainer.getLayoutParams().height = AndroidUtilities.dp(40.0f);
        this.pinTextView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 0), heightMeasureSpec);
        this.unpinTextView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 0), heightMeasureSpec);
        this.pinContainer.getLayoutParams().width = AndroidUtilities.dp(46.0f) + (!this.hasPinnedVideo ? this.pinTextView : this.unpinTextView).getMeasuredWidth();
        ((ViewGroup.MarginLayoutParams) this.speakingMembersToast.getLayoutParams()).rightMargin = GroupCallActivity.isLandscapeMode ? AndroidUtilities.dp(45.0f) : 0;
        for (int i = 0; i < 2; i++) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.undoView[i].getLayoutParams();
            if (this.isTablet) {
                marginLayoutParams.rightMargin = AndroidUtilities.dp(344.0f);
            } else {
                marginLayoutParams.rightMargin = GroupCallActivity.isLandscapeMode ? AndroidUtilities.dp(180.0f) : 0;
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public boolean autoPinEnabled() {
        return (this.hasPinnedVideo || System.currentTimeMillis() - this.lastUpdateTime <= 2000 || this.swipeToBackGesture || this.isInPinchToZoomTouchMode) ? false : true;
    }

    public void setVisibleParticipant(boolean animated) {
        boolean z;
        int i;
        int iDp = 0;
        if (!this.inFullscreenMode || this.isTablet || this.fullscreenParticipant == null || this.fullscreenAnimator != null || this.call == null) {
            if (this.showSpeakingMembersToast) {
                this.showSpeakingMembersToast = false;
                this.showSpeakingMembersToastProgress = 0.0f;
                return;
            }
            return;
        }
        int currentAccount = this.groupCallActivity.getCurrentAccount();
        long j = 500;
        if (System.currentTimeMillis() - this.lastUpdateTooltipTime < 500) {
            if (this.updateTooltipRunnbale == null) {
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$GroupCallRenderersContainer$l9EU2pOuAnOEIaFmgNRfOcSlg94
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setVisibleParticipant$8$GroupCallRenderersContainer();
                    }
                };
                this.updateTooltipRunnbale = runnable;
                AndroidUtilities.runOnUIThread(runnable, (System.currentTimeMillis() - this.lastUpdateTooltipTime) + 50);
                return;
            }
            return;
        }
        this.lastUpdateTooltipTime = System.currentTimeMillis();
        int i2 = 0;
        SpannableStringBuilder spannableStringBuilder = null;
        int i3 = 0;
        while (i2 < this.call.currentSpeakingPeers.size()) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.call.currentSpeakingPeers.get(this.call.currentSpeakingPeers.keyAt(i2));
            if (tLRPC$TL_groupCallParticipant.self || tLRPC$TL_groupCallParticipant.muted_by_you || MessageObject.getPeerId(this.fullscreenParticipant.participant.peer) == MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer)) {
                i = i2;
            } else {
                long peerId = MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer);
                i = i2;
                if (SystemClock.uptimeMillis() - tLRPC$TL_groupCallParticipant.lastSpeakTime < j) {
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                    }
                    if (i3 == 0) {
                        this.speakingToastPeerId = MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer);
                    }
                    if (i3 < 3) {
                        TLRPC$User user = peerId > 0 ? MessagesController.getInstance(currentAccount).getUser(Long.valueOf(peerId)) : null;
                        TLRPC$Chat chat = peerId <= 0 ? MessagesController.getInstance(currentAccount).getChat(Long.valueOf(peerId)) : null;
                        if (user != null || chat != null) {
                            this.speakingMembersAvatars.setObject(i3, currentAccount, tLRPC$TL_groupCallParticipant);
                            if (i3 != 0) {
                                spannableStringBuilder.append((CharSequence) ", ");
                            }
                            if (user != null) {
                                if (Build.VERSION.SDK_INT >= 21) {
                                    spannableStringBuilder.append(UserObject.getFirstName(user), new TypefaceSpan(AndroidUtilities.getFontFamily(true)), 0);
                                } else {
                                    spannableStringBuilder.append((CharSequence) UserObject.getFirstName(user));
                                }
                            } else if (Build.VERSION.SDK_INT >= 21) {
                                spannableStringBuilder.append(chat.title, new TypefaceSpan(AndroidUtilities.getFontFamily(true)), 0);
                            } else {
                                spannableStringBuilder.append((CharSequence) chat.title);
                            }
                        }
                    }
                    i3++;
                    if (i3 == 3) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            i2 = i + 1;
            j = 500;
        }
        boolean z2 = i3 != 0;
        boolean z3 = this.showSpeakingMembersToast;
        if (!z3 && z2) {
            z = false;
        } else {
            if (!z2 && z3) {
                this.showSpeakingMembersToast = z2;
                invalidate();
                return;
            }
            if (z3 && z2) {
                this.speakingMembersToastFromLeft = this.speakingMembersToast.getLeft();
                this.speakingMembersToastFromRight = this.speakingMembersToast.getRight();
                this.speakingMembersToastFromTextLeft = this.speakingMembersText.getLeft();
                this.speakingMembersToastChangeProgress = 0.0f;
            }
            z = animated;
        }
        if (!z2) {
            this.showSpeakingMembersToast = z2;
            invalidate();
            return;
        }
        String pluralString = LocaleController.getPluralString("MembersAreSpeakingToast", i3);
        int iIndexOf = pluralString.indexOf("un1");
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(pluralString);
        spannableStringBuilder2.replace(iIndexOf, iIndexOf + 3, (CharSequence) spannableStringBuilder);
        this.speakingMembersText.setText(spannableStringBuilder2);
        if (i3 != 0) {
            if (i3 == 1) {
                iDp = AndroidUtilities.dp(40.0f);
            } else if (i3 == 2) {
                iDp = AndroidUtilities.dp(64.0f);
            } else {
                iDp = AndroidUtilities.dp(88.0f);
            }
        }
        ((FrameLayout.LayoutParams) this.speakingMembersText.getLayoutParams()).leftMargin = iDp;
        ((FrameLayout.LayoutParams) this.speakingMembersText.getLayoutParams()).rightMargin = AndroidUtilities.dp(16.0f);
        this.showSpeakingMembersToast = z2;
        invalidate();
        while (i3 < 3) {
            this.speakingMembersAvatars.setObject(i3, currentAccount, null);
            i3++;
        }
        this.speakingMembersAvatars.commitTransition(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setVisibleParticipant$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setVisibleParticipant$8$GroupCallRenderersContainer() {
        this.updateTooltipRunnbale = null;
        setVisibleParticipant(true);
    }

    public UndoView getUndoView() {
        if (this.undoView[0].getVisibility() == 0) {
            UndoView[] undoViewArr = this.undoView;
            UndoView undoView = undoViewArr[0];
            undoViewArr[0] = undoViewArr[1];
            undoViewArr[1] = undoView;
            undoView.hide(true, 2);
            removeView(this.undoView[0]);
            addView(this.undoView[0]);
        }
        return this.undoView[0];
    }

    public boolean isVisible(TLRPC$TL_groupCallParticipant participant) {
        return this.attachedPeerIds.get(MessageObject.getPeerId(participant.peer)) > 0;
    }

    public void attach(GroupCallMiniTextureView view) {
        this.attachedRenderers.add(view);
        long peerId = MessageObject.getPeerId(view.participant.participant.peer);
        LongSparseIntArray longSparseIntArray = this.attachedPeerIds;
        longSparseIntArray.put(peerId, longSparseIntArray.get(peerId, 0) + 1);
    }

    public void detach(GroupCallMiniTextureView view) {
        this.attachedRenderers.remove(view);
        long peerId = MessageObject.getPeerId(view.participant.participant.peer);
        this.attachedPeerIds.put(peerId, r4.get(peerId, 0) - 1);
    }

    public void setGroupCall(ChatObject.Call call) {
        this.call = call;
    }
}
