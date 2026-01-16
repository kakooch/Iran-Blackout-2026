package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes4.dex */
public class DERUTF8String extends ASN1Primitive {
    private final byte[] string;

    DERUTF8String(byte[] bArr) {
        this.string = bArr;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERUTF8String) {
            return Arrays.areEqual(this.string, ((DERUTF8String) aSN1Primitive).string);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 12, this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength() throws IOException {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public String getString() {
        return Strings.fromUTF8ByteArray(this.string);
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
