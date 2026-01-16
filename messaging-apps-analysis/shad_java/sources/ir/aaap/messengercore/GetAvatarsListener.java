package ir.aaap.messengercore;

import ir.aaap.messengercore.model.AvatarObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public interface GetAvatarsListener {
    void onAvatarsDidLoad(ArrayList<AvatarObject> arrayList);

    void onAvatarsLoadingFailed();
}
