package ir.nasim;

import android.content.Context;
import ir.nasim.C23345wl7;

/* renamed from: ir.nasim.oP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18285oP1 extends AbstractC17457n0 {
    private static final a f = new a(null);
    private final EnumC18494ol1 c;
    private final String d;
    private final int e;

    /* renamed from: ir.nasim.oP1$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.oP1$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC18494ol1.values().length];
            try {
                iArr[EnumC18494ol1.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18494ol1.BANK_TRANSFER_MONEY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC18494ol1.BANK_REMAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC18494ol1.BANK_RECEIPT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC18494ol1.ORDER_CHARGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC18494ol1.PURCHASE_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC18494ol1.CROWDFUNDING_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC18494ol1.ORDER_BILL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumC18494ol1.BANK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EnumC18494ol1.DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EnumC18494ol1.DOCUMENT_PHOTO.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EnumC18494ol1.DOCUMENT_VIDEO.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[EnumC18494ol1.DOCUMENT_VOICE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[EnumC18494ol1.DOCUMENT_AUDIO.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[EnumC18494ol1.CONTACT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[EnumC18494ol1.LOCATION.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[EnumC18494ol1.STICKER.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_REGISTERED.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_CREATED.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_ADD.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_LEAVE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_KICK.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_AVATAR.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_AVATAR_REMOVED.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_TITLE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_TOPIC.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_ABOUT.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_JOINED.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_CALL_ENDED.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_VIDEO_CALL_ENDED.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_CALL_MISSED.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_BAM_LOGIN_REQUESTED.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[EnumC18494ol1.TEMPLATE.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[EnumC18494ol1.TEMPLATE_RESPONSE.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[EnumC18494ol1.GIFT_PACKET.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_GIFT_PACKET_OPENED.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[EnumC18494ol1.SERVICE_GIFT_PACKET_OPENED_COMPACT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C18285oP1(EnumC18494ol1 enumC18494ol1, String str, int i) {
        this(new C8540Wk1(new NG3(enumC18494ol1, str, i)));
        AbstractC13042fc3.i(enumC18494ol1, "contentType");
        AbstractC13042fc3.i(str, "dialogText");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String r(android.content.Context r16, int r17, ir.nasim.EnumC18494ol1 r18, java.lang.String r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 982
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18285oP1.r(android.content.Context, int, ir.nasim.ol1, java.lang.String, int, boolean):java.lang.String");
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return r(context, i, this.c, this.d, this.e, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C18285oP1.class, obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.DialogPreviewContent");
        C18285oP1 c18285oP1 = (C18285oP1) obj;
        return this.c == c18285oP1.c && AbstractC13042fc3.d(this.d, c18285oP1.d) && this.e == c18285oP1.e;
    }

    public int hashCode() {
        return (((((super.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e;
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return C23345wl7.a.c(C23345wl7.g, this.d, null, 2, null);
    }

    public final EnumC18494ol1 s() {
        return this.c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18285oP1(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "localContainer");
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalDialogPreviewContent");
        NG3 ng3 = (NG3) abstractC19230q0C;
        this.c = ng3.s();
        this.d = ng3.u();
        this.e = ng3.w();
    }
}
