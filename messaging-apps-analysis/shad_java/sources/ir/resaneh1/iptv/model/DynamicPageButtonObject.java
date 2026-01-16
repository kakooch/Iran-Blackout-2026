package ir.resaneh1.iptv.model;

import ir.aaap.messengercore.model.MiniFunctionObject;

/* loaded from: classes3.dex */
public class DynamicPageButtonObject extends MiniFunctionObject {
    public boolean save_default_value;
    public String set_item_name;
    public String set_object_data_id;
    public String title;

    @Override // ir.aaap.messengercore.model.MiniFunctionObject
    public String getTitle() {
        return this.title;
    }
}
