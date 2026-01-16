package ir.nasim.features.payment.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.appcompat.app.AppCompatActivity;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C5735Kp4;
import ir.nasim.InterfaceC14067hI1;
import ir.nasim.InterfaceC9764aW7;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000fR\"\u0010\u0015\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lir/nasim/features/payment/base/BaseActivity;", "Lir/nasim/aW7;", "B", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "n1", "()Lir/nasim/aW7;", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/os/PersistableBundle;", "persistentState", "(Landroid/os/Bundle;Landroid/os/PersistableBundle;)V", "G", "Lir/nasim/aW7;", "l1", "o1", "(Lir/nasim/aW7;)V", "binding", "Ljava/util/ArrayList;", "Lir/nasim/features/payment/data/model/BankCreditCard;", "H", "Ljava/util/ArrayList;", "newSourceCardList", "J", "newDestinationCardList", "nasim_release"}, k = 1, mv = {2, 0, 0})
@InterfaceC14067hI1
/* loaded from: classes6.dex */
public abstract class BaseActivity<B extends InterfaceC9764aW7> extends AppCompatActivity {

    /* renamed from: G, reason: from kotlin metadata */
    public InterfaceC9764aW7 binding;

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList newSourceCardList = new ArrayList();

    /* renamed from: J, reason: from kotlin metadata */
    private final ArrayList newDestinationCardList = new ArrayList();

    public final InterfaceC9764aW7 l1() {
        InterfaceC9764aW7 interfaceC9764aW7 = this.binding;
        if (interfaceC9764aW7 != null) {
            return interfaceC9764aW7;
        }
        AbstractC13042fc3.y("binding");
        return null;
    }

    public abstract InterfaceC9764aW7 n1();

    public final void o1(InterfaceC9764aW7 interfaceC9764aW7) {
        AbstractC13042fc3.i(interfaceC9764aW7, "<set-?>");
        this.binding = interfaceC9764aW7;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        C5735Kp4.w().L();
        super.onCreate(savedInstanceState);
        o1(n1());
        setContentView(l1().getRoot());
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        C5735Kp4.w().L();
        super.onCreate(savedInstanceState, persistentState);
        o1(n1());
        setContentView(l1().getRoot());
    }
}
