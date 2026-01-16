package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.EmojiView;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;

/* loaded from: classes3.dex */
public class EditTextEmoji extends FrameLayout implements NotificationCenter.NotificationCenterDelegate, SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate {
    AdjustPanLayoutHelper adjustPanLayoutHelper;
    private int currentStyle;
    private EditTextEmojiDelegate delegate;
    private boolean destroyed;
    private EditTextCaption editText;
    private ImageView emojiButton;
    private ReplaceableIconDrawable emojiIconDrawable;
    private int emojiPadding;
    private EmojiView emojiView;
    private boolean emojiViewVisible;
    private int innerTextChange;
    private boolean isAnimatePopupClosing;
    private boolean isPaused;
    private int keyboardHeight;
    private int keyboardHeightLand;
    private boolean keyboardVisible;
    private int lastSizeChangeValue1;
    private boolean lastSizeChangeValue2;
    private Runnable openKeyboardRunnable;
    private BaseFragment parentFragment;
    private final Theme.ResourcesProvider resourcesProvider;
    private boolean showKeyboardOnResume;
    private SizeNotifierFrameLayout sizeNotifierLayout;
    private boolean waitingForKeyboardOpen;

    public interface EditTextEmojiDelegate {
        void onWindowSizeChanged(int size);
    }

    protected void bottomPanelTranslationY(float translation) {
    }

    protected void onLineCountChanged(int oldLineCount, int newLineCount) {
    }

    public boolean isPopupVisible() {
        EmojiView emojiView = this.emojiView;
        return emojiView != null && emojiView.getVisibility() == 0;
    }

    public boolean isWaitingForKeyboardOpen() {
        return this.waitingForKeyboardOpen;
    }

    public boolean isAnimatePopupClosing() {
        return this.isAnimatePopupClosing;
    }

    public void setAdjustPanLayoutHelper(AdjustPanLayoutHelper adjustPanLayoutHelper) {
        this.adjustPanLayoutHelper = adjustPanLayoutHelper;
    }

    public EditTextEmoji(Context context, SizeNotifierFrameLayout parent, BaseFragment fragment, int style) {
        this(context, parent, fragment, style, null);
    }

    public EditTextEmoji(Context context, SizeNotifierFrameLayout parent, BaseFragment fragment, int style, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.isPaused = true;
        this.openKeyboardRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.EditTextEmoji.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditTextEmoji.this.destroyed || EditTextEmoji.this.editText == null || !EditTextEmoji.this.waitingForKeyboardOpen || EditTextEmoji.this.keyboardVisible || AndroidUtilities.usingHardwareInput || AndroidUtilities.isInMultiwindow || !AndroidUtilities.isTablet()) {
                    return;
                }
                EditTextEmoji.this.editText.requestFocus();
                AndroidUtilities.showKeyboard(EditTextEmoji.this.editText);
                AndroidUtilities.cancelRunOnUIThread(EditTextEmoji.this.openKeyboardRunnable);
                AndroidUtilities.runOnUIThread(EditTextEmoji.this.openKeyboardRunnable, 100L);
            }
        };
        this.resourcesProvider = resourcesProvider;
        this.currentStyle = style;
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        this.parentFragment = fragment;
        this.sizeNotifierLayout = parent;
        parent.setDelegate(this);
        EditTextCaption editTextCaption = new EditTextCaption(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.EditTextEmoji.2
            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (EditTextEmoji.this.isPopupShowing() && event.getAction() == 0) {
                    EditTextEmoji.this.showPopup(AndroidUtilities.usingHardwareInput ? 0 : 2);
                    EditTextEmoji.this.openKeyboardInternal();
                }
                if (event.getAction() == 0) {
                    requestFocus();
                    if (!AndroidUtilities.showKeyboard(this)) {
                        clearFocus();
                        requestFocus();
                    }
                }
                try {
                    return super.onTouchEvent(event);
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // ir.eitaa.ui.Components.EditTextCaption
            protected void onLineCountChanged(int oldLineCount, int newLineCount) {
                EditTextEmoji.this.onLineCountChanged(oldLineCount, newLineCount);
            }
        };
        this.editText = editTextCaption;
        editTextCaption.setTextSize(1, 18.0f);
        this.editText.setTypeface(AndroidUtilities.getFontFamily(false));
        this.editText.setImeOptions(268435456);
        EditTextCaption editTextCaption2 = this.editText;
        editTextCaption2.setInputType(editTextCaption2.getInputType() | 16384);
        this.editText.setMaxLines(4);
        EditTextCaption editTextCaption3 = this.editText;
        editTextCaption3.setFocusable(editTextCaption3.isEnabled());
        this.editText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.editText.setCursorWidth(1.5f);
        this.editText.setCursorColor(getThemedColor("windowBackgroundWhiteBlackText"));
        if (style == 0) {
            this.editText.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            this.editText.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.editText.setHintTextColor(getThemedColor("windowBackgroundWhiteHintText"));
            this.editText.setTextColor(getThemedColor("windowBackgroundWhiteBlackText"));
            this.editText.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(40.0f) : 0, 0, LocaleController.isRTL ? 0 : AndroidUtilities.dp(40.0f), AndroidUtilities.dp(8.0f));
            EditTextCaption editTextCaption4 = this.editText;
            boolean z = LocaleController.isRTL;
            addView(editTextCaption4, LayoutHelper.createFrame(-1, -2.0f, 19, z ? 11.0f : 0.0f, 1.0f, z ? 0.0f : 11.0f, 0.0f));
        } else {
            this.editText.setGravity(19);
            this.editText.setHintTextColor(getThemedColor("dialogTextHint"));
            this.editText.setTextColor(getThemedColor("dialogTextBlack"));
            this.editText.setBackgroundDrawable(null);
            this.editText.setPadding(0, AndroidUtilities.dp(11.0f), 0, AndroidUtilities.dp(12.0f));
            addView(this.editText, LayoutHelper.createFrame(-1, -1.0f, 19, 48.0f, 0.0f, 0.0f, 0.0f));
        }
        ImageView imageView = new ImageView(context);
        this.emojiButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageView imageView2 = this.emojiButton;
        ReplaceableIconDrawable replaceableIconDrawable = new ReplaceableIconDrawable(context);
        this.emojiIconDrawable = replaceableIconDrawable;
        imageView2.setImageDrawable(replaceableIconDrawable);
        this.emojiIconDrawable.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
        if (style == 0) {
            this.emojiIconDrawable.setIcon(R.drawable.smiles_tab_smiles, false);
            addView(this.emojiButton, LayoutHelper.createFrame(48, 48.0f, (LocaleController.isRTL ? 3 : 5) | 16, 0.0f, 0.0f, 0.0f, 7.0f));
        } else {
            this.emojiIconDrawable.setIcon(R.drawable.input_smile, false);
            addView(this.emojiButton, LayoutHelper.createFrame(48, 48.0f, 83, 0.0f, 0.0f, 0.0f, 0.0f));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.emojiButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("listSelectorSDK21")));
        }
        this.emojiButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EditTextEmoji$lHZ-O2FKddDYw1ULjuyW-RdP370
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$EditTextEmoji(view);
            }
        });
        this.emojiButton.setContentDescription(LocaleController.getString("Emoji", R.string.Emoji));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$EditTextEmoji(View view) {
        if (this.emojiButton.isEnabled()) {
            AdjustPanLayoutHelper adjustPanLayoutHelper = this.adjustPanLayoutHelper;
            if (adjustPanLayoutHelper == null || !adjustPanLayoutHelper.animationInProgress()) {
                if (!isPopupShowing()) {
                    showPopup(1);
                    this.emojiView.onOpen(this.editText.length() > 0);
                    this.editText.requestFocus();
                    return;
                }
                openKeyboardInternal();
            }
        }
    }

    public void setSizeNotifierLayout(SizeNotifierFrameLayout layout) {
        this.sizeNotifierLayout = layout;
        layout.setDelegate(this);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.emojiLoaded) {
            EmojiView emojiView = this.emojiView;
            if (emojiView != null) {
                emojiView.invalidateViews();
            }
            EditTextCaption editTextCaption = this.editText;
            if (editTextCaption != null) {
                int currentTextColor = editTextCaption.getCurrentTextColor();
                this.editText.setTextColor(-1);
                this.editText.setTextColor(currentTextColor);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        this.editText.setEnabled(enabled);
        this.emojiButton.setVisibility(enabled ? 0 : 8);
        if (enabled) {
            this.editText.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(40.0f) : 0, 0, LocaleController.isRTL ? 0 : AndroidUtilities.dp(40.0f), AndroidUtilities.dp(8.0f));
        } else {
            this.editText.setPadding(0, 0, 0, AndroidUtilities.dp(8.0f));
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean focusable) {
        this.editText.setFocusable(focusable);
    }

    public void hideEmojiView() {
        EmojiView emojiView;
        if (!this.emojiViewVisible && (emojiView = this.emojiView) != null && emojiView.getVisibility() != 8) {
            this.emojiView.setVisibility(8);
        }
        this.emojiPadding = 0;
    }

    public void setDelegate(EditTextEmojiDelegate editTextEmojiDelegate) {
        this.delegate = editTextEmojiDelegate;
    }

    public void onPause() {
        this.isPaused = true;
        closeKeyboard();
    }

    public void onResume() {
        this.isPaused = false;
        if (this.showKeyboardOnResume) {
            this.showKeyboardOnResume = false;
            this.editText.requestFocus();
            AndroidUtilities.showKeyboard(this.editText);
            if (AndroidUtilities.usingHardwareInput || this.keyboardVisible || AndroidUtilities.isInMultiwindow || AndroidUtilities.isTablet()) {
                return;
            }
            this.waitingForKeyboardOpen = true;
            AndroidUtilities.cancelRunOnUIThread(this.openKeyboardRunnable);
            AndroidUtilities.runOnUIThread(this.openKeyboardRunnable, 100L);
        }
    }

    public void onDestroy() {
        this.destroyed = true;
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.onDestroy();
        }
        SizeNotifierFrameLayout sizeNotifierFrameLayout = this.sizeNotifierLayout;
        if (sizeNotifierFrameLayout != null) {
            sizeNotifierFrameLayout.setDelegate(null);
        }
    }

    public void updateColors() {
        if (this.currentStyle == 0) {
            this.editText.setHintTextColor(getThemedColor("windowBackgroundWhiteHintText"));
            this.editText.setCursorColor(getThemedColor("windowBackgroundWhiteBlackText"));
            this.editText.setTextColor(getThemedColor("windowBackgroundWhiteBlackText"));
        } else {
            this.editText.setHintTextColor(getThemedColor("dialogTextHint"));
            this.editText.setTextColor(getThemedColor("dialogTextBlack"));
        }
        this.emojiIconDrawable.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.updateColors();
        }
    }

    public void setMaxLines(int value) {
        this.editText.setMaxLines(value);
    }

    public int length() {
        return this.editText.length();
    }

    public void setFilters(InputFilter[] filters) {
        this.editText.setFilters(filters);
    }

    public Editable getText() {
        return this.editText.getText();
    }

    public void setHint(CharSequence hint) {
        this.editText.setHint(hint);
    }

    public void setText(CharSequence text) {
        this.editText.setText(text);
    }

    public void setSelection(int selection) {
        this.editText.setSelection(selection);
    }

    public void hidePopup(boolean byBackButton) {
        EmojiView emojiView;
        if (isPopupShowing()) {
            showPopup(0);
        }
        if (byBackButton) {
            if (SharedConfig.smoothKeyboard && (emojiView = this.emojiView) != null && emojiView.getVisibility() == 0 && !this.waitingForKeyboardOpen) {
                final int measuredHeight = this.emojiView.getMeasuredHeight();
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, measuredHeight);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EditTextEmoji$fC666Bfny-FaSRilnpYC8ugaE68
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$hidePopup$1$EditTextEmoji(measuredHeight, valueAnimator);
                    }
                });
                this.isAnimatePopupClosing = true;
                valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EditTextEmoji.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        EditTextEmoji.this.isAnimatePopupClosing = false;
                        EditTextEmoji.this.emojiView.setTranslationY(0.0f);
                        EditTextEmoji.this.bottomPanelTranslationY(0.0f);
                        EditTextEmoji.this.hideEmojiView();
                    }
                });
                valueAnimatorOfFloat.setDuration(250L);
                valueAnimatorOfFloat.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                valueAnimatorOfFloat.start();
                return;
            }
            hideEmojiView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hidePopup$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hidePopup$1$EditTextEmoji(int i, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.emojiView.setTranslationY(fFloatValue);
        bottomPanelTranslationY(fFloatValue - i);
    }

    public void openKeyboard() {
        AndroidUtilities.showKeyboard(this.editText);
    }

    public void closeKeyboard() {
        AndroidUtilities.hideKeyboard(this.editText);
    }

    public boolean isPopupShowing() {
        return this.emojiViewVisible;
    }

    public boolean isKeyboardVisible() {
        return this.keyboardVisible;
    }

    protected void openKeyboardInternal() {
        showPopup((AndroidUtilities.usingHardwareInput || this.isPaused) ? 0 : 2);
        this.editText.requestFocus();
        AndroidUtilities.showKeyboard(this.editText);
        if (this.isPaused) {
            this.showKeyboardOnResume = true;
            return;
        }
        if (AndroidUtilities.usingHardwareInput || this.keyboardVisible || AndroidUtilities.isInMultiwindow || AndroidUtilities.isTablet()) {
            return;
        }
        this.waitingForKeyboardOpen = true;
        AndroidUtilities.cancelRunOnUIThread(this.openKeyboardRunnable);
        AndroidUtilities.runOnUIThread(this.openKeyboardRunnable, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopup(int show) {
        if (show == 1) {
            EmojiView emojiView = this.emojiView;
            boolean z = emojiView != null && emojiView.getVisibility() == 0;
            if (this.emojiView == null) {
                createEmojiView();
            }
            this.emojiView.setVisibility(0);
            this.emojiViewVisible = true;
            EmojiView emojiView2 = this.emojiView;
            if (this.keyboardHeight <= 0) {
                if (AndroidUtilities.isTablet()) {
                    this.keyboardHeight = AndroidUtilities.dp(150.0f);
                } else {
                    this.keyboardHeight = MessagesController.getGlobalEmojiSettings().getInt("kbd_height", AndroidUtilities.dp(200.0f));
                }
            }
            if (this.keyboardHeightLand <= 0) {
                if (AndroidUtilities.isTablet()) {
                    this.keyboardHeightLand = AndroidUtilities.dp(150.0f);
                } else {
                    this.keyboardHeightLand = MessagesController.getGlobalEmojiSettings().getInt("kbd_height_land3", AndroidUtilities.dp(200.0f));
                }
            }
            android.graphics.Point point = AndroidUtilities.displaySize;
            int i = point.x > point.y ? this.keyboardHeightLand : this.keyboardHeight;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) emojiView2.getLayoutParams();
            layoutParams.height = i;
            emojiView2.setLayoutParams(layoutParams);
            if (!AndroidUtilities.isInMultiwindow && !AndroidUtilities.isTablet()) {
                AndroidUtilities.hideKeyboard(this.editText);
            }
            SizeNotifierFrameLayout sizeNotifierFrameLayout = this.sizeNotifierLayout;
            if (sizeNotifierFrameLayout != null) {
                this.emojiPadding = i;
                sizeNotifierFrameLayout.requestLayout();
                this.emojiIconDrawable.setIcon(R.drawable.input_keyboard, true);
                onWindowSizeChanged();
            }
            if (this.keyboardVisible || z || !SharedConfig.smoothKeyboard) {
                return;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.emojiPadding, 0.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EditTextEmoji$DtQBmwOaKHzvlC73OfbG8if6RUM
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$showPopup$2$EditTextEmoji(valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EditTextEmoji.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    EditTextEmoji.this.emojiView.setTranslationY(0.0f);
                    EditTextEmoji.this.bottomPanelTranslationY(0.0f);
                }
            });
            valueAnimatorOfFloat.setDuration(250L);
            valueAnimatorOfFloat.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
            valueAnimatorOfFloat.start();
            return;
        }
        if (this.emojiButton != null) {
            if (this.currentStyle == 0) {
                this.emojiIconDrawable.setIcon(R.drawable.smiles_tab_smiles, true);
            } else {
                this.emojiIconDrawable.setIcon(R.drawable.input_smile, true);
            }
        }
        EmojiView emojiView3 = this.emojiView;
        if (emojiView3 != null) {
            this.emojiViewVisible = false;
            if (AndroidUtilities.usingHardwareInput || AndroidUtilities.isInMultiwindow) {
                emojiView3.setVisibility(8);
            }
        }
        SizeNotifierFrameLayout sizeNotifierFrameLayout2 = this.sizeNotifierLayout;
        if (sizeNotifierFrameLayout2 != null) {
            if (show == 0) {
                this.emojiPadding = 0;
            }
            sizeNotifierFrameLayout2.requestLayout();
            onWindowSizeChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPopup$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPopup$2$EditTextEmoji(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.emojiView.setTranslationY(fFloatValue);
        bottomPanelTranslationY(fFloatValue);
    }

    private void onWindowSizeChanged() {
        int height = this.sizeNotifierLayout.getHeight();
        if (!this.keyboardVisible) {
            height -= this.emojiPadding;
        }
        EditTextEmojiDelegate editTextEmojiDelegate = this.delegate;
        if (editTextEmojiDelegate != null) {
            editTextEmojiDelegate.onWindowSizeChanged(height);
        }
    }

    private void createEmojiView() {
        if (this.emojiView != null) {
            return;
        }
        EmojiView emojiView = new EmojiView(false, false, getContext(), false, null, null, this.resourcesProvider);
        this.emojiView = emojiView;
        emojiView.setVisibility(8);
        if (AndroidUtilities.isTablet()) {
            this.emojiView.setForseMultiwindowLayout(true);
        }
        this.emojiView.setDelegate(new AnonymousClass5());
        this.sizeNotifierLayout.addView(this.emojiView);
    }

    /* renamed from: ir.eitaa.ui.Components.EditTextEmoji$5, reason: invalid class name */
    class AnonymousClass5 implements EmojiView.EmojiViewDelegate {
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

        AnonymousClass5() {
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public boolean onBackspace() {
            if (EditTextEmoji.this.editText.length() == 0) {
                return false;
            }
            EditTextEmoji.this.editText.dispatchKeyEvent(new KeyEvent(0, 67));
            return true;
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onEmojiSelected(String symbol) {
            int selectionEnd = EditTextEmoji.this.editText.getSelectionEnd();
            if (selectionEnd < 0) {
                selectionEnd = 0;
            }
            try {
                try {
                    EditTextEmoji.this.innerTextChange = 2;
                    CharSequence charSequenceReplaceEmoji = Emoji.replaceEmoji(symbol, EditTextEmoji.this.editText.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
                    EditTextEmoji.this.editText.setText(EditTextEmoji.this.editText.getText().insert(selectionEnd, charSequenceReplaceEmoji));
                    int length = selectionEnd + charSequenceReplaceEmoji.length();
                    EditTextEmoji.this.editText.setSelection(length, length);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } finally {
                EditTextEmoji.this.innerTextChange = 0;
            }
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onClearEmojiRecent() {
            AlertDialog.Builder builder = new AlertDialog.Builder(EditTextEmoji.this.getContext(), EditTextEmoji.this.resourcesProvider);
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.getString("ClearRecentEmoji", R.string.ClearRecentEmoji));
            builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EditTextEmoji$5$heWw83yBcd4WDGcRYpKH36oPdJg
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onClearEmojiRecent$0$EditTextEmoji$5(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            if (EditTextEmoji.this.parentFragment != null) {
                EditTextEmoji.this.parentFragment.showDialog(builder.create());
            } else {
                builder.show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onClearEmojiRecent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onClearEmojiRecent$0$EditTextEmoji$5(DialogInterface dialogInterface, int i) {
            EditTextEmoji.this.emojiView.clearRecentEmoji();
        }
    }

    public boolean isPopupView(View view) {
        return view == this.emojiView;
    }

    public int getEmojiPadding() {
        return this.emojiPadding;
    }

    @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
    public void onSizeChanged(int height, boolean isWidthGreater) {
        boolean z;
        if (height > AndroidUtilities.dp(50.0f) && this.keyboardVisible && !AndroidUtilities.isInMultiwindow && !AndroidUtilities.isTablet()) {
            if (isWidthGreater) {
                this.keyboardHeightLand = height;
                MessagesController.getGlobalEmojiSettings().edit().putInt("kbd_height_land3", this.keyboardHeightLand).commit();
            } else {
                this.keyboardHeight = height;
                MessagesController.getGlobalEmojiSettings().edit().putInt("kbd_height", this.keyboardHeight).commit();
            }
        }
        if (isPopupShowing()) {
            int i = isWidthGreater ? this.keyboardHeightLand : this.keyboardHeight;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.emojiView.getLayoutParams();
            int i2 = layoutParams.width;
            int i3 = AndroidUtilities.displaySize.x;
            if (i2 != i3 || layoutParams.height != i) {
                layoutParams.width = i3;
                layoutParams.height = i;
                this.emojiView.setLayoutParams(layoutParams);
                SizeNotifierFrameLayout sizeNotifierFrameLayout = this.sizeNotifierLayout;
                if (sizeNotifierFrameLayout != null) {
                    this.emojiPadding = layoutParams.height;
                    sizeNotifierFrameLayout.requestLayout();
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
        boolean z3 = this.editText.isFocused() && height > 0;
        this.keyboardVisible = z3;
        if (z3 && isPopupShowing()) {
            showPopup(0);
        }
        if (this.emojiPadding != 0 && !(z = this.keyboardVisible) && z != z2 && !isPopupShowing()) {
            this.emojiPadding = 0;
            this.sizeNotifierLayout.requestLayout();
        }
        if (this.keyboardVisible && this.waitingForKeyboardOpen) {
            this.waitingForKeyboardOpen = false;
            AndroidUtilities.cancelRunOnUIThread(this.openKeyboardRunnable);
        }
        onWindowSizeChanged();
    }

    public EditTextCaption getEditText() {
        return this.editText;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
