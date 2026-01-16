package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class WarningObject {
    public Link link;
    public String text;
    public String title;
    public ColorObject title_color;
    public String warning_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WarningObject)) {
            return false;
        }
        WarningObject warningObject = (WarningObject) obj;
        return Objects.equals(this.title, warningObject.title) && Objects.equals(this.text, warningObject.text) && Objects.equals(this.link, warningObject.link) && Objects.equals(this.title_color, warningObject.title_color) && Objects.equals(this.warning_id, warningObject.warning_id);
    }

    public int hashCode() {
        return Objects.hash(this.title, this.text, this.link, this.title_color, this.warning_id);
    }
}
