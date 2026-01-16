package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.C14015hC3;
import ir.nasim.C23798xX7;
import ir.nasim.C7139Ql0;
import ir.nasim.O02;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class s extends ListView {
    private final Rect a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private d g;
    private boolean h;
    private boolean i;
    private boolean j;
    private C23798xX7 k;
    private C14015hC3 l;
    f m;

    static class a {
        static void a(View view, float f, float f2) {
            view.drawableHotspotChanged(f, f2);
        }
    }

    static class b {
        private static Method a;
        private static Method b;
        private static Method c;
        private static boolean d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                d = true;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        static boolean a() {
            return d;
        }

        static void b(s sVar, int i, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                a.invoke(sVar, Integer.valueOf(i), view, Boolean.FALSE, -1, -1);
                b.invoke(sVar, Integer.valueOf(i));
                c.invoke(sVar, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    static class c {
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z) {
            absListView.setSelectedChildViewEnabled(z);
        }
    }

    private static class d extends O02 {
        private boolean b;

        d(Drawable drawable) {
            super(drawable);
            this.b = true;
        }

        void b(boolean z) {
            this.b = z;
        }

        @Override // ir.nasim.O02, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.b) {
                super.draw(canvas);
            }
        }

        @Override // ir.nasim.O02, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.b) {
                super.setHotspot(f, f2);
            }
        }

        @Override // ir.nasim.O02, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.b) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // ir.nasim.O02, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // ir.nasim.O02, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.b) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    static class e {
        private static final Field a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            a = declaredField;
        }

        static boolean a(AbsListView absListView) {
            Field field = a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z) throws IllegalAccessException, IllegalArgumentException {
            Field field = a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class f implements Runnable {
        f() {
        }

        public void a() {
            s sVar = s.this;
            sVar.m = null;
            sVar.removeCallbacks(this);
        }

        public void b() {
            s.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            s sVar = s.this;
            sVar.m = null;
            sVar.drawableStateChanged();
        }
    }

    s(Context context, boolean z) {
        super(context, null, AbstractC15790kA5.dropDownListViewStyle);
        this.a = new Rect();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.i = z;
        setCacheColorHint(0);
    }

    private void a() {
        this.j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        C23798xX7 c23798xX7 = this.k;
        if (c23798xX7 != null) {
            c23798xX7.c();
            this.k = null;
        }
    }

    private void b(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.a);
        selector.draw(canvas);
    }

    private void f(int i, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.b;
        rect.top -= this.c;
        rect.right += this.d;
        rect.bottom += this.e;
        boolean zK = k();
        if (view.isEnabled() != zK) {
            l(!zK);
            if (i != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        f(i, view);
        if (z) {
            Rect rect = this.a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            AbstractC21710u02.e(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i, View view, float f2, float f3) throws IllegalAccessException, IllegalArgumentException {
        g(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        AbstractC21710u02.e(selector, f2, f3);
    }

    private void i(View view, int i, float f2, float f3) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.j = true;
        a.a(this, f2, f3);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.f;
        if (i2 != -1 && (childAt = getChildAt(i2 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f = i;
        a.a(view, f2 - view.getLeft(), f3 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i, view, f2, f3);
        j(false);
        refreshDrawableState();
    }

    private void j(boolean z) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    private boolean k() {
        return C7139Ql0.d() ? c.a(this) : e.a(this);
    }

    private void l(boolean z) throws IllegalAccessException, IllegalArgumentException {
        if (C7139Ql0.d()) {
            c.b(this, z);
        } else {
            e.b(this, z);
        }
    }

    private boolean m() {
        return this.j;
    }

    private void n() {
        Drawable selector = getSelector();
        if (selector != null && m() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        View view = null;
        while (i6 < count) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            view.measure(i, i9 > 0 ? View.MeasureSpec.makeMeasureSpec(i9, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i6 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i6 <= i5 || i8 <= 0 || measuredHeight == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i6 >= i5) {
                i8 = measuredHeight;
            }
            i6++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.m != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r3 = r1
            r9 = r2
            goto L46
        L11:
            r9 = r2
            r3 = r9
            goto L46
        L14:
            r3 = r1
            goto L17
        L16:
            r3 = r2
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            ir.nasim.hC3 r9 = r7.l
            if (r9 != 0) goto L5a
            ir.nasim.hC3 r9 = new ir.nasim.hC3
            r9.<init>(r7)
            r7.l = r9
        L5a:
            ir.nasim.hC3 r9 = r7.l
            r9.m(r1)
            ir.nasim.hC3 r9 = r7.l
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            ir.nasim.hC3 r8 = r7.l
            if (r8 == 0) goto L6c
            r8.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.s.e(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.i || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.i || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.i && this.h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.m == null) {
            f fVar = new f();
            this.m = fVar;
            fVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i < 30 || !b.a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, iPointToPosition, childAt);
                    }
                }
                n();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.m;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z) {
        this.h = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.b = rect.left;
        this.c = rect.top;
        this.d = rect.right;
        this.e = rect.bottom;
    }
}
