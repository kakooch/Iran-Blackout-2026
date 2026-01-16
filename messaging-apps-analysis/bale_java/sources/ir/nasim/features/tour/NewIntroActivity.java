package ir.nasim.features.tour;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C12001du4;
import ir.nasim.C14433hu3;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.TA5;
import ir.nasim.UQ;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.features.tour.NewIntroActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lir/nasim/features/tour/NewIntroActivity;", "Lir/nasim/designsystem/base/activity/BaseActivity;", "<init>", "()V", "Lir/nasim/rB7;", "A2", "o2", "p2", "", "W1", "()Z", "onStart", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lir/nasim/features/tour/NewPagerWithIndicator;", "K0", "Lir/nasim/features/tour/NewPagerWithIndicator;", "pagerBullet", "Lir/nasim/du4;", "L0", "Lir/nasim/du4;", "adapter", "Landroid/widget/FrameLayout;", "M0", "Landroid/widget/FrameLayout;", "rootView", "N0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class NewIntroActivity extends BaseActivity {
    public static final int O0 = 8;

    /* renamed from: K0, reason: from kotlin metadata */
    private NewPagerWithIndicator pagerBullet;

    /* renamed from: L0, reason: from kotlin metadata */
    private C12001du4 adapter;

    /* renamed from: M0, reason: from kotlin metadata */
    private FrameLayout rootView;

    private final void A2() {
        Bundle bundle = new Bundle();
        bundle.putInt("sign_type", 4);
        C5735Kp4.w().B(this, bundle);
        finish();
    }

    private final void o2() {
        NewPagerWithIndicator newPagerWithIndicator = this.pagerBullet;
        AbstractC13042fc3.f(newPagerWithIndicator);
        int currentItem = newPagerWithIndicator.getViewPagerBullet().getCurrentItem();
        NewPagerWithIndicator newPagerWithIndicator2 = this.pagerBullet;
        if (newPagerWithIndicator2 != null) {
            newPagerWithIndicator2.setCurrentItem(currentItem + 1);
        }
    }

    private final void p2() {
        NewPagerWithIndicator newPagerWithIndicator = this.pagerBullet;
        AbstractC13042fc3.f(newPagerWithIndicator);
        int currentItem = newPagerWithIndicator.getViewPagerBullet().getCurrentItem();
        NewPagerWithIndicator newPagerWithIndicator2 = this.pagerBullet;
        if (newPagerWithIndicator2 != null) {
            newPagerWithIndicator2.setCurrentItem(currentItem - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(NewIntroActivity newIntroActivity, View view) {
        AbstractC13042fc3.i(newIntroActivity, "this$0");
        NewPagerWithIndicator newPagerWithIndicator = newIntroActivity.pagerBullet;
        if (newPagerWithIndicator != null) {
            if ((newPagerWithIndicator != null ? newPagerWithIndicator.getViewPagerBullet() : null) != null) {
                newIntroActivity.o2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(NewIntroActivity newIntroActivity, View view) {
        AbstractC13042fc3.i(newIntroActivity, "this$0");
        NewPagerWithIndicator newPagerWithIndicator = newIntroActivity.pagerBullet;
        if (newPagerWithIndicator != null) {
            if ((newPagerWithIndicator != null ? newPagerWithIndicator.getViewPagerBullet() : null) != null) {
                newIntroActivity.p2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(NewIntroActivity newIntroActivity, View view) {
        AbstractC13042fc3.i(newIntroActivity, "this$0");
        newIntroActivity.A2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(NewIntroActivity newIntroActivity, View view) {
        AbstractC13042fc3.i(newIntroActivity, "this$0");
        newIntroActivity.A2();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    public boolean W1() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        C6011Lu2.m(this);
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);
        this.rootView = frameLayout;
        AbstractC13042fc3.f(frameLayout);
        frameLayout.setLayoutParams(C14433hu3.a(-1, -1.0f));
        int color = getResources().getColor(TA5.c1);
        FrameLayout frameLayout2 = this.rootView;
        AbstractC13042fc3.f(frameLayout2);
        frameLayout2.setBackgroundColor(color);
        NewPagerWithIndicator newPagerWithIndicator = new NewPagerWithIndicator(this);
        this.pagerBullet = newPagerWithIndicator;
        AbstractC13042fc3.f(newPagerWithIndicator);
        newPagerWithIndicator.j();
        this.adapter = new C12001du4(this, 4);
        NewPagerWithIndicator newPagerWithIndicator2 = this.pagerBullet;
        AbstractC13042fc3.f(newPagerWithIndicator2);
        C12001du4 c12001du4 = this.adapter;
        AbstractC13042fc3.f(c12001du4);
        newPagerWithIndicator2.setAdapter(c12001du4);
        C12001du4 c12001du42 = this.adapter;
        AbstractC13042fc3.f(c12001du42);
        c12001du42.j();
        FrameLayout frameLayout3 = this.rootView;
        AbstractC13042fc3.f(frameLayout3);
        frameLayout3.addView(this.pagerBullet);
        NewPagerWithIndicator newPagerWithIndicator3 = this.pagerBullet;
        AbstractC13042fc3.f(newPagerWithIndicator3);
        newPagerWithIndicator3.setNextButtonOnclickListener(new View.OnClickListener() { // from class: ir.nasim.Zt4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewIntroActivity.q2(this.a, view);
            }
        });
        NewPagerWithIndicator newPagerWithIndicator4 = this.pagerBullet;
        AbstractC13042fc3.f(newPagerWithIndicator4);
        newPagerWithIndicator4.setPreviousButtonOnclickListener(new View.OnClickListener() { // from class: ir.nasim.au4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewIntroActivity.r2(this.a, view);
            }
        });
        NewPagerWithIndicator newPagerWithIndicator5 = this.pagerBullet;
        AbstractC13042fc3.f(newPagerWithIndicator5);
        newPagerWithIndicator5.setSkipTextOnclickListener(new View.OnClickListener() { // from class: ir.nasim.bu4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewIntroActivity.v2(this.a, view);
            }
        });
        NewPagerWithIndicator newPagerWithIndicator6 = this.pagerBullet;
        AbstractC13042fc3.f(newPagerWithIndicator6);
        newPagerWithIndicator6.setDoneOnclickListener(new View.OnClickListener() { // from class: ir.nasim.cu4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewIntroActivity.x2(this.a, view);
            }
        });
        FrameLayout frameLayout4 = this.rootView;
        AbstractC13042fc3.f(frameLayout4);
        frameLayout4.setLayoutDirection(0);
        FrameLayout frameLayout5 = this.rootView;
        AbstractC13042fc3.f(frameLayout5);
        setContentView(frameLayout5);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C5735Kp4.w().L();
        UQ.a aVar = UQ.a;
        String strE = C7183Qq.p().e("auth_state");
        UQ uq = UQ.c;
        UQ uqA = aVar.a(strE, uq);
        if (uqA == UQ.e || uqA == uq) {
            return;
        }
        C5735Kp4.w().I(this);
        finish();
    }
}
