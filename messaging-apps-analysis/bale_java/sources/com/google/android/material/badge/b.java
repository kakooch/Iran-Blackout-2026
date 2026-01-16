package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes3.dex */
public abstract class b {
    public static final boolean a = false;

    public static void a(a aVar, View view, FrameLayout frameLayout) throws Resources.NotFoundException {
        e(aVar, view, frameLayout);
        if (aVar.h() != null) {
            aVar.h().setForeground(aVar);
        } else {
            if (a) {
                throw new IllegalArgumentException("Trying to reference null customBadgeParent");
            }
            view.getOverlay().add(aVar);
        }
    }

    public static SparseArray b(Context context, ParcelableSparseArray parcelableSparseArray) {
        SparseArray sparseArray = new SparseArray(parcelableSparseArray.size());
        for (int i = 0; i < parcelableSparseArray.size(); i++) {
            int iKeyAt = parcelableSparseArray.keyAt(i);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i);
            if (state == null) {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
            sparseArray.put(iKeyAt, a.d(context, state));
        }
        return sparseArray;
    }

    public static ParcelableSparseArray c(SparseArray sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            a aVar = (a) sparseArray.valueAt(i);
            if (aVar == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(iKeyAt, aVar.l());
        }
        return parcelableSparseArray;
    }

    public static void d(a aVar, View view) {
        if (aVar == null) {
            return;
        }
        if (a || aVar.h() != null) {
            aVar.h().setForeground(null);
        } else {
            view.getOverlay().remove(aVar);
        }
    }

    public static void e(a aVar, View view, FrameLayout frameLayout) throws Resources.NotFoundException {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.B(view, frameLayout);
    }

    public static void f(Rect rect, float f, float f2, float f3, float f4) {
        rect.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
    }
}
