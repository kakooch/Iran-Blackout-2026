package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import ir.nasim.J22;
import ir.nasim.SE5;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class d extends e {
    String h = null;
    int i = androidx.constraintlayout.motion.widget.a.f;
    int j = 0;
    float k = Float.NaN;
    float l = Float.NaN;
    float m = Float.NaN;
    float n = Float.NaN;
    float o = Float.NaN;
    float p = Float.NaN;
    int q = 0;
    private float r = Float.NaN;
    private float s = Float.NaN;

    private static class a {
        private static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(SE5.KeyPosition_motionTarget, 1);
            a.append(SE5.KeyPosition_framePosition, 2);
            a.append(SE5.KeyPosition_transitionEasing, 3);
            a.append(SE5.KeyPosition_curveFit, 4);
            a.append(SE5.KeyPosition_drawPath, 5);
            a.append(SE5.KeyPosition_percentX, 6);
            a.append(SE5.KeyPosition_percentY, 7);
            a.append(SE5.KeyPosition_keyPositionType, 9);
            a.append(SE5.KeyPosition_sizePercent, 8);
            a.append(SE5.KeyPosition_percentWidth, 11);
            a.append(SE5.KeyPosition_percentHeight, 12);
            a.append(SE5.KeyPosition_pathMotionArc, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(d dVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        if (MotionLayout.S1) {
                            int resourceId = typedArray.getResourceId(index, dVar.b);
                            dVar.b = resourceId;
                            if (resourceId == -1) {
                                dVar.c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            dVar.c = typedArray.getString(index);
                            break;
                        } else {
                            dVar.b = typedArray.getResourceId(index, dVar.b);
                            break;
                        }
                    case 2:
                        dVar.a = typedArray.getInt(index, dVar.a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            dVar.h = typedArray.getString(index);
                            break;
                        } else {
                            dVar.h = J22.c[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        dVar.g = typedArray.getInteger(index, dVar.g);
                        break;
                    case 5:
                        dVar.j = typedArray.getInt(index, dVar.j);
                        break;
                    case 6:
                        dVar.m = typedArray.getFloat(index, dVar.m);
                        break;
                    case 7:
                        dVar.n = typedArray.getFloat(index, dVar.n);
                        break;
                    case 8:
                        float f = typedArray.getFloat(index, dVar.l);
                        dVar.k = f;
                        dVar.l = f;
                        break;
                    case 9:
                        dVar.q = typedArray.getInt(index, dVar.q);
                        break;
                    case 10:
                        dVar.i = typedArray.getInt(index, dVar.i);
                        break;
                    case 11:
                        dVar.k = typedArray.getFloat(index, dVar.k);
                        break;
                    case 12:
                        dVar.l = typedArray.getFloat(index, dVar.l);
                        break;
                    default:
                        String hexString = Integer.toHexString(index);
                        int i2 = a.get(index);
                        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 33);
                        sb.append("unused attribute 0x");
                        sb.append(hexString);
                        sb.append("   ");
                        sb.append(i2);
                        Log.e("KeyPosition", sb.toString());
                        break;
                }
            }
            if (dVar.a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public d() {
        this.d = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void a(HashMap map) {
    }

    @Override // androidx.constraintlayout.motion.widget.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public androidx.constraintlayout.motion.widget.a clone() {
        return new d().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public androidx.constraintlayout.motion.widget.a c(androidx.constraintlayout.motion.widget.a aVar) {
        super.c(aVar);
        d dVar = (d) aVar;
        this.h = dVar.h;
        this.i = dVar.i;
        this.j = dVar.j;
        this.k = dVar.k;
        this.l = Float.NaN;
        this.m = dVar.m;
        this.n = dVar.n;
        this.o = dVar.o;
        this.p = dVar.p;
        this.r = dVar.r;
        this.s = dVar.s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, SE5.KeyPosition));
    }

    public void m(int i) {
        this.q = i;
    }

    public void n(String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "transitionEasing":
                this.h = obj.toString();
                break;
            case "percentWidth":
                this.k = k(obj);
                break;
            case "percentHeight":
                this.l = k(obj);
                break;
            case "drawPath":
                this.j = l(obj);
                break;
            case "sizePercent":
                float fK = k(obj);
                this.k = fK;
                this.l = fK;
                break;
            case "percentX":
                this.m = k(obj);
                break;
            case "percentY":
                this.n = k(obj);
                break;
        }
    }
}
