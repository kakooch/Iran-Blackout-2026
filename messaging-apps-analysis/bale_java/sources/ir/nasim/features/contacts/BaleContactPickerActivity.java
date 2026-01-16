package ir.nasim.features.contacts;

import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19329q98;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.designsystem.base.activity.BaseFragmentActivity;
import ir.nasim.features.contacts.a;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB'\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0016\u001a\u00020\u000e2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b¨\u0006\u001f"}, d2 = {"Lir/nasim/features/contacts/BaleContactPickerActivity;", "Lir/nasim/designsystem/base/activity/BaseFragmentActivity;", "Lir/nasim/features/contacts/a$b;", "", "groupId", "", "useSelection", "useCardToCardIcon", "<init>", "(IZZ)V", "W1", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "onCreate", "(Landroid/os/Bundle;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "userIdList", "", "singleSelectionContactName", "D", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "K0", TokenNames.I, "L0", "Z", "M0", "N0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class BaleContactPickerActivity extends BaseFragmentActivity implements a.b {

    /* renamed from: N0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int O0 = 8;

    /* renamed from: K0, reason: from kotlin metadata */
    private int groupId;

    /* renamed from: L0, reason: from kotlin metadata */
    private boolean useSelection;

    /* renamed from: M0, reason: from kotlin metadata */
    private boolean useCardToCardIcon;

    /* renamed from: ir.nasim.features.contacts.BaleContactPickerActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final Intent a(Context context, int i) {
            AbstractC13042fc3.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) BaleContactPickerActivity.class);
            intent.putExtra("ir.nasim.features.contacts.contact_title", i);
            return intent;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public BaleContactPickerActivity() {
        this(0, false, false, 7, null);
    }

    @Override // ir.nasim.features.contacts.a.b
    public void D(ArrayList userIdList, String singleSelectionContactName) {
        Intent intent = new Intent();
        intent.putExtra("USER_LIST", userIdList);
        intent.putExtra("SINGLE_SELECTION_USER_NAME", singleSelectionContactName);
        setResult(20011, intent);
        finish();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    public boolean W1() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseFragmentActivity, ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        C6011Lu2.m(this);
        AbstractC19329q98.b(getWindow(), false);
        super.onCreate(savedInstanceState);
        int intExtra = getIntent().getIntExtra("ir.nasim.features.contacts.contact_title", 2002);
        if (savedInstanceState == null) {
            a aVarA = a.INSTANCE.a(this.groupId, false, "GROUP", this.useSelection, this.useCardToCardIcon, intExtra);
            aVarA.Ka(this);
            j2(aVarA);
        }
    }

    public /* synthetic */ BaleContactPickerActivity(int i, boolean z, boolean z2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2);
    }

    public BaleContactPickerActivity(int i, boolean z, boolean z2) {
        this.groupId = i;
        this.useSelection = z;
        this.useCardToCardIcon = z2;
    }
}
