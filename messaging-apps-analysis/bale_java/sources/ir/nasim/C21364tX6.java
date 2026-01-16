package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.tX6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21364tX6 {
    private final String a;
    private final List b;

    public C21364tX6(String str, List list) {
        AbstractC13042fc3.i(str, "storyId");
        AbstractC13042fc3.i(list, "storyViewerItem");
        this.a = str;
        this.b = list;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21364tX6)) {
            return false;
        }
        C21364tX6 c21364tX6 = (C21364tX6) obj;
        return AbstractC13042fc3.d(this.a, c21364tX6.a) && AbstractC13042fc3.d(this.b, c21364tX6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "StoryViewerUiModel(storyId=" + this.a + ", storyViewerItem=" + this.b + Separators.RPAREN;
    }
}
