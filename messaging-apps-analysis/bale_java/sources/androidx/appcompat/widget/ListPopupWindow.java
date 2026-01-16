package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC7822Ti5;
import ir.nasim.HE5;
import ir.nasim.InterfaceC13418gB6;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ListPopupWindow implements InterfaceC13418gB6 {
    private static Method Y;
    private static Method Z;
    private Runnable A;
    final Handler B;
    private final Rect D;
    private Rect G;
    private boolean H;
    PopupWindow J;
    private Context a;
    private ListAdapter b;
    s c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    int o;
    private View p;
    private int q;
    private DataSetObserver r;
    private View s;
    private Drawable t;
    private AdapterView.OnItemClickListener u;
    private AdapterView.OnItemSelectedListener v;
    final i w;
    private final h x;
    private final g y;
    private final e z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            View viewT = ListPopupWindow.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            ListPopupWindow.this.a();
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            s sVar;
            if (i == -1 || (sVar = ListPopupWindow.this.c) == null) {
                return;
            }
            sVar.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class c {
        static int a(PopupWindow popupWindow, View view, int i, boolean z) {
            return popupWindow.getMaxAvailableHeight(view, i, z);
        }
    }

    static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.r();
        }
    }

    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (ListPopupWindow.this.b()) {
                ListPopupWindow.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (i != 1 || ListPopupWindow.this.A() || ListPopupWindow.this.J.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.B.removeCallbacks(listPopupWindow.w);
            ListPopupWindow.this.w.run();
        }
    }

    private class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.J) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.J.getWidth() && y >= 0 && y < ListPopupWindow.this.J.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.B.postDelayed(listPopupWindow.w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.B.removeCallbacks(listPopupWindow2.w);
            return false;
        }
    }

    private class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            s sVar = ListPopupWindow.this.c;
            if (sVar == null || !AbstractC12990fW7.S(sVar) || ListPopupWindow.this.c.getCount() <= ListPopupWindow.this.c.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.c.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.o) {
                listPopupWindow.J.setInputMethodMode(2);
                ListPopupWindow.this.a();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                Y = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                Z = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, AbstractC15790kA5.listPopupWindowStyle);
    }

    private void C() {
        View view = this.p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.p);
            }
        }
    }

    private void N(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.J, z);
            return;
        }
        Method method = Y;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int q() {
        int measuredHeight;
        int i2;
        int iMakeMeasureSpec;
        int i3;
        if (this.c == null) {
            Context context = this.a;
            this.A = new a();
            s sVarS = s(context, !this.H);
            this.c = sVarS;
            Drawable drawable = this.t;
            if (drawable != null) {
                sVarS.setSelector(drawable);
            }
            this.c.setAdapter(this.b);
            this.c.setOnItemClickListener(this.u);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new b());
            this.c.setOnScrollListener(this.y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.v;
            if (onItemSelectedListener != null) {
                this.c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.c;
            View view2 = this.p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.q;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.q);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.e;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.J.setContentView(view);
        } else {
            View view3 = this.p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.i) {
                this.g = -i6;
            }
        } else {
            this.D.setEmpty();
            i2 = 0;
        }
        int iU = u(t(), this.g, this.J.getInputMethodMode() == 2);
        if (this.m || this.d == -1) {
            return iU + i2;
        }
        int i7 = this.e;
        if (i7 == -2) {
            int i8 = this.a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.D;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), RecyclerView.UNDEFINED_DURATION);
        } else if (i7 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            int i9 = this.a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.D;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.c.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i2 + this.c.getPaddingTop() + this.c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int u(View view, int i2, boolean z) {
        return c.a(this.J, view, i2, z);
    }

    public boolean A() {
        return this.J.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.H;
    }

    public void D(View view) {
        this.s = view;
    }

    public void E(int i2) {
        this.J.setAnimationStyle(i2);
    }

    public void F(int i2) {
        Drawable background = this.J.getBackground();
        if (background == null) {
            Q(i2);
            return;
        }
        background.getPadding(this.D);
        Rect rect = this.D;
        this.e = rect.left + rect.right + i2;
    }

    public void G(int i2) {
        this.l = i2;
    }

    public void H(Rect rect) {
        this.G = rect != null ? new Rect(rect) : null;
    }

    public void I(int i2) {
        this.J.setInputMethodMode(i2);
    }

    public void J(boolean z) {
        this.H = z;
        this.J.setFocusable(z);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.u = onItemClickListener;
    }

    public void M(boolean z) {
        this.k = true;
        this.j = z;
    }

    public void O(int i2) {
        this.q = i2;
    }

    public void P(int i2) {
        s sVar = this.c;
        if (!b() || sVar == null) {
            return;
        }
        sVar.setListSelectionHidden(false);
        sVar.setSelection(i2);
        if (sVar.getChoiceMode() != 0) {
            sVar.setItemChecked(i2, true);
        }
    }

    public void Q(int i2) {
        this.e = i2;
    }

    @Override // ir.nasim.InterfaceC13418gB6
    public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iQ = q();
        boolean zA = A();
        AbstractC7822Ti5.b(this.J, this.h);
        if (this.J.isShowing()) {
            if (AbstractC12990fW7.S(t())) {
                int width = this.e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i2 = this.d;
                if (i2 == -1) {
                    if (!zA) {
                        iQ = -1;
                    }
                    if (zA) {
                        this.J.setWidth(this.e == -1 ? -1 : 0);
                        this.J.setHeight(0);
                    } else {
                        this.J.setWidth(this.e == -1 ? -1 : 0);
                        this.J.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    iQ = i2;
                }
                this.J.setOutsideTouchable((this.n || this.m) ? false : true);
                this.J.update(t(), this.f, this.g, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i3 = this.d;
        if (i3 == -1) {
            iQ = -1;
        } else if (i3 != -2) {
            iQ = i3;
        }
        this.J.setWidth(width2);
        this.J.setHeight(iQ);
        N(true);
        this.J.setOutsideTouchable((this.n || this.m) ? false : true);
        this.J.setTouchInterceptor(this.x);
        if (this.k) {
            AbstractC7822Ti5.a(this.J, this.j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = Z;
            if (method != null) {
                try {
                    method.invoke(this.J, this.G);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            d.a(this.J, this.G);
        }
        AbstractC7822Ti5.c(this.J, t(), this.f, this.g, this.l);
        this.c.setSelection(-1);
        if (!this.H || this.c.isInTouchMode()) {
            r();
        }
        if (this.H) {
            return;
        }
        this.B.post(this.z);
    }

    @Override // ir.nasim.InterfaceC13418gB6
    public boolean b() {
        return this.J.isShowing();
    }

    public void c(Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    public int d() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC13418gB6
    public void dismiss() {
        this.J.dismiss();
        C();
        this.J.setContentView(null);
        this.c = null;
        this.B.removeCallbacks(this.w);
    }

    public void f(int i2) {
        this.f = i2;
    }

    public Drawable h() {
        return this.J.getBackground();
    }

    public void j(int i2) {
        this.g = i2;
        this.i = true;
    }

    public int m() {
        if (this.i) {
            return this.g;
        }
        return 0;
    }

    public void n(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.r;
        if (dataSetObserver == null) {
            this.r = new f();
        } else {
            ListAdapter listAdapter2 = this.b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.r);
        }
        s sVar = this.c;
        if (sVar != null) {
            sVar.setAdapter(this.b);
        }
    }

    @Override // ir.nasim.InterfaceC13418gB6
    public ListView p() {
        return this.c;
    }

    public void r() {
        s sVar = this.c;
        if (sVar != null) {
            sVar.setListSelectionHidden(true);
            sVar.requestLayout();
        }
    }

    s s(Context context, boolean z) {
        return new s(context, z);
    }

    public View t() {
        return this.s;
    }

    public Object v() {
        if (b()) {
            return this.c.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (b()) {
            return this.c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (b()) {
            return this.c.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (b()) {
            return this.c.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.e;
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC15790kA5.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.d = -2;
        this.e = -2;
        this.h = 1002;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.o = Integer.MAX_VALUE;
        this.q = 0;
        this.w = new i();
        this.x = new h();
        this.y = new g();
        this.z = new e();
        this.D = new Rect();
        this.a = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, HE5.ListPopupWindow, i2, i3);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(HE5.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(HE5.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i2, i3);
        this.J = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
