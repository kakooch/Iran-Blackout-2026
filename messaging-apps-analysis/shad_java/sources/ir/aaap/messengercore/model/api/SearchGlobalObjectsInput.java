package ir.aaap.messengercore.model.api;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SearchGlobalObjectsInput {
    public ArrayList<FilterType> filter_types;
    public String search_text;
    public String start_id;

    public enum FilterType {
        User,
        Bot,
        Channel
    }
}
