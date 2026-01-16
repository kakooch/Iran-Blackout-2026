package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.qY7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC19554qY7 extends Serializable {

    /* renamed from: ir.nasim.qY7$a */
    public static final class a implements InterfaceC19554qY7 {
        private final String a;

        public a(String str) {
            AbstractC13042fc3.i(str, "fileDescriptor");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.qY7$b */
    public static final class b implements InterfaceC19554qY7 {
        private final long a;
        private final long b;

        public b(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public final long a() {
            return this.b;
        }

        public final long b() {
            return this.a;
        }
    }
}
