package ir.nasim;

import android.content.Context;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: ir.nasim.Ml4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6166Ml4 implements InterfaceC15645jv7 {
    private final Collection b;

    public C6166Ml4(InterfaceC15645jv7... interfaceC15645jv7Arr) {
        if (interfaceC15645jv7Arr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.b = Arrays.asList(interfaceC15645jv7Arr);
    }

    @Override // ir.nasim.InterfaceC15645jv7
    public DW5 a(Context context, DW5 dw5, int i, int i2) {
        Iterator it = this.b.iterator();
        DW5 dw52 = dw5;
        while (it.hasNext()) {
            DW5 dw5A = ((InterfaceC15645jv7) it.next()).a(context, dw52, i, i2);
            if (dw52 != null && !dw52.equals(dw5) && !dw52.equals(dw5A)) {
                dw52.a();
            }
            dw52 = dw5A;
        }
        return dw52;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((InterfaceC15645jv7) it.next()).b(messageDigest);
        }
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (obj instanceof C6166Ml4) {
            return this.b.equals(((C6166Ml4) obj).b);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return this.b.hashCode();
    }
}
