package ir.nasim;

import ir.nasim.C4092Dq5;
import ir.nasim.C9066Yi4;
import ir.nasim.InterfaceC7584Si4;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.hj4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC14322hj4 {
    public static final InterfaceC7584Si4.a a = new b(null);

    /* renamed from: ir.nasim.hj4$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC6192Mo3.values().length];
            a = iArr;
            try {
                iArr[EnumC6192Mo3.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC6192Mo3.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC6192Mo3.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: ir.nasim.hj4$b */
    private static class b implements InterfaceC7584Si4.a {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // ir.nasim.InterfaceC7584Si4.a
        public void b() {
        }

        @Override // ir.nasim.InterfaceC7584Si4.a
        public void a(int i, long j) {
        }
    }

    public static C9066Yi4 a(C4092Dq5 c4092Dq5) {
        C9066Yi4.b bVarA = C9066Yi4.a();
        bVarA.d(c4092Dq5.e());
        Iterator it = c4092Dq5.d().iterator();
        while (it.hasNext()) {
            for (C4092Dq5.c cVar : (List) it.next()) {
                bVarA.a(c(cVar.h()), cVar.d(), b(cVar.e()), cVar.f().name());
            }
        }
        if (c4092Dq5.f() != null) {
            bVarA.e(c4092Dq5.f().d());
        }
        try {
            return bVarA.b();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String b(String str) {
        return !str.startsWith("type.googleapis.com/google.crypto.") ? str : str.substring(34);
    }

    private static C5959Lo3 c(EnumC6192Mo3 enumC6192Mo3) {
        int i = a.a[enumC6192Mo3.ordinal()];
        if (i == 1) {
            return C5959Lo3.b;
        }
        if (i == 2) {
            return C5959Lo3.c;
        }
        if (i == 3) {
            return C5959Lo3.d;
        }
        throw new IllegalStateException("Unknown key status");
    }
}
