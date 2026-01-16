package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.zk1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC25103zk1 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.zk1$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final String a(Context context) {
            AbstractC13042fc3.i(context, "context");
            String string = context.getString(AbstractC12217eE5.message_holder_content_message);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
    }

    static String e(Context context) {
        return a.a(context);
    }

    String b(Context context, int i, String str, boolean z);
}
