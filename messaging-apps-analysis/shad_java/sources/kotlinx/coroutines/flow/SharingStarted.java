package kotlinx.coroutines.flow;

/* compiled from: SharingStarted.kt */
/* loaded from: classes4.dex */
public interface SharingStarted {
    public static final Companion Companion = Companion.$$INSTANCE;

    Flow<SharingCommand> command(StateFlow<Integer> stateFlow);

    /* compiled from: SharingStarted.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SharingStarted Eagerly = new StartedEagerly();
        private static final SharingStarted Lazily = new StartedLazily();

        private Companion() {
        }

        public final SharingStarted getEagerly() {
            return Eagerly;
        }

        public final SharingStarted getLazily() {
            return Lazily;
        }
    }
}
