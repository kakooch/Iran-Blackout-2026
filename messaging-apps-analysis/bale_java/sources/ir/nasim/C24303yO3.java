package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.yO3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24303yO3 {
    private final ExPeerType a;
    private C11458d25 b;
    private final J44 c;
    private final Boolean d;
    private final Boolean e;
    private final Boolean f;
    private final Boolean g;
    private final Boolean h;
    private final Boolean i;
    private final Boolean j;
    private final Boolean k;
    private final Boolean l;

    /* renamed from: ir.nasim.yO3$a */
    public static final class a {
        private ExPeerType a;
        private C11458d25 b;
        private J44 c;
        private Boolean d;
        private Boolean e;
        private Boolean f;
        private Boolean g;
        private Boolean h;
        private Boolean i;
        private Boolean j;
        private Boolean k;
        private Boolean l;

        public final C24303yO3 a() {
            return new C24303yO3(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }

        public final a b(Boolean bool) {
            this.i = bool;
            return this;
        }

        public final a c(Boolean bool) {
            this.j = bool;
            return this;
        }

        public final a d(Boolean bool) {
            this.k = bool;
            return this;
        }

        public final a e(Boolean bool) {
            this.f = bool;
            return this;
        }

        public final a f(ExPeerType exPeerType) {
            this.a = exPeerType;
            return this;
        }

        public final a g(Boolean bool) {
            this.h = bool;
            return this;
        }

        public final a h(Boolean bool) {
            this.e = bool;
            return this;
        }

        public final a i(Boolean bool) {
            this.g = bool;
            return this;
        }

        public final a j(J44 j44) {
            this.c = j44;
            return this;
        }

        public final a k(C11458d25 c11458d25) {
            this.b = c11458d25;
            return this;
        }

        public final a l(Boolean bool) {
            this.d = bool;
            return this;
        }

        public final a m(Boolean bool) {
            this.l = bool;
            return this;
        }
    }

    public C24303yO3(ExPeerType exPeerType, C11458d25 c11458d25, J44 j44, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9) {
        this.a = exPeerType;
        this.b = c11458d25;
        this.c = j44;
        this.d = bool;
        this.e = bool2;
        this.f = bool3;
        this.g = bool4;
        this.h = bool5;
        this.i = bool6;
        this.j = bool7;
        this.k = bool8;
        this.l = bool9;
    }

    public final Boolean a() {
        return this.i;
    }

    public final Boolean b() {
        return this.j;
    }

    public final Boolean c() {
        return this.k;
    }

    public final Boolean d() {
        return this.f;
    }

    public final Boolean e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24303yO3)) {
            return false;
        }
        C24303yO3 c24303yO3 = (C24303yO3) obj;
        return this.a == c24303yO3.a && AbstractC13042fc3.d(this.b, c24303yO3.b) && AbstractC13042fc3.d(this.c, c24303yO3.c) && AbstractC13042fc3.d(this.d, c24303yO3.d) && AbstractC13042fc3.d(this.e, c24303yO3.e) && AbstractC13042fc3.d(this.f, c24303yO3.f) && AbstractC13042fc3.d(this.g, c24303yO3.g) && AbstractC13042fc3.d(this.h, c24303yO3.h) && AbstractC13042fc3.d(this.i, c24303yO3.i) && AbstractC13042fc3.d(this.j, c24303yO3.j) && AbstractC13042fc3.d(this.k, c24303yO3.k) && AbstractC13042fc3.d(this.l, c24303yO3.l);
    }

    public final Boolean f() {
        return this.e;
    }

    public final Boolean g() {
        return this.g;
    }

    public final Boolean h() {
        return this.d;
    }

    public int hashCode() {
        ExPeerType exPeerType = this.a;
        int iHashCode = (exPeerType == null ? 0 : exPeerType.hashCode()) * 31;
        C11458d25 c11458d25 = this.b;
        int iHashCode2 = (iHashCode + (c11458d25 == null ? 0 : c11458d25.hashCode())) * 31;
        J44 j44 = this.c;
        int iHashCode3 = (iHashCode2 + (j44 == null ? 0 : j44.hashCode())) * 31;
        Boolean bool = this.d;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.e;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.f;
        int iHashCode6 = (iHashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.g;
        int iHashCode7 = (iHashCode6 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.h;
        int iHashCode8 = (iHashCode7 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.i;
        int iHashCode9 = (iHashCode8 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.j;
        int iHashCode10 = (iHashCode9 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.k;
        int iHashCode11 = (iHashCode10 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.l;
        return iHashCode11 + (bool9 != null ? bool9.hashCode() : 0);
    }

    public final Boolean i() {
        return this.l;
    }

    public final ExPeerType j() {
        return this.a;
    }

    public final J44 k() {
        return this.c;
    }

    public final C11458d25 l() {
        return this.b;
    }

    public String toString() {
        return "MarkWonConfigs(exPeerType=" + this.a + ", peer=" + this.b + ", message=" + this.c + ", enableSoftBreakAddsNewLinePlugin=" + this.d + ", enableLinkifyPlugin=" + this.e + ", enableCodePlugin=" + this.f + ", enableMentionPlugin=" + this.g + ", enableHashtagPlugin=" + this.h + ", enableBankCardPlugin=" + this.i + ", enableBotPlugin=" + this.j + ", enableCheckBoxPlugin=" + this.k + ", enableUserMentionPlugin=" + this.l + Separators.RPAREN;
    }
}
