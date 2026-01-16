package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import ir.nasim.SE5;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class b extends androidx.constraintlayout.motion.widget.a {
    private String g;
    private int h = -1;
    private boolean i = false;
    private float j = Float.NaN;
    private float k = Float.NaN;
    private float l = Float.NaN;
    private float m = Float.NaN;
    private float n = Float.NaN;
    private float o = Float.NaN;
    private float p = Float.NaN;
    private float q = Float.NaN;
    private float r = Float.NaN;
    private float s = Float.NaN;
    private float t = Float.NaN;
    private float u = Float.NaN;
    private float v = Float.NaN;
    private float w = Float.NaN;

    private static class a {
        private static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(SE5.KeyAttribute_android_alpha, 1);
            a.append(SE5.KeyAttribute_android_elevation, 2);
            a.append(SE5.KeyAttribute_android_rotation, 4);
            a.append(SE5.KeyAttribute_android_rotationX, 5);
            a.append(SE5.KeyAttribute_android_rotationY, 6);
            a.append(SE5.KeyAttribute_android_transformPivotX, 19);
            a.append(SE5.KeyAttribute_android_transformPivotY, 20);
            a.append(SE5.KeyAttribute_android_scaleX, 7);
            a.append(SE5.KeyAttribute_transitionPathRotate, 8);
            a.append(SE5.KeyAttribute_transitionEasing, 9);
            a.append(SE5.KeyAttribute_motionTarget, 10);
            a.append(SE5.KeyAttribute_framePosition, 12);
            a.append(SE5.KeyAttribute_curveFit, 13);
            a.append(SE5.KeyAttribute_android_scaleY, 14);
            a.append(SE5.KeyAttribute_android_translationX, 15);
            a.append(SE5.KeyAttribute_android_translationY, 16);
            a.append(SE5.KeyAttribute_android_translationZ, 17);
            a.append(SE5.KeyAttribute_motionProgress, 18);
        }

        public static void a(b bVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        bVar.j = typedArray.getFloat(index, bVar.j);
                        break;
                    case 2:
                        bVar.k = typedArray.getDimension(index, bVar.k);
                        break;
                    case 3:
                    case 11:
                    default:
                        String hexString = Integer.toHexString(index);
                        int i2 = a.get(index);
                        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 33);
                        sb.append("unused attribute 0x");
                        sb.append(hexString);
                        sb.append("   ");
                        sb.append(i2);
                        Log.e("KeyAttribute", sb.toString());
                        break;
                    case 4:
                        bVar.l = typedArray.getFloat(index, bVar.l);
                        break;
                    case 5:
                        bVar.m = typedArray.getFloat(index, bVar.m);
                        break;
                    case 6:
                        bVar.n = typedArray.getFloat(index, bVar.n);
                        break;
                    case 7:
                        bVar.r = typedArray.getFloat(index, bVar.r);
                        break;
                    case 8:
                        bVar.q = typedArray.getFloat(index, bVar.q);
                        break;
                    case 9:
                        bVar.g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.S1) {
                            int resourceId = typedArray.getResourceId(index, bVar.b);
                            bVar.b = resourceId;
                            if (resourceId == -1) {
                                bVar.c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            bVar.c = typedArray.getString(index);
                            break;
                        } else {
                            bVar.b = typedArray.getResourceId(index, bVar.b);
                            break;
                        }
                    case 12:
                        bVar.a = typedArray.getInt(index, bVar.a);
                        break;
                    case 13:
                        bVar.h = typedArray.getInteger(index, bVar.h);
                        break;
                    case 14:
                        bVar.s = typedArray.getFloat(index, bVar.s);
                        break;
                    case 15:
                        bVar.t = typedArray.getDimension(index, bVar.t);
                        break;
                    case 16:
                        bVar.u = typedArray.getDimension(index, bVar.u);
                        break;
                    case 17:
                        bVar.v = typedArray.getDimension(index, bVar.v);
                        break;
                    case 18:
                        bVar.w = typedArray.getFloat(index, bVar.w);
                        break;
                    case 19:
                        bVar.o = typedArray.getDimension(index, bVar.o);
                        break;
                    case 20:
                        bVar.p = typedArray.getDimension(index, bVar.p);
                        break;
                }
            }
        }
    }

    public b() {
        this.d = 1;
        this.e = new HashMap();
    }

    public void R(String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "motionProgress":
                this.w = k(obj);
                break;
            case "transitionEasing":
                this.g = obj.toString();
                break;
            case "rotationX":
                this.m = k(obj);
                break;
            case "rotationY":
                this.n = k(obj);
                break;
            case "translationX":
                this.t = k(obj);
                break;
            case "translationY":
                this.u = k(obj);
                break;
            case "translationZ":
                this.v = k(obj);
                break;
            case "scaleX":
                this.r = k(obj);
                break;
            case "scaleY":
                this.s = k(obj);
                break;
            case "transformPivotX":
                this.o = k(obj);
                break;
            case "transformPivotY":
                this.p = k(obj);
                break;
            case "rotation":
                this.l = k(obj);
                break;
            case "elevation":
                this.k = k(obj);
                break;
            case "transitionPathRotate":
                this.q = k(obj);
                break;
            case "alpha":
                this.j = k(obj);
                break;
            case "curveFit":
                this.h = l(obj);
                break;
            case "visibility":
                this.i = j(obj);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    @Override // androidx.constraintlayout.motion.widget.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.HashMap r7) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.b.a(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.a
    /* renamed from: b */
    public androidx.constraintlayout.motion.widget.a clone() {
        return new b().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public androidx.constraintlayout.motion.widget.a c(androidx.constraintlayout.motion.widget.a aVar) {
        super.c(aVar);
        b bVar = (b) aVar;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.n = bVar.n;
        this.o = bVar.o;
        this.p = bVar.p;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
        this.v = bVar.v;
        this.w = bVar.w;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add("progress");
        }
        if (this.e.size() > 0) {
            Iterator it = this.e.keySet().iterator();
            while (it.hasNext()) {
                String strValueOf = String.valueOf((String) it.next());
                hashSet.add(strValueOf.length() != 0 ? "CUSTOM,".concat(strValueOf) : new String("CUSTOM,"));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, SE5.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void h(HashMap map) {
        if (this.h == -1) {
            return;
        }
        if (!Float.isNaN(this.j)) {
            map.put("alpha", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.k)) {
            map.put("elevation", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.l)) {
            map.put("rotation", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.m)) {
            map.put("rotationX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.n)) {
            map.put("rotationY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.o)) {
            map.put("transformPivotX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.p)) {
            map.put("transformPivotY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.t)) {
            map.put("translationX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.u)) {
            map.put("translationY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.v)) {
            map.put("translationZ", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.q)) {
            map.put("transitionPathRotate", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.r)) {
            map.put("scaleX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.s)) {
            map.put("scaleY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.w)) {
            map.put("progress", Integer.valueOf(this.h));
        }
        if (this.e.size() > 0) {
            Iterator it = this.e.keySet().iterator();
            while (it.hasNext()) {
                String strValueOf = String.valueOf((String) it.next());
                map.put(strValueOf.length() != 0 ? "CUSTOM,".concat(strValueOf) : new String("CUSTOM,"), Integer.valueOf(this.h));
            }
        }
    }
}
