package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class DynamicPageCommandObject {
    public AddObjectData add_object_data;
    public AddPagePartData add_page_part_data;
    public ApiClickData api_click_data;
    public EditObjectData edit_object_data;
    public GoLinkData go_link_data;
    public RemoveObjectData remove_object_data;
    public RemovePagePartData remove_page_part_data;
    public TypeEnum type;

    public enum TypeEnum {
        EditObjectData,
        RemoveObjectData,
        AddObjectData,
        AddPagePartData,
        RemovePagePartData,
        GoLink,
        ApiClick
    }
}
