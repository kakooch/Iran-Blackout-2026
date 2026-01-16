package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public class DLBitString extends ASN1BitString {
    public DLBitString(byte[] bArr, int i) {
        super(bArr, i);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 3, (byte) this.padBits, this.data);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength() {
        return StreamUtil.calculateBodyLength(this.data.length + 1) + 1 + this.data.length + 1;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean isConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1BitString, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
