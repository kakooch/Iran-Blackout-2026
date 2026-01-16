package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.SparseIntArray;
import android.util.StateSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.ActionBar.Theme;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class RecyclerListView extends RecyclerView {
    private static int[] attributes;
    private static boolean gotAttributes;
    private boolean allowItemsInteractionDuringAnimation;
    private boolean animateEmptyView;
    private Runnable clickRunnable;
    private int currentChildPosition;
    private View currentChildView;
    private int currentFirst;
    int currentSelectedPosition;
    private int currentVisible;
    private boolean disableHighlightState;
    private boolean disallowInterceptTouchEvents;
    private boolean drawSelectorBehind;
    private View emptyView;
    int emptyViewAnimateToVisibility;
    private int emptyViewAnimationType;
    private FastScroll fastScroll;
    public boolean fastScrollAnimationRunning;
    private GestureDetector gestureDetector;
    private ArrayList<View> headers;
    private ArrayList<View> headersCache;
    private boolean hiddenByEmptyView;
    private boolean hideIfEmpty;
    private boolean instantClick;
    private boolean interceptedByChild;
    private boolean isChildViewEnabled;
    private boolean isHidden;
    private long lastAlphaAnimationTime;
    float lastX;
    float lastY;
    int[] listPaddings;
    private boolean longPressCalled;
    boolean multiSelectionGesture;
    boolean multiSelectionGestureStarted;
    onMultiSelectionChanged multiSelectionListener;
    boolean multiselectScrollRunning;
    boolean multiselectScrollToTop;
    private RecyclerView.AdapterDataObserver observer;
    private OnInterceptTouchListener onInterceptTouchListener;
    private OnItemClickListener onItemClickListener;
    private OnItemClickListenerExtended onItemClickListenerExtended;
    private OnItemLongClickListener onItemLongClickListener;
    private OnItemLongClickListenerExtended onItemLongClickListenerExtended;
    private RecyclerView.OnScrollListener onScrollListener;
    private FrameLayout overlayContainer;
    private IntReturnCallback pendingHighlightPosition;
    private View pinnedHeader;
    private float pinnedHeaderShadowAlpha;
    private Drawable pinnedHeaderShadowDrawable;
    private float pinnedHeaderShadowTargetAlpha;
    private Runnable removeHighlighSelectionRunnable;
    protected final Theme.ResourcesProvider resourcesProvider;
    private boolean scrollEnabled;
    Runnable scroller;
    private boolean scrollingByUser;
    private int sectionOffset;
    private SectionsAdapter sectionsAdapter;
    private int sectionsCount;
    private int sectionsType;
    private Runnable selectChildRunnable;
    HashSet<Integer> selectedPositions;
    protected Drawable selectorDrawable;
    protected int selectorPosition;
    private int selectorRadius;
    protected android.graphics.Rect selectorRect;
    private int selectorType;
    private boolean selfOnLayout;
    private int startSection;
    int startSelectionFrom;
    private int topBottomSelectorRadius;
    private int touchSlop;
    boolean useRelativePositions;

    public static abstract class FastScrollAdapter extends SelectionAdapter {
        public abstract String getLetter(int position);

        public abstract int getPositionForScrollProgress(float progress);
    }

    public interface IntReturnCallback {
        int run();
    }

    public interface OnInterceptTouchListener {
        boolean onInterceptTouchEvent(MotionEvent event);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemClickListenerExtended {
        void onItemClick(View view, int position, float x, float y);
    }

    public interface OnItemLongClickListener {
        boolean onItemClick(View view, int position);
    }

    public interface OnItemLongClickListenerExtended {
        boolean onItemClick(View view, int position, float x, float y);

        void onLongClickRelease();

        void onMove(float dx, float dy);
    }

    public static abstract class SelectionAdapter extends RecyclerView.Adapter {
        public int getSelectionBottomPadding(View view) {
            return 0;
        }

        public abstract boolean isEnabled(RecyclerView.ViewHolder holder);
    }

    public interface onMultiSelectionChanged {
        boolean canSelect(int position);

        int checkPosition(int position, boolean selectionFromTop);

        void getPaddings(int[] paddings);

        boolean limitReached();

        void onSelectionChanged(int position, boolean selected, float x, float y);

        void scrollBy(int dy);
    }

    protected boolean allowSelectChildAtPosition(float x, float y) {
        return true;
    }

    protected boolean allowSelectChildAtPosition(View child) {
        return true;
    }

    protected boolean canHighlightChildAt(View child, float x, float y) {
        return true;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public static abstract class SectionsAdapter extends FastScrollAdapter {
        private int count;
        private SparseIntArray sectionCache;
        private int sectionCount;
        private SparseIntArray sectionCountCache;
        private SparseIntArray sectionPositionCache;

        public abstract int getCountForSection(int section);

        public abstract Object getItem(int section, int position);

        public abstract int getItemViewType(int section, int position);

        public abstract int getSectionCount();

        public abstract View getSectionHeaderView(int section, View view);

        public abstract boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row);

        public abstract void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder);

        private void cleanupCache() {
            SparseIntArray sparseIntArray = this.sectionCache;
            if (sparseIntArray == null) {
                this.sectionCache = new SparseIntArray();
                this.sectionPositionCache = new SparseIntArray();
                this.sectionCountCache = new SparseIntArray();
            } else {
                sparseIntArray.clear();
                this.sectionPositionCache.clear();
                this.sectionCountCache.clear();
            }
            this.count = -1;
            this.sectionCount = -1;
        }

        public void notifySectionsChanged() {
            cleanupCache();
        }

        public SectionsAdapter() {
            cleanupCache();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            cleanupCache();
            super.notifyDataSetChanged();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return isEnabled(holder, getSectionForPosition(adapterPosition), getPositionInSectionForPosition(adapterPosition));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int i = this.count;
            if (i >= 0) {
                return i;
            }
            this.count = 0;
            int iInternalGetSectionCount = internalGetSectionCount();
            for (int i2 = 0; i2 < iInternalGetSectionCount; i2++) {
                this.count += internalGetCountForSection(i2);
            }
            return this.count;
        }

        public final Object getItem(int position) {
            return getItem(getSectionForPosition(position), getPositionInSectionForPosition(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int position) {
            return getItemViewType(getSectionForPosition(position), getPositionInSectionForPosition(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            onBindViewHolder(getSectionForPosition(position), getPositionInSectionForPosition(position), holder);
        }

        private int internalGetCountForSection(int section) {
            int i = this.sectionCountCache.get(section, ConnectionsManager.DEFAULT_DATACENTER_ID);
            if (i != Integer.MAX_VALUE) {
                return i;
            }
            int countForSection = getCountForSection(section);
            this.sectionCountCache.put(section, countForSection);
            return countForSection;
        }

        private int internalGetSectionCount() {
            int i = this.sectionCount;
            if (i >= 0) {
                return i;
            }
            int sectionCount = getSectionCount();
            this.sectionCount = sectionCount;
            return sectionCount;
        }

        public final int getSectionForPosition(int position) {
            int i = this.sectionCache.get(position, ConnectionsManager.DEFAULT_DATACENTER_ID);
            if (i != Integer.MAX_VALUE) {
                return i;
            }
            int iInternalGetSectionCount = internalGetSectionCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < iInternalGetSectionCount) {
                int iInternalGetCountForSection = internalGetCountForSection(i2) + i3;
                if (position >= i3 && position < iInternalGetCountForSection) {
                    this.sectionCache.put(position, i2);
                    return i2;
                }
                i2++;
                i3 = iInternalGetCountForSection;
            }
            return -1;
        }

        public int getPositionInSectionForPosition(int position) {
            int i = this.sectionPositionCache.get(position, ConnectionsManager.DEFAULT_DATACENTER_ID);
            if (i != Integer.MAX_VALUE) {
                return i;
            }
            int iInternalGetSectionCount = internalGetSectionCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < iInternalGetSectionCount) {
                int iInternalGetCountForSection = internalGetCountForSection(i2) + i3;
                if (position >= i3 && position < iInternalGetCountForSection) {
                    int i4 = position - i3;
                    this.sectionPositionCache.put(position, i4);
                    return i4;
                }
                i2++;
                i3 = iInternalGetCountForSection;
            }
            return -1;
        }
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }
    }

    private class FastScroll extends View {
        private float bubbleProgress;
        private int[] colors;
        private String currentLetter;
        private long lastUpdateTime;
        private float lastY;
        private StaticLayout letterLayout;
        private TextPaint letterPaint;
        private StaticLayout oldLetterLayout;
        private Paint paint;
        private Path path;
        private boolean pressed;
        private float progress;
        private float[] radii;
        private RectF rect;
        private int scrollX;
        private float startDy;
        private float textX;
        private float textY;

        public FastScroll(Context context) {
            super(context);
            this.rect = new RectF();
            this.paint = new Paint(1);
            this.letterPaint = new TextPaint(1);
            this.path = new Path();
            this.radii = new float[8];
            this.colors = new int[6];
            this.letterPaint.setTextSize(AndroidUtilities.dp(45.0f));
            for (int i = 0; i < 8; i++) {
                this.radii[i] = AndroidUtilities.dp(44.0f);
            }
            this.scrollX = AndroidUtilities.dp(LocaleController.isRTL ? 10.0f : 117.0f);
            updateColors();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateColors() {
            int color = Theme.getColor("fastScrollInactive");
            int color2 = Theme.getColor("fastScrollActive");
            this.paint.setColor(color);
            this.letterPaint.setColor(Theme.getColor("fastScrollText"));
            this.colors[0] = Color.red(color);
            this.colors[1] = Color.red(color2);
            this.colors[2] = Color.green(color);
            this.colors[3] = Color.green(color2);
            this.colors[4] = Color.blue(color);
            this.colors[5] = Color.blue(color2);
            invalidate();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            if (action == 0) {
                float x = event.getX();
                this.lastY = event.getY();
                float fCeil = ((float) Math.ceil((getMeasuredHeight() - AndroidUtilities.dp(54.0f)) * this.progress)) + AndroidUtilities.dp(12.0f);
                if ((!LocaleController.isRTL || x <= AndroidUtilities.dp(25.0f)) && (LocaleController.isRTL || x >= AndroidUtilities.dp(107.0f))) {
                    float f = this.lastY;
                    if (f >= fCeil && f <= AndroidUtilities.dp(30.0f) + fCeil) {
                        this.startDy = this.lastY - fCeil;
                        this.pressed = true;
                        this.lastUpdateTime = System.currentTimeMillis();
                        getCurrentLetter();
                        invalidate();
                        return true;
                    }
                }
                return false;
            }
            if (action != 1) {
                if (action == 2) {
                    if (!this.pressed) {
                        return true;
                    }
                    float y = event.getY();
                    float fDp = AndroidUtilities.dp(12.0f) + this.startDy;
                    float measuredHeight = (getMeasuredHeight() - AndroidUtilities.dp(42.0f)) + this.startDy;
                    if (y < fDp) {
                        y = fDp;
                    } else if (y > measuredHeight) {
                        y = measuredHeight;
                    }
                    float f2 = y - this.lastY;
                    this.lastY = y;
                    float measuredHeight2 = this.progress + (f2 / (getMeasuredHeight() - AndroidUtilities.dp(54.0f)));
                    this.progress = measuredHeight2;
                    if (measuredHeight2 < 0.0f) {
                        this.progress = 0.0f;
                    } else if (measuredHeight2 > 1.0f) {
                        this.progress = 1.0f;
                    }
                    getCurrentLetter();
                    invalidate();
                    return true;
                }
                if (action != 3) {
                    return super.onTouchEvent(event);
                }
            }
            this.pressed = false;
            this.lastUpdateTime = System.currentTimeMillis();
            invalidate();
            return true;
        }

        private void getCurrentLetter() {
            RecyclerView.LayoutManager layoutManager = RecyclerListView.this.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager.getOrientation() == 1) {
                    RecyclerView.Adapter adapter = RecyclerListView.this.getAdapter();
                    if (adapter instanceof FastScrollAdapter) {
                        FastScrollAdapter fastScrollAdapter = (FastScrollAdapter) adapter;
                        int positionForScrollProgress = fastScrollAdapter.getPositionForScrollProgress(this.progress);
                        linearLayoutManager.scrollToPositionWithOffset(positionForScrollProgress, RecyclerListView.this.sectionOffset);
                        String letter = fastScrollAdapter.getLetter(positionForScrollProgress);
                        if (letter == null) {
                            StaticLayout staticLayout = this.letterLayout;
                            if (staticLayout != null) {
                                this.oldLetterLayout = staticLayout;
                            }
                            this.letterLayout = null;
                            return;
                        }
                        if (letter.equals(this.currentLetter)) {
                            return;
                        }
                        StaticLayout staticLayout2 = new StaticLayout(letter, this.letterPaint, 1000, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                        this.letterLayout = staticLayout2;
                        this.oldLetterLayout = null;
                        if (staticLayout2.getLineCount() > 0) {
                            this.letterLayout.getLineWidth(0);
                            this.letterLayout.getLineLeft(0);
                            if (LocaleController.isRTL) {
                                this.textX = (AndroidUtilities.dp(10.0f) + ((AndroidUtilities.dp(88.0f) - this.letterLayout.getLineWidth(0)) / 2.0f)) - this.letterLayout.getLineLeft(0);
                            } else {
                                this.textX = ((AndroidUtilities.dp(88.0f) - this.letterLayout.getLineWidth(0)) / 2.0f) - this.letterLayout.getLineLeft(0);
                            }
                            this.textY = (AndroidUtilities.dp(88.0f) - this.letterLayout.getHeight()) / 2;
                        }
                    }
                }
            }
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(AndroidUtilities.dp(132.0f), View.MeasureSpec.getSize(heightMeasureSpec));
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x019a  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r21) {
            /*
                Method dump skipped, instructions count: 539
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.RecyclerListView.FastScroll.onDraw(android.graphics.Canvas):void");
        }

        @Override // android.view.View
        public void layout(int l, int t, int r, int b) {
            if (RecyclerListView.this.selfOnLayout) {
                super.layout(l, t, r, b);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProgress(float value) {
            this.progress = value;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class RecyclerListViewItemClickListener implements RecyclerView.OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView view, MotionEvent event) {
        }

        public RecyclerListViewItemClickListener(Context context) {
            RecyclerListView.this.gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener() { // from class: ir.eitaa.ui.Components.RecyclerListView.RecyclerListViewItemClickListener.1
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent e) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent e) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent e) {
                    if (RecyclerListView.this.currentChildView != null && (RecyclerListView.this.onItemClickListener != null || RecyclerListView.this.onItemClickListenerExtended != null)) {
                        final float x = e.getX();
                        final float y = e.getY();
                        RecyclerListView recyclerListView = RecyclerListView.this;
                        recyclerListView.onChildPressed(recyclerListView.currentChildView, x, y, true);
                        final View view = RecyclerListView.this.currentChildView;
                        final int i = RecyclerListView.this.currentChildPosition;
                        if (RecyclerListView.this.instantClick && i != -1) {
                            view.playSoundEffect(0);
                            view.sendAccessibilityEvent(1);
                            if (RecyclerListView.this.onItemClickListener != null) {
                                RecyclerListView.this.onItemClickListener.onItemClick(view, i);
                            } else if (RecyclerListView.this.onItemClickListenerExtended != null) {
                                RecyclerListView.this.onItemClickListenerExtended.onItemClick(view, i, x - view.getX(), y - view.getY());
                            }
                        }
                        AndroidUtilities.runOnUIThread(RecyclerListView.this.clickRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RecyclerListView.RecyclerListViewItemClickListener.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (this == RecyclerListView.this.clickRunnable) {
                                    RecyclerListView.this.clickRunnable = null;
                                }
                                View view2 = view;
                                if (view2 != null) {
                                    RecyclerListView.this.onChildPressed(view2, 0.0f, 0.0f, false);
                                    if (RecyclerListView.this.instantClick) {
                                        return;
                                    }
                                    view.playSoundEffect(0);
                                    view.sendAccessibilityEvent(1);
                                    if (i != -1) {
                                        if (RecyclerListView.this.onItemClickListener != null) {
                                            RecyclerListView.this.onItemClickListener.onItemClick(view, i);
                                        } else if (RecyclerListView.this.onItemClickListenerExtended != null) {
                                            OnItemClickListenerExtended onItemClickListenerExtended = RecyclerListView.this.onItemClickListenerExtended;
                                            View view3 = view;
                                            onItemClickListenerExtended.onItemClick(view3, i, x - view3.getX(), y - view.getY());
                                        }
                                    }
                                }
                            }
                        }, ViewConfiguration.getPressedStateDuration());
                        if (RecyclerListView.this.selectChildRunnable != null) {
                            View view2 = RecyclerListView.this.currentChildView;
                            AndroidUtilities.cancelRunOnUIThread(RecyclerListView.this.selectChildRunnable);
                            RecyclerListView.this.selectChildRunnable = null;
                            RecyclerListView.this.currentChildView = null;
                            RecyclerListView.this.interceptedByChild = false;
                            RecyclerListView.this.removeSelection(view2, e);
                        }
                    }
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent event) {
                    if (RecyclerListView.this.currentChildView == null || RecyclerListView.this.currentChildPosition == -1) {
                        return;
                    }
                    if (RecyclerListView.this.onItemLongClickListener == null && RecyclerListView.this.onItemLongClickListenerExtended == null) {
                        return;
                    }
                    View view = RecyclerListView.this.currentChildView;
                    if (RecyclerListView.this.onItemLongClickListener != null) {
                        if (RecyclerListView.this.onItemLongClickListener.onItemClick(RecyclerListView.this.currentChildView, RecyclerListView.this.currentChildPosition)) {
                            view.performHapticFeedback(0);
                            view.sendAccessibilityEvent(2);
                            return;
                        }
                        return;
                    }
                    if (RecyclerListView.this.onItemLongClickListenerExtended.onItemClick(RecyclerListView.this.currentChildView, RecyclerListView.this.currentChildPosition, event.getX() - RecyclerListView.this.currentChildView.getX(), event.getY() - RecyclerListView.this.currentChildView.getY())) {
                        view.performHapticFeedback(0);
                        view.sendAccessibilityEvent(2);
                        RecyclerListView.this.longPressCalled = true;
                    }
                }
            });
            RecyclerListView.this.gestureDetector.setIsLongpressEnabled(false);
        }

        /* JADX WARN: Removed duplicated region for block: B:99:0x027c  */
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView r19, android.view.MotionEvent r20) {
            /*
                Method dump skipped, instructions count: 652
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.RecyclerListView.RecyclerListViewItemClickListener.onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onInterceptTouchEvent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onInterceptTouchEvent$0$RecyclerListView$RecyclerListViewItemClickListener(float f, float f2) {
            if (RecyclerListView.this.selectChildRunnable == null || RecyclerListView.this.currentChildView == null) {
                return;
            }
            RecyclerListView recyclerListView = RecyclerListView.this;
            recyclerListView.onChildPressed(recyclerListView.currentChildView, f, f2, true);
            RecyclerListView.this.selectChildRunnable = null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            RecyclerListView.this.cancelClickRunnables(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public View findChildViewUnder(float x, float y) {
        int childCount = getChildCount();
        int i = 0;
        while (i < 2) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                float translationX = i == 0 ? childAt.getTranslationX() : 0.0f;
                float translationY = i == 0 ? childAt.getTranslationY() : 0.0f;
                if (x >= childAt.getLeft() + translationX && x <= childAt.getRight() + translationX && y >= childAt.getTop() + translationY && y <= childAt.getBottom() + translationY) {
                    return childAt;
                }
            }
            i++;
        }
        return null;
    }

    public void setDisableHighlightState(boolean value) {
        this.disableHighlightState = value;
    }

    protected View getPressedChildView() {
        return this.currentChildView;
    }

    protected void onChildPressed(View child, float x, float y, boolean pressed) {
        if (this.disableHighlightState || child == null) {
            return;
        }
        child.setPressed(pressed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSelection(View pressedChild, MotionEvent event) {
        if (pressedChild == null || this.selectorRect.isEmpty()) {
            return;
        }
        if (pressedChild.isEnabled()) {
            positionSelector(this.currentChildPosition, pressedChild);
            Drawable drawable = this.selectorDrawable;
            if (drawable != null) {
                Drawable current = drawable.getCurrent();
                if (current instanceof TransitionDrawable) {
                    ((TransitionDrawable) current).resetTransition();
                }
                if (event != null && Build.VERSION.SDK_INT >= 21) {
                    this.selectorDrawable.setHotspot(event.getX(), event.getY());
                }
            }
        } else {
            this.selectorRect.setEmpty();
        }
        updateSelectorState();
    }

    public void cancelClickRunnables(boolean uncheck) {
        Runnable runnable = this.selectChildRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.selectChildRunnable = null;
        }
        View view = this.currentChildView;
        if (view != null) {
            if (uncheck) {
                onChildPressed(view, 0.0f, 0.0f, false);
            }
            this.currentChildView = null;
            removeSelection(view, null);
        }
        this.selectorRect.setEmpty();
        Runnable runnable2 = this.clickRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.clickRunnable = null;
        }
        this.interceptedByChild = false;
    }

    public int[] getResourceDeclareStyleableIntArray(String packageName, String name) {
        try {
            Field field = Class.forName(packageName + ".R$styleable").getField(name);
            if (field != null) {
                return (int[]) field.get(null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public RecyclerListView(Context context) {
        this(context, null);
    }

    @SuppressLint({"PrivateApi"})
    public RecyclerListView(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.allowItemsInteractionDuringAnimation = true;
        this.currentFirst = -1;
        this.currentVisible = -1;
        this.hideIfEmpty = true;
        this.selectorType = 2;
        this.selectorRect = new android.graphics.Rect();
        this.scrollEnabled = true;
        this.lastX = Float.MAX_VALUE;
        this.lastY = Float.MAX_VALUE;
        this.observer = new RecyclerView.AdapterDataObserver() { // from class: ir.eitaa.ui.Components.RecyclerListView.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                RecyclerListView.this.checkIfEmpty(true);
                RecyclerListView.this.currentFirst = -1;
                if (RecyclerListView.this.removeHighlighSelectionRunnable == null) {
                    RecyclerListView.this.selectorRect.setEmpty();
                }
                RecyclerListView.this.invalidate();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                RecyclerListView.this.checkIfEmpty(true);
                if (RecyclerListView.this.pinnedHeader == null || RecyclerListView.this.pinnedHeader.getAlpha() != 0.0f) {
                    return;
                }
                RecyclerListView.this.currentFirst = -1;
                RecyclerListView.this.invalidateViews();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                RecyclerListView.this.checkIfEmpty(true);
            }
        };
        this.scroller = new Runnable() { // from class: ir.eitaa.ui.Components.RecyclerListView.5
            @Override // java.lang.Runnable
            public void run() {
                int iDp;
                RecyclerListView recyclerListView = RecyclerListView.this;
                recyclerListView.multiSelectionListener.getPaddings(recyclerListView.listPaddings);
                if (RecyclerListView.this.multiselectScrollToTop) {
                    iDp = -AndroidUtilities.dp(12.0f);
                    RecyclerListView.this.chekMultiselect(0.0f, r2.listPaddings[0]);
                } else {
                    iDp = AndroidUtilities.dp(12.0f);
                    RecyclerListView.this.chekMultiselect(0.0f, r2.getMeasuredHeight() - RecyclerListView.this.listPaddings[1]);
                }
                RecyclerListView.this.multiSelectionListener.scrollBy(iDp);
                RecyclerListView recyclerListView2 = RecyclerListView.this;
                if (recyclerListView2.multiselectScrollRunning) {
                    AndroidUtilities.runOnUIThread(recyclerListView2.scroller);
                }
            }
        };
        this.resourcesProvider = resourcesProvider;
        setGlowColor(getThemedColor("actionBarDefault"));
        Drawable selectorDrawable = Theme.getSelectorDrawable(getThemedColor("listSelectorSDK21"), false);
        this.selectorDrawable = selectorDrawable;
        selectorDrawable.setCallback(this);
        try {
            if (!gotAttributes) {
                attributes = getResourceDeclareStyleableIntArray("com.android.internal", "View");
                gotAttributes = true;
            }
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributes);
            View.class.getDeclaredMethod("initializeScrollbars", TypedArray.class).invoke(this, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            FileLog.e(th);
        }
        super.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.RecyclerListView.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState != 0 && RecyclerListView.this.currentChildView != null) {
                    if (RecyclerListView.this.selectChildRunnable != null) {
                        AndroidUtilities.cancelRunOnUIThread(RecyclerListView.this.selectChildRunnable);
                        RecyclerListView.this.selectChildRunnable = null;
                    }
                    MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                    try {
                        RecyclerListView.this.gestureDetector.onTouchEvent(motionEventObtain);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    RecyclerListView.this.currentChildView.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    View view = RecyclerListView.this.currentChildView;
                    RecyclerListView recyclerListView = RecyclerListView.this;
                    recyclerListView.onChildPressed(recyclerListView.currentChildView, 0.0f, 0.0f, false);
                    RecyclerListView.this.currentChildView = null;
                    RecyclerListView.this.removeSelection(view, null);
                    RecyclerListView.this.interceptedByChild = false;
                }
                if (RecyclerListView.this.onScrollListener != null) {
                    RecyclerListView.this.onScrollListener.onScrollStateChanged(recyclerView, newState);
                }
                RecyclerListView.this.scrollingByUser = newState == 1 || newState == 2;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (RecyclerListView.this.onScrollListener != null) {
                    RecyclerListView.this.onScrollListener.onScrolled(recyclerView, dx, dy);
                }
                RecyclerListView recyclerListView = RecyclerListView.this;
                if (recyclerListView.selectorPosition != -1) {
                    recyclerListView.selectorRect.offset(-dx, -dy);
                    RecyclerListView recyclerListView2 = RecyclerListView.this;
                    recyclerListView2.selectorDrawable.setBounds(recyclerListView2.selectorRect);
                    RecyclerListView.this.invalidate();
                } else {
                    recyclerListView.selectorRect.setEmpty();
                }
                RecyclerListView.this.checkSection();
            }
        });
        addOnItemTouchListener(new RecyclerListViewItemClickListener(context));
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        if (attributes != null) {
            super.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (this.fastScroll != null) {
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            this.fastScroll.getLayoutParams().height = measuredHeight;
            this.fastScroll.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(132.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (this.fastScroll != null) {
            this.selfOnLayout = true;
            int paddingTop = t + getPaddingTop();
            if (LocaleController.isRTL) {
                FastScroll fastScroll = this.fastScroll;
                fastScroll.layout(0, paddingTop, fastScroll.getMeasuredWidth(), this.fastScroll.getMeasuredHeight() + paddingTop);
            } else {
                int measuredWidth = getMeasuredWidth() - this.fastScroll.getMeasuredWidth();
                FastScroll fastScroll2 = this.fastScroll;
                fastScroll2.layout(measuredWidth, paddingTop, fastScroll2.getMeasuredWidth() + measuredWidth, this.fastScroll.getMeasuredHeight() + paddingTop);
            }
            this.selfOnLayout = false;
        }
        checkSection();
        IntReturnCallback intReturnCallback = this.pendingHighlightPosition;
        if (intReturnCallback != null) {
            highlightRowInternal(intReturnCallback, false);
        }
    }

    public void setSelectorType(int type) {
        this.selectorType = type;
    }

    public void setSelectorRadius(int radius) {
        this.selectorRadius = radius;
    }

    public void setTopBottomSelectorRadius(int radius) {
        this.topBottomSelectorRadius = radius;
    }

    public void setDrawSelectorBehind(boolean value) {
        this.drawSelectorBehind = value;
    }

    public void setSelectorDrawableColor(int color) {
        Drawable drawable = this.selectorDrawable;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        int i = this.topBottomSelectorRadius;
        if (i > 0) {
            this.selectorDrawable = Theme.createRadSelectorDrawable(color, i, i);
        } else {
            int i2 = this.selectorRadius;
            if (i2 > 0) {
                this.selectorDrawable = Theme.createSimpleSelectorRoundRectDrawable(i2, 0, color, -16777216);
            } else {
                int i3 = this.selectorType;
                if (i3 == 2) {
                    this.selectorDrawable = Theme.getSelectorDrawable(color, false);
                } else {
                    this.selectorDrawable = Theme.createSelectorDrawable(color, i3);
                }
            }
        }
        this.selectorDrawable.setCallback(this);
    }

    public void checkSection() {
        RecyclerView.ViewHolder childViewHolder;
        int adapterPosition;
        int sectionForPosition;
        RecyclerView.ViewHolder childViewHolder2;
        View view;
        int top;
        if ((!this.scrollingByUser || this.fastScroll == null) && (this.sectionsType == 0 || this.sectionsAdapter == null)) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.getOrientation() == 1) {
                if (this.sectionsAdapter != null) {
                    int paddingTop = getPaddingTop();
                    int i = this.sectionsType;
                    int i2 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    if (i != 1) {
                        if (i == 2) {
                            this.pinnedHeaderShadowTargetAlpha = 0.0f;
                            if (this.sectionsAdapter.getItemCount() == 0) {
                                return;
                            }
                            int childCount = getChildCount();
                            int i3 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                            View view2 = null;
                            int iMax = 0;
                            View view3 = null;
                            for (int i4 = 0; i4 < childCount; i4++) {
                                View childAt = getChildAt(i4);
                                int bottom = childAt.getBottom();
                                if (bottom > this.sectionOffset + paddingTop) {
                                    if (bottom < i2) {
                                        view2 = childAt;
                                        i2 = bottom;
                                    }
                                    iMax = Math.max(iMax, bottom);
                                    if (bottom >= this.sectionOffset + paddingTop + AndroidUtilities.dp(32.0f) && bottom < i3) {
                                        view3 = childAt;
                                        i3 = bottom;
                                    }
                                }
                            }
                            if (view2 == null || (childViewHolder = getChildViewHolder(view2)) == null || (sectionForPosition = this.sectionsAdapter.getSectionForPosition((adapterPosition = childViewHolder.getAdapterPosition()))) < 0) {
                                return;
                            }
                            if (this.currentFirst != sectionForPosition || this.pinnedHeader == null) {
                                View sectionHeaderView = getSectionHeaderView(sectionForPosition, this.pinnedHeader);
                                this.pinnedHeader = sectionHeaderView;
                                sectionHeaderView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0));
                                View view4 = this.pinnedHeader;
                                view4.layout(0, 0, view4.getMeasuredWidth(), this.pinnedHeader.getMeasuredHeight());
                                this.currentFirst = sectionForPosition;
                            }
                            if (this.pinnedHeader != null && view3 != null && view3.getClass() != this.pinnedHeader.getClass()) {
                                this.pinnedHeaderShadowTargetAlpha = 1.0f;
                            }
                            int countForSection = this.sectionsAdapter.getCountForSection(sectionForPosition);
                            int positionInSectionForPosition = this.sectionsAdapter.getPositionInSectionForPosition(adapterPosition);
                            int i5 = (iMax == 0 || iMax >= getMeasuredHeight() - getPaddingBottom()) ? this.sectionOffset : 0;
                            if (positionInSectionForPosition == countForSection - 1) {
                                int height = this.pinnedHeader.getHeight();
                                int top2 = ((view2.getTop() - paddingTop) - this.sectionOffset) + view2.getHeight();
                                int i6 = top2 < height ? top2 - height : paddingTop;
                                if (i6 < 0) {
                                    this.pinnedHeader.setTag(Integer.valueOf(paddingTop + i5 + i6));
                                } else {
                                    this.pinnedHeader.setTag(Integer.valueOf(paddingTop + i5));
                                }
                            } else {
                                this.pinnedHeader.setTag(Integer.valueOf(paddingTop + i5));
                            }
                            invalidate();
                            return;
                        }
                        return;
                    }
                    int childCount2 = getChildCount();
                    int i7 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    View view5 = null;
                    int iMax2 = 0;
                    for (int i8 = 0; i8 < childCount2; i8++) {
                        View childAt2 = getChildAt(i8);
                        int bottom2 = childAt2.getBottom();
                        if (bottom2 > this.sectionOffset + paddingTop) {
                            if (bottom2 < i2) {
                                view5 = childAt2;
                                i2 = bottom2;
                            }
                            iMax2 = Math.max(iMax2, bottom2);
                            if (bottom2 >= this.sectionOffset + paddingTop + AndroidUtilities.dp(32.0f) && bottom2 < i7) {
                                i7 = bottom2;
                            }
                        }
                    }
                    if (view5 == null || (childViewHolder2 = getChildViewHolder(view5)) == null) {
                        return;
                    }
                    int adapterPosition2 = childViewHolder2.getAdapterPosition();
                    int iAbs = Math.abs(linearLayoutManager.findLastVisibleItemPosition() - adapterPosition2) + 1;
                    if (this.scrollingByUser && this.fastScroll != null) {
                        if (getAdapter() instanceof FastScrollAdapter) {
                            this.fastScroll.setProgress(Math.min(1.0f, adapterPosition2 / ((r6.getItemCount() - iAbs) + 1)));
                        }
                    }
                    this.headersCache.addAll(this.headers);
                    this.headers.clear();
                    if (this.sectionsAdapter.getItemCount() == 0) {
                        return;
                    }
                    if (this.currentFirst != adapterPosition2 || this.currentVisible != iAbs) {
                        this.currentFirst = adapterPosition2;
                        this.currentVisible = iAbs;
                        this.sectionsCount = 1;
                        int sectionForPosition2 = this.sectionsAdapter.getSectionForPosition(adapterPosition2);
                        this.startSection = sectionForPosition2;
                        int countForSection2 = (this.sectionsAdapter.getCountForSection(sectionForPosition2) + adapterPosition2) - this.sectionsAdapter.getPositionInSectionForPosition(adapterPosition2);
                        while (countForSection2 < adapterPosition2 + iAbs) {
                            countForSection2 += this.sectionsAdapter.getCountForSection(this.startSection + this.sectionsCount);
                            this.sectionsCount++;
                        }
                    }
                    int i9 = adapterPosition2;
                    for (int i10 = this.startSection; i10 < this.startSection + this.sectionsCount; i10++) {
                        if (this.headersCache.isEmpty()) {
                            view = null;
                        } else {
                            view = this.headersCache.get(0);
                            this.headersCache.remove(0);
                        }
                        View sectionHeaderView2 = getSectionHeaderView(i10, view);
                        this.headers.add(sectionHeaderView2);
                        int countForSection3 = this.sectionsAdapter.getCountForSection(i10);
                        if (i10 == this.startSection) {
                            int positionInSectionForPosition2 = this.sectionsAdapter.getPositionInSectionForPosition(i9);
                            if (positionInSectionForPosition2 == countForSection3 - 1) {
                                sectionHeaderView2.setTag(Integer.valueOf((-sectionHeaderView2.getHeight()) + paddingTop));
                            } else if (positionInSectionForPosition2 == countForSection3 - 2) {
                                View childAt3 = getChildAt(i9 - adapterPosition2);
                                if (childAt3 != null) {
                                    top = childAt3.getTop() + paddingTop;
                                } else {
                                    top = -AndroidUtilities.dp(100.0f);
                                }
                                sectionHeaderView2.setTag(Integer.valueOf(Math.min(top, 0)));
                            } else {
                                sectionHeaderView2.setTag(0);
                            }
                            countForSection3 -= this.sectionsAdapter.getPositionInSectionForPosition(adapterPosition2);
                        } else {
                            View childAt4 = getChildAt(i9 - adapterPosition2);
                            if (childAt4 != null) {
                                sectionHeaderView2.setTag(Integer.valueOf(childAt4.getTop() + paddingTop));
                            } else {
                                sectionHeaderView2.setTag(Integer.valueOf(-AndroidUtilities.dp(100.0f)));
                            }
                        }
                        i9 += countForSection3;
                    }
                    return;
                }
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int iAbs2 = Math.abs(linearLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1;
                if (iFindFirstVisibleItemPosition == -1 || !this.scrollingByUser || this.fastScroll == null) {
                    return;
                }
                if (getAdapter() instanceof FastScrollAdapter) {
                    this.fastScroll.setProgress(Math.min(1.0f, iFindFirstVisibleItemPosition / ((r5.getItemCount() - iAbs2) + 1)));
                }
            }
        }
    }

    public void setListSelectorColor(int color) {
        Theme.setSelectorDrawableColor(this.selectorDrawable, color, true);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setOnItemClickListener(OnItemClickListenerExtended listener) {
        this.onItemClickListenerExtended = listener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.onItemLongClickListener = listener;
        this.gestureDetector.setIsLongpressEnabled(listener != null);
    }

    public void setOnItemLongClickListener(OnItemLongClickListenerExtended listener) {
        this.onItemLongClickListenerExtended = listener;
        this.gestureDetector.setIsLongpressEnabled(listener != null);
    }

    public void setEmptyView(View view) {
        View view2 = this.emptyView;
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            view2.animate().setListener(null).cancel();
        }
        this.emptyView = view;
        if (this.animateEmptyView && view != null) {
            view.setVisibility(8);
        }
        if (this.isHidden) {
            View view3 = this.emptyView;
            if (view3 != null) {
                this.emptyViewAnimateToVisibility = 8;
                view3.setVisibility(8);
                return;
            }
            return;
        }
        this.emptyViewAnimateToVisibility = -1;
        checkIfEmpty(updateEmptyViewAnimated());
    }

    protected boolean updateEmptyViewAnimated() {
        return isAttachedToWindow();
    }

    public View getEmptyView() {
        return this.emptyView;
    }

    public void invalidateViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).invalidate();
        }
    }

    public void updateFastScrollColors() {
        FastScroll fastScroll = this.fastScroll;
        if (fastScroll != null) {
            fastScroll.updateColors();
        }
    }

    public void setPinnedHeaderShadowDrawable(Drawable drawable) {
        this.pinnedHeaderShadowDrawable = drawable;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.scrollEnabled && super.canScrollVertically(direction);
    }

    public void setScrollEnabled(boolean value) {
        this.scrollEnabled = value;
    }

    public void highlightRow(IntReturnCallback callback) {
        highlightRowInternal(callback, true);
    }

    private void highlightRowInternal(IntReturnCallback callback, boolean canHighlightLater) {
        Runnable runnable = this.removeHighlighSelectionRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.removeHighlighSelectionRunnable = null;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(callback.run());
        if (viewHolderFindViewHolderForAdapterPosition == null) {
            if (canHighlightLater) {
                this.pendingHighlightPosition = callback;
                return;
            }
            return;
        }
        positionSelector(viewHolderFindViewHolderForAdapterPosition.getLayoutPosition(), viewHolderFindViewHolderForAdapterPosition.itemView);
        Drawable drawable = this.selectorDrawable;
        if (drawable != null) {
            Drawable current = drawable.getCurrent();
            if (current instanceof TransitionDrawable) {
                if (this.onItemLongClickListener != null || this.onItemClickListenerExtended != null) {
                    ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                } else {
                    ((TransitionDrawable) current).resetTransition();
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.selectorDrawable.setHotspot(viewHolderFindViewHolderForAdapterPosition.itemView.getMeasuredWidth() / 2, viewHolderFindViewHolderForAdapterPosition.itemView.getMeasuredHeight() / 2);
            }
        }
        Drawable drawable2 = this.selectorDrawable;
        if (drawable2 != null && drawable2.isStateful() && this.selectorDrawable.setState(getDrawableStateForSelector())) {
            invalidateDrawable(this.selectorDrawable);
        }
        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$RecyclerListView$OBGycvwAOQKnOySZlOPp_iCRZCk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$highlightRowInternal$0$RecyclerListView();
            }
        };
        this.removeHighlighSelectionRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$highlightRowInternal$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$highlightRowInternal$0$RecyclerListView() {
        this.removeHighlighSelectionRunnable = null;
        this.pendingHighlightPosition = null;
        Drawable drawable = this.selectorDrawable;
        if (drawable != null) {
            Drawable current = drawable.getCurrent();
            if (current instanceof TransitionDrawable) {
                ((TransitionDrawable) current).resetTransition();
            }
        }
        Drawable drawable2 = this.selectorDrawable;
        if (drawable2 == null || !drawable2.isStateful()) {
            return;
        }
        this.selectorDrawable.setState(StateSet.NOTHING);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (!isEnabled()) {
            return false;
        }
        if (this.disallowInterceptTouchEvents) {
            requestDisallowInterceptTouchEvent(true);
        }
        OnInterceptTouchListener onInterceptTouchListener = this.onInterceptTouchListener;
        return (onInterceptTouchListener != null && onInterceptTouchListener.onInterceptTouchEvent(e)) || super.onInterceptTouchEvent(e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view;
        if (this.sectionsAdapter == null || (view = this.pinnedHeader) == null || view.getAlpha() == 0.0f || !this.pinnedHeader.dispatchTouchEvent(ev)) {
            return super.dispatchTouchEvent(ev);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIfEmpty(boolean animated) {
        if (this.isHidden) {
            return;
        }
        if (getAdapter() == null || this.emptyView == null) {
            if (!this.hiddenByEmptyView || getVisibility() == 0) {
                return;
            }
            setVisibility(0);
            this.hiddenByEmptyView = false;
            return;
        }
        boolean zEmptyViewIsVisible = emptyViewIsVisible();
        int i = zEmptyViewIsVisible ? 0 : 8;
        if (!this.animateEmptyView) {
            animated = false;
        }
        if (animated) {
            if (this.emptyViewAnimateToVisibility != i) {
                this.emptyViewAnimateToVisibility = i;
                if (i == 0) {
                    this.emptyView.animate().setListener(null).cancel();
                    if (this.emptyView.getVisibility() == 8) {
                        this.emptyView.setVisibility(0);
                        this.emptyView.setAlpha(0.0f);
                        if (this.emptyViewAnimationType == 1) {
                            this.emptyView.setScaleX(0.7f);
                            this.emptyView.setScaleY(0.7f);
                        }
                    }
                    this.emptyView.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(150L).start();
                } else if (this.emptyView.getVisibility() != 8) {
                    ViewPropertyAnimator viewPropertyAnimatorAlpha = this.emptyView.animate().alpha(0.0f);
                    if (this.emptyViewAnimationType == 1) {
                        viewPropertyAnimatorAlpha.scaleY(0.7f).scaleX(0.7f);
                    }
                    viewPropertyAnimatorAlpha.setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.RecyclerListView.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (RecyclerListView.this.emptyView != null) {
                                RecyclerListView.this.emptyView.setVisibility(8);
                            }
                        }
                    }).start();
                }
            }
        } else {
            this.emptyViewAnimateToVisibility = i;
            this.emptyView.setVisibility(i);
            this.emptyView.setAlpha(1.0f);
        }
        if (this.hideIfEmpty) {
            int i2 = zEmptyViewIsVisible ? 4 : 0;
            if (getVisibility() != i2) {
                setVisibility(i2);
            }
            this.hiddenByEmptyView = true;
        }
    }

    protected boolean emptyViewIsVisible() {
        return (getAdapter() == null || isFastScrollAnimationRunning() || getAdapter().getItemCount() != 0) ? false : true;
    }

    public void hide() {
        if (this.isHidden) {
            return;
        }
        this.isHidden = true;
        if (getVisibility() != 8) {
            setVisibility(8);
        }
        View view = this.emptyView;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        this.emptyView.setVisibility(8);
    }

    public void show() {
        if (this.isHidden) {
            this.isHidden = false;
            checkIfEmpty(false);
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility != 0) {
            this.hiddenByEmptyView = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setOnScrollListener(RecyclerView.OnScrollListener listener) {
        this.onScrollListener = listener;
    }

    public void setHideIfEmpty(boolean value) {
        this.hideIfEmpty = value;
    }

    public RecyclerView.OnScrollListener getOnScrollListener() {
        return this.onScrollListener;
    }

    public void setOnInterceptTouchListener(OnInterceptTouchListener listener) {
        this.onInterceptTouchListener = listener;
    }

    public void setInstantClick(boolean value) {
        this.instantClick = value;
    }

    public void setDisallowInterceptTouchEvents(boolean value) {
        this.disallowInterceptTouchEvents = value;
    }

    public void setFastScrollEnabled() {
        this.fastScroll = new FastScroll(getContext());
        if (getParent() != null) {
            ((ViewGroup) getParent()).addView(this.fastScroll);
        }
    }

    public void setFastScrollVisible(boolean value) {
        FastScroll fastScroll = this.fastScroll;
        if (fastScroll == null) {
            return;
        }
        fastScroll.setVisibility(value ? 0 : 8);
    }

    public void setSectionsType(int type) {
        this.sectionsType = type;
        if (type == 1) {
            this.headers = new ArrayList<>();
            this.headersCache = new ArrayList<>();
        }
    }

    public void setPinnedSectionOffsetY(int offset) {
        this.sectionOffset = offset;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void positionSelector(int position, View sel) {
        positionSelector(position, sel, false, -1.0f, -1.0f);
    }

    private void positionSelector(int position, View sel, boolean manageHotspot, float x, float y) {
        Runnable runnable = this.removeHighlighSelectionRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.removeHighlighSelectionRunnable = null;
            this.pendingHighlightPosition = null;
        }
        if (this.selectorDrawable == null) {
            return;
        }
        boolean z = position != this.selectorPosition;
        int selectionBottomPadding = getAdapter() instanceof SelectionAdapter ? ((SelectionAdapter) getAdapter()).getSelectionBottomPadding(sel) : 0;
        if (position != -1) {
            this.selectorPosition = position;
        }
        if (this.topBottomSelectorRadius > 0 && getAdapter() != null) {
            Theme.setMaskDrawableRad(this.selectorDrawable, position == 0 ? this.topBottomSelectorRadius : 0, position == getAdapter().getItemCount() + (-2) ? this.topBottomSelectorRadius : 0);
        }
        this.selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom() - selectionBottomPadding);
        boolean zIsEnabled = sel.isEnabled();
        if (this.isChildViewEnabled != zIsEnabled) {
            this.isChildViewEnabled = zIsEnabled;
        }
        if (z) {
            this.selectorDrawable.setVisible(false, false);
            this.selectorDrawable.setState(StateSet.NOTHING);
        }
        this.selectorDrawable.setBounds(this.selectorRect);
        if (z && getVisibility() == 0) {
            this.selectorDrawable.setVisible(true, false);
        }
        if (Build.VERSION.SDK_INT < 21 || !manageHotspot) {
            return;
        }
        this.selectorDrawable.setHotspot(x, y);
    }

    public void setAllowItemsInteractionDuringAnimation(boolean value) {
        this.allowItemsInteractionDuringAnimation = value;
    }

    public void hideSelector(boolean animated) {
        View view = this.currentChildView;
        if (view != null) {
            onChildPressed(view, 0.0f, 0.0f, false);
            this.currentChildView = null;
            if (animated) {
                removeSelection(view, null);
            }
        }
        if (animated) {
            return;
        }
        this.selectorDrawable.setState(StateSet.NOTHING);
        this.selectorRect.setEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectorState() {
        Drawable drawable = this.selectorDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        if (this.currentChildView != null) {
            if (this.selectorDrawable.setState(getDrawableStateForSelector())) {
                invalidateDrawable(this.selectorDrawable);
            }
        } else if (this.removeHighlighSelectionRunnable == null) {
            this.selectorDrawable.setState(StateSet.NOTHING);
        }
    }

    private int[] getDrawableStateForSelector() {
        int[] iArrOnCreateDrawableState = onCreateDrawableState(1);
        iArrOnCreateDrawableState[iArrOnCreateDrawableState.length - 1] = 16842919;
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onChildAttachedToWindow(View child) {
        if (getAdapter() instanceof SelectionAdapter) {
            RecyclerView.ViewHolder viewHolderFindContainingViewHolder = findContainingViewHolder(child);
            if (viewHolderFindContainingViewHolder != null) {
                child.setEnabled(((SelectionAdapter) getAdapter()).isEnabled(viewHolderFindContainingViewHolder));
            }
        } else {
            child.setEnabled(false);
        }
        super.onChildAttachedToWindow(child);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.selectorDrawable == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.selectorDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FastScroll fastScroll = this.fastScroll;
        if (fastScroll == null || fastScroll.getParent() == getParent()) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.fastScroll.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.fastScroll);
        }
        ((ViewGroup) getParent()).addView(this.fastScroll);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.observer);
        }
        ArrayList<View> arrayList = this.headers;
        if (arrayList != null) {
            arrayList.clear();
            this.headersCache.clear();
        }
        this.currentFirst = -1;
        this.selectorPosition = -1;
        this.selectorRect.setEmpty();
        this.pinnedHeader = null;
        if (adapter instanceof SectionsAdapter) {
            this.sectionsAdapter = (SectionsAdapter) adapter;
        } else {
            this.sectionsAdapter = null;
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.observer);
        }
        checkIfEmpty(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void stopScroll() {
        try {
            super.stopScroll();
        } catch (NullPointerException unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        if (this.longPressCalled) {
            OnItemLongClickListenerExtended onItemLongClickListenerExtended = this.onItemLongClickListenerExtended;
            if (onItemLongClickListenerExtended != null) {
                onItemLongClickListenerExtended.onMove(dx, dy);
            }
            consumed[0] = dx;
            consumed[1] = dy;
            return true;
        }
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type);
    }

    private View getSectionHeaderView(int section, View oldView) {
        boolean z = oldView == null;
        View sectionHeaderView = this.sectionsAdapter.getSectionHeaderView(section, oldView);
        if (z) {
            ensurePinnedHeaderLayout(sectionHeaderView, false);
        }
        return sectionHeaderView;
    }

    private void ensurePinnedHeaderLayout(View header, boolean forceLayout) {
        if (header == null) {
            return;
        }
        if (header.isLayoutRequested() || forceLayout) {
            int i = this.sectionsType;
            if (i == 1) {
                ViewGroup.LayoutParams layoutParams = header.getLayoutParams();
                try {
                    header.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else if (i == 2) {
                try {
                    header.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            header.layout(0, 0, header.getMeasuredWidth(), header.getMeasuredHeight());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        View view;
        super.onSizeChanged(w, h, oldw, oldh);
        FrameLayout frameLayout = this.overlayContainer;
        if (frameLayout != null) {
            frameLayout.requestLayout();
        }
        int i = this.sectionsType;
        if (i == 1) {
            if (this.sectionsAdapter == null || this.headers.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < this.headers.size(); i2++) {
                ensurePinnedHeaderLayout(this.headers.get(i2), true);
            }
            return;
        }
        if (i != 2 || this.sectionsAdapter == null || (view = this.pinnedHeader) == null) {
            return;
        }
        ensurePinnedHeaderLayout(view, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View view;
        if (this.drawSelectorBehind && !this.selectorRect.isEmpty()) {
            this.selectorDrawable.setBounds(this.selectorRect);
            this.selectorDrawable.draw(canvas);
        }
        super.dispatchDraw(canvas);
        if (!this.drawSelectorBehind && !this.selectorRect.isEmpty()) {
            this.selectorDrawable.setBounds(this.selectorRect);
            this.selectorDrawable.draw(canvas);
        }
        FrameLayout frameLayout = this.overlayContainer;
        if (frameLayout != null) {
            frameLayout.draw(canvas);
        }
        int i = this.sectionsType;
        if (i == 1) {
            if (this.sectionsAdapter == null || this.headers.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < this.headers.size(); i2++) {
                View view2 = this.headers.get(i2);
                int iSave = canvas.save();
                canvas.translate(LocaleController.isRTL ? getWidth() - view2.getWidth() : 0.0f, ((Integer) view2.getTag()).intValue());
                canvas.clipRect(0, 0, getWidth(), view2.getMeasuredHeight());
                view2.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            return;
        }
        if (i != 2 || this.sectionsAdapter == null || (view = this.pinnedHeader) == null || view.getAlpha() == 0.0f) {
            return;
        }
        int iSave2 = canvas.save();
        canvas.translate(LocaleController.isRTL ? getWidth() - this.pinnedHeader.getWidth() : 0.0f, ((Integer) this.pinnedHeader.getTag()).intValue());
        Drawable drawable = this.pinnedHeaderShadowDrawable;
        if (drawable != null) {
            drawable.setBounds(0, this.pinnedHeader.getMeasuredHeight(), getWidth(), this.pinnedHeader.getMeasuredHeight() + this.pinnedHeaderShadowDrawable.getIntrinsicHeight());
            this.pinnedHeaderShadowDrawable.setAlpha((int) (this.pinnedHeaderShadowAlpha * 255.0f));
            this.pinnedHeaderShadowDrawable.draw(canvas);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMin = Math.min(20L, jElapsedRealtime - this.lastAlphaAnimationTime);
            this.lastAlphaAnimationTime = jElapsedRealtime;
            float f = this.pinnedHeaderShadowAlpha;
            float f2 = this.pinnedHeaderShadowTargetAlpha;
            if (f < f2) {
                float f3 = f + (jMin / 180.0f);
                this.pinnedHeaderShadowAlpha = f3;
                if (f3 > f2) {
                    this.pinnedHeaderShadowAlpha = f2;
                }
                invalidate();
            } else if (f > f2) {
                float f4 = f - (jMin / 180.0f);
                this.pinnedHeaderShadowAlpha = f4;
                if (f4 < f2) {
                    this.pinnedHeaderShadowAlpha = f2;
                }
                invalidate();
            }
        }
        canvas.clipRect(0, 0, getWidth(), this.pinnedHeader.getMeasuredHeight());
        this.pinnedHeader.draw(canvas);
        canvas.restoreToCount(iSave2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.selectorPosition = -1;
        this.selectorRect.setEmpty();
    }

    public void addOverlayView(View view, FrameLayout.LayoutParams layoutParams) {
        if (this.overlayContainer == null) {
            this.overlayContainer = new FrameLayout(getContext()) { // from class: ir.eitaa.ui.Components.RecyclerListView.4
                @Override // android.view.View, android.view.ViewParent
                public void requestLayout() {
                    super.requestLayout();
                    try {
                        measure(View.MeasureSpec.makeMeasureSpec(RecyclerListView.this.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(RecyclerListView.this.getMeasuredHeight(), 1073741824));
                        layout(0, 0, RecyclerListView.this.overlayContainer.getMeasuredWidth(), RecyclerListView.this.overlayContainer.getMeasuredHeight());
                    } catch (Exception unused) {
                    }
                }
            };
        }
        this.overlayContainer.addView(view, layoutParams);
    }

    public ArrayList<View> getHeaders() {
        return this.headers;
    }

    public ArrayList<View> getHeadersCache() {
        return this.headersCache;
    }

    public View getPinnedHeader() {
        return this.pinnedHeader;
    }

    public boolean isFastScrollAnimationRunning() {
        return this.fastScrollAnimationRunning;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.fastScrollAnimationRunning) {
            return;
        }
        super.requestLayout();
    }

    public void setAnimateEmptyView(boolean animate, int emptyViewAnimationType) {
        this.animateEmptyView = animate;
        this.emptyViewAnimationType = emptyViewAnimationType;
    }

    public static class FoucsableOnTouchListener implements View.OnTouchListener {
        private boolean onFocus;
        private float x;
        private float y;

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            ViewParent parent = v.getParent();
            if (parent == null) {
                return false;
            }
            if (event.getAction() == 0) {
                this.x = event.getX();
                this.y = event.getY();
                this.onFocus = true;
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (event.getAction() == 2) {
                float x = this.x - event.getX();
                float y = this.y - event.getY();
                float scaledTouchSlop = ViewConfiguration.get(v.getContext()).getScaledTouchSlop();
                if (this.onFocus && Math.sqrt((x * x) + (y * y)) > scaledTouchSlop) {
                    this.onFocus = false;
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (event.getAction() == 1 || event.getAction() == 3) {
                this.onFocus = false;
                parent.requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        FastScroll fastScroll = this.fastScroll;
        if (fastScroll != null) {
            fastScroll.setTranslationY(translationY);
        }
    }

    public void startMultiselect(int positionFrom, boolean useRelativePositions, onMultiSelectionChanged multiSelectionListener) {
        if (!this.multiSelectionGesture) {
            this.listPaddings = new int[2];
            this.selectedPositions = new HashSet<>();
            getParent().requestDisallowInterceptTouchEvent(true);
            this.multiSelectionListener = multiSelectionListener;
            this.multiSelectionGesture = true;
            this.currentSelectedPosition = positionFrom;
            this.startSelectionFrom = positionFrom;
        }
        this.useRelativePositions = useRelativePositions;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent e) {
        if (this.multiSelectionGesture && e.getAction() != 0 && e.getAction() != 1 && e.getAction() != 3) {
            if (this.lastX == Float.MAX_VALUE && this.lastY == Float.MAX_VALUE) {
                this.lastX = e.getX();
                this.lastY = e.getY();
            }
            if (!this.multiSelectionGestureStarted && Math.abs(e.getY() - this.lastY) > this.touchSlop) {
                this.multiSelectionGestureStarted = true;
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (this.multiSelectionGestureStarted) {
                chekMultiselect(e.getX(), e.getY());
                this.multiSelectionListener.getPaddings(this.listPaddings);
                if (e.getY() > (getMeasuredHeight() - AndroidUtilities.dp(56.0f)) - this.listPaddings[1] && (this.currentSelectedPosition >= this.startSelectionFrom || !this.multiSelectionListener.limitReached())) {
                    startMultiselectScroll(false);
                } else if (e.getY() < AndroidUtilities.dp(56.0f) + this.listPaddings[0] && (this.currentSelectedPosition <= this.startSelectionFrom || !this.multiSelectionListener.limitReached())) {
                    startMultiselectScroll(true);
                } else {
                    cancelMultiselectScroll();
                }
            }
            return true;
        }
        this.lastX = Float.MAX_VALUE;
        this.lastY = Float.MAX_VALUE;
        this.multiSelectionGesture = false;
        this.multiSelectionGestureStarted = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        cancelMultiselectScroll();
        return super.onTouchEvent(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chekMultiselect(float x, float y) {
        int measuredHeight = getMeasuredHeight();
        int[] iArr = this.listPaddings;
        float fMin = Math.min(measuredHeight - iArr[1], Math.max(y, iArr[0]));
        float fMin2 = Math.min(getMeasuredWidth(), Math.max(x, 0.0f));
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            }
            this.multiSelectionListener.getPaddings(this.listPaddings);
            if (!this.useRelativePositions) {
                View childAt = getChildAt(i);
                RectF rectF = AndroidUtilities.rectTmp;
                rectF.set(childAt.getLeft(), childAt.getTop(), childAt.getLeft() + childAt.getMeasuredWidth(), childAt.getTop() + childAt.getMeasuredHeight());
                if (rectF.contains(fMin2, fMin)) {
                    int childLayoutPosition = getChildLayoutPosition(childAt);
                    int i2 = this.currentSelectedPosition;
                    if (i2 != childLayoutPosition) {
                        int i3 = this.startSelectionFrom;
                        boolean z = i2 > i3 || childLayoutPosition > i3;
                        childLayoutPosition = this.multiSelectionListener.checkPosition(childLayoutPosition, z);
                        if (z) {
                            int i4 = this.currentSelectedPosition;
                            if (childLayoutPosition <= i4) {
                                while (i4 > childLayoutPosition) {
                                    if (i4 != this.startSelectionFrom && this.multiSelectionListener.canSelect(i4)) {
                                        this.multiSelectionListener.onSelectionChanged(i4, false, fMin2, fMin);
                                    }
                                    i4--;
                                }
                            } else if (!this.multiSelectionListener.limitReached()) {
                                for (int i5 = this.currentSelectedPosition + 1; i5 <= childLayoutPosition; i5++) {
                                    if (i5 != this.startSelectionFrom && this.multiSelectionListener.canSelect(i5)) {
                                        this.multiSelectionListener.onSelectionChanged(i5, true, fMin2, fMin);
                                    }
                                }
                            }
                        } else {
                            int i6 = this.currentSelectedPosition;
                            if (childLayoutPosition > i6) {
                                while (i6 < childLayoutPosition) {
                                    if (i6 != this.startSelectionFrom && this.multiSelectionListener.canSelect(i6)) {
                                        this.multiSelectionListener.onSelectionChanged(i6, false, fMin2, fMin);
                                    }
                                    i6++;
                                }
                            } else if (!this.multiSelectionListener.limitReached()) {
                                for (int i7 = this.currentSelectedPosition - 1; i7 >= childLayoutPosition; i7--) {
                                    if (i7 != this.startSelectionFrom && this.multiSelectionListener.canSelect(i7)) {
                                        this.multiSelectionListener.onSelectionChanged(i7, true, fMin2, fMin);
                                    }
                                }
                            }
                        }
                    }
                    if (!this.multiSelectionListener.limitReached()) {
                        this.currentSelectedPosition = childLayoutPosition;
                    }
                }
            }
            i++;
        }
        return true;
    }

    private void cancelMultiselectScroll() {
        this.multiselectScrollRunning = false;
        AndroidUtilities.cancelRunOnUIThread(this.scroller);
    }

    private void startMultiselectScroll(boolean top) {
        this.multiselectScrollToTop = top;
        if (this.multiselectScrollRunning) {
            return;
        }
        this.multiselectScrollRunning = true;
        AndroidUtilities.cancelRunOnUIThread(this.scroller);
        AndroidUtilities.runOnUIThread(this.scroller);
    }

    public boolean isMultiselect() {
        return this.multiSelectionGesture;
    }

    protected int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    protected Drawable getThemedDrawable(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Drawable drawable = resourcesProvider != null ? resourcesProvider.getDrawable(key) : null;
        return drawable != null ? drawable : Theme.getThemeDrawable(key);
    }

    protected Paint getThemedPaint(String paintKey) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Paint paint = resourcesProvider != null ? resourcesProvider.getPaint(paintKey) : null;
        return paint != null ? paint : Theme.getThemePaint(paintKey);
    }
}
