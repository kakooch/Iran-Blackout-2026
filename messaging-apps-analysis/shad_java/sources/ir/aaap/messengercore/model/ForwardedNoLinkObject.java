package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class ForwardedNoLinkObject {
    public String from_title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ForwardedNoLinkObject) {
            return Objects.equals(this.from_title, ((ForwardedNoLinkObject) obj).from_title);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.from_title);
    }
}
