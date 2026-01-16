package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3366Ao4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MyBankStruct$NewMyBankItemPayload extends GeneratedMessageLite implements U64 {
    private static final MyBankStruct$NewMyBankItemPayload DEFAULT_INSTANCE;
    public static final int MENU_ITEMS_FIELD_NUMBER = 6;
    public static final int MESSAGE_ID_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
    public static final int USSD_CODE_FIELD_NUMBER = 4;
    public static final int WITHINTENT_FIELD_NUMBER = 5;
    private int bitField0_;
    private MessagingStruct$MessageId messageId_;
    private PeersStruct$OutPeer peer_;
    private boolean withIntent_;
    private String url_ = "";
    private String ussdCode_ = "";
    private B.j menuItems_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MyBankStruct$NewMyBankItemPayload.DEFAULT_INSTANCE);
        }
    }

    static {
        MyBankStruct$NewMyBankItemPayload myBankStruct$NewMyBankItemPayload = new MyBankStruct$NewMyBankItemPayload();
        DEFAULT_INSTANCE = myBankStruct$NewMyBankItemPayload;
        GeneratedMessageLite.registerDefaultInstance(MyBankStruct$NewMyBankItemPayload.class, myBankStruct$NewMyBankItemPayload);
    }

    private MyBankStruct$NewMyBankItemPayload() {
    }

    private void addAllMenuItems(Iterable<? extends MyBankStruct$NewMyBankItem> iterable) {
        ensureMenuItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.menuItems_);
    }

    private void addMenuItems(MyBankStruct$NewMyBankItem myBankStruct$NewMyBankItem) {
        myBankStruct$NewMyBankItem.getClass();
        ensureMenuItemsIsMutable();
        this.menuItems_.add(myBankStruct$NewMyBankItem);
    }

    private void clearMenuItems() {
        this.menuItems_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    private void clearUssdCode() {
        this.ussdCode_ = getDefaultInstance().getUssdCode();
    }

    private void clearWithIntent() {
        this.withIntent_ = false;
    }

    private void ensureMenuItemsIsMutable() {
        B.j jVar = this.menuItems_;
        if (jVar.u()) {
            return;
        }
        this.menuItems_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MyBankStruct$NewMyBankItemPayload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.messageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.messageId_ = messagingStruct$MessageId;
        } else {
            this.messageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.messageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.peer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutPeer;
        } else {
            this.peer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.peer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MyBankStruct$NewMyBankItemPayload parseDelimitedFrom(InputStream inputStream) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(ByteBuffer byteBuffer) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMenuItems(int i) {
        ensureMenuItemsIsMutable();
        this.menuItems_.remove(i);
    }

    private void setMenuItems(int i, MyBankStruct$NewMyBankItem myBankStruct$NewMyBankItem) {
        myBankStruct$NewMyBankItem.getClass();
        ensureMenuItemsIsMutable();
        this.menuItems_.set(i, myBankStruct$NewMyBankItem);
    }

    private void setMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.messageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 2;
    }

    private void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    private void setUssdCode(String str) {
        str.getClass();
        this.ussdCode_ = str;
    }

    private void setUssdCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ussdCode_ = abstractC2383g.f0();
    }

    private void setWithIntent(boolean z) {
        this.withIntent_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (R0.a[gVar.ordinal()]) {
            case 1:
                return new MyBankStruct$NewMyBankItemPayload();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004Ȉ\u0005\u0007\u0006\u001b", new Object[]{"bitField0_", "url_", "peer_", "messageId_", "ussdCode_", "withIntent_", "menuItems_", MyBankStruct$NewMyBankItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MyBankStruct$NewMyBankItemPayload.class) {
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

    public MyBankStruct$NewMyBankItem getMenuItems(int i) {
        return (MyBankStruct$NewMyBankItem) this.menuItems_.get(i);
    }

    public int getMenuItemsCount() {
        return this.menuItems_.size();
    }

    public List<MyBankStruct$NewMyBankItem> getMenuItemsList() {
        return this.menuItems_;
    }

    public InterfaceC3366Ao4 getMenuItemsOrBuilder(int i) {
        return (InterfaceC3366Ao4) this.menuItems_.get(i);
    }

    public List<? extends InterfaceC3366Ao4> getMenuItemsOrBuilderList() {
        return this.menuItems_;
    }

    public MessagingStruct$MessageId getMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.messageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public String getUssdCode() {
        return this.ussdCode_;
    }

    public AbstractC2383g getUssdCodeBytes() {
        return AbstractC2383g.N(this.ussdCode_);
    }

    public boolean getWithIntent() {
        return this.withIntent_;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MyBankStruct$NewMyBankItemPayload myBankStruct$NewMyBankItemPayload) {
        return (a) DEFAULT_INSTANCE.createBuilder(myBankStruct$NewMyBankItemPayload);
    }

    public static MyBankStruct$NewMyBankItemPayload parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(AbstractC2383g abstractC2383g) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMenuItems(int i, MyBankStruct$NewMyBankItem myBankStruct$NewMyBankItem) {
        myBankStruct$NewMyBankItem.getClass();
        ensureMenuItemsIsMutable();
        this.menuItems_.add(i, myBankStruct$NewMyBankItem);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(byte[] bArr) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(byte[] bArr, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(InputStream inputStream) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(AbstractC2384h abstractC2384h) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MyBankStruct$NewMyBankItemPayload parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MyBankStruct$NewMyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
