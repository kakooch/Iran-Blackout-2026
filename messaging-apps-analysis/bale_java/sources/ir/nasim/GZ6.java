package ir.nasim;

import ai.bale.proto.LahzeStruct$LiveInfo;

/* loaded from: classes5.dex */
public final class GZ6 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FD3 a(LahzeStruct$LiveInfo lahzeStruct$LiveInfo) {
        AbstractC13042fc3.i(lahzeStruct$LiveInfo, "input");
        long key = lahzeStruct$LiveInfo.getKey();
        C11458d25 c11458d25Y = C11458d25.y(lahzeStruct$LiveInfo.getGroupId());
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        return new FD3(key, c11458d25Y, lahzeStruct$LiveInfo.getUserCount(), lahzeStruct$LiveInfo.getIsLive(), lahzeStruct$LiveInfo.getMainMessageId(), lahzeStruct$LiveInfo.getMainMessageDate());
    }
}
