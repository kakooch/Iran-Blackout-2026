package ir.appp.ui.ActionBar;

import android.app.Activity;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import org.rbmain.ui.ActionBar.BaseFragment;

/* loaded from: classes3.dex */
public class LifecycleAwareBaseFragment extends BaseFragment implements ViewModelStoreOwner, LifecycleOwner {
    private LifecycleOwner mViewLifecycleOwner;
    private final MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData = new MutableLiveData<>();
    private LifecycleRegistry mViewLifecycleRegistry;
    private ViewModelStore mViewModelStore;

    public void onLifecycleCreate() {
    }

    public void onLifecycleDestroy() {
    }

    public void onLifecyclePause() {
    }

    public void onLifecycleResume() {
    }

    public void onLifecycleStart() {
    }

    public void onLifecycleStop() {
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getContext() == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mViewModelStore == null) {
            this.mViewModelStore = new ViewModelStore();
        }
        return this.mViewModelStore;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        LifecycleOwner lifecycleOwner = this.mViewLifecycleOwner;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mViewLifecycleRegistry;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public void onCreateInternal() {
        LifecycleOwner lifecycleOwner = new LifecycleOwner() { // from class: ir.appp.ui.ActionBar.LifecycleAwareBaseFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleOwner
            public final Lifecycle getLifecycle() {
                return this.f$0.lambda$onCreateInternal$0();
            }
        };
        this.mViewLifecycleOwner = lifecycleOwner;
        this.mViewLifecycleRegistry = null;
        lifecycleOwner.getLifecycle();
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        LifecycleRegistry lifecycleRegistry = this.mViewLifecycleRegistry;
        if (lifecycleRegistry != null) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            Log.d("SAEED", "ON_CREATE " + getClass().getSimpleName());
        }
        onLifecycleCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Lifecycle lambda$onCreateInternal$0() {
        if (this.mViewLifecycleRegistry == null) {
            this.mViewLifecycleRegistry = new LifecycleRegistry(this.mViewLifecycleOwner);
        }
        return this.mViewLifecycleRegistry;
    }

    public void onPauseInternal() {
        LifecycleRegistry lifecycleRegistry = this.mViewLifecycleRegistry;
        if (lifecycleRegistry != null) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            Log.d("SAEED", "ON_PAUSE " + getClass().getSimpleName());
        }
        onLifecyclePause();
    }

    public void onResumeInternal() {
        LifecycleRegistry lifecycleRegistry = this.mViewLifecycleRegistry;
        if (lifecycleRegistry != null) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            Log.d("SAEED", "ON_RESUME " + getClass().getSimpleName());
        }
        onLifecycleResume();
    }

    public void onStartInternal() {
        LifecycleRegistry lifecycleRegistry = this.mViewLifecycleRegistry;
        if (lifecycleRegistry != null) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            Log.d("SAEED", "ON_START " + getClass().getSimpleName());
        }
        onLifecycleStart();
    }

    public void onStopInternal() {
        LifecycleRegistry lifecycleRegistry = this.mViewLifecycleRegistry;
        if (lifecycleRegistry != null) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            Log.d("SAEED", "ON_STOP " + getClass().getSimpleName());
        }
        onLifecycleStop();
    }

    public void onDestroyInternal() {
        LifecycleRegistry lifecycleRegistry = this.mViewLifecycleRegistry;
        if (lifecycleRegistry != null) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
            Log.d("SAEED", "ON_DESTROY " + getClass().getSimpleName());
        }
        Activity parentActivity = getParentActivity();
        boolean z = parentActivity != null && parentActivity.isChangingConfigurations();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore != null && !z) {
            viewModelStore.clear();
        }
        onLifecycleDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        onPauseInternal();
        onStopInternal();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        onStartInternal();
        onResumeInternal();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        onCreateInternal();
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        onDestroyInternal();
    }
}
