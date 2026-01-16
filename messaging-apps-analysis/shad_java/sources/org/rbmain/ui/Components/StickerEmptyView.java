package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
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
    Runnable showProgressRunnable;
    private int stickerType;
    public BackupImageView stickerView;
    private LoadingStickerDrawable stubDrawable;
    public final TextView subtitle;
    public final TextView title;

    public StickerEmptyView(Context context, View view, int i) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.showProgressRunnable = new Runnable() { // from class: org.rbmain.ui.Components.StickerEmptyView.1
            @Override // java.lang.Runnable
            public void run() {
                StickerEmptyView stickerEmptyView = StickerEmptyView.this;
                View view2 = stickerEmptyView.progressView;
                if (view2 == null) {
                    stickerEmptyView.progressBar.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
                    return;
                }
                if (view2.getVisibility() != 0) {
                    StickerEmptyView.this.progressView.setVisibility(0);
                    StickerEmptyView.this.progressView.setAlpha(0.0f);
                }
                StickerEmptyView.this.progressView.animate().setListener(null).cancel();
                StickerEmptyView.this.progressView.animate().alpha(1.0f).setDuration(150L).start();
            }
        };
        this.progressView = view;
        this.stickerType = i;
        LinearLayout linearLayout = new LinearLayout(context) { // from class: org.rbmain.ui.Components.StickerEmptyView.2
            @Override // android.view.View
            public void setVisibility(int i2) {
                if (getVisibility() == 8 && i2 == 0) {
                    StickerEmptyView.this.setSticker();
                    StickerEmptyView.this.stickerView.getImageReceiver().startAnimation();
                } else if (i2 == 8) {
                    StickerEmptyView.this.stickerView.getImageReceiver().clearImage();
                }
                super.setVisibility(i2);
            }
        };
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(1);
        BackupImageView backupImageView = new BackupImageView(context);
        this.stickerView = backupImageView;
        backupImageView.setVisibility(8);
        this.stickerView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.StickerEmptyView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0(view2);
            }
        });
        LoadingStickerDrawable loadingStickerDrawable = new LoadingStickerDrawable(this.stickerView, i == 1 ? "M503.1,302.3c-2-20-21.4-29.8-42.4-30.7c13.8-56.8-8.2-121-52.8-164.1C321.6,24,190,51.3,131.7,146.2\n\tc-21.2-30.5-65-34.3-91.1-7.6c-30,30.6-18.4,82.7,22.5,97.3c-4.7,2.4-6.4,7.6-5.7,12.4c-14.2,10.5-19,28.5-5.1,42.4\n\tc-5.4,15,13.2,28.8,26.9,18.8c10.5,6.9,21,15,27.8,28.8c-17.1,55.3-8.5,79.4,8.5,98.7v0c47.5,53.8,235.6,45.3,292.2,11.5\n\tc22.6-13.5,39.5-34.6,30.4-96.8C459.1,322.1,505.7,328.5,503.1,302.3z M107.4,234c0.1,2.8,0.2,5.8,0.4,8.8c-7-2.5-14-3.6-20.5-3.6\n\tC94.4,238.6,101.2,236.9,107.4,234z" : "m418 282.6c13.4-21.1 20.2-44.9 20.2-70.8 0-88.3-79.8-175.3-178.9-175.3-100.1 0-178.9 88-178.9 175.3 0 46.6 16.9 73.1 29.1 86.1-19.3 23.4-30.9 52.3-34.6 86.1-2.5 22.7 3.2 41.4 17.4 57.3 14.3 16 51.7 35 148.1 35 41.2 0 119.9-5.3 156.7-18.3 49.5-17.4 59.2-41.1 59.2-76.2 0-41.5-12.9-74.8-38.3-99.2z", AndroidUtilities.dp(130.0f), AndroidUtilities.dp(130.0f));
        this.stubDrawable = loadingStickerDrawable;
        this.stickerView.setImageDrawable(loadingStickerDrawable);
        TextView textView = new TextView(context);
        this.title = textView;
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        int i2 = Theme.key_windowBackgroundWhiteBlackText;
        textView.setTag(Integer.valueOf(i2));
        textView.setTextColor(Theme.getColor(i2));
        textView.setTextSize(1, 20.0f);
        textView.setGravity(17);
        TextView textView2 = new TextView(context);
        this.subtitle = textView2;
        int i3 = Theme.key_windowBackgroundWhiteGrayText;
        textView2.setTag(Integer.valueOf(i3));
        textView2.setTextColor(Theme.getColor(i3));
        textView2.setTextSize(1, 14.0f);
        textView2.setGravity(17);
        this.linearLayout.addView(this.stickerView, LayoutHelper.createLinear(130, 130, 1));
        this.linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 1, 0, 12, 0, 0));
        this.linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 1, 0, 8, 0, 0));
        addView(this.linearLayout, LayoutHelper.createFrame(-2, -2.0f, 17, 56.0f, 0.0f, 56.0f, 30.0f));
        if (view == null) {
            RadialProgressView radialProgressView = new RadialProgressView(context);
            this.progressBar = radialProgressView;
            radialProgressView.setAlpha(0.0f);
            this.progressBar.setScaleY(0.5f);
            this.progressBar.setScaleX(0.5f);
            addView(this.progressBar, LayoutHelper.createFrame(-2, -2, 17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.stickerView.getImageReceiver().startAnimation();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        if ((this.animateLayoutChange || this.preventMoving) && (i5 = this.lastH) > 0 && i5 != getMeasuredHeight()) {
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

    public void setColors(int i, int i2, int i3, int i4) {
        this.title.setTag(Integer.valueOf(i));
        this.title.setTextColor(Theme.getColor(i));
        this.subtitle.setTag(Integer.valueOf(i2));
        this.subtitle.setTextColor(Theme.getColor(i2));
        this.stubDrawable.setColors(i3, i4);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i && i == 0) {
            if (this.progressShowing) {
                this.linearLayout.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(150L).start();
                this.progressView.setVisibility(0);
                this.progressView.setAlpha(1.0f);
            } else {
                this.linearLayout.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
                View view = this.progressView;
                if (view != null) {
                    view.animate().setListener(null).cancel();
                    this.progressView.animate().setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.StickerEmptyView.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            StickerEmptyView.this.progressView.setVisibility(8);
                        }
                    }).alpha(0.0f).setDuration(150L).start();
                } else {
                    this.progressBar.animate().alpha(0.0f).scaleY(0.5f).scaleX(0.5f).setDuration(150L).start();
                }
                this.stickerView.getImageReceiver().startAnimation();
            }
        }
        super.setVisibility(i);
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
            this.progressView.animate().setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.StickerEmptyView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setSticker() {
        TLRPC$TL_messages_stickerSet stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByName("tg_placeholders");
        if (stickerSetByName == null) {
            stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByEmojiOrName("tg_placeholders");
        }
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = stickerSetByName;
        if (tLRPC$TL_messages_stickerSet != null && tLRPC$TL_messages_stickerSet.documents.size() >= 2) {
            this.stickerView.setImage(ImageLocation.getForDocument(tLRPC$TL_messages_stickerSet.documents.get(this.stickerType)), "130_130", "tgs", this.stubDrawable, tLRPC$TL_messages_stickerSet);
            this.stickerView.getImageReceiver().setAutoRepeat(2);
        } else {
            MediaDataController.getInstance(this.currentAccount).loadStickersByEmojiOrName("tg_placeholders", false, tLRPC$TL_messages_stickerSet == null);
            this.stickerView.setImageDrawable(this.stubDrawable);
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.diceStickersDidLoad && "tg_placeholders".equals((String) objArr[0]) && getVisibility() == 0) {
            setSticker();
        }
    }

    public void setKeyboardHeight(int i, boolean z) {
        if (this.keyboardSize != i) {
            if (getVisibility() != 0) {
                z = false;
            }
            this.keyboardSize = i;
            float fDp = (-(i >> 1)) + (i > 0 ? AndroidUtilities.dp(20.0f) : 0);
            if (z) {
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

    public void showProgress(boolean z) {
        showProgress(z, true);
    }

    public void showProgress(boolean z, boolean z2) {
        if (this.progressShowing != z) {
            this.progressShowing = z;
            if (getVisibility() != 0) {
                return;
            }
            if (z2) {
                if (z) {
                    this.linearLayout.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(150L).start();
                    this.showProgressRunnable.run();
                    return;
                }
                this.linearLayout.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
                View view = this.progressView;
                if (view != null) {
                    view.animate().setListener(null).cancel();
                    this.progressView.animate().setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.StickerEmptyView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            StickerEmptyView.this.progressView.setVisibility(8);
                        }
                    }).alpha(0.0f).setDuration(150L).start();
                } else {
                    this.progressBar.animate().alpha(0.0f).scaleY(0.5f).scaleX(0.5f).setDuration(150L).start();
                }
                this.stickerView.getImageReceiver().startAnimation();
                return;
            }
            if (z) {
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

    public void setAnimateLayoutChange(boolean z) {
        this.animateLayoutChange = z;
    }

    public void setPreventMoving(boolean z) {
        this.preventMoving = z;
        if (z) {
            return;
        }
        this.linearLayout.setTranslationY(0.0f);
        RadialProgressView radialProgressView = this.progressBar;
        if (radialProgressView != null) {
            radialProgressView.setTranslationY(0.0f);
        }
    }
}
