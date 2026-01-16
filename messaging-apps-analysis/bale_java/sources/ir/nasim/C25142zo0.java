package ir.nasim;

import java.nio.ByteBuffer;

/* renamed from: ir.nasim.zo0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C25142zo0 implements HW5 {
    private final C16602lZ1 a;

    public C25142zo0(C16602lZ1 c16602lZ1) {
        this.a = c16602lZ1;
    }

    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(ByteBuffer byteBuffer, int i, int i2, HL4 hl4) {
        return this.a.g(byteBuffer, i, i2, hl4);
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, HL4 hl4) {
        return this.a.q(byteBuffer);
    }
}
