package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.gB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13411gB extends AbstractC14591iA {
    private String a;
    private String b;
    private int c;
    private C19811qz d;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(3);
        this.d = (C19811qz) c19084pl0.k(4, new C19811qz());
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC14591iA
    public int s() {
        return SetRpcStruct$ComposedRpc.LOAD_MEMBERS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
        c19675ql0.f(3, this.c);
        C19811qz c19811qz = this.d;
        if (c19811qz == null) {
            throw new IOException();
        }
        c19675ql0.i(4, c19811qz);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct PsProxyOrderMessage{}";
    }

    public C19811qz u() {
        return this.d;
    }

    public String w() {
        return this.b;
    }

    public int y() {
        return this.c;
    }

    public String z() {
        return this.a;
    }
}
