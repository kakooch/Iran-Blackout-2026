package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import com.google.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.uB1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC21818uB1 {
    private static final char[] b;
    private static final char[] d;
    private static final char[] a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* renamed from: ir.nasim.uB1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: ir.nasim.uB1$b */
    private enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        b = cArr;
        d = cArr;
    }

    static LB1 a(byte[] bArr) throws FormatException {
        C5875Lf0 c5875Lf0 = new C5875Lf0(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVarC = b.ASCII_ENCODE;
        do {
            b bVar = b.ASCII_ENCODE;
            if (bVarC == bVar) {
                bVarC = c(c5875Lf0, sb, sb2);
            } else {
                int i = a.a[bVarC.ordinal()];
                if (i == 1) {
                    e(c5875Lf0, sb);
                } else if (i == 2) {
                    g(c5875Lf0, sb);
                } else if (i == 3) {
                    b(c5875Lf0, sb);
                } else if (i == 4) {
                    f(c5875Lf0, sb);
                } else {
                    if (i != 5) {
                        throw FormatException.a();
                    }
                    d(c5875Lf0, sb, arrayList);
                }
                bVarC = bVar;
            }
            if (bVarC == b.PAD_ENCODE) {
                break;
            }
        } while (c5875Lf0.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new LB1(bArr, string, arrayList, null);
    }

    private static void b(C5875Lf0 c5875Lf0, StringBuilder sb) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        while (c5875Lf0.a() != 8 && (iD = c5875Lf0.d(8)) != 254) {
            h(iD, c5875Lf0.d(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append('\r');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append('>');
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else {
                    if (i2 >= 40) {
                        throw FormatException.a();
                    }
                    sb.append((char) (i2 + 51));
                }
            }
            if (c5875Lf0.a() <= 0) {
                return;
            }
        }
    }

    private static b c(C5875Lf0 c5875Lf0, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int iD = c5875Lf0.d(8);
            if (iD == 0) {
                throw FormatException.a();
            }
            if (iD > 128) {
                if (iD != 129) {
                    if (iD > 229) {
                        switch (iD) {
                            case SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER /* 230 */:
                                return b.C40_ENCODE;
                            case 231:
                                return b.BASE256_ENCODE;
                            case 232:
                                sb.append((char) 29);
                                break;
                            case SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER /* 233 */:
                            case SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER /* 234 */:
                            case 241:
                                break;
                            case SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER /* 235 */:
                                z = true;
                                break;
                            case 236:
                                sb.append("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                sb.append("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER /* 238 */:
                                return b.ANSIX12_ENCODE;
                            case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER /* 239 */:
                                return b.TEXT_ENCODE;
                            case SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER /* 240 */:
                                return b.EDIFACT_ENCODE;
                            default:
                                if (iD != 254 || c5875Lf0.a() != 0) {
                                    throw FormatException.a();
                                }
                                break;
                        }
                    } else {
                        int i = iD - 130;
                        if (i < 10) {
                            sb.append('0');
                        }
                        sb.append(i);
                    }
                } else {
                    return b.PAD_ENCODE;
                }
            } else {
                if (z) {
                    iD += 128;
                }
                sb.append((char) (iD - 1));
                return b.ASCII_ENCODE;
            }
        } while (c5875Lf0.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static void d(C5875Lf0 c5875Lf0, StringBuilder sb, Collection collection) throws FormatException {
        int iC = c5875Lf0.c();
        int i = iC + 2;
        int i2 = i(c5875Lf0.d(8), iC + 1);
        if (i2 == 0) {
            i2 = c5875Lf0.a() / 8;
        } else if (i2 >= 250) {
            i2 = ((i2 - 249) * Type.TSIG) + i(c5875Lf0.d(8), i);
            i = iC + 3;
        }
        if (i2 < 0) {
            throw FormatException.a();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            if (c5875Lf0.a() < 8) {
                throw FormatException.a();
            }
            bArr[i3] = (byte) i(c5875Lf0.d(8), i);
            i3++;
            i++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e2)));
        }
    }

    private static void e(C5875Lf0 c5875Lf0, StringBuilder sb) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (c5875Lf0.a() != 8 && (iD = c5875Lf0.d(8)) != 254) {
            h(iD, c5875Lf0.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = b;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.a();
                                }
                                z = true;
                            }
                            i = 0;
                        } else {
                            if (i != 3) {
                                throw FormatException.a();
                            }
                            if (z) {
                                sb.append((char) (i3 + 224));
                                z = false;
                                i = 0;
                            } else {
                                sb.append((char) (i3 + 96));
                                i = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i3 + 128));
                        z = false;
                        i = 0;
                    } else {
                        sb.append((char) i3);
                        i = 0;
                    }
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr2 = a;
                    if (i3 >= cArr2.length) {
                        throw FormatException.a();
                    }
                    char c3 = cArr2[i3];
                    if (z) {
                        sb.append((char) (c3 + 128));
                        z = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (c5875Lf0.a() <= 0) {
                return;
            }
        }
    }

    private static void f(C5875Lf0 c5875Lf0, StringBuilder sb) {
        while (c5875Lf0.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int iD = c5875Lf0.d(6);
                if (iD == 31) {
                    int iB = 8 - c5875Lf0.b();
                    if (iB != 8) {
                        c5875Lf0.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                sb.append((char) iD);
            }
            if (c5875Lf0.a() <= 0) {
                return;
            }
        }
    }

    private static void g(C5875Lf0 c5875Lf0, StringBuilder sb) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (c5875Lf0.a() != 8 && (iD = c5875Lf0.d(8)) != 254) {
            h(iD, c5875Lf0.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = d;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.a();
                                }
                                z = true;
                            }
                            i = 0;
                        } else {
                            if (i != 3) {
                                throw FormatException.a();
                            }
                            char[] cArr2 = e;
                            if (i3 >= cArr2.length) {
                                throw FormatException.a();
                            }
                            char c3 = cArr2[i3];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                                i = 0;
                            } else {
                                sb.append(c3);
                                i = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i3 + 128));
                        z = false;
                        i = 0;
                    } else {
                        sb.append((char) i3);
                        i = 0;
                    }
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr3 = c;
                    if (i3 >= cArr3.length) {
                        throw FormatException.a();
                    }
                    char c4 = cArr3[i3];
                    if (z) {
                        sb.append((char) (c4 + 128));
                        z = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (c5875Lf0.a() <= 0) {
                return;
            }
        }
    }

    private static void h(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static int i(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
