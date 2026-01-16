package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;
import ir.nasim.M44;

/* renamed from: ir.nasim.Xz7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8967Xz7 {
    private final Q64 a;
    private final Spannable b;
    private final C4602Fv2 c;
    private final PO5 d;
    private final M44.a e;
    private final J44 f;
    private final Object g;
    private final Spannable h;
    private final String i;
    private final Spannable j;
    private final C20610sI7 k;
    private final Spannable l;
    private final C19672qk7 m;
    private final String n;
    private final String o;
    private final GM3 p;
    private final XV4 q;
    private final boolean r;
    private final boolean s;

    public C8967Xz7(Q64 q64, Spannable spannable, C4602Fv2 c4602Fv2, PO5 po5, M44.a aVar, J44 j44, Object obj, Spannable spannable2, String str, Spannable spannable3, C20610sI7 c20610sI7, Spannable spannable4, C19672qk7 c19672qk7, String str2, String str3, GM3 gm3, XV4 xv4, boolean z, boolean z2) {
        AbstractC13042fc3.i(q64, "mId");
        AbstractC13042fc3.i(spannable, "state");
        AbstractC13042fc3.i(aVar, "availableActionsBuilder");
        AbstractC13042fc3.i(j44, "oldMessage");
        AbstractC13042fc3.i(str2, "contentDescription");
        AbstractC13042fc3.i(str3, "selectedContentDescription");
        AbstractC13042fc3.i(gm3, "upVote");
        this.a = q64;
        this.b = spannable;
        this.c = c4602Fv2;
        this.d = po5;
        this.e = aVar;
        this.f = j44;
        this.g = obj;
        this.h = spannable2;
        this.i = str;
        this.j = spannable3;
        this.k = c20610sI7;
        this.l = spannable4;
        this.m = c19672qk7;
        this.n = str2;
        this.o = str3;
        this.p = gm3;
        this.q = xv4;
        this.r = z;
        this.s = z2;
    }

    public final C8967Xz7 a(Q64 q64, Spannable spannable, C4602Fv2 c4602Fv2, PO5 po5, M44.a aVar, J44 j44, Object obj, Spannable spannable2, String str, Spannable spannable3, C20610sI7 c20610sI7, Spannable spannable4, C19672qk7 c19672qk7, String str2, String str3, GM3 gm3, XV4 xv4, boolean z, boolean z2) {
        AbstractC13042fc3.i(q64, "mId");
        AbstractC13042fc3.i(spannable, "state");
        AbstractC13042fc3.i(aVar, "availableActionsBuilder");
        AbstractC13042fc3.i(j44, "oldMessage");
        AbstractC13042fc3.i(str2, "contentDescription");
        AbstractC13042fc3.i(str3, "selectedContentDescription");
        AbstractC13042fc3.i(gm3, "upVote");
        return new C8967Xz7(q64, spannable, c4602Fv2, po5, aVar, j44, obj, spannable2, str, spannable3, c20610sI7, spannable4, c19672qk7, str2, str3, gm3, xv4, z, z2);
    }

    public final M44.a c() {
        return this.e;
    }

    public final Spannable d() {
        return this.h;
    }

    public final String e() {
        return this.n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8967Xz7)) {
            return false;
        }
        C8967Xz7 c8967Xz7 = (C8967Xz7) obj;
        return AbstractC13042fc3.d(this.a, c8967Xz7.a) && AbstractC13042fc3.d(this.b, c8967Xz7.b) && AbstractC13042fc3.d(this.c, c8967Xz7.c) && AbstractC13042fc3.d(this.d, c8967Xz7.d) && AbstractC13042fc3.d(this.e, c8967Xz7.e) && AbstractC13042fc3.d(this.f, c8967Xz7.f) && AbstractC13042fc3.d(this.g, c8967Xz7.g) && AbstractC13042fc3.d(this.h, c8967Xz7.h) && AbstractC13042fc3.d(this.i, c8967Xz7.i) && AbstractC13042fc3.d(this.j, c8967Xz7.j) && AbstractC13042fc3.d(this.k, c8967Xz7.k) && AbstractC13042fc3.d(this.l, c8967Xz7.l) && AbstractC13042fc3.d(this.m, c8967Xz7.m) && AbstractC13042fc3.d(this.n, c8967Xz7.n) && AbstractC13042fc3.d(this.o, c8967Xz7.o) && AbstractC13042fc3.d(this.p, c8967Xz7.p) && AbstractC13042fc3.d(this.q, c8967Xz7.q) && this.r == c8967Xz7.r && this.s == c8967Xz7.s;
    }

    public final Object f() {
        return this.g;
    }

    public final C4602Fv2 g() {
        return this.c;
    }

    public final Q64 h() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        C4602Fv2 c4602Fv2 = this.c;
        int iHashCode2 = (iHashCode + (c4602Fv2 == null ? 0 : c4602Fv2.hashCode())) * 31;
        PO5 po5 = this.d;
        int iHashCode3 = (((((iHashCode2 + (po5 == null ? 0 : po5.hashCode())) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        Object obj = this.g;
        int iHashCode4 = (iHashCode3 + (obj == null ? 0 : obj.hashCode())) * 31;
        Spannable spannable = this.h;
        int iHashCode5 = (iHashCode4 + (spannable == null ? 0 : spannable.hashCode())) * 31;
        String str = this.i;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Spannable spannable2 = this.j;
        int iHashCode7 = (iHashCode6 + (spannable2 == null ? 0 : spannable2.hashCode())) * 31;
        C20610sI7 c20610sI7 = this.k;
        int iHashCode8 = (iHashCode7 + (c20610sI7 == null ? 0 : c20610sI7.hashCode())) * 31;
        Spannable spannable3 = this.l;
        int iHashCode9 = (iHashCode8 + (spannable3 == null ? 0 : spannable3.hashCode())) * 31;
        C19672qk7 c19672qk7 = this.m;
        int iHashCode10 = (((((((iHashCode9 + (c19672qk7 == null ? 0 : c19672qk7.hashCode())) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31;
        XV4 xv4 = this.q;
        return ((((iHashCode10 + (xv4 != null ? xv4.hashCode() : 0)) * 31) + Boolean.hashCode(this.r)) * 31) + Boolean.hashCode(this.s);
    }

    public final XV4 i() {
        return this.q;
    }

    public final J44 j() {
        return this.f;
    }

    public final String k() {
        return this.i;
    }

    public final Spannable l() {
        return this.j;
    }

    public final PO5 m() {
        return this.d;
    }

    public final String n() {
        return this.o;
    }

    public final Spannable o() {
        return this.l;
    }

    public final boolean p() {
        return this.s;
    }

    public final boolean q() {
        return this.r;
    }

    public final Spannable r() {
        return this.b;
    }

    public final C19672qk7 s() {
        return this.m;
    }

    public final GM3 t() {
        return this.p;
    }

    public String toString() {
        Q64 q64 = this.a;
        Spannable spannable = this.b;
        C4602Fv2 c4602Fv2 = this.c;
        PO5 po5 = this.d;
        M44.a aVar = this.e;
        J44 j44 = this.f;
        Object obj = this.g;
        Spannable spannable2 = this.h;
        String str = this.i;
        Spannable spannable3 = this.j;
        C20610sI7 c20610sI7 = this.k;
        Spannable spannable4 = this.l;
        return "UIMessage(mId=" + q64 + ", state=" + ((Object) spannable) + ", forward=" + c4602Fv2 + ", reply=" + po5 + ", availableActionsBuilder=" + aVar + ", oldMessage=" + j44 + ", data=" + obj + ", body=" + ((Object) spannable2) + ", reactedReactionCode=" + str + ", reactions=" + ((Object) spannable3) + ", userAvatar=" + c20610sI7 + ", senderName=" + ((Object) spannable4) + ", template=" + this.m + ", contentDescription=" + this.n + ", selectedContentDescription=" + this.o + ", upVote=" + this.p + ", messageRepliesInfo=" + this.q + ", showAvatar=" + this.r + ", showAddStoryIcon=" + this.s + Separators.RPAREN;
    }

    public final C20610sI7 u() {
        return this.k;
    }

    public /* synthetic */ C8967Xz7(Q64 q64, Spannable spannable, C4602Fv2 c4602Fv2, PO5 po5, M44.a aVar, J44 j44, Object obj, Spannable spannable2, String str, Spannable spannable3, C20610sI7 c20610sI7, Spannable spannable4, C19672qk7 c19672qk7, String str2, String str3, GM3 gm3, XV4 xv4, boolean z, boolean z2, int i, ED1 ed1) {
        this(q64, spannable, c4602Fv2, po5, aVar, j44, obj, spannable2, str, spannable3, c20610sI7, spannable4, c19672qk7, (i & 8192) != 0 ? "" : str2, (i & 16384) != 0 ? "" : str3, gm3, (65536 & i) != 0 ? null : xv4, (131072 & i) != 0 ? true : z, (i & 262144) != 0 ? false : z2);
    }
}
