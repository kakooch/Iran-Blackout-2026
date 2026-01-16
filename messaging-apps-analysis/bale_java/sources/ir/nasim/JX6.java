package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.story.model.StoryWidget;

/* loaded from: classes7.dex */
public final class JX6 {
    private final String a;
    private final long b;
    private final StoryWidget c;

    public JX6(String str, long j, StoryWidget storyWidget) {
        AbstractC13042fc3.i(str, "storyId");
        AbstractC13042fc3.i(storyWidget, "widget");
        this.a = str;
        this.b = j;
        this.c = storyWidget;
    }

    public final long a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final StoryWidget c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JX6)) {
            return false;
        }
        JX6 jx6 = (JX6) obj;
        return AbstractC13042fc3.d(this.a, jx6.a) && this.b == jx6.b && AbstractC13042fc3.d(this.c, jx6.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "StoryWidgetFull(storyId=" + this.a + ", expirationDateSec=" + this.b + ", widget=" + this.c + Separators.RPAREN;
    }
}
