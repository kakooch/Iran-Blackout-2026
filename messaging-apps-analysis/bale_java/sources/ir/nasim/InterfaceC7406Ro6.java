package ir.nasim;

import ai.bale.proto.GiftpacketStruct$GiftReceiver;
import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Ro6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC7406Ro6 {

    /* renamed from: ir.nasim.Ro6$a */
    public static final class a implements InterfaceC7406Ro6 {
        private final long a;
        private final int b;
        private final int c;
        private final List d;
        private final EnumC19802qy e;

        public a(long j, int i, int i2, List list, EnumC19802qy enumC19802qy) {
            AbstractC13042fc3.i(list, "receivers");
            AbstractC13042fc3.i(enumC19802qy, "givingType");
            this.a = j;
            this.b = i;
            this.c = i2;
            this.d = list;
            this.e = enumC19802qy;
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.c;
        }

        public final List c() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && AbstractC13042fc3.d(this.d, aVar.d) && this.e == aVar.e;
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Group(date=" + this.a + ", allCount=" + this.b + ", openedCount=" + this.c + ", receivers=" + this.d + ", givingType=" + this.e + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Ro6$b */
    public static final class b implements InterfaceC7406Ro6 {
        private final long a;
        private final boolean b;
        private final GiftpacketStruct$GiftReceiver c;

        public b(long j, boolean z, GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver) {
            this.a = j;
            this.b = z;
            this.c = giftpacketStruct$GiftReceiver;
        }

        public final GiftpacketStruct$GiftReceiver a() {
            return this.c;
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
            return this.a == bVar.a && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31;
            GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver = this.c;
            return iHashCode + (giftpacketStruct$GiftReceiver == null ? 0 : giftpacketStruct$GiftReceiver.hashCode());
        }

        public String toString() {
            return "Private(date=" + this.a + ", isOpened=" + this.b + ", receiver=" + this.c + Separators.RPAREN;
        }
    }
}
