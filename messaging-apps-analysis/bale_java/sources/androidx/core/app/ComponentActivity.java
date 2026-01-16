package androidx.core.app;

import android.app.Activity;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21595to3;
import ir.nasim.C24792zC6;
import ir.nasim.InterfaceC18633oz3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0015¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0004¢\u0006\u0004\b\u0019\u0010\u000bR.\u0010 \u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001b\u0012\u0004\u0012\u00020\u001c0\u001a8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u0005R\u001a\u0010%\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\"\u0010#\u0012\u0004\b$\u0010\u0005R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Landroidx/core/app/ComponentActivity;", "Landroid/app/Activity;", "Lir/nasim/oz3;", "Lir/nasim/to3$a;", "<init>", "()V", "", "", "args", "", TokenNames.L, "([Ljava/lang/String;)Z", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/KeyEvent;", "event", "m", "(Landroid/view/KeyEvent;)Z", "dispatchKeyShortcutEvent", "dispatchKeyEvent", TokenNames.K, "Lir/nasim/zC6;", "Ljava/lang/Class;", "", "a", "Lir/nasim/zC6;", "getExtraDataMap$annotations", "extraDataMap", "Landroidx/lifecycle/p;", "b", "Landroidx/lifecycle/p;", "getLifecycleRegistry$annotations", "lifecycleRegistry", "Landroidx/lifecycle/j;", "getLifecycle", "()Landroidx/lifecycle/j;", "lifecycle", "core_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public class ComponentActivity extends Activity implements InterfaceC18633oz3, AbstractC21595to3.a {

    /* renamed from: a, reason: from kotlin metadata */
    private final C24792zC6 extraDataMap = new C24792zC6();

    /* renamed from: b, reason: from kotlin metadata */
    private final p lifecycleRegistry = new p(this);

    private final boolean L(String[] args) {
        if (args == null || args.length == 0) {
            return false;
        }
        String str = args[0];
        switch (str.hashCode()) {
            case -645125871:
                return str.equals("--translation") && Build.VERSION.SDK_INT >= 31;
            case 100470631:
                if (!str.equals("--dump-dumpable")) {
                    return false;
                }
                break;
            case 472614934:
                if (!str.equals("--list-dumpables")) {
                    return false;
                }
                break;
            case 1159329357:
                return str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29;
            case 1455016274:
                return str.equals("--autofill") && Build.VERSION.SDK_INT >= 26;
            default:
                return false;
        }
        return Build.VERSION.SDK_INT >= 33;
    }

    protected final boolean K(String[] args) {
        return !L(args);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        AbstractC13042fc3.i(event, "event");
        View decorView = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView, "window.decorView");
        if (AbstractC21595to3.d(decorView, event)) {
            return true;
        }
        return AbstractC21595to3.e(this, decorView, this, event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        AbstractC13042fc3.i(event, "event");
        View decorView = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView, "window.decorView");
        if (AbstractC21595to3.d(decorView, event)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(event);
    }

    public j getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // ir.nasim.AbstractC21595to3.a
    public boolean m(KeyEvent event) {
        AbstractC13042fc3.i(event, "event");
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.INSTANCE.c(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        AbstractC13042fc3.i(outState, "outState");
        this.lifecycleRegistry.n(j.b.CREATED);
        super.onSaveInstanceState(outState);
    }
}
