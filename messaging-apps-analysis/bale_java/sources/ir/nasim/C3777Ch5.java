package ir.nasim;

import ai.bale.proto.MessagingStruct$PollMessage;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.PollOuterClass$RequestClosePoll;
import ai.bale.proto.PollOuterClass$RequestCreatePoll;
import ai.bale.proto.PollOuterClass$RequestGetFullPollResult;
import ai.bale.proto.PollOuterClass$RequestGetPollResults;
import ai.bale.proto.PollOuterClass$RequestVote;
import ai.bale.proto.PollOuterClass$ResponseCreatePoll;
import ai.bale.proto.PollOuterClass$ResponseGetFullPollResult;
import ai.bale.proto.PollOuterClass$ResponseGetPollResults;
import ai.bale.proto.PollOuterClass$ResponseVote;
import ai.bale.proto.PollStruct$FullOptionResult;
import ai.bale.proto.PollStruct$OptionResult;
import ai.bale.proto.PollStruct$PollOption;
import ai.bale.proto.PollStruct$PollResult;
import ai.bale.proto.PollStruct$Voter;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.Z06;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Ch5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3777Ch5 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final AbstractC13778go1 a;
    private final InterfaceC20315ro1 b;
    private final E84 c;
    private final C6287Mz d;

    /* renamed from: ir.nasim.Ch5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ch5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3777Ch5.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6287Mz c6287Mz = C3777Ch5.this.d;
                GeneratedMessageLite generatedMessageLiteA = PollOuterClass$RequestClosePoll.newBuilder().A(this.d).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.poll.v1.Poll/ClosePoll", generatedMessageLiteA, defaultInstance);
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return AbstractC6392Nk0.a(((Z06) obj) instanceof Z06.b);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ch5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PollOuterClass$RequestCreatePoll d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ C13121fh5 f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PollOuterClass$RequestCreatePoll pollOuterClass$RequestCreatePoll, C11458d25 c11458d25, C13121fh5 c13121fh5, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = pollOuterClass$RequestCreatePoll;
            this.e = c11458d25;
            this.f = c13121fh5;
            this.g = j;
            this.h = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3777Ch5.this.new c(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            boolean z = true;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6287Mz c6287Mz = C3777Ch5.this.d;
                PollOuterClass$RequestCreatePoll pollOuterClass$RequestCreatePoll = this.d;
                AbstractC13042fc3.f(pollOuterClass$RequestCreatePoll);
                PollOuterClass$ResponseCreatePoll defaultInstance = PollOuterClass$ResponseCreatePoll.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.poll.v1.Poll/CreatePoll", pollOuterClass$RequestCreatePoll, defaultInstance);
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                C3777Ch5.this.c.D2(this.e, AbstractC6392Nk0.e(((PollOuterClass$ResponseCreatePoll) ((Z06.b) z06).a()).getPollId()), this.f.e(), this.f.a(), AbstractC6392Nk0.a(this.f.g()), AbstractC9292Zh5.b(AbstractC9292Zh5.c(this.f.d())), AbstractC6392Nk0.e(this.g), AbstractC6392Nk0.e(this.h));
            } else {
                z = false;
            }
            return AbstractC6392Nk0.a(z);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ch5$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3777Ch5.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6287Mz c6287Mz = C3777Ch5.this.d;
                GeneratedMessageLite generatedMessageLiteA = PollOuterClass$RequestGetFullPollResult.newBuilder().A(this.d).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                PollOuterClass$ResponseGetFullPollResult defaultInstance = PollOuterClass$ResponseGetFullPollResult.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.poll.v1.Poll/GetFullPollResult", generatedMessageLiteA, defaultInstance);
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (!(z06 instanceof Z06.b)) {
                return AbstractC10360bX0.m();
            }
            List<PollStruct$FullOptionResult> fullPollResultList = ((PollOuterClass$ResponseGetFullPollResult) ((Z06.b) z06).a()).getFullPollResultList();
            AbstractC13042fc3.h(fullPollResultList, "getFullPollResultList(...)");
            List<PollStruct$FullOptionResult> list = fullPollResultList;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (PollStruct$FullOptionResult pollStruct$FullOptionResult : list) {
                int optionId = pollStruct$FullOptionResult.getOptionId();
                int votesCount = pollStruct$FullOptionResult.getVotesCount();
                List<PollStruct$Voter> votersList = pollStruct$FullOptionResult.getVotersList();
                AbstractC13042fc3.h(votersList, "getVotersList(...)");
                List<PollStruct$Voter> list2 = votersList;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                for (PollStruct$Voter pollStruct$Voter : list2) {
                    arrayList2.add(new C20449s18(pollStruct$Voter.getUserId(), pollStruct$Voter.getVotedAt()));
                }
                arrayList.add(new C19640qh5(optionId, votesCount, arrayList2));
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ch5$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C3777Ch5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(List list, C3777Ch5 c3777Ch5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c3777Ch5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PollOuterClass$RequestGetPollResults.a aVarA = PollOuterClass$RequestGetPollResults.newBuilder().A(this.c);
                C6287Mz c6287Mz = this.d.d;
                GeneratedMessageLite generatedMessageLiteA = aVarA.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                PollOuterClass$ResponseGetPollResults defaultInstance = PollOuterClass$ResponseGetPollResults.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.poll.v1.Poll/GetPollResults", generatedMessageLiteA, defaultInstance);
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (!(z06 instanceof Z06.b)) {
                return AbstractC10360bX0.m();
            }
            List<PollStruct$PollResult> pollResultsList = ((PollOuterClass$ResponseGetPollResults) ((Z06.b) z06).a()).getPollResultsList();
            AbstractC13042fc3.h(pollResultsList, "getPollResultsList(...)");
            List<PollStruct$PollResult> list = pollResultsList;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (PollStruct$PollResult pollStruct$PollResult : list) {
                List<Long> recentVotersList = pollStruct$PollResult.getRecentVotersList();
                AbstractC13042fc3.h(recentVotersList, "getRecentVotersList(...)");
                int recentVotersCount = pollStruct$PollResult.getRecentVotersCount();
                long pollId = pollStruct$PollResult.getPollId();
                List<Long> chosenOptionIdsList = pollStruct$PollResult.getChosenOptionIdsList();
                AbstractC13042fc3.h(chosenOptionIdsList, "getChosenOptionIdsList(...)");
                List<PollStruct$OptionResult> optionResultsList = pollStruct$PollResult.getOptionResultsList();
                AbstractC13042fc3.h(optionResultsList, "getOptionResultsList(...)");
                List<PollStruct$OptionResult> list2 = optionResultsList;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                for (PollStruct$OptionResult pollStruct$OptionResult : list2) {
                    arrayList2.add(new C4011Dh5(pollStruct$OptionResult.getOptionId(), pollStruct$OptionResult.getVotesCount()));
                }
                arrayList.add(new C16885m18(pollId, chosenOptionIdsList, AbstractC15401jX0.p1(arrayList2), pollStruct$PollResult.getIsClosed(), pollStruct$PollResult.getVotersCount(), recentVotersList, recentVotersCount));
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ch5$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PollOuterClass$RequestVote.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(PollOuterClass$RequestVote.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3777Ch5.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6287Mz c6287Mz = C3777Ch5.this.d;
                GeneratedMessageLite generatedMessageLiteA = this.d.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                GeneratedMessageLite generatedMessageLiteA2 = PollOuterClass$ResponseVote.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA2, "build(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.poll.v1.Poll/Vote", generatedMessageLiteA, generatedMessageLiteA2);
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (!(z06 instanceof Z06.b)) {
                return null;
            }
            Z06.b bVar = (Z06.b) z06;
            List<Long> recentVotersList = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getRecentVotersList();
            AbstractC13042fc3.h(recentVotersList, "getRecentVotersList(...)");
            int recentVotersCount = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getRecentVotersCount();
            long pollId = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getPollId();
            List<Long> chosenOptionIdsList = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getChosenOptionIdsList();
            AbstractC13042fc3.h(chosenOptionIdsList, "getChosenOptionIdsList(...)");
            List<PollStruct$OptionResult> optionResultsList = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getOptionResultsList();
            AbstractC13042fc3.h(optionResultsList, "getOptionResultsList(...)");
            List<PollStruct$OptionResult> list = optionResultsList;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (PollStruct$OptionResult pollStruct$OptionResult : list) {
                arrayList.add(new C4011Dh5(pollStruct$OptionResult.getOptionId(), pollStruct$OptionResult.getVotesCount()));
            }
            return new C16885m18(pollId, chosenOptionIdsList, AbstractC15401jX0.p1(arrayList), ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getIsClosed(), ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getVotersCount(), recentVotersList, recentVotersCount);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ch5$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PollOuterClass$RequestVote.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(PollOuterClass$RequestVote.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3777Ch5.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6287Mz c6287Mz = C3777Ch5.this.d;
                GeneratedMessageLite generatedMessageLiteA = this.d.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                GeneratedMessageLite generatedMessageLiteA2 = PollOuterClass$ResponseVote.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA2, "build(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.poll.v1.Poll/Vote", generatedMessageLiteA, generatedMessageLiteA2);
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (!(z06 instanceof Z06.b)) {
                return null;
            }
            Z06.b bVar = (Z06.b) z06;
            List<Long> recentVotersList = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getRecentVotersList();
            AbstractC13042fc3.h(recentVotersList, "getRecentVotersList(...)");
            int recentVotersCount = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getRecentVotersCount();
            long pollId = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getPollId();
            List<Long> chosenOptionIdsList = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getChosenOptionIdsList();
            AbstractC13042fc3.h(chosenOptionIdsList, "getChosenOptionIdsList(...)");
            List<PollStruct$OptionResult> optionResultsList = ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getOptionResultsList();
            AbstractC13042fc3.h(optionResultsList, "getOptionResultsList(...)");
            List<PollStruct$OptionResult> list = optionResultsList;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (PollStruct$OptionResult pollStruct$OptionResult : list) {
                arrayList.add(new C4011Dh5(pollStruct$OptionResult.getOptionId(), pollStruct$OptionResult.getVotesCount()));
            }
            return new C16885m18(pollId, chosenOptionIdsList, AbstractC15401jX0.p1(arrayList), ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getIsClosed(), ((PollOuterClass$ResponseVote) bVar.a()).getPollResult().getVotersCount(), recentVotersList, recentVotersCount);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C3777Ch5(AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, E84 e84, C6287Mz c6287Mz) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = abstractC13778go1;
        this.b = interfaceC20315ro1;
        this.c = e84;
        this.d = c6287Mz;
    }

    public final Object c(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new b(j, null), interfaceC20295rm1);
    }

    public final Object d(C13121fh5 c13121fh5, C11458d25 c11458d25, ExPeerType exPeerType, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        MessagingStruct$PollMessage.a aVarC = MessagingStruct$PollMessage.newBuilder().D(AbstractC9292Zh5.c(c13121fh5.d())).B(c13121fh5.g()).C(c13121fh5.e());
        int i = 0;
        for (Object obj : c13121fh5.a()) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            aVarC.A(i, (PollStruct$PollOption) PollStruct$PollOption.newBuilder().A(i).B((String) obj).a());
            i = i2;
        }
        return AbstractC9323Zl0.g(this.a, new c((PollOuterClass$RequestCreatePoll) PollOuterClass$RequestCreatePoll.newBuilder().B((MessagingStruct$PollMessage) aVarC.a()).A(PeersStruct$ExPeer.newBuilder().B(c11458d25.getPeerId()).C(exPeerType.toProtoApi())).a(), c11458d25, c13121fh5, j, j2, null), interfaceC20295rm1);
    }

    public final Object e(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new d(j, null), interfaceC20295rm1);
    }

    public final Object f(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new e(list, this, null), interfaceC20295rm1);
    }

    public final Object g(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new f(PollOuterClass$RequestVote.newBuilder().B(true).C(j), null), interfaceC20295rm1);
    }

    public final Object h(long j, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new g(PollOuterClass$RequestVote.newBuilder().C(j).A(list), null), interfaceC20295rm1);
    }
}
