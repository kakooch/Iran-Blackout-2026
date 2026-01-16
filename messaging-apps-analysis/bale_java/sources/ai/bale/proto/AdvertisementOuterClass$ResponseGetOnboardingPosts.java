package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22701vh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetOnboardingPosts extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetOnboardingPosts DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POSTS_FIELD_NUMBER = 1;
    private B.j posts_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetOnboardingPosts.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetOnboardingPosts advertisementOuterClass$ResponseGetOnboardingPosts = new AdvertisementOuterClass$ResponseGetOnboardingPosts();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetOnboardingPosts;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetOnboardingPosts.class, advertisementOuterClass$ResponseGetOnboardingPosts);
    }

    private AdvertisementOuterClass$ResponseGetOnboardingPosts() {
    }

    private void addAllPosts(Iterable<? extends AdvertisementStruct$OnboardingPost> iterable) {
        ensurePostsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.posts_);
    }

    private void addPosts(int i, AdvertisementStruct$OnboardingPost advertisementStruct$OnboardingPost) {
        advertisementStruct$OnboardingPost.getClass();
        ensurePostsIsMutable();
        this.posts_.add(i, advertisementStruct$OnboardingPost);
    }

    private void clearPosts() {
        this.posts_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePostsIsMutable() {
        B.j jVar = this.posts_;
        if (jVar.u()) {
            return;
        }
        this.posts_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePosts(int i) {
        ensurePostsIsMutable();
        this.posts_.remove(i);
    }

    private void setPosts(int i, AdvertisementStruct$OnboardingPost advertisementStruct$OnboardingPost) {
        advertisementStruct$OnboardingPost.getClass();
        ensurePostsIsMutable();
        this.posts_.set(i, advertisementStruct$OnboardingPost);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetOnboardingPosts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"posts_", AdvertisementStruct$OnboardingPost.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetOnboardingPosts.class) {
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

    public AdvertisementStruct$OnboardingPost getPosts(int i) {
        return (AdvertisementStruct$OnboardingPost) this.posts_.get(i);
    }

    public int getPostsCount() {
        return this.posts_.size();
    }

    public List<AdvertisementStruct$OnboardingPost> getPostsList() {
        return this.posts_;
    }

    public InterfaceC22701vh getPostsOrBuilder(int i) {
        return (InterfaceC22701vh) this.posts_.get(i);
    }

    public List<? extends InterfaceC22701vh> getPostsOrBuilderList() {
        return this.posts_;
    }

    private void addPosts(AdvertisementStruct$OnboardingPost advertisementStruct$OnboardingPost) {
        advertisementStruct$OnboardingPost.getClass();
        ensurePostsIsMutable();
        this.posts_.add(advertisementStruct$OnboardingPost);
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetOnboardingPosts advertisementOuterClass$ResponseGetOnboardingPosts) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetOnboardingPosts);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingPosts parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingPosts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
