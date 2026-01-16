package ir.appp.vod.data.source.mock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ir.appp.vod.data.source.VodDataSource;
import ir.appp.vod.domain.model.output.GetCastRelatedOutput;
import ir.appp.vod.domain.model.output.GetEpisodesOutput;
import ir.appp.vod.domain.model.output.GetRelatedOutput;
import ir.appp.vod.domain.model.output.VodMediaEntity;
import ir.appp.vod.domain.model.output.VodMediaEntityOutput;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: VodMockDataSource.kt */
/* loaded from: classes3.dex */
public final class VodMockDataSource implements VodDataSource {
    private final String mp4Url = "https://test-videos.co.uk/vids/bigbuckbunny/mp4/h264/360/Big_Buck_Bunny_360_10s_5MB.mp4";

    static {
        new Companion(null);
    }

    /* compiled from: VodMockDataSource.kt */
    @DebugMetadata(c = "ir.appp.vod.data.source.mock.VodMockDataSource$getMedia$2", f = "VodMockDataSource.kt", l = {40}, m = "invokeSuspend")
    /* renamed from: ir.appp.vod.data.source.mock.VodMockDataSource$getMedia$2, reason: invalid class name and case insensitive filesystem */
    static final class C00972 extends SuspendLambda implements Function2<FlowCollector<? super VodMediaEntityOutput>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00972(Continuation<? super C00972> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00972 c00972 = VodMockDataSource.this.new C00972(continuation);
            c00972.L$0 = obj;
            return c00972;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super VodMediaEntityOutput> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00972) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Object objFromJson = new Gson().fromJson(StringsKt__IndentKt.trimIndent("\n                    {\n                        \"media\" : {\n                              \"media_id\": \"2506659b-3396-44b1-af16-b57011506a06\",\n                              \"media_type\": \"series\",\n                              \"caption\": \"sunt est nostrud elit exercitation\",\n                              \"full_description\": \"Aute culpa cupidatat esse amet. Non magna ex officia est quis tempor laborum quis. Minim aliquip minim consectetur ut velit qui tempor aliqua velit aute consequat est. Labore aliquip aliquip minim laborum. Incididunt eu exercitation duis deserunt excepteur pariatur mollit veniam culpa. Veniam anim deserunt adipisicing reprehenderit dolor proident dolore aute ea quis mollit ut sit.\\r\\nUt pariatur aute aute ipsum aliqua mollit Lorem non eu deserunt occaecat dolore dolor nostrud. Dolor sint velit elit labore aliqua amet cillum deserunt occaecat duis minim ipsum ea anim. Incididunt laborum in nostrud nostrud. Pariatur tempor eiusmod consectetur veniam amet labore culpa ex.\\r\\n\",\n                              \"short_description\": \"Ipsum est ad eiusmod enim do exercitation sint ut sint duis. Sit excepteur Lorem amet tempor officia duis deserunt laborum aliqua sit est aute pariatur. Ea nisi nisi laboris cupidatat proident amet incididunt irure quis.\\r\\n\",\n                              \"year\": 1994,\n                              \"title\": \"فیلم 1\",\n                              \"is_hd\": true,\n                              \"latin_name\": \"movie 5\",\n                              \"imdb\": 9.33,\n                              \"trailer_video_url\": {\n                                    \"url\" : \"" + VodMockDataSource.this.mp4Url + "\",\n                                    \"play_type\": \"MP4\"\n                              },\n                              \"cover_url\": \"https://picsum.photos/seed/57086/800/450\",\n                              \"logo_image_url\": \"https://picsum.photos/seed/72841/400\",\n                              \"age_limit\": \"+ 5\",\n                              \"has_persian_subtitle\": false,\n                              \"has_persian_dub\": false,\n                              \"media_duration\": 498127,\n                              \"like_status\": \"none\",\n                              \"share_text\": \"hi , this is share text\",\n                              \"seasons\": [\n                                {\n                                  \"season_id\": \"d0b9e6db-5a18-4ffb-9d1e-a21981d6244f\",\n                                  \"season_name\": \"Season 1\",\n                                  \"season_order\": 1\n                                },\n                                {\n                                  \"season_id\": \"1d5dcc07-90ad-4001-9a76-903fca489039\",\n                                  \"season_name\": \"Season 2\",\n                                  \"season_order\": 2\n                                },\n                                {\n                                  \"season_id\": \"6c406b87-ddbd-4906-8040-ab8ed5339fe1\",\n                                  \"season_name\": \"Season 3\",\n                                  \"season_order\": 3\n                                }\n                              ],\n                              \"casts\": [\n                                {\n                                  \"cast_id\": \"8f5b692f-78f6-456c-82ab-16a9da55b396\",\n                                  \"cast_name\": \"Joanne Sexton\",\n                                  \"cast_role_name\": \"کارگردان\",\n                                  \"cast_role_type\": \"director\",\n                                  \"cast_image_url\": \"https://picsum.photos/seed/34953/300/400\"\n                                },\n                                {\n                                  \"cast_id\": \"69a33f81-85aa-4e8d-bf82-36fb64336309\",\n                                  \"cast_name\": \"Katelyn Benton\",\n                                  \"cast_role_name\": \"نویسنده\",\n                                  \"cast_role_type\": \"author\",\n                                  \"cast_image_url\": \"https://picsum.photos/seed/57559/300/400\"\n                                },\n                                {\n                                  \"cast_id\": \"a6f5a8ef-b021-42aa-9453-7c3c7e8906d9\",\n                                  \"cast_name\": \"Alford Wade\",\n                                  \"cast_role_name\": \"کارگردان\",\n                                  \"cast_image_url\": \"https://picsum.photos/seed/75951/300/400\"\n                                },\n                                {\n                                  \"cast_id\": \"9b4d8919-53b5-47ed-bab4-17fd54dcec50\",\n                                  \"cast_name\": \"Lynette Stevenson\",\n                                  \"cast_role_name\": \"نویسنده\",\n                                  \"cast_image_url\": \"https://picsum.photos/seed/99581/300/400\"\n                                },\n                                {\n                                  \"cast_id\": \"c48f6add-2718-4bea-a808-3fd947440a6f\",\n                                  \"cast_name\": \"Tricia Bender\",\n                                  \"cast_role_name\": \"نویسنده\",\n                                  \"cast_image_url\": \"https://picsum.photos/seed/92274/300/400\"\n                                },\n                                {\n                                  \"cast_id\": \"07b28a09-af28-432b-933b-9a6b5aaf6875\",\n                                  \"cast_name\": \"Ginger Terrell\",\n                                  \"cast_role_name\": \"کارگردان\",\n                                  \"cast_image_url\": \"https://picsum.photos/seed/33032/300/400\"\n                                },\n                                {\n                                  \"cast_id\": \"cc02c6d3-c494-4ab0-8196-971719159929\",\n                                  \"cast_name\": \"Reynolds Hughes\",\n                                  \"cast_role_name\": \"کارگردان\",\n                                  \"cast_image_url\": \"https://picsum.photos/seed/64572/300/400\"\n                                },\n                                {\n                                  \"cast_id\": \"3a24cc57-9008-4e02-8b80-d69237f7ef58\",\n                                  \"cast_name\": \"Dina Chen\",\n                                  \"cast_role_name\": \"بازیگر\",\n                                  \"cast_role_type\": \"actor\",\n                                  \"cast_image_url\": \"https://picsum.photos/seed/95447/300/400\"\n                                }\n                              ]\n                        }\n                    }\n                "), (Class<Object>) VodMediaEntityOutput.class);
                Intrinsics.checkNotNullExpressionValue(objFromJson, "Gson().fromJson(\n       …:class.java\n            )");
                this.label = 1;
                if (flowCollector.emit(objFromJson, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // ir.appp.vod.data.source.VodDataSource
    public Object getMedia(String str, Continuation<? super Flow<VodMediaEntityOutput>> continuation) {
        return FlowKt.flow(new C00972(null));
    }

    /* compiled from: VodMockDataSource.kt */
    @DebugMetadata(c = "ir.appp.vod.data.source.mock.VodMockDataSource$getEpisodes$2", f = "VodMockDataSource.kt", l = {149}, m = "invokeSuspend")
    /* renamed from: ir.appp.vod.data.source.mock.VodMockDataSource$getEpisodes$2, reason: invalid class name and case insensitive filesystem */
    static final class C00962 extends SuspendLambda implements Function2<FlowCollector<? super GetEpisodesOutput>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00962(Continuation<? super C00962> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00962 c00962 = new C00962(continuation);
            c00962.L$0 = obj;
            return c00962;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super GetEpisodesOutput> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00962) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Object objFromJson = new Gson().fromJson("   {\n    \"episodes\" : [\n      {\n        \"episode_id\": \"96ade728-015c-4647-91c3-6afef1ec44cc\",\n        \"title\": \"magna exercitation eiusmod culpa veniam\",\n        \"short_description\": \"Mollit ea commodo commodo eiusmod excepteur consequat cillum nisi laborum dolore. Do nisi laborum laborum sit excepteur. Incididunt proident sit exercitation Lorem mollit eiusmod ullamco cillum anim sunt commodo esse amet. Aliqua excepteur eiusmod ad in. Esse reprehenderit magna mollit sunt. Consectetur aliquip mollit et velit veniam nisi consectetur incididunt ipsum.\\r\\n\",\n        \"image_url\": \"https://picsum.photos/seed/16409/800/450\",\n        \"media_duration\": 483018\n      },\n      {\n        \"episode_id\": \"afa88eff-75cb-4ed5-86e1-3ac05573ea8d\",\n        \"title\": \"sint esse aute nisi nulla\",\n        \"short_description\": \"Ex anim pariatur irure aliqua et minim commodo sunt quis veniam duis sunt. Labore cupidatat ad ex velit eiusmod excepteur. Excepteur voluptate nisi velit proident. Esse et nisi veniam sint ad esse sit do ullamco pariatur sit eiusmod. Proident aute aute magna nulla ea culpa.\\r\\n\",\n        \"image_url\": \"https://picsum.photos/seed/91734/800/450\",\n        \"media_duration\": 404387\n      },\n      {\n        \"episode_id\": \"353b448f-cf57-4e78-94a7-3d0fb691afe7\",\n        \"title\": \"aliqua ipsum irure tempor eiusmod\",\n        \"short_description\": \"Voluptate voluptate id enim officia aute aliquip deserunt deserunt sint. Cupidatat officia exercitation adipisicing minim amet nisi pariatur. Et reprehenderit cillum amet est velit cillum exercitation do cupidatat non et incididunt minim eu. Magna nostrud sit do Lorem mollit laborum sint adipisicing excepteur sint ipsum. Nostrud eu aliquip et esse ea. Sunt ut ullamco labore enim.\\r\\n\",\n        \"image_url\": \"https://picsum.photos/seed/58424/800/450\",\n        \"media_duration\": 592898\n      },\n      {\n        \"episode_id\": \"04b1d218-16a3-41a5-bc2c-dd8c01d5b02d\",\n        \"title\": \"consectetur adipisicing cillum velit ut\",\n        \"short_description\": \"Esse labore incididunt mollit voluptate est dolor non anim ullamco ut. Sit officia reprehenderit ea nisi sint. Sunt consectetur nisi qui proident nisi minim in proident voluptate velit reprehenderit dolore aliqua.\\r\\n\",\n        \"image_url\": \"https://picsum.photos/seed/70835/800/450\",\n        \"media_duration\": 485800\n      },\n      {\n        \"episode_id\": \"9f6e6b57-3a19-45a8-9669-6e1f1ee90ae3\",\n        \"title\": \"ipsum ex commodo nisi amet\",\n        \"short_description\": \"Anim enim aliqua velit laborum esse occaecat. Minim ut ad anim ad. Ad esse sit cupidatat minim. Est occaecat nulla aute proident. Laboris magna eiusmod amet occaecat deserunt et ea qui irure anim. Id ex proident nostrud eu. Ullamco esse magna eu fugiat nostrud officia.\\r\\n\",\n        \"image_url\": \"https://picsum.photos/seed/67389/800/450\",\n        \"media_duration\": 565634\n      },\n      {\n        \"episode_id\": \"b661cbb8-cc6a-4dc6-a053-d60e2137f7e6\",\n        \"title\": \"culpa ad aliquip anim quis\",\n        \"short_description\": \"Commodo irure nulla eu dolor consectetur voluptate duis anim voluptate pariatur excepteur ut. Excepteur amet sunt do deserunt deserunt laboris velit reprehenderit duis. Adipisicing commodo labore proident amet cupidatat do excepteur pariatur. Reprehenderit magna laboris excepteur fugiat sint. Dolor dolor dolore esse in dolor exercitation. Occaecat duis fugiat adipisicing laborum aliquip enim aliquip qui duis quis incididunt tempor.\\r\\n\",\n        \"image_url\": \"https://picsum.photos/seed/4989/800/450\",\n        \"media_duration\": 468070\n      },\n      {\n        \"episode_id\": \"83e97d88-4c93-42fb-b833-9493b2a5084d\",\n        \"title\": \"dolor ea enim ex velit\",\n        \"short_description\": \"Non culpa eu id culpa. Dolore aliquip nostrud culpa nulla elit velit veniam commodo. Ut enim ex ad elit eiusmod ex ullamco anim cillum sint exercitation adipisicing.\\r\\n\",\n        \"image_url\": \"https://picsum.photos/seed/98023/800/450\",\n        \"media_duration\": 602609\n      },\n      {\n        \"episode_id\": \"7e3f53a5-05a6-4ea5-8af6-0b96ae01f007\",\n        \"title\": \"consequat aute laboris anim aliqua\",\n        \"short_description\": \"Tempor consequat ut sunt ullamco aute magna cupidatat velit. Aliqua excepteur esse culpa voluptate deserunt deserunt tempor est. Cupidatat do duis sit quis adipisicing magna veniam in.\\r\\n\",\n        \"image_url\": \"https://picsum.photos/seed/96063/800/450\",\n        \"media_duration\": 650855\n      },\n      {\n        \"episode_id\": \"a68217ee-42a4-48d9-800d-40ee676d05ef\",\n        \"title\": \"esse laboris ad deserunt quis\",\n        \"short_description\": \"Minim velit anim aliqua commodo mollit consequat ad amet dolor cillum esse et Lorem. Nulla cillum est non dolore est dolore aute labore amet adipisicing. Nisi consectetur proident aliqua excepteur mollit do do ullamco mollit id qui minim. Dolor aliqua veniam ut officia incididunt occaecat anim cupidatat minim aliqua labore. Sunt laborum quis veniam minim fugiat elit minim anim non irure incididunt ipsum. Est qui aliquip anim cupidatat. Aliqua laborum cillum labore est cillum eu est et fugiat laboris commodo duis cillum.\\r\\n\",\n        \"image_url\": \"https://picsum.photos/seed/40876/800/450\",\n        \"media_duration\": 669857\n      }\n    ]\n}", new TypeToken<GetEpisodesOutput>() { // from class: ir.appp.vod.data.source.mock.VodMockDataSource.getEpisodes.2.1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "Gson().fromJson(\n       …>() {}.type\n            )");
                this.label = 1;
                if (flowCollector.emit(objFromJson, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // ir.appp.vod.data.source.VodDataSource
    public Object getEpisodes(String str, String str2, Continuation<? super Flow<GetEpisodesOutput>> continuation) {
        return FlowKt.flow(new C00962(null));
    }

    /* compiled from: VodMockDataSource.kt */
    @DebugMetadata(c = "ir.appp.vod.data.source.mock.VodMockDataSource$getRelated$2", f = "VodMockDataSource.kt", l = {305}, m = "invokeSuspend")
    /* renamed from: ir.appp.vod.data.source.mock.VodMockDataSource$getRelated$2, reason: invalid class name and case insensitive filesystem */
    static final class C00982 extends SuspendLambda implements Function2<FlowCollector<? super GetRelatedOutput>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00982(Continuation<? super C00982> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00982 c00982 = new C00982(continuation);
            c00982.L$0 = obj;
            return c00982;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super GetRelatedOutput> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00982) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Object objFromJson = new Gson().fromJson("   {\n   \"related_medias\" : [\n     {\n       \"media_id\": \"9c1429e1-e9d5-4b60-9e28-7b340bc8085f\",\n       \"media_type\": \"episode\",\n       \"caption\": \"fugiat aliqua culpa minim esse\",\n       \"image_url\": \"https://picsum.photos/seed/72925/800/450\"\n     },\n     {\n       \"media_id\": \"8b13f1f2-1066-4803-9223-208c7b6f2677\",\n       \"media_type\": \"movie\",\n       \"caption\": \"in laboris nostrud fugiat consectetur\",\n       \"image_url\": \"https://picsum.photos/seed/53695/800/450\"\n     },\n     {\n       \"media_id\": \"29ca193c-6f1e-4d92-b91c-17af92143106\",\n       \"media_type\": \"movie\",\n       \"caption\": \"Lorem in et tempor reprehenderit\",\n       \"image_url\": \"https://picsum.photos/seed/86826/800/450\"\n     },\n     {\n       \"media_id\": \"54b25eb1-01c4-4b61-b5c0-7f0f55a18ecd\",\n       \"media_type\": \"movie\",\n       \"caption\": \"culpa cillum id commodo ut\",\n       \"image_url\": \"https://picsum.photos/seed/66324/800/450\"\n     },\n     {\n       \"media_id\": \"ed8e44c7-4b7c-48fe-96d1-087b5e462bfb\",\n       \"media_type\": \"movie\",\n       \"caption\": \"adipisicing aliquip velit consectetur cillum\",\n       \"image_url\": \"https://picsum.photos/seed/11545/800/450\"\n     },\n     {\n       \"media_id\": \"f519a9f0-072f-41ad-949b-ed48d6d315b6\",\n       \"media_type\": \"series\",\n       \"caption\": \"cillum proident ullamco labore aute\",\n       \"image_url\": \"https://picsum.photos/seed/33977/800/450\"\n     }\n   ], \n    \"next_start_id\": \"0\",\n    \"has_continue\": false\n}", new TypeToken<GetRelatedOutput>() { // from class: ir.appp.vod.data.source.mock.VodMockDataSource.getRelated.2.1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "Gson().fromJson(\n       …>() {}.type\n            )");
                this.label = 1;
                if (flowCollector.emit(objFromJson, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // ir.appp.vod.data.source.VodDataSource
    public Object getRelated(String str, String str2, Continuation<? super Flow<GetRelatedOutput>> continuation) {
        return FlowKt.flow(new C00982(null));
    }

    /* compiled from: VodMockDataSource.kt */
    @DebugMetadata(c = "ir.appp.vod.data.source.mock.VodMockDataSource$getCastMedias$2", f = "VodMockDataSource.kt", l = {622}, m = "invokeSuspend")
    /* renamed from: ir.appp.vod.data.source.mock.VodMockDataSource$getCastMedias$2, reason: invalid class name and case insensitive filesystem */
    static final class C00952 extends SuspendLambda implements Function2<FlowCollector<? super GetCastRelatedOutput>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00952(Continuation<? super C00952> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00952 c00952 = new C00952(continuation);
            c00952.L$0 = obj;
            return c00952;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super GetCastRelatedOutput> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00952) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Object objFromJson = new Gson().fromJson("   {\n   \"medias\" : [\n     {\n       \"media_id\": \"9c1429e1-e9d5-4b60-9e28-7b340bc8085f\",\n       \"media_type\": \"episode\",\n       \"caption\": \"fugiat aliqua culpa minim esse\",\n       \"image_url\": \"https://picsum.photos/seed/72925/800/450\"\n     },\n     {\n       \"media_id\": \"8b13f1f2-1066-4803-9223-208c7b6f2677\",\n       \"media_type\": \"movie\",\n       \"caption\": \"in laboris nostrud fugiat consectetur\",\n       \"image_url\": \"https://picsum.photos/seed/53695/800/450\"\n     },\n     {\n       \"media_id\": \"29ca193c-6f1e-4d92-b91c-17af92143106\",\n       \"media_type\": \"movie\",\n       \"caption\": \"Lorem in et tempor reprehenderit\",\n       \"image_url\": \"https://picsum.photos/seed/86826/800/450\"\n     },\n     {\n       \"media_id\": \"54b25eb1-01c4-4b61-b5c0-7f0f55a18ecd\",\n       \"media_type\": \"movie\",\n       \"caption\": \"culpa cillum id commodo ut\",\n       \"image_url\": \"https://picsum.photos/seed/66324/800/450\"\n     },\n     {\n       \"media_id\": \"ed8e44c7-4b7c-48fe-96d1-087b5e462bfb\",\n       \"media_type\": \"movie\",\n       \"caption\": \"adipisicing aliquip velit consectetur cillum\",\n       \"image_url\": \"https://picsum.photos/seed/11545/800/450\"\n     },\n     {\n       \"media_id\": \"f519a9f0-072f-41ad-949b-ed48d6d315b6\",\n       \"media_type\": \"series\",\n       \"caption\": \"cillum proident ullamco labore aute\",\n       \"image_url\": \"https://picsum.photos/seed/33977/800/450\"\n     }\n   ], \n    \"next_start_id\": \"0\",\n    \"has_continue\": false\n}", new TypeToken<GetCastRelatedOutput>() { // from class: ir.appp.vod.data.source.mock.VodMockDataSource.getCastMedias.2.1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "Gson().fromJson(\n       …>() {}.type\n            )");
                this.label = 1;
                if (flowCollector.emit(objFromJson, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // ir.appp.vod.data.source.VodDataSource
    public Object getCastMedias(String str, String str2, Continuation<? super Flow<GetCastRelatedOutput>> continuation) {
        return FlowKt.flow(new C00952(null));
    }

    /* compiled from: VodMockDataSource.kt */
    @DebugMetadata(c = "ir.appp.vod.data.source.mock.VodMockDataSource$actionOnMedia$2", f = "VodMockDataSource.kt", l = {699}, m = "invokeSuspend")
    /* renamed from: ir.appp.vod.data.source.mock.VodMockDataSource$actionOnMedia$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Object>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<Object>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<Object> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Boolean boolBoxBoolean = Boxing.boxBoolean(true);
                this.label = 1;
                if (flowCollector.emit(boolBoxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // ir.appp.vod.data.source.VodDataSource
    public Object actionOnMedia(String str, VodMediaEntity.LikeStatus likeStatus, Continuation<? super Flow<? extends Object>> continuation) {
        return FlowKt.flow(new AnonymousClass2(null));
    }

    /* compiled from: VodMockDataSource.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
