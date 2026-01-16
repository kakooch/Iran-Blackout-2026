package ir.nasim;

import ai.bale.proto.MeetStruct$Call;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC21761u53;

/* renamed from: ir.nasim.Zz0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC9449Zz0 {

    /* renamed from: ir.nasim.Zz0$a */
    public static final class a implements InterfaceC9449Zz0 {
        private final long a;
        private final long b;

        public /* synthetic */ a(long j, long j2, ED1 ed1) {
            this(j, j2);
        }

        public final long a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC20975sv0.b(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            return (AbstractC20975sv0.c(this.a) * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "CallEvent(callId=" + AbstractC20975sv0.d(this.a) + ", triggererIdentity=" + this.b + Separators.RPAREN;
        }

        private a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    /* renamed from: ir.nasim.Zz0$b */
    public static final class b implements InterfaceC9449Zz0 {
        private final long a;
        private final boolean b;

        public b(long j, boolean z) {
            this.a = j;
            this.b = z;
        }

        public final long a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }

        public int hashCode() {
            return (Long.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "CallJoinRequestAnswered(callId=" + this.a + ", isAllowed=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Zz0$c */
    public static final class c implements InterfaceC9449Zz0 {
        private final long a;

        public /* synthetic */ c(long j, ED1 ed1) {
            this(j);
        }

        public final long a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC20975sv0.b(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return AbstractC20975sv0.c(this.a);
        }

        public String toString() {
            return "CallReceived(callId=" + AbstractC20975sv0.d(this.a) + Separators.RPAREN;
        }

        private c(long j) {
            this.a = j;
        }
    }

    /* renamed from: ir.nasim.Zz0$d */
    public static final class d implements InterfaceC9449Zz0 {
        private final MeetStruct$Call a;

        public d(MeetStruct$Call meetStruct$Call) {
            AbstractC13042fc3.i(meetStruct$Call, "update");
            this.a = meetStruct$Call;
        }

        public final MeetStruct$Call a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "DiscardCall(update=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Zz0$e */
    public static final class e implements InterfaceC9449Zz0 {
        private final AbstractC21761u53.c a;

        public e(AbstractC21761u53.c cVar) {
            AbstractC13042fc3.i(cVar, "incomingCall");
            this.a = cVar;
        }

        public final AbstractC21761u53.c a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.a, ((e) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "IncomingCallUpdate(incomingCall=" + this.a + Separators.RPAREN;
        }
    }
}
