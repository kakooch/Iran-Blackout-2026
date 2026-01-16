package ir.nasim;

import ir.nasim.data.model.story.PostToStoryData;
import ir.nasim.data.model.story.PostToStoryStoryType;
import java.util.List;

/* loaded from: classes7.dex */
public final class BR6 implements AR6 {
    @Override // ir.nasim.AR6
    public C22042ua0 a(String str, List list, PostToStoryData postToStoryData) {
        AbstractC13042fc3.i(str, "filePath");
        AbstractC13042fc3.i(list, "coordinates");
        AbstractC13042fc3.i(postToStoryData, "postToStoryData");
        return C14933ij5.INSTANCE.a(str, list, postToStoryData);
    }

    @Override // ir.nasim.AR6
    public void b(PostToStoryData postToStoryData) {
        AbstractC13042fc3.i(postToStoryData, "postToStoryData");
        C23144wQ6.a.a(-1, postToStoryData.getPeerId(), postToStoryData.getPostOwnerExPeerTypeValue(), postToStoryData.getPostId(), postToStoryData.getOrigin(), PostToStoryStoryType.b, EnumC11893dj5.b, null, null);
    }
}
