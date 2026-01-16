package ir.nasim.features.media.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C19406qI3;
import java.lang.reflect.Field;

/* loaded from: classes6.dex */
public class RecyclerListView extends RecyclerView {
    private static int[] L1;
    private static boolean M1;
    private OnItemClickListener B1;
    private RecyclerView.t C1;
    private View D1;
    private Runnable E1;
    private GestureDetector F1;
    private View G1;
    private int H1;
    private boolean I1;
    private Runnable J1;
    private RecyclerView.j K1;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    class a extends RecyclerView.j {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            RecyclerListView.this.l1();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2) {
            RecyclerListView.this.l1();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void f(int i, int i2) {
            RecyclerListView.this.l1();
        }
    }

    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            if (i != 0 && RecyclerListView.this.G1 != null) {
                if (RecyclerListView.this.E1 != null) {
                    AbstractC7426Rr.w(RecyclerListView.this.E1);
                    RecyclerListView.this.E1 = null;
                }
                MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                try {
                    RecyclerListView.this.F1.onTouchEvent(motionEventObtain);
                } catch (Exception e) {
                    C19406qI3.d("baleMessages", e);
                }
                RecyclerListView.this.G1.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                RecyclerListView.this.G1.setPressed(false);
                RecyclerListView.this.G1 = null;
                RecyclerListView.this.I1 = false;
            }
            if (RecyclerListView.this.C1 != null) {
                RecyclerListView.this.C1.a(recyclerView, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (RecyclerListView.this.C1 != null) {
                RecyclerListView.this.C1.b(recyclerView, i, i2);
            }
        }
    }

    private class c implements RecyclerView.s {

        class a extends GestureDetector.SimpleOnGestureListener {
            final /* synthetic */ RecyclerListView a;

            /* renamed from: ir.nasim.features.media.components.RecyclerListView$c$a$a, reason: collision with other inner class name */
            class RunnableC1180a implements Runnable {
                final /* synthetic */ View a;

                RunnableC1180a(View view) {
                    this.a = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this == RecyclerListView.this.J1) {
                        RecyclerListView.this.J1 = null;
                    }
                    View view = this.a;
                    if (view != null) {
                        view.setPressed(false);
                        this.a.playSoundEffect(0);
                        if (RecyclerListView.this.B1 != null) {
                            RecyclerListView.this.B1.onItemClick(RecyclerListView.this.H1);
                        }
                    }
                }
            }

            a(RecyclerListView recyclerListView) {
                this.a = recyclerListView;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (RecyclerListView.this.G1 != null && RecyclerListView.this.B1 != null) {
                    RecyclerListView.this.G1.setPressed(true);
                    View view = RecyclerListView.this.G1;
                    RecyclerListView recyclerListView = RecyclerListView.this;
                    RunnableC1180a runnableC1180a = new RunnableC1180a(view);
                    recyclerListView.J1 = runnableC1180a;
                    AbstractC7426Rr.Q(runnableC1180a, ViewConfiguration.getPressedStateDuration());
                    if (RecyclerListView.this.E1 != null) {
                        AbstractC7426Rr.w(RecyclerListView.this.E1);
                        RecyclerListView.this.E1 = null;
                        RecyclerListView.this.G1 = null;
                        RecyclerListView.this.I1 = false;
                    }
                }
                return true;
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerListView.this.E1 == null || RecyclerListView.this.G1 == null) {
                    return;
                }
                RecyclerListView.this.G1.setPressed(true);
                RecyclerListView.this.E1 = null;
            }
        }

        public c(Context context) {
            RecyclerListView.this.F1 = new GestureDetector(context, new a(RecyclerListView.this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            boolean z = RecyclerListView.this.getScrollState() == 0;
            if ((actionMasked == 0 || actionMasked == 5) && RecyclerListView.this.G1 == null && z) {
                RecyclerListView.this.G1 = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (RecyclerListView.this.G1 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) RecyclerListView.this.G1;
                    float x = motionEvent.getX() - RecyclerListView.this.G1.getLeft();
                    float y = motionEvent.getY() - RecyclerListView.this.G1.getTop();
                    int childCount = viewGroup.getChildCount() - 1;
                    while (true) {
                        if (childCount < 0) {
                            break;
                        }
                        View childAt = viewGroup.getChildAt(childCount);
                        if (x >= childAt.getLeft() && x <= childAt.getRight() && y >= childAt.getTop() && y <= childAt.getBottom() && childAt.isClickable()) {
                            RecyclerListView.this.G1 = null;
                            break;
                        }
                        childCount--;
                    }
                }
                RecyclerListView.this.H1 = -1;
                if (RecyclerListView.this.G1 != null) {
                    RecyclerListView recyclerListView = RecyclerListView.this;
                    recyclerListView.H1 = recyclerView.getChildPosition(recyclerListView.G1);
                    MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, motionEvent.getActionMasked(), motionEvent.getX() - RecyclerListView.this.G1.getLeft(), motionEvent.getY() - RecyclerListView.this.G1.getTop(), 0);
                    if (RecyclerListView.this.G1.onTouchEvent(motionEventObtain)) {
                        RecyclerListView.this.I1 = true;
                    }
                    motionEventObtain.recycle();
                }
            }
            if (RecyclerListView.this.G1 != null && !RecyclerListView.this.I1) {
                try {
                    RecyclerListView.this.F1.onTouchEvent(motionEvent);
                } catch (Exception e) {
                    C19406qI3.d("baleMessages", e);
                }
            }
            if (actionMasked == 0 || actionMasked == 5) {
                if (!RecyclerListView.this.I1 && RecyclerListView.this.G1 != null) {
                    RecyclerListView.this.E1 = new b();
                    AbstractC7426Rr.Q(RecyclerListView.this.E1, ViewConfiguration.getTapTimeout());
                }
            } else if (RecyclerListView.this.G1 != null && (actionMasked == 1 || actionMasked == 6 || actionMasked == 3 || !z)) {
                if (RecyclerListView.this.E1 != null) {
                    AbstractC7426Rr.w(RecyclerListView.this.E1);
                    RecyclerListView.this.E1 = null;
                }
                RecyclerListView.this.G1.setPressed(false);
                RecyclerListView.this.G1 = null;
                RecyclerListView.this.I1 = false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z) {
            RecyclerListView.this.cancelClickRunnables(true);
        }
    }

    public RecyclerListView(Context context) {
        super(context);
        this.K1 = new a();
        try {
            if (!M1) {
                L1 = getResourceDeclareStyleableIntArray("com.android.internal", "View");
                M1 = true;
            }
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(L1);
            View.class.getDeclaredMethod("initializeScrollbars", TypedArray.class).invoke(this, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            C19406qI3.d("baleMessages", th);
        }
        super.setOnScrollListener(new b());
        addOnItemTouchListener(new c(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        if (this.D1 == null || getAdapter() == null) {
            return;
        }
        boolean z = getAdapter().getItemCount() == 0;
        this.D1.setVisibility(z ? 0 : 8);
        setVisibility(z ? 4 : 0);
    }

    public void cancelClickRunnables(boolean z) {
        Runnable runnable = this.E1;
        if (runnable != null) {
            AbstractC7426Rr.w(runnable);
            this.E1 = null;
        }
        View view = this.G1;
        if (view != null) {
            if (z) {
                view.setPressed(false);
            }
            this.G1 = null;
        }
        Runnable runnable2 = this.J1;
        if (runnable2 != null) {
            AbstractC7426Rr.w(runnable2);
            this.J1 = null;
        }
        this.I1 = false;
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

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.h hVar) {
        RecyclerView.h adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.K1);
        }
        super.setAdapter(hVar);
        if (hVar != null) {
            hVar.registerAdapterDataObserver(this.K1);
        }
        l1();
    }

    public void setEmptyView(View view) {
        if (this.D1 == view) {
            return;
        }
        this.D1 = view;
        l1();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.B1 = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setOnScrollListener(RecyclerView.t tVar) {
        this.C1 = tVar;
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        if (L1 != null) {
            super.setVerticalScrollBarEnabled(z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void stopScroll() {
        try {
            super.stopScroll();
        } catch (NullPointerException unused) {
        }
    }
}
