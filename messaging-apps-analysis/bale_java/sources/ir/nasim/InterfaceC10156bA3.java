package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.net.Uri;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.bA3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC10156bA3 {

    /* renamed from: ir.nasim.bA3$a */
    public static final class a implements InterfaceC10156bA3 {
        private final String a;
        private final ExPeer b;

        public a(String str) {
            AbstractC13042fc3.i(str, "link");
            this.a = str;
        }

        @Override // ir.nasim.InterfaceC10156bA3
        public Object a(Context context, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            Uri uri = Uri.parse(this.a);
            AbstractC13042fc3.h(uri, "parse(...)");
            aVar.B(uri);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC10156bA3
        public ExPeer c() {
            return this.b;
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
            return "OpenExternalLink(link=" + this.a + Separators.RPAREN;
        }
    }

    static /* synthetic */ Object b(InterfaceC10156bA3 interfaceC10156bA3, Context context, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 1) != 0) {
            context = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return interfaceC10156bA3.a(context, z, interfaceC20295rm1);
    }

    Object a(Context context, boolean z, InterfaceC20295rm1 interfaceC20295rm1);

    ExPeer c();
}
