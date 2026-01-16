package androidx.compose.ui.focus;

import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C12544en4;
import ir.nasim.ED1;
import ir.nasim.InterfaceC5283Ir2;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public final class m {
    public static final a b = new a(null);
    private static final m c = new m();
    private static final m d = new m();
    private static final m e = new m();
    private final C12544en4 a = new C12544en4(new InterfaceC5283Ir2[16], 0);

    public static final class a {
        private a() {
        }

        public final m a() {
            return m.d;
        }

        public final m b() {
            return m.c;
        }

        public final m c() {
            return m.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i) {
            super(1);
            this.e = i;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(FocusTargetNode focusTargetNode) {
            return Boolean.valueOf(focusTargetNode.M(this.e));
        }
    }

    public static /* synthetic */ boolean g(m mVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = d.b.b();
        }
        return mVar.f(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0060, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(ir.nasim.UA2 r18) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.m.d(ir.nasim.UA2):boolean");
    }

    public final C12544en4 e() {
        return this.a;
    }

    public final boolean f(int i) {
        return d(new b(i));
    }
}
