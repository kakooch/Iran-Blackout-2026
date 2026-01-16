package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public class ASN1Boolean extends ASN1Primitive {
    public static final ASN1Boolean FALSE = new ASN1Boolean((byte) 0);
    public static final ASN1Boolean TRUE = new ASN1Boolean((byte) -1);
    private final byte value;

    private ASN1Boolean(byte b) {
        this.value = b;
    }

    static ASN1Boolean fromOctetString(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b = bArr[0];
        return b != -1 ? b != 0 ? new ASN1Boolean(b) : FALSE : TRUE;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return (aSN1Primitive instanceof ASN1Boolean) && isTrue() == ((ASN1Boolean) aSN1Primitive).isTrue();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 1, this.value);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength() {
        return 3;
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return isTrue() ? 1 : 0;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean isConstructed() {
        return false;
    }

    public boolean isTrue() {
        return this.value != 0;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return isTrue() ? TRUE : FALSE;
    }

    public String toString() {
        return isTrue() ? "TRUE" : "FALSE";
    }
}
