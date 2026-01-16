package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.j;
import ir.nasim.PC5;

/* loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {
    private e a;
    private androidx.appcompat.app.a b;
    c c;
    private j.a d;

    public f(e eVar) {
        this.a = eVar;
    }

    public void a() {
        androidx.appcompat.app.a aVar = this.b;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void b(IBinder iBinder) {
        e eVar = this.a;
        a.C0011a c0011a = new a.C0011a(eVar.w());
        c cVar = new c(c0011a.getContext(), PC5.abc_list_menu_item_layout);
        this.c = cVar;
        cVar.e(this);
        this.a.b(this.c);
        c0011a.a(this.c.a(), this);
        View viewA = eVar.A();
        if (viewA != null) {
            c0011a.b(viewA);
        } else {
            c0011a.c(eVar.y()).setTitle(eVar.z());
        }
        c0011a.h(this);
        androidx.appcompat.app.a aVarCreate = c0011a.create();
        this.b = aVarCreate;
        aVarCreate.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.b.show();
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void c(e eVar, boolean z) {
        if (z || eVar == this.a) {
            a();
        }
        j.a aVar = this.d;
        if (aVar != null) {
            aVar.c(eVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean d(e eVar) {
        j.a aVar = this.d;
        if (aVar != null) {
            return aVar.d(eVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.N((g) this.c.a().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.c.c(this.a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.a.performShortcut(i, keyEvent, 0);
    }
}
