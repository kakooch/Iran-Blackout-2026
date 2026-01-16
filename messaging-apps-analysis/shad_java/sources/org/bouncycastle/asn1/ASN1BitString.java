package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes4.dex */
public abstract class ASN1BitString extends ASN1Primitive {
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    protected final byte[] data;
    protected final int padBits;

    public ASN1BitString(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        }
        if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.data = Arrays.clone(bArr);
        this.padBits = i;
    }

    static ASN1BitString fromInputStream(int i, InputStream inputStream) throws IOException {
        if (i < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int i2 = inputStream.read();
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        if (i3 != 0) {
            if (Streams.readFully(inputStream, bArr) != i3) {
                throw new EOFException("EOF encountered in middle of BIT STRING");
            }
            if (i2 > 0 && i2 < 8) {
                int i4 = i3 - 1;
                if (bArr[i4] != ((byte) (bArr[i4] & (255 << i2)))) {
                    return new DLBitString(bArr, i2);
                }
            }
        }
        return new DERBitString(bArr, i2);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1BitString)) {
            return false;
        }
        ASN1BitString aSN1BitString = (ASN1BitString) aSN1Primitive;
        if (this.padBits != aSN1BitString.padBits) {
            return false;
        }
        byte[] bArr = this.data;
        byte[] bArr2 = aSN1BitString.data;
        int length = bArr.length;
        if (length != bArr2.length) {
            return false;
        }
        int i = length - 1;
        if (i < 0) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        byte b = bArr[i];
        int i3 = this.padBits;
        return ((byte) (b & (255 << i3))) == ((byte) (bArr2[i] & (255 << i3)));
    }

    public byte[] getBytes() {
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrClone = Arrays.clone(bArr);
        int length = this.data.length - 1;
        bArrClone[length] = (byte) (bArrClone[length] & (255 << this.padBits));
        return bArrClone;
    }

    public byte[] getOctets() {
        if (this.padBits == 0) {
            return Arrays.clone(this.data);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public String getString() {
        StringBuffer stringBuffer = new StringBuffer("#");
        try {
            byte[] encoded = getEncoded();
            for (int i = 0; i != encoded.length; i++) {
                char[] cArr = table;
                stringBuffer.append(cArr[(encoded[i] >>> 4) & 15]);
                stringBuffer.append(cArr[encoded[i] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        byte[] bArr = this.data;
        int length = bArr.length - 1;
        if (length < 0) {
            return 1;
        }
        return ((Arrays.hashCode(bArr, 0, length) * 257) ^ ((byte) (bArr[length] & (255 << this.padBits)))) ^ this.padBits;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DERBitString(this.data, this.padBits);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DLBitString(this.data, this.padBits);
    }

    public String toString() {
        return getString();
    }
}
