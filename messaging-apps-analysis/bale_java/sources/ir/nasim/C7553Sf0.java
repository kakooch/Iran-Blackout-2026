package ir.nasim;

import android.graphics.drawable.BitmapDrawable;
import java.io.File;

/* renamed from: ir.nasim.Sf0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C7553Sf0 implements KW5 {
    private final InterfaceC13106fg0 a;
    private final KW5 b;

    public C7553Sf0(InterfaceC13106fg0 interfaceC13106fg0, KW5 kw5) {
        this.a = interfaceC13106fg0;
        this.b = kw5;
    }

    @Override // ir.nasim.KW5
    public T72 a(HL4 hl4) {
        return this.b.a(hl4);
    }

    @Override // ir.nasim.Z72
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(DW5 dw5, File file, HL4 hl4) {
        return this.b.b(new C14288hg0(((BitmapDrawable) dw5.get()).getBitmap(), this.a), file, hl4);
    }
}
