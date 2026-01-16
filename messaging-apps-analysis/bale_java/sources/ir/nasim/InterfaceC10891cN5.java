package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.network.RpcException;

/* renamed from: ir.nasim.cN5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC10891cN5 {

    /* renamed from: ir.nasim.cN5$a */
    public static final class a implements InterfaceC10891cN5 {
        private final RpcException a;

        public a(RpcException rpcException) {
            AbstractC13042fc3.i(rpcException, "e");
            this.a = rpcException;
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

    /* renamed from: ir.nasim.cN5$b */
    public static final class b implements InterfaceC10891cN5 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 802086094;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* renamed from: ir.nasim.cN5$c */
    public static final class c implements InterfaceC10891cN5 {
        private final Object a;

        public c(Object obj) {
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            Object obj = this.a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.a + Separators.RPAREN;
        }
    }
}
