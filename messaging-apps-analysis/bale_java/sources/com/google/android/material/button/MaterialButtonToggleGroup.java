package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC23123wO3;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.C11411cx6;
import ir.nasim.C22317v2;
import ir.nasim.C22893w0;
import ir.nasim.GE5;
import ir.nasim.InterfaceC9342Zn1;
import ir.nasim.X2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    private static final String k = "MaterialButtonToggleGroup";
    private static final int l = AbstractC21175tE5.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private final List a;
    private final e b;
    private final LinkedHashSet c;
    private final Comparator d;
    private Integer[] e;
    private boolean f;
    private boolean g;
    private boolean h;
    private final int i;
    private Set j;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends C22317v2 {
        b() {
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            x2.s0(X2.f.a(0, 1, MaterialButtonToggleGroup.this.i(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private static class c {
        private static final InterfaceC9342Zn1 e = new C22893w0(0.0f);
        InterfaceC9342Zn1 a;
        InterfaceC9342Zn1 b;
        InterfaceC9342Zn1 c;
        InterfaceC9342Zn1 d;

        c(InterfaceC9342Zn1 interfaceC9342Zn1, InterfaceC9342Zn1 interfaceC9342Zn12, InterfaceC9342Zn1 interfaceC9342Zn13, InterfaceC9342Zn1 interfaceC9342Zn14) {
            this.a = interfaceC9342Zn1;
            this.b = interfaceC9342Zn13;
            this.c = interfaceC9342Zn14;
            this.d = interfaceC9342Zn12;
        }

        public static c a(c cVar) {
            InterfaceC9342Zn1 interfaceC9342Zn1 = e;
            return new c(interfaceC9342Zn1, cVar.d, interfaceC9342Zn1, cVar.c);
        }

        public static c b(c cVar, View view) {
            return AbstractC10402bY7.j(view) ? c(cVar) : d(cVar);
        }

        public static c c(c cVar) {
            InterfaceC9342Zn1 interfaceC9342Zn1 = cVar.a;
            InterfaceC9342Zn1 interfaceC9342Zn12 = cVar.d;
            InterfaceC9342Zn1 interfaceC9342Zn13 = e;
            return new c(interfaceC9342Zn1, interfaceC9342Zn12, interfaceC9342Zn13, interfaceC9342Zn13);
        }

        public static c d(c cVar) {
            InterfaceC9342Zn1 interfaceC9342Zn1 = e;
            return new c(interfaceC9342Zn1, interfaceC9342Zn1, cVar.b, cVar.c);
        }

        public static c e(c cVar, View view) {
            return AbstractC10402bY7.j(view) ? d(cVar) : c(cVar);
        }

        public static c f(c cVar) {
            InterfaceC9342Zn1 interfaceC9342Zn1 = cVar.a;
            InterfaceC9342Zn1 interfaceC9342Zn12 = e;
            return new c(interfaceC9342Zn1, interfaceC9342Zn12, cVar.b, interfaceC9342Zn12);
        }
    }

    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    private class e implements MaterialButton.a {
        private e() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context) {
        this(context, null);
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton materialButtonH = h(i);
            int iMin = Math.min(materialButtonH.getStrokeWidth(), h(i - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsD = d(materialButtonH);
            if (getOrientation() == 0) {
                AbstractC23123wO3.c(layoutParamsD, 0);
                AbstractC23123wO3.d(layoutParamsD, -iMin);
                layoutParamsD.topMargin = 0;
            } else {
                layoutParamsD.bottomMargin = 0;
                layoutParamsD.topMargin = -iMin;
                AbstractC23123wO3.d(layoutParamsD, 0);
            }
            materialButtonH.setLayoutParams(layoutParamsD);
        }
        n(firstVisibleChildIndex);
    }

    private LinearLayout.LayoutParams d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void e(int i, boolean z) {
        if (i == -1) {
            Log.e(k, "Button ID is not valid: " + i);
            return;
        }
        HashSet hashSet = new HashSet(this.j);
        if (z && !hashSet.contains(Integer.valueOf(i))) {
            if (this.g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i))) {
                return;
            }
            if (!this.h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i));
            }
        }
        q(hashSet);
    }

    private void g(int i, boolean z) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(this, i, z);
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (k(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && k(i2)) {
                i++;
            }
        }
        return i;
    }

    private MaterialButton h(int i) {
        return (MaterialButton) getChildAt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) == view) {
                return i;
            }
            if ((getChildAt(i2) instanceof MaterialButton) && k(i2)) {
                i++;
            }
        }
        return -1;
    }

    private c j(int i, int i2, int i3) {
        c cVar = (c) this.a.get(i);
        if (i2 == i3) {
            return cVar;
        }
        boolean z = getOrientation() == 0;
        if (i == i2) {
            return z ? c.e(cVar, this) : c.f(cVar);
        }
        if (i == i3) {
            return z ? c.b(cVar, this) : c.a(cVar);
        }
        return null;
    }

    private boolean k(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    private void n(int i) {
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) h(i).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            AbstractC23123wO3.c(layoutParams, 0);
            AbstractC23123wO3.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void o(int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof MaterialButton) {
            this.f = true;
            ((MaterialButton) viewFindViewById).setChecked(z);
            this.f = false;
        }
    }

    private static void p(C11411cx6.b bVar, c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.I(cVar.a).x(cVar.d).N(cVar.b).C(cVar.c);
        }
    }

    private void q(Set set) {
        Set set2 = this.j;
        this.j = new HashSet(set);
        for (int i = 0; i < getChildCount(); i++) {
            int id = h(i).getId();
            o(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                g(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void r() {
        TreeMap treeMap = new TreeMap(this.d);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(h(i), Integer.valueOf(i));
        }
        this.e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(AbstractC12990fW7.k());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(k, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        e(materialButton.getId(), materialButton.isChecked());
        C11411cx6 shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.a.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        AbstractC12990fW7.p0(materialButton, new b());
    }

    public void b(d dVar) {
        this.c.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public void f() {
        q(new HashSet());
    }

    public int getCheckedButtonId() {
        if (!this.g || this.j.isEmpty()) {
            return -1;
        }
        return ((Integer) this.j.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            int id = h(i).getId();
            if (this.j.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.e;
        if (numArr != null && i2 < numArr.length) {
            return numArr[i2].intValue();
        }
        Log.w(k, "Child order wasn't updated");
        return i2;
    }

    public boolean l() {
        return this.g;
    }

    void m(MaterialButton materialButton, boolean z) {
        if (this.f) {
            return;
        }
        e(materialButton.getId(), z);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.i;
        if (i != -1) {
            q(Collections.singleton(Integer.valueOf(i)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        X2.g1(accessibilityNodeInfo).r0(X2.e.b(1, getVisibleButtonCount(), false, l() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        s();
        c();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.a.remove(iIndexOfChild);
        }
        s();
        c();
    }

    void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton materialButtonH = h(i);
            if (materialButtonH.getVisibility() != 8) {
                C11411cx6.b bVarV = materialButtonH.getShapeAppearanceModel().v();
                p(bVarV, j(i, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonH.setShapeAppearanceModel(bVarV.m());
            }
        }
    }

    public void setSelectionRequired(boolean z) {
        this.h = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.g != z) {
            this.g = z;
            f();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i) {
        int i2 = l;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        this.a = new ArrayList();
        this.b = new e(this, null);
        this.c = new LinkedHashSet();
        this.d = new a();
        this.f = false;
        this.j = new HashSet();
        TypedArray typedArrayH = AbstractC5729Ko7.h(getContext(), attributeSet, GE5.MaterialButtonToggleGroup, i, i2, new int[0]);
        setSingleSelection(typedArrayH.getBoolean(GE5.MaterialButtonToggleGroup_singleSelection, false));
        this.i = typedArrayH.getResourceId(GE5.MaterialButtonToggleGroup_checkedButton, -1);
        this.h = typedArrayH.getBoolean(GE5.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayH.recycle();
        AbstractC12990fW7.A0(this, 1);
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
