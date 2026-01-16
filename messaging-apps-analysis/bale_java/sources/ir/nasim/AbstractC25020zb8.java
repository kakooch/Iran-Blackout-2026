package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.zb8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC25020zb8 extends AbstractC17902nl0 {
    private int recordField;
    private AbstractC17902nl0 wrapped;

    protected AbstractC25020zb8(int i, byte[] bArr) throws IOException {
        this.recordField = i;
        load(bArr);
        if (this.wrapped == null) {
            throw new IOException("Unable to deserialize wrapped object");
        }
    }

    protected abstract AbstractC17902nl0 createInstance();

    protected AbstractC17902nl0 getWrapped() {
        return this.wrapped;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        byte[] bArrV = c19084pl0.v(this.recordField);
        if (bArrV != null) {
            AbstractC17902nl0 abstractC17902nl0B = AbstractC16720ll0.b(createInstance(), bArrV);
            this.wrapped = abstractC17902nl0B;
            applyWrapped(abstractC17902nl0B);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.i(this.recordField, this.wrapped);
    }

    protected void setWrapped(AbstractC17902nl0 abstractC17902nl0) {
        this.wrapped = abstractC17902nl0;
        applyWrapped(abstractC17902nl0);
    }

    protected AbstractC25020zb8(int i, AbstractC17902nl0 abstractC17902nl0) {
        this.recordField = i;
        this.wrapped = abstractC17902nl0;
        applyWrapped(abstractC17902nl0);
    }

    protected AbstractC25020zb8(int i) {
        this.recordField = i;
    }

    protected void applyWrapped(AbstractC17902nl0 abstractC17902nl0) {
    }
}
