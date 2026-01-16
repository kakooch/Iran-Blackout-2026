package ir.nasim;

import android.content.Context;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class TM extends C24967zW1 {
    public static final a q = new a(null);
    public static final int r = 8;
    private boolean i;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private byte[] o;
    private long p;

    public static final class a {
        private a() {
        }

        public final TM a(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, C22694vg2 c22694vg2, byte[] bArr, int i2) {
            AbstractC13042fc3.i(str, "descriptor");
            AbstractC13042fc3.i(str2, "fileName");
            return new TM(new C8540Wk1(new GG3(str2, str, str3, i, "audio/mp3", str4, str5, str6, str7, c22694vg2 != null ? new RG3(c22694vg2) : null, bArr, i2)));
        }

        public final TM b(FileReference fileReference, ArrayList arrayList, String str, String str2, String str3, String str4, C22694vg2 c22694vg2, byte[] bArr, int i) {
            AbstractC13042fc3.i(fileReference, "reference");
            AbstractC13042fc3.i(arrayList, "mentions");
            AbstractC13042fc3.i(str, "artist");
            AbstractC13042fc3.i(str2, "album");
            AbstractC13042fc3.i(str3, "track");
            AbstractC13042fc3.i(str4, "genre");
            long fileId = fileReference.getFileId();
            long accessHash = fileReference.getAccessHash();
            int fileSize = fileReference.getFileSize();
            String fileName = fileReference.getFileName();
            C11413cy c11413cy = c22694vg2 != null ? new C11413cy(c22694vg2.d(), c22694vg2.b(), c22694vg2.c(), null) : null;
            C4617Fx c4617Fx = new C4617Fx(i, str2, str, str4, str3, bArr);
            String caption = fileReference.getCaption();
            return new TM(new C11909dl1(new C6035Lx(fileId, accessHash, fileSize, fileName, "audio/mp3", c11413cy, c4617Fx, caption != null ? new ZC(caption, arrayList, null, null) : null, "checksum", "algorithm", fileReference.getFileStorageVersion(), null, null)));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TM(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "contentLocalContainer");
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalAudio");
        GG3 gg3 = (GG3) abstractC19230q0C;
        this.n = gg3.D();
        this.j = gg3.z();
        this.k = gg3.y();
        this.l = gg3.F();
        this.m = gg3.E();
        this.o = gg3.C();
        this.p = Math.round(gg3.getFileSize());
    }

    public static final TM B(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, C22694vg2 c22694vg2, byte[] bArr, int i2) {
        return q.a(str, str2, str3, i, str4, str5, str6, str7, c22694vg2, bArr, i2);
    }

    public static final TM C(FileReference fileReference, ArrayList arrayList, String str, String str2, String str3, String str4, C22694vg2 c22694vg2, byte[] bArr, int i) {
        return q.b(fileReference, arrayList, str, str2, str3, str4, c22694vg2, bArr, i);
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

    public final String D() {
        return this.k;
    }

    public final String E() {
        return this.j;
    }

    public final byte[] F() {
        return this.o;
    }

    public final int G() {
        return this.n;
    }

    public final String I() {
        return this.m;
    }

    public final boolean J() {
        return this.i;
    }

    public final String K() {
        return this.l;
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.message_holder_content_audio);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    @Override // ir.nasim.C24967zW1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TM) || !super.equals(obj)) {
            return false;
        }
        TM tm = (TM) obj;
        if (this.i != tm.i || !AbstractC13042fc3.d(this.j, tm.j) || !AbstractC13042fc3.d(this.k, tm.k) || !AbstractC13042fc3.d(this.l, tm.l) || !AbstractC13042fc3.d(this.m, tm.m) || this.n != tm.n) {
            return false;
        }
        byte[] bArr = this.o;
        if (bArr != null) {
            byte[] bArr2 = tm.o;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (tm.o != null) {
            return false;
        }
        return this.p == tm.p;
    }

    @Override // ir.nasim.C24967zW1
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + Boolean.hashCode(this.i)) * 31;
        String str = this.j;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.k;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.l;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.m;
        int iHashCode5 = (((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.n) * 31;
        byte[] bArr = this.o;
        return ((iHashCode5 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + Long.hashCode(this.p);
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        int i = AbstractC12217eE5.media_music;
        String strY = y();
        AbstractC13042fc3.h(strY, "getName(...)");
        String strU = u();
        AbstractC13042fc3.h(strU, "getExt(...)");
        String strA = super.A(context, i, AbstractC20153rZ6.M(strY, strU, "", false, 4, null) + this.j + H(context, this.n) + C10082b3.b(context, Long.valueOf(this.p)));
        AbstractC13042fc3.h(strA, "getTypeAndCaptionContentDescription(...)");
        return strA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TM(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentRemoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiDocumentMessage");
        C4617Fx c4617Fx = (C4617Fx) ((C6035Lx) abstractC24063xzC).w();
        if (c4617Fx != null) {
            this.n = c4617Fx.z();
            this.j = c4617Fx.w();
            this.k = c4617Fx.u();
            this.l = c4617Fx.D();
            this.m = c4617Fx.C();
            this.o = c4617Fx.y();
            this.p = Math.round(r5.getFileSize());
        } else {
            this.i = true;
        }
        if (this.o == null) {
            this.i = true;
        }
    }
}
