package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.util.StateSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class RecyclerListViewEdited extends RecyclerView {
    private static int[] attributes;
    private static boolean gotAttributes;
    private boolean allowItemsInteractionDuringAnimation;
    private Runnable clickRunnable;
    private int currentChildPosition;
    private View currentChildView;
    private int currentFirst;
    private int currentVisible;
    private boolean disableHighlightState;
    private boolean disallowInterceptTouchEvents;
    private boolean drawSelectorBehind;
    private View emptyView;
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
    private boolean longPressCalled;
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
    public boolean scrollAnimationRunning;
    private boolean scrollEnabled;
    private boolean scrollingByUser;
    private int sectionOffset;
    private SectionsAdapter sectionsAdapter;
    private int sectionsCount;
    private int sectionsType;
    private Runnable selectChildRunnable;
    protected Drawable selectorDrawable;
    protected int selectorPosition;
    protected Rect selectorRect;
    private int selectorType;
    private int startSection;

    public static abstract class FastScrollAdapter extends SelectionAdapter {
    }

    public interface IntReturnCallback {
        int run();
    }

    public interface OnInterceptTouchListener {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public interface OnItemClickListenerExtended {
        void onItemClick(View view, int i, float f, float f2);
    }

    public interface OnItemLongClickListener {
        boolean onItemClick(View view, int i);
    }

    public interface OnItemLongClickListenerExtended {
        boolean onItemClick(View view, int i, float f, float f2);

        void onLongClickRelease();

        void onMove(float f, float f2);
    }

    public static abstract class SelectionAdapter extends RecyclerView.Adapter {
        public int getSelectionBottomPadding(View view) {
            return 0;
        }

        public abstract boolean isEnabled(RecyclerView.ViewHolder viewHolder);
    }

    protected boolean allowSelectChildAtPosition(float f, float f2) {
        return true;
    }

    protected boolean allowSelectChildAtPosition(View view) {
        return true;
    }

    protected boolean canHighlightChildAt(View view, float f, float f2) {
        return true;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void setFastScrollVisible(boolean z) {
    }

    public static abstract class SectionsAdapter extends FastScrollAdapter {
        private int count;
        private SparseIntArray sectionCache;
        private int sectionCount;
        private SparseIntArray sectionCountCache;
        private SparseIntArray sectionPositionCache;

        public abstract int getCountForSection(int i);

        public abstract int getItemViewType(int i, int i2);

        public abstract int getSectionCount();

        public abstract View getSectionHeaderView(int i, View view);

        public abstract boolean isEnabled(int i, int i2);

        public abstract void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder);

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

        public SectionsAdapter() {
            cleanupCache();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            cleanupCache();
            super.notifyDataSetChanged();
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return isEnabled(getSectionForPosition(adapterPosition), getPositionInSectionForPosition(adapterPosition));
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

        public int getPositionForPositionInSection(int i, int i2) {
            int iInternalGetSectionCount = internalGetSectionCount();
            int iInternalGetCountForSection = 0;
            for (int i3 = 0; i3 < iInternalGetSectionCount && i3 < i; i3++) {
                iInternalGetCountForSection += internalGetCountForSection(i3);
            }
            return iInternalGetCountForSection + i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i) {
            return getItemViewType(getSectionForPosition(i), getPositionInSectionForPosition(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            onBindViewHolder(getSectionForPosition(i), getPositionInSectionForPosition(i), viewHolder);
        }

        private int internalGetCountForSection(int i) {
            int i2 = this.sectionCountCache.get(i, ConnectionsManager.DEFAULT_DATACENTER_ID);
            if (i2 != Integer.MAX_VALUE) {
                return i2;
            }
            int countForSection = getCountForSection(i);
            this.sectionCountCache.put(i, countForSection);
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

        public final int getSectionForPosition(int i) {
            int i2 = this.sectionCache.get(i, ConnectionsManager.DEFAULT_DATACENTER_ID);
            if (i2 != Integer.MAX_VALUE) {
                return i2;
            }
            int iInternalGetSectionCount = internalGetSectionCount();
            int i3 = 0;
            int i4 = 0;
            while (i3 < iInternalGetSectionCount) {
                int iInternalGetCountForSection = internalGetCountForSection(i3) + i4;
                if (i >= i4 && i < iInternalGetCountForSection) {
                    this.sectionCache.put(i, i3);
                    return i3;
                }
                i3++;
                i4 = iInternalGetCountForSection;
            }
            return -1;
        }

        public int getPositionInSectionForPosition(int i) {
            int i2 = this.sectionPositionCache.get(i, ConnectionsManager.DEFAULT_DATACENTER_ID);
            if (i2 != Integer.MAX_VALUE) {
                return i2;
            }
            int iInternalGetSectionCount = internalGetSectionCount();
            int i3 = 0;
            int i4 = 0;
            while (i3 < iInternalGetSectionCount) {
                int iInternalGetCountForSection = internalGetCountForSection(i3) + i4;
                if (i >= i4 && i < iInternalGetCountForSection) {
                    int i5 = i - i4;
                    this.sectionPositionCache.put(i, i5);
                    return i5;
                }
                i3++;
                i4 = iInternalGetCountForSection;
            }
            return -1;
        }
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public Holder(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class RecyclerListViewItemClickListener implements RecyclerView.OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        public RecyclerListViewItemClickListener(Context context) {
            RecyclerListViewEdited.this.gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener(RecyclerListViewEdited.this) { // from class: ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.RecyclerListViewItemClickListener.1
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent motionEvent) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    if (RecyclerListViewEdited.this.currentChildView != null && (RecyclerListViewEdited.this.onItemClickListener != null || RecyclerListViewEdited.this.onItemClickListenerExtended != null)) {
                        final float x = motionEvent.getX();
                        final float y = motionEvent.getY();
                        RecyclerListViewEdited recyclerListViewEdited = RecyclerListViewEdited.this;
                        recyclerListViewEdited.onChildPressed(recyclerListViewEdited.currentChildView, x, y, true);
                        final View view = RecyclerListViewEdited.this.currentChildView;
                        final int i = RecyclerListViewEdited.this.currentChildPosition;
                        if (RecyclerListViewEdited.this.instantClick && i != -1) {
                            view.playSoundEffect(0);
                            view.sendAccessibilityEvent(1);
                            if (RecyclerListViewEdited.this.onItemClickListener != null) {
                                RecyclerListViewEdited.this.onItemClickListener.onItemClick(view, i);
                            } else if (RecyclerListViewEdited.this.onItemClickListenerExtended != null) {
                                RecyclerListViewEdited.this.onItemClickListenerExtended.onItemClick(view, i, x - view.getX(), y - view.getY());
                            }
                        }
                        AndroidUtilities.runOnUIThread(RecyclerListViewEdited.this.clickRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.RecyclerListViewItemClickListener.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (this == RecyclerListViewEdited.this.clickRunnable) {
                                    RecyclerListViewEdited.this.clickRunnable = null;
                                }
                                View view2 = view;
                                if (view2 != null) {
                                    RecyclerListViewEdited.this.onChildPressed(view2, 0.0f, 0.0f, false);
                                    if (RecyclerListViewEdited.this.instantClick) {
                                        return;
                                    }
                                    view.playSoundEffect(0);
                                    view.sendAccessibilityEvent(1);
                                    if (i != -1) {
                                        if (RecyclerListViewEdited.this.onItemClickListener != null) {
                                            RecyclerListViewEdited.this.onItemClickListener.onItemClick(view, i);
                                        } else if (RecyclerListViewEdited.this.onItemClickListenerExtended != null) {
                                            OnItemClickListenerExtended onItemClickListenerExtended = RecyclerListViewEdited.this.onItemClickListenerExtended;
                                            View view3 = view;
                                            onItemClickListenerExtended.onItemClick(view3, i, x - view3.getX(), y - view.getY());
                                        }
                                    }
                                }
                            }
                        }, ViewConfiguration.getPressedStateDuration());
                        if (RecyclerListViewEdited.this.selectChildRunnable != null) {
                            View view2 = RecyclerListViewEdited.this.currentChildView;
                            AndroidUtilities.cancelRunOnUIThread(RecyclerListViewEdited.this.selectChildRunnable);
                            RecyclerListViewEdited.this.selectChildRunnable = null;
                            RecyclerListViewEdited.this.currentChildView = null;
                            RecyclerListViewEdited.this.interceptedByChild = false;
                            RecyclerListViewEdited.this.removeSelection(view2, motionEvent);
                        }
                    }
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (RecyclerListViewEdited.this.currentChildView == null || RecyclerListViewEdited.this.currentChildPosition == -1) {
                        return;
                    }
                    if (RecyclerListViewEdited.this.onItemLongClickListener == null && RecyclerListViewEdited.this.onItemLongClickListenerExtended == null) {
                        return;
                    }
                    View view = RecyclerListViewEdited.this.currentChildView;
                    if (RecyclerListViewEdited.this.onItemLongClickListener != null) {
                        if (RecyclerListViewEdited.this.onItemLongClickListener.onItemClick(RecyclerListViewEdited.this.currentChildView, RecyclerListViewEdited.this.currentChildPosition)) {
                            view.performHapticFeedback(0);
                            view.sendAccessibilityEvent(2);
                            return;
                        }
                        return;
                    }
                    if (RecyclerListViewEdited.this.onItemLongClickListenerExtended == null || !RecyclerListViewEdited.this.onItemLongClickListenerExtended.onItemClick(RecyclerListViewEdited.this.currentChildView, RecyclerListViewEdited.this.currentChildPosition, motionEvent.getX() - RecyclerListViewEdited.this.currentChildView.getX(), motionEvent.getY() - RecyclerListViewEdited.this.currentChildView.getY())) {
                        return;
                    }
                    view.performHapticFeedback(0);
                    view.sendAccessibilityEvent(2);
                    RecyclerListViewEdited.this.longPressCalled = true;
                }
            });
            RecyclerListViewEdited.this.gestureDetector.setIsLongpressEnabled(false);
        }

        /* JADX WARN: Removed duplicated region for block: B:99:0x026d  */
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView r19, android.view.MotionEvent r20) {
            /*
                Method dump skipped, instructions count: 637
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.RecyclerListViewItemClickListener.onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInterceptTouchEvent$0(float f, float f2) {
            if (RecyclerListViewEdited.this.selectChildRunnable == null || RecyclerListViewEdited.this.currentChildView == null) {
                return;
            }
            RecyclerListViewEdited recyclerListViewEdited = RecyclerListViewEdited.this;
            recyclerListViewEdited.onChildPressed(recyclerListViewEdited.currentChildView, f, f2, true);
            RecyclerListViewEdited.this.selectChildRunnable = null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            RecyclerListViewEdited.this.cancelClickRunnables(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public View findChildViewUnder(float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        while (i < 2) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                float translationX = i == 0 ? childAt.getTranslationX() : 0.0f;
                float translationY = i == 0 ? childAt.getTranslationY() : 0.0f;
                if (f >= childAt.getLeft() + translationX && f <= childAt.getRight() + translationX && f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                    return childAt;
                }
            }
            i++;
        }
        return null;
    }

    public void setDisableHighlightState(boolean z) {
        this.disableHighlightState = z;
    }

    protected View getPressedChildView() {
        return this.currentChildView;
    }

    protected void onChildPressed(View view, float f, float f2, boolean z) {
        if (this.disableHighlightState) {
            return;
        }
        view.setPressed(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSelection(View view, MotionEvent motionEvent) {
        if (view == null || this.selectorRect.isEmpty()) {
            return;
        }
        if (view.isEnabled()) {
            positionSelector(this.currentChildPosition, view);
            Drawable drawable = this.selectorDrawable;
            if (drawable != null) {
                Drawable current = drawable.getCurrent();
                if (current instanceof TransitionDrawable) {
                    ((TransitionDrawable) current).resetTransition();
                }
                if (motionEvent != null && Build.VERSION.SDK_INT >= 21) {
                    this.selectorDrawable.setHotspot(motionEvent.getX(), motionEvent.getY());
                }
            }
        } else {
            this.selectorRect.setEmpty();
        }
        updateSelectorState();
    }

    public void cancelClickRunnables(boolean z) {
        Runnable runnable = this.selectChildRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.selectChildRunnable = null;
        }
        View view = this.currentChildView;
        if (view != null) {
            if (z) {
                onChildPressed(view, 0.0f, 0.0f, false);
            }
            this.currentChildView = null;
            removeSelection(view, null);
        }
        Runnable runnable2 = this.clickRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.clickRunnable = null;
        }
        this.interceptedByChild = false;
    }

    public int[] getResourceDeclareStyleableIntArray(String str, String str2) {
        try {
            Field field = Class.forName(str + ".R$styleable").getField(str2);
            if (field != null) {
                return (int[]) field.get(null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public RecyclerListViewEdited(Context context) {
        super(context);
        this.allowItemsInteractionDuringAnimation = true;
        this.currentFirst = -1;
        this.currentVisible = -1;
        this.hideIfEmpty = true;
        this.selectorType = 2;
        this.selectorRect = new Rect();
        this.scrollEnabled = true;
        this.observer = new RecyclerView.AdapterDataObserver() { // from class: ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                RecyclerListViewEdited.this.checkIfEmpty();
                RecyclerListViewEdited.this.currentFirst = -1;
                if (RecyclerListViewEdited.this.removeHighlighSelectionRunnable == null) {
                    RecyclerListViewEdited.this.selectorRect.setEmpty();
                }
                RecyclerListViewEdited.this.invalidate();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                RecyclerListViewEdited.this.checkIfEmpty();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                RecyclerListViewEdited.this.checkIfEmpty();
            }
        };
        Drawable selectorDrawable = Theme.getSelectorDrawable(false);
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
        super.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && RecyclerListViewEdited.this.currentChildView != null) {
                    if (RecyclerListViewEdited.this.selectChildRunnable != null) {
                        AndroidUtilities.cancelRunOnUIThread(RecyclerListViewEdited.this.selectChildRunnable);
                        RecyclerListViewEdited.this.selectChildRunnable = null;
                    }
                    MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                    try {
                        RecyclerListViewEdited.this.gestureDetector.onTouchEvent(motionEventObtain);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    RecyclerListViewEdited.this.currentChildView.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    View view = RecyclerListViewEdited.this.currentChildView;
                    RecyclerListViewEdited recyclerListViewEdited = RecyclerListViewEdited.this;
                    recyclerListViewEdited.onChildPressed(recyclerListViewEdited.currentChildView, 0.0f, 0.0f, false);
                    RecyclerListViewEdited.this.currentChildView = null;
                    RecyclerListViewEdited.this.removeSelection(view, null);
                    RecyclerListViewEdited.this.interceptedByChild = false;
                }
                if (RecyclerListViewEdited.this.onScrollListener != null) {
                    RecyclerListViewEdited.this.onScrollListener.onScrollStateChanged(recyclerView, i);
                }
                RecyclerListViewEdited.this.scrollingByUser = i == 1 || i == 2;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (RecyclerListViewEdited.this.onScrollListener != null) {
                    RecyclerListViewEdited.this.onScrollListener.onScrolled(recyclerView, i, i2);
                }
                RecyclerListViewEdited recyclerListViewEdited = RecyclerListViewEdited.this;
                if (recyclerListViewEdited.selectorPosition != -1) {
                    recyclerListViewEdited.selectorRect.offset(-i, -i2);
                    RecyclerListViewEdited recyclerListViewEdited2 = RecyclerListViewEdited.this;
                    recyclerListViewEdited2.selectorDrawable.setBounds(recyclerListViewEdited2.selectorRect);
                    RecyclerListViewEdited.this.invalidate();
                } else {
                    recyclerListViewEdited.selectorRect.setEmpty();
                }
                RecyclerListViewEdited.this.checkSection();
            }
        });
        addOnItemTouchListener(new RecyclerListViewItemClickListener(context));
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        if (attributes != null) {
            super.setVerticalScrollBarEnabled(z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        checkSection();
        IntReturnCallback intReturnCallback = this.pendingHighlightPosition;
        if (intReturnCallback != null) {
            highlightRowInternal(intReturnCallback, false);
        }
    }

    public void setSelectorType(int i) {
        this.selectorType = i;
    }

    public void setDrawSelectorBehind(boolean z) {
        this.drawSelectorBehind = z;
    }

    public void setSelectorDrawableColor(int i) {
        Drawable drawable = this.selectorDrawable;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        int i2 = this.selectorType;
        if (i2 == 2) {
            this.selectorDrawable = Theme.getSelectorDrawable(false);
        } else {
            this.selectorDrawable = Theme.createSelectorDrawable(i, i2);
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
        boolean z = this.scrollingByUser;
        if (this.sectionsType == 0 || this.sectionsAdapter == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.getOrientation() == 1) {
                if (this.sectionsAdapter != null) {
                    int paddingTop = getPaddingTop();
                    int i = this.sectionsType;
                    View view2 = null;
                    int i2 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    if (i != 1) {
                        if (i == 2) {
                            this.pinnedHeaderShadowTargetAlpha = 0.0f;
                            if (this.sectionsAdapter.getItemCount() == 0) {
                                return;
                            }
                            int childCount = getChildCount();
                            View view3 = null;
                            int i3 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                            int iMax = 0;
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
                    View view5 = null;
                    int i7 = ConnectionsManager.DEFAULT_DATACENTER_ID;
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
                    boolean z2 = this.scrollingByUser;
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
                Math.abs(linearLayoutManager.findLastVisibleItemPosition() - linearLayoutManager.findFirstVisibleItemPosition());
            }
        }
    }

    public void setListSelectorColor(int i) {
        Theme.setSelectorDrawableColor(this.selectorDrawable, i, true);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListenerExtended onItemClickListenerExtended) {
        this.onItemClickListenerExtended = onItemClickListenerExtended;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
        this.gestureDetector.setIsLongpressEnabled(onItemLongClickListener != null);
    }

    public void setOnItemLongClickListener(OnItemLongClickListenerExtended onItemLongClickListenerExtended) {
        this.onItemLongClickListenerExtended = onItemLongClickListenerExtended;
        this.gestureDetector.setIsLongpressEnabled(onItemLongClickListenerExtended != null);
    }

    public void setEmptyView(View view) {
        if (this.emptyView == view) {
            return;
        }
        this.emptyView = view;
        if (!this.isHidden) {
            checkIfEmpty();
        } else if (view != null) {
            view.setVisibility(8);
        }
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

    public void setPinnedHeaderShadowDrawable(Drawable drawable) {
        this.pinnedHeaderShadowDrawable = drawable;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.scrollEnabled && super.canScrollVertically(i);
    }

    public void setScrollEnabled(boolean z) {
        this.scrollEnabled = z;
    }

    private void highlightRowInternal(IntReturnCallback intReturnCallback, boolean z) {
        Runnable runnable = this.removeHighlighSelectionRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.removeHighlighSelectionRunnable = null;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(intReturnCallback.run());
        if (viewHolderFindViewHolderForAdapterPosition == null) {
            if (z) {
                this.pendingHighlightPosition = intReturnCallback;
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
        Runnable runnable2 = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$highlightRowInternal$0();
            }
        };
        this.removeHighlighSelectionRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$highlightRowInternal$0() {
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
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.disallowInterceptTouchEvents) {
            requestDisallowInterceptTouchEvent(true);
        }
        OnInterceptTouchListener onInterceptTouchListener = this.onInterceptTouchListener;
        return (onInterceptTouchListener != null && onInterceptTouchListener.onInterceptTouchEvent(motionEvent)) || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view;
        if (this.sectionsAdapter == null || (view = this.pinnedHeader) == null || view.getAlpha() == 0.0f || !this.pinnedHeader.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void checkIfEmpty() {
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
        boolean z = getAdapter().getItemCount() == 0;
        int i = z ? 0 : 8;
        if (this.emptyView.getVisibility() != i) {
            this.emptyView.setVisibility(i);
        }
        if (this.hideIfEmpty) {
            int i2 = z ? 4 : 0;
            if (getVisibility() != i2) {
                setVisibility(i2);
            }
            this.hiddenByEmptyView = true;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            this.hiddenByEmptyView = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public void setHideIfEmpty(boolean z) {
        this.hideIfEmpty = z;
    }

    public RecyclerView.OnScrollListener getOnScrollListener() {
        return this.onScrollListener;
    }

    public void setOnInterceptTouchListener(OnInterceptTouchListener onInterceptTouchListener) {
        this.onInterceptTouchListener = onInterceptTouchListener;
    }

    public void setInstantClick(boolean z) {
        this.instantClick = z;
    }

    public void setDisallowInterceptTouchEvents(boolean z) {
        this.disallowInterceptTouchEvents = z;
    }

    public void setSectionsType(int i) {
        this.sectionsType = i;
        if (i == 1) {
            this.headers = new ArrayList<>();
            this.headersCache = new ArrayList<>();
        }
    }

    public void setPinnedSectionOffsetY(int i) {
        this.sectionOffset = i;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void positionSelector(int i, View view) {
        positionSelector(i, view, false, -1.0f, -1.0f);
    }

    private void positionSelector(int i, View view, boolean z, float f, float f2) {
        Runnable runnable = this.removeHighlighSelectionRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.removeHighlighSelectionRunnable = null;
            this.pendingHighlightPosition = null;
        }
        if (this.selectorDrawable == null) {
            return;
        }
        boolean z2 = i != this.selectorPosition;
        int selectionBottomPadding = getAdapter() instanceof SelectionAdapter ? ((SelectionAdapter) getAdapter()).getSelectionBottomPadding(view) : 0;
        if (i != -1) {
            this.selectorPosition = i;
        }
        this.selectorRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom() - selectionBottomPadding);
        boolean zIsEnabled = view.isEnabled();
        if (this.isChildViewEnabled != zIsEnabled) {
            this.isChildViewEnabled = zIsEnabled;
        }
        if (z2) {
            this.selectorDrawable.setVisible(false, false);
            this.selectorDrawable.setState(StateSet.NOTHING);
        }
        this.selectorDrawable.setBounds(this.selectorRect);
        if (z2 && getVisibility() == 0) {
            this.selectorDrawable.setVisible(true, false);
        }
        if (Build.VERSION.SDK_INT < 21 || !z) {
            return;
        }
        this.selectorDrawable.setHotspot(f, f2);
    }

    public void setAllowItemsInteractionDuringAnimation(boolean z) {
        this.allowItemsInteractionDuringAnimation = z;
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
    public void onChildAttachedToWindow(View view) {
        if (getAdapter() instanceof SelectionAdapter) {
            RecyclerView.ViewHolder viewHolderFindContainingViewHolder = findContainingViewHolder(view);
            if (viewHolderFindContainingViewHolder != null) {
                view.setEnabled(((SelectionAdapter) getAdapter()).isEnabled(viewHolderFindContainingViewHolder));
            }
        } else {
            view.setEnabled(false);
        }
        super.onChildAttachedToWindow(view);
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
        checkIfEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void stopScroll() {
        try {
            super.stopScroll();
        } catch (NullPointerException unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (this.longPressCalled) {
            OnItemLongClickListenerExtended onItemLongClickListenerExtended = this.onItemLongClickListenerExtended;
            if (onItemLongClickListenerExtended != null) {
                onItemLongClickListenerExtended.onMove(i, i2);
            }
            iArr[0] = i;
            iArr[1] = i2;
            return true;
        }
        return super.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    private View getSectionHeaderView(int i, View view) {
        boolean z = view == null;
        View sectionHeaderView = this.sectionsAdapter.getSectionHeaderView(i, view);
        if (z) {
            ensurePinnedHeaderLayout(sectionHeaderView, false);
        }
        return sectionHeaderView;
    }

    private void ensurePinnedHeaderLayout(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (view.isLayoutRequested() || z) {
            int i = this.sectionsType;
            if (i == 1) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                try {
                    view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else if (i == 2) {
                try {
                    view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        View view;
        super.onSizeChanged(i, i2, i3, i4);
        FrameLayout frameLayout = this.overlayContainer;
        if (frameLayout != null) {
            frameLayout.requestLayout();
        }
        int i5 = this.sectionsType;
        if (i5 == 1) {
            if (this.sectionsAdapter == null || this.headers.isEmpty()) {
                return;
            }
            for (int i6 = 0; i6 < this.headers.size(); i6++) {
                ensurePinnedHeaderLayout(this.headers.get(i6), true);
            }
            return;
        }
        if (i5 != 2 || this.sectionsAdapter == null || (view = this.pinnedHeader) == null) {
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

    public ArrayList<View> getHeaders() {
        return this.headers;
    }

    public ArrayList<View> getHeadersCache() {
        return this.headersCache;
    }

    public View getPinnedHeader() {
        return this.pinnedHeader;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.scrollAnimationRunning) {
            return;
        }
        super.requestLayout();
    }
}
