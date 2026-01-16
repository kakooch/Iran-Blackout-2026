package ir.nasim;

/* renamed from: ir.nasim.x57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC23541x57 extends AbstractC12724f57 {
    public static AbstractC23541x57 d(T1 t1, int i, boolean z) {
        AbstractC23541x57 p87 = i != -55902537 ? i != 1684014375 ? null : new P87() : new O87();
        if (p87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputDialogPeer", Integer.valueOf(i)));
        }
        if (p87 != null) {
            p87.b(t1, z);
        }
        return p87;
    }
}
