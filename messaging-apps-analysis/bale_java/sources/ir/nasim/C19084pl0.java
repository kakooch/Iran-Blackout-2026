package ir.nasim;

import ir.nasim.core.runtime.bser.IncorrectTypeException;
import ir.nasim.core.runtime.bser.UnknownFieldException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.pl0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C19084pl0 {
    private C18818pI6 a;
    String b = "BserValues";
    private C21212tI6 c = new C21212tI6();

    public C19084pl0(C18818pI6 c18818pI6) {
        this.a = c18818pI6;
    }

    public String A(int i) {
        return AbstractC17091mN7.b(v(i));
    }

    public C18818pI6 a() {
        C18818pI6 c18818pI6 = new C18818pI6();
        for (int i = 0; i < this.a.k(); i++) {
            int iH = this.a.h(i);
            if (!this.c.a(iH, false)) {
                c18818pI6.i(iH, this.a.d(iH));
            }
        }
        return c18818pI6;
    }

    public boolean b(int i) {
        return i(i) != 0;
    }

    public boolean c(int i, boolean z) {
        return j(i, z ? 1L : 0L) != 0;
    }

    public byte[] d(int i) throws UnknownFieldException {
        if (this.a.b(i)) {
            return e(i, null);
        }
        throw new UnknownFieldException("Unable to find field #" + i);
    }

    public byte[] e(int i, byte[] bArr) throws IncorrectTypeException {
        if (!this.a.b(i)) {
            return bArr;
        }
        this.c.c(i, true);
        Object objD = this.a.d(i);
        if (objD instanceof byte[]) {
            return (byte[]) objD;
        }
        throw new IncorrectTypeException("Expected type: byte[], got " + objD.getClass().getSimpleName());
    }

    public double f(int i) {
        return Double.longBitsToDouble(i(i));
    }

    public int g(int i) {
        return AbstractC17091mN7.a(i(i));
    }

    public int h(int i, int i2) {
        return AbstractC17091mN7.a(j(i, i2));
    }

    public long i(int i) {
        if (this.a.b(i)) {
            return j(i, 0L);
        }
        C19406qI3.b(this.b, "Unable to find field #" + i);
        return 0L;
    }

    public long j(int i, long j) throws IncorrectTypeException {
        if (!this.a.b(i)) {
            return j;
        }
        this.c.c(i, true);
        Object objD = this.a.d(i);
        if (objD instanceof Long) {
            return ((Long) objD).longValue();
        }
        throw new IncorrectTypeException("Expected type: long, got " + objD.getClass().getSimpleName());
    }

    public AbstractC17902nl0 k(int i, AbstractC17902nl0 abstractC17902nl0) throws UnknownFieldException {
        byte[] bArrV = v(i);
        if (bArrV != null) {
            return AbstractC16720ll0.a(abstractC17902nl0, new C9207Yy1(bArrV, 0, bArrV.length));
        }
        throw new UnknownFieldException("Unable to find field #" + i);
    }

    public List l(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (this.a.b(i)) {
            this.c.c(i, true);
            Object objD = this.a.d(i);
            if (objD instanceof byte[]) {
                arrayList.add((byte[]) objD);
            } else {
                if (!(objD instanceof List)) {
                    throw new IOException("Expected type: byte[], got " + objD.getClass().getSimpleName());
                }
                for (Object obj : (List) objD) {
                    if (!(obj instanceof byte[])) {
                        throw new IOException("Expected type: byte[], got " + obj.getClass().getSimpleName());
                    }
                    arrayList.add((byte[]) obj);
                }
            }
        }
        return arrayList;
    }

    public int m(int i) {
        if (!this.a.b(i)) {
            return 0;
        }
        this.c.c(i, true);
        Object objD = this.a.d(i);
        if (objD instanceof List) {
            return ((List) objD).size();
        }
        return 1;
    }

    public List n(int i) throws IOException {
        List listO = o(i);
        ArrayList arrayList = new ArrayList();
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(AbstractC17091mN7.a(((Long) it.next()).longValue())));
        }
        return arrayList;
    }

    public List o(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (this.a.b(i)) {
            this.c.c(i, true);
            Object objD = this.a.d(i);
            if (objD instanceof Long) {
                arrayList.add((Long) objD);
            } else {
                if (!(objD instanceof List)) {
                    throw new IOException("Expected type: long, got " + objD.getClass().getSimpleName());
                }
                for (Object obj : (List) objD) {
                    if (!(obj instanceof Long)) {
                        throw new IOException("Expected type: long, got " + obj.getClass().getSimpleName());
                    }
                    arrayList.add((Long) obj);
                }
            }
        }
        return arrayList;
    }

    public List p(int i, List list) {
        ArrayList arrayList = new ArrayList();
        for (byte[] bArr : l(i)) {
            arrayList.add(AbstractC16720ll0.a((AbstractC17902nl0) list.remove(0), new C9207Yy1(bArr, 0, bArr.length)));
        }
        return arrayList;
    }

    public List q(int i) throws IOException {
        List listL = l(i);
        ArrayList arrayList = new ArrayList();
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC17091mN7.b((byte[]) it.next()));
        }
        return arrayList;
    }

    public String r(int i) {
        return AbstractC17091mN7.b(d(i));
    }

    public String s(int i, String str) {
        return AbstractC17091mN7.b(e(i, str.getBytes("UTF-8")));
    }

    public boolean t() {
        for (int i = 0; i < this.a.k(); i++) {
            if (!this.c.a(this.a.h(i), false)) {
                return true;
            }
        }
        return false;
    }

    public boolean u(int i) {
        return y(i) != 0;
    }

    public byte[] v(int i) {
        return e(i, null);
    }

    public double w(int i) {
        return Double.longBitsToDouble(y(i));
    }

    public int x(int i) {
        return AbstractC17091mN7.a(y(i));
    }

    public long y(int i) {
        return j(i, 0L);
    }

    public AbstractC17902nl0 z(int i, AbstractC17902nl0 abstractC17902nl0) {
        byte[] bArrV = v(i);
        if (bArrV == null) {
            return null;
        }
        return AbstractC16720ll0.b(abstractC17902nl0, bArrV);
    }
}
