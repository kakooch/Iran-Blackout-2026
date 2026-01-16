package ir.nasim;

/* loaded from: classes5.dex */
public abstract class KW3 {

    public static final class a extends KW3 {
        private final String a;
        private final String b;
        private final boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, boolean z) {
            super(null);
            AbstractC13042fc3.i(str, "path");
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        @Override // ir.nasim.KW3
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.KW3
        public String b() {
            return this.a;
        }

        @Override // ir.nasim.KW3
        public boolean c() {
            return this.c;
        }
    }

    public static final class b extends KW3 {
        private final String a;
        private final String b;
        private final boolean c;
        private final boolean d;
        private final ir.nasim.tgwidgets.editor.messenger.H e;

        public /* synthetic */ b(String str, String str2, boolean z, boolean z2, ir.nasim.tgwidgets.editor.messenger.H h, int i, ED1 ed1) {
            this(str, str2, z, z2, (i & 16) != 0 ? null : h);
        }

        @Override // ir.nasim.KW3
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.KW3
        public String b() {
            return this.a;
        }

        @Override // ir.nasim.KW3
        public boolean c() {
            return this.d;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, boolean z, boolean z2, ir.nasim.tgwidgets.editor.messenger.H h) {
            super(null);
            AbstractC13042fc3.i(str, "path");
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = z2;
            this.e = h;
        }
    }

    private KW3() {
    }

    public abstract String a();

    public abstract String b();

    public abstract boolean c();

    public /* synthetic */ KW3(ED1 ed1) {
        this();
    }
}
