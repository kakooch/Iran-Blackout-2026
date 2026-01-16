package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.NumberPicker;

/* loaded from: classes3.dex */
public class SwipeGestureSettingsView extends FrameLayout {
    String[] backgroundKeys;
    float colorProgress;
    String currentColorKey;
    int currentIconIndex;
    int currentIconValue;
    Paint filledPaint;
    int fromColor;
    boolean hasTabs;
    RLottieImageView[] iconViews;
    RLottieDrawable[] icons;
    Paint linePaint;
    Paint outlinePaint;
    private NumberPicker picker;
    Paint pickerDividersPaint;
    float progressToSwipeFolders;
    RectF rect;
    String[] strings;
    Runnable swapIconRunnable;

    public SwipeGestureSettingsView(Context context, int currentAccount) {
        super(context);
        this.outlinePaint = new Paint(1);
        this.filledPaint = new Paint(1);
        this.linePaint = new Paint(1);
        this.pickerDividersPaint = new Paint(1);
        this.rect = new RectF();
        String[] strArr = new String[6];
        this.strings = strArr;
        this.backgroundKeys = new String[6];
        this.icons = new RLottieDrawable[6];
        this.iconViews = new RLottieImageView[2];
        this.colorProgress = 1.0f;
        strArr[0] = LocaleController.getString("SwipeSettingsPin", R.string.SwipeSettingsPin);
        this.strings[1] = LocaleController.getString("SwipeSettingsRead", R.string.SwipeSettingsRead);
        this.strings[2] = LocaleController.getString("SwipeSettingsArchive", R.string.SwipeSettingsArchive);
        this.strings[3] = LocaleController.getString("SwipeSettingsMute", R.string.SwipeSettingsMute);
        this.strings[4] = LocaleController.getString("SwipeSettingsDelete", R.string.SwipeSettingsDelete);
        this.strings[5] = LocaleController.getString("SwipeSettingsFolders", R.string.SwipeSettingsFolders);
        String[] strArr2 = this.backgroundKeys;
        strArr2[0] = "chats_archiveBackground";
        strArr2[1] = "chats_archiveBackground";
        strArr2[2] = "chats_archiveBackground";
        strArr2[3] = "chats_archiveBackground";
        strArr2[4] = "dialogSwipeRemove";
        strArr2[5] = "chats_archivePinBackground";
        this.outlinePaint.setStyle(Paint.Style.STROKE);
        this.outlinePaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        this.linePaint.setStyle(Paint.Style.STROKE);
        this.linePaint.setStrokeCap(Paint.Cap.ROUND);
        this.linePaint.setStrokeWidth(AndroidUtilities.dp(5.0f));
        this.pickerDividersPaint.setStyle(Paint.Style.STROKE);
        this.pickerDividersPaint.setStrokeCap(Paint.Cap.ROUND);
        this.pickerDividersPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        NumberPicker numberPicker = new NumberPicker(context, 13) { // from class: ir.eitaa.ui.Components.SwipeGestureSettingsView.1
            @Override // ir.eitaa.ui.Components.NumberPicker, android.widget.LinearLayout, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                float fDp = AndroidUtilities.dp(31.0f);
                SwipeGestureSettingsView.this.pickerDividersPaint.setColor(Theme.getColor("radioBackgroundChecked"));
                canvas.drawLine(AndroidUtilities.dp(2.0f), fDp, getMeasuredWidth() - AndroidUtilities.dp(2.0f), fDp, SwipeGestureSettingsView.this.pickerDividersPaint);
                float measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(31.0f);
                canvas.drawLine(AndroidUtilities.dp(2.0f), measuredHeight, getMeasuredWidth() - AndroidUtilities.dp(2.0f), measuredHeight, SwipeGestureSettingsView.this.pickerDividersPaint);
            }
        };
        this.picker = numberPicker;
        numberPicker.setMinValue(0);
        this.picker.setDrawDividers(false);
        boolean z = !MessagesController.getInstance(currentAccount).dialogFilters.isEmpty();
        this.hasTabs = z;
        this.picker.setMaxValue(z ? this.strings.length - 1 : this.strings.length - 2);
        this.picker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$SwipeGestureSettingsView$-w1GUoJW50pOukP9s1I6j7vLZag
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i) {
                return this.f$0.lambda$new$0$SwipeGestureSettingsView(i);
            }
        });
        this.picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SwipeGestureSettingsView$-MjwUPjWId8R5Kg-b4gi29-uHYY
            @Override // ir.eitaa.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker2, int i, int i2) throws InterruptedException {
                this.f$0.lambda$new$1$SwipeGestureSettingsView(numberPicker2, i, i2);
            }
        });
        this.picker.setValue(SharedConfig.getChatSwipeAction(currentAccount));
        addView(this.picker, LayoutHelper.createFrame(132, -1.0f, 5, 21.0f, 0.0f, 21.0f, 0.0f));
        setWillNotDraw(false);
        this.currentIconIndex = 0;
        for (int i = 0; i < 2; i++) {
            this.iconViews[i] = new RLottieImageView(context);
            addView(this.iconViews[i], LayoutHelper.createFrame(28, 28.0f, 21, 0.0f, 0.0f, 184.0f, 0.0f));
        }
        RLottieDrawable icon = getIcon(this.picker.getValue());
        if (icon != null) {
            this.iconViews[0].setImageDrawable(icon);
            icon.setCurrentFrame(icon.getFramesCount() - 1);
        }
        AndroidUtilities.updateViewVisibilityAnimated(this.iconViews[0], true, 0.5f, false);
        AndroidUtilities.updateViewVisibilityAnimated(this.iconViews[1], false, 0.5f, false);
        this.progressToSwipeFolders = this.picker.getValue() != 5 ? 0.0f : 1.0f;
        this.currentIconValue = this.picker.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String lambda$new$0$SwipeGestureSettingsView(int i) {
        return this.strings[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$SwipeGestureSettingsView(NumberPicker numberPicker, int i, int i2) throws InterruptedException {
        swapIcons();
        SharedConfig.updateChatListSwipeSetting(i2);
        invalidate();
        numberPicker.performHapticFeedback(3, 2);
    }

    private void swapIcons() throws InterruptedException {
        int value;
        if (this.swapIconRunnable == null && this.currentIconValue != (value = this.picker.getValue())) {
            this.currentIconValue = value;
            int i = (this.currentIconIndex + 1) % 2;
            RLottieDrawable icon = getIcon(value);
            if (icon != null) {
                if (this.iconViews[i].getVisibility() != 0) {
                    icon.setCurrentFrame(0, false);
                }
                this.iconViews[i].setAnimation(icon);
                this.iconViews[i].playAnimation();
            } else {
                this.iconViews[i].clearAnimationDrawable();
            }
            AndroidUtilities.updateViewVisibilityAnimated(this.iconViews[this.currentIconIndex], false, 0.5f, true);
            AndroidUtilities.updateViewVisibilityAnimated(this.iconViews[i], true, 0.5f, true);
            this.currentIconIndex = i;
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SwipeGestureSettingsView$L6Wt2gWYdZv8zuBo9TR4mM36Qsc
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$swapIcons$2$SwipeGestureSettingsView();
                }
            };
            this.swapIconRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$swapIcons$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$swapIcons$2$SwipeGestureSettingsView() throws InterruptedException {
        this.swapIconRunnable = null;
        swapIcons();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(102.0f), 1073741824));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r16) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.SwipeGestureSettingsView.onDraw(android.graphics.Canvas):void");
    }

    public RLottieDrawable getIcon(int i) {
        RLottieDrawable[] rLottieDrawableArr = this.icons;
        if (rLottieDrawableArr[i] == null) {
            int i2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? R.raw.swipe_pin : R.raw.swipe_disabled : R.raw.swipe_delete : R.raw.swipe_mute : R.raw.chats_archive : R.raw.swipe_read;
            rLottieDrawableArr[i] = new RLottieDrawable(i2, "" + i2, AndroidUtilities.dp(28.0f), AndroidUtilities.dp(28.0f), true, (int[]) null);
            updateIconColor(i);
        }
        return this.icons[i];
    }

    public void updateIconColor(int i) {
        if (this.icons[i] != null) {
            int iBlendARGB = ColorUtils.blendARGB(Theme.getColor("windowBackgroundWhite"), Theme.getColor("chats_archiveBackground"), 0.9f);
            int color = Theme.getColor("chats_archiveIcon");
            if (i == 2) {
                this.icons[i].setLayerColor("Arrow.**", iBlendARGB);
                this.icons[i].setLayerColor("Box2.**", color);
                this.icons[i].setLayerColor("Box1.**", color);
                return;
            }
            this.icons[i].setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        }
    }

    public void updateColors() {
        for (int i = 0; i < this.icons.length; i++) {
            updateIconColor(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        updateColors();
        this.picker.setTextColor(Theme.getColor("dialogTextBlack"));
        this.picker.invalidate();
    }
}
