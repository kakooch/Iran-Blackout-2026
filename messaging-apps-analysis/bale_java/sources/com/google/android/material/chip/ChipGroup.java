package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.FlowLayout;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.C21970uS0;
import ir.nasim.GE5;
import ir.nasim.X2;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class ChipGroup extends FlowLayout {
    private static final int k = AbstractC21175tE5.Widget_MaterialComponents_ChipGroup;
    private int e;
    private int f;
    private d g;
    private final C21970uS0 h;
    private final int i;
    private final e j;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    class a implements C21970uS0.b {
        a() {
        }

        @Override // ir.nasim.C21970uS0.b
        public void a(Set set) {
            if (ChipGroup.this.g != null) {
                d dVar = ChipGroup.this.g;
                ChipGroup chipGroup = ChipGroup.this;
                dVar.a(chipGroup, chipGroup.h.j(ChipGroup.this));
            }
        }
    }

    class b implements d {
        b(c cVar) {
        }

        @Override // com.google.android.material.chip.ChipGroup.d
        public void a(ChipGroup chipGroup, List list) {
            if (ChipGroup.this.h.l()) {
                ChipGroup.this.getCheckedChipId();
                throw null;
            }
        }
    }

    public interface c {
    }

    public interface d {
        void a(ChipGroup chipGroup, List list);
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener a;

        private e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(AbstractC12990fW7.k());
                }
                ChipGroup.this.h.e((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                chipGroup.h.n((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        /* synthetic */ e(ChipGroup chipGroup, a aVar) {
            this();
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int getChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                i++;
            }
        }
        return i;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    int g(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                if (((Chip) getChildAt(i2)) == view) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.h.k();
    }

    public List<Integer> getCheckedChipIds() {
        return this.h.j(this);
    }

    public int getChipSpacingHorizontal() {
        return this.e;
    }

    public int getChipSpacingVertical() {
        return this.f;
    }

    public boolean h() {
        return this.h.l();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.i;
        if (i != -1) {
            this.h.f(i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        X2.g1(accessibilityNodeInfo).r0(X2.e.b(getRowCount(), c() ? getChipCount() : -1, false, h() ? 1 : 2));
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.e != i) {
            this.e = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.f != i) {
            this.f = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(c cVar) {
        if (cVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new b(cVar));
        }
    }

    public void setOnCheckedStateChangeListener(d dVar) {
        this.g = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.j.a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.h.p(z);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        this.h.q(z);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.chipGroupStyle);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        int i2 = k;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        C21970uS0 c21970uS0 = new C21970uS0();
        this.h = c21970uS0;
        e eVar = new e(this, null);
        this.j = eVar;
        TypedArray typedArrayH = AbstractC5729Ko7.h(getContext(), attributeSet, GE5.ChipGroup, i, i2, new int[0]);
        int dimensionPixelOffset = typedArrayH.getDimensionPixelOffset(GE5.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayH.getDimensionPixelOffset(GE5.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayH.getDimensionPixelOffset(GE5.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayH.getBoolean(GE5.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayH.getBoolean(GE5.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayH.getBoolean(GE5.ChipGroup_selectionRequired, false));
        this.i = typedArrayH.getResourceId(GE5.ChipGroup_checkedChip, -1);
        typedArrayH.recycle();
        c21970uS0.o(new a());
        super.setOnHierarchyChangeListener(eVar);
        AbstractC12990fW7.A0(this, 1);
    }
}
