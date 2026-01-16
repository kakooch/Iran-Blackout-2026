package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class Generator {
    private long current;
    public final int dclass;
    public long end;
    public final String namePattern;
    public final Name origin;
    public final String rdataPattern;
    public long start;
    public long step;
    public final long ttl;
    public final int type;

    public Generator(long j, long j2, long j3, String str, int i, int i2, long j4, String str2, Name name) {
        if (j < 0 || j2 < 0 || j > j2 || j3 <= 0) {
            throw new IllegalArgumentException("invalid range specification");
        }
        if (!supportedType(i)) {
            throw new IllegalArgumentException("unsupported type");
        }
        DClass.check(i2);
        this.start = j;
        this.end = j2;
        this.step = j3;
        this.namePattern = str;
        this.type = i;
        this.dclass = i2;
        this.ttl = j4;
        this.rdataPattern = str2;
        this.origin = name;
        this.current = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0090, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0091, code lost:
    
        if (r3 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0093, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
    
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        if (r5 != ',') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0098, code lost:
    
        r3 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009b, code lost:
    
        if (r3 >= r0.length) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009d, code lost:
    
        r5 = (char) (r0[r3] & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        if (r5 == ',') goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a4, code lost:
    
        if (r5 != '}') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a7, code lost:
    
        if (r5 < '0') goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a9, code lost:
    
        if (r5 > '9') goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ab, code lost:
    
        r5 = (char) (r5 - '0');
        r16 = (r16 * 10) + r5;
        r8 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bc, code lost:
    
        throw new org.xbill.DNS.TextParseException("invalid width");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bd, code lost:
    
        r8 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00be, code lost:
    
        if (r5 != ',') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c0, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c5, code lost:
    
        if (r8 == r0.length) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c7, code lost:
    
        r3 = (char) (r0[r8] & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ce, code lost:
    
        if (r3 != 'o') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d0, code lost:
    
        r5 = false;
        r13 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d7, code lost:
    
        if (r3 != 'x') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d9, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00db, code lost:
    
        r13 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e0, code lost:
    
        if (r3 != 'X') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e2, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e7, code lost:
    
        if (r3 != 'd') goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e9, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f1, code lost:
    
        throw new org.xbill.DNS.TextParseException("invalid base");
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f7, code lost:
    
        throw new org.xbill.DNS.TextParseException("invalid base");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f8, code lost:
    
        r6 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00fb, code lost:
    
        if (r6 == r0.length) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00ff, code lost:
    
        if (r0[r6] != 125) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0101, code lost:
    
        r3 = r6;
        r6 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x010c, code lost:
    
        throw new org.xbill.DNS.TextParseException("invalid modifiers");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String substitute(java.lang.String r19, long r20) throws org.xbill.DNS.TextParseException {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Generator.substitute(java.lang.String, long):java.lang.String");
    }

    public static boolean supportedType(int i) {
        Type.check(i);
        return i == 12 || i == 5 || i == 39 || i == 1 || i == 28 || i == 2;
    }

    public Record[] expand() throws TextParseException {
        ArrayList arrayList = new ArrayList();
        long j = this.start;
        while (j < this.end) {
            arrayList.add(Record.fromString(Name.fromString(substitute(this.namePattern, this.current), this.origin), this.type, this.dclass, this.ttl, substitute(this.rdataPattern, this.current), this.origin));
            j += this.step;
        }
        return (Record[]) arrayList.toArray(new Record[0]);
    }

    public Record nextRecord() throws TextParseException {
        long j = this.current;
        if (j > this.end) {
            return null;
        }
        Name nameFromString = Name.fromString(substitute(this.namePattern, j), this.origin);
        String strSubstitute = substitute(this.rdataPattern, this.current);
        this.current += this.step;
        return Record.fromString(nameFromString, this.type, this.dclass, this.ttl, strSubstitute, this.origin);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("$GENERATE ");
        sb.append(this.start);
        sb.append("-");
        sb.append(this.end);
        if (this.step > 1) {
            sb.append(Separators.SLASH);
            sb.append(this.step);
        }
        sb.append(Separators.SP);
        sb.append(this.namePattern);
        sb.append(Separators.SP);
        sb.append(this.ttl);
        sb.append(Separators.SP);
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            sb.append(DClass.string(this.dclass));
            sb.append(Separators.SP);
        }
        sb.append(Type.string(this.type));
        sb.append(Separators.SP);
        sb.append(this.rdataPattern);
        sb.append(Separators.SP);
        return sb.toString();
    }
}
