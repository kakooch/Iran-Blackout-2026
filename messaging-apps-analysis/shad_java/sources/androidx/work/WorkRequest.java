package androidx.work;

import android.os.Build;
import androidx.work.impl.model.WorkSpec;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class WorkRequest {
    private UUID mId;
    private Set<String> mTags;
    private WorkSpec mWorkSpec;

    protected WorkRequest(UUID id, WorkSpec workSpec, Set<String> tags) {
        this.mId = id;
        this.mWorkSpec = workSpec;
        this.mTags = tags;
    }

    public String getStringId() {
        return this.mId.toString();
    }

    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    public Set<String> getTags() {
        return this.mTags;
    }

    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {
        WorkSpec mWorkSpec;
        boolean mBackoffCriteriaSet = false;
        Set<String> mTags = new HashSet();
        UUID mId = UUID.randomUUID();

        abstract W buildInternal();

        abstract B getThis();

        Builder(Class<? extends ListenableWorker> workerClass) {
            this.mWorkSpec = new WorkSpec(this.mId.toString(), workerClass.getName());
            addTag(workerClass.getName());
        }

        public final B setConstraints(Constraints constraints) {
            this.mWorkSpec.constraints = constraints;
            return (B) getThis();
        }

        public final B addTag(String str) {
            this.mTags.add(str);
            return (B) getThis();
        }

        public B setInitialDelay(long j, TimeUnit timeUnit) {
            this.mWorkSpec.initialDelay = timeUnit.toMillis(j);
            if (Long.MAX_VALUE - System.currentTimeMillis() <= this.mWorkSpec.initialDelay) {
                throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
            }
            return (B) getThis();
        }

        public final W build() {
            W w = (W) buildInternal();
            Constraints constraints = this.mWorkSpec.constraints;
            int i = Build.VERSION.SDK_INT;
            boolean z = (i >= 24 && constraints.hasContentUriTriggers()) || constraints.requiresBatteryNotLow() || constraints.requiresCharging() || (i >= 23 && constraints.requiresDeviceIdle());
            WorkSpec workSpec = this.mWorkSpec;
            if (workSpec.expedited) {
                if (z) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (workSpec.initialDelay > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.mId = UUID.randomUUID();
            WorkSpec workSpec2 = new WorkSpec(this.mWorkSpec);
            this.mWorkSpec = workSpec2;
            workSpec2.id = this.mId.toString();
            return w;
        }
    }
}
