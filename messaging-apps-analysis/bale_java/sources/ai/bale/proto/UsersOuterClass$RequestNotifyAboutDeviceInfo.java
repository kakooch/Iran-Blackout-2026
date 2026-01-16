package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestNotifyAboutDeviceInfo extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestNotifyAboutDeviceInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PREFERRED_LANGUAGES_FIELD_NUMBER = 1;
    public static final int TIME_ZONE_FIELD_NUMBER = 2;
    private int bitField0_;
    private B.j preferredLanguages_ = GeneratedMessageLite.emptyProtobufList();
    private StringValue timeZone_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((UsersOuterClass$RequestNotifyAboutDeviceInfo) this.b).addAllPreferredLanguages(iterable);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((UsersOuterClass$RequestNotifyAboutDeviceInfo) this.b).setTimeZone(stringValue);
            return this;
        }

        private a() {
            super(UsersOuterClass$RequestNotifyAboutDeviceInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestNotifyAboutDeviceInfo usersOuterClass$RequestNotifyAboutDeviceInfo = new UsersOuterClass$RequestNotifyAboutDeviceInfo();
        DEFAULT_INSTANCE = usersOuterClass$RequestNotifyAboutDeviceInfo;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestNotifyAboutDeviceInfo.class, usersOuterClass$RequestNotifyAboutDeviceInfo);
    }

    private UsersOuterClass$RequestNotifyAboutDeviceInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPreferredLanguages(Iterable<String> iterable) {
        ensurePreferredLanguagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.preferredLanguages_);
    }

    private void addPreferredLanguages(String str) {
        str.getClass();
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.add(str);
    }

    private void addPreferredLanguagesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.add(abstractC2383g.f0());
    }

    private void clearPreferredLanguages() {
        this.preferredLanguages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTimeZone() {
        this.timeZone_ = null;
        this.bitField0_ &= -2;
    }

    private void ensurePreferredLanguagesIsMutable() {
        B.j jVar = this.preferredLanguages_;
        if (jVar.u()) {
            return;
        }
        this.preferredLanguages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTimeZone(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.timeZone_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.timeZone_ = stringValue;
        } else {
            this.timeZone_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.timeZone_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPreferredLanguages(int i, String str) {
        str.getClass();
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeZone(StringValue stringValue) {
        stringValue.getClass();
        this.timeZone_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestNotifyAboutDeviceInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002ဉ\u0000", new Object[]{"bitField0_", "preferredLanguages_", "timeZone_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestNotifyAboutDeviceInfo.class) {
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

    public String getPreferredLanguages(int i) {
        return (String) this.preferredLanguages_.get(i);
    }

    public AbstractC2383g getPreferredLanguagesBytes(int i) {
        return AbstractC2383g.N((String) this.preferredLanguages_.get(i));
    }

    public int getPreferredLanguagesCount() {
        return this.preferredLanguages_.size();
    }

    public List<String> getPreferredLanguagesList() {
        return this.preferredLanguages_;
    }

    public StringValue getTimeZone() {
        StringValue stringValue = this.timeZone_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasTimeZone() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$RequestNotifyAboutDeviceInfo usersOuterClass$RequestNotifyAboutDeviceInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestNotifyAboutDeviceInfo);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestNotifyAboutDeviceInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestNotifyAboutDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
