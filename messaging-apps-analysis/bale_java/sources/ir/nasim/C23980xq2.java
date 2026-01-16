package ir.nasim;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/* renamed from: ir.nasim.xq2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23980xq2 extends ActionMode.Callback2 {
    private final C6160Mk7 a;

    public C23980xq2(C6160Mk7 c6160Mk7) {
        this.a = c6160Mk7;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.a.d(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.a.e(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.a.f();
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
        CK5 ck5C = this.a.c();
        if (rect != null) {
            rect.set((int) ck5C.i(), (int) ck5C.l(), (int) ck5C.j(), (int) ck5C.e());
        }
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.a.g(actionMode, menu);
    }
}
