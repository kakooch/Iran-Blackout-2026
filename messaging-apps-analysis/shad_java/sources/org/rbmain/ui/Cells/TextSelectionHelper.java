package org.rbmain.ui.Cells;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Magnifier;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.zxing.common.detector.MathUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ArticleViewer;
import org.rbmain.ui.Cells.TextSelectionHelper;
import org.rbmain.ui.Cells.TextSelectionHelper.SelectableView;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public abstract class TextSelectionHelper<Cell extends SelectableView> {
    private ActionMode actionMode;
    protected boolean actionsIsShowing;
    private Callback callback;
    protected int capturedX;
    protected int capturedY;
    private TextView deleteView;
    protected float enterProgress;
    protected float handleViewProgress;
    private boolean isOneTouch;
    int keyboardSize;
    private int lastX;
    private int lastY;
    protected final LayoutBlock layoutBlock;
    private Magnifier magnifier;
    private float magnifierDy;
    private float magnifierY;
    private float magnifierYanimated;
    protected Cell maybeSelectedView;
    protected int maybeTextX;
    protected int maybeTextY;
    protected boolean movingDirectionSettling;
    private boolean movingHandle;
    protected boolean movingHandleStart;
    float movingOffsetX;
    float movingOffsetY;
    protected boolean multiselect;
    private boolean parentIsScrolling;
    protected RecyclerListView parentRecyclerView;
    protected ViewGroup parentView;
    protected PathWithSavedBottom path;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout popupLayout;
    private Rect popupRect;
    private ActionBarPopupWindow popupWindow;
    private boolean scrollDown;
    private boolean scrolling;
    protected long selectedCellId;
    protected Cell selectedView;
    private boolean snap;
    protected TextSelectionHelper<Cell>.TextSelectionOverlay textSelectionOverlay;
    protected int textX;
    protected int textY;
    private int topOffset;
    private boolean tryCapture;
    protected int[] tmpCoord = new int[2];
    protected Paint selectionPaint = new Paint();
    protected int selectionStart = -1;
    protected int selectionEnd = -1;
    private final ActionMode.Callback textSelectActionCallback = createActionCallback();
    protected final Rect textArea = new Rect();
    private RectF startArea = new RectF();
    private RectF endArea = new RectF();
    private Interpolator interpolator = new OvershootInterpolator();
    protected boolean showActionsAsPopupAlways = false;
    private Runnable scrollRunnable = new Runnable() { // from class: org.rbmain.ui.Cells.TextSelectionHelper.1
        @Override // java.lang.Runnable
        public void run() {
            int lineHeight;
            if (TextSelectionHelper.this.scrolling) {
                TextSelectionHelper textSelectionHelper = TextSelectionHelper.this;
                if (textSelectionHelper.parentRecyclerView != null) {
                    if (textSelectionHelper.multiselect && textSelectionHelper.selectedView == null) {
                        lineHeight = AndroidUtilities.dp(8.0f);
                    } else if (textSelectionHelper.selectedView == null) {
                        return;
                    } else {
                        lineHeight = textSelectionHelper.getLineHeight() >> 1;
                    }
                    TextSelectionHelper textSelectionHelper2 = TextSelectionHelper.this;
                    if (!textSelectionHelper2.multiselect) {
                        if (textSelectionHelper2.scrollDown) {
                            if (TextSelectionHelper.this.selectedView.getBottom() - lineHeight < TextSelectionHelper.this.parentView.getMeasuredHeight()) {
                                lineHeight = TextSelectionHelper.this.selectedView.getBottom() - TextSelectionHelper.this.parentView.getMeasuredHeight();
                            }
                        } else if (TextSelectionHelper.this.selectedView.getTop() + lineHeight > 0) {
                            lineHeight = -TextSelectionHelper.this.selectedView.getTop();
                        }
                    }
                    TextSelectionHelper textSelectionHelper3 = TextSelectionHelper.this;
                    RecyclerListView recyclerListView = textSelectionHelper3.parentRecyclerView;
                    if (!textSelectionHelper3.scrollDown) {
                        lineHeight = -lineHeight;
                    }
                    recyclerListView.scrollBy(0, lineHeight);
                    AndroidUtilities.runOnUIThread(this);
                }
            }
        }
    };
    final Runnable startSelectionRunnable = new Runnable() { // from class: org.rbmain.ui.Cells.TextSelectionHelper.2
        @Override // java.lang.Runnable
        public void run() {
            TextSelectionHelper textSelectionHelper = TextSelectionHelper.this;
            Cell cell = textSelectionHelper.maybeSelectedView;
            if (cell == null || textSelectionHelper.textSelectionOverlay == null) {
                return;
            }
            Cell cell2 = textSelectionHelper.selectedView;
            CharSequence text = textSelectionHelper.getText(cell, true);
            RecyclerListView recyclerListView = TextSelectionHelper.this.parentRecyclerView;
            if (recyclerListView != null) {
                recyclerListView.cancelClickRunnables(false);
            }
            TextSelectionHelper textSelectionHelper2 = TextSelectionHelper.this;
            int i = textSelectionHelper2.capturedX;
            int i2 = textSelectionHelper2.capturedY;
            if (!textSelectionHelper2.textArea.isEmpty()) {
                Rect rect = TextSelectionHelper.this.textArea;
                int i3 = rect.right;
                if (i > i3) {
                    i = i3 - 1;
                }
                int i4 = rect.left;
                if (i < i4) {
                    i = i4 + 1;
                }
                int i5 = rect.top;
                if (i2 < i5) {
                    i2 = i5 + 1;
                }
                int i6 = rect.bottom;
                if (i2 > i6) {
                    i2 = i6 - 1;
                }
            }
            int i7 = i;
            TextSelectionHelper textSelectionHelper3 = TextSelectionHelper.this;
            int charOffsetFromCord = textSelectionHelper3.getCharOffsetFromCord(i7, i2, textSelectionHelper3.maybeTextX, textSelectionHelper3.maybeTextY, cell, true);
            if (charOffsetFromCord >= text.length()) {
                TextSelectionHelper textSelectionHelper4 = TextSelectionHelper.this;
                textSelectionHelper4.fillLayoutForOffset(charOffsetFromCord, textSelectionHelper4.layoutBlock, true);
                TextSelectionHelper textSelectionHelper5 = TextSelectionHelper.this;
                StaticLayout staticLayout = textSelectionHelper5.layoutBlock.layout;
                if (staticLayout == null) {
                    textSelectionHelper5.selectionEnd = -1;
                    textSelectionHelper5.selectionStart = -1;
                    return;
                }
                int lineCount = staticLayout.getLineCount() - 1;
                TextSelectionHelper textSelectionHelper6 = TextSelectionHelper.this;
                float f = i7 - textSelectionHelper6.maybeTextX;
                if (f < textSelectionHelper6.layoutBlock.layout.getLineRight(lineCount) + AndroidUtilities.dp(4.0f) && f > TextSelectionHelper.this.layoutBlock.layout.getLineLeft(lineCount)) {
                    charOffsetFromCord = text.length() - 1;
                }
            }
            if (charOffsetFromCord >= 0 && charOffsetFromCord < text.length() && text.charAt(charOffsetFromCord) != '\n') {
                TextSelectionHelper textSelectionHelper7 = TextSelectionHelper.this;
                int i8 = textSelectionHelper7.maybeTextX;
                int i9 = textSelectionHelper7.maybeTextY;
                textSelectionHelper7.clear();
                TextSelectionHelper.this.textSelectionOverlay.setVisibility(0);
                TextSelectionHelper.this.onTextSelected(cell, cell2);
                TextSelectionHelper textSelectionHelper8 = TextSelectionHelper.this;
                textSelectionHelper8.selectionStart = charOffsetFromCord;
                textSelectionHelper8.selectionEnd = charOffsetFromCord;
                if (text instanceof Spanned) {
                    Spanned spanned = (Spanned) text;
                    Emoji.EmojiSpan[] emojiSpanArr = (Emoji.EmojiSpan[]) spanned.getSpans(0, text.length(), Emoji.EmojiSpan.class);
                    int length = emojiSpanArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        Emoji.EmojiSpan emojiSpan = emojiSpanArr[i10];
                        int spanStart = spanned.getSpanStart(emojiSpan);
                        int spanEnd = spanned.getSpanEnd(emojiSpan);
                        if (charOffsetFromCord >= spanStart && charOffsetFromCord <= spanEnd) {
                            TextSelectionHelper textSelectionHelper9 = TextSelectionHelper.this;
                            textSelectionHelper9.selectionStart = spanStart;
                            textSelectionHelper9.selectionEnd = spanEnd;
                            break;
                        }
                        i10++;
                    }
                }
                TextSelectionHelper textSelectionHelper10 = TextSelectionHelper.this;
                if (textSelectionHelper10.selectionStart == textSelectionHelper10.selectionEnd) {
                    while (true) {
                        int i11 = TextSelectionHelper.this.selectionStart;
                        if (i11 <= 0 || !TextSelectionHelper.isInterruptedCharacter(text.charAt(i11 - 1))) {
                            break;
                        }
                        TextSelectionHelper.this.selectionStart--;
                    }
                    while (TextSelectionHelper.this.selectionEnd < text.length() && TextSelectionHelper.isInterruptedCharacter(text.charAt(TextSelectionHelper.this.selectionEnd))) {
                        TextSelectionHelper.this.selectionEnd++;
                    }
                }
                TextSelectionHelper textSelectionHelper11 = TextSelectionHelper.this;
                textSelectionHelper11.textX = i8;
                textSelectionHelper11.textY = i9;
                textSelectionHelper11.selectedView = cell;
                textSelectionHelper11.textSelectionOverlay.performHapticFeedback(0);
                TextSelectionHelper.this.showActions();
                TextSelectionHelper.this.invalidate();
                if (cell2 != null) {
                    cell2.invalidate();
                }
                if (TextSelectionHelper.this.callback != null) {
                    TextSelectionHelper.this.callback.onStateChanged(true);
                }
                TextSelectionHelper.this.movingHandle = true;
                TextSelectionHelper textSelectionHelper12 = TextSelectionHelper.this;
                textSelectionHelper12.movingDirectionSettling = true;
                textSelectionHelper12.isOneTouch = true;
                TextSelectionHelper textSelectionHelper13 = TextSelectionHelper.this;
                textSelectionHelper13.movingOffsetY = 0.0f;
                textSelectionHelper13.movingOffsetX = 0.0f;
                textSelectionHelper13.onOffsetChanged();
            }
            TextSelectionHelper.this.tryCapture = false;
        }
    };
    private final Runnable hideActionsRunnable = new Runnable() { // from class: org.rbmain.ui.Cells.TextSelectionHelper.3
        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT < 23 || TextSelectionHelper.this.actionMode == null) {
                return;
            }
            TextSelectionHelper textSelectionHelper = TextSelectionHelper.this;
            if (textSelectionHelper.actionsIsShowing) {
                return;
            }
            textSelectionHelper.actionMode.hide(Long.MAX_VALUE);
            AndroidUtilities.runOnUIThread(TextSelectionHelper.this.hideActionsRunnable, 1000L);
        }
    };
    private int longpressDelay = ViewConfiguration.getLongPressTimeout();
    private int touchSlop = ViewConfiguration.get(ApplicationLoader.applicationContext).getScaledTouchSlop();

    public interface ArticleSelectableView extends SelectableView {
        void fillTextLayoutBlocks(ArrayList<TextLayoutBlock> arrayList);
    }

    public static class Callback {
        public void onStateChanged(boolean z) {
            throw null;
        }

        public void onTextCopied() {
        }
    }

    public static class IgnoreCopySpannable {
    }

    public interface SelectableView {
        int getBottom();

        int getMeasuredWidth();

        int getTop();

        float getX();

        float getY();

        void invalidate();
    }

    public interface TextLayoutBlock {
        StaticLayout getLayout();

        CharSequence getPrefix();

        int getRow();

        int getX();

        int getY();
    }

    protected abstract void fillLayoutForOffset(int i, LayoutBlock layoutBlock, boolean z);

    protected abstract int getCharOffsetFromCord(int i, int i2, int i3, int i4, Cell cell, boolean z);

    protected abstract int getLineHeight();

    protected abstract CharSequence getText(Cell cell, boolean z);

    protected void onExitSelectionMode(boolean z) {
    }

    protected void onOffsetChanged() {
    }

    protected abstract void onTextSelected(Cell cell, Cell cell2);

    protected void pickEndView() {
    }

    protected void pickStartView() {
    }

    protected boolean selectLayout(int i, int i2) {
        return false;
    }

    public TextSelectionHelper() {
        this.path = new PathWithSavedBottom();
        this.layoutBlock = new LayoutBlock();
    }

    public void setParentView(ViewGroup viewGroup) {
        if (viewGroup instanceof RecyclerListView) {
            this.parentRecyclerView = (RecyclerListView) viewGroup;
        }
        this.parentView = viewGroup;
    }

    public void setMaybeTextCord(int i, int i2) {
        this.maybeTextX = i;
        this.maybeTextY = i2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.capturedX = (int) motionEvent.getX();
            this.capturedY = (int) motionEvent.getY();
            this.tryCapture = false;
            this.textArea.inset(-AndroidUtilities.dp(8.0f), -AndroidUtilities.dp(8.0f));
            if (this.textArea.contains(this.capturedX, this.capturedY)) {
                this.textArea.inset(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
                int i = this.capturedX;
                int i2 = this.capturedY;
                Rect rect = this.textArea;
                int i3 = rect.right;
                if (i > i3) {
                    i = i3 - 1;
                }
                int i4 = rect.left;
                if (i < i4) {
                    i = i4 + 1;
                }
                int i5 = rect.top;
                if (i2 < i5) {
                    i2 = i5 + 1;
                }
                int i6 = rect.bottom;
                int charOffsetFromCord = getCharOffsetFromCord(i, i2 > i6 ? i6 - 1 : i2, this.maybeTextX, this.maybeTextY, this.maybeSelectedView, true);
                CharSequence text = getText(this.maybeSelectedView, true);
                if (charOffsetFromCord >= text.length()) {
                    fillLayoutForOffset(charOffsetFromCord, this.layoutBlock, true);
                    StaticLayout staticLayout = this.layoutBlock.layout;
                    if (staticLayout == null) {
                        this.tryCapture = false;
                        return false;
                    }
                    int lineCount = staticLayout.getLineCount() - 1;
                    float f = i - this.maybeTextX;
                    if (f < this.layoutBlock.layout.getLineRight(lineCount) + AndroidUtilities.dp(4.0f) && f > this.layoutBlock.layout.getLineLeft(lineCount)) {
                        charOffsetFromCord = text.length() - 1;
                    }
                }
                if (charOffsetFromCord >= 0 && charOffsetFromCord < text.length() && text.charAt(charOffsetFromCord) != '\n') {
                    AndroidUtilities.runOnUIThread(this.startSelectionRunnable, this.longpressDelay);
                    this.tryCapture = true;
                }
            }
            return this.tryCapture;
        }
        if (action != 1) {
            if (action == 2) {
                int y = (int) motionEvent.getY();
                int x = (int) motionEvent.getX();
                int i7 = this.capturedY;
                int i8 = (i7 - y) * (i7 - y);
                int i9 = this.capturedX;
                if (i8 + ((i9 - x) * (i9 - x)) > this.touchSlop) {
                    AndroidUtilities.cancelRunOnUIThread(this.startSelectionRunnable);
                    this.tryCapture = false;
                }
                return this.tryCapture;
            }
            if (action != 3) {
                return false;
            }
        }
        AndroidUtilities.cancelRunOnUIThread(this.startSelectionRunnable);
        this.tryCapture = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideMagnifier() {
        Magnifier magnifier;
        if (Build.VERSION.SDK_INT < 28 || (magnifier = this.magnifier) == null) {
            return;
        }
        magnifier.dismiss();
        this.magnifier = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMagnifier(int i) {
        int x;
        int x2;
        if (Build.VERSION.SDK_INT < 28 || this.selectedView == null || this.isOneTouch || !this.movingHandle || this.textSelectionOverlay == null) {
            return;
        }
        int i2 = this.movingHandleStart ? this.selectionStart : this.selectionEnd;
        fillLayoutForOffset(i2, this.layoutBlock);
        StaticLayout staticLayout = this.layoutBlock.layout;
        if (staticLayout == null) {
            return;
        }
        int lineForOffset = staticLayout.getLineForOffset(i2);
        int lineBottom = staticLayout.getLineBottom(lineForOffset) - staticLayout.getLineTop(lineForOffset);
        float lineTop = (int) (((((int) ((staticLayout.getLineTop(lineForOffset) + this.textY) + this.selectedView.getY())) - lineBottom) - AndroidUtilities.dp(8.0f)) + this.layoutBlock.yOffset);
        if (this.magnifierY != lineTop) {
            this.magnifierY = lineTop;
            this.magnifierDy = (lineTop - this.magnifierYanimated) / 200.0f;
        }
        if (this.magnifier == null) {
            this.magnifier = new Magnifier(this.textSelectionOverlay);
            this.magnifierYanimated = this.magnifierY;
        }
        float f = this.magnifierYanimated;
        float f2 = this.magnifierY;
        if (f != f2) {
            this.magnifierYanimated = f + (this.magnifierDy * 16.0f);
        }
        float f3 = this.magnifierDy;
        if (f3 > 0.0f && this.magnifierYanimated > f2) {
            this.magnifierYanimated = f2;
        } else if (f3 < 0.0f && this.magnifierYanimated < f2) {
            this.magnifierYanimated = f2;
        }
        Cell cell = this.selectedView;
        if (cell instanceof ArticleViewer.BlockTableCell) {
            x2 = (int) cell.getX();
            x = ((int) this.selectedView.getX()) + this.selectedView.getMeasuredWidth();
        } else {
            int x3 = (int) (cell.getX() + this.textX + staticLayout.getLineLeft(lineForOffset));
            x = (int) (this.selectedView.getX() + this.textX + staticLayout.getLineRight(lineForOffset));
            x2 = x3;
        }
        if (i < x2) {
            i = x2;
        } else if (i > x) {
            i = x;
        }
        this.magnifier.show(i, this.magnifierYanimated + (lineBottom * 1.5f) + AndroidUtilities.dp(8.0f));
        this.magnifier.update();
    }

    protected void showHandleViews() {
        if (this.handleViewProgress == 1.0f || this.textSelectionOverlay == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Cells.TextSelectionHelper$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$showHandleViews$0(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showHandleViews$0(ValueAnimator valueAnimator) {
        this.handleViewProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.textSelectionOverlay.invalidate();
    }

    public boolean isSelectionMode() {
        return this.selectionStart >= 0 && this.selectionEnd >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showActions() {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.TextSelectionHelper.showActions():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showActions$1(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.popupWindow) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.popupRect);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showActions$2(View view) {
        copyText();
    }

    protected boolean canShowActions() {
        return this.selectedView != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideActions() {
        ActionMode actionMode;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.actionMode != null && this.actionsIsShowing) {
                this.actionsIsShowing = false;
                this.hideActionsRunnable.run();
            }
            this.actionsIsShowing = false;
        }
        if (!isSelectionMode() && (actionMode = this.actionMode) != null) {
            actionMode.finish();
            this.actionMode = null;
        }
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
    }

    public TextSelectionHelper<Cell>.TextSelectionOverlay getOverlayView(Context context) {
        if (this.textSelectionOverlay == null) {
            this.textSelectionOverlay = new TextSelectionOverlay(context);
        }
        return this.textSelectionOverlay;
    }

    public boolean isSelected(MessageObject messageObject) {
        return messageObject != null && this.selectedCellId == messageObject.getId();
    }

    public void checkSelectionCancel(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            cancelTextSelectionRunnable();
        }
    }

    public void cancelTextSelectionRunnable() {
        AndroidUtilities.cancelRunOnUIThread(this.startSelectionRunnable);
        this.tryCapture = false;
    }

    public void clear() {
        clear(false);
    }

    public void clear(boolean z) {
        onExitSelectionMode(z);
        this.selectionStart = -1;
        this.selectionEnd = -1;
        hideMagnifier();
        hideActions();
        invalidate();
        this.selectedView = null;
        this.selectedCellId = 0L;
        AndroidUtilities.cancelRunOnUIThread(this.startSelectionRunnable);
        this.tryCapture = false;
        TextSelectionHelper<Cell>.TextSelectionOverlay textSelectionOverlay = this.textSelectionOverlay;
        if (textSelectionOverlay != null) {
            textSelectionOverlay.setVisibility(8);
        }
        this.handleViewProgress = 0.0f;
        Callback callback = this.callback;
        if (callback != null) {
            callback.onStateChanged(false);
        }
        this.capturedX = -1;
        this.capturedY = -1;
        this.maybeTextX = -1;
        this.maybeTextY = -1;
        this.movingOffsetX = 0.0f;
        this.movingOffsetY = 0.0f;
        this.movingHandle = false;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public boolean isTryingSelect() {
        return this.tryCapture;
    }

    public void onParentScrolled() {
        TextSelectionHelper<Cell>.TextSelectionOverlay textSelectionOverlay;
        if (!isSelectionMode() || (textSelectionOverlay = this.textSelectionOverlay) == null) {
            return;
        }
        this.parentIsScrolling = true;
        textSelectionOverlay.invalidate();
        hideActions();
    }

    public void stopScrolling() {
        this.parentIsScrolling = false;
        showActions();
    }

    public static boolean isInterruptedCharacter(char c) {
        return Character.isLetter(c) || Character.isDigit(c) || c == '_';
    }

    public void setTopOffset(int i) {
        this.topOffset = i;
    }

    public class TextSelectionOverlay extends View {
        Paint handleViewPaint;
        Path path;
        long pressedTime;
        float pressedX;
        float pressedY;

        public TextSelectionOverlay(Context context) {
            super(context);
            this.handleViewPaint = new Paint(1);
            this.pressedTime = 0L;
            this.path = new Path();
            this.handleViewPaint.setStyle(Paint.Style.FILL);
        }

        public boolean checkOnTap(MotionEvent motionEvent) {
            if (TextSelectionHelper.this.isSelectionMode() && !TextSelectionHelper.this.movingHandle) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.pressedX = motionEvent.getX();
                    this.pressedY = motionEvent.getY();
                    this.pressedTime = System.currentTimeMillis();
                } else if (action == 1 && System.currentTimeMillis() - this.pressedTime < 200 && MathUtils.distance((int) this.pressedX, (int) this.pressedY, (int) motionEvent.getX(), (int) motionEvent.getY()) < TextSelectionHelper.this.touchSlop) {
                    TextSelectionHelper.this.hideActions();
                    TextSelectionHelper.this.clear();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:278:0x04e8  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00f3  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x011b  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r22) {
            /*
                Method dump skipped, instructions count: 1533
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.TextSelectionHelper.TextSelectionOverlay.onTouchEvent(android.view.MotionEvent):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x018a  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r19) {
            /*
                Method dump skipped, instructions count: 890
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.TextSelectionHelper.TextSelectionOverlay.onDraw(android.graphics.Canvas):void");
        }
    }

    protected void jumpToLine(int i, int i2, boolean z, float f, float f2, Cell cell) {
        int i3;
        int i4;
        if (this.movingHandleStart) {
            this.selectionStart = i2;
            if (!z && i2 > (i4 = this.selectionEnd)) {
                this.selectionEnd = i2;
                this.selectionStart = i4;
                this.movingHandleStart = false;
            }
            this.snap = true;
            return;
        }
        this.selectionEnd = i2;
        if (!z && (i3 = this.selectionStart) > i2) {
            this.selectionEnd = i3;
            this.selectionStart = i2;
            this.movingHandleStart = true;
        }
        this.snap = true;
    }

    protected boolean canSelect(int i) {
        return (i == this.selectionStart || i == this.selectionEnd) ? false : true;
    }

    public void invalidate() {
        Cell cell = this.selectedView;
        if (cell != null) {
            cell.invalidate();
        }
        TextSelectionHelper<Cell>.TextSelectionOverlay textSelectionOverlay = this.textSelectionOverlay;
        if (textSelectionOverlay != null) {
            textSelectionOverlay.invalidate();
        }
    }

    private ActionMode.Callback createActionCallback() {
        final ActionMode.Callback callback = new ActionMode.Callback() { // from class: org.rbmain.ui.Cells.TextSelectionHelper.4
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                menu.add(0, R.id.copy, 0, R.string.copy);
                menu.add(0, R.id.selectAll, 1, R.string.selectAll);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                TextSelectionHelper textSelectionHelper = TextSelectionHelper.this;
                Cell cell = textSelectionHelper.selectedView;
                if (cell != null) {
                    CharSequence text = textSelectionHelper.getText(cell, false);
                    TextSelectionHelper textSelectionHelper2 = TextSelectionHelper.this;
                    if (textSelectionHelper2.multiselect || (textSelectionHelper2.selectionStart <= 0 && textSelectionHelper2.selectionEnd >= text.length() - 1)) {
                        menu.getItem(1).setVisible(false);
                    } else {
                        menu.getItem(1).setVisible(true);
                    }
                }
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                if (!TextSelectionHelper.this.isSelectionMode()) {
                    return true;
                }
                int itemId = menuItem.getItemId();
                if (itemId != 16908319) {
                    if (itemId == 16908321) {
                        TextSelectionHelper.this.copyText();
                        return true;
                    }
                    TextSelectionHelper.this.clear();
                    return true;
                }
                TextSelectionHelper textSelectionHelper = TextSelectionHelper.this;
                CharSequence text = textSelectionHelper.getText(textSelectionHelper.selectedView, false);
                if (text == null) {
                    return true;
                }
                TextSelectionHelper textSelectionHelper2 = TextSelectionHelper.this;
                textSelectionHelper2.selectionStart = 0;
                textSelectionHelper2.selectionEnd = text.length();
                TextSelectionHelper.this.hideActions();
                TextSelectionHelper.this.invalidate();
                TextSelectionHelper.this.showActions();
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
                if (Build.VERSION.SDK_INT < 23) {
                    TextSelectionHelper.this.clear();
                }
            }
        };
        return Build.VERSION.SDK_INT >= 23 ? new ActionMode.Callback2() { // from class: org.rbmain.ui.Cells.TextSelectionHelper.5
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return callback.onCreateActionMode(actionMode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return callback.onPrepareActionMode(actionMode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return callback.onActionItemClicked(actionMode, menuItem);
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
                callback.onDestroyActionMode(actionMode);
            }

            @Override // android.view.ActionMode.Callback2
            public void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
                int i;
                if (TextSelectionHelper.this.isSelectionMode()) {
                    TextSelectionHelper.this.pickStartView();
                    TextSelectionHelper textSelectionHelper = TextSelectionHelper.this;
                    int i2 = 1;
                    if (textSelectionHelper.selectedView != null) {
                        int i3 = -textSelectionHelper.getLineHeight();
                        TextSelectionHelper textSelectionHelper2 = TextSelectionHelper.this;
                        int i4 = textSelectionHelper2.offsetToCord(textSelectionHelper2.selectionStart)[0];
                        TextSelectionHelper textSelectionHelper3 = TextSelectionHelper.this;
                        i = i4 + textSelectionHelper3.textX;
                        int y = (((int) ((r7[1] + textSelectionHelper3.textY) + textSelectionHelper3.selectedView.getY())) + (i3 / 2)) - AndroidUtilities.dp(4.0f);
                        if (y >= 1) {
                            i2 = y;
                        }
                    } else {
                        i = 0;
                    }
                    int width = TextSelectionHelper.this.parentView.getWidth();
                    TextSelectionHelper.this.pickEndView();
                    TextSelectionHelper textSelectionHelper4 = TextSelectionHelper.this;
                    if (textSelectionHelper4.selectedView != null) {
                        width = textSelectionHelper4.offsetToCord(textSelectionHelper4.selectionEnd)[0] + TextSelectionHelper.this.textX;
                    }
                    rect.set(Math.min(i, width), i2, Math.max(i, width), i2 + 1);
                }
            }
        } : callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyText() {
        CharSequence textForCopy;
        if (isSelectionMode() && (textForCopy = getTextForCopy()) != null) {
            ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", textForCopy));
            hideActions();
            clear(true);
            Callback callback = this.callback;
            if (callback != null) {
                callback.onTextCopied();
            }
        }
    }

    protected CharSequence getTextForCopy() {
        CharSequence text = getText(this.selectedView, false);
        if (text != null) {
            return text.subSequence(this.selectionStart, this.selectionEnd);
        }
        return null;
    }

    protected int[] offsetToCord(int i) {
        fillLayoutForOffset(i, this.layoutBlock);
        StaticLayout staticLayout = this.layoutBlock.layout;
        if (staticLayout == null || i > staticLayout.getText().length()) {
            return this.tmpCoord;
        }
        int lineForOffset = staticLayout.getLineForOffset(i);
        this.tmpCoord[0] = (int) (staticLayout.getPrimaryHorizontal(i) + this.layoutBlock.xOffset);
        this.tmpCoord[1] = staticLayout.getLineBottom(lineForOffset);
        int[] iArr = this.tmpCoord;
        iArr[1] = (int) (iArr[1] + this.layoutBlock.yOffset);
        return iArr;
    }

    protected void drawSelection(Canvas canvas, StaticLayout staticLayout, int i, int i2) {
        float lineRight;
        int lineForOffset = staticLayout.getLineForOffset(i);
        int lineForOffset2 = staticLayout.getLineForOffset(i2);
        if (lineForOffset == lineForOffset2) {
            drawLine(canvas, staticLayout, lineForOffset, i, i2);
            return;
        }
        int lineEnd = staticLayout.getLineEnd(lineForOffset);
        if (staticLayout.getParagraphDirection(lineForOffset) != -1 && lineEnd > 0) {
            lineEnd--;
            CharSequence text = staticLayout.getText();
            int primaryHorizontal = (int) staticLayout.getPrimaryHorizontal(lineEnd);
            if (staticLayout.isRtlCharAt(lineEnd)) {
                int i3 = lineEnd;
                while (staticLayout.isRtlCharAt(i3) && i3 != 0) {
                    i3--;
                }
                lineRight = staticLayout.getLineForOffset(i3) == staticLayout.getLineForOffset(lineEnd) ? staticLayout.getPrimaryHorizontal(i3 + 1) : staticLayout.getLineLeft(lineForOffset);
            } else {
                lineRight = staticLayout.getLineRight(lineForOffset);
            }
            int i4 = (int) lineRight;
            int iMin = Math.min(primaryHorizontal, i4);
            int iMax = Math.max(primaryHorizontal, i4);
            if (lineEnd > 0 && lineEnd < text.length() && !Character.isWhitespace(text.charAt(lineEnd - 1))) {
                canvas.drawRect(iMin, staticLayout.getLineTop(lineForOffset), iMax, staticLayout.getLineBottom(lineForOffset), this.selectionPaint);
            }
        }
        drawLine(canvas, staticLayout, lineForOffset, i, lineEnd);
        drawLine(canvas, staticLayout, lineForOffset2, staticLayout.getLineStart(lineForOffset2), i2);
        while (true) {
            lineForOffset++;
            if (lineForOffset >= lineForOffset2) {
                return;
            }
            int lineLeft = (int) staticLayout.getLineLeft(lineForOffset);
            int lineRight2 = (int) staticLayout.getLineRight(lineForOffset);
            canvas.drawRect(Math.min(lineLeft, lineRight2), staticLayout.getLineTop(lineForOffset), Math.max(lineLeft, lineRight2), staticLayout.getLineBottom(lineForOffset), this.selectionPaint);
        }
    }

    private void drawLine(Canvas canvas, StaticLayout staticLayout, int i, int i2, int i3) {
        staticLayout.getSelectionPath(i2, i3, this.path);
        if (this.path.lastBottom < staticLayout.getLineBottom(i)) {
            int lineBottom = staticLayout.getLineBottom(i);
            int lineTop = staticLayout.getLineTop(i);
            float f = lineBottom - lineTop;
            float f2 = lineTop;
            float f3 = this.path.lastBottom - f2;
            canvas.save();
            canvas.scale(1.0f, f / f3, 0.0f, f2);
            canvas.drawPath(this.path, this.selectionPaint);
            canvas.restore();
            return;
        }
        canvas.drawPath(this.path, this.selectionPaint);
    }

    private static class LayoutBlock {
        StaticLayout layout;
        float xOffset;
        float yOffset;

        private LayoutBlock() {
        }
    }

    protected void fillLayoutForOffset(int i, LayoutBlock layoutBlock) {
        fillLayoutForOffset(i, layoutBlock, false);
    }

    public static class ChatListTextSelectionHelper extends TextSelectionHelper<ChatMessageCell> {
        public static int TYPE_CAPTION = 1;
        public static int TYPE_DESCRIPTION = 2;
        public static int TYPE_MESSAGE;
        LongSparseArray<Animator> animatorSparseArray = new LongSparseArray<>();
        private boolean isDescription;
        private boolean maybeIsDescription;

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected int getLineHeight() {
            Cell cell = this.selectedView;
            if (cell == null || ((ChatMessageCell) cell).getMessageObject() == null) {
                return 0;
            }
            MessageObject messageObject = ((ChatMessageCell) this.selectedView).getMessageObject();
            StaticLayout captionLayout = null;
            if (this.isDescription) {
                captionLayout = ((ChatMessageCell) this.selectedView).getDescriptionlayout();
            } else if (((ChatMessageCell) this.selectedView).hasCaptionLayout()) {
                captionLayout = ((ChatMessageCell) this.selectedView).getCaptionLayout();
            } else {
                ArrayList<MessageObject.TextLayoutBlock> arrayList = messageObject.textLayoutBlocks;
                if (arrayList != null) {
                    captionLayout = arrayList.get(0).textLayout;
                }
            }
            if (captionLayout == null) {
                return 0;
            }
            return captionLayout.getLineBottom(0) - captionLayout.getLineTop(0);
        }

        public void setMessageObject(ChatMessageCell chatMessageCell) {
            ArrayList<MessageObject.TextLayoutBlock> arrayList;
            this.maybeSelectedView = chatMessageCell;
            MessageObject messageObject = chatMessageCell.getMessageObject();
            if (this.maybeIsDescription && chatMessageCell.getDescriptionlayout() != null) {
                Rect rect = this.textArea;
                int i = this.maybeTextX;
                rect.set(i, this.maybeTextY, chatMessageCell.getDescriptionlayout().getWidth() + i, this.maybeTextY + chatMessageCell.getDescriptionlayout().getHeight());
            } else if (chatMessageCell.hasCaptionLayout()) {
                Rect rect2 = this.textArea;
                int i2 = this.maybeTextX;
                rect2.set(i2, this.maybeTextY, chatMessageCell.getCaptionLayout().getWidth() + i2, this.maybeTextY + chatMessageCell.getCaptionLayout().getHeight());
            } else {
                if (messageObject == null || (arrayList = messageObject.textLayoutBlocks) == null || arrayList.size() <= 0) {
                    return;
                }
                MessageObject.TextLayoutBlock textLayoutBlock = messageObject.textLayoutBlocks.get(r7.size() - 1);
                Rect rect3 = this.textArea;
                int i3 = this.maybeTextX;
                rect3.set(i3, this.maybeTextY, textLayoutBlock.textLayout.getWidth() + i3, (int) (this.maybeTextY + textLayoutBlock.textYOffset + textLayoutBlock.textLayout.getHeight()));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public CharSequence getText(ChatMessageCell chatMessageCell, boolean z) {
            if (chatMessageCell == null || chatMessageCell.getMessageObject() == null) {
                return null;
            }
            if (!z ? this.isDescription : this.maybeIsDescription) {
                return chatMessageCell.getDescriptionlayout().getText();
            }
            if (chatMessageCell.hasCaptionLayout()) {
                return chatMessageCell.getCaptionLayout().getText();
            }
            return chatMessageCell.getMessageObject().messageText;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public void onTextSelected(ChatMessageCell chatMessageCell, ChatMessageCell chatMessageCell2) {
            final boolean z = chatMessageCell2 == null || !(chatMessageCell2.getMessageObject() == null || chatMessageCell2.getMessageObject().getId() == chatMessageCell.getMessageObject().getId());
            long id = chatMessageCell.getMessageObject().getId();
            this.selectedCellId = id;
            this.enterProgress = 0.0f;
            this.isDescription = this.maybeIsDescription;
            Animator animator = this.animatorSparseArray.get(id);
            if (animator != null) {
                animator.removeAllListeners();
                animator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Cells.TextSelectionHelper$ChatListTextSelectionHelper$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$onTextSelected$0(z, valueAnimator);
                }
            });
            valueAnimatorOfFloat.setDuration(250L);
            valueAnimatorOfFloat.start();
            this.animatorSparseArray.put(this.selectedCellId, valueAnimatorOfFloat);
            if (!z) {
                chatMessageCell.setSelectedBackgroundProgress(0.0f);
            }
            SharedConfig.removeTextSelectionHint();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextSelected$0(boolean z, ValueAnimator valueAnimator) {
            this.enterProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            TextSelectionHelper<Cell>.TextSelectionOverlay textSelectionOverlay = this.textSelectionOverlay;
            if (textSelectionOverlay != null) {
                textSelectionOverlay.invalidate();
            }
            Cell cell = this.selectedView;
            if (cell != null && ((ChatMessageCell) cell).getCurrentMessagesGroup() == null && z) {
                ((ChatMessageCell) this.selectedView).setSelectedBackgroundProgress(1.0f - this.enterProgress);
            }
        }

        public void draw(MessageObject messageObject, MessageObject.TextLayoutBlock textLayoutBlock, Canvas canvas) {
            MessageObject messageObject2;
            Cell cell = this.selectedView;
            if (cell == null || ((ChatMessageCell) cell).getMessageObject() == null || this.isDescription || (messageObject2 = ((ChatMessageCell) this.selectedView).getMessageObject()) == null || messageObject2.textLayoutBlocks == null || messageObject.getId() != this.selectedCellId) {
                return;
            }
            int i = this.selectionStart;
            int i2 = this.selectionEnd;
            if (messageObject2.textLayoutBlocks.size() > 1) {
                int i3 = textLayoutBlock.charactersOffset;
                if (i < i3) {
                    i = i3;
                }
                int i4 = textLayoutBlock.charactersEnd;
                if (i > i4) {
                    i = i4;
                }
                if (i2 < i3) {
                    i2 = i3;
                }
                if (i2 > i4) {
                    i2 = i4;
                }
            }
            if (i != i2) {
                if (messageObject2.isOutOwner()) {
                    this.selectionPaint.setColor(Theme.getColor(Theme.key_chat_outTextSelectionHighlight));
                } else {
                    this.selectionPaint.setColor(Theme.getColor(Theme.key_chat_inTextSelectionHighlight));
                }
                drawSelection(canvas, textLayoutBlock.textLayout, i, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public int getCharOffsetFromCord(int i, int i2, int i3, int i4, ChatMessageCell chatMessageCell, boolean z) {
            StaticLayout captionLayout;
            int i5 = 0;
            if (chatMessageCell == null) {
                return 0;
            }
            int i6 = i - i3;
            int lineBottom = i2 - i4;
            float f = 0.0f;
            if (z ? this.maybeIsDescription : this.isDescription) {
                captionLayout = chatMessageCell.getDescriptionlayout();
            } else if (chatMessageCell.hasCaptionLayout()) {
                captionLayout = chatMessageCell.getCaptionLayout();
            } else {
                MessageObject.TextLayoutBlock textLayoutBlock = chatMessageCell.getMessageObject().textLayoutBlocks.get(chatMessageCell.getMessageObject().textLayoutBlocks.size() - 1);
                captionLayout = textLayoutBlock.textLayout;
                f = textLayoutBlock.textYOffset;
            }
            if (lineBottom < 0) {
                lineBottom = 1;
            }
            if (lineBottom > captionLayout.getLineBottom(captionLayout.getLineCount() - 1) + f) {
                lineBottom = (int) ((f + captionLayout.getLineBottom(captionLayout.getLineCount() - 1)) - 1.0f);
            }
            fillLayoutForCoords(i6, lineBottom, chatMessageCell, this.layoutBlock, z);
            LayoutBlock layoutBlock = this.layoutBlock;
            StaticLayout staticLayout = layoutBlock.layout;
            if (staticLayout == null) {
                return -1;
            }
            int i7 = (int) (i6 - layoutBlock.xOffset);
            while (true) {
                if (i5 >= staticLayout.getLineCount()) {
                    i5 = -1;
                    break;
                }
                float f2 = lineBottom;
                if (f2 > this.layoutBlock.yOffset + staticLayout.getLineTop(i5) && f2 < this.layoutBlock.yOffset + staticLayout.getLineBottom(i5)) {
                    break;
                }
                i5++;
            }
            if (i5 >= 0) {
                return staticLayout.getOffsetForHorizontal(i5, i7);
            }
            return -1;
        }

        private void fillLayoutForCoords(int i, int i2, ChatMessageCell chatMessageCell, LayoutBlock layoutBlock, boolean z) {
            if (chatMessageCell == null) {
                return;
            }
            MessageObject messageObject = chatMessageCell.getMessageObject();
            if (!z ? this.isDescription : this.maybeIsDescription) {
                layoutBlock.layout = chatMessageCell.getDescriptionlayout();
                layoutBlock.xOffset = 0.0f;
                layoutBlock.yOffset = 0.0f;
                return;
            }
            if (chatMessageCell.hasCaptionLayout()) {
                layoutBlock.layout = chatMessageCell.getCaptionLayout();
                layoutBlock.xOffset = 0.0f;
                layoutBlock.yOffset = 0.0f;
                return;
            }
            for (int i3 = 0; i3 < messageObject.textLayoutBlocks.size(); i3++) {
                MessageObject.TextLayoutBlock textLayoutBlock = messageObject.textLayoutBlocks.get(i3);
                float f = i2;
                float f2 = textLayoutBlock.textYOffset;
                if (f >= f2 && f <= textLayoutBlock.height + f2) {
                    layoutBlock.layout = textLayoutBlock.textLayout;
                    layoutBlock.yOffset = f2;
                    layoutBlock.xOffset = -(textLayoutBlock.isRtl() ? (int) Math.ceil(messageObject.textXOffset) : 0);
                    return;
                }
            }
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected void fillLayoutForOffset(int i, LayoutBlock layoutBlock, boolean z) {
            ChatMessageCell chatMessageCell = (ChatMessageCell) (z ? this.maybeSelectedView : this.selectedView);
            if (chatMessageCell == null) {
                layoutBlock.layout = null;
                return;
            }
            MessageObject messageObject = chatMessageCell.getMessageObject();
            if (this.isDescription) {
                layoutBlock.layout = chatMessageCell.getDescriptionlayout();
                layoutBlock.yOffset = 0.0f;
                layoutBlock.xOffset = 0.0f;
                return;
            }
            if (chatMessageCell.hasCaptionLayout()) {
                layoutBlock.layout = chatMessageCell.getCaptionLayout();
                layoutBlock.yOffset = 0.0f;
                layoutBlock.xOffset = 0.0f;
                return;
            }
            ArrayList<MessageObject.TextLayoutBlock> arrayList = messageObject.textLayoutBlocks;
            if (arrayList == null) {
                layoutBlock.layout = null;
                return;
            }
            if (arrayList.size() == 1) {
                layoutBlock.layout = messageObject.textLayoutBlocks.get(0).textLayout;
                layoutBlock.yOffset = 0.0f;
                layoutBlock.xOffset = -(messageObject.textLayoutBlocks.get(0).isRtl() ? (int) Math.ceil(messageObject.textXOffset) : 0);
                return;
            }
            for (int i2 = 0; i2 < messageObject.textLayoutBlocks.size(); i2++) {
                MessageObject.TextLayoutBlock textLayoutBlock = messageObject.textLayoutBlocks.get(i2);
                if (i >= textLayoutBlock.charactersOffset && i <= textLayoutBlock.charactersEnd) {
                    layoutBlock.layout = messageObject.textLayoutBlocks.get(i2).textLayout;
                    layoutBlock.yOffset = messageObject.textLayoutBlocks.get(i2).textYOffset;
                    layoutBlock.xOffset = -(textLayoutBlock.isRtl() ? (int) Math.ceil(messageObject.textXOffset) : 0);
                    return;
                }
            }
            layoutBlock.layout = null;
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected void onExitSelectionMode(boolean z) {
            Cell cell = this.selectedView;
            if (cell == null || !((ChatMessageCell) cell).isDrawingSelectionBackground() || z) {
                return;
            }
            Cell cell2 = this.selectedView;
            final ChatMessageCell chatMessageCell = (ChatMessageCell) cell2;
            final long id = ((ChatMessageCell) cell2).getMessageObject().getId();
            Animator animator = this.animatorSparseArray.get(id);
            if (animator != null) {
                animator.removeAllListeners();
                animator.cancel();
            }
            chatMessageCell.setSelectedBackgroundProgress(0.01f);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.01f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Cells.TextSelectionHelper$ChatListTextSelectionHelper$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TextSelectionHelper.ChatListTextSelectionHelper.lambda$onExitSelectionMode$1(chatMessageCell, id, valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter(this) { // from class: org.rbmain.ui.Cells.TextSelectionHelper.ChatListTextSelectionHelper.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    chatMessageCell.setSelectedBackgroundProgress(0.0f);
                }
            });
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.start();
            this.animatorSparseArray.put(id, valueAnimatorOfFloat);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onExitSelectionMode$1(ChatMessageCell chatMessageCell, long j, ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (chatMessageCell.getMessageObject() == null || chatMessageCell.getMessageObject().getId() != j) {
                return;
            }
            chatMessageCell.setSelectedBackgroundProgress(fFloatValue);
        }

        public void onChatMessageCellAttached(ChatMessageCell chatMessageCell) {
            if (chatMessageCell.getMessageObject() == null || chatMessageCell.getMessageObject().getId() != this.selectedCellId) {
                return;
            }
            this.selectedView = chatMessageCell;
        }

        public void onChatMessageCellDetached(ChatMessageCell chatMessageCell) {
            if (chatMessageCell.getMessageObject() == null || chatMessageCell.getMessageObject().getId() != this.selectedCellId) {
                return;
            }
            this.selectedView = null;
        }

        public void drawCaption(boolean z, StaticLayout staticLayout, Canvas canvas) {
            if (this.isDescription) {
                return;
            }
            if (z) {
                this.selectionPaint.setColor(Theme.getColor(Theme.key_chat_outTextSelectionHighlight));
            } else {
                this.selectionPaint.setColor(Theme.getColor(Theme.key_chat_inTextSelectionHighlight));
            }
            drawSelection(canvas, staticLayout, this.selectionStart, this.selectionEnd);
        }

        public void drawDescription(boolean z, StaticLayout staticLayout, Canvas canvas) {
            if (this.isDescription) {
                if (z) {
                    this.selectionPaint.setColor(Theme.getColor(Theme.key_chat_outTextSelectionHighlight));
                } else {
                    this.selectionPaint.setColor(Theme.getColor(Theme.key_chat_inTextSelectionHighlight));
                }
                drawSelection(canvas, staticLayout, this.selectionStart, this.selectionEnd);
            }
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public void invalidate() {
            super.invalidate();
            Cell cell = this.selectedView;
            if (cell == null || ((ChatMessageCell) cell).getCurrentMessagesGroup() == null) {
                return;
            }
            this.parentView.invalidate();
        }

        public void cancelAllAnimators() {
            for (int i = 0; i < this.animatorSparseArray.size(); i++) {
                LongSparseArray<Animator> longSparseArray = this.animatorSparseArray;
                longSparseArray.get(longSparseArray.keyAt(i)).cancel();
            }
            this.animatorSparseArray.clear();
        }

        public void setIsDescription(boolean z) {
            this.maybeIsDescription = z;
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public void clear(boolean z) {
            super.clear(z);
            this.isDescription = false;
        }

        public int getTextSelectionType(ChatMessageCell chatMessageCell) {
            if (this.isDescription) {
                return TYPE_DESCRIPTION;
            }
            if (chatMessageCell.hasCaptionLayout()) {
                return TYPE_CAPTION;
            }
            return TYPE_MESSAGE;
        }

        public void updateTextPosition(int i, int i2) {
            if (this.textX == i && this.textY == i2) {
                return;
            }
            this.textX = i;
            this.textY = i2;
            invalidate();
        }

        public void checkDataChanged(MessageObject messageObject) {
            if (this.selectedCellId == messageObject.getId()) {
                clear(true);
            }
        }
    }

    public static class ArticleTextSelectionHelper extends TextSelectionHelper<ArticleSelectableView> {
        int endViewOffset;
        public LinearLayoutManager layoutManager;
        boolean startPeek;
        int startViewOffset;
        int startViewPosition = -1;
        int startViewChildPosition = -1;
        int endViewPosition = -1;
        int endViewChildPosition = -1;
        int maybeTextIndex = -1;
        SparseArray<CharSequence> textByPosition = new SparseArray<>();
        SparseArray<CharSequence> prefixTextByPosition = new SparseArray<>();
        SparseIntArray childCountByPosition = new SparseIntArray();
        public ArrayList<TextLayoutBlock> arrayList = new ArrayList<>();

        public ArticleTextSelectionHelper() {
            this.multiselect = true;
            this.showActionsAsPopupAlways = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public CharSequence getText(ArticleSelectableView articleSelectableView, boolean z) {
            int i;
            this.arrayList.clear();
            articleSelectableView.fillTextLayoutBlocks(this.arrayList);
            if (z) {
                i = this.maybeTextIndex;
            } else {
                i = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
            }
            return (this.arrayList.isEmpty() || i < 0) ? BuildConfig.FLAVOR : this.arrayList.get(i).getLayout().getText();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public int getCharOffsetFromCord(int i, int i2, int i3, int i4, ArticleSelectableView articleSelectableView, boolean z) {
            int i5;
            if (articleSelectableView == null) {
                return -1;
            }
            int width = i - i3;
            int lineBottom = i2 - i4;
            this.arrayList.clear();
            articleSelectableView.fillTextLayoutBlocks(this.arrayList);
            if (z) {
                i5 = this.maybeTextIndex;
            } else {
                i5 = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
            }
            StaticLayout layout = this.arrayList.get(i5).getLayout();
            if (width < 0) {
                width = 1;
            }
            if (lineBottom < 0) {
                lineBottom = 1;
            }
            if (width > layout.getWidth()) {
                width = layout.getWidth();
            }
            if (lineBottom > layout.getLineBottom(layout.getLineCount() - 1)) {
                lineBottom = layout.getLineBottom(layout.getLineCount() - 1) - 1;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= layout.getLineCount()) {
                    i6 = -1;
                    break;
                }
                if (lineBottom > layout.getLineTop(i6) && lineBottom < layout.getLineBottom(i6)) {
                    break;
                }
                i6++;
            }
            if (i6 >= 0) {
                return layout.getOffsetForHorizontal(i6, width);
            }
            return -1;
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected void fillLayoutForOffset(int i, LayoutBlock layoutBlock, boolean z) {
            this.arrayList.clear();
            ArticleSelectableView articleSelectableView = (ArticleSelectableView) (z ? this.maybeSelectedView : this.selectedView);
            if (articleSelectableView == null) {
                layoutBlock.layout = null;
                return;
            }
            articleSelectableView.fillTextLayoutBlocks(this.arrayList);
            if (z) {
                layoutBlock.layout = this.arrayList.get(this.maybeTextIndex).getLayout();
            } else {
                int i2 = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
                if (i2 < 0 || i2 >= this.arrayList.size()) {
                    layoutBlock.layout = null;
                    return;
                }
                layoutBlock.layout = this.arrayList.get(i2).getLayout();
            }
            layoutBlock.yOffset = 0.0f;
            layoutBlock.xOffset = 0.0f;
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected int getLineHeight() {
            if (this.selectedView == null) {
                return 0;
            }
            this.arrayList.clear();
            ((ArticleSelectableView) this.selectedView).fillTextLayoutBlocks(this.arrayList);
            int i = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
            if (i < 0 || i >= this.arrayList.size()) {
                return 0;
            }
            StaticLayout layout = this.arrayList.get(i).getLayout();
            int i2 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            for (int i3 = 0; i3 < layout.getLineCount(); i3++) {
                int lineBottom = layout.getLineBottom(i3) - layout.getLineTop(i3);
                if (lineBottom < i2) {
                    i2 = lineBottom;
                }
            }
            return i2;
        }

        public void trySelect(View view) {
            if (this.maybeSelectedView != null) {
                this.startSelectionRunnable.run();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setMaybeView(int i, int i2, View view) {
            if (view instanceof ArticleSelectableView) {
                this.capturedX = i;
                this.capturedY = i2;
                ArticleSelectableView articleSelectableView = (ArticleSelectableView) view;
                this.maybeSelectedView = articleSelectableView;
                int iFindClosestLayoutIndex = findClosestLayoutIndex(i, i2, articleSelectableView);
                this.maybeTextIndex = iFindClosestLayoutIndex;
                if (iFindClosestLayoutIndex < 0) {
                    this.maybeSelectedView = null;
                } else {
                    this.maybeTextX = this.arrayList.get(iFindClosestLayoutIndex).getX();
                    this.maybeTextY = this.arrayList.get(this.maybeTextIndex).getY();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int findClosestLayoutIndex(int i, int i2, ArticleSelectableView articleSelectableView) {
            int i3 = 0;
            if (articleSelectableView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) articleSelectableView;
                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                    View childAt = viewGroup.getChildAt(i4);
                    if (childAt instanceof ArticleSelectableView) {
                        float f = i2;
                        if (f > childAt.getY() && f < childAt.getY() + childAt.getHeight()) {
                            return findClosestLayoutIndex((int) (i - childAt.getX()), (int) (f - childAt.getY()), (ArticleSelectableView) childAt);
                        }
                    }
                }
            }
            this.arrayList.clear();
            articleSelectableView.fillTextLayoutBlocks(this.arrayList);
            if (this.arrayList.isEmpty()) {
                return -1;
            }
            int size = this.arrayList.size() - 1;
            int i5 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            int i6 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            int i7 = -1;
            while (true) {
                if (size < 0) {
                    i3 = i6;
                    size = i7;
                    break;
                }
                TextLayoutBlock textLayoutBlock = this.arrayList.get(size);
                int y = textLayoutBlock.getY();
                int height = textLayoutBlock.getLayout().getHeight() + y;
                if (i2 >= y && i2 < height) {
                    break;
                }
                int iMin = Math.min(Math.abs(i2 - y), Math.abs(i2 - height));
                if (iMin < i6) {
                    i7 = size;
                    i6 = iMin;
                }
                size--;
            }
            if (size < 0) {
                return -1;
            }
            int row = this.arrayList.get(size).getRow();
            if (row > 0 && i3 < AndroidUtilities.dp(24.0f)) {
                for (int size2 = this.arrayList.size() - 1; size2 >= 0; size2--) {
                    TextLayoutBlock textLayoutBlock2 = this.arrayList.get(size2);
                    if (textLayoutBlock2.getRow() == row) {
                        int x = textLayoutBlock2.getX();
                        int x2 = textLayoutBlock2.getX() + textLayoutBlock2.getLayout().getWidth();
                        if (i >= x && i <= x2) {
                            return size2;
                        }
                        int iMin2 = Math.min(Math.abs(i - x), Math.abs(i - x2));
                        if (iMin2 < i5) {
                            size = size2;
                            i5 = iMin2;
                        }
                    }
                }
            }
            return size;
        }

        public void draw(Canvas canvas, ArticleSelectableView articleSelectableView, int i) {
            this.selectionPaint.setColor(Theme.getColor(Theme.key_chat_inTextSelectionHighlight));
            int adapterPosition = getAdapterPosition(articleSelectableView);
            if (adapterPosition < 0) {
                return;
            }
            this.arrayList.clear();
            articleSelectableView.fillTextLayoutBlocks(this.arrayList);
            if (this.arrayList.isEmpty()) {
                return;
            }
            TextLayoutBlock textLayoutBlock = this.arrayList.get(i);
            int i2 = this.endViewOffset;
            int length = textLayoutBlock.getLayout().getText().length();
            if (i2 > length) {
                i2 = length;
            }
            int i3 = this.startViewPosition;
            if (adapterPosition == i3 && adapterPosition == this.endViewPosition) {
                int i4 = this.startViewChildPosition;
                int i5 = this.endViewChildPosition;
                if (i4 == i5 && i4 == i) {
                    drawSelection(canvas, textLayoutBlock.getLayout(), this.startViewOffset, i2);
                    return;
                }
                if (i == i4) {
                    drawSelection(canvas, textLayoutBlock.getLayout(), this.startViewOffset, length);
                    return;
                }
                if (i == i5) {
                    drawSelection(canvas, textLayoutBlock.getLayout(), 0, i2);
                    return;
                } else {
                    if (i <= i4 || i >= i5) {
                        return;
                    }
                    drawSelection(canvas, textLayoutBlock.getLayout(), 0, length);
                    return;
                }
            }
            if (adapterPosition == i3 && this.startViewChildPosition == i) {
                drawSelection(canvas, textLayoutBlock.getLayout(), this.startViewOffset, length);
                return;
            }
            int i6 = this.endViewPosition;
            if (adapterPosition == i6 && this.endViewChildPosition == i) {
                drawSelection(canvas, textLayoutBlock.getLayout(), 0, i2);
                return;
            }
            if ((adapterPosition <= i3 || adapterPosition >= i6) && ((adapterPosition != i3 || i <= this.startViewChildPosition) && (adapterPosition != i6 || i >= this.endViewChildPosition))) {
                return;
            }
            drawSelection(canvas, textLayoutBlock.getLayout(), 0, length);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int getAdapterPosition(ArticleSelectableView articleSelectableView) {
            ViewGroup viewGroup;
            View view = (View) articleSelectableView;
            ViewParent parent = view.getParent();
            while (true) {
                viewGroup = this.parentView;
                if (parent != viewGroup && parent != null) {
                    if (!(parent instanceof View)) {
                        parent = null;
                        break;
                    }
                    view = parent;
                    parent = view.getParent();
                } else {
                    break;
                }
            }
            if (parent == null) {
                return -1;
            }
            RecyclerListView recyclerListView = this.parentRecyclerView;
            if (recyclerListView != null) {
                return recyclerListView.getChildAdapterPosition(view);
            }
            return viewGroup.indexOfChild(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean isSelectable(View view) {
            if (!(view instanceof ArticleSelectableView)) {
                return false;
            }
            this.arrayList.clear();
            ((ArticleSelectableView) view).fillTextLayoutBlocks(this.arrayList);
            if (view instanceof ArticleViewer.BlockTableCell) {
                return true;
            }
            return !this.arrayList.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public void onTextSelected(ArticleSelectableView articleSelectableView, ArticleSelectableView articleSelectableView2) {
            int adapterPosition = getAdapterPosition(articleSelectableView);
            if (adapterPosition < 0) {
                return;
            }
            this.endViewPosition = adapterPosition;
            this.startViewPosition = adapterPosition;
            int i = this.maybeTextIndex;
            this.endViewChildPosition = i;
            this.startViewChildPosition = i;
            this.arrayList.clear();
            articleSelectableView.fillTextLayoutBlocks(this.arrayList);
            int size = this.arrayList.size();
            this.childCountByPosition.put(adapterPosition, size);
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = (i2 << 16) + adapterPosition;
                this.textByPosition.put(i3, this.arrayList.get(i2).getLayout().getText());
                this.prefixTextByPosition.put(i3, this.arrayList.get(i2).getPrefix());
            }
        }

        protected void onNewViewSelected(ArticleSelectableView articleSelectableView, ArticleSelectableView articleSelectableView2, int i) {
            int i2;
            int adapterPosition = getAdapterPosition(articleSelectableView2);
            int adapterPosition2 = articleSelectableView != null ? getAdapterPosition(articleSelectableView) : -1;
            invalidate();
            if (this.movingDirectionSettling && (i2 = this.startViewPosition) == this.endViewPosition) {
                if (adapterPosition == i2) {
                    if (i < this.startViewChildPosition) {
                        this.startViewChildPosition = i;
                        pickStartView();
                        this.movingHandleStart = true;
                        int i3 = this.selectionEnd;
                        this.startViewOffset = i3;
                        this.selectionStart = i3 - 1;
                    } else {
                        this.endViewChildPosition = i;
                        pickEndView();
                        this.movingHandleStart = false;
                        this.endViewOffset = 0;
                    }
                } else if (adapterPosition < i2) {
                    this.startViewPosition = adapterPosition;
                    this.startViewChildPosition = i;
                    pickStartView();
                    this.movingHandleStart = true;
                    int i4 = this.selectionEnd;
                    this.startViewOffset = i4;
                    this.selectionStart = i4 - 1;
                } else {
                    this.endViewPosition = adapterPosition;
                    this.endViewChildPosition = i;
                    pickEndView();
                    this.movingHandleStart = false;
                    this.endViewOffset = 0;
                }
            } else if (this.movingHandleStart) {
                if (adapterPosition == adapterPosition2) {
                    int i5 = this.endViewChildPosition;
                    if (i <= i5 || adapterPosition < this.endViewPosition) {
                        this.startViewPosition = adapterPosition;
                        this.startViewChildPosition = i;
                        pickStartView();
                        this.startViewOffset = this.selectionEnd;
                    } else {
                        this.endViewPosition = adapterPosition;
                        this.startViewChildPosition = i5;
                        this.endViewChildPosition = i;
                        this.startViewOffset = this.endViewOffset;
                        pickEndView();
                        this.endViewOffset = 0;
                        this.movingHandleStart = false;
                    }
                } else if (adapterPosition <= this.endViewPosition) {
                    this.startViewPosition = adapterPosition;
                    this.startViewChildPosition = i;
                    pickStartView();
                    this.startViewOffset = this.selectionEnd;
                } else {
                    this.endViewPosition = adapterPosition;
                    this.startViewChildPosition = this.endViewChildPosition;
                    this.endViewChildPosition = i;
                    this.startViewOffset = this.endViewOffset;
                    pickEndView();
                    this.endViewOffset = 0;
                    this.movingHandleStart = false;
                }
            } else if (adapterPosition == adapterPosition2) {
                int i6 = this.startViewChildPosition;
                if (i >= i6 || adapterPosition > this.startViewPosition) {
                    this.endViewPosition = adapterPosition;
                    this.endViewChildPosition = i;
                    pickEndView();
                    this.endViewOffset = 0;
                } else {
                    this.startViewPosition = adapterPosition;
                    this.endViewChildPosition = i6;
                    this.startViewChildPosition = i;
                    this.endViewOffset = this.startViewOffset;
                    pickStartView();
                    this.movingHandleStart = true;
                    this.startViewOffset = this.selectionEnd;
                }
            } else if (adapterPosition >= this.startViewPosition) {
                this.endViewPosition = adapterPosition;
                this.endViewChildPosition = i;
                pickEndView();
                this.endViewOffset = 0;
            } else {
                this.startViewPosition = adapterPosition;
                this.endViewChildPosition = this.startViewChildPosition;
                this.startViewChildPosition = i;
                this.endViewOffset = this.startViewOffset;
                pickStartView();
                this.movingHandleStart = true;
                this.startViewOffset = this.selectionEnd;
            }
            this.arrayList.clear();
            articleSelectableView2.fillTextLayoutBlocks(this.arrayList);
            int size = this.arrayList.size();
            this.childCountByPosition.put(adapterPosition, size);
            for (int i7 = 0; i7 < size; i7++) {
                int i8 = (i7 << 16) + adapterPosition;
                this.textByPosition.put(i8, this.arrayList.get(i7).getLayout().getText());
                this.prefixTextByPosition.put(i8, this.arrayList.get(i7).getPrefix());
            }
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected void pickEndView() {
            ArticleSelectableView articleSelectableView;
            if (isSelectionMode()) {
                this.startPeek = false;
                int i = this.endViewPosition;
                if (i >= 0) {
                    LinearLayoutManager linearLayoutManager = this.layoutManager;
                    if (linearLayoutManager != null) {
                        articleSelectableView = (ArticleSelectableView) linearLayoutManager.findViewByPosition(i);
                    } else {
                        articleSelectableView = i < this.parentView.getChildCount() ? (ArticleSelectableView) this.parentView.getChildAt(this.endViewPosition) : null;
                    }
                    if (articleSelectableView == null) {
                        this.selectedView = null;
                        return;
                    }
                    this.selectedView = articleSelectableView;
                    if (this.startViewPosition != this.endViewPosition || this.startViewChildPosition != this.endViewChildPosition) {
                        this.selectionStart = 0;
                    } else {
                        this.selectionStart = this.startViewOffset;
                    }
                    this.selectionEnd = this.endViewOffset;
                    CharSequence text = getText(articleSelectableView, false);
                    if (this.selectionEnd > text.length()) {
                        this.selectionEnd = text.length();
                    }
                    this.arrayList.clear();
                    ((ArticleSelectableView) this.selectedView).fillTextLayoutBlocks(this.arrayList);
                    if (this.arrayList.isEmpty()) {
                        return;
                    }
                    this.textX = this.arrayList.get(this.endViewChildPosition).getX();
                    this.textY = this.arrayList.get(this.endViewChildPosition).getY();
                }
            }
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected void pickStartView() {
            ArticleSelectableView articleSelectableView;
            if (isSelectionMode()) {
                this.startPeek = true;
                int i = this.startViewPosition;
                if (i >= 0) {
                    LinearLayoutManager linearLayoutManager = this.layoutManager;
                    if (linearLayoutManager != null) {
                        articleSelectableView = (ArticleSelectableView) linearLayoutManager.findViewByPosition(i);
                    } else {
                        articleSelectableView = this.endViewPosition < this.parentView.getChildCount() ? (ArticleSelectableView) this.parentView.getChildAt(this.startViewPosition) : null;
                    }
                    if (articleSelectableView == null) {
                        this.selectedView = null;
                        return;
                    }
                    this.selectedView = articleSelectableView;
                    if (this.startViewPosition != this.endViewPosition || this.startViewChildPosition != this.endViewChildPosition) {
                        this.selectionEnd = getText(articleSelectableView, false).length();
                    } else {
                        this.selectionEnd = this.endViewOffset;
                    }
                    this.selectionStart = this.startViewOffset;
                    this.arrayList.clear();
                    ((ArticleSelectableView) this.selectedView).fillTextLayoutBlocks(this.arrayList);
                    if (this.arrayList.isEmpty()) {
                        return;
                    }
                    this.textX = this.arrayList.get(this.startViewChildPosition).getX();
                    this.textY = this.arrayList.get(this.startViewChildPosition).getY();
                }
            }
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected void onOffsetChanged() {
            int adapterPosition = getAdapterPosition((ArticleSelectableView) this.selectedView);
            int i = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
            if (adapterPosition == this.startViewPosition && i == this.startViewChildPosition) {
                this.startViewOffset = this.selectionStart;
            }
            if (adapterPosition == this.endViewPosition && i == this.endViewChildPosition) {
                this.endViewOffset = this.selectionEnd;
            }
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public void invalidate() {
            super.invalidate();
            for (int i = 0; i < this.parentView.getChildCount(); i++) {
                this.parentView.getChildAt(i).invalidate();
            }
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public void clear(boolean z) {
            super.clear(z);
            this.startViewPosition = -1;
            this.endViewPosition = -1;
            this.startViewChildPosition = -1;
            this.endViewChildPosition = -1;
            this.textByPosition.clear();
            this.childCountByPosition.clear();
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected CharSequence getTextForCopy() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i = this.startViewPosition;
            while (true) {
                int i2 = this.endViewPosition;
                if (i > i2) {
                    break;
                }
                int i3 = this.startViewPosition;
                if (i == i3) {
                    int i4 = i3 == i2 ? this.endViewChildPosition : this.childCountByPosition.get(i) - 1;
                    for (int i5 = this.startViewChildPosition; i5 <= i4; i5++) {
                        int i6 = (i5 << 16) + i;
                        CharSequence charSequence = this.textByPosition.get(i6);
                        if (charSequence != null) {
                            int i7 = this.startViewPosition;
                            int i8 = this.endViewPosition;
                            if (i7 == i8 && i5 == this.endViewChildPosition && i5 == this.startViewChildPosition) {
                                int i9 = this.endViewOffset;
                                int length = this.startViewOffset;
                                if (i9 >= length) {
                                    length = i9;
                                    i9 = length;
                                }
                                if (i9 < charSequence.length()) {
                                    if (length > charSequence.length()) {
                                        length = charSequence.length();
                                    }
                                    spannableStringBuilder.append(charSequence.subSequence(i9, length));
                                    spannableStringBuilder.append('\n');
                                }
                            } else if (i7 == i8 && i5 == this.endViewChildPosition) {
                                CharSequence charSequence2 = this.prefixTextByPosition.get(i6);
                                if (charSequence2 != null) {
                                    spannableStringBuilder.append(charSequence2).append(' ');
                                }
                                int length2 = this.endViewOffset;
                                if (length2 > charSequence.length()) {
                                    length2 = charSequence.length();
                                }
                                spannableStringBuilder.append(charSequence.subSequence(0, length2));
                                spannableStringBuilder.append('\n');
                            } else if (i5 == this.startViewChildPosition) {
                                int i10 = this.startViewOffset;
                                if (i10 < charSequence.length()) {
                                    spannableStringBuilder.append(charSequence.subSequence(i10, charSequence.length()));
                                    spannableStringBuilder.append('\n');
                                }
                            } else {
                                CharSequence charSequence3 = this.prefixTextByPosition.get(i6);
                                if (charSequence3 != null) {
                                    spannableStringBuilder.append(charSequence3).append(' ');
                                }
                                spannableStringBuilder.append(charSequence);
                                spannableStringBuilder.append('\n');
                            }
                        }
                    }
                } else if (i == i2) {
                    for (int i11 = 0; i11 <= this.endViewChildPosition; i11++) {
                        int i12 = (i11 << 16) + i;
                        CharSequence charSequence4 = this.textByPosition.get(i12);
                        if (charSequence4 != null) {
                            if (this.startViewPosition == this.endViewPosition && i11 == this.endViewChildPosition && i11 == this.startViewChildPosition) {
                                int length3 = this.endViewOffset;
                                int i13 = this.startViewOffset;
                                if (i13 < charSequence4.length()) {
                                    if (length3 > charSequence4.length()) {
                                        length3 = charSequence4.length();
                                    }
                                    spannableStringBuilder.append(charSequence4.subSequence(i13, length3));
                                    spannableStringBuilder.append('\n');
                                }
                            } else if (i11 == this.endViewChildPosition) {
                                CharSequence charSequence5 = this.prefixTextByPosition.get(i12);
                                if (charSequence5 != null) {
                                    spannableStringBuilder.append(charSequence5).append(' ');
                                }
                                int length4 = this.endViewOffset;
                                if (length4 > charSequence4.length()) {
                                    length4 = charSequence4.length();
                                }
                                spannableStringBuilder.append(charSequence4.subSequence(0, length4));
                                spannableStringBuilder.append('\n');
                            } else {
                                CharSequence charSequence6 = this.prefixTextByPosition.get(i12);
                                if (charSequence6 != null) {
                                    spannableStringBuilder.append(charSequence6).append(' ');
                                }
                                spannableStringBuilder.append(charSequence4);
                                spannableStringBuilder.append('\n');
                            }
                        }
                    }
                } else {
                    int i14 = this.childCountByPosition.get(i);
                    for (int i15 = this.startViewChildPosition; i15 < i14; i15++) {
                        int i16 = (i15 << 16) + i;
                        CharSequence charSequence7 = this.prefixTextByPosition.get(i16);
                        if (charSequence7 != null) {
                            spannableStringBuilder.append(charSequence7).append(' ');
                        }
                        spannableStringBuilder.append(this.textByPosition.get(i16));
                        spannableStringBuilder.append('\n');
                    }
                }
                i++;
            }
            if (spannableStringBuilder.length() <= 0) {
                return null;
            }
            for (IgnoreCopySpannable ignoreCopySpannable : (IgnoreCopySpannable[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, IgnoreCopySpannable.class)) {
                spannableStringBuilder.delete(spannableStringBuilder.getSpanStart(ignoreCopySpannable), spannableStringBuilder.getSpanEnd(ignoreCopySpannable));
            }
            return spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1);
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected boolean selectLayout(int i, int i2) {
            if (!this.multiselect) {
                return false;
            }
            if (i2 <= ((ArticleSelectableView) this.selectedView).getTop() || i2 >= ((ArticleSelectableView) this.selectedView).getBottom()) {
                int childCount = this.parentView.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (isSelectable(this.parentView.getChildAt(i3))) {
                        ArticleSelectableView articleSelectableView = (ArticleSelectableView) this.parentView.getChildAt(i3);
                        if (i2 > articleSelectableView.getTop() && i2 < articleSelectableView.getBottom()) {
                            int iFindClosestLayoutIndex = findClosestLayoutIndex((int) (i - articleSelectableView.getX()), (int) (i2 - articleSelectableView.getY()), articleSelectableView);
                            if (iFindClosestLayoutIndex < 0) {
                                return false;
                            }
                            onNewViewSelected((ArticleSelectableView) this.selectedView, articleSelectableView, iFindClosestLayoutIndex);
                            this.selectedView = articleSelectableView;
                            return true;
                        }
                    }
                }
                return false;
            }
            int i4 = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
            int iFindClosestLayoutIndex2 = findClosestLayoutIndex((int) (i - ((ArticleSelectableView) this.selectedView).getX()), (int) (i2 - ((ArticleSelectableView) this.selectedView).getY()), (ArticleSelectableView) this.selectedView);
            if (iFindClosestLayoutIndex2 == i4 || iFindClosestLayoutIndex2 < 0) {
                return false;
            }
            Cell cell = this.selectedView;
            onNewViewSelected((ArticleSelectableView) cell, (ArticleSelectableView) cell, iFindClosestLayoutIndex2);
            return true;
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected boolean canSelect(int i) {
            if (this.startViewPosition == this.endViewPosition && this.startViewChildPosition == this.endViewChildPosition) {
                return super.canSelect(i);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        public void jumpToLine(int i, int i2, boolean z, float f, float f2, ArticleSelectableView articleSelectableView) {
            if (z && articleSelectableView == this.selectedView && f2 == f) {
                if (this.movingHandleStart) {
                    this.selectionStart = i;
                    return;
                } else {
                    this.selectionEnd = i;
                    return;
                }
            }
            super.jumpToLine(i, i2, z, f, f2, (float) articleSelectableView);
        }

        @Override // org.rbmain.ui.Cells.TextSelectionHelper
        protected boolean canShowActions() {
            LinearLayoutManager linearLayoutManager = this.layoutManager;
            if (linearLayoutManager == null) {
                return true;
            }
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
            int i = this.startViewPosition;
            if ((iFindFirstVisibleItemPosition < i || iFindFirstVisibleItemPosition > this.endViewPosition) && (iFindLastVisibleItemPosition < i || iFindLastVisibleItemPosition > this.endViewPosition)) {
                return i >= iFindFirstVisibleItemPosition && this.endViewPosition <= iFindLastVisibleItemPosition;
            }
            return true;
        }
    }

    private static class PathWithSavedBottom extends Path {
        float lastBottom;

        private PathWithSavedBottom() {
            this.lastBottom = 0.0f;
        }

        @Override // android.graphics.Path
        public void reset() {
            super.reset();
            this.lastBottom = 0.0f;
        }

        @Override // android.graphics.Path
        public void addRect(float f, float f2, float f3, float f4, Path.Direction direction) {
            super.addRect(f, f2, f3, f4, direction);
            if (f4 > this.lastBottom) {
                this.lastBottom = f4;
            }
        }
    }

    public void setKeyboardSize(int i) {
        this.keyboardSize = i;
        invalidate();
    }
}
