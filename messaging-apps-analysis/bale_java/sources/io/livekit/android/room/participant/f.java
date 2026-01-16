package io.livekit.android.room.participant;

import io.livekit.android.room.participant.Participant;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.Q12;

/* loaded from: classes3.dex */
public final class f {
    private final String a;
    private final String b;
    private final String c;
    private final long d;

    public /* synthetic */ f(String str, String str2, String str3, long j, ED1 ed1) {
        this(str, str2, str3, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return AbstractC13042fc3.d(this.a, fVar.a) && Participant.Identity.d(this.b, fVar.b) && AbstractC13042fc3.d(this.c, fVar.c) && Q12.u(this.d, fVar.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + Participant.Identity.e(this.b)) * 31) + this.c.hashCode()) * 31) + Q12.J(this.d);
    }

    public String toString() {
        return "RpcInvocationData(requestId=" + this.a + ", callerIdentity=" + ((Object) Participant.Identity.f(this.b)) + ", payload=" + this.c + ", responseTimeout=" + ((Object) Q12.S(this.d)) + ')';
    }

    private f(String str, String str2, String str3, long j) {
        AbstractC13042fc3.i(str, "requestId");
        AbstractC13042fc3.i(str2, "callerIdentity");
        AbstractC13042fc3.i(str3, "payload");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }
}
