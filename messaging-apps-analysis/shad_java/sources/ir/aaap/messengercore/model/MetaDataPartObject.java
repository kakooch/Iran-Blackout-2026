package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class MetaDataPartObject {
    public int from_index;
    public int length;
    public Link link;
    public String mention_text_object_guid;
    public MetaType type;

    public enum MetaType {
        Bold,
        Italic,
        MentionText,
        Link,
        Pre,
        Mono,
        Strike,
        Underline,
        Spoiler
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetaDataPartObject)) {
            return false;
        }
        MetaDataPartObject metaDataPartObject = (MetaDataPartObject) obj;
        return this.from_index == metaDataPartObject.from_index && this.length == metaDataPartObject.length && this.type == metaDataPartObject.type && Objects.equals(this.link, metaDataPartObject.link) && Objects.equals(this.mention_text_object_guid, metaDataPartObject.mention_text_object_guid);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.from_index), Integer.valueOf(this.length), this.type, this.link, this.mention_text_object_guid);
    }
}
