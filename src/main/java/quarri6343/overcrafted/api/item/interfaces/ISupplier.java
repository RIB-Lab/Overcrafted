package quarri6343.overcrafted.api.item.interfaces;

import org.bukkit.entity.Player;

/**
 * 供給UIを通じて供給可能なアイテム
 */
public interface ISupplier {

    /**
     * 供給アクションが行われた時プレイヤーに対して行う動作
     * @param player
     */
    public void onSupply(Player player);
}
