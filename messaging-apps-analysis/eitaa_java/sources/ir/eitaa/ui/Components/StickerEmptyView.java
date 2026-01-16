package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class StickerEmptyView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private boolean animateLayoutChange;
    int currentAccount;
    int keyboardSize;
    private int lastH;
    private LinearLayout linearLayout;
    boolean preventMoving;
    private RadialProgressView progressBar;
    private boolean progressShowing;
    public final View progressView;
    private final Theme.ResourcesProvider resourcesProvider;
    Runnable showProgressRunnable;
    private int stickerType;
    public BackupImageView stickerView;
    public final TextView subtitle;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: private */
    public void setSticker() {
    }

    public StickerEmptyView(Context context, View progressView, int type) {
        this(context, progressView, type, null);
    }

    public StickerEmptyView(Context context, View progressView, int type, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.showProgressRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.StickerEmptyView.1
            @Override // java.lang.Runnable
            public void run() {
                StickerEmptyView stickerEmptyView = StickerEmptyView.this;
                View view = stickerEmptyView.progressView;
                if (view == null) {
                    stickerEmptyView.progressBar.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
                    return;
                }
                if (view.getVisibility() != 0) {
                    StickerEmptyView.this.progressView.setVisibility(0);
                    StickerEmptyView.this.progressView.setAlpha(0.0f);
                }
                StickerEmptyView.this.progressView.animate().setListener(null).cancel();
                StickerEmptyView.this.progressView.animate().alpha(1.0f).setDuration(150L).start();
            }
        };
        this.resourcesProvider = resourcesProvider;
        this.progressView = progressView;
        this.stickerType = type;
        LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.eitaa.ui.Components.StickerEmptyView.2
            @Override // android.view.View
            public void setVisibility(int visibility) {
                if (getVisibility() == 8 && visibility == 0) {
                    StickerEmptyView.this.setSticker();
                    StickerEmptyView.this.stickerView.getImageReceiver().startAnimation();
                } else if (visibility == 8) {
                    StickerEmptyView.this.stickerView.getImageReceiver().clearImage();
                }
                super.setVisibility(visibility);
            }
        };
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(1);
        BackupImageView backupImageView = new BackupImageView(context);
        this.stickerView = backupImageView;
        backupImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickerEmptyView$v531cxSmv8m3poyLbhJhHcL0lck
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$StickerEmptyView(view);
            }
        });
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_noresult);
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.SRC_ATOP));
        this.stickerView.setImageDrawable(drawable);
        TextView textView = new TextView(context);
        this.title = textView;
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setTag("windowBackgroundWhiteBlackText");
        textView.setTextColor(getThemedColor("windowBackgroundWhiteBlackText"));
        textView.setTextSize(1, 20.0f);
        textView.setGravity(17);
        TextView textView2 = new TextView(context);
        this.subtitle = textView2;
        textView2.setTag("windowBackgroundWhiteGrayText");
        textView2.setTextColor(getThemedColor("windowBackgroundWhiteGrayText"));
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(false));
        textView2.setGravity(17);
        this.linearLayout.addView(this.stickerView, LayoutHelper.createLinear(130, 130, 1));
        this.linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 1, 0, 12, 0, 0));
        this.linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 1, 0, 8, 0, 0));
        addView(this.linearLayout, LayoutHelper.createFrame(-2, -2.0f, 17, 56.0f, 0.0f, 56.0f, 30.0f));
        if (progressView == null) {
            RadialProgressView radialProgressView = new RadialProgressView(context, resourcesProvider);
            this.progressBar = radialProgressView;
            radialProgressView.setAlpha(0.0f);
            this.progressBar.setScaleY(0.5f);
            this.progressBar.setScaleX(0.5f);
            addView(this.progressBar, LayoutHelper.createFrame(-2, -2, 17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$StickerEmptyView(View view) {
        this.stickerView.getImageReceiver().startAnimation();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i;
        super.onLayout(changed, left, top, right, bottom);
        if ((this.animateLayoutChange || this.preventMoving) && (i = this.lastH) > 0 && i != getMeasuredHeight()) {
            float measuredHeight = (this.lastH - getMeasuredHeight()) / 2.0f;
            LinearLayout linearLayout = this.linearLayout;
            linearLayout.setTranslationY(linearLayout.getTranslationY() + measuredHeight);
            if (!this.preventMoving) {
                this.linearLayout.animate().translationY(0.0f).setInterpolator(CubicBezierInterpolator.DEFAULT).setDuration(250L);
            }
            RadialProgressView radialProgressView = this.progressBar;
            if (radialProgressView != null) {
                radialProgressView.setTranslationY(radialProgressView.getTranslationY() + measuredHeight);
                if (!this.preventMoving) {
                    this.progressBar.animate().translationY(0.0f).setInterpolator(CubicBezierInterpolator.DEFAULT).setDuration(250L);
                }
            }
        }
        this.lastH = getMeasuredHeight();
    }

    public void setColors(String titleKey, String subtitleKey, String key1, String key2) {
        this.title.setTag(titleKey);
        this.title.setTextColor(getThemedColor(titleKey));
        this.subtitle.setTag(subtitleKey);
        this.subtitle.setTextColor(getThemedColor(subtitleKey));
    }

    public void updateNoResultColor() {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_noresult);
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.SRC_ATOP));
        this.stickerView.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (getVisibility() != visibility && visibility == 0) {
            if (this.progressShowing) {
                this.linearLayout.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(150L).start();
                this.progressView.setVisibility(0);
                this.progressView.setAlpha(1.0f);
            } else {
                this.linearLayout.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
                View view = this.progressView;
                if (view != null) {
                    view.animate().setListener(null).cancel();
                    this.progressView.animate().setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.StickerEmptyView.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            StickerEmptyView.this.progressView.setVisibility(8);
                        }
                    }).alpha(0.0f).setDuration(150L).start();
                } else {
                    this.progressBar.animate().alpha(0.0f).scaleY(0.5f).scaleX(0.5f).setDuration(150L).start();
                }
                this.stickerView.getImageReceiver().startAnimation();
            }
        }
        super.setVisibility(visibility);
        if (getVisibility() == 0) {
            setSticker();
            return;
        }
        this.lastH = 0;
        this.linearLayout.setAlpha(0.0f);
        this.linearLayout.setScaleX(0.8f);
        this.linearLayout.setScaleY(0.8f);
        View view2 = this.progressView;
        if (view2 != null) {
            view2.animate().setListener(null).cancel();
            this.progressView.animate().setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.StickerEmptyView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    StickerEmptyView.this.progressView.setVisibility(8);
                }
            }).alpha(0.0f).setDuration(150L).start();
        } else {
            this.progressBar.setAlpha(0.0f);
            this.progressBar.setScaleX(0.5f);
            this.progressBar.setScaleY(0.5f);
        }
        this.stickerView.getImageReceiver().stopAnimation();
        this.stickerView.getImageReceiver().clearImage();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            setSticker();
        }
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.diceStickersDidLoad);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.diceStickersDidLoad);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.diceStickersDidLoad && AndroidUtilities.STICKERS_PLACEHOLDER_PACK_NAME.equals((String) args[0]) && getVisibility() == 0) {
            setSticker();
        }
    }

    public void setKeyboardHeight(int keyboardSize, boolean animated) {
        if (this.keyboardSize != keyboardSize) {
            if (getVisibility() != 0) {
                animated = false;
            }
            this.keyboardSize = keyboardSize;
            float fDp = (-(keyboardSize >> 1)) + (keyboardSize > 0 ? AndroidUtilities.dp(20.0f) : 0);
            if (animated) {
                ViewPropertyAnimator viewPropertyAnimatorTranslationY = this.linearLayout.animate().translationY(fDp);
                CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
                viewPropertyAnimatorTranslationY.setInterpolator(cubicBezierInterpolator).setDuration(250L);
                RadialProgressView radialProgressView = this.progressBar;
                if (radialProgressView != null) {
                    radialProgressView.animate().translationY(fDp).setInterpolator(cubicBezierInterpolator).setDuration(250L);
                    return;
                }
                return;
            }
            this.linearLayout.setTranslationY(fDp);
            RadialProgressView radialProgressView2 = this.progressBar;
            if (radialProgressView2 != null) {
                radialProgressView2.setTranslationY(fDp);
            }
        }
    }

    public void showProgress(boolean show) {
        showProgress(show, true);
    }

    public void showProgress(boolean show, boolean animated) {
        if (this.progressShowing != show) {
            this.progressShowing = show;
            if (getVisibility() != 0) {
                return;
            }
            if (animated) {
                if (show) {
                    this.linearLayout.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(150L).start();
                    this.showProgressRunnable.run();
                    return;
                }
                this.linearLayout.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
                View view = this.progressView;
                if (view != null) {
                    view.animate().setListener(null).cancel();
                    this.progressView.animate().setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.StickerEmptyView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            StickerEmptyView.this.progressView.setVisibility(8);
                        }
                    }).alpha(0.0f).setDuration(150L).start();
                } else {
                    this.progressBar.animate().alpha(0.0f).scaleY(0.5f).scaleX(0.5f).setDuration(150L).start();
                }
                this.stickerView.getImageReceiver().startAnimation();
                return;
            }
            if (show) {
                this.linearLayout.animate().cancel();
                this.linearLayout.setAlpha(0.0f);
                this.linearLayout.setScaleX(0.8f);
                this.linearLayout.setScaleY(0.8f);
                View view2 = this.progressView;
                if (view2 != null) {
                    view2.animate().setListener(null).cancel();
                    this.progressView.setAlpha(1.0f);
                    this.progressView.setVisibility(0);
                    return;
                } else {
                    this.progressBar.setAlpha(1.0f);
                    this.progressBar.setScaleX(1.0f);
                    this.progressBar.setScaleY(1.0f);
                    return;
                }
            }
            this.linearLayout.animate().cancel();
            this.linearLayout.setAlpha(1.0f);
            this.linearLayout.setScaleX(1.0f);
            this.linearLayout.setScaleY(1.0f);
            View view3 = this.progressView;
            if (view3 != null) {
                view3.animate().setListener(null).cancel();
                this.progressView.setVisibility(8);
            } else {
                this.progressBar.setAlpha(0.0f);
                this.progressBar.setScaleX(0.5f);
                this.progressBar.setScaleY(0.5f);
            }
        }
    }

    public void setAnimateLayoutChange(boolean animate) {
        this.animateLayoutChange = animate;
    }

    public void setPreventMoving(boolean preventMoving) {
        this.preventMoving = preventMoving;
        if (preventMoving) {
            return;
        }
        this.linearLayout.setTranslationY(0.0f);
        RadialProgressView radialProgressView = this.progressBar;
        if (radialProgressView != null) {
            radialProgressView.setTranslationY(0.0f);
        }
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
