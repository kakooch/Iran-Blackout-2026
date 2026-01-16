package ir.nasim;

import ai.bale.proto.PassportOuterClass$RequestGetPassportGroup;
import ai.bale.proto.PassportOuterClass$RequestGetPassportGroupList;
import ai.bale.proto.PassportOuterClass$RequestLoadFormLink;
import ai.bale.proto.PassportOuterClass$RequestRemovePassportInfo;
import ai.bale.proto.PassportOuterClass$RequestSetPassportGroup;
import ai.bale.proto.PassportOuterClass$RequestSetPassportInfoByLink;
import ai.bale.proto.PassportOuterClass$RequestSubmitForm;
import ai.bale.proto.PassportOuterClass$RequestValidateField;
import ai.bale.proto.PassportOuterClass$ResponseGetPassportGroup;
import ai.bale.proto.PassportOuterClass$ResponseGetPassportGroupList;
import ai.bale.proto.PassportOuterClass$ResponseLoadFormLink;
import ai.bale.proto.PassportOuterClass$ResponseRemovePassportInfo;
import ai.bale.proto.PassportOuterClass$ResponseSetPassportGroup;
import ai.bale.proto.PassportOuterClass$ResponseSetPassportInfoByLink;
import ai.bale.proto.PassportOuterClass$ResponseSubmitForm;
import ai.bale.proto.PassportOuterClass$ResponseValidateField;
import ai.bale.proto.PassportStruct$PassportDate;
import ai.bale.proto.PassportStruct$PassportField;
import ai.bale.proto.PassportStruct$PassportFieldGroup;
import ai.bale.proto.PassportStruct$PassportFieldGroupHeader;
import ai.bale.proto.PassportStruct$PassportFieldValue;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.C9475a16;
import ir.nasim.EX4;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tZ4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21380tZ4 implements InterfaceC20760sZ4 {
    public static final a e = new a(null);
    private final InterfaceC16847ly a;
    private final AbstractC13778go1 b;
    private final InterfaceC14123hO3 c;
    private final InterfaceC14123hO3 d;

    /* renamed from: ir.nasim.tZ4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tZ4$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C21380tZ4.this.f(0, null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.tZ4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ C21380tZ4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, String str, C21380tZ4 c21380tZ4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = str;
            this.e = c21380tZ4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PassportOuterClass$RequestGetPassportGroup passportOuterClass$RequestGetPassportGroup = (PassportOuterClass$RequestGetPassportGroup) PassportOuterClass$RequestGetPassportGroup.newBuilder().A(this.c).B(StringValue.of(this.d)).a();
                AbstractC13042fc3.f(passportOuterClass$RequestGetPassportGroup);
                PassportOuterClass$ResponseGetPassportGroup defaultInstance = PassportOuterClass$ResponseGetPassportGroup.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.passport.v1.Passport/GetPassportGroup", passportOuterClass$RequestGetPassportGroup, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.e.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            C21380tZ4 c21380tZ4 = this.e;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                PassportOuterClass$ResponseGetPassportGroup passportOuterClass$ResponseGetPassportGroup = (PassportOuterClass$ResponseGetPassportGroup) ((Z06.b) z06).a();
                InterfaceC14123hO3 interfaceC14123hO3 = c21380tZ4.c;
                PassportStruct$PassportFieldGroup group = passportOuterClass$ResponseGetPassportGroup.getGroup();
                AbstractC13042fc3.h(group, "getGroup(...)");
                objB = C9475a16.b((CX4) interfaceC14123hO3.a(group));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tZ4$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objD = C21380tZ4.this.d(null, this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.tZ4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ C21380tZ4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, C21380tZ4 c21380tZ4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = c21380tZ4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PassportOuterClass$RequestGetPassportGroupList passportOuterClass$RequestGetPassportGroupList = (PassportOuterClass$RequestGetPassportGroupList) PassportOuterClass$RequestGetPassportGroupList.newBuilder().A(StringValue.of(this.c)).a();
                AbstractC13042fc3.f(passportOuterClass$RequestGetPassportGroupList);
                PassportOuterClass$ResponseGetPassportGroupList defaultInstance = PassportOuterClass$ResponseGetPassportGroupList.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.passport.v1.Passport/GetPassportGroupList", passportOuterClass$RequestGetPassportGroupList, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.d.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                List<PassportStruct$PassportFieldGroupHeader> groupsList = ((PassportOuterClass$ResponseGetPassportGroupList) ((Z06.b) z06).a()).getGroupsList();
                AbstractC13042fc3.h(groupsList, "getGroupsList(...)");
                List<PassportStruct$PassportFieldGroupHeader> list = groupsList;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (PassportStruct$PassportFieldGroupHeader passportStruct$PassportFieldGroupHeader : list) {
                    int id = passportStruct$PassportFieldGroupHeader.getId();
                    String title = passportStruct$PassportFieldGroupHeader.getTitle();
                    AbstractC13042fc3.h(title, "getTitle(...)");
                    arrayList.add(new UX4(id, title));
                }
                objB = C9475a16.b(arrayList);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tZ4$f */
    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objH = C21380tZ4.this.h(null, null, this);
            return objH == AbstractC14862ic3.e() ? objH : C9475a16.a(objH);
        }
    }

    /* renamed from: ir.nasim.tZ4$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ C21380tZ4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, String str2, C21380tZ4 c21380tZ4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = str2;
            this.e = c21380tZ4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PassportOuterClass$RequestLoadFormLink passportOuterClass$RequestLoadFormLink = (PassportOuterClass$RequestLoadFormLink) PassportOuterClass$RequestLoadFormLink.newBuilder().B(this.c).A(StringValue.of(this.d)).a();
                AbstractC13042fc3.f(passportOuterClass$RequestLoadFormLink);
                PassportOuterClass$ResponseLoadFormLink defaultInstance = PassportOuterClass$ResponseLoadFormLink.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.passport.v1.Passport/LoadFormLink", passportOuterClass$RequestLoadFormLink, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.e.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            C21380tZ4 c21380tZ4 = this.e;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                PassportOuterClass$ResponseLoadFormLink passportOuterClass$ResponseLoadFormLink = (PassportOuterClass$ResponseLoadFormLink) ((Z06.b) z06).a();
                String linkId = passportOuterClass$ResponseLoadFormLink.getLinkId();
                AbstractC13042fc3.h(linkId, "getLinkId(...)");
                String description = passportOuterClass$ResponseLoadFormLink.getDescription();
                AbstractC13042fc3.h(description, "getDescription(...)");
                List<PassportStruct$PassportFieldGroup> groupsList = passportOuterClass$ResponseLoadFormLink.getForm().getGroupsList();
                AbstractC13042fc3.h(groupsList, "getGroupsList(...)");
                List<PassportStruct$PassportFieldGroup> list = groupsList;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup : list) {
                    InterfaceC14123hO3 interfaceC14123hO3 = c21380tZ4.c;
                    AbstractC13042fc3.f(passportStruct$PassportFieldGroup);
                    arrayList.add((CX4) interfaceC14123hO3.a(passportStruct$PassportFieldGroup));
                }
                FX4 fx4 = new FX4(arrayList, description);
                String value = passportOuterClass$ResponseLoadFormLink.getCancelCallbackUrl().getValue();
                AbstractC13042fc3.f(value);
                if (!(!AbstractC20762sZ6.n0(value))) {
                    value = null;
                }
                if (value == null) {
                    value = "";
                }
                String value2 = passportOuterClass$ResponseLoadFormLink.getSuccessCallbackUrl().getValue();
                AbstractC13042fc3.f(value2);
                String str = true ^ AbstractC20762sZ6.n0(value2) ? value2 : null;
                objB = C9475a16.b(new C22609vX4(linkId, fx4, value, str != null ? str : ""));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tZ4$h */
    static final class h extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C21380tZ4.this.a(this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.tZ4$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21380tZ4.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PassportOuterClass$RequestRemovePassportInfo passportOuterClass$RequestRemovePassportInfo = (PassportOuterClass$RequestRemovePassportInfo) PassportOuterClass$RequestRemovePassportInfo.newBuilder().a();
                AbstractC13042fc3.f(passportOuterClass$RequestRemovePassportInfo);
                PassportOuterClass$ResponseRemovePassportInfo defaultInstance = PassportOuterClass$ResponseRemovePassportInfo.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.passport.v1.Passport/RemovePassportInfo", passportOuterClass$RequestRemovePassportInfo, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = C21380tZ4.this.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(C19938rB7.a);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tZ4$j */
    static final class j extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objG = C21380tZ4.this.g(0, null, null, this);
            return objG == AbstractC14862ic3.e() ? objG : C9475a16.a(objG);
        }
    }

    /* renamed from: ir.nasim.tZ4$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ List e;
        final /* synthetic */ C21380tZ4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(int i, String str, List list, C21380tZ4 c21380tZ4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = str;
            this.e = list;
            this.f = c21380tZ4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new k(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PassportOuterClass$RequestSetPassportGroup.a aVarC = PassportOuterClass$RequestSetPassportGroup.newBuilder().B(this.c).C(StringValue.of(this.d));
                List<BX4> list = this.e;
                C21380tZ4 c21380tZ4 = this.f;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (BX4 bx4 : list) {
                    arrayList.add(c21380tZ4.n(bx4.d(), bx4.i()));
                }
                PassportOuterClass$RequestSetPassportGroup passportOuterClass$RequestSetPassportGroup = (PassportOuterClass$RequestSetPassportGroup) aVarC.A(arrayList).a();
                AbstractC13042fc3.f(passportOuterClass$RequestSetPassportGroup);
                PassportOuterClass$ResponseSetPassportGroup defaultInstance = PassportOuterClass$ResponseSetPassportGroup.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.passport.v1.Passport/SetPassportGroup", passportOuterClass$RequestSetPassportGroup, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.f.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            C21380tZ4 c21380tZ42 = this.f;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                List<PassportStruct$PassportField> fieldsList = ((PassportOuterClass$ResponseSetPassportGroup) ((Z06.b) z06).a()).getInvalidGroup().getFieldsList();
                AbstractC13042fc3.f(fieldsList);
                ArrayList arrayList2 = null;
                if (!(!fieldsList.isEmpty())) {
                    fieldsList = null;
                }
                if (fieldsList != null) {
                    List<PassportStruct$PassportField> list2 = fieldsList;
                    arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                    for (PassportStruct$PassportField passportStruct$PassportField : list2) {
                        InterfaceC14123hO3 interfaceC14123hO3 = c21380tZ42.d;
                        AbstractC13042fc3.f(passportStruct$PassportField);
                        arrayList2.add((BX4) interfaceC14123hO3.a(passportStruct$PassportField));
                    }
                }
                objB = C9475a16.b(arrayList2);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tZ4$l */
    static final class l extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objE = C21380tZ4.this.e(null, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    /* renamed from: ir.nasim.tZ4$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ C21380tZ4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, C21380tZ4 c21380tZ4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = c21380tZ4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new m(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PassportOuterClass$RequestSetPassportInfoByLink passportOuterClass$RequestSetPassportInfoByLink = (PassportOuterClass$RequestSetPassportInfoByLink) PassportOuterClass$RequestSetPassportInfoByLink.newBuilder().A(this.c).a();
                AbstractC13042fc3.f(passportOuterClass$RequestSetPassportInfoByLink);
                PassportOuterClass$ResponseSetPassportInfoByLink defaultInstance = PassportOuterClass$ResponseSetPassportInfoByLink.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.passport.v1.Passport/SetPassportInfoByLink", passportOuterClass$RequestSetPassportInfoByLink, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.d.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(C19938rB7.a);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tZ4$n */
    static final class n extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objB = C21380tZ4.this.b(null, null, null, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.tZ4$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(String str, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21380tZ4.this.new o(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PassportOuterClass$RequestSubmitForm.a aVarNewBuilder = PassportOuterClass$RequestSubmitForm.newBuilder();
                String str = this.d;
                C21380tZ4 c21380tZ4 = C21380tZ4.this;
                List list = this.e;
                aVarNewBuilder.B(str);
                List<BX4> listO = c21380tZ4.o(list);
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listO, 10));
                for (BX4 bx4 : listO) {
                    arrayList.add(c21380tZ4.n(bx4.d(), bx4.i()));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    aVarNewBuilder.A((PassportStruct$PassportFieldValue) it.next());
                }
                PassportOuterClass$RequestSubmitForm passportOuterClass$RequestSubmitForm = (PassportOuterClass$RequestSubmitForm) aVarNewBuilder.a();
                AbstractC13042fc3.f(passportOuterClass$RequestSubmitForm);
                PassportOuterClass$ResponseSubmitForm defaultInstance = PassportOuterClass$ResponseSubmitForm.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.passport.v1.Passport/SubmitForm", passportOuterClass$RequestSubmitForm, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = C21380tZ4.this.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            C21380tZ4 c21380tZ42 = C21380tZ4.this;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                PassportOuterClass$ResponseSubmitForm passportOuterClass$ResponseSubmitForm = (PassportOuterClass$ResponseSubmitForm) ((Z06.b) z06).a();
                boolean showUpdateDialog = passportOuterClass$ResponseSubmitForm.getShowUpdateDialog();
                List<PassportStruct$PassportFieldGroup> groupsList = passportOuterClass$ResponseSubmitForm.getInvalidForm().getGroupsList();
                AbstractC13042fc3.h(groupsList, "getGroupsList(...)");
                List<PassportStruct$PassportFieldGroup> list2 = groupsList;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                for (PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup : list2) {
                    InterfaceC14123hO3 interfaceC14123hO3 = c21380tZ42.c;
                    AbstractC13042fc3.f(passportStruct$PassportFieldGroup);
                    arrayList2.add((CX4) interfaceC14123hO3.a(passportStruct$PassportFieldGroup));
                }
                objB = C9475a16.b(new C11440d07(showUpdateDialog, arrayList2));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tZ4$p */
    static final class p extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objC = C21380tZ4.this.c(0, null, null, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.tZ4$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ EX4 e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(int i, EX4 ex4, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = ex4;
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21380tZ4.this.new q(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PassportStruct$PassportFieldValue passportStruct$PassportFieldValueN = C21380tZ4.this.n(this.d, this.e);
                PassportOuterClass$RequestValidateField.a aVarNewBuilder = PassportOuterClass$RequestValidateField.newBuilder();
                aVarNewBuilder.A(StringValue.of(this.f));
                aVarNewBuilder.B(passportStruct$PassportFieldValueN);
                PassportOuterClass$RequestValidateField passportOuterClass$RequestValidateField = (PassportOuterClass$RequestValidateField) aVarNewBuilder.a();
                AbstractC13042fc3.f(passportOuterClass$RequestValidateField);
                PassportOuterClass$ResponseValidateField defaultInstance = PassportOuterClass$ResponseValidateField.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.passport.v1.Passport/ValidateField", passportOuterClass$RequestValidateField, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = C21380tZ4.this.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            C21380tZ4 c21380tZ4 = C21380tZ4.this;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                PassportOuterClass$ResponseValidateField passportOuterClass$ResponseValidateField = (PassportOuterClass$ResponseValidateField) ((Z06.b) z06).a();
                InterfaceC14123hO3 interfaceC14123hO3 = c21380tZ4.d;
                PassportStruct$PassportField field = passportOuterClass$ResponseValidateField.getField();
                AbstractC13042fc3.h(field, "getField(...)");
                objB = C9475a16.b((BX4) interfaceC14123hO3.a(field));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21380tZ4(InterfaceC16847ly interfaceC16847ly, AbstractC13778go1 abstractC13778go1, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC14123hO3 interfaceC14123hO32) {
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateWay");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC14123hO3, "apiPassportFieldGroupToPassportFieldGroup");
        AbstractC13042fc3.i(interfaceC14123hO32, "apiPassportFieldToPassportField");
        this.a = interfaceC16847ly;
        this.b = abstractC13778go1;
        this.c = interfaceC14123hO3;
        this.d = interfaceC14123hO32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PassportStruct$PassportFieldValue n(int i2, EX4 ex4) {
        PassportStruct$PassportFieldValue.a aVarB = PassportStruct$PassportFieldValue.newBuilder().B(i2);
        if (ex4 instanceof EX4.a) {
            Long lE = ((EX4.a) ex4).e();
            if (lE == null) {
                GeneratedMessageLite generatedMessageLiteA = aVarB.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                return (PassportStruct$PassportFieldValue) generatedMessageLiteA;
            }
            aVarB.A((PassportStruct$PassportDate) PassportStruct$PassportDate.newBuilder().A(lE.longValue()).a());
        } else if (ex4 instanceof EX4.b) {
            Integer numE = ((EX4.b) ex4).e();
            if (numE == null) {
                GeneratedMessageLite generatedMessageLiteA2 = aVarB.a();
                AbstractC13042fc3.h(generatedMessageLiteA2, "build(...)");
                return (PassportStruct$PassportFieldValue) generatedMessageLiteA2;
            }
            aVarB.C((Int32Value) Int32Value.newBuilder().A(numE.intValue()).a());
        } else {
            if (!(ex4 instanceof EX4.c)) {
                if (!AbstractC13042fc3.d(ex4, EX4.d.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                GeneratedMessageLite generatedMessageLiteA3 = aVarB.a();
                AbstractC13042fc3.h(generatedMessageLiteA3, "build(...)");
                return (PassportStruct$PassportFieldValue) generatedMessageLiteA3;
            }
            String strH = ((EX4.c) ex4).h();
            if (strH == null) {
                GeneratedMessageLite generatedMessageLiteA4 = aVarB.a();
                AbstractC13042fc3.h(generatedMessageLiteA4, "build(...)");
                return (PassportStruct$PassportFieldValue) generatedMessageLiteA4;
            }
            aVarB.D(StringValue.of(strH));
        }
        GeneratedMessageLite generatedMessageLiteA5 = aVarB.a();
        AbstractC13042fc3.h(generatedMessageLiteA5, "build(...)");
        return (PassportStruct$PassportFieldValue) generatedMessageLiteA5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List o(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, ((CX4) it.next()).c());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20760sZ4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C21380tZ4.h
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.tZ4$h r0 = (ir.nasim.C21380tZ4.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tZ4$h r0 = new ir.nasim.tZ4$h
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.b
            ir.nasim.tZ4$i r2 = new ir.nasim.tZ4$i
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21380tZ4.a(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20760sZ4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r5, java.util.List r6, java.lang.String r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r7 = r8 instanceof ir.nasim.C21380tZ4.n
            if (r7 == 0) goto L13
            r7 = r8
            ir.nasim.tZ4$n r7 = (ir.nasim.C21380tZ4.n) r7
            int r0 = r7.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r7.c = r0
            goto L18
        L13:
            ir.nasim.tZ4$n r7 = new ir.nasim.tZ4$n
            r7.<init>(r8)
        L18:
            java.lang.Object r8 = r7.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r7.c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r4.b
            ir.nasim.tZ4$o r1 = new ir.nasim.tZ4$o
            r3 = 0
            r1.<init>(r5, r6, r3)
            r7.c = r2
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r1, r7)
            if (r8 != r0) goto L45
            return r0
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r5 = r8.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21380tZ4.b(java.lang.String, java.util.List, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20760sZ4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(int r11, ir.nasim.EX4 r12, java.lang.String r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.C21380tZ4.p
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.tZ4$p r0 = (ir.nasim.C21380tZ4.p) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tZ4$p r0 = new ir.nasim.tZ4$p
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L4a
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.go1 r14 = r10.b
            ir.nasim.tZ4$q r2 = new ir.nasim.tZ4$q
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L4a
            return r1
        L4a:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21380tZ4.c(int, ir.nasim.EX4, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20760sZ4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C21380tZ4.d
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.tZ4$d r0 = (ir.nasim.C21380tZ4.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tZ4$d r0 = new ir.nasim.tZ4$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.b
            ir.nasim.tZ4$e r2 = new ir.nasim.tZ4$e
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21380tZ4.d(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20760sZ4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C21380tZ4.l
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.tZ4$l r0 = (ir.nasim.C21380tZ4.l) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tZ4$l r0 = new ir.nasim.tZ4$l
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.b
            ir.nasim.tZ4$m r2 = new ir.nasim.tZ4$m
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21380tZ4.e(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20760sZ4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(int r6, java.lang.String r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C21380tZ4.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.tZ4$b r0 = (ir.nasim.C21380tZ4.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tZ4$b r0 = new ir.nasim.tZ4$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.b
            ir.nasim.tZ4$c r2 = new ir.nasim.tZ4$c
            r4 = 0
            r2.<init>(r6, r7, r5, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21380tZ4.f(int, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20760sZ4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(int r11, java.util.List r12, java.lang.String r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.C21380tZ4.j
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.tZ4$j r0 = (ir.nasim.C21380tZ4.j) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tZ4$j r0 = new ir.nasim.tZ4$j
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L4a
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.go1 r14 = r10.b
            ir.nasim.tZ4$k r2 = new ir.nasim.tZ4$k
            r9 = 0
            r4 = r2
            r5 = r11
            r6 = r13
            r7 = r12
            r8 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L4a
            return r1
        L4a:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21380tZ4.g(int, java.util.List, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20760sZ4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(java.lang.String r6, java.lang.String r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C21380tZ4.f
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.tZ4$f r0 = (ir.nasim.C21380tZ4.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tZ4$f r0 = new ir.nasim.tZ4$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.b
            ir.nasim.tZ4$g r2 = new ir.nasim.tZ4$g
            r4 = 0
            r2.<init>(r6, r7, r5, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21380tZ4.h(java.lang.String, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
