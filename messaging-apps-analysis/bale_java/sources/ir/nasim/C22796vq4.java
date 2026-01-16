package ir.nasim;

/* renamed from: ir.nasim.vq4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C22796vq4 {
    private final C7386Rm4 a = C6405Nl4.e(null, 1, null);
    private final C7386Rm4 b = C6405Nl4.e(null, 1, null);

    /* renamed from: ir.nasim.vq4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C20869sk4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C20869sk4 c20869sk4) {
            super(1);
            this.e = c20869sk4;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(AbstractC23392wq4 abstractC23392wq4) {
            return Boolean.valueOf(AbstractC13042fc3.d(abstractC23392wq4.a(), this.e));
        }
    }

    public final void a() {
        C6405Nl4.c(this.a);
        C6405Nl4.c(this.b);
    }

    public final boolean b(AbstractC19669qk4 abstractC19669qk4) {
        return C6405Nl4.f(this.a, abstractC19669qk4);
    }

    public final AbstractC23392wq4 c(AbstractC19669qk4 abstractC19669qk4) {
        AbstractC23392wq4 abstractC23392wq4 = (AbstractC23392wq4) C6405Nl4.l(this.a, abstractC19669qk4);
        if (C6405Nl4.i(this.a)) {
            C6405Nl4.c(this.b);
        }
        return abstractC23392wq4;
    }

    public final void d(C20869sk4 c20869sk4) {
        Object objE = this.b.e(c20869sk4);
        if (objE != null) {
            if (!(objE instanceof C3587Bm4)) {
                AbstractC13042fc3.g(objE, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                AbstractC18350oW3.a(objE);
                C6405Nl4.m(this.a, null, new a(c20869sk4));
                return;
            }
            AbstractC23052wG4 abstractC23052wG4 = (AbstractC23052wG4) objE;
            Object[] objArr = abstractC23052wG4.a;
            int i = abstractC23052wG4.b;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                AbstractC18350oW3.a(obj);
                C6405Nl4.m(this.a, null, new a(c20869sk4));
            }
        }
    }
}
