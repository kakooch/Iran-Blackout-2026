package ir.nasim;

/* renamed from: ir.nasim.fv3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13259fv3 {

    /* renamed from: ir.nasim.fv3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ C20996sx3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, C20996sx3 c20996sx3) {
            super(1);
            this.e = ua2;
            this.f = c20996sx3;
        }

        public final Object a(int i) {
            if (this.e == null) {
                return androidx.paging.compose.a.a(i);
            }
            Object objJ = this.f.j(i);
            return objJ == null ? androidx.paging.compose.a.a(i) : this.e.invoke(objJ);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final UA2 a(C20996sx3 c20996sx3, UA2 ua2) {
        AbstractC13042fc3.i(c20996sx3, "<this>");
        return new a(ua2, c20996sx3);
    }
}
