package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC4886Gz1;

/* loaded from: classes7.dex */
public abstract class PA7 {
    private final AbstractC4886Gz1 a;

    public static final class a extends PA7 {
        public static final a b = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return super.equals(obj);
        }
    }

    public static final class b extends PA7 {
        private final AbstractC4886Gz1.a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC4886Gz1.a aVar) {
            super(null);
            AbstractC13042fc3.i(aVar, "data");
            this.b = aVar;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return super.equals(obj);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Loading(data=" + this.b + Separators.RPAREN;
        }
    }

    public static final class c extends PA7 {
        public static final int c = C24119y45.r;
        private final AbstractC4886Gz1.b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractC4886Gz1.b bVar) {
            super(null);
            AbstractC13042fc3.i(bVar, "data");
            this.b = bVar;
        }

        public AbstractC4886Gz1.b a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return super.equals(obj);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.b + Separators.RPAREN;
        }
    }

    public /* synthetic */ PA7(ED1 ed1) {
        this();
    }

    private PA7() {
        this.a = new AbstractC4886Gz1.a(0.0f);
    }
}
