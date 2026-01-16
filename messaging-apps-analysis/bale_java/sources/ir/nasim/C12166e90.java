package ir.nasim;

import ir.nasim.UK6;

/* renamed from: ir.nasim.e90, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12166e90 extends C17749nV2 {
    private UK6.d n0;
    private int o0;
    private C11523d90 p0;

    /* renamed from: ir.nasim.e90$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UK6.d.values().length];
            a = iArr;
            try {
                iArr[UK6.d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UK6.d.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UK6.d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[UK6.d.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[UK6.d.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[UK6.d.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public C12166e90(UK6 uk6) {
        super(uk6, UK6.e.BARRIER);
    }

    @Override // ir.nasim.C13060fe1
    public C13060fe1 A(int i) {
        this.o0 = i;
        return this;
    }

    @Override // ir.nasim.C13060fe1
    public C13060fe1 B(Object obj) {
        A(this.j0.d(obj));
        return this;
    }

    @Override // ir.nasim.C17749nV2
    public C18931pV2 X() {
        if (this.p0 == null) {
            this.p0 = new C11523d90();
        }
        return this.p0;
    }

    public void Y(UK6.d dVar) {
        this.n0 = dVar;
    }

    @Override // ir.nasim.C17749nV2, ir.nasim.C13060fe1, ir.nasim.InterfaceC14709iL5, ir.nasim.InterfaceC17844nf2
    public void apply() {
        X();
        int i = a.a[this.n0.ordinal()];
        int i2 = 3;
        if (i == 3 || i == 4) {
            i2 = 1;
        } else if (i == 5) {
            i2 = 2;
        } else if (i != 6) {
            i2 = 0;
        }
        this.p0.z1(i2);
        this.p0.A1(this.o0);
    }
}
