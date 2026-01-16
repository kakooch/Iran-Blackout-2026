package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.EmojiView;
import ir.eitaa.ui.Components.SizeNotifierFrameLayoutPhoto;

/* loaded from: classes3.dex */
public class PhotoViewerCaptionEnterView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate, SizeNotifierFrameLayoutPhoto.SizeNotifierFrameLayoutPhotoDelegate {
    float animationProgress;
    private NumberTextView captionLimitView;
    private int captionMaxLength;
    private float chatActivityEnterViewAnimateFromTop;
    private Drawable checkDrawable;
    private int codePointCount;
    private PhotoViewerCaptionEnterViewDelegate delegate;
    private final ImageView doneButton;
    private Drawable doneDrawable;
    private ImageView emojiButton;
    private ReplaceableIconDrawable emojiIconDrawable;
    private int emojiPadding;
    private EmojiView emojiView;
    private boolean forceFloatingEmoji;
    private boolean innerTextChange;
    private boolean isInitLineCount;
    private int keyboardHeight;
    private int keyboardHeightLand;
    private boolean keyboardVisible;
    int lastShow;
    private int lastSizeChangeValue1;
    private boolean lastSizeChangeValue2;
    private String lengthText;
    private TextPaint lengthTextPaint;
    private int lineCount;
    private EditTextCaption messageEditText;
    ValueAnimator messageEditTextAnimator;
    private int messageEditTextPredrawHeigth;
    private int messageEditTextPredrawScrollY;
    float offset;
    Paint paint;
    private boolean popupAnimating;
    private final Theme.ResourcesProvider resourcesProvider;
    private ValueAnimator sendButtonColorAnimator;
    boolean sendButtonEnabled;
    private float sendButtonEnabledProgress;
    private boolean shouldAnimateEditTextWithBounds;
    private SizeNotifierFrameLayoutPhoto sizeNotifierLayout;
    ValueAnimator topBackgroundAnimator;
    private View windowView;

    public interface PhotoViewerCaptionEnterViewDelegate {
        void onCaptionEnter();

        void onEmojiViewCloseEnd();

        void onEmojiViewCloseStart();

        void onTextChanged(CharSequence text);

        void onWindowSizeChanged(int size);
    }

    protected void extendActionMode(ActionMode actionMode, Menu menu) {
    }

    public boolean hideActionMode() {
        return false;
    }

    public int getCaptionLimitOffset() {
        return this.captionMaxLength - this.codePointCount;
    }

    public PhotoViewerCaptionEnterView(Context context, SizeNotifierFrameLayoutPhoto parent, final View window, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.captionMaxLength = 1404;
        this.sendButtonEnabled = true;
        this.sendButtonEnabledProgress = 1.0f;
        this.animationProgress = 0.0f;
        Paint paint = new Paint();
        this.paint = paint;
        this.offset = 0.0f;
        this.resourcesProvider = resourcesProvider;
        paint.setColor(2130706432);
        setWillNotDraw(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        this.windowView = window;
        this.sizeNotifierLayout = parent;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setClipChildren(false);
        linearLayout.setOrientation(0);
        addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f, 51, 2.0f, 0.0f, 0.0f, 0.0f));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setClipChildren(false);
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(0, -2, 1.0f));
        ImageView imageView = new ImageView(context);
        this.emojiButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.emojiButton.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(1.0f), 0, 0);
        this.emojiButton.setAlpha(0.58f);
        frameLayout.addView(this.emojiButton, LayoutHelper.createFrame(48, 48, 83));
        this.emojiButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoViewerCaptionEnterView$-1NyvvrKaDbyM-o0ZBlm4zISjXE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$PhotoViewerCaptionEnterView(view);
            }
        });
        this.emojiButton.setContentDescription(LocaleController.getString("Emoji", R.string.Emoji));
        ImageView imageView2 = this.emojiButton;
        ReplaceableIconDrawable replaceableIconDrawable = new ReplaceableIconDrawable(context);
        this.emojiIconDrawable = replaceableIconDrawable;
        imageView2.setImageDrawable(replaceableIconDrawable);
        this.emojiIconDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        this.emojiIconDrawable.setIcon(R.drawable.input_smile, false);
        TextPaint textPaint = new TextPaint(1);
        this.lengthTextPaint = textPaint;
        textPaint.setTextSize(AndroidUtilities.dp(13.0f));
        this.lengthTextPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.lengthTextPaint.setColor(-2500135);
        EditTextCaption editTextCaption = new EditTextCaption(context, null) { // from class: ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.1
            @Override // ir.eitaa.ui.Components.EditTextBoldCursor
            protected int getActionModeStyle() {
                return 2;
            }

            @Override // ir.eitaa.ui.Components.EditTextCaption, ir.eitaa.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                try {
                    PhotoViewerCaptionEnterView.this.isInitLineCount = getMeasuredWidth() == 0 && getMeasuredHeight() == 0;
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                    if (PhotoViewerCaptionEnterView.this.isInitLineCount) {
                        PhotoViewerCaptionEnterView.this.lineCount = getLineCount();
                    }
                    PhotoViewerCaptionEnterView.this.isInitLineCount = false;
                } catch (Exception e) {
                    setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(51.0f));
                    FileLog.e(e);
                }
            }

            @Override // android.widget.TextView
            protected void onSelectionChanged(int selStart, int selEnd) {
                super.onSelectionChanged(selStart, selEnd);
                if (selStart != selEnd) {
                    fixHandleView(false);
                } else {
                    fixHandleView(true);
                }
            }

            @Override // ir.eitaa.ui.Components.EditTextBoldCursor
            protected void extendActionMode(ActionMode actionMode, Menu menu) {
                PhotoViewerCaptionEnterView.this.extendActionMode(actionMode, menu);
            }

            @Override // android.view.View
            public boolean requestRectangleOnScreen(android.graphics.Rect rectangle) {
                rectangle.bottom += AndroidUtilities.dp(1000.0f);
                return super.requestRectangleOnScreen(rectangle);
            }
        };
        this.messageEditText = editTextCaption;
        editTextCaption.setWindowView(this.windowView);
        this.messageEditText.setHint(LocaleController.getString("AddCaption", R.string.AddCaption));
        this.messageEditText.setImeOptions(268435456);
        this.messageEditText.setLinkTextColor(-8994063);
        EditTextCaption editTextCaption2 = this.messageEditText;
        editTextCaption2.setInputType(editTextCaption2.getInputType() | 16384);
        this.messageEditText.setMaxLines(4);
        this.messageEditText.setHorizontallyScrolling(false);
        this.messageEditText.setTextSize(1, 18.0f);
        this.messageEditText.setTypeface(AndroidUtilities.getFontFamily(false));
        this.messageEditText.setGravity(80);
        this.messageEditText.setPadding(0, AndroidUtilities.dp(11.0f), 0, AndroidUtilities.dp(12.0f));
        this.messageEditText.setBackgroundDrawable(null);
        this.messageEditText.setCursorColor(-1);
        this.messageEditText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.messageEditText.setTextColor(-1);
        this.messageEditText.setHighlightColor(1342177279);
        this.messageEditText.setHintTextColor(-1291845633);
        frameLayout.addView(this.messageEditText, LayoutHelper.createFrame(-1, -2.0f, 83, 52.0f, 0.0f, 6.0f, 0.0f));
        this.messageEditText.setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoViewerCaptionEnterView$B1LxD64KCErnEbWzXok1QMaPsy8
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$new$1$PhotoViewerCaptionEnterView(view, i, keyEvent);
            }
        });
        this.messageEditText.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoViewerCaptionEnterView$txQtwCdrP8KCjaxvL8Crxiu0b28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2$PhotoViewerCaptionEnterView(view);
            }
        });
        this.messageEditText.addTextChangedListener(new AnonymousClass2());
        this.doneDrawable = Theme.createCircleDrawable(AndroidUtilities.dp(16.0f), -10043398);
        this.checkDrawable = context.getResources().getDrawable(R.drawable.input_done).mutate();
        CombinedDrawable combinedDrawable = new CombinedDrawable(this.doneDrawable, this.checkDrawable, 0, AndroidUtilities.dp(1.0f));
        combinedDrawable.setCustomSize(AndroidUtilities.dp(32.0f), AndroidUtilities.dp(32.0f));
        ImageView imageView3 = new ImageView(context);
        this.doneButton = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        imageView3.setImageDrawable(combinedDrawable);
        linearLayout.addView(imageView3, LayoutHelper.createLinear(48, 48, 80));
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoViewerCaptionEnterView$HIERUhscfXcRulS9lofQwIsVPKM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$3$PhotoViewerCaptionEnterView(view);
            }
        });
        imageView3.setContentDescription(LocaleController.getString("Done", R.string.Done));
        NumberTextView numberTextView = new NumberTextView(context);
        this.captionLimitView = numberTextView;
        numberTextView.setVisibility(8);
        this.captionLimitView.setTextSize(15);
        this.captionLimitView.setTextColor(-1);
        this.captionLimitView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.captionLimitView.setCenterAlign(true);
        addView(this.captionLimitView, LayoutHelper.createFrame(48, 20.0f, 85, 3.0f, 0.0f, 3.0f, 48.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$PhotoViewerCaptionEnterView(View view) {
        if (this.keyboardVisible || ((AndroidUtilities.isInMultiwindow || AndroidUtilities.usingHardwareInput) && !isPopupShowing())) {
            showPopup(1, false);
        } else {
            openKeyboardInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$1$PhotoViewerCaptionEnterView(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.windowView != null && hideActionMode()) {
                return true;
            }
            if (!this.keyboardVisible && isPopupShowing()) {
                if (keyEvent.getAction() == 1) {
                    showPopup(0, true);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$PhotoViewerCaptionEnterView(View view) {
        if (isPopupShowing()) {
            showPopup((AndroidUtilities.isInMultiwindow || AndroidUtilities.usingHardwareInput) ? 0 : 2, false);
        }
    }

    /* renamed from: ir.eitaa.ui.Components.PhotoViewerCaptionEnterView$2, reason: invalid class name */
    class AnonymousClass2 implements TextWatcher {
        boolean processChange = false;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        AnonymousClass2() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            if (PhotoViewerCaptionEnterView.this.lineCount != PhotoViewerCaptionEnterView.this.messageEditText.getLineCount()) {
                if (!PhotoViewerCaptionEnterView.this.isInitLineCount && PhotoViewerCaptionEnterView.this.messageEditText.getMeasuredWidth() > 0) {
                    PhotoViewerCaptionEnterView photoViewerCaptionEnterView = PhotoViewerCaptionEnterView.this;
                    photoViewerCaptionEnterView.onLineCountChanged(photoViewerCaptionEnterView.lineCount, PhotoViewerCaptionEnterView.this.messageEditText.getLineCount());
                }
                PhotoViewerCaptionEnterView photoViewerCaptionEnterView2 = PhotoViewerCaptionEnterView.this;
                photoViewerCaptionEnterView2.lineCount = photoViewerCaptionEnterView2.messageEditText.getLineCount();
            }
            if (PhotoViewerCaptionEnterView.this.innerTextChange) {
                return;
            }
            if (PhotoViewerCaptionEnterView.this.delegate != null) {
                PhotoViewerCaptionEnterView.this.delegate.onTextChanged(charSequence);
            }
            if (count - before > 1) {
                this.processChange = true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void afterTextChanged(android.text.Editable r11) {
            /*
                Method dump skipped, instructions count: 427
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.AnonymousClass2.afterTextChanged(android.text.Editable):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$afterTextChanged$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$afterTextChanged$0$PhotoViewerCaptionEnterView$2(ValueAnimator valueAnimator) {
            PhotoViewerCaptionEnterView.this.sendButtonEnabledProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Theme.setDrawableColor(PhotoViewerCaptionEnterView.this.checkDrawable, ColorUtils.setAlphaComponent(PhotoViewerCaptionEnterView.this.getThemedColor("dialogFloatingIcon"), (int) (Color.alpha(r5) * ((PhotoViewerCaptionEnterView.this.sendButtonEnabledProgress * 0.42f) + 0.58f))));
            PhotoViewerCaptionEnterView.this.doneButton.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$PhotoViewerCaptionEnterView(View view) {
        if (this.captionMaxLength - this.codePointCount < 0) {
            AndroidUtilities.shakeView(this.captionLimitView, 2.0f, 0);
            Vibrator vibrator = (Vibrator) this.captionLimitView.getContext().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
                return;
            }
            return;
        }
        this.delegate.onCaptionEnter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLineCountChanged(int lineCountOld, int lineCountNew) {
        if (!TextUtils.isEmpty(this.messageEditText.getText())) {
            this.shouldAnimateEditTextWithBounds = true;
            this.messageEditTextPredrawHeigth = this.messageEditText.getMeasuredHeight();
            this.messageEditTextPredrawScrollY = this.messageEditText.getScrollY();
            invalidate();
        } else {
            this.messageEditText.animate().cancel();
            this.messageEditText.setOffsetY(0.0f);
            this.shouldAnimateEditTextWithBounds = false;
        }
        this.chatActivityEnterViewAnimateFromTop = getTop() + this.offset;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.drawRect(0.0f, this.offset, getMeasuredWidth(), getMeasuredHeight(), this.paint);
        canvas.clipRect(0.0f, this.offset, getMeasuredWidth(), getMeasuredHeight());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.shouldAnimateEditTextWithBounds) {
            float measuredHeight = (this.messageEditTextPredrawHeigth - this.messageEditText.getMeasuredHeight()) + (this.messageEditTextPredrawScrollY - this.messageEditText.getScrollY());
            EditTextCaption editTextCaption = this.messageEditText;
            editTextCaption.setOffsetY(editTextCaption.getOffsetY() - measuredHeight);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.messageEditText.getOffsetY(), 0.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoViewerCaptionEnterView$8Nj_sPrcv-60ro2SdQJtWnSB9bY
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$onDraw$4$PhotoViewerCaptionEnterView(valueAnimator);
                }
            });
            ValueAnimator valueAnimator = this.messageEditTextAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.messageEditTextAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.DEFAULT);
            valueAnimatorOfFloat.start();
            this.shouldAnimateEditTextWithBounds = false;
        }
        float f = this.chatActivityEnterViewAnimateFromTop;
        if (f == 0.0f || f == getTop() + this.offset) {
            return;
        }
        ValueAnimator valueAnimator2 = this.topBackgroundAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        float top = this.chatActivityEnterViewAnimateFromTop - (getTop() + this.offset);
        this.offset = top;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(top, 0.0f);
        this.topBackgroundAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoViewerCaptionEnterView$u4GgIW02nS7utjvdo-4mN3mzD5I
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                this.f$0.lambda$onDraw$5$PhotoViewerCaptionEnterView(valueAnimator3);
            }
        });
        this.topBackgroundAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.topBackgroundAnimator.setDuration(200L);
        this.topBackgroundAnimator.start();
        this.chatActivityEnterViewAnimateFromTop = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDraw$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDraw$4$PhotoViewerCaptionEnterView(ValueAnimator valueAnimator) {
        this.messageEditText.setOffsetY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDraw$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDraw$5$PhotoViewerCaptionEnterView(ValueAnimator valueAnimator) {
        this.offset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void setForceFloatingEmoji(boolean value) {
        this.forceFloatingEmoji = value;
    }

    public void updateColors() {
        Theme.setDrawableColor(this.doneDrawable, getThemedColor("dialogFloatingButton"));
        Theme.setDrawableColor(this.checkDrawable, ColorUtils.setAlphaComponent(getThemedColor("dialogFloatingIcon"), (int) (Color.alpha(r0) * ((this.sendButtonEnabledProgress * 0.42f) + 0.58f))));
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.updateColors();
        }
    }

    private void onWindowSizeChanged() {
        int height = this.sizeNotifierLayout.getHeight();
        if (!this.keyboardVisible) {
            height -= this.emojiPadding;
        }
        PhotoViewerCaptionEnterViewDelegate photoViewerCaptionEnterViewDelegate = this.delegate;
        if (photoViewerCaptionEnterViewDelegate != null) {
            photoViewerCaptionEnterViewDelegate.onWindowSizeChanged(height);
        }
    }

    public void onCreate() {
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        this.sizeNotifierLayout.setDelegate(this);
    }

    public void onDestroy() {
        hidePopup();
        if (isKeyboardVisible()) {
            closeKeyboard();
        }
        this.keyboardVisible = false;
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto = this.sizeNotifierLayout;
        if (sizeNotifierFrameLayoutPhoto != null) {
            sizeNotifierFrameLayoutPhoto.setDelegate(null);
        }
    }

    public void setDelegate(PhotoViewerCaptionEnterViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void setFieldText(CharSequence text) {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return;
        }
        editTextCaption.setText(text);
        EditTextCaption editTextCaption2 = this.messageEditText;
        editTextCaption2.setSelection(editTextCaption2.getText().length());
        PhotoViewerCaptionEnterViewDelegate photoViewerCaptionEnterViewDelegate = this.delegate;
        if (photoViewerCaptionEnterViewDelegate != null) {
            photoViewerCaptionEnterViewDelegate.onTextChanged(this.messageEditText.getText());
        }
        this.captionMaxLength = MessagesController.getInstance(UserConfig.selectedAccount).maxCaptionLength;
    }

    public int getSelectionLength() {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return 0;
        }
        try {
            return editTextCaption.getSelectionEnd() - this.messageEditText.getSelectionStart();
        } catch (Exception e) {
            FileLog.e(e);
            return 0;
        }
    }

    public int getCursorPosition() {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return 0;
        }
        return editTextCaption.getSelectionStart();
    }

    private void createEmojiView() {
        if (this.emojiView != null) {
            return;
        }
        EmojiView emojiView = new EmojiView(false, false, getContext(), false, null, null, null);
        this.emojiView = emojiView;
        emojiView.setDelegate(new EmojiView.EmojiViewDelegate() { // from class: ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.3
            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ long getDialogId() {
                return EmojiView.EmojiViewDelegate.CC.$default$getDialogId(this);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ float getProgressToSearchOpened() {
                return EmojiView.EmojiViewDelegate.CC.$default$getProgressToSearchOpened(this);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ int getThreadId() {
                return EmojiView.EmojiViewDelegate.CC.$default$getThreadId(this);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void invalidateEnterView() {
                EmojiView.EmojiViewDelegate.CC.$default$invalidateEnterView(this);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ boolean isExpanded() {
                return EmojiView.EmojiViewDelegate.CC.$default$isExpanded(this);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ boolean isInScheduleMode() {
                return EmojiView.EmojiViewDelegate.CC.$default$isInScheduleMode(this);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ boolean isSearchOpened() {
                return EmojiView.EmojiViewDelegate.CC.$default$isSearchOpened(this);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void onClearEmojiRecent() {
                EmojiView.EmojiViewDelegate.CC.$default$onClearEmojiRecent(this);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            /* renamed from: onGifSelected */
            public /* synthetic */ void lambda$onGifSelected$0$ChatActivityEnterView$47(View view, Object obj, String str, Object obj2, boolean z, int i) {
                EmojiView.EmojiViewDelegate.CC.$default$onGifSelected(this, view, obj, str, obj2, z, i);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void onSearchOpenClose(int i) {
                EmojiView.EmojiViewDelegate.CC.$default$onSearchOpenClose(this, i);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void onShowStickerSet(TLRPC$StickerSet tLRPC$StickerSet, TLRPC$InputStickerSet tLRPC$InputStickerSet) {
                EmojiView.EmojiViewDelegate.CC.$default$onShowStickerSet(this, tLRPC$StickerSet, tLRPC$InputStickerSet);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void onStickerSelected(View view, TLRPC$Document tLRPC$Document, String str, Object obj, MessageObject.SendAnimationData sendAnimationData, boolean z, int i) {
                EmojiView.EmojiViewDelegate.CC.$default$onStickerSelected(this, view, tLRPC$Document, str, obj, sendAnimationData, z, i);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void onStickerSetAdd(TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
                EmojiView.EmojiViewDelegate.CC.$default$onStickerSetAdd(this, tLRPC$StickerSetCovered);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void onStickerSetRemove(TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
                EmojiView.EmojiViewDelegate.CC.$default$onStickerSetRemove(this, tLRPC$StickerSetCovered);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void onStickersGroupClick(long j) {
                EmojiView.EmojiViewDelegate.CC.$default$onStickersGroupClick(this, j);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void onStickersSettingsClick() {
                EmojiView.EmojiViewDelegate.CC.$default$onStickersSettingsClick(this);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void onTabOpened(int i) {
                EmojiView.EmojiViewDelegate.CC.$default$onTabOpened(this, i);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public /* synthetic */ void showTrendingStickersAlert(TrendingStickersLayout trendingStickersLayout) {
                EmojiView.EmojiViewDelegate.CC.$default$showTrendingStickersAlert(this, trendingStickersLayout);
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public boolean onBackspace() {
                if (PhotoViewerCaptionEnterView.this.messageEditText.length() == 0) {
                    return false;
                }
                PhotoViewerCaptionEnterView.this.messageEditText.dispatchKeyEvent(new KeyEvent(0, 67));
                return true;
            }

            @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
            public void onEmojiSelected(String symbol) {
                int selectionEnd = PhotoViewerCaptionEnterView.this.messageEditText.getSelectionEnd();
                if (selectionEnd < 0) {
                    selectionEnd = 0;
                }
                try {
                    try {
                        PhotoViewerCaptionEnterView.this.innerTextChange = true;
                        CharSequence charSequenceReplaceEmoji = Emoji.replaceEmoji(symbol, PhotoViewerCaptionEnterView.this.messageEditText.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
                        PhotoViewerCaptionEnterView.this.messageEditText.setText(PhotoViewerCaptionEnterView.this.messageEditText.getText().insert(selectionEnd, charSequenceReplaceEmoji));
                        int length = selectionEnd + charSequenceReplaceEmoji.length();
                        PhotoViewerCaptionEnterView.this.messageEditText.setSelection(length, length);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                } finally {
                    PhotoViewerCaptionEnterView.this.innerTextChange = false;
                }
            }
        });
        this.sizeNotifierLayout.addView(this.emojiView);
    }

    public void addEmojiToRecent(String code) {
        createEmojiView();
        this.emojiView.addEmojiToRecent(code);
    }

    public void replaceWithText(int start, int len, CharSequence text, boolean parseEmoji) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.messageEditText.getText());
            spannableStringBuilder.replace(start, len + start, text);
            if (parseEmoji) {
                Emoji.replaceEmoji(spannableStringBuilder, this.messageEditText.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            }
            this.messageEditText.setText(spannableStringBuilder);
            this.messageEditText.setSelection(Math.min(start + text.length(), this.messageEditText.length()));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setFieldFocused(boolean focus) {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return;
        }
        if (focus) {
            if (editTextCaption.isFocused()) {
                return;
            }
            this.messageEditText.postDelayed(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoViewerCaptionEnterView$DqO9u3pvVZJ2LW1OaYRX3gW9DtQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFieldFocused$6$PhotoViewerCaptionEnterView();
                }
            }, 600L);
        } else {
            if (!editTextCaption.isFocused() || this.keyboardVisible) {
                return;
            }
            this.messageEditText.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setFieldFocused$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setFieldFocused$6$PhotoViewerCaptionEnterView() {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption != null) {
            try {
                editTextCaption.requestFocus();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public CharSequence getFieldCharSequence() {
        return AndroidUtilities.getTrimmedString(this.messageEditText.getText());
    }

    public int getEmojiPadding() {
        return this.emojiPadding;
    }

    public boolean isPopupView(View view) {
        return view == this.emojiView;
    }

    private void showPopup(int show, boolean animated) {
        EmojiView emojiView;
        this.lastShow = show;
        if (show == 1) {
            if (this.emojiView == null) {
                createEmojiView();
            }
            this.emojiView.setVisibility(0);
            if (this.keyboardHeight <= 0) {
                this.keyboardHeight = MessagesController.getGlobalEmojiSettings().getInt("kbd_height", AndroidUtilities.dp(200.0f));
            }
            if (this.keyboardHeightLand <= 0) {
                this.keyboardHeightLand = MessagesController.getGlobalEmojiSettings().getInt("kbd_height_land3", AndroidUtilities.dp(200.0f));
            }
            android.graphics.Point point = AndroidUtilities.displaySize;
            int i = point.x > point.y ? this.keyboardHeightLand : this.keyboardHeight;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.emojiView.getLayoutParams();
            layoutParams.width = AndroidUtilities.displaySize.x;
            layoutParams.height = i;
            this.emojiView.setLayoutParams(layoutParams);
            if (!AndroidUtilities.isInMultiwindow && !this.forceFloatingEmoji) {
                AndroidUtilities.hideKeyboard(this.messageEditText);
            }
            SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto = this.sizeNotifierLayout;
            if (sizeNotifierFrameLayoutPhoto != null) {
                this.emojiPadding = i;
                sizeNotifierFrameLayoutPhoto.requestLayout();
                this.emojiIconDrawable.setIcon(R.drawable.input_keyboard, true);
                onWindowSizeChanged();
                return;
            }
            return;
        }
        if (this.emojiButton != null) {
            this.emojiIconDrawable.setIcon(R.drawable.input_smile, true);
        }
        if (this.sizeNotifierLayout != null) {
            if (animated && SharedConfig.smoothKeyboard && show == 0 && this.emojiView != null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.emojiPadding, 0.0f);
                final float f = this.emojiPadding;
                this.popupAnimating = true;
                this.delegate.onEmojiViewCloseStart();
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoViewerCaptionEnterView$UGhnbpAzXox5tEqaQEDcws4GG_w
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$showPopup$7$PhotoViewerCaptionEnterView(f, valueAnimator);
                    }
                });
                valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        PhotoViewerCaptionEnterView.this.emojiPadding = 0;
                        PhotoViewerCaptionEnterView.this.setTranslationY(0.0f);
                        PhotoViewerCaptionEnterView.this.setAlpha(1.0f);
                        PhotoViewerCaptionEnterView.this.emojiView.setTranslationY(0.0f);
                        PhotoViewerCaptionEnterView.this.popupAnimating = false;
                        PhotoViewerCaptionEnterView.this.delegate.onEmojiViewCloseEnd();
                        PhotoViewerCaptionEnterView.this.emojiView.setVisibility(8);
                        PhotoViewerCaptionEnterView.this.emojiView.setAlpha(1.0f);
                    }
                });
                valueAnimatorOfFloat.setDuration(210L);
                valueAnimatorOfFloat.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                valueAnimatorOfFloat.start();
            } else if (show == 0) {
                EmojiView emojiView2 = this.emojiView;
                if (emojiView2 != null) {
                    emojiView2.setVisibility(8);
                }
                this.emojiPadding = 0;
            } else if (!SharedConfig.smoothKeyboard && (emojiView = this.emojiView) != null) {
                emojiView.setVisibility(8);
            }
            this.sizeNotifierLayout.requestLayout();
            onWindowSizeChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPopup$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPopup$7$PhotoViewerCaptionEnterView(float f, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.emojiPadding = (int) fFloatValue;
        float f2 = f - fFloatValue;
        this.emojiView.setTranslationY(f2);
        setTranslationY(f2);
        float f3 = fFloatValue / f;
        setAlpha(f3);
        this.emojiView.setAlpha(f3);
    }

    public void hidePopup() {
        if (isPopupShowing()) {
            showPopup(0, true);
        }
    }

    private void openKeyboardInternal() {
        showPopup((AndroidUtilities.isInMultiwindow || AndroidUtilities.usingHardwareInput) ? 0 : 2, false);
        openKeyboard();
    }

    public void openKeyboard() {
        int selectionStart;
        try {
            selectionStart = this.messageEditText.getSelectionStart();
        } catch (Exception e) {
            int length = this.messageEditText.length();
            FileLog.e(e);
            selectionStart = length;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0);
        this.messageEditText.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 1, 0.0f, 0.0f, 0);
        this.messageEditText.onTouchEvent(motionEventObtain2);
        motionEventObtain2.recycle();
        AndroidUtilities.showKeyboard(this.messageEditText);
        try {
            this.messageEditText.setSelection(selectionStart);
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    public boolean isPopupShowing() {
        EmojiView emojiView = this.emojiView;
        return emojiView != null && emojiView.getVisibility() == 0;
    }

    public boolean isPopupAnimatig() {
        return this.popupAnimating;
    }

    public void closeKeyboard() {
        AndroidUtilities.hideKeyboard(this.messageEditText);
        this.messageEditText.clearFocus();
    }

    public boolean isKeyboardVisible() {
        return ((AndroidUtilities.usingHardwareInput || AndroidUtilities.isInMultiwindow) && getTag() != null) || this.keyboardVisible;
    }

    @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayoutPhoto.SizeNotifierFrameLayoutPhotoDelegate
    public void onSizeChanged(int height, boolean isWidthGreater) {
        boolean z;
        int i;
        if (height > AndroidUtilities.dp(50.0f) && this.keyboardVisible && !AndroidUtilities.isInMultiwindow && !this.forceFloatingEmoji) {
            if (isWidthGreater) {
                this.keyboardHeightLand = height;
                MessagesController.getGlobalEmojiSettings().edit().putInt("kbd_height_land3", this.keyboardHeightLand).commit();
            } else {
                this.keyboardHeight = height;
                MessagesController.getGlobalEmojiSettings().edit().putInt("kbd_height", this.keyboardHeight).commit();
            }
        }
        if (isPopupShowing()) {
            if (isWidthGreater) {
                i = this.keyboardHeightLand;
            } else {
                i = this.keyboardHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.emojiView.getLayoutParams();
            int i2 = layoutParams.width;
            int i3 = AndroidUtilities.displaySize.x;
            if (i2 != i3 || layoutParams.height != i) {
                layoutParams.width = i3;
                layoutParams.height = i;
                this.emojiView.setLayoutParams(layoutParams);
                SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto = this.sizeNotifierLayout;
                if (sizeNotifierFrameLayoutPhoto != null) {
                    this.emojiPadding = layoutParams.height;
                    sizeNotifierFrameLayoutPhoto.requestLayout();
                    onWindowSizeChanged();
                }
            }
        }
        if (this.lastSizeChangeValue1 == height && this.lastSizeChangeValue2 == isWidthGreater) {
            onWindowSizeChanged();
            return;
        }
        this.lastSizeChangeValue1 = height;
        this.lastSizeChangeValue2 = isWidthGreater;
        boolean z2 = this.keyboardVisible;
        boolean z3 = height > 0;
        this.keyboardVisible = z3;
        if (z3 && isPopupShowing()) {
            showPopup(0, false);
        }
        if (this.emojiPadding != 0 && !(z = this.keyboardVisible) && z != z2 && !isPopupShowing()) {
            this.emojiPadding = 0;
            this.sizeNotifierLayout.requestLayout();
        }
        onWindowSizeChanged();
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        EmojiView emojiView;
        if (id != NotificationCenter.emojiLoaded || (emojiView = this.emojiView) == null) {
            return;
        }
        emojiView.invalidateViews();
    }

    public void setAllowTextEntitiesIntersection(boolean value) {
        this.messageEditText.setAllowTextEntitiesIntersection(value);
    }

    public EditTextCaption getMessageEditText() {
        return this.messageEditText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
