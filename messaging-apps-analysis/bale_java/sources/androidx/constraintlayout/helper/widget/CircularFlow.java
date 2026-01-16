package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import ir.nasim.SE5;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class CircularFlow extends VirtualLayout {
    private static int v;
    private static float w;
    ConstraintLayout l;
    int m;
    private float[] n;
    private int[] o;
    private int p;
    private int q;
    private String r;
    private String s;
    private Float t;
    private Integer u;

    public CircularFlow(Context context) {
        super(context);
    }

    private void A() {
        this.l = (ConstraintLayout) getParent();
        for (int i = 0; i < this.b; i++) {
            View viewK = this.l.K(this.a[i]);
            if (viewK != null) {
                int i2 = v;
                float f = w;
                int[] iArr = this.o;
                if (iArr == null || i >= iArr.length) {
                    Integer num = this.u;
                    if (num == null || num.intValue() == -1) {
                        String strValueOf = String.valueOf((String) this.i.get(Integer.valueOf(viewK.getId())));
                        Log.e("CircularFlow", strValueOf.length() != 0 ? "Added radius to view with id: ".concat(strValueOf) : new String("Added radius to view with id: "));
                    } else {
                        this.p++;
                        if (this.o == null) {
                            this.o = new int[1];
                        }
                        int[] radius = getRadius();
                        this.o = radius;
                        radius[this.p - 1] = i2;
                    }
                } else {
                    i2 = iArr[i];
                }
                float[] fArr = this.n;
                if (fArr == null || i >= fArr.length) {
                    Float f2 = this.t;
                    if (f2 == null || f2.floatValue() == -1.0f) {
                        String strValueOf2 = String.valueOf((String) this.i.get(Integer.valueOf(viewK.getId())));
                        Log.e("CircularFlow", strValueOf2.length() != 0 ? "Added angle to view with id: ".concat(strValueOf2) : new String("Added angle to view with id: "));
                    } else {
                        this.q++;
                        if (this.n == null) {
                            this.n = new float[1];
                        }
                        float[] angles = getAngles();
                        this.n = angles;
                        angles[this.q - 1] = f;
                    }
                } else {
                    f = fArr[i];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewK.getLayoutParams();
                layoutParams.q = f;
                layoutParams.o = this.m;
                layoutParams.p = i2;
                viewK.setLayoutParams(layoutParams);
            }
        }
        h();
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.q = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                y(str.substring(i).trim());
                return;
            } else {
                y(str.substring(i, iIndexOf).trim());
                i = iIndexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.p = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                z(str.substring(i).trim());
                return;
            } else {
                z(str.substring(i, iIndexOf).trim());
                i = iIndexOf + 1;
            }
        }
    }

    private void y(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.c == null || (fArr = this.n) == null) {
            return;
        }
        if (this.q + 1 > fArr.length) {
            this.n = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.n[this.q] = Integer.parseInt(str);
        this.q++;
    }

    private void z(String str) {
        int[] iArr;
        if (str == null || str.length() == 0 || this.c == null || (iArr = this.o) == null) {
            return;
        }
        if (this.p + 1 > iArr.length) {
            this.o = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.o[this.p] = (int) (Integer.parseInt(str) * this.c.getResources().getDisplayMetrics().density);
        this.p++;
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.n, this.q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.o, this.p);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.o(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, SE5.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.m = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                } else if (index == SE5.ConstraintLayout_Layout_circularflow_angles) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.r = string;
                    setAngles(string);
                } else if (index == SE5.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.s = string2;
                    setRadius(string2);
                } else if (index == SE5.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, w));
                    this.t = fValueOf;
                    setDefaultAngle(fValueOf.floatValue());
                } else if (index == SE5.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, v));
                    this.u = numValueOf;
                    setDefaultRadius(numValueOf.intValue());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.r;
        if (str != null) {
            this.n = new float[1];
            setAngles(str);
        }
        String str2 = this.s;
        if (str2 != null) {
            this.o = new int[1];
            setRadius(str2);
        }
        Float f = this.t;
        if (f != null) {
            setDefaultAngle(f.floatValue());
        }
        Integer num = this.u;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        A();
    }

    public void setDefaultAngle(float f) {
        w = f;
    }

    public void setDefaultRadius(int i) {
        v = i;
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
