package quarri6343.overcrafted.common.data;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;

public class OCResourcePackData {

    /**
     * リソースパックのurl
     */
    public static final String packURL = "https://drive.google.com/uc?export=download&id=1_ryjm_tb5HVxHwi28Rp3TPk7QSMOSepr";

    /**
     * ダウンロードしてきたリソースパックを補完するパス
     */
    public static final String packPath = "plugins/overcrafted_resourcepack.zip";

    /**
     * リソースパックのハッシュ
     */
    public static String packHash;

    /**
     * menuFontのリソースパック上での名前
     */
    public static final Key menuFontName = Key.key("menu");

    /**
     * リソースパックのmenuFontのカスタムアイコン名とunicodeの対応表
     */
    public enum MenuFont {
        SPACE(" "),
        TORCH("\uE000"),
        FURNACE("\uE001"),
        IRON("\uE002"),
        MINECART("\uE003"),
        BONUS("\uE004");

        private final String _char;

        MenuFont(String _char) {
            this._char = _char;
        }

        public String get_char() {
            return _char;
        }
    }

    /**
     * リソースパックで設定されたカスタムの皿(Materialはpaper)と皿に載っているアイテムとその名称とcustomModelDataとの対応表
     */
    public enum CustomDishModel {
        DISH(null, Component.text("皿").decoration(TextDecoration.ITALIC, false), 1),
        DISH_DIRTY(null, Component.text("汚い皿").decoration(TextDecoration.ITALIC, false), 2),
        DISH_FURNACE(Material.FURNACE, Component.text("かまどの載った皿").decoration(TextDecoration.ITALIC, false), 3),
        DISH_IRON_INGOT(Material.IRON_INGOT, Component.text("鉄インゴットの載った皿").decoration(TextDecoration.ITALIC, false), 4),
        DISH_MINECART(Material.MINECART, Component.text("トロッコが載った皿").decoration(TextDecoration.ITALIC, false), 5),
        DISH_TORCH(Material.TORCH, Component.text("松明が載った皿").decoration(TextDecoration.ITALIC, false), 6);

        private final Material materialOnDish;
        private final Component name;
        private final int data;

        CustomDishModel(Material material, Component name, int data) {
            this.materialOnDish = material;
            this.name = name;
            this.data = data;
        }

        public Material getMaterialOnDish() {
            return materialOnDish;
        }

        public Component getName() {
            return name;
        }

        public int getData() {
            return data;
        }
    }

    public interface IDishModel {
        public int getStackedNumber();

        public int getData();
    }

    /**
     * リソースパックで設定された積みあがった皿(Materialはmusic_disc_pigstep)の名称と積みあがった枚数とcustomModelDataとの対応表
     */
    public enum PiledCleanDishModel implements IDishModel {
        DISH_STACKED_1(1, 1),
        DISH_STACKED_2(2, 2),
        DISH_STACKED_3(3, 3),
        DISH_STACKED_4(4, 4),
        DISH_STACKED_5(5, 5);

        private final int stackedNumber;
        private final int data;

        PiledCleanDishModel(int stackedNumber, int data) {
            this.stackedNumber = stackedNumber;
            this.data = data;
        }

        public int getStackedNumber() {
            return stackedNumber;
        }

        public int getData() {
            return data;
        }
    }

    /**
     * リソースパックで設定された積みあがった汚い皿(Materialはmusic_disc_pigstep)の名称と積みあがった枚数とcustomModelDataとの対応表
     */
    public enum PiledDirtyDishModel implements IDishModel {
        DISH_STACKED_DIRTY_1(1, 6),
        DISH_STACKED_DIRTY_2(2, 7),
        DISH_STACKED_DIRTY_3(3, 8),
        DISH_STACKED_DIRTY_4(4, 9),
        DISH_STACKED_DIRTY_5(5, 10);

        private final int stackedNumber;
        private final int data;

        PiledDirtyDishModel(int stackedNumber, int data) {
            this.stackedNumber = stackedNumber;
            this.data = data;
        }

        public int getStackedNumber() {
            return stackedNumber;
        }

        public int getData() {
            return data;
        }
    }
}
