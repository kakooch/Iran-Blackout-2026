package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.zI7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24847zI7 {
    public static final C24847zI7 a = new C24847zI7();

    private C24847zI7() {
    }

    public static /* synthetic */ String b(C24847zI7 c24847zI7, Context context, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        return c24847zI7.a(context, i, str, z);
    }

    private final InterfaceC8344Vo3 c() {
        return AbstractC5969Lp4.e().W().p0();
    }

    private final String d(int i) {
        C17637nI7 c17637nI7 = (C17637nI7) c().d(i);
        if (c17637nI7 != null) {
            return c17637nI7.getName();
        }
        return null;
    }

    public final String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        if (i == AbstractC5969Lp4.f()) {
            String string = context.getString(AbstractC12217eE5.all_referencing_you);
            AbstractC13042fc3.f(string);
            return string;
        }
        if (str == null && (str = a.d(i)) == null) {
            str = context.getString(AbstractC12217eE5.all_default_user_title);
            AbstractC13042fc3.h(str, "getString(...)");
        }
        return z ? AbstractC20655sN7.c(context, AbstractC12217eE5.all_double_quote, str) : str;
    }
}
