package ir.nasim;

import android.content.Context;
import ir.nasim.C17182mY;

/* renamed from: ir.nasim.hj1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C14319hj1 {
    private final Context a;
    private final C17182mY.a b;

    public C14319hj1(Context context, C17182mY.a aVar) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(aVar, "baleContactDataLoaderFactory");
        this.a = context;
        this.b = aVar;
    }

    public final C13728gj1 a(String str, boolean z, EnumC4715Gg1 enumC4715Gg1) {
        AbstractC13042fc3.i(enumC4715Gg1, "sortType");
        String string = this.a.getString(AbstractC12217eE5.settings_saved_messages);
        AbstractC13042fc3.h(string, "getString(...)");
        return new C13728gj1(this.b.a(str, z, string, enumC4715Gg1));
    }
}
