package ir.nasim;

import kotlin.KotlinNothingValueException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.sk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20868sk3 extends kotlinx.serialization.encoding.a {
    private final Z0 a;
    private final AbstractC3859Cq6 b;

    public C20868sk3(Z0 z0, AbstractC11279ck3 abstractC11279ck3) {
        AbstractC13042fc3.i(z0, "lexer");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        this.a = z0;
        this.b = abstractC11279ck3.a();
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public byte G() {
        Z0 z0 = this.a;
        String strQ = z0.q();
        try {
            return HA7.a(strQ);
        } catch (IllegalArgumentException unused) {
            Z0.x(z0, "Failed to parse type 'UByte' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.c
    public AbstractC3859Cq6 a() {
        return this.b;
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public int h() {
        Z0 z0 = this.a;
        String strQ = z0.q();
        try {
            return HA7.d(strQ);
        } catch (IllegalArgumentException unused) {
            Z0.x(z0, "Failed to parse type 'UInt' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public long m() {
        Z0 z0 = this.a;
        String strQ = z0.q();
        try {
            return HA7.g(strQ);
        } catch (IllegalArgumentException unused) {
            Z0.x(z0, "Failed to parse type 'ULong' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.c
    public int o(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public short s() {
        Z0 z0 = this.a;
        String strQ = z0.q();
        try {
            return HA7.j(strQ);
        } catch (IllegalArgumentException unused) {
            Z0.x(z0, "Failed to parse type 'UShort' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }
}
