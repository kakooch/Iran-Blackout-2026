package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23695xM3;
import ir.nasim.InterfaceC3488Bb4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MagazineStruct$FeedAlbumMessage extends GeneratedMessageLite implements U64 {
    private static final MagazineStruct$FeedAlbumMessage DEFAULT_INSTANCE;
    public static final int DOCUMENT_MESSAGES_FIELD_NUMBER = 1;
    public static final int ITEMS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j documentMessages_ = GeneratedMessageLite.emptyProtobufList();
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MagazineStruct$FeedAlbumMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineStruct$FeedAlbumMessage magazineStruct$FeedAlbumMessage = new MagazineStruct$FeedAlbumMessage();
        DEFAULT_INSTANCE = magazineStruct$FeedAlbumMessage;
        GeneratedMessageLite.registerDefaultInstance(MagazineStruct$FeedAlbumMessage.class, magazineStruct$FeedAlbumMessage);
    }

    private MagazineStruct$FeedAlbumMessage() {
    }

    private void addAllDocumentMessages(Iterable<? extends MessagingStruct$DocumentMessage> iterable) {
        ensureDocumentMessagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.documentMessages_);
    }

    private void addAllItems(Iterable<? extends MagazineStruct$FeedAlbumItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addDocumentMessages(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        ensureDocumentMessagesIsMutable();
        this.documentMessages_.add(messagingStruct$DocumentMessage);
    }

    private void addItems(MagazineStruct$FeedAlbumItem magazineStruct$FeedAlbumItem) {
        magazineStruct$FeedAlbumItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(magazineStruct$FeedAlbumItem);
    }

    private void clearDocumentMessages() {
        this.documentMessages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearItems() {
        this.items_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDocumentMessagesIsMutable() {
        B.j jVar = this.documentMessages_;
        if (jVar.u()) {
            return;
        }
        this.documentMessages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureItemsIsMutable() {
        B.j jVar = this.items_;
        if (jVar.u()) {
            return;
        }
        this.items_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MagazineStruct$FeedAlbumMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineStruct$FeedAlbumMessage parseDelimitedFrom(InputStream inputStream) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(ByteBuffer byteBuffer) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDocumentMessages(int i) {
        ensureDocumentMessagesIsMutable();
        this.documentMessages_.remove(i);
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setDocumentMessages(int i, MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        ensureDocumentMessagesIsMutable();
        this.documentMessages_.set(i, messagingStruct$DocumentMessage);
    }

    private void setItems(int i, MagazineStruct$FeedAlbumItem magazineStruct$FeedAlbumItem) {
        magazineStruct$FeedAlbumItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, magazineStruct$FeedAlbumItem);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineStruct$FeedAlbumMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"documentMessages_", MessagingStruct$DocumentMessage.class, "items_", MagazineStruct$FeedAlbumItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineStruct$FeedAlbumMessage.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    public MessagingStruct$DocumentMessage getDocumentMessages(int i) {
        return (MessagingStruct$DocumentMessage) this.documentMessages_.get(i);
    }

    @Deprecated
    public int getDocumentMessagesCount() {
        return this.documentMessages_.size();
    }

    @Deprecated
    public List<MessagingStruct$DocumentMessage> getDocumentMessagesList() {
        return this.documentMessages_;
    }

    @Deprecated
    public InterfaceC3488Bb4 getDocumentMessagesOrBuilder(int i) {
        return (InterfaceC3488Bb4) this.documentMessages_.get(i);
    }

    @Deprecated
    public List<? extends InterfaceC3488Bb4> getDocumentMessagesOrBuilderList() {
        return this.documentMessages_;
    }

    public MagazineStruct$FeedAlbumItem getItems(int i) {
        return (MagazineStruct$FeedAlbumItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<MagazineStruct$FeedAlbumItem> getItemsList() {
        return this.items_;
    }

    public InterfaceC23695xM3 getItemsOrBuilder(int i) {
        return (InterfaceC23695xM3) this.items_.get(i);
    }

    public List<? extends InterfaceC23695xM3> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(MagazineStruct$FeedAlbumMessage magazineStruct$FeedAlbumMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineStruct$FeedAlbumMessage);
    }

    public static MagazineStruct$FeedAlbumMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDocumentMessages(int i, MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        ensureDocumentMessagesIsMutable();
        this.documentMessages_.add(i, messagingStruct$DocumentMessage);
    }

    private void addItems(int i, MagazineStruct$FeedAlbumItem magazineStruct$FeedAlbumItem) {
        magazineStruct$FeedAlbumItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, magazineStruct$FeedAlbumItem);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(byte[] bArr) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(InputStream inputStream) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineStruct$FeedAlbumMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineStruct$FeedAlbumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
