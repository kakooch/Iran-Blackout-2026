package ir.nasim;

import ir.nasim.tgwidgets.editor.SQLite.SQLiteCursor;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteDatabase;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class XO6 {
    int a;
    ir.nasim.tgwidgets.editor.messenger.D b;

    public XO6(int i) {
        this.a = i;
        this.b = ir.nasim.tgwidgets.editor.messenger.D.F(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final InterfaceC23269we1 interfaceC23269we1) {
        SQLiteDatabase sQLiteDatabaseD = this.b.D();
        final C23078wJ3 c23078wJ3 = new C23078wJ3();
        try {
            SQLiteCursor sQLiteCursorG = sQLiteDatabaseD.g("SELECT dialog_id, max_read FROM stories_counter", new Object[0]);
            while (sQLiteCursorG.h()) {
                c23078wJ3.h(sQLiteCursorG.g(0), sQLiteCursorG.e(1));
            }
        } catch (Exception e) {
            this.b.x(e);
        }
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.WO6
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC23269we1.accept(c23078wJ3);
            }
        });
    }

    public void c(final InterfaceC23269we1 interfaceC23269we1) {
        this.b.G().i(new Runnable() { // from class: ir.nasim.VO6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e(interfaceC23269we1);
            }
        });
    }
}
