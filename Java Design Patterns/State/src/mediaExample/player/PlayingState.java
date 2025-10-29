package mediaExample.player;

public class PlayingState extends State {

    PlayingState(Player player) {
        super(player);
    }

    public String onLock() {
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Paused...";
    }

    public String onNext() {
        return player.nextTrack();
    }

    public String onPrevious() {
        return player.previousTrack();
    }
}
