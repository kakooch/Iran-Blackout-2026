package ir.nasim;

import ai.bale.proto.ImagesStruct$GifDescriptor;

/* renamed from: ir.nasim.bH2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10218bH2 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C5845Lb6 a(ImagesStruct$GifDescriptor imagesStruct$GifDescriptor) {
        AbstractC13042fc3.i(imagesStruct$GifDescriptor, "input");
        byte[] bArrA0 = imagesStruct$GifDescriptor.getThumb().a0();
        long fileId = imagesStruct$GifDescriptor.getGifLocation().getFileId();
        long accessHash = imagesStruct$GifDescriptor.getGifLocation().getAccessHash();
        int value = imagesStruct$GifDescriptor.getGifLocation().getFileStorageVersion().getValue();
        int width = imagesStruct$GifDescriptor.getWidth();
        int height = imagesStruct$GifDescriptor.getHeight();
        long fileSize = imagesStruct$GifDescriptor.getFileSize();
        int duration = imagesStruct$GifDescriptor.getDuration();
        long usedAt = imagesStruct$GifDescriptor.getUsedAt();
        String value2 = imagesStruct$GifDescriptor.getMimeType().getValue();
        String str = value2.length() == 0 ? null : value2;
        AbstractC13042fc3.f(bArrA0);
        return new C5845Lb6(0, fileId, accessHash, value, width, height, fileSize, duration, usedAt, str, bArrA0.length == 0 ? null : bArrA0, 1, null);
    }
}
