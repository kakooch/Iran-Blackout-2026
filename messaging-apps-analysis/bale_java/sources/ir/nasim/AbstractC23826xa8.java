package ir.nasim;

/* renamed from: ir.nasim.xa8, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23826xa8 {

    /* renamed from: ir.nasim.xa8$a */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ A98 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(A98 a98) {
            super(1);
            this.e = a98;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xa8$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(A98 a98, WH1 wh1) {
            return Integer.valueOf(a98.c(wh1));
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, A98 a98) {
        return eVar.i(new C18222oI1(a98, Q93.b() ? new a(a98) : Q93.a(), b.e));
    }
}
