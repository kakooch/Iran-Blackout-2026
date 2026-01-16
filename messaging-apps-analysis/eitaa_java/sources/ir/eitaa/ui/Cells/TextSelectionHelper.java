package ir.eitaa.ui.Cells;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.zxing.common.detector.MathUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ArticleViewer;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import ir.eitaa.ui.Cells.TextSelectionHelper.SelectableView;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
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
    protected int selectedCellId;
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
    private Runnable scrollRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.TextSelectionHelper.1
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
                        } else if (TextSelectionHelper.this.selectedView.getTop() + lineHeight > TextSelectionHelper.this.getParentTopPadding()) {
                            lineHeight = (-TextSelectionHelper.this.selectedView.getTop()) + TextSelectionHelper.this.getParentTopPadding();
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
    final Runnable startSelectionRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.TextSelectionHelper.2
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
    private final Runnable hideActionsRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.TextSelectionHelper.3
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
        void fillTextLayoutBlocks(ArrayList<TextLayoutBlock> blocks);
    }

    public static class Callback {
        public void onStateChanged(boolean isSelected) {
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

    protected abstract void fillLayoutForOffset(int offset, LayoutBlock layoutBlock, boolean maybe);

    protected abstract int getCharOffsetFromCord(int x, int y, int offsetX, int offsetY, Cell view, boolean maybe);

    protected abstract int getLineHeight();

    public int getParentTopPadding() {
        return 0;
    }

    protected Theme.ResourcesProvider getResourcesProvider() {
        return null;
    }

    protected abstract CharSequence getText(Cell view, boolean maybe);

    protected void onExitSelectionMode(boolean didAction) {
    }

    protected void onOffsetChanged() {
    }

    protected abstract void onTextSelected(Cell newView, Cell oldView);

    protected void pickEndView() {
    }

    protected void pickStartView() {
    }

    protected boolean selectLayout(int x, int y) {
        return false;
    }

    public TextSelectionHelper() {
        this.path = new PathWithSavedBottom();
        this.layoutBlock = new LayoutBlock();
    }

    public void setParentView(ViewGroup view) {
        if (view instanceof RecyclerListView) {
            this.parentRecyclerView = (RecyclerListView) view;
        }
        this.parentView = view;
    }

    public void setMaybeTextCord(int x, int y) {
        this.maybeTextX = x;
        this.maybeTextY = y;
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.capturedX = (int) event.getX();
            this.capturedY = (int) event.getY();
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
                int y = (int) event.getY();
                int x = (int) event.getX();
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
    public void showMagnifier(int x) {
        int x2;
        int x3;
        if (Build.VERSION.SDK_INT < 28 || this.selectedView == null || this.isOneTouch || !this.movingHandle || this.textSelectionOverlay == null) {
            return;
        }
        int i = this.movingHandleStart ? this.selectionStart : this.selectionEnd;
        fillLayoutForOffset(i, this.layoutBlock);
        StaticLayout staticLayout = this.layoutBlock.layout;
        if (staticLayout == null) {
            return;
        }
        int lineForOffset = staticLayout.getLineForOffset(i);
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
            x3 = (int) cell.getX();
            x2 = ((int) this.selectedView.getX()) + this.selectedView.getMeasuredWidth();
        } else {
            int x4 = (int) (cell.getX() + this.textX + staticLayout.getLineLeft(lineForOffset));
            x2 = (int) (this.selectedView.getX() + this.textX + staticLayout.getLineRight(lineForOffset));
            x3 = x4;
        }
        if (x < x3) {
            x = x3;
        } else if (x > x2) {
            x = x2;
        }
        this.magnifier.show(x, this.magnifierYanimated + (lineBottom * 1.5f) + AndroidUtilities.dp(8.0f));
        this.magnifier.update();
    }

    protected void showHandleViews() {
        if (this.handleViewProgress == 1.0f || this.textSelectionOverlay == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$TextSelectionHelper$JjlxBB3xXnS887NT6fwFQA-jHLk
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$showHandleViews$0$TextSelectionHelper(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showHandleViews$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showHandleViews$0$TextSelectionHelper(ValueAnimator valueAnimator) {
        this.handleViewProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.textSelectionOverlay.invalidate();
    }

    public boolean isSelectionMode() {
        return this.selectionStart >= 0 && this.selectionEnd >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showActions() {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.TextSelectionHelper.showActions():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showActions$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$showActions$1$TextSelectionHelper(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.popupWindow) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.popupRect);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showActions$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showActions$2$TextSelectionHelper(View view) {
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

    public void checkSelectionCancel(MotionEvent e) {
        if (e.getAction() == 1 || e.getAction() == 3) {
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

    public void clear(boolean instant) {
        onExitSelectionMode(instant);
        this.selectionStart = -1;
        this.selectionEnd = -1;
        hideMagnifier();
        hideActions();
        invalidate();
        this.selectedView = null;
        this.selectedCellId = 0;
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

    public void setCallback(Callback listener) {
        this.callback = listener;
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

    public void setTopOffset(int topOffset) {
        this.topOffset = topOffset;
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

        public boolean checkOnTap(MotionEvent event) {
            if (TextSelectionHelper.this.isSelectionMode() && !TextSelectionHelper.this.movingHandle) {
                int action = event.getAction();
                if (action == 0) {
                    this.pressedX = event.getX();
                    this.pressedY = event.getY();
                    this.pressedTime = System.currentTimeMillis();
                } else if (action == 1 && System.currentTimeMillis() - this.pressedTime < 200 && MathUtils.distance((int) this.pressedX, (int) this.pressedY, (int) event.getX(), (int) event.getY()) < TextSelectionHelper.this.touchSlop) {
                    TextSelectionHelper.this.hideActions();
                    TextSelectionHelper.this.clear();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:278:0x04f5  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00f3  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0128  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r22) {
            /*
                Method dump skipped, instructions count: 1546
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.TextSelectionHelper.TextSelectionOverlay.onTouchEvent(android.view.MotionEvent):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x018c  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r19) {
            /*
                Method dump skipped, instructions count: 892
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.TextSelectionHelper.TextSelectionOverlay.onDraw(android.graphics.Canvas):void");
        }
    }

    protected void jumpToLine(int newSelection, int nextWhitespace, boolean viewChanged, float newYoffset, float oldYoffset, Cell oldSelectedView) {
        int i;
        int i2;
        if (this.movingHandleStart) {
            this.selectionStart = nextWhitespace;
            if (!viewChanged && nextWhitespace > (i2 = this.selectionEnd)) {
                this.selectionEnd = nextWhitespace;
                this.selectionStart = i2;
                this.movingHandleStart = false;
            }
            this.snap = true;
            return;
        }
        this.selectionEnd = nextWhitespace;
        if (!viewChanged && (i = this.selectionStart) > nextWhitespace) {
            this.selectionEnd = i;
            this.selectionStart = nextWhitespace;
            this.movingHandleStart = true;
        }
        this.snap = true;
    }

    protected boolean canSelect(int newSelection) {
        return (newSelection == this.selectionStart || newSelection == this.selectionEnd) ? false : true;
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
        final ActionMode.Callback callback = new ActionMode.Callback() { // from class: ir.eitaa.ui.Cells.TextSelectionHelper.4
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(0, R.id.copy, 0, R.string.copy);
                menu.add(0, R.id.selectAll, 1, R.string.selectAll);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
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
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if (!TextSelectionHelper.this.isSelectionMode()) {
                    return true;
                }
                int itemId = item.getItemId();
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
            public void onDestroyActionMode(ActionMode mode) {
                if (Build.VERSION.SDK_INT < 23) {
                    TextSelectionHelper.this.clear();
                }
            }
        };
        return Build.VERSION.SDK_INT >= 23 ? new ActionMode.Callback2() { // from class: ir.eitaa.ui.Cells.TextSelectionHelper.5
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return callback.onCreateActionMode(mode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return callback.onPrepareActionMode(mode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return callback.onActionItemClicked(mode, item);
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
                callback.onDestroyActionMode(mode);
            }

            @Override // android.view.ActionMode.Callback2
            public void onGetContentRect(ActionMode mode, View view, Rect outRect) {
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
                    outRect.set(Math.min(i, width), i2, Math.max(i, width), i2 + 1);
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

    protected int[] offsetToCord(int offset) {
        fillLayoutForOffset(offset, this.layoutBlock);
        StaticLayout staticLayout = this.layoutBlock.layout;
        if (staticLayout == null || offset > staticLayout.getText().length()) {
            return this.tmpCoord;
        }
        int lineForOffset = staticLayout.getLineForOffset(offset);
        this.tmpCoord[0] = (int) (staticLayout.getPrimaryHorizontal(offset) + this.layoutBlock.xOffset);
        this.tmpCoord[1] = staticLayout.getLineBottom(lineForOffset);
        int[] iArr = this.tmpCoord;
        iArr[1] = (int) (iArr[1] + this.layoutBlock.yOffset);
        return iArr;
    }

    protected void drawSelection(Canvas canvas, StaticLayout layout, int selectionStart, int selectionEnd) {
        float lineRight;
        int lineForOffset = layout.getLineForOffset(selectionStart);
        int lineForOffset2 = layout.getLineForOffset(selectionEnd);
        if (lineForOffset == lineForOffset2) {
            drawLine(canvas, layout, lineForOffset, selectionStart, selectionEnd);
            return;
        }
        int lineEnd = layout.getLineEnd(lineForOffset);
        if (layout.getParagraphDirection(lineForOffset) != -1 && lineEnd > 0) {
            lineEnd--;
            CharSequence text = layout.getText();
            int primaryHorizontal = (int) layout.getPrimaryHorizontal(lineEnd);
            if (layout.isRtlCharAt(lineEnd)) {
                int i = lineEnd;
                while (layout.isRtlCharAt(i) && i != 0) {
                    i--;
                }
                lineRight = layout.getLineForOffset(i) == layout.getLineForOffset(lineEnd) ? layout.getPrimaryHorizontal(i + 1) : layout.getLineLeft(lineForOffset);
            } else {
                lineRight = layout.getLineRight(lineForOffset);
            }
            int i2 = (int) lineRight;
            int iMin = Math.min(primaryHorizontal, i2);
            int iMax = Math.max(primaryHorizontal, i2);
            if (lineEnd > 0 && lineEnd < text.length() && !Character.isWhitespace(text.charAt(lineEnd - 1))) {
                canvas.drawRect(iMin, layout.getLineTop(lineForOffset), iMax, layout.getLineBottom(lineForOffset), this.selectionPaint);
            }
        }
        drawLine(canvas, layout, lineForOffset, selectionStart, lineEnd);
        drawLine(canvas, layout, lineForOffset2, layout.getLineStart(lineForOffset2), selectionEnd);
        while (true) {
            lineForOffset++;
            if (lineForOffset >= lineForOffset2) {
                return;
            }
            int lineLeft = (int) layout.getLineLeft(lineForOffset);
            int lineRight2 = (int) layout.getLineRight(lineForOffset);
            canvas.drawRect(Math.min(lineLeft, lineRight2), layout.getLineTop(lineForOffset), Math.max(lineLeft, lineRight2), layout.getLineBottom(lineForOffset), this.selectionPaint);
        }
    }

    private void drawLine(Canvas canvas, StaticLayout layout, int line, int start, int end) {
        layout.getSelectionPath(start, end, this.path);
        if (this.path.lastBottom < layout.getLineBottom(line)) {
            int lineBottom = layout.getLineBottom(line);
            int lineTop = layout.getLineTop(line);
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

    protected void fillLayoutForOffset(int offset, LayoutBlock layoutBlock) {
        fillLayoutForOffset(offset, layoutBlock, false);
    }

    public static class ChatListTextSelectionHelper extends TextSelectionHelper<ChatMessageCell> {
        public static int TYPE_CAPTION = 1;
        public static int TYPE_DESCRIPTION = 2;
        public static int TYPE_MESSAGE;
        SparseArray<Animator> animatorSparseArray = new SparseArray<>();
        private boolean isDescription;
        private boolean maybeIsDescription;

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
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
        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public CharSequence getText(ChatMessageCell cell, boolean maybe) {
            if (cell == null || cell.getMessageObject() == null) {
                return null;
            }
            if (!maybe ? this.isDescription : this.maybeIsDescription) {
                return cell.getDescriptionlayout().getText();
            }
            if (cell.hasCaptionLayout()) {
                return cell.getCaptionLayout().getText();
            }
            return cell.getMessageObject().messageText;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public void onTextSelected(ChatMessageCell newView, ChatMessageCell oldView) {
            final boolean z = oldView == null || !(oldView.getMessageObject() == null || oldView.getMessageObject().getId() == newView.getMessageObject().getId());
            int id = newView.getMessageObject().getId();
            this.selectedCellId = id;
            this.enterProgress = 0.0f;
            this.isDescription = this.maybeIsDescription;
            Animator animator = this.animatorSparseArray.get(id);
            if (animator != null) {
                animator.removeAllListeners();
                animator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$TextSelectionHelper$ChatListTextSelectionHelper$NCwITSuslSHtldHQWekJHCLxUzU
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$onTextSelected$0$TextSelectionHelper$ChatListTextSelectionHelper(z, valueAnimator);
                }
            });
            valueAnimatorOfFloat.setDuration(250L);
            valueAnimatorOfFloat.start();
            this.animatorSparseArray.put(this.selectedCellId, valueAnimatorOfFloat);
            if (!z) {
                newView.setSelectedBackgroundProgress(0.0f);
            }
            SharedConfig.removeTextSelectionHint();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onTextSelected$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onTextSelected$0$TextSelectionHelper$ChatListTextSelectionHelper(boolean z, ValueAnimator valueAnimator) {
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

        public void draw(MessageObject messageObject, MessageObject.TextLayoutBlock block, Canvas canvas) {
            MessageObject messageObject2;
            Cell cell = this.selectedView;
            if (cell == null || ((ChatMessageCell) cell).getMessageObject() == null || this.isDescription || (messageObject2 = ((ChatMessageCell) this.selectedView).getMessageObject()) == null || messageObject2.textLayoutBlocks == null || messageObject.getId() != this.selectedCellId) {
                return;
            }
            int i = this.selectionStart;
            int i2 = this.selectionEnd;
            if (messageObject2.textLayoutBlocks.size() > 1) {
                int i3 = block.charactersOffset;
                if (i < i3) {
                    i = i3;
                }
                int i4 = block.charactersEnd;
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
                    this.selectionPaint.setColor(getThemedColor("chat_outTextSelectionHighlight"));
                } else {
                    this.selectionPaint.setColor(getThemedColor("chat_inTextSelectionHighlight"));
                }
                drawSelection(canvas, block.textLayout, i, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public int getCharOffsetFromCord(int x, int y, int offsetX, int offsetY, ChatMessageCell cell, boolean maybe) {
            StaticLayout captionLayout;
            int i = 0;
            if (cell == null) {
                return 0;
            }
            int i2 = x - offsetX;
            int lineBottom = y - offsetY;
            float f = 0.0f;
            if (maybe ? this.maybeIsDescription : this.isDescription) {
                captionLayout = cell.getDescriptionlayout();
            } else if (cell.hasCaptionLayout()) {
                captionLayout = cell.getCaptionLayout();
            } else {
                MessageObject.TextLayoutBlock textLayoutBlock = cell.getMessageObject().textLayoutBlocks.get(cell.getMessageObject().textLayoutBlocks.size() - 1);
                captionLayout = textLayoutBlock.textLayout;
                f = textLayoutBlock.textYOffset;
            }
            if (lineBottom < 0) {
                lineBottom = 1;
            }
            if (lineBottom > captionLayout.getLineBottom(captionLayout.getLineCount() - 1) + f) {
                lineBottom = (int) ((f + captionLayout.getLineBottom(captionLayout.getLineCount() - 1)) - 1.0f);
            }
            fillLayoutForCoords(i2, lineBottom, cell, this.layoutBlock, maybe);
            LayoutBlock layoutBlock = this.layoutBlock;
            StaticLayout staticLayout = layoutBlock.layout;
            if (staticLayout == null) {
                return -1;
            }
            int i3 = (int) (i2 - layoutBlock.xOffset);
            while (true) {
                if (i >= staticLayout.getLineCount()) {
                    i = -1;
                    break;
                }
                float f2 = lineBottom;
                if (f2 > this.layoutBlock.yOffset + staticLayout.getLineTop(i) && f2 < this.layoutBlock.yOffset + staticLayout.getLineBottom(i)) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                return staticLayout.getOffsetForHorizontal(i, i3);
            }
            return -1;
        }

        private void fillLayoutForCoords(int x, int y, ChatMessageCell cell, LayoutBlock layoutBlock, boolean maybe) {
            if (cell == null) {
                return;
            }
            MessageObject messageObject = cell.getMessageObject();
            if (!maybe ? this.isDescription : this.maybeIsDescription) {
                layoutBlock.layout = cell.getDescriptionlayout();
                layoutBlock.xOffset = 0.0f;
                layoutBlock.yOffset = 0.0f;
                return;
            }
            if (cell.hasCaptionLayout()) {
                layoutBlock.layout = cell.getCaptionLayout();
                layoutBlock.xOffset = 0.0f;
                layoutBlock.yOffset = 0.0f;
                return;
            }
            for (int i = 0; i < messageObject.textLayoutBlocks.size(); i++) {
                MessageObject.TextLayoutBlock textLayoutBlock = messageObject.textLayoutBlocks.get(i);
                float f = y;
                float f2 = textLayoutBlock.textYOffset;
                if (f >= f2 && f <= textLayoutBlock.height + f2) {
                    layoutBlock.layout = textLayoutBlock.textLayout;
                    layoutBlock.yOffset = f2;
                    layoutBlock.xOffset = -(textLayoutBlock.isRtl() ? (int) Math.ceil(messageObject.textXOffset) : 0);
                    return;
                }
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        protected void fillLayoutForOffset(int offset, LayoutBlock layoutBlock, boolean maybe) {
            ChatMessageCell chatMessageCell = (ChatMessageCell) (maybe ? this.maybeSelectedView : this.selectedView);
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
            for (int i = 0; i < messageObject.textLayoutBlocks.size(); i++) {
                MessageObject.TextLayoutBlock textLayoutBlock = messageObject.textLayoutBlocks.get(i);
                if (offset >= textLayoutBlock.charactersOffset && offset <= textLayoutBlock.charactersEnd) {
                    layoutBlock.layout = messageObject.textLayoutBlocks.get(i).textLayout;
                    layoutBlock.yOffset = messageObject.textLayoutBlocks.get(i).textYOffset;
                    layoutBlock.xOffset = -(textLayoutBlock.isRtl() ? (int) Math.ceil(messageObject.textXOffset) : 0);
                    return;
                }
            }
            layoutBlock.layout = null;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        protected void onExitSelectionMode(boolean instant) {
            Cell cell = this.selectedView;
            if (cell == null || !((ChatMessageCell) cell).isDrawingSelectionBackground() || instant) {
                return;
            }
            Cell cell2 = this.selectedView;
            final ChatMessageCell chatMessageCell = (ChatMessageCell) cell2;
            final int id = ((ChatMessageCell) cell2).getMessageObject().getId();
            Animator animator = this.animatorSparseArray.get(id);
            if (animator != null) {
                animator.removeAllListeners();
                animator.cancel();
            }
            chatMessageCell.setSelectedBackgroundProgress(0.01f);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.01f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$TextSelectionHelper$ChatListTextSelectionHelper$eYgYCm5k5s7QsSp_vYU8NubvEY8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TextSelectionHelper.ChatListTextSelectionHelper.lambda$onExitSelectionMode$1(chatMessageCell, id, valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.TextSelectionHelper.ChatListTextSelectionHelper.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    chatMessageCell.setSelectedBackgroundProgress(0.0f);
                }
            });
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.start();
            this.animatorSparseArray.put(id, valueAnimatorOfFloat);
        }

        static /* synthetic */ void lambda$onExitSelectionMode$1(ChatMessageCell chatMessageCell, int i, ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (chatMessageCell.getMessageObject() == null || chatMessageCell.getMessageObject().getId() != i) {
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

        public void drawCaption(boolean isOut, StaticLayout captionLayout, Canvas canvas) {
            if (this.isDescription) {
                return;
            }
            if (isOut) {
                this.selectionPaint.setColor(getThemedColor("chat_outTextSelectionHighlight"));
            } else {
                this.selectionPaint.setColor(getThemedColor("chat_inTextSelectionHighlight"));
            }
            drawSelection(canvas, captionLayout, this.selectionStart, this.selectionEnd);
        }

        public void drawDescription(boolean isOut, StaticLayout layout, Canvas canvas) {
            if (this.isDescription) {
                if (isOut) {
                    this.selectionPaint.setColor(getThemedColor("chat_outTextSelectionHighlight"));
                } else {
                    this.selectionPaint.setColor(getThemedColor("chat_inTextSelectionHighlight"));
                }
                drawSelection(canvas, layout, this.selectionStart, this.selectionEnd);
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
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
                SparseArray<Animator> sparseArray = this.animatorSparseArray;
                sparseArray.get(sparseArray.keyAt(i)).cancel();
            }
            this.animatorSparseArray.clear();
        }

        public void setIsDescription(boolean b) {
            this.maybeIsDescription = b;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public void clear(boolean instant) {
            super.clear(instant);
            this.isDescription = false;
        }

        public int getTextSelectionType(ChatMessageCell cell) {
            if (this.isDescription) {
                return TYPE_DESCRIPTION;
            }
            if (cell.hasCaptionLayout()) {
                return TYPE_CAPTION;
            }
            return TYPE_MESSAGE;
        }

        public void updateTextPosition(int textX, int textY) {
            if (this.textX == textX && this.textY == textY) {
                return;
            }
            this.textX = textX;
            this.textY = textY;
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
        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public CharSequence getText(ArticleSelectableView view, boolean maybe) {
            int i;
            this.arrayList.clear();
            view.fillTextLayoutBlocks(this.arrayList);
            if (maybe) {
                i = this.maybeTextIndex;
            } else {
                i = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
            }
            return (this.arrayList.isEmpty() || i < 0) ? "" : this.arrayList.get(i).getLayout().getText();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public int getCharOffsetFromCord(int x, int y, int offsetX, int offsetY, ArticleSelectableView view, boolean maybe) {
            int i;
            if (view == null) {
                return -1;
            }
            int width = x - offsetX;
            int lineBottom = y - offsetY;
            this.arrayList.clear();
            view.fillTextLayoutBlocks(this.arrayList);
            if (maybe) {
                i = this.maybeTextIndex;
            } else {
                i = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
            }
            StaticLayout layout = this.arrayList.get(i).getLayout();
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
            int i2 = 0;
            while (true) {
                if (i2 >= layout.getLineCount()) {
                    i2 = -1;
                    break;
                }
                if (lineBottom > layout.getLineTop(i2) && lineBottom < layout.getLineBottom(i2)) {
                    break;
                }
                i2++;
            }
            if (i2 >= 0) {
                return layout.getOffsetForHorizontal(i2, width);
            }
            return -1;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        protected void fillLayoutForOffset(int offset, LayoutBlock layoutBlock, boolean maybe) {
            this.arrayList.clear();
            ArticleSelectableView articleSelectableView = (ArticleSelectableView) (maybe ? this.maybeSelectedView : this.selectedView);
            if (articleSelectableView == null) {
                layoutBlock.layout = null;
                return;
            }
            articleSelectableView.fillTextLayoutBlocks(this.arrayList);
            if (maybe) {
                layoutBlock.layout = this.arrayList.get(this.maybeTextIndex).getLayout();
            } else {
                int i = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
                if (i < 0 || i >= this.arrayList.size()) {
                    layoutBlock.layout = null;
                    return;
                }
                layoutBlock.layout = this.arrayList.get(i).getLayout();
            }
            layoutBlock.yOffset = 0.0f;
            layoutBlock.xOffset = 0.0f;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
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
        public void setMaybeView(int x, int y, View parentView) {
            if (parentView instanceof ArticleSelectableView) {
                this.capturedX = x;
                this.capturedY = y;
                ArticleSelectableView articleSelectableView = (ArticleSelectableView) parentView;
                this.maybeSelectedView = articleSelectableView;
                int iFindClosestLayoutIndex = findClosestLayoutIndex(x, y, articleSelectableView);
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
        private int findClosestLayoutIndex(int x, int y, ArticleSelectableView maybeSelectedView) {
            int i = 0;
            if (maybeSelectedView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) maybeSelectedView;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof ArticleSelectableView) {
                        float f = y;
                        if (f > childAt.getY() && f < childAt.getY() + childAt.getHeight()) {
                            return findClosestLayoutIndex((int) (x - childAt.getX()), (int) (f - childAt.getY()), (ArticleSelectableView) childAt);
                        }
                    }
                }
            }
            this.arrayList.clear();
            maybeSelectedView.fillTextLayoutBlocks(this.arrayList);
            if (this.arrayList.isEmpty()) {
                return -1;
            }
            int size = this.arrayList.size() - 1;
            int i3 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            int i4 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            int i5 = -1;
            while (true) {
                if (size < 0) {
                    i = i4;
                    size = i5;
                    break;
                }
                TextLayoutBlock textLayoutBlock = this.arrayList.get(size);
                int y2 = textLayoutBlock.getY();
                int height = textLayoutBlock.getLayout().getHeight() + y2;
                if (y >= y2 && y < height) {
                    break;
                }
                int iMin = Math.min(Math.abs(y - y2), Math.abs(y - height));
                if (iMin < i4) {
                    i5 = size;
                    i4 = iMin;
                }
                size--;
            }
            if (size < 0) {
                return -1;
            }
            int row = this.arrayList.get(size).getRow();
            if (row > 0 && i < AndroidUtilities.dp(24.0f)) {
                for (int size2 = this.arrayList.size() - 1; size2 >= 0; size2--) {
                    TextLayoutBlock textLayoutBlock2 = this.arrayList.get(size2);
                    if (textLayoutBlock2.getRow() == row) {
                        int x2 = textLayoutBlock2.getX();
                        int x3 = textLayoutBlock2.getX() + textLayoutBlock2.getLayout().getWidth();
                        if (x >= x2 && x <= x3) {
                            return size2;
                        }
                        int iMin2 = Math.min(Math.abs(x - x2), Math.abs(x - x3));
                        if (iMin2 < i3) {
                            size = size2;
                            i3 = iMin2;
                        }
                    }
                }
            }
            return size;
        }

        public void draw(Canvas canvas, ArticleSelectableView view, int i) {
            this.selectionPaint.setColor(getThemedColor("chat_inTextSelectionHighlight"));
            int adapterPosition = getAdapterPosition(view);
            if (adapterPosition < 0) {
                return;
            }
            this.arrayList.clear();
            view.fillTextLayoutBlocks(this.arrayList);
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
        private int getAdapterPosition(ArticleSelectableView view) {
            ViewGroup viewGroup;
            View view2 = (View) view;
            ViewParent parent = view2.getParent();
            while (true) {
                viewGroup = this.parentView;
                if (parent != viewGroup && parent != null) {
                    if (!(parent instanceof View)) {
                        parent = null;
                        break;
                    }
                    view2 = parent;
                    parent = view2.getParent();
                } else {
                    break;
                }
            }
            if (parent == null) {
                return -1;
            }
            RecyclerListView recyclerListView = this.parentRecyclerView;
            if (recyclerListView != null) {
                return recyclerListView.getChildAdapterPosition(view2);
            }
            return viewGroup.indexOfChild(view2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean isSelectable(View child) {
            if (!(child instanceof ArticleSelectableView)) {
                return false;
            }
            this.arrayList.clear();
            ((ArticleSelectableView) child).fillTextLayoutBlocks(this.arrayList);
            if (child instanceof ArticleViewer.BlockTableCell) {
                return true;
            }
            return !this.arrayList.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public void onTextSelected(ArticleSelectableView newView, ArticleSelectableView oldView) {
            int adapterPosition = getAdapterPosition(newView);
            if (adapterPosition < 0) {
                return;
            }
            this.endViewPosition = adapterPosition;
            this.startViewPosition = adapterPosition;
            int i = this.maybeTextIndex;
            this.endViewChildPosition = i;
            this.startViewChildPosition = i;
            this.arrayList.clear();
            newView.fillTextLayoutBlocks(this.arrayList);
            int size = this.arrayList.size();
            this.childCountByPosition.put(adapterPosition, size);
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = (i2 << 16) + adapterPosition;
                this.textByPosition.put(i3, this.arrayList.get(i2).getLayout().getText());
                this.prefixTextByPosition.put(i3, this.arrayList.get(i2).getPrefix());
            }
        }

        protected void onNewViewSelected(ArticleSelectableView oldView, ArticleSelectableView newView, int childPosition) {
            int i;
            int adapterPosition = getAdapterPosition(newView);
            int adapterPosition2 = oldView != null ? getAdapterPosition(oldView) : -1;
            invalidate();
            if (this.movingDirectionSettling && (i = this.startViewPosition) == this.endViewPosition) {
                if (adapterPosition == i) {
                    if (childPosition < this.startViewChildPosition) {
                        this.startViewChildPosition = childPosition;
                        pickStartView();
                        this.movingHandleStart = true;
                        int i2 = this.selectionEnd;
                        this.startViewOffset = i2;
                        this.selectionStart = i2 - 1;
                    } else {
                        this.endViewChildPosition = childPosition;
                        pickEndView();
                        this.movingHandleStart = false;
                        this.endViewOffset = 0;
                    }
                } else if (adapterPosition < i) {
                    this.startViewPosition = adapterPosition;
                    this.startViewChildPosition = childPosition;
                    pickStartView();
                    this.movingHandleStart = true;
                    int i3 = this.selectionEnd;
                    this.startViewOffset = i3;
                    this.selectionStart = i3 - 1;
                } else {
                    this.endViewPosition = adapterPosition;
                    this.endViewChildPosition = childPosition;
                    pickEndView();
                    this.movingHandleStart = false;
                    this.endViewOffset = 0;
                }
            } else if (this.movingHandleStart) {
                if (adapterPosition == adapterPosition2) {
                    int i4 = this.endViewChildPosition;
                    if (childPosition <= i4 || adapterPosition < this.endViewPosition) {
                        this.startViewPosition = adapterPosition;
                        this.startViewChildPosition = childPosition;
                        pickStartView();
                        this.startViewOffset = this.selectionEnd;
                    } else {
                        this.endViewPosition = adapterPosition;
                        this.startViewChildPosition = i4;
                        this.endViewChildPosition = childPosition;
                        this.startViewOffset = this.endViewOffset;
                        pickEndView();
                        this.endViewOffset = 0;
                        this.movingHandleStart = false;
                    }
                } else if (adapterPosition <= this.endViewPosition) {
                    this.startViewPosition = adapterPosition;
                    this.startViewChildPosition = childPosition;
                    pickStartView();
                    this.startViewOffset = this.selectionEnd;
                } else {
                    this.endViewPosition = adapterPosition;
                    this.startViewChildPosition = this.endViewChildPosition;
                    this.endViewChildPosition = childPosition;
                    this.startViewOffset = this.endViewOffset;
                    pickEndView();
                    this.endViewOffset = 0;
                    this.movingHandleStart = false;
                }
            } else if (adapterPosition == adapterPosition2) {
                int i5 = this.startViewChildPosition;
                if (childPosition >= i5 || adapterPosition > this.startViewPosition) {
                    this.endViewPosition = adapterPosition;
                    this.endViewChildPosition = childPosition;
                    pickEndView();
                    this.endViewOffset = 0;
                } else {
                    this.startViewPosition = adapterPosition;
                    this.endViewChildPosition = i5;
                    this.startViewChildPosition = childPosition;
                    this.endViewOffset = this.startViewOffset;
                    pickStartView();
                    this.movingHandleStart = true;
                    this.startViewOffset = this.selectionEnd;
                }
            } else if (adapterPosition >= this.startViewPosition) {
                this.endViewPosition = adapterPosition;
                this.endViewChildPosition = childPosition;
                pickEndView();
                this.endViewOffset = 0;
            } else {
                this.startViewPosition = adapterPosition;
                this.endViewChildPosition = this.startViewChildPosition;
                this.startViewChildPosition = childPosition;
                this.endViewOffset = this.startViewOffset;
                pickStartView();
                this.movingHandleStart = true;
                this.startViewOffset = this.selectionEnd;
            }
            this.arrayList.clear();
            newView.fillTextLayoutBlocks(this.arrayList);
            int size = this.arrayList.size();
            this.childCountByPosition.put(adapterPosition, size);
            for (int i6 = 0; i6 < size; i6++) {
                int i7 = (i6 << 16) + adapterPosition;
                this.textByPosition.put(i7, this.arrayList.get(i6).getLayout().getText());
                this.prefixTextByPosition.put(i7, this.arrayList.get(i6).getPrefix());
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
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

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
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

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
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

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public void invalidate() {
            super.invalidate();
            for (int i = 0; i < this.parentView.getChildCount(); i++) {
                this.parentView.getChildAt(i).invalidate();
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public void clear(boolean instant) {
            super.clear(instant);
            this.startViewPosition = -1;
            this.endViewPosition = -1;
            this.startViewChildPosition = -1;
            this.endViewChildPosition = -1;
            this.textByPosition.clear();
            this.childCountByPosition.clear();
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
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

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        protected boolean selectLayout(int x, int y) {
            if (!this.multiselect) {
                return false;
            }
            if (y <= ((ArticleSelectableView) this.selectedView).getTop() || y >= ((ArticleSelectableView) this.selectedView).getBottom()) {
                int childCount = this.parentView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (isSelectable(this.parentView.getChildAt(i))) {
                        ArticleSelectableView articleSelectableView = (ArticleSelectableView) this.parentView.getChildAt(i);
                        if (y > articleSelectableView.getTop() && y < articleSelectableView.getBottom()) {
                            int iFindClosestLayoutIndex = findClosestLayoutIndex((int) (x - articleSelectableView.getX()), (int) (y - articleSelectableView.getY()), articleSelectableView);
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
            int i2 = this.startPeek ? this.startViewChildPosition : this.endViewChildPosition;
            int iFindClosestLayoutIndex2 = findClosestLayoutIndex((int) (x - ((ArticleSelectableView) this.selectedView).getX()), (int) (y - ((ArticleSelectableView) this.selectedView).getY()), (ArticleSelectableView) this.selectedView);
            if (iFindClosestLayoutIndex2 == i2 || iFindClosestLayoutIndex2 < 0) {
                return false;
            }
            Cell cell = this.selectedView;
            onNewViewSelected((ArticleSelectableView) cell, (ArticleSelectableView) cell, iFindClosestLayoutIndex2);
            return true;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        protected boolean canSelect(int newSelection) {
            if (this.startViewPosition == this.endViewPosition && this.startViewChildPosition == this.endViewChildPosition) {
                return super.canSelect(newSelection);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
        public void jumpToLine(int newSelection, int nextWhitespace, boolean viewChanged, float newYoffset, float oldYoffset, ArticleSelectableView oldSelectedView) {
            if (viewChanged && oldSelectedView == this.selectedView && oldYoffset == newYoffset) {
                if (this.movingHandleStart) {
                    this.selectionStart = newSelection;
                    return;
                } else {
                    this.selectionEnd = newSelection;
                    return;
                }
            }
            super.jumpToLine(newSelection, nextWhitespace, viewChanged, newYoffset, oldYoffset, (float) oldSelectedView);
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper
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
        public void addRect(float left, float top, float right, float bottom, Path.Direction dir) {
            super.addRect(left, top, right, bottom, dir);
            if (bottom > this.lastBottom) {
                this.lastBottom = bottom;
            }
        }
    }

    public void setKeyboardSize(int keyboardSize) {
        this.keyboardSize = keyboardSize;
        invalidate();
    }

    protected int getThemedColor(String key) {
        return Theme.getColor(key);
    }
}
