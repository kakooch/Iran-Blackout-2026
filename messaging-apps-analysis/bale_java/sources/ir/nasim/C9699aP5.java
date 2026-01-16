package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.aP5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9699aP5 extends C14566i74 {
    private final AbstractC6544Ny5 s;

    public /* synthetic */ C9699aP5(AbstractC6544Ny5 abstractC6544Ny5, long j, long j2, String str, String str2, AbstractC24063xz abstractC24063xz, String str3, C11458d25 c11458d25, String str4, long j3, String str5, long j4, String str6, String str7, int i, int i2, ED1 ed1) {
        this(abstractC6544Ny5, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0L : j2, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? null : abstractC24063xz, (i2 & 64) != 0 ? null : str3, c11458d25, (i2 & 256) != 0 ? "" : str4, (i2 & 512) != 0 ? 0L : j3, (i2 & 1024) != 0 ? null : str5, (i2 & 2048) != 0 ? 0L : j4, str6, (i2 & 8192) != 0 ? "" : str7, i);
    }

    @Override // ir.nasim.C14566i74, ir.nasim.AbstractC4398Ey5
    public AbstractC6544Ny5 d() {
        return this.s;
    }

    @Override // ir.nasim.C14566i74
    public String toString() {
        return "ReplyPushNotification(sourceType = " + d() + Separators.RPAREN;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9699aP5(AbstractC6544Ny5 abstractC6544Ny5, long j, long j2, String str, String str2, AbstractC24063xz abstractC24063xz, String str3, C11458d25 c11458d25, String str4, long j3, String str5, long j4, String str6, String str7, int i) {
        super(abstractC6544Ny5, j, j2, str, str2, abstractC24063xz, str3, c11458d25, str4, j3, str5, j4, str6, str7, null, i, 16384, null);
        AbstractC13042fc3.i(abstractC6544Ny5, "sourceType");
        AbstractC13042fc3.i(str, "messageRid");
        AbstractC13042fc3.i(str2, "peerUserId");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str4, "title");
        AbstractC13042fc3.i(str6, ParameterNames.TEXT);
        AbstractC13042fc3.i(str7, "peerType");
        this.s = abstractC6544Ny5;
        q(EnumC13889gz5.i);
    }
}
