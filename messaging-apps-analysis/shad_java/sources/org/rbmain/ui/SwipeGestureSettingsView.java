package org.rbmain.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.NumberPicker;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;

/* loaded from: classes4.dex */
public class SwipeGestureSettingsView extends FrameLayout {
    int[] backgroundKeys;
    float colorProgress;
    int currentColorKey;
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

    public SwipeGestureSettingsView(Context context, int i) {
        super(context);
        this.outlinePaint = new Paint(1);
        this.filledPaint = new Paint(1);
        this.linePaint = new Paint(1);
        this.pickerDividersPaint = new Paint(1);
        this.rect = new RectF();
        String[] strArr = new String[5];
        this.strings = strArr;
        this.backgroundKeys = new int[5];
        this.icons = new RLottieDrawable[5];
        this.iconViews = new RLottieImageView[2];
        this.colorProgress = 1.0f;
        strArr[0] = LocaleController.getString("SwipeSettingsPin", R.string.SwipeSettingsPin);
        this.strings[1] = LocaleController.getString("SwipeSettingsRead", R.string.SwipeSettingsRead);
        this.strings[2] = LocaleController.getString("SwipeSettingsMute", R.string.SwipeSettingsMute);
        this.strings[3] = LocaleController.getString("SwipeSettingsDelete", R.string.SwipeSettingsDelete);
        this.strings[4] = LocaleController.getString("SwipeSettingsFolders", R.string.SwipeSettingsFolders);
        int[] iArr = this.backgroundKeys;
        int i2 = Theme.key_chats_archiveBackground;
        iArr[0] = i2;
        iArr[1] = i2;
        iArr[2] = i2;
        iArr[3] = Theme.key_dialogSwipeRemove;
        iArr[4] = Theme.key_chats_archivePinBackground;
        this.outlinePaint.setStyle(Paint.Style.STROKE);
        this.outlinePaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        this.linePaint.setStyle(Paint.Style.STROKE);
        this.linePaint.setStrokeCap(Paint.Cap.ROUND);
        this.linePaint.setStrokeWidth(AndroidUtilities.dp(5.0f));
        this.pickerDividersPaint.setStyle(Paint.Style.STROKE);
        this.pickerDividersPaint.setStrokeCap(Paint.Cap.ROUND);
        this.pickerDividersPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        NumberPicker numberPicker = new NumberPicker(context, 13) { // from class: org.rbmain.ui.SwipeGestureSettingsView.1
            @Override // org.rbmain.ui.Components.NumberPicker, android.widget.LinearLayout, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                float fDp = AndroidUtilities.dp(31.0f);
                SwipeGestureSettingsView.this.pickerDividersPaint.setColor(Theme.getColor(Theme.key_radioBackgroundChecked));
                canvas.drawLine(AndroidUtilities.dp(2.0f), fDp, getMeasuredWidth() - AndroidUtilities.dp(2.0f), fDp, SwipeGestureSettingsView.this.pickerDividersPaint);
                float measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(31.0f);
                canvas.drawLine(AndroidUtilities.dp(2.0f), measuredHeight, getMeasuredWidth() - AndroidUtilities.dp(2.0f), measuredHeight, SwipeGestureSettingsView.this.pickerDividersPaint);
            }
        };
        this.picker = numberPicker;
        numberPicker.setMinValue(0);
        this.picker.setDrawDividers(false);
        boolean z = !MessagesController.getInstance(i).dialogFilters.isEmpty();
        this.hasTabs = z;
        this.picker.setMaxValue(z ? this.strings.length - 1 : this.strings.length - 2);
        this.picker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.SwipeGestureSettingsView$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i3) {
                return this.f$0.lambda$new$0(i3);
            }
        });
        this.picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: org.rbmain.ui.SwipeGestureSettingsView$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker2, int i3, int i4) {
                this.f$0.lambda$new$1(numberPicker2, i3, i4);
            }
        });
        this.picker.setValue(SharedConfig.getChatSwipeAction(i));
        addView(this.picker, LayoutHelper.createFrame(132, -1.0f, 5, 21.0f, 0.0f, 21.0f, 0.0f));
        setWillNotDraw(false);
        this.currentIconIndex = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            this.iconViews[i3] = new RLottieImageView(context);
            addView(this.iconViews[i3], LayoutHelper.createFrame(28, 28.0f, 21, 0.0f, 0.0f, 184.0f, 0.0f));
        }
        RLottieDrawable icon = getIcon(this.picker.getValue());
        if (icon != null) {
            this.iconViews[0].setImageDrawable(icon);
            icon.setCurrentFrame(icon.getFramesCount() - 1);
        }
        AndroidUtilities.updateViewVisibilityAnimated(this.iconViews[0], true, 0.5f, false);
        AndroidUtilities.updateViewVisibilityAnimated(this.iconViews[1], false, 0.5f, false);
        this.progressToSwipeFolders = this.picker.getValue() != 4 ? 0.0f : 1.0f;
        this.currentIconValue = this.picker.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$new$0(int i) {
        return this.strings[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(NumberPicker numberPicker, int i, int i2) {
        swapIcons();
        SharedConfig.updateChatListSwipeSetting(i2);
        invalidate();
        numberPicker.performHapticFeedback(3, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void swapIcons() {
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
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.SwipeGestureSettingsView.2
                @Override // java.lang.Runnable
                public void run() {
                    SwipeGestureSettingsView swipeGestureSettingsView = SwipeGestureSettingsView.this;
                    swipeGestureSettingsView.swapIconRunnable = null;
                    swipeGestureSettingsView.swapIcons();
                }
            };
            this.swapIconRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 150L);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(102.0f), 1073741824));
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.SwipeGestureSettingsView.onDraw(android.graphics.Canvas):void");
    }

    public RLottieDrawable getIcon(int i) {
        RLottieDrawable[] rLottieDrawableArr = this.icons;
        if (rLottieDrawableArr[i] == null) {
            int i2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? R.raw.swipe_pin : R.raw.swipe_disabled : R.raw.swipe_delete : R.raw.swipe_mute : R.raw.swipe_read;
            rLottieDrawableArr[i] = new RLottieDrawable(i2, BuildConfig.FLAVOR + i2, AndroidUtilities.dp(28.0f), AndroidUtilities.dp(28.0f), true, null);
            updateIconColor(i);
        }
        return this.icons[i];
    }

    public void updateIconColor(int i) {
        if (this.icons[i] != null) {
            ColorUtils.blendARGB(Theme.getColor(Theme.key_windowBackgroundWhite), Theme.getColor(Theme.key_chats_archiveBackground), 0.9f);
            this.icons[i].setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chats_archiveIcon), PorterDuff.Mode.MULTIPLY));
        }
    }

    public void updateColors() {
        for (int i = 0; i < this.icons.length; i++) {
            updateIconColor(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        updateColors();
        this.picker.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        this.picker.invalidate();
    }
}
