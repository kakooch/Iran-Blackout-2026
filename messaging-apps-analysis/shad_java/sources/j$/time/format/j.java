package j$.time.format;

/* loaded from: classes2.dex */
class j implements g {
    static final long[] f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};
    final j$.time.temporal.l a;
    final int b;
    final int c;
    private final t d;
    final int e;

    j(j$.time.temporal.l lVar, int i, int i2, t tVar) {
        this.a = lVar;
        this.b = i;
        this.c = i2;
        this.d = tVar;
        this.e = 0;
    }

    protected j(j$.time.temporal.l lVar, int i, int i2, t tVar, int i3) {
        this.a = lVar;
        this.b = i;
        this.c = i2;
        this.d = tVar;
        this.e = i3;
    }

    @Override // j$.time.format.g
    public boolean a(q qVar, StringBuilder sb) {
        char c;
        int i;
        Long lE = qVar.e(this.a);
        if (lE == null) {
            return false;
        }
        long jLongValue = lE.longValue();
        s sVarB = qVar.b();
        String string = jLongValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jLongValue));
        if (string.length() > this.c) {
            throw new j$.time.c("Field " + this.a + " cannot be printed as the value " + jLongValue + " exceeds the maximum print width of " + this.c);
        }
        sVarB.a(string);
        int[] iArr = d.a;
        int iOrdinal = this.d.ordinal();
        if (jLongValue >= 0) {
            int i2 = iArr[iOrdinal];
            if (i2 == 1 ? !((i = this.b) >= 19 || jLongValue < f[i]) : i2 == 2) {
                c = sVarB.d();
                sb.append(c);
            }
        } else {
            int i3 = iArr[iOrdinal];
            if (i3 == 1 || i3 == 2 || i3 == 3) {
                c = sVarB.c();
                sb.append(c);
            } else if (i3 == 4) {
                throw new j$.time.c("Field " + this.a + " cannot be printed as the value " + jLongValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i4 = 0; i4 < this.b - string.length(); i4++) {
            sb.append(sVarB.e());
        }
        sb.append(string);
        return true;
    }

    j c() {
        return this.e == -1 ? this : new j(this.a, this.b, this.c, this.d, -1);
    }

    j d(int i) {
        return new j(this.a, this.b, this.c, this.d, this.e + i);
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        int i = this.b;
        if (i == 1 && this.c == 19 && this.d == t.NORMAL) {
            sb = new StringBuilder();
            sb.append("Value(");
            obj = this.a;
        } else {
            if (i == this.c && this.d == t.NOT_NEGATIVE) {
                sb = new StringBuilder();
                sb.append("Value(");
                sb.append(this.a);
                sb.append(",");
                sb.append(this.b);
                sb.append(")");
                return sb.toString();
            }
            sb = new StringBuilder();
            sb.append("Value(");
            sb.append(this.a);
            sb.append(",");
            sb.append(this.b);
            sb.append(",");
            sb.append(this.c);
            sb.append(",");
            obj = this.d;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
