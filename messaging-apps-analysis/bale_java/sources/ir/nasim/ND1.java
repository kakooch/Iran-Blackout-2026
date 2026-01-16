package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import java.util.ArrayDeque;
import org.xbill.DNS.TTL;

/* loaded from: classes2.dex */
final class ND1 implements W22 {
    private final byte[] a = new byte[8];
    private final ArrayDeque b = new ArrayDeque();
    private final LQ7 c = new LQ7();
    private V22 d;
    private int e;
    private int f;
    private long g;

    private static final class b {
        private final int a;
        private final long b;

        private b(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }

    private long c(InterfaceC9845af2 interfaceC9845af2) {
        interfaceC9845af2.e();
        while (true) {
            interfaceC9845af2.m(this.a, 0, 4);
            int iC = LQ7.c(this.a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) LQ7.a(this.a, iC, false);
                if (this.d.f(iA)) {
                    interfaceC9845af2.k(iC);
                    return iA;
                }
            }
            interfaceC9845af2.k(1);
        }
    }

    private double d(InterfaceC9845af2 interfaceC9845af2, int i) {
        return i == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(interfaceC9845af2, i));
    }

    private long e(InterfaceC9845af2 interfaceC9845af2, int i) {
        interfaceC9845af2.readFully(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.a[i2] & 255);
        }
        return j;
    }

    private static String f(InterfaceC9845af2 interfaceC9845af2, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        interfaceC9845af2.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    @Override // ir.nasim.W22
    public boolean a(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        AbstractC20011rK.i(this.d);
        while (true) {
            b bVar = (b) this.b.peek();
            if (bVar != null && interfaceC9845af2.getPosition() >= bVar.b) {
                this.d.a(((b) this.b.pop()).a);
                return true;
            }
            if (this.e == 0) {
                long jD = this.c.d(interfaceC9845af2, true, false, 4);
                if (jD == -2) {
                    jD = c(interfaceC9845af2);
                }
                if (jD == -1) {
                    return false;
                }
                this.f = (int) jD;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.d(interfaceC9845af2, false, true, 8);
                this.e = 2;
            }
            int iE = this.d.e(this.f);
            if (iE != 0) {
                if (iE == 1) {
                    long position = interfaceC9845af2.getPosition();
                    this.b.push(new b(this.f, this.g + position));
                    this.d.h(this.f, position, this.g);
                    this.e = 0;
                    return true;
                }
                if (iE == 2) {
                    long j = this.g;
                    if (j <= 8) {
                        this.d.d(this.f, e(interfaceC9845af2, (int) j));
                        this.e = 0;
                        return true;
                    }
                    throw ParserException.a("Invalid integer size: " + this.g, null);
                }
                if (iE == 3) {
                    long j2 = this.g;
                    if (j2 <= TTL.MAX_VALUE) {
                        this.d.g(this.f, f(interfaceC9845af2, (int) j2));
                        this.e = 0;
                        return true;
                    }
                    throw ParserException.a("String element size: " + this.g, null);
                }
                if (iE == 4) {
                    this.d.c(this.f, (int) this.g, interfaceC9845af2);
                    this.e = 0;
                    return true;
                }
                if (iE != 5) {
                    throw ParserException.a("Invalid element type " + iE, null);
                }
                long j3 = this.g;
                if (j3 == 4 || j3 == 8) {
                    this.d.b(this.f, d(interfaceC9845af2, (int) j3));
                    this.e = 0;
                    return true;
                }
                throw ParserException.a("Invalid float size: " + this.g, null);
            }
            interfaceC9845af2.k((int) this.g);
            this.e = 0;
        }
    }

    @Override // ir.nasim.W22
    public void b(V22 v22) {
        this.d = v22;
    }

    @Override // ir.nasim.W22
    public void reset() {
        this.e = 0;
        this.b.clear();
        this.c.e();
    }
}
