package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;

/* loaded from: classes2.dex */
final class i implements g {
    i(int i) {
    }

    @Override // j$.time.format.g
    public boolean a(q qVar, StringBuilder sb) {
        Long lE = qVar.e(j$.time.temporal.a.INSTANT_SECONDS);
        j$.time.temporal.k kVarD = qVar.d();
        j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
        Long lValueOf = kVarD.e(aVar) ? Long.valueOf(qVar.d().c(aVar)) : null;
        int i = 0;
        if (lE == null) {
            return false;
        }
        long jLongValue = lE.longValue();
        int iG = aVar.g(lValueOf != null ? lValueOf.longValue() : 0L);
        if (jLongValue >= -62167219200L) {
            long j = (jLongValue - 315569520000L) + 62167219200L;
            long jF = j$.lang.d.f(j, 315569520000L) + 1;
            LocalDateTime localDateTimeL = LocalDateTime.l(j$.lang.d.e(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (jF > 0) {
                sb.append('+');
                sb.append(jF);
            }
            sb.append(localDateTimeL);
            if (localDateTimeL.h() == 0) {
                sb.append(":00");
            }
        } else {
            long j2 = jLongValue + 62167219200L;
            long j3 = j2 / 315569520000L;
            long j4 = j2 % 315569520000L;
            LocalDateTime localDateTimeL2 = LocalDateTime.l(j4 - 62167219200L, 0, ZoneOffset.UTC);
            int length = sb.length();
            sb.append(localDateTimeL2);
            if (localDateTimeL2.h() == 0) {
                sb.append(":00");
            }
            if (j3 < 0) {
                if (localDateTimeL2.i() == -10000) {
                    sb.replace(length, length + 2, Long.toString(j3 - 1));
                } else if (j4 == 0) {
                    sb.insert(length, j3);
                } else {
                    sb.insert(length + 1, Math.abs(j3));
                }
            }
        }
        if (iG > 0) {
            sb.append('.');
            int i2 = 100000000;
            while (true) {
                if (iG <= 0 && i % 3 == 0 && i >= -2) {
                    break;
                }
                int i3 = iG / i2;
                sb.append((char) (i3 + 48));
                iG -= i3 * i2;
                i2 /= 10;
                i++;
            }
        }
        sb.append('Z');
        return true;
    }

    public String toString() {
        return "Instant()";
    }
}
