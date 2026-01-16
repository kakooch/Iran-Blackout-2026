package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ChatMessageCell;

/* loaded from: classes3.dex */
public class HintView extends FrameLayout {
    private AnimatorSet animatorSet;
    private ImageView arrowImageView;
    private int bottomOffset;
    private int currentType;
    private View currentView;
    private float extraTranslationY;
    private Runnable hideRunnable;
    private ImageView imageView;
    private boolean isTopArrow;
    private ChatMessageCell messageCell;
    private String overrideText;
    private final Theme.ResourcesProvider resourcesProvider;
    private long showingDuration;
    private int shownY;
    private TextView textView;
    private float translationY;

    public HintView(Context context, int type) {
        this(context, type, false, null);
    }

    public HintView(Context context, int type, boolean topArrow) {
        this(context, type, topArrow, null);
    }

    public HintView(Context context, int type, Theme.ResourcesProvider resourcesProvider) {
        this(context, type, false, resourcesProvider);
    }

    public HintView(Context context, int type, boolean topArrow, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.showingDuration = 2000L;
        this.resourcesProvider = resourcesProvider;
        this.currentType = type;
        this.isTopArrow = topArrow;
        CorrectlyMeasuringTextView correctlyMeasuringTextView = new CorrectlyMeasuringTextView(context);
        this.textView = correctlyMeasuringTextView;
        correctlyMeasuringTextView.setTextColor(getThemedColor("chat_gifSaveHintText"));
        this.textView.setTextSize(1, 14.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setMaxLines(2);
        if (type == 7 || type == 8 || type == 9) {
            this.textView.setMaxWidth(AndroidUtilities.dp(310.0f));
        } else if (type == 4) {
            this.textView.setMaxWidth(AndroidUtilities.dp(280.0f));
        } else {
            this.textView.setMaxWidth(AndroidUtilities.dp(250.0f));
        }
        if (this.currentType == 3) {
            this.textView.setGravity(19);
            this.textView.setBackground(Theme.createRoundRectDrawable(AndroidUtilities.dp(5.0f), getThemedColor("chat_gifSaveHintBackground")));
            this.textView.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
            addView(this.textView, LayoutHelper.createFrame(-2, 30.0f, 51, 0.0f, topArrow ? 6.0f : 0.0f, 0.0f, topArrow ? 0.0f : 6.0f));
        } else {
            this.textView.setGravity(51);
            TextView textView = this.textView;
            int i = this.currentType;
            textView.setBackground(Theme.createRoundRectDrawable(AndroidUtilities.dp((i == 7 || i == 8 || i == 9) ? 6.0f : 3.0f), getThemedColor("chat_gifSaveHintBackground")));
            int i2 = this.currentType;
            if (i2 == 5 || i2 == 4) {
                this.textView.setPadding(AndroidUtilities.dp(9.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(9.0f), AndroidUtilities.dp(7.0f));
            } else if (i2 == 2) {
                this.textView.setPadding(AndroidUtilities.dp(7.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f));
            } else if (i2 == 7 || i2 == 8 || i2 == 9) {
                this.textView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            } else {
                this.textView.setPadding(AndroidUtilities.dp(i2 == 0 ? 54.0f : 5.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(7.0f));
            }
            addView(this.textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, topArrow ? 6.0f : 0.0f, 0.0f, topArrow ? 0.0f : 6.0f));
        }
        if (type == 0) {
            this.textView.setText(LocaleController.getString("AutoplayVideoInfo", R.string.AutoplayVideoInfo));
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setImageResource(R.drawable.tooltip_sound);
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_gifSaveHintText"), PorterDuff.Mode.MULTIPLY));
            addView(this.imageView, LayoutHelper.createFrame(38, 34.0f, 51, 7.0f, 7.0f, 0.0f, 0.0f));
        }
        ImageView imageView2 = new ImageView(context);
        this.arrowImageView = imageView2;
        imageView2.setImageResource(topArrow ? R.drawable.tooltip_arrow_up : R.drawable.tooltip_arrow);
        this.arrowImageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_gifSaveHintBackground"), PorterDuff.Mode.MULTIPLY));
        addView(this.arrowImageView, LayoutHelper.createFrame(14, 6.0f, (topArrow ? 48 : 80) | 3, 0.0f, 0.0f, 0.0f, 0.0f));
    }

    public void setBackgroundColor(int background, int text) {
        this.textView.setTextColor(text);
        this.arrowImageView.setColorFilter(new PorterDuffColorFilter(background, PorterDuff.Mode.MULTIPLY));
        TextView textView = this.textView;
        int i = this.currentType;
        textView.setBackground(Theme.createRoundRectDrawable(AndroidUtilities.dp((i == 7 || i == 8) ? 6.0f : 3.0f), background));
    }

    public void setOverrideText(String text) {
        this.overrideText = text;
        this.textView.setText(text);
        ChatMessageCell chatMessageCell = this.messageCell;
        if (chatMessageCell != null) {
            this.messageCell = null;
            showForMessageCell(chatMessageCell, false);
        }
    }

    public void setExtraTranslationY(float value) {
        this.extraTranslationY = value;
        setTranslationY(value + this.translationY);
    }

    public float getBaseTranslationY() {
        return this.translationY;
    }

    public boolean showForMessageCell(ChatMessageCell cell, boolean animated) {
        return showForMessageCell(cell, null, 0, 0, animated);
    }

    public boolean showForMessageCell(ChatMessageCell cell, Object object, int x, int y, boolean animated) {
        int iDp;
        int forwardNameCenterX;
        int i = this.currentType;
        if ((i == 5 && y == this.shownY && this.messageCell == cell) || (i != 5 && ((i == 0 && getTag() != null) || this.messageCell == cell))) {
            return false;
        }
        Runnable runnable = this.hideRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.hideRunnable = null;
        }
        int[] iArr = new int[2];
        cell.getLocationInWindow(iArr);
        int i2 = iArr[1];
        ((View) getParent()).getLocationInWindow(iArr);
        int iDp2 = i2 - iArr[1];
        View view = (View) cell.getParent();
        int i3 = this.currentType;
        if (i3 == 0) {
            ImageReceiver photoImage = cell.getPhotoImage();
            iDp2 = (int) (iDp2 + photoImage.getImageY());
            int imageHeight = (int) photoImage.getImageHeight();
            int i4 = iDp2 + imageHeight;
            int measuredHeight = view.getMeasuredHeight();
            if (iDp2 <= getMeasuredHeight() + AndroidUtilities.dp(10.0f) || i4 > measuredHeight + (imageHeight / 4)) {
                return false;
            }
            forwardNameCenterX = cell.getNoSoundIconCenterX();
        } else if (i3 == 5) {
            Integer num = (Integer) object;
            iDp2 += y;
            this.shownY = y;
            if (num.intValue() == -1) {
                this.textView.setText(LocaleController.getString("PollSelectOption", R.string.PollSelectOption));
            } else if (cell.getMessageObject().isQuiz()) {
                if (num.intValue() == 0) {
                    this.textView.setText(LocaleController.getString("NoVotesQuiz", R.string.NoVotesQuiz));
                } else {
                    this.textView.setText(LocaleController.formatPluralString("Answer", num.intValue()));
                }
            } else if (num.intValue() == 0) {
                this.textView.setText(LocaleController.getString("NoVotes", R.string.NoVotes));
            } else {
                this.textView.setText(LocaleController.formatPluralString("Vote", num.intValue()));
            }
            measure(View.MeasureSpec.makeMeasureSpec(1000, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(1000, Integer.MIN_VALUE));
            forwardNameCenterX = x;
        } else {
            MessageObject messageObject = cell.getMessageObject();
            String str = this.overrideText;
            if (str == null) {
                this.textView.setText(LocaleController.getString("HidAccount", R.string.HidAccount));
            } else {
                this.textView.setText(str);
            }
            measure(View.MeasureSpec.makeMeasureSpec(1000, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(1000, Integer.MIN_VALUE));
            TLRPC$User currentUser = cell.getCurrentUser();
            if (currentUser != null && currentUser.id == 0) {
                iDp = (cell.getMeasuredHeight() - Math.max(0, cell.getBottom() - view.getMeasuredHeight())) - AndroidUtilities.dp(50.0f);
            } else {
                iDp2 += AndroidUtilities.dp(22.0f);
                if (!messageObject.isOutOwner() && cell.isDrawNameLayout()) {
                    iDp = AndroidUtilities.dp(20.0f);
                }
                if (this.isTopArrow && iDp2 <= getMeasuredHeight() + AndroidUtilities.dp(10.0f)) {
                    return false;
                }
                forwardNameCenterX = cell.getForwardNameCenterX();
            }
            iDp2 += iDp;
            if (this.isTopArrow) {
            }
            forwardNameCenterX = cell.getForwardNameCenterX();
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.isTopArrow) {
            float f = this.extraTranslationY;
            float fDp = AndroidUtilities.dp(44.0f);
            this.translationY = fDp;
            setTranslationY(f + fDp);
        } else {
            float f2 = this.extraTranslationY;
            float measuredHeight2 = iDp2 - getMeasuredHeight();
            this.translationY = measuredHeight2;
            setTranslationY(f2 + measuredHeight2);
        }
        int left = cell.getLeft() + forwardNameCenterX;
        int iDp3 = AndroidUtilities.dp(19.0f);
        if (this.currentType == 5) {
            int iMax = Math.max(0, (forwardNameCenterX - (getMeasuredWidth() / 2)) - AndroidUtilities.dp(19.1f));
            setTranslationX(iMax);
            iDp3 += iMax;
        } else if (left > view.getMeasuredWidth() / 2) {
            int measuredWidth2 = (measuredWidth - getMeasuredWidth()) - AndroidUtilities.dp(38.0f);
            setTranslationX(measuredWidth2);
            iDp3 += measuredWidth2;
        } else {
            setTranslationX(0.0f);
        }
        float left2 = ((cell.getLeft() + forwardNameCenterX) - iDp3) - (this.arrowImageView.getMeasuredWidth() / 2);
        this.arrowImageView.setTranslationX(left2);
        if (left > view.getMeasuredWidth() / 2) {
            if (left2 < AndroidUtilities.dp(10.0f)) {
                float fDp2 = left2 - AndroidUtilities.dp(10.0f);
                setTranslationX(getTranslationX() + fDp2);
                this.arrowImageView.setTranslationX(left2 - fDp2);
            }
        } else if (left2 > getMeasuredWidth() - AndroidUtilities.dp(24.0f)) {
            float measuredWidth3 = (left2 - getMeasuredWidth()) + AndroidUtilities.dp(24.0f);
            setTranslationX(measuredWidth3);
            this.arrowImageView.setTranslationX(left2 - measuredWidth3);
        } else if (left2 < AndroidUtilities.dp(10.0f)) {
            float fDp3 = left2 - AndroidUtilities.dp(10.0f);
            setTranslationX(getTranslationX() + fDp3);
            this.arrowImageView.setTranslationX(left2 - fDp3);
        }
        this.messageCell = cell;
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet = null;
        }
        setTag(1);
        setVisibility(0);
        if (animated) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this, (Property<HintView, Float>) View.ALPHA, 0.0f, 1.0f));
            this.animatorSet.addListener(new AnonymousClass1());
            this.animatorSet.setDuration(300L);
            this.animatorSet.start();
        } else {
            setAlpha(1.0f);
        }
        return true;
    }

    /* renamed from: ir.eitaa.ui.Components.HintView$1, reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            HintView.this.animatorSet = null;
            AndroidUtilities.runOnUIThread(HintView.this.hideRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$HintView$1$Tspsu39cf_OqIPD3r3N9Xw6PDJc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0$HintView$1();
                }
            }, HintView.this.currentType == 0 ? 10000L : 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$HintView$1() {
            HintView.this.hide();
        }
    }

    public boolean showForView(View view, boolean animated) {
        if (this.currentView == view || getTag() != null) {
            if (getTag() != null) {
                updatePosition(view);
            }
            return false;
        }
        Runnable runnable = this.hideRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.hideRunnable = null;
        }
        updatePosition(view);
        this.currentView = view;
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet = null;
        }
        setTag(1);
        setVisibility(0);
        if (animated) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this, (Property<HintView, Float>) View.ALPHA, 0.0f, 1.0f));
            this.animatorSet.addListener(new AnonymousClass2());
            this.animatorSet.setDuration(300L);
            this.animatorSet.start();
        } else {
            setAlpha(1.0f);
        }
        return true;
    }

    /* renamed from: ir.eitaa.ui.Components.HintView$2, reason: invalid class name */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            HintView.this.animatorSet = null;
            AndroidUtilities.runOnUIThread(HintView.this.hideRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$HintView$2$AjBtA3772TXKIWrTlfJid2x1-MY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0$HintView$2();
                }
            }, HintView.this.showingDuration);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$HintView$2() {
            HintView.this.hide();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0161 A[PHI: r1
      0x0161: PHI (r1v11 int) = (r1v10 int), (r1v15 int) binds: [B:63:0x015e, B:57:0x0140] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updatePosition(android.view.View r14) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.HintView.updatePosition(android.view.View):void");
    }

    public void hide() {
        if (getTag() == null) {
            return;
        }
        setTag(null);
        Runnable runnable = this.hideRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.hideRunnable = null;
        }
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.animatorSet = animatorSet2;
        animatorSet2.playTogether(ObjectAnimator.ofFloat(this, (Property<HintView, Float>) View.ALPHA, 0.0f));
        this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.HintView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                HintView.this.setVisibility(4);
                HintView.this.currentView = null;
                HintView.this.messageCell = null;
                HintView.this.animatorSet = null;
            }
        });
        this.animatorSet.setDuration(300L);
        this.animatorSet.start();
    }

    public void setText(CharSequence text) {
        this.textView.setText(text);
    }

    public ChatMessageCell getMessageCell() {
        return this.messageCell;
    }

    public void setShowingDuration(long showingDuration) {
        this.showingDuration = showingDuration;
    }

    public void setBottomOffset(int offset) {
        this.bottomOffset = offset;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
