package ir.resaneh1.iptv.UIView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Vibrator;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidMessenger.utilites.MyLog;
import androidx.customview.widget.ViewDragHelper;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.musicplayer.AudioPlayManager;
import ir.resaneh1.iptv.musicplayer.NewMusicPlayerService;
import ir.resaneh1.iptv.musicplayer.PlayableAudioObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class FloatingViewsLayout extends FrameLayout {
    private ImageView closeImageView;
    Context context;
    boolean moveOnOnLayout;
    private ImageView musicImageView;
    private View musicLayoutView;
    private RingProgressBar ringProgressBar;
    public boolean showOnPlayMusic;
    private ViewDragHelper viewDragHelper;

    public FloatingViewsLayout(Activity activity) {
        super(activity);
        this.showOnPlayMusic = true;
        this.moveOnOnLayout = true;
        this.context = activity;
        init();
        initViewDragHelper();
    }

    boolean isView1onView2(View view, View view2) {
        float x = view.getX() + (view.getWidth() / 2);
        float y = view.getY() + (view.getHeight() / 2);
        return x > view2.getX() && x < view2.getX() + ((float) view2.getWidth()) && y > view2.getY() && y < view2.getY() + ((float) view2.getHeight());
    }

    private void initViewDragHelper() {
        ViewDragHelper viewDragHelperCreate = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: ir.resaneh1.iptv.UIView.FloatingViewsLayout.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return i;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return i;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onEdgeDragStarted(int i, int i2) {
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                ObjectAnimator objectAnimatorOfPropertyValuesHolder;
                FloatingViewsLayout floatingViewsLayout = FloatingViewsLayout.this;
                if (floatingViewsLayout.isView1onView2(view, floatingViewsLayout.closeImageView) && view == FloatingViewsLayout.this.musicLayoutView) {
                    FloatingViewsLayout floatingViewsLayout2 = FloatingViewsLayout.this;
                    floatingViewsLayout2.moveOnOnLayout = false;
                    floatingViewsLayout2.musicLayoutView.setScaleY(1.0f);
                    FloatingViewsLayout.this.musicLayoutView.setScaleX(1.0f);
                    FloatingViewsLayout.this.hideMusicLayout(0);
                    FloatingViewsLayout.this.hideCloseLayout();
                    NewMusicPlayerService.staticStopService(FloatingViewsLayout.this.getContext());
                    Vibrator vibrator = (Vibrator) FloatingViewsLayout.this.getContext().getSystemService("vibrator");
                    if (vibrator != null) {
                        vibrator.vibrate(20L);
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.UIView.FloatingViewsLayout.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FloatingViewsLayout floatingViewsLayout3 = FloatingViewsLayout.this;
                            floatingViewsLayout3.moveOnOnLayout = true;
                            floatingViewsLayout3.requestLayout();
                        }
                    }, 2000L);
                    return;
                }
                FloatingViewsLayout.this.hideCloseLayout();
                if (view == FloatingViewsLayout.this.musicLayoutView) {
                    int screenHeight = DimensionHelper.getScreenHeight((Activity) FloatingViewsLayout.this.getContext());
                    int screenWidth = DimensionHelper.getScreenWidth((Activity) FloatingViewsLayout.this.getContext());
                    int y = (int) view.getY();
                    if (y < AndroidUtilities.dp(72.0f)) {
                        y = AndroidUtilities.dp(72.0f);
                    }
                    if (y > (screenHeight - AndroidUtilities.dp(80.0f)) - view.getHeight()) {
                        y = (screenHeight - AndroidUtilities.dp(80.0f)) - view.getHeight();
                    }
                    if (view.getX() > screenWidth / 2) {
                        FloatingViewsLayout.this.viewDragHelper.settleCapturedViewAt((screenWidth - view.getWidth()) - AndroidUtilities.dp(8.0f), y);
                    } else {
                        FloatingViewsLayout.this.viewDragHelper.settleCapturedViewAt(AndroidUtilities.dp(8.0f), y);
                    }
                    PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.1f, 1.0f);
                    PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.1f, 1.0f);
                    if (Build.VERSION.SDK_INT >= 21) {
                        objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Z, AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f)));
                    } else {
                        objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                    }
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(200L);
                    animatorSet.setInterpolator(new AccelerateInterpolator());
                    animatorSet.play(objectAnimatorOfPropertyValuesHolder);
                    animatorSet.start();
                    FloatingViewsLayout.this.invalidate();
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(View view) {
                return FloatingViewsLayout.this.getMeasuredWidth() - view.getMeasuredWidth();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                return FloatingViewsLayout.this.getMeasuredHeight() - view.getMeasuredHeight();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                ObjectAnimator objectAnimatorOfPropertyValuesHolder;
                if (view.getVisibility() != 0 || view.getAlpha() == 0.0f) {
                    return false;
                }
                PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f, 1.1f);
                PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f, 1.1f);
                if (Build.VERSION.SDK_INT >= 21) {
                    objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Z, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(8.0f)));
                } else {
                    objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                }
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.setInterpolator(new AccelerateInterpolator());
                animatorSet.play(objectAnimatorOfPropertyValuesHolder);
                animatorSet.start();
                if (view == FloatingViewsLayout.this.musicLayoutView) {
                    FloatingViewsLayout.this.showCloseLayout();
                }
                return true;
            }
        });
        this.viewDragHelper = viewDragHelperCreate;
        viewDragHelperCreate.setEdgeTrackingEnabled(2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MyLog.e("FloatingView", "x" + motionEvent.getX() + " y " + motionEvent.getY());
        MyLog.e("FloatingView", "music x" + this.musicLayoutView.getX() + " y " + this.musicLayoutView.getY());
        return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.viewDragHelper.processTouchEvent(motionEvent);
        return this.musicLayoutView.getVisibility() == 0 && motionEvent.getX() > this.musicLayoutView.getX() && motionEvent.getX() < this.musicLayoutView.getX() + ((float) this.musicLayoutView.getWidth()) && motionEvent.getY() > this.musicLayoutView.getY() && motionEvent.getY() < this.musicLayoutView.getY() + ((float) this.musicLayoutView.getHeight());
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.viewDragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float x = this.musicLayoutView.getX();
        if (x > AndroidUtilities.dp(16.0f) && x < DimensionHelper.getScreenWidth((Activity) getContext()) - AndroidUtilities.dp(80.0f) && this.moveOnOnLayout) {
            x = DimensionHelper.getScreenWidth((Activity) getContext()) - AndroidUtilities.dp(72.0f);
        }
        float y = this.musicLayoutView.getY();
        float fDp = AndroidUtilities.dp(64.0f) + x;
        float fDp2 = AndroidUtilities.dp(64.0f) + y;
        super.onLayout(z, i, i2, i3, i4);
        if (x <= 0.0f || this.musicLayoutView.getVisibility() != 0) {
            return;
        }
        this.musicLayoutView.layout((int) x, (int) y, (int) fDp, (int) fDp2);
    }

    protected void init() {
        View viewFindViewById = findViewById(R.id.musicLayout);
        this.musicLayoutView = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.UIView.FloatingViewsLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PlayableAudioObject currentPlayingObject = AudioPlayManager.getInstance().getCurrentPlayingObject();
                if (currentPlayingObject == null || ApplicationLoader.applicationActivity == null || currentPlayingObject.type != PlayableAudioObject.Type.aod) {
                    return;
                }
                Link link = new Link();
                link.type = Link.LinkTypeEnum.action;
                link.action = Link.EnumBannerAction.openPlayingMusic;
                new MainClickHandler().onLinkClick(ApplicationLoader.applicationActivity.getLastFragment(), link);
            }
        });
        this.musicImageView = (ImageView) findViewById(R.id.imageViewMusic);
        this.ringProgressBar = (RingProgressBar) findViewById(R.id.circleProgress);
        ImageView imageView = new ImageView(this.context);
        this.closeImageView = imageView;
        imageView.setBackground(this.context.getResources().getDrawable(R.drawable.circle_close_floating_layout));
        this.closeImageView.setImageResource(R.drawable.close_white);
        this.closeImageView.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
        this.closeImageView.setVisibility(4);
        addView(this.closeImageView, LayoutHelper.createFrame(64, 64.0f, 49, 0.0f, 72.0f, 0.0f, 0.0f));
        this.musicLayoutView.setBackgroundResource(R.drawable.circle_white);
        DimensionHelper.getScreenHeight((Activity) getContext());
        DimensionHelper.getScreenWidth((Activity) getContext());
        AndroidUtilities.dp(88.0f);
        AudioPlayManager.getInstance().addListener(new AudioPlayManager.Listener() { // from class: ir.resaneh1.iptv.UIView.FloatingViewsLayout.3
            @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
            public void updateJustProgressText(String str) {
            }

            @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
            public void updateView() {
                if (AudioPlayManager.getInstance().getCurrentPlayingObject() != null) {
                    FloatingViewsLayout floatingViewsLayout = FloatingViewsLayout.this;
                    if (floatingViewsLayout.showOnPlayMusic) {
                        floatingViewsLayout.showMusicLayout();
                    }
                    GlideHelper.loadCircle(FloatingViewsLayout.this.getContext(), FloatingViewsLayout.this.musicImageView, AudioPlayManager.getInstance().getCurrentPlayingObject().getImageUrl());
                    try {
                        FloatingViewsLayout.this.ringProgressBar.setMax(Math.max(1, AudioPlayManager.getInstance().getDuration(AudioPlayManager.getInstance().getCurrentPlayingObject())));
                        FloatingViewsLayout.this.ringProgressBar.setProgress(AudioPlayManager.getInstance().getCurrentPosition(AudioPlayManager.getInstance().getCurrentPlayingObject()));
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                FloatingViewsLayout.this.hideMusicLayout(400);
            }

            @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
            public void updateProgress() {
                FloatingViewsLayout.this.ringProgressBar.setProgress(AudioPlayManager.getInstance().getCurrentPosition(AudioPlayManager.getInstance().getCurrentPlayingObject()));
            }
        });
    }

    public void hideMusicLayout() {
        hideMusicLayout(ImageReceiver.DEFAULT_CROSSFADE_DURATION);
    }

    public void hideMusicLayout(int i) {
        this.musicLayoutView.setAlpha(0.0f);
        this.musicLayoutView.setVisibility(4);
    }

    public void showMusicLayout() {
        this.musicLayoutView.setAlpha(1.0f);
        this.musicLayoutView.setVisibility(0);
    }

    public void hideCloseLayout() {
        if (this.closeImageView.getAlpha() == 0.0f) {
            this.closeImageView.clearAnimation();
            this.closeImageView.setVisibility(8);
            return;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.closeImageView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f, 0.7f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f, 0.7f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, this.closeImageView.getAlpha(), 0.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.play(objectAnimatorOfPropertyValuesHolder);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: ir.resaneh1.iptv.UIView.FloatingViewsLayout.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FloatingViewsLayout.this.closeImageView.setVisibility(8);
            }
        });
        animatorSet.start();
    }

    public void showCloseLayout() {
        this.closeImageView.setVisibility(0);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.closeImageView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.7f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.7f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, this.closeImageView.getAlpha(), 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.play(objectAnimatorOfPropertyValuesHolder);
        animatorSet.start();
    }
}
