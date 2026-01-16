package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.View;

/* loaded from: classes5.dex */
public abstract class AV7 {

    public static final class a extends AV7 {
        private final View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(null);
            AbstractC13042fc3.i(view, "androidView");
            this.a = view;
        }

        public final View a() {
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
            return "AndroidViewVideo(androidView=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends AV7 {
        private final InterfaceC14603iB2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC14603iB2 interfaceC14603iB2) {
            super(null);
            AbstractC13042fc3.i(interfaceC14603iB2, "composeView");
            this.a = interfaceC14603iB2;
        }

        public final InterfaceC14603iB2 a() {
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
            return "ComposeViewVideo(composeView=" + this.a + Separators.RPAREN;
        }
    }

    private AV7() {
    }

    public /* synthetic */ AV7(ED1 ed1) {
        this();
    }
}
