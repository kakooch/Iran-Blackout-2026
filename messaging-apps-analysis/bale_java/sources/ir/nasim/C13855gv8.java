package ir.nasim;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.gv8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13855gv8 extends Vh8 {
    private final Callable c;

    public C13855gv8(String str, Callable callable) {
        super("internal.appMetadata");
        this.c = callable;
    }

    @Override // ir.nasim.Vh8
    public final InterfaceC22720vi8 a(C20322ro8 c20322ro8, List list) {
        try {
            return Yp8.b(this.c.call());
        } catch (Exception unused) {
            return InterfaceC22720vi8.r0;
        }
    }
}
