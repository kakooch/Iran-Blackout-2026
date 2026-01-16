package ir.nasim;

import androidx.fragment.app.Fragment;

/* renamed from: ir.nasim.wR, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC23146wR {
    public static final a a = a.a;

    /* renamed from: ir.nasim.wR$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    static /* synthetic */ Fragment a(InterfaceC23146wR interfaceC23146wR, String str, TR tr, boolean z, boolean z2, SA2 sa2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCreatePasswordFragment");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.vR
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return InterfaceC23146wR.b();
                }
            };
        }
        return interfaceC23146wR.d(str2, tr, z3, z4, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static C19938rB7 b() {
        return C19938rB7.a;
    }

    static /* synthetic */ Fragment c(InterfaceC23146wR interfaceC23146wR, String str, TR tr, boolean z, boolean z2, SA2 sa2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getValidatePasswordFragment");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.uR
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return InterfaceC23146wR.g();
                }
            };
        }
        return interfaceC23146wR.f(str2, tr, z3, z4, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static C19938rB7 g() {
        return C19938rB7.a;
    }

    Fragment d(String str, TR tr, boolean z, boolean z2, SA2 sa2);

    Fragment f(String str, TR tr, boolean z, boolean z2, SA2 sa2);

    Fragment h(SA2 sa2, TR tr, String str, SA2 sa22);
}
