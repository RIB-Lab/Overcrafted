package quarri6343.overcrafted.common.logic;

import org.bukkit.scheduler.BukkitRunnable;
import quarri6343.overcrafted.Overcrafted;
import quarri6343.overcrafted.common.order.ScoreBoardHandler;
import quarri6343.overcrafted.common.data.OCData;
import quarri6343.overcrafted.common.data.OCTeam;

import java.util.function.Consumer;

/**
 * 定期的に起動してゲームの状態を監視するrunnable
 */
public class GameRunnable extends BukkitRunnable {

    private int count = 0;
    private final Consumer<OCTeam> onGameSuccess;

    public GameRunnable(Consumer<OCTeam> onGameSuccess) {
        this.onGameSuccess = onGameSuccess;
    }

    @Override
    public void run() {
        count++;

        if (count % 20 == 0) {
            ScoreBoardHandler.refresh(OCData.gameLength - count / 20);
        }

        if (count >= OCData.gameLength * 20) {
            onGameSuccess.accept(ScoreBoardHandler.getHighestScoreTeam());
            cancel();
        }

        if (count % OCData.checkInventoryInterval == 0) {
            getData().teams.clearExcessiveItemsFromAllTeam();
        }
    }

    private OCData getData() {
        return Overcrafted.getInstance().getData();
    }
}
