package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Iz7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC5360Iz7 {
    public static final a a;
    public static final EnumC5360Iz7 b = new EnumC5360Iz7("NONE", 0);
    public static final EnumC5360Iz7 c = new EnumC5360Iz7("TEXT", 1);
    public static final EnumC5360Iz7 d = new EnumC5360Iz7("VOICE_RECORDING", 2);
    public static final EnumC5360Iz7 e = new EnumC5360Iz7("SENDING_VOICE", 3);
    public static final EnumC5360Iz7 f = new EnumC5360Iz7("SENDING_FILE", 4);
    public static final EnumC5360Iz7 g = new EnumC5360Iz7("SENDING_PHOTO", 5);
    public static final EnumC5360Iz7 h = new EnumC5360Iz7("SENDING_ALBUM", 6);
    public static final EnumC5360Iz7 i = new EnumC5360Iz7("SENDING_VIDEO", 7);
    public static final EnumC5360Iz7 j = new EnumC5360Iz7("SENDING_MUSIC", 8);
    public static final EnumC5360Iz7 k = new EnumC5360Iz7("CHOOSING_EMOJI", 9);
    public static final EnumC5360Iz7 l = new EnumC5360Iz7("CHOOSING_STICKER", 10);
    public static final EnumC5360Iz7 m = new EnumC5360Iz7("CHOOSING_GIF", 11);
    public static final EnumC5360Iz7 n = new EnumC5360Iz7("CREATING_GIFT_PACKET", 12);
    private static final /* synthetic */ EnumC5360Iz7[] o;
    private static final /* synthetic */ F92 p;

    /* renamed from: ir.nasim.Iz7$a */
    public static final class a {

        /* renamed from: ir.nasim.Iz7$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0427a {
            public static final /* synthetic */ int[] a;
            public static final /* synthetic */ int[] b;

            static {
                int[] iArr = new int[EnumC14020hD.values().length];
                try {
                    iArr[EnumC14020hD.UNKNOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC14020hD.UNSUPPORTED_VALUE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC14020hD.TEXT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC14020hD.VOICERECODRING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[EnumC14020hD.SENDINGVOICE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[EnumC14020hD.SENDINGFILE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[EnumC14020hD.SENDINGPHOTO.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[EnumC14020hD.SENDINGALBUM.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[EnumC14020hD.SENDINGVIDEO.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[EnumC14020hD.SENDINGMUSIC.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[EnumC14020hD.CHOOSINGSTICKER.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[EnumC14020hD.CHOSINGGIF.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[EnumC14020hD.CREATINGGIFTPACKET.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[EnumC14020hD.CHOSINGEMOJI.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                a = iArr;
                int[] iArr2 = new int[EnumC5025Ho5.values().length];
                try {
                    iArr2[EnumC5025Ho5.TypingType_UNKNOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr2[EnumC5025Ho5.UNRECOGNIZED.ordinal()] = 2;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_TEXT.ordinal()] = 3;
                } catch (NoSuchFieldError unused17) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_VOICERECODRING.ordinal()] = 4;
                } catch (NoSuchFieldError unused18) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_SENDINGVOICE.ordinal()] = 5;
                } catch (NoSuchFieldError unused19) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_SENDINGFILE.ordinal()] = 6;
                } catch (NoSuchFieldError unused20) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_SENDINGPHOTO.ordinal()] = 7;
                } catch (NoSuchFieldError unused21) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_SENDINGALBUM.ordinal()] = 8;
                } catch (NoSuchFieldError unused22) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_SENDINGVIDEO.ordinal()] = 9;
                } catch (NoSuchFieldError unused23) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_SENDINGMUSIC.ordinal()] = 10;
                } catch (NoSuchFieldError unused24) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_CHOOSINGSTICKER.ordinal()] = 11;
                } catch (NoSuchFieldError unused25) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_CHOSINGGIF.ordinal()] = 12;
                } catch (NoSuchFieldError unused26) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_CREATINGGIFTPACKET.ordinal()] = 13;
                } catch (NoSuchFieldError unused27) {
                }
                try {
                    iArr2[EnumC5025Ho5.TypingType_CHOSINGEMOJI.ordinal()] = 14;
                } catch (NoSuchFieldError unused28) {
                }
                b = iArr2;
            }
        }

        private a() {
        }

        public final EnumC5360Iz7 a(C24967zW1 c24967zW1) {
            AbstractC13042fc3.i(c24967zW1, "documentContent");
            return c24967zW1 instanceof C13388g85 ? EnumC5360Iz7.g : c24967zW1 instanceof GS7 ? EnumC5360Iz7.i : c24967zW1 instanceof J08 ? EnumC5360Iz7.e : c24967zW1 instanceof TM ? EnumC5360Iz7.j : c24967zW1 instanceof XG2 ? EnumC5360Iz7.b : EnumC5360Iz7.f;
        }

        public final EnumC5360Iz7 b(EnumC5025Ho5 enumC5025Ho5) {
            AbstractC13042fc3.i(enumC5025Ho5, "proto");
            switch (C0427a.b[enumC5025Ho5.ordinal()]) {
                case 1:
                case 2:
                    return EnumC5360Iz7.b;
                case 3:
                    return EnumC5360Iz7.c;
                case 4:
                    return EnumC5360Iz7.d;
                case 5:
                    return EnumC5360Iz7.e;
                case 6:
                    return EnumC5360Iz7.f;
                case 7:
                    return EnumC5360Iz7.g;
                case 8:
                    return EnumC5360Iz7.h;
                case 9:
                    return EnumC5360Iz7.i;
                case 10:
                    return EnumC5360Iz7.j;
                case 11:
                    return EnumC5360Iz7.l;
                case 12:
                    return EnumC5360Iz7.m;
                case 13:
                    return EnumC5360Iz7.n;
                case 14:
                    return EnumC5360Iz7.k;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Iz7$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5360Iz7.values().length];
            try {
                iArr[EnumC5360Iz7.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5360Iz7.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC5360Iz7.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC5360Iz7.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC5360Iz7.f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC5360Iz7.g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC5360Iz7.h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC5360Iz7.i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumC5360Iz7.j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EnumC5360Iz7.l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EnumC5360Iz7.m.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EnumC5360Iz7.n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[EnumC5360Iz7.k.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            a = iArr;
        }
    }

    static {
        EnumC5360Iz7[] enumC5360Iz7ArrA = a();
        o = enumC5360Iz7ArrA;
        p = G92.a(enumC5360Iz7ArrA);
        a = new a(null);
    }

    private EnumC5360Iz7(String str, int i2) {
    }

    private static final /* synthetic */ EnumC5360Iz7[] a() {
        return new EnumC5360Iz7[]{b, c, d, e, f, g, h, i, j, k, l, m, n};
    }

    public static final EnumC5360Iz7 j(C24967zW1 c24967zW1) {
        return a.a(c24967zW1);
    }

    public static EnumC5360Iz7 valueOf(String str) {
        return (EnumC5360Iz7) Enum.valueOf(EnumC5360Iz7.class, str);
    }

    public static EnumC5360Iz7[] values() {
        return (EnumC5360Iz7[]) o.clone();
    }

    public final int p() {
        return ordinal();
    }

    public final boolean q() {
        return this != b;
    }

    public final EnumC5025Ho5 r() {
        switch (b.a[ordinal()]) {
            case 1:
                return EnumC5025Ho5.TypingType_UNKNOWN;
            case 2:
                return EnumC5025Ho5.TypingType_TEXT;
            case 3:
                return EnumC5025Ho5.TypingType_VOICERECODRING;
            case 4:
                return EnumC5025Ho5.TypingType_SENDINGVOICE;
            case 5:
                return EnumC5025Ho5.TypingType_SENDINGFILE;
            case 6:
                return EnumC5025Ho5.TypingType_SENDINGPHOTO;
            case 7:
                return EnumC5025Ho5.TypingType_SENDINGALBUM;
            case 8:
                return EnumC5025Ho5.TypingType_SENDINGVIDEO;
            case 9:
                return EnumC5025Ho5.TypingType_SENDINGMUSIC;
            case 10:
                return EnumC5025Ho5.TypingType_CHOOSINGSTICKER;
            case 11:
                return EnumC5025Ho5.TypingType_CHOSINGGIF;
            case 12:
                return EnumC5025Ho5.TypingType_CREATINGGIFTPACKET;
            case 13:
                return EnumC5025Ho5.TypingType_CHOSINGEMOJI;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
