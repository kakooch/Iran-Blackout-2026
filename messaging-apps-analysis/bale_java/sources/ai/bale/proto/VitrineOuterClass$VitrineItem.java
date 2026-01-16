package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineOuterClass$VitrineItem extends GeneratedMessageLite implements U64 {
    private static final VitrineOuterClass$VitrineItem DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 2;
    public static final int INDEX_FIELD_NUMBER = 1;
    public static final int NICKNAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 4;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;
    private int index_;
    private String id_ = "";
    private String nickname_ = "";
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$VitrineItem.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$VitrineItem vitrineOuterClass$VitrineItem = new VitrineOuterClass$VitrineItem();
        DEFAULT_INSTANCE = vitrineOuterClass$VitrineItem;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$VitrineItem.class, vitrineOuterClass$VitrineItem);
    }

    private VitrineOuterClass$VitrineItem() {
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearIndex() {
        this.index_ = 0;
    }

    private void clearNickname() {
        this.nickname_ = getDefaultInstance().getNickname();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static VitrineOuterClass$VitrineItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$VitrineItem parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setIndex(int i) {
        this.index_ = i;
    }

    private void setNickname(String str) {
        str.getClass();
        this.nickname_ = str;
    }

    private void setNicknameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nickname_ = abstractC2383g.f0();
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$VitrineItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005ဉ\u0000", new Object[]{"bitField0_", "index_", "id_", "nickname_", "title_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$VitrineItem.class) {
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

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public int getIndex() {
        return this.index_;
    }

    public String getNickname() {
        return this.nickname_;
    }

    public AbstractC2383g getNicknameBytes() {
        return AbstractC2383g.N(this.nickname_);
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(VitrineOuterClass$VitrineItem vitrineOuterClass$VitrineItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$VitrineItem);
    }

    public static VitrineOuterClass$VitrineItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(byte[] bArr) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$VitrineItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$VitrineItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
