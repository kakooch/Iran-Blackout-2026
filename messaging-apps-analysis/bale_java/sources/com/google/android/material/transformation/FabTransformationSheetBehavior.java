package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.transformation.FabTransformationBehavior;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC9564aA5;
import ir.nasim.C15532jk4;
import ir.nasim.C9067Yi5;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    private Map i;

    public FabTransformationSheetBehavior() {
    }

    private void g0(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                this.i = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.e) && (((CoordinatorLayout.e) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (z) {
                        this.i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        AbstractC12990fW7.A0(childAt, 4);
                    } else {
                        Map map = this.i;
                        if (map != null && map.containsKey(childAt)) {
                            AbstractC12990fW7.A0(childAt, ((Integer) this.i.get(childAt)).intValue());
                        }
                    }
                }
            }
            if (z) {
                return;
            }
            this.i = null;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    protected boolean H(View view, View view2, boolean z, boolean z2) {
        g0(view2, z);
        return super.H(view, view2, z, z2);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected FabTransformationBehavior.e e0(Context context, boolean z) {
        int i = z ? AbstractC9564aA5.mtrl_fab_transformation_sheet_expand_spec : AbstractC9564aA5.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.a = C15532jk4.d(context, i);
        eVar.b = new C9067Yi5(17, 0.0f, 0.0f);
        return eVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
