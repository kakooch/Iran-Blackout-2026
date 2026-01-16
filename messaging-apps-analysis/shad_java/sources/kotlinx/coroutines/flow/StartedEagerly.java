package kotlinx.coroutines.flow;

/* compiled from: SharingStarted.kt */
/* loaded from: classes4.dex */
final class StartedEagerly implements SharingStarted {
    public String toString() {
        return "SharingStarted.Eagerly";
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.flowOf(SharingCommand.START);
    }
}
