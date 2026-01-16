package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.FolderObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AddOrEditFolderInput {
    public String folder_id;
    public Boolean is_add_to_top;
    public String name;
    public String suggestion_folder_id;
    public ArrayList<String> updated_parameters;
    public ArrayList<FolderObject.EnumIncludeChatType> include_chat_types = new ArrayList<>();
    public ArrayList<FolderObject.EnumExcludeChatType> exclude_chat_types = new ArrayList<>();
    public ArrayList<String> include_object_guids = new ArrayList<>();
    public ArrayList<String> exclude_object_guids = new ArrayList<>();
}
