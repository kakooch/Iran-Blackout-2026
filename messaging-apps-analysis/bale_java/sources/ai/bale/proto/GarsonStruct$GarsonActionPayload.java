package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonMenu;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonActionPayload extends GeneratedMessageLite implements U64 {
    private static final GarsonStruct$GarsonActionPayload DEFAULT_INSTANCE;
    public static final int EMPTY_FIELD_NUMBER = 1;
    public static final int MENU_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 2;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonStruct$GarsonActionPayload.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        EMPTY(1),
        URL(2),
        PEER(3),
        MENU(4),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return EMPTY;
            }
            if (i == 2) {
                return URL;
            }
            if (i == 3) {
                return PEER;
            }
            if (i != 4) {
                return null;
            }
            return MENU;
        }
    }

    static {
        GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload = new GarsonStruct$GarsonActionPayload();
        DEFAULT_INSTANCE = garsonStruct$GarsonActionPayload;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonActionPayload.class, garsonStruct$GarsonActionPayload);
    }

    private GarsonStruct$GarsonActionPayload() {
    }

    private void clearEmpty() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMenu() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPeer() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearUrl() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    public static GarsonStruct$GarsonActionPayload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeEmpty(Empty empty) {
        empty.getClass();
        if (this.traitCase_ != 1 || this.trait_ == Empty.getDefaultInstance()) {
            this.trait_ = empty;
        } else {
            this.trait_ = ((Empty.b) Empty.newBuilder((Empty) this.trait_).v(empty)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeMenu(GarsonStruct$GarsonMenu garsonStruct$GarsonMenu) {
        garsonStruct$GarsonMenu.getClass();
        if (this.traitCase_ != 4 || this.trait_ == GarsonStruct$GarsonMenu.getDefaultInstance()) {
            this.trait_ = garsonStruct$GarsonMenu;
        } else {
            this.trait_ = ((GarsonStruct$GarsonMenu.a) GarsonStruct$GarsonMenu.newBuilder((GarsonStruct$GarsonMenu) this.trait_).v(garsonStruct$GarsonMenu)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        if (this.traitCase_ != 3 || this.trait_ == PeersStruct$OutPeer.getDefaultInstance()) {
            this.trait_ = peersStruct$OutPeer;
        } else {
            this.trait_ = ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder((PeersStruct$OutPeer) this.trait_).v(peersStruct$OutPeer)).j();
        }
        this.traitCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonActionPayload parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEmpty(Empty empty) {
        empty.getClass();
        this.trait_ = empty;
        this.traitCase_ = 1;
    }

    private void setMenu(GarsonStruct$GarsonMenu garsonStruct$GarsonMenu) {
        garsonStruct$GarsonMenu.getClass();
        this.trait_ = garsonStruct$GarsonMenu;
        this.traitCase_ = 4;
    }

    private void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.trait_ = peersStruct$OutPeer;
        this.traitCase_ = 3;
    }

    private void setUrl(String str) {
        str.getClass();
        this.traitCase_ = 2;
        this.trait_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trait_ = abstractC2383g.f0();
        this.traitCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonActionPayload();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"trait_", "traitCase_", Empty.class, PeersStruct$OutPeer.class, GarsonStruct$GarsonMenu.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonActionPayload.class) {
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

    public Empty getEmpty() {
        return this.traitCase_ == 1 ? (Empty) this.trait_ : Empty.getDefaultInstance();
    }

    public GarsonStruct$GarsonMenu getMenu() {
        return this.traitCase_ == 4 ? (GarsonStruct$GarsonMenu) this.trait_ : GarsonStruct$GarsonMenu.getDefaultInstance();
    }

    public PeersStruct$OutPeer getPeer() {
        return this.traitCase_ == 3 ? (PeersStruct$OutPeer) this.trait_ : PeersStruct$OutPeer.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public String getUrl() {
        return this.traitCase_ == 2 ? (String) this.trait_ : "";
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.traitCase_ == 2 ? (String) this.trait_ : "");
    }

    public boolean hasEmpty() {
        return this.traitCase_ == 1;
    }

    public boolean hasMenu() {
        return this.traitCase_ == 4;
    }

    public boolean hasPeer() {
        return this.traitCase_ == 3;
    }

    public boolean hasUrl() {
        return this.traitCase_ == 2;
    }

    public static a newBuilder(GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonActionPayload);
    }

    public static GarsonStruct$GarsonActionPayload parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonActionPayload parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
