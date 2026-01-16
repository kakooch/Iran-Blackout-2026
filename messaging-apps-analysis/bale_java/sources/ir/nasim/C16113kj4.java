package ir.nasim;

/* renamed from: ir.nasim.kj4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16113kj4 extends AbstractC8614Ws3 implements UA2 {
    final /* synthetic */ UA2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C16113kj4(UA2 ua2) {
        super(1);
        this.e = ua2;
    }

    public final Object a(long j) {
        return this.e.invoke(Long.valueOf(j / 1000000));
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a(((Number) obj).longValue());
    }
}
