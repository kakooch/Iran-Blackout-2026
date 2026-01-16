package org.xbill.DNS;

import android.gov.nist.core.Separators;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.io.Serializable;
import java.util.Arrays;
import lombok.Generated;

/* loaded from: classes8.dex */
public class Name implements Comparable<Name>, Serializable {
    private static final int LABEL_COMPRESSION = 192;
    private static final int LABEL_MASK = 192;
    private static final int LABEL_NORMAL = 0;
    private static final int MAXLABEL = 63;
    private static final int MAXNAME = 255;
    private static final int MAXOFFSETS = 9;
    public static final Name empty;
    public static final Name root;
    private static final long serialVersionUID = -6036624806201621219L;
    private static final Name wild;
    private transient int hashcode;
    private int labels;
    private byte[] name;
    private long offsets;

    @Generated
    private static final OI3 log = RI3.i(Name.class);
    private static final byte[] emptyLabel = {0};
    private static final byte[] wildLabel = {1, 42};
    private static final byte[] lowercase = new byte[256];

    static {
        int i = 0;
        while (true) {
            byte[] bArr = lowercase;
            if (i >= bArr.length) {
                Name name = new Name();
                root = name;
                name.name = emptyLabel;
                name.labels = 1;
                Name name2 = new Name();
                empty = name2;
                name2.name = new byte[0];
                Name name3 = new Name();
                wild = name3;
                name3.name = wildLabel;
                name3.labels = 1;
                return;
            }
            if (i < 65 || i > 90) {
                bArr[i] = (byte) i;
            } else {
                bArr[i] = (byte) (i + 32);
            }
            i++;
        }
    }

    private Name() {
    }

    private void append(byte[] bArr, int i, int i2) throws NameTooLongException {
        byte[] bArr2 = this.name;
        int length = bArr2 == null ? 0 : bArr2.length;
        int i3 = i;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i3] + 1;
            i3 += i6;
            i4 += i6;
        }
        int i7 = length + i4;
        if (i7 > 255) {
            throw new NameTooLongException();
        }
        byte[] bArr3 = this.name;
        byte[] bArrCopyOf = bArr3 != null ? Arrays.copyOf(bArr3, i7) : new byte[i7];
        System.arraycopy(bArr, i, bArrCopyOf, length, i4);
        this.name = bArrCopyOf;
        for (int i8 = 0; i8 < i2 && i8 < 9; i8++) {
            setOffset(this.labels + i8, length);
            length += bArrCopyOf[length] + 1;
        }
        this.labels += i2;
    }

    private void appendFromString(String str, char[] cArr, int i) {
        try {
            append(cArr, i);
        } catch (NameTooLongException e) {
            throw new TextParseException(str, "Name too long", e);
        }
    }

    private String byteString(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i + 1;
        int i3 = bArr[i];
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            int i5 = bArr[i4] & 255;
            if (i5 <= 32 || i5 >= 127) {
                sb.append('\\');
                if (i5 < 10) {
                    sb.append("00");
                } else if (i5 < 100) {
                    sb.append('0');
                }
                sb.append(i5);
            } else if (i5 == 34 || i5 == 40 || i5 == 41 || i5 == 46 || i5 == 59 || i5 == 92 || i5 == 64 || i5 == 36) {
                sb.append('\\');
                sb.append((char) i5);
            } else {
                sb.append((char) i5);
            }
        }
        return sb.toString();
    }

    public static Name concatenate(Name name, Name name2) throws NameTooLongException {
        if (name.isAbsolute()) {
            return name;
        }
        Name name3 = new Name();
        name3.append(name.name, 0, name.labels);
        name3.append(name2.name, 0, name2.labels);
        return name3;
    }

    private static void copy(Name name, Name name2) {
        name2.name = name.name;
        name2.offsets = name.offsets;
        name2.labels = name.labels;
    }

    private boolean equals(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.labels; i3++) {
            byte b = this.name[i2];
            if (b != bArr[i]) {
                return false;
            }
            i2++;
            i++;
            int i4 = 0;
            while (i4 < b) {
                byte[] bArr2 = lowercase;
                int i5 = i2 + 1;
                int i6 = i + 1;
                if (bArr2[this.name[i2] & 255] != bArr2[bArr[i] & 255]) {
                    return false;
                }
                i4++;
                i = i6;
                i2 = i5;
            }
        }
        return true;
    }

    public static Name fromConstantString(String str) {
        try {
            return fromString(str, null);
        } catch (TextParseException unused) {
            throw new IllegalArgumentException("Invalid name '" + str + Separators.QUOTE);
        }
    }

    public static Name fromString(String str, Name name) {
        return str.equals(Separators.AT) ? name != null ? name : empty : str.equals(Separators.DOT) ? root : new Name(str, name);
    }

    private int offset(int i) {
        if (i == 0) {
            return 0;
        }
        if (i < 1 || i >= this.labels) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i < 9) {
            return ((int) (this.offsets >>> ((i - 1) * 8))) & 255;
        }
        int i2 = ((int) (this.offsets >>> 56)) & 255;
        for (int i3 = 8; i3 < i; i3++) {
            i2 += this.name[i2] + 1;
        }
        return i2;
    }

    private int prepareAppend(int i) {
        byte[] bArr = this.name;
        int length = bArr == null ? 0 : bArr.length;
        int i2 = length + 1;
        int i3 = i2 + i;
        if (i3 > 255) {
            throw new NameTooLongException();
        }
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, i3) : new byte[i3];
        bArrCopyOf[length] = (byte) i;
        this.name = bArrCopyOf;
        setOffset(this.labels, length);
        this.labels++;
        return i2;
    }

    private void setOffset(int i, int i2) {
        if (i == 0 || i >= 9) {
            return;
        }
        int i3 = (i - 1) * 8;
        this.offsets = (i2 << i3) | (this.offsets & (~(255 << i3)));
    }

    public Name canonicalize() {
        int i = 0;
        for (byte b : this.name) {
            if (lowercase[b & 255] != b) {
                Name name = new Name();
                name.offsets = this.offsets;
                name.labels = this.labels;
                name.name = new byte[length()];
                while (true) {
                    byte[] bArr = name.name;
                    if (i >= bArr.length) {
                        return name;
                    }
                    bArr[i] = lowercase[this.name[i] & 255];
                    i++;
                }
            }
        }
        return this;
    }

    public Name fromDNAME(DNAMERecord dNAMERecord) throws NameTooLongException {
        Name name = dNAMERecord.getName();
        Name target = dNAMERecord.getTarget();
        if (!subdomain(name)) {
            return null;
        }
        int i = this.labels - name.labels;
        int length = length() - name.length();
        int i2 = target.labels;
        short length2 = target.length();
        int i3 = length + length2;
        if (i3 > 255) {
            throw new NameTooLongException();
        }
        Name name2 = new Name();
        int i4 = i + i2;
        name2.labels = i4;
        byte[] bArrCopyOf = Arrays.copyOf(this.name, i3);
        name2.name = bArrCopyOf;
        System.arraycopy(target.name, 0, bArrCopyOf, length, length2);
        int i5 = 0;
        for (int i6 = 0; i6 < 9 && i6 < i4; i6++) {
            name2.setOffset(i6, i5);
            i5 += name2.name[i5] + 1;
        }
        return name2;
    }

    public byte[] getLabel(int i) {
        int iOffset = offset(i);
        byte[] bArr = this.name;
        return Arrays.copyOfRange(bArr, iOffset, ((byte) (bArr[iOffset] + 1)) + iOffset);
    }

    public String getLabelString(int i) {
        return byteString(this.name, offset(i));
    }

    public int hashCode() {
        int i = this.hashcode;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        int iOffset = offset(0);
        while (true) {
            byte[] bArr = this.name;
            if (iOffset >= bArr.length) {
                this.hashcode = i2;
                return i2;
            }
            i2 += (i2 << 3) + (lowercase[bArr[iOffset] & 255] & 255);
            iOffset++;
        }
    }

    public boolean isAbsolute() {
        int i = this.labels;
        return i != 0 && this.name[offset(i - 1)] == 0;
    }

    public boolean isWild() {
        if (this.labels == 0) {
            return false;
        }
        byte[] bArr = this.name;
        return bArr[0] == 1 && bArr[1] == 42;
    }

    public int labels() {
        return this.labels;
    }

    public short length() {
        if (this.labels == 0) {
            return (short) 0;
        }
        return (short) this.name.length;
    }

    public Name relativize(Name name) {
        if (name == null || !subdomain(name)) {
            return this;
        }
        Name name2 = new Name();
        int length = length() - name.length();
        name2.labels = this.labels - name.labels;
        name2.offsets = this.offsets;
        byte[] bArr = new byte[length];
        name2.name = bArr;
        System.arraycopy(this.name, 0, bArr, 0, length);
        return name2;
    }

    public boolean subdomain(Name name) {
        int i = name.labels;
        int i2 = this.labels;
        if (i > i2) {
            return false;
        }
        return i == i2 ? equals(name) : name.equals(this.name, offset(i2 - i));
    }

    public String toString(boolean z) {
        int i = this.labels;
        if (i == 0) {
            return Separators.AT;
        }
        int i2 = 0;
        if (i == 1 && this.name[0] == 0) {
            return Separators.DOT;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            if (i2 >= this.labels) {
                break;
            }
            byte b = this.name[i3];
            if (b != 0) {
                if (i2 > 0) {
                    sb.append('.');
                }
                sb.append(byteString(this.name, i3));
                i3 += b + 1;
                i2++;
            } else if (!z) {
                sb.append('.');
            }
        }
        return sb.toString();
    }

    public void toWire(DNSOutput dNSOutput, Compression compression) {
        if (!isAbsolute()) {
            throw new IllegalArgumentException("toWire() called on non-absolute name");
        }
        int i = 0;
        while (i < this.labels - 1) {
            Name name = i == 0 ? this : new Name(this, i);
            int i2 = compression != null ? compression.get(name) : -1;
            if (i2 >= 0) {
                dNSOutput.writeU16(49152 | i2);
                return;
            }
            if (compression != null) {
                compression.add(dNSOutput.current(), name);
            }
            int iOffset = offset(i);
            byte[] bArr = this.name;
            dNSOutput.writeByteArray(bArr, iOffset, bArr[iOffset] + 1);
            i++;
        }
        dNSOutput.writeU8(0);
    }

    public void toWireCanonical(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(toWireCanonical());
    }

    public Name wild(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("must replace 1 or more labels");
        }
        try {
            Name name = new Name();
            copy(wild, name);
            name.append(this.name, offset(i), this.labels - i);
            return name;
        } catch (NameTooLongException unused) {
            throw new IllegalStateException("Name.wild: concatenate failed");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Name(java.lang.String r17, org.xbill.DNS.Name r18) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Name.<init>(java.lang.String, org.xbill.DNS.Name):void");
    }

    @Override // java.lang.Comparable
    public int compareTo(Name name) {
        if (this == name) {
            return 0;
        }
        int i = name.labels;
        int iMin = Math.min(this.labels, i);
        for (int i2 = 1; i2 <= iMin; i2++) {
            int iOffset = offset(this.labels - i2);
            int iOffset2 = name.offset(i - i2);
            byte b = this.name[iOffset];
            byte b2 = name.name[iOffset2];
            for (int i3 = 0; i3 < b && i3 < b2; i3++) {
                byte[] bArr = lowercase;
                int i4 = (bArr[this.name[(i3 + iOffset) + 1] & 255] & 255) - (bArr[name.name[(i3 + iOffset2) + 1] & 255] & 255);
                if (i4 != 0) {
                    return i4;
                }
            }
            if (b != b2) {
                return b - b2;
            }
        }
        return this.labels - i;
    }

    private void appendFromString(String str, byte[] bArr, int i) throws TextParseException {
        try {
            append(bArr, 0, i);
        } catch (NameTooLongException unused) {
            throw new TextParseException(str, "Name too long");
        }
    }

    public byte[] toWireCanonical() {
        if (this.labels == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.name.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.labels; i3++) {
            byte b = this.name[i];
            i++;
            bArr[i2] = b;
            i2++;
            int i4 = 0;
            while (i4 < b) {
                bArr[i2] = lowercase[this.name[i] & 255];
                i4++;
                i2++;
                i++;
            }
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        if (name.labels == this.labels && name.hashCode() == hashCode()) {
            return equals(name.name, 0);
        }
        return false;
    }

    public static Name fromString(String str) {
        return fromString(str, null);
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, null);
        return dNSOutput.toByteArray();
    }

    private void append(char[] cArr, int i) {
        int iPrepareAppend = prepareAppend(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.name[iPrepareAppend + i2] = (byte) cArr[i2];
        }
    }

    public String toString() {
        return toString(false);
    }

    public void toWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        if (z) {
            toWireCanonical(dNSOutput);
        } else {
            toWire(dNSOutput, compression);
        }
    }

    public Name(String str) {
        this(str, (Name) null);
    }

    public Name(DNSInput dNSInput) throws WireParseException {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int u8 = dNSInput.readU8();
            int i = u8 & 192;
            if (i != 0) {
                if (i == 192) {
                    int u82 = dNSInput.readU8() + ((u8 & (-193)) << 8);
                    OI3 oi3 = log;
                    oi3.e("currently {}, pointer to {}", Integer.valueOf(dNSInput.current()), Integer.valueOf(u82));
                    if (u82 < dNSInput.current() - 2) {
                        if (!z2) {
                            dNSInput.save();
                            z2 = true;
                        }
                        dNSInput.jump(u82);
                        oi3.e("current name '{}', seeking to {}", this, Integer.valueOf(u82));
                    } else {
                        throw new WireParseException("bad compression");
                    }
                } else {
                    throw new WireParseException("bad label type");
                }
            } else if (u8 == 0) {
                append(emptyLabel, 0, 1);
                z = true;
            } else {
                bArr[0] = (byte) u8;
                dNSInput.readByteArray(bArr, 1, u8);
                append(bArr, 0, 1);
            }
        }
        if (z2) {
            dNSInput.restore();
        }
    }

    public Name(byte[] bArr) {
        this(new DNSInput(bArr));
    }

    public Name(Name name, int i) {
        int i2 = name.labels;
        if (i > i2) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        if (i == i2) {
            copy(empty, this);
            return;
        }
        this.labels = i2 - i;
        this.name = Arrays.copyOfRange(name.name, name.offset(i), name.name.length);
        int iOffset = name.offset(i);
        for (int i3 = 1; i3 < 9 && i3 < this.labels; i3++) {
            setOffset(i3, name.offset(i3 + i) - iOffset);
        }
    }
}
