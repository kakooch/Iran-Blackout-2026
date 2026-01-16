package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GetGameStatusOutput {
    public long api_call_time;
    public String count_online;
    public GameStateObject next_state;
    public long retry_time;
    public GameStateObject state;
    public long state_remaining;
    public String stream_url;

    public String toString() {
        return "state: " + getStateString() + " state_remaining: " + this.state_remaining + " api_call_time: " + this.api_call_time + " next_state: " + getNextStateString() + " count_online: " + this.count_online;
    }

    private String getStateString() {
        GameStateObject gameStateObject = this.state;
        return gameStateObject == null ? "null!" : gameStateObject.toString();
    }

    private String getNextStateString() {
        GameStateObject gameStateObject = this.next_state;
        return gameStateObject == null ? "null!" : gameStateObject.toString();
    }
}
