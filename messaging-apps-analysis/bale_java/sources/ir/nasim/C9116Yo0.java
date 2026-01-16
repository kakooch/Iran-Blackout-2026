package ir.nasim;

/* renamed from: ir.nasim.Yo0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C9116Yo0 implements DW5 {
    private final byte[] a;

    public C9116Yo0(byte[] bArr) {
        this.a = (byte[]) AbstractC3322Aj5.d(bArr);
    }

    @Override // ir.nasim.DW5
    public Class b() {
        return byte[].class;
    }

    @Override // ir.nasim.DW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.a;
    }

    @Override // ir.nasim.DW5
    public int f() {
        return this.a.length;
    }

    @Override // ir.nasim.DW5
    public void a() {
    }
}
