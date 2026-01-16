package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

/* loaded from: classes4.dex */
public class DERGraphicString extends ASN1Primitive {
    private final byte[] string;

    public DERGraphicString(byte[] bArr) {
        this.string = Arrays.clone(bArr);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERGraphicString) {
            return Arrays.areEqual(this.string, ((DERGraphicString) aSN1Primitive).string);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 25, this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean isConstructed() {
        return false;
    }
}
