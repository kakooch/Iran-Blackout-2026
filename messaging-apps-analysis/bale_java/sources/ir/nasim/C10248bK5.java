package ir.nasim;

import ir.nasim.tgwidgets.editor.messenger.MediaController;

/* renamed from: ir.nasim.bK5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10248bK5 {
    public static final C10248bK5 a = new C10248bK5();

    private C10248bK5() {
    }

    public final MediaController.m a(String str) {
        AbstractC13042fc3.i(str, "path");
        return new MediaController.m(0, 0, 0L, str, 0, false, 0, 0, 0L);
    }

    public final MediaController.m b(String str, int i) {
        AbstractC13042fc3.i(str, "path");
        return new MediaController.m(0, 0, 0L, str, i, true, 0, 0, 0L);
    }
}
