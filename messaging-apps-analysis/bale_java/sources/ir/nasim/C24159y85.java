package ir.nasim;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* renamed from: ir.nasim.y85, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24159y85 {
    private View a;
    private final List b = new ArrayList();
    private final Stack c = new Stack();

    public final void a(View view) {
        AbstractC13042fc3.i(view, "view");
        this.b.add(view);
    }

    public final void b() {
        this.b.clear();
    }

    public final void c() {
        this.a = null;
    }

    public final void d() {
        this.c.clear();
    }

    public final boolean e(View view) {
        AbstractC13042fc3.i(view, "view");
        return this.b.contains(view);
    }

    public final View f(int i) {
        return (View) this.b.get(i);
    }

    public final int g() {
        return this.b.size();
    }

    public final View h() {
        return this.a;
    }

    public final int i() {
        return this.c.size();
    }

    public final View j() {
        Object objPop = this.c.pop();
        AbstractC13042fc3.h(objPop, "redoViews.pop()");
        return (View) objPop;
    }

    public final void k(View view) {
        AbstractC13042fc3.i(view, "view");
        this.c.push(view);
    }

    public final View l(int i) {
        return (View) this.b.remove(i);
    }

    public final void m(View view) {
        AbstractC13042fc3.i(view, "view");
        this.b.remove(view);
    }

    public final boolean n(View view) {
        AbstractC13042fc3.i(view, "view");
        int iIndexOf = this.b.indexOf(view);
        if (iIndexOf <= -1) {
            return false;
        }
        this.b.set(iIndexOf, view);
        return true;
    }

    public final void o(View view) {
        this.a = view;
    }
}
