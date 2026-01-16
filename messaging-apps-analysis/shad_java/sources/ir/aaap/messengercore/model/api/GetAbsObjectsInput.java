package ir.aaap.messengercore.model.api;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetAbsObjectsInput {
    public ArrayList<String> objects_guids;

    public GetAbsObjectsInput(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.objects_guids = arrayList;
        arrayList.add(str);
    }

    public GetAbsObjectsInput(ArrayList<String> arrayList) {
        this.objects_guids = arrayList;
    }
}
