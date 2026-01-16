package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public class DLApplicationSpecific extends ASN1ApplicationSpecific {
    DLApplicationSpecific(boolean z, int i, byte[] bArr) {
        super(z, i, bArr);
    }

    @Override // org.bouncycastle.asn1.ASN1ApplicationSpecific, org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, this.isConstructed ? 96 : 64, this.tag, this.octets);
    }
}
