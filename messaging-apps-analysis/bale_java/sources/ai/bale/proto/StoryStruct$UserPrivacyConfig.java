package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC21337tU6;
import ir.nasim.KW4;
import ir.nasim.ZU6;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryStruct$UserPrivacyConfig extends GeneratedMessageLite implements ZU6 {
    public static final int CREATED_AT_FIELD_NUMBER = 4;
    private static final StoryStruct$UserPrivacyConfig DEFAULT_INSTANCE;
    public static final int EXCEPTION_FIELD_NUMBER = 3;
    public static final int EXCEPTION_TOGGLE_FIELD_NUMBER = 6;
    public static final int EXCEPTION_USER_IDS_FIELD_NUMBER = 2;
    public static final int IS_ACTIVE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int USERID_FIELD_NUMBER = 1;
    private long createdAt_;
    private boolean exceptionToggle_;
    private int exceptionUserIdsMemoizedSerializedSize = -1;
    private B.g exceptionUserIds_ = GeneratedMessageLite.emptyIntList();
    private int exception_;
    private boolean isActive_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements ZU6 {
        public a A(Iterable iterable) {
            q();
            ((StoryStruct$UserPrivacyConfig) this.b).addAllExceptionUserIds(iterable);
            return this;
        }

        public a B(EnumC21337tU6 enumC21337tU6) {
            q();
            ((StoryStruct$UserPrivacyConfig) this.b).setException(enumC21337tU6);
            return this;
        }

        public a C(boolean z) {
            q();
            ((StoryStruct$UserPrivacyConfig) this.b).setIsActive(z);
            return this;
        }

        private a() {
            super(StoryStruct$UserPrivacyConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig = new StoryStruct$UserPrivacyConfig();
        DEFAULT_INSTANCE = storyStruct$UserPrivacyConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$UserPrivacyConfig.class, storyStruct$UserPrivacyConfig);
    }

    private StoryStruct$UserPrivacyConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllExceptionUserIds(Iterable<? extends Integer> iterable) {
        ensureExceptionUserIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.exceptionUserIds_);
    }

    private void addExceptionUserIds(int i) {
        ensureExceptionUserIdsIsMutable();
        this.exceptionUserIds_.b1(i);
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearException() {
        this.exception_ = 0;
    }

    private void clearExceptionToggle() {
        this.exceptionToggle_ = false;
    }

    private void clearExceptionUserIds() {
        this.exceptionUserIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearIsActive() {
        this.isActive_ = false;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    private void ensureExceptionUserIdsIsMutable() {
        B.g gVar = this.exceptionUserIds_;
        if (gVar.u()) {
            return;
        }
        this.exceptionUserIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static StoryStruct$UserPrivacyConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$UserPrivacyConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setException(EnumC21337tU6 enumC21337tU6) {
        this.exception_ = enumC21337tU6.getNumber();
    }

    private void setExceptionToggle(boolean z) {
        this.exceptionToggle_ = z;
    }

    private void setExceptionUserIds(int i, int i2) {
        ensureExceptionUserIdsIsMutable();
        this.exceptionUserIds_.U(i, i2);
    }

    private void setExceptionValue(int i) {
        this.exception_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsActive(boolean z) {
        this.isActive_ = z;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$UserPrivacyConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0002'\u0003\f\u0004\u0002\u0005\u0007\u0006\u0007", new Object[]{"userId_", "exceptionUserIds_", "exception_", "createdAt_", "isActive_", "exceptionToggle_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$UserPrivacyConfig.class) {
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

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public EnumC21337tU6 getException() {
        EnumC21337tU6 enumC21337tU6J = EnumC21337tU6.j(this.exception_);
        return enumC21337tU6J == null ? EnumC21337tU6.UNRECOGNIZED : enumC21337tU6J;
    }

    public boolean getExceptionToggle() {
        return this.exceptionToggle_;
    }

    public int getExceptionUserIds(int i) {
        return this.exceptionUserIds_.getInt(i);
    }

    public int getExceptionUserIdsCount() {
        return this.exceptionUserIds_.size();
    }

    public List<Integer> getExceptionUserIdsList() {
        return this.exceptionUserIds_;
    }

    public int getExceptionValue() {
        return this.exception_;
    }

    public boolean getIsActive() {
        return this.isActive_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$UserPrivacyConfig);
    }

    public static StoryStruct$UserPrivacyConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(byte[] bArr) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(InputStream inputStream) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$UserPrivacyConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$UserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
