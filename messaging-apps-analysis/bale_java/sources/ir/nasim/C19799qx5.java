package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import ir.nasim.C20317ro3;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.qx5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19799qx5 implements InterfaceC20931sq6 {
    private final String a;
    private final C8575Wo0 b;
    private final AbstractC2345g c;
    private final C20317ro3.c d;
    private final FN4 e;
    private final Integer f;

    private C19799qx5(String str, AbstractC2345g abstractC2345g, C20317ro3.c cVar, FN4 fn4, Integer num) {
        this.a = str;
        this.b = AbstractC10893cN7.h(str);
        this.c = abstractC2345g;
        this.d = cVar;
        this.e = fn4;
        this.f = num;
    }

    public static C19799qx5 b(String str, AbstractC2345g abstractC2345g, C20317ro3.c cVar, FN4 fn4, Integer num) throws GeneralSecurityException {
        if (fn4 == FN4.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new C19799qx5(str, abstractC2345g, cVar, fn4, num);
    }

    @Override // ir.nasim.InterfaceC20931sq6
    public C8575Wo0 a() {
        return this.b;
    }

    public Integer c() {
        return this.f;
    }

    public C20317ro3.c d() {
        return this.d;
    }

    public FN4 e() {
        return this.e;
    }

    public String f() {
        return this.a;
    }

    public AbstractC2345g g() {
        return this.c;
    }
}
