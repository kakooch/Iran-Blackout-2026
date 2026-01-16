package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.security.SecureRandom;
import java.util.Random;

/* loaded from: classes8.dex */
public class Header implements Cloneable {
    public static final int LENGTH = 12;
    private static final Random random = new SecureRandom();
    private int[] counts;
    private int flags;
    private int id;

    public Header(int i) {
        if (Utils.isUInt16(i)) {
            this.counts = new int[4];
            this.flags = 0;
            this.id = i;
        } else {
            throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
        }
    }

    private static void checkFlag(int i) {
        if (validFlag(i)) {
            return;
        }
        throw new IllegalArgumentException("invalid flag bit " + i);
    }

    static boolean getFlag(int i, int i2) {
        checkFlag(i2);
        return (i & (1 << (15 - i2))) != 0;
    }

    static int setFlag(int i, int i2, boolean z) {
        checkFlag(i2);
        return z ? i | (1 << (15 - i2)) : i & (~(1 << (15 - i2)));
    }

    private static boolean validFlag(int i) {
        return i >= 0 && i <= 15 && Flags.isFlag(i);
    }

    void decCount(int i) {
        int[] iArr = this.counts;
        int i2 = iArr[i];
        if (i2 == 0) {
            throw new IllegalStateException("DNS section count cannot be decremented");
        }
        iArr[i] = i2 - 1;
    }

    public int getCount(int i) {
        return this.counts[i];
    }

    boolean[] getFlags() {
        boolean[] zArr = new boolean[16];
        for (int i = 0; i < 16; i++) {
            if (validFlag(i)) {
                zArr[i] = getFlag(i);
            }
        }
        return zArr;
    }

    int getFlagsByte() {
        return this.flags;
    }

    public int getID() {
        return this.id;
    }

    public int getOpcode() {
        return (this.flags >> 11) & 15;
    }

    public int getRcode() {
        return this.flags & 15;
    }

    void incCount(int i) {
        int[] iArr = this.counts;
        int i2 = iArr[i];
        if (i2 == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i] = i2 + 1;
    }

    public String printFlags() {
        StringBuilder sb = new StringBuilder();
        printFlags(sb);
        return sb.toString();
    }

    void setCount(int i, int i2) {
        if (Utils.isUInt16(i2)) {
            this.counts[i] = i2;
            return;
        }
        throw new IllegalArgumentException("DNS section count " + i2 + " is out of range");
    }

    public void setID(int i) {
        if (Utils.isUInt16(i)) {
            this.id = i;
            return;
        }
        throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
    }

    public void setOpcode(int i) {
        if (i >= 0 && i <= 15) {
            this.flags = (i << 11) | (this.flags & 34815);
        } else {
            throw new IllegalArgumentException("DNS Opcode " + i + "is out of range");
        }
    }

    public void setRcode(int i) {
        if (i >= 0 && i <= 15) {
            this.flags = i | (this.flags & (-16));
            return;
        }
        throw new IllegalArgumentException("DNS Rcode " + i + " is out of range");
    }

    public String toString() {
        return toStringWithRcode(getRcode());
    }

    String toStringWithRcode(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(";; ->>HEADER<<- ");
        sb.append("opcode: ");
        sb.append(Opcode.string(getOpcode()));
        sb.append(", status: ");
        sb.append(Rcode.string(i));
        sb.append(", id: ");
        sb.append(getID());
        sb.append(Separators.RETURN);
        sb.append(";; flags: ");
        printFlags(sb);
        sb.append("; ");
        for (int i2 = 0; i2 < 4; i2++) {
            sb.append(Section.string(i2));
            sb.append(": ");
            sb.append(getCount(i2));
            sb.append(Separators.SP);
        }
        return sb.toString();
    }

    void toWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(getID());
        dNSOutput.writeU16(this.flags);
        for (int i : this.counts) {
            dNSOutput.writeU16(i);
        }
    }

    public void unsetFlag(int i) {
        checkFlag(i);
        this.flags = setFlag(this.flags, i, false);
    }

    public Header clone() {
        Header header = (Header) super.clone();
        header.id = this.id;
        header.flags = this.flags;
        int[] iArr = new int[header.counts.length];
        header.counts = iArr;
        int[] iArr2 = this.counts;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        return header;
    }

    public boolean getFlag(int i) {
        return getFlag(this.flags, i);
    }

    public void setFlag(int i) {
        checkFlag(i);
        this.flags = setFlag(this.flags, i, true);
    }

    private void printFlags(StringBuilder sb) {
        for (int i = 0; i < 16; i++) {
            if (validFlag(i) && getFlag(i)) {
                sb.append(Flags.string(i));
                sb.append(Separators.SP);
            }
        }
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public Header() {
        this(random.nextInt(65535));
    }

    Header(DNSInput dNSInput) {
        this(dNSInput.readU16());
        this.flags = dNSInput.readU16();
        int i = 0;
        while (true) {
            int[] iArr = this.counts;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = dNSInput.readU16();
            i++;
        }
    }

    public Header(byte[] bArr) {
        this(new DNSInput(bArr));
    }
}
