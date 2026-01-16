package org.xbill.DNS;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes8.dex */
final class TypeBitmap implements Serializable {
    private static final long serialVersionUID = -125354057735389003L;
    private final TreeSet<Integer> types;

    private TypeBitmap() {
        this.types = new TreeSet<>();
    }

    private static int getMapLength(DNSInput dNSInput) throws WireParseException {
        int u8 = dNSInput.readU8();
        if (u8 <= dNSInput.remaining()) {
            return u8;
        }
        throw new WireParseException("invalid bitmap");
    }

    private static int getWindowBlockNumber(DNSInput dNSInput, int i) throws WireParseException {
        int u8 = dNSInput.readU8();
        if (u8 >= i) {
            return u8;
        }
        throw new WireParseException("invalid ordering");
    }

    private static void mapToWire(DNSOutput dNSOutput, TreeSet<Integer> treeSet, int i) {
        int iIntValue = ((treeSet.last().intValue() & 255) / 8) + 1;
        int[] iArr = new int[iIntValue];
        dNSOutput.writeU8(i);
        dNSOutput.writeU8(iIntValue);
        Iterator<Integer> it = treeSet.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            int i2 = (iIntValue2 & 255) / 8;
            iArr[i2] = (1 << (7 - (iIntValue2 % 8))) | iArr[i2];
        }
        for (int i3 = 0; i3 < iIntValue; i3++) {
            dNSOutput.writeU8(iArr[i3]);
        }
    }

    public boolean contains(int i) {
        return this.types.contains(Integer.valueOf(i));
    }

    public boolean empty() {
        return this.types.isEmpty();
    }

    public int[] toArray() {
        int[] iArr = new int[this.types.size()];
        Iterator<Integer> it = this.types.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = this.types.iterator();
        while (it.hasNext()) {
            sb.append(Type.string(it.next().intValue()));
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public void toWire(DNSOutput dNSOutput) {
        if (this.types.isEmpty()) {
            return;
        }
        TreeSet treeSet = new TreeSet();
        Iterator<Integer> it = this.types.iterator();
        int i = -1;
        while (it.hasNext()) {
            Integer next = it.next();
            int iIntValue = next.intValue() >> 8;
            if (iIntValue != i) {
                if (!treeSet.isEmpty()) {
                    mapToWire(dNSOutput, treeSet, i);
                    treeSet.clear();
                }
                i = iIntValue;
            }
            treeSet.add(next);
        }
        mapToWire(dNSOutput, treeSet, i);
    }

    public TypeBitmap(int[] iArr) {
        this();
        for (int i : iArr) {
            Type.check(i);
            this.types.add(Integer.valueOf(i));
        }
    }

    public TypeBitmap(DNSInput dNSInput) throws WireParseException {
        this();
        while (dNSInput.remaining() > 0) {
            if (dNSInput.remaining() >= 2) {
                int windowBlockNumber = getWindowBlockNumber(dNSInput, -1);
                int mapLength = getMapLength(dNSInput);
                for (int i = 0; i < mapLength; i++) {
                    int u8 = dNSInput.readU8();
                    for (int i2 = 0; i2 < 8 && u8 > 0; i2++) {
                        if (((1 << (7 - i2)) & u8) != 0) {
                            this.types.add(Integer.valueOf((windowBlockNumber * 256) + (i * 8) + i2));
                        }
                    }
                }
            } else {
                throw new WireParseException("invalid bitmap descriptor");
            }
        }
    }

    public TypeBitmap(Tokenizer tokenizer) throws TextParseException {
        this();
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                return;
            }
            int iValue = Type.value(token.value());
            if (iValue >= 0) {
                this.types.add(Integer.valueOf(iValue));
            } else {
                throw tokenizer.exception("Invalid type: " + token.value());
            }
        }
    }
}
