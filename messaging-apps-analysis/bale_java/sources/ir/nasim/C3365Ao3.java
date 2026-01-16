package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC8110Uo3;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Ao3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C3365Ao3 implements InterfaceC25145zo3 {
    private final AbstractC8110Uo3 a;
    private final Class b;

    /* renamed from: ir.nasim.Ao3$a */
    private static class a {
        final AbstractC8110Uo3.a a;

        a(AbstractC8110Uo3.a aVar) {
            this.a = aVar;
        }

        private com.google.crypto.tink.shaded.protobuf.I b(com.google.crypto.tink.shaded.protobuf.I i) {
            this.a.c(i);
            return this.a.a(i);
        }

        com.google.crypto.tink.shaded.protobuf.I a(AbstractC2345g abstractC2345g) {
            return b(this.a.b(abstractC2345g));
        }
    }

    public C3365Ao3(AbstractC8110Uo3 abstractC8110Uo3, Class cls) {
        if (!abstractC8110Uo3.i().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", abstractC8110Uo3.toString(), cls.getName()));
        }
        this.a = abstractC8110Uo3;
        this.b = cls;
    }

    private a d() {
        return new a(this.a.f());
    }

    private Object e(com.google.crypto.tink.shaded.protobuf.I i) throws GeneralSecurityException {
        if (Void.class.equals(this.b)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.a.j(i);
        return this.a.e(i, this.b);
    }

    @Override // ir.nasim.InterfaceC25145zo3
    public final C20317ro3 a(AbstractC2345g abstractC2345g) throws GeneralSecurityException {
        try {
            return (C20317ro3) C20317ro3.Z().q(b()).r(d().a(abstractC2345g).b()).p(this.a.g()).e();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    @Override // ir.nasim.InterfaceC25145zo3
    public final String b() {
        return this.a.d();
    }

    @Override // ir.nasim.InterfaceC25145zo3
    public final Object c(AbstractC2345g abstractC2345g) throws GeneralSecurityException {
        try {
            return e(this.a.h(abstractC2345g));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.a.c().getName(), e);
        }
    }
}
