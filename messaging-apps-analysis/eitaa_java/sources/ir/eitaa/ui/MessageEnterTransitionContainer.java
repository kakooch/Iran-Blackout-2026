package ir.eitaa.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import ir.eitaa.messenger.NotificationCenter;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class MessageEnterTransitionContainer extends View {
    private final int currentAccount;
    Runnable hideRunnable;
    private ArrayList<Transition> transitions;

    public interface Transition {
        void onDraw(Canvas canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$MessageEnterTransitionContainer() {
        setVisibility(8);
    }

    public MessageEnterTransitionContainer(Context context, int currentAccount) {
        super(context);
        this.transitions = new ArrayList<>();
        this.hideRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MessageEnterTransitionContainer$v9Rn3IjeasgeYRxLgjP7WDiP_F0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$MessageEnterTransitionContainer();
            }
        };
        this.currentAccount = currentAccount;
    }

    void addTransition(Transition transition) {
        this.transitions.add(transition);
        checkVisibility();
    }

    void removeTransition(Transition transition) {
        this.transitions.remove(transition);
        checkVisibility();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.transitions.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.transitions.size(); i++) {
            this.transitions.get(i).onDraw(canvas);
        }
    }

    private void checkVisibility() {
        if (this.transitions.isEmpty() && getVisibility() != 8) {
            NotificationCenter.getInstance(this.currentAccount).removeDelayed(this.hideRunnable);
            NotificationCenter.getInstance(this.currentAccount).doOnIdle(this.hideRunnable);
        } else {
            if (this.transitions.isEmpty() || getVisibility() == 0) {
                return;
            }
            NotificationCenter.getInstance(this.currentAccount).removeDelayed(this.hideRunnable);
            setVisibility(0);
        }
    }
}
