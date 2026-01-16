package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.yt3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24601yt3 {
    public static final String a(String str, Context context) {
        AbstractC13042fc3.i(context, "context");
        if (str != null) {
            return str;
        }
        String string = context.getString(FD5.message_holder_content_template);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }
}
