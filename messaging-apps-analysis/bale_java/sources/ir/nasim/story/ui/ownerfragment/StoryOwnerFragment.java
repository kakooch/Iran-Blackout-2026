package ir.nasim.story.ui.ownerfragment;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11710dT6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19455qN7;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC23008wB5;
import ir.nasim.AbstractC23640xG2;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC9718aR6;
import ir.nasim.C10366bX6;
import ir.nasim.C10600bs7;
import ir.nasim.C14189hV6;
import ir.nasim.C14593iA1;
import ir.nasim.C14733iO2;
import ir.nasim.C19938rB7;
import ir.nasim.C20672sP6;
import ir.nasim.C21231tK7;
import ir.nasim.C22042ua0;
import ir.nasim.C24066xz2;
import ir.nasim.C5495Jo7;
import ir.nasim.D20;
import ir.nasim.EnumC20117rV6;
import ir.nasim.HG1;
import ir.nasim.InterfaceC10040ay6;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.JF5;
import ir.nasim.MW6;
import ir.nasim.QQ6;
import ir.nasim.SA2;
import ir.nasim.SD5;
import ir.nasim.SX2;
import ir.nasim.XY6;
import ir.nasim.YK6;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.story.ui.ownerfragment.StoryOwnerFragment;
import ir.nasim.story.ui.storyadder.StoryAdderSourceCallerEnum;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import org.xbill.DNS.Type;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0003J\r\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u0003J\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R!\u00109\u001a\b\u0012\u0004\u0012\u000205048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u00100\u001a\u0004\b7\u00108R\u0016\u0010=\u001a\u0004\u0018\u00010:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010A\u001a\u0004\u0018\u00010>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lir/nasim/story/ui/ownerfragment/StoryOwnerFragment;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ha", "ga", "ia", "qa", "ra", "ca", "ea", "Lir/nasim/QQ6;", "myStory", "ta", "(Lir/nasim/QQ6;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "i9", "T6", "na", "la", "Lir/nasim/iO2;", "groupVm", "oa", "(Lir/nasim/iO2;)V", "Lir/nasim/tK7;", "userVM", "pa", "(Lir/nasim/tK7;)V", "Lir/nasim/xz2;", "h1", "Lir/nasim/xz2;", "binding", "i1", "Lir/nasim/iO2;", "j1", "Lir/nasim/tK7;", "userVm", "Lir/nasim/bX6;", "k1", "Lir/nasim/Yu3;", "ma", "()Lir/nasim/bX6;", "viewModel", "Lir/nasim/ay6;", "", "l1", "ka", "()Lir/nasim/ay6;", "showSnackBar", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "z", "()Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, "", "ja", "()Ljava/lang/Integer;", "peerId", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class StoryOwnerFragment extends SX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private C24066xz2 binding;

    /* renamed from: i1, reason: from kotlin metadata */
    private C14733iO2 groupVm;

    /* renamed from: j1, reason: from kotlin metadata */
    private C21231tK7 userVm;

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rS6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return StoryOwnerFragment.ua(this.a);
        }
    });

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 showSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.sS6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return StoryOwnerFragment.sa(this.a);
        }
    });

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[YK6.values().length];
            try {
                iArr2[YK6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[YK6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ StoryOwnerFragment a;

            /* renamed from: ir.nasim.story.ui.ownerfragment.StoryOwnerFragment$b$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C1547a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[ExPeerType.values().length];
                    try {
                        iArr[ExPeerType.PRIVATE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ExPeerType.BOT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ExPeerType.CHANNEL.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[ExPeerType.GROUP.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    a = iArr;
                }
            }

            a(StoryOwnerFragment storyOwnerFragment) {
                this.a = storyOwnerFragment;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(AbstractC23640xG2 abstractC23640xG2, InterfaceC20295rm1 interfaceC20295rm1) {
                ExPeerType exPeerTypeZ = this.a.z();
                int i = exPeerTypeZ == null ? -1 : C1547a.a[exPeerTypeZ.ordinal()];
                if (i == 1) {
                    StoryOwnerFragment storyOwnerFragment = this.a;
                    storyOwnerFragment.ta(storyOwnerFragment.ma().x3(this.a.ma().W3()));
                } else if (i == 2) {
                    StoryOwnerFragment storyOwnerFragment2 = this.a;
                    C10366bX6 c10366bX6Ma = storyOwnerFragment2.ma();
                    C21231tK7 c21231tK7 = this.a.userVm;
                    AbstractC13042fc3.f(c21231tK7);
                    storyOwnerFragment2.ta(c10366bX6Ma.x3(c21231tK7.o()));
                } else if (i == 3 || i == 4) {
                    StoryOwnerFragment storyOwnerFragment3 = this.a;
                    C10366bX6 c10366bX6Ma2 = storyOwnerFragment3.ma();
                    C14733iO2 c14733iO2 = this.a.groupVm;
                    AbstractC13042fc3.f(c14733iO2);
                    storyOwnerFragment3.ta(c10366bX6Ma2.x3(c14733iO2.r()));
                }
                return C19938rB7.a;
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return StoryOwnerFragment.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6H3 = StoryOwnerFragment.this.ma().H3();
                a aVar = new a(StoryOwnerFragment.this);
                this.b = 1;
                if (interfaceC10258bL6H3.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
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
            final /* synthetic */ StoryOwnerFragment c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(StoryOwnerFragment storyOwnerFragment, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = storyOwnerFragment;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.b = 1;
                    if (HG1.b(500L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                D20.a aVarA = C10600bs7.a.a(this.c);
                String strH6 = this.c.h6(SD5.story_balloon_channel_owner);
                AbstractC13042fc3.h(strH6, "getString(...)");
                aVarA.X1(strH6);
                aVarA.a1(0.15f);
                aVarA.k2(Type.TSIG);
                aVarA.u1(RecyclerView.UNDEFINED_DURATION);
                aVarA.b2(5);
                D20 d20A = aVarA.a();
                C24066xz2 c24066xz2 = this.c.binding;
                if (c24066xz2 == null) {
                    AbstractC13042fc3.y("binding");
                    c24066xz2 = null;
                }
                TextView textView = c24066xz2.b;
                AbstractC13042fc3.h(textView, "addStoryText");
                d20A.J0(textView, 0, 0);
                this.c.ma().L5();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return StoryOwnerFragment.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryOwnerFragment storyOwnerFragment = StoryOwnerFragment.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(storyOwnerFragment, null);
                this.b = 1;
                if (w.b(storyOwnerFragment, bVar, aVar, this) == objE) {
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

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ StoryOwnerFragment c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(StoryOwnerFragment storyOwnerFragment, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = storyOwnerFragment;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.b = 1;
                    if (HG1.b(500L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                D20.a aVarA = C10600bs7.a.a(this.c);
                String strH6 = this.c.h6(SD5.story_balloon_group_owner);
                AbstractC13042fc3.h(strH6, "getString(...)");
                aVarA.X1(strH6);
                aVarA.a1(0.15f);
                aVarA.k2(Type.TSIG);
                aVarA.u1(RecyclerView.UNDEFINED_DURATION);
                aVarA.b2(5);
                D20 d20A = aVarA.a();
                C24066xz2 c24066xz2 = this.c.binding;
                if (c24066xz2 == null) {
                    AbstractC13042fc3.y("binding");
                    c24066xz2 = null;
                }
                TextView textView = c24066xz2.b;
                AbstractC13042fc3.h(textView, "addStoryText");
                d20A.J0(textView, 0, 0);
                this.c.ma().M5();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return StoryOwnerFragment.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryOwnerFragment storyOwnerFragment = StoryOwnerFragment.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(storyOwnerFragment, null);
                this.b = 1;
                if (w.b(storyOwnerFragment, bVar, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final void ca() {
        C24066xz2 c24066xz2 = this.binding;
        if (c24066xz2 == null) {
            AbstractC13042fc3.y("binding");
            c24066xz2 = null;
        }
        c24066xz2.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.uS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryOwnerFragment.da(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(StoryOwnerFragment storyOwnerFragment, View view) {
        AbstractC13042fc3.i(storyOwnerFragment, "this$0");
        C14733iO2 c14733iO2 = storyOwnerFragment.groupVm;
        if (c14733iO2 != null && ((Number) c14733iO2.u().b()).intValue() < storyOwnerFragment.ma().e4()) {
            C10366bX6 c10366bX6Ma = storyOwnerFragment.ma();
            String strI6 = storyOwnerFragment.i6(SD5.story_snackbar_message_for_member_count, XY6.v(String.valueOf(storyOwnerFragment.ma().e4())));
            AbstractC13042fc3.h(strI6, "getString(...)");
            c10366bX6Ma.R5(strI6);
            return;
        }
        Integer numJa = storyOwnerFragment.ja();
        ExPeerType exPeerTypeZ = storyOwnerFragment.z();
        if (numJa != null && exPeerTypeZ != null) {
            storyOwnerFragment.ma().S5(numJa.intValue(), exPeerTypeZ);
        }
        C22042ua0.A9(storyOwnerFragment, C20672sP6.INSTANCE.a(StoryAdderSourceCallerEnum.d), false, null, 6, null);
    }

    private final void ea() {
        C21231tK7 c21231tK7C;
        C24066xz2 c24066xz2 = this.binding;
        if (c24066xz2 == null) {
            AbstractC13042fc3.y("binding");
            c24066xz2 = null;
        }
        AvatarViewGlide avatarViewGlide = c24066xz2.c;
        avatarViewGlide.B(22.0f, true);
        ExPeerType exPeerTypeZ = z();
        int i = exPeerTypeZ == null ? -1 : a.a[exPeerTypeZ.ordinal()];
        if (i == 1 || i == 2) {
            avatarViewGlide.q(this.groupVm);
        } else if (i == 3) {
            C21231tK7 c21231tK7 = this.userVm;
            if (c21231tK7 != null) {
                AvatarViewGlide.u(avatarViewGlide, c21231tK7, null, 2, null);
            }
        } else if (i == 4 && (c21231tK7C = AbstractC5969Lp4.c()) != null) {
            AvatarViewGlide.u(avatarViewGlide, c21231tK7C, null, 2, null);
        }
        avatarViewGlide.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryOwnerFragment.fa(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(StoryOwnerFragment storyOwnerFragment, View view) {
        AbstractC13042fc3.i(storyOwnerFragment, "this$0");
        C24066xz2 c24066xz2 = storyOwnerFragment.binding;
        Integer numValueOf = null;
        if (c24066xz2 == null) {
            AbstractC13042fc3.y("binding");
            c24066xz2 = null;
        }
        AppCompatImageView appCompatImageView = c24066xz2.f;
        AbstractC13042fc3.h(appCompatImageView, "storyRing");
        if (appCompatImageView.getVisibility() == 0) {
            ExPeerType exPeerTypeZ = storyOwnerFragment.z();
            int i = exPeerTypeZ == null ? -1 : a.a[exPeerTypeZ.ordinal()];
            if (i == 1 || i == 2) {
                C14733iO2 c14733iO2 = storyOwnerFragment.groupVm;
                if (c14733iO2 != null) {
                    numValueOf = Integer.valueOf(c14733iO2.r());
                }
            } else if (i == 3) {
                C21231tK7 c21231tK7 = storyOwnerFragment.userVm;
                if (c21231tK7 != null) {
                    numValueOf = Integer.valueOf(c21231tK7.o());
                }
            } else if (i == 4) {
                numValueOf = Integer.valueOf(storyOwnerFragment.ma().W3());
            }
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                if (!storyOwnerFragment.ma().p4(iIntValue).isEmpty()) {
                    C22042ua0.A9(storyOwnerFragment, MW6.INSTANCE.a(iIntValue, new ArrayList(), (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? -1 : 0), false, null, 6, null);
                }
            }
        }
    }

    private final void ga() {
        C24066xz2 c24066xz2 = this.binding;
        if (c24066xz2 == null) {
            AbstractC13042fc3.y("binding");
            c24066xz2 = null;
        }
        TextView textView = c24066xz2.h;
        ExPeerType exPeerTypeZ = z();
        int i = exPeerTypeZ == null ? -1 : a.a[exPeerTypeZ.ordinal()];
        if (i == 1) {
            textView.setText(SD5.channel_story);
        } else if (i == 2) {
            textView.setText(SD5.group_story);
        } else {
            if (i != 3) {
                return;
            }
            textView.setText(SD5.bot_story);
        }
    }

    private final void ha() {
        ea();
        ca();
        ga();
    }

    private final void ia() {
        C24066xz2 c24066xz2 = this.binding;
        if (c24066xz2 == null) {
            AbstractC13042fc3.y("binding");
            c24066xz2 = null;
        }
        TextView textView = c24066xz2.b;
        C24066xz2 c24066xz22 = this.binding;
        if (c24066xz22 == null) {
            AbstractC13042fc3.y("binding");
            c24066xz22 = null;
        }
        textView.setTextColor(c24066xz22.b.getTextColors().withAlpha(50));
        C24066xz2 c24066xz23 = this.binding;
        if (c24066xz23 == null) {
            AbstractC13042fc3.y("binding");
            c24066xz23 = null;
        }
        for (Drawable drawable : c24066xz23.b.getCompoundDrawables()) {
            if (drawable != null) {
                C24066xz2 c24066xz24 = this.binding;
                if (c24066xz24 == null) {
                    AbstractC13042fc3.y("binding");
                    c24066xz24 = null;
                }
                drawable.setColorFilter(new PorterDuffColorFilter(c24066xz24.b.getTextColors().withAlpha(50).getDefaultColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    private final Integer ja() {
        C14733iO2 c14733iO2 = this.groupVm;
        if (c14733iO2 != null) {
            return Integer.valueOf(c14733iO2.r());
        }
        C21231tK7 c21231tK7 = this.userVm;
        if (c21231tK7 != null) {
            return Integer.valueOf(c21231tK7.o());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10366bX6 ma() {
        return (C10366bX6) this.viewModel.getValue();
    }

    private final void qa() {
        if (ma().D3()) {
            return;
        }
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new c(null), 3, null);
    }

    private final void ra() {
        if (ma().J3()) {
            return;
        }
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10040ay6 sa(StoryOwnerFragment storyOwnerFragment) {
        AbstractC13042fc3.i(storyOwnerFragment, "this$0");
        return storyOwnerFragment.ma().f4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(QQ6 myStory) {
        EnumC20117rV6 enumC20117rV6A;
        C24066xz2 c24066xz2 = null;
        if (myStory == null) {
            C24066xz2 c24066xz22 = this.binding;
            if (c24066xz22 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz22 = null;
            }
            c24066xz22.f.setVisibility(4);
            C24066xz2 c24066xz23 = this.binding;
            if (c24066xz23 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz23 = null;
            }
            c24066xz23.d.setVisibility(4);
            C24066xz2 c24066xz24 = this.binding;
            if (c24066xz24 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c24066xz2 = c24066xz24;
            }
            c24066xz2.g.setVisibility(8);
            return;
        }
        if (myStory.u() == YK6.b) {
            C24066xz2 c24066xz25 = this.binding;
            if (c24066xz25 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz25 = null;
            }
            c24066xz25.f.setImageDrawable(AbstractC4043Dl1.f(S7(), AbstractC23008wB5.drawable_ring_error_story));
            C24066xz2 c24066xz26 = this.binding;
            if (c24066xz26 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz26 = null;
            }
            c24066xz26.e.setVisibility(8);
        } else {
            AbstractC11710dT6 abstractC11710dT6S = myStory.s();
            AbstractC11710dT6.a aVar = AbstractC11710dT6.a.a;
            if (!AbstractC13042fc3.d(abstractC11710dT6S, aVar)) {
                C24066xz2 c24066xz27 = this.binding;
                if (c24066xz27 == null) {
                    AbstractC13042fc3.y("binding");
                    c24066xz27 = null;
                }
                c24066xz27.f.setImageDrawable(AbstractC4043Dl1.f(S7(), AbstractC23008wB5.drawable_ring_viewed_story));
            } else if (AbstractC9718aR6.a(myStory)) {
                EnumC20117rV6.a aVar2 = EnumC20117rV6.h;
                Integer numY = myStory.y();
                AbstractC13042fc3.f(numY);
                EnumC20117rV6 enumC20117rV6A2 = aVar2.a(numY.intValue());
                if (enumC20117rV6A2 != null) {
                    C24066xz2 c24066xz28 = this.binding;
                    if (c24066xz28 == null) {
                        AbstractC13042fc3.y("binding");
                        c24066xz28 = null;
                    }
                    c24066xz28.f.setImageResource(enumC20117rV6A2.u());
                }
            } else {
                C24066xz2 c24066xz29 = this.binding;
                if (c24066xz29 == null) {
                    AbstractC13042fc3.y("binding");
                    c24066xz29 = null;
                }
                c24066xz29.f.setImageDrawable(AbstractC4043Dl1.f(S7(), AbstractC23008wB5.drawable_ring_new_story));
            }
            C14189hV6 c14189hV6W = myStory.w();
            if (c14189hV6W != null && (enumC20117rV6A = EnumC20117rV6.h.a(c14189hV6W.a())) != null) {
                C24066xz2 c24066xz210 = this.binding;
                if (c24066xz210 == null) {
                    AbstractC13042fc3.y("binding");
                    c24066xz210 = null;
                }
                c24066xz210.e.setVisibility(0);
                if (AbstractC13042fc3.d(myStory.s(), aVar)) {
                    C24066xz2 c24066xz211 = this.binding;
                    if (c24066xz211 == null) {
                        AbstractC13042fc3.y("binding");
                        c24066xz211 = null;
                    }
                    c24066xz211.e.setImageResource(enumC20117rV6A.j());
                } else {
                    C24066xz2 c24066xz212 = this.binding;
                    if (c24066xz212 == null) {
                        AbstractC13042fc3.y("binding");
                        c24066xz212 = null;
                    }
                    c24066xz212.e.setImageResource(enumC20117rV6A.p());
                }
            }
            if (myStory.w() == null) {
                C24066xz2 c24066xz213 = this.binding;
                if (c24066xz213 == null) {
                    AbstractC13042fc3.y("binding");
                    c24066xz213 = null;
                }
                c24066xz213.e.setVisibility(8);
            }
        }
        C24066xz2 c24066xz214 = this.binding;
        if (c24066xz214 == null) {
            AbstractC13042fc3.y("binding");
            c24066xz214 = null;
        }
        c24066xz214.d.setVisibility(4);
        int i = a.b[myStory.u().ordinal()];
        if (i == 1) {
            C24066xz2 c24066xz215 = this.binding;
            if (c24066xz215 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz215 = null;
            }
            c24066xz215.g.setTextColor(C5495Jo7.a.v0());
            C24066xz2 c24066xz216 = this.binding;
            if (c24066xz216 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz216 = null;
            }
            c24066xz216.g.setText(h6(SD5.sending_story));
        } else if (i != 2) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            String strJ = C14593iA1.j(contextS7, myStory.f() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, false, 4, null);
            if (!AbstractC13042fc3.d(strJ, h6(SD5.story_date_now))) {
                strJ = strJ + h6(SD5.story_date_ago);
            }
            if (JF5.g()) {
                strJ = XY6.e(strJ);
            }
            C24066xz2 c24066xz217 = this.binding;
            if (c24066xz217 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz217 = null;
            }
            c24066xz217.g.setTextColor(C5495Jo7.a.v0());
            C24066xz2 c24066xz218 = this.binding;
            if (c24066xz218 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz218 = null;
            }
            c24066xz218.g.setText(strJ);
        } else {
            C24066xz2 c24066xz219 = this.binding;
            if (c24066xz219 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz219 = null;
            }
            c24066xz219.g.setTextColor(C5495Jo7.a.B0());
            C24066xz2 c24066xz220 = this.binding;
            if (c24066xz220 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz220 = null;
            }
            c24066xz220.g.setText(h6(SD5.story_uploading_error));
            C24066xz2 c24066xz221 = this.binding;
            if (c24066xz221 == null) {
                AbstractC13042fc3.y("binding");
                c24066xz221 = null;
            }
            c24066xz221.d.setVisibility(0);
        }
        C24066xz2 c24066xz222 = this.binding;
        if (c24066xz222 == null) {
            AbstractC13042fc3.y("binding");
            c24066xz222 = null;
        }
        c24066xz222.f.setVisibility(0);
        C24066xz2 c24066xz223 = this.binding;
        if (c24066xz223 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c24066xz2 = c24066xz223;
        }
        c24066xz2.g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 ua(StoryOwnerFragment storyOwnerFragment) {
        AbstractC13042fc3.i(storyOwnerFragment, "this$0");
        FragmentActivity fragmentActivityQ7 = storyOwnerFragment.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new G(fragmentActivityQ7).b(C10366bX6.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExPeerType z() {
        C14733iO2 c14733iO2 = this.groupVm;
        if (c14733iO2 != null) {
            return c14733iO2.p();
        }
        C21231tK7 c21231tK7 = this.userVm;
        if (c21231tK7 != null) {
            return c21231tK7.n();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C24066xz2 c24066xz2C = C24066xz2.c(inflater, container, false);
        this.binding = c24066xz2C;
        if (c24066xz2C == null) {
            AbstractC13042fc3.y("binding");
            c24066xz2C = null;
        }
        ConstraintLayout root = c24066xz2C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        ma().d6();
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        ma().Y4();
    }

    public final InterfaceC10040ay6 ka() {
        return (InterfaceC10040ay6) this.showSnackBar.getValue();
    }

    public final void la() {
        if (ma().H3().getValue() instanceof AbstractC23640xG2.b) {
            return;
        }
        ma().g4();
    }

    public final void na() {
        AbstractC19455qN7.g(this, null, new b(null), 1, null);
        ha();
    }

    public final void oa(C14733iO2 groupVm) {
        AbstractC13042fc3.i(groupVm, "groupVm");
        this.groupVm = groupVm;
        na();
        if (groupVm.p() == ExPeerType.CHANNEL) {
            qa();
        } else if (groupVm.p() == ExPeerType.GROUP) {
            ra();
        }
        if (((Number) groupVm.u().b()).intValue() < ma().e4()) {
            ia();
        }
    }

    public final void pa(C21231tK7 userVM) {
        AbstractC13042fc3.i(userVM, "userVM");
        this.userVm = userVM;
        na();
    }
}
