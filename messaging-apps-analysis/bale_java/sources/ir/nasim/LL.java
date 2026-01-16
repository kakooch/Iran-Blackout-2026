package ir.nasim;

import ir.nasim.InterfaceC4155Dx5;

/* loaded from: classes3.dex */
public final class LL {
    private int a;
    private InterfaceC4155Dx5.a b = InterfaceC4155Dx5.a.DEFAULT;

    private static final class a implements InterfaceC4155Dx5 {
        private final int b;
        private final InterfaceC4155Dx5.a c;

        a(int i, InterfaceC4155Dx5.a aVar) {
            this.b = i;
            this.c = aVar;
        }

        @Override // java.lang.annotation.Annotation
        public Class annotationType() {
            return InterfaceC4155Dx5.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InterfaceC4155Dx5)) {
                return false;
            }
            InterfaceC4155Dx5 interfaceC4155Dx5 = (InterfaceC4155Dx5) obj;
            return this.b == interfaceC4155Dx5.tag() && this.c.equals(interfaceC4155Dx5.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.b) + (this.c.hashCode() ^ 2041407134);
        }

        @Override // ir.nasim.InterfaceC4155Dx5
        public InterfaceC4155Dx5.a intEncoding() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC4155Dx5
        public int tag() {
            return this.b;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.b + "intEncoding=" + this.c + ')';
        }
    }

    public static LL b() {
        return new LL();
    }

    public InterfaceC4155Dx5 a() {
        return new a(this.a, this.b);
    }

    public LL c(int i) {
        this.a = i;
        return this;
    }
}
