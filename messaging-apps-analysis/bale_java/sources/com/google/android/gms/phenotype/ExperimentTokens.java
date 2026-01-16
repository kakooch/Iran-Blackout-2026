package com.google.android.gms.phenotype;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Mo8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class ExperimentTokens extends AbstractSafeParcelable {
    private static final byte[][] i;
    private static final ExperimentTokens j;
    private final String a;
    private final byte[] b;
    private final byte[][] c;
    private final byte[][] d;
    private final byte[][] e;
    private final byte[][] f;
    private final int[] g;
    private final byte[][] h;
    public static final Parcelable.Creator<ExperimentTokens> CREATOR = new Mo8();
    private static final a k = new com.google.android.gms.phenotype.a();
    private static final a l = new b();
    private static final a m = new c();
    private static final a n = new d();

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
    }

    static {
        byte[][] bArr = new byte[0][];
        i = bArr;
        j = new ExperimentTokens("", null, bArr, bArr, bArr, bArr, null, null);
    }

    public ExperimentTokens(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.a = str;
        this.b = bArr;
        this.c = bArr2;
        this.d = bArr3;
        this.e = bArr4;
        this.f = bArr5;
        this.g = iArr;
        this.h = bArr6;
    }

    private static List P(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List S(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] bArr2 : bArr) {
            arrayList.add(Base64.encodeToString(bArr2, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void d0(StringBuilder sb, String str, byte[][] bArr) {
        String str2;
        sb.append(str);
        sb.append(Separators.EQUALS);
        if (bArr == null) {
            str2 = "null";
        } else {
            sb.append(Separators.LPAREN);
            int length = bArr.length;
            boolean z = true;
            int i2 = 0;
            while (i2 < length) {
                byte[] bArr2 = bArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append(Separators.QUOTE);
                sb.append(Base64.encodeToString(bArr2, 3));
                sb.append(Separators.QUOTE);
                i2++;
                z = false;
            }
            str2 = Separators.RPAREN;
        }
        sb.append(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExperimentTokens) {
            ExperimentTokens experimentTokens = (ExperimentTokens) obj;
            if (e.a(this.a, experimentTokens.a) && Arrays.equals(this.b, experimentTokens.b) && e.a(S(this.c), S(experimentTokens.c)) && e.a(S(this.d), S(experimentTokens.d)) && e.a(S(this.e), S(experimentTokens.e)) && e.a(S(this.f), S(experimentTokens.f)) && e.a(P(this.g), P(experimentTokens.g)) && e.a(S(this.h), S(experimentTokens.h))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder("ExperimentTokens");
        sb.append(Separators.LPAREN);
        String str = this.a;
        if (str == null) {
            string = "null";
        } else {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2);
            sb2.append(Separators.QUOTE);
            sb2.append(str);
            sb2.append(Separators.QUOTE);
            string = sb2.toString();
        }
        sb.append(string);
        sb.append(", ");
        byte[] bArr = this.b;
        sb.append("direct");
        sb.append(Separators.EQUALS);
        if (bArr == null) {
            sb.append("null");
        } else {
            sb.append(Separators.QUOTE);
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append(Separators.QUOTE);
        }
        sb.append(", ");
        d0(sb, "GAIA", this.c);
        sb.append(", ");
        d0(sb, "PSEUDO", this.d);
        sb.append(", ");
        d0(sb, "ALWAYS", this.e);
        sb.append(", ");
        d0(sb, "OTHER", this.f);
        sb.append(", ");
        int[] iArr = this.g;
        sb.append("weak");
        sb.append(Separators.EQUALS);
        if (iArr == null) {
            sb.append("null");
        } else {
            sb.append(Separators.LPAREN);
            int length = iArr.length;
            boolean z = true;
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append(i3);
                i2++;
                z = false;
            }
            sb.append(Separators.RPAREN);
        }
        sb.append(", ");
        d0(sb, "directs", this.h);
        sb.append(Separators.RPAREN);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 2, this.a, false);
        AbstractC21804u96.g(parcel, 3, this.b, false);
        AbstractC21804u96.h(parcel, 4, this.c, false);
        AbstractC21804u96.h(parcel, 5, this.d, false);
        AbstractC21804u96.h(parcel, 6, this.e, false);
        AbstractC21804u96.h(parcel, 7, this.f, false);
        AbstractC21804u96.o(parcel, 8, this.g, false);
        AbstractC21804u96.h(parcel, 9, this.h, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
