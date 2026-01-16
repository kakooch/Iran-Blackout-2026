package ir.nasim;

import android.view.View;

/* loaded from: classes2.dex */
public abstract class HY7 extends AbstractC4373Ev7 {
    private static final String[] a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    private static int d(androidx.transition.t tVar, int i) {
        int[] iArr;
        if (tVar == null || (iArr = (int[]) tVar.a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }

    @Override // ir.nasim.AbstractC4373Ev7
    public void a(androidx.transition.t tVar) {
        View view = tVar.b;
        Integer numValueOf = (Integer) tVar.a.get("android:visibility:visibility");
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        tVar.a.put("android:visibilityPropagation:visibility", numValueOf);
        int[] iArr = {iRound, 0};
        view.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iRound + (view.getWidth() / 2);
        int iRound2 = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iRound2;
        iArr[1] = iRound2 + (view.getHeight() / 2);
        tVar.a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // ir.nasim.AbstractC4373Ev7
    public String[] b() {
        return a;
    }

    public int e(androidx.transition.t tVar) {
        Integer num;
        if (tVar == null || (num = (Integer) tVar.a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(androidx.transition.t tVar) {
        return d(tVar, 0);
    }

    public int g(androidx.transition.t tVar) {
        return d(tVar, 1);
    }
}
