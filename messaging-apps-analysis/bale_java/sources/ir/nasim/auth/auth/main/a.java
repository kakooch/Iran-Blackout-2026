package ir.nasim.auth.auth.main;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: ir.nasim.auth.auth.main.a$a, reason: collision with other inner class name */
    public static final class C0872a extends a {
        private String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0872a(String str) {
            super(null);
            AbstractC13042fc3.i(str, "transactionHash");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }
    }

    public static final class b extends a {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    private a() {
    }

    public /* synthetic */ a(ED1 ed1) {
        this();
    }
}
