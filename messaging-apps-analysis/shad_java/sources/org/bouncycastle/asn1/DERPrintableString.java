package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes4.dex */
public class DERPrintableString extends ASN1Primitive {
    private final byte[] string;

    DERPrintableString(byte[] bArr) {
        this.string = bArr;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERPrintableString) {
            return Arrays.areEqual(this.string, ((DERPrintableString) aSN1Primitive).string);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 19, this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public String getString() {
        return Strings.fromByteArray(this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }
}
