package ir.nasim;

import android.content.Context;

/* loaded from: classes5.dex */
public final class WE1 extends AbstractC12586er6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WE1(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return r();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WE1) && super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
