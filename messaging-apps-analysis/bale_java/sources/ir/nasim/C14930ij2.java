package ir.nasim;

import ir.nasim.AbstractC15520jj2;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.jaryan.feed.model.db.AbsFeedMessageDataEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ij2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14930ij2 implements InterfaceC14123hO3 {
    private final AbstractC15520jj2.b b(AbsFeedMessageDataEntity.AlbumMessage albumMessage) {
        List<AbsFeedMessageDataEntity.AlbumItem> albumItems = albumMessage.getAlbumItems();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(albumItems, 10));
        for (AbsFeedMessageDataEntity.AlbumItem albumItem : albumItems) {
            arrayList.add(new AbstractC15520jj2.a(albumItem.getItemRid(), albumItem.getItemDate(), f(albumItem.getMediaMessage())));
        }
        return new AbstractC15520jj2.b(arrayList, 0, null, 6, null);
    }

    private final AbstractC15520jj2 c(AbsFeedMessageDataEntity absFeedMessageDataEntity) {
        return absFeedMessageDataEntity instanceof AbsFeedMessageDataEntity.TextMessage ? h((AbsFeedMessageDataEntity.TextMessage) absFeedMessageDataEntity) : absFeedMessageDataEntity instanceof AbsFeedMessageDataEntity.PhotoMessage ? g((AbsFeedMessageDataEntity.PhotoMessage) absFeedMessageDataEntity) : absFeedMessageDataEntity instanceof AbsFeedMessageDataEntity.GifMessage ? e((AbsFeedMessageDataEntity.GifMessage) absFeedMessageDataEntity) : absFeedMessageDataEntity instanceof AbsFeedMessageDataEntity.VideoMessage ? i((AbsFeedMessageDataEntity.VideoMessage) absFeedMessageDataEntity) : absFeedMessageDataEntity instanceof AbsFeedMessageDataEntity.AlbumMessage ? b((AbsFeedMessageDataEntity.AlbumMessage) absFeedMessageDataEntity) : absFeedMessageDataEntity instanceof AbsFeedMessageDataEntity.UnknownMessage ? AbstractC15520jj2.g.a : AbstractC15520jj2.g.a;
    }

    private final AbsFeedMessageDataEntity d(byte[] bArr, int i) {
        if (i == EnumC12502ej2.c.j()) {
            return (AbsFeedMessageDataEntity) C23196wW4.a.c(bArr, AbsFeedMessageDataEntity.TextMessage.INSTANCE);
        }
        if (i == EnumC12502ej2.d.j()) {
            return (AbsFeedMessageDataEntity) C23196wW4.a.c(bArr, AbsFeedMessageDataEntity.PhotoMessage.INSTANCE);
        }
        if (i == EnumC12502ej2.g.j()) {
            return (AbsFeedMessageDataEntity) C23196wW4.a.c(bArr, AbsFeedMessageDataEntity.GifMessage.INSTANCE);
        }
        if (i == EnumC12502ej2.e.j()) {
            return (AbsFeedMessageDataEntity) C23196wW4.a.c(bArr, AbsFeedMessageDataEntity.VideoMessage.INSTANCE);
        }
        if (i == EnumC12502ej2.f.j()) {
            return (AbsFeedMessageDataEntity) C23196wW4.a.c(bArr, AbsFeedMessageDataEntity.AlbumMessage.INSTANCE);
        }
        return (AbsFeedMessageDataEntity) C23196wW4.a.c(bArr, AbsFeedMessageDataEntity.UnknownMessage.INSTANCE);
    }

    private final AbstractC15520jj2.c e(AbsFeedMessageDataEntity.GifMessage gifMessage) {
        return new AbstractC15520jj2.c(gifMessage.getThumbnail(), gifMessage.getCaption(), new FileReference(new C12056dy(gifMessage.getFileId(), gifMessage.getAccessHash(), gifMessage.getFileStorageVersion()), gifMessage.getFileName(), gifMessage.getCaption(), gifMessage.getFileSize()), gifMessage.getHeight(), gifMessage.getWidth(), 0, null, 96, null);
    }

    private final AbstractC15520jj2.d f(AbsFeedMessageDataEntity.MediaMessage mediaMessage) {
        if (mediaMessage instanceof AbsFeedMessageDataEntity.PhotoMessage) {
            return g((AbsFeedMessageDataEntity.PhotoMessage) mediaMessage);
        }
        if (mediaMessage instanceof AbsFeedMessageDataEntity.GifMessage) {
            return e((AbsFeedMessageDataEntity.GifMessage) mediaMessage);
        }
        if (mediaMessage instanceof AbsFeedMessageDataEntity.VideoMessage) {
            return i((AbsFeedMessageDataEntity.VideoMessage) mediaMessage);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final AbstractC15520jj2.e g(AbsFeedMessageDataEntity.PhotoMessage photoMessage) {
        return new AbstractC15520jj2.e(photoMessage.getThumbnail(), photoMessage.getCaption(), new FileReference(new C12056dy(photoMessage.getFileId(), photoMessage.getAccessHash(), photoMessage.getFileStorageVersion()), photoMessage.getFileName(), photoMessage.getCaption(), photoMessage.getFileSize()), photoMessage.getHeight(), photoMessage.getWidth(), 0, null, 96, null);
    }

    private final AbstractC15520jj2.f h(AbsFeedMessageDataEntity.TextMessage textMessage) {
        return new AbstractC15520jj2.f(textMessage.getText(), textMessage.getMentions(), 0, null, 12, null);
    }

    private final AbstractC15520jj2.h i(AbsFeedMessageDataEntity.VideoMessage videoMessage) {
        FileReference fileReference = new FileReference(new C12056dy(videoMessage.getFileId(), videoMessage.getAccessHash(), videoMessage.getFileStorageVersion()), videoMessage.getFileName(), videoMessage.getCaption(), videoMessage.getFileSize());
        return new AbstractC15520jj2.h(videoMessage.getThumbnail(), fileReference, videoMessage.getCaption(), videoMessage.getMimeType(), videoMessage.getHeight(), videoMessage.getWidth(), videoMessage.getDuration(), 0, null, 384, null);
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C5886Lg2 a(C22114uh2 c22114uh2) {
        AbstractC13042fc3.i(c22114uh2, "input");
        ExPeer exPeer = new ExPeer(c22114uh2.e(), c22114uh2.l());
        AbsFeedMessageDataEntity absFeedMessageDataEntityD = d(c22114uh2.i(), c22114uh2.j());
        long jN = c22114uh2.n();
        long jD = c22114uh2.d();
        AbstractC15520jj2 abstractC15520jj2C = c(absFeedMessageDataEntityD);
        List<C15759k74> listM = c22114uh2.m();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listM, 10));
        for (C15759k74 c15759k74 : listM) {
            arrayList.add(new C15759k74(c15759k74.b(), c15759k74.a(), c15759k74.c()));
        }
        return new C5886Lg2(jN, jD, abstractC15520jj2C, arrayList, exPeer, c22114uh2.g(), c22114uh2.o(), c22114uh2.r(), c22114uh2.s(), c22114uh2.q(), c22114uh2.a(), c22114uh2.k(), c22114uh2.h(), c22114uh2.c() == null ? null : new C17532n74(c22114uh2.c().intValue(), null, null, null, null, null, false, 0L, 0, 510, null));
    }
}
