package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodecInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessagesController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class qv {
    public static final /* synthetic */ int a = 0;
    private static final Pattern b = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<qp, List<qg>> c = new HashMap<>();
    private static int d = -1;

    public static qg a() throws qq {
        return f("audio/raw");
    }

    public static synchronized List<qg> b(String str, boolean z, boolean z2) throws qq {
        qp qpVar = new qp(str, z, z2);
        HashMap<qp, List<qg>> map = c;
        List<qg> list = map.get(qpVar);
        if (list != null) {
            return list;
        }
        int i = aeu.a;
        ArrayList<qg> arrayListG = g(qpVar, i >= 21 ? new qt(z, z2) : new qs(null));
        if (z && arrayListG.isEmpty() && i >= 21 && i <= 23) {
            arrayListG = g(qpVar, new qs(null));
            if (!arrayListG.isEmpty()) {
                String str2 = arrayListG.get(0).a;
                StringBuilder sb = new StringBuilder(str.length() + 63 + str2.length());
                sb.append("MediaCodecList API didn't list secure decoder for: ");
                sb.append(str);
                sb.append(". Assuming: ");
                sb.append(str2);
                Log.w("MediaCodecUtil", sb.toString());
            }
        }
        if ("audio/raw".equals(str)) {
            if (i < 26 && aeu.b.equals("R9") && arrayListG.size() == 1 && arrayListG.get(0).a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayListG.add(qg.a("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            i(arrayListG, qm.a);
        }
        if (i < 21 && arrayListG.size() > 1) {
            String str3 = arrayListG.get(0).a;
            if ("OMX.SEC.mp3.dec".equals(str3) || "OMX.SEC.MP3.Decoder".equals(str3) || "OMX.brcm.audio.mp3.decoder".equals(str3)) {
                i(arrayListG, qn.a);
            }
        }
        if (i < 30 && arrayListG.size() > 1 && "OMX.qti.audio.decoder.flac".equals(arrayListG.get(0).a)) {
            arrayListG.add(arrayListG.remove(0));
        }
        List<qg> listUnmodifiableList = Collections.unmodifiableList(arrayListG);
        map.put(qpVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static List<qg> c(List<qg> list, final cy cyVar) {
        ArrayList arrayList = new ArrayList(list);
        i(arrayList, new qu(cyVar) { // from class: com.google.ads.interactivemedia.v3.internal.ql
            private final cy a;

            {
                this.a = cyVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.qu
            public final int a(Object obj) {
                cy cyVar2 = this.a;
                qg qgVar = (qg) obj;
                int i = qv.a;
                try {
                    return !qgVar.c(cyVar2) ? 0 : 1;
                } catch (qq unused) {
                    return -1;
                }
            }
        });
        return arrayList;
    }

    public static int d() throws qq {
        int i;
        if (d == -1) {
            qg qgVarF = f(MediaController.VIDEO_MIME_TYPE);
            int iMax = 0;
            if (qgVarF != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrB = qgVarF.b();
                int length = codecProfileLevelArrB.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i2 = codecProfileLevelArrB[iMax].level;
                    if (i2 != 1 && i2 != 2) {
                        switch (i2) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM /* 16384 */:
                                i = 5652480;
                                break;
                            case 32768:
                            case MessagesController.UPDATE_MASK_CHECK /* 65536 */:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    iMax2 = Math.max(i, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, aeu.a >= 21 ? 345600 : 172800);
            }
            d = iMax;
        }
        return d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02e3 A[Catch: NumberFormatException -> 0x02f2, TRY_LEAVE, TryCatch #1 {NumberFormatException -> 0x02f2, blocks: (B:167:0x0289, B:169:0x029b, B:180:0x02b7, B:195:0x02e3), top: B:552:0x0289 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> e(com.google.ads.interactivemedia.v3.internal.cy r18) {
        /*
            Method dump skipped, instructions count: 2730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.qv.e(com.google.ads.interactivemedia.v3.internal.cy):android.util.Pair");
    }

    public static qg f(String str) throws qq {
        List<qg> listB = b(str, false, false);
        if (listB.isEmpty()) {
            return null;
        }
        return listB.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0291 A[Catch: Exception -> 0x0346, TryCatch #1 {Exception -> 0x0346, blocks: (B:157:0x0260, B:163:0x0277, B:169:0x028b, B:171:0x0291, B:176:0x029f, B:178:0x02a7, B:189:0x02d3, B:191:0x02dd, B:193:0x02e5, B:195:0x02ed, B:200:0x02fa, B:203:0x0300, B:179:0x02ac, B:181:0x02bc, B:183:0x02c4, B:172:0x0296), top: B:232:0x0260 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0296 A[Catch: Exception -> 0x0346, TryCatch #1 {Exception -> 0x0346, blocks: (B:157:0x0260, B:163:0x0277, B:169:0x028b, B:171:0x0291, B:176:0x029f, B:178:0x02a7, B:189:0x02d3, B:191:0x02dd, B:193:0x02e5, B:195:0x02ed, B:200:0x02fa, B:203:0x0300, B:179:0x02ac, B:181:0x02bc, B:183:0x02c4, B:172:0x0296), top: B:232:0x0260 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a7 A[Catch: Exception -> 0x0346, TryCatch #1 {Exception -> 0x0346, blocks: (B:157:0x0260, B:163:0x0277, B:169:0x028b, B:171:0x0291, B:176:0x029f, B:178:0x02a7, B:189:0x02d3, B:191:0x02dd, B:193:0x02e5, B:195:0x02ed, B:200:0x02fa, B:203:0x0300, B:179:0x02ac, B:181:0x02bc, B:183:0x02c4, B:172:0x0296), top: B:232:0x0260 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02ac A[Catch: Exception -> 0x0346, TryCatch #1 {Exception -> 0x0346, blocks: (B:157:0x0260, B:163:0x0277, B:169:0x028b, B:171:0x0291, B:176:0x029f, B:178:0x02a7, B:189:0x02d3, B:191:0x02dd, B:193:0x02e5, B:195:0x02ed, B:200:0x02fa, B:203:0x0300, B:179:0x02ac, B:181:0x02bc, B:183:0x02c4, B:172:0x0296), top: B:232:0x0260 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02d3 A[Catch: Exception -> 0x0346, TryCatch #1 {Exception -> 0x0346, blocks: (B:157:0x0260, B:163:0x0277, B:169:0x028b, B:171:0x0291, B:176:0x029f, B:178:0x02a7, B:189:0x02d3, B:191:0x02dd, B:193:0x02e5, B:195:0x02ed, B:200:0x02fa, B:203:0x0300, B:179:0x02ac, B:181:0x02bc, B:183:0x02c4, B:172:0x0296), top: B:232:0x0260 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList<com.google.ads.interactivemedia.v3.internal.qg> g(com.google.ads.interactivemedia.v3.internal.qp r24, com.google.ads.interactivemedia.v3.internal.qr r25) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 970
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.qv.g(com.google.ads.interactivemedia.v3.internal.qp, com.google.ads.interactivemedia.v3.internal.qr):java.util.ArrayList");
    }

    private static boolean h(MediaCodecInfo mediaCodecInfo) {
        if (aeu.a >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        String strC = aeu.C(mediaCodecInfo.getName());
        if (strC.startsWith("arc.")) {
            return false;
        }
        return strC.startsWith("omx.google.") || strC.startsWith("omx.ffmpeg.") || (strC.startsWith("omx.sec.") && strC.contains(".sw.")) || strC.equals("omx.qcom.video.decoder.hevcswvdec") || strC.startsWith("c2.android.") || strC.startsWith("c2.google.") || !(strC.startsWith("omx.") || strC.startsWith("c2."));
    }

    private static <T> void i(List<T> list, final qu<T> quVar) {
        Collections.sort(list, new Comparator(quVar) { // from class: com.google.ads.interactivemedia.v3.internal.qo
            private final qu a;

            {
                this.a = quVar;
            }

            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                qu quVar2 = this.a;
                int i = qv.a;
                return quVar2.a(obj2) - quVar2.a(obj);
            }
        });
    }
}
