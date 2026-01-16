package ir.nasim;

import ir.nasim.AbstractC7863Tn;

/* loaded from: classes2.dex */
final class NS extends AbstractC7863Tn {
    private final Integer a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;

    static final class b extends AbstractC7863Tn.a {
        private Integer a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;

        b() {
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn a() {
            return new NS(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a b(String str) {
            this.l = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a c(String str) {
            this.j = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a d(String str) {
            this.d = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a e(String str) {
            this.h = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a f(String str) {
            this.c = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a g(String str) {
            this.i = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a h(String str) {
            this.g = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a i(String str) {
            this.k = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a j(String str) {
            this.b = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a k(String str) {
            this.f = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a l(String str) {
            this.e = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7863Tn.a
        public AbstractC7863Tn.a m(Integer num) {
            this.a = num;
            return this;
        }
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String b() {
        return this.l;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String c() {
        return this.j;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String d() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC7863Tn)) {
            return false;
        }
        AbstractC7863Tn abstractC7863Tn = (AbstractC7863Tn) obj;
        Integer num = this.a;
        if (num != null ? num.equals(abstractC7863Tn.m()) : abstractC7863Tn.m() == null) {
            String str = this.b;
            if (str != null ? str.equals(abstractC7863Tn.j()) : abstractC7863Tn.j() == null) {
                String str2 = this.c;
                if (str2 != null ? str2.equals(abstractC7863Tn.f()) : abstractC7863Tn.f() == null) {
                    String str3 = this.d;
                    if (str3 != null ? str3.equals(abstractC7863Tn.d()) : abstractC7863Tn.d() == null) {
                        String str4 = this.e;
                        if (str4 != null ? str4.equals(abstractC7863Tn.l()) : abstractC7863Tn.l() == null) {
                            String str5 = this.f;
                            if (str5 != null ? str5.equals(abstractC7863Tn.k()) : abstractC7863Tn.k() == null) {
                                String str6 = this.g;
                                if (str6 != null ? str6.equals(abstractC7863Tn.h()) : abstractC7863Tn.h() == null) {
                                    String str7 = this.h;
                                    if (str7 != null ? str7.equals(abstractC7863Tn.e()) : abstractC7863Tn.e() == null) {
                                        String str8 = this.i;
                                        if (str8 != null ? str8.equals(abstractC7863Tn.g()) : abstractC7863Tn.g() == null) {
                                            String str9 = this.j;
                                            if (str9 != null ? str9.equals(abstractC7863Tn.c()) : abstractC7863Tn.c() == null) {
                                                String str10 = this.k;
                                                if (str10 != null ? str10.equals(abstractC7863Tn.i()) : abstractC7863Tn.i() == null) {
                                                    String str11 = this.l;
                                                    if (str11 == null) {
                                                        if (abstractC7863Tn.b() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(abstractC7863Tn.b())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String f() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String g() {
        return this.i;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String h() {
        return this.g;
    }

    public int hashCode() {
        Integer num = this.a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.l;
        return iHashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String i() {
        return this.k;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String j() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String k() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public String l() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC7863Tn
    public Integer m() {
        return this.a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.a + ", model=" + this.b + ", hardware=" + this.c + ", device=" + this.d + ", product=" + this.e + ", osBuild=" + this.f + ", manufacturer=" + this.g + ", fingerprint=" + this.h + ", locale=" + this.i + ", country=" + this.j + ", mccMnc=" + this.k + ", applicationBuild=" + this.l + "}";
    }

    private NS(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.a = num;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
    }
}
