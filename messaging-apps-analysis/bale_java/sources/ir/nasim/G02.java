package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class G02 implements InterfaceC15645jv7 {
    private final InterfaceC15645jv7 b;
    private final boolean c;

    public G02(InterfaceC15645jv7 interfaceC15645jv7, boolean z) {
        this.b = interfaceC15645jv7;
        this.c = z;
    }

    private DW5 d(Context context, DW5 dw5) {
        return C10009av3.d(context.getResources(), dw5);
    }

    @Override // ir.nasim.InterfaceC15645jv7
    public DW5 a(Context context, DW5 dw5, int i, int i2) {
        InterfaceC13106fg0 interfaceC13106fg0F = com.bumptech.glide.b.c(context).f();
        Drawable drawable = (Drawable) dw5.get();
        DW5 dw5A = F02.a(interfaceC13106fg0F, drawable, i, i2);
        if (dw5A != null) {
            DW5 dw5A2 = this.b.a(context, dw5A, i, i2);
            if (!dw5A2.equals(dw5A)) {
                return d(context, dw5A2);
            }
            dw5A2.a();
            return dw5;
        }
        if (!this.c) {
            return dw5;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (obj instanceof G02) {
            return this.b.equals(((G02) obj).b);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return this.b.hashCode();
    }

    public InterfaceC15645jv7 c() {
        return this;
    }
}
