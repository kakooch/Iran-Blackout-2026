package ir.nasim;

import ir.nasim.AbstractC21437tf2;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: ir.nasim.p96, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18736p96 {
    private final C15887kL3 a = new C15887kL3(1000);
    private final InterfaceC20850si5 b = AbstractC21437tf2.d(10, new a());

    /* renamed from: ir.nasim.p96$a */
    class a implements AbstractC21437tf2.d {
        a() {
        }

        @Override // ir.nasim.AbstractC21437tf2.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: ir.nasim.p96$b */
    private static final class b implements AbstractC21437tf2.f {
        final MessageDigest a;
        private final AbstractC18254oL6 b = AbstractC18254oL6.a();

        b(MessageDigest messageDigest) {
            this.a = messageDigest;
        }

        @Override // ir.nasim.AbstractC21437tf2.f
        public AbstractC18254oL6 h() {
            return this.b;
        }
    }

    private String a(InterfaceC14373ho3 interfaceC14373ho3) {
        b bVar = (b) AbstractC3322Aj5.d((b) this.b.b());
        try {
            interfaceC14373ho3.b(bVar.a);
            return YM7.y(bVar.a.digest());
        } finally {
            this.b.a(bVar);
        }
    }

    public String b(InterfaceC14373ho3 interfaceC14373ho3) {
        String strA;
        synchronized (this.a) {
            strA = (String) this.a.g(interfaceC14373ho3);
        }
        if (strA == null) {
            strA = a(interfaceC14373ho3);
        }
        synchronized (this.a) {
            this.a.k(interfaceC14373ho3, strA);
        }
        return strA;
    }
}
