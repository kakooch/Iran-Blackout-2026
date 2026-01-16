package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Mq6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6213Mq6 extends AbstractC12586er6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6213Mq6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        throw new IllegalStateException();
    }

    @Override // ir.nasim.AbstractC12586er6, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.dialog_call_missed);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }
}
