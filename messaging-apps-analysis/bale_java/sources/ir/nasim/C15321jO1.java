package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.MessageState;

/* renamed from: ir.nasim.jO1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15321jO1 {
    private final String a;
    private final boolean b;
    private final int c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final String g;
    private final MessageState h;
    private final Boolean i;
    private final boolean j;
    private final boolean k;
    private final int l;

    public C15321jO1(String str, boolean z, int i, boolean z2, boolean z3, boolean z4, String str2, MessageState messageState, Boolean bool, boolean z5, boolean z6, int i2) {
        this.a = str;
        this.b = z;
        this.c = i;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = str2;
        this.h = messageState;
        this.i = bool;
        this.j = z5;
        this.k = z6;
        this.l = i2;
    }

    public final boolean a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15321jO1)) {
            return false;
        }
        C15321jO1 c15321jO1 = (C15321jO1) obj;
        return AbstractC13042fc3.d(this.a, c15321jO1.a) && this.b == c15321jO1.b && this.c == c15321jO1.c && this.d == c15321jO1.d && this.e == c15321jO1.e && this.f == c15321jO1.f && AbstractC13042fc3.d(this.g, c15321jO1.g) && this.h == c15321jO1.h && AbstractC13042fc3.d(this.i, c15321jO1.i) && this.j == c15321jO1.j && this.k == c15321jO1.k && this.l == c15321jO1.l;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (((((((((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31;
        String str2 = this.g;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        MessageState messageState = this.h;
        int iHashCode3 = (iHashCode2 + (messageState == null ? 0 : messageState.hashCode())) * 31;
        Boolean bool = this.i;
        return ((((((iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + Integer.hashCode(this.l);
    }

    public String toString() {
        return "DialogListItemSideDateColumnState(formattedTime=" + this.a + ", isPinned=" + this.b + ", unreadMessageCount=" + this.c + ", markAsUnread=" + this.d + ", isMuted=" + this.e + ", hasMention=" + this.f + ", lastReactionEmoji=" + this.g + ", messageState=" + this.h + ", shouldShowMessageState=" + this.i + ", hasMainWebApp=" + this.j + ", isFormalDialog=" + this.k + ", formalDialogsMaxUnreadCount=" + this.l + Separators.RPAREN;
    }
}
