package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.network.RpcException;

/* loaded from: classes5.dex */
public abstract class Z06 {

    public static final class a extends Z06 {
        private final RpcException a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RpcException rpcException) {
            super(null);
            AbstractC13042fc3.i(rpcException, "e");
            this.a = rpcException;
        }

        public final RpcException a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Failure(e=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends Z06 {
        private final com.google.protobuf.P a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.google.protobuf.P p) {
            super(null);
            AbstractC13042fc3.i(p, "data");
            this.a = p;
        }

        public final com.google.protobuf.P a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.a + Separators.RPAREN;
        }
    }

    private Z06() {
    }

    public /* synthetic */ Z06(ED1 ed1) {
        this();
    }
}
