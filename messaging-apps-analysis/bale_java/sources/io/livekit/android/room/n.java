package io.livekit.android.room;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;

/* loaded from: classes3.dex */
public abstract class n {

    public static final class a extends n {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            AbstractC13042fc3.i(str, "value");
            this.a = str;
        }

        public final String a() {
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
            return "Cid(value=" + this.a + ')';
        }
    }

    private n() {
    }

    public /* synthetic */ n(ED1 ed1) {
        this();
    }
}
