package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class a {
    private static final ViewGroup.MarginLayoutParams b;
    private LinearLayoutManager a;

    /* renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    class C0133a implements Comparator {
        C0133a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager linearLayoutManager) {
        this.a = linearLayoutManager;
    }

    private boolean a() {
        int top;
        int i;
        int bottom;
        int i2;
        int iK = this.a.K();
        if (iK == 0) {
            return true;
        }
        boolean z = this.a.r2() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iK, 2);
        for (int i3 = 0; i3 < iK; i3++) {
            View viewJ = this.a.J(i3);
            if (viewJ == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = viewJ.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : b;
            int[] iArr2 = iArr[i3];
            if (z) {
                top = viewJ.getLeft();
                i = marginLayoutParams.leftMargin;
            } else {
                top = viewJ.getTop();
                i = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i;
            int[] iArr3 = iArr[i3];
            if (z) {
                bottom = viewJ.getRight();
                i2 = marginLayoutParams.rightMargin;
            } else {
                bottom = viewJ.getBottom();
                i2 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i2;
        }
        Arrays.sort(iArr, new C0133a());
        for (int i4 = 1; i4 < iK; i4++) {
            if (iArr[i4 - 1][1] != iArr[i4][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i5 = iArr4[1];
        int i6 = iArr4[0];
        return i6 <= 0 && iArr[iK - 1][1] >= i5 - i6;
    }

    private boolean b() {
        int iK = this.a.K();
        for (int i = 0; i < iK; i++) {
            if (c(this.a.J(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (c(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean d() {
        return (!a() || this.a.K() <= 1) && b();
    }
}
