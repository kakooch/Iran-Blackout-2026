package androidx.constraintlayout.widget;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC19015pe1;
import ir.nasim.AbstractC22501vL4;
import ir.nasim.C16651le1;
import ir.nasim.C17242me1;
import ir.nasim.C20795sd0;
import ir.nasim.C8243Vd1;
import ir.nasim.DY7;
import ir.nasim.NS2;
import ir.nasim.SE5;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.internal.http2.Http2Connection;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes2.dex */
public class ConstraintLayout extends ViewGroup {
    private static d x;
    SparseArray a;
    private ArrayList b;
    protected C17242me1 c;
    private int d;
    private int e;
    private int f;
    private int g;
    protected boolean h;
    private int i;
    private c j;
    protected androidx.constraintlayout.widget.b k;
    private int l;
    private HashMap m;
    private int n;
    private int o;
    int p;
    int q;
    int r;
    int s;
    private SparseArray t;
    b u;
    private int v;
    private int w;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C16651le1.b.values().length];
            a = iArr;
            try {
                iArr[C16651le1.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[C16651le1.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[C16651le1.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[C16651le1.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class b implements C20795sd0.b {
        ConstraintLayout a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;

        public b(ConstraintLayout constraintLayout) {
            this.a = constraintLayout;
        }

        private boolean d(int i, int i2, int i3) {
            if (i == i2) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i);
            View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
            }
            return false;
        }

        @Override // ir.nasim.C20795sd0.b
        public final void a() {
            int childCount = this.a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.a.getChildAt(i);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).b(this.a);
                }
            }
            int size = this.a.b.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ((ConstraintHelper) this.a.b.get(i2)).s(this.a);
                }
            }
        }

        @Override // ir.nasim.C20795sd0.b
        public final void b(C16651le1 c16651le1, C20795sd0.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int i;
            int measuredHeight;
            int i2;
            if (c16651le1 == null) {
                return;
            }
            if (c16651le1.W() == 8 && !c16651le1.k0()) {
                aVar.e = 0;
                aVar.f = 0;
                aVar.g = 0;
                return;
            }
            if (c16651le1.N() == null) {
                return;
            }
            C16651le1.b bVar = aVar.a;
            C16651le1.b bVar2 = aVar.b;
            int i3 = aVar.c;
            int i4 = aVar.d;
            int i5 = this.b + this.c;
            int i6 = this.d;
            View view = (View) c16651le1.u();
            int[] iArr = a.a;
            int i7 = iArr[bVar.ordinal()];
            if (i7 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else if (i7 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i6, -2);
            } else if (i7 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i6 + c16651le1.D(), -1);
            } else if (i7 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i6, -2);
                boolean z = c16651le1.w == 1;
                int i8 = aVar.j;
                if (i8 == C20795sd0.a.l || i8 == C20795sd0.a.m) {
                    boolean z2 = view.getMeasuredHeight() == c16651le1.z();
                    if (aVar.j == C20795sd0.a.m || !z || ((z && z2) || (view instanceof Placeholder) || c16651le1.o0())) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(c16651le1.X(), 1073741824);
                    }
                }
            }
            int i9 = iArr[bVar2.ordinal()];
            if (i9 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else if (i9 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i5, -2);
            } else if (i9 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i5 + c16651le1.V(), -1);
            } else if (i9 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i5, -2);
                boolean z3 = c16651le1.x == 1;
                int i10 = aVar.j;
                if (i10 == C20795sd0.a.l || i10 == C20795sd0.a.m) {
                    boolean z4 = view.getMeasuredWidth() == c16651le1.X();
                    if (aVar.j == C20795sd0.a.m || !z3 || ((z3 && z4) || (view instanceof Placeholder) || c16651le1.p0())) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(c16651le1.z(), 1073741824);
                    }
                }
            }
            C17242me1 c17242me1 = (C17242me1) c16651le1.N();
            if (c17242me1 != null && AbstractC22501vL4.b(ConstraintLayout.this.i, 256) && view.getMeasuredWidth() == c16651le1.X() && view.getMeasuredWidth() < c17242me1.X() && view.getMeasuredHeight() == c16651le1.z() && view.getMeasuredHeight() < c17242me1.z() && view.getBaseline() == c16651le1.r() && !c16651le1.n0() && d(c16651le1.E(), iMakeMeasureSpec, c16651le1.X()) && d(c16651le1.F(), iMakeMeasureSpec2, c16651le1.z())) {
                aVar.e = c16651le1.X();
                aVar.f = c16651le1.z();
                aVar.g = c16651le1.r();
                return;
            }
            C16651le1.b bVar3 = C16651le1.b.MATCH_CONSTRAINT;
            boolean z5 = bVar == bVar3;
            boolean z6 = bVar2 == bVar3;
            C16651le1.b bVar4 = C16651le1.b.MATCH_PARENT;
            boolean z7 = bVar2 == bVar4 || bVar2 == C16651le1.b.FIXED;
            boolean z8 = bVar == bVar4 || bVar == C16651le1.b.FIXED;
            boolean z9 = z5 && c16651le1.f0 > 0.0f;
            boolean z10 = z6 && c16651le1.f0 > 0.0f;
            if (view == null) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i11 = aVar.j;
            if (i11 != C20795sd0.a.l && i11 != C20795sd0.a.m && z5 && c16651le1.w == 0 && z6 && c16651le1.x == 0) {
                i2 = -1;
                measuredHeight = 0;
                baseline = 0;
                iMax = 0;
            } else {
                if ((view instanceof VirtualLayout) && (c16651le1 instanceof DY7)) {
                    ((VirtualLayout) view).x((DY7) c16651le1, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                c16651le1.U0(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i12 = c16651le1.z;
                iMax = i12 > 0 ? Math.max(i12, measuredWidth) : measuredWidth;
                int i13 = c16651le1.A;
                if (i13 > 0) {
                    iMax = Math.min(i13, iMax);
                }
                int i14 = c16651le1.C;
                if (i14 > 0) {
                    measuredHeight = Math.max(i14, measuredHeight2);
                    i = iMakeMeasureSpec;
                } else {
                    i = iMakeMeasureSpec;
                    measuredHeight = measuredHeight2;
                }
                int i15 = c16651le1.D;
                if (i15 > 0) {
                    measuredHeight = Math.min(i15, measuredHeight);
                }
                if (!AbstractC22501vL4.b(ConstraintLayout.this.i, 1)) {
                    if (z9 && z7) {
                        iMax = (int) ((measuredHeight * c16651le1.f0) + 0.5f);
                    } else if (z10 && z8) {
                        measuredHeight = (int) ((iMax / c16651le1.f0) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight2 != measuredHeight) {
                    int iMakeMeasureSpec3 = measuredWidth != iMax ? View.MeasureSpec.makeMeasureSpec(iMax, 1073741824) : i;
                    if (measuredHeight2 != measuredHeight) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    c16651le1.U0(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i2 = -1;
            }
            boolean z11 = baseline != i2;
            aVar.i = (iMax == aVar.c && measuredHeight == aVar.d) ? false : true;
            if (layoutParams.f0) {
                z11 = true;
            }
            if (z11 && baseline != -1 && c16651le1.r() != baseline) {
                aVar.i = true;
            }
            aVar.e = iMax;
            aVar.f = measuredHeight;
            aVar.h = z11;
            aVar.g = baseline;
        }

        public void c(int i, int i2, int i3, int i4, int i5, int i6) {
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = i6;
            this.f = i;
            this.g = i2;
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.a = new SparseArray();
        this.b = new ArrayList(4);
        this.c = new C17242me1();
        this.d = 0;
        this.e = 0;
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
        this.h = true;
        this.i = Type.CAA;
        this.j = null;
        this.k = null;
        this.l = -1;
        this.m = new HashMap();
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        this.t = new SparseArray();
        this.u = new b(this);
        this.v = 0;
        this.w = 0;
        Q(null, 0, 0);
    }

    private final C16651le1 H(int i) {
        if (i == 0) {
            return this.c;
        }
        View viewFindViewById = (View) this.a.get(i);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.c;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((LayoutParams) viewFindViewById.getLayoutParams()).u0;
    }

    private void Q(AttributeSet attributeSet, int i, int i2) {
        this.c.A0(this);
        this.c.U1(this.u);
        this.a.put(getId(), this);
        this.j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, SE5.ConstraintLayout_Layout, i, i2);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == SE5.ConstraintLayout_Layout_android_minWidth) {
                    this.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.d);
                } else if (index == SE5.ConstraintLayout_Layout_android_minHeight) {
                    this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == SE5.ConstraintLayout_Layout_android_maxWidth) {
                    this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == SE5.ConstraintLayout_Layout_android_maxHeight) {
                    this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == SE5.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.i = typedArrayObtainStyledAttributes.getInt(index, this.i);
                } else if (index == SE5.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            V(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.k = null;
                        }
                    }
                } else if (index == SE5.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        c cVar = new c();
                        this.j = cVar;
                        cVar.F(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.j = null;
                    }
                    this.l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.c.V1(this.i);
    }

    private void U() {
        this.h = true;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
    }

    private void Z() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C16651le1 c16651le1P = P(getChildAt(i));
            if (c16651le1P != null) {
                c16651le1P.u0();
            }
        }
        if (zIsInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    H(childAt.getId()).B0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.l != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getId() == this.l && (childAt2 instanceof Constraints)) {
                    this.j = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        c cVar = this.j;
        if (cVar != null) {
            cVar.k(this, true);
        }
        this.c.t1();
        int size = this.b.size();
        if (size > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                ((ConstraintHelper) this.b.get(i4)).u(this);
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt3 = getChildAt(i5);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).c(this);
            }
        }
        this.t.clear();
        this.t.put(0, this.c);
        this.t.put(getId(), this.c);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt4 = getChildAt(i6);
            this.t.put(childAt4.getId(), P(childAt4));
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt5 = getChildAt(i7);
            C16651le1 c16651le1P2 = P(childAt5);
            if (c16651le1P2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                this.c.a(c16651le1P2);
                x(zIsInEditMode, childAt5, c16651le1P2, layoutParams, this.t);
            }
        }
    }

    private void b0(C16651le1 c16651le1, LayoutParams layoutParams, SparseArray sparseArray, int i, C8243Vd1.b bVar) {
        View view = (View) this.a.get(i);
        C16651le1 c16651le12 = (C16651le1) sparseArray.get(i);
        if (c16651le12 == null || view == null || !(view.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        layoutParams.f0 = true;
        C8243Vd1.b bVar2 = C8243Vd1.b.BASELINE;
        if (bVar == bVar2) {
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.f0 = true;
            layoutParams2.u0.J0(true);
        }
        c16651le1.q(bVar2).b(c16651le12.q(bVar), layoutParams.C, layoutParams.B, true);
        c16651le1.J0(true);
        c16651le1.q(C8243Vd1.b.TOP).q();
        c16651le1.q(C8243Vd1.b.BOTTOM).q();
    }

    private boolean c0() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            Z();
        }
        return z;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static d getSharedValues() {
        if (x == null) {
            x = new d();
        }
        return x;
    }

    @Override // android.view.ViewGroup
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Object F(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap map = this.m;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.m.get(str);
    }

    public View K(int i) {
        return (View) this.a.get(i);
    }

    public final C16651le1 P(View view) {
        if (view == this) {
            return this.c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).u0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).u0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean T() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    protected void V(int i) {
        this.k = new androidx.constraintlayout.widget.b(getContext(), this, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        b bVar = this.u;
        int i5 = bVar.e;
        int iResolveSizeAndState = View.resolveSizeAndState(i3 + bVar.d, i, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i4 + i5, i2, 0) & 16777215;
        int iMin = Math.min(this.f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.g, iResolveSizeAndState2);
        if (z) {
            iMin |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z2) {
            iMin2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(iMin, iMin2);
        this.n = iMin;
        this.o = iMin2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(C17242me1 c17242me1, int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i4 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.u.c(i2, i3, iMax, iMax2, paddingWidth, i4);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        int iMax5 = (iMax3 > 0 || iMax4 > 0) ? T() ? iMax4 : iMax3 : Math.max(0, getPaddingLeft());
        int i5 = size - paddingWidth;
        int i6 = size2 - i4;
        a0(c17242me1, mode, i5, mode2, i6);
        c17242me1.Q1(i, mode, i5, mode2, i6, this.n, this.o, iMax5, iMax);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 ir.nasim.le1$b) = (r2v3 ir.nasim.le1$b), (r2v0 ir.nasim.le1$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void a0(ir.nasim.C17242me1 r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$b r0 = r7.u
            int r1 = r0.e
            int r0 = r0.d
            ir.nasim.le1$b r2 = ir.nasim.C16651le1.b.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            if (r9 == r5) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = r6
            goto L38
        L1a:
            int r9 = r7.f
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L38
        L23:
            ir.nasim.le1$b r9 = ir.nasim.C16651le1.b.WRAP_CONTENT
            if (r3 != 0) goto L18
            int r10 = r7.d
            int r10 = java.lang.Math.max(r6, r10)
            goto L38
        L2e:
            ir.nasim.le1$b r9 = ir.nasim.C16651le1.b.WRAP_CONTENT
            if (r3 != 0) goto L38
            int r10 = r7.d
            int r10 = java.lang.Math.max(r6, r10)
        L38:
            if (r11 == r5) goto L53
            if (r11 == 0) goto L48
            if (r11 == r4) goto L40
        L3e:
            r12 = r6
            goto L5d
        L40:
            int r11 = r7.g
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L5d
        L48:
            ir.nasim.le1$b r2 = ir.nasim.C16651le1.b.WRAP_CONTENT
            if (r3 != 0) goto L3e
            int r11 = r7.e
            int r12 = java.lang.Math.max(r6, r11)
            goto L5d
        L53:
            ir.nasim.le1$b r2 = ir.nasim.C16651le1.b.WRAP_CONTENT
            if (r3 != 0) goto L5d
            int r11 = r7.e
            int r12 = java.lang.Math.max(r6, r11)
        L5d:
            int r11 = r8.X()
            if (r10 != r11) goto L69
            int r11 = r8.z()
            if (r12 == r11) goto L6c
        L69:
            r8.M1()
        L6c:
            r8.l1(r6)
            r8.m1(r6)
            int r11 = r7.f
            int r11 = r11 - r0
            r8.W0(r11)
            int r11 = r7.g
            int r11 = r11 - r1
            r8.V0(r11)
            r8.Z0(r6)
            r8.Y0(r6)
            r8.O0(r9)
            r8.j1(r10)
            r8.f1(r2)
            r8.K0(r12)
            int r9 = r7.d
            int r9 = r9 - r0
            r8.Z0(r9)
            int r9 = r7.e
            int r9 = r9 - r1
            r8.Y0(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a0(ir.nasim.me1, int, int, int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((ConstraintHelper) this.b.get(i)).t(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        U();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.g;
    }

    public int getMaxWidth() {
        return this.f;
    }

    public int getMinHeight() {
        return this.e;
    }

    public int getMinWidth() {
        return this.d;
    }

    public int getOptimizationLevel() {
        return this.c.I1();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            C16651le1 c16651le1 = layoutParams.u0;
            if ((childAt.getVisibility() != 8 || layoutParams.g0 || layoutParams.h0 || layoutParams.j0 || zIsInEditMode) && !layoutParams.i0) {
                int iY = c16651le1.Y();
                int iZ = c16651le1.Z();
                int iX = c16651le1.X() + iY;
                int iZ2 = c16651le1.z() + iZ;
                childAt.layout(iY, iZ, iX, iZ2);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iY, iZ, iX, iZ2);
                }
            }
        }
        int size = this.b.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((ConstraintHelper) this.b.get(i6)).r(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.v == i) {
            int i3 = this.w;
        }
        if (!this.h) {
            int childCount = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                if (getChildAt(i4).isLayoutRequested()) {
                    this.h = true;
                    break;
                }
                i4++;
            }
        }
        this.v = i;
        this.w = i2;
        this.c.X1(T());
        if (this.h) {
            this.h = false;
            if (c0()) {
                this.c.Z1();
            }
        }
        Y(this.c, this.i, i, i2);
        W(i, i2, this.c.X(), this.c.z(), this.c.P1(), this.c.N1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        C16651le1 c16651le1P = P(view);
        if ((view instanceof Guideline) && !(c16651le1P instanceof NS2)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            NS2 ns2 = new NS2();
            layoutParams.u0 = ns2;
            layoutParams.g0 = true;
            ns2.z1(layoutParams.Y);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.w();
            ((LayoutParams) view.getLayoutParams()).h0 = true;
            if (!this.b.contains(constraintHelper)) {
                this.b.add(constraintHelper);
            }
        }
        this.a.put(view.getId(), view);
        this.h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.a.remove(view.getId());
        this.c.s1(P(view));
        this.b.remove(view);
        this.h = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        U();
        super.requestLayout();
    }

    public void setConstraintSet(c cVar) {
        this.j = cVar;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.m == null) {
                this.m = new HashMap();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf(Separators.SLASH);
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.m.put(strSubstring, num);
        }
    }

    @Override // android.view.View
    public void setId(int i) {
        this.a.remove(getId());
        super.setId(i);
        this.a.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f) {
            return;
        }
        this.f = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.e) {
            return;
        }
        this.e = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.d) {
            return;
        }
        this.d = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(AbstractC19015pe1 abstractC19015pe1) {
        androidx.constraintlayout.widget.b bVar = this.k;
        if (bVar != null) {
            bVar.c(abstractC19015pe1);
        }
    }

    public void setOptimizationLevel(int i) {
        this.i = i;
        this.c.V1(i);
    }

    public void setState(int i, int i2, int i3) {
        androidx.constraintlayout.widget.b bVar = this.k;
        if (bVar != null) {
            bVar.d(i, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(boolean z, View view, C16651le1 c16651le1, LayoutParams layoutParams, SparseArray sparseArray) {
        C16651le1 c16651le12;
        C16651le1 c16651le13;
        C16651le1 c16651le14;
        C16651le1 c16651le15;
        int i;
        layoutParams.c();
        layoutParams.v0 = false;
        c16651le1.i1(view.getVisibility());
        if (layoutParams.i0) {
            c16651le1.S0(true);
            c16651le1.i1(8);
        }
        c16651le1.A0(view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).q(c16651le1, this.c.O1());
        }
        if (layoutParams.g0) {
            NS2 ns2 = (NS2) c16651le1;
            int i2 = layoutParams.r0;
            int i3 = layoutParams.s0;
            float f = layoutParams.t0;
            if (f != -1.0f) {
                ns2.y1(f);
                return;
            } else if (i2 != -1) {
                ns2.w1(i2);
                return;
            } else {
                if (i3 != -1) {
                    ns2.x1(i3);
                    return;
                }
                return;
            }
        }
        int i4 = layoutParams.k0;
        int i5 = layoutParams.l0;
        int i6 = layoutParams.m0;
        int i7 = layoutParams.n0;
        int i8 = layoutParams.o0;
        int i9 = layoutParams.p0;
        float f2 = layoutParams.q0;
        int i10 = layoutParams.o;
        if (i10 != -1) {
            C16651le1 c16651le16 = (C16651le1) sparseArray.get(i10);
            if (c16651le16 != null) {
                c16651le1.m(c16651le16, layoutParams.q, layoutParams.p);
            }
        } else {
            if (i4 != -1) {
                C16651le1 c16651le17 = (C16651le1) sparseArray.get(i4);
                if (c16651le17 != null) {
                    C8243Vd1.b bVar = C8243Vd1.b.LEFT;
                    c16651le1.f0(bVar, c16651le17, bVar, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i8);
                }
            } else if (i5 != -1 && (c16651le12 = (C16651le1) sparseArray.get(i5)) != null) {
                c16651le1.f0(C8243Vd1.b.LEFT, c16651le12, C8243Vd1.b.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i8);
            }
            if (i6 != -1) {
                C16651le1 c16651le18 = (C16651le1) sparseArray.get(i6);
                if (c16651le18 != null) {
                    c16651le1.f0(C8243Vd1.b.RIGHT, c16651le18, C8243Vd1.b.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i9);
                }
            } else if (i7 != -1 && (c16651le13 = (C16651le1) sparseArray.get(i7)) != null) {
                C8243Vd1.b bVar2 = C8243Vd1.b.RIGHT;
                c16651le1.f0(bVar2, c16651le13, bVar2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i9);
            }
            int i11 = layoutParams.h;
            if (i11 != -1) {
                C16651le1 c16651le19 = (C16651le1) sparseArray.get(i11);
                if (c16651le19 != null) {
                    C8243Vd1.b bVar3 = C8243Vd1.b.TOP;
                    c16651le1.f0(bVar3, c16651le19, bVar3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.w);
                }
            } else {
                int i12 = layoutParams.i;
                if (i12 != -1 && (c16651le14 = (C16651le1) sparseArray.get(i12)) != null) {
                    c16651le1.f0(C8243Vd1.b.TOP, c16651le14, C8243Vd1.b.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.w);
                }
            }
            int i13 = layoutParams.j;
            if (i13 != -1) {
                C16651le1 c16651le110 = (C16651le1) sparseArray.get(i13);
                if (c16651le110 != null) {
                    c16651le1.f0(C8243Vd1.b.BOTTOM, c16651le110, C8243Vd1.b.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.y);
                }
            } else {
                int i14 = layoutParams.k;
                if (i14 != -1 && (c16651le15 = (C16651le1) sparseArray.get(i14)) != null) {
                    C8243Vd1.b bVar4 = C8243Vd1.b.BOTTOM;
                    c16651le1.f0(bVar4, c16651le15, bVar4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.y);
                }
            }
            int i15 = layoutParams.l;
            if (i15 != -1) {
                b0(c16651le1, layoutParams, sparseArray, i15, C8243Vd1.b.BASELINE);
            } else {
                int i16 = layoutParams.m;
                if (i16 != -1) {
                    b0(c16651le1, layoutParams, sparseArray, i16, C8243Vd1.b.TOP);
                } else {
                    int i17 = layoutParams.n;
                    if (i17 != -1) {
                        b0(c16651le1, layoutParams, sparseArray, i17, C8243Vd1.b.BOTTOM);
                    }
                }
            }
            if (f2 >= 0.0f) {
                c16651le1.L0(f2);
            }
            float f3 = layoutParams.G;
            if (f3 >= 0.0f) {
                c16651le1.c1(f3);
            }
        }
        if (z && ((i = layoutParams.W) != -1 || layoutParams.X != -1)) {
            c16651le1.a1(i, layoutParams.X);
        }
        if (layoutParams.d0) {
            c16651le1.O0(C16651le1.b.FIXED);
            c16651le1.j1(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                c16651le1.O0(C16651le1.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
            if (layoutParams.Z) {
                c16651le1.O0(C16651le1.b.MATCH_CONSTRAINT);
            } else {
                c16651le1.O0(C16651le1.b.MATCH_PARENT);
            }
            c16651le1.q(C8243Vd1.b.LEFT).g = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            c16651le1.q(C8243Vd1.b.RIGHT).g = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            c16651le1.O0(C16651le1.b.MATCH_CONSTRAINT);
            c16651le1.j1(0);
        }
        if (layoutParams.e0) {
            c16651le1.f1(C16651le1.b.FIXED);
            c16651le1.K0(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                c16651le1.f1(C16651le1.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
            if (layoutParams.a0) {
                c16651le1.f1(C16651le1.b.MATCH_CONSTRAINT);
            } else {
                c16651le1.f1(C16651le1.b.MATCH_PARENT);
            }
            c16651le1.q(C8243Vd1.b.TOP).g = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            c16651le1.q(C8243Vd1.b.BOTTOM).g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        } else {
            c16651le1.f1(C16651le1.b.MATCH_CONSTRAINT);
            c16651le1.K0(0);
        }
        c16651le1.C0(layoutParams.H);
        c16651le1.Q0(layoutParams.K);
        c16651le1.h1(layoutParams.L);
        c16651le1.M0(layoutParams.M);
        c16651le1.d1(layoutParams.N);
        c16651le1.k1(layoutParams.c0);
        c16651le1.P0(layoutParams.O, layoutParams.Q, layoutParams.S, layoutParams.U);
        c16651le1.g1(layoutParams.P, layoutParams.R, layoutParams.T, layoutParams.V);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new SparseArray();
        this.b = new ArrayList(4);
        this.c = new C17242me1();
        this.d = 0;
        this.e = 0;
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
        this.h = true;
        this.i = Type.CAA;
        this.j = null;
        this.k = null;
        this.l = -1;
        this.m = new HashMap();
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        this.t = new SparseArray();
        this.u = new b(this);
        this.v = 0;
        this.w = 0;
        Q(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new SparseArray();
        this.b = new ArrayList(4);
        this.c = new C17242me1();
        this.d = 0;
        this.e = 0;
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
        this.h = true;
        this.i = Type.CAA;
        this.j = null;
        this.k = null;
        this.l = -1;
        this.m = new HashMap();
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        this.t = new SparseArray();
        this.u = new b(this);
        this.v = 0;
        this.w = 0;
        Q(attributeSet, i, 0);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        boolean D;
        boolean E;
        public float F;
        public float G;
        public String H;
        float I;
        int J;
        public float K;
        public float L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public float U;
        public float V;
        public int W;
        public int X;
        public int Y;
        public boolean Z;
        public int a;
        public boolean a0;
        public int b;
        public String b0;
        public float c;
        public int c0;
        public int d;
        boolean d0;
        public int e;
        boolean e0;
        public int f;
        boolean f0;
        public int g;
        boolean g0;
        public int h;
        boolean h0;
        public int i;
        boolean i0;
        public int j;
        boolean j0;
        public int k;
        int k0;
        public int l;
        int l0;
        public int m;
        int m0;
        public int n;
        int n0;
        public int o;
        int o0;
        public int p;
        int p0;
        public float q;
        float q0;
        public int r;
        int r0;
        public int s;
        int s0;
        public int t;
        float t0;
        public int u;
        C16651le1 u0;
        public int v;
        public boolean v0;
        public int w;
        public int x;
        public int y;
        public int z;

        private static class a {
            public static final SparseIntArray a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                a = sparseIntArray;
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(SE5.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = 0;
            this.q = 0.0f;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = RecyclerView.UNDEFINED_DURATION;
            this.w = RecyclerView.UNDEFINED_DURATION;
            this.x = RecyclerView.UNDEFINED_DURATION;
            this.y = RecyclerView.UNDEFINED_DURATION;
            this.z = RecyclerView.UNDEFINED_DURATION;
            this.A = RecyclerView.UNDEFINED_DURATION;
            this.B = RecyclerView.UNDEFINED_DURATION;
            this.C = 0;
            this.D = true;
            this.E = true;
            this.F = 0.5f;
            this.G = 0.5f;
            this.H = null;
            this.I = 0.0f;
            this.J = 1;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = 1.0f;
            this.W = -1;
            this.X = -1;
            this.Y = -1;
            this.Z = false;
            this.a0 = false;
            this.b0 = null;
            this.c0 = 0;
            this.d0 = true;
            this.e0 = true;
            this.f0 = false;
            this.g0 = false;
            this.h0 = false;
            this.i0 = false;
            this.j0 = false;
            this.k0 = -1;
            this.l0 = -1;
            this.m0 = -1;
            this.n0 = -1;
            this.o0 = RecyclerView.UNDEFINED_DURATION;
            this.p0 = RecyclerView.UNDEFINED_DURATION;
            this.q0 = 0.5f;
            this.u0 = new C16651le1();
            this.v0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SE5.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                int i2 = a.a.get(index);
                switch (i2) {
                    case 1:
                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.o);
                        this.o = resourceId;
                        if (resourceId == -1) {
                            this.o = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.p);
                        break;
                    case 4:
                        float f = typedArrayObtainStyledAttributes.getFloat(index, this.q) % 360.0f;
                        this.q = f;
                        if (f < 0.0f) {
                            this.q = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.a);
                        break;
                    case 6:
                        this.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.b);
                        break;
                    case 7:
                        this.c = typedArrayObtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.d);
                        this.d = resourceId2;
                        if (resourceId2 == -1) {
                            this.d = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                        this.e = resourceId3;
                        if (resourceId3 == -1) {
                            this.e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f);
                        this.f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.g);
                        this.g = resourceId5;
                        if (resourceId5 == -1) {
                            this.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.h);
                        this.h = resourceId6;
                        if (resourceId6 == -1) {
                            this.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.i);
                        this.i = resourceId7;
                        if (resourceId7 == -1) {
                            this.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                        this.j = resourceId8;
                        if (resourceId8 == -1) {
                            this.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.k);
                        this.k = resourceId9;
                        if (resourceId9 == -1) {
                            this.k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId11;
                        if (resourceId11 == -1) {
                            this.r = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId12;
                        if (resourceId12 == -1) {
                            this.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.t);
                        this.t = resourceId13;
                        if (resourceId13 == -1) {
                            this.t = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
                        this.u = resourceId14;
                        if (resourceId14 == -1) {
                            this.u = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 22:
                        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 23:
                        this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 24:
                        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 25:
                        this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.z);
                        break;
                    case 26:
                        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 27:
                        this.Z = typedArrayObtainStyledAttributes.getBoolean(index, this.Z);
                        break;
                    case 28:
                        this.a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.a0);
                        break;
                    case 29:
                        this.F = typedArrayObtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 30:
                        this.G = typedArrayObtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case 31:
                        int i3 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.O = i3;
                        if (i3 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.P = i4;
                        if (i4 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.Q) == -2) {
                                this.Q = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.S) == -2) {
                                this.S = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.U = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.U));
                        this.O = 2;
                        break;
                    case 36:
                        try {
                            this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.R) == -2) {
                                this.R = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.T) == -2) {
                                this.T = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    default:
                        switch (i2) {
                            case 44:
                                c.K(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.K = typedArrayObtainStyledAttributes.getFloat(index, this.K);
                                break;
                            case 46:
                                this.L = typedArrayObtainStyledAttributes.getFloat(index, this.L);
                                break;
                            case 47:
                                this.M = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.W = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.W);
                                break;
                            case 50:
                                this.X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                break;
                            case 51:
                                this.b0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case Type.TLSA /* 52 */:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.m);
                                this.m = resourceId15;
                                if (resourceId15 == -1) {
                                    this.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.n);
                                this.n = resourceId16;
                                if (resourceId16 == -1) {
                                    this.n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 55:
                                this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                                break;
                            default:
                                switch (i2) {
                                    case 64:
                                        c.I(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.D = true;
                                        break;
                                    case 65:
                                        c.I(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.E = true;
                                        break;
                                    case WKSRecord.Protocol.RVD /* 66 */:
                                        this.c0 = typedArrayObtainStyledAttributes.getInt(index, this.c0);
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            c();
        }

        public String a() {
            return this.b0;
        }

        public C16651le1 b() {
            return this.u0;
        }

        public void c() {
            this.g0 = false;
            this.d0 = true;
            this.e0 = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.Z) {
                this.d0 = false;
                if (this.O == 0) {
                    this.O = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.a0) {
                this.e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.d0 = false;
                if (i == 0 && this.O == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.Z = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.e0 = false;
                if (i2 == 0 && this.P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.a0 = true;
                }
            }
            if (this.c == -1.0f && this.a == -1 && this.b == -1) {
                return;
            }
            this.g0 = true;
            this.d0 = true;
            this.e0 = true;
            if (!(this.u0 instanceof NS2)) {
                this.u0 = new NS2();
            }
            ((NS2) this.u0).z1(this.Y);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 255
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = 0;
            this.q = 0.0f;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = RecyclerView.UNDEFINED_DURATION;
            this.w = RecyclerView.UNDEFINED_DURATION;
            this.x = RecyclerView.UNDEFINED_DURATION;
            this.y = RecyclerView.UNDEFINED_DURATION;
            this.z = RecyclerView.UNDEFINED_DURATION;
            this.A = RecyclerView.UNDEFINED_DURATION;
            this.B = RecyclerView.UNDEFINED_DURATION;
            this.C = 0;
            this.D = true;
            this.E = true;
            this.F = 0.5f;
            this.G = 0.5f;
            this.H = null;
            this.I = 0.0f;
            this.J = 1;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = 1.0f;
            this.W = -1;
            this.X = -1;
            this.Y = -1;
            this.Z = false;
            this.a0 = false;
            this.b0 = null;
            this.c0 = 0;
            this.d0 = true;
            this.e0 = true;
            this.f0 = false;
            this.g0 = false;
            this.h0 = false;
            this.i0 = false;
            this.j0 = false;
            this.k0 = -1;
            this.l0 = -1;
            this.m0 = -1;
            this.n0 = -1;
            this.o0 = RecyclerView.UNDEFINED_DURATION;
            this.p0 = RecyclerView.UNDEFINED_DURATION;
            this.q0 = 0.5f;
            this.u0 = new C16651le1();
            this.v0 = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = 0;
            this.q = 0.0f;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = RecyclerView.UNDEFINED_DURATION;
            this.w = RecyclerView.UNDEFINED_DURATION;
            this.x = RecyclerView.UNDEFINED_DURATION;
            this.y = RecyclerView.UNDEFINED_DURATION;
            this.z = RecyclerView.UNDEFINED_DURATION;
            this.A = RecyclerView.UNDEFINED_DURATION;
            this.B = RecyclerView.UNDEFINED_DURATION;
            this.C = 0;
            this.D = true;
            this.E = true;
            this.F = 0.5f;
            this.G = 0.5f;
            this.H = null;
            this.I = 0.0f;
            this.J = 1;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = 1.0f;
            this.W = -1;
            this.X = -1;
            this.Y = -1;
            this.Z = false;
            this.a0 = false;
            this.b0 = null;
            this.c0 = 0;
            this.d0 = true;
            this.e0 = true;
            this.f0 = false;
            this.g0 = false;
            this.h0 = false;
            this.i0 = false;
            this.j0 = false;
            this.k0 = -1;
            this.l0 = -1;
            this.m0 = -1;
            this.n0 = -1;
            this.o0 = RecyclerView.UNDEFINED_DURATION;
            this.p0 = RecyclerView.UNDEFINED_DURATION;
            this.q0 = 0.5f;
            this.u0 = new C16651le1();
            this.v0 = false;
        }
    }
}
