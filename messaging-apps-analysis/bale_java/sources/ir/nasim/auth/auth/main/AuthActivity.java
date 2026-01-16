package ir.nasim.auth.auth.main;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19329q98;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C14819iX7;
import ir.nasim.C15661jx4;
import ir.nasim.C19938rB7;
import ir.nasim.C5798Kw4;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.auth.auth.main.a;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0011\u0010\u0003R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lir/nasim/auth/auth/main/AuthActivity;", "Lir/nasim/designsystem/base/activity/BaseFragmentActivity;", "<init>", "()V", "Lir/nasim/rB7;", "p2", "Lir/nasim/auth/auth/main/a;", "viewState", "q2", "(Lir/nasim/auth/auth/main/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "W1", "()Z", "onPause", "Lir/nasim/auth/auth/main/b;", "L0", "Lir/nasim/Yu3;", "o2", "()Lir/nasim/auth/auth/main/b;", "viewModel", "authentication_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class AuthActivity extends Hilt_AuthActivity {

    /* renamed from: L0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = new F(AbstractC10882cM5.b(ir.nasim.auth.auth.main.b.class), new c(this), new b(this), new d(null, this));

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.auth.auth.main.AuthActivity$a$a, reason: collision with other inner class name */
        static final class C0871a implements InterfaceC4806Gq2 {
            final /* synthetic */ AuthActivity a;

            C0871a(AuthActivity authActivity) {
                this.a = authActivity;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(ir.nasim.auth.auth.main.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.q2(aVar);
                return C19938rB7.a;
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AuthActivity.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6T0 = AuthActivity.this.o2().T0();
                C0871a c0871a = new C0871a(AuthActivity.this);
                this.b = 1;
                if (interfaceC10258bL6T0.b(c0871a, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.n3();
        }
    }

    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.d1();
        }
    }

    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ ComponentActivity f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2, ComponentActivity componentActivity) {
            super(0);
            this.e = sa2;
            this.f = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            return (sa2 == null || (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) == null) ? this.f.p3() : abstractC20375ru1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ir.nasim.auth.auth.main.b o2() {
        return (ir.nasim.auth.auth.main.b) this.viewModel.getValue();
    }

    private final void p2() {
        AbstractC19224pz3.a(this).d(new a(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q2(ir.nasim.auth.auth.main.a viewState) {
        if (viewState instanceof a.C0872a) {
            j2(C15661jx4.INSTANCE.a(((a.C0872a) viewState).a()));
        } else {
            j2(C5798Kw4.INSTANCE.a());
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    public boolean W1() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseFragmentActivity, ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AbstractC19329q98.b(getWindow(), false);
        super.onCreate(savedInstanceState);
        p2();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        R4();
    }
}
