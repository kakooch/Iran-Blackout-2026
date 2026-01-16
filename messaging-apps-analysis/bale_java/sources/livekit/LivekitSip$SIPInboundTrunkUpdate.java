package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.BF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$ListUpdate;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPInboundTrunkUpdate extends GeneratedMessageLite implements U64 {
    public static final int ALLOWED_ADDRESSES_FIELD_NUMBER = 2;
    public static final int ALLOWED_NUMBERS_FIELD_NUMBER = 3;
    public static final int AUTH_PASSWORD_FIELD_NUMBER = 5;
    public static final int AUTH_USERNAME_FIELD_NUMBER = 4;
    private static final LivekitSip$SIPInboundTrunkUpdate DEFAULT_INSTANCE;
    public static final int MEDIA_ENCRYPTION_FIELD_NUMBER = 8;
    public static final int METADATA_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 6;
    public static final int NUMBERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private LivekitModels$ListUpdate allowedAddresses_;
    private LivekitModels$ListUpdate allowedNumbers_;
    private int bitField0_;
    private int mediaEncryption_;
    private LivekitModels$ListUpdate numbers_;
    private String authUsername_ = "";
    private String authPassword_ = "";
    private String name_ = "";
    private String metadata_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$SIPInboundTrunkUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$SIPInboundTrunkUpdate livekitSip$SIPInboundTrunkUpdate = new LivekitSip$SIPInboundTrunkUpdate();
        DEFAULT_INSTANCE = livekitSip$SIPInboundTrunkUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPInboundTrunkUpdate.class, livekitSip$SIPInboundTrunkUpdate);
    }

    private LivekitSip$SIPInboundTrunkUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowedAddresses() {
        this.allowedAddresses_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowedNumbers() {
        this.allowedNumbers_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthPassword() {
        this.bitField0_ &= -3;
        this.authPassword_ = getDefaultInstance().getAuthPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthUsername() {
        this.bitField0_ &= -2;
        this.authUsername_ = getDefaultInstance().getAuthUsername();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaEncryption() {
        this.bitField0_ &= -17;
        this.mediaEncryption_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.bitField0_ &= -9;
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -5;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumbers() {
        this.numbers_ = null;
    }

    public static LivekitSip$SIPInboundTrunkUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAllowedAddresses(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        livekitModels$ListUpdate.getClass();
        LivekitModels$ListUpdate livekitModels$ListUpdate2 = this.allowedAddresses_;
        if (livekitModels$ListUpdate2 == null || livekitModels$ListUpdate2 == LivekitModels$ListUpdate.getDefaultInstance()) {
            this.allowedAddresses_ = livekitModels$ListUpdate;
        } else {
            this.allowedAddresses_ = (LivekitModels$ListUpdate) ((LivekitModels$ListUpdate.a) LivekitModels$ListUpdate.newBuilder(this.allowedAddresses_).v(livekitModels$ListUpdate)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAllowedNumbers(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        livekitModels$ListUpdate.getClass();
        LivekitModels$ListUpdate livekitModels$ListUpdate2 = this.allowedNumbers_;
        if (livekitModels$ListUpdate2 == null || livekitModels$ListUpdate2 == LivekitModels$ListUpdate.getDefaultInstance()) {
            this.allowedNumbers_ = livekitModels$ListUpdate;
        } else {
            this.allowedNumbers_ = (LivekitModels$ListUpdate) ((LivekitModels$ListUpdate.a) LivekitModels$ListUpdate.newBuilder(this.allowedNumbers_).v(livekitModels$ListUpdate)).j();
        }
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

    public static LivekitSip$SIPInboundTrunkUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllowedAddresses(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        livekitModels$ListUpdate.getClass();
        this.allowedAddresses_ = livekitModels$ListUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllowedNumbers(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        livekitModels$ListUpdate.getClass();
        this.allowedNumbers_ = livekitModels$ListUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthPassword(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.authPassword_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.authPassword_ = abstractC2383g.f0();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthUsername(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.authUsername_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthUsernameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.authUsername_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryption(BF3 bf3) {
        this.mediaEncryption_ = bf3.getNumber();
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryptionValue(int i) {
        this.bitField0_ |= 16;
        this.mediaEncryption_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.metadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.metadata_ = abstractC2383g.f0();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumbers(LivekitModels$ListUpdate livekitModels$ListUpdate) {
        livekitModels$ListUpdate.getClass();
        this.numbers_ = livekitModels$ListUpdate;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPInboundTrunkUpdate();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\t\u0002\t\u0003\t\u0004ለ\u0000\u0005ለ\u0001\u0006ለ\u0002\u0007ለ\u0003\bဌ\u0004", new Object[]{"bitField0_", "numbers_", "allowedAddresses_", "allowedNumbers_", "authUsername_", "authPassword_", "name_", "metadata_", "mediaEncryption_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPInboundTrunkUpdate.class) {
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

    public LivekitModels$ListUpdate getAllowedAddresses() {
        LivekitModels$ListUpdate livekitModels$ListUpdate = this.allowedAddresses_;
        return livekitModels$ListUpdate == null ? LivekitModels$ListUpdate.getDefaultInstance() : livekitModels$ListUpdate;
    }

    public LivekitModels$ListUpdate getAllowedNumbers() {
        LivekitModels$ListUpdate livekitModels$ListUpdate = this.allowedNumbers_;
        return livekitModels$ListUpdate == null ? LivekitModels$ListUpdate.getDefaultInstance() : livekitModels$ListUpdate;
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

    public boolean hasAllowedAddresses() {
        return this.allowedAddresses_ != null;
    }

    public boolean hasAllowedNumbers() {
        return this.allowedNumbers_ != null;
    }

    public boolean hasAuthPassword() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasAuthUsername() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMediaEncryption() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasMetadata() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasNumbers() {
        return this.numbers_ != null;
    }

    public static a newBuilder(LivekitSip$SIPInboundTrunkUpdate livekitSip$SIPInboundTrunkUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPInboundTrunkUpdate);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(byte[] bArr) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPInboundTrunkUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPInboundTrunkUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
