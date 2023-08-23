package foy.firstmod.init;

import foy.firstmod.FirstModMain;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstModMain.MODID);

    public static final RegistryObject<Item> FOYSWORD = ITEMS.register("foysword",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));

    public static class ModCreativeTab extends CreativeModeTab {

        public ModCreativeTab(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FOYSWORD.get());
        }

        public static final ModCreativeTab instance = new ModCreativeTab("firstmod");
    }
}
