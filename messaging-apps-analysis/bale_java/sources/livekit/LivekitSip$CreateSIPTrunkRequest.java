package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

@Deprecated
/* loaded from: classes8.dex */
public final class LivekitSip$CreateSIPTrunkRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$CreateSIPTrunkRequest DEFAULT_INSTANCE;
    public static final int INBOUND_ADDRESSES_FIELD_NUMBER = 1;
    public static final int INBOUND_NUMBERS_FIELD_NUMBER = 9;
    public static final int INBOUND_NUMBERS_REGEX_FIELD_NUMBER = 4;
    public static final int INBOUND_PASSWORD_FIELD_NUMBER = 6;
    public static final int INBOUND_USERNAME_FIELD_NUMBER = 5;
    public static final int METADATA_FIELD_NUMBER = 11;
    public static final int NAME_FIELD_NUMBER = 10;
    public static final int OUTBOUND_ADDRESS_FIELD_NUMBER = 2;
    public static final int OUTBOUND_NUMBER_FIELD_NUMBER = 3;
    public static final int OUTBOUND_PASSWORD_FIELD_NUMBER = 8;
    public static final int OUTBOUND_USERNAME_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER;
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

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$CreateSIPTrunkRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$CreateSIPTrunkRequest livekitSip$CreateSIPTrunkRequest = new LivekitSip$CreateSIPTrunkRequest();
        DEFAULT_INSTANCE = livekitSip$CreateSIPTrunkRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$CreateSIPTrunkRequest.class, livekitSip$CreateSIPTrunkRequest);
    }

    private LivekitSip$CreateSIPTrunkRequest() {
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

    public static LivekitSip$CreateSIPTrunkRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$CreateSIPTrunkRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$CreateSIPTrunkRequest();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0000\u0003\u0000\u0001Ț\u0002Ȉ\u0003Ȉ\u0004Ț\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȚ\nȈ\u000bȈ", new Object[]{"inboundAddresses_", "outboundAddress_", "outboundNumber_", "inboundNumbersRegex_", "inboundUsername_", "inboundPassword_", "outboundUsername_", "outboundPassword_", "inboundNumbers_", "name_", "metadata_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$CreateSIPTrunkRequest.class) {
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

    public static a newBuilder(LivekitSip$CreateSIPTrunkRequest livekitSip$CreateSIPTrunkRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$CreateSIPTrunkRequest);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(byte[] bArr) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$CreateSIPTrunkRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$CreateSIPTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
