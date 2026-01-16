package ir.nasim.features.conversation.sharedmedia.old;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19329q98;
import ir.nasim.C11458d25;
import ir.nasim.C24137y63;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.designsystem.base.activity.BaseFragmentActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lir/nasim/features/conversation/sharedmedia/old/SharedMediaActivity;", "Lir/nasim/designsystem/base/activity/BaseFragmentActivity;", "<init>", "()V", "Lir/nasim/rB7;", "o2", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lir/nasim/d25;", "K0", "Lir/nasim/d25;", "l2", "()Lir/nasim/d25;", "n2", "(Lir/nasim/d25;)V", "peer", "L0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class SharedMediaActivity extends BaseFragmentActivity {

    /* renamed from: L0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int M0 = 8;

    /* renamed from: K0, reason: from kotlin metadata */
    public C11458d25 peer;

    /* renamed from: ir.nasim.features.conversation.sharedmedia.old.SharedMediaActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final Intent a(Context context, C11458d25 c11458d25) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c11458d25, "peer");
            Intent intent = new Intent(context, (Class<?>) SharedMediaActivity.class);
            intent.putExtra("EXTRA_BYTE_ARRAY_PEER", c11458d25.toByteArray());
            return intent;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private final void o2() {
        if (l2().z()) {
            j2(C24137y63.a(l2().getPeerId(), true));
        } else {
            j2(C24137y63.c(l2().getPeerId(), true));
        }
    }

    public final C11458d25 l2() {
        C11458d25 c11458d25 = this.peer;
        if (c11458d25 != null) {
            return c11458d25;
        }
        AbstractC13042fc3.y("peer");
        return null;
    }

    public final void n2(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "<set-?>");
        this.peer = c11458d25;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseFragmentActivity, ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        C6011Lu2.m(this);
        AbstractC19329q98.b(getWindow(), false);
        super.onCreate(savedInstanceState);
        n2(C11458d25.q(getIntent().getByteArrayExtra("EXTRA_BYTE_ARRAY_PEER")));
        if (l2().u() == 0) {
            finish();
        }
        if (savedInstanceState == null) {
            o2();
        }
    }
}
