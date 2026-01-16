package ir.nasim;

import java.util.Arrays;
import java.util.Set;

/* renamed from: ir.nasim.Uh3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC8047Uh3 {
    InterfaceC22715vi3 a(C9424Zw2 c9424Zw2);

    InterfaceC7106Qh3 b(a aVar);

    Set c(C9424Zw2 c9424Zw2);

    /* renamed from: ir.nasim.Uh3$a */
    public static final class a {
        private final C24948zU0 a;
        private final byte[] b;
        private final InterfaceC7106Qh3 c;

        public a(C24948zU0 c24948zU0, byte[] bArr, InterfaceC7106Qh3 interfaceC7106Qh3) {
            AbstractC13042fc3.i(c24948zU0, "classId");
            this.a = c24948zU0;
            this.b = bArr;
            this.c = interfaceC7106Qh3;
        }

        public final C24948zU0 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            byte[] bArr = this.b;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            InterfaceC7106Qh3 interfaceC7106Qh3 = this.c;
            return iHashCode2 + (interfaceC7106Qh3 != null ? interfaceC7106Qh3.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.b) + ", outerClass=" + this.c + ')';
        }

        public /* synthetic */ a(C24948zU0 c24948zU0, byte[] bArr, InterfaceC7106Qh3 interfaceC7106Qh3, int i, ED1 ed1) {
            this(c24948zU0, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : interfaceC7106Qh3);
        }
    }
}
