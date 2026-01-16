package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.C9475a16;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class J08 extends C24967zW1 {
    public static final a l = new a(null);
    public static final int m = 8;
    private static final InterfaceC9173Yu3 n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.H08
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return J08.K();
        }
    });
    private int i;
    private long j;
    private VoiceTranscript k;

    public static final class a {
        private a() {
        }

        public final J08 a(J08 j08, VoiceTranscript c10071b18) {
            AbstractC13042fc3.i(j08, "old");
            AbstractC13042fc3.i(c10071b18, "voiceTranscript");
            InterfaceC18505om2 interfaceC18505om2 = j08.c;
            if (interfaceC18505om2 instanceof C4512Fl2) {
                String str = j08.e;
                InterfaceC18505om2 interfaceC18505om22 = j08.c;
                C4512Fl2 c4512Fl2 = interfaceC18505om22 instanceof C4512Fl2 ? (C4512Fl2) interfaceC18505om22 : null;
                String str2 = c4512Fl2 != null ? c4512Fl2.c : null;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = str2;
                C23345wl7 c23345wl7T = j08.t();
                String strV = c23345wl7T != null ? c23345wl7T.v() : null;
                int I = (int) j08.I();
                String str4 = j08.d;
                if (str4 == null) {
                    str4 = "audio/ogg; codecs=opus";
                }
                int iG = j08.G();
                AbstractC11279ck3 abstractC11279ck3D = d();
                abstractC11279ck3D.a();
                return new J08(new C8540Wk1(new BH3(str, str3, strV, I, str4, iG, abstractC11279ck3D.c(VoiceTranscript.INSTANCE.serializer(), c10071b18))));
            }
            if (!(interfaceC18505om2 instanceof C11920dm2)) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC18048o0 abstractC18048o0I = j08.i();
            AbstractC13042fc3.g(abstractC18048o0I, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.ContentRemoteContainer");
            AbstractC24063xz abstractC24063xzC = ((C11909dl1) abstractC18048o0I).c();
            AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiDocumentMessage");
            C6035Lx c6035Lx = (C6035Lx) abstractC24063xzC;
            long fileId = c6035Lx.getFileId();
            long accessHash = c6035Lx.getAccessHash();
            int fileSize = c6035Lx.getFileSize();
            String name = c6035Lx.getName();
            String strZ = c6035Lx.z();
            int iG2 = j08.G();
            AbstractC11279ck3 abstractC11279ck3D2 = J08.l.d();
            abstractC11279ck3D2.a();
            C5802Kx c5802Kx = new C5802Kx(iG2, abstractC11279ck3D2.c(VoiceTranscript.INSTANCE.serializer(), c10071b18));
            ZC zcU = c6035Lx.u();
            return new J08(new C11909dl1(new C6035Lx(fileId, accessHash, fileSize, name, strZ, null, c5802Kx, zcU != null ? new ZC(zcU.z(), zcU.w(), zcU.u(), null) : null, "checksum", "algorithm", c6035Lx.getFileStorageVersion(), null, null)));
        }

        public final J08 b(String str, String str2, String str3, int i, int i2) {
            AbstractC13042fc3.i(str, "descriptor");
            AbstractC13042fc3.i(str2, "fileName");
            return new J08(new C8540Wk1(new BH3(str2, str, str3, i, "audio/ogg; codecs=opus", i2, null)));
        }

        public final J08 c(FileReference fileReference, ArrayList arrayList, int i, String str, String str2) {
            AbstractC13042fc3.i(fileReference, "reference");
            AbstractC13042fc3.i(arrayList, "mentions");
            long fileId = fileReference.getFileId();
            long accessHash = fileReference.getAccessHash();
            int fileSize = fileReference.getFileSize();
            String fileName = fileReference.getFileName();
            String str3 = str2 == null ? "audio/ogg; codecs=opus" : str2;
            C5802Kx c5802Kx = new C5802Kx(i, str);
            String caption = fileReference.getCaption();
            return new J08(new C11909dl1(new C6035Lx(fileId, accessHash, fileSize, fileName, str3, null, c5802Kx, caption != null ? new ZC(caption, arrayList, null, null) : null, "checksum", "algorithm", fileReference.getFileStorageVersion(), null, null)));
        }

        public final AbstractC11279ck3 d() {
            return (AbstractC11279ck3) J08.n.getValue();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J08(C8540Wk1 c8540Wk1) {
        Object objB;
        VoiceTranscript c10071b18;
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "contentLocalContainer");
        this.k = new VoiceTranscript((EnumC9477a18) null, (String) null, false, 7, (ED1) null);
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalVoice");
        BH3 bh3 = (BH3) abstractC19230q0C;
        this.j = Math.round(bh3.getFileSize());
        this.i = bh3.y();
        try {
            C9475a16.a aVar = C9475a16.b;
            String strZ = bh3.z();
            if (strZ != null) {
                AbstractC11279ck3 abstractC11279ck3D = l.d();
                abstractC11279ck3D.a();
                c10071b18 = (VoiceTranscript) abstractC11279ck3D.b(VoiceTranscript.INSTANCE.serializer(), strZ);
            } else {
                c10071b18 = null;
            }
            objB = C9475a16.b(c10071b18);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        VoiceTranscript c10071b182 = (VoiceTranscript) (C9475a16.g(objB) ? null : objB);
        if (c10071b182 != null) {
            this.k = c10071b182;
        }
    }

    public static final J08 E(String str, String str2, String str3, int i, int i2) {
        return l.b(str, str2, str3, i, i2);
    }

    public static final J08 F(FileReference fileReference, ArrayList arrayList, int i, String str, String str2) {
        return l.c(fileReference, arrayList, i, str, str2);
    }

    private final String H(Context context, long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(j);
        long j2 = 60;
        long minutes = timeUnit.toMinutes(j) % j2;
        long seconds = timeUnit.toSeconds(j) % j2;
        if (hours != 0) {
            String string = minutes != 0 ? context.getString(AbstractC12217eE5.time_duration_hours_minutes, Long.valueOf(hours), Long.valueOf(minutes)) : context.getString(AbstractC12217eE5.time_duration_hours, Long.valueOf(hours));
            AbstractC13042fc3.f(string);
            return string;
        }
        if (minutes != 0) {
            String string2 = seconds != 0 ? context.getString(AbstractC12217eE5.time_duration_minutes_seconds, Long.valueOf(minutes), Long.valueOf(seconds)) : context.getString(AbstractC12217eE5.time_duration_minutes, Long.valueOf(minutes));
            AbstractC13042fc3.f(string2);
            return string2;
        }
        String string3 = context.getString(AbstractC12217eE5.time_duration_seconds, Long.valueOf(seconds));
        AbstractC13042fc3.f(string3);
        return string3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC11279ck3 K() {
        return AbstractC4987Hk3.b(null, new UA2() { // from class: ir.nasim.I08
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return J08.L((C14333hk3) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(C14333hk3 c14333hk3) {
        AbstractC13042fc3.i(c14333hk3, "$this$Json");
        c14333hk3.d(true);
        return C19938rB7.a;
    }

    public final int G() {
        return this.i;
    }

    public final long I() {
        return this.j;
    }

    public final VoiceTranscript J() {
        return this.k;
    }

    public final String M(String str, Context context) {
        AbstractC13042fc3.i(str, "original");
        AbstractC13042fc3.i(context, "context");
        String str2 = H(context, this.i) + C10082b3.b(context, Long.valueOf(this.j));
        String string = context.getString(AbstractC12217eE5.media_audio);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = context.getString(AbstractC12217eE5.chat_fragment_has_caption_content_description);
        VoiceTranscript c10071b18 = this.k;
        return AbstractC20153rZ6.M(str, j(context), string + Separators.SP + str2 + Separators.SP + string2 + Separators.SP + (c10071b18 != null ? c10071b18.getVoiceTranscript() : null), false, 4, null);
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.message_holder_content_voice);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    @Override // ir.nasim.C24967zW1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(J08.class, obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.VoiceContent");
        J08 j08 = (J08) obj;
        return this.i == j08.i && this.j == j08.j && AbstractC13042fc3.d(this.k, j08.k);
    }

    @Override // ir.nasim.C24967zW1
    public int hashCode() {
        return (((((super.hashCode() * 31) + this.i) * 31) + Long.hashCode(this.j)) * 31) + this.k.hashCode();
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        String strA = super.A(context, AbstractC12217eE5.media_audio, H(context, this.i) + C10082b3.b(context, Long.valueOf(this.j)));
        AbstractC13042fc3.h(strA, "getTypeAndCaptionContentDescription(...)");
        return strA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J08(C11909dl1 c11909dl1) {
        Object objB;
        VoiceTranscript c10071b18;
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentRemoteContainer");
        this.k = new VoiceTranscript((EnumC9477a18) null, (String) null, false, 7, (ED1) null);
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiDocumentMessage");
        C5802Kx c5802Kx = (C5802Kx) ((C6035Lx) abstractC24063xzC).w();
        if (c5802Kx != null) {
            this.j = Math.round(r8.getFileSize());
            this.i = c5802Kx.u();
            try {
                C9475a16.a aVar = C9475a16.b;
                String strW = c5802Kx.w();
                if (strW != null) {
                    AbstractC11279ck3 abstractC11279ck3D = l.d();
                    abstractC11279ck3D.a();
                    c10071b18 = (VoiceTranscript) abstractC11279ck3D.b(VoiceTranscript.INSTANCE.serializer(), strW);
                } else {
                    c10071b18 = null;
                }
                objB = C9475a16.b(c10071b18);
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            VoiceTranscript c10071b182 = (VoiceTranscript) (C9475a16.g(objB) ? null : objB);
            if (c10071b182 != null) {
                this.k = c10071b182;
            }
        }
    }
}
