package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.cS7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10938cS7 {
    public static final a b = new a(null);
    private static final C10938cS7 c = new C10938cS7(AbstractC10360bX0.m());
    private final List a;

    /* renamed from: ir.nasim.cS7$a */
    public static final class a {
        private a() {
        }

        public final C10938cS7 a(C14464hx5 c14464hx5) {
            AbstractC13042fc3.i(c14464hx5, "table");
            if (c14464hx5.u() == 0) {
                return b();
            }
            List listW = c14464hx5.w();
            AbstractC13042fc3.h(listW, "table.requirementList");
            return new C10938cS7(listW, null);
        }

        public final C10938cS7 b() {
            return C10938cS7.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C10938cS7(List list, ED1 ed1) {
        this(list);
    }

    public final C13871gx5 b(int i) {
        return (C13871gx5) AbstractC15401jX0.t0(this.a, i);
    }

    private C10938cS7(List list) {
        this.a = list;
    }
}
