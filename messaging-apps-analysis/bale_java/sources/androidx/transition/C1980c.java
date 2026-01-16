package androidx.transition;

import android.animation.TypeEvaluator;

/* renamed from: androidx.transition.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1980c implements TypeEvaluator {
    private float[] a;

    C1980c(float[] fArr) {
        this.a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = f2 + ((fArr2[i] - f2) * f);
        }
        return fArr3;
    }
}
