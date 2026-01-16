package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.BF3;
import ir.nasim.FF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$ListUpdate;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPOutboundTrunkUpdate extends GeneratedMessageLite implements U64 {
    public static final int ADDRESS_FIELD_NUMBER = 1;
    public static final int AUTH_PASSWORD_FIELD_NUMBER = 5;
    public static final int AUTH_USERNAME_FIELD_NUMBER = 4;
    private static final LivekitSip$SIPOutboundTrunkUpdate DEFAULT_INSTANCE;
    public static final int DESTINATION_COUNTRY_FIELD_NUMBER = 9;
    public static final int MEDIA_ENCRYPTION_FIELD_NUMBER = 8;
    public static final int METADATA_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 6;
    public static final int NUMBERS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TRANSPORT_FIELD_NUMBER = 2;
    private int bitField0_;
    private int mediaEncryption_;
    private LivekitModels$ListUpdate numbers_;
    private int transport_;
    private String address_ = "";
    private String destinationCountry_ = "";
    private String authUsername_ = "";
    private String authPassword_ = "";
    private String name_ = "";
    private String metadata_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$SIPOutboundTrunkUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$SIPOutboundTrunkUpdate livekitSip$SIPOutboundTrunkUpdate = new LivekitSip$SIPOutboundTrunkUpdate();
        DEFAULT_INSTANCE = livekitSip$SIPOutboundTrunkUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPOutboundTrunkUpdate.class, livekitSip$SIPOutboundTrunkUpdate);
    }

    private LivekitSip$SIPOutboundTrunkUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddress() {
        this.bitField0_ &= -2;
        this.address_ = getDefaultInstance().getAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthPassword() {
        this.bitField0_ &= -17;
        this.authPassword_ = getDefaultInstance().getAuthPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthUsername() {
        this.bitField0_ &= -9;
        this.authUsername_ = getDefaultInstance().getAuthUsername();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinationCountry() {
        this.bitField0_ &= -5;
        this.destinationCountry_ = getDefaultInstance().getDestinationCountry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaEncryption() {
        this.bitField0_ &= -129;
        this.mediaEncryption_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.bitField0_ &= -65;
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -33;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumbers() {
        this.numbers_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransport() {
        this.bitField0_ &= -3;
        this.transport_ = 0;
    }

    public static LivekitSip$SIPOutboundTrunkUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeNumbers(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        livekitModels$ListUpdate.getClass();
        LivekitModels$ListUpdate livekitModels$ListUpdate2 = this.numbers_;
        if (livekitModels$ListUpdate2 == null || livekitModels$ListUpdate2 == LivekitModels$ListUpdate.getDefaultInstance()) {
            this.numbers_ = livekitModels$ListUpdate;
        } else {
            this.numbers_ = (LivekitModels$ListUpdate) ((LivekitModels$ListUpdate.a) LivekitModels$ListUpdate.newBuilder(this.numbers_).v(livekitModels$ListUpdate)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddress(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.address_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.address_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthPassword(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.authPassword_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.authPassword_ = abstractC2383g.f0();
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthUsername(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.authUsername_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthUsernameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.authUsername_ = abstractC2383g.f0();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationCountry(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.destinationCountry_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationCountryBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.destinationCountry_ = abstractC2383g.f0();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryption(BF3 bf3) {
        this.mediaEncryption_ = bf3.getNumber();
        this.bitField0_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryptionValue(int i) {
        this.bitField0_ |= 128;
        this.mediaEncryption_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.metadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.metadata_ = abstractC2383g.f0();
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumbers(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        livekitModels$ListUpdate.getClass();
        this.numbers_ = livekitModels$ListUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransport(FF3 ff3) {
        this.transport_ = ff3.getNumber();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransportValue(int i) {
        this.bitField0_ |= 2;
        this.transport_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPOutboundTrunkUpdate();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ለ\u0000\u0002ဌ\u0001\u0003\t\u0004ለ\u0003\u0005ለ\u0004\u0006ለ\u0005\u0007ለ\u0006\bဌ\u0007\tለ\u0002", new Object[]{"bitField0_", "address_", "transport_", "numbers_", "authUsername_", "authPassword_", "name_", "metadata_", "mediaEncryption_", "destinationCountry_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPOutboundTrunkUpdate.class) {
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

    public String getAddress() {
        return this.address_;
    }

    public AbstractC2383g getAddressBytes() {
        return AbstractC2383g.N(this.address_);
    }

    public String getAuthPassword() {
        return this.authPassword_;
    }

    public AbstractC2383g getAuthPasswordBytes() {
        return AbstractC2383g.N(this.authPassword_);
    }

    public String getAuthUsername() {
        return this.authUsername_;
    }

    public AbstractC2383g getAuthUsernameBytes() {
        return AbstractC2383g.N(this.authUsername_);
    }

    public String getDestinationCountry() {
        return this.destinationCountry_;
    }

    public AbstractC2383g getDestinationCountryBytes() {
        return AbstractC2383g.N(this.destinationCountry_);
    }

    public BF3 getMediaEncryption() {
        BF3 bf3J = BF3.j(this.mediaEncryption_);
        return bf3J == null ? BF3.UNRECOGNIZED : bf3J;
    }

    public int getMediaEncryptionValue() {
        return this.mediaEncryption_;
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

    public LivekitModels$ListUpdate getNumbers() {
        LivekitModels$ListUpdate livekitModels$ListUpdate = this.numbers_;
        return livekitModels$ListUpdate == null ? LivekitModels$ListUpdate.getDefaultInstance() : livekitModels$ListUpdate;
    }

    public FF3 getTransport() {
        FF3 ff3J = FF3.j(this.transport_);
        return ff3J == null ? FF3.UNRECOGNIZED : ff3J;
    }

    public int getTransportValue() {
        return this.transport_;
    }

    public boolean hasAddress() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasAuthPassword() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasAuthUsername() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasDestinationCountry() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMediaEncryption() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasMetadata() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasNumbers() {
        return this.numbers_ != null;
    }

    public boolean hasTransport() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(LivekitSip$SIPOutboundTrunkUpdate livekitSip$SIPOutboundTrunkUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPOutboundTrunkUpdate);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(byte[] bArr) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPOutboundTrunkUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
