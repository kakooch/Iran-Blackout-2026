package ir.nasim;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.Ow1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ActionModeCallbackC6761Ow1 implements ActionMode.Callback {
    private final TextView a;
    private final UA2 b;

    public ActionModeCallbackC6761Ow1(TextView textView, UA2 ua2) {
        AbstractC13042fc3.i(textView, "textView");
        AbstractC13042fc3.i(ua2, "onAskAIClick");
        this.a = textView;
        this.b = ua2;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        AbstractC13042fc3.i(actionMode, "mode");
        AbstractC13042fc3.i(menuItem, "item");
        String string = this.a.getText().subSequence(this.a.getSelectionStart(), this.a.getSelectionEnd()).toString();
        if (menuItem.getItemId() != BC5.ask_ai) {
            return false;
        }
        this.b.invoke(string);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        AbstractC13042fc3.i(actionMode, "mode");
        AbstractC13042fc3.i(menu, "menu");
        menu.clear();
        actionMode.getMenuInflater().inflate(AbstractC15226jD5.selection_menu, menu);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        AbstractC13042fc3.i(actionMode, "mode");
        this.a.clearFocus();
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        AbstractC13042fc3.i(actionMode, "mode");
        AbstractC13042fc3.i(menu, "menu");
        ArrayList arrayList = new ArrayList();
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            if (item.getItemId() != 16908321 && item.getItemId() != 16908319 && item.getItemId() != BC5.ask_ai) {
                arrayList.add(Integer.valueOf(item.getItemId()));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            menu.removeItem(((Number) it.next()).intValue());
        }
        if (C8386Vt0.a.t4()) {
            return true;
        }
        menu.removeItem(BC5.ask_ai);
        return true;
    }
}
