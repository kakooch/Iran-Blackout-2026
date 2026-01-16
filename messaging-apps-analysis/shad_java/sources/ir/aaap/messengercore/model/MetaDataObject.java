package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MetaDataObject {
    public ArrayList<MetaDataPartObject> meta_data_parts;

    public void addMetaData(MetaDataPartObject metaDataPartObject) {
        if (this.meta_data_parts == null) {
            this.meta_data_parts = new ArrayList<>();
        }
        if (this.meta_data_parts.size() >= 30) {
            return;
        }
        this.meta_data_parts.add(metaDataPartObject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MetaDataObject) {
            return Objects.equalsArray(this.meta_data_parts, ((MetaDataObject) obj).meta_data_parts);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.meta_data_parts);
    }
}
