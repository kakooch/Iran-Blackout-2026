package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.FF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

@Deprecated
/* loaded from: classes8.dex */
public final class LivekitSip$SIPTrunkInfo extends GeneratedMessageLite implements u {
    private static final LivekitSip$SIPTrunkInfo DEFAULT_INSTANCE;
    public static final int INBOUND_ADDRESSES_FIELD_NUMBER = 2;
    public static final int INBOUND_NUMBERS_FIELD_NUMBER = 10;
    public static final int INBOUND_NUMBERS_REGEX_FIELD_NUMBER = 5;
    public static final int INBOUND_PASSWORD_FIELD_NUMBER = 7;
    public static final int INBOUND_USERNAME_FIELD_NUMBER = 6;
    public static final int KIND_FIELD_NUMBER = 14;
    public static final int METADATA_FIELD_NUMBER = 12;
    public static final int NAME_FIELD_NUMBER = 11;
    public static final int OUTBOUND_ADDRESS_FIELD_NUMBER = 3;
    public static final int OUTBOUND_NUMBER_FIELD_NUMBER = 4;
    public static final int OUTBOUND_PASSWORD_FIELD_NUMBER = 9;
    public static final int OUTBOUND_USERNAME_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int SIP_TRUNK_ID_FIELD_NUMBER = 1;
    public static final int TRANSPORT_FIELD_NUMBER = 13;
    private int kind_;
    private int transport_;
    private String sipTrunkId_ = "";
    private B.j inboundAddresses_ = GeneratedMessageLite.emptyProtobufList();
    private String outboundAddress_ = "";
    private String outboundNumber_ = "";
    private B.j inboundNumbersRegex_ = GeneratedMessageLite.emptyProtobufList();
    private B.j inboundNumbers_ = GeneratedMessageLite.emptyProtobufList();
    private String inboundUsername_ = "";
    private String inboundPassword_ = "";
    private String outboundUsername_ = "";
    private String outboundPassword_ = "";
    private String name_ = "";
    private String metadata_ = "";

    public static final class a extends GeneratedMessageLite.b implements u {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$SIPTrunkInfo.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        TRUNK_LEGACY(0),
        TRUNK_INBOUND(1),
        TRUNK_OUTBOUND(2),
        UNRECOGNIZED(-1);

        private static final B.d f = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.j(i);
            }
        }

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRUNK_LEGACY;
            }
            if (i == 1) {
                return TRUNK_INBOUND;
            }
            if (i != 2) {
                return null;
            }
            return TRUNK_OUTBOUND;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        LivekitSip$SIPTrunkInfo livekitSip$SIPTrunkInfo = new LivekitSip$SIPTrunkInfo();
        DEFAULT_INSTANCE = livekitSip$SIPTrunkInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPTrunkInfo.class, livekitSip$SIPTrunkInfo);
    }

    private LivekitSip$SIPTrunkInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllInboundAddresses(Iterable<String> iterable) {
        ensureInboundAddressesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.inboundAddresses_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllInboundNumbers(Iterable<String> iterable) {
        ensureInboundNumbersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.inboundNumbers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllInboundNumbersRegex(Iterable<String> iterable) {
        ensureInboundNumbersRegexIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.inboundNumbersRegex_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInboundAddresses(String str) {
        str.getClass();
        ensureInboundAddressesIsMutable();
        this.inboundAddresses_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInboundAddressesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureInboundAddressesIsMutable();
        this.inboundAddresses_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInboundNumbers(String str) {
        str.getClass();
        ensureInboundNumbersIsMutable();
        this.inboundNumbers_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInboundNumbersBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureInboundNumbersIsMutable();
        this.inboundNumbers_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInboundNumbersRegex(String str) {
        str.getClass();
        ensureInboundNumbersRegexIsMutable();
        this.inboundNumbersRegex_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInboundNumbersRegexBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureInboundNumbersRegexIsMutable();
        this.inboundNumbersRegex_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInboundAddresses() {
        this.inboundAddresses_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInboundNumbers() {
        this.inboundNumbers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInboundNumbersRegex() {
        this.inboundNumbersRegex_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInboundPassword() {
        this.inboundPassword_ = getDefaultInstance().getInboundPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInboundUsername() {
        this.inboundUsername_ = getDefaultInstance().getInboundUsername();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutboundAddress() {
        this.outboundAddress_ = getDefaultInstance().getOutboundAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutboundNumber() {
        this.outboundNumber_ = getDefaultInstance().getOutboundNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutboundPassword() {
        this.outboundPassword_ = getDefaultInstance().getOutboundPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutboundUsername() {
        this.outboundUsername_ = getDefaultInstance().getOutboundUsername();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipTrunkId() {
        this.sipTrunkId_ = getDefaultInstance().getSipTrunkId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransport() {
        this.transport_ = 0;
    }

    private void ensureInboundAddressesIsMutable() {
        B.j jVar = this.inboundAddresses_;
        if (jVar.u()) {
            return;
        }
        this.inboundAddresses_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureInboundNumbersIsMutable() {
        B.j jVar = this.inboundNumbers_;
        if (jVar.u()) {
            return;
        }
        this.inboundNumbers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureInboundNumbersRegexIsMutable() {
        B.j jVar = this.inboundNumbersRegex_;
        if (jVar.u()) {
            return;
        }
        this.inboundNumbersRegex_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitSip$SIPTrunkInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPTrunkInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInboundAddresses(int i, String str) {
        str.getClass();
        ensureInboundAddressesIsMutable();
        this.inboundAddresses_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInboundNumbers(int i, String str) {
        str.getClass();
        ensureInboundNumbersIsMutable();
        this.inboundNumbers_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInboundNumbersRegex(int i, String str) {
        str.getClass();
        ensureInboundNumbersRegexIsMutable();
        this.inboundNumbersRegex_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInboundPassword(String str) {
        str.getClass();
        this.inboundPassword_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInboundPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.inboundPassword_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInboundUsername(String str) {
        str.getClass();
        this.inboundUsername_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInboundUsernameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.inboundUsername_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKind(b bVar) {
        this.kind_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindValue(int i) {
        this.kind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(String str) {
        str.getClass();
        this.metadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.metadata_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutboundAddress(String str) {
        str.getClass();
        this.outboundAddress_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutboundAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.outboundAddress_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutboundNumber(String str) {
        str.getClass();
        this.outboundNumber_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutboundNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.outboundNumber_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutboundPassword(String str) {
        str.getClass();
        this.outboundPassword_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutboundPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.outboundPassword_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutboundUsername(String str) {
        str.getClass();
        this.outboundUsername_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutboundUsernameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.outboundUsername_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkId(String str) {
        str.getClass();
        this.sipTrunkId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipTrunkId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransport(FF3 ff3) {
        this.transport_ = ff3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransportValue(int i) {
        this.transport_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPTrunkInfo();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0000\u0001\u000e\u000e\u0000\u0003\u0000\u0001Ȉ\u0002Ț\u0003Ȉ\u0004Ȉ\u0005Ț\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȚ\u000bȈ\fȈ\r\f\u000e\f", new Object[]{"sipTrunkId_", "inboundAddresses_", "outboundAddress_", "outboundNumber_", "inboundNumbersRegex_", "inboundUsername_", "inboundPassword_", "outboundUsername_", "outboundPassword_", "inboundNumbers_", "name_", "metadata_", "transport_", "kind_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPTrunkInfo.class) {
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

    public String getInboundAddresses(int i) {
        return (String) this.inboundAddresses_.get(i);
    }

    public AbstractC2383g getInboundAddressesBytes(int i) {
        return AbstractC2383g.N((String) this.inboundAddresses_.get(i));
    }

    public int getInboundAddressesCount() {
        return this.inboundAddresses_.size();
    }

    public List<String> getInboundAddressesList() {
        return this.inboundAddresses_;
    }

    public String getInboundNumbers(int i) {
        return (String) this.inboundNumbers_.get(i);
    }

    public AbstractC2383g getInboundNumbersBytes(int i) {
        return AbstractC2383g.N((String) this.inboundNumbers_.get(i));
    }

    public int getInboundNumbersCount() {
        return this.inboundNumbers_.size();
    }

    public List<String> getInboundNumbersList() {
        return this.inboundNumbers_;
    }

    @Deprecated
    public String getInboundNumbersRegex(int i) {
        return (String) this.inboundNumbersRegex_.get(i);
    }

    @Deprecated
    public AbstractC2383g getInboundNumbersRegexBytes(int i) {
        return AbstractC2383g.N((String) this.inboundNumbersRegex_.get(i));
    }

    @Deprecated
    public int getInboundNumbersRegexCount() {
        return this.inboundNumbersRegex_.size();
    }

    @Deprecated
    public List<String> getInboundNumbersRegexList() {
        return this.inboundNumbersRegex_;
    }

    public String getInboundPassword() {
        return this.inboundPassword_;
    }

    public AbstractC2383g getInboundPasswordBytes() {
        return AbstractC2383g.N(this.inboundPassword_);
    }

    public String getInboundUsername() {
        return this.inboundUsername_;
    }

    public AbstractC2383g getInboundUsernameBytes() {
        return AbstractC2383g.N(this.inboundUsername_);
    }

    public b getKind() {
        b bVarJ = b.j(this.kind_);
        return bVarJ == null ? b.UNRECOGNIZED : bVarJ;
    }

    public int getKindValue() {
        return this.kind_;
    }

    public String getMetadata() {
        return this.metadata_;
    }

    public AbstractC2383g getMetadataBytes() {
        return AbstractC2383g.N(this.metadata_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getOutboundAddress() {
        return this.outboundAddress_;
    }

    public AbstractC2383g getOutboundAddressBytes() {
        return AbstractC2383g.N(this.outboundAddress_);
    }

    public String getOutboundNumber() {
        return this.outboundNumber_;
    }

    public AbstractC2383g getOutboundNumberBytes() {
        return AbstractC2383g.N(this.outboundNumber_);
    }

    public String getOutboundPassword() {
        return this.outboundPassword_;
    }

    public AbstractC2383g getOutboundPasswordBytes() {
        return AbstractC2383g.N(this.outboundPassword_);
    }

    public String getOutboundUsername() {
        return this.outboundUsername_;
    }

    public AbstractC2383g getOutboundUsernameBytes() {
        return AbstractC2383g.N(this.outboundUsername_);
    }

    public String getSipTrunkId() {
        return this.sipTrunkId_;
    }

    public AbstractC2383g getSipTrunkIdBytes() {
        return AbstractC2383g.N(this.sipTrunkId_);
    }

    public FF3 getTransport() {
        FF3 ff3J = FF3.j(this.transport_);
        return ff3J == null ? FF3.UNRECOGNIZED : ff3J;
    }

    public int getTransportValue() {
        return this.transport_;
    }

    public static a newBuilder(LivekitSip$SIPTrunkInfo livekitSip$SIPTrunkInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPTrunkInfo);
    }

    public static LivekitSip$SIPTrunkInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(byte[] bArr) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPTrunkInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
