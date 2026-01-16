package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21928uN3;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.GE5;
import ir.nasim.YC5;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private final ListPopupWindow e;
    private final AccessibilityManager f;
    private final Rect g;
    private final int h;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            MaterialAutoCompleteTextView.this.f(i < 0 ? materialAutoCompleteTextView.e.v() : materialAutoCompleteTextView.getAdapter().getItem(i));
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i < 0) {
                    view = MaterialAutoCompleteTextView.this.e.y();
                    i = MaterialAutoCompleteTextView.this.e.x();
                    j = MaterialAutoCompleteTextView.this.e.w();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.e.p(), view, i, j);
            }
            MaterialAutoCompleteTextView.this.e.dismiss();
        }
    }

    public MaterialAutoCompleteTextView(Context context) {
        this(context, null);
    }

    private TextInputLayout d() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int e() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutD = d();
        int i = 0;
        if (adapter == null || textInputLayoutD == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.e.x()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutD);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableH = this.e.h();
        if (drawableH != null) {
            drawableH.getPadding(this.g);
            Rect rect = this.g;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutD.getEndIconView().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutD = d();
        return (textInputLayoutD == null || !textInputLayoutD.O()) ? super.getHint() : textInputLayoutD.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutD = d();
        if (textInputLayoutD != null && textInputLayoutD.O() && super.getHint() == null && AbstractC21928uN3.a()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), e()), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.e.n(getAdapter());
    }

    public void setSimpleItems(int i) {
        setSimpleItems(getResources().getStringArray(i));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AccessibilityManager accessibilityManager = this.f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.e.a();
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.autoCompleteTextViewStyle);
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new ArrayAdapter(getContext(), this.h, strArr));
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(AbstractC17750nV3.c(context, attributeSet, i, 0), attributeSet, i);
        this.g = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.MaterialAutoCompleteTextView, i, AbstractC21175tE5.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayH.hasValue(GE5.MaterialAutoCompleteTextView_android_inputType) && typedArrayH.getInt(GE5.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.h = typedArrayH.getResourceId(GE5.MaterialAutoCompleteTextView_simpleItemLayout, YC5.mtrl_auto_complete_simple_item);
        this.f = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.e = listPopupWindow;
        listPopupWindow.J(true);
        listPopupWindow.D(this);
        listPopupWindow.I(2);
        listPopupWindow.n(getAdapter());
        listPopupWindow.L(new a());
        if (typedArrayH.hasValue(GE5.MaterialAutoCompleteTextView_simpleItems)) {
            setSimpleItems(typedArrayH.getResourceId(GE5.MaterialAutoCompleteTextView_simpleItems, 0));
        }
        typedArrayH.recycle();
    }
}
