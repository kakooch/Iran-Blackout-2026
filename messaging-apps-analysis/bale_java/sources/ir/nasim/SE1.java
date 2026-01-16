package ir.nasim;

/* loaded from: classes8.dex */
public final class SE1 extends AbstractC4918Hc6 {
    public static final SE1 i = new SE1();

    private SE1() {
        super(AbstractC9312Zj7.c, AbstractC9312Zj7.d, AbstractC9312Zj7.e, AbstractC9312Zj7.a);
    }

    @Override // ir.nasim.AbstractC13778go1
    public AbstractC13778go1 B0(int i2) {
        AbstractC3703Bz3.a(i2);
        return i2 >= AbstractC9312Zj7.c ? this : super.B0(i2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // ir.nasim.AbstractC13778go1
    public String toString() {
        return "Dispatchers.Default";
    }
}
