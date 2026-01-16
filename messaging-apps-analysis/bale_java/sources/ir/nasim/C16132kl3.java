package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.Arrays;

/* renamed from: ir.nasim.kl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16132kl3 implements InterfaceC6075Mb3 {
    private char[] a = UJ0.c.d();
    private int b;

    private final void d(int i, int i2, String str) {
        byte b;
        int length = str.length();
        while (i < length) {
            int iF = f(i2, 2);
            char cCharAt = str.charAt(i);
            if (cCharAt >= SY6.a().length || (b = SY6.a()[cCharAt]) == 0) {
                int i3 = iF + 1;
                this.a[iF] = cCharAt;
                i2 = i3;
                i++;
            } else {
                if (b == 1) {
                    String str2 = SY6.b()[cCharAt];
                    AbstractC13042fc3.f(str2);
                    int iF2 = f(iF, str2.length());
                    str2.getChars(0, str2.length(), this.a, iF2);
                    i2 = iF2 + str2.length();
                    this.b = i2;
                } else {
                    char[] cArr = this.a;
                    cArr[iF] = '\\';
                    cArr[iF + 1] = (char) b;
                    i2 = iF + 2;
                    this.b = i2;
                }
                i++;
            }
        }
        int iF3 = f(i2, 1);
        this.a[iF3] = '\"';
        this.b = iF3 + 1;
    }

    private final void e(int i) {
        f(this.b, i);
    }

    private final int f(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = this.a;
        if (cArr.length <= i3) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, AbstractC23053wG5.e(i3, i * 2));
            AbstractC13042fc3.h(cArrCopyOf, "copyOf(...)");
            this.a = cArrCopyOf;
        }
        return i;
    }

    @Override // ir.nasim.InterfaceC6075Mb3
    public void a(char c) {
        e(1);
        char[] cArr = this.a;
        int i = this.b;
        this.b = i + 1;
        cArr[i] = c;
    }

    @Override // ir.nasim.InterfaceC6075Mb3
    public void b(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        e(str.length() + 2);
        char[] cArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        for (int i4 = i2; i4 < i3; i4++) {
            char c = cArr[i4];
            if (c < SY6.a().length && SY6.a()[c] != 0) {
                d(i4 - i2, i4, str);
                return;
            }
        }
        cArr[i3] = '\"';
        this.b = i3 + 1;
    }

    @Override // ir.nasim.InterfaceC6075Mb3
    public void c(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        int length = str.length();
        if (length == 0) {
            return;
        }
        e(length);
        str.getChars(0, str.length(), this.a, this.b);
        this.b += length;
    }

    public void g() {
        UJ0.c.c(this.a);
    }

    public String toString() {
        return new String(this.a, 0, this.b);
    }

    @Override // ir.nasim.InterfaceC6075Mb3
    public void writeLong(long j) {
        c(String.valueOf(j));
    }
}
