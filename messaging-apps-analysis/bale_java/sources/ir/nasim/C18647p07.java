package ir.nasim;

/* renamed from: ir.nasim.p07, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C18647p07 extends C10656by6 implements InterfaceC10258bL6 {
    public C18647p07(int i) {
        super(1, Integer.MAX_VALUE, EnumC6162Ml0.DROP_OLDEST);
        c(Integer.valueOf(i));
    }

    @Override // ir.nasim.InterfaceC10258bL6
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer numValueOf;
        synchronized (this) {
            numValueOf = Integer.valueOf(((Number) O()).intValue());
        }
        return numValueOf;
    }

    public final boolean c0(int i) {
        boolean zC;
        synchronized (this) {
            zC = c(Integer.valueOf(((Number) O()).intValue() + i));
        }
        return zC;
    }
}
