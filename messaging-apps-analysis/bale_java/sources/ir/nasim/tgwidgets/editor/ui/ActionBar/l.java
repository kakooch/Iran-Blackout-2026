package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import android.view.Window;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.util.List;

/* loaded from: classes7.dex */
public interface l {

    public interface a {
    }

    public static class b implements m.h {
        SparseIntArray a = new SparseIntArray();
        int[] b = {m.h9, m.k9, m.l9, m.m9, m.Ea, m.j9};

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.m.h
        public int getColor(int i) {
            int iIndexOfKey = this.a.indexOfKey(i);
            return iIndexOfKey >= 0 ? this.a.valueAt(iIndexOfKey) : m.i0(i);
        }
    }

    public static class c {
        public final m.k a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public boolean e;
        public boolean f = true;
        public long g = 200;

        public c(m.k kVar, int i, boolean z, boolean z2) {
            this.a = kVar;
            this.b = i;
            this.c = z;
            this.d = z2;
        }
    }

    void a(c cVar, Runnable runnable);

    void b();

    default void c(m.k kVar, int i, boolean z, boolean z2) {
        a(new c(kVar, i, z, z2), null);
    }

    void d(float f);

    void e(Canvas canvas, Drawable drawable);

    boolean f();

    default ir.nasim.tgwidgets.editor.ui.ActionBar.c getBackgroundFragment() {
        if (getFragmentStack().size() <= 1) {
            return null;
        }
        AbstractC18350oW3.a(getFragmentStack().get(getFragmentStack().size() - 2));
        return null;
    }

    default BottomSheet getBottomSheet() {
        return null;
    }

    float getCurrentPreviewFragmentAlpha();

    List getFragmentStack();

    default Activity getParentActivity() {
        Context context = getView().getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        throw new IllegalArgumentException("NavigationLayout added in non-activity context!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    default ViewGroup getView() {
        if (this instanceof ViewGroup) {
            return (ViewGroup) this;
        }
        throw new IllegalArgumentException("You should override getView() if you're not inheriting from it.");
    }

    default Window getWindow() {
        if (getParentActivity() != null) {
            return getParentActivity().getWindow();
        }
        return null;
    }
}
