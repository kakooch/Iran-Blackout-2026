package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import ir.nasim.AbstractC23607xC5;
import ir.nasim.C16651le1;
import ir.nasim.C17242me1;
import ir.nasim.C18931pV2;
import ir.nasim.InterfaceC17158mV2;
import ir.nasim.SE5;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class ConstraintHelper extends View {
    protected int[] a;
    protected int b;
    protected Context c;
    protected InterfaceC17158mV2 d;
    protected boolean e;
    protected String f;
    protected String g;
    private View[] h;
    protected HashMap i;

    public ConstraintHelper(Context context) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context);
        this.a = new int[32];
        this.e = false;
        this.h = null;
        this.i = new HashMap();
        this.c = context;
        o(null);
    }

    private void d(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (str == null || str.length() == 0 || this.c == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iM = m(strTrim);
        if (iM != 0) {
            this.i.put(Integer.valueOf(iM), strTrim);
            e(iM);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(strTrim).length() + 23);
        sb.append("Could not find id of \"");
        sb.append(strTrim);
        sb.append(Separators.DOUBLE_QUOTE);
        Log.w("ConstraintHelper", sb.toString());
    }

    private void e(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.b + 1;
        int[] iArr = this.a;
        if (i2 > iArr.length) {
            this.a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.a;
        int i3 = this.b;
        iArr2[i3] = i;
        this.b = i3 + 1;
    }

    private void f(String str) {
        if (str == null || str.length() == 0 || this.c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && strTrim.equals(((ConstraintLayout.LayoutParams) layoutParams).b0)) {
                if (childAt.getId() == -1) {
                    String simpleName = childAt.getClass().getSimpleName();
                    StringBuilder sb = new StringBuilder(simpleName.length() + 42);
                    sb.append("to use ConstraintTag view ");
                    sb.append(simpleName);
                    sb.append(" must have an ID");
                    Log.w("ConstraintHelper", sb.toString());
                } else {
                    e(childAt.getId());
                }
            }
        }
    }

    private int[] k(View view, String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        String[] strArrSplit = str.split(",");
        view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        for (String str2 : strArrSplit) {
            int iM = m(str2.trim());
            if (iM != 0) {
                iArr[i] = iM;
                i++;
            }
        }
        return i != strArrSplit.length ? Arrays.copyOf(iArr, i) : iArr;
    }

    private int l(ConstraintLayout constraintLayout, String str) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int m(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iL = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objF = constraintLayout.F(0, str);
            if (objF instanceof Integer) {
                iL = ((Integer) objF).intValue();
            }
        }
        if (iL == 0 && constraintLayout != null) {
            iL = l(constraintLayout, str);
        }
        if (iL == 0) {
            try {
                iL = AbstractC23607xC5.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iL == 0 ? this.c.getResources().getIdentifier(str, "id", this.c.getPackageName()) : iL;
    }

    public void g(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else {
            if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
                return;
            }
            this.f = null;
            e(view.getId());
            requestLayout();
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.a, this.b);
    }

    protected void h() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        i((ConstraintLayout) parent);
    }

    protected void i(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.b; i++) {
            View viewK = constraintLayout.K(this.a[i]);
            if (viewK != null) {
                viewK.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewK.setTranslationZ(viewK.getTranslationZ() + elevation);
                }
            }
        }
    }

    protected void j(ConstraintLayout constraintLayout) {
    }

    protected View[] n(ConstraintLayout constraintLayout) {
        View[] viewArr = this.h;
        if (viewArr == null || viewArr.length != this.b) {
            this.h = new View[this.b];
        }
        for (int i = 0; i < this.b; i++) {
            this.h[i] = constraintLayout.K(this.a[i]);
        }
        return this.h;
    }

    protected void o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, SE5.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f = string;
                    setIds(string);
                } else if (index == SE5.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(c.a aVar, C18931pV2 c18931pV2, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        c.b bVar = aVar.e;
        int[] iArr = bVar.j0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar.k0;
            if (str != null) {
                if (str.length() > 0) {
                    c.b bVar2 = aVar.e;
                    bVar2.j0 = k(this, bVar2.k0);
                } else {
                    aVar.e.j0 = null;
                }
            }
        }
        if (c18931pV2 == null) {
            return;
        }
        c18931pV2.c();
        if (aVar.e.j0 == null) {
            return;
        }
        int i = 0;
        while (true) {
            int[] iArr2 = aVar.e.j0;
            if (i >= iArr2.length) {
                return;
            }
            C16651le1 c16651le1 = (C16651le1) sparseArray.get(iArr2[i]);
            if (c16651le1 != null) {
                c18931pV2.a(c16651le1);
            }
            i++;
        }
    }

    public void r(ConstraintLayout constraintLayout) {
    }

    public void s(ConstraintLayout constraintLayout) {
    }

    protected void setIds(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                d(str.substring(i));
                return;
            } else {
                d(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.g = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                f(str.substring(i));
                return;
            } else {
                f(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f = null;
        this.b = 0;
        for (int i : iArr) {
            e(i);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.f == null) {
            e(i);
        }
    }

    public void t(ConstraintLayout constraintLayout) {
    }

    public void u(ConstraintLayout constraintLayout) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        String str;
        int iL;
        if (isInEditMode()) {
            setIds(this.f);
        }
        InterfaceC17158mV2 interfaceC17158mV2 = this.d;
        if (interfaceC17158mV2 == null) {
            return;
        }
        interfaceC17158mV2.c();
        for (int i = 0; i < this.b; i++) {
            int i2 = this.a[i];
            View viewK = constraintLayout.K(i2);
            if (viewK == null && (iL = l(constraintLayout, (str = (String) this.i.get(Integer.valueOf(i2))))) != 0) {
                this.a[i] = iL;
                this.i.put(Integer.valueOf(iL), str);
                viewK = constraintLayout.K(iL);
            }
            if (viewK != null) {
                this.d.a(constraintLayout.P(viewK));
            }
        }
        this.d.b(constraintLayout.c);
    }

    public void v(C17242me1 c17242me1, InterfaceC17158mV2 interfaceC17158mV2, SparseArray sparseArray) {
        interfaceC17158mV2.c();
        for (int i = 0; i < this.b; i++) {
            interfaceC17158mV2.a((C16651le1) sparseArray.get(this.a[i]));
        }
    }

    public void w() {
        if (this.d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).u0 = (C16651le1) this.d;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet);
        this.a = new int[32];
        this.e = false;
        this.h = null;
        this.i = new HashMap();
        this.c = context;
        o(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet, i);
        this.a = new int[32];
        this.e = false;
        this.h = null;
        this.i = new HashMap();
        this.c = context;
        o(attributeSet);
    }

    public void q(C16651le1 c16651le1, boolean z) {
    }
}
