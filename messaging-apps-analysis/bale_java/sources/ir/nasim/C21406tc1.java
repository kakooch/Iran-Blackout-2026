package ir.nasim;

import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.tc1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21406tc1 extends AbstractC6535Nx5 {
    private final C22063uc1 b;

    /* renamed from: ir.nasim.tc1$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            AbstractC5138Ib1.t("Unexpected call to default provider");
            throw new KotlinNothingValueException();
        }
    }

    public C21406tc1(UA2 ua2) {
        super(a.e);
        this.b = new C22063uc1(ua2);
    }

    @Override // ir.nasim.AbstractC6535Nx5
    public C7252Qx5 c(Object obj) {
        return new C7252Qx5(this, obj, obj == null, null, null, null, true);
    }

    @Override // ir.nasim.AbstractC8979Yb1
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C22063uc1 a() {
        return this.b;
    }
}
