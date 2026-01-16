package ir.nasim;

import ai.bale.proto.GiftpacketStruct$GiftReceiver;
import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC17632nI2;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.InterfaceC17041mI2;
import ir.nasim.InterfaceC7406Ro6;
import ir.nasim.InterfaceC9566aA7;
import ir.nasim.YI5;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ^2\u00020\u0001:\u0001_B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J7\u0010\"\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0004H\u0002¢\u0006\u0004\b<\u0010\u0003J\u000f\u0010=\u001a\u00020\u0004H\u0002¢\u0006\u0004\b=\u0010\u0003J\u000f\u0010>\u001a\u00020\u0004H\u0002¢\u0006\u0004\b>\u0010\u0003J\u000f\u0010?\u001a\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010\u0003J\u0019\u0010B\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010@H\u0016¢\u0006\u0004\bB\u0010CJ-\u0010I\u001a\u0004\u0018\u00010H2\u0006\u0010E\u001a\u00020D2\b\u0010G\u001a\u0004\u0018\u00010F2\b\u0010A\u001a\u0004\u0018\u00010@H\u0016¢\u0006\u0004\bI\u0010JJ!\u0010L\u001a\u00020\u00042\u0006\u0010K\u001a\u00020H2\b\u0010A\u001a\u0004\u0018\u00010@H\u0016¢\u0006\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020N8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001b\u0010Y\u001a\u00020T8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006`"}, d2 = {"Lir/nasim/YK4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ja", "Lir/nasim/mI2;", "state", "ta", "(Lir/nasim/mI2;)V", "", "winAmount", "", "isAlreadyReceived", "isFirst", "ma", "(JZZ)V", "Lir/nasim/YI5;", "pa", "(Lir/nasim/YI5;)V", "Lir/nasim/YI5$b;", "oa", "(Lir/nasim/YI5$b;)V", "Lir/nasim/YI5$a;", "ga", "(Lir/nasim/YI5$a;)V", "sa", "", "Lai/bale/proto/GiftpacketStruct$GiftReceiver;", "receivers", "", "remainCount", "receiverCount", "isFailState", "X9", "(Ljava/util/List;IIZ)V", "Lir/nasim/Ro6;", "qa", "(Lir/nasim/Ro6;)V", "Lir/nasim/Ro6$a;", "fa", "(Lir/nasim/Ro6$a;)V", "isPrivate", "ha", "(Z)V", "Lir/nasim/Ro6$b;", "na", "(Lir/nasim/Ro6$b;)V", "Lir/nasim/nI2;", "exceptionState", "ba", "(Lir/nasim/nI2;)V", "Lir/nasim/nI2$d;", "soldOut", "ra", "(Lir/nasim/nI2$d;)V", "Lir/nasim/nI2$a;", "expire", "Z9", "(Lir/nasim/nI2$a;)V", "aa", "la", "ia", "R6", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/Wt4;", "h1", "Lir/nasim/bW7;", "da", "()Lir/nasim/Wt4;", "binding", "Lir/nasim/BI2;", "i1", "Lir/nasim/Yu3;", "ea", "()Lir/nasim/BI2;", "viewmodel", "Lir/nasim/Lt4;", "j1", "Lir/nasim/Lt4;", "adapter", "k1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class YK4 extends AbstractC18358oX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new d(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewmodel;

    /* renamed from: j1, reason: from kotlin metadata */
    private C6004Lt4 adapter;
    static final /* synthetic */ InterfaceC5239Im3[] l1 = {AbstractC10882cM5.i(new C25226zw5(YK4.class, "binding", "getBinding()Lir/nasim/databinding/NewGiftPacketRecyclerResultLayoutBinding;", 0))};

    /* renamed from: k1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m1 = 8;

    /* renamed from: ir.nasim.YK4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final YK4 a(long j, int i, long j2, int i2, int i3, long j3, long j4, int i4, boolean z, boolean z2, boolean z3, boolean z4, long j5) {
            YK4 yk4 = new YK4();
            yk4.a8(AbstractC23348wm0.b(new XV4("arg_rid", Long.valueOf(j)), new XV4("arg_owner_id", Integer.valueOf(i)), new XV4("arg_date", Long.valueOf(j2)), new XV4("arg_peer_id", Integer.valueOf(i2)), new XV4("arg_expeer_type", Integer.valueOf(i3)), new XV4("arg_total_AMOUNT", Long.valueOf(j3)), new XV4("arg_packet_count", Long.valueOf(j4)), new XV4("arg_given_type_is_random", Boolean.valueOf(i4 == EnumC19802qy.RANDOM.j())), new XV4("arg_show_total_amount", Boolean.valueOf(z)), new XV4("arg_random_gift_packet_is_failure", Boolean.valueOf(z2)), new XV4("arg_later_send_to_wallet", Boolean.valueOf(z3)), new XV4("ARG_IS_GOLD", Boolean.valueOf(z4)), new XV4("ARG_ID_GOLD", Long.valueOf(j5))));
            return yk4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return YK4.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                BI2 bi2Ea = YK4.this.ea();
                this.b = 1;
                obj = bi2Ea.o1(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C21231tK7 c21231tK7 = (C21231tK7) obj;
            if (c21231tK7 != null) {
                YK4 yk4 = YK4.this;
                AvatarViewGlide.u(yk4.da().G, c21231tK7, null, 2, null);
                TextView textView = yk4.da().H;
                String string = yk4.b6().getString(AbstractC12217eE5.gift_packet_sender_name);
                AbstractC13042fc3.h(string, "getString(...)");
                Object objB = c21231tK7.r().b();
                AbstractC13042fc3.h(objB, "get(...)");
                textView.setText(AbstractC20153rZ6.M(string, "{0}", (String) objB, false, 4, null));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ YK4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(YK4 yk4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = yk4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC9566aA7 interfaceC9566aA7 = (InterfaceC9566aA7) this.c;
                if (interfaceC9566aA7 instanceof InterfaceC9566aA7.b) {
                    this.d.la();
                } else if (interfaceC9566aA7 instanceof InterfaceC9566aA7.c) {
                    this.d.ta(((InterfaceC9566aA7.c) interfaceC9566aA7).a());
                } else {
                    if (!(interfaceC9566aA7 instanceof InterfaceC9566aA7.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.d.ba(((InterfaceC9566aA7.a) interfaceC9566aA7).a());
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC9566aA7 interfaceC9566aA7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC9566aA7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return YK4.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6L1 = YK4.this.ea().l1();
                a aVar = new a(YK4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6L1, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C8624Wt4.a(fragment.V7());
        }
    }

    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public static final class j extends CountDownTimer {
        j(long j) {
            super(j, 1000L);
        }

        private final String a(long j, long j2) {
            long j3 = j / j2;
            if (j3 >= 10) {
                return String.valueOf(j3);
            }
            return "0" + j3;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            YK4.this.da().L.setText(XY6.e("00:00:00"));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            long j2 = 60;
            long j3 = j2 * 1000;
            long j4 = j2 * j3;
            long j5 = j % (24 * j4);
            String strA = a(j5, j4);
            long j6 = j5 % j4;
            String strA2 = a(j6, j3);
            String strA3 = a(j6 % j3, 1000L);
            if (YK4.this.u6()) {
                YK4.this.da().L.setText(XY6.e(strA + ":" + strA2 + ":" + strA3));
            }
        }
    }

    public YK4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.viewmodel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(BI2.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), new i(this, interfaceC9173Yu3B));
    }

    private final void X9(List receivers, int remainCount, int receiverCount, boolean isFailState) {
        if (receivers.isEmpty()) {
            return;
        }
        if (isFailState || remainCount == 0) {
            da().C.setVisibility(8);
            da().E.setVisibility(8);
        } else {
            da().C.setText(XY6.e(String.valueOf(remainCount)));
        }
        da().z.setText(XY6.e(String.valueOf(receiverCount)));
        da().q.setVisibility(0);
        AbstractC13042fc3.g(receivers, "null cannot be cast to non-null type kotlin.collections.MutableList<ai.bale.proto.GiftpacketStruct.GiftReceiver>");
        List listC = AbstractC19810qy7.c(receivers);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        this.adapter = new C6004Lt4(listC, contextS7, ea().b1(), ea().c1() == EnumC19802qy.RANDOM, ea().t1());
        da().o.setLayoutManager(new LinearLayoutManager(G5()));
        RecyclerView recyclerView = da().o;
        C6004Lt4 c6004Lt4 = this.adapter;
        C6004Lt4 c6004Lt42 = null;
        if (c6004Lt4 == null) {
            AbstractC13042fc3.y("adapter");
            c6004Lt4 = null;
        }
        recyclerView.setAdapter(c6004Lt4);
        C6004Lt4 c6004Lt43 = this.adapter;
        if (c6004Lt43 == null) {
            AbstractC13042fc3.y("adapter");
        } else {
            c6004Lt42 = c6004Lt43;
        }
        c6004Lt42.notifyDataSetChanged();
    }

    static /* synthetic */ void Y9(YK4 yk4, List list, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z = false;
        }
        yk4.X9(list, i2, i3, z);
    }

    private final void Z9(AbstractC17632nI2.a expire) {
        if (expire.b()) {
            da().q.setVisibility(8);
        } else {
            X9(expire.d(), ea().h1() - expire.c(), expire.c(), true);
        }
        da().L.setText(ea().t1() ? h6(AbstractC12217eE5.gold_gift_packet_owner_expire) : h6(AbstractC12217eE5.gift_packet_owner_expire));
    }

    private final void aa() {
        String str = h6(AbstractC12217eE5.yor_are_not_lucky);
        AbstractC13042fc3.h(str, "toString(...)");
        da().I.setVisibility(0);
        da().I.setText(str);
        da().L.setText(h6(AbstractC12217eE5.you_are_not_win_gift));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(AbstractC17632nI2 exceptionState) {
        ia();
        da().W.setVisibility(0);
        da().q.setVisibility(8);
        da().l.getRoot().setVisibility(8);
        da().b.setVisibility(8);
        da().t.setVisibility(8);
        if (C5495Jo7.a.J2()) {
            da().d.setImageResource(KB5.ic_big_lose_dark);
        } else {
            da().d.setImageResource(KB5.ic_big_lose);
        }
        if (exceptionState instanceof AbstractC17632nI2.c) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            FragmentActivity fragmentActivityQ7 = Q7();
            AbstractC13042fc3.g(fragmentActivityQ7, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            C24398yZ.g(contextS7, fragmentActivityQ7, exceptionState.a(), new SA2() { // from class: ir.nasim.XK4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return YK4.ca(this.a);
                }
            });
            return;
        }
        if (exceptionState instanceof AbstractC17632nI2.b) {
            aa();
        } else if (exceptionState instanceof AbstractC17632nI2.a) {
            Z9((AbstractC17632nI2.a) exceptionState);
        } else {
            if (!(exceptionState instanceof AbstractC17632nI2.d)) {
                throw new NoWhenBranchMatchedException();
            }
            ra((AbstractC17632nI2.d) exceptionState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ca(YK4 yk4) {
        AbstractC13042fc3.i(yk4, "this$0");
        yk4.Q7().onBackPressed();
        return C19938rB7.a;
    }

    private final void fa(InterfaceC7406Ro6.a state) {
        if (state.b() == state.a()) {
            da().L.setText(h6(AbstractC12217eE5.gift_packet_owner_finish));
        } else {
            sa();
        }
        da().h.setText(GY6.a(String.valueOf(state.b())));
        da().i.setText(GY6.a(String.valueOf(state.a() - state.b())));
        if (state.b() == 0) {
            ha(false);
        } else {
            Y9(this, state.c(), state.a() - state.b(), state.b(), false, 8, null);
        }
    }

    private final void ga(YI5.a state) {
        Y9(this, state.e(), state.c() - state.d(), state.d(), false, 8, null);
        ma(state.f(), state.a(), state.g());
        if (state.e().isEmpty()) {
            return;
        }
        if (!state.g()) {
            da().K.setVisibility(0);
            return;
        }
        da().I.setVisibility(0);
        da().J.setVisibility(0);
        StringBuilder sb = new StringBuilder();
        sb.append(h6(AbstractC12217eE5.gift_packet_status_first));
        sb.append(Separators.SP);
        char[] chars = Character.toChars(128525);
        AbstractC13042fc3.h(chars, "toChars(...)");
        sb.append(new String(chars));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        da().d.setImageResource(KB5.ic_big_medal);
        da().I.setText(string);
    }

    private final void ha(boolean isPrivate) {
        da().l0.setVisibility(8);
        da().o.setVisibility(8);
        da().U.setVisibility(0);
        da().e0.setVisibility(8);
        da().U.setText(h6(isPrivate ? AbstractC12217eE5.gift_packet_result_empty_state_message_owner_in_private : AbstractC12217eE5.gift_packet_result_empty_state_message_owner));
        da().U.setTypeface(C6011Lu2.i());
        da().U.setTextColor(AbstractC4043Dl1.c(S7(), TA5.color8));
        if (ea().i1() <= 1000) {
            da().L.setText(ea().t1() ? h6(AbstractC12217eE5.gold_gift_packet_owner_expire) : h6(AbstractC12217eE5.gift_packet_owner_expire));
        } else {
            sa();
        }
    }

    private final void ia() {
        da().H.setTypeface(C6011Lu2.k());
        da().H.setVisibility(0);
        da().G.setVisibility(0);
        da().G.B(11.0f, true);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(null), 3, null);
    }

    private final void ja() {
        FrameLayout root = da().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        AbstractC16172kp3.a(root);
        da().L.setTextSize(16.0f);
        da().L.setTypeface(C6011Lu2.k());
        da().p.setTypeface(C6011Lu2.k());
        da().Q.setTypeface(C6011Lu2.i());
        if (ea().t1()) {
            da().Q.setText(h6(AbstractC12217eE5.gold_gift_packet));
            da().P.setText(h6(AbstractC12217eE5.gold_gift_packet));
            da().P.setTextColor(S7().getColor(TA5.a01_light));
            da().O.setImageDrawable(AbstractC4043Dl1.f(S7(), KB5.gift_card));
            da().O.setColorFilter(S7().getColor(TA5.a01_light), PorterDuff.Mode.SRC_IN);
            da().V.setText(h6(AbstractC12217eE5.gold_gift_dialogs_result_win_status_new_done));
            da().U.setText(h6(AbstractC12217eE5.gold_gift_dialogs_result_win_status_new));
            da().k0.setText(h6(AbstractC12217eE5.amount_of_gift_will_be_deposit_into_your_gold_wallet));
            da().d.setImageResource(KB5.gold_gift_card);
        }
        da().U.setTypeface(C6011Lu2.k());
        da().t.setTypeface(C6011Lu2.i());
        da().r.d.setTypeface(C6011Lu2.k());
        da().p.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.WK4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YK4.ka(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ka(YK4 yk4, View view) {
        AbstractC13042fc3.i(yk4, "this$0");
        yk4.Q7().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la() {
        da().b.setVisibility(0);
        da().t.setVisibility(0);
    }

    private final void ma(long winAmount, boolean isAlreadyReceived, boolean isFirst) {
        String strV;
        String strI6;
        String strI62;
        String str;
        String strC = XY6.c(XY6.e(String.valueOf(winAmount)), (char) 0, 2, null);
        if (ea().j1()) {
            da().y.setVisibility(0);
        } else {
            da().S.setVisibility(0);
        }
        TextView textView = da().R;
        if (ea().t1()) {
            TextView textView2 = da().T;
            if (winAmount >= 1000) {
                str = Separators.SP + S7().getString(AbstractC12217eE5.wallet_gold);
            } else {
                str = Separators.SP + S7().getString(AbstractC12217eE5.wallet_gold_mill);
            }
            textView2.setText(str);
            strV = winAmount >= 1000 ? XY6.v(String.valueOf(winAmount / 1000.0d)) : XY6.d(String.valueOf(winAmount));
        } else {
            strV = strC;
        }
        textView.setText(strV);
        TextView textView3 = da().m;
        if (!ea().t1()) {
            strI6 = i6(AbstractC12217eE5.gift_packet_rial, strC);
            AbstractC13042fc3.f(strI6);
        } else if (winAmount >= 1000) {
            strI6 = XY6.v(String.valueOf(winAmount / 1000.0d)) + Separators.SP + S7().getString(AbstractC12217eE5.wallet_gold);
        } else {
            strI6 = XY6.d(String.valueOf(winAmount)) + Separators.SP + S7().getString(AbstractC12217eE5.wallet_gold_mill);
        }
        textView3.setText(strI6);
        String strC2 = XY6.c(XY6.e(String.valueOf(ea().k1())), (char) 0, 2, null);
        TextView textView4 = da().b0;
        if (!ea().t1()) {
            strI62 = i6(AbstractC12217eE5.gift_packet_rial, strC2);
            AbstractC13042fc3.f(strI62);
        } else if (ea().k1() >= 1000) {
            strI62 = XY6.v(String.valueOf(ea().k1() / 1000.0d)) + Separators.SP + S7().getString(AbstractC12217eE5.wallet_gold);
        } else {
            strI62 = XY6.d(String.valueOf(ea().k1())) + Separators.SP + S7().getString(AbstractC12217eE5.wallet_gold_mill);
        }
        textView4.setText(strI62);
        if (!isAlreadyReceived) {
            da().d0.setVisibility(0);
        }
        if (isFirst) {
            return;
        }
        if (C5495Jo7.a.J2()) {
            da().d.setImageResource(KB5.ic_big_gift_dark);
        } else {
            da().d.setImageResource(KB5.ic_big_gift);
        }
        da().I.setVisibility(8);
        da().K.setVisibility(8);
        da().J.setVisibility(8);
    }

    private final void na(InterfaceC7406Ro6.b state) {
        if (!state.b()) {
            da().h.setText("۰");
            da().i.setText("۱");
            ha(true);
            return;
        }
        da().h.setText("۱");
        da().i.setText("۰");
        da().L.setText(ea().t1() ? h6(AbstractC12217eE5.gold_gift_packet_owner_finish_private) : h6(AbstractC12217eE5.gift_packet_owner_finish_private));
        GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiverA = state.a();
        if (giftpacketStruct$GiftReceiverA != null) {
            Y9(this, AbstractC9766aX0.e(giftpacketStruct$GiftReceiverA), 0, 1, false, 8, null);
        }
    }

    private final void oa(YI5.b state) {
        ma(ea().k1(), state.a(), false);
    }

    private final void pa(YI5 state) {
        ia();
        if (state.a()) {
            da().L.setText(h6(AbstractC12217eE5.gift_packet_status_received));
        } else {
            sa();
            da().U.setVisibility(0);
            if (ea().e1()) {
                da().U.setText(ea().t1() ? h6(AbstractC12217eE5.amount_of_gift_will_be_deposit_into_your_gold_wallet) : h6(AbstractC12217eE5.amount_of_gift_will_be_deposit_into_your_wallet));
            }
        }
        if (C5495Jo7.a.J2()) {
            da().d.setImageResource(KB5.ic_big_gift_dark);
        } else {
            da().d.setImageResource(KB5.ic_big_gift);
        }
        if (state instanceof YI5.a) {
            ga((YI5.a) state);
        } else {
            if (!(state instanceof YI5.b)) {
                throw new NoWhenBranchMatchedException();
            }
            oa((YI5.b) state);
        }
    }

    private final void qa(InterfaceC7406Ro6 state) {
        da().e0.setVisibility(8);
        if (ea().t1()) {
            da().d.setImageResource(KB5.gold_gift_card);
        } else {
            da().d.setImageResource(KB5.ic_big_owner);
        }
        da().D.setVisibility(8);
        da().F.setVisibility(8);
        da().I.setVisibility(8);
        da().K.setVisibility(8);
        da().J.setVisibility(8);
        da().x.setVisibility(0);
        da().C.setVisibility(0);
        da().i.setVisibility(0);
        sa();
        if (state instanceof InterfaceC7406Ro6.a) {
            fa((InterfaceC7406Ro6.a) state);
        } else {
            if (!(state instanceof InterfaceC7406Ro6.b)) {
                throw new NoWhenBranchMatchedException();
            }
            na((InterfaceC7406Ro6.b) state);
        }
    }

    private final void ra(AbstractC17632nI2.d soldOut) {
        String strC;
        da().v.setVisibility(0);
        if (!ea().t1()) {
            strC = XY6.c(XY6.e(String.valueOf(ea().k1())), (char) 0, 2, null);
        } else if (ea().k1() >= 1000) {
            da().w.setText(S7().getString(AbstractC12217eE5.wallet_gold));
            strC = XY6.v(String.valueOf(ea().k1() / 1000.0d));
        } else {
            da().w.setText(S7().getString(AbstractC12217eE5.wallet_gold_mill));
            strC = XY6.d(String.valueOf(ea().k1()));
        }
        da().u.setText(strC);
        if (soldOut.b()) {
            da().q.setVisibility(8);
            StringBuilder sb = new StringBuilder();
            sb.append(h6(AbstractC12217eE5.gift_packet_status_private_lose));
            char[] chars = Character.toChars(128532);
            AbstractC13042fc3.h(chars, "toChars(...)");
            sb.append(new String(chars));
            String string = sb.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            da().I.setText(string);
        } else {
            X9(soldOut.d(), 0, soldOut.c(), true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(h6(!ea().e1() ? AbstractC12217eE5.gift_dialogs_lose_comment_new : AbstractC12217eE5.competion_is_heavy));
            char[] chars2 = Character.toChars(128525);
            AbstractC13042fc3.h(chars2, "toChars(...)");
            sb2.append(new String(chars2));
            String string2 = sb2.toString();
            AbstractC13042fc3.h(string2, "toString(...)");
            da().I.setText(string2);
        }
        da().L.setText(ea().t1() ? h6(AbstractC12217eE5.gold_gift_packet_status_lose_gift) : h6(AbstractC12217eE5.gift_packet_status_lose_gift));
        da().L.setVisibility(0);
        da().I.setVisibility(0);
        da().U.setVisibility(8);
    }

    private final void sa() {
        new j(ea().i1()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(InterfaceC17041mI2 state) {
        da().W.setVisibility(0);
        da().W.setImportantForAccessibility(1);
        da().l.getRoot().setVisibility(8);
        da().b.setVisibility(8);
        da().t.setVisibility(8);
        if (state instanceof InterfaceC17041mI2.a) {
            pa(((InterfaceC17041mI2.a) state).a());
        } else {
            if (!(state instanceof InterfaceC17041mI2.b)) {
                throw new NoWhenBranchMatchedException();
            }
            qa(((InterfaceC17041mI2.b) state).a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        Window window;
        super.M6(savedInstanceState);
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 != null && (window = fragmentActivityA5.getWindow()) != null) {
            window.addFlags(8192);
        }
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            long j2 = bundleE5.getLong("arg_rid", 0L);
            int i2 = bundleE5.getInt("arg_owner_id", 0);
            long j3 = bundleE5.getLong("arg_date", 0L);
            ExPeerType exPeerTypeFromValue = ExPeerType.fromValue(bundleE5.getInt("arg_expeer_type", 0));
            AbstractC13042fc3.h(exPeerTypeFromValue, "fromValue(...)");
            long j4 = bundleE5.getLong("arg_total_AMOUNT", 0L);
            int i3 = bundleE5.getInt("arg_peer_id", 0);
            int i4 = (int) bundleE5.getLong("arg_packet_count", 0L);
            boolean z = bundleE5.getBoolean("arg_later_send_to_wallet", false);
            boolean z2 = bundleE5.getBoolean("arg_random_gift_packet_is_failure", false);
            boolean z3 = bundleE5.getBoolean("arg_given_type_is_random", false);
            boolean z4 = bundleE5.getBoolean("arg_show_total_amount", false);
            boolean z5 = bundleE5.getBoolean("ARG_IS_GOLD", false);
            Long lValueOf = Long.valueOf(bundleE5.getLong("ARG_ID_GOLD", -1L));
            if (lValueOf.longValue() == -1) {
                lValueOf = null;
            }
            ea().q1(j2, i3, i2, j3, exPeerTypeFromValue, z2, z, z3, j4, z4, i4, z5, lValueOf);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.inflate(AbstractC12208eD5.new_gift_packet_recycler_result_layout, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        Window window;
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 != null && (window = fragmentActivityA5.getWindow()) != null) {
            window.clearFlags(8192);
        }
        super.R6();
    }

    public final C8624Wt4 da() {
        return (C8624Wt4) this.binding.a(this, l1[0]);
    }

    public final BI2 ea() {
        return (BI2) this.viewmodel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ja();
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new c(null), 3, null);
    }
}
