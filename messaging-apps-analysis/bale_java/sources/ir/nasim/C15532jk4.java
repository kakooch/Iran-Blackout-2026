package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.jk4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C15532jk4 {
    private final C24792zC6 a = new C24792zC6();
    private final C24792zC6 b = new C24792zC6();

    private static void a(C15532jk4 c15532jk4, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            c15532jk4.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            c15532jk4.m(objectAnimator.getPropertyName(), C16123kk4.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    private PropertyValuesHolder[] b(PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i = 0; i < propertyValuesHolderArr.length; i++) {
            propertyValuesHolderArr2[i] = propertyValuesHolderArr[i].clone();
        }
        return propertyValuesHolderArr2;
    }

    public static C15532jk4 c(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return d(context, resourceId);
    }

    public static C15532jk4 d(Context context, int i) throws Resources.NotFoundException {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return e(arrayList);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    private static C15532jk4 e(List list) {
        C15532jk4 c15532jk4 = new C15532jk4();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(c15532jk4, (Animator) list.get(i));
        }
        return c15532jk4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C15532jk4) {
            return this.a.equals(((C15532jk4) obj).a);
        }
        return false;
    }

    public ObjectAnimator f(String str, Object obj, Property property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, g(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        h(str).a(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b((PropertyValuesHolder[]) this.b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public C16123kk4 h(String str) {
        if (k(str)) {
            return (C16123kk4) this.a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public long i() {
        int size = this.a.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            C16123kk4 c16123kk4 = (C16123kk4) this.a.k(i);
            jMax = Math.max(jMax, c16123kk4.c() + c16123kk4.d());
        }
        return jMax;
    }

    public boolean j(String str) {
        return this.b.get(str) != null;
    }

    public boolean k(String str) {
        return this.a.get(str) != null;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, C16123kk4 c16123kk4) {
        this.a.put(str, c16123kk4);
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.a + "}\n";
    }
}
