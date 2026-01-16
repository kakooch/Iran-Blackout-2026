package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC11911dl3;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: ir.nasim.rl3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C20287rl3 extends AbstractC11911dl3 {
    private static final ByteString n = ByteString.encodeUtf8("'\\");
    private static final ByteString o = ByteString.encodeUtf8("\"\\");
    private static final ByteString p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString q = ByteString.encodeUtf8("\n\r");
    private static final ByteString r = ByteString.encodeUtf8("*/");
    private final BufferedSource h;
    private final Buffer i;
    private int j = 0;
    private long k;
    private int l;
    private String m;

    C20287rl3(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.h = bufferedSource;
        this.i = bufferedSource.getBufferField();
        k(6);
    }

    private String G(ByteString byteString) throws C3568Bk3, EOFException {
        StringBuilder sb = null;
        while (true) {
            long jIndexOfElement = this.h.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw p("Unterminated string");
            }
            if (this.i.getByte(jIndexOfElement) != 92) {
                if (sb == null) {
                    String utf8 = this.i.readUtf8(jIndexOfElement);
                    this.i.readByte();
                    return utf8;
                }
                sb.append(this.i.readUtf8(jIndexOfElement));
                this.i.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.i.readUtf8(jIndexOfElement));
            this.i.readByte();
            sb.append(M());
        }
    }

    private String H() {
        long jIndexOfElement = this.h.indexOfElement(p);
        return jIndexOfElement != -1 ? this.i.readUtf8(jIndexOfElement) : this.i.readUtf8();
    }

    private int J() throws EOFException {
        String str;
        String str2;
        int i;
        byte b = this.i.getByte(0L);
        if (b == 116 || b == 84) {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (b == 102 || b == 70) {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (b != 110 && b != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.h.request(i3)) {
                return 0;
            }
            byte b2 = this.i.getByte(i2);
            if (b2 != str.charAt(i2) && b2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.h.request(length + 1) && y(this.i.getByte(length))) {
            return 0;
        }
        this.i.skip(length);
        this.j = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        if (y(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
    
        r16.k = r8;
        r16.i.skip(r5);
        r16.j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
    
        r16.l = r5;
        r16.j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int K() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20287rl3.K():int");
    }

    private char M() throws C3568Bk3, EOFException {
        int i;
        if (!this.h.request(1L)) {
            throw p("Unterminated escape sequence");
        }
        byte b = this.i.readByte();
        if (b == 10 || b == 34 || b == 39 || b == 47 || b == 92) {
            return (char) b;
        }
        if (b == 98) {
            return '\b';
        }
        if (b == 102) {
            return '\f';
        }
        if (b == 110) {
            return '\n';
        }
        if (b == 114) {
            return '\r';
        }
        if (b == 116) {
            return '\t';
        }
        if (b != 117) {
            if (this.e) {
                return (char) b;
            }
            throw p("Invalid escape sequence: \\" + ((char) b));
        }
        if (!this.h.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + A());
        }
        char c = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            byte b2 = this.i.getByte(i2);
            char c2 = (char) (c << 4);
            if (b2 >= 48 && b2 <= 57) {
                i = b2 - 48;
            } else if (b2 >= 97 && b2 <= 102) {
                i = b2 - 87;
            } else {
                if (b2 < 65 || b2 > 70) {
                    throw p("\\u" + this.i.readUtf8(4L));
                }
                i = b2 - 55;
            }
            c = (char) (c2 + i);
        }
        this.i.skip(4L);
        return c;
    }

    private void P(ByteString byteString) throws C3568Bk3, EOFException {
        while (true) {
            long jIndexOfElement = this.h.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw p("Unterminated string");
            }
            if (this.i.getByte(jIndexOfElement) != 92) {
                this.i.skip(jIndexOfElement + 1);
                return;
            } else {
                this.i.skip(jIndexOfElement + 1);
                M();
            }
        }
    }

    private boolean S() throws EOFException {
        long jIndexOf = this.h.indexOf(r);
        boolean z = jIndexOf != -1;
        Buffer buffer = this.i;
        buffer.skip(z ? jIndexOf + r1.size() : buffer.size());
        return z;
    }

    private void T() throws EOFException {
        long jIndexOfElement = this.h.indexOfElement(q);
        Buffer buffer = this.i;
        buffer.skip(jIndexOfElement != -1 ? jIndexOfElement + 1 : buffer.size());
    }

    private void U() throws EOFException {
        long jIndexOfElement = this.h.indexOfElement(p);
        Buffer buffer = this.i;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }

    private void q() throws C3568Bk3 {
        if (!this.e) {
            throw p("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int s() throws C3568Bk3, EOFException {
        int[] iArr = this.b;
        int i = this.a;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int iZ = z(true);
            this.i.readByte();
            if (iZ != 44) {
                if (iZ != 59) {
                    if (iZ != 93) {
                        throw p("Unterminated array");
                    }
                    this.j = 4;
                    return 4;
                }
                q();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5) {
                    int iZ2 = z(true);
                    this.i.readByte();
                    if (iZ2 != 44) {
                        if (iZ2 != 59) {
                            if (iZ2 != 125) {
                                throw p("Unterminated object");
                            }
                            this.j = 2;
                            return 2;
                        }
                        q();
                    }
                }
                int iZ3 = z(true);
                if (iZ3 == 34) {
                    this.i.readByte();
                    this.j = 13;
                    return 13;
                }
                if (iZ3 == 39) {
                    this.i.readByte();
                    q();
                    this.j = 12;
                    return 12;
                }
                if (iZ3 != 125) {
                    q();
                    if (!y((char) iZ3)) {
                        throw p("Expected name");
                    }
                    this.j = 14;
                    return 14;
                }
                if (i2 == 5) {
                    throw p("Expected name");
                }
                this.i.readByte();
                this.j = 2;
                return 2;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int iZ4 = z(true);
                this.i.readByte();
                if (iZ4 != 58) {
                    if (iZ4 != 61) {
                        throw p("Expected ':'");
                    }
                    q();
                    if (this.h.request(1L) && this.i.getByte(0L) == 62) {
                        this.i.readByte();
                    }
                }
            } else if (i2 == 6) {
                iArr[i - 1] = 7;
            } else if (i2 == 7) {
                if (z(false) == -1) {
                    this.j = 18;
                    return 18;
                }
                q();
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iZ5 = z(true);
        if (iZ5 == 34) {
            this.i.readByte();
            this.j = 9;
            return 9;
        }
        if (iZ5 == 39) {
            q();
            this.i.readByte();
            this.j = 8;
            return 8;
        }
        if (iZ5 != 44 && iZ5 != 59) {
            if (iZ5 == 91) {
                this.i.readByte();
                this.j = 3;
                return 3;
            }
            if (iZ5 != 93) {
                if (iZ5 == 123) {
                    this.i.readByte();
                    this.j = 1;
                    return 1;
                }
                int iJ = J();
                if (iJ != 0) {
                    return iJ;
                }
                int iK = K();
                if (iK != 0) {
                    return iK;
                }
                if (!y(this.i.getByte(0L))) {
                    throw p("Expected value");
                }
                q();
                this.j = 10;
                return 10;
            }
            if (i2 == 1) {
                this.i.readByte();
                this.j = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            throw p("Unexpected value");
        }
        q();
        this.j = 7;
        return 7;
    }

    private int u(String str, AbstractC11911dl3.a aVar) {
        int length = aVar.a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.a[i])) {
                this.j = 0;
                this.c[this.a - 1] = str;
                return i;
            }
        }
        return -1;
    }

    private boolean y(int i) throws C3568Bk3 {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        q();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.i.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r2 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if (r6.h.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        q();
        r3 = r6.i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r6.i.readByte();
        r6.i.readByte();
        T();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r6.i.readByte();
        r6.i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        if (S() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        throw p("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        q();
        T();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int z(boolean r7) throws ir.nasim.C3568Bk3, java.io.EOFException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            okio.BufferedSource r2 = r6.h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L80
            okio.Buffer r2 = r6.i
            long r4 = (long) r1
            byte r2 = r2.getByte(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            okio.Buffer r3 = r6.i
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L72
            okio.BufferedSource r3 = r6.h
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3a
            return r2
        L3a:
            r6.q()
            okio.Buffer r3 = r6.i
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            return r2
        L4c:
            okio.Buffer r1 = r6.i
            r1.readByte()
            okio.Buffer r1 = r6.i
            r1.readByte()
            r6.T()
            goto L1
        L5a:
            okio.Buffer r1 = r6.i
            r1.readByte()
            okio.Buffer r1 = r6.i
            r1.readByte()
            boolean r1 = r6.S()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            ir.nasim.Bk3 r7 = r6.p(r7)
            throw r7
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.q()
            r6.T()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r7 = -1
            return r7
        L84:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20287rl3.z(boolean):int");
    }

    @Override // ir.nasim.AbstractC11911dl3
    public void B() throws C3568Bk3, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 1) {
            k(3);
            this.j = 0;
            return;
        }
        throw new C19077pk3("Expected BEGIN_OBJECT but was " + j() + " at path " + A());
    }

    @Override // ir.nasim.AbstractC11911dl3
    public void F() throws C3568Bk3, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS != 2) {
            throw new C19077pk3("Expected END_OBJECT but was " + j() + " at path " + A());
        }
        int i = this.a;
        int i2 = i - 1;
        this.a = i2;
        this.c[i2] = null;
        int[] iArr = this.d;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.j = 0;
    }

    @Override // ir.nasim.AbstractC11911dl3
    public void R() throws C3568Bk3, EOFException {
        if (this.f) {
            throw new C19077pk3("Cannot skip unexpected " + j() + " at " + A());
        }
        int i = 0;
        do {
            int iS = this.j;
            if (iS == 0) {
                iS = s();
            }
            if (iS == 3) {
                k(1);
            } else if (iS == 1) {
                k(3);
            } else {
                if (iS == 4) {
                    i--;
                    if (i < 0) {
                        throw new C19077pk3("Expected a value but was " + j() + " at path " + A());
                    }
                    this.a--;
                } else if (iS == 2) {
                    i--;
                    if (i < 0) {
                        throw new C19077pk3("Expected a value but was " + j() + " at path " + A());
                    }
                    this.a--;
                } else if (iS == 14 || iS == 10) {
                    U();
                } else if (iS == 9 || iS == 13) {
                    P(o);
                } else if (iS == 8 || iS == 12) {
                    P(n);
                } else if (iS == 17) {
                    this.i.skip(this.l);
                } else if (iS == 18) {
                    throw new C19077pk3("Expected a value but was " + j() + " at path " + A());
                }
                this.j = 0;
            }
            i++;
            this.j = 0;
        } while (i != 0);
        int[] iArr = this.d;
        int i2 = this.a;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.c[i2 - 1] = "null";
    }

    @Override // ir.nasim.AbstractC11911dl3
    public String T0() throws C3568Bk3, EOFException {
        String utf8;
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 10) {
            utf8 = H();
        } else if (iS == 9) {
            utf8 = G(o);
        } else if (iS == 8) {
            utf8 = G(n);
        } else if (iS == 11) {
            utf8 = this.m;
            this.m = null;
        } else if (iS == 16) {
            utf8 = Long.toString(this.k);
        } else {
            if (iS != 17) {
                throw new C19077pk3("Expected a string but was " + j() + " at path " + A());
            }
            utf8 = this.i.readUtf8(this.l);
        }
        this.j = 0;
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return utf8;
    }

    @Override // ir.nasim.AbstractC11911dl3
    public void b() throws C3568Bk3, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 3) {
            k(1);
            this.d[this.a - 1] = 0;
            this.j = 0;
        } else {
            throw new C19077pk3("Expected BEGIN_ARRAY but was " + j() + " at path " + A());
        }
    }

    @Override // ir.nasim.AbstractC11911dl3
    public void c() throws C3568Bk3, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS != 4) {
            throw new C19077pk3("Expected END_ARRAY but was " + j() + " at path " + A());
        }
        int i = this.a;
        this.a = i - 1;
        int[] iArr = this.d;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.j = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.j = 0;
        this.b[0] = 8;
        this.a = 1;
        this.i.clear();
        this.h.close();
    }

    @Override // ir.nasim.AbstractC11911dl3
    public boolean d() throws C3568Bk3, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        return (iS == 2 || iS == 4 || iS == 18) ? false : true;
    }

    @Override // ir.nasim.AbstractC11911dl3
    public boolean e() throws C3568Bk3, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 5) {
            this.j = 0;
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iS == 6) {
            this.j = 0;
            int[] iArr2 = this.d;
            int i2 = this.a - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new C19077pk3("Expected a boolean but was " + j() + " at path " + A());
    }

    @Override // ir.nasim.AbstractC11911dl3
    public double f1() throws C3568Bk3, NumberFormatException, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 16) {
            this.j = 0;
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            return this.k;
        }
        if (iS == 17) {
            this.m = this.i.readUtf8(this.l);
        } else if (iS == 9) {
            this.m = G(o);
        } else if (iS == 8) {
            this.m = G(n);
        } else if (iS == 10) {
            this.m = H();
        } else if (iS != 11) {
            throw new C19077pk3("Expected a double but was " + j() + " at path " + A());
        }
        this.j = 11;
        try {
            double d = Double.parseDouble(this.m);
            if (this.e || !(Double.isNaN(d) || Double.isInfinite(d))) {
                this.m = null;
                this.j = 0;
                int[] iArr2 = this.d;
                int i2 = this.a - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return d;
            }
            throw new C3568Bk3("JSON forbids NaN and infinities: " + d + " at path " + A());
        } catch (NumberFormatException unused) {
            throw new C19077pk3("Expected a double but was " + this.m + " at path " + A());
        }
    }

    @Override // ir.nasim.AbstractC11911dl3
    public AbstractC11911dl3.b j() throws C3568Bk3, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        switch (iS) {
            case 1:
                return AbstractC11911dl3.b.BEGIN_OBJECT;
            case 2:
                return AbstractC11911dl3.b.END_OBJECT;
            case 3:
                return AbstractC11911dl3.b.BEGIN_ARRAY;
            case 4:
                return AbstractC11911dl3.b.END_ARRAY;
            case 5:
            case 6:
                return AbstractC11911dl3.b.BOOLEAN;
            case 7:
                return AbstractC11911dl3.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return AbstractC11911dl3.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return AbstractC11911dl3.b.NAME;
            case 16:
            case 17:
                return AbstractC11911dl3.b.NUMBER;
            case 18:
                return AbstractC11911dl3.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // ir.nasim.AbstractC11911dl3
    public int l(AbstractC11911dl3.a aVar) throws C3568Bk3, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS < 12 || iS > 15) {
            return -1;
        }
        if (iS == 15) {
            return u(this.m, aVar);
        }
        int iSelect = this.h.select(aVar.b);
        if (iSelect != -1) {
            this.j = 0;
            this.c[this.a - 1] = aVar.a[iSelect];
            return iSelect;
        }
        String str = this.c[this.a - 1];
        String strN0 = n0();
        int iU = u(strN0, aVar);
        if (iU == -1) {
            this.j = 15;
            this.m = strN0;
            this.c[this.a - 1] = str;
        }
        return iU;
    }

    @Override // ir.nasim.AbstractC11911dl3
    public void m() throws C3568Bk3, EOFException {
        if (this.f) {
            throw new C19077pk3("Cannot skip unexpected " + j() + " at " + A());
        }
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 14) {
            U();
        } else if (iS == 13) {
            P(o);
        } else if (iS == 12) {
            P(n);
        } else if (iS != 15) {
            throw new C19077pk3("Expected a name but was " + j() + " at path " + A());
        }
        this.j = 0;
        this.c[this.a - 1] = "null";
    }

    @Override // ir.nasim.AbstractC11911dl3
    public String n0() throws C3568Bk3, EOFException {
        String strG;
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 14) {
            strG = H();
        } else if (iS == 13) {
            strG = G(o);
        } else if (iS == 12) {
            strG = G(n);
        } else {
            if (iS != 15) {
                throw new C19077pk3("Expected a name but was " + j() + " at path " + A());
            }
            strG = this.m;
        }
        this.j = 0;
        this.c[this.a - 1] = strG;
        return strG;
    }

    @Override // ir.nasim.AbstractC11911dl3
    public int r0() throws C3568Bk3, NumberFormatException, EOFException {
        int iS = this.j;
        if (iS == 0) {
            iS = s();
        }
        if (iS == 16) {
            long j = this.k;
            int i = (int) j;
            if (j == i) {
                this.j = 0;
                int[] iArr = this.d;
                int i2 = this.a - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new C19077pk3("Expected an int but was " + this.k + " at path " + A());
        }
        if (iS == 17) {
            this.m = this.i.readUtf8(this.l);
        } else if (iS == 9 || iS == 8) {
            String strG = iS == 9 ? G(o) : G(n);
            this.m = strG;
            try {
                int i3 = Integer.parseInt(strG);
                this.j = 0;
                int[] iArr2 = this.d;
                int i4 = this.a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iS != 11) {
            throw new C19077pk3("Expected an int but was " + j() + " at path " + A());
        }
        this.j = 11;
        try {
            double d = Double.parseDouble(this.m);
            int i5 = (int) d;
            if (i5 == d) {
                this.m = null;
                this.j = 0;
                int[] iArr3 = this.d;
                int i6 = this.a - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new C19077pk3("Expected an int but was " + this.m + " at path " + A());
        } catch (NumberFormatException unused2) {
            throw new C19077pk3("Expected an int but was " + this.m + " at path " + A());
        }
    }

    public String toString() {
        return "JsonReader(" + this.h + Separators.RPAREN;
    }
}
