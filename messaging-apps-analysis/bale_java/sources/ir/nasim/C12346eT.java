package ir.nasim;

import ir.nasim.AbstractC18832pK2;

/* renamed from: ir.nasim.eT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C12346eT extends AbstractC18832pK2 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;

    /* renamed from: ir.nasim.eT$b */
    static final class b extends AbstractC18832pK2.a {
        private String a;
        private String b;
        private String c;
        private String d;

        b() {
        }

        @Override // ir.nasim.AbstractC18832pK2.a
        public AbstractC18832pK2 a() {
            String str = "";
            if (this.a == null) {
                str = " glVersion";
            }
            if (this.b == null) {
                str = str + " eglVersion";
            }
            if (this.c == null) {
                str = str + " glExtensions";
            }
            if (this.d == null) {
                str = str + " eglExtensions";
            }
            if (str.isEmpty()) {
                return new C12346eT(this.a, this.b, this.c, this.d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.AbstractC18832pK2.a
        public AbstractC18832pK2.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null eglExtensions");
            }
            this.d = str;
            return this;
        }

        @Override // ir.nasim.AbstractC18832pK2.a
        public AbstractC18832pK2.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null eglVersion");
            }
            this.b = str;
            return this;
        }

        @Override // ir.nasim.AbstractC18832pK2.a
        public AbstractC18832pK2.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null glExtensions");
            }
            this.c = str;
            return this;
        }

        @Override // ir.nasim.AbstractC18832pK2.a
        public AbstractC18832pK2.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null glVersion");
            }
            this.a = str;
            return this;
        }
    }

    @Override // ir.nasim.AbstractC18832pK2
    public String b() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC18832pK2
    public String c() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC18832pK2
    public String d() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC18832pK2
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC18832pK2)) {
            return false;
        }
        AbstractC18832pK2 abstractC18832pK2 = (AbstractC18832pK2) obj;
        return this.a.equals(abstractC18832pK2.e()) && this.b.equals(abstractC18832pK2.c()) && this.c.equals(abstractC18832pK2.d()) && this.d.equals(abstractC18832pK2.b());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        return "GraphicDeviceInfo{glVersion=" + this.a + ", eglVersion=" + this.b + ", glExtensions=" + this.c + ", eglExtensions=" + this.d + "}";
    }

    private C12346eT(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }
}
