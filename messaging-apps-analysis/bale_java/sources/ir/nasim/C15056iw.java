package ir.nasim;

import ai.bale.proto.VitrineOuterClass$BannerItem;
import ir.nasim.jaryan.discover.model.BannerItem;
import ir.nasim.jaryan.discover.model.FileLocation;

/* renamed from: ir.nasim.iw, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15056iw implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BannerItem a(VitrineOuterClass$BannerItem vitrineOuterClass$BannerItem) {
        Integer fileStorageVersion;
        AbstractC13042fc3.i(vitrineOuterClass$BannerItem, "bannerItem");
        C4626Fy c4626FyO0 = C18732p92.o0(vitrineOuterClass$BannerItem.getImage());
        C12056dy fileLocation = c4626FyO0 != null ? c4626FyO0.getFileLocation() : null;
        FileLocation fileLocation2 = new FileLocation(fileLocation != null ? fileLocation.getFileId() : 0L, fileLocation != null ? fileLocation.getAccessHash() : 0L, (fileLocation == null || (fileStorageVersion = fileLocation.getFileStorageVersion()) == null) ? 1 : fileStorageVersion.intValue());
        String url = vitrineOuterClass$BannerItem.getAction().getPayload().getUrl();
        AbstractC13042fc3.h(url, "getUrl(...)");
        return new BannerItem(fileLocation2, url, vitrineOuterClass$BannerItem.getImage().getFileSize());
    }
}
