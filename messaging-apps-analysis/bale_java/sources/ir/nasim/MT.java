package ir.nasim;

import ir.nasim.AbstractC5792Kv7;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class MT extends AbstractC5792Kv7 {
    private final String a;
    private final byte[] b;
    private final EnumC5979Lq5 c;

    static final class b extends AbstractC5792Kv7.a {
        private String a;
        private byte[] b;
        private EnumC5979Lq5 c;

        b() {
        }

        @Override // ir.nasim.AbstractC5792Kv7.a
        public AbstractC5792Kv7 a() {
            String str = "";
            if (this.a == null) {
                str = " backendName";
            }
            if (this.c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new MT(this.a, this.b, this.c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.AbstractC5792Kv7.a
        public AbstractC5792Kv7.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.a = str;
            return this;
        }

        @Override // ir.nasim.AbstractC5792Kv7.a
        public AbstractC5792Kv7.a c(byte[] bArr) {
            this.b = bArr;
            return this;
        }

        @Override // ir.nasim.AbstractC5792Kv7.a
        public AbstractC5792Kv7.a d(EnumC5979Lq5 enumC5979Lq5) {
            if (enumC5979Lq5 == null) {
                throw new NullPointerException("Null priority");
            }
            this.c = enumC5979Lq5;
            return this;
        }
    }

    @Override // ir.nasim.AbstractC5792Kv7
    public String b() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC5792Kv7
    public byte[] c() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC5792Kv7
    public EnumC5979Lq5 d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC5792Kv7)) {
            return false;
        }
        AbstractC5792Kv7 abstractC5792Kv7 = (AbstractC5792Kv7) obj;
        if (this.a.equals(abstractC5792Kv7.b())) {
            if (Arrays.equals(this.b, abstractC5792Kv7 instanceof MT ? ((MT) abstractC5792Kv7).b : abstractC5792Kv7.c()) && this.c.equals(abstractC5792Kv7.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003) ^ this.c.hashCode();
    }

    private MT(String str, byte[] bArr, EnumC5979Lq5 enumC5979Lq5) {
        this.a = str;
        this.b = bArr;
        this.c = enumC5979Lq5;
    }
}
