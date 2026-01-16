package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.ICrashTransformer;
import io.appmetrica.analytics.impl.C2519ef;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Pattern;

/* renamed from: io.appmetrica.analytics.impl.ef, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2519ef implements InterfaceC2621im {
    @Override // io.appmetrica.analytics.impl.InterfaceC2621im
    public final InterfaceC3016za a(Context context, Na na) {
        return new Tg(new Sm(na, "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"), new InterfaceC2606i6() { // from class: ir.nasim.kd8
            @Override // io.appmetrica.analytics.impl.InterfaceC2606i6
            public final boolean a(Throwable th) {
                return C2519ef.a(th);
            }
        }, (ICrashTransformer) null, new G9(context));
    }

    public static final boolean a(Throwable th) {
        String string;
        Pattern pattern = AbstractC2904ui.a;
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            string = stringWriter.toString();
            printWriter.close();
        } else {
            string = "";
        }
        return !TextUtils.isEmpty(string) && AbstractC2904ui.a.matcher(string).find();
    }
}
