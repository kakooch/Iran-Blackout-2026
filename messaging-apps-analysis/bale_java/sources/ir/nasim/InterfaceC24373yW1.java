package ir.nasim;

import android.view.View;

/* renamed from: ir.nasim.yW1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC24373yW1 {
    static /* synthetic */ void h(InterfaceC24373yW1 interfaceC24373yW1, C8967Xz7 c8967Xz7, AbstractC17757nW1 abstractC17757nW1, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDocumentClicked");
        }
        if ((i & 2) != 0) {
            Object objF = c8967Xz7.f();
            AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Document");
            abstractC17757nW1 = (AbstractC17757nW1) objF;
        }
        if ((i & 4) != 0) {
            view = null;
        }
        interfaceC24373yW1.b(c8967Xz7, abstractC17757nW1, view);
    }

    void a(J44 j44);

    void b(C8967Xz7 c8967Xz7, AbstractC17757nW1 abstractC17757nW1, View view);

    void c(C8967Xz7 c8967Xz7, String str, SA2 sa2);

    void d(C8967Xz7 c8967Xz7, Object obj);

    void e(long j, long j2, C8967Xz7 c8967Xz7, Object obj, SA2 sa2);

    void f(C8967Xz7 c8967Xz7, EnumC9477a18 enumC9477a18, String str);

    void g(String str);
}
