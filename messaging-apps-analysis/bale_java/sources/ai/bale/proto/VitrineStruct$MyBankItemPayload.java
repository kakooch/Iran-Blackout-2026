package ai.bale.proto;

import ai.bale.proto.VitrineStruct$MyBankPeer;
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
public final class VitrineStruct$MyBankItemPayload extends GeneratedMessageLite implements U64 {
    private static final VitrineStruct$MyBankItemPayload DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
    public static final int USSD_CODE_FIELD_NUMBER = 3;
    public static final int WITHINTENT_FIELD_NUMBER = 4;
    private int bitField0_;
    private VitrineStruct$MyBankPeer peer_;
    private String url_ = "";
    private String ussdCode_ = "";
    private boolean withIntent_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineStruct$MyBankItemPayload.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineStruct$MyBankItemPayload vitrineStruct$MyBankItemPayload = new VitrineStruct$MyBankItemPayload();
        DEFAULT_INSTANCE = vitrineStruct$MyBankItemPayload;
        GeneratedMessageLite.registerDefaultInstance(VitrineStruct$MyBankItemPayload.class, vitrineStruct$MyBankItemPayload);
    }

    private VitrineStruct$MyBankItemPayload() {
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

    public static VitrineStruct$MyBankItemPayload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(VitrineStruct$MyBankPeer vitrineStruct$MyBankPeer) {
        vitrineStruct$MyBankPeer.getClass();
        VitrineStruct$MyBankPeer vitrineStruct$MyBankPeer2 = this.peer_;
        if (vitrineStruct$MyBankPeer2 == null || vitrineStruct$MyBankPeer2 == VitrineStruct$MyBankPeer.getDefaultInstance()) {
            this.peer_ = vitrineStruct$MyBankPeer;
        } else {
            this.peer_ = (VitrineStruct$MyBankPeer) ((VitrineStruct$MyBankPeer.a) VitrineStruct$MyBankPeer.newBuilder(this.peer_).v(vitrineStruct$MyBankPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineStruct$MyBankItemPayload parseDelimitedFrom(InputStream inputStream) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(ByteBuffer byteBuffer) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeer(VitrineStruct$MyBankPeer vitrineStruct$MyBankPeer) {
        vitrineStruct$MyBankPeer.getClass();
        this.peer_ = vitrineStruct$MyBankPeer;
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
        switch (t2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineStruct$MyBankItemPayload();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003Ȉ\u0004\u0007", new Object[]{"bitField0_", "url_", "peer_", "ussdCode_", "withIntent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineStruct$MyBankItemPayload.class) {
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

    public VitrineStruct$MyBankPeer getPeer() {
        VitrineStruct$MyBankPeer vitrineStruct$MyBankPeer = this.peer_;
        return vitrineStruct$MyBankPeer == null ? VitrineStruct$MyBankPeer.getDefaultInstance() : vitrineStruct$MyBankPeer;
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

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(VitrineStruct$MyBankItemPayload vitrineStruct$MyBankItemPayload) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineStruct$MyBankItemPayload);
    }

    public static VitrineStruct$MyBankItemPayload parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(byte[] bArr) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(InputStream inputStream) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineStruct$MyBankItemPayload parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineStruct$MyBankItemPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
