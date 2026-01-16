package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.nI2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17632nI2 {
    private final String a;
    private final boolean b;

    /* renamed from: ir.nasim.nI2$a */
    public static final class a extends AbstractC17632nI2 {
        private final List c;
        private final int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean z, List list, int i) {
            super(null, z, 1, 0 == true ? 1 : 0);
            AbstractC13042fc3.i(list, "receivers");
            this.c = list;
            this.d = i;
        }

        public final int c() {
            return this.d;
        }

        public final List d() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.nI2$b */
    public static final class b extends AbstractC17632nI2 {
        /* JADX WARN: Multi-variable type inference failed */
        public b(boolean z) {
            super(null, z, 1, 0 == true ? 1 : 0);
        }
    }

    /* renamed from: ir.nasim.nI2$c */
    public static final class c extends AbstractC17632nI2 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, boolean z) {
            super(str, z, null);
            AbstractC13042fc3.i(str, "data");
        }
    }

    /* renamed from: ir.nasim.nI2$d */
    public static final class d extends AbstractC17632nI2 {
        private final List c;
        private final int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(boolean z, List list, int i) {
            super(null, z, 1, 0 == true ? 1 : 0);
            AbstractC13042fc3.i(list, "receivers");
            this.c = list;
            this.d = i;
        }

        public final int c() {
            return this.d;
        }

        public final List d() {
            return this.c;
        }
    }

    public /* synthetic */ AbstractC17632nI2(String str, boolean z, ED1 ed1) {
        this(str, z);
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    private AbstractC17632nI2(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public /* synthetic */ AbstractC17632nI2(String str, boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, z, null);
    }
}
