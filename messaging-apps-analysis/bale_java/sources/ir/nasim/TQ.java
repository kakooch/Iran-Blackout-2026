package ir.nasim;

import java.util.List;

/* loaded from: classes5.dex */
public final class TQ {
    public static final a j = new a(null);
    public static final int k = 8;
    private final String a;
    private final SP b;
    private final boolean c;
    private final List d;
    private final SQ e;
    private final long f;
    private final SQ g;
    private final long h;
    private final List i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public TQ(String str, SP sp, boolean z, List list, SQ sq, long j2, SQ sq2, long j3, List list2) {
        AbstractC13042fc3.i(str, "transactionHash");
        AbstractC13042fc3.i(sp, "authMode");
        AbstractC13042fc3.i(list, "availableSendCodeType");
        AbstractC13042fc3.i(sq, "sentCodeType");
        AbstractC13042fc3.i(sq2, "nextSendCodeType");
        AbstractC13042fc3.i(list2, "exInfoList");
        this.a = str;
        this.b = sp;
        this.c = z;
        this.d = list;
        this.e = sq;
        this.f = j2;
        this.g = sq2;
        this.h = j3;
        this.i = list2;
    }

    public final SP a() {
        return this.b;
    }

    public final List b() {
        return this.d;
    }

    public final long c() {
        return this.f;
    }

    public final List d() {
        return this.i;
    }

    public final SQ e() {
        return this.g;
    }

    public final long f() {
        return this.h;
    }

    public final SQ g() {
        return this.e;
    }

    public final String h() {
        return this.a;
    }
}
