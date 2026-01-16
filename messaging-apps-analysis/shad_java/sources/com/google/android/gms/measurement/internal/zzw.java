package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
abstract class zzw {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    zzw(String str, int i) {
        this.zzb = str;
        this.zzc = i;
    }

    private static Boolean zzd(String str, com.google.android.gms.internal.measurement.zzcj zzcjVar, boolean z, String str2, List<String> list, String str3, zzei zzeiVar) {
        if (zzcjVar == com.google.android.gms.internal.measurement.zzcj.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzcjVar != com.google.android.gms.internal.measurement.zzcj.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        com.google.android.gms.internal.measurement.zzcc zzccVar = com.google.android.gms.internal.measurement.zzcc.UNKNOWN_COMPARISON_TYPE;
        switch (zzcjVar.ordinal()) {
            case 1:
                if (str3 != null) {
                    try {
                        break;
                    } catch (PatternSyntaxException unused) {
                        if (zzeiVar != null) {
                            zzeiVar.zze().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                        }
                        return null;
                    }
                }
                break;
            case 6:
                if (list != null) {
                    break;
                }
                break;
        }
        return null;
    }

    static Boolean zze(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    static Boolean zzf(String str, com.google.android.gms.internal.measurement.zzck zzckVar, zzei zzeiVar) {
        List<String> list;
        Preconditions.checkNotNull(zzckVar);
        if (str == null || !zzckVar.zza() || zzckVar.zzb() == com.google.android.gms.internal.measurement.zzcj.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        com.google.android.gms.internal.measurement.zzcj zzcjVarZzb = zzckVar.zzb();
        com.google.android.gms.internal.measurement.zzcj zzcjVar = com.google.android.gms.internal.measurement.zzcj.IN_LIST;
        if (zzcjVarZzb == zzcjVar) {
            if (zzckVar.zzh() == 0) {
                return null;
            }
        } else if (!zzckVar.zzc()) {
            return null;
        }
        com.google.android.gms.internal.measurement.zzcj zzcjVarZzb2 = zzckVar.zzb();
        boolean zZzf = zzckVar.zzf();
        String strZzd = (zZzf || zzcjVarZzb2 == com.google.android.gms.internal.measurement.zzcj.REGEXP || zzcjVarZzb2 == zzcjVar) ? zzckVar.zzd() : zzckVar.zzd().toUpperCase(Locale.ENGLISH);
        if (zzckVar.zzh() == 0) {
            list = null;
        } else {
            List<String> listZzg = zzckVar.zzg();
            if (!zZzf) {
                ArrayList arrayList = new ArrayList(listZzg.size());
                Iterator<String> it = listZzg.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                listZzg = Collections.unmodifiableList(arrayList);
            }
            list = listZzg;
        }
        return zzd(str, zzcjVarZzb2, zZzf, strZzd, list, zzcjVarZzb2 == com.google.android.gms.internal.measurement.zzcj.REGEXP ? strZzd : null, zzeiVar);
    }

    static Boolean zzg(long j, com.google.android.gms.internal.measurement.zzcd zzcdVar) {
        try {
            return zzj(new BigDecimal(j), zzcdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzh(double d, com.google.android.gms.internal.measurement.zzcd zzcdVar) {
        try {
            return zzj(new BigDecimal(d), zzcdVar, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzi(String str, com.google.android.gms.internal.measurement.zzcd zzcdVar) {
        if (!zzkf.zzl(str)) {
            return null;
        }
        try {
            return zzj(new BigDecimal(str), zzcdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzj(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzcd zzcdVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzcdVar);
        if (zzcdVar.zza() && zzcdVar.zzb() != com.google.android.gms.internal.measurement.zzcc.UNKNOWN_COMPARISON_TYPE) {
            com.google.android.gms.internal.measurement.zzcc zzccVarZzb = zzcdVar.zzb();
            com.google.android.gms.internal.measurement.zzcc zzccVar = com.google.android.gms.internal.measurement.zzcc.BETWEEN;
            if (zzccVarZzb == zzccVar) {
                if (!zzcdVar.zzg() || !zzcdVar.zzi()) {
                    return null;
                }
            } else if (!zzcdVar.zze()) {
                return null;
            }
            com.google.android.gms.internal.measurement.zzcc zzccVarZzb2 = zzcdVar.zzb();
            if (zzcdVar.zzb() == zzccVar) {
                if (zzkf.zzl(zzcdVar.zzh()) && zzkf.zzl(zzcdVar.zzj())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzcdVar.zzh());
                        bigDecimal4 = new BigDecimal(zzcdVar.zzj());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!zzkf.zzl(zzcdVar.zzf())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzcdVar.zzf());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (zzccVarZzb2 == zzccVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 == null) {
                return null;
            }
            com.google.android.gms.internal.measurement.zzcj zzcjVar = com.google.android.gms.internal.measurement.zzcj.UNKNOWN_MATCH_TYPE;
            int iOrdinal = zzccVarZzb2.ordinal();
            if (iOrdinal == 1) {
                if (bigDecimal2 == null) {
                    return null;
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == -1);
            }
            if (iOrdinal == 2) {
                if (bigDecimal2 == null) {
                    return null;
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 1);
            }
            if (iOrdinal != 3) {
                if (iOrdinal != 4 || bigDecimal3 == null) {
                    return null;
                }
                if (bigDecimal.compareTo(bigDecimal3) != -1 && bigDecimal.compareTo(bigDecimal4) != 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            if (bigDecimal2 == null) {
                return null;
            }
            if (d == 0.0d) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            }
            if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return null;
    }

    abstract int zza();

    abstract boolean zzb();

    abstract boolean zzc();
}
