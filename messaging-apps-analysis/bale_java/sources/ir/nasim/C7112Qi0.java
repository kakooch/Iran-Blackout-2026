package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Qi0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7112Qi0 {
    public static final a e = new a(null);
    private final int a;
    private final String b;
    private final String c;
    private final Avatar d;

    /* renamed from: ir.nasim.Qi0$a */
    public static final class a {
        private a() {
        }

        public final C7112Qi0 a(int i, String str, String str2, Avatar avatar) {
            AbstractC13042fc3.i(str, "description");
            return new C7112Qi0(i, str2, str, avatar);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C7112Qi0(int i, String str, String str2, Avatar avatar) {
        AbstractC13042fc3.i(str2, "description");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = avatar;
    }

    public final Avatar a() {
        return this.d;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7112Qi0)) {
            return false;
        }
        C7112Qi0 c7112Qi0 = (C7112Qi0) obj;
        return this.a == c7112Qi0.a && AbstractC13042fc3.d(this.b, c7112Qi0.b) && AbstractC13042fc3.d(this.c, c7112Qi0.c) && AbstractC13042fc3.d(this.d, c7112Qi0.d);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31;
        Avatar avatar = this.d;
        return iHashCode2 + (avatar != null ? avatar.hashCode() : 0);
    }

    public String toString() {
        return "BotItemUI(botUserId=" + this.a + ", name=" + this.b + ", description=" + this.c + ", avatar=" + this.d + Separators.RPAREN;
    }
}
