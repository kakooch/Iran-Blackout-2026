package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Wr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8608Wr6 extends AbstractC12586er6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8608Wr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.service_data_sent_to_the_bot);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }
}
